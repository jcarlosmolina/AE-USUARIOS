package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AesolicitudesConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.PreexistenciaConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.global.UsuarioConstants;
import com.keralty.aeusuarios.persistence.oid.PreexistenciaOid;
import com.keralty.aeusuarios.persistence.Preexistencia;
import com.keralty.aeusuarios.repository.PreexistenciaJpaRepository;
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
public class PreexistenciaService extends AbstractService {

    PreexistenciaJpaRepository repository;

    PreexistenciaService preexistenciaSrv;

    @Inject
    public PreexistenciaService(
            PreexistenciaService preexistenciaSrv,
            PreexistenciaJpaRepository repository) {
        this.preexistenciaSrv = preexistenciaSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Preexistencia by ID
     *
     * @param aesolicitudesidsolicitud Identification field aesolicitudesidsolicitud
     *
     * @param usuarioUsuarioIdentificador Identification field usuarioUsuarioIdentificador
     *
     * @param preexistenciaIdentificador Identification field preexistenciaIdentificador
     *
     * @return Instance of Preexistencia
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Preexistencia getById(Long aesolicitudesidsolicitud, Long usuarioUsuarioIdentificador, Long preexistenciaIdentificador) {
        return getByOID(new PreexistenciaOid(aesolicitudesidsolicitud, usuarioUsuarioIdentificador, preexistenciaIdentificador));
    }
    
    /*
     * Returns an instance of Preexistencia by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Preexistencia
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Preexistencia getByOID(PreexistenciaOid oid) {
        Optional<Preexistencia> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Preexistencia by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Preexistencia
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Preexistencia getByOIDWithHV(PreexistenciaOid oid) {
        Optional<Preexistencia> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Preexistencia> getInstanceByOid(PreexistenciaOid oid) {
        return oid != null && oid.getAesolicitudesidsolicitud() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of Preexistencia by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Preexistencia
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Preexistencia getByJsonOid(String jsonOid) {
        PreexistenciaOid oid = new PreexistenciaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PreexistenciaOid oid = new PreexistenciaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PreexistenciaConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAesolicitudesidsolicitud(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(PreexistenciaConstants.ROLE_NAME_USUARIO + "." + UsuarioConstants.ATTR_FIELD_USUARIOIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getUsuarioUsuarioIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
            SQLWhereComparison comparison3 = new SQLWhereComparison(sql);
            comparison3.setOperator("=");
            comparison3.setFirstOperand(new SQLWhereOperandPathAttribute(PreexistenciaConstants.ATTR_FIELD_PREEXISTENCIAIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison3.setSecondOperand(new SQLWhereOperandLiteral(oid.getPreexistenciaIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison3);
        } catch (Exception e) {
            LoggerFactory.getLogger(PreexistenciaService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
