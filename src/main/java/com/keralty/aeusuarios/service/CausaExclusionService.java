package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.CausaExclusionConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.CausaExclusion;
import com.keralty.aeusuarios.persistence.oid.CausaExclusionOid;
import com.keralty.aeusuarios.repository.CausaExclusionJpaRepository;
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
public class CausaExclusionService extends AbstractService {

    CausaExclusionJpaRepository repository;

    CausaExclusionService causaExclusionSrv;

    @Inject
    public CausaExclusionService(
            CausaExclusionService causaExclusionSrv,
            CausaExclusionJpaRepository repository) {
        this.causaExclusionSrv = causaExclusionSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of CausaExclusion by ID
     *
     * @param causaExclusionidCausaExclusion Identification field causaExclusionidCausaExclusion
     *
     * @return Instance of CausaExclusion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public CausaExclusion getById(Long causaExclusionidCausaExclusion) {
        return getByOID(new CausaExclusionOid(causaExclusionidCausaExclusion));
    }
    
    /*
     * Returns an instance of CausaExclusion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CausaExclusion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public CausaExclusion getByOID(CausaExclusionOid oid) {
        Optional<CausaExclusion> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of CausaExclusion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of CausaExclusion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public CausaExclusion getByOIDWithHV(CausaExclusionOid oid) {
        Optional<CausaExclusion> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<CausaExclusion> getInstanceByOid(CausaExclusionOid oid) {
        return oid != null && oid.getCausaExclusionidCausaExclusion() != null
               ? repository.findById(oid.getCausaExclusionidCausaExclusion())
               : Optional.empty();
    }

    /*
     * Returns an instance of CausaExclusion by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of CausaExclusion
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public CausaExclusion getByJsonOid(String jsonOid) {
        CausaExclusionOid oid = new CausaExclusionOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            CausaExclusionOid oid = new CausaExclusionOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(CausaExclusionConstants.ATTR_FIELD_CAUSAEXCLUSIONIDCAUSAEXCLUSION, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getCausaExclusionidCausaExclusion(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(CausaExclusionService.class).error(e.getMessage());
        }
    }

}
