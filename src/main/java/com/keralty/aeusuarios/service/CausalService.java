package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.CausalConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.Causal;
import com.keralty.aeusuarios.persistence.oid.CausalOid;
import com.keralty.aeusuarios.repository.CausalJpaRepository;
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
public class CausalService extends AbstractService {

    CausalJpaRepository repository;

    CausalService causalSrv;

    @Inject
    public CausalService(
            CausalService causalSrv,
            CausalJpaRepository repository) {
        this.causalSrv = causalSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Causal by ID
     *
     * @param causalidCausal Identification field causalidCausal
     *
     * @return Instance of Causal
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Causal getById(Long causalidCausal) {
        return getByOID(new CausalOid(causalidCausal));
    }
    
    /*
     * Returns an instance of Causal by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Causal
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Causal getByOID(CausalOid oid) {
        Optional<Causal> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Causal by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Causal
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Causal getByOIDWithHV(CausalOid oid) {
        Optional<Causal> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Causal> getInstanceByOid(CausalOid oid) {
        return oid != null && oid.getCausalidCausal() != null
               ? repository.findById(oid.getCausalidCausal())
               : Optional.empty();
    }

    /*
     * Returns an instance of Causal by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Causal
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Causal getByJsonOid(String jsonOid) {
        CausalOid oid = new CausalOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            CausalOid oid = new CausalOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(CausalConstants.ATTR_FIELD_CAUSALIDCAUSAL, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getCausalidCausal(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(CausalService.class).error(e.getMessage());
        }
    }

}
