package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.InstanceExistsException;
import com.keralty.aeusuarios.exception.ModelException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.UsuarioSistemaExternoConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioSistemaExternoOid;
import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;
import com.keralty.aeusuarios.repository.UsuarioSistemaExternoJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class UsuarioSistemaExternoService extends AbstractService {

    UsuarioSistemaExternoJpaRepository repository;

    @Inject
    public UsuarioSistemaExternoService(
            UsuarioSistemaExternoJpaRepository repository) {
        this.repository = repository;
    }

    public List<Map<String, Object>> solveQuery(QueryRequest request) {
        return solveGenericQuery(request, UsuarioSistemaExternoConstants.CLASS_NAME);
    }

    private List<UsuarioSistemaExterno> solveUsuarioSistemaExternoTypedQuery(QueryRequest request) {
        return repository.solveQuery(processQueryRequest(request, UsuarioSistemaExternoConstants.CLASS_NAME), request.getPageSize(), request.getPageNumber());
    }
    
    private int solveUsuarioSistemaExternoTypedCountQuery(QueryRequest request) {
        return repository.solveCountQuery(processCountQueryRequest(request, UsuarioSistemaExternoConstants.CLASS_NAME));
    }

    /*
     * Returns the population of class UsuarioSistemaExterno
     *
     * @return Population of class UsuarioSistemaExterno
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<UsuarioSistemaExterno> get() {
        List<UsuarioSistemaExterno> results = new java.util.ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }
    /*
     * Returns the population of class UsuarioSistemaExterno that matches certain search criteria
     *
     * @param queryRequest Search criteria
     *
     * @return Population of class UsuarioSistemaExterno matching the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<UsuarioSistemaExterno> get(QueryRequest queryRequest) {
        return solveUsuarioSistemaExternoTypedQuery(queryRequest);
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
            return new PopulationResponseViewModel(solveUsuarioSistemaExternoTypedQuery(queryRequest).stream()
                    .map(instance -> buildDynamicObject(instance, queryRequest.getDisplaySetItems()))
                    .collect(Collectors.toList()), queryRequest.getPageSize() != 0 ? solveUsuarioSistemaExternoTypedCountQuery(queryRequest) : 0);
        } else {
            return new PreloadResponseViewModel();
        }
    }

    /*
     * Returns an instance of UsuarioSistemaExterno by ID
     *
     * @param usuarioSistemaExternoLogin Identification field usuarioSistemaExternoLogin
     *
     * @return Instance of UsuarioSistemaExterno
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioSistemaExterno getById(String usuarioSistemaExternoLogin) {
        return getByOID(new UsuarioSistemaExternoOid(usuarioSistemaExternoLogin));
    }
    
    /*
     * Returns an instance of UsuarioSistemaExterno by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioSistemaExterno
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioSistemaExterno getByOID(UsuarioSistemaExternoOid oid) {
        Optional<UsuarioSistemaExterno> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of UsuarioSistemaExterno by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioSistemaExterno
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public UsuarioSistemaExterno getByOIDWithHV(UsuarioSistemaExternoOid oid) {
        Optional<UsuarioSistemaExterno> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<UsuarioSistemaExterno> getInstanceByOid(UsuarioSistemaExternoOid oid) {
        return oid != null && oid.getUsuarioSistemaExternoLogin() != null
               ? repository.findById(oid.getUsuarioSistemaExternoLogin())
               : Optional.empty();
    }

    /*
     * Returns an instance of UsuarioSistemaExterno by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of UsuarioSistemaExterno
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioSistemaExterno getByJsonOid(String jsonOid) {
        UsuarioSistemaExternoOid oid = new UsuarioSistemaExternoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }

    /*
     * Returns a set of displayset items for an instance of UsuarioSistemaExterno
     *
     * @param oid Object IDentifier
     *
     * @param displaySetItems List of comma-separated displayset items
     *
     * @return Set of displayset items for an instance of UsuarioSistemaExterno
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public InstanceResponseViewModel getUsuarioSistemaExternoDynamic(UsuarioSistemaExternoOid oid, String displaySetItems) {
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
    public String getSuppInfo(UsuarioSistemaExternoOid oid, String dsName) {
        UsuarioSistemaExterno instance = getByOIDWithHV(oid);
        return (instance != null ? getSuppInfo(instance, dsName): "");
    }

    private String getSuppInfo(UsuarioSistemaExterno instance, String dsName) {
        if (instance == null || instance.isNull()) return "";
        return dsName.isEmpty() ? instance.getOid().toJson() : "";
    }




    // IIU Methods


    /*
     * Solves the query needed for PIUUsuarioSistemaExterno
     *
     * @param queryRequest Query request
     * @return List of viewmodels for UsuarioSistemaExterno using displayset DSUsuarioSistemaExterno that 
     * match the search criteria
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public List<com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.ds.DSUsuarioSistemaExterno> piuPIUUsuarioSistemaExterno(QueryRequest queryRequest) {
        return solveUsuarioSistemaExternoTypedQuery(queryRequest).stream()
                .map(com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.ds.DSUsuarioSistemaExterno::new)
                .collect(Collectors.toList());
    }

    /*
     * Solves the COUNT query needed for PIUUsuarioSistemaExterno
     *
     * @param queryRequest Query request
     * @returns Count of instances for PIUUsuarioSistemaExterno
     */
    public int getCount4PIUUsuarioSistemaExterno(QueryRequest queryRequest) {
        return solveUsuarioSistemaExternoTypedQuery(queryRequest).size();
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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.CrearRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioSistemaExternoSrv.crearTxn(request);
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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.CrearRequest request) throws ModelException {
        return usuarioSistemaExternoSrv.crearImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.CrearRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        String usuarioSistemaExternocrearpatrLogin = request.getUsuarioSistemaExternocrearpatrLogin();
        String usuarioSistemaExternocrearpatrDescripcion = request.getUsuarioSistemaExternocrearpatrDescripcion();
        String usuarioSistemaExternocrearppassword = request.getUsuarioSistemaExternocrearppassword();

        request.checkArguments();
        UsuarioSistemaExterno instance = new UsuarioSistemaExterno();
        instance.setUsuarioSistemaExternoLogin(usuarioSistemaExternocrearpatrLogin);
        instance.setUsuarioSistemaExternoDescripcion(usuarioSistemaExternocrearpatrDescripcion);
        instance.setPassWord(encrypt(usuarioSistemaExternocrearppassword));
        if (usuarioSistemaExternoSrv.getByOID(instance.getOid()) != null) {
            throw new InstanceExistsException(UsuarioSistemaExternoConstants.CLASS_ALIAS);
        }

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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.EliminarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioSistemaExternoSrv.eliminarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.EliminarRequest request) throws ModelException {
        request.setUsuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance(usuarioSistemaExternoSrv.getByOIDWithHV(request.getUsuarioSistemaExternoeliminarpthisUsuarioSistemaExterno()));
        return usuarioSistemaExternoSrv.eliminarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.EliminarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioSistemaExterno usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno = request.getUsuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance();

        request.checkArguments();
        UsuarioSistemaExterno instance = usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno;


        repository.delete(instance);
        
        response.setInstance(instance);

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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ModificarRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioSistemaExternoSrv.modificarTxn(request);
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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ModificarRequest request) throws ModelException {
        request.setUsuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance(usuarioSistemaExternoSrv.getByOIDWithHV(request.getUsuarioSistemaExternomodificarpthisUsuarioSistemaExterno()));
        return usuarioSistemaExternoSrv.modificarImplementation(request);
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
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ModificarRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioSistemaExterno usuarioSistemaExternomodificarpthisUsuarioSistemaExterno = request.getUsuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance();
        String usuarioSistemaExternomodificarpDescripcion = request.getUsuarioSistemaExternomodificarpDescripcion();

        request.checkArguments();
        UsuarioSistemaExterno instance = usuarioSistemaExternomodificarpthisUsuarioSistemaExterno;
        instance.setUsuarioSistemaExternoDescripcion(usuarioSistemaExternomodificarpDescripcion);


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: setPassword

    /*
     * Entry point for service setPassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse setPassword(
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.SetPasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioSistemaExternoSrv.setPasswordTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service setPassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse setPasswordTxn(
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.SetPasswordRequest request) throws ModelException {
        request.setUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance(usuarioSistemaExternoSrv.getByOIDWithHV(request.getUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno()));
        return usuarioSistemaExternoSrv.setPasswordImplementation(request);
    }

    /*
     * Implements service setPassword
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse setPasswordImplementation(
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.SetPasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioSistemaExterno usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno = request.getUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance();
        String usuarioSistemaExternosetPasswordpNewPassword = request.getUsuarioSistemaExternosetPasswordpNewPassword();

        request.checkArguments();
        UsuarioSistemaExterno instance = usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno;
        instance.setPassWord(encrypt(usuarioSistemaExternosetPasswordpNewPassword));


        response.setInstance(repository.save(instance));

        return response;
    }

    // Service: changePassword

    /*
     * Entry point for service changePassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.NOT_SUPPORTED)
    public ServiceResponse changePassword(
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ChangePasswordRequest request) {
        ServiceResponse response = new ServiceResponse();
        try {
            response = usuarioSistemaExternoSrv.changePasswordTxn(request);
        } catch (Exception e) {
            response.setException(e);
        }
        return response;
    }

    /*
     * Transactional entry point for service changePassword
     *
     * @param request Service request viewmodel
     *
     * @returns Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public ServiceResponse changePasswordTxn(
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ChangePasswordRequest request) throws ModelException {
        request.setUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance(usuarioSistemaExternoSrv.getByOIDWithHV(request.getUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno()));
        return usuarioSistemaExternoSrv.changePasswordImplementation(request);
    }

    /*
     * Implements service changePassword
     *
     * @param request Service request viewmodel
     *
     * @return Service response ViewModel encapsulating the execution results
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public ServiceResponse changePasswordImplementation(
            com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ChangePasswordRequest request) throws ModelException {
        ServiceResponse response = new ServiceResponse();
        UsuarioSistemaExterno usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno = request.getUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance();
        String usuarioSistemaExternochangePasswordpOldPassword = request.getUsuarioSistemaExternochangePasswordpOldPassword();
        String usuarioSistemaExternochangePasswordpNewPassword = request.getUsuarioSistemaExternochangePasswordpNewPassword();

        request.checkArguments();
        UsuarioSistemaExterno instance = usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno;
        if(!instance.getPassWord().equals(encrypt(usuarioSistemaExternochangePasswordpOldPassword))) {
            throw new ModelException("Incorrect password");
        }
        instance.setPassWord(encrypt(usuarioSistemaExternochangePasswordpNewPassword));


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
        select.getOrderByPart().addItem(Constants.normalizePath(UsuarioSistemaExternoConstants.CLASS_NAME, UsuarioSistemaExternoConstants.ATTR_FIELD_USUARIOSISTEMAEXTERNOLOGIN, false), true);
    }

    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            UsuarioSistemaExternoOid oid = new UsuarioSistemaExternoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(UsuarioSistemaExternoConstants.ATTR_FIELD_USUARIOSISTEMAEXTERNOLOGIN, Constants.Type.STRING.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getUsuarioSistemaExternoLogin(), Constants.Type.STRING.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(UsuarioSistemaExternoService.class).error(e.getMessage());
        }
    }

}
