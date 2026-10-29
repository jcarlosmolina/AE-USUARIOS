package com.keralty.aeusuarios.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.NovedadConstants;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.global.TipoNovedadConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.Causal;
import com.keralty.aeusuarios.persistence.EstadoContrato;
import com.keralty.aeusuarios.persistence.FamiliaNovedad;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsociado;
import com.keralty.aeusuarios.persistence.Novedad;
import com.keralty.aeusuarios.persistence.oid.CausalOid;
import com.keralty.aeusuarios.persistence.oid.EstadoContratoOid;
import com.keralty.aeusuarios.persistence.oid.FamiliaNovedadOid;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsociadoOid;
import com.keralty.aeusuarios.persistence.oid.NovedadOid;
import com.keralty.aeusuarios.persistence.oid.PeriodicidadOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Periodicidad;
import com.keralty.aeusuarios.persistence.Planes;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.repository.SolicitudNovedadJpaRepository;
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
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class SolicitudNovedadService extends AbstractService {

    SolicitudNovedadJpaRepository repository;

    SolicitudNovedadService solicitudNovedadSrv;

    FamiliaNovedadService familiaNovedadSrv;

    PlanesService planesSrv;

    NovedadService novedadSrv;

    CausalService causalSrv;

    TipoIdentificacionService tipoIdentificacionSrv;

    EstadoContratoService estadoContratoSrv;

    GrupoAsociadoService grupoAsociadoSrv;

    PeriodicidadService periodicidadSrv;

    FirmaService firmaSrv;

    UserFunctions userFunctionsSrv;

    @Inject
    public SolicitudNovedadService(
            SolicitudNovedadService solicitudNovedadSrv,
            FamiliaNovedadService familiaNovedadSrv,
            PlanesService planesSrv,
            NovedadService novedadSrv,
            CausalService causalSrv,
            TipoIdentificacionService tipoIdentificacionSrv,
            EstadoContratoService estadoContratoSrv,
            GrupoAsociadoService grupoAsociadoSrv,
            PeriodicidadService periodicidadSrv,
            FirmaService firmaSrv,
            UserFunctions userFunctionsSrv,
            SolicitudNovedadJpaRepository repository) {
        this.solicitudNovedadSrv = solicitudNovedadSrv;
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.planesSrv = planesSrv;
        this.novedadSrv = novedadSrv;
        this.causalSrv = causalSrv;
        this.tipoIdentificacionSrv = tipoIdentificacionSrv;
        this.estadoContratoSrv = estadoContratoSrv;
        this.grupoAsociadoSrv = grupoAsociadoSrv;
        this.periodicidadSrv = periodicidadSrv;
        this.firmaSrv = firmaSrv;
        this.userFunctionsSrv = userFunctionsSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, SolicitudNovedadConstants.CLASS_NAME);
    }

    private List<SolicitudNovedad> solveSolicitudNovedadTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, SolicitudNovedadConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveSolicitudNovedadTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, SolicitudNovedadConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class SolicitudNovedad
     *
     * @return Population of class SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> get() {
        List<SolicitudNovedad> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class SolicitudNovedad
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<SolicitudNovedad> instances = get(queryRequest);
        if(SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADCON.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolicitudNovedadCon())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVTIPOCONTRATO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovTipoContrato())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVCONTRATANTE.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovContratante())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVOBSERVACIONES.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovObservaciones())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVTIPOTITULAR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovTipoTitular())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVESTATUS.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovEstatus())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVTIPOUSUARIO.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovTipoUsuario())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVCONTRATIPOTITULAR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovContraTipoTitular())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSICSOLICITUDNOVEDAD.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICSolicitudNovedad())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVESTATUSAFILIACION.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovEstatusAfiliacion())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLNOVESTATUSASESOR.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolNovEstatusAsesor())).collect(Collectors.toList());
        }
        if(SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADNULL.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSSolicitudNovedadNull())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class SolicitudNovedad that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class SolicitudNovedad matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> get(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveSolicitudNovedadTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveSolicitudNovedadTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveSolicitudNovedadTypedQuery(queryRequest).stream()
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
        return new PopulationResponseViewModel(solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(instance -> buildDynamicObject(instance, displaySetItems))
                .collect(Collectors.toList()));
    }

    /*
     * Returns an instance of SolicitudNovedad by ID
     *
     * @param solicitudNovedadId Identification field solicitudNovedadId
     *
     * @return Instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SolicitudNovedad getById(Long solicitudNovedadId) {
        return getByOID(new SolicitudNovedadOid(solicitudNovedadId));
    }
    
    /*
     * Returns an instance of SolicitudNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public SolicitudNovedad getByOID(SolicitudNovedadOid oid) {
        Optional<SolicitudNovedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of SolicitudNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public SolicitudNovedad getByOIDWithHV(SolicitudNovedadOid oid) {
        Optional<SolicitudNovedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<SolicitudNovedad> getInstanceByOid(SolicitudNovedadOid oid) {
        return oid != null && oid.getSolicitudNovedadId() != null
               ? repository.findById(oid.getSolicitudNovedadId())
               : Optional.empty();
    }

    /*
     * Returns an instance of SolicitudNovedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of SolicitudNovedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public SolicitudNovedad getByJsonOid(String jsonOid) {
        SolicitudNovedadOid oid = new SolicitudNovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns the list of instances of SolicitudNovedad related to a given instance through 
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> getByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        QueryRequest queryRequest = new QueryRequest(new FilterRequest(Constants.FILTER_BY_RELATED,
                Arrays.asList(new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_PATH, relatedInstancePath),
                        new FilterVariableRequest(Constants.FILTER_BY_RELATED_FVAR_OID, relatedInstance.getOid().toJson()))));
        return solveSolicitudNovedadTypedQuery(queryRequest);
    }

    /*
     * Returns the list of instances of SolicitudNovedad related to a given instance through
     * a given path
     *
     * @param relatedInstance Related instance
     *
     * @param relatedInstancePath Related instance path
     *
     * @return List of instances of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<SolicitudNovedad> getInstancesByRelated(AbstractAppEntity relatedInstance, String relatedInstancePath) {
        return getByRelated(relatedInstance, relatedInstancePath);
    }

    /*
     * Returns a set of displayset items for an instance of SolicitudNovedad
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of SolicitudNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getSolicitudNovedadDynamic(SolicitudNovedadOid oid, String displaySetItems) {
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
    public String getSuppInfo(SolicitudNovedadOid oid, String dsName) {
        SolicitudNovedad instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(SolicitudNovedad instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (SolicitudNovedadConstants.DSICSOLICITUDNOVEDAD.equals(dsName))
            return instance.buildICSolicitudNovedad();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(SolicitudNovedad instance, String dsName) {
        if (SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADCON.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolicitudNovedadCon());
        if (SolicitudNovedadConstants.DSDSSOLNOVTIPOCONTRATO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovTipoContrato());
        if (SolicitudNovedadConstants.DSDSSOLNOVCONTRATANTE.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovContratante());
        if (SolicitudNovedadConstants.DSDSSOLNOVOBSERVACIONES.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovObservaciones());
        if (SolicitudNovedadConstants.DSDSSOLNOVTIPOTITULAR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovTipoTitular());
        if (SolicitudNovedadConstants.DSDSSOLNOVESTATUS.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovEstatus());
        if (SolicitudNovedadConstants.DSDSSOLNOVTIPOUSUARIO.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovTipoUsuario());
        if (SolicitudNovedadConstants.DSDSSOLNOVCONTRATIPOTITULAR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovContraTipoTitular());
        if (SolicitudNovedadConstants.DSICSOLICITUDNOVEDAD.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICSolicitudNovedad());
        if (SolicitudNovedadConstants.DSDSSOLNOVESTATUSAFILIACION.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovEstatusAfiliacion());
        if (SolicitudNovedadConstants.DSDSSOLNOVESTATUSASESOR.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolNovEstatusAsesor());
        if (SolicitudNovedadConstants.DSDSSOLICITUDNOVEDADNULL.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSSolicitudNovedadNull());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADNUMFECHAS.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadNumFechas(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADNUMFECHESTA.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadNumFechEsta(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_IFILTROPORNUMRADICADO.equalsIgnoreCase(filterRequest.getName()))
            iFiltroPorNumRadicado(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADESTATUAFIL1.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadEstatuAfil1(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADESTATUAFIL2.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadEstatuAfil2(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADESTATUAFIL3.equalsIgnoreCase(filterRequest.getName()))
            fSolicitudNovedadEstatuAfil3(filterRequest, sql);
        if (SolicitudNovedadConstants.FILTER_NAME_IFSOLNOVVALIDADORUSUARIOS.equalsIgnoreCase(filterRequest.getName()))
            iFSolNovValidadorUsuarios(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_SolicitudNovedad".equals(filterRequest.getName()))
            suppInfo4ICSolicitudNovedad(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fSolicitudNovedadNumFechas(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFHASTA, FilterVariableRequest.DATE) : null;

        // Completada = false
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison1);


        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadNumFechEsta(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;
        Long vfEstadoDoc = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADODOC) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADODOC, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // EstadoDocumentacion = vfEstadoDoc
        if (vfEstadoDoc != null) {
            // '=' Comparison
            SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
            comparison6.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
            comparison6.setFirstOperand(operand117);
            
            // Operand 2
            comparison6.setSecondOperand(new SQLWhereOperandLiteral(vfEstadoDoc, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison6);

        }        

        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison7 = new SQLWhereComparison(sql);
        comparison7.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand118 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison7.setFirstOperand(operand118);
        
        // Operand 2
        comparison7.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison7);


        sql.addConjunction(conjunction);
    }

    private void iFiltroPorNumRadicado(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFILTROPORNUMRADICADO_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFILTROPORNUMRADICADO_VFNUMRADICADO, FilterVariableRequest.INT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadEstatuAfil1(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;
        Long vfEstadoDoc = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADODOC) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL1_VFESTADODOC, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // EstadoDocumentacion = vfEstadoDoc
        if (vfEstadoDoc != null) {
            // '=' Comparison
            SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
            comparison6.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
            comparison6.setFirstOperand(operand117);
            
            // Operand 2
            comparison6.setSecondOperand(new SQLWhereOperandLiteral(vfEstadoDoc, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison6);

        }        

        // ((EstadoDocumentacion = 1 AND Estado <> 4 AND FechaTerminada = NULL) OR (EstadoDocumentacion = 2 AND Estado = 1))
    {
        // 'or' Logical operator
        SQLWhereDisjunction comparison7 = new SQLWhereDisjunction();
    
        // Operand 1
        {
            // 'and' Logical operator
            SQLWhereConjunction comparison8 = new SQLWhereConjunction();
        
            // Operand 1
            {
                // 'and' Logical operator
                SQLWhereConjunction comparison9 = new SQLWhereConjunction();
            
                // Operand 1
                    // '=' Comparison
                    SQLWhereComparison comparison10 = new SQLWhereComparison(sql);
                    comparison10.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand1111 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
                    comparison10.setFirstOperand(operand1111);
                    
                    // Operand 2
                    comparison10.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                    comparison9.addOperand(comparison10);
            
                // Operand 2
                    // '<>' Comparison
                    SQLWhereComparison comparison12 = new SQLWhereComparison(sql);
                    comparison12.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand1113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
                    comparison12.setFirstOperand(operand1113);
                    
                    // Operand 2
                    comparison12.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(4), Constants.Type.NAT.getTypeName()));
                    comparison9.addOperand(comparison12);
                
                comparison8.addOperand(comparison9);
            }
        
            // Operand 2
                // '=' Comparison
                SQLWhereComparison comparison13 = new SQLWhereComparison(sql);
                comparison13.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand1114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHATERMINADA, Constants.Type.DATE.getTypeName());
                comparison13.setFirstOperand(operand1114);
                
                // Operand 2
                comparison13.setSecondOperand(new SQLWhereOperandNull());
                comparison8.addOperand(comparison13);
            
            comparison7.addOperand(comparison8);
        }
    
        // Operand 2
        {
            // 'and' Logical operator
            SQLWhereConjunction comparison130 = new SQLWhereConjunction();
        
            // Operand 1
                // '=' Comparison
                SQLWhereComparison comparison14 = new SQLWhereComparison(sql);
                comparison14.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand1115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
                comparison14.setFirstOperand(operand1115);
                
                // Operand 2
                comparison14.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
                comparison130.addOperand(comparison14);
        
            // Operand 2
                // '=' Comparison
                SQLWhereComparison comparison16 = new SQLWhereComparison(sql);
                comparison16.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand1117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
                comparison16.setFirstOperand(operand1117);
                
                // Operand 2
                comparison16.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
                comparison130.addOperand(comparison16);
            
            comparison7.addOperand(comparison130);
        }
        
        conjunction.addOperand(comparison7);
    }


        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
        comparison8.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison8.setFirstOperand(operand119);
        
        // Operand 2
        comparison8.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison8);


        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadEstatuAfil2(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // FechaTerminada = NULL
        // '=' Comparison
        SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
        comparison6.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHATERMINADA, Constants.Type.DATE.getTypeName());
        comparison6.setFirstOperand(operand117);
        
        // Operand 2
        comparison6.setSecondOperand(new SQLWhereOperandNull());
        conjunction.addOperand(comparison6);


        // EstadoDocumentacion = 3
        // '=' Comparison
        SQLWhereComparison comparison7 = new SQLWhereComparison(sql);
        comparison7.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand118 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
        comparison7.setFirstOperand(operand118);
        
        // Operand 2
        comparison7.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(3), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison7);


        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
        comparison8.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison8.setFirstOperand(operand119);
        
        // Operand 2
        comparison8.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison8);


        sql.addConjunction(conjunction);
    }

    private void fSolicitudNovedadEstatuAfil3(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vfNumRadicado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFNUMRADICADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFNUMRADICADO, FilterVariableRequest.NAT) : null;
        Date vfDesde = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFDESDE) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFDESDE, FilterVariableRequest.DATE) : null;
        Date vfHasta = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFHASTA) ? (Date) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFHASTA, FilterVariableRequest.DATE) : null;
        Long vfEstado = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFESTADO) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFESTADO, FilterVariableRequest.INT) : null;
        Long vfTipoNovedad = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFTIPONOVEDAD) ? (Long) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL3_VFTIPONOVEDAD, FilterVariableRequest.NAT) : null;

        // NumRadicado = vfNumRadicado
        if (vfNumRadicado != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMRADICADO, Constants.Type.INT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vfNumRadicado, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaCreacion >= vfDesde
        if (vfDesde != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vfDesde, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaCreacion <= vfHasta
        if (vfHasta != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfHasta, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // Estado = vfEstado
        if (vfEstado != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfEstado, Constants.Type.INT.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // Novedad.TipoNovedad.Tipo = vfTipoNovedad
        if (vfTipoNovedad != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ROLE_NAME_TIPONOVEDAD + "." + TipoNovedadConstants.ATTR_NAME_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfTipoNovedad, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // FechaTerminada <> NULL
        // '<>' Comparison
        SQLWhereComparison comparison6 = new SQLWhereComparison(sql);
        comparison6.setOperator("<>");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand117 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHATERMINADA, Constants.Type.DATE.getTypeName());
        comparison6.setFirstOperand(operand117);
        
        // Operand 2
        comparison6.setSecondOperand(new SQLWhereOperandNull());
        conjunction.addOperand(comparison6);


        // EstadoDocumentacion = 2
        // '=' Comparison
        SQLWhereComparison comparison7 = new SQLWhereComparison(sql);
        comparison7.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand118 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
        comparison7.setFirstOperand(operand118);
        
        // Operand 2
        comparison7.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(2), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison7);


        // Completada = true
        // '=' Comparison
        SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
        comparison8.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADCOMPLETADA, Constants.Type.BOOL.getTypeName());
        comparison8.setFirstOperand(operand119);
        
        // Operand 2
        comparison8.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
        conjunction.addOperand(comparison8);


        sql.addConjunction(conjunction);
    }

    private void iFSolNovValidadorUsuarios(FilterRequest filterRequest, SQLSelect sql) throws SystemException{
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        String vfNumContrato = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMCONTRATO) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMCONTRATO, FilterVariableRequest.STRING) : null;
        String vfPlan = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPLAN) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPLAN, FilterVariableRequest.STRING) : null;
        String vfProducto = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPRODUCTO) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPRODUCTO, FilterVariableRequest.STRING) : null;
        String vfTipoIdent = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFTIPOIDENT) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFTIPOIDENT, FilterVariableRequest.STRING) : null;
        String vfNumIdent = filterRequest.hasFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMIDENT) ? (String) filterRequest.getFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMIDENT, FilterVariableRequest.STRING) : null;

        // Estado = 1
        // '=' Comparison
        SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
        comparison1.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADO, Constants.Type.INT.getTypeName());
        comparison1.setFirstOperand(operand112);
        
        // Operand 2
        comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison1);


        // EstadoDocumentacion = 1
        // '=' Comparison
        SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
        comparison2.setOperator("=");
        
        // Operand 1
        SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADESTADODOCUMENTACION, Constants.Type.NAT.getTypeName());
        comparison2.setFirstOperand(operand113);
        
        // Operand 2
        comparison2.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(1), Constants.Type.NAT.getTypeName()));
        conjunction.addOperand(comparison2);


        // NumContrato = vfNumContrato
        if (vfNumContrato != null) {
            // '=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADNUMCONTRATO, Constants.Type.STRING.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vfNumContrato, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        // PlanT.CodigoLegal = vfPlan
        if (vfPlan != null) {
            // '=' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand115 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ATTR_NAME_PLANESCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison4.setFirstOperand(operand115);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(vfPlan, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison4);

        }        

        // PlanT.ProductoT.CodigoLegal = vfProducto
        if (vfProducto != null) {
            // '=' Comparison
            SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
            comparison5.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_PLANT + "." + PlanesConstants.ROLE_NAME_PRODUCTOT + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
            comparison5.setFirstOperand(operand116);
            
            // Operand 2
            comparison5.setSecondOperand(new SQLWhereOperandLiteral(vfProducto, Constants.Type.STRING.getTypeName()));
            conjunction.addOperand(comparison5);

        }        

        // (Novedad.AliasNovedad = "CC" OR (Novedad.AliasNovedad = "CF" AND COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent) > 0) OR (Novedad.AliasNovedad = "EU" AND COUNT (Familias.UsuarioNovedad) WHERE (Familias.UsuarioNovedad.TipoIdentificacion.NombreCorto = vfTipoIdent AND Familias.UsuarioNovedad.NumIdentificacion = vfNumIdent AND Familias.UsuarioNovedad.Excluido = true) > 0))
        if (vfTipoIdent != null && vfNumIdent != null) {
        {
            // 'or' Logical operator
            SQLWhereDisjunction comparison6 = new SQLWhereDisjunction();
        
            // Operand 1
                {
                    // 'or' Logical operator
                    SQLWhereDisjunction comparison7 = new SQLWhereDisjunction();
                
                    // Operand 1
                            // '=' Comparison
                            SQLWhereComparison comparison8 = new SQLWhereComparison(sql);
                            comparison8.setOperator("=");
                            
                            // Operand 1
                            SQLWhereOperandPathAttribute operand119 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                            comparison8.setFirstOperand(operand119);
                            
                            // Operand 2
                            comparison8.setSecondOperand(new SQLWhereOperandLiteral("CC", Constants.Type.STRING.getTypeName()));
                            comparison7.addOperand(comparison8);
                
                    // Operand 2
                        {
                            // 'and' Logical operator
                            SQLWhereConjunction comparison10 = new SQLWhereConjunction();
                        
                            // Operand 1
                                    // '=' Comparison
                                    SQLWhereComparison comparison11 = new SQLWhereComparison(sql);
                                    comparison11.setOperator("=");
                                    
                                    // Operand 1
                                    SQLWhereOperandPathAttribute operand1112 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                                    comparison11.setFirstOperand(operand1112);
                                    
                                    // Operand 2
                                    comparison11.setSecondOperand(new SQLWhereOperandLiteral("CF", Constants.Type.STRING.getTypeName()));
                                    comparison10.addOperand(comparison11);
                        
                            // Operand 2
                                    // '>' Comparison
                                    SQLWhereComparison comparison13 = new SQLWhereComparison(sql);
                                    comparison13.setOperator(">");
                                    
                                    // Operand 1
                                        // 'count' Association operator
                                        SQLWhereOperandSubQuery operandSubQueryAssocOperator016 = new SQLWhereOperandSubQuery(repository.assocOperator016Range1Query(vfTipoIdent, vfNumIdent, sql));
                                    comparison13.setFirstOperand(operandSubQueryAssocOperator016);
                                    
                                    // Operand 2
                                    comparison13.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                                    comparison10.addOperand(comparison13);
                            
                            comparison7.addOperand(comparison10);
                        }
                    
                    comparison6.addOperand(comparison7);
                }
        
            // Operand 2
                {
                    // 'and' Logical operator
                    SQLWhereConjunction comparison110 = new SQLWhereConjunction();
                
                    // Operand 1
                            // '=' Comparison
                            SQLWhereComparison comparison12 = new SQLWhereComparison(sql);
                            comparison12.setOperator("=");
                            
                            // Operand 1
                            SQLWhereOperandPathAttribute operand1113 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_NOVEDAD + "." + NovedadConstants.ATTR_NAME_NOVEDADALIASNOVEDAD, Constants.Type.STRING.getTypeName());
                            comparison12.setFirstOperand(operand1113);
                            
                            // Operand 2
                            comparison12.setSecondOperand(new SQLWhereOperandLiteral("EU", Constants.Type.STRING.getTypeName()));
                            comparison110.addOperand(comparison12);
                
                    // Operand 2
                            // '>' Comparison
                            SQLWhereComparison comparison14 = new SQLWhereComparison(sql);
                            comparison14.setOperator(">");
                            
                            // Operand 1
                                // 'count' Association operator
                                SQLWhereOperandSubQuery operandSubQueryAssocOperator017 = new SQLWhereOperandSubQuery(repository.assocOperator017Range1Query(vfTipoIdent, vfNumIdent, sql));
                            comparison14.setFirstOperand(operandSubQueryAssocOperator017);
                            
                            // Operand 2
                            comparison14.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                            comparison110.addOperand(comparison14);
                    
                    comparison6.addOperand(comparison110);
                }
            
            conjunction.addOperand(comparison6);
        }

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoContrato for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato iIUSolNovTipoContrato(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContratante for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContratante
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContratante iIUSolNovContratante(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContratante(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovObservaciones for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovObservaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones iIUSolNovObservaciones(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoTitular for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoTitular
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular iIUSolNovTipoTitular(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoUsuario for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoUsuario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario iIUSolNovTipoUsuario(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContratante for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContratante
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContratante iIUSolNovContratanteSL(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContratante(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContraTipoTitular for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContraTipoTitular
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContraTipoTitular iIUSolNovContraTipoTitular(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContraTipoTitular(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoContrato for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoContrato
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato iIUSolNovTipoContratoOBS(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoContrato(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovContratante for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovContratante
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContratante iIUSolNovContratanteOBS(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovContratante(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovObservaciones for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovObservaciones
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones iIUSolNovObservacionesOBS(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovObservaciones(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoTitular for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoTitular
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular iIUSolNovTipoTitularObs(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoTitular(getByOIDWithHV(oid));
    }

    /*
     * Returns a viewmodel for class SolicitudNovedad with displayset DSSolNovTipoUsuario for the instance with a given OID
     * @param oid Class oid
     * @return Viewmodel for class class SolicitudNovedad with displayset DSSolNovTipoUsuario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario iIUSolNovTipoUsuarioObs(SolicitudNovedadOid oid) {
        return new com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovTipoUsuario(getByOIDWithHV(oid));
    }


    /*
     * Solves the query needed for PIUConsultaSolicitudNovedad
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolicitudNovedadCon that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadCon> piuPIUConsultaSolicitudNovedad(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadCon::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUConsultaSolicitudNovedad
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUConsultaSolicitudNovedad
     */
    public int getCount4PIUConsultaSolicitudNovedad(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUEstatusSolNov
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolNovEstatus that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatus> piuPIUEstatusSolNov(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatus::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEstatusSolNov
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEstatusSolNov
     */
    public int getCount4PIUEstatusSolNov(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUEstatusSolNovAfiliacion
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolNovEstatusAfiliacion that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAfiliacion> piuPIUEstatusSolNovAfiliacion(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAfiliacion::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEstatusSolNovAfiliacion
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEstatusSolNovAfiliacion
     */
    public int getCount4PIUEstatusSolNovAfiliacion(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUEstatusSolNovAsesor
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolNovEstatusAsesor that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAsesor> piuPIUEstatusSolNovAsesor(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAsesor::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUEstatusSolNovAsesor
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUEstatusSolNovAsesor
     */
    public int getCount4PIUEstatusSolNovAsesor(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    /*
     * Solves the query needed for PIUSolicitudNovedadNull
     *
     * @param queryRequest Query request
     * @return List of viewmodels for SolicitudNovedad using displayset DSSolicitudNovedadNull that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadNull> piuPIUSolicitudNovedadNull(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadNull::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUSolicitudNovedadNull
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUSolicitudNovedadNull
     */
    public int getCount4PIUSolicitudNovedadNull(QueryRequest queryRequest) {
        return solveSolicitudNovedadTypedQuery(queryRequest).size();
    }

    // Service: InsSolNovUsrAfiliacion

    /*
     * Entry point for service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse insSolNovUsrAfiliacion(
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.insSolNovUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse insSolNovUsrAfiliacionTxn(
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest request) throws ModelException {
        request.setSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad()));
        request.setSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario()));
        return solicitudNovedadSrv.insSolNovUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service InsSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse insSolNovUsrAfiliacionImplementation(
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.InsSolNovUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad = request.getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance();
        Funcionario solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario = request.getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad;

        instance.add2UsrAfiliacion(solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.InsSolNovUsrAfiliacionRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.funcionario.siu.InsSolNovUsrAfiliacionRequest();
            relatedRequest.setFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance(solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario);
            relatedRequest.setFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance(solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad);
            funcionarioSrv.insSolNovUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }

    // Service: DelSolNovUsrAfiliacion

    /*
     * Entry point for service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse delSolNovUsrAfiliacion(
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = solicitudNovedadSrv.delSolNovUsrAfiliacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse delSolNovUsrAfiliacionTxn(
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest request) throws ModelException {
        request.setSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance(solicitudNovedadSrv.getByOIDWithHV(request.getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad()));
        request.setSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance(funcionarioSrv.getByOIDWithHV(request.getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario()));
        return solicitudNovedadSrv.delSolNovUsrAfiliacionImplementation(request, true);
    }

    /*
     * Implements service DelSolNovUsrAfiliacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse delSolNovUsrAfiliacionImplementation(
            com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu.DelSolNovUsrAfiliacionRequest request, boolean isEntryPoint) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        SolicitudNovedad solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad = request.getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance();
        Funcionario solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario = request.getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance();

        request.checkArguments();
        SolicitudNovedad instance = solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad;

        instance.add2UsrAfiliacion(null);
        if (isEntryPoint) {
            com.keralty.aeusuarios.viewmodel.funcionario.siu.DelSolNovUsrAfiliacionRequest relatedRequest = new com.keralty.aeusuarios.viewmodel.funcionario.siu.DelSolNovUsrAfiliacionRequest();
            relatedRequest.setFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance(solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario);
            relatedRequest.setFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance(solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad);
            funcionarioSrv.delSolNovUsrAfiliacionImplementation(relatedRequest, false);
        }


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICSolicitudNovedad());

        return response;
    }


    @Override
    protected void applyHVFilter(SQLSelect sql) throws SystemException {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        SQLWhereDisjunction disjunction = new SQLWhereDisjunction();
        if (getAgentRoles().contains(AsesorConstants.CLASS_NAME)) applyHVFilter4Asesor(sql, disjunction);
        if (getAgentRoles().contains(AfiliacionesConstants.CLASS_NAME)) applyHVFilter4Afiliaciones(sql, disjunction);
        conjunction.addDisjunction(disjunction);
        sql.addConjunction(conjunction);
    }

    private void applyHVFilter4Asesor(SQLSelect sql, SQLWhereDisjunction disjunction) throws SystemException{
        // (Agente = agent OR Agente.CodJefe = Agent.Usuario OR EXIST (UsrAfiliacion) WHERE (UsrAfiliacion = agent) = true)
        Asesor agentInstance = getAgentAsesor();
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
                SQLWhereOperandPathInstance operand114 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_AGENTE, FuncionarioConstants.CLASS_NAME);
                comparison3.setFirstOperand(operand114);
                
                // Operand 2
                SQLWhereOperandOVParameter operand225 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
                comparison3.setSecondOperand(operand225);
                comparison2.addOperand(comparison3);
        
            // Operand 2
                // '=' Comparison
                SQLWhereComparison comparison5 = new SQLWhereComparison(sql);
                comparison5.setOperator("=");
                
                // Operand 1
                SQLWhereOperandPathAttribute operand116 = new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ROLE_NAME_AGENTE + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
                comparison5.setFirstOperand(operand116);
                
                // Operand 2
                comparison5.setSecondOperand(new SQLWhereOperandLiteral(agentInstance.getFuncionarioUsuario(), Constants.Type.STRING.getTypeName()));
                comparison2.addOperand(comparison5);
            
            comparison1.addOperand(comparison2);
        }
    
        // Operand 2
        // 'exist' Association operator
        SQLWhereOperandSubQuery operandSubQueryAssocOperator000 = new SQLWhereOperandSubQuery(repository.assocOperator000Range1Query(sql));
        comparison1.addOperand(operandSubQueryAssocOperator000);
        
        disjunction.addOperand(comparison1);
    }

    }

    private void applyHVFilter4Afiliaciones(SQLSelect sql, SQLWhereDisjunction disjunction) throws SystemException{
        // UsrAfiliacion = agent AND COUNT (PlanT.Afiliaciones) WHERE (PlanT.Afiliaciones = agent) > 0
        Afiliaciones agentInstance = getAgentAfiliaciones();
    {
        // 'and' Logical operator
        SQLWhereConjunction comparison1 = new SQLWhereConjunction();
    
        // Operand 1
            // '=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathInstance operand113 = new SQLWhereOperandPathInstance(SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION, FuncionarioConstants.CLASS_NAME);
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            SQLWhereOperandOVParameter operand224 = new SQLWhereOperandOVParameter(Constants.AGENTKEYWORD, AfiliacionesConstants.CLASS_NAME, AfiliacionesConstants.CLASS_NAME, agentInstance.getOid(), Constants.AGENTKEYWORD);
            comparison2.setSecondOperand(operand224);
            comparison1.addOperand(comparison2);
    
        // Operand 2
            // '>' Comparison
            SQLWhereComparison comparison4 = new SQLWhereComparison(sql);
            comparison4.setOperator(">");
            
            // Operand 1
                // 'count' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator001 = new SQLWhereOperandSubQuery(repository.assocOperator001Range1Query(sql));
            comparison4.setFirstOperand(operandSubQueryAssocOperator001);
            
            // Operand 2
            comparison4.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
            comparison1.addOperand(comparison4);
        
        disjunction.addOperand(comparison1);
    }

    }


    private void suppInfo4ICSolicitudNovedad(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADDRVNUMRADICADOSTR, Constants.Type.STRING.getTypeName()));
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
        applyOCOCSolicitudPrioridadFechas(queryRequest, select);
        applyOCOCSolNovFechaFAPrioridad(queryRequest, select);
        applyOCOCSolNovFechaCreacion(queryRequest, select);
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_FIELD_SOLICITUDNOVEDADID, false), true);
    }


    private void applyOCOCSolicitudPrioridadFechas(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_Solicitud_PrioridadFechas".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADPRIORIDAD, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACOMPLETADA, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHAULTIMODOC, false), true);
        }
    }


    private void applyOCOCSolNovFechaFAPrioridad(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_SolNov_FechaFA_Prioridad".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHAFA, false), true);
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADPRIORIDAD, false), true);
        }
    }


    private void applyOCOCSolNovFechaCreacion(QueryRequest queryRequest, SQLSelect select) {
        if ("OC_SolNov_FechaCreacion".equalsIgnoreCase(queryRequest.getOrderCriteriaName())) {
            select.getOrderByPart().addItem(Constants.normalizePath(SolicitudNovedadConstants.CLASS_NAME, SolicitudNovedadConstants.ATTR_NAME_SOLICITUDNOVEDADFECHACREACION, false), false);
        }
    }
    
    @Override
    protected AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePathFirstItem, String remainingPath) {
        AbstractAppEntity relatedInstance = null;
        if (relatedInstancePathFirstItem.isEmpty()) {
            relatedInstance = buildSolicitudNovedadRelatedInstance(relatedInstanceJsonOid);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_FAMILIAS.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4FamiliaNovedad(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_PLANT.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Planes(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_NOVEDAD.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Novedad(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_CAUSAL.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Causal(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_TIPOIDENTCONTRATANTE.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4TipoIdentificacion(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_ESTADOCONTRATO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4EstadoContrato(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_GRUPOASOCIADO.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4GrupoAsociado(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_PERIODICIDAD.equalsIgnoreCase(relatedInstancePathFirstItem) || SolicitudNovedadConstants.ROLE_NAME_PERIODICIDADNUEVA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Periodicidad(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_AGENTE.equalsIgnoreCase(relatedInstancePathFirstItem) || SolicitudNovedadConstants.ROLE_NAME_USRAFILIACION.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Funcionario(relatedInstanceJsonOid, remainingPath);
        }
        if (SolicitudNovedadConstants.ROLE_NAME_FIRMA.equalsIgnoreCase(relatedInstancePathFirstItem)) {
            relatedInstance = buildSolicitudNovedadRelatedInstance4Firma(relatedInstanceJsonOid, remainingPath);
        }
        return relatedInstance;
    }
    
    private AbstractAppEntity buildSolicitudNovedadRelatedInstance(String relatedInstanceJsonOid) {
    	ObjectMapper mapper = new ObjectMapper();
    	try {
    		return new SolicitudNovedad(mapper.readValue(relatedInstanceJsonOid, SolicitudNovedadOid.class));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4FamiliaNovedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new FamiliaNovedad(mapper.readValue(relatedInstanceJsonOid, FamiliaNovedadOid.class)): FamiliaNovedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Planes(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Planes(mapper.readValue(relatedInstanceJsonOid, PlanesOid.class)): Planes.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Novedad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Novedad(mapper.readValue(relatedInstanceJsonOid, NovedadOid.class)): Novedad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Causal(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Causal(mapper.readValue(relatedInstanceJsonOid, CausalOid.class)): Causal.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4TipoIdentificacion(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new TipoIdentificacion(mapper.readValue(relatedInstanceJsonOid, TipoIdentificacionOid.class)): TipoIdentificacion.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4EstadoContrato(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new EstadoContrato(mapper.readValue(relatedInstanceJsonOid, EstadoContratoOid.class)): EstadoContrato.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4GrupoAsociado(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new GrupoAsociado(mapper.readValue(relatedInstanceJsonOid, GrupoAsociadoOid.class)): GrupoAsociado.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Periodicidad(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Periodicidad(mapper.readValue(relatedInstanceJsonOid, PeriodicidadOid.class)): Periodicidad.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Funcionario(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Funcionario(mapper.readValue(relatedInstanceJsonOid, FuncionarioOid.class)): Funcionario.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    private AbstractAppEntity buildSolicitudNovedadRelatedInstance4Firma(String relatedInstanceJsonOid, String remainingPath) {
        ObjectMapper mapper = new ObjectMapper();
    	try {
            return (remainingPath.isEmpty() ? new Firma(mapper.readValue(relatedInstanceJsonOid, FirmaOid.class)): Firma.buildRelatedInstance(relatedInstanceJsonOid, remainingPath));
    	} catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            throw new SystemException(e.getMessage());
    	}
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            SolicitudNovedadOid oid = new SolicitudNovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(SolicitudNovedadConstants.ATTR_FIELD_SOLICITUDNOVEDADID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getSolicitudNovedadId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(SolicitudNovedadService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
