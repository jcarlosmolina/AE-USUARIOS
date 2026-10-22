package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.PreconditionException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.repository.AgentexProductoJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class AgentexProductoService extends AbstractService {

    AgentexProductoJpaRepository repository;

    AgentexProductoService agentexProductoSrv;

    ProductosService productosSrv;

    DominioService dominioSrv;

    LogHistoricoPlanesService logHistoricoPlanesSrv;

    PlanesService planesSrv;

    @Inject
    public AgentexProductoService(
            AgentexProductoService agentexProductoSrv,
            ProductosService productosSrv,
            DominioService dominioSrv,
            LogHistoricoPlanesService logHistoricoPlanesSrv,
            PlanesService planesSrv,
            AgentexProductoJpaRepository repository) {
        this.agentexProductoSrv = agentexProductoSrv;
        this.productosSrv = productosSrv;
        this.dominioSrv = dominioSrv;
        this.logHistoricoPlanesSrv = logHistoricoPlanesSrv;
        this.planesSrv = planesSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, AgentexProductoConstants.CLASS_NAME);
    }

    private List<AgentexProducto> solveAgentexProductoTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, AgentexProductoConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveAgentexProductoTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, AgentexProductoConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class AgentexProducto
     *
     * @return Population of class AgentexProducto
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AgentexProducto> get() {
        List<AgentexProducto> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class AgentexProducto
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class AgentexProducto
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<AgentexProducto> instances = get(queryRequest);
        if(AgentexProductoConstants.DSICAGENTEXPRODUCTO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICAgentexProducto())).collect(Collectors.toList());
        }
        if(AgentexProductoConstants.DSDSAGENTEXPRODUCTOPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSAgentexProductoPIU())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class AgentexProducto that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class AgentexProducto matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AgentexProducto> get(QueryRequest queryRequest) {
        return solveAgentexProductoTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveAgentexProductoTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveAgentexProductoTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveAgentexProductoTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveAgentexProductoTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of AgentexProducto by ID
     *
     * @param funcionarioAsesorId Identification field funcionarioAsesorId
     *
     * @param agentexProductoId Identification field agentexProductoId
     *
     * @return Instance of AgentexProducto
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AgentexProducto getById(Long funcionarioAsesorId, Long agentexProductoId) {
        return getByOID(new AgentexProductoOid(funcionarioAsesorId, agentexProductoId));
    }
    
    /*
     * Returns an instance of AgentexProducto by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AgentexProducto
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AgentexProducto getByOID(AgentexProductoOid oid) {
        Optional<AgentexProducto> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of AgentexProducto by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AgentexProducto
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public AgentexProducto getByOIDWithHV(AgentexProductoOid oid) {
        Optional<AgentexProducto> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<AgentexProducto> getInstanceByOid(AgentexProductoOid oid) {
        return oid != null && oid.getFuncionarioAsesorId() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of AgentexProducto by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of AgentexProducto
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public AgentexProducto getByJsonOid(String jsonOid) {
        AgentexProductoOid oid = new AgentexProductoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of AgentexProducto related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of AgentexProducto
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AgentexProducto> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveAgentexProductoTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of AgentexProducto related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of AgentexProducto
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<AgentexProducto> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of AgentexProducto
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of AgentexProducto
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getAgentexProductoDynamic(AgentexProductoOid oid, String displaySetItems) {
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
    public String getSuppInfo(AgentexProductoOid oid, String dsName) {
        AgentexProducto instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(AgentexProducto instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (AgentexProductoConstants.DSICAGENTEXPRODUCTO.equals(dsName))
            return instance.buildICAgentexProducto();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(AgentexProducto instance, String dsName) {
        if (AgentexProductoConstants.DSICAGENTEXPRODUCTO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICAgentexProducto());
        if (AgentexProductoConstants.DSDSAGENTEXPRODUCTOPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSAgentexProductoPIU());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_AgentexProducto".equals(filterRequest.getName()))
            suppInfo4ICAgentexProducto(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods


    /*
     * Solves the query needed for PIUAgentexProducto
     *
     * @param queryRequest Query request
     * @return List of viewmodels for AgentexProducto using displayset DSAgentexProductoPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.agentexproducto.ds.DSAgentexProductoPIU> piuPIUAgentexProducto(QueryRequest queryRequest) {
        return solveAgentexProductoTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.agentexproducto.ds.DSAgentexProductoPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUAgentexProducto
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUAgentexProducto
     */
    public int getCount4PIUAgentexProducto(QueryRequest queryRequest) {
        return solveAgentexProductoTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CrearRequest request) throws ModelException {
        request.setAgentexProductocrearpagrProductoTInstance(productosSrv.getByOIDWithHV(request.getAgentexProductocrearpagrProductoT()));
        request.setAgentexProductocrearpagrAsesorInstance(asesorSrv.getByOIDWithHV(request.getAgentexProductocrearpagrAsesor()));
        return agentexProductoSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos agentexProductocrearpagrProductoT = request.getAgentexProductocrearpagrProductoTInstance();
        Asesor agentexProductocrearpagrAsesor = request.getAgentexProductocrearpagrAsesorInstance();
        Timestamp agentexProductocrearpatrFechaInicio = request.getAgentexProductocrearpatrFechaInicio();
        Timestamp agentexProductocrearpatrFechaFin = request.getAgentexProductocrearpatrFechaFin();
        Long agentexProductocrearpatrCodigo = request.getAgentexProductocrearpatrCodigo();

        request.checkArguments();
        AgentexProducto instance = new AgentexProducto();
        instance.add2ProductoT(agentexProductocrearpagrProductoT);

        instance.add2Asesor(agentexProductocrearpagrAsesor);

        instance.setAgentexProductoId(Long.valueOf(0));
        instance.setAgentexProductoTodosDominios(Boolean.TRUE);
        instance.setAgentexProductoId(repository.nextAgentexProductoId(instance.getFuncionarioAsesorId()));
        instance.setAgentexProductoFechaInicio(agentexProductocrearpatrFechaInicio);
        instance.setAgentexProductoFechaFin(agentexProductocrearpatrFechaFin);
        instance.setAgentexProductoCodigo(agentexProductocrearpatrCodigo);

        instance.setOid(instance.getOid());

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.eliminarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.EliminarRequest request) throws ModelException {
        request.setAgentexProductoeliminarpthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoeliminarpthisAgentexProducto()));
        return agentexProductoSrv.eliminarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AgentexProducto agentexProductoeliminarpthisAgentexProducto = request.getAgentexProductoeliminarpthisAgentexProductoInstance();

        request.checkArguments();
        AgentexProducto instance = agentexProductoeliminarpthisAgentexProducto;


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

        return response;
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SincronizarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.sincronizarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SincronizarRequest request) throws ModelException {
        request.setAgentexProductosincronizarpthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductosincronizarpthisAgentexProducto()));
        return agentexProductoSrv.sincronizarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SincronizarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AgentexProducto agentexProductosincronizarpthisAgentexProducto = request.getAgentexProductosincronizarpthisAgentexProductoInstance();
        Timestamp agentexProductosincronizarpFechaInicio = request.getAgentexProductosincronizarpFechaInicio();
        Timestamp agentexProductosincronizarpFechaFin = request.getAgentexProductosincronizarpFechaFin();

        request.checkArguments();
        AgentexProducto instance = agentexProductosincronizarpthisAgentexProducto;
        instance.setAgentexProductoFechaInicio(agentexProductosincronizarpFechaInicio);
        instance.setAgentexProductoFechaFin(agentexProductosincronizarpFechaFin);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

        return response;
    }

    // Service: CambProductoDeAsesorxProducto

    /*
     * Entry point for service CambProductoDeAsesorxProducto
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambProductoDeAsesorxProducto(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CambProductoDeAsesorxProductoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.cambProductoDeAsesorxProductoTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service CambProductoDeAsesorxProducto
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambProductoDeAsesorxProductoTxn(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CambProductoDeAsesorxProductoRequest request) throws ModelException {
        request.setAgentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoCambProductoDeAsesorxProductopthisAgentexProducto()));
        request.setAgentexProductoCambProductoDeAsesorxProductopevcProductosInstance(productosSrv.getByOIDWithHV(request.getAgentexProductoCambProductoDeAsesorxProductopevcProductos()));
        return agentexProductoSrv.cambProductoDeAsesorxProductoImplementation(request, true);
    }

    /*
     * Implements service CambProductoDeAsesorxProducto
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambProductoDeAsesorxProductoImplementation(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CambProductoDeAsesorxProductoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AgentexProducto agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto = request.getAgentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance();
        Productos agentexProductoCambProductoDeAsesorxProductopevcProductos = request.getAgentexProductoCambProductoDeAsesorxProductopevcProductosInstance();

        request.checkArguments();
        AgentexProducto instance = agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto;

        instance.add2ProductoT(agentexProductoCambProductoDeAsesorxProductopevcProductos);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.productos.siu.CambProductoDeAsesorxProductoRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.productos.siu.CambProductoDeAsesorxProductoRequest();
            relatedRequest.setProductosCambProductoDeAsesorxProductopthisProductoInstance(agentexProductoCambProductoDeAsesorxProductopevcProductos);
            relatedRequest.setProductosCambProductoDeAsesorxProductopevcAgentexProductoInstance(agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto);
            productosSrv.cambProductoDeAsesorxProductoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

        return response;
    }

    // Service: InsDominio

    /*
     * Entry point for service InsDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insDominio(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.InsDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.insDominioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insDominioTxn(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.InsDominioRequest request) throws ModelException {
        request.setAgentexProductoInsDominiopthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoInsDominiopthisAgentexProducto()));
        request.setAgentexProductoInsDominiopevcDominioInstance(dominioSrv.getByOIDWithHV(request.getAgentexProductoInsDominiopevcDominio()));
        return agentexProductoSrv.insDominioImplementation(request, true);
    }

    /*
     * Implements service InsDominio
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insDominioImplementation(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.InsDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AgentexProducto agentexProductoInsDominiopthisAgentexProducto = request.getAgentexProductoInsDominiopthisAgentexProductoInstance();
        Dominio agentexProductoInsDominiopevcDominio = request.getAgentexProductoInsDominiopevcDominioInstance();

        request.checkArguments();
        AgentexProducto instance = agentexProductoInsDominiopthisAgentexProducto;

        instance.add2Dominios(agentexProductoInsDominiopevcDominio);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.dominio.siu.InsDominioRequest();
            relatedRequest.setDominioInsDominiopthisDominioInstance(agentexProductoInsDominiopevcDominio);
            relatedRequest.setDominioInsDominiopevcAgentexProductoInstance(agentexProductoInsDominiopthisAgentexProducto);
            dominioSrv.insDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

        return response;
    }

    // Service: DelDominio

    /*
     * Entry point for service DelDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delDominio(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.DelDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.delDominioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delDominioTxn(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.DelDominioRequest request) throws ModelException {
        request.setAgentexProductoDelDominiopthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoDelDominiopthisAgentexProducto()));
        request.setAgentexProductoDelDominiopevcDominioInstance(dominioSrv.getByOIDWithHV(request.getAgentexProductoDelDominiopevcDominio()));
        return agentexProductoSrv.delDominioImplementation(request, true);
    }

    /*
     * Implements service DelDominio
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delDominioImplementation(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.DelDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AgentexProducto agentexProductoDelDominiopthisAgentexProducto = request.getAgentexProductoDelDominiopthisAgentexProductoInstance();
        Dominio agentexProductoDelDominiopevcDominio = request.getAgentexProductoDelDominiopevcDominioInstance();

        request.checkArguments();
        AgentexProducto instance = agentexProductoDelDominiopthisAgentexProducto;

        instance.removeFromDominios(agentexProductoDelDominiopevcDominio);
        agentexProductoDelDominiopevcDominio.removeFromAgentexProducto(instance);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.dominio.siu.DelDominioRequest();
            relatedRequest.setDominioDelDominiopthisDominioInstance(agentexProductoDelDominiopevcDominio);
            relatedRequest.setDominioDelDominiopevcAgentexProductoInstance(agentexProductoDelDominiopthisAgentexProducto);
            dominioSrv.delDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

        return response;
    }

    // Service: setTodosDominios

    /*
     * Entry point for service setTodosDominios
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse setTodosDominios(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SetTodosDominiosRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.setTodosDominiosTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service setTodosDominios
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse setTodosDominiosTxn(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SetTodosDominiosRequest request) throws ModelException {
        request.setAgentexProductosetTodosDominiospthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductosetTodosDominiospthisAgentexProducto()));
        return agentexProductoSrv.setTodosDominiosImplementation(request);
    }

    /*
     * Implements service setTodosDominios
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse setTodosDominiosImplementation(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SetTodosDominiosRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        AgentexProducto agentexProductosetTodosDominiospthisAgentexProducto = request.getAgentexProductosetTodosDominiospthisAgentexProductoInstance();
        Boolean agentexProductosetTodosDominiosptTodos = request.getAgentexProductosetTodosDominiosptTodos();

        request.checkArguments();
        AgentexProducto instance = agentexProductosetTodosDominiospthisAgentexProducto;
        instance.setAgentexProductoTodosDominios(agentexProductosetTodosDominiosptTodos);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TSINCRONIZARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.tSINCRONIZARTxn(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TSINCRONIZARRequest request) throws ModelException {
        request.setAgentexProductoTSINCRONIZARpthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoTSINCRONIZARpthisAgentexProducto()));
        request.setAgentexProductoTSINCRONIZARpProductoInstance(productosSrv.getByOIDWithHV(request.getAgentexProductoTSINCRONIZARpProducto()));
        return agentexProductoSrv.tSINCRONIZARImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TSINCRONIZARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Timestamp agentexProductoTSINCRONIZARptpFechaInicio = request.getAgentexProductoTSINCRONIZARptpFechaInicio();
        Timestamp agentexProductoTSINCRONIZARptpFechaFin = request.getAgentexProductoTSINCRONIZARptpFechaFin();
        Productos agentexProductoTSINCRONIZARpProducto = request.getAgentexProductoTSINCRONIZARpProductoInstance();
        AgentexProducto agentexProductoTSINCRONIZARpthisAgentexProducto = request.getAgentexProductoTSINCRONIZARpthisAgentexProductoInstance();

        request.checkArguments();
        AgentexProducto instance = agentexProductoTSINCRONIZARpthisAgentexProducto;

        com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SincronizarRequest step1Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SincronizarRequest();
        step1Request.setAgentexProductosincronizarpthisAgentexProductoInstance(agentexProductoTSINCRONIZARpthisAgentexProducto);
        step1Request.setAgentexProductosincronizarpFechaInicio(agentexProductoTSINCRONIZARptpFechaInicio);
        step1Request.setAgentexProductosincronizarpFechaFin(agentexProductoTSINCRONIZARptpFechaFin);
        agentexProductoSrv.sincronizarImplementation(step1Request);

        /* Action 2: IF (ProductoT <> pProducto) */
        boolean ifCondition2 = !(agentexProductoTSINCRONIZARpthisAgentexProducto.getProductoT().equalsObject(agentexProductoTSINCRONIZARpProducto));
        if (ifCondition2) {
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CambProductoDeAsesorxProductoRequest step20Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CambProductoDeAsesorxProductoRequest();
            step20Request.setAgentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance(agentexProductoTSINCRONIZARpthisAgentexProducto);
            step20Request.setAgentexProductoCambProductoDeAsesorxProductopevcProductosInstance(agentexProductoTSINCRONIZARpProducto);
            agentexProductoSrv.cambProductoDeAsesorxProductoImplementation(step20Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.tCREARTxn(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCREARRequest request) throws ModelException {
        request.setAgentexProductoTCREARptpagrProductoTInstance(productosSrv.getByOIDWithHV(request.getAgentexProductoTCREARptpagrProductoT()));
        request.setAgentexProductoTCREARptpagrAsesorInstance(asesorSrv.getByOIDWithHV(request.getAgentexProductoTCREARptpagrAsesor()));
        return agentexProductoSrv.tCREARImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Productos agentexProductoTCREARptpagrProductoT = request.getAgentexProductoTCREARptpagrProductoTInstance();
        Asesor agentexProductoTCREARptpagrAsesor = request.getAgentexProductoTCREARptpagrAsesorInstance();
        Timestamp agentexProductoTCREARptpatrFechaInicio = request.getAgentexProductoTCREARptpatrFechaInicio();
        Timestamp agentexProductoTCREARptpatrFechaFin = request.getAgentexProductoTCREARptpatrFechaFin();
        Long agentexProductoTCREARptpatrCodigo = request.getAgentexProductoTCREARptpatrCodigo();

        request.checkArguments();
        AgentexProducto instance;

        com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CrearRequest step1Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.CrearRequest();
        step1Request.setAgentexProductocrearpagrProductoTInstance(agentexProductoTCREARptpagrProductoT);
        step1Request.setAgentexProductocrearpagrAsesorInstance(agentexProductoTCREARptpagrAsesor);
        step1Request.setAgentexProductocrearpatrFechaInicio(agentexProductoTCREARptpatrFechaInicio);
        step1Request.setAgentexProductocrearpatrFechaFin(agentexProductoTCREARptpatrFechaFin);
        step1Request.setAgentexProductocrearpatrCodigo(agentexProductoTCREARptpatrCodigo);
        instance = (AgentexProducto) agentexProductoSrv.crearImplementation(step1Request).getInstance();

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

        return response;
    }

    // Service: TADDDOMINIO

    /*
     * Entry point for service TADDDOMINIO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tADDDOMINIO(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.tADDDOMINIOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TADDDOMINIO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tADDDOMINIOTxn(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest request) throws ModelException {
        request.setAgentexProductoTADDDOMINIOpthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoTADDDOMINIOpthisAgentexProducto()));
        request.setAgentexProductoTADDDOMINIOptpevcDominioInstance(dominioSrv.getByOIDWithHV(request.getAgentexProductoTADDDOMINIOptpevcDominio()));
        return agentexProductoSrv.tADDDOMINIOImplementation(request);
    }

    /*
     * Implements service TADDDOMINIO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tADDDOMINIOImplementation(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Dominio agentexProductoTADDDOMINIOptpevcDominio = request.getAgentexProductoTADDDOMINIOptpevcDominioInstance();
        AgentexProducto agentexProductoTADDDOMINIOpthisAgentexProducto = request.getAgentexProductoTADDDOMINIOpthisAgentexProductoInstance();

        request.checkArguments();

        tADDDOMINIOPreconditions(request);
        AgentexProducto instance = agentexProductoTADDDOMINIOpthisAgentexProducto;

        com.keralty.aeusuarios.viewmodel.agentexproducto.siu.InsDominioRequest step1Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.InsDominioRequest();
        step1Request.setAgentexProductoInsDominiopthisAgentexProductoInstance(agentexProductoTADDDOMINIOpthisAgentexProducto);
        step1Request.setAgentexProductoInsDominiopevcDominioInstance(agentexProductoTADDDOMINIOptpevcDominio);
        agentexProductoSrv.insDominioImplementation(step1Request, true);

        com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.TNEWRequest step2Request = new com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.TNEWRequest();
        step2Request.setLogHistoricoPlanesTNEWptpagrAsesorInstance(agentexProductoTADDDOMINIOpthisAgentexProducto.getAsesor());
        step2Request.setLogHistoricoPlanesTNEWptpatrProducto(agentexProductoTADDDOMINIOpthisAgentexProducto.getProductoT().getProductosCodigoLegal());
        step2Request.setLogHistoricoPlanesTNEWptpatrPlan(agentexProductoTADDDOMINIOptpevcDominio.getPlanT().getPlanesCodigoLegal());
        step2Request.setLogHistoricoPlanesTNEWptpatrAccion("Añadido");
        logHistoricoPlanesSrv.tNEWImplementation(step2Request);

        com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SetTodosDominiosRequest step3Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SetTodosDominiosRequest();
        step3Request.setAgentexProductosetTodosDominiospthisAgentexProductoInstance(agentexProductoTADDDOMINIOpthisAgentexProducto);
        step3Request.setAgentexProductosetTodosDominiosptTodos(Boolean.FALSE);
        agentexProductoSrv.setTodosDominiosImplementation(step3Request);

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

        return response;
    }

    /*
     * Checks service TADDDOMINIO preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse tADDDOMINIOCheckPreconditions(com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setAgentexProductoTADDDOMINIOpthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoTADDDOMINIOpthisAgentexProducto()));
        request.setAgentexProductoTADDDOMINIOptpevcDominioInstance(dominioSrv.getByOIDWithHV(request.getAgentexProductoTADDDOMINIOptpevcDominio()));
        try {
            if("Clas_1460560723968553Pre_1".equals(request.getPreconditionId()))
                checkClas1460560723968553Pre1(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void tADDDOMINIOPreconditions(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest request) 
            throws ModelException {
        checkClas1460560723968553Pre1(request);
    }

    private void checkClas1460560723968553Pre1 (
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest request) 
            throws ModelException {
        // EXIST( ProductoT.Dominios ) WHERE (ProductoT.Dominios = ptpevcDominio) = true

        Dominio agentexProductoTADDDOMINIOptpevcDominio = request.getAgentexProductoTADDDOMINIOptpevcDominioInstance();
        AgentexProducto agentexProductoTADDDOMINIOpthisAgentexProducto = request.getAgentexProductoTADDDOMINIOpthisAgentexProductoInstance();
        try {
            boolean preconditionHolds = repository.assocOperator000(agentexProductoTADDDOMINIOpthisAgentexProducto, agentexProductoTADDDOMINIOptpevcDominio).equals(true);
            if (!preconditionHolds) throw new PreconditionException("Debe seleccionar un Dominio del producto");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: TDELDOMINIO

    /*
     * Entry point for service TDELDOMINIO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tDELDOMINIO(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TDELDOMINIORequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.tDELDOMINIOTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TDELDOMINIO
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tDELDOMINIOTxn(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TDELDOMINIORequest request) throws ModelException, SystemException {
        request.setAgentexProductoTDELDOMINIOpthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoTDELDOMINIOpthisAgentexProducto()));
        request.setAgentexProductoTDELDOMINIOptpevcDominioInstance(dominioSrv.getByOIDWithHV(request.getAgentexProductoTDELDOMINIOptpevcDominio()));
        return agentexProductoSrv.tDELDOMINIOImplementation(request);
    }

    /*
     * Implements service TDELDOMINIO
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tDELDOMINIOImplementation(
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TDELDOMINIORequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        Dominio agentexProductoTDELDOMINIOptpevcDominio = request.getAgentexProductoTDELDOMINIOptpevcDominioInstance();
        AgentexProducto agentexProductoTDELDOMINIOpthisAgentexProducto = request.getAgentexProductoTDELDOMINIOpthisAgentexProductoInstance();

        request.checkArguments();
        AgentexProducto instance = agentexProductoTDELDOMINIOpthisAgentexProducto;

        com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.TNEWRequest step1Request = new com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.TNEWRequest();
        step1Request.setLogHistoricoPlanesTNEWptpagrAsesorInstance(agentexProductoTDELDOMINIOpthisAgentexProducto.getAsesor());
        step1Request.setLogHistoricoPlanesTNEWptpatrProducto(agentexProductoTDELDOMINIOpthisAgentexProducto.getProductoT().getProductosCodigoLegal());
        step1Request.setLogHistoricoPlanesTNEWptpatrPlan(agentexProductoTDELDOMINIOptpevcDominio.getPlanT().getPlanesCodigoLegal());
        step1Request.setLogHistoricoPlanesTNEWptpatrAccion("Eliminado");
        logHistoricoPlanesSrv.tNEWImplementation(step1Request);

        com.keralty.aeusuarios.viewmodel.agentexproducto.siu.DelDominioRequest step2Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.DelDominioRequest();
        step2Request.setAgentexProductoDelDominiopthisAgentexProductoInstance(agentexProductoTDELDOMINIOpthisAgentexProducto);
        step2Request.setAgentexProductoDelDominiopevcDominioInstance(agentexProductoTDELDOMINIOptpevcDominio);
        agentexProductoSrv.delDominioImplementation(step2Request, true);

        boolean guard3 = (repository.assocOperator001(agentexProductoTDELDOMINIOpthisAgentexProducto)).equals(Long.valueOf(0));

        if (guard3) {
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SetTodosDominiosRequest step3Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.SetTodosDominiosRequest();
            step3Request.setAgentexProductosetTodosDominiospthisAgentexProductoInstance(agentexProductoTDELDOMINIOpthisAgentexProducto);
            step3Request.setAgentexProductosetTodosDominiosptTodos(Boolean.TRUE);
            agentexProductoSrv.setTodosDominiosImplementation(step3Request);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCARGARDOMINIOPLANRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = agentexProductoSrv.tCARGARDOMINIOPLANTxn(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCARGARDOMINIOPLANRequest request) throws ModelException, SystemException {
        request.setAgentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getAgentexProductoTCARGARDOMINIOPLANpthisAgentexProducto()));
        return agentexProductoSrv.tCARGARDOMINIOPLANImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCARGARDOMINIOPLANRequest request) throws ModelException, SystemException {
        ServiceResponse response = new ServiceResponse();
        String agentexProductoTCARGARDOMINIOPLANptAccion = request.getAgentexProductoTCARGARDOMINIOPLANptAccion();
        String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan = request.getAgentexProductoTCARGARDOMINIOPLANptCodLegalPlan();
        AgentexProducto agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto = request.getAgentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance();

        request.checkArguments();
        AgentexProducto instance = agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto;

        /* Action 1: IF (ptAccion = "1") */
        boolean ifCondition1 = (agentexProductoTCARGARDOMINIOPLANptAccion).equals("1");
        if (ifCondition1) {
            /* Action 10: IF (EXIST (Dominios) WHERE (Dominios.PlanT.CodigoLegal = ptCodLegalPlan) = false) */
            boolean ifCondition10 = repository.assocOperator005(agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan).equals(false);
            if (ifCondition10) {
                for(Dominio step1100Entity : repository.assocOperator003(agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan)) {
                    com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest step100Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest();
                    step100Request.setAgentexProductoTADDDOMINIOpthisAgentexProductoInstance(agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto);
                    step100Request.setAgentexProductoTADDDOMINIOptpevcDominioInstance(step1100Entity);
                    agentexProductoSrv.tADDDOMINIOImplementation(step100Request);
                }
            }
        } else {
            for(Dominio step111Entity : repository.assocOperator004(agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto, agentexProductoTCARGARDOMINIOPLANptCodLegalPlan)) {
                com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TDELDOMINIORequest step11Request = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TDELDOMINIORequest();
                step11Request.setAgentexProductoTDELDOMINIOpthisAgentexProductoInstance(agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto);
                step11Request.setAgentexProductoTDELDOMINIOptpevcDominioInstance(step111Entity);
                agentexProductoSrv.tDELDOMINIOImplementation(step11Request);
            }
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICAgentexProducto());

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
        // Asesor = agent OR Asesor.CodJefe = Agent.Usuario
        Asesor agentInstance = getAgentAsesor();
    {
        // 'or' Logical operator
        SQLWhereDisjunction comparison1 = new SQLWhereDisjunction();
    
        // Operand 1
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(AgentexProductoConstants.ROLE_NAME_ASESOR, AsesorConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
            comparison2.setSecondOperand(operand224);
            comparison1.addOperand(comparison2);
    
        // Operand 2
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_ASESOR + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(agentInstance.getFuncionarioUsuario(), Constants.Type.STRING.getTypeName()));
            comparison1.addOperand(comparison4);
        
        disjunction.addOperand(comparison1);
    }

    }


    private void suppInfo4ICAgentexProducto(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_ASESOR + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIODRVNOMBRECOMPLETO, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereComparison comparison2 = new SQLWhereComparison(select);
            comparison2.setOperator("LIKE");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ATTR_NAME_PRODUCTOSDESCRIPCION, Constants.Type.STRING.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison2);

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
        select.getOrderByPart().addItem(Constants.normalizePath(AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.ROLE_NAME_ASESOR + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, false), true);
        select.getOrderByPart().addItem(Constants.normalizePath(AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.ATTR_FIELD_AGENTEXPRODUCTOID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildAgentexProductoRelatedInstance(relatedInstanceJsonOid);
        }
        if (AgentexProductoConstants.ROLE_NAME_PRODUCTOT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAgentexProductoRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        if (AgentexProductoConstants.ROLE_NAME_ASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAgentexProductoRelatedInstance4Asesor(relatedInstanceJsonOid, remainingPath);
        }
        if (AgentexProductoConstants.ROLE_NAME_DOMINIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildAgentexProductoRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildAgentexProductoRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAgentexProductoRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAgentexProductoRelatedInstance4Asesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Asesor(mapper.readValue(relatedInstanceJsonOid, AsesorOid.class)): Asesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildAgentexProductoRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AgentexProductoOid oid = new AgentexProductoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AgentexProductoConstants.ROLE_NAME_ASESOR + "." + FuncionarioConstants.ATTR_FIELD_FUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFuncionarioAsesorId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(AgentexProductoConstants.ATTR_FIELD_AGENTEXPRODUCTOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getAgentexProductoId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(AgentexProductoService.class).error(e.getMessage());
        }
    }

}
