package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.MinCardinalityException;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.PreconditionException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.GrupoAsignacionConstants;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Admin;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Gestor;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.MesaDeApoyo;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;
import com.keralty.aeusuarios.persistence.oid.LogFuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.LogHistoricoPlanesOid;
import com.keralty.aeusuarios.persistence.oid.LogInformacionAsesorOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;
import com.keralty.aeusuarios.persistence.RespRegional;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.SuperAdmin;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.repository.FuncionarioJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereNegation;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandThis;
import com.keralty.aeusuarios.viewmodel.FilterRequest;
import com.keralty.aeusuarios.viewmodel.FilterVariableRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class FuncionarioService extends AbstractService {

    FuncionarioJpaRepository repository;

    RolService rolSrv;

    SucursalService sucursalSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    RegionalService regionalSrv;

    ReportesProcAlmService reportesProcAlmSrv;

    GrupoAsignacionService grupoAsignacionSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    SolicitudService solicitudSrv;

    LogFuncionarioService logFuncionarioSrv;

    ContratoCService contratoCSrv;

    AgentexProductoService agentexProductoSrv;

    LogInformacionAsesorService logInformacionAsesorSrv;

    LogHistoricoPlanesService logHistoricoPlanesSrv;

    FirmaService firmaSrv;

    PlanesService planesSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public FuncionarioService(
            RolService rolSrv,
            SucursalService sucursalSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            RegionalService regionalSrv,
            ReportesProcAlmService reportesProcAlmSrv,
            GrupoAsignacionService grupoAsignacionSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            SolicitudService solicitudSrv,
            LogFuncionarioService logFuncionarioSrv,
            ContratoCService contratoCSrv,
            AgentexProductoService agentexProductoSrv,
            LogInformacionAsesorService logInformacionAsesorSrv,
            LogHistoricoPlanesService logHistoricoPlanesSrv,
            FirmaService firmaSrv,
            PlanesService planesSrv,
            UserFunctions userFunctionsSrv,
            FuncionarioJpaRepository repository) {
        this.rolSrv = rolSrv;
        this.sucursalSrv = sucursalSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.regionalSrv = regionalSrv;
        this.reportesProcAlmSrv = reportesProcAlmSrv;
        this.grupoAsignacionSrv = grupoAsignacionSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.solicitudSrv = solicitudSrv;
        this.logFuncionarioSrv = logFuncionarioSrv;
        this.contratoCSrv = contratoCSrv;
        this.agentexProductoSrv = agentexProductoSrv;
        this.logInformacionAsesorSrv = logInformacionAsesorSrv;
        this.logHistoricoPlanesSrv = logHistoricoPlanesSrv;
        this.firmaSrv = firmaSrv;
        this.planesSrv = planesSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, FuncionarioConstants.CLASS_NAME);
    }

    private List<Funcionario> solveFuncionarioTypedQuery(QueryRequest request) {
        boolean hasInMemoryFilters = hasInMemoryFilters(request);
        int requestedPageSize = request.getPageSize();
        int pageSize = requestedPageSize >= 0
                && requestedPageSize <= Constants.MAX_BLOCKSIZE
                ? requestedPageSize
                : Constants.DEFAULT_BLOCKSIZE;
        int pageNumber = Math.max(1, request.getPageNumber());

    	List<Funcionario> results = repository.solveQuery(processQueryRequest(request, FuncionarioConstants.CLASS_NAME), (hasInMemoryFilters ? 0 : pageSize), (hasInMemoryFilters ? 1 : pageNumber)).stream()
                .filter(instance -> hasInMemoryFilters ? applyMemoryFilters(request, instance) : true).collect(Collectors.toList()); 

        if (hasInMemoryFilters && results != null && !results.isEmpty()) {
            long fromInstance = ((long) pageNumber - 1) * pageSize;
            long toInstance = (long) pageNumber * pageSize;
            if (pageSize == 0) {
               fromInstance = 0;
               toInstance = results.size();
            }
            int from = (int) Math.min(fromInstance, results.size());
            int to = (int) Math.min(toInstance, results.size());
            results = (fromInstance > results.size() - 1)
                    ? new ArrayList<>()
                    : results.subList(from, Math.max(from, to));
        }

        return results;
    }
    
    private int solveFuncionarioTypedCountQuery(QueryRequest request) {
        return hasInMemoryFilters(request)
               ? repository.solveQuery(processQueryRequest(request, FuncionarioConstants.CLASS_NAME)).stream().filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size()
               : repository.solveCountQuery(processCountQueryRequest(request, FuncionarioConstants.CLASS_NAME));
    }

    private boolean hasInMemoryFilters(QueryRequest queryRequest) {
        for(FilterRequest filterRequest : queryRequest.getFilters()) {
            if (hasInMemoryConjunctions(filterRequest)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasInMemoryConjunctions(FilterRequest filterRequest) {
        if ("Solicitud_TREASIGNARUSUARIOS_ptUsrAfiliacion_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        if ("SolicitudNovedad_TREASIGNARUSUARIOS_ptUsrAfiliacion_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        if ("GrupoAsignacion_TADDUSUARIO_ptFuncionario_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        return false;
    }

    /*
     * Returns the population of class Funcionario
     *
     * @return Population of class Funcionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Funcionario> get() {
        List<Funcionario> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Funcionario
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Funcionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Funcionario> instances = get(queryRequest);
        if(FuncionarioConstants.DSICAGENTE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICAgente())).collect(Collectors.toList());
        }
        if(FuncionarioConstants.DSDSAGENTEPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAgentePIU())).collect(Collectors.toList());
        }
        if(FuncionarioConstants.DSDSFUNCIONARIODREPORTES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSFuncionarioDReportes())).collect(Collectors.toList());
        }
        if(FuncionarioConstants.DSDSFUNCIONARIODGRUPO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSFuncionarioDGrupo())).collect(Collectors.toList());
        }
        if(FuncionarioConstants.DSICUSUARIOLDAP.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICUsuarioLDAP())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Funcionario that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Funcionario matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Funcionario> get(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest);
    }
    
    /*
     * Returns the list of instances that matches certain search criteria
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return List of instances that matches certain search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public QueryResponse getDynamic(QueryRequest queryRequest) {
        if (queryRequest.getDisplaySetName() == null || queryRequest.getDisplaySetName().isEmpty()) {
            return new PopulationResponseViewModel(solveFuncionarioTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveFuncionarioTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveFuncionarioTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
        }
    }

    /*
     * Returns the population of a class with a certain structure
     *
     * @param relatedInstanceJsonOid Json Oid of the related instance
     *
     * @param relatedInstancePath Path to the related instance
     *
     * @param displaySetItems DisplaySet items for each returned instance
     *
     * @return List of instances
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PopulationResponseViewModel getByRelatedDynamic(String relatedInstanceJsonOid, String relatedInstancePath, String displaySetItems) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstanceJsonOid))));
        return new PopulationResponseViewModel(solveFuncionarioTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Funcionario by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of Funcionario
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Funcionario getById(Long funcionarioId) {
        return getByOID(new FuncionarioOid(funcionarioId));
    }
    
    /*
     * Returns an instance of Funcionario by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Funcionario
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Funcionario getByOID(FuncionarioOid oid) {
        Optional<Funcionario> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Funcionario by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Funcionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Funcionario getByOIDWithHV(FuncionarioOid oid) {
        Optional<Funcionario> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Funcionario> getInstanceByOid(FuncionarioOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }

    /*
     * Returns an instance of Funcionario by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Funcionario
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Funcionario getByJsonOid(String jsonOid) {
        FuncionarioOid oid = new FuncionarioOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Funcionario related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Funcionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Funcionario> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveFuncionarioTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Funcionario related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Funcionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Funcionario> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Funcionario
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Funcionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getFuncionarioDynamic(FuncionarioOid oid, String displaySetItems) {
        return new InstanceResponseViewModel(getByOIDWithHV(oid), displaySetItems);
    }

    /*
     * Returns the supplementary info for a given instance
     *
     * @param oid Instance OID
     *
     * @param dsName DisplaySet name
     *
     * @return Supplementary info for a given instance
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public String getSuppInfo(FuncionarioOid oid, String dsName) {
        Funcionario instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Funcionario instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (FuncionarioConstants.DSICAGENTE.equals(dsName))
            return instance.buildICAgente();
        if (FuncionarioConstants.DSICUSUARIOLDAP.equals(dsName))
            return instance.buildICUsuarioLDAP();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Funcionario instance, String dsName) {
        if (FuncionarioConstants.DSICAGENTE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICAgente());
        if (FuncionarioConstants.DSDSAGENTEPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAgentePIU());
        if (FuncionarioConstants.DSDSFUNCIONARIODREPORTES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSFuncionarioDReportes());
        if (FuncionarioConstants.DSDSFUNCIONARIODGRUPO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSFuncionarioDGrupo());
        if (FuncionarioConstants.DSICUSUARIOLDAP.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICUsuarioLDAP());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (FuncionarioConstants.FILTER_NAME_IFILTERFUNCIONARIOPORNUMUSU.equalsIgnoreCase(filterRequest.getName()))
            iFilterFuncionarioPorNumUsu(filterRequest, sql);
        if (FuncionarioConstants.FILTER_NAME_IFILTERPORUSUARIOLDAP.equalsIgnoreCase(filterRequest.getName()))
            iFilterPorUsuarioLDAP(filterRequest, sql);
        if (FuncionarioConstants.FILTER_NAME_FFUNCIONARIOPORNOMBRE.equalsIgnoreCase(filterRequest.getName()))
            fFuncionarioPorNombre(filterRequest, sql);
        if (FuncionarioConstants.FILTER_NAME_FFUNCIONARIOPORNOMBRENOASESO.equalsIgnoreCase(filterRequest.getName()))
            fFuncionarioPorNombreNoAseso(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Solicitud_TREASIGNARUSUARIOS_ptUsrAfiliacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav69(sql);
        if ("SolicitudNovedad_TREASIGNARUSUARIOS_ptUsrAfiliacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1581421428736234FiltNav26(sql);
        if ("GrupoAsignacion_TADDUSUARIO_ptFuncionario_NavFilter1".equalsIgnoreCase(filterRequest.getName()))
            clas1586850168832947FiltNav4(filterRequest, sql);
        if ("GrupoAsignacion_TDELUSUARIO_ptFuncionario_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1586850168832947FiltNav2(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Agente".equals(filterRequest.getName()))
            suppInfo4ICAgente(filterRequest.getFilterVariable("searchText").toString(), sql);
        if ("SuppInfo_IC_UsuarioLDAP".equals(filterRequest.getName()))
            suppInfo4ICUsuarioLDAP(filterRequest.getFilterVariable("searchText").toString(), sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Funcionario instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Funcionario instance) {
        return applyMemoryNavigationalFilter(filterRequest, instance);
    }

    private boolean applyMemoryNavigationalFilter(FilterRequest filterRequest, Funcionario entity) {
        if ("Solicitud_TREASIGNARUSUARIOS_ptUsrAfiliacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1431957012480960FiltNav69(entity);
        if ("SolicitudNovedad_TREASIGNARUSUARIOS_ptUsrAfiliacion_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1581421428736234FiltNav26(entity);
        if ("GrupoAsignacion_TADDUSUARIO_ptFuncionario_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryClas1586850168832947FiltNav1(entity);
        return true;
    }


    private void iFilterFuncionarioPorNumUsu(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfNumUsu = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_IFILTERFUNCIONARIOPORNUMUSU_VFNUMUSU) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_IFILTERFUNCIONARIOPORNUMUSU_VFNUMUSU, FilterVariableRequest.STRING) : null;

        // Usuario = vfNumUsu
        if (vfNumUsu != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumUsu, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFilterPorUsuarioLDAP(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfUsuLDAP = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_IFILTERPORUSUARIOLDAP_VFUSULDAP) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_IFILTERPORUSUARIOLDAP_VFUSULDAP, FilterVariableRequest.STRING) : null;

        // UsuarioLDAP = vfUsuLDAP
        if (vfUsuLDAP != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfUsuLDAP, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void fFuncionarioPorNombre(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfPriNom = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFPRINOM) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFPRINOM, FilterVariableRequest.STRING) : null;
        String vfSegNom = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFSEGNOM) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFSEGNOM, FilterVariableRequest.STRING) : null;
        String vfPriApe = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFPRIAPE) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFPRIAPE, FilterVariableRequest.STRING) : null;
        String vfSegApe = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFSEGAPE) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRE_VFSEGAPE, FilterVariableRequest.STRING) : null;

        // PrimerNombre LIKE "%" + vfPriNom
        if (vfPriNom != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral("%" + vfPriNom, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // SegundoNombre LIKE "%" + vfSegNom
        if (vfSegNom != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral("%" + vfSegNom, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // PrimerApellido LIKE "%" + vfPriApe
        if (vfPriApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral("%" + vfPriApe, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // SegundoApellido LIKE "%" + vfSegApe
        if (vfSegApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral("%" + vfSegApe, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    private void fFuncionarioPorNombreNoAseso(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfPriNom = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFPRINOM) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFPRINOM, FilterVariableRequest.STRING) : null;
        String vfSegNom = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFSEGNOM) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFSEGNOM, FilterVariableRequest.STRING) : null;
        String vfPriApe = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFPRIAPE) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFPRIAPE, FilterVariableRequest.STRING) : null;
        String vfSegApe = filterRequest.hasFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFSEGAPE) ? (String) filterRequest.getFilterVariable(FuncionarioConstants.VAR_NAME_FFUNCIONARIOPORNOMBRENOASESO_VFSEGAPE, FilterVariableRequest.STRING) : null;

        // PrimerNombre LIKE "%" + vfPriNom
        if (vfPriNom != null) {
            // 'like' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral("%" + vfPriNom, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // SegundoNombre LIKE "%" + vfSegNom
        if (vfSegNom != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral("%" + vfSegNom, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // PrimerApellido LIKE "%" + vfPriApe
        if (vfPriApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral("%" + vfPriApe, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // SegundoApellido LIKE "%" + vfSegApe
        if (vfSegApe != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral("%" + vfSegApe, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Rol.Nombre <> "ASESOR COMERCIAL"
        // '<>' Comparison
        SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
        comparison5.setOperator("<>");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ROLE_NAME_ROL + "." + RolConstants.ATTR_NAME_ROLNOMBRE, Constants.Type.STRING.getTypeName());
        comparison5.setFirstOperand(operand116);
        
        // Operand 2
        comparison5.setSecondOperand(new SQLWhereOperandLiteral("ASESOR COMERCIAL", Constants.Type.STRING.getTypeName()));
        conjunction.addOperand(comparison5);


        // Rol.Nombre <> "JEFEASESORES"
        // '<>' Comparison
        SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
        comparison6.setOperator("<>");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ROLE_NAME_ROL + "." + RolConstants.ATTR_NAME_ROLNOMBRE, Constants.Type.STRING.getTypeName());
        comparison6.setFirstOperand(operand117);
        
        // Operand 2
        comparison6.setSecondOperand(new SQLWhereOperandLiteral("JEFEASESORES", Constants.Type.STRING.getTypeName()));
        conjunction.addOperand(comparison6);


        sql.addConjunction(conjunction);
    }

    private void clas1431957012480960FiltNav69(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // Disponible = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIODISPONIBLE, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1581421428736234FiltNav26(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // Disponible = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIODISPONIBLE, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1586850168832947FiltNav4(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        GrupoAsignacion grupoAsignacionTADDUSUARIOpthisGrupoAsignacion = filterRequest.hasFilterVariable(GrupoAsignacionConstants.ARG_NAME_TADDUSUARIO_GRUPOASIGNACIONTADDUSUARIOPTHISGRUPOASIGNACION) ? grupoAsignacionSrv.getByOID(new GrupoAsignacionOid().fromJsonString(toJson(filterRequest.getFilterVariable(GrupoAsignacionConstants.ARG_NAME_TADDUSUARIO_GRUPOASIGNACIONTADDUSUARIOPTHISGRUPOASIGNACION)))) : null;

        // EXIST (GrupoAsignacion) WHERE (GrupoAsignacion = pthisGrupoAsignacion) = false
        if (grupoAsignacionTADDUSUARIOpthisGrupoAsignacion != null) {
        {
            // 'not' Logical operator
            SQLWhereNegation comparison1 = new SQLWhereNegation(sql);
        
            // Operand 1
            // 'exist' Association operator
            SQLWhereOperandSubQuery operandSubQueryAssocOperator002 = new SQLWhereOperandSubQuery(repository.assocOperator002Range1Query(grupoAsignacionTADDUSUARIOpthisGrupoAsignacion, sql));
            comparison1.addOperand(operandSubQueryAssocOperator002);
            
            conjunction.addOperand(comparison1);
        }

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1586850168832947FiltNav2(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        GrupoAsignacion grupoAsignacionTDELUSUARIOpthisGrupoAsignacion = filterRequest.hasFilterVariable(GrupoAsignacionConstants.ARG_NAME_TDELUSUARIO_GRUPOASIGNACIONTDELUSUARIOPTHISGRUPOASIGNACION) ? grupoAsignacionSrv.getByOID(new GrupoAsignacionOid().fromJsonString(toJson(filterRequest.getFilterVariable(GrupoAsignacionConstants.ARG_NAME_TDELUSUARIO_GRUPOASIGNACIONTDELUSUARIOPTHISGRUPOASIGNACION)))) : null;

        // EXIST (GrupoAsignacion) WHERE (GrupoAsignacion = pthisGrupoAsignacion) = true
        if (grupoAsignacionTDELUSUARIOpthisGrupoAsignacion != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator003 = new SQLWhereOperandSubQuery(repository.assocOperator003Range1Query(grupoAsignacionTDELUSUARIOpthisGrupoAsignacion, sql));
    conjunction.addOperand(operandSubQueryAssocOperator003);

        }        
        sql.addConjunction(conjunction);
    }

    private boolean inMemoryClas1431957012480960FiltNav69(Funcionario entity) {
        boolean result = true;

        // (drvEsAsesorIntegral = true OR Rol.Nombre = "AFILIACIONES")
        try {
            result = (entity.getFuncionariodrvEsAsesorIntegral().equals(true) || (entity.getRol().getRolNombre()).equals("AFILIACIONES"));
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private boolean inMemoryClas1581421428736234FiltNav26(Funcionario entity) {
        boolean result = true;

        // (drvEsAsesorIntegral = true OR drvEsAfiliacion = true)
        try {
            result = (entity.getFuncionariodrvEsAsesorIntegral().equals(true) || entity.getFuncionariodrvEsAfiliacion().equals(true));
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private boolean inMemoryClas1586850168832947FiltNav1(Funcionario entity) {
        boolean result = true;

        // drvEsAsesorIntegral = true OR Rol.Nombre = "AFILIACIONES"
        try {
            result = entity.getFuncionariodrvEsAsesorIntegral().equals(true) || (entity.getRol().getRolNombre()).equals("AFILIACIONES");
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUAgente
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Funcionario using displayset DSAgentePIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU> piuPIUAgente(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAgente
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAgente
     */
    public int getCount4PIUAgente(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUDFuncionariosReporte
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Funcionario using displayset DSFuncionarioDReportes that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.funcionario.ds.DSFuncionarioDReportes> piuPIUDFuncionariosReporte(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.funcionario.ds.DSFuncionarioDReportes::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDFuncionariosReporte
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDFuncionariosReporte
     */
    public int getCount4PIUDFuncionariosReporte(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFuncionarioDGrupo
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Funcionario using displayset DSFuncionarioDGrupo that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.funcionario.ds.DSFuncionarioDGrupo> piuPIUFuncionarioDGrupo(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.funcionario.ds.DSFuncionarioDGrupo::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFuncionarioDGrupo
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFuncionarioDGrupo
     */
    public int getCount4PIUFuncionarioDGrupo(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFuncionarioDDominio
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Funcionario using displayset DSFuncionarioDGrupo that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.funcionario.ds.DSFuncionarioDGrupo> piuPIUFuncionarioDDominio(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.funcionario.ds.DSFuncionarioDGrupo::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFuncionarioDDominio
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFuncionarioDDominio
     */
    public int getCount4PIUFuncionarioDDominio(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFuncionarioGrupoUsuarios
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Funcionario using displayset DSAgentePIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU> piuPIUFuncionarioGrupoUsuarios(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFuncionarioGrupoUsuarios
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFuncionarioGrupoUsuarios
     */
    public int getCount4PIUFuncionarioGrupoUsuarios(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUUsuarios
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Funcionario using displayset DSAgentePIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU> piuPIUUsuarios(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUUsuarios
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUUsuarios
     */
    public int getCount4PIUUsuarios(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFuncionarioObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Funcionario using displayset DSAgentePIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU> piuPIUFuncionarioObs(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.funcionario.ds.DSAgentePIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFuncionarioObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFuncionarioObs
     */
    public int getCount4PIUFuncionarioObs(QueryRequest queryRequest) {
        return solveFuncionarioTypedQuery(queryRequest).size();
    }

    // Service: crear

    /*
     * Entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse crear(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.crearTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service crear
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse crearTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest request) throws ModelException {
        request.setFuncionariocrearpagrRolInstance(rolSrv.getByOIDWithHV(request.getFuncionariocrearpagrRol()));
        request.setFuncionariocrearpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getFuncionariocrearpagrSucursal()));
        return funcionarioSrv.crearImplementation(request);
    }

    /*
     * Implements service crear
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse crearImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Rol funcionariocrearpagrRol = request.getFuncionariocrearpagrRolInstance();
        Sucursal funcionariocrearpagrSucursal = request.getFuncionariocrearpagrSucursalInstance();
        String funcionariocrearpatrUsuario = request.getFuncionariocrearpatrUsuario();
        String funcionariocrearpatrPrimerNombre = request.getFuncionariocrearpatrPrimerNombre();
        String funcionariocrearpatrSegundoNombre = request.getFuncionariocrearpatrSegundoNombre();
        String funcionariocrearpatrPrimerApellido = request.getFuncionariocrearpatrPrimerApellido();
        String funcionariocrearpatrSegundoApellido = request.getFuncionariocrearpatrSegundoApellido();
        String funcionariocrearpatrUsuarioLDAP = request.getFuncionariocrearpatrUsuarioLDAP();
        String funcionariocrearpatrEmail = request.getFuncionariocrearpatrEmail();
        Boolean funcionariocrearpatrManual = request.getFuncionariocrearpatrManual();
        String funcionariocrearppassword = request.getFuncionariocrearppassword();

        request.checkArguments();
        Funcionario instance = new Funcionario();
        instance.add2Rol(funcionariocrearpagrRol);

        instance.add2Sucursal(funcionariocrearpagrSucursal);

        instance.setFuncionarioId(Long.valueOf(0));
        instance.setFuncionarioDisponible(Boolean.TRUE);
        instance.setFuncionarioNumSolNoTerminadas(Long.valueOf(0));
        instance.setFuncionarioIdSesion(null);
        instance.setFuncionarioUsuario(funcionariocrearpatrUsuario);
        instance.setFuncionarioPrimerNombre(funcionariocrearpatrPrimerNombre);
        instance.setFuncionarioSegundoNombre(funcionariocrearpatrSegundoNombre);
        instance.setFuncionarioPrimerApellido(funcionariocrearpatrPrimerApellido);
        instance.setFuncionarioSegundoApellido(funcionariocrearpatrSegundoApellido);
        instance.setFuncionarioUsuarioLDAP(funcionariocrearpatrUsuarioLDAP);
        instance.setFuncionarioEmail(funcionariocrearpatrEmail);
        instance.setFuncionarioManual(funcionariocrearpatrManual);
        instance.setPassWord(encrypt(funcionariocrearppassword));

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: eliminar

    /*
     * Entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse eliminar(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.eliminarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service eliminar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse eliminarTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.EliminarRequest request) throws ModelException {
        request.setFuncionarioeliminarpthisAdminInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioeliminarpthisAdmin()));
        return funcionarioSrv.eliminarImplementation(request);
    }

    /*
     * Implements service eliminar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse eliminarImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioeliminarpthisAdmin = request.getFuncionarioeliminarpthisAdminInstance();

        request.checkArguments();
        Funcionario instance = funcionarioeliminarpthisAdmin;
        if(funcionarioeliminarpthisAdmin.getSolicitudes().size() > 0) {
            throw new MinCardinalityException(FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ROLE_ALIAS_SOLICITUDES);
        }
        if(funcionarioeliminarpthisAdmin.getSolicitudesAfiliacion().size() > 0) {
            throw new MinCardinalityException(FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ROLE_ALIAS_SOLICITUDESAFILIACION);
        }
        if(funcionarioeliminarpthisAdmin.getSolicitudesNovedad().size() > 0) {
            throw new MinCardinalityException(FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ROLE_ALIAS_SOLICITUDESNOVEDAD);
        }
        if(funcionarioeliminarpthisAdmin.getSolNovAifliaciones().size() > 0) {
            throw new MinCardinalityException(FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ROLE_ALIAS_SOLNOVAIFLIACIONES);
        }
        if(funcionarioeliminarpthisAdmin.getLogFuncionario().size() > 0) {
            throw new MinCardinalityException(FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ROLE_ALIAS_LOGFUNCIONARIO);
        }


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: modificar

    /*
     * Entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificar(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.modificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest request) throws ModelException {
        request.setFuncionariomodificarpthisAdminInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariomodificarpthisAdmin()));
        return funcionarioSrv.modificarImplementation(request);
    }

    /*
     * Implements service modificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariomodificarpthisAdmin = request.getFuncionariomodificarpthisAdminInstance();
        String funcionariomodificarpPrimerNombre = request.getFuncionariomodificarpPrimerNombre();
        String funcionariomodificarpSegundoNombre = request.getFuncionariomodificarpSegundoNombre();
        String funcionariomodificarpPrimerApellido = request.getFuncionariomodificarpPrimerApellido();
        String funcionariomodificarpSegundoApellido = request.getFuncionariomodificarpSegundoApellido();
        String funcionariomodificarpUsuarioLDAP = request.getFuncionariomodificarpUsuarioLDAP();
        String funcionariomodificarpEmail = request.getFuncionariomodificarpEmail();

        request.checkArguments();
        Funcionario instance = funcionariomodificarpthisAdmin;
        instance.setFuncionarioPrimerNombre(funcionariomodificarpPrimerNombre);
        instance.setFuncionarioSegundoNombre(funcionariomodificarpSegundoNombre);
        instance.setFuncionarioPrimerApellido(funcionariomodificarpPrimerApellido);
        instance.setFuncionarioSegundoApellido(funcionariomodificarpSegundoApellido);
        instance.setFuncionarioUsuarioLDAP(funcionariomodificarpUsuarioLDAP);
        instance.setFuncionarioEmail(funcionariomodificarpEmail);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: setPassword

    /*
     * Entry point for service setPassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse setPassword(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SetPasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.setPasswordTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service setPassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse setPasswordTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SetPasswordRequest request) throws ModelException {
        request.setFuncionariosetPasswordpthisAdminInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariosetPasswordpthisAdmin()));
        return funcionarioSrv.setPasswordImplementation(request);
    }

    /*
     * Implements service setPassword
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse setPasswordImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SetPasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariosetPasswordpthisAdmin = request.getFuncionariosetPasswordpthisAdminInstance();
        String funcionariosetPasswordpNewPassword = request.getFuncionariosetPasswordpNewPassword();

        request.checkArguments();
        Funcionario instance = funcionariosetPasswordpthisAdmin;
        instance.setPassWord(encrypt(funcionariosetPasswordpNewPassword));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerAdmin

    /*
     * Entry point for service hacerAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerAdmin(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAdminRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerAdminTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerAdminTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAdminRequest request) throws ModelException {
        request.setFuncionariohacerAdminpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerAdminpthisAgente()));
        return funcionarioSrv.hacerAdminImplementation(request);
    }

    /*
     * Implements service hacerAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerAdminImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerAdminpthisAgente = request.getFuncionariohacerAdminpthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariohacerAdminpthisAgente;

        instance.setChildAdmin((Admin) adminSrv.hacerAdminImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerSuperAdmin

    /*
     * Entry point for service hacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerSuperAdmin(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerSuperAdminTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerSuperAdminTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest request) throws ModelException {
        request.setFuncionariohacerSuperAdminpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerSuperAdminpthisAgente()));
        return funcionarioSrv.hacerSuperAdminImplementation(request);
    }

    /*
     * Implements service hacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerSuperAdminImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerSuperAdminpthisAgente = request.getFuncionariohacerSuperAdminpthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariohacerSuperAdminpthisAgente;

        instance.setChildSuperAdmin((SuperAdmin) superAdminSrv.hacerSuperAdminImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerAsesor

    /*
     * Entry point for service hacerAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerAsesor(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerAsesorTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAsesorRequest request) throws ModelException {
        request.setFuncionariohacerAsesorpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerAsesorpthisAgente()));
        request.setFuncionariohacerAsesorpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFuncionariohacerAsesorpagrTipoIdentificacion()));
        return funcionarioSrv.hacerAsesorImplementation(request);
    }

    /*
     * Implements service hacerAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerAsesorImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAsesorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerAsesorpthisAgente = request.getFuncionariohacerAsesorpthisAgenteInstance();
        TipoIdentificacion funcionariohacerAsesorpagrTipoIdentificacion = request.getFuncionariohacerAsesorpagrTipoIdentificacionInstance();
        Boolean funcionariohacerAsesorpatrmodificaDirector = request.getFuncionariohacerAsesorpatrmodificaDirector();
        Boolean funcionariohacerAsesorpatresDirector = request.getFuncionariohacerAsesorpatresDirector();
        String funcionariohacerAsesorpatrNumIdentificacion = request.getFuncionariohacerAsesorpatrNumIdentificacion();
        Boolean funcionariohacerAsesorpatrModDBasicosPersona = request.getFuncionariohacerAsesorpatrModDBasicosPersona();
        Boolean funcionariohacerAsesorpatrEsIntegral = request.getFuncionariohacerAsesorpatrEsIntegral();
        Boolean funcionariohacerAsesorpatrVerDBasicosPersona = request.getFuncionariohacerAsesorpatrVerDBasicosPersona();
        Boolean funcionariohacerAsesorpatrVerDocIdentificacionPerso = request.getFuncionariohacerAsesorpatrVerDocIdentificacionPerso();
        Boolean funcionariohacerAsesorpatrVerContratoNovedad = request.getFuncionariohacerAsesorpatrVerContratoNovedad();
        String funcionariohacerAsesorpatrCanalComercial = request.getFuncionariohacerAsesorpatrCanalComercial();
        String funcionariohacerAsesorpatrCargo = request.getFuncionariohacerAsesorpatrCargo();
        String funcionariohacerAsesorpatrEstado = request.getFuncionariohacerAsesorpatrEstado();
        Boolean funcionariohacerAsesorpatrAccesoValidadorUsuarios = request.getFuncionariohacerAsesorpatrAccesoValidadorUsuarios();
        String funcionariohacerAsesorpCodJefe = request.getFuncionariohacerAsesorpCodJefe();

        request.checkArguments();
        Funcionario instance = funcionariohacerAsesorpthisAgente;
        instance.setFuncionarioCodJefe(funcionariohacerAsesorpCodJefe);

        instance.setChildAsesor((Asesor) asesorSrv.hacerAsesorImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: sincronizarAsesor

    /*
     * Entry point for service sincronizarAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse sincronizarAsesor(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SincronizarAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.sincronizarAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service sincronizarAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse sincronizarAsesorTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SincronizarAsesorRequest request) throws ModelException {
        request.setFuncionariosincronizarAsesorpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariosincronizarAsesorpthisAgente()));
        return funcionarioSrv.sincronizarAsesorImplementation(request);
    }

    /*
     * Implements service sincronizarAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse sincronizarAsesorImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SincronizarAsesorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariosincronizarAsesorpthisAgente = request.getFuncionariosincronizarAsesorpthisAgenteInstance();
        String funcionariosincronizarAsesorpPrimerNombre = request.getFuncionariosincronizarAsesorpPrimerNombre();
        String funcionariosincronizarAsesorpSegundoNombre = request.getFuncionariosincronizarAsesorpSegundoNombre();
        String funcionariosincronizarAsesorpPrimerApellido = request.getFuncionariosincronizarAsesorpPrimerApellido();
        String funcionariosincronizarAsesorpSegundoApellido = request.getFuncionariosincronizarAsesorpSegundoApellido();

        request.checkArguments();
        Funcionario instance = funcionariosincronizarAsesorpthisAgente;
        instance.setFuncionarioPrimerNombre(funcionariosincronizarAsesorpPrimerNombre);
        instance.setFuncionarioSegundoNombre(funcionariosincronizarAsesorpSegundoNombre);
        instance.setFuncionarioPrimerApellido(funcionariosincronizarAsesorpPrimerApellido);
        instance.setFuncionarioSegundoApellido(funcionariosincronizarAsesorpSegundoApellido);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerRespRegional

    /*
     * Entry point for service hacerRespRegional
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerRespRegional(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerRespRegionalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerRespRegionalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerRespRegional
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerRespRegionalTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerRespRegionalRequest request) throws ModelException {
        request.setFuncionariohacerRespRegionalpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerRespRegionalpthisAgente()));
        request.setFuncionariohacerRespRegionalpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getFuncionariohacerRespRegionalpagrRegional()));
        return funcionarioSrv.hacerRespRegionalImplementation(request);
    }

    /*
     * Implements service hacerRespRegional
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerRespRegionalImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerRespRegionalRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerRespRegionalpthisAgente = request.getFuncionariohacerRespRegionalpthisAgenteInstance();
        Regional funcionariohacerRespRegionalpagrRegional = request.getFuncionariohacerRespRegionalpagrRegionalInstance();

        request.checkArguments();
        Funcionario instance = funcionariohacerRespRegionalpthisAgente;

        instance.setChildRespRegional((RespRegional) respRegionalSrv.hacerRespRegionalImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerAreaMedica

    /*
     * Entry point for service hacerAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerAreaMedica(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAreaMedicaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerAreaMedicaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerAreaMedicaTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAreaMedicaRequest request) throws ModelException {
        request.setFuncionariohacerAreaMedicapthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerAreaMedicapthisAgente()));
        return funcionarioSrv.hacerAreaMedicaImplementation(request);
    }

    /*
     * Implements service hacerAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerAreaMedicaImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAreaMedicaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerAreaMedicapthisAgente = request.getFuncionariohacerAreaMedicapthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariohacerAreaMedicapthisAgente;

        instance.setChildAreaMedica((AreaMedica) areaMedicaSrv.hacerAreaMedicaImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerAfiliaciones

    /*
     * Entry point for service hacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerAfiliaciones(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerAfiliacionesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerAfiliacionesTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest request) throws ModelException {
        request.setFuncionariohacerAfiliacionespthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerAfiliacionespthisAgente()));
        return funcionarioSrv.hacerAfiliacionesImplementation(request);
    }

    /*
     * Implements service hacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerAfiliacionesImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerAfiliacionespthisAgente = request.getFuncionariohacerAfiliacionespthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariohacerAfiliacionespthisAgente;

        instance.setChildAfiliaciones((Afiliaciones) afiliacionesSrv.hacerAfiliacionesImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: CambSucursalAgente

    /*
     * Entry point for service CambSucursalAgente
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambSucursalAgente(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.cambSucursalAgenteTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service CambSucursalAgente
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambSucursalAgenteTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest request) throws ModelException {
        request.setFuncionarioCambSucursalAgentepthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioCambSucursalAgentepthisAgente()));
        request.setFuncionarioCambSucursalAgentepevcSucursalInstance(sucursalSrv.getByOIDWithHV(request.getFuncionarioCambSucursalAgentepevcSucursal()));
        return funcionarioSrv.cambSucursalAgenteImplementation(request, true);
    }

    /*
     * Implements service CambSucursalAgente
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambSucursalAgenteImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioCambSucursalAgentepthisAgente = request.getFuncionarioCambSucursalAgentepthisAgenteInstance();
        Sucursal funcionarioCambSucursalAgentepevcSucursal = request.getFuncionarioCambSucursalAgentepevcSucursalInstance();

        request.checkArguments();
        Funcionario instance = funcionarioCambSucursalAgentepthisAgente;

        instance.add2Sucursal(funcionarioCambSucursalAgentepevcSucursal);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambSucursalAgenteRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.sucursal.siu.CambSucursalAgenteRequest();
            relatedRequest.setSucursalCambSucursalAgentepthisSucursalInstance(funcionarioCambSucursalAgentepevcSucursal);
            relatedRequest.setSucursalCambSucursalAgentepevcFuncionarioInstance(funcionarioCambSucursalAgentepthisAgente);
            sucursalSrv.cambSucursalAgenteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerAdmin

    /*
     * Entry point for service deshacerAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerAdmin(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAdminRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerAdminTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerAdminTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAdminRequest request) throws ModelException {
        request.setFuncionariodeshacerAdminpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerAdminpthisAgente()));
        return funcionarioSrv.deshacerAdminImplementation(request);
    }

    /*
     * Implements service deshacerAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerAdminImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerAdminpthisAgente = request.getFuncionariodeshacerAdminpthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerAdminpthisAgente;

        adminSrv.deshacerAdminImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerSuperAdmin

    /*
     * Entry point for service deshacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerSuperAdmin(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerSuperAdminRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerSuperAdminTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerSuperAdminTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerSuperAdminRequest request) throws ModelException {
        request.setFuncionariodeshacerSuperAdminpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerSuperAdminpthisAgente()));
        return funcionarioSrv.deshacerSuperAdminImplementation(request);
    }

    /*
     * Implements service deshacerSuperAdmin
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerSuperAdminImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerSuperAdminRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerSuperAdminpthisAgente = request.getFuncionariodeshacerSuperAdminpthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerSuperAdminpthisAgente;

        superAdminSrv.deshacerSuperAdminImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerAsesor

    /*
     * Entry point for service deshacerAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerAsesor(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerAsesorTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAsesorRequest request) throws ModelException {
        request.setFuncionariodeshacerAsesorpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerAsesorpthisAgente()));
        return funcionarioSrv.deshacerAsesorImplementation(request);
    }

    /*
     * Implements service deshacerAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerAsesorImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAsesorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerAsesorpthisAgente = request.getFuncionariodeshacerAsesorpthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerAsesorpthisAgente;
        instance.setFuncionarioCodJefe(null);

        asesorSrv.deshacerAsesorImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerRespRegional

    /*
     * Entry point for service deshacerRespRegional
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerRespRegional(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerRespRegionalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerRespRegionalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerRespRegional
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerRespRegionalTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerRespRegionalRequest request) throws ModelException {
        request.setFuncionariodeshacerRespRegionalpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerRespRegionalpthisAgente()));
        return funcionarioSrv.deshacerRespRegionalImplementation(request);
    }

    /*
     * Implements service deshacerRespRegional
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerRespRegionalImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerRespRegionalRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerRespRegionalpthisAgente = request.getFuncionariodeshacerRespRegionalpthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerRespRegionalpthisAgente;

        respRegionalSrv.deshacerRespRegionalImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerAreaMedica

    /*
     * Entry point for service deshacerAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerAreaMedica(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAreaMedicaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerAreaMedicaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerAreaMedicaTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAreaMedicaRequest request) throws ModelException {
        request.setFuncionariodeshacerAreaMedicapthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerAreaMedicapthisAgente()));
        return funcionarioSrv.deshacerAreaMedicaImplementation(request);
    }

    /*
     * Implements service deshacerAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerAreaMedicaImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAreaMedicaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerAreaMedicapthisAgente = request.getFuncionariodeshacerAreaMedicapthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerAreaMedicapthisAgente;

        areaMedicaSrv.deshacerAreaMedicaImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerAfiliaciones

    /*
     * Entry point for service deshacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerAfiliaciones(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAfiliacionesRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerAfiliacionesTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerAfiliacionesTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAfiliacionesRequest request) throws ModelException {
        request.setFuncionariodeshacerAfiliacionespthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerAfiliacionespthisAgente()));
        return funcionarioSrv.deshacerAfiliacionesImplementation(request);
    }

    /*
     * Implements service deshacerAfiliaciones
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerAfiliacionesImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAfiliacionesRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerAfiliacionespthisAgente = request.getFuncionariodeshacerAfiliacionespthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerAfiliacionespthisAgente;

        afiliacionesSrv.deshacerAfiliacionesImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: CambRolAgente

    /*
     * Entry point for service CambRolAgente
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambRolAgente(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.cambRolAgenteTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service CambRolAgente
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambRolAgenteTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest request) throws ModelException {
        request.setFuncionarioCambRolAgentepthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioCambRolAgentepthisAgente()));
        request.setFuncionarioCambRolAgentepevcRolInstance(rolSrv.getByOIDWithHV(request.getFuncionarioCambRolAgentepevcRol()));
        return funcionarioSrv.cambRolAgenteImplementation(request, true);
    }

    /*
     * Implements service CambRolAgente
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambRolAgenteImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioCambRolAgentepthisAgente = request.getFuncionarioCambRolAgentepthisAgenteInstance();
        Rol funcionarioCambRolAgentepevcRol = request.getFuncionarioCambRolAgentepevcRolInstance();

        request.checkArguments();
        Funcionario instance = funcionarioCambRolAgentepthisAgente;

        instance.add2Rol(funcionarioCambRolAgentepevcRol);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.rol.siu.CambRolAgenteRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.rol.siu.CambRolAgenteRequest();
            relatedRequest.setRolCambRolAgentepthisRolInstance(funcionarioCambRolAgentepevcRol);
            relatedRequest.setRolCambRolAgentepevcFuncionarioInstance(funcionarioCambRolAgentepthisAgente);
            rolSrv.cambRolAgenteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: modAsesorAgencia

    /*
     * Entry point for service modAsesorAgencia
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modAsesorAgencia(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.modAsesorAgenciaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modAsesorAgencia
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modAsesorAgenciaTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest request) throws ModelException {
        request.setFuncionariomodAsesorAgenciapthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariomodAsesorAgenciapthisFuncionario()));
        return funcionarioSrv.modAsesorAgenciaImplementation(request);
    }

    /*
     * Implements service modAsesorAgencia
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modAsesorAgenciaImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariomodAsesorAgenciapthisFuncionario = request.getFuncionariomodAsesorAgenciapthisFuncionarioInstance();
        String funcionariomodAsesorAgenciapeNumUsuario = request.getFuncionariomodAsesorAgenciapeNumUsuario();
        String funcionariomodAsesorAgenciapeCodJefe = request.getFuncionariomodAsesorAgenciapeCodJefe();

        request.checkArguments();
        Funcionario instance = funcionariomodAsesorAgenciapthisFuncionario;
        instance.setFuncionarioUsuario(funcionariomodAsesorAgenciapeNumUsuario);
        instance.setFuncionarioCodJefe(funcionariomodAsesorAgenciapeCodJefe);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: InsReporteFuncionario

    /*
     * Entry point for service InsReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insReporteFuncionario(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsReporteFuncionarioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.insReporteFuncionarioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insReporteFuncionarioTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsReporteFuncionarioRequest request) throws ModelException {
        request.setFuncionarioInsReporteFuncionariopthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioInsReporteFuncionariopthisFuncionario()));
        request.setFuncionarioInsReporteFuncionariopevcReportesProcAlmInstance(reportesProcAlmSrv.getByOIDWithHV(new ReportesProcAlmOid().fromJsonString(request.getFuncionarioInsReporteFuncionariopevcReportesProcAlm())));
        return funcionarioSrv.insReporteFuncionarioImplementation(request, true);
    }

    /*
     * Implements service InsReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insReporteFuncionarioImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsReporteFuncionarioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioInsReporteFuncionariopthisFuncionario = request.getFuncionarioInsReporteFuncionariopthisFuncionarioInstance();
        ReportesProcAlm funcionarioInsReporteFuncionariopevcReportesProcAlm = request.getFuncionarioInsReporteFuncionariopevcReportesProcAlmInstance();

        request.checkArguments();
        Funcionario instance = funcionarioInsReporteFuncionariopthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.reportesprocalm.siu.InsReporteFuncionarioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.reportesprocalm.siu.InsReporteFuncionarioRequest();
            relatedRequest.setReportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance(funcionarioInsReporteFuncionariopevcReportesProcAlm);
            relatedRequest.setReportesProcAlmInsReporteFuncionariopevcFuncionarioInstance(funcionarioInsReporteFuncionariopthisFuncionario);
            reportesProcAlmSrv.insReporteFuncionarioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: DelReporteFuncionario

    /*
     * Entry point for service DelReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delReporteFuncionario(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelReporteFuncionarioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.delReporteFuncionarioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delReporteFuncionarioTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelReporteFuncionarioRequest request) throws ModelException {
        request.setFuncionarioDelReporteFuncionariopthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioDelReporteFuncionariopthisFuncionario()));
        request.setFuncionarioDelReporteFuncionariopevcReportesProcAlmInstance(reportesProcAlmSrv.getByOIDWithHV(new ReportesProcAlmOid().fromJsonString(request.getFuncionarioDelReporteFuncionariopevcReportesProcAlm())));
        return funcionarioSrv.delReporteFuncionarioImplementation(request, true);
    }

    /*
     * Implements service DelReporteFuncionario
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delReporteFuncionarioImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelReporteFuncionarioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioDelReporteFuncionariopthisFuncionario = request.getFuncionarioDelReporteFuncionariopthisFuncionarioInstance();
        ReportesProcAlm funcionarioDelReporteFuncionariopevcReportesProcAlm = request.getFuncionarioDelReporteFuncionariopevcReportesProcAlmInstance();

        request.checkArguments();
        Funcionario instance = funcionarioDelReporteFuncionariopthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.reportesprocalm.siu.DelReporteFuncionarioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.reportesprocalm.siu.DelReporteFuncionarioRequest();
            relatedRequest.setReportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance(funcionarioDelReporteFuncionariopevcReportesProcAlm);
            relatedRequest.setReportesProcAlmDelReporteFuncionariopevcFuncionarioInstance(funcionarioDelReporteFuncionariopthisFuncionario);
            reportesProcAlmSrv.delReporteFuncionarioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: AddFuncionarioGrupo

    /*
     * Entry point for service AddFuncionarioGrupo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse addFuncionarioGrupo(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.AddFuncionarioGrupoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.addFuncionarioGrupoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service AddFuncionarioGrupo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse addFuncionarioGrupoTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.AddFuncionarioGrupoRequest request) throws ModelException {
        request.setFuncionarioAddFuncionarioGrupopthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioAddFuncionarioGrupopthisFuncionario()));
        request.setFuncionarioAddFuncionarioGrupopevcGrupoAsignacionInstance(grupoAsignacionSrv.getByOIDWithHV(request.getFuncionarioAddFuncionarioGrupopevcGrupoAsignacion()));
        return funcionarioSrv.addFuncionarioGrupoImplementation(request, true);
    }

    /*
     * Implements service AddFuncionarioGrupo
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse addFuncionarioGrupoImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.AddFuncionarioGrupoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioAddFuncionarioGrupopthisFuncionario = request.getFuncionarioAddFuncionarioGrupopthisFuncionarioInstance();
        GrupoAsignacion funcionarioAddFuncionarioGrupopevcGrupoAsignacion = request.getFuncionarioAddFuncionarioGrupopevcGrupoAsignacionInstance();

        request.checkArguments();
        Funcionario instance = funcionarioAddFuncionarioGrupopthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.AddFuncionarioGrupoRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.AddFuncionarioGrupoRequest();
            relatedRequest.setGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance(funcionarioAddFuncionarioGrupopevcGrupoAsignacion);
            relatedRequest.setGrupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance(funcionarioAddFuncionarioGrupopthisFuncionario);
            grupoAsignacionSrv.addFuncionarioGrupoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: DelFuncionarioGrupo

    /*
     * Entry point for service DelFuncionarioGrupo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delFuncionarioGrupo(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelFuncionarioGrupoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.delFuncionarioGrupoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelFuncionarioGrupo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delFuncionarioGrupoTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelFuncionarioGrupoRequest request) throws ModelException {
        request.setFuncionarioDelFuncionarioGrupopthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioDelFuncionarioGrupopthisFuncionario()));
        request.setFuncionarioDelFuncionarioGrupopevcGrupoAsignacionInstance(grupoAsignacionSrv.getByOIDWithHV(request.getFuncionarioDelFuncionarioGrupopevcGrupoAsignacion()));
        return funcionarioSrv.delFuncionarioGrupoImplementation(request, true);
    }

    /*
     * Implements service DelFuncionarioGrupo
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delFuncionarioGrupoImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelFuncionarioGrupoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioDelFuncionarioGrupopthisFuncionario = request.getFuncionarioDelFuncionarioGrupopthisFuncionarioInstance();
        GrupoAsignacion funcionarioDelFuncionarioGrupopevcGrupoAsignacion = request.getFuncionarioDelFuncionarioGrupopevcGrupoAsignacionInstance();

        request.checkArguments();
        Funcionario instance = funcionarioDelFuncionarioGrupopthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.DelFuncionarioGrupoRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.DelFuncionarioGrupoRequest();
            relatedRequest.setGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance(funcionarioDelFuncionarioGrupopevcGrupoAsignacion);
            relatedRequest.setGrupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance(funcionarioDelFuncionarioGrupopthisFuncionario);
            grupoAsignacionSrv.delFuncionarioGrupoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: InsSolNovUsrAfiliacion

    /*
     * Entry point for service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insSolNovUsrAfiliacion(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsSolNovUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.insSolNovUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insSolNovUsrAfiliacionTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsSolNovUsrAfiliacionRequest request) throws ModelException {
        request.setFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioInsSolNovUsrAfiliacionpthisFuncionario()));
        request.setFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad()));
        return funcionarioSrv.insSolNovUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insSolNovUsrAfiliacionImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsSolNovUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioInsSolNovUsrAfiliacionpthisFuncionario = request.getFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance();
        SolicitudNovedad funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad = request.getFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance();

        request.checkArguments();
        Funcionario instance = funcionarioInsSolNovUsrAfiliacionpthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest();
            relatedRequest.setSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance(funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad);
            relatedRequest.setSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance(funcionarioInsSolNovUsrAfiliacionpthisFuncionario);
            solicitudNovedadSrv.insSolNovUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: DelSolNovUsrAfiliacion

    /*
     * Entry point for service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delSolNovUsrAfiliacion(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelSolNovUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.delSolNovUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delSolNovUsrAfiliacionTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelSolNovUsrAfiliacionRequest request) throws ModelException {
        request.setFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioDelSolNovUsrAfiliacionpthisFuncionario()));
        request.setFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad()));
        return funcionarioSrv.delSolNovUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delSolNovUsrAfiliacionImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelSolNovUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioDelSolNovUsrAfiliacionpthisFuncionario = request.getFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance();
        SolicitudNovedad funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad = request.getFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance();

        request.checkArguments();
        Funcionario instance = funcionarioDelSolNovUsrAfiliacionpthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest();
            relatedRequest.setSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance(funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad);
            relatedRequest.setSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance(funcionarioDelSolNovUsrAfiliacionpthisFuncionario);
            solicitudNovedadSrv.delSolNovUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: InsUsrAfiliacion

    /*
     * Entry point for service InsUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insUsrAfiliacion(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.insUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insUsrAfiliacionTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsUsrAfiliacionRequest request) throws ModelException {
        request.setFuncionarioInsUsrAfiliacionpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioInsUsrAfiliacionpthisFuncionario()));
        request.setFuncionarioInsUsrAfiliacionpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getFuncionarioInsUsrAfiliacionpevcSolicitud()));
        return funcionarioSrv.insUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service InsUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insUsrAfiliacionImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioInsUsrAfiliacionpthisFuncionario = request.getFuncionarioInsUsrAfiliacionpthisFuncionarioInstance();
        Solicitud funcionarioInsUsrAfiliacionpevcSolicitud = request.getFuncionarioInsUsrAfiliacionpevcSolicitudInstance();

        request.checkArguments();
        Funcionario instance = funcionarioInsUsrAfiliacionpthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.solicitud.siu.InsUsrAfiliacionRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.solicitud.siu.InsUsrAfiliacionRequest();
            relatedRequest.setSolicitudInsUsrAfiliacionpthisSolicitudInstance(funcionarioInsUsrAfiliacionpevcSolicitud);
            relatedRequest.setSolicitudInsUsrAfiliacionpevcFuncionarioInstance(funcionarioInsUsrAfiliacionpthisFuncionario);
            solicitudSrv.insUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: DelUsrAfiliacion

    /*
     * Entry point for service DelUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delUsrAfiliacion(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.delUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delUsrAfiliacionTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelUsrAfiliacionRequest request) throws ModelException {
        request.setFuncionarioDelUsrAfiliacionpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioDelUsrAfiliacionpthisFuncionario()));
        request.setFuncionarioDelUsrAfiliacionpevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getFuncionarioDelUsrAfiliacionpevcSolicitud()));
        return funcionarioSrv.delUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service DelUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delUsrAfiliacionImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioDelUsrAfiliacionpthisFuncionario = request.getFuncionarioDelUsrAfiliacionpthisFuncionarioInstance();
        Solicitud funcionarioDelUsrAfiliacionpevcSolicitud = request.getFuncionarioDelUsrAfiliacionpevcSolicitudInstance();

        request.checkArguments();
        Funcionario instance = funcionarioDelUsrAfiliacionpthisFuncionario;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.solicitud.siu.DelUsrAfiliacionRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.solicitud.siu.DelUsrAfiliacionRequest();
            relatedRequest.setSolicitudDelUsrAfiliacionpthisSolicitudInstance(funcionarioDelUsrAfiliacionpevcSolicitud);
            relatedRequest.setSolicitudDelUsrAfiliacionpevcFuncionarioInstance(funcionarioDelUsrAfiliacionpthisFuncionario);
            solicitudSrv.delUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: cambiarDisponible

    /*
     * Entry point for service cambiarDisponible
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambiarDisponible(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambiarDisponibleRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.cambiarDisponibleTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service cambiarDisponible
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambiarDisponibleTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambiarDisponibleRequest request) throws ModelException {
        request.setFuncionariocambiarDisponiblepthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariocambiarDisponiblepthisFuncionario()));
        return funcionarioSrv.cambiarDisponibleImplementation(request);
    }

    /*
     * Implements service cambiarDisponible
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambiarDisponibleImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambiarDisponibleRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariocambiarDisponiblepthisFuncionario = request.getFuncionariocambiarDisponiblepthisFuncionarioInstance();
        Boolean funcionariocambiarDisponiblepeDisponible = request.getFuncionariocambiarDisponiblepeDisponible();

        request.checkArguments();
        Funcionario instance = funcionariocambiarDisponiblepthisFuncionario;
        instance.setFuncionarioDisponible(funcionariocambiarDisponiblepeDisponible);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: solicitudAsignada

    /*
     * Entry point for service solicitudAsignada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse solicitudAsignada(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SolicitudAsignadaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.solicitudAsignadaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service solicitudAsignada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse solicitudAsignadaTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SolicitudAsignadaRequest request) throws ModelException {
        request.setFuncionariosolicitudAsignadapthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariosolicitudAsignadapthisFuncionario()));
        return funcionarioSrv.solicitudAsignadaImplementation(request);
    }

    /*
     * Implements service solicitudAsignada
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse solicitudAsignadaImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SolicitudAsignadaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariosolicitudAsignadapthisFuncionario = request.getFuncionariosolicitudAsignadapthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionariosolicitudAsignadapthisFuncionario;
        instance.setFuncionarioNumSolNoTerminadas(funcionariosolicitudAsignadapthisFuncionario.getFuncionarioNumSolNoTerminadas() + Long.valueOf(1));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: solicitudTerminada

    /*
     * Entry point for service solicitudTerminada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse solicitudTerminada(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SolicitudTerminadaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.solicitudTerminadaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service solicitudTerminada
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse solicitudTerminadaTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SolicitudTerminadaRequest request) throws ModelException {
        request.setFuncionariosolicitudTerminadapthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariosolicitudTerminadapthisFuncionario()));
        return funcionarioSrv.solicitudTerminadaImplementation(request);
    }

    /*
     * Implements service solicitudTerminada
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse solicitudTerminadaImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SolicitudTerminadaRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariosolicitudTerminadapthisFuncionario = request.getFuncionariosolicitudTerminadapthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionariosolicitudTerminadapthisFuncionario;
        if (funcionariosolicitudTerminadapthisFuncionario.getFuncionarioNumSolNoTerminadas() > Long.valueOf(0)) {
            instance.setFuncionarioNumSolNoTerminadas(funcionariosolicitudTerminadapthisFuncionario.getFuncionarioNumSolNoTerminadas() - Long.valueOf(1));
        } else {
            instance.setFuncionarioNumSolNoTerminadas(Long.valueOf(0));
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerGestor

    /*
     * Entry point for service hacerGestor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerGestor(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerGestorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerGestorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerGestor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerGestorTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerGestorRequest request) throws ModelException {
        request.setFuncionariohacerGestorpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerGestorpthisFuncionario()));
        return funcionarioSrv.hacerGestorImplementation(request);
    }

    /*
     * Implements service hacerGestor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerGestorImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerGestorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerGestorpthisFuncionario = request.getFuncionariohacerGestorpthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionariohacerGestorpthisFuncionario;

        instance.setChildGestor((Gestor) gestorSrv.hacerGestorImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerGestor

    /*
     * Entry point for service deshacerGestor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerGestor(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerGestorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerGestorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerGestor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerGestorTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerGestorRequest request) throws ModelException {
        request.setFuncionariodeshacerGestorpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerGestorpthisFuncionario()));
        return funcionarioSrv.deshacerGestorImplementation(request);
    }

    /*
     * Implements service deshacerGestor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerGestorImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerGestorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerGestorpthisFuncionario = request.getFuncionariodeshacerGestorpthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerGestorpthisFuncionario;

        gestorSrv.deshacerGestorImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: hacerMesaApoyo

    /*
     * Entry point for service hacerMesaApoyo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse hacerMesaApoyo(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerMesaApoyoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.hacerMesaApoyoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service hacerMesaApoyo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse hacerMesaApoyoTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerMesaApoyoRequest request) throws ModelException {
        request.setFuncionariohacerMesaApoyopthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariohacerMesaApoyopthisFuncionario()));
        return funcionarioSrv.hacerMesaApoyoImplementation(request);
    }

    /*
     * Implements service hacerMesaApoyo
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse hacerMesaApoyoImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerMesaApoyoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariohacerMesaApoyopthisFuncionario = request.getFuncionariohacerMesaApoyopthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionariohacerMesaApoyopthisFuncionario;

        instance.setChildMesaDeApoyo((MesaDeApoyo) mesaDeApoyoSrv.hacerMesaApoyoImplementation(request).getInstance());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: deshacerMesaApoyo

    /*
     * Entry point for service deshacerMesaApoyo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse deshacerMesaApoyo(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerMesaApoyoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.deshacerMesaApoyoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service deshacerMesaApoyo
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse deshacerMesaApoyoTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerMesaApoyoRequest request) throws ModelException {
        request.setFuncionariodeshacerMesaApoyopthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariodeshacerMesaApoyopthisFuncionario()));
        return funcionarioSrv.deshacerMesaApoyoImplementation(request);
    }

    /*
     * Implements service deshacerMesaApoyo
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse deshacerMesaApoyoImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerMesaApoyoRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariodeshacerMesaApoyopthisFuncionario = request.getFuncionariodeshacerMesaApoyopthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionariodeshacerMesaApoyopthisFuncionario;

        mesaDeApoyoSrv.deshacerMesaApoyoImplementation(request);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: setIdSesion

    /*
     * Entry point for service setIdSesion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse setIdSesion(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.setIdSesionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service setIdSesion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse setIdSesionTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest request) throws ModelException {
        request.setFuncionariosetIdSesionpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariosetIdSesionpthisFuncionario()));
        return funcionarioSrv.setIdSesionImplementation(request);
    }

    /*
     * Implements service setIdSesion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse setIdSesionImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariosetIdSesionpthisFuncionario = request.getFuncionariosetIdSesionpthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionariosetIdSesionpthisFuncionario;
        instance.setFuncionarioIdSesion(STDFunctions.toShortDateFormatFun(STDFunctions.systemDateFun()) + STDFunctions.timeToStringFun(STDFunctions.systemTimeFun()));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: TCREAR

    /*
     * Entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAR(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.tCREARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARRequest request) throws ModelException {
        request.setFuncionarioTCREARptpagrRolInstance(rolSrv.getByOIDWithHV(request.getFuncionarioTCREARptpagrRol()));
        request.setFuncionarioTCREARptpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getFuncionarioTCREARptpagrSucursal()));
        request.setFuncionarioTCREARptpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getFuncionarioTCREARptpagrRegional()));
        return funcionarioSrv.tCREARImplementation(request);
    }

    /*
     * Implements service TCREAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Rol funcionarioTCREARptpagrRol = request.getFuncionarioTCREARptpagrRolInstance();
        Sucursal funcionarioTCREARptpagrSucursal = request.getFuncionarioTCREARptpagrSucursalInstance();
        String funcionarioTCREARptpatrUsuario = request.getFuncionarioTCREARptpatrUsuario();
        String funcionarioTCREARptpatrPrimerNombre = request.getFuncionarioTCREARptpatrPrimerNombre();
        String funcionarioTCREARptpatrSegundoNombre = request.getFuncionarioTCREARptpatrSegundoNombre();
        String funcionarioTCREARptpatrPrimerApellido = request.getFuncionarioTCREARptpatrPrimerApellido();
        String funcionarioTCREARptpatrSegundoApellido = request.getFuncionarioTCREARptpatrSegundoApellido();
        String funcionarioTCREARptpatrUsuarioLDAP = request.getFuncionarioTCREARptpatrUsuarioLDAP();
        String funcionarioTCREARptpatrEmail = request.getFuncionarioTCREARptpatrEmail();
        String funcionarioTCREARptppassword = request.getFuncionarioTCREARptppassword();
        Regional funcionarioTCREARptpagrRegional = request.getFuncionarioTCREARptpagrRegionalInstance();

        request.checkArguments();
        Funcionario instance;

        com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest();
        step1Request.setFuncionariocrearpagrRolInstance(funcionarioTCREARptpagrRol);
        step1Request.setFuncionariocrearpagrSucursalInstance(funcionarioTCREARptpagrSucursal);
        step1Request.setFuncionariocrearpatrUsuario(funcionarioTCREARptpatrUsuario);
        step1Request.setFuncionariocrearpatrPrimerNombre(funcionarioTCREARptpatrPrimerNombre);
        step1Request.setFuncionariocrearpatrSegundoNombre(funcionarioTCREARptpatrSegundoNombre);
        step1Request.setFuncionariocrearpatrPrimerApellido(funcionarioTCREARptpatrPrimerApellido);
        step1Request.setFuncionariocrearpatrSegundoApellido(funcionarioTCREARptpatrSegundoApellido);
        step1Request.setFuncionariocrearpatrUsuarioLDAP(funcionarioTCREARptpatrUsuarioLDAP);
        step1Request.setFuncionariocrearpatrEmail(funcionarioTCREARptpatrEmail);
        step1Request.setFuncionariocrearpatrManual(Boolean.FALSE);
        step1Request.setFuncionariocrearppassword(funcionarioTCREARptppassword);
        instance = (Funcionario) funcionarioSrv.crearImplementation(step1Request).getInstance();

        /* Action 2: IF (Rol.Nombre = "ADMIN") */
        boolean ifCondition2 = (instance.getRol().getRolNombre()).equals("ADMIN");
        if (ifCondition2) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAdminRequest step20Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAdminRequest();
            step20Request.setFuncionariohacerAdminpthisAgenteInstance(instance);
            funcionarioSrv.hacerAdminImplementation(step20Request);
        }

        /* Action 3: IF (Rol.Nombre = "SUPERADMIN") */
        boolean ifCondition3 = (instance.getRol().getRolNombre()).equals("SUPERADMIN");
        if (ifCondition3) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest step30Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest();
            step30Request.setFuncionariohacerSuperAdminpthisAgenteInstance(instance);
            funcionarioSrv.hacerSuperAdminImplementation(step30Request);
        }

        /* Action 4: IF (Rol.Nombre = "AREAMEDICA") */
        boolean ifCondition4 = (instance.getRol().getRolNombre()).equals("AREAMEDICA");
        if (ifCondition4) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAreaMedicaRequest step40Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAreaMedicaRequest();
            step40Request.setFuncionariohacerAreaMedicapthisAgenteInstance(instance);
            funcionarioSrv.hacerAreaMedicaImplementation(step40Request);
        }

        /* Action 5: IF (Rol.Nombre = "AFILIACIONES") */
        boolean ifCondition5 = (instance.getRol().getRolNombre()).equals("AFILIACIONES");
        if (ifCondition5) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest step50Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest();
            step50Request.setFuncionariohacerAfiliacionespthisAgenteInstance(instance);
            funcionarioSrv.hacerAfiliacionesImplementation(step50Request);
        }

        /* Action 6: IF (Rol.Nombre = "RESPREGIONAL") */
        boolean ifCondition6 = (instance.getRol().getRolNombre()).equals("RESPREGIONAL");
        if (ifCondition6) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerRespRegionalRequest step60Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerRespRegionalRequest();
            step60Request.setFuncionariohacerRespRegionalpthisAgenteInstance(instance);
            step60Request.setFuncionariohacerRespRegionalpagrRegionalInstance(funcionarioTCREARptpagrRegional);
            funcionarioSrv.hacerRespRegionalImplementation(step60Request);
        }

        /* Action 7: IF (Rol.Nombre = "GESTOR") */
        boolean ifCondition7 = (instance.getRol().getRolNombre()).equals("GESTOR");
        if (ifCondition7) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerGestorRequest step70Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerGestorRequest();
            step70Request.setFuncionariohacerGestorpthisFuncionarioInstance(instance);
            funcionarioSrv.hacerGestorImplementation(step70Request);
        }

        /* Action 8: IF (Rol.Nombre = "MESA DE APOYO") */
        boolean ifCondition8 = (instance.getRol().getRolNombre()).equals("MESA DE APOYO");
        if (ifCondition8) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerMesaApoyoRequest step80Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerMesaApoyoRequest();
            step80Request.setFuncionariohacerMesaApoyopthisFuncionarioInstance(instance);
            funcionarioSrv.hacerMesaApoyoImplementation(step80Request);
        }

        com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest step9Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest();
        step9Request.setFuncionariosetIdSesionpthisFuncionarioInstance(instance);
        funcionarioSrv.setIdSesionImplementation(step9Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: TMODIFICARYROL

    /*
     * Entry point for service TMODIFICARYROL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICARYROL(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TMODIFICARYROLRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.tMODIFICARYROLTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICARYROL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARYROLTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TMODIFICARYROLRequest request) throws ModelException {
        request.setFuncionarioTMODIFICARYROLpthisAgenteInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioTMODIFICARYROLpthisAgente()));
        request.setFuncionarioTMODIFICARYROLptNuevoRolInstance(rolSrv.getByOIDWithHV(request.getFuncionarioTMODIFICARYROLptNuevoRol()));
        request.setFuncionarioTMODIFICARYROLptpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getFuncionarioTMODIFICARYROLptpagrRegional()));
        return funcionarioSrv.tMODIFICARYROLImplementation(request);
    }

    /*
     * Implements service TMODIFICARYROL
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARYROLImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TMODIFICARYROLRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String funcionarioTMODIFICARYROLptpPrimerNombre = request.getFuncionarioTMODIFICARYROLptpPrimerNombre();
        String funcionarioTMODIFICARYROLptpSegundoNombre = request.getFuncionarioTMODIFICARYROLptpSegundoNombre();
        String funcionarioTMODIFICARYROLptpPrimerApellido = request.getFuncionarioTMODIFICARYROLptpPrimerApellido();
        String funcionarioTMODIFICARYROLptpSegundoApellido = request.getFuncionarioTMODIFICARYROLptpSegundoApellido();
        String funcionarioTMODIFICARYROLptpatrUsuarioLDAP = request.getFuncionarioTMODIFICARYROLptpatrUsuarioLDAP();
        String funcionarioTMODIFICARYROLptpatrEmail = request.getFuncionarioTMODIFICARYROLptpatrEmail();
        Rol funcionarioTMODIFICARYROLptNuevoRol = request.getFuncionarioTMODIFICARYROLptNuevoRolInstance();
        Regional funcionarioTMODIFICARYROLptpagrRegional = request.getFuncionarioTMODIFICARYROLptpagrRegionalInstance();
        Funcionario funcionarioTMODIFICARYROLpthisAgente = request.getFuncionarioTMODIFICARYROLpthisAgenteInstance();

        request.checkArguments();
        Funcionario instance = funcionarioTMODIFICARYROLpthisAgente;

        com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest();
        step1Request.setFuncionariomodificarpthisAdminInstance(funcionarioTMODIFICARYROLpthisAgente);
        step1Request.setFuncionariomodificarpPrimerNombre(funcionarioTMODIFICARYROLptpPrimerNombre);
        step1Request.setFuncionariomodificarpSegundoNombre(funcionarioTMODIFICARYROLptpSegundoNombre);
        step1Request.setFuncionariomodificarpPrimerApellido(funcionarioTMODIFICARYROLptpPrimerApellido);
        step1Request.setFuncionariomodificarpSegundoApellido(funcionarioTMODIFICARYROLptpSegundoApellido);
        step1Request.setFuncionariomodificarpUsuarioLDAP(funcionarioTMODIFICARYROLptpatrUsuarioLDAP);
        step1Request.setFuncionariomodificarpEmail(funcionarioTMODIFICARYROLptpatrEmail);
        funcionarioSrv.modificarImplementation(step1Request);

        /* Action 2: IF (Rol.Nombre = "ADMIN" AND ptNuevoRol.Nombre <> "ADMIN") */
        boolean ifCondition2 = (funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("ADMIN") && !(funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("ADMIN");
        if (ifCondition2) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAdminRequest step20Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAdminRequest();
            step20Request.setFuncionariodeshacerAdminpthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.deshacerAdminImplementation(step20Request);
        }

        /* Action 3: IF (Rol.Nombre = "SUPERADMIN" AND ptNuevoRol.Nombre <> "SUPERADMIN") */
        boolean ifCondition3 = (funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("SUPERADMIN") && !(funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("SUPERADMIN");
        if (ifCondition3) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerSuperAdminRequest step30Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerSuperAdminRequest();
            step30Request.setFuncionariodeshacerSuperAdminpthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.deshacerSuperAdminImplementation(step30Request);
        }

        /* Action 4: IF (Rol.Nombre = "AREAMEDICA" AND ptNuevoRol.Nombre <> "AREAMEDICA") */
        boolean ifCondition4 = (funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("AREAMEDICA") && !(funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("AREAMEDICA");
        if (ifCondition4) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAreaMedicaRequest step40Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAreaMedicaRequest();
            step40Request.setFuncionariodeshacerAreaMedicapthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.deshacerAreaMedicaImplementation(step40Request);
        }

        /* Action 5: IF (Rol.Nombre = "AFILIACIONES" AND ptNuevoRol.Nombre <> "AFILIACIONES") */
        boolean ifCondition5 = (funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("AFILIACIONES") && !(funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("AFILIACIONES");
        if (ifCondition5) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAfiliacionesRequest step50Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerAfiliacionesRequest();
            step50Request.setFuncionariodeshacerAfiliacionespthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.deshacerAfiliacionesImplementation(step50Request);
        }

        /* Action 6: IF (Rol.Nombre = "RESPREGIONAL" AND ptNuevoRol.Nombre <> "RESPREGIONAL") */
        boolean ifCondition6 = (funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("RESPREGIONAL") && !(funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("RESPREGIONAL");
        if (ifCondition6) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerRespRegionalRequest step60Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerRespRegionalRequest();
            step60Request.setFuncionariodeshacerRespRegionalpthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.deshacerRespRegionalImplementation(step60Request);
        }

        /* Action 7: IF (Rol.Nombre = "GESTOR" AND ptNuevoRol.Nombre <> "GESTOR") */
        boolean ifCondition7 = (funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("GESTOR") && !(funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("GESTOR");
        if (ifCondition7) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerGestorRequest step70Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerGestorRequest();
            step70Request.setFuncionariodeshacerGestorpthisFuncionarioInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.deshacerGestorImplementation(step70Request);
        }

        /* Action 8: IF (Rol.Nombre = "MESA DE APOYO" AND ptNuevoRol.Nombre <> "MESA DE APOYO") */
        boolean ifCondition8 = (funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("MESA DE APOYO") && !(funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("MESA DE APOYO");
        if (ifCondition8) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerMesaApoyoRequest step80Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DeshacerMesaApoyoRequest();
            step80Request.setFuncionariodeshacerMesaApoyopthisFuncionarioInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.deshacerMesaApoyoImplementation(step80Request);
        }

        /* Action 9: IF (Rol.Nombre <> "ADMIN" AND ptNuevoRol.Nombre = "ADMIN") */
        boolean ifCondition9 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("ADMIN") && (funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("ADMIN");
        if (ifCondition9) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAdminRequest step90Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAdminRequest();
            step90Request.setFuncionariohacerAdminpthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.hacerAdminImplementation(step90Request);
        }

        /* Action 10: IF (Rol.Nombre <> "SUPERADMIN" AND ptNuevoRol.Nombre = "SUPERADMIN") */
        boolean ifCondition10 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("SUPERADMIN") && (funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("SUPERADMIN");
        if (ifCondition10) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest step100Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerSuperAdminRequest();
            step100Request.setFuncionariohacerSuperAdminpthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.hacerSuperAdminImplementation(step100Request);
        }

        /* Action 11: IF (Rol.Nombre <> "AREAMEDICA" AND ptNuevoRol.Nombre = "AREAMEDICA") */
        boolean ifCondition11 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("AREAMEDICA") && (funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("AREAMEDICA");
        if (ifCondition11) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAreaMedicaRequest step110Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAreaMedicaRequest();
            step110Request.setFuncionariohacerAreaMedicapthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.hacerAreaMedicaImplementation(step110Request);
        }

        /* Action 12: IF (Rol.Nombre <> "AFILIACIONES" AND ptNuevoRol.Nombre = "AFILIACIONES") */
        boolean ifCondition12 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("AFILIACIONES") && (funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("AFILIACIONES");
        if (ifCondition12) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest step120Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAfiliacionesRequest();
            step120Request.setFuncionariohacerAfiliacionespthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.hacerAfiliacionesImplementation(step120Request);
        }

        /* Action 13: IF (Rol.Nombre <> "RESPREGIONAL" AND ptNuevoRol.Nombre = "RESPREGIONAL") */
        boolean ifCondition13 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("RESPREGIONAL") && (funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("RESPREGIONAL");
        if (ifCondition13) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerRespRegionalRequest step130Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerRespRegionalRequest();
            step130Request.setFuncionariohacerRespRegionalpthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            step130Request.setFuncionariohacerRespRegionalpagrRegionalInstance(funcionarioTMODIFICARYROLptpagrRegional);
            funcionarioSrv.hacerRespRegionalImplementation(step130Request);
        }

        /* Action 14: IF (Rol.Nombre <> "GESTOR" AND ptNuevoRol.Nombre = "GESTOR") */
        boolean ifCondition14 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("GESTOR") && (funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("GESTOR");
        if (ifCondition14) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerGestorRequest step140Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerGestorRequest();
            step140Request.setFuncionariohacerGestorpthisFuncionarioInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.hacerGestorImplementation(step140Request);
        }

        /* Action 15: IF (Rol.Nombre <> "MESA DE APOYO" AND ptNuevoRol.Nombre = "MESA DE APOYO") */
        boolean ifCondition15 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().getRolNombre()).equals("MESA DE APOYO") && (funcionarioTMODIFICARYROLptNuevoRol.getRolNombre()).equals("MESA DE APOYO");
        if (ifCondition15) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerMesaApoyoRequest step150Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerMesaApoyoRequest();
            step150Request.setFuncionariohacerMesaApoyopthisFuncionarioInstance(funcionarioTMODIFICARYROLpthisAgente);
            funcionarioSrv.hacerMesaApoyoImplementation(step150Request);
        }

        /* Action 16: IF (Rol <> ptNuevoRol) */
        boolean ifCondition16 = !(funcionarioTMODIFICARYROLpthisAgente.getRol().equalsObject(funcionarioTMODIFICARYROLptNuevoRol));
        if (ifCondition16) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest step160Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest();
            step160Request.setFuncionarioCambRolAgentepthisAgenteInstance(funcionarioTMODIFICARYROLpthisAgente);
            step160Request.setFuncionarioCambRolAgentepevcRolInstance(funcionarioTMODIFICARYROLptNuevoRol);
            funcionarioSrv.cambRolAgenteImplementation(step160Request, true);
        }

        com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest step17Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.SetIdSesionRequest();
        step17Request.setFuncionariosetIdSesionpthisFuncionarioInstance(funcionarioTMODIFICARYROLpthisAgente);
        funcionarioSrv.setIdSesionImplementation(step17Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: TCREARASESOR

    /*
     * Entry point for service TCREARASESOR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREARASESOR(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARASESORRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.tCREARASESORTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREARASESOR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREARASESORTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARASESORRequest request) throws ModelException {
        request.setFuncionarioTCREARASESORptpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getFuncionarioTCREARASESORptpagrSucursal()));
        request.setFuncionarioTCREARASESORptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFuncionarioTCREARASESORptpagrTipoIdentificacion()));
        return funcionarioSrv.tCREARASESORImplementation(request);
    }

    /*
     * Implements service TCREARASESOR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREARASESORImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCREARASESORRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Sucursal funcionarioTCREARASESORptpagrSucursal = request.getFuncionarioTCREARASESORptpagrSucursalInstance();
        String funcionarioTCREARASESORptpatrUsuario = request.getFuncionarioTCREARASESORptpatrUsuario();
        String funcionarioTCREARASESORptpatrPrimerNombre = request.getFuncionarioTCREARASESORptpatrPrimerNombre();
        String funcionarioTCREARASESORptpatrSegundoNombre = request.getFuncionarioTCREARASESORptpatrSegundoNombre();
        String funcionarioTCREARASESORptpatrPrimerApellido = request.getFuncionarioTCREARASESORptpatrPrimerApellido();
        String funcionarioTCREARASESORptpatrSegundoApellido = request.getFuncionarioTCREARASESORptpatrSegundoApellido();
        String funcionarioTCREARASESORptpatrEmail = request.getFuncionarioTCREARASESORptpatrEmail();
        TipoIdentificacion funcionarioTCREARASESORptpagrTipoIdentificacion = request.getFuncionarioTCREARASESORptpagrTipoIdentificacionInstance();
        String funcionarioTCREARASESORptpatrNumIdentificacion = request.getFuncionarioTCREARASESORptpatrNumIdentificacion();
        String funcionarioTCREARASESORptCargo = request.getFuncionarioTCREARASESORptCargo();
        String funcionarioTCREARASESORptCanal = request.getFuncionarioTCREARASESORptCanal();
        String funcionarioTCREARASESORptEstado = request.getFuncionarioTCREARASESORptEstado();
        String funcionarioTCREARASESORptpCodJefe = request.getFuncionarioTCREARASESORptpCodJefe();

        request.checkArguments();
        Funcionario instance;

        com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest();
        step1Request.setFuncionariocrearpagrRolInstance(userFunctionsSrv.fugetRolFun("ASESOR COMERCIAL"));
        step1Request.setFuncionariocrearpagrSucursalInstance(funcionarioTCREARASESORptpagrSucursal);
        step1Request.setFuncionariocrearpatrUsuario(funcionarioTCREARASESORptpatrUsuario);
        step1Request.setFuncionariocrearpatrPrimerNombre(funcionarioTCREARASESORptpatrPrimerNombre);
        step1Request.setFuncionariocrearpatrSegundoNombre(funcionarioTCREARASESORptpatrSegundoNombre);
        step1Request.setFuncionariocrearpatrPrimerApellido(funcionarioTCREARASESORptpatrPrimerApellido);
        step1Request.setFuncionariocrearpatrSegundoApellido(funcionarioTCREARASESORptpatrSegundoApellido);
        step1Request.setFuncionariocrearpatrUsuarioLDAP(null);
        step1Request.setFuncionariocrearpatrEmail(funcionarioTCREARASESORptpatrEmail);
        step1Request.setFuncionariocrearpatrManual(Boolean.FALSE);
        step1Request.setFuncionariocrearppassword("1");
        instance = (Funcionario) funcionarioSrv.crearImplementation(step1Request).getInstance();

        com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAsesorRequest step2Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAsesorRequest();
        step2Request.setFuncionariohacerAsesorpthisAgenteInstance(instance);
        step2Request.setFuncionariohacerAsesorpagrTipoIdentificacionInstance(funcionarioTCREARASESORptpagrTipoIdentificacion);
        step2Request.setFuncionariohacerAsesorpatrmodificaDirector(Boolean.FALSE);
        step2Request.setFuncionariohacerAsesorpatresDirector(Boolean.FALSE);
        step2Request.setFuncionariohacerAsesorpatrNumIdentificacion(funcionarioTCREARASESORptpatrNumIdentificacion);
        step2Request.setFuncionariohacerAsesorpatrModDBasicosPersona(Boolean.FALSE);
        step2Request.setFuncionariohacerAsesorpatrEsIntegral(Boolean.FALSE);
        step2Request.setFuncionariohacerAsesorpatrVerDBasicosPersona(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpatrVerDocIdentificacionPerso(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpatrVerContratoNovedad(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpatrCanalComercial(funcionarioTCREARASESORptCargo);
        step2Request.setFuncionariohacerAsesorpatrCargo(funcionarioTCREARASESORptCanal);
        step2Request.setFuncionariohacerAsesorpatrEstado(funcionarioTCREARASESORptEstado);
        step2Request.setFuncionariohacerAsesorpatrAccesoValidadorUsuarios(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpCodJefe(funcionarioTCREARASESORptpCodJefe);
        funcionarioSrv.hacerAsesorImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: TNEWASESORMANUAL

    /*
     * Entry point for service TNEWASESORMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse tNEWASESORMANUAL(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALRequest request) {
        com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse response = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse();
        try {
            response = funcionarioSrv.tNEWASESORMANUALTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEWASESORMANUAL
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse tNEWASESORMANUALTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALRequest request) throws ModelException {
        request.setFuncionarioTNEWASESORMANUALptpagrSucursalInstance(sucursalSrv.getByOIDWithHV(request.getFuncionarioTNEWASESORMANUALptpagrSucursal()));
        request.setFuncionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getFuncionarioTNEWASESORMANUALptpagrTipoIdentificacion()));
        return funcionarioSrv.tNEWASESORMANUALImplementation(request);
    }

    /*
     * Implements service TNEWASESORMANUAL
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse tNEWASESORMANUALImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALRequest request) throws ModelException {
        com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse response = new com.keralty.aeusuarios.viewmodel.funcionario.siu.TNEWASESORMANUALResponse();
        Sucursal funcionarioTNEWASESORMANUALptpagrSucursal = request.getFuncionarioTNEWASESORMANUALptpagrSucursalInstance();
        String funcionarioTNEWASESORMANUALptpatrUsuario = request.getFuncionarioTNEWASESORMANUALptpatrUsuario();
        String funcionarioTNEWASESORMANUALptpatrPrimerNombre = request.getFuncionarioTNEWASESORMANUALptpatrPrimerNombre();
        String funcionarioTNEWASESORMANUALptpatrSegundoNombre = request.getFuncionarioTNEWASESORMANUALptpatrSegundoNombre();
        String funcionarioTNEWASESORMANUALptpatrPrimerApellido = request.getFuncionarioTNEWASESORMANUALptpatrPrimerApellido();
        String funcionarioTNEWASESORMANUALptpatrSegundoApellido = request.getFuncionarioTNEWASESORMANUALptpatrSegundoApellido();
        String funcionarioTNEWASESORMANUALptpatrUsuarioLDAP = request.getFuncionarioTNEWASESORMANUALptpatrUsuarioLDAP();
        String funcionarioTNEWASESORMANUALptpatrEmail = request.getFuncionarioTNEWASESORMANUALptpatrEmail();
        TipoIdentificacion funcionarioTNEWASESORMANUALptpagrTipoIdentificacion = request.getFuncionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance();
        Boolean funcionarioTNEWASESORMANUALptpatrmodificaDirector = request.getFuncionarioTNEWASESORMANUALptpatrmodificaDirector();
        Boolean funcionarioTNEWASESORMANUALptpatresDirector = request.getFuncionarioTNEWASESORMANUALptpatresDirector();
        String funcionarioTNEWASESORMANUALptpatrNumIdentificacion = request.getFuncionarioTNEWASESORMANUALptpatrNumIdentificacion();
        Boolean funcionarioTNEWASESORMANUALptpatrModDBasicosPersona = request.getFuncionarioTNEWASESORMANUALptpatrModDBasicosPersona();
        String funcionarioTNEWASESORMANUALptpCodJefe = request.getFuncionarioTNEWASESORMANUALptpCodJefe();

        request.checkArguments();
        Funcionario instance;

        com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CrearRequest();
        step1Request.setFuncionariocrearpagrRolInstance(userFunctionsSrv.fugetRolFun("ASESOR COMERCIAL"));
        step1Request.setFuncionariocrearpagrSucursalInstance(funcionarioTNEWASESORMANUALptpagrSucursal);
        step1Request.setFuncionariocrearpatrUsuario(funcionarioTNEWASESORMANUALptpatrUsuario);
        step1Request.setFuncionariocrearpatrPrimerNombre(funcionarioTNEWASESORMANUALptpatrPrimerNombre);
        step1Request.setFuncionariocrearpatrSegundoNombre(funcionarioTNEWASESORMANUALptpatrSegundoNombre);
        step1Request.setFuncionariocrearpatrPrimerApellido(funcionarioTNEWASESORMANUALptpatrPrimerApellido);
        step1Request.setFuncionariocrearpatrSegundoApellido(funcionarioTNEWASESORMANUALptpatrSegundoApellido);
        step1Request.setFuncionariocrearpatrUsuarioLDAP(funcionarioTNEWASESORMANUALptpatrUsuarioLDAP);
        step1Request.setFuncionariocrearpatrEmail(funcionarioTNEWASESORMANUALptpatrEmail);
        step1Request.setFuncionariocrearpatrManual(Boolean.TRUE);
        step1Request.setFuncionariocrearppassword("1");
        instance = (Funcionario) funcionarioSrv.crearImplementation(step1Request).getInstance();

        com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAsesorRequest step2Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.HacerAsesorRequest();
        step2Request.setFuncionariohacerAsesorpthisAgenteInstance(instance);
        step2Request.setFuncionariohacerAsesorpagrTipoIdentificacionInstance(funcionarioTNEWASESORMANUALptpagrTipoIdentificacion);
        step2Request.setFuncionariohacerAsesorpatrmodificaDirector(funcionarioTNEWASESORMANUALptpatrmodificaDirector);
        step2Request.setFuncionariohacerAsesorpatresDirector(funcionarioTNEWASESORMANUALptpatresDirector);
        step2Request.setFuncionariohacerAsesorpatrNumIdentificacion(funcionarioTNEWASESORMANUALptpatrNumIdentificacion);
        step2Request.setFuncionariohacerAsesorpatrModDBasicosPersona(funcionarioTNEWASESORMANUALptpatrModDBasicosPersona);
        step2Request.setFuncionariohacerAsesorpatrEsIntegral(Boolean.FALSE);
        step2Request.setFuncionariohacerAsesorpatrVerDBasicosPersona(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpatrVerDocIdentificacionPerso(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpatrVerContratoNovedad(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpatrCanalComercial("");
        step2Request.setFuncionariohacerAsesorpatrCargo("");
        step2Request.setFuncionariohacerAsesorpatrEstado("");
        step2Request.setFuncionariohacerAsesorpatrAccesoValidadorUsuarios(Boolean.TRUE);
        step2Request.setFuncionariohacerAsesorpCodJefe(funcionarioTNEWASESORMANUALptpCodJefe);
        funcionarioSrv.hacerAsesorImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgente());

        // Value expressions for outgoing argument 'funcionarioTNEWASESORMANUALoaFuncionario'
        // DEFAULT  : THIS
        response.setFuncionarioTNEWASESORMANUALoaFuncionarioInstance(instance);


        return response;
    }

    // Service: TCAMBIARDISPONIBLE

    /*
     * Entry point for service TCAMBIARDISPONIBLE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCAMBIARDISPONIBLE(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCAMBIARDISPONIBLERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.tCAMBIARDISPONIBLETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCAMBIARDISPONIBLE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCAMBIARDISPONIBLETxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCAMBIARDISPONIBLERequest request) throws ModelException {
        request.setFuncionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioTCAMBIARDISPONIBLEpthisFuncionario()));
        return funcionarioSrv.tCAMBIARDISPONIBLEImplementation(request);
    }

    /*
     * Implements service TCAMBIARDISPONIBLE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCAMBIARDISPONIBLEImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TCAMBIARDISPONIBLERequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Boolean funcionarioTCAMBIARDISPONIBLEptpeDisponible = request.getFuncionarioTCAMBIARDISPONIBLEptpeDisponible();
        Funcionario funcionarioTCAMBIARDISPONIBLEpthisFuncionario = request.getFuncionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance();

        request.checkArguments();
        Funcionario instance = funcionarioTCAMBIARDISPONIBLEpthisFuncionario;

        com.keralty.aeusuarios.viewmodel.funcionario.siu.CambiarDisponibleRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambiarDisponibleRequest();
        step1Request.setFuncionariocambiarDisponiblepthisFuncionarioInstance(funcionarioTCAMBIARDISPONIBLEpthisFuncionario);
        step1Request.setFuncionariocambiarDisponiblepeDisponible(funcionarioTCAMBIARDISPONIBLEptpeDisponible);
        funcionarioSrv.cambiarDisponibleImplementation(step1Request);

        com.keralty.aeusuarios.viewmodel.logfuncionario.siu.TCREARRequest step2Request = new com.keralty.aeusuarios.viewmodel.logfuncionario.siu.TCREARRequest();
        step2Request.setLogFuncionarioTCREARptpagrFuncionarioInstance(funcionarioTCAMBIARDISPONIBLEpthisFuncionario);
        step2Request.setLogFuncionarioTCREARptpatrDisponible(funcionarioTCAMBIARDISPONIBLEpthisFuncionario.getFuncionarioDisponible());
        logFuncionarioSrv.tCREARImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    // Service: TBORRAR

    /*
     * Entry point for service TBORRAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tBORRAR(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TBORRARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.tBORRARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TBORRAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tBORRARTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TBORRARRequest request) throws ModelException, SystemException {
        request.setFuncionarioTBORRARpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioTBORRARpthisFuncionario()));
        return funcionarioSrv.tBORRARImplementation(request);
    }

    /*
     * Implements service TBORRAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tBORRARImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TBORRARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionarioTBORRARpthisFuncionario = request.getFuncionarioTBORRARpthisFuncionarioInstance();

        request.checkArguments();

        tBORRARPreconditions(request);
        Funcionario instance = funcionarioTBORRARpthisFuncionario;

        for(LogFuncionario step1Entity : repository.assocOperator001(funcionarioTBORRARpthisFuncionario)) {
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.EliminarRequest step1Request = new com.keralty.aeusuarios.viewmodel.logfuncionario.siu.EliminarRequest();
            step1Request.setLogFuncionarioeliminarpthisLogFuncoinarioInstance(step1Entity);
            logFuncionarioSrv.eliminarImplementation(step1Request);
        }

        com.keralty.aeusuarios.viewmodel.funcionario.siu.EliminarRequest step2Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.EliminarRequest();
        step2Request.setFuncionarioeliminarpthisAdminInstance(funcionarioTBORRARpthisFuncionario);
        funcionarioSrv.eliminarImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }

    /*
     * Checks service TBORRAR preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tBORRARCheckPreconditions(com.keralty.aeusuarios.viewmodel.funcionario.siu.TBORRARRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setFuncionarioTBORRARpthisFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionarioTBORRARpthisFuncionario()));
        try {
            if("Clas_1431626842112800Pre_9".equals(request.getPreconditionId()))
                checkClas1431626842112800Pre9(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tBORRARPreconditions(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TBORRARRequest request) 
            throws ModelException {
        checkClas1431626842112800Pre9(request);
    }

    private void checkClas1431626842112800Pre9 (
            com.keralty.aeusuarios.viewmodel.funcionario.siu.TBORRARRequest request) 
            throws ModelException {
        // Rol.Nombre = "GESTOR" OR Rol.Nombre = "MESA DE APOYO"

        Funcionario funcionarioTBORRARpthisFuncionario = request.getFuncionarioTBORRARpthisFuncionarioInstance();
        boolean preconditionHolds = (funcionarioTBORRARpthisFuncionario.getRol().getRolNombre()).equals("GESTOR") || (funcionarioTBORRARpthisFuncionario.getRol().getRolNombre()).equals("MESA DE APOYO");
        if (!preconditionHolds) throw new PreconditionException("Tan solo puede elimnarse los usuarios de los roles 'Gestor' y 'Mesa de apoyo'");
    }

    // Service: changePassword

    /*
     * Entry point for service changePassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse changePassword(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = funcionarioSrv.changePasswordTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service changePassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse changePasswordTxn(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ChangePasswordRequest request) throws ModelException {
        request.setFuncionariochangePasswordpthisAdminInstance(funcionarioSrv.getByOIDWithHV(request.getFuncionariochangePasswordpthisAdmin()));
        return funcionarioSrv.changePasswordImplementation(request);
    }

    /*
     * Implements service changePassword
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse changePasswordImplementation(
            com.keralty.aeusuarios.viewmodel.funcionario.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario funcionariochangePasswordpthisAdmin = request.getFuncionariochangePasswordpthisAdminInstance();
        String funcionariochangePasswordpOldPassword = request.getFuncionariochangePasswordpOldPassword();
        String funcionariochangePasswordpNewPassword = request.getFuncionariochangePasswordpNewPassword();

        request.checkArguments();
        Funcionario instance = funcionariochangePasswordpthisAdmin;
        if(!instance.getPassWord().equals(encrypt(funcionariochangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(funcionariochangePasswordpNewPassword));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgente());

        return response;
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(AsesorConstants.CLASS_NAME)) applyHVFilter4Asesor(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4Asesor(SQLSelect sql, SQLWhereDisjunction disjunction) {
        // agent = this OR Agent.Usuario = CodJefe
        Asesor agentInstance = getAgentAsesor();
    {
        // 'or' Logical operator
        SQLWhereDisjunction comparison1 = new SQLWhereDisjunction();
    
        // Operand 1
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandOVParameter operand113 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandThis operand224 = new SQLWhereOperandThis();
            comparison2.setSecondOperand(operand224);
            comparison1.addOperand(comparison2);
    
        // Operand 2
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            comparison4.setFirstOperand(new SQLWhereOperandLiteral(agentInstance.getFuncionarioUsuario(), Constants.Type.STRING.getTypeName()));
            
            // Operand 2
            SQLWhereOperandPathAttribute operand226 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
            comparison4.setSecondOperand(operand226);
            comparison1.addOperand(comparison4);
        
        disjunction.addOperand(comparison1);
    }

    }


    private void suppInfo4ICAgente(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereComparison comparison2 = new SQLWhereComparison(select);
            comparison2.setOperator("LIKE");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison2);

            SQLWhereComparison comparison3 = new SQLWhereComparison(select);
            comparison3.setOperator("LIKE");
            comparison3.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName()));
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison3);

            SQLWhereComparison comparison4 = new SQLWhereComparison(select);
            comparison4.setOperator("LIKE");
            comparison4.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName()));
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison4);

            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            conjunction.addDisjunction(disjunction);
            select.addConjunction(conjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }


    private void suppInfo4ICUsuarioLDAP(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereConjunction conjunction = new SQLWhereConjunction();
            conjunction.addDisjunction(disjunction);
            select.addConjunction(conjunction);
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(FuncionarioConstants.CLASS_NAME, FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildFuncionarioRelatedInstance(relatedInstanceJsonOid);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem) || AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_REPORTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4ReportesProcAlm(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4LogFuncionario(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4LogInformacionAsesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGHISTORICOPLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4LogHistoricoPlanes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFuncionarioRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildFuncionarioRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4ReportesProcAlm(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class)): ReportesProcAlm.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): GrupoAsignacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4LogFuncionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class)): LogFuncionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): AgentexProducto.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4LogInformacionAsesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class)): LogInformacionAsesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4LogHistoricoPlanes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class)): LogHistoricoPlanes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): Rol.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFuncionarioRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Regional(mapper.readValue(relatedInstanceJsonOid, RegionalOid.class)): Regional.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FuncionarioOid oid = new FuncionarioOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(FuncionarioService.class).error(e.getMessage());
        }
    }

}
