package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AesolicitudesConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.UsuarioRegConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioRegOid;
import com.keralty.aeusuarios.persistence.UsuarioReg;
import com.keralty.aeusuarios.repository.UsuarioRegJpaRepository;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.slf4j.LoggerFactory;

@Transactional
@ApplicationScoped
public class UsuarioRegService extends AbstractService {

    UsuarioRegJpaRepository repository;

    UsuarioRegService usuarioRegSrv;

    @Inject
    public UsuarioRegService(
            UsuarioRegService usuarioRegSrv,
            UsuarioRegJpaRepository repository) {
        this.usuarioRegSrv = usuarioRegSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of UsuarioReg by ID
     *
     * @param aesolicitudesidsolicitud Identification field aesolicitudesidsolicitud
     *
     * @param usuarioRegIdentificador Identification field usuarioRegIdentificador
     *
     * @return Instance of UsuarioReg
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioReg getById(Long aesolicitudesidsolicitud, Long usuarioRegIdentificador) {
        return getByOID(new UsuarioRegOid(aesolicitudesidsolicitud, usuarioRegIdentificador));
    }
    
    /*
     * Returns an instance of UsuarioReg by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioReg
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioReg getByOID(UsuarioRegOid oid) {
        Optional<UsuarioReg> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of UsuarioReg by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of UsuarioReg
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public UsuarioReg getByOIDWithHV(UsuarioRegOid oid) {
        Optional<UsuarioReg> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<UsuarioReg> getInstanceByOid(UsuarioRegOid oid) {
        return oid != null && oid.getAesolicitudesidsolicitud() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of UsuarioReg by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of UsuarioReg
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public UsuarioReg getByJsonOid(String jsonOid) {
        UsuarioRegOid oid = new UsuarioRegOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            UsuarioRegOid oid = new UsuarioRegOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(UsuarioRegConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAesolicitudesidsolicitud(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(UsuarioRegConstants.ATTR_FIELD_USUARIOREGIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getUsuarioRegIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(UsuarioRegService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
