package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.Novedad;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;
import com.keralty.aeusuarios.persistence.oid.NovedadOid;
import com.keralty.aeusuarios.persistence.oid.PeriodicidadOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.PlantillaEmailOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.oid.ReportesDominioOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Periodicidad;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.PlantillaEmail;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.ReportesDominio;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.repository.DominioJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereDisjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
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
public class DominioService extends AbstractService {

    DominioJpaRepository repository;

    DominioService dominioSrv;

    RolService rolSrv;

    AgentexProductoService agentexProductoSrv;

    ProductosService productosSrv;

    PlanesService planesSrv;

    ReportesDominioService reportesDominioSrv;

    PeriodicidadService periodicidadSrv;

    PlantillaEmailService plantillaEmailSrv;

    NovedadService novedadSrv;

    GrupoAsignacionService grupoAsignacionSrv;

    @Inject
    public DominioService(
            DominioService dominioSrv,
            RolService rolSrv,
            AgentexProductoService agentexProductoSrv,
            ProductosService productosSrv,
            PlanesService planesSrv,
            ReportesDominioService reportesDominioSrv,
            PeriodicidadService periodicidadSrv,
            PlantillaEmailService plantillaEmailSrv,
            NovedadService novedadSrv,
            GrupoAsignacionService grupoAsignacionSrv,
            DominioJpaRepository repository) {
        this.dominioSrv = dominioSrv;
        this.rolSrv = rolSrv;
        this.agentexProductoSrv = agentexProductoSrv;
        this.productosSrv = productosSrv;
        this.planesSrv = planesSrv;
        this.reportesDominioSrv = reportesDominioSrv;
        this.periodicidadSrv = periodicidadSrv;
        this.plantillaEmailSrv = plantillaEmailSrv;
        this.novedadSrv = novedadSrv;
        this.grupoAsignacionSrv = grupoAsignacionSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, DominioConstants.CLASS_NAME);
    }

    private List<Dominio> solveDominioTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, DominioConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveDominioTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, DominioConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class Dominio
     *
     * @return Population of class Dominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Dominio> get() {
        List<Dominio> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class Dominio
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class Dominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<Dominio> instances = get(queryRequest);
        if(DominioConstants.DSICDOMINIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICDominio())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioPIU())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOIIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioIIU())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOIIUREPORTES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioIIUReportes())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOFIRMARESPCLAUSULADO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioFirmaRespClausulado())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOSOLNOVEDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioSolNovedad())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOMGRUPOASESORES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioMGrupoAsesores())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOMGRUPOAREAMEDICA.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioMGrupoAreaMedica())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOMGRUPOSUSUARIOS.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioMGruposUsuarios())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOSPORASESOR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominiosPorAsesor())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIOMLOG.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioMLog())).collect(Collectors.toList());
        }
        if(DominioConstants.DSDSDOMINIODINCOMPATIBLES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSDominioDIncompatibles())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class Dominio that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class Dominio matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Dominio> get(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveDominioTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveDominioTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveDominioTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveDominioTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of Dominio by ID
     *
     * @param dominioNumero Identification field dominioNumero
     *
     * @return Instance of Dominio
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Dominio getById(Long dominioNumero) {
        return getByOID(new DominioOid(dominioNumero));
    }
    
    /*
     * Returns an instance of Dominio by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Dominio
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Dominio getByOID(DominioOid oid) {
        Optional<Dominio> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Dominio by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Dominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Dominio getByOIDWithHV(DominioOid oid) {
        Optional<Dominio> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Dominio> getInstanceByOid(DominioOid oid) {
        return oid != null && oid.getDominioNumero() != null
               ? repository.findById(oid.getDominioNumero())
               : Optional.empty();
    }

    /*
     * Returns an instance of Dominio by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Dominio
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Dominio getByJsonOid(String jsonOid) {
        DominioOid oid = new DominioOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of Dominio related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Dominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Dominio> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveDominioTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of Dominio related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of Dominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<Dominio> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of Dominio
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of Dominio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getDominioDynamic(DominioOid oid, String displaySetItems) {
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
    public String getSuppInfo(DominioOid oid, String dsName) {
        Dominio instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(Dominio instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (DominioConstants.DSICDOMINIO.equals(dsName))
            return instance.buildICDominio();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(Dominio instance, String dsName) {
        if (DominioConstants.DSICDOMINIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICDominio());
        if (DominioConstants.DSDSDOMINIOPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioPIU());
        if (DominioConstants.DSDSDOMINIOIIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioIIU());
        if (DominioConstants.DSDSDOMINIOIIUREPORTES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioIIUReportes());
        if (DominioConstants.DSDSDOMINIOFIRMARESPCLAUSULADO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioFirmaRespClausulado());
        if (DominioConstants.DSDSDOMINIOSOLNOVEDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioSolNovedad());
        if (DominioConstants.DSDSDOMINIOMGRUPOASESORES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioMGrupoAsesores());
        if (DominioConstants.DSDSDOMINIOMGRUPOAREAMEDICA.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioMGrupoAreaMedica());
        if (DominioConstants.DSDSDOMINIOMGRUPOSUSUARIOS.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioMGruposUsuarios());
        if (DominioConstants.DSDSDOMINIOSPORASESOR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominiosPorAsesor());
        if (DominioConstants.DSDSDOMINIOMLOG.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioMLog());
        if (DominioConstants.DSDSDOMINIODINCOMPATIBLES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSDominioDIncompatibles());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (DominioConstants.FILTER_NAME_FDOMINIOVARIOS.equalsIgnoreCase(filterRequest.getName()))
            fDominioVarios(filterRequest, sql);
        if (DominioConstants.FILTER_NAME_IFDOMINIOPRODPLAN.equalsIgnoreCase(filterRequest.getName()))
            iFDominioProdPlan(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_Dominio".equals(filterRequest.getName()))
            suppInfo4ICDominio(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fDominioVarios(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos voProducto = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO)))) : null;
        Planes voPlan = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPLAN) ? planesSrv.getByOID(new PlanesOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPLAN)))) : null;
        Boolean vNuevaAfiliacion = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VNUEVAAFILIACION) ? (Boolean) filterRequest.getFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VNUEVAAFILIACION, FilterVariableRequest.BOOL) : null;
        Boolean vInclusion = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VINCLUSION) ? (Boolean) filterRequest.getFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VINCLUSION, FilterVariableRequest.BOOL) : null;
        Rol voRol = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOROL) ? rolSrv.getByOID(new RolOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOROL)))) : null;

        // ProductoT = voProducto
        if (voProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, voProducto.getOid(), DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // PlanT = voPlan
        if (voPlan != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPLAN, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, voPlan.getOid(), DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPLAN);
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        // NuevaAfiliacion = vNuevaAfiliacion
        if (vNuevaAfiliacion != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(DominioConstants.ATTR_NAME_DOMINIONUEVAAFILIACION, Constants.Type.BOOL.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vNuevaAfiliacion, Constants.Type.BOOL.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Inclusion = vInclusion
        if (vInclusion != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(DominioConstants.ATTR_NAME_DOMINIOINCLUSION, Constants.Type.BOOL.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vInclusion, Constants.Type.BOOL.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // EXIST (Roles) WHERE (Roles = voRol) = true
        if (voRol != null) {
    // 'exist' Association operator
    SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(voRol, sql));
    conjunction.addOperand(operandSubQueryAssocOperator000);

        }        

        sql.addConjunction(conjunction);
    }

    private void iFDominioProdPlan(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Productos voProducto = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPRODUCTO) ? productosSrv.getByOID(new ProductosOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPRODUCTO)))) : null;
        Planes voPlan = filterRequest.hasFilterVariable(DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPLAN) ? planesSrv.getByOID(new PlanesOid().fromJsonString(toJson(filterRequest.getFilterVariable(DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPLAN)))) : null;

        // ProductoT = voProducto
        if (voProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(DominioConstants.ROLE_NAME_PRODUCTOT, ProductosConstants.CLASS_NAME);
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPRODUCTO, ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, voProducto.getOid(), DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPRODUCTO);
            comparison1.setSecondOperand(operand223);
            conjunction.addOperand(comparison1);

        }        

        // PlanT = voPlan
        if (voPlan != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(DominioConstants.ROLE_NAME_PLANT, PlanesConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPLAN, PlanesConstants.CLASS_NAME, PlanesConstants.CLASS_NAME, voPlan.getOid(), DominioConstants.VAR_NAME_IFDOMINIOPRODPLAN_VOPLAN);
            comparison2.setSecondOperand(operand224);
            conjunction.addOperand(comparison2);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioIIU for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioIIU
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioIIU iIUDominio(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioIIU(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioFirmaRespClausulado for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioFirmaRespClausulado
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioFirmaRespClausulado iIUDominioFirma(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioFirmaRespClausulado(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioSolNovedad for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioSolNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioSolNovedad iIUDominioDSolNovedad(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioSolNovedad(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioMGrupoAsesores for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioMGrupoAsesores
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMGrupoAsesores iIUDominioMGrupoAsesores(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMGrupoAsesores(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioMGrupoAreaMedica for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioMGrupoAreaMedica
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMGrupoAreaMedica iIUDominioMGrupoAreaMedica(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMGrupoAreaMedica(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioMGruposUsuarios for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioMGruposUsuarios
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMGruposUsuarios iIUDominioMGruposUsuarios(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMGruposUsuarios(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioMLog for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioMLog
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMLog iIUDominioMIncompatibles(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMLog(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class Dominio with displayset DSDominioMLog for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class Dominio with displayset DSDominioMLog
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMLog iIUDominioMLogDatos(DominioOid oid) {
        return new com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioMLog(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUDominio
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Dominio using displayset DSDominioPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioPIU> piuPIUDominio(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDominio
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDominio
     */
    public int getCount4PIUDominio(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUDominiosPorAsesor
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Dominio using displayset DSDominiosPorAsesor that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominiosPorAsesor> piuPIUDominiosPorAsesor(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominiosPorAsesor::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDominiosPorAsesor
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDominiosPorAsesor
     */
    public int getCount4PIUDominiosPorAsesor(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUDominioDIncompatibles
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Dominio using displayset DSDominioDIncompatibles that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioDIncompatibles> piuPIUDominioDIncompatibles(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioDIncompatibles::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDominioDIncompatibles
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDominioDIncompatibles
     */
    public int getCount4PIUDominioDIncompatibles(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUDominioObs
     *
     * @param queryRequest Query request
     * @return List of viewmodels for Dominio using displayset DSDominioPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioPIU> piuPIUDominioObs(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUDominioObs
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUDominioObs
     */
    public int getCount4PIUDominioObs(QueryRequest queryRequest) {
        return solveDominioTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsRolDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dominioSrv.insRolDominioTxn(request);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsRolDominioRequest request) throws ModelException {
        request.setDominioInsRolDominiopthisDominioInstance(dominioSrv.getByOIDWithHV(request.getDominioInsRolDominiopthisDominio()));
        request.setDominioInsRolDominiopevcRolInstance(rolSrv.getByOIDWithHV(request.getDominioInsRolDominiopevcRol()));
        return dominioSrv.insRolDominioImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsRolDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Dominio dominioInsRolDominiopthisDominio = request.getDominioInsRolDominiopthisDominioInstance();
        Rol dominioInsRolDominiopevcRol = request.getDominioInsRolDominiopevcRolInstance();

        request.checkArguments();
        Dominio instance = dominioInsRolDominiopthisDominio;

        instance.add2Roles(dominioInsRolDominiopevcRol);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.rol.siu.InsRolDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.rol.siu.InsRolDominioRequest();
            relatedRequest.setRolInsRolDominiopthisRolInstance(dominioInsRolDominiopevcRol);
            relatedRequest.setRolInsRolDominiopevcDominioInstance(dominioInsRolDominiopthisDominio);
            rolSrv.insRolDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDominio());

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
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelRollDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dominioSrv.delRollDominioTxn(request);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelRollDominioRequest request) throws ModelException {
        request.setDominioDelRollDominiopthisDominioInstance(dominioSrv.getByOIDWithHV(request.getDominioDelRollDominiopthisDominio()));
        request.setDominioDelRollDominiopevcRolInstance(rolSrv.getByOIDWithHV(new RolOid().fromJsonString(request.getDominioDelRollDominiopevcRol())));
        return dominioSrv.delRollDominioImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelRollDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Dominio dominioDelRollDominiopthisDominio = request.getDominioDelRollDominiopthisDominioInstance();
        Rol dominioDelRollDominiopevcRol = request.getDominioDelRollDominiopevcRolInstance();

        request.checkArguments();
        Dominio instance = dominioDelRollDominiopthisDominio;

        instance.removeFromRoles(dominioDelRollDominiopevcRol);
        dominioDelRollDominiopevcRol.removeFromDominios(instance);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.rol.siu.DelRollDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.rol.siu.DelRollDominioRequest();
            relatedRequest.setRolDelRollDominiopthisRolInstance(dominioDelRollDominiopevcRol);
            relatedRequest.setRolDelRollDominiopevcDominioInstance(dominioDelRollDominiopthisDominio);
            rolSrv.delRollDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDominio());

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
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dominioSrv.insDominioTxn(request);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsDominioRequest request) throws ModelException {
        request.setDominioInsDominiopthisDominioInstance(dominioSrv.getByOIDWithHV(request.getDominioInsDominiopthisDominio()));
        request.setDominioInsDominiopevcAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getDominioInsDominiopevcAgentexProducto()));
        return dominioSrv.insDominioImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.InsDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Dominio dominioInsDominiopthisDominio = request.getDominioInsDominiopthisDominioInstance();
        AgentexProducto dominioInsDominiopevcAgentexProducto = request.getDominioInsDominiopevcAgentexProductoInstance();

        request.checkArguments();
        Dominio instance = dominioInsDominiopthisDominio;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.InsDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.InsDominioRequest();
            relatedRequest.setAgentexProductoInsDominiopthisAgentexProductoInstance(dominioInsDominiopevcAgentexProducto);
            relatedRequest.setAgentexProductoInsDominiopevcDominioInstance(dominioInsDominiopthisDominio);
            agentexProductoSrv.insDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDominio());

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
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelDominioRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = dominioSrv.delDominioTxn(request);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelDominioRequest request) throws ModelException {
        request.setDominioDelDominiopthisDominioInstance(dominioSrv.getByOIDWithHV(request.getDominioDelDominiopthisDominio()));
        request.setDominioDelDominiopevcAgentexProductoInstance(agentexProductoSrv.getByOIDWithHV(request.getDominioDelDominiopevcAgentexProducto()));
        return dominioSrv.delDominioImplementation(request, true);
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
            com.keralty.aeusuarios.viewmodel.dominio.siu.DelDominioRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        Dominio dominioDelDominiopthisDominio = request.getDominioDelDominiopthisDominioInstance();
        AgentexProducto dominioDelDominiopevcAgentexProducto = request.getDominioDelDominiopevcAgentexProductoInstance();

        request.checkArguments();
        Dominio instance = dominioDelDominiopthisDominio;

        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.agentexproducto.siu.DelDominioRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.agentexproducto.siu.DelDominioRequest();
            relatedRequest.setAgentexProductoDelDominiopthisAgentexProductoInstance(dominioDelDominiopevcAgentexProducto);
            relatedRequest.setAgentexProductoDelDominiopevcDominioInstance(dominioDelDominiopthisDominio);
            agentexProductoSrv.delDominioImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICDominio());

        return response;
    }


    private void suppInfo4ICDominio(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DominioConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ATTR_NAME_PRODUCTOSDESCRIPCION, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison1);

            SQLWhereComparison comparison2 = new SQLWhereComparison(select);
            comparison2.setOperator("LIKE");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(DominioConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ATTR_NAME_PLANESNOMBRE, Constants.Type.STRING.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(searchText, Constants.Type.STRING.getTypeName()));
            disjunction.addComparison(comparison2);

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
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(DominioConstants.CLASS_NAME, DominioConstants.ATTR_FIELD_DOMINIONUMERO, false), true);
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildDominioRelatedInstance(relatedInstanceJsonOid);
        }
        if (DominioConstants.ROLE_NAME_DOMINIOSCONINCOMPATIBILIDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || DominioConstants.ROLE_NAME_DOMINIOSINCOMPATIBLES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4Dominio(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_AGENTEXPRODUCTO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4AgentexProducto(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_REPORTESDOMINIO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4ReportesDominio(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_PLANT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_PRODUCTOT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4Productos(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_PERIODICIDADES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4Periodicidad(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_ROLES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4Rol(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_PLANTILLAS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4PlantillaEmail(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_NOVEDADES.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4Novedad(relatedInstanceJsonOid, remainingPath);
        }
        if (DominioConstants.ROLE_NAME_GRUPOASESORES.equalsIgnoreCase(relatedInstancePathFirstItem) || DominioConstants.ROLE_NAME_GRUPOAREAMEDICA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildDominioRelatedInstance4GrupoAsignacion(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildDominioRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4Dominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Dominio(mapper.readValue(relatedInstanceJsonOid, DominioOid.class)): Dominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4AgentexProducto(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new AgentexProducto(mapper.readValue(relatedInstanceJsonOid, AgentexProductoOid.class)): AgentexProducto.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4ReportesDominio(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new ReportesDominio(mapper.readValue(relatedInstanceJsonOid, ReportesDominioOid.class)): ReportesDominio.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4Productos(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Productos(mapper.readValue(relatedInstanceJsonOid, ProductosOid.class)): Productos.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4Periodicidad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Periodicidad(mapper.readValue(relatedInstanceJsonOid, PeriodicidadOid.class)): Periodicidad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4Rol(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Rol(mapper.readValue(relatedInstanceJsonOid, RolOid.class)): Rol.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4PlantillaEmail(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new PlantillaEmail(mapper.readValue(relatedInstanceJsonOid, PlantillaEmailOid.class)): PlantillaEmail.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4Novedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Novedad(mapper.readValue(relatedInstanceJsonOid, NovedadOid.class)): Novedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildDominioRelatedInstance4GrupoAsignacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsignacion(mapper.readValue(relatedInstanceJsonOid, GrupoAsignacionOid.class)): GrupoAsignacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            DominioOid oid = new DominioOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DominioConstants.ATTR_FIELD_DOMINIONUMERO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDominioNumero(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(DominioService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
