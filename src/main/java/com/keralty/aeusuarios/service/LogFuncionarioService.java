package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.LogFuncionarioConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.LogFuncionarioOid;
import com.keralty.aeusuarios.repository.LogFuncionarioJpaRepository;
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
public class LogFuncionarioService extends AbstractService {

    LogFuncionarioJpaRepository repository;

    LogFuncionarioService logFuncionarioSrv;

    @Inject
    public LogFuncionarioService(
            LogFuncionarioService logFuncionarioSrv,
            LogFuncionarioJpaRepository repository) {
        this.logFuncionarioSrv = logFuncionarioSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, LogFuncionarioConstants.CLASS_NAME);
    }

    private List<LogFuncionario> solveLogFuncionarioTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, LogFuncionarioConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveLogFuncionarioTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, LogFuncionarioConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class LogFuncionario
     *
     * @return Population of class LogFuncionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogFuncionario> get() {
        List<LogFuncionario> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class LogFuncionario that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class LogFuncionario matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogFuncionario> get(QueryRequest queryRequest) {
        return solveLogFuncionarioTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveLogFuncionarioTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveLogFuncionarioTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveLogFuncionarioTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of LogFuncionario by ID
     *
     * @param logFuncionarioId Identification field logFuncionarioId
     *
     * @return Instance of LogFuncionario
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogFuncionario getById(Long logFuncionarioId) {
        return getByOID(new LogFuncionarioOid(logFuncionarioId));
    }
    
    /*
     * Returns an instance of LogFuncionario by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogFuncionario
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogFuncionario getByOID(LogFuncionarioOid oid) {
        Optional<LogFuncionario> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of LogFuncionario by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogFuncionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public LogFuncionario getByOIDWithHV(LogFuncionarioOid oid) {
        Optional<LogFuncionario> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<LogFuncionario> getInstanceByOid(LogFuncionarioOid oid) {
        return oid != null && oid.getLogFuncionarioId() != null
               ? repository.findById(oid.getLogFuncionarioId())
               : Optional.empty();
    }

    /*
     * Returns an instance of LogFuncionario by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of LogFuncionario
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public LogFuncionario getByJsonOid(String jsonOid) {
        LogFuncionarioOid oid = new LogFuncionarioOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of LogFuncionario related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogFuncionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogFuncionario> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveLogFuncionarioTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of LogFuncionario related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogFuncionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogFuncionario> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of LogFuncionario
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of LogFuncionario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getLogFuncionarioDynamic(LogFuncionarioOid oid, String displaySetItems) {
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
    public String getSuppInfo(LogFuncionarioOid oid, String dsName) {
        LogFuncionario instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(LogFuncionario instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIULogFuncionario
     *
     * @param queryRequest Query request
     * @return List of viewmodels for LogFuncionario using displayset DSLogFuncionario that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.logfuncionario.ds.DSLogFuncionario> piuPIULogFuncionario(QueryRequest queryRequest) {
        return solveLogFuncionarioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.logfuncionario.ds.DSLogFuncionario::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIULogFuncionario
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIULogFuncionario
     */
    public int getCount4PIULogFuncionario(QueryRequest queryRequest) {
        return solveLogFuncionarioTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logFuncionarioSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.CrearRequest request) throws ModelException {
        request.setLogFuncionariocrearpagrFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getLogFuncionariocrearpagrFuncionario()));
        return logFuncionarioSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario logFuncionariocrearpagrFuncionario = request.getLogFuncionariocrearpagrFuncionarioInstance();
        String logFuncionariocrearpatrLoginFuncionario = request.getLogFuncionariocrearpatrLoginFuncionario();
        Boolean logFuncionariocrearpatrDisponible = request.getLogFuncionariocrearpatrDisponible();

        request.checkArguments();
        LogFuncionario instance = new LogFuncionario();
        instance.add2Funcionario(logFuncionariocrearpagrFuncionario);

        instance.setLogFuncionarioId(Long.valueOf(0));
        instance.setLogFuncionarioFecha(STDFunctions.systemDateTimeFun());
        instance.setLogFuncionarioLoginFuncionario(logFuncionariocrearpatrLoginFuncionario);
        instance.setLogFuncionarioDisponible(logFuncionariocrearpatrDisponible);

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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logFuncionarioSrv.eliminarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.EliminarRequest request) throws ModelException {
        request.setLogFuncionarioeliminarpthisLogFuncoinarioInstance(logFuncionarioSrv.getByOIDWithHV(request.getLogFuncionarioeliminarpthisLogFuncoinario()));
        return logFuncionarioSrv.eliminarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        LogFuncionario logFuncionarioeliminarpthisLogFuncoinario = request.getLogFuncionarioeliminarpthisLogFuncoinarioInstance();

        request.checkArguments();
        LogFuncionario instance = logFuncionarioeliminarpthisLogFuncoinario;


        repository.delete(instance);
        
        response.setInstance(instance);

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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.TCREARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logFuncionarioSrv.tCREARTxn(request);
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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.TCREARRequest request) throws ModelException {
        request.setLogFuncionarioTCREARptpagrFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getLogFuncionarioTCREARptpagrFuncionario()));
        return logFuncionarioSrv.tCREARImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.TCREARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Funcionario logFuncionarioTCREARptpagrFuncionario = request.getLogFuncionarioTCREARptpagrFuncionarioInstance();
        Boolean logFuncionarioTCREARptpatrDisponible = request.getLogFuncionarioTCREARptpatrDisponible();

        request.checkArguments();
        LogFuncionario instance;

        /* Action 1: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition1 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.logfuncionario.siu.CrearRequest();
            step10Request.setLogFuncionariocrearpagrFuncionarioInstance(logFuncionarioTCREARptpagrFuncionario);
            step10Request.setLogFuncionariocrearpatrLoginFuncionario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
            step10Request.setLogFuncionariocrearpatrDisponible(logFuncionarioTCREARptpatrDisponible);
            instance = (LogFuncionario) logFuncionarioSrv.crearImplementation(step10Request).getInstance();
        } else {
            com.keralty.aeusuarios.viewmodel.logfuncionario.siu.CrearRequest step11Request = new com.keralty.aeusuarios.viewmodel.logfuncionario.siu.CrearRequest();
            step11Request.setLogFuncionariocrearpagrFuncionarioInstance(logFuncionarioTCREARptpagrFuncionario);
            step11Request.setLogFuncionariocrearpatrLoginFuncionario("usuicafile");
            step11Request.setLogFuncionariocrearpatrDisponible(logFuncionarioTCREARptpatrDisponible);
            instance = (LogFuncionario) logFuncionarioSrv.crearImplementation(step11Request).getInstance();
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCLogFuncionario(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(LogFuncionarioConstants.CLASS_NAME, LogFuncionarioConstants.ATTR_FIELD_LOGFUNCIONARIOID, false), true);
    }


    private void applyOCOCLogFuncionario(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_LogFuncionario".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(LogFuncionarioConstants.CLASS_NAME, LogFuncionarioConstants.ATTR_NAME_LOGFUNCIONARIOFECHA, false), false);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildLogFuncionarioRelatedInstance(relatedInstanceJsonOid);
        }
        if (LogFuncionarioConstants.ROLE_NAME_FUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildLogFuncionarioRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildLogFuncionarioRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new LogFuncionario(mapper.readValue(relatedInstanceJsonOid, LogFuncionarioOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildLogFuncionarioRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): Funcionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            LogFuncionarioOid oid = new LogFuncionarioOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(LogFuncionarioConstants.ATTR_FIELD_LOGFUNCIONARIOID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getLogFuncionarioId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(LogFuncionarioService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
