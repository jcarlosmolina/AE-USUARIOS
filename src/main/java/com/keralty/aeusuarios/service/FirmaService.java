package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FirmaConstants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.FamiliaNovedad;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.NovedadCT;
import com.keralty.aeusuarios.persistence.oid.FamiliaNovedadOid;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;
import com.keralty.aeusuarios.persistence.oid.NovedadCTOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.RespRegional;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.repository.FirmaJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aeusuarios.utils.Utilities;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class FirmaService extends AbstractService {

    FirmaJpaRepository repository;

    FirmaService firmaSrv;

    SolicitudService solicitudSrv;

    FamiliaNovedadService familiaNovedadSrv;

    NovedadCTService novedadCTSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    RegionalService regionalSrv;

    @Inject
    public FirmaService(
            FirmaService firmaSrv,
            SolicitudService solicitudSrv,
            FamiliaNovedadService familiaNovedadSrv,
            NovedadCTService novedadCTSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            RegionalService regionalSrv,
            FirmaJpaRepository repository) {
        this.firmaSrv = firmaSrv;
        this.solicitudSrv = solicitudSrv;
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.novedadCTSrv = novedadCTSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.regionalSrv = regionalSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, FirmaConstants.CLASS_NAME);
    }

    private List<Firma> solveFirmaTypedQuery(QueryRequest request) {
        boolean hasInMemoryFilters = hasInMemoryFilters(request);
        int requestedPageSize = request.getPageSize();
        int pageSize = requestedPageSize >= 0
                && requestedPageSize <= Constants.MAX_BLOCKSIZE
                ? requestedPageSize
                : Constants.DEFAULT_BLOCKSIZE;
        int pageNumber = Math.max(1, request.getPageNumber());

    	List<Firma> results = repository.solveQuery(processQueryRequest(request, FirmaConstants.CLASS_NAME), (hasInMemoryFilters ? 0 : pageSize), (hasInMemoryFilters ? 1 : pageNumber)).stream()
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
    
    private int solveFirmaTypedCountQuery(QueryRequest request) {
        return hasInMemoryFilters(request)
               ? repository.solveQuery(processQueryRequest(request, FirmaConstants.CLASS_NAME)).stream().filter(instance -> applyMemoryFilters(request, instance)).collect(Collectors.toList()).size()
               : repository.solveCountQuery(processCountQueryRequest(request, FirmaConstants.CLASS_NAME));
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
        if (FirmaConstants.FILTER_NAME_FFIRMASRESPONSABLES.equalsIgnoreCase(filterRequest.getName())) {
            return true;
        }
        return false;
    }

    /*
     * Returns the population of class Firma
     *
     * @return Population of class Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> get() {
        List<Firma> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class Firma that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Firma matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> get(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveFirmaTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveFirmaTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveFirmaTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Firma by ID
     *
     * @param firmaIdentificador Identification field firmaIdentificador
     *
     * @return Instance of Firma
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Firma getById(Long firmaIdentificador) {
        return getByOID(new FirmaOid(firmaIdentificador));
    }
    
    /*
     * Returns an instance of Firma by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Firma
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Firma getByOID(FirmaOid oid) {
        Optional<Firma> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Firma by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Firma getByOIDWithHV(FirmaOid oid) {
        Optional<Firma> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Firma> getInstanceByOid(FirmaOid oid) {
        return oid != null && oid.getFirmaIdentificador() != null
               ? repository.findById(oid.getFirmaIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of Firma by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Firma
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Firma getByJsonOid(String jsonOid) {
        FirmaOid oid = new FirmaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Firma related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveFirmaTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Firma related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Firma> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Firma
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Firma
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getFirmaDynamic(FirmaOid oid, String displaySetItems) {
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
    public String getSuppInfo(FirmaOid oid, String dsName) {
        Firma instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Firma instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (FirmaConstants.FILTER_NAME_FFIRMASRESPONSABLES.equalsIgnoreCase(filterRequest.getName()))
            fFirmasResponsables(filterRequest, sql);
    }

    private boolean applyMemoryFilters(QueryRequest queryRequest, Firma instance) {
        for (FilterRequest filterRequest : queryRequest.getFilters()) {
            if (!applyMemoryFilter(filterRequest, instance))
                return false;
        }
        return true;
    }
    
    private boolean applyMemoryFilter(FilterRequest filterRequest, Firma instance) {
        return applyMemoryQueryFilter(filterRequest, instance);
    }

    private boolean applyMemoryQueryFilter(FilterRequest filterRequest, Firma entity) {
        if (FirmaConstants.FILTER_NAME_FFIRMASRESPONSABLES.equalsIgnoreCase(filterRequest.getName()))
            return inMemoryFFirmasResponsables(filterRequest,  entity);
        return true;
    }


    private void fFirmasResponsables(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vUsuario = filterRequest.hasFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VUSUARIO) ? (String) filterRequest.getFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VUSUARIO, FilterVariableRequest.STRING) : null;
        Regional voRegional = filterRequest.hasFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL) ? regionalSrv.getByOID(new RegionalOid().fromJsonString(toJson(filterRequest.getFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL)))) : null;

        // EXIST (RespRegional) = true
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(sql));
    conjunction.addOperand(operandSubQueryAssocOperator000);


        // RespRegional.Usuario LIKE "%" + vUsuario
        if (vUsuario != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FirmaConstants.ROLE_NAME_RESPREGIONAL + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral("%" + vUsuario, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // RespRegional.Sucursal.Regional = voRegional
        if (voRegional != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand114 = new SQLWhereOperandPathInstance(FirmaConstants.ROLE_NAME_RESPREGIONAL + "." + RespRegionalConstants.ROLE_NAME_SUCURSAL + "." + SucursalConstants.ROLE_NAME_REGIONAL, RegionalConstants.CLASS_NAME);
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            SQLWhereOperandOVParameter operand225 = new SQLWhereOperandOVParameter(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL, RegionalConstants.CLASS_NAME, RegionalConstants.CLASS_NAME, voRegional.getOid(), FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VOREGIONAL);
            comparison3.setSecondOperand(operand225);
            conjunction.addOperand(comparison3);

        }        

        sql.addConjunction(conjunction);
    }

    private boolean inMemoryFFirmasResponsables(FilterRequest filterRequest, Firma entity) {
        boolean result = true;
        String vNombre = filterRequest.hasFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VNOMBRE) ? (String) filterRequest.getFilterVariable(FirmaConstants.VAR_NAME_FFIRMASRESPONSABLES_VNOMBRE, FilterVariableRequest.STRING) : null;

        // RespRegional.drvNombreCompleto LIKE "%" + vNombre
        try {
            if (vNombre != null) {
                result = Utilities.like(entity.getRespRegional().getFuncionariodrvNombreCompleto(), "%" + vNombre);
            }
        } catch(Exception e) {
           LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
        }
        return result;
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUFirmasRespRegional
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Firma using displayset DSFirmaPIUResponsable that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.firma.ds.DSFirmaPIUResponsable> piuPIUFirmasRespRegional(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.firma.ds.DSFirmaPIUResponsable::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFirmasRespRegional
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFirmasRespRegional
     */
    public int getCount4PIUFirmasRespRegional(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUFirmaNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Firma using displayset DSFirmaNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.firma.ds.DSFirmaNull> piuPIUFirmaNull(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.firma.ds.DSFirmaNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFirmaNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFirmaNull
     */
    public int getCount4PIUFirmaNull(QueryRequest queryRequest) {
        return solveFirmaTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.firma.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = firmaSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.firma.siu.CrearRequest request) {
        request.setFirmacrearpagrSolicitudSegundaInstance(solicitudSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitudSegunda()));
        request.setFirmacrearpagrRespRegionalInstance(respRegionalSrv.getByOIDWithHV(request.getFirmacrearpagrRespRegional()));
        request.setFirmacrearpagrSolicitudContratanteInstance(solicitudSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitudContratante()));
        request.setFirmacrearpagrFamiliaNovedadInstance(familiaNovedadSrv.getByOIDWithHV(request.getFirmacrearpagrFamiliaNovedad()));
        request.setFirmacrearpagrNovedadesCTInstance(novedadCTSrv.getByOIDWithHV(request.getFirmacrearpagrNovedadesCT()));
        request.setFirmacrearpagrSolicitudInstance(solicitudSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitud()));
        request.setFirmacrearpagrSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getFirmacrearpagrSolicitudNovedad()));
        return firmaSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.firma.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        Solicitud firmacrearpagrSolicitudSegunda = request.getFirmacrearpagrSolicitudSegundaInstance();
        RespRegional firmacrearpagrRespRegional = request.getFirmacrearpagrRespRegionalInstance();
        Solicitud firmacrearpagrSolicitudContratante = request.getFirmacrearpagrSolicitudContratanteInstance();
        Solicitud firmacrearpagrSolicitud = request.getFirmacrearpagrSolicitudInstance();
        byte[] firmacrearpatrImagenFirma = request.getFirmacrearpatrImagenFirma();
        String firmacrearpatrLatitud = request.getFirmacrearpatrLatitud();
        String firmacrearpatrLongitud = request.getFirmacrearpatrLongitud();
        Firma instance = new Firma();
        if (firmacrearpagrSolicitudSegunda != null && !firmacrearpagrSolicitudSegunda.isNull()) {
            firmacrearpagrSolicitudSegunda.add2SegundaFirma(instance);
            instance.add2SolicitudSegunda(firmacrearpagrSolicitudSegunda);
        }

        if (firmacrearpagrRespRegional != null && !firmacrearpagrRespRegional.isNull()) {
            firmacrearpagrRespRegional.add2Firma(instance);
            instance.add2RespRegional(firmacrearpagrRespRegional);
        }

        if (firmacrearpagrSolicitudContratante != null && !firmacrearpagrSolicitudContratante.isNull()) {
            firmacrearpagrSolicitudContratante.add2FirmaContratanteIncl(instance);
            instance.add2SolicitudContratante(firmacrearpagrSolicitudContratante);
        }



        if (firmacrearpagrSolicitud != null && !firmacrearpagrSolicitud.isNull()) {
            firmacrearpagrSolicitud.add2Firma(instance);
            instance.add2Solicitud(firmacrearpagrSolicitud);
        }


        instance.setFirmaIdentificador(Long.valueOf(0));
        instance.setFirmaImagenFirma(firmacrearpatrImagenFirma);
        instance.setFirmaLatitud(firmacrearpatrLatitud);
        instance.setFirmaLongitud(firmacrearpatrLongitud);

        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: modificar

    /*
     * Entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse modificar(
            com.keralty.aeusuarios.viewmodel.firma.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = firmaSrv.modificarTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service modificar
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse modificarTxn(
            com.keralty.aeusuarios.viewmodel.firma.siu.ModificarRequest request) throws ModelException {
        request.setFirmamodificarpthisFirmaInstance(firmaSrv.getByOIDWithHV(request.getFirmamodificarpthisFirma()));
        return firmaSrv.modificarImplementation(request);
    }

    /*
     * Implements service modificar
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse modificarImplementation(
            com.keralty.aeusuarios.viewmodel.firma.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Firma firmamodificarpthisFirma = request.getFirmamodificarpthisFirmaInstance();
        byte[] firmamodificarpImagenFirma = request.getFirmamodificarpImagenFirma();
        String firmamodificarpLatitud = request.getFirmamodificarpLatitud();
        String firmamodificarpLongitud = request.getFirmamodificarpLongitud();

        request.checkArguments();
        Firma instance = firmamodificarpthisFirma;
        instance.setFirmaImagenFirma(firmamodificarpImagenFirma);
        instance.setFirmaLatitud(firmamodificarpLatitud);
        instance.setFirmaLongitud(firmamodificarpLongitud);


        response.setInstance(repository.save(instance));

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
        // RespRegional = agent
        RespRegional agentInstance = getAgentRespRegional();
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(FirmaConstants.ROLE_NAME_RESPREGIONAL, RespRegionalConstants.CLASS_NAME);
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, RespRegionalConstants.CLASS_NAME, RespRegionalConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
        comparison1.setSecondOperand(operand223);
        disjunction.addOperand(comparison1);

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
        select.getOrderByPart().addItem(Constants.normalizePath(FirmaConstants.CLASS_NAME, FirmaConstants.ATTR_FIELD_FIRMAIDENTIFICADOR, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildFirmaRelatedInstance(relatedInstanceJsonOid);
        }
        if (FirmaConstants.ROLE_NAME_SOLICITUDNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_FAMILIANOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_NOVEDADESCT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4NovedadCT(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem) || FirmaConstants.ROLE_NAME_SOLICITUDSEGUNDA.equalsIgnoreCase(relatedInstancePathFirstItem) || FirmaConstants.ROLE_NAME_SOLICITUDCONTRATANTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (FirmaConstants.ROLE_NAME_RESPREGIONAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildFirmaRelatedInstance4RespRegional(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildFirmaRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): FamiliaNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4NovedadCT(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new NovedadCT(mapper.readValue(relatedInstanceJsonOid, NovedadCTOid.class)): NovedadCT.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildFirmaRelatedInstance4RespRegional(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new RespRegional(mapper.readValue(relatedInstanceJsonOid, RespRegionalOid.class)): RespRegional.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FirmaOid oid = new FirmaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FirmaConstants.ATTR_FIELD_FIRMAIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFirmaIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(FirmaService.class).error(e.getMessage());
        }
    }

}
