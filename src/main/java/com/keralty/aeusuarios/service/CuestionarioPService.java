package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.CuestionarioPConstants;
import com.keralty.aeusuarios.persistence.CuestionarioP;
import com.keralty.aeusuarios.persistence.oid.CuestionarioPOid;
import com.keralty.aeusuarios.repository.CuestionarioPJpaRepository;
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
public class CuestionarioPService extends AbstractService {

    CuestionarioPJpaRepository repository;

    CuestionarioPService cuestionarioPSrv;

    @Inject
    public CuestionarioPService(
            CuestionarioPService cuestionarioPSrv,
            CuestionarioPJpaRepository repository) {
        this.cuestionarioPSrv = cuestionarioPSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of CuestionarioP by ID
     *
     * @param cuestionarioPNumero Identification field cuestionarioPNumero
     *
     * @return Instance of CuestionarioP
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public CuestionarioP getById(Long cuestionarioPNumero) {
        return getByOID(new CuestionarioPOid(cuestionarioPNumero));
    }
    
    /*
     * Returns an instance of CuestionarioP by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CuestionarioP
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public CuestionarioP getByOID(CuestionarioPOid oid) {
        Optional<CuestionarioP> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of CuestionarioP by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CuestionarioP
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public CuestionarioP getByOIDWithHV(CuestionarioPOid oid) {
        Optional<CuestionarioP> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<CuestionarioP> getInstanceByOid(CuestionarioPOid oid) {
        return oid != null && oid.getCuestionarioPNumero() != null
               ? repository.findById(oid.getCuestionarioPNumero())
               : Optional.empty();
    }

    /*
     * Returns an instance of CuestionarioP by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of CuestionarioP
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public CuestionarioP getByJsonOid(String jsonOid) {
        CuestionarioPOid oid = new CuestionarioPOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            CuestionarioPOid oid = new CuestionarioPOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(CuestionarioPConstants.ATTR_FIELD_CUESTIONARIOPNUMERO, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getCuestionarioPNumero(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(CuestionarioPService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
