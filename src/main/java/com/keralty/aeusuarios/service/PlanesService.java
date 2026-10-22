package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AesolicitudesConstants;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Aesolicitudes;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.GrupoAsociado;
import com.keralty.aeusuarios.persistence.oid.AesolicitudesOid;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsociadoOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.oid.TarifaOid;
import com.keralty.aeusuarios.persistence.oid.TipoIVAOid;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.persistence.Tarifa;
import com.keralty.aeusuarios.persistence.TipoIVA;
import com.keralty.aeusuarios.repository.PlanesJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandNull;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
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
public class PlanesService extends AbstractService {

    PlanesJpaRepository repository;

    PlanesService planesSrv;

    ProductosService productosSrv;

    RolService rolSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    RegionalService regionalSrv;

    DominioService dominioSrv;

    TarifaService tarifaSrv;

    GrupoAsociadoService grupoAsociadoSrv;

    TipoIVAService tipoIVASrv;

    AesolicitudesService aesolicitudesSrv;

    ContratoCService contratoCSrv;

    SolicitudNovedadService solicitudNovedadSrv;

    @Inject
    public PlanesService(
            PlanesService planesSrv,
            ProductosService productosSrv,
            RolService rolSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            RegionalService regionalSrv,
            DominioService dominioSrv,
            TarifaService tarifaSrv,
            GrupoAsociadoService grupoAsociadoSrv,
            TipoIVAService tipoIVASrv,
            AesolicitudesService aesolicitudesSrv,
            ContratoCService contratoCSrv,
            SolicitudNovedadService solicitudNovedadSrv,
            PlanesJpaRepository repository) {
        this.planesSrv = planesSrv;
        this.productosSrv = productosSrv;
        this.rolSrv = rolSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.regionalSrv = regionalSrv;
        this.dominioSrv = dominioSrv;
        this.tarifaSrv = tarifaSrv;
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.tipoIVASrv = tipoIVASrv;
        this.aesolicitudesSrv = aesolicitudesSrv;
        this.contratoCSrv = contratoCSrv;
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, PlanesConstants.CLASS_NAME);
    }

    private List<Planes> solvePlanesTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, PlanesConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solvePlanesTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, PlanesConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class Planes
     *
     * @return Population of class Planes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Planes> get() {
        List<Planes> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Planes
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Planes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Planes> instances = get(queryRequest);
        if(PlanesConstants.DSICPLAN.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICPlan())).collect(Collectors.toList());
        }
        if(PlanesConstants.DSDSPLANPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSPlanPIU())).collect(Collectors.toList());
        }
        if(PlanesConstants.DSDSPLANESDAFILIACION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSPlanesDAfiliacion())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Planes that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Planes matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Planes> get(QueryRequest queryRequest) {
        return solvePlanesTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solvePlanesTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solvePlanesTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solvePlanesTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solvePlanesTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Planes by ID
     *
     * @param planesPlan Identification field planesPlan
     *
     * @return Instance of Planes
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Planes getById(Long planesPlan) {
        return getByOID(new PlanesOid(planesPlan));
    }
    
    /*
     * Returns an instance of Planes by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Planes
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Planes getByOID(PlanesOid oid) {
        Optional<Planes> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Planes by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Planes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Planes getByOIDWithHV(PlanesOid oid) {
        Optional<Planes> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Planes> getInstanceByOid(PlanesOid oid) {
        return oid != null && oid.getPlanesPlan() != null
               ? repository.findById(oid.getPlanesPlan())
               : Optional.empty();
    }

    /*
     * Returns an instance of Planes by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Planes
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Planes getByJsonOid(String jsonOid) {
        PlanesOid oid = new PlanesOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Planes related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Planes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Planes> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solvePlanesTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Planes related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Planes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Planes> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Planes
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Planes
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getPlanesDynamic(PlanesOid oid, String displaySetItems) {
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
    public String getSuppInfo(PlanesOid oid, String dsName) {
        Planes instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Planes instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (PlanesConstants.DSICPLAN.equals(dsName))
            return instance.buildICPlan();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Planes instance, String dsName) {
        if (PlanesConstants.DSICPLAN.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICPlan());
        if (PlanesConstants.DSDSPLANPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSPlanPIU());
        if (PlanesConstants.DSDSPLANESDAFILIACION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSPlanesDAfiliacion());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (PlanesConstants.FILTER_NAME_FPLANVARIOS.equalsIgnoreCase(filterRequest.getName()))
            fPlanVarios(filterRequest, sql);
        if (PlanesConstants.FILTER_NAME_IFPLANCODIGO.equalsIgnoreCase(filterRequest.getName()))
            iFPlanCodigo(filterRequest, sql);
        if (PlanesConstants.FILTER_NAME_FPLANESPORCODLEGAL.equalsIgnoreCase(filterRequest.getName()))
            fPlanesPorCodLegal(filterRequest, sql);
    }

    @Override
    protected void applyNavigationalFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if ("Dominio_crear_p_agrPlanT_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav9(filterRequest, sql);
        if ("TipoIVA_crear_p_agrPlanT_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431882432512691FiltNav3(filterRequest, sql);
        if ("Ae_solicitudes_TNUEVAAFILIACION_pt_p_agrPlan_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431956094976663FiltNav2(filterRequest, sql);
        if ("Ae_solicitudes_TNUEVAAFILIACION_pt_p_agrPlan_NavFilter1".equalsIgnoreCase(filterRequest.getName()))
            clas1431956094976663FiltNav16(filterRequest, sql);
        if ("Ae_solicitudes_TINCLUSIONSC_pt_p_agrPlan_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1431956094976663FiltNav8(filterRequest, sql);
        if ("Ae_solicitudes_TINCLUSIONSC_pt_p_agrPlan_NavFilter1".equalsIgnoreCase(filterRequest.getName()))
            clas1431956094976663FiltNav17(filterRequest, sql);
        if ("Afiliaciones_InsPlan_p_evcPlanes_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1434549485568784FiltNav1(filterRequest, sql);
        if ("Afiliaciones_DelPlan_p_evcPlanes_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1434549485568784FiltNav2(filterRequest, sql);
        if ("SolicitudNovedad_TCREAR_pt_p_agrPlan_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1581421428736234FiltNav2(filterRequest, sql);
        if ("SolicitudNovedad_TCREAR_pt_p_agrPlan_NavFilter1".equalsIgnoreCase(filterRequest.getName()))
            clas1581421428736234FiltNav27(filterRequest, sql);
        if ("SolicitudNovedad_TCREAREXCEPCION_pt_p_agrPlan_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            clas1581421428736234FiltNav11(filterRequest, sql);
        if ("TGCREARTARIFA_pPlan_NavFilter0".equalsIgnoreCase(filterRequest.getName()))
            iGl1445874368512966FiltNav1(filterRequest, sql);
        if ("Dominio_F_DominioVarios_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431701422080423FiltNav1(filterRequest, sql);
        if ("Tarifa_F_TarifaVarios_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431714529280565FiltNav1(filterRequest, sql);
        if ("GrupoAsociado_F_GrupoAsociadoVarios_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431875354624341FiltNav1(filterRequest, sql);
        if ("TipoIVA_F_TipoIVAVarios_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431882432512691FiltNav2(filterRequest, sql);
        if ("Solicitud_F_SolicitudStatusAdmin_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav19(filterRequest, sql);
        if ("Solicitud_F_SolicitudStatus_Afil1_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav58(filterRequest, sql);
        if ("Solicitud_F_SolicitudStatus_Afil2_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav60(filterRequest, sql);
        if ("Solicitud_F_SolicitudStatus_Afil3_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav62(filterRequest, sql);
        if ("Solicitud_F_SolicitudEstatus_AreaMed1_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav64(filterRequest, sql);
        if ("Solicitud_F_SolicitudEstatus_AreaMed2_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav66(filterRequest, sql);
        if ("Solicitud_F_SolicitudEstatus_AreaMed3_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav68(filterRequest, sql);
        if ("Solicitud_F_SolicitudStatusEstHomo_vo_Plan_NavFilter".equalsIgnoreCase(filterRequest.getName()))
            clas1431957012480960FiltNav73(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Plan".equals(filterRequest.getName()))
            suppInfo4ICPlan(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fPlanVarios(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos voProducto = filterRequest.hasFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VOPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VOPRODUCTO)))) : null;
        String vNombre = filterRequest.hasFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VNOMBRE) ? (String) filterRequest.getFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VNOMBRE, FilterVariableRequest.STRING) : null;
        Boolean vEsBancoRep = filterRequest.hasFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VESBANCOREP) ? (Boolean) filterRequest.getFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VESBANCOREP, FilterVariableRequest.BOOL) : null;
        Boolean vEsVoluntario = filterRequest.hasFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VESVOLUNTARIO) ? (Boolean) filterRequest.getFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VESVOLUNTARIO, FilterVariableRequest.BOOL) : null;

        // ProductoT = voProducto
        if (voProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(PlanesConstants.VAR_NAME_FPLANVARIOS_VOPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, voProducto.getOid(), PlanesConstants.VAR_NAME_FPLANVARIOS_VOPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // Nombre LIKE "%" + vNombre
        if (vNombre != null) {
            // 'like' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("like");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESNOMBRE, Constants.Type.STRING.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral("%" + vNombre, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // EsBancoRep = vEsBancoRep
        if (vEsBancoRep != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESESBANCOREP, Constants.Type.BOOL.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vEsBancoRep, Constants.Type.BOOL.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // EsVoluntario = vEsVoluntario
        if (vEsVoluntario != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESESVOLUNTARIO, Constants.Type.BOOL.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vEsVoluntario, Constants.Type.BOOL.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFPlanCodigo(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vCodigo = filterRequest.hasFilterVariable(PlanesConstants.VAR_NAME_IFPLANCODIGO_VCODIGO) ? (Long) filterRequest.getFilterVariable(PlanesConstants.VAR_NAME_IFPLANCODIGO_VCODIGO, FilterVariableRequest.INT) : null;

        // Plan = vCodigo
        if (vCodigo != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESPLAN, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vCodigo, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void fPlanesPorCodLegal(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfCodigoLegal = filterRequest.hasFilterVariable(PlanesConstants.VAR_NAME_FPLANESPORCODLEGAL_VFCODIGOLEGAL) ? (String) filterRequest.getFilterVariable(PlanesConstants.VAR_NAME_FPLANESPORCODLEGAL_VFCODIGOLEGAL, FilterVariableRequest.STRING) : null;

        // CodigoLegal = vfCodigoLegal
        if (vfCodigoLegal != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfCodigoLegal, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void clas1431701422080423FiltNav9(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos dominiocrearpagrProductoT = filterRequest.hasFilterVariable(DominioConstants.ARG_NAME_CREAR_DOMINIOCREARPAGRPRODUCTOT) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.ARG_NAME_CREAR_DOMINIOCREARPAGRPRODUCTOT)))) : null;

        // ProductoT = pagrProductoT
        if (dominiocrearpagrProductoT != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.ARG_NAME_CREAR_DOMINIOCREARPAGRPRODUCTOT, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, dominiocrearpagrProductoT.getOid(), DominioConstants.ARG_NAME_CREAR_DOMINIOCREARPAGRPRODUCTOT);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431882432512691FiltNav3(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav9(filterRequest, sql);
    }

    private void clas1431956094976663FiltNav2(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto = filterRequest.hasFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO)))) : null;

        // ProductoT = ptpagrProducto
        if (aesolicitudesTNUEVAAFILIACIONptpagrProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aesolicitudesTNUEVAAFILIACIONptpagrProducto.getOid(), AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // EXIST (Dominios) WHERE (Dominios.ProductoT = ptpagrProducto AND Dominios.NuevaAfiliacion = true) = true
        if (aesolicitudesTNUEVAAFILIACIONptpagrProducto != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator006 = new SQLWhereOperandSubQuery(repository.assocOperator006Range1Query(aesolicitudesTNUEVAAFILIACIONptpagrProducto, sql));
    conjunction.addOperand(operandSubQueryAssocOperator006);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431956094976663FiltNav16(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        if(!(getAgentRoles().contains(AsesorConstants.CLASS_NAME))) return;
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos aesolicitudesTNUEVAAFILIACIONptpagrProducto = filterRequest.hasFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(AesolicitudesConstants.ARG_NAME_TNUEVAAFILIACION_AESOLICITUDESTNUEVAAFILIACIONPTPAGRPRODUCTO)))) : null;

        // COUNT (AGENTAsesor.AgentexProducto) WHERE (AGENTAsesor.AgentexProducto.ProductoT = ptpagrProducto AND AGENTAsesor.AgentexProducto.TodosDominios = true) > 0 OR COUNT (Dominios.AgentexProducto) WHERE (Dominios.AgentexProducto.ProductoT = ptpagrProducto AND Dominios.AgentexProducto.Asesor = AGENTAsesor) > 0
        if (aesolicitudesTNUEVAAFILIACIONptpagrProducto != null) {
        {
            // 'or' Logical operator
            SQLWhereDisjunction comparison1 = new SQLWhereDisjunction();
        
            // Operand 1
                    // '>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator(">");
                    
                    // Operand 1
                        // 'count' Association operator
                        SQLWhereOperandSubQuery operandSubQueryAssocOperator007 = new SQLWhereOperandSubQuery(repository.assocOperator007Range1Query(aesolicitudesTNUEVAAFILIACIONptpagrProducto, sql));
                    comparison2.setFirstOperand(operandSubQueryAssocOperator007);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                    comparison1.addOperand(comparison2);
        
            // Operand 2
                    // '>' Comparison
                    SQLWhereComparison comparison20 = new SQLWhereComparison(sql);
                    comparison20.setOperator(">");
                    
                    // Operand 1
                        // 'count' Association operator
                        SQLWhereOperandSubQuery operandSubQueryAssocOperator008 = new SQLWhereOperandSubQuery(repository.assocOperator008Range1Query(aesolicitudesTNUEVAAFILIACIONptpagrProducto, sql));
                    comparison20.setFirstOperand(operandSubQueryAssocOperator008);
                    
                    // Operand 2
                    comparison20.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                    comparison1.addOperand(comparison20);
            
            conjunction.addOperand(comparison1);
        }

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431956094976663FiltNav8(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos aesolicitudesTINCLUSIONSCptpagrProducto = filterRequest.hasFilterVariable(AesolicitudesConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(AesolicitudesConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO)))) : null;

        // ProductoT = ptpagrProducto
        if (aesolicitudesTINCLUSIONSCptpagrProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(AesolicitudesConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, aesolicitudesTINCLUSIONSCptpagrProducto.getOid(), AesolicitudesConstants.ARG_NAME_TINCLUSIONSC_AESOLICITUDESTINCLUSIONSCPTPAGRPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // EXIST (Dominios) WHERE (Dominios.ProductoT = ptpagrProducto AND Dominios.Inclusion = true) = true
        if (aesolicitudesTINCLUSIONSCptpagrProducto != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator009 = new SQLWhereOperandSubQuery(repository.assocOperator009Range1Query(aesolicitudesTINCLUSIONSCptpagrProducto, sql));
    conjunction.addOperand(operandSubQueryAssocOperator009);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431956094976663FiltNav17(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        clas1431956094976663FiltNav16(filterRequest, sql);
    }

    private void clas1434549485568784FiltNav1(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Afiliaciones afiliacionesInsPlanpthisAfiliaciones = filterRequest.hasFilterVariable(AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES) ? afiliacionesSrv.getByOID(new AfiliacionesOid().fromJsonString(toJson(filterRequest.getFilterVariable(AfiliacionesConstants.ARG_NAME_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES)))) : null;

        // COUNT (pthisAfiliaciones.Planes) WHERE (pthisAfiliaciones.Planes.Plan = Plan) = 0
        if (afiliacionesInsPlanpthisAfiliaciones != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
                // 'count' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(afiliacionesInsPlanpthisAfiliaciones, sql));
            comparison1.setFirstOperand(operandSubQueryAssocOperator000);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1434549485568784FiltNav2(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Afiliaciones afiliacionesDelPlanpthisAfiliaciones = filterRequest.hasFilterVariable(AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES) ? afiliacionesSrv.getByOID(new AfiliacionesOid().fromJsonString(toJson(filterRequest.getFilterVariable(AfiliacionesConstants.ARG_NAME_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES)))) : null;

        // COUNT (pthisAfiliaciones.Planes) WHERE (pthisAfiliaciones.Planes.Plan = Plan) > 0
        if (afiliacionesDelPlanpthisAfiliaciones != null) {
            // '>' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator(">");
            
            // Operand 1
                // 'count' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator001 = new SQLWhereOperandSubQuery(repository.assocOperator001Range1Query(afiliacionesDelPlanpthisAfiliaciones, sql));
            comparison1.setFirstOperand(operandSubQueryAssocOperator001);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1581421428736234FiltNav2(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos solicitudNovedadTCREARptProducto = filterRequest.hasFilterVariable(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO)))) : null;

        // ProductoT = ptProducto
        if (solicitudNovedadTCREARptProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, solicitudNovedadTCREARptProducto.getOid(), SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // EXIST (Dominios) WHERE (Dominios.ProductoT = ptProducto) = true
        if (solicitudNovedadTCREARptProducto != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator012 = new SQLWhereOperandSubQuery(repository.assocOperator012Range1Query(solicitudNovedadTCREARptProducto, sql));
    conjunction.addOperand(operandSubQueryAssocOperator012);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1581421428736234FiltNav27(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos solicitudNovedadTCREARptProducto = filterRequest.hasFilterVariable(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(SolicitudNovedadConstants.ARG_NAME_TCREAR_SOLICITUDNOVEDADTCREARPTPRODUCTO)))) : null;

        // AGENTAsesor = NULL OR COUNT (AGENTAsesor.AgentexProducto) WHERE (AGENTAsesor.AgentexProducto.ProductoT = ptProducto AND AGENTAsesor.AgentexProducto.TodosDominios = true) > 0 OR COUNT (Dominios.AgentexProducto) WHERE (Dominios.AgentexProducto.ProductoT = ptProducto AND Dominios.AgentexProducto.Asesor = AGENTAsesor) > 0
        if (solicitudNovedadTCREARptProducto != null) {
        {
            // 'or' Logical operator
            SQLWhereDisjunction comparison1 = new SQLWhereDisjunction();
        
            // Operand 1
                {
                    // 'or' Logical operator
                    SQLWhereDisjunction comparison2 = new SQLWhereDisjunction();
                
                    // Operand 1
                            // '=' Comparison
                            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
                            comparison3.setOperator("=");
                            
                            // Operand 1
                            SQLWhereOperandOVParameter operand114 = new SQLWhereOperandOVParameter(Constants.AGENT_ASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, ((Asesor) getAgentInstance(AsesorConstants.CLASS_NAME)).getOid(), Constants.AGENT_ASESOR);
                            comparison3.setFirstOperand(operand114);
                            
                            // Operand 2
                            comparison3.setSecondOperand(new SQLWhereOperandNull());
                            comparison2.addOperand(comparison3);
                
                    // Operand 2
                            // '>' Comparison
                            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
                            comparison4.setOperator(">");
                            
                            // Operand 1
                                // 'count' Association operator
                                SQLWhereOperandSubQuery operandSubQueryAssocOperator013 = new SQLWhereOperandSubQuery(repository.assocOperator013Range1Query(solicitudNovedadTCREARptProducto, sql));
                            comparison4.setFirstOperand(operandSubQueryAssocOperator013);
                            
                            // Operand 2
                            comparison4.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                            comparison2.addOperand(comparison4);
                    
                    comparison1.addOperand(comparison2);
                }
        
            // Operand 2
                    // '>' Comparison
                    SQLWhereComparison comparison30 = new SQLWhereComparison(sql);
                    comparison30.setOperator(">");
                    
                    // Operand 1
                        // 'count' Association operator
                        SQLWhereOperandSubQuery operandSubQueryAssocOperator014 = new SQLWhereOperandSubQuery(repository.assocOperator014Range1Query(solicitudNovedadTCREARptProducto, sql));
                    comparison30.setFirstOperand(operandSubQueryAssocOperator014);
                    
                    // Operand 2
                    comparison30.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                    comparison1.addOperand(comparison30);
            
            conjunction.addOperand(comparison1);
        }

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1581421428736234FiltNav11(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        clas1581421428736234FiltNav2(filterRequest, sql);
    }

    private void iGl1445874368512966FiltNav1(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos tGCREARTARIFApProducto = filterRequest.hasFilterVariable(GlobalServiceConstants.GS_ARG_NAME_TGCREARTARIFA_TGCREARTARIFAPPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(GlobalServiceConstants.GS_ARG_NAME_TGCREARTARIFA_TGCREARTARIFAPPRODUCTO)))) : null;

        // ProductoT = pProducto
        if (tGCREARTARIFApProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GlobalServiceConstants.GS_ARG_NAME_TGCREARTARIFA_TGCREARTARIFAPPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, tGCREARTARIFApProducto.getOid(), GlobalServiceConstants.GS_ARG_NAME_TGCREARTARIFA_TGCREARTARIFAPPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431701422080423FiltNav1(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos voProducto = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO)))) : null;

        // ProductoT = voProducto
        if (voProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(PlanesConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, voProducto.getOid(), DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        
        sql.addConjunction(conjunction);
    }

    private void clas1431714529280565FiltNav1(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431875354624341FiltNav1(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431882432512691FiltNav2(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav19(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav58(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav60(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav62(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav64(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav66(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav68(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    private void clas1431957012480960FiltNav73(FilterRequest filterRequest, SQLSelect sql) {
        clas1431701422080423FiltNav1(filterRequest, sql);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUPlan
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Planes using displayset DSPlanPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.planes.ds.DSPlanPIU> piuPIUPlan(QueryRequest queryRequest) {
        return solvePlanesTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.planes.ds.DSPlanPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUPlan
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUPlan
     */
    public int getCount4PIUPlan(QueryRequest queryRequest) {
        return solvePlanesTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUPlanesDAfiliacion
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Planes using displayset DSPlanesDAfiliacion that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.planes.ds.DSPlanesDAfiliacion> piuPIUPlanesDAfiliacion(QueryRequest queryRequest) {
        return solvePlanesTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.planes.ds.DSPlanesDAfiliacion::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUPlanesDAfiliacion
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUPlanesDAfiliacion
     */
    public int getCount4PIUPlanesDAfiliacion(QueryRequest queryRequest) {
        return solvePlanesTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUPlanesObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Planes using displayset DSPlanPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.planes.ds.DSPlanPIU> piuPIUPlanesObs(QueryRequest queryRequest) {
        return solvePlanesTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.planes.ds.DSPlanPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUPlanesObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUPlanesObs
     */
    public int getCount4PIUPlanesObs(QueryRequest queryRequest) {
        return solvePlanesTypedQuery(queryRequest).size();
    }

    // Service: InsPlan

    /*
     * Entry point for service InsPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insPlan(
            com.keralty.aeusuarios.viewmodel.planes.siu.InsPlanRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = planesSrv.insPlanTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insPlanTxn(
            com.keralty.aeusuarios.viewmodel.planes.siu.InsPlanRequest request) throws ModelException {
        request.setPlanesInsPlanpthisPlanesInstance(planesSrv.getByOIDWithHV(request.getPlanesInsPlanpthisPlanes()));
        request.setPlanesInsPlanpevcAfiliacionesInstance(afiliacionesSrv.getByOIDWithHV(request.getPlanesInsPlanpevcAfiliaciones()));
        return planesSrv.insPlanImplementation(request, true);
    }

    /*
     * Implements service InsPlan
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insPlanImplementation(
            com.keralty.aeusuarios.viewmodel.planes.siu.InsPlanRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Planes planesInsPlanpthisPlanes = request.getPlanesInsPlanpthisPlanesInstance();
        Afiliaciones planesInsPlanpevcAfiliaciones = request.getPlanesInsPlanpevcAfiliacionesInstance();

        request.checkArguments();
        Planes instance = planesInsPlanpthisPlanes;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.InsPlanRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.afiliaciones.siu.InsPlanRequest();
            relatedRequest.setAfiliacionesInsPlanpthisAfiliacionesInstance(planesInsPlanpevcAfiliaciones);
            relatedRequest.setAfiliacionesInsPlanpevcPlanesInstance(planesInsPlanpthisPlanes);
            afiliacionesSrv.insPlanImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPlan());

        return response;
    }

    // Service: DelPlan

    /*
     * Entry point for service DelPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delPlan(
            com.keralty.aeusuarios.viewmodel.planes.siu.DelPlanRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = planesSrv.delPlanTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelPlan
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delPlanTxn(
            com.keralty.aeusuarios.viewmodel.planes.siu.DelPlanRequest request) throws ModelException {
        request.setPlanesDelPlanpthisPlanesInstance(planesSrv.getByOIDWithHV(request.getPlanesDelPlanpthisPlanes()));
        request.setPlanesDelPlanpevcAfiliacionesInstance(afiliacionesSrv.getByOIDWithHV(request.getPlanesDelPlanpevcAfiliaciones()));
        return planesSrv.delPlanImplementation(request, true);
    }

    /*
     * Implements service DelPlan
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delPlanImplementation(
            com.keralty.aeusuarios.viewmodel.planes.siu.DelPlanRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Planes planesDelPlanpthisPlanes = request.getPlanesDelPlanpthisPlanesInstance();
        Afiliaciones planesDelPlanpevcAfiliaciones = request.getPlanesDelPlanpevcAfiliacionesInstance();

        request.checkArguments();
        Planes instance = planesDelPlanpthisPlanes;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.afiliaciones.siu.DelPlanRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.afiliaciones.siu.DelPlanRequest();
            relatedRequest.setAfiliacionesDelPlanpthisAfiliacionesInstance(planesDelPlanpevcAfiliaciones);
            relatedRequest.setAfiliacionesDelPlanpevcPlanesInstance(planesDelPlanpthisPlanes);
            afiliacionesSrv.delPlanImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICPlan());

        return response;
    }


    private void suppInfo4ICPlan(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_NAME_PLANESNOMBRE, Constants.Type.STRING.getTypeName()));
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
        applyOCOCPlan(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(PlanesConstants.CLASS_NAME, PlanesConstants.ATTR_FIELD_PLANESPLAN, false), true);
    }


    private void applyOCOCPlan(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Plan".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(PlanesConstants.CLASS_NAME, PlanesConstants.ATTR_NAME_PLANESNOMBRE, false), true);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildPlanesRelatedInstance(relatedInstanceJsonOid);
        }
        if (PlanesConstants.ROLE_NAME_DOMINIOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_TARIFAS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4Tarifa(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_GRUPOSASOCIADOS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4GrupoAsociado(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_TIPOSIVA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4TipoIVA(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_AESOLICITUDES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4Aesolicitudes(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_CONTRATOSC.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4ContratoC(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_AFILIACIONES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4Afiliaciones(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_SOLICITUDESNOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4SolicitudNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (PlanesConstants.ROLE_NAME_PRODUCTOT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildPlanesRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildPlanesRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4Tarifa(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Tarifa(mapper.readValue(relatedInstanceJsonOid, TarifaOid.class)): Tarifa.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4GrupoAsociado(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsociado(mapper.readValue(relatedInstanceJsonOid, GrupoAsociadoOid.class)): GrupoAsociado.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4TipoIVA(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIVA(mapper.readValue(relatedInstanceJsonOid, TipoIVAOid.class)): TipoIVA.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4Aesolicitudes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Aesolicitudes(mapper.readValue(relatedInstanceJsonOid, AesolicitudesOid.class)): Aesolicitudes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4ContratoC(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ContratoC(mapper.readValue(relatedInstanceJsonOid, ContratoCOid.class)): ContratoC.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4Afiliaciones(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Afiliaciones(mapper.readValue(relatedInstanceJsonOid, AfiliacionesOid.class)): Afiliaciones.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4SolicitudNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class)): SolicitudNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    private AbstractAppEntity buildPlanesRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
    		return null;
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PlanesOid oid = new PlanesOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PlanesConstants.ATTR_FIELD_PLANESPLAN, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPlanesPlan(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PlanesService.class).error(e.getMessage());
        }
    }

}
