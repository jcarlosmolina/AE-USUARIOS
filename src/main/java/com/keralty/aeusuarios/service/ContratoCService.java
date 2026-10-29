package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ContratoCConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.BeneficiarioC;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.EstadoContrato;
import com.keralty.aeusuarios.persistence.FamiliaC;
import com.keralty.aeusuarios.persistence.GrupoAsociado;
import com.keralty.aeusuarios.persistence.Municipio;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.BeneficiarioCOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.persistence.oid.EstadoContratoOid;
import com.keralty.aeusuarios.persistence.oid.FamiliaCOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsociadoOid;
import com.keralty.aeusuarios.persistence.oid.MunicipioOid;
import com.keralty.aeusuarios.persistence.oid.PeriodicidadOid;
import com.keralty.aeusuarios.persistence.oid.PersonaCOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TarifaOid;
import com.keralty.aeusuarios.persistence.Periodicidad;
import com.keralty.aeusuarios.persistence.PersonaC;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.Tarifa;
import com.keralty.aeusuarios.repository.ContratoCJpaRepository;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class ContratoCService extends AbstractService {

    ContratoCJpaRepository repository;

    ContratoCService contratoCSrv;

    SolicitudService solicitudSrv;

    PersonaCService personaCSrv;

    BeneficiarioCService beneficiarioCSrv;

    FamiliaCService familiaCSrv;

    PeriodicidadService periodicidadSrv;

    EstadoContratoService estadoContratoSrv;

    ProductosService productosSrv;

    PlanesService planesSrv;

    TarifaService tarifaSrv;

    GrupoAsociadoService grupoAsociadoSrv;

    MunicipioService municipioSrv;

    SucursalService sucursalSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public ContratoCService(
            ContratoCService contratoCSrv,
            SolicitudService solicitudSrv,
            PersonaCService personaCSrv,
            BeneficiarioCService beneficiarioCSrv,
            FamiliaCService familiaCSrv,
            PeriodicidadService periodicidadSrv,
            EstadoContratoService estadoContratoSrv,
            ProductosService productosSrv,
            PlanesService planesSrv,
            TarifaService tarifaSrv,
            GrupoAsociadoService grupoAsociadoSrv,
            MunicipioService municipioSrv,
            SucursalService sucursalSrv,
            UserFunctions userFunctionsSrv,
            ContratoCJpaRepository repository) {
        this.contratoCSrv = contratoCSrv;
        this.solicitudSrv = solicitudSrv;
        this.personaCSrv = personaCSrv;
        this.beneficiarioCSrv = beneficiarioCSrv;
        this.familiaCSrv = familiaCSrv;
        this.periodicidadSrv = periodicidadSrv;
        this.estadoContratoSrv = estadoContratoSrv;
        this.productosSrv = productosSrv;
        this.planesSrv = planesSrv;
        this.tarifaSrv = tarifaSrv;
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.municipioSrv = municipioSrv;
        this.sucursalSrv = sucursalSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, ContratoCConstants.CLASS_NAME);
    }

    private List<ContratoC> solveContratoCTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, ContratoCConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveContratoCTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, ContratoCConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class ContratoC
     *
     * @return Population of class ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> get() {
        List<ContratoC> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class ContratoC that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class ContratoC matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> get(QueryRequest queryRequest) {
        return solveContratoCTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveContratoCTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveContratoCTypedCountQuery(queryRequest) : 0);
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
        return new PopulationResponseViewModel(solveContratoCTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of ContratoC by ID
     *
     * @param contratoCID Identification field contratoCID
     *
     * @return Instance of ContratoC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ContratoC getById(Long contratoCID) {
        return getByOID(new ContratoCOid(contratoCID));
    }
    
    /*
     * Returns an instance of ContratoC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ContratoC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ContratoC getByOID(ContratoCOid oid) {
        Optional<ContratoC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of ContratoC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public ContratoC getByOIDWithHV(ContratoCOid oid) {
        Optional<ContratoC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<ContratoC> getInstanceByOid(ContratoCOid oid) {
        return oid != null && oid.getContratoCID() != null
               ? repository.findById(oid.getContratoCID())
               : Optional.empty();
    }

    /*
     * Returns an instance of ContratoC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of ContratoC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public ContratoC getByJsonOid(String jsonOid) {
        ContratoCOid oid = new ContratoCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of ContratoC related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveContratoCTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of ContratoC related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<ContratoC> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of ContratoC
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of ContratoC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getContratoCDynamic(ContratoCOid oid, String displaySetItems) {
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
    public String getSuppInfo(ContratoCOid oid, String dsName) {
        ContratoC instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(ContratoC instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods



    // Service: InsAsesorC

    /*
     * Entry point for service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insAsesorC(
            com.keralty.aeusuarios.viewmodel.contratoc.siu.InsAsesorCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.insAsesorCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insAsesorCTxn(
            com.keralty.aeusuarios.viewmodel.contratoc.siu.InsAsesorCRequest request) throws ModelException {
        request.setContratoCInsAsesorCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCInsAsesorCpthisContratoC()));
        request.setContratoCInsAsesorCpevcAsesorInstance(asesorSrv.getByOIDWithHV(request.getContratoCInsAsesorCpevcAsesor()));
        return contratoCSrv.insAsesorCImplementation(request, true);
    }

    /*
     * Implements service InsAsesorC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insAsesorCImplementation(
            com.keralty.aeusuarios.viewmodel.contratoc.siu.InsAsesorCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCInsAsesorCpthisContratoC = request.getContratoCInsAsesorCpthisContratoCInstance();
        Asesor contratoCInsAsesorCpevcAsesor = request.getContratoCInsAsesorCpevcAsesorInstance();

        request.checkArguments();
        ContratoC instance = contratoCInsAsesorCpthisContratoC;

        instance.add2AsesorC(contratoCInsAsesorCpevcAsesor);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.asesor.siu.InsAsesorCRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.asesor.siu.InsAsesorCRequest();
            relatedRequest.setAsesorInsAsesorCpthisAsesorInstance(contratoCInsAsesorCpevcAsesor);
            relatedRequest.setAsesorInsAsesorCpevcContratoCInstance(contratoCInsAsesorCpthisContratoC);
            asesorSrv.insAsesorCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: DelAsesorC

    /*
     * Entry point for service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delAsesorC(
            com.keralty.aeusuarios.viewmodel.contratoc.siu.DelAsesorCRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = contratoCSrv.delAsesorCTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delAsesorCTxn(
            com.keralty.aeusuarios.viewmodel.contratoc.siu.DelAsesorCRequest request) throws ModelException {
        request.setContratoCDelAsesorCpthisContratoCInstance(contratoCSrv.getByOIDWithHV(request.getContratoCDelAsesorCpthisContratoC()));
        request.setContratoCDelAsesorCpevcAsesorInstance(asesorSrv.getByOIDWithHV(request.getContratoCDelAsesorCpevcAsesor()));
        return contratoCSrv.delAsesorCImplementation(request, true);
    }

    /*
     * Implements service DelAsesorC
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delAsesorCImplementation(
            com.keralty.aeusuarios.viewmodel.contratoc.siu.DelAsesorCRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        ContratoC contratoCDelAsesorCpthisContratoC = request.getContratoCDelAsesorCpthisContratoCInstance();
        Asesor contratoCDelAsesorCpevcAsesor = request.getContratoCDelAsesorCpevcAsesorInstance();

        request.checkArguments();
        ContratoC instance = contratoCDelAsesorCpthisContratoC;

        instance.add2AsesorC(null);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.asesor.siu.DelAsesorCRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.asesor.siu.DelAsesorCRequest();
            relatedRequest.setAsesorDelAsesorCpthisAsesorInstance(contratoCDelAsesorCpevcAsesor);
            relatedRequest.setAsesorDelAsesorCpevcContratoCInstance(contratoCDelAsesorCpthisContratoC);
            asesorSrv.delAsesorCImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));

        return response;
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
        select.getOrderByPart().addItem(Constants.normalizePath(ContratoCConstants.CLASS_NAME, ContratoCConstants.ATTR_FIELD_CONTRATOCID, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildContratoCRelatedInstance(relatedInstanceJsonOid);
        }
        if (ContratoCConstants.ROLE_NAME_SOLICITUD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Solicitud(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PERSONACCONTRATANTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4PersonaC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_BENEFICIARIOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4BeneficiarioC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_FAMILIASC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4FamiliaC(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PERIODICIDADC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Periodicidad(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_ESTADOCONTRATOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4EstadoContrato(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PRODUCTOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_PLANC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_TARIFAC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Tarifa(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_GRUPOASOCIADOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4GrupoAsociado(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_MUNICIPIOC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Municipio(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_SUCURSALC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Sucursal(relatedInstanceJsonOid, remainingPath);
        }
        if (ContratoCConstants.ROLE_NAME_ASESORC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildContratoCRelatedInstance4Asesor(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildContratoCRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Solicitud(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Solicitud(mapper.readValue(relatedInstanceJsonOid, SolicitudOid.class)): Solicitud.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4PersonaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PersonaC(mapper.readValue(relatedInstanceJsonOid, PersonaCOid.class)): PersonaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4BeneficiarioC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new BeneficiarioC(mapper.readValue(relatedInstanceJsonOid, BeneficiarioCOid.class)): BeneficiarioC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4FamiliaC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaC(mapper.readValue(relatedInstanceJsonOid, FamiliaCOid.class)): FamiliaC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Periodicidad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Periodicidad(mapper.readValue(relatedInstanceJsonOid, PeriodicidadOid.class)): Periodicidad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4EstadoContrato(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoContrato(mapper.readValue(relatedInstanceJsonOid, EstadoContratoOid.class)): EstadoContrato.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Tarifa(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Tarifa(mapper.readValue(relatedInstanceJsonOid, TarifaOid.class)): Tarifa.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4GrupoAsociado(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsociado(mapper.readValue(relatedInstanceJsonOid, GrupoAsociadoOid.class)): GrupoAsociado.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Municipio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Municipio(mapper.readValue(relatedInstanceJsonOid, MunicipioOid.class)): Municipio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Sucursal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Sucursal(mapper.readValue(relatedInstanceJsonOid, SucursalOid.class)): Sucursal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildContratoCRelatedInstance4Asesor(String relatedInstanceJsonOid, String remainingPath) {
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
            ContratoCOid oid = new ContratoCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ContratoCConstants.ATTR_FIELD_CONTRATOCID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getContratoCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ContratoCService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
