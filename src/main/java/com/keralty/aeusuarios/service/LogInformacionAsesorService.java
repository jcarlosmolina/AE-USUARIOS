package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.LogInformacionAsesorConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.LogInformacionAsesorOid;
import com.keralty.aeusuarios.repository.LogInformacionAsesorJpaRepository;
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
public class LogInformacionAsesorService extends AbstractService {

    LogInformacionAsesorJpaRepository repository;

    LogInformacionAsesorService logInformacionAsesorSrv;

    @Inject
    public LogInformacionAsesorService(
            LogInformacionAsesorService logInformacionAsesorSrv,
            LogInformacionAsesorJpaRepository repository) {
        this.logInformacionAsesorSrv = logInformacionAsesorSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, LogInformacionAsesorConstants.CLASS_NAME);
    }

    private List<LogInformacionAsesor> solveLogInformacionAsesorTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, LogInformacionAsesorConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveLogInformacionAsesorTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, LogInformacionAsesorConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class LogInformacionAsesor
     *
     * @return Population of class LogInformacionAsesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogInformacionAsesor> get() {
        List<LogInformacionAsesor> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class LogInformacionAsesor that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class LogInformacionAsesor matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogInformacionAsesor> get(QueryRequest queryRequest) {
        return solveLogInformacionAsesorTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveLogInformacionAsesorTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveLogInformacionAsesorTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveLogInformacionAsesorTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of LogInformacionAsesor by ID
     *
     * @param logInformacionAsesoridLogInformacionAsesor Identification field logInformacionAsesoridLogInformacionAsesor
     *
     * @return Instance of LogInformacionAsesor
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogInformacionAsesor getById(Long logInformacionAsesoridLogInformacionAsesor) {
        return getByOID(new LogInformacionAsesorOid(logInformacionAsesoridLogInformacionAsesor));
    }
    
    /*
     * Returns an instance of LogInformacionAsesor by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogInformacionAsesor
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public LogInformacionAsesor getByOID(LogInformacionAsesorOid oid) {
        Optional<LogInformacionAsesor> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of LogInformacionAsesor by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of LogInformacionAsesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public LogInformacionAsesor getByOIDWithHV(LogInformacionAsesorOid oid) {
        Optional<LogInformacionAsesor> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<LogInformacionAsesor> getInstanceByOid(LogInformacionAsesorOid oid) {
        return oid != null && oid.getLogInformacionAsesoridLogInformacionAsesor() != null
               ? repository.findById(oid.getLogInformacionAsesoridLogInformacionAsesor())
               : Optional.empty();
    }

    /*
     * Returns an instance of LogInformacionAsesor by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of LogInformacionAsesor
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public LogInformacionAsesor getByJsonOid(String jsonOid) {
        LogInformacionAsesorOid oid = new LogInformacionAsesorOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of LogInformacionAsesor related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogInformacionAsesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogInformacionAsesor> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveLogInformacionAsesorTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of LogInformacionAsesor related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of LogInformacionAsesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<LogInformacionAsesor> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of LogInformacionAsesor
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of LogInformacionAsesor
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getLogInformacionAsesorDynamic(LogInformacionAsesorOid oid, String displaySetItems) {
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
    public String getSuppInfo(LogInformacionAsesorOid oid, String dsName) {
        LogInformacionAsesor instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(LogInformacionAsesor instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIULogInformacionAsesor
     *
     * @param queryRequest Query request
     * @return List of viewmodels for LogInformacionAsesor using displayset DSLogInformacionAsesor that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.loginformacionasesor.ds.DSLogInformacionAsesor> piuPIULogInformacionAsesor(QueryRequest queryRequest) {
        return solveLogInformacionAsesorTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.loginformacionasesor.ds.DSLogInformacionAsesor::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIULogInformacionAsesor
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIULogInformacionAsesor
     */
    public int getCount4PIULogInformacionAsesor(QueryRequest queryRequest) {
        return solveLogInformacionAsesorTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logInformacionAsesorSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.CrearRequest request) throws ModelException {
        request.setLogInformacionAsesorcrearpagrAsesorInstance(asesorSrv.getByOIDWithHV(request.getLogInformacionAsesorcrearpagrAsesor()));
        return logInformacionAsesorSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor logInformacionAsesorcrearpagrAsesor = request.getLogInformacionAsesorcrearpagrAsesorInstance();
        Boolean logInformacionAsesorcrearpatrVerDatosPersona = request.getLogInformacionAsesorcrearpatrVerDatosPersona();
        Boolean logInformacionAsesorcrearpatrVerDocsPersona = request.getLogInformacionAsesorcrearpatrVerDocsPersona();
        Boolean logInformacionAsesorcrearpatrVerContratoNovedad = request.getLogInformacionAsesorcrearpatrVerContratoNovedad();
        String logInformacionAsesorcrearpatrLoginFuncionario = request.getLogInformacionAsesorcrearpatrLoginFuncionario();
        Boolean logInformacionAsesorcrearpatrAccesoValidadorUsuarios = request.getLogInformacionAsesorcrearpatrAccesoValidadorUsuarios();

        request.checkArguments();
        LogInformacionAsesor instance = new LogInformacionAsesor();
        instance.add2Asesor(logInformacionAsesorcrearpagrAsesor);

        instance.setLogInformacionAsesoridLogInformacionAsesor(Long.valueOf(0));
        instance.setLogInformacionAsesorFechaHora(STDFunctions.systemDateTimeFun());
        instance.setLogInformacionAsesorVerDatosPersona(logInformacionAsesorcrearpatrVerDatosPersona);
        instance.setLogInformacionAsesorVerDocsPersona(logInformacionAsesorcrearpatrVerDocsPersona);
        instance.setLogInformacionAsesorVerContratoNovedad(logInformacionAsesorcrearpatrVerContratoNovedad);
        instance.setLogInformacionAsesorLoginFuncionario(logInformacionAsesorcrearpatrLoginFuncionario);
        instance.setLogInformacionAsesorAccesoValidadorUsuarios(logInformacionAsesorcrearpatrAccesoValidadorUsuarios);

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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logInformacionAsesorSrv.eliminarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.EliminarRequest request) throws ModelException {
        request.setLogInformacionAsesoreliminarpthisLogInformacionAsesorInstance(logInformacionAsesorSrv.getByOIDWithHV(request.getLogInformacionAsesoreliminarpthisLogInformacionAsesor()));
        return logInformacionAsesorSrv.eliminarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        LogInformacionAsesor logInformacionAsesoreliminarpthisLogInformacionAsesor = request.getLogInformacionAsesoreliminarpthisLogInformacionAsesorInstance();

        request.checkArguments();
        LogInformacionAsesor instance = logInformacionAsesoreliminarpthisLogInformacionAsesor;


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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.TNEWRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = logInformacionAsesorSrv.tNEWTxn(request);
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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.TNEWRequest request) throws ModelException {
        request.setLogInformacionAsesorTNEWptpagrAsesorInstance(asesorSrv.getByOIDWithHV(request.getLogInformacionAsesorTNEWptpagrAsesor()));
        return logInformacionAsesorSrv.tNEWImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.TNEWRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Asesor logInformacionAsesorTNEWptpagrAsesor = request.getLogInformacionAsesorTNEWptpagrAsesorInstance();
        Boolean logInformacionAsesorTNEWptpatrVerDatosPersona = request.getLogInformacionAsesorTNEWptpatrVerDatosPersona();
        Boolean logInformacionAsesorTNEWptpatrVerDocsPersona = request.getLogInformacionAsesorTNEWptpatrVerDocsPersona();
        Boolean logInformacionAsesorTNEWptpatrVerContratoNovedad = request.getLogInformacionAsesorTNEWptpatrVerContratoNovedad();
        Boolean logInformacionAsesorTNEWpatrAccesoValidadorUsuarios = request.getLogInformacionAsesorTNEWpatrAccesoValidadorUsuarios();

        request.checkArguments();
        LogInformacionAsesor instance;

        /* Action 1: IF (AGENTFuncionario <> NULL) */
        boolean ifCondition1 = (((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)) != null && !((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).isNull());
        if (ifCondition1) {
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.CrearRequest step10Request = new com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.CrearRequest();
            step10Request.setLogInformacionAsesorcrearpagrAsesorInstance(logInformacionAsesorTNEWptpagrAsesor);
            step10Request.setLogInformacionAsesorcrearpatrVerDatosPersona(logInformacionAsesorTNEWptpatrVerDatosPersona);
            step10Request.setLogInformacionAsesorcrearpatrVerDocsPersona(logInformacionAsesorTNEWptpatrVerDocsPersona);
            step10Request.setLogInformacionAsesorcrearpatrVerContratoNovedad(logInformacionAsesorTNEWptpatrVerContratoNovedad);
            step10Request.setLogInformacionAsesorcrearpatrLoginFuncionario(((Funcionario) getAgentInstance(FuncionarioConstants.CLASS_NAME)).getFuncionarioUsuarioLDAP());
            step10Request.setLogInformacionAsesorcrearpatrAccesoValidadorUsuarios(logInformacionAsesorTNEWpatrAccesoValidadorUsuarios);
            instance = (LogInformacionAsesor) logInformacionAsesorSrv.crearImplementation(step10Request).getInstance();
        } else {
            com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.CrearRequest step11Request = new com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu.CrearRequest();
            step11Request.setLogInformacionAsesorcrearpagrAsesorInstance(logInformacionAsesorTNEWptpagrAsesor);
            step11Request.setLogInformacionAsesorcrearpatrVerDatosPersona(logInformacionAsesorTNEWptpatrVerDatosPersona);
            step11Request.setLogInformacionAsesorcrearpatrVerDocsPersona(logInformacionAsesorTNEWptpatrVerDocsPersona);
            step11Request.setLogInformacionAsesorcrearpatrVerContratoNovedad(logInformacionAsesorTNEWptpatrVerContratoNovedad);
            step11Request.setLogInformacionAsesorcrearpatrLoginFuncionario("usuicafile");
            step11Request.setLogInformacionAsesorcrearpatrAccesoValidadorUsuarios(logInformacionAsesorTNEWpatrAccesoValidadorUsuarios);
            instance = (LogInformacionAsesor) logInformacionAsesorSrv.crearImplementation(step11Request).getInstance();
        }

        response.setInstance(getByOID(instance.getOid()));

        return response;
    }

    @Override
    protected void applyOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        applyOCOCLogInformacionAsesor(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(LogInformacionAsesorConstants.CLASS_NAME, LogInformacionAsesorConstants.ATTR_FIELD_LOGINFORMACIONASESORIDLOGINFORMACIONASESOR, false), true);
    }


    private void applyOCOCLogInformacionAsesor(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_LogInformacionAsesor".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(LogInformacionAsesorConstants.CLASS_NAME, LogInformacionAsesorConstants.ATTR_NAME_LOGINFORMACIONASESORFECHAHORA, false), false);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildLogInformacionAsesorRelatedInstance(relatedInstanceJsonOid);
        }
        if (LogInformacionAsesorConstants.ROLE_NAME_ASESOR.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildLogInformacionAsesorRelatedInstance4Asesor(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildLogInformacionAsesorRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new LogInformacionAsesor(mapper.readValue(relatedInstanceJsonOid, LogInformacionAsesorOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildLogInformacionAsesorRelatedInstance4Asesor(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Asesor(mapper.readValue(relatedInstanceJsonOid, AsesorOid.class)): Asesor.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            LogInformacionAsesorOid oid = new LogInformacionAsesorOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(LogInformacionAsesorConstants.ATTR_FIELD_LOGINFORMACIONASESORIDLOGINFORMACIONASESOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getLogInformacionAsesoridLogInformacionAsesor(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(LogInformacionAsesorService.class).error(e.getMessage());
        }
    }

}
