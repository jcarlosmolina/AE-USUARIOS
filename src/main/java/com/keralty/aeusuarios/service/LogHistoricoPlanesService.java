package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.LogHistoricoPlanesConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.LogHistoricoPlanesOid;
import com.keralty.aeusuarios.repository.LogHistoricoPlanesJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.viewmodel.FilterRequest;
import com.keralty.aeusuarios.viewmodel.FilterVariableRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class LogHistoricoPlanesService extends AbstractService {

    LogHistoricoPlanesJpaRepository repository;

    LogHistoricoPlanesService logHistoricoPlanesSrv;

    @Inject
    public LogHistoricoPlanesService(
            LogHistoricoPlanesService logHistoricoPlanesSrv,
            LogHistoricoPlanesJpaRepository repository) {
        this.logHistoricoPlanesSrv = logHistoricoPlanesSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, LogHistoricoPlanesConstants.CLASS_NAME);
    }

    private List<LogHistoricoPlanes> solveLogHistoricoPlanesTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, LogHistoricoPlanesConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveLogHistoricoPlanesTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, LogHistoricoPlanesConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class LogHistoricoPlanes
     *
     * @return Population of class LogHistoricoPlanes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogHistoricoPlanes> get() {
        List<LogHistoricoPlanes> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class LogHistoricoPlanes that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class LogHistoricoPlanes matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogHistoricoPlanes> get(QueryRequest queryRequest) {
        return solveLogHistoricoPlanesTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveLogHistoricoPlanesTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveLogHistoricoPlanesTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
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
        return new PopulationResponseViewModel(solveLogHistoricoPlanesTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of LogHistoricoPlanes by ID
     *
     * @param logHistoricoPlanesidLogHistoricoPlanes Identification field logHistoricoPlanesidLogHistoricoPlanes
     *
     * @return Instance of LogHistoricoPlanes
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogHistoricoPlanes getById(Long logHistoricoPlanesidLogHistoricoPlanes) {
        return getByOID(new LogHistoricoPlanesOid(logHistoricoPlanesidLogHistoricoPlanes));
    }
    
    /*
     * Returns an instance of LogHistoricoPlanes by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogHistoricoPlanes
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogHistoricoPlanes getByOID(LogHistoricoPlanesOid oid) {
        Optional<LogHistoricoPlanes> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of LogHistoricoPlanes by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogHistoricoPlanes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public LogHistoricoPlanes getByOIDWithHV(LogHistoricoPlanesOid oid) {
        Optional<LogHistoricoPlanes> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<LogHistoricoPlanes> getInstanceByOid(LogHistoricoPlanesOid oid) {
        return oid != null && oid.getLogHistoricoPlanesidLogHistoricoPlanes() != null
               ? repository.findById(oid.getLogHistoricoPlanesidLogHistoricoPlanes())
               : Optional.empty();
    }

    /*
     * Returns an instance of LogHistoricoPlanes by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of LogHistoricoPlanes
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public LogHistoricoPlanes getByJsonOid(String jsonOid) {
        LogHistoricoPlanesOid oid = new LogHistoricoPlanesOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of LogHistoricoPlanes related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogHistoricoPlanes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogHistoricoPlanes> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveLogHistoricoPlanesTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of LogHistoricoPlanes related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogHistoricoPlanes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogHistoricoPlanes> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of LogHistoricoPlanes
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of LogHistoricoPlanes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getLogHistoricoPlanesDynamic(LogHistoricoPlanesOid oid, String displaySetItems) {
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
    public String getSuppInfo(LogHistoricoPlanesOid oid, String dsName) {
        LogHistoricoPlanes instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(LogHistoricoPlanes instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIULogHistoricoPlanes
     *
     * @param queryRequest Query request
     * @return List of viewmodels for LogHistoricoPlanes using displayset DSLogHistoricoPlanes that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.loghistoricoplanes.ds.DSLogHistoricoPlanes> piuPIULogHistoricoPlanes(QueryRequest queryRequest) {
        return solveLogHistoricoPlanesTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.loghistoricoplanes.ds.DSLogHistoricoPlanes::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIULogHistoricoPlanes
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIULogHistoricoPlanes
     */
    public int getCount4PIULogHistoricoPlanes(QueryRequest queryRequest) {
        return solveLogHistoricoPlanesTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logHistoricoPlanesSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.CrearRequest request) throws ModelException {
        request.setLogHistoricoPlanescrearpagrAsesorInstance(asesorSrv.getByOIDWithHV(request.getLogHistoricoPlanescrearpagrAsesor()));
        return logHistoricoPlanesSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor logHistoricoPlanescrearpagrAsesor = request.getLogHistoricoPlanescrearpagrAsesorInstance();
        String logHistoricoPlanescrearpatrLoginFuncionario = request.getLogHistoricoPlanescrearpatrLoginFuncionario();
        String logHistoricoPlanescrearpatrProducto = request.getLogHistoricoPlanescrearpatrProducto();
        String logHistoricoPlanescrearpatrPlan = request.getLogHistoricoPlanescrearpatrPlan();
        String logHistoricoPlanescrearpatrAccion = request.getLogHistoricoPlanescrearpatrAccion();

        request.checkArguments();
        LogHistoricoPlanes instance = new LogHistoricoPlanes();
        instance.add2Asesor(logHistoricoPlanescrearpagrAsesor);

        instance.setLogHistoricoPlanesidLogHistoricoPlanes(Long.valueOf(0));
        instance.setLogHistoricoPlanesFechaHora(STDFunctions.systemDateTimeFun());
        instance.setLogHistoricoPlanesLoginFuncionario(logHistoricoPlanescrearpatrLoginFuncionario);
        instance.setLogHistoricoPlanesProducto(logHistoricoPlanescrearpatrProducto);
        instance.setLogHistoricoPlanesPlan(logHistoricoPlanescrearpatrPlan);
        instance.setLogHistoricoPlanesAccion(logHistoricoPlanescrearpatrAccion);

        response.setInstance(repository.save(instance));

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
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logHistoricoPlanesSrv.eliminarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.EliminarRequest request) throws ModelException {
        request.setLogHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance(logHistoricoPlanesSrv.getByOIDWithHV(request.getLogHistoricoPlaneseliminarpthisLogHistoricoPlanes()));
        return logHistoricoPlanesSrv.eliminarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        LogHistoricoPlanes logHistoricoPlaneseliminarpthisLogHistoricoPlanes = request.getLogHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance();

        request.checkArguments();
        LogHistoricoPlanes instance = logHistoricoPlaneseliminarpthisLogHistoricoPlanes;


        repository.delete(instance);
        
        response.setInstance(instance);

        return response;
    }

    // Service: TNEW

    /*
     * Entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse tNEW(
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.TNEWRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logHistoricoPlanesSrv.tNEWTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service TNEW
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse tNEWTxn(
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.TNEWRequest request) throws ModelException {
        request.setLogHistoricoPlanesTNEWptpagrAsesorInstance(asesorSrv.getByOIDWithHV(request.getLogHistoricoPlanesTNEWptpagrAsesor()));
        return logHistoricoPlanesSrv.tNEWImplementation(request);
    }

    /*
     * Implements service TNEW
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse tNEWImplementation(
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.TNEWRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor logHistoricoPlanesTNEWptpagrAsesor = request.getLogHistoricoPlanesTNEWptpagrAsesorInstance();
        String logHistoricoPlanesTNEWptpatrProducto = request.getLogHistoricoPlanesTNEWptpatrProducto();
        String logHistoricoPlanesTNEWptpatrPlan = request.getLogHistoricoPlanesTNEWptpatrPlan();
        String logHistoricoPlanesTNEWptpatrAccion = request.getLogHistoricoPlanesTNEWptpatrAccion();

        request.checkArguments();
        LogHistoricoPlanes instance;

        /* Action 1: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition1 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.CrearRequest();
            step10Request.setLogHistoricoPlanescrearpagrAsesorInstance(logHistoricoPlanesTNEWptpagrAsesor);
            step10Request.setLogHistoricoPlanescrearpatrLoginFuncionario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
            step10Request.setLogHistoricoPlanescrearpatrProducto(logHistoricoPlanesTNEWptpatrProducto);
            step10Request.setLogHistoricoPlanescrearpatrPlan(logHistoricoPlanesTNEWptpatrPlan);
            step10Request.setLogHistoricoPlanescrearpatrAccion(logHistoricoPlanesTNEWptpatrAccion);
            instance = (LogHistoricoPlanes) logHistoricoPlanesSrv.crearImplementation(step10Request).getInstance();
        } else {
            com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.CrearRequest step11Request = new com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu.CrearRequest();
            step11Request.setLogHistoricoPlanescrearpagrAsesorInstance(logHistoricoPlanesTNEWptpagrAsesor);
            step11Request.setLogHistoricoPlanescrearpatrLoginFuncionario("usuicafile");
            step11Request.setLogHistoricoPlanescrearpatrProducto(logHistoricoPlanesTNEWptpatrProducto);
            step11Request.setLogHistoricoPlanescrearpatrPlan(logHistoricoPlanesTNEWptpatrPlan);
            step11Request.setLogHistoricoPlanescrearpatrAccion(logHistoricoPlanesTNEWptpatrAccion);
            instance = (LogHistoricoPlanes) logHistoricoPlanesSrv.crearImplementation(step11Request).getInstance();
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCLogHistoricoPlanes(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(LogHistoricoPlanesConstants.CLASS_NAME, LogHistoricoPlanesConstants.ATTR_FIELD_LOGHISTORICOPLANESIDLOGHISTORICOPLANES, false), true);
    }


    private void applyOCOCLogHistoricoPlanes(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_LogHistoricoPlanes".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(LogHistoricoPlanesConstants.CLASS_NAME, LogHistoricoPlanesConstants.ATTR_NAME_LOGHISTORICOPLANESFECHAHORA, false), false);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildLogHistoricoPlanesRelatedInstance(relatedInstanceJsonOid);
        }
        if (LogHistoricoPlanesConstants.ROLE_NAME_ASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildLogHistoricoPlanesRelatedInstance4Asesor(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildLogHistoricoPlanesRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new LogHistoricoPlanes(mapper.readValue(relatedInstanceJsonOid, LogHistoricoPlanesOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildLogHistoricoPlanesRelatedInstance4Asesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Asesor(mapper.readValue(relatedInstanceJsonOid, AsesorOid.class)): Asesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            LogHistoricoPlanesOid oid = new LogHistoricoPlanesOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(LogHistoricoPlanesConstants.ATTR_FIELD_LOGHISTORICOPLANESIDLOGHISTORICOPLANES, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getLogHistoricoPlanesidLogHistoricoPlanes(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(LogHistoricoPlanesService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
