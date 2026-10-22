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
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;
import com.keralty.aeusuarios.persistence.oid.LogFuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.LogHistoricoPlanesOid;
import com.keralty.aeusuarios.persistence.oid.LogInformacionAsesorOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
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
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.repository.RespRegionalJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandThis;
import com.keralty.aeusuarios.utils.Utilities;
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
public class RespRegionalService extends AbstractService {

    RespRegionalJpaRepository repository;

    RegionalService regionalSrv;

    FirmaService firmaSrv;

    SolicitudService solicitudSrv;

    ReportesProcAlmService reportesProcAlmSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    GrupoAsignacionService grupoAsignacionSrv;

    LogFuncionarioService logFuncionarioSrv;

    ContratoCService contratoCSrv;

    AgentexProductoService agentexProductoSrv;

    LogInformacionAsesorService logInformacionAsesorSrv;

    LogHistoricoPlanesService logHistoricoPlanesSrv;

    RolService rolSrv;

    SucursalService sucursalSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    PlanesService planesSrv;

    @Inject
    public RespRegionalService(
            RegionalService regionalSrv,
            FirmaService firmaSrv,
            SolicitudService solicitudSrv,
            ReportesProcAlmService reportesProcAlmSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            GrupoAsignacionService grupoAsignacionSrv,
            LogFuncionarioService logFuncionarioSrv,
            ContratoCService contratoCSrv,
            AgentexProductoService agentexProductoSrv,
            LogInformacionAsesorService logInformacionAsesorSrv,
            LogHistoricoPlanesService logHistoricoPlanesSrv,
            RolService rolSrv,
            SucursalService sucursalSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            PlanesService planesSrv,
            RespRegionalJpaRepository repository) {
        this.regionalSrv = regionalSrv;
        this.firmaSrv = firmaSrv;
        this.solicitudSrv = solicitudSrv;
        this.reportesProcAlmSrv = reportesProcAlmSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.grupoAsignacionSrv = grupoAsignacionSrv;
        this.logFuncionarioSrv = logFuncionarioSrv;
        this.contratoCSrv = contratoCSrv;
        this.agentexProductoSrv = agentexProductoSrv;
        this.logInformacionAsesorSrv = logInformacionAsesorSrv;
        this.logHistoricoPlanesSrv = logHistoricoPlanesSrv;
        this.rolSrv = rolSrv;
        this.sucursalSrv = sucursalSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.planesSrv = planesSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, RespRegionalConstants.CLASS_NAME);
    }

    private List<RespRegional> solveRespRegionalTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, RespRegionalConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveRespRegionalTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, RespRegionalConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class RespRegional
     *
     * @return Population of class RespRegional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<RespRegional> get() {
        List<RespRegional> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class RespRegional
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class RespRegional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<RespRegional> instances = get(queryRequest);
        if(RespRegionalConstants.DSICRESPREGIONAL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICRespRegional())).collect(Collectors.toList());
        }
        if(RespRegionalConstants.DSDSRESPREGIONALPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSRespRegionalPIU())).collect(Collectors.toList());
        }
        if(RespRegionalConstants.DSICRESPREGIONALNOMAPE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICRespRegionalNomApe())).collect(Collectors.toList());
        }
        if(RespRegionalConstants.DSDSRESPREGIONALFIRMA.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSRespRegionalFirma())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class RespRegional that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class RespRegional matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<RespRegional> get(QueryRequest queryRequest) {
        return solveRespRegionalTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveRespRegionalTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveRespRegionalTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveRespRegionalTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveRespRegionalTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of RespRegional by ID
     *
     * @param funcionarioId Identification field funcionarioId
     *
     * @return Instance of RespRegional
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public RespRegional getById(Long funcionarioId) {
        return getByOID(new RespRegionalOid(funcionarioId));
    }
    
    /*
     * Returns an instance of RespRegional by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of RespRegional
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public RespRegional getByOID(RespRegionalOid oid) {
        Optional<RespRegional> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of RespRegional by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of RespRegional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public RespRegional getByOIDWithHV(RespRegionalOid oid) {
        Optional<RespRegional> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<RespRegional> getInstanceByOid(RespRegionalOid oid) {
        return oid != null && oid.getFuncionarioId() != null
               ? repository.findById(oid.getFuncionarioId())
               : Optional.empty();
    }

    /*
     * Returns an instance of RespRegional by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of RespRegional
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public RespRegional getByJsonOid(String jsonOid) {
        RespRegionalOid oid = new RespRegionalOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of RespRegional related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of RespRegional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<RespRegional> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveRespRegionalTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of RespRegional related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of RespRegional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<RespRegional> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of RespRegional
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of RespRegional
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getRespRegionalDynamic(RespRegionalOid oid, String displaySetItems) {
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
    public String getSuppInfo(RespRegionalOid oid, String dsName) {
        RespRegional instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(RespRegional instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (RespRegionalConstants.DSICRESPREGIONALNOMAPE.equals(dsName))
            return instance.buildICRespRegionalNomApe();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(RespRegional instance, String dsName) {
        if (RespRegionalConstants.DSICRESPREGIONAL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICRespRegional());
        if (RespRegionalConstants.DSDSRESPREGIONALPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSRespRegionalPIU());
        if (RespRegionalConstants.DSICRESPREGIONALNOMAPE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICRespRegionalNomApe());
        if (RespRegionalConstants.DSDSRESPREGIONALFIRMA.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSRespRegionalFirma());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_RespRegionalNomApe".equals(filterRequest.getName()))
            suppInfo4ICRespRegionalNomApe(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods

    /*
     * Returns a viewmodel for class RespRegional with displayset DSRespRegionalFirma for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class RespRegional with displayset DSRespRegionalFirma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.respregional.ds.DSRespRegionalFirma iIURespRegionalFirma(RespRegionalOid oid) {
        return new com.keralty.aeusuarios.viewmodel.respregional.ds.DSRespRegionalFirma(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIURespRegional
     *
     * @param queryRequest Query request
     * @return List of viewmodels for RespRegional using displayset DSRespRegionalPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.respregional.ds.DSRespRegionalPIU> piuPIURespRegional(QueryRequest queryRequest) {
        return solveRespRegionalTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.respregional.ds.DSRespRegionalPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIURespRegional
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIURespRegional
     */
    public int getCount4PIURespRegional(QueryRequest queryRequest) {
        return solveRespRegionalTypedQuery(queryRequest).size();
    }

    // Service: InsRegionalResponsable

    /*
     * Entry point for service InsRegionalResponsable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insRegionalResponsable(
            com.keralty.aeusuarios.viewmodel.respregional.siu.InsRegionalResponsableRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = respRegionalSrv.insRegionalResponsableTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsRegionalResponsable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insRegionalResponsableTxn(
            com.keralty.aeusuarios.viewmodel.respregional.siu.InsRegionalResponsableRequest request) throws ModelException {
        request.setRespRegionalInsRegionalResponsablepthisRespRegionalInstance(respRegionalSrv.getByOIDWithHV(request.getRespRegionalInsRegionalResponsablepthisRespRegional()));
        request.setRespRegionalInsRegionalResponsablepevcRegionalInstance(regionalSrv.getByOIDWithHV(request.getRespRegionalInsRegionalResponsablepevcRegional()));
        return respRegionalSrv.insRegionalResponsableImplementation(request, true);
    }

    /*
     * Implements service InsRegionalResponsable
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insRegionalResponsableImplementation(
            com.keralty.aeusuarios.viewmodel.respregional.siu.InsRegionalResponsableRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        RespRegional respRegionalInsRegionalResponsablepthisRespRegional = request.getRespRegionalInsRegionalResponsablepthisRespRegionalInstance();
        Regional respRegionalInsRegionalResponsablepevcRegional = request.getRespRegionalInsRegionalResponsablepevcRegionalInstance();

        request.checkArguments();
        RespRegional instance = respRegionalInsRegionalResponsablepthisRespRegional;

        instance.add2Regional(respRegionalInsRegionalResponsablepevcRegional);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.regional.siu.InsRegionalResponsableRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.regional.siu.InsRegionalResponsableRequest();
            relatedRequest.setRegionalInsRegionalResponsablepthisRegionalInstance(respRegionalInsRegionalResponsablepevcRegional);
            relatedRequest.setRegionalInsRegionalResponsablepevcRespRegionalInstance(respRegionalInsRegionalResponsablepthisRespRegional);
            regionalSrv.insRegionalResponsableImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

        return response;
    }

    // Service: DelRegionalResponsable

    /*
     * Entry point for service DelRegionalResponsable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delRegionalResponsable(
            com.keralty.aeusuarios.viewmodel.respregional.siu.DelRegionalResponsableRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = respRegionalSrv.delRegionalResponsableTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelRegionalResponsable
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delRegionalResponsableTxn(
            com.keralty.aeusuarios.viewmodel.respregional.siu.DelRegionalResponsableRequest request) throws ModelException {
        request.setRespRegionalDelRegionalResponsablepthisRespRegionalInstance(respRegionalSrv.getByOIDWithHV(request.getRespRegionalDelRegionalResponsablepthisRespRegional()));
        request.setRespRegionalDelRegionalResponsablepevcRegionalInstance(regionalSrv.getByOIDWithHV(request.getRespRegionalDelRegionalResponsablepevcRegional()));
        return respRegionalSrv.delRegionalResponsableImplementation(request, true);
    }

    /*
     * Implements service DelRegionalResponsable
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delRegionalResponsableImplementation(
            com.keralty.aeusuarios.viewmodel.respregional.siu.DelRegionalResponsableRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        RespRegional respRegionalDelRegionalResponsablepthisRespRegional = request.getRespRegionalDelRegionalResponsablepthisRespRegionalInstance();
        Regional respRegionalDelRegionalResponsablepevcRegional = request.getRespRegionalDelRegionalResponsablepevcRegionalInstance();

        request.checkArguments();
        RespRegional instance = respRegionalDelRegionalResponsablepthisRespRegional;

        instance.add2Regional(null);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.regional.siu.DelRegionalResponsableRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.regional.siu.DelRegionalResponsableRequest();
            relatedRequest.setRegionalDelRegionalResponsablepthisRegionalInstance(respRegionalDelRegionalResponsablepevcRegional);
            relatedRequest.setRegionalDelRegionalResponsablepevcRespRegionalInstance(respRegionalDelRegionalResponsablepthisRespRegional);
            regionalSrv.delRegionalResponsableImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

        return response;
    }

    // Service: TMODIFICAR

    /*
     * Entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tMODIFICAR(
            com.keralty.aeusuarios.viewmodel.respregional.siu.TMODIFICARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = respRegionalSrv.tMODIFICARTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tMODIFICARTxn(
            com.keralty.aeusuarios.viewmodel.respregional.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        request.setRespRegionalTMODIFICARpthisRespRegionalInstance(respRegionalSrv.getByOIDWithHV(request.getRespRegionalTMODIFICARpthisRespRegional()));
        request.setRespRegionalTMODIFICARptpevcRegionalInstance(regionalSrv.getByOIDWithHV(new RegionalOid().fromJsonString(request.getRespRegionalTMODIFICARptpevcRegional())));
        return respRegionalSrv.tMODIFICARImplementation(request);
    }

    /*
     * Implements service TMODIFICAR
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tMODIFICARImplementation(
            com.keralty.aeusuarios.viewmodel.respregional.siu.TMODIFICARRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String respRegionalTMODIFICARptpPrimerNombre = request.getRespRegionalTMODIFICARptpPrimerNombre();
        String respRegionalTMODIFICARptpSegundoNombre = request.getRespRegionalTMODIFICARptpSegundoNombre();
        String respRegionalTMODIFICARptpPrimerApellido = request.getRespRegionalTMODIFICARptpPrimerApellido();
        String respRegionalTMODIFICARptpSegundoApellido = request.getRespRegionalTMODIFICARptpSegundoApellido();
        String respRegionalTMODIFICARptpUsuarioLDAP = request.getRespRegionalTMODIFICARptpUsuarioLDAP();
        String respRegionalTMODIFICARptpEmail = request.getRespRegionalTMODIFICARptpEmail();
        Regional respRegionalTMODIFICARptpevcRegional = request.getRespRegionalTMODIFICARptpevcRegionalInstance();
        RespRegional respRegionalTMODIFICARpthisRespRegional = request.getRespRegionalTMODIFICARpthisRespRegionalInstance();

        request.checkArguments();
        RespRegional instance = respRegionalTMODIFICARpthisRespRegional;

        com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest step1Request = new com.keralty.aeusuarios.viewmodel.funcionario.siu.ModificarRequest();
        step1Request.setFuncionariomodificarpthisAdminInstance(respRegionalTMODIFICARpthisRespRegional.getFuncionarioFacet());
        step1Request.setFuncionariomodificarpPrimerNombre(respRegionalTMODIFICARptpPrimerNombre);
        step1Request.setFuncionariomodificarpSegundoNombre(respRegionalTMODIFICARptpSegundoNombre);
        step1Request.setFuncionariomodificarpPrimerApellido(respRegionalTMODIFICARptpPrimerApellido);
        step1Request.setFuncionariomodificarpSegundoApellido(respRegionalTMODIFICARptpSegundoApellido);
        step1Request.setFuncionariomodificarpUsuarioLDAP(respRegionalTMODIFICARptpUsuarioLDAP);
        step1Request.setFuncionariomodificarpEmail(respRegionalTMODIFICARptpEmail);
        funcionarioSrv.modificarImplementation(step1Request);

        /* Action 2: IF (Regional <> ptpevcRegional) */
        boolean ifCondition2 = !Utilities.isEqual(respRegionalTMODIFICARpthisRespRegional.getRegional(), respRegionalTMODIFICARptpevcRegional);
        if (ifCondition2) {
            /* Action 20: IF (EXIST (Regional) = true) */
            boolean ifCondition20 = repository.assocOperator001(respRegionalTMODIFICARpthisRespRegional).equals(true);
            if (ifCondition20) {
                com.keralty.aeusuarios.viewmodel.respregional.siu.DelRegionalResponsableRequest step200Request = new com.keralty.aeusuarios.viewmodel.respregional.siu.DelRegionalResponsableRequest();
                step200Request.setRespRegionalDelRegionalResponsablepthisRespRegionalInstance(respRegionalTMODIFICARpthisRespRegional);
                step200Request.setRespRegionalDelRegionalResponsablepevcRegionalInstance(respRegionalTMODIFICARpthisRespRegional.getRegional());
                respRegionalSrv.delRegionalResponsableImplementation(step200Request, true);
            }
            /* Action 21: IF (ptpevcRegional <> NULL) */
            boolean ifCondition21 = (respRegionalTMODIFICARptpevcRegional != null && !respRegionalTMODIFICARptpevcRegional.isNull());
            if (ifCondition21) {
                com.keralty.aeusuarios.viewmodel.respregional.siu.InsRegionalResponsableRequest step210Request = new com.keralty.aeusuarios.viewmodel.respregional.siu.InsRegionalResponsableRequest();
                step210Request.setRespRegionalInsRegionalResponsablepthisRespRegionalInstance(respRegionalTMODIFICARpthisRespRegional);
                step210Request.setRespRegionalInsRegionalResponsablepevcRegionalInstance(respRegionalTMODIFICARptpevcRegional);
                respRegionalSrv.insRegionalResponsableImplementation(step210Request, true);
            }
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

        return response;
    }

    // Service: TCREAROMODFIRMA

    /*
     * Entry point for service TCREAROMODFIRMA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tCREAROMODFIRMA(
            com.keralty.aeusuarios.viewmodel.respregional.siu.TCREAROMODFIRMARequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = respRegionalSrv.tCREAROMODFIRMATxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TCREAROMODFIRMA
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tCREAROMODFIRMATxn(
            com.keralty.aeusuarios.viewmodel.respregional.siu.TCREAROMODFIRMARequest request) throws ModelException, SystemException {
        request.setRespRegionalTCREAROMODFIRMApthisRespRegionalInstance(respRegionalSrv.getByOIDWithHV(request.getRespRegionalTCREAROMODFIRMApthisRespRegional()));
        return respRegionalSrv.tCREAROMODFIRMAImplementation(request);
    }

    /*
     * Implements service TCREAROMODFIRMA
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tCREAROMODFIRMAImplementation(
            com.keralty.aeusuarios.viewmodel.respregional.siu.TCREAROMODFIRMARequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        byte[] respRegionalTCREAROMODFIRMAptpatrImagenFirma = request.getRespRegionalTCREAROMODFIRMAptpatrImagenFirma();
        String respRegionalTCREAROMODFIRMAptpatrLatitud = request.getRespRegionalTCREAROMODFIRMAptpatrLatitud();
        String respRegionalTCREAROMODFIRMAptpatrLongitud = request.getRespRegionalTCREAROMODFIRMAptpatrLongitud();
        RespRegional respRegionalTCREAROMODFIRMApthisRespRegional = request.getRespRegionalTCREAROMODFIRMApthisRespRegionalInstance();

        request.checkArguments();
        RespRegional instance = respRegionalTCREAROMODFIRMApthisRespRegional;

        /* Action 1: IF (EXIST (Firma) = false) */
        boolean ifCondition1 = repository.assocOperator003(respRegionalTCREAROMODFIRMApthisRespRegional).equals(false);
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.firma.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.firma.siu.CrearRequest();
            step10Request.setFirmacrearpagrSolicitudSegundaInstance(null);
            step10Request.setFirmacrearpagrRespRegionalInstance(respRegionalTCREAROMODFIRMApthisRespRegional);
            step10Request.setFirmacrearpagrSolicitudContratanteInstance(null);
            step10Request.setFirmacrearpagrFamiliaNovedadInstance(null);
            step10Request.setFirmacrearpagrNovedadesCTInstance(null);
            step10Request.setFirmacrearpagrSolicitudInstance(null);
            step10Request.setFirmacrearpagrSolicitudNovedadInstance(null);
            step10Request.setFirmacrearpatrImagenFirma(respRegionalTCREAROMODFIRMAptpatrImagenFirma);
            step10Request.setFirmacrearpatrLatitud(respRegionalTCREAROMODFIRMAptpatrLatitud);
            step10Request.setFirmacrearpatrLongitud(respRegionalTCREAROMODFIRMAptpatrLongitud);
            firmaSrv.crearImplementation(step10Request);
        } else {
            com.keralty.aeusuarios.viewmodel.firma.siu.ModificarRequest step11Request = new com.keralty.aeusuarios.viewmodel.firma.siu.ModificarRequest();
            step11Request.setFirmamodificarpthisFirmaInstance(respRegionalTCREAROMODFIRMApthisRespRegional.getFirma());
            step11Request.setFirmamodificarpImagenFirma(respRegionalTCREAROMODFIRMAptpatrImagenFirma);
            step11Request.setFirmamodificarpLatitud(respRegionalTCREAROMODFIRMAptpatrLatitud);
            step11Request.setFirmamodificarpLongitud(respRegionalTCREAROMODFIRMAptpatrLongitud);
            firmaSrv.modificarImplementation(step11Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

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
            com.keralty.aeusuarios.viewmodel.respregional.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = respRegionalSrv.changePasswordTxn(request);
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
            com.keralty.aeusuarios.viewmodel.respregional.siu.ChangePasswordRequest request) throws ModelException {
        request.setRespRegionalchangePasswordpthisAdminInstance(respRegionalSrv.getByOIDWithHV(request.getRespRegionalchangePasswordpthisAdmin()));
        return respRegionalSrv.changePasswordImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.respregional.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        RespRegional respRegionalchangePasswordpthisAdmin = request.getRespRegionalchangePasswordpthisAdminInstance();
        String respRegionalchangePasswordpOldPassword = request.getRespRegionalchangePasswordpOldPassword();
        String respRegionalchangePasswordpNewPassword = request.getRespRegionalchangePasswordpNewPassword();

        request.checkArguments();
        RespRegional instance = respRegionalchangePasswordpthisAdmin;
        if(!instance.getPassWord().equals(encrypt(respRegionalchangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(respRegionalchangePasswordpNewPassword));


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

        return response;
    }

    // Service: hacerRespRegional

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
        RespRegional instance = new RespRegional();

        if (funcionariohacerRespRegionalpagrRegional != null && !funcionariohacerRespRegionalpagrRegional.isNull()) {
            funcionariohacerRespRegionalpagrRegional.add2RespRegional(instance);
            instance.add2Regional(funcionariohacerRespRegionalpagrRegional);
        }

        instance.setFuncionarioId(funcionariohacerRespRegionalpthisAgente.getFuncionarioId());

        instance.setParentFuncionario(funcionariohacerRespRegionalpthisAgente);
        instance.setPassWord(funcionariohacerRespRegionalpthisAgente.getPassWord());
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

        return response;
    }

    // Service: deshacerRespRegional

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
        RespRegional instance = funcionariodeshacerRespRegionalpthisAgente.getChildRespRegional();
        funcionariodeshacerRespRegionalpthisAgente.setChildRespRegional(null);
        instance.setParentFuncionario(null);


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

        response.setInstanceSuppInfo(instance.buildICRespRegionalNomApe());

        return response;
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(RespRegionalConstants.CLASS_NAME)) applyHVFilter4RespRegional(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4RespRegional(SQLSelect sql, SQLWhereDisjunction disjunction) {
        // agent = this
        RespRegional agentInstance = getAgentRespRegional();
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandOVParameter operand112 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, RespRegionalConstants.CLASS_NAME, RespRegionalConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandThis operand223 = new SQLWhereOperandThis();
        comparison1.setSecondOperand(operand223);
        disjunction.addOperand(comparison1);

    }


    private void suppInfo4ICRespRegionalNomApe(String searchText, SQLSelect select) {
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
        select.getOrderByPart().addItem(Constants.normalizePath(RespRegionalConstants.CLASS_NAME, FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildRespRegionalRelatedInstance(relatedInstanceJsonOid);
        }
        if (RespRegionalConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLICITUDESAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem) || AreaMedicaConstants.ROLE_NAME_SOLICITUDESARME.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_REPORTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4ReportesProcAlm(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || FuncionarioConstants.ROLE_NAME_SOLNOVAIFLIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_GRUPOASIGNACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_LOGFUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4LogFuncionario(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGINFORMACIONASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4LogInformacionAsesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_LOGHISTORICOPLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4LogHistoricoPlanes(relatedInstanceJsonOid, remainingPath);
        }
        if (RespRegionalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_ROL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (FuncionarioConstants.ROLE_NAME_SUCURSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (AsesorConstants.ROLE_NAME_TIPOIDENTIFICACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (AfiliacionesConstants.ROLE_NAME_PLANES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRespRegionalRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildRespRegionalRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new RespRegional(mapper.readValue(relatedInstanceJsonOid, RespRegionalOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4ReportesProcAlm(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesProcAlm(mapper.readValue(relatedInstanceJsonOid, ReportesProcAlmOid.class)): ReportesProcAlm.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): GrupoAsignacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4LogFuncionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class)): LogFuncionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): AgentexProducto.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4LogInformacionAsesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class)): LogInformacionAsesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4LogHistoricoPlanes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class)): LogHistoricoPlanes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Regional(mapper.readValue(relatedInstanceJsonOid, RegionalOid.class)): Regional.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): Rol.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRespRegionalRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            RespRegionalOid oid = new RespRegionalOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(RespRegionalService.class).error(e.getMessage());
        }
    }

}
