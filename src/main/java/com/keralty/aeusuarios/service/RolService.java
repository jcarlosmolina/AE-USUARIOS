package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.MinCardinalityException;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.PreconditionException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.repository.RolJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereNegation;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandSubQuery;
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
public class RolService extends AbstractService {

    RolJpaRepository repository;

    RolService rolSrv;

    DominioService dominioSrv;

    @Inject
    public RolService(
            RolService rolSrv,
            DominioService dominioSrv,
            RolJpaRepository repository) {
        this.rolSrv = rolSrv;
        this.dominioSrv = dominioSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, RolConstants.CLASS_NAME);
    }

    private List<Rol> solveRolTypedQuery(QueryRequest request) {
        boolean hasInMemoryFilters = hasInMemoryFilters(request);
        int requestedPageSize = request.getPageSize();
        int pageSize = requestedPageSize >= 0
                && requestedPageSize <= Constants.MAX_BLOCKSIZE
                ? requestedPageSize
                : Constants.DEFAULT_BLOCKSIZE;
        int pageNumber = Math.max(1, request.getPageNumber());

    	List<Rol> results = repository.solveQuery(processQueryRequest(request, RolConstants.CLASS_NAME), (hasInMemoryFilters ? 0 : pageSize), (hasInMemoryFilters ? 1 : pageNumber)).stream()
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
    
    private int solveRolTypedCountQuery(QueryRequest request) {
        return hasInMemoryFilters(request)
               ? repository.solveQuery(processQueryRequest(request, RolConstants.CLASS_NAME)).stream().filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size()
               : repository.solveCountQuery(processCountQueryRequest(request, RolConstants.CLASS_NAME));
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
        if ("TCREARAGENTE_pt_p_agrRol_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        if ("TMODIFICARAGENTE_pt_NuevoRol_NavFilter0".equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        return false;
    }

    /*
     * Returns the population of class Rol
     *
     * @return Population of class Rol
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Rol> get() {
        List<Rol> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Rol
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Rol
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Rol> instances = get(queryRequest);
        if(RolConstants.DSICROL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICRol())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Rol that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Rol matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Rol> get(QueryRequest queryRequest) {
        return solveRolTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveRolTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveRolTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveRolTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveRolTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Rol by ID
     *
     * @param rolIdentificador Identification field rolIdentificador
     *
     * @return Instance of Rol
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Rol getById(Long rolIdentificador) {
        return getByOID(new RolOid(rolIdentificador));
    }
    
    /*
     * Returns an instance of Rol by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Rol
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Rol getByOID(RolOid oid) {
        Optional<Rol> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Rol by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Rol
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Rol getByOIDWithHV(RolOid oid) {
        Optional<Rol> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Rol> getInstanceByOid(RolOid oid) {
        return oid != null && oid.getRolIdentificador() != null
               ? repository.findById(oid.getRolIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of Rol by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Rol
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Rol getByJsonOid(String jsonOid) {
        RolOid oid = new RolOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Rol related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Rol
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Rol> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveRolTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Rol related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Rol
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Rol> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Rol
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Rol
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getRolDynamic(RolOid oid, String displaySetItems) {
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
    public String getSuppInfo(RolOid oid, String dsName) {
        Rol instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Rol instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (RolConstants.DSICROL.equals(dsName))
            return instance.buildICRol();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Rol instance, String dsName) {
        if (RolConstants.DSICROL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICRol());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (RolConstants.FILTER_NAME_IFROLPORNOMBRE.equalsIgnoreCase(filterRequest.getName()))
            iFRolPorNombre(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Dominio_InsRolDominio_p_evcRol_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav3(filterRequest, sql);
        if ("Dominio_DelRollDominio_p_evcRol_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav8(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Rol".equals(filterRequest.getName()))
            suppInfo4ICRol(filterRequest.getFilterVariable("searchText").toString(), sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Rol instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Rol instance) {
        return applyMemoryNavigationalFilter(filterRequest, instance);
    }

    private boolean applyMemoryNavigationalFilter(FilterRequest filterRequest, Rol entity) {
        if ("TCREARAGENTE_pt_p_agrRol_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryIGl1462447112192088FiltNav1(entity);
        if ("TMODIFICARAGENTE_pt_NuevoRol_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            return inMemoryIGl1462447243264368FiltNav1(entity);
        return true;
    }


    private void iFRolPorNombre(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vNombre = filterRequest.hasFilterVariable(RolConstants.VAR_NAME_IFROLPORNOMBRE_VNOMBRE) ? (String) filterRequest.getFilterVariable(RolConstants.VAR_NAME_IFROLPORNOMBRE_VNOMBRE, FilterVariableRequest.STRING) : null;

        // Nombre = vNombre
        if (vNombre != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(RolConstants.ATTR_NAME_ROLNOMBRE, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void clas1431701422080423FiltNav3(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Dominio dominioInsRolDominiopthisDominio = filterRequest.hasFilterVariable(DominioConstants.ARG_NAME_INSROLDOMINIO_DOMINIOINSROLDOMINIOPTHISDOMINIO) ? dominioSrv.getByOID(new DominioOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.ARG_NAME_INSROLDOMINIO_DOMINIOINSROLDOMINIOPTHISDOMINIO)))) : null;

        // EXIST (Dominios) WHERE (Dominios = pthisDominio) = false
        if (dominioInsRolDominiopthisDominio != null) {
        {
            // 'not' Logical operator
            SQLWhereNegation comparison1 = new SQLWhereNegation(sql);
        
            // Operand 1
            // 'exist' Association operator
            SQLWhereOperandSubQuery operandSubQueryAssocOperator001 = new SQLWhereOperandSubQuery(repository.assocOperator001Range1Query(dominioInsRolDominiopthisDominio, sql));
            comparison1.addOperand(operandSubQueryAssocOperator001);
            
            conjunction.addOperand(comparison1);
        }

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431701422080423FiltNav8(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Dominio dominioDelRollDominiopthisDominio = filterRequest.hasFilterVariable(DominioConstants.ARG_NAME_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPTHISDOMINIO) ? dominioSrv.getByOID(new DominioOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.ARG_NAME_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPTHISDOMINIO)))) : null;

        // EXIST (Dominios) WHERE (Dominios = pthisDominio) = true
        if (dominioDelRollDominiopthisDominio != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator002 = new SQLWhereOperandSubQuery(repository.assocOperator002Range1Query(dominioDelRollDominiopthisDominio, sql));
    conjunction.addOperand(operandSubQueryAssocOperator002);

        }        
        sql.addConjunction(conjunction);
    }

    private boolean inMemoryIGl1462447112192088FiltNav1(Rol entity) {
        boolean result = true;

        // indexOf(Nombre, "ASESOR") = 0
        try {
            result = (STDFunctions.indexOfFun(entity.getRolNombre(), "ASESOR")).equals(Long.valueOf(0));
        } catch (Exception e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    private boolean inMemoryIGl1462447243264368FiltNav1(Rol entity) {
        return inMemoryIGl1462447112192088FiltNav1(entity);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIURol
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Rol using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.rol.ds.AutoDS> piuPIURol(QueryRequest queryRequest) {
        return solveRolTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.rol.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIURol
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIURol
     */
    public int getCount4PIURol(QueryRequest queryRequest) {
        return solveRolTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIURolDetDominio
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Rol using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.rol.ds.AutoDS> piuPIURolDetDominio(QueryRequest queryRequest) {
        return solveRolTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.rol.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIURolDetDominio
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIURolDetDominio
     */
    public int getCount4PIURolDetDominio(QueryRequest queryRequest) {
        return solveRolTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.rol.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = rolSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.rol.siu.CrearRequest request) throws ModelException {
        return rolSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.rol.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String rolcrearpatrNombre = request.getRolcrearpatrNombre();

        request.checkArguments();
        Rol instance = new Rol();
        instance.setRolIdentificador(Long.valueOf(0));
        instance.setRolNombre(rolcrearpatrNombre);

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRol());

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
            com.keralty.aeusuarios.viewmodel.rol.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = rolSrv.eliminarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.rol.siu.EliminarRequest request) throws ModelException {
        request.setRoleliminarpthisRolInstance(rolSrv.getByOIDWithHV(request.getRoleliminarpthisRol()));
        return rolSrv.eliminarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.rol.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Rol roleliminarpthisRol = request.getRoleliminarpthisRolInstance();

        request.checkArguments();

        eliminarPreconditions(request);
        Rol instance = roleliminarpthisRol;
        if(roleliminarpthisRol.getAgentes().size() > 0) {
            throw new MinCardinalityException(RolConstants.CLASS_ALIAS, RolConstants.ROLE_ALIAS_AGENTES);
        }


        repository.delete(instance);
        
        response.setInstance(instance);
        response.setInstanceSuppInfo(instance.buildICRol());

        return response;
    }

    /*
     * Checks service eliminar preconditions individually
     *
     * @param request Service request viewmodel
     *
     * @return Service preconditions evaluation result
     */
    public ServiceResponse eliminarCheckPreconditions(com.keralty.aeusuarios.viewmodel.rol.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        request.setRoleliminarpthisRolInstance(rolSrv.getByOIDWithHV(request.getRoleliminarpthisRol()));
        try {
            if("Clas_1431700897792807Pre_1".equals(request.getPreconditionId()))
                checkClas1431700897792807Pre1(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    private void eliminarPreconditions(
            com.keralty.aeusuarios.viewmodel.rol.siu.EliminarRequest request) 
            throws ModelException {
        checkClas1431700897792807Pre1(request);
    }

    private void checkClas1431700897792807Pre1 (
            com.keralty.aeusuarios.viewmodel.rol.siu.EliminarRequest request) 
            throws ModelException {
        // EXIST( Agentes ) = false

        Rol roleliminarpthisRol = request.getRoleliminarpthisRolInstance();
        try {
            boolean preconditionHolds = repository.assocOperator000(roleliminarpthisRol).equals(false);
            if (!preconditionHolds) throw new PreconditionException("No se puede eliminar el rol, porque existen usuarios con este rol");
        } catch (SystemException e) {
            LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
    }

    // Service: InsRolDominio

    /*
     * Entry point for service InsRolDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insRolDominio(
            com.keralty.aeusuarios.viewmodel.rol.siu.InsRolDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = rolSrv.insRolDominioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsRolDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insRolDominioTxn(
            com.keralty.aeusuarios.viewmodel.rol.siu.InsRolDominioRequest request) throws ModelException {
        request.setRolInsRolDominiopthisRolInstance(rolSrv.getByOIDWithHV(request.getRolInsRolDominiopthisRol()));
        request.setRolInsRolDominiopevcDominioInstance(dominioSrv.getByOIDWithHV(request.getRolInsRolDominiopevcDominio()));
        return rolSrv.insRolDominioImplementation(request, true);
    }

    /*
     * Implements service InsRolDominio
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insRolDominioImplementation(
            com.keralty.aeusuarios.viewmodel.rol.siu.InsRolDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Rol rolInsRolDominiopthisRol = request.getRolInsRolDominiopthisRolInstance();
        Dominio rolInsRolDominiopevcDominio = request.getRolInsRolDominiopevcDominioInstance();

        request.checkArguments();
        Rol instance = rolInsRolDominiopthisRol;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsRolDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.dominio.siu.InsRolDominioRequest();
            relatedRequest.setDominioInsRolDominiopthisDominioInstance(rolInsRolDominiopevcDominio);
            relatedRequest.setDominioInsRolDominiopevcRolInstance(rolInsRolDominiopthisRol);
            dominioSrv.insRolDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRol());

        return response;
    }

    // Service: DelRollDominio

    /*
     * Entry point for service DelRollDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delRollDominio(
            com.keralty.aeusuarios.viewmodel.rol.siu.DelRollDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = rolSrv.delRollDominioTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelRollDominio
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delRollDominioTxn(
            com.keralty.aeusuarios.viewmodel.rol.siu.DelRollDominioRequest request) throws ModelException {
        request.setRolDelRollDominiopthisRolInstance(rolSrv.getByOIDWithHV(request.getRolDelRollDominiopthisRol()));
        request.setRolDelRollDominiopevcDominioInstance(dominioSrv.getByOIDWithHV(request.getRolDelRollDominiopevcDominio()));
        return rolSrv.delRollDominioImplementation(request, true);
    }

    /*
     * Implements service DelRollDominio
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delRollDominioImplementation(
            com.keralty.aeusuarios.viewmodel.rol.siu.DelRollDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Rol rolDelRollDominiopthisRol = request.getRolDelRollDominiopthisRolInstance();
        Dominio rolDelRollDominiopevcDominio = request.getRolDelRollDominiopevcDominioInstance();

        request.checkArguments();
        Rol instance = rolDelRollDominiopthisRol;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelRollDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.dominio.siu.DelRollDominioRequest();
            relatedRequest.setDominioDelRollDominiopthisDominioInstance(rolDelRollDominiopevcDominio);
            relatedRequest.setDominioDelRollDominiopevcRolInstance(rolDelRollDominiopthisRol);
            dominioSrv.delRollDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRol());

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
            com.keralty.aeusuarios.viewmodel.rol.siu.CambRolAgenteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = rolSrv.cambRolAgenteTxn(request);
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
            com.keralty.aeusuarios.viewmodel.rol.siu.CambRolAgenteRequest request) throws ModelException {
        request.setRolCambRolAgentepthisRolInstance(rolSrv.getByOIDWithHV(request.getRolCambRolAgentepthisRol()));
        request.setRolCambRolAgentepevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getRolCambRolAgentepevcFuncionario()));
        return rolSrv.cambRolAgenteImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.rol.siu.CambRolAgenteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Rol rolCambRolAgentepthisRol = request.getRolCambRolAgentepthisRolInstance();
        Funcionario rolCambRolAgentepevcFuncionario = request.getRolCambRolAgentepevcFuncionarioInstance();

        request.checkArguments();
        Rol instance = rolCambRolAgentepthisRol;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest();
            relatedRequest.setFuncionarioCambRolAgentepthisAgenteInstance(rolCambRolAgentepevcFuncionario);
            relatedRequest.setFuncionarioCambRolAgentepevcRolInstance(rolCambRolAgentepthisRol);
            funcionarioSrv.cambRolAgenteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICRol());

        return response;
    }


    private void suppInfo4ICRol(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(RolConstants.ATTR_NAME_ROLNOMBRE, Constants.Type.STRING.getTypeName()));
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
        select.getOrderByPart().addItem(Constants.normalizePath(RolConstants.CLASS_NAME, RolConstants.ATTR_FIELD_ROLIDENTIFICADOR, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildRolRelatedInstance(relatedInstanceJsonOid);
        }
        if (RolConstants.ROLE_NAME_AGENTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRolRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        if (RolConstants.ROLE_NAME_DOMINIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildRolRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildRolRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRolRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): Funcionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildRolRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
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
            RolOid oid = new RolOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(RolConstants.ATTR_FIELD_ROLIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getRolIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(RolService.class).error(e.getMessage());
        }
    }

}
