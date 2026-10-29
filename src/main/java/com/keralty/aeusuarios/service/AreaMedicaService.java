package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.AreaMedicaOid;
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
import com.keralty.aeusuarios.repository.AreaMedicaJpaRepository;
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
public class AreaMedicaService extends AbstractService {

    AreaMedicaJpaRepository repository;

    SolicitudService solicitudSrv;

    ReportesProcAlmService reportesProcAlmSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    GrupoAsignacionService grupoAsignacionSrv;

    LogFuncionarioService logFuncionarioSrv;

    ContratoCService contratoCSrv;

    AgentexProductoService agentexProductoSrv;

    LogInformacionAsesorService logInformacionAsesorSrv;

    LogHistoricoPlanesService logHistoricoPlanesSrv;

    FirmaService firmaSrv;

    RolService rolSrv;

    SucursalService sucursalSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    PlanesService planesSrv;

    RegionalService regionalSrv;

    @Inject
    public AreaMedicaService(
            SolicitudService solicitudSrv,
            ReportesProcAlmService reportesProcAlmSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            GrupoAsignacionService grupoAsignacionSrv,
            LogFuncionarioService logFuncionarioSrv,
            ContratoCService contratoCSrv,
            AgentexProductoService agentexProductoSrv,
            LogInformacionAsesorService logInformacionAsesorSrv,
            LogHistoricoPlanesService logHistoricoPlanesSrv,
            FirmaService firmaSrv,
            RolService rolSrv,
            SucursalService sucursalSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            PlanesService planesSrv,
            RegionalService regionalSrv,
            AreaMedicaJpaRepository repository) {
        this.solicitudSrv = solicitudSrv;
        this.reportesProcAlmSrv = reportesProcAlmSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.grupoAsignacionSrv = grupoAsignacionSrv;
        this.logFuncionarioSrv = logFuncionarioSrv;
        this.contratoCSrv = contratoCSrv;
        this.agentexProductoSrv = agentexProductoSrv;
        this.logInformacionAsesorSrv = logInformacionAsesorSrv;
        this.logHistoricoPlanesSrv = logHistoricoPlanesSrv;
        this.firmaSrv = firmaSrv;
        this.rolSrv = rolSrv;
        this.sucursalSrv = sucursalSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.planesSrv = planesSrv;
        this.regionalSrv = regionalSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AreaMedicaConstants.CLASS_NAME);
    }

    private List<AreaMedica> solveAreaMedicaTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AreaMedicaConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAreaMedicaTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AreaMedicaConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class AreaMedica
     *
     * @return Population of class AreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AreaMedica> get() {
        List<AreaMedica> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class AreaMedica
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class AreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<AreaMedica> instances = get(queryRequest);
        if(AreaMedicaConstants.DSSIAREAMEDICA.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildSIAreaMedica())).collect(Collectors.toList());
        }
        if(AreaMedicaConstants.DSDSAREAMEDICANULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAreaMedicaNull())).collect(Collectors.toList());
        }
        if(AreaMedicaConstants.DSDSAREAMEDICA.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAreaMedica())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class AreaMedica that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class AreaMedica matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AreaMedica> get(QueryRequest queryRequest) {
        return solveAreaMedicaTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAreaMedicaTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAreaMedicaTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveAreaMedicaTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveAreaMedicaTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of AreaMedica by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of AreaMedica
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AreaMedica getById(Long funcionarioId) {
        return getByOID(new AreaMedicaOid(funcionarioId));
    }
    
    /*
     * Returns an instance of AreaMedica by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AreaMedica
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AreaMedica getByOID(AreaMedicaOid oid) {
        Optional<AreaMedica> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of AreaMedica by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public AreaMedica getByOIDWithHV(AreaMedicaOid oid) {
        Optional<AreaMedica> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<AreaMedica> getInstanceByOid(AreaMedicaOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }

    /*
     * Returns an instance of AreaMedica by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of AreaMedica
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public AreaMedica getByJsonOid(String jsonOid) {
        AreaMedicaOid oid = new AreaMedicaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of AreaMedica related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of AreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AreaMedica> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveAreaMedicaTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of AreaMedica related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of AreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AreaMedica> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of AreaMedica
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of AreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getAreaMedicaDynamic(AreaMedicaOid oid, String displaySetItems) {
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
    public String getSuppInfo(AreaMedicaOid oid, String dsName) {
        AreaMedica instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(AreaMedica instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (AreaMedicaConstants.DSSIAREAMEDICA.equals(dsName))
            return instance.buildSIAreaMedica();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(AreaMedica instance, String dsName) {
        if (AreaMedicaConstants.DSSIAREAMEDICA.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildSIAreaMedica());
        if (AreaMedicaConstants.DSDSAREAMEDICANULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAreaMedicaNull());
        if (AreaMedicaConstants.DSDSAREAMEDICA.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAreaMedica());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Solicitud_TREASIGNARUSUARIOS_ptUsrAreaMedica_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav71(sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_SIAreaMedica".equals(filterRequest.getName()))
            suppInfo4SIAreaMedica(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void clas1431957012480960FiltNav71(SQLSelect sql) {
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

    // IIU Methods


    /*
     * Solves the query needed for PIUAreaMedicaNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for AreaMedica using displayset DSAreaMedicaNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.areamedica.ds.DSAreaMedicaNull> piuPIUAreaMedicaNull(QueryRequest queryRequest) {
        return solveAreaMedicaTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.areamedica.ds.DSAreaMedicaNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAreaMedicaNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAreaMedicaNull
     */
    public int getCount4PIUAreaMedicaNull(QueryRequest queryRequest) {
        return solveAreaMedicaTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUAreaMedicaObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for AreaMedica using displayset DSAreaMedica that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.areamedica.ds.DSAreaMedica> piuPIUAreaMedicaObs(QueryRequest queryRequest) {
        return solveAreaMedicaTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.areamedica.ds.DSAreaMedica::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAreaMedicaObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAreaMedicaObs
     */
    public int getCount4PIUAreaMedicaObs(QueryRequest queryRequest) {
        return solveAreaMedicaTypedQuery(queryRequest).size();
    }

    // Service: InsUsrAreaMedica

    /*
     * Entry point for service InsUsrAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insUsrAreaMedica(
            com.keralty.aeusuarios.viewmodel.areamedica.siu.InsUsrAreaMedicaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = areaMedicaSrv.insUsrAreaMedicaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsUsrAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insUsrAreaMedicaTxn(
            com.keralty.aeusuarios.viewmodel.areamedica.siu.InsUsrAreaMedicaRequest request) throws ModelException {
        request.setAreaMedicaInsUsrAreaMedicapthisAreaMedicaInstance(areaMedicaSrv.getByOIDWithHV(request.getAreaMedicaInsUsrAreaMedicapthisAreaMedica()));
        request.setAreaMedicaInsUsrAreaMedicapevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getAreaMedicaInsUsrAreaMedicapevcSolicitud()));
        return areaMedicaSrv.insUsrAreaMedicaImplementation(request, true);
    }

    /*
     * Implements service InsUsrAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insUsrAreaMedicaImplementation(
            com.keralty.aeusuarios.viewmodel.areamedica.siu.InsUsrAreaMedicaRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AreaMedica areaMedicaInsUsrAreaMedicapthisAreaMedica = request.getAreaMedicaInsUsrAreaMedicapthisAreaMedicaInstance();
        Solicitud areaMedicaInsUsrAreaMedicapevcSolicitud = request.getAreaMedicaInsUsrAreaMedicapevcSolicitudInstance();

        request.checkArguments();
        AreaMedica instance = areaMedicaInsUsrAreaMedicapthisAreaMedica;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.solicitud.siu.InsUsrAreaMedicaRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.solicitud.siu.InsUsrAreaMedicaRequest();
            relatedRequest.setSolicitudInsUsrAreaMedicapthisSolicitudInstance(areaMedicaInsUsrAreaMedicapevcSolicitud);
            relatedRequest.setSolicitudInsUsrAreaMedicapevcAreaMedicaInstance(areaMedicaInsUsrAreaMedicapthisAreaMedica);
            solicitudSrv.insUsrAreaMedicaImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAreaMedica());

        return response;
    }

    // Service: DelUsrAreaMedica

    /*
     * Entry point for service DelUsrAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delUsrAreaMedica(
            com.keralty.aeusuarios.viewmodel.areamedica.siu.DelUsrAreaMedicaRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = areaMedicaSrv.delUsrAreaMedicaTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelUsrAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delUsrAreaMedicaTxn(
            com.keralty.aeusuarios.viewmodel.areamedica.siu.DelUsrAreaMedicaRequest request) throws ModelException {
        request.setAreaMedicaDelUsrAreaMedicapthisAreaMedicaInstance(areaMedicaSrv.getByOIDWithHV(request.getAreaMedicaDelUsrAreaMedicapthisAreaMedica()));
        request.setAreaMedicaDelUsrAreaMedicapevcSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getAreaMedicaDelUsrAreaMedicapevcSolicitud()));
        return areaMedicaSrv.delUsrAreaMedicaImplementation(request, true);
    }

    /*
     * Implements service DelUsrAreaMedica
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delUsrAreaMedicaImplementation(
            com.keralty.aeusuarios.viewmodel.areamedica.siu.DelUsrAreaMedicaRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AreaMedica areaMedicaDelUsrAreaMedicapthisAreaMedica = request.getAreaMedicaDelUsrAreaMedicapthisAreaMedicaInstance();
        Solicitud areaMedicaDelUsrAreaMedicapevcSolicitud = request.getAreaMedicaDelUsrAreaMedicapevcSolicitudInstance();

        request.checkArguments();
        AreaMedica instance = areaMedicaDelUsrAreaMedicapthisAreaMedica;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.solicitud.siu.DelUsrAreaMedicaRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.solicitud.siu.DelUsrAreaMedicaRequest();
            relatedRequest.setSolicitudDelUsrAreaMedicapthisSolicitudInstance(areaMedicaDelUsrAreaMedicapevcSolicitud);
            relatedRequest.setSolicitudDelUsrAreaMedicapevcAreaMedicaInstance(areaMedicaDelUsrAreaMedicapthisAreaMedica);
            solicitudSrv.delUsrAreaMedicaImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAreaMedica());

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
            com.keralty.aeusuarios.viewmodel.areamedica.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = areaMedicaSrv.changePasswordTxn(request);
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
            com.keralty.aeusuarios.viewmodel.areamedica.siu.ChangePasswordRequest request) throws ModelException {
        request.setAreaMedicachangePasswordpthisAdminInstance(areaMedicaSrv.getByOIDWithHV(request.getAreaMedicachangePasswordpthisAdmin()));
        return areaMedicaSrv.changePasswordImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.areamedica.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AreaMedica areaMedicachangePasswordpthisAdmin = request.getAreaMedicachangePasswordpthisAdminInstance();
        String areaMedicachangePasswordpOldPassword = request.getAreaMedicachangePasswordpOldPassword();
        String areaMedicachangePasswordpNewPassword = request.getAreaMedicachangePasswordpNewPassword();

        request.checkArguments();
        AreaMedica instance = areaMedicachangePasswordpthisAdmin;
        if(!instance.getPassWord().equals(encrypt(areaMedicachangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(areaMedicachangePasswordpNewPassword));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAreaMedica());

        return response;
    }

    // Service: hacerAreaMedica

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
        AreaMedica instance = new AreaMedica();

        instance.setFuncionarioId(funcionariohacerAreaMedicapthisAgente.getFuncionarioId());

        instance.setParentFuncionario(funcionariohacerAreaMedicapthisAgente);
        instance.setPassWord(funcionariohacerAreaMedicapthisAgente.getPassWord());
        response.setInstanceSuppInfo(instance.buildSIAreaMedica());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildSIAreaMedica());

        return response;
    }

    // Service: deshacerAreaMedica

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
        AreaMedica instance = funcionariodeshacerAreaMedicapthisAgente.getChildAreaMedica();
        funcionariodeshacerAreaMedicapthisAgente.setChildAreaMedica(null);
        instance.setParentFuncionario(null);


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildSIAreaMedica());

        response.setInstanceSuppInfo(instance.buildSIAreaMedica());

        return response;
    }


    private void suppInfo4SIAreaMedica(String searchText, SQLSelect select) {
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
            throw new SystemException(e.getMessage());
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
        select.getOrderByPart().addItem(Constants.normalizePath(AreaMedicaConstants.CLASS_NAME, FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildAreaMedicaRelatedInstance(relatedInstanceJsonOid);
        }
        if (AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_REPORTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4ReportesProcAlm(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4LogFuncionario(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4LogInformacionAsesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGHISTORICOPLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4LogHistoricoPlanes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAreaMedicaRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildAreaMedicaRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new AreaMedica(mapper.readValue(relatedInstanceJsonOid, AreaMedicaOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4ReportesProcAlm(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class)): ReportesProcAlm.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): GrupoAsignacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4LogFuncionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class)): LogFuncionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): AgentexProducto.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4LogInformacionAsesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class)): LogInformacionAsesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4LogHistoricoPlanes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class)): LogHistoricoPlanes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): Rol.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildAreaMedicaRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Regional(mapper.readValue(relatedInstanceJsonOid, RegionalOid.class)): Regional.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AreaMedicaOid oid = new AreaMedicaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AreaMedicaService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
