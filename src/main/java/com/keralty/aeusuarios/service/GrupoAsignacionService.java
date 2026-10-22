package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.GrupoAsignacionConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;
import com.keralty.aeusuarios.repository.GrupoAsignacionJpaRepository;
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
public class GrupoAsignacionService extends AbstractService {

    GrupoAsignacionJpaRepository repository;

    GrupoAsignacionService grupoAsignacionSrv;

    DominioService dominioSrv;

    @Inject
    public GrupoAsignacionService(
            GrupoAsignacionService grupoAsignacionSrv,
            DominioService dominioSrv,
            GrupoAsignacionJpaRepository repository) {
        this.grupoAsignacionSrv = grupoAsignacionSrv;
        this.dominioSrv = dominioSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, GrupoAsignacionConstants.CLASS_NAME);
    }

    private List<GrupoAsignacion> solveGrupoAsignacionTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, GrupoAsignacionConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveGrupoAsignacionTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, GrupoAsignacionConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class GrupoAsignacion
     *
     * @return Population of class GrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsignacion> get() {
        List<GrupoAsignacion> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class GrupoAsignacion
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class GrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<GrupoAsignacion> instances = get(queryRequest);
        if(GrupoAsignacionConstants.DSDSGRUPOASIGNACION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSGrupoAsignacion())).collect(Collectors.toList());
        }
        if(GrupoAsignacionConstants.DSICGRUPOASIGNACION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICGrupoAsignacion())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class GrupoAsignacion that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class GrupoAsignacion matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsignacion> get(QueryRequest queryRequest) {
        return solveGrupoAsignacionTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveGrupoAsignacionTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveGrupoAsignacionTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveGrupoAsignacionTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveGrupoAsignacionTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of GrupoAsignacion by ID
     *
     * @param grupoAsignacionId Identification field grupoAsignacionId
     *
     * @return Instance of GrupoAsignacion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public GrupoAsignacion getById(Long grupoAsignacionId) {
        return getByOID(new GrupoAsignacionOid(grupoAsignacionId));
    }
    
    /*
     * Returns an instance of GrupoAsignacion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of GrupoAsignacion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public GrupoAsignacion getByOID(GrupoAsignacionOid oid) {
        Optional<GrupoAsignacion> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of GrupoAsignacion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of GrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public GrupoAsignacion getByOIDWithHV(GrupoAsignacionOid oid) {
        Optional<GrupoAsignacion> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<GrupoAsignacion> getInstanceByOid(GrupoAsignacionOid oid) {
        return oid != null && oid.getGrupoAsignacionId() != null
               ? repository.findById(oid.getGrupoAsignacionId())
               : Optional.empty();
    }

    /*
     * Returns an instance of GrupoAsignacion by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of GrupoAsignacion
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public GrupoAsignacion getByJsonOid(String jsonOid) {
        GrupoAsignacionOid oid = new GrupoAsignacionOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of GrupoAsignacion related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of GrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsignacion> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveGrupoAsignacionTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of GrupoAsignacion related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of GrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<GrupoAsignacion> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of GrupoAsignacion
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of GrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getGrupoAsignacionDynamic(GrupoAsignacionOid oid, String displaySetItems) {
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
    public String getSuppInfo(GrupoAsignacionOid oid, String dsName) {
        GrupoAsignacion instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(GrupoAsignacion instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (GrupoAsignacionConstants.DSICGRUPOASIGNACION.equals(dsName))
            return instance.buildICGrupoAsignacion();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(GrupoAsignacion instance, String dsName) {
        if (GrupoAsignacionConstants.DSDSGRUPOASIGNACION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSGrupoAsignacion());
        if (GrupoAsignacionConstants.DSICGRUPOASIGNACION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICGrupoAsignacion());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (GrupoAsignacionConstants.FILTER_NAME_FGRUPOASIGNACIONPORTIPO.equalsIgnoreCase(filterRequest.getName()))
            fGrupoAsignacionPorTipo(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Dominio_TADDGRPASESORES_ptGrupo_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav13(sql);
        if ("Dominio_TADDGRPMEDICO_ptGrupo_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav14(sql);
        if ("GrupoAsignacionNovedad_TCREAR_pt_p_agrGrupoUsuarios_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1586852003840652FiltNav3(sql);
        if ("GrupoAsignacionNovedad_TASGGRUPO_ptGrupo_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1586852003840652FiltNav5(sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_GrupoAsignacion".equals(filterRequest.getName()))
            suppInfo4ICGrupoAsignacion(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fGrupoAsignacionPorTipo(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfTipo = filterRequest.hasFilterVariable(GrupoAsignacionConstants.VAR_NAME_FGRUPOASIGNACIONPORTIPO_VFTIPO) ? (Long) filterRequest.getFilterVariable(GrupoAsignacionConstants.VAR_NAME_FGRUPOASIGNACIONPORTIPO_VFTIPO, FilterVariableRequest.NAT) : null;

        // Tipo = vfTipo
        if (vfTipo != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(GrupoAsignacionConstants.ATTR_NAME_GRUPOASIGNACIONTIPO, Constants.Type.NAT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfTipo, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void clas1431701422080423FiltNav13(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // Tipo = 1
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(GrupoAsignacionConstants.ATTR_NAME_GRUPOASIGNACIONTIPO, Constants.Type.NAT.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1431701422080423FiltNav14(SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();

        // Tipo = 2
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(GrupoAsignacionConstants.ATTR_NAME_GRUPOASIGNACIONTIPO, Constants.Type.NAT.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison1);

        sql.addConjunction(conjunction);
    }

    private void clas1586852003840652FiltNav3(SQLSelect sql) {
        clas1431701422080423FiltNav13(sql);
    }

    private void clas1586852003840652FiltNav5(SQLSelect sql) {
        clas1431701422080423FiltNav13(sql);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class GrupoAsignacion with displayset DSGrupoAsignacion for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class GrupoAsignacion with displayset DSGrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion iIUGrupoMDominio(GrupoAsignacionOid oid) {
        return new com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class GrupoAsignacion with displayset DSGrupoAsignacion for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class GrupoAsignacion with displayset DSGrupoAsignacion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion iIUGrupoMedicoMDominio(GrupoAsignacionOid oid) {
        return new com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUGrupoAsignacion
     *
     * @param queryRequest Query request
     * @return List of viewmodels for GrupoAsignacion using displayset DSGrupoAsignacion that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion> piuPIUGrupoAsignacion(QueryRequest queryRequest) {
        return solveGrupoAsignacionTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUGrupoAsignacion
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUGrupoAsignacion
     */
    public int getCount4PIUGrupoAsignacion(QueryRequest queryRequest) {
        return solveGrupoAsignacionTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUGrupoAsignacion1
     *
     * @param queryRequest Query request
     * @return List of viewmodels for GrupoAsignacion using displayset AutoDS that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.AutoDS> piuPIUGrupoAsignacion1(QueryRequest queryRequest) {
        return solveGrupoAsignacionTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.AutoDS::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUGrupoAsignacion1
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUGrupoAsignacion1
     */
    public int getCount4PIUGrupoAsignacion1(QueryRequest queryRequest) {
        return solveGrupoAsignacionTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.AddFuncionarioGrupoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = grupoAsignacionSrv.addFuncionarioGrupoTxn(request);
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
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.AddFuncionarioGrupoRequest request) throws ModelException {
        request.setGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance(grupoAsignacionSrv.getByOIDWithHV(request.getGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion()));
        request.setGrupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getGrupoAsignacionAddFuncionarioGrupopevcFuncionario()));
        return grupoAsignacionSrv.addFuncionarioGrupoImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.AddFuncionarioGrupoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        GrupoAsignacion grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion = request.getGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance();
        Funcionario grupoAsignacionAddFuncionarioGrupopevcFuncionario = request.getGrupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance();

        request.checkArguments();
        GrupoAsignacion instance = grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion;

        instance.add2Funcionario(grupoAsignacionAddFuncionarioGrupopevcFuncionario);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.AddFuncionarioGrupoRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.funcionario.siu.AddFuncionarioGrupoRequest();
            relatedRequest.setFuncionarioAddFuncionarioGrupopthisFuncionarioInstance(grupoAsignacionAddFuncionarioGrupopevcFuncionario);
            relatedRequest.setFuncionarioAddFuncionarioGrupopevcGrupoAsignacionInstance(grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion);
            funcionarioSrv.addFuncionarioGrupoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICGrupoAsignacion());

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
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.DelFuncionarioGrupoRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = grupoAsignacionSrv.delFuncionarioGrupoTxn(request);
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
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.DelFuncionarioGrupoRequest request) throws ModelException {
        request.setGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance(grupoAsignacionSrv.getByOIDWithHV(request.getGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion()));
        request.setGrupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getGrupoAsignacionDelFuncionarioGrupopevcFuncionario()));
        return grupoAsignacionSrv.delFuncionarioGrupoImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.grupoasignacion.siu.DelFuncionarioGrupoRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        GrupoAsignacion grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion = request.getGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance();
        Funcionario grupoAsignacionDelFuncionarioGrupopevcFuncionario = request.getGrupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance();

        request.checkArguments();
        GrupoAsignacion instance = grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion;

        instance.removeFromFuncionario(grupoAsignacionDelFuncionarioGrupopevcFuncionario);
        grupoAsignacionDelFuncionarioGrupopevcFuncionario.removeFromGrupoAsignacion(instance);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelFuncionarioGrupoRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DelFuncionarioGrupoRequest();
            relatedRequest.setFuncionarioDelFuncionarioGrupopthisFuncionarioInstance(grupoAsignacionDelFuncionarioGrupopevcFuncionario);
            relatedRequest.setFuncionarioDelFuncionarioGrupopevcGrupoAsignacionInstance(grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion);
            funcionarioSrv.delFuncionarioGrupoImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICGrupoAsignacion());

        return response;
    }


    private void suppInfo4ICGrupoAsignacion(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(GrupoAsignacionConstants.ATTR_NAME_GRUPOASIGNACIONNOMBRE, Constants.Type.STRING.getTypeName()));
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
        select.getOrderByPart().addItem(Constants.normalizePath(GrupoAsignacionConstants.CLASS_NAME, GrupoAsignacionConstants.ATTR_FIELD_GRUPOASIGNACIONID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildGrupoAsignacionRelatedInstance(relatedInstanceJsonOid);
        }
        if (GrupoAsignacionConstants.ROLE_NAME_DOMINIOASESORES.equalsIgnoreCase(relatedInstancePathFirstItem) || GrupoAsignacionConstants.ROLE_NAME_DOMINIOAREAMEDICA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGrupoAsignacionRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        if (GrupoAsignacionConstants.ROLE_NAME_FUNCIONARIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildGrupoAsignacionRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildGrupoAsignacionRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildGrupoAsignacionRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildGrupoAsignacionRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): Funcionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            GrupoAsignacionOid oid = new GrupoAsignacionOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(GrupoAsignacionConstants.ATTR_FIELD_GRUPOASIGNACIONID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getGrupoAsignacionId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(GrupoAsignacionService.class).error(e.getMessage());
        }
    }

}
