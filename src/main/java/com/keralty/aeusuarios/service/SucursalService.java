package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.InstanceExistsException;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.repository.SucursalJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
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
public class SucursalService extends AbstractService {

    SucursalJpaRepository repository;

    SucursalService sucursalSrv;

    RegionalService regionalSrv;

    ContratoCService contratoCSrv;

    @Inject
    public SucursalService(
            SucursalService sucursalSrv,
            RegionalService regionalSrv,
            ContratoCService contratoCSrv,
            SucursalJpaRepository repository) {
        this.sucursalSrv = sucursalSrv;
        this.regionalSrv = regionalSrv;
        this.contratoCSrv = contratoCSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, SucursalConstants.CLASS_NAME);
    }

    private List<Sucursal> solveSucursalTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, SucursalConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveSucursalTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, SucursalConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class Sucursal
     *
     * @return Population of class Sucursal
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Sucursal> get() {
        List<Sucursal> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Sucursal
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Sucursal
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Sucursal> instances = get(queryRequest);
        if(SucursalConstants.DSICSUCURSAL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICSucursal())).collect(Collectors.toList());
        }
        if(SucursalConstants.DSDSSUCURSALPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSucursalPIU())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Sucursal that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Sucursal matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Sucursal> get(QueryRequest queryRequest) {
        return solveSucursalTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveSucursalTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveSucursalTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveSucursalTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveSucursalTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Sucursal by ID
     *
     * @param sucursalCodigo Identification field sucursalCodigo
     *
     * @return Instance of Sucursal
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Sucursal getById(Long sucursalCodigo) {
        return getByOID(new SucursalOid(sucursalCodigo));
    }
    
    /*
     * Returns an instance of Sucursal by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Sucursal
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Sucursal getByOID(SucursalOid oid) {
        Optional<Sucursal> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Sucursal by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Sucursal
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Sucursal getByOIDWithHV(SucursalOid oid) {
        Optional<Sucursal> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Sucursal> getInstanceByOid(SucursalOid oid) {
        return oid != null && oid.getSucursalCodigo() != null
               ? repository.findById(oid.getSucursalCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Sucursal by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Sucursal
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Sucursal getByJsonOid(String jsonOid) {
        SucursalOid oid = new SucursalOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Sucursal related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Sucursal
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Sucursal> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveSucursalTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Sucursal related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Sucursal
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Sucursal> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Sucursal
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Sucursal
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getSucursalDynamic(SucursalOid oid, String displaySetItems) {
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
    public String getSuppInfo(SucursalOid oid, String dsName) {
        Sucursal instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Sucursal instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (SucursalConstants.DSICSUCURSAL.equals(dsName))
            return instance.buildICSucursal();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Sucursal instance, String dsName) {
        if (SucursalConstants.DSICSUCURSAL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICSucursal());
        if (SucursalConstants.DSDSSUCURSALPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSucursalPIU());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Sucursal".equals(filterRequest.getName()))
            suppInfo4ICSucursal(filterRequest.getFilterVariable("searchText").toString(), sql);
    }



    // IIU Methods


    /*
     * Solves the query needed for PIUSucursal
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Sucursal using displayset DSSucursalPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.sucursal.ds.DSSucursalPIU> piuPIUSucursal(QueryRequest queryRequest) {
        return solveSucursalTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.sucursal.ds.DSSucursalPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUSucursal
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUSucursal
     */
    public int getCount4PIUSucursal(QueryRequest queryRequest) {
        return solveSucursalTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUSucursalObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Sucursal using displayset DSSucursalPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.sucursal.ds.DSSucursalPIU> piuPIUSucursalObs(QueryRequest queryRequest) {
        return solveSucursalTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.sucursal.ds.DSSucursalPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUSucursalObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUSucursalObs
     */
    public int getCount4PIUSucursalObs(QueryRequest queryRequest) {
        return solveSucursalTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = sucursalSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CrearRequest request) throws ModelException {
        request.setSucursalcrearpagrRegionalInstance(regionalSrv.getByOIDWithHV(request.getSucursalcrearpagrRegional()));
        return sucursalSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Regional sucursalcrearpagrRegional = request.getSucursalcrearpagrRegionalInstance();
        Long sucursalcrearpatrCodigo = request.getSucursalcrearpatrCodigo();
        String sucursalcrearpatrDescripcion = request.getSucursalcrearpatrDescripcion();

        request.checkArguments();
        Sucursal instance = new Sucursal();
        instance.add2Regional(sucursalcrearpagrRegional);

        instance.setSucursalCodigo(sucursalcrearpatrCodigo);
        instance.setSucursalDescripcion(sucursalcrearpatrDescripcion);
        if (sucursalSrv.getByOID(instance.getOid()) != null) {
            throw new InstanceExistsException(SucursalConstants.CLASS_ALIAS);
        }

        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSucursal());

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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.SincronizarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = sucursalSrv.sincronizarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.SincronizarRequest request) throws ModelException {
        request.setSucursalsincronizarpthisSucursalInstance(sucursalSrv.getByOIDWithHV(request.getSucursalsincronizarpthisSucursal()));
        return sucursalSrv.sincronizarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.SincronizarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Sucursal sucursalsincronizarpthisSucursal = request.getSucursalsincronizarpthisSucursalInstance();
        String sucursalsincronizarpDescripcion = request.getSucursalsincronizarpDescripcion();

        request.checkArguments();
        Sucursal instance = sucursalsincronizarpthisSucursal;
        instance.setSucursalDescripcion(sucursalsincronizarpDescripcion);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSucursal());

        return response;
    }

    // Service: CambRegionalSucursal

    /*
     * Entry point for service CambRegionalSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse cambRegionalSucursal(
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambRegionalSucursalRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = sucursalSrv.cambRegionalSucursalTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service CambRegionalSucursal
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse cambRegionalSucursalTxn(
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambRegionalSucursalRequest request) throws ModelException {
        request.setSucursalCambRegionalSucursalpthisSucursalInstance(sucursalSrv.getByOIDWithHV(request.getSucursalCambRegionalSucursalpthisSucursal()));
        request.setSucursalCambRegionalSucursalpevcRegionalInstance(regionalSrv.getByOIDWithHV(request.getSucursalCambRegionalSucursalpevcRegional()));
        return sucursalSrv.cambRegionalSucursalImplementation(request, true);
    }

    /*
     * Implements service CambRegionalSucursal
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse cambRegionalSucursalImplementation(
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambRegionalSucursalRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Sucursal sucursalCambRegionalSucursalpthisSucursal = request.getSucursalCambRegionalSucursalpthisSucursalInstance();
        Regional sucursalCambRegionalSucursalpevcRegional = request.getSucursalCambRegionalSucursalpevcRegionalInstance();

        request.checkArguments();
        Sucursal instance = sucursalCambRegionalSucursalpthisSucursal;

        instance.add2Regional(sucursalCambRegionalSucursalpevcRegional);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.regional.siu.CambRegionalSucursalRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.regional.siu.CambRegionalSucursalRequest();
            relatedRequest.setRegionalCambRegionalSucursalpthisRegionalInstance(sucursalCambRegionalSucursalpevcRegional);
            relatedRequest.setRegionalCambRegionalSucursalpevcSucursalInstance(sucursalCambRegionalSucursalpthisSucursal);
            regionalSrv.cambRegionalSucursalImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSucursal());

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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambSucursalAgenteRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = sucursalSrv.cambSucursalAgenteTxn(request);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambSucursalAgenteRequest request) throws ModelException {
        request.setSucursalCambSucursalAgentepthisSucursalInstance(sucursalSrv.getByOIDWithHV(request.getSucursalCambSucursalAgentepthisSucursal()));
        request.setSucursalCambSucursalAgentepevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getSucursalCambSucursalAgentepevcFuncionario()));
        return sucursalSrv.cambSucursalAgenteImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambSucursalAgenteRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Sucursal sucursalCambSucursalAgentepthisSucursal = request.getSucursalCambSucursalAgentepthisSucursalInstance();
        Funcionario sucursalCambSucursalAgentepevcFuncionario = request.getSucursalCambSucursalAgentepevcFuncionarioInstance();

        request.checkArguments();
        Sucursal instance = sucursalCambSucursalAgentepthisSucursal;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.funcionario.siu.CambSucursalAgenteRequest();
            relatedRequest.setFuncionarioCambSucursalAgentepthisAgenteInstance(sucursalCambSucursalAgentepevcFuncionario);
            relatedRequest.setFuncionarioCambSucursalAgentepevcSucursalInstance(sucursalCambSucursalAgentepthisSucursal);
            funcionarioSrv.cambSucursalAgenteImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSucursal());

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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.TSINCRONIZARRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = sucursalSrv.tSINCRONIZARTxn(request);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.TSINCRONIZARRequest request) throws ModelException {
        request.setSucursalTSINCRONIZARpthisSucursalInstance(sucursalSrv.getByOIDWithHV(request.getSucursalTSINCRONIZARpthisSucursal()));
        request.setSucursalTSINCRONIZARptpevcRegionalInstance(regionalSrv.getByOIDWithHV(request.getSucursalTSINCRONIZARptpevcRegional()));
        return sucursalSrv.tSINCRONIZARImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.sucursal.siu.TSINCRONIZARRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String sucursalTSINCRONIZARptpDescripcion = request.getSucursalTSINCRONIZARptpDescripcion();
        Regional sucursalTSINCRONIZARptpevcRegional = request.getSucursalTSINCRONIZARptpevcRegionalInstance();
        Sucursal sucursalTSINCRONIZARpthisSucursal = request.getSucursalTSINCRONIZARpthisSucursalInstance();

        request.checkArguments();
        Sucursal instance = sucursalTSINCRONIZARpthisSucursal;

        com.keralty.aeusuarios.viewmodel.sucursal.siu.SincronizarRequest step1Request = new com.keralty.aeusuarios.viewmodel.sucursal.siu.SincronizarRequest();
        step1Request.setSucursalsincronizarpthisSucursalInstance(sucursalTSINCRONIZARpthisSucursal);
        step1Request.setSucursalsincronizarpDescripcion(sucursalTSINCRONIZARptpDescripcion);
        sucursalSrv.sincronizarImplementation(step1Request);

        boolean guard2 = !Utilities.isEqual(sucursalTSINCRONIZARpthisSucursal.getRegional(), sucursalTSINCRONIZARptpevcRegional);

        if (guard2) {
            com.keralty.aeusuarios.viewmodel.sucursal.siu.CambRegionalSucursalRequest step2Request = new com.keralty.aeusuarios.viewmodel.sucursal.siu.CambRegionalSucursalRequest();
            step2Request.setSucursalCambRegionalSucursalpthisSucursalInstance(sucursalTSINCRONIZARpthisSucursal);
            step2Request.setSucursalCambRegionalSucursalpevcRegionalInstance(sucursalTSINCRONIZARptpevcRegional);
            sucursalSrv.cambRegionalSucursalImplementation(step2Request, true);
        }

        response.setInstance(getByOID(instance.getOid()));
        response.setInstanceSuppInfo(instance.buildICSucursal());

        return response;
    }


    private void suppInfo4ICSucursal(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(SucursalConstants.ATTR_NAME_SUCURSALDESCRIPCION, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

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
        applyOCOCSucursal(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(SucursalConstants.CLASS_NAME, SucursalConstants.ATTR_FIELD_SUCURSALCODIGO, false), true);
    }


    private void applyOCOCSucursal(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Sucursal".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(SucursalConstants.CLASS_NAME, SucursalConstants.ATTR_NAME_SUCURSALDESCRIPCION, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildSucursalRelatedInstance(relatedInstanceJsonOid);
        }
        if (SucursalConstants.ROLE_NAME_AGENTES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSucursalRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        if (SucursalConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSucursalRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (SucursalConstants.ROLE_NAME_REGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSucursalRelatedInstance4Regional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildSucursalRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSucursalRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): Funcionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSucursalRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSucursalRelatedInstance4Regional(String relatedInstanceJsonOid, String remainingPath) {
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
            SucursalOid oid = new SucursalOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(SucursalConstants.ATTR_FIELD_SUCURSALCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getSucursalCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(SucursalService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
