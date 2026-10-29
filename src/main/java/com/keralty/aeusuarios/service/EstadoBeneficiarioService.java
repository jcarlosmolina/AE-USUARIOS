package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.EstadoBeneficiarioConstants;
import com.keralty.aeusuarios.persistence.EstadoBeneficiario;
import com.keralty.aeusuarios.persistence.oid.EstadoBeneficiarioOid;
import com.keralty.aeusuarios.repository.EstadoBeneficiarioJpaRepository;
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
public class EstadoBeneficiarioService extends AbstractService {

    EstadoBeneficiarioJpaRepository repository;

    EstadoBeneficiarioService estadoBeneficiarioSrv;

    @Inject
    public EstadoBeneficiarioService(
            EstadoBeneficiarioService estadoBeneficiarioSrv,
            EstadoBeneficiarioJpaRepository repository) {
        this.estadoBeneficiarioSrv = estadoBeneficiarioSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of EstadoBeneficiario by ID
     *
     * @param estadoBeneficiarioCodigo Identification field estadoBeneficiarioCodigo
     *
     * @return Instance of EstadoBeneficiario
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public EstadoBeneficiario getById(Long estadoBeneficiarioCodigo) {
        return getByOID(new EstadoBeneficiarioOid(estadoBeneficiarioCodigo));
    }
    
    /*
     * Returns an instance of EstadoBeneficiario by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoBeneficiario
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public EstadoBeneficiario getByOID(EstadoBeneficiarioOid oid) {
        Optional<EstadoBeneficiario> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of EstadoBeneficiario by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of EstadoBeneficiario
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public EstadoBeneficiario getByOIDWithHV(EstadoBeneficiarioOid oid) {
        Optional<EstadoBeneficiario> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<EstadoBeneficiario> getInstanceByOid(EstadoBeneficiarioOid oid) {
        return oid != null && oid.getEstadoBeneficiarioCodigo() != null
               ? repository.findById(oid.getEstadoBeneficiarioCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of EstadoBeneficiario by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of EstadoBeneficiario
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public EstadoBeneficiario getByJsonOid(String jsonOid) {
        EstadoBeneficiarioOid oid = new EstadoBeneficiarioOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            EstadoBeneficiarioOid oid = new EstadoBeneficiarioOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(EstadoBeneficiarioConstants.ATTR_FIELD_ESTADOBENEFICIARIOCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getEstadoBeneficiarioCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(EstadoBeneficiarioService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
