package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FrecuenciaActConstants;
import com.keralty.aeusuarios.persistence.FrecuenciaAct;
import com.keralty.aeusuarios.persistence.oid.FrecuenciaActOid;
import com.keralty.aeusuarios.repository.FrecuenciaActJpaRepository;
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
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class FrecuenciaActService extends AbstractService {

    FrecuenciaActJpaRepository repository;

    FrecuenciaActService frecuenciaActSrv;

    @Inject
    public FrecuenciaActService(
            FrecuenciaActService frecuenciaActSrv,
            FrecuenciaActJpaRepository repository) {
        this.frecuenciaActSrv = frecuenciaActSrv;
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, FrecuenciaActConstants.CLASS_NAME);
    }

    private List<FrecuenciaAct> solveFrecuenciaActTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, FrecuenciaActConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveFrecuenciaActTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, FrecuenciaActConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class FrecuenciaAct
     *
     * @return Population of class FrecuenciaAct
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FrecuenciaAct> get() {
        List<FrecuenciaAct> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    
    /*
     * Gets the preloaded list of objects of class FrecuenciaAct
     *
     * @param queryRequest Request object that dictates the search conditions to 
     * retrieve objects
     *
     * @return Preloaded list of objects of class FrecuenciaAct
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<PreloadViewModel> getPreload(QueryRequest queryRequest) {
        List<PreloadViewModel> results = new ArrayList<>();
        List<FrecuenciaAct> instances = get(queryRequest);
        if(FrecuenciaActConstants.DSICFRECUENCIAACT.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildICFrecuenciaAct())).collect(Collectors.toList());
        }
        if(FrecuenciaActConstants.DSDSFRECUENCIAACTPIU.equals(queryRequest.getDisplaySetName())) {
            results = instances.stream().map(x -> new PreloadViewModel(x.getOid().toJson(), x.buildDSFrecuenciaActPIU())).collect(Collectors.toList());
        }
        return results;
    }
    /*
     * Returns the population of class FrecuenciaAct that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class FrecuenciaAct matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<FrecuenciaAct> get(QueryRequest queryRequest) {
        return solveFrecuenciaActTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveFrecuenciaActTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveFrecuenciaActTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel(solveFrecuenciaActTypedQuery(queryRequest).stream()
                    .map(instance -> buildPreloadViewModel(instance, queryRequest.getDisplaySetName()))
                    .collect(Collectors.toList()));
        }
    }

    /*
     * Returns an instance of FrecuenciaAct by ID
     *
     * @param frecuenciaActCodigo Identification field frecuenciaActCodigo
     *
     * @return Instance of FrecuenciaAct
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FrecuenciaAct getById(Long frecuenciaActCodigo) {
        return getByOID(new FrecuenciaActOid(frecuenciaActCodigo));
    }
    
    /*
     * Returns an instance of FrecuenciaAct by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FrecuenciaAct
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FrecuenciaAct getByOID(FrecuenciaActOid oid) {
        Optional<FrecuenciaAct> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of FrecuenciaAct by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FrecuenciaAct
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public FrecuenciaAct getByOIDWithHV(FrecuenciaActOid oid) {
        Optional<FrecuenciaAct> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<FrecuenciaAct> getInstanceByOid(FrecuenciaActOid oid) {
        return oid != null && oid.getFrecuenciaActCodigo() != null
               ? repository.findById(oid.getFrecuenciaActCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of FrecuenciaAct by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of FrecuenciaAct
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public FrecuenciaAct getByJsonOid(String jsonOid) {
        FrecuenciaActOid oid = new FrecuenciaActOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns a set of displayset items for an instance of FrecuenciaAct
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of FrecuenciaAct
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getFrecuenciaActDynamic(FrecuenciaActOid oid, String displaySetItems) {
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
    public String getSuppInfo(FrecuenciaActOid oid, String dsName) {
        FrecuenciaAct instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(FrecuenciaAct instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        if (FrecuenciaActConstants.DSICFRECUENCIAACT.equals(dsName))
            return instance.buildICFrecuenciaAct();
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }

    public static PreloadViewModel buildPreloadViewModel(FrecuenciaAct instance, String dsName) {
        if (FrecuenciaActConstants.DSICFRECUENCIAACT.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildICFrecuenciaAct());
        if (FrecuenciaActConstants.DSDSFRECUENCIAACTPIU.equals(dsName))
            return new PreloadViewModel(instance.getOid().toJson(), instance.buildDSFrecuenciaActPIU());
        return new PreloadViewModel(instance.getOid().toJson(), "");
    }


    @Override
    protected void applyQueryFilters(FilterRequest filterRequest, SQLSelect sql) throws SystemException {
        if (FrecuenciaActConstants.FILTER_NAME_FFRECUENCIAACTVARIOS.equalsIgnoreCase(filterRequest.getName()))
            fFrecuenciaActVarios(filterRequest, sql);
    }

    @Override
    protected void applyServiceSIFilters(FilterRequest filterRequest, SQLSelect sql) {
        if ("SuppInfo_IC_FrecuenciaAct".equals(filterRequest.getName()))
            suppInfo4ICFrecuenciaAct(filterRequest.getFilterVariable("searchText").toString(), sql);
    }


    private void fFrecuenciaActVarios(FilterRequest filterRequest, SQLSelect sql) {
        SQLWhereConjunction conjunction = new SQLWhereConjunction();
        Long vParametrica = filterRequest.hasFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VPARAMETRICA) ? (Long) filterRequest.getFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VPARAMETRICA, FilterVariableRequest.NAT) : null;
        Date vFIni = filterRequest.hasFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VFINI) ? (Date) filterRequest.getFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VFINI, FilterVariableRequest.DATE) : null;
        Date vFFin = filterRequest.hasFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VFFIN) ? (Date) filterRequest.getFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VFFIN, FilterVariableRequest.DATE) : null;

        // Parametrica = vParametrica
        if (vParametrica != null) {
            // '=' Comparison
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTPARAMETRICA, Constants.Type.NAT.getTypeName());
            comparison1.setFirstOperand(operand112);
            
            // Operand 2
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(vParametrica, Constants.Type.NAT.getTypeName()));
            conjunction.addOperand(comparison1);

        }        

        // FechaUltimaSinc >= vFIni
        if (vFIni != null) {
            // '>=' Comparison
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator(">=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTFECHAULTIMASINC, Constants.Type.DATE.getTypeName());
            comparison2.setFirstOperand(operand113);
            
            // Operand 2
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(vFIni, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison2);

        }        

        // FechaUltimaSinc <= vFFin
        if (vFFin != null) {
            // '<=' Comparison
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("<=");
            
            // Operand 1
            SQLWhereOperandPathAttribute operand114 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTFECHAULTIMASINC, Constants.Type.DATE.getTypeName());
            comparison3.setFirstOperand(operand114);
            
            // Operand 2
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(vFFin, Constants.Type.DATE.getTypeName()));
            conjunction.addOperand(comparison3);

        }        

        sql.addConjunction(conjunction);
    }

    // IIU Methods


    /*
     * Solves the query needed for PIUFrecuenciaAct
     *
     * @param queryRequest Query request
     * @return List of viewmodels for FrecuenciaAct using displayset DSFrecuenciaActPIU that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.frecuenciaact.ds.DSFrecuenciaActPIU> piuPIUFrecuenciaAct(QueryRequest queryRequest) {
        return solveFrecuenciaActTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.frecuenciaact.ds.DSFrecuenciaActPIU::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUFrecuenciaAct
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUFrecuenciaAct
     */
    public int getCount4PIUFrecuenciaAct(QueryRequest queryRequest) {
        return solveFrecuenciaActTypedQuery(queryRequest).size();
    }

    // Service: fijarSincronizacion

    /*
     * Entry point for service fijarSincronizacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse fijarSincronizacion(
            com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = frecuenciaActSrv.fijarSincronizacionTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service fijarSincronizacion
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse fijarSincronizacionTxn(
            com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest request) throws ModelException {
        request.setFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance(frecuenciaActSrv.getByOIDWithHV(request.getFrecuenciaActfijarSincronizacionpthisFrecuenciaAct()));
        return frecuenciaActSrv.fijarSincronizacionImplementation(request);
    }

    /*
     * Implements service fijarSincronizacion
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse fijarSincronizacionImplementation(
            com.keralty.aeusuarios.viewmodel.frecuenciaact.siu.FijarSincronizacionRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        FrecuenciaAct frecuenciaActfijarSincronizacionpthisFrecuenciaAct = request.getFrecuenciaActfijarSincronizacionpthisFrecuenciaActInstance();
        Date frecuenciaActfijarSincronizacionpFechaUltimaSinc = request.getFrecuenciaActfijarSincronizacionpFechaUltimaSinc();
        String frecuenciaActfijarSincronizacionpResultadoSinc = request.getFrecuenciaActfijarSincronizacionpResultadoSinc();
        String frecuenciaActfijarSincronizacionpUsuario = request.getFrecuenciaActfijarSincronizacionpUsuario();
        String frecuenciaActfijarSincronizacionpNombreUsuario = request.getFrecuenciaActfijarSincronizacionpNombreUsuario();

        request.checkArguments();
        FrecuenciaAct instance = frecuenciaActfijarSincronizacionpthisFrecuenciaAct;
        instance.setFrecuenciaActFechaUltimaSinc(frecuenciaActfijarSincronizacionpFechaUltimaSinc);
        instance.setFrecuenciaActResultadoSinc(frecuenciaActfijarSincronizacionpResultadoSinc);
        instance.setFrecuenciaActUsuario(frecuenciaActfijarSincronizacionpUsuario);
        instance.setFrecuenciaActNombreUsuario(frecuenciaActfijarSincronizacionpNombreUsuario);


        response.setInstance(repository.save(instance));
        response.setInstanceSuppInfo(instance.buildICFrecuenciaAct());

        return response;
    }


    private void suppInfo4ICFrecuenciaAct(String searchText, SQLSelect select) {
        try {
            SQLWhereDisjunction disjunction = new SQLWhereDisjunction();

            SQLWhereComparison comparison1 = new SQLWhereComparison(select);
            comparison1.setOperator("LIKE");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTDRVNOMBREPARAMETRICA, Constants.Type.STRING.getTypeName()));
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
        applyDSItemSort(queryRequest, select);
        applyDefaultOrderCriteria(queryRequest, select);
    }

    private void applyDefaultOrderCriteria(QueryRequest queryRequest, SQLSelect select) {
        if (queryRequest.getOrderCriteriaName() != null && !queryRequest.getOrderCriteriaName().isBlank())
            return;
        if (queryRequest.getDsItemSort() != null && !queryRequest.getDsItemSort().isBlank())
            return;
        select.getOrderByPart().addItem(Constants.normalizePath(FrecuenciaActConstants.CLASS_NAME, FrecuenciaActConstants.ATTR_FIELD_FRECUENCIAACTCODIGO, false), true);
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FrecuenciaActOid oid = new FrecuenciaActOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FrecuenciaActConstants.ATTR_FIELD_FRECUENCIAACTCODIGO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFrecuenciaActCodigo(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(FrecuenciaActService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
