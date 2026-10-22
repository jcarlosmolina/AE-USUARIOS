package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.PreconditionException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;
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
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.repository.AsesorJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
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
public class AsesorService extends AbstractService {

    AsesorJpaRepository repository;

    TipoIdentificacionService tipoIdentificacionSrv;

    ContratoCService contratoCSrv;

    SucursalService sucursalSrv;

    RolService rolSrv;

    AgentexProductoService agentexProductoSrv;

    LogInformacionAsesorService logInformacionAsesorSrv;

    ProductosService productosSrv;

    LogHistoricoPlanesService logHistoricoPlanesSrv;

    SolicitudService solicitudSrv;

    ReportesProcAlmService reportesProcAlmSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    GrupoAsignacionService grupoAsignacionSrv;

    LogFuncionarioService logFuncionarioSrv;

    FirmaService firmaSrv;

    PlanesService planesSrv;

    RegionalService regionalSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public AsesorService(
            TipoIdentificacionService tipoIdentificacionSrv,
            ContratoCService contratoCSrv,
            SucursalService sucursalSrv,
            RolService rolSrv,
            AgentexProductoService agentexProductoSrv,
            LogInformacionAsesorService logInformacionAsesorSrv,
            ProductosService productosSrv,
            LogHistoricoPlanesService logHistoricoPlanesSrv,
            SolicitudService solicitudSrv,
            ReportesProcAlmService reportesProcAlmSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            GrupoAsignacionService grupoAsignacionSrv,
            LogFuncionarioService logFuncionarioSrv,
            FirmaService firmaSrv,
            PlanesService planesSrv,
            RegionalService regionalSrv,
            UserFunctions userFunctionsSrv,
            AsesorJpaRepository repository) {
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.contratoCSrv = contratoCSrv;
        this.sucursalSrv = sucursalSrv;
        this.rolSrv = rolSrv;
        this.agentexProductoSrv = agentexProductoSrv;
        this.logInformacionAsesorSrv = logInformacionAsesorSrv;
        this.productosSrv = productosSrv;
        this.logHistoricoPlanesSrv = logHistoricoPlanesSrv;
        this.solicitudSrv = solicitudSrv;
        this.reportesProcAlmSrv = reportesProcAlmSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.grupoAsignacionSrv = grupoAsignacionSrv;
        this.logFuncionarioSrv = logFuncionarioSrv;
        this.firmaSrv = firmaSrv;
        this.planesSrv = planesSrv;
        this.regionalSrv = regionalSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AsesorConstants.CLASS_NAME);
    }

    private List<Asesor> solveAsesorTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AsesorConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAsesorTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AsesorConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class Asesor
     *
     * @return Population of class Asesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Asesor> get() {
        List<Asesor> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Asesor
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Asesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Asesor> instances = get(queryRequest);
        if(AsesorConstants.DSICASESOR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICAsesor())).collect(Collectors.toList());
        }
        if(AsesorConstants.DSDSASESORPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAsesorPIU())).collect(Collectors.toList());
        }
        if(AsesorConstants.DSDSASESORIIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAsesorIIU())).collect(Collectors.toList());
        }
        if(AsesorConstants.DSDSASESORPIUMAESTROPRODUCTOS.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAsesorPIUMaestroProductos())).collect(Collectors.toList());
        }
        if(AsesorConstants.DSDSASESORNULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAsesorNull())).collect(Collectors.toList());
        }
        if(AsesorConstants.DSDSASESORMDIRECTORES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAsesorMDirectores())).collect(Collectors.toList());
        }
        if(AsesorConstants.DSDSDIRECTORESOBS.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDirectoresObs())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Asesor that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Asesor matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Asesor> get(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAsesorTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAsesorTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveAsesorTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveAsesorTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Asesor by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of Asesor
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Asesor getById(Long funcionarioId) {
        return getByOID(new AsesorOid(funcionarioId));
    }
    
    /*
     * Returns an instance of Asesor by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Asesor
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Asesor getByOID(AsesorOid oid) {
        Optional<Asesor> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Asesor by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Asesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Asesor getByOIDWithHV(AsesorOid oid) {
        Optional<Asesor> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Asesor> getInstanceByOid(AsesorOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }

    /*
     * Returns an instance of Asesor by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Asesor
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Asesor getByJsonOid(String jsonOid) {
        AsesorOid oid = new AsesorOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Asesor related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Asesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Asesor> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveAsesorTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Asesor related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Asesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Asesor> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Asesor
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Asesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getAsesorDynamic(AsesorOid oid, String displaySetItems) {
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
    public String getSuppInfo(AsesorOid oid, String dsName) {
        Asesor instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Asesor instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (AsesorConstants.DSICASESOR.equals(dsName))
            return instance.buildICAsesor();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Asesor instance, String dsName) {
        if (AsesorConstants.DSICASESOR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICAsesor());
        if (AsesorConstants.DSDSASESORPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAsesorPIU());
        if (AsesorConstants.DSDSASESORIIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAsesorIIU());
        if (AsesorConstants.DSDSASESORPIUMAESTROPRODUCTOS.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAsesorPIUMaestroProductos());
        if (AsesorConstants.DSDSASESORNULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAsesorNull());
        if (AsesorConstants.DSDSASESORMDIRECTORES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAsesorMDirectores());
        if (AsesorConstants.DSDSDIRECTORESOBS.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDirectoresObs());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (AsesorConstants.FILTER_NAME_FASESORES.equalsIgnoreCase(filterRequest.getName()))
            fAsesores(filterRequest, sql);
        if (AsesorConstants.FILTER_NAME_FDIRECTORES.equalsIgnoreCase(filterRequest.getName()))
            fDirectores(filterRequest, sql);
        if (AsesorConstants.FILTER_NAME_FASESORESAGENCIA.equalsIgnoreCase(filterRequest.getName()))
            fAsesoresAgencia(filterRequest, sql);
        if (AsesorConstants.FILTER_NAME_IFASESORPORUSUARIONOMANUAL.equalsIgnoreCase(filterRequest.getName()))
            iFAsesorPorUsuarioNoManual(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Clas_1431886233600794FiltNav_3".equalsIgnoreCase(filterRequest.getName()))
            clas1431886233600794FiltNav3(filterRequest, sql);
        if ("Ae_solicitudes_TNUEVAAFILIACION_pDirector_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431956094976663FiltNav6(sql);
        if ("Ae_solicitudes_TINCLUSIONSC_pDirector_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431956094976663FiltNav7(sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Asesor".equals(filterRequest.getName()))
            suppInfo4ICAsesor(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fAsesores(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vUsuario = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VUSUARIO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VUSUARIO, FilterVariableRequest.STRING) : null;
        String vPrimerNombre = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VPRIMERNOMBRE) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VPRIMERNOMBRE, FilterVariableRequest.STRING) : null;
        String vSegundoNombre = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VSEGUNDONOMBRE) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VSEGUNDONOMBRE, FilterVariableRequest.STRING) : null;
        String vPrimerApellido = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VPRIMERAPELLIDO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VPRIMERAPELLIDO, FilterVariableRequest.STRING) : null;
        String vSegundoApellido = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VSEGUNDOAPELLIDO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORES_VSEGUNDOAPELLIDO, FilterVariableRequest.STRING) : null;

        // Usuario = vUsuario
        if (vUsuario != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vUsuario, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // PrimerNombre LIKE vPrimerNombre
        if (vPrimerNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vPrimerNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // SegundoNombre LIKE vSegundoNombre
        if (vSegundoNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vSegundoNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // PrimerApellido LIKE vPrimerApellido
        if (vPrimerApellido != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vPrimerApellido, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // SegundoApellido LIKE vSegundoApellido
        if (vSegundoApellido != null) {
            // 'like' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vSegundoApellido, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        sql.addConjunction(conjunction);
    }

    private void fDirectores(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vUsuario = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VUSUARIO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VUSUARIO, FilterVariableRequest.STRING) : null;
        String vPrimerNombre = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VPRIMERNOMBRE) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VPRIMERNOMBRE, FilterVariableRequest.STRING) : null;
        String vSegundoNombre = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VSEGUNDONOMBRE) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VSEGUNDONOMBRE, FilterVariableRequest.STRING) : null;
        String vPrimerApellido = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VPRIMERAPELLIDO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VPRIMERAPELLIDO, FilterVariableRequest.STRING) : null;
        String vSegundoApellido = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VSEGUNDOAPELLIDO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FDIRECTORES_VSEGUNDOAPELLIDO, FilterVariableRequest.STRING) : null;

        // EsDirector = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.ATTR_NAME_ASESORESDIRECTOR, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);


        // Usuario = vUsuario
        if (vUsuario != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vUsuario, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // PrimerNombre LIKE vPrimerNombre
        if (vPrimerNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vPrimerNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // SegundoNombre LIKE vSegundoNombre
        if (vSegundoNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vSegundoNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // PrimerApellido LIKE vPrimerApellido
        if (vPrimerApellido != null) {
            // 'like' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vPrimerApellido, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // SegundoApellido LIKE vSegundoApellido
        if (vSegundoApellido != null) {
            // 'like' Comparison
            SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
            comparison6.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison6.setFirstOperand(operand117);
            
            // Operand 2
            comparison6.setSecondOperand(new SQLWhereOperandLiteral(vSegundoApellido, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison6);

        }        

        sql.addConjunction(conjunction);
    }

    private void fAsesoresAgencia(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vUsuario = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VUSUARIO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VUSUARIO, FilterVariableRequest.STRING) : null;
        String vPrimerNombre = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VPRIMERNOMBRE) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VPRIMERNOMBRE, FilterVariableRequest.STRING) : null;
        String vSegundoNombre = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VSEGUNDONOMBRE) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VSEGUNDONOMBRE, FilterVariableRequest.STRING) : null;
        String vPrimerApellido = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VPRIMERAPELLIDO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VPRIMERAPELLIDO, FilterVariableRequest.STRING) : null;
        String vSegundoApellido = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VSEGUNDOAPELLIDO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_FASESORESAGENCIA_VSEGUNDOAPELLIDO, FilterVariableRequest.STRING) : null;

        // Manual = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);


        // Usuario = vUsuario
        if (vUsuario != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vUsuario, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // PrimerNombre LIKE vPrimerNombre
        if (vPrimerNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERNOMBRE, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vPrimerNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // SegundoNombre LIKE vSegundoNombre
        if (vSegundoNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDONOMBRE, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vSegundoNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // PrimerApellido LIKE vPrimerApellido
        if (vPrimerApellido != null) {
            // 'like' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOPRIMERAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vPrimerApellido, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // SegundoApellido LIKE vSegundoApellido
        if (vSegundoApellido != null) {
            // 'like' Comparison
            SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
            comparison6.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOSEGUNDOAPELLIDO, Constants.Type.STRING.getTypeName());
            comparison6.setFirstOperand(operand117);
            
            // Operand 2
            comparison6.setSecondOperand(new SQLWhereOperandLiteral(vSegundoApellido, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison6);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFAsesorPorUsuarioNoManual(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfUsuario = filterRequest.hasFilterVariable(AsesorConstants.VAR_NAME_IFASESORPORUSUARIONOMANUAL_VFUSUARIO) ? (String) filterRequest.getFilterVariable(AsesorConstants.VAR_NAME_IFASESORPORUSUARIONOMANUAL_VFUSUARIO, FilterVariableRequest.STRING) : null;

        // Usuario = vfUsuario
        if (vfUsuario != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfUsuario, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // Manual = false
        // '=' Comparison
        SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
        comparison2.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
        comparison2.setFirstOperand(operand113);
        
        // Operand 2
        comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison2);


        sql.addConjunction(conjunction);
    }

    private void clas1431886233600794FiltNav3(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Asesor selectedObject = filterRequest.hasFilterVariable(Constants.SELECTEDOBJECT) ? new Asesor(new AsesorOid().fromJsonString(filterRequest.getFilterVariable(Constants.SELECTEDOBJECT).toString())) : null;

        // CodJefe = SelectedObject.Usuario
        if (selectedObject != null) {
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(selectedObject.getFuncionarioUsuario(), Constants.Type.STRING.getTypeName()));
        conjunction.addOperand(comparison1);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431956094976663FiltNav6(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // esDirector = true
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.ATTR_NAME_ASESORESDIRECTOR, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431956094976663FiltNav7(SQLSelect sql) {
        clas1431956094976663FiltNav6(sql);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class Asesor with displayset DSAsesorIIU for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Asesor with displayset DSAsesorIIU
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorIIU iIUAsesor(AsesorOid oid) {
        return new com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorIIU(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Asesor with displayset DSAsesorPIUMaestroProductos for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Asesor with displayset DSAsesorPIUMaestroProductos
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIUMaestroProductos iIUAsesorProductos(AsesorOid oid) {
        return new com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIUMaestroProductos(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUAsesor
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Asesor using displayset DSAsesorPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIU> piuPIUAsesor(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAsesor
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAsesor
     */
    public int getCount4PIUAsesor(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUAsesorDetalle
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Asesor using displayset DSAsesorPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIU> piuPIUAsesorDetalle(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAsesorDetalle
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAsesorDetalle
     */
    public int getCount4PIUAsesorDetalle(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUDirectores
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Asesor using displayset DSAsesorMDirectores that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorMDirectores> piuPIUDirectores(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorMDirectores::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDirectores
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDirectores
     */
    public int getCount4PIUDirectores(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUAsesoresDeAgencia
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Asesor using displayset DSAsesorPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIU> piuPIUAsesoresDeAgencia(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAsesoresDeAgencia
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAsesoresDeAgencia
     */
    public int getCount4PIUAsesoresDeAgencia(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUAsesorNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Asesor using displayset DSAsesorNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorNull> piuPIUAsesorNull(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAsesorNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAsesorNull
     */
    public int getCount4PIUAsesorNull(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUDirectoresObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Asesor using displayset DSDirectoresObs that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.asesor.ds.DSDirectoresObs> piuPIUDirectoresObs(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.asesor.ds.DSDirectoresObs::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDirectoresObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDirectoresObs
     */
    public int getCount4PIUDirectoresObs(QueryRequest queryRequest) {
        return solveAsesorTypedQuery(queryRequest).size();
    }

    // Service: sincronizar

    /*
     * Entry point for service sincronizar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse sincronizar(
            com.keralty.aeusuarios.viewmodel.asesor.siu.SincronizarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.sincronizarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service sincronizar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse sincronizarTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.SincronizarRequest request) throws ModelException {
        request.setAsesorsincronizarpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorsincronizarpthisAsesor()));
        return asesorSrv.sincronizarImplementation(request);
    }

    /*
     * Implements service sincronizar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse sincronizarImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.SincronizarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesorsincronizarpthisAsesor = request.getAsesorsincronizarpthisAsesorInstance();
        String asesorsincronizarpCodDirector = request.getAsesorsincronizarpCodDirector();
        String asesorsincronizarpNumIdentificacion = request.getAsesorsincronizarpNumIdentificacion();
        String asesorsincronizarpCanal = request.getAsesorsincronizarpCanal();
        String asesorsincronizarpCargo = request.getAsesorsincronizarpCargo();
        String asesorsincronizarpEstado = request.getAsesorsincronizarpEstado();

        request.checkArguments();
        Asesor instance = asesorsincronizarpthisAsesor;
        instance.setFuncionarioCodJefe(asesorsincronizarpCodDirector);
        instance.setAsesorNumIdentificacion(asesorsincronizarpNumIdentificacion);
        instance.setAsesorCanalComercial(asesorsincronizarpCanal);
        instance.setAsesorCargo(asesorsincronizarpCargo);
        instance.setAsesorEstado(asesorsincronizarpEstado);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: modificarAsesor

    /*
     * Entry point for service modificarAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificarAsesor(
            com.keralty.aeusuarios.viewmodel.asesor.siu.ModificarAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.modificarAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificarAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarAsesorTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.ModificarAsesorRequest request) throws ModelException {
        request.setAsesormodificarAsesorpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesormodificarAsesorpthisAsesor()));
        return asesorSrv.modificarAsesorImplementation(request);
    }

    /*
     * Implements service modificarAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarAsesorImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.ModificarAsesorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesormodificarAsesorpthisAsesor = request.getAsesormodificarAsesorpthisAsesorInstance();
        String asesormodificarAsesorptUsuarioLDAP = request.getAsesormodificarAsesorptUsuarioLDAP();
        String asesormodificarAsesorptEmail = request.getAsesormodificarAsesorptEmail();
        Boolean asesormodificarAsesorpModDBasicosPersona = request.getAsesormodificarAsesorpModDBasicosPersona();
        Boolean asesormodificarAsesorpModificaDirector = request.getAsesormodificarAsesorpModificaDirector();
        String asesormodificarAsesorptNumIdentificacion = request.getAsesormodificarAsesorptNumIdentificacion();
        Boolean asesormodificarAsesorpeIntegral = request.getAsesormodificarAsesorpeIntegral();
        Boolean asesormodificarAsesorpeValidadorUsuarios = request.getAsesormodificarAsesorpeValidadorUsuarios();

        request.checkArguments();
        Asesor instance = asesormodificarAsesorpthisAsesor;
        instance.setFuncionarioUsuarioLDAP(asesormodificarAsesorptUsuarioLDAP);
        instance.setFuncionarioEmail(asesormodificarAsesorptEmail);
        instance.setAsesorModDBasicosPersona(asesormodificarAsesorpModDBasicosPersona);
        instance.setAsesormodificaDirector(asesormodificarAsesorpModificaDirector);
        instance.setAsesorNumIdentificacion(asesormodificarAsesorptNumIdentificacion);
        instance.setAsesorEsIntegral(asesormodificarAsesorpeIntegral);
        instance.setAsesorAccesoValidadorUsuarios(asesormodificarAsesorpeValidadorUsuarios);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: InsTipoIdentificacionAsesor

    /*
     * Entry point for service InsTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insTipoIdentificacionAsesor(
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.insTipoIdentificacionAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insTipoIdentificacionAsesorTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest request) throws ModelException {
        request.setAsesorInsTipoIdentificacionAsesorpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorInsTipoIdentificacionAsesorpthisAsesor()));
        request.setAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacion()));
        return asesorSrv.insTipoIdentificacionAsesorImplementation(request, true);
    }

    /*
     * Implements service InsTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insTipoIdentificacionAsesorImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesorInsTipoIdentificacionAsesorpthisAsesor = request.getAsesorInsTipoIdentificacionAsesorpthisAsesorInstance();
        TipoIdentificacion asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion = request.getAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance();

        request.checkArguments();
        Asesor instance = asesorInsTipoIdentificacionAsesorpthisAsesor;

        instance.add2TipoIdentificacion(asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionAsesorRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.InsTipoIdentificacionAsesorRequest();
            relatedRequest.setTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance(asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance(asesorInsTipoIdentificacionAsesorpthisAsesor);
            tipoIdentificacionSrv.insTipoIdentificacionAsesorImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: DelTipoIdentificacionAsesor

    /*
     * Entry point for service DelTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delTipoIdentificacionAsesor(
            com.keralty.aeusuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.delTipoIdentificacionAsesorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delTipoIdentificacionAsesorTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest request) throws ModelException {
        request.setAsesorDelTipoIdentificacionAsesorpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorDelTipoIdentificacionAsesorpthisAsesor()));
        request.setAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacion()));
        return asesorSrv.delTipoIdentificacionAsesorImplementation(request, true);
    }

    /*
     * Implements service DelTipoIdentificacionAsesor
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delTipoIdentificacionAsesorImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesorDelTipoIdentificacionAsesorpthisAsesor = request.getAsesorDelTipoIdentificacionAsesorpthisAsesorInstance();
        TipoIdentificacion asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion = request.getAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance();

        request.checkArguments();
        Asesor instance = asesorDelTipoIdentificacionAsesorpthisAsesor;

        instance.add2TipoIdentificacion(null);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionAsesorRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu.DelTipoIdentificacionAsesorRequest();
            relatedRequest.setTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance(asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion);
            relatedRequest.setTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance(asesorDelTipoIdentificacionAsesorpthisAsesor);
            tipoIdentificacionSrv.delTipoIdentificacionAsesorImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: marcarEsDirector

    /*
     * Entry point for service marcarEsDirector
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse marcarEsDirector(
            com.keralty.aeusuarios.viewmodel.asesor.siu.MarcarEsDirectorRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.marcarEsDirectorTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service marcarEsDirector
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse marcarEsDirectorTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.MarcarEsDirectorRequest request) throws ModelException {
        request.setAsesormarcarEsDirectorpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesormarcarEsDirectorpthisAsesor()));
        return asesorSrv.marcarEsDirectorImplementation(request);
    }

    /*
     * Implements service marcarEsDirector
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse marcarEsDirectorImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.MarcarEsDirectorRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesormarcarEsDirectorpthisAsesor = request.getAsesormarcarEsDirectorpthisAsesorInstance();
        Boolean asesormarcarEsDirectorpEsDirector = request.getAsesormarcarEsDirectorpEsDirector();

        request.checkArguments();
        Asesor instance = asesormarcarEsDirectorpthisAsesor;
        instance.setAsesoresDirector(asesormarcarEsDirectorpEsDirector);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: InsAsesorC

    /*
     * Entry point for service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insAsesorC(
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsAsesorCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.insAsesorCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insAsesorCTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsAsesorCRequest request) throws ModelException {
        request.setAsesorInsAsesorCpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorInsAsesorCpthisAsesor()));
        request.setAsesorInsAsesorCpevcContratoCInstance(contratoCSrv.getByOIDWithHV(request.getAsesorInsAsesorCpevcContratoC()));
        return asesorSrv.insAsesorCImplementation(request, true);
    }

    /*
     * Implements service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insAsesorCImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsAsesorCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesorInsAsesorCpthisAsesor = request.getAsesorInsAsesorCpthisAsesorInstance();
        ContratoC asesorInsAsesorCpevcContratoC = request.getAsesorInsAsesorCpevcContratoCInstance();

        request.checkArguments();
        Asesor instance = asesorInsAsesorCpthisAsesor;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.contratoc.siu.InsAsesorCRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.contratoc.siu.InsAsesorCRequest();
            relatedRequest.setContratoCInsAsesorCpthisContratoCInstance(asesorInsAsesorCpevcContratoC);
            relatedRequest.setContratoCInsAsesorCpevcAsesorInstance(asesorInsAsesorCpthisAsesor);
            contratoCSrv.insAsesorCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: DelAsesorC

    /*
     * Entry point for service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delAsesorC(
            com.keralty.aeusuarios.viewmodel.asesor.siu.DelAsesorCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.delAsesorCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delAsesorCTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.DelAsesorCRequest request) throws ModelException {
        request.setAsesorDelAsesorCpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorDelAsesorCpthisAsesor()));
        request.setAsesorDelAsesorCpevcContratoCInstance(contratoCSrv.getByOIDWithHV(request.getAsesorDelAsesorCpevcContratoC()));
        return asesorSrv.delAsesorCImplementation(request, true);
    }

    /*
     * Implements service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delAsesorCImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.DelAsesorCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesorDelAsesorCpthisAsesor = request.getAsesorDelAsesorCpthisAsesorInstance();
        ContratoC asesorDelAsesorCpevcContratoC = request.getAsesorDelAsesorCpevcContratoCInstance();

        request.checkArguments();
        Asesor instance = asesorDelAsesorCpthisAsesor;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.contratoc.siu.DelAsesorCRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.contratoc.siu.DelAsesorCRequest();
            relatedRequest.setContratoCDelAsesorCpthisContratoCInstance(asesorDelAsesorCpevcContratoC);
            relatedRequest.setContratoCDelAsesorCpevcAsesorInstance(asesorDelAsesorCpthisAsesor);
            contratoCSrv.delAsesorCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: modVisibilidad

    /*
     * Entry point for service modVisibilidad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modVisibilidad(
            com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.modVisibilidadTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modVisibilidad
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modVisibilidadTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest request) throws ModelException {
        request.setAsesormodVisibilidadpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesormodVisibilidadpthisAsesor()));
        return asesorSrv.modVisibilidadImplementation(request);
    }

    /*
     * Implements service modVisibilidad
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modVisibilidadImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesormodVisibilidadpthisAsesor = request.getAsesormodVisibilidadpthisAsesorInstance();
        Boolean asesormodVisibilidadpVerDatosPersona = request.getAsesormodVisibilidadpVerDatosPersona();
        Boolean asesormodVisibilidadpVerDocsPersona = request.getAsesormodVisibilidadpVerDocsPersona();
        Boolean asesormodVisibilidadpVerContratoNovedad = request.getAsesormodVisibilidadpVerContratoNovedad();

        request.checkArguments();
        Asesor instance = asesormodVisibilidadpthisAsesor;
        instance.setAsesorVerDBasicosPersona(asesormodVisibilidadpVerDatosPersona);
        instance.setAsesorVerDocIdentificacionPersona(asesormodVisibilidadpVerDocsPersona);
        instance.setAsesorVerContratoNovedad(asesormodVisibilidadpVerContratoNovedad);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: TSINCRONIZAR

    /*
     * Entry point for service TSINCRONIZAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tSINCRONIZAR(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TSINCRONIZARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tSINCRONIZARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TSINCRONIZAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tSINCRONIZARTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TSINCRONIZARRequest request) throws ModelException, SystemException {
        request.setAsesorTSINCRONIZARpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTSINCRONIZARpthisAsesor()));
        request.setAsesorTSINCRONIZARptpevcSucursalInstance(sucursalSrv.getByOIDWithHV(request.getAsesorTSINCRONIZARptpevcSucursal()));
        request.setAsesorTSINCRONIZARpTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getAsesorTSINCRONIZARpTipoIdentificacion()));
        return asesorSrv.tSINCRONIZARImplementation(request);
    }

    /*
     * Implements service TSINCRONIZAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tSINCRONIZARImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TSINCRONIZARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String asesorTSINCRONIZARpCodDirector = request.getAsesorTSINCRONIZARpCodDirector();
        String asesorTSINCRONIZARpNumIdentificacion = request.getAsesorTSINCRONIZARpNumIdentificacion();
        String asesorTSINCRONIZARptpCanal = request.getAsesorTSINCRONIZARptpCanal();
        String asesorTSINCRONIZARptpCargo = request.getAsesorTSINCRONIZARptpCargo();
        String asesorTSINCRONIZARptpEstado = request.getAsesorTSINCRONIZARptpEstado();
        String asesorTSINCRONIZARptpPrimerNombre = request.getAsesorTSINCRONIZARptpPrimerNombre();
        String asesorTSINCRONIZARptpSegundoNombre = request.getAsesorTSINCRONIZARptpSegundoNombre();
        String asesorTSINCRONIZARptpPrimerApellido = request.getAsesorTSINCRONIZARptpPrimerApellido();
        String asesorTSINCRONIZARptpSegundoApellido = request.getAsesorTSINCRONIZARptpSegundoApellido();
        Sucursal asesorTSINCRONIZARptpevcSucursal = request.getAsesorTSINCRONIZARptpevcSucursalInstance();
        TipoIdentificacion asesorTSINCRONIZARpTipoIdentificacion = request.getAsesorTSINCRONIZARpTipoIdentificacionInstance();
        Asesor asesorTSINCRONIZARpthisAsesor = request.getAsesorTSINCRONIZARpthisAsesorInstance();

        request.checkArguments();
        Asesor instance = asesorTSINCRONIZARpthisAsesor;

        com.keralty.aeusuarios.viewmodel.asesor.siu.SincronizarRequest step1Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.SincronizarRequest();
        step1Request.setAsesorsincronizarpthisAsesorInstance(asesorTSINCRONIZARpthisAsesor);
        step1Request.setAsesorsincronizarpCodDirector(asesorTSINCRONIZARpCodDirector);
        step1Request.setAsesorsincronizarpNumIdentificacion(asesorTSINCRONIZARpNumIdentificacion);
        step1Request.setAsesorsincronizarpCanal(asesorTSINCRONIZARptpCanal);
        step1Request.setAsesorsincronizarpCargo(asesorTSINCRONIZARptpCargo);
        step1Request.setAsesorsincronizarpEstado(asesorTSINCRONIZARptpEstado);
        asesorSrv.sincronizarImplementation(step1Request);

        com.keralty.aeusuarios.viewmodel.funcionario.siu.SincronizarAsesorRequest step2Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.SincronizarAsesorRequest();
        step2Request.setFuncionariosincronizarAsesorpthisAgenteInstance(asesorTSINCRONIZARpthisAsesor.getFuncionarioFacet());
        step2Request.setFuncionariosincronizarAsesorpPrimerNombre(asesorTSINCRONIZARptpPrimerNombre);
        step2Request.setFuncionariosincronizarAsesorpSegundoNombre(asesorTSINCRONIZARptpSegundoNombre);
        step2Request.setFuncionariosincronizarAsesorpPrimerApellido(asesorTSINCRONIZARptpPrimerApellido);
        step2Request.setFuncionariosincronizarAsesorpSegundoApellido(asesorTSINCRONIZARptpSegundoApellido);
        funcionarioSrv.sincronizarAsesorImplementation(step2Request);

        boolean guard3 = !(asesorTSINCRONIZARpthisAsesor.getSucursal().equalsObject(asesorTSINCRONIZARptpevcSucursal));

        if (guard3) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest step3Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest();
            step3Request.setFuncionarioCambSucursalAgentepthisAgenteInstance(asesorTSINCRONIZARpthisAsesor.getFuncionarioFacet());
            step3Request.setFuncionarioCambSucursalAgentepevcSucursalInstance(asesorTSINCRONIZARptpevcSucursal);
            funcionarioSrv.cambSucursalAgenteImplementation(step3Request, true);
        }

        /* Action 4: IF (TipoIdentificacion <> pTipoIdentificacion) */
        boolean ifCondition4 = !(asesorTSINCRONIZARpthisAsesor.getTipoIdentificacion().equalsObject(asesorTSINCRONIZARpTipoIdentificacion));
        if (ifCondition4) {
            /* Action 40: IF (EXIST (TipoIdentificacion) = true) */
            boolean ifCondition40 = repository.assocOperator002(asesorTSINCRONIZARpthisAsesor).equals(true);
            if (ifCondition40) {
                com.keralty.aeusuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest step400Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest();
                step400Request.setAsesorDelTipoIdentificacionAsesorpthisAsesorInstance(asesorTSINCRONIZARpthisAsesor);
                step400Request.setAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance(asesorTSINCRONIZARpthisAsesor.getTipoIdentificacion());
                asesorSrv.delTipoIdentificacionAsesorImplementation(step400Request, true);
            }
            /* Action 41: IF (pTipoIdentificacion <> NULL) */
            boolean ifCondition41 = (asesorTSINCRONIZARpTipoIdentificacion != null && !asesorTSINCRONIZARpTipoIdentificacion.isNull());
            if (ifCondition41) {
                com.keralty.aeusuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest step410Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest();
                step410Request.setAsesorInsTipoIdentificacionAsesorpthisAsesorInstance(asesorTSINCRONIZARpthisAsesor);
                step410Request.setAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance(asesorTSINCRONIZARpTipoIdentificacion);
                asesorSrv.insTipoIdentificacionAsesorImplementation(step410Request, true);
            }
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: TMODIFICARASESOR

    /*
     * Entry point for service TMODIFICARASESOR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICARASESOR(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tMODIFICARASESORTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICARASESOR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARASESORTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORRequest request) throws ModelException {
        request.setAsesorTMODIFICARASESORpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTMODIFICARASESORpthisAsesor()));
        return asesorSrv.tMODIFICARASESORImplementation(request);
    }

    /*
     * Implements service TMODIFICARASESOR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARASESORImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Boolean asesorTMODIFICARASESORptpVerDBasicosPersona = request.getAsesorTMODIFICARASESORptpVerDBasicosPersona();
        Boolean asesorTMODIFICARASESORptpVerDocsPersona = request.getAsesorTMODIFICARASESORptpVerDocsPersona();
        Boolean asesorTMODIFICARASESORptpVerContratoNovedad = request.getAsesorTMODIFICARASESORptpVerContratoNovedad();
        Boolean asesorTMODIFICARASESORptpModDBasicosPersona = request.getAsesorTMODIFICARASESORptpModDBasicosPersona();
        Boolean asesorTMODIFICARASESORpModificaDirector = request.getAsesorTMODIFICARASESORpModificaDirector();
        String asesorTMODIFICARASESORptUsuarioLDAP = request.getAsesorTMODIFICARASESORptUsuarioLDAP();
        String asesorTMODIFICARASESORptEmail = request.getAsesorTMODIFICARASESORptEmail();
        Boolean asesorTMODIFICARASESORpeIntegral = request.getAsesorTMODIFICARASESORpeIntegral();
        Asesor asesorTMODIFICARASESORpthisAsesor = request.getAsesorTMODIFICARASESORpthisAsesorInstance();

        request.checkArguments();
        Asesor instance = asesorTMODIFICARASESORpthisAsesor;

        com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest step1Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest();
        step1Request.setAsesorTLOGCAMBIOSpthisAsesorInstance(asesorTMODIFICARASESORpthisAsesor);
        step1Request.setAsesorTLOGCAMBIOSptpVerDatosPersona(asesorTMODIFICARASESORptpVerDBasicosPersona);
        step1Request.setAsesorTLOGCAMBIOSptpVerDocsPersona(asesorTMODIFICARASESORptpVerDocsPersona);
        step1Request.setAsesorTLOGCAMBIOSptpVerContratoNovedad(asesorTMODIFICARASESORptpVerContratoNovedad);
        step1Request.setAsesorTLOGCAMBIOSptAccesoValidador(asesorTMODIFICARASESORpthisAsesor.getAsesorAccesoValidadorUsuarios());
        asesorSrv.tLOGCAMBIOSImplementation(step1Request);

        com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest step2Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest();
        step2Request.setAsesormodVisibilidadpthisAsesorInstance(asesorTMODIFICARASESORpthisAsesor);
        step2Request.setAsesormodVisibilidadpVerDatosPersona(asesorTMODIFICARASESORptpVerDBasicosPersona);
        step2Request.setAsesormodVisibilidadpVerDocsPersona(asesorTMODIFICARASESORptpVerDocsPersona);
        step2Request.setAsesormodVisibilidadpVerContratoNovedad(asesorTMODIFICARASESORptpVerContratoNovedad);
        asesorSrv.modVisibilidadImplementation(step2Request);

        com.keralty.aeusuarios.viewmodel.asesor.siu.ModificarAsesorRequest step3Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.ModificarAsesorRequest();
        step3Request.setAsesormodificarAsesorpthisAsesorInstance(asesorTMODIFICARASESORpthisAsesor);
        step3Request.setAsesormodificarAsesorpModDBasicosPersona(asesorTMODIFICARASESORptpModDBasicosPersona);
        step3Request.setAsesormodificarAsesorpModificaDirector(asesorTMODIFICARASESORpModificaDirector);
        step3Request.setAsesormodificarAsesorptUsuarioLDAP(asesorTMODIFICARASESORptUsuarioLDAP);
        step3Request.setAsesormodificarAsesorptEmail(asesorTMODIFICARASESORptEmail);
        step3Request.setAsesormodificarAsesorptNumIdentificacion(asesorTMODIFICARASESORpthisAsesor.getAsesorNumIdentificacion());
        step3Request.setAsesormodificarAsesorpeIntegral(asesorTMODIFICARASESORpeIntegral);
        step3Request.setAsesormodificarAsesorpeValidadorUsuarios(asesorTMODIFICARASESORpthisAsesor.getAsesorAccesoValidadorUsuarios());
        asesorSrv.modificarAsesorImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: TPOSPROCESOSINC

    /*
     * Entry point for service TPOSPROCESOSINC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tPOSPROCESOSINC(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tPOSPROCESOSINCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TPOSPROCESOSINC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tPOSPROCESOSINCTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest request) throws ModelException {
        request.setAsesorTPOSPROCESOSINCpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTPOSPROCESOSINCpthisAsesor()));
        return asesorSrv.tPOSPROCESOSINCImplementation(request);
    }

    /*
     * Implements service TPOSPROCESOSINC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tPOSPROCESOSINCImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TPOSPROCESOSINCRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Boolean asesorTPOSPROCESOSINCpEsDirector = request.getAsesorTPOSPROCESOSINCpEsDirector();
        Asesor asesorTPOSPROCESOSINCpthisAsesor = request.getAsesorTPOSPROCESOSINCpthisAsesorInstance();

        request.checkArguments();
        Asesor instance = asesorTPOSPROCESOSINCpthisAsesor;

        /* Action 1: IF (pEsDirector = true) */
        boolean ifCondition1 = asesorTPOSPROCESOSINCpEsDirector.equals(true);
        if (ifCondition1) {
            /* Action 10: IF (Rol.Nombre <> "JEFEASESORES") */
            boolean ifCondition10 = !(asesorTPOSPROCESOSINCpthisAsesor.getRol().getRolNombre()).equals("JEFEASESORES");
            if (ifCondition10) {
                com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest step100Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest();
                step100Request.setFuncionarioCambRolAgentepthisAgenteInstance(asesorTPOSPROCESOSINCpthisAsesor.getFuncionarioFacet());
                step100Request.setFuncionarioCambRolAgentepevcRolInstance(userFunctionsSrv.fugetRolFun("JEFEASESORES"));
                funcionarioSrv.cambRolAgenteImplementation(step100Request, true);
            }
        } else {
            /* Action 11: IF (Rol.Nombre = "JEFEASESORES") */
            boolean ifCondition11 = (asesorTPOSPROCESOSINCpthisAsesor.getRol().getRolNombre()).equals("JEFEASESORES");
            if (ifCondition11) {
                com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest step110Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest();
                step110Request.setFuncionarioCambRolAgentepthisAgenteInstance(asesorTPOSPROCESOSINCpthisAsesor.getFuncionarioFacet());
                step110Request.setFuncionarioCambRolAgentepevcRolInstance(userFunctionsSrv.fugetRolFun("ASESOR"));
                funcionarioSrv.cambRolAgenteImplementation(step110Request, true);
            }
        }

        com.keralty.aeusuarios.viewmodel.asesor.siu.MarcarEsDirectorRequest step2Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.MarcarEsDirectorRequest();
        step2Request.setAsesormarcarEsDirectorpthisAsesorInstance(asesorTPOSPROCESOSINCpthisAsesor);
        step2Request.setAsesormarcarEsDirectorpEsDirector(asesorTPOSPROCESOSINCpEsDirector);
        asesorSrv.marcarEsDirectorImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: TMODIFICARASESORAGENCIA

    /*
     * Entry point for service TMODIFICARASESORAGENCIA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICARASESORAGENCIA(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORAGENCIARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tMODIFICARASESORAGENCIATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICARASESORAGENCIA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARASESORAGENCIATxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORAGENCIARequest request) throws ModelException, SystemException {
        request.setAsesorTMODIFICARASESORAGENCIApthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTMODIFICARASESORAGENCIApthisAsesor()));
        request.setAsesorTMODIFICARASESORAGENCIAptSucursalInstance(sucursalSrv.getByOIDWithHV(request.getAsesorTMODIFICARASESORAGENCIAptSucursal()));
        request.setAsesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance(tipoIdentificacionSrv.getByOIDWithHV(request.getAsesorTMODIFICARASESORAGENCIAptTipoIdentificacion()));
        return asesorSrv.tMODIFICARASESORAGENCIAImplementation(request);
    }

    /*
     * Implements service TMODIFICARASESORAGENCIA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARASESORAGENCIAImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORAGENCIARequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Boolean asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona = request.getAsesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona();
        Boolean asesorTMODIFICARASESORAGENCIAptpVerDocsPersona = request.getAsesorTMODIFICARASESORAGENCIAptpVerDocsPersona();
        Boolean asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad = request.getAsesorTMODIFICARASESORAGENCIAptpVerContratoNovedad();
        String asesorTMODIFICARASESORAGENCIAptpPrimerNombre = request.getAsesorTMODIFICARASESORAGENCIAptpPrimerNombre();
        String asesorTMODIFICARASESORAGENCIAptpSegundoNombre = request.getAsesorTMODIFICARASESORAGENCIAptpSegundoNombre();
        String asesorTMODIFICARASESORAGENCIAptpPrimerApellido = request.getAsesorTMODIFICARASESORAGENCIAptpPrimerApellido();
        String asesorTMODIFICARASESORAGENCIAptpSegundoApellido = request.getAsesorTMODIFICARASESORAGENCIAptpSegundoApellido();
        String asesorTMODIFICARASESORAGENCIAptUsuarioLDAP = request.getAsesorTMODIFICARASESORAGENCIAptUsuarioLDAP();
        String asesorTMODIFICARASESORAGENCIAptEmail = request.getAsesorTMODIFICARASESORAGENCIAptEmail();
        String asesorTMODIFICARASESORAGENCIAptpeNumUsuario = request.getAsesorTMODIFICARASESORAGENCIAptpeNumUsuario();
        String asesorTMODIFICARASESORAGENCIAptpeCodJefe = request.getAsesorTMODIFICARASESORAGENCIAptpeCodJefe();
        Boolean asesorTMODIFICARASESORAGENCIAptpModDBasicosPersona = request.getAsesorTMODIFICARASESORAGENCIAptpModDBasicosPersona();
        Boolean asesorTMODIFICARASESORAGENCIApModificaDirector = request.getAsesorTMODIFICARASESORAGENCIApModificaDirector();
        String asesorTMODIFICARASESORAGENCIAptNumIdentificacion = request.getAsesorTMODIFICARASESORAGENCIAptNumIdentificacion();
        Boolean asesorTMODIFICARASESORAGENCIAptpEsDirector = request.getAsesorTMODIFICARASESORAGENCIAptpEsDirector();
        Sucursal asesorTMODIFICARASESORAGENCIAptSucursal = request.getAsesorTMODIFICARASESORAGENCIAptSucursalInstance();
        TipoIdentificacion asesorTMODIFICARASESORAGENCIAptTipoIdentificacion = request.getAsesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance();
        Asesor asesorTMODIFICARASESORAGENCIApthisAsesor = request.getAsesorTMODIFICARASESORAGENCIApthisAsesorInstance();

        request.checkArguments();
        Asesor instance = asesorTMODIFICARASESORAGENCIApthisAsesor;

        com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest step1Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest();
        step1Request.setAsesorTLOGCAMBIOSpthisAsesorInstance(asesorTMODIFICARASESORAGENCIApthisAsesor);
        step1Request.setAsesorTLOGCAMBIOSptpVerDatosPersona(asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona);
        step1Request.setAsesorTLOGCAMBIOSptpVerDocsPersona(asesorTMODIFICARASESORAGENCIAptpVerDocsPersona);
        step1Request.setAsesorTLOGCAMBIOSptpVerContratoNovedad(asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad);
        step1Request.setAsesorTLOGCAMBIOSptAccesoValidador(asesorTMODIFICARASESORAGENCIApthisAsesor.getAsesorAccesoValidadorUsuarios());
        asesorSrv.tLOGCAMBIOSImplementation(step1Request);

        com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest step2Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest();
        step2Request.setAsesormodVisibilidadpthisAsesorInstance(asesorTMODIFICARASESORAGENCIApthisAsesor);
        step2Request.setAsesormodVisibilidadpVerDatosPersona(asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona);
        step2Request.setAsesormodVisibilidadpVerDocsPersona(asesorTMODIFICARASESORAGENCIAptpVerDocsPersona);
        step2Request.setAsesormodVisibilidadpVerContratoNovedad(asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad);
        asesorSrv.modVisibilidadImplementation(step2Request);

        com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest step3Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest();
        step3Request.setFuncionariomodificarpthisAdminInstance(asesorTMODIFICARASESORAGENCIApthisAsesor.getFuncionarioFacet());
        step3Request.setFuncionariomodificarpPrimerNombre(asesorTMODIFICARASESORAGENCIAptpPrimerNombre);
        step3Request.setFuncionariomodificarpSegundoNombre(asesorTMODIFICARASESORAGENCIAptpSegundoNombre);
        step3Request.setFuncionariomodificarpPrimerApellido(asesorTMODIFICARASESORAGENCIAptpPrimerApellido);
        step3Request.setFuncionariomodificarpSegundoApellido(asesorTMODIFICARASESORAGENCIAptpSegundoApellido);
        step3Request.setFuncionariomodificarpUsuarioLDAP(asesorTMODIFICARASESORAGENCIAptUsuarioLDAP);
        step3Request.setFuncionariomodificarpEmail(asesorTMODIFICARASESORAGENCIAptEmail);
        funcionarioSrv.modificarImplementation(step3Request);

        com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest step4Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.ModAsesorAgenciaRequest();
        step4Request.setFuncionariomodAsesorAgenciapthisFuncionarioInstance(asesorTMODIFICARASESORAGENCIApthisAsesor.getFuncionarioFacet());
        step4Request.setFuncionariomodAsesorAgenciapeNumUsuario(asesorTMODIFICARASESORAGENCIAptpeNumUsuario);
        step4Request.setFuncionariomodAsesorAgenciapeCodJefe(asesorTMODIFICARASESORAGENCIAptpeCodJefe);
        funcionarioSrv.modAsesorAgenciaImplementation(step4Request);

        com.keralty.aeusuarios.viewmodel.asesor.siu.ModificarAsesorRequest step5Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.ModificarAsesorRequest();
        step5Request.setAsesormodificarAsesorpthisAsesorInstance(asesorTMODIFICARASESORAGENCIApthisAsesor);
        step5Request.setAsesormodificarAsesorpModDBasicosPersona(asesorTMODIFICARASESORAGENCIAptpModDBasicosPersona);
        step5Request.setAsesormodificarAsesorpModificaDirector(asesorTMODIFICARASESORAGENCIApModificaDirector);
        step5Request.setAsesormodificarAsesorptUsuarioLDAP(asesorTMODIFICARASESORAGENCIAptUsuarioLDAP);
        step5Request.setAsesormodificarAsesorptEmail(asesorTMODIFICARASESORAGENCIAptEmail);
        step5Request.setAsesormodificarAsesorptNumIdentificacion(asesorTMODIFICARASESORAGENCIAptNumIdentificacion);
        step5Request.setAsesormodificarAsesorpeIntegral(asesorTMODIFICARASESORAGENCIApthisAsesor.getAsesorEsIntegral());
        step5Request.setAsesormodificarAsesorpeValidadorUsuarios(asesorTMODIFICARASESORAGENCIApthisAsesor.getAsesorAccesoValidadorUsuarios());
        asesorSrv.modificarAsesorImplementation(step5Request);

        com.keralty.aeusuarios.viewmodel.asesor.siu.MarcarEsDirectorRequest step6Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.MarcarEsDirectorRequest();
        step6Request.setAsesormarcarEsDirectorpthisAsesorInstance(asesorTMODIFICARASESORAGENCIApthisAsesor);
        step6Request.setAsesormarcarEsDirectorpEsDirector(asesorTMODIFICARASESORAGENCIAptpEsDirector);
        asesorSrv.marcarEsDirectorImplementation(step6Request);

        /* Action 7: IF (Sucursal <> ptSucursal) */
        boolean ifCondition7 = !(asesorTMODIFICARASESORAGENCIApthisAsesor.getSucursal().equalsObject(asesorTMODIFICARASESORAGENCIAptSucursal));
        if (ifCondition7) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest step70Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest();
            step70Request.setFuncionarioCambSucursalAgentepthisAgenteInstance(asesorTMODIFICARASESORAGENCIApthisAsesor.getFuncionarioFacet());
            step70Request.setFuncionarioCambSucursalAgentepevcSucursalInstance(asesorTMODIFICARASESORAGENCIAptSucursal);
            funcionarioSrv.cambSucursalAgenteImplementation(step70Request, true);
        }

        /* Action 8: IF (TipoIdentificacion <> ptTipoIdentificacion) */
        boolean ifCondition8 = !(asesorTMODIFICARASESORAGENCIApthisAsesor.getTipoIdentificacion().equalsObject(asesorTMODIFICARASESORAGENCIAptTipoIdentificacion));
        if (ifCondition8) {
            /* Action 80: IF (EXIST (TipoIdentificacion) = true) */
            boolean ifCondition80 = repository.assocOperator004(asesorTMODIFICARASESORAGENCIApthisAsesor).equals(true);
            if (ifCondition80) {
                com.keralty.aeusuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest step800Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.DelTipoIdentificacionAsesorRequest();
                step800Request.setAsesorDelTipoIdentificacionAsesorpthisAsesorInstance(asesorTMODIFICARASESORAGENCIApthisAsesor);
                step800Request.setAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance(asesorTMODIFICARASESORAGENCIApthisAsesor.getTipoIdentificacion());
                asesorSrv.delTipoIdentificacionAsesorImplementation(step800Request, true);
            }
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest step81Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.InsTipoIdentificacionAsesorRequest();
            step81Request.setAsesorInsTipoIdentificacionAsesorpthisAsesorInstance(asesorTMODIFICARASESORAGENCIApthisAsesor);
            step81Request.setAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance(asesorTMODIFICARASESORAGENCIAptTipoIdentificacion);
            asesorSrv.insTipoIdentificacionAsesorImplementation(step81Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: TDELETE

    /*
     * Entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tDELETE(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tDELETETxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tDELETETxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest request) throws ModelException, SystemException {
        request.setAsesorTDELETEpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTDELETEpthisAsesor()));
        return asesorSrv.tDELETEImplementation(request);
    }

    /*
     * Implements service TDELETE
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tDELETEImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesorTDELETEpthisAsesor = request.getAsesorTDELETEpthisAsesorInstance();

        request.checkArguments();

        tDELETEPreconditions(request);
        Asesor instance = asesorTDELETEpthisAsesor;

        for(AgentexProducto step1Entity : repository.assocOperator005(asesorTDELETEpthisAsesor)) {
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.EliminarRequest step1Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.EliminarRequest();
            step1Request.setAgentexProductoeliminarpthisAgentexProductoInstance(step1Entity);
            agentexProductoSrv.eliminarImplementation(step1Request);
        }

        for(LogInformacionAsesor step2Entity : repository.assocOperator006(asesorTDELETEpthisAsesor)) {
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.EliminarRequest step2Request = new com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.EliminarRequest();
            step2Request.setLogInformacionAsesoreliminarpthisLogInformacionAsesorInstance(step2Entity);
            logInformacionAsesorSrv.eliminarImplementation(step2Request);
        }

        com.keralty.aeusuarios.viewmodel.funcionario.siu.EliminarRequest step3Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.EliminarRequest();
        step3Request.setFuncionarioeliminarpthisAdminInstance(asesorTDELETEpthisAsesor.getFuncionarioFacet());
        funcionarioSrv.eliminarImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    /*
     * Checks service TDELETE preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tDELETECheckPreconditions(com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setAsesorTDELETEpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTDELETEpthisAsesor()));
        try {
            if("Clas_1431886233600794Pre_1".equals(request.getPreconditionId()))
                checkClas1431886233600794Pre1(request);
            if("Clas_1431886233600794Pre_2".equals(request.getPreconditionId()))
                checkClas1431886233600794Pre2(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tDELETEPreconditions(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest request) 
            throws ModelException {
        checkClas1431886233600794Pre1(request);
        checkClas1431886233600794Pre2(request);
    }

    private void checkClas1431886233600794Pre1 (
            com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest request) 
            throws ModelException {
        // Manual = TRUE

        Asesor asesorTDELETEpthisAsesor = request.getAsesorTDELETEpthisAsesorInstance();
        boolean preconditionHolds = asesorTDELETEpthisAsesor.getFuncionarioManual().equals(true);
        if (!preconditionHolds) throw new PreconditionException("Tan solo puede eliminarse los Asesores de Agencia");
    }

    private void checkClas1431886233600794Pre2 (
            com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest request) 
            throws ModelException {
        // COUNT( Solicitudes ) = 0

        Asesor asesorTDELETEpthisAsesor = request.getAsesorTDELETEpthisAsesorInstance();
        try {
            boolean preconditionHolds = (repository.assocOperator000(asesorTDELETEpthisAsesor)).equals(Long.valueOf(0));
            if (!preconditionHolds) throw new PreconditionException("El Asesor tiene solicitudes asociadas. No puede eliminarse");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: TMODVISIBILIDAD

    /*
     * Entry point for service TMODVISIBILIDAD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODVISIBILIDAD(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODVISIBILIDADRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tMODVISIBILIDADTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODVISIBILIDAD
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODVISIBILIDADTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODVISIBILIDADRequest request) throws ModelException {
        request.setAsesorTMODVISIBILIDADpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTMODVISIBILIDADpthisAsesor()));
        return asesorSrv.tMODVISIBILIDADImplementation(request);
    }

    /*
     * Implements service TMODVISIBILIDAD
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODVISIBILIDADImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TMODVISIBILIDADRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Boolean asesorTMODVISIBILIDADptpVerDatosPersona = request.getAsesorTMODVISIBILIDADptpVerDatosPersona();
        Boolean asesorTMODVISIBILIDADptpVerDocsPersona = request.getAsesorTMODVISIBILIDADptpVerDocsPersona();
        Boolean asesorTMODVISIBILIDADptpVerContratoNovedad = request.getAsesorTMODVISIBILIDADptpVerContratoNovedad();
        Asesor asesorTMODVISIBILIDADpthisAsesor = request.getAsesorTMODVISIBILIDADpthisAsesorInstance();

        request.checkArguments();
        Asesor instance = asesorTMODVISIBILIDADpthisAsesor;

        com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest step1Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest();
        step1Request.setAsesorTLOGCAMBIOSpthisAsesorInstance(asesorTMODVISIBILIDADpthisAsesor);
        step1Request.setAsesorTLOGCAMBIOSptpVerDatosPersona(asesorTMODVISIBILIDADptpVerDatosPersona);
        step1Request.setAsesorTLOGCAMBIOSptpVerDocsPersona(asesorTMODVISIBILIDADptpVerDocsPersona);
        step1Request.setAsesorTLOGCAMBIOSptpVerContratoNovedad(asesorTMODVISIBILIDADptpVerContratoNovedad);
        step1Request.setAsesorTLOGCAMBIOSptAccesoValidador(asesorTMODVISIBILIDADpthisAsesor.getAsesorAccesoValidadorUsuarios());
        asesorSrv.tLOGCAMBIOSImplementation(step1Request);

        com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest step2Request = new com.keralty.aeusuarios.viewmodel.asesor.siu.ModVisibilidadRequest();
        step2Request.setAsesormodVisibilidadpthisAsesorInstance(asesorTMODVISIBILIDADpthisAsesor);
        step2Request.setAsesormodVisibilidadpVerDatosPersona(asesorTMODVISIBILIDADptpVerDatosPersona);
        step2Request.setAsesormodVisibilidadpVerDocsPersona(asesorTMODVISIBILIDADptpVerDocsPersona);
        step2Request.setAsesormodVisibilidadpVerContratoNovedad(asesorTMODVISIBILIDADptpVerContratoNovedad);
        asesorSrv.modVisibilidadImplementation(step2Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: TCARGARDOMINIOPLAN

    /*
     * Entry point for service TCARGARDOMINIOPLAN
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCARGARDOMINIOPLAN(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TCARGARDOMINIOPLANRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tCARGARDOMINIOPLANTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCARGARDOMINIOPLAN
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCARGARDOMINIOPLANTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TCARGARDOMINIOPLANRequest request) throws ModelException, SystemException {
        request.setAsesorTCARGARDOMINIOPLANpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTCARGARDOMINIOPLANpthisAsesor()));
        return asesorSrv.tCARGARDOMINIOPLANImplementation(request);
    }

    /*
     * Implements service TCARGARDOMINIOPLAN
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCARGARDOMINIOPLANImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TCARGARDOMINIOPLANRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String asesorTCARGARDOMINIOPLANptCodLegalProducto = request.getAsesorTCARGARDOMINIOPLANptCodLegalProducto();
        String asesorTCARGARDOMINIOPLANptCodLegalPlan = request.getAsesorTCARGARDOMINIOPLANptCodLegalPlan();
        String asesorTCARGARDOMINIOPLANptAccion = request.getAsesorTCARGARDOMINIOPLANptAccion();
        Asesor asesorTCARGARDOMINIOPLANpthisAsesor = request.getAsesorTCARGARDOMINIOPLANpthisAsesorInstance();

        request.checkArguments();
        Asesor instance = asesorTCARGARDOMINIOPLANpthisAsesor;

        for(AgentexProducto step1Entity : repository.assocOperator007(asesorTCARGARDOMINIOPLANpthisAsesor, asesorTCARGARDOMINIOPLANptCodLegalProducto)) {
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCARGARDOMINIOPLANRequest step1Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCARGARDOMINIOPLANRequest();
            step1Request.setAgentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance(step1Entity);
            step1Request.setAgentexProductoTCARGARDOMINIOPLANptCodLegalPlan(asesorTCARGARDOMINIOPLANptCodLegalPlan);
            step1Request.setAgentexProductoTCARGARDOMINIOPLANptAccion(asesorTCARGARDOMINIOPLANptAccion);
            agentexProductoSrv.tCARGARDOMINIOPLANImplementation(step1Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: TLOGCAMBIOS

    /*
     * Entry point for service TLOGCAMBIOS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tLOGCAMBIOS(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.tLOGCAMBIOSTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TLOGCAMBIOS
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tLOGCAMBIOSTxn(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest request) throws ModelException {
        request.setAsesorTLOGCAMBIOSpthisAsesorInstance(asesorSrv.getByOIDWithHV(request.getAsesorTLOGCAMBIOSpthisAsesor()));
        return asesorSrv.tLOGCAMBIOSImplementation(request);
    }

    /*
     * Implements service TLOGCAMBIOS
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tLOGCAMBIOSImplementation(
            com.keralty.aeusuarios.viewmodel.asesor.siu.TLOGCAMBIOSRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Boolean asesorTLOGCAMBIOSptpVerDatosPersona = request.getAsesorTLOGCAMBIOSptpVerDatosPersona();
        Boolean asesorTLOGCAMBIOSptpVerDocsPersona = request.getAsesorTLOGCAMBIOSptpVerDocsPersona();
        Boolean asesorTLOGCAMBIOSptpVerContratoNovedad = request.getAsesorTLOGCAMBIOSptpVerContratoNovedad();
        Boolean asesorTLOGCAMBIOSptAccesoValidador = request.getAsesorTLOGCAMBIOSptAccesoValidador();
        Asesor asesorTLOGCAMBIOSpthisAsesor = request.getAsesorTLOGCAMBIOSpthisAsesorInstance();

        request.checkArguments();
        Asesor instance = asesorTLOGCAMBIOSpthisAsesor;

        /* Action 1: IF (VerDBasicosPersona <> ptpVerDatosPersona OR VerDocIdentificacionPersona <> ptpVerDocsPersona OR VerContratoNovedad <> ptpVerContratoNovedad OR ptAccesoValidador <> AccesoValidadorUsuarios) */
        boolean ifCondition1 = !(asesorTLOGCAMBIOSpthisAsesor.getAsesorVerDBasicosPersona()).equals(asesorTLOGCAMBIOSptpVerDatosPersona) || !(asesorTLOGCAMBIOSpthisAsesor.getAsesorVerDocIdentificacionPersona()).equals(asesorTLOGCAMBIOSptpVerDocsPersona) || !(asesorTLOGCAMBIOSpthisAsesor.getAsesorVerContratoNovedad()).equals(asesorTLOGCAMBIOSptpVerContratoNovedad) || !(asesorTLOGCAMBIOSptAccesoValidador).equals(asesorTLOGCAMBIOSpthisAsesor.getAsesorAccesoValidadorUsuarios());
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.TNEWRequest step10Request = new com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.TNEWRequest();
            step10Request.setLogInformacionAsesorTNEWptpagrAsesorInstance(asesorTLOGCAMBIOSpthisAsesor);
            step10Request.setLogInformacionAsesorTNEWptpatrVerDatosPersona(asesorTLOGCAMBIOSptpVerDatosPersona);
            step10Request.setLogInformacionAsesorTNEWptpatrVerDocsPersona(asesorTLOGCAMBIOSptpVerDocsPersona);
            step10Request.setLogInformacionAsesorTNEWptpatrVerContratoNovedad(asesorTLOGCAMBIOSptpVerContratoNovedad);
            step10Request.setLogInformacionAsesorTNEWpatrAccesoValidadorUsuarios(asesorTLOGCAMBIOSptAccesoValidador);
            logInformacionAsesorSrv.tNEWImplementation(step10Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
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
            com.keralty.aeusuarios.viewmodel.asesor.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = asesorSrv.changePasswordTxn(request);
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
            com.keralty.aeusuarios.viewmodel.asesor.siu.ChangePasswordRequest request) throws ModelException {
        request.setAsesorchangePasswordpthisAdminInstance(asesorSrv.getByOIDWithHV(request.getAsesorchangePasswordpthisAdmin()));
        return asesorSrv.changePasswordImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.asesor.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor asesorchangePasswordpthisAdmin = request.getAsesorchangePasswordpthisAdminInstance();
        String asesorchangePasswordpOldPassword = request.getAsesorchangePasswordpOldPassword();
        String asesorchangePasswordpNewPassword = request.getAsesorchangePasswordpNewPassword();

        request.checkArguments();
        Asesor instance = asesorchangePasswordpthisAdmin;
        if(!instance.getPassWord().equals(encrypt(asesorchangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(asesorchangePasswordpNewPassword));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: hacerAsesor

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

        request.checkArguments();
        Asesor instance = new Asesor();

        if (funcionariohacerAsesorpagrTipoIdentificacion != null && !funcionariohacerAsesorpagrTipoIdentificacion.isNull()) {
            instance.add2TipoIdentificacion(funcionariohacerAsesorpagrTipoIdentificacion);
        }

        instance.setAsesormodificaDirector(funcionariohacerAsesorpatrmodificaDirector);
        instance.setAsesoresDirector(funcionariohacerAsesorpatresDirector);
        instance.setAsesorNumIdentificacion(funcionariohacerAsesorpatrNumIdentificacion);
        instance.setAsesorModDBasicosPersona(funcionariohacerAsesorpatrModDBasicosPersona);
        instance.setAsesorEsIntegral(funcionariohacerAsesorpatrEsIntegral);
        instance.setAsesorVerDBasicosPersona(funcionariohacerAsesorpatrVerDBasicosPersona);
        instance.setAsesorVerDocIdentificacionPersona(funcionariohacerAsesorpatrVerDocIdentificacionPerso);
        instance.setAsesorVerContratoNovedad(funcionariohacerAsesorpatrVerContratoNovedad);
        instance.setAsesorCanalComercial(funcionariohacerAsesorpatrCanalComercial);
        instance.setAsesorCargo(funcionariohacerAsesorpatrCargo);
        instance.setAsesorEstado(funcionariohacerAsesorpatrEstado);
        instance.setAsesorAccesoValidadorUsuarios(funcionariohacerAsesorpatrAccesoValidadorUsuarios);
        instance.setFuncionarioId(funcionariohacerAsesorpthisAgente.getFuncionarioId());

        instance.setParentFuncionario(funcionariohacerAsesorpthisAgente);
        instance.setPassWord(funcionariohacerAsesorpthisAgente.getPassWord());
        response.setInstanceSuppInfo(instance.buildICAsesor());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }

    // Service: deshacerAsesor

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
        Asesor instance = funcionariodeshacerAsesorpthisAgente.getChildAsesor();
        funcionariodeshacerAsesorpthisAgente.setChildAsesor(null);
        instance.setParentFuncionario(null);


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICAsesor());

        response.setInstanceSuppInfo(instance.buildICAsesor());

        return response;
    }


    private void suppInfo4ICAsesor(String searchText, SQLSelect select) {
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
        select.getOrderByPart().addItem(Constants.normalizePath(AsesorConstants.CLASS_NAME, FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildAsesorRelatedInstance(relatedInstanceJsonOid);
        }
        if (AsesorConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4LogInformacionAsesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGHISTORICOPLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4LogHistoricoPlanes(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem) || AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_REPORTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4ReportesProcAlm(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4LogFuncionario(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAsesorRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildAsesorRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Asesor(mapper.readValue(relatedInstanceJsonOid, AsesorOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): AgentexProducto.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4LogInformacionAsesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class)): LogInformacionAsesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4LogHistoricoPlanes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class)): LogHistoricoPlanes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4ReportesProcAlm(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class)): ReportesProcAlm.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): GrupoAsignacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4LogFuncionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class)): LogFuncionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): Rol.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAsesorRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
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
            AsesorOid oid = new AsesorOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AsesorService.class).error(e.getMessage());
        }
    }

}
