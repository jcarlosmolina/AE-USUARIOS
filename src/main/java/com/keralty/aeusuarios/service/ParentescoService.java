package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ParentescoConstants;
import com.keralty.aeusuarios.persistence.oid.ParentescoOid;
import com.keralty.aeusuarios.persistence.Parentesco;
import com.keralty.aeusuarios.repository.ParentescoJpaRepository;
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
public class ParentescoService extends AbstractService {

    ParentescoJpaRepository repository;

    ParentescoService parentescoSrv;

    @Inject
    public ParentescoService(
            ParentescoService parentescoSrv,
            ParentescoJpaRepository repository) {
        this.parentescoSrv = parentescoSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Parentesco by ID
     *
     * @param parentescoCodigo Identification field parentescoCodigo
     *
     * @return Instance of Parentesco
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Parentesco getById(Long parentescoCodigo) {
        return getByOID(new ParentescoOid(parentescoCodigo));
    }
    
    /*
     * Returns an instance of Parentesco by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Parentesco
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Parentesco getByOID(ParentescoOid oid) {
        Optional<Parentesco> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Parentesco by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Parentesco
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Parentesco getByOIDWithHV(ParentescoOid oid) {
        Optional<Parentesco> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Parentesco> getInstanceByOid(ParentescoOid oid) {
        return oid != null && oid.getParentescoCodigo() != null
               ? repository.findById(oid.getParentescoCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Parentesco by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Parentesco
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Parentesco getByJsonOid(String jsonOid) {
        ParentescoOid oid = new ParentescoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ParentescoOid oid = new ParentescoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ParentescoConstants.ATTR_FIELD_PARENTESCOCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getParentescoCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ParentescoService.class).error(e.getMessage());
        }
    }

}
