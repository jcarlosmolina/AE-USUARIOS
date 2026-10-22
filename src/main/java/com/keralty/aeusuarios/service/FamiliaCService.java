package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ContratoCConstants;
import com.keralty.aeusuarios.global.FamiliaCConstants;
import com.keralty.aeusuarios.persistence.FamiliaC;
import com.keralty.aeusuarios.persistence.oid.FamiliaCOid;
import com.keralty.aeusuarios.repository.FamiliaCJpaRepository;
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
public class FamiliaCService extends AbstractService {

    FamiliaCJpaRepository repository;

    FamiliaCService familiaCSrv;

    @Inject
    public FamiliaCService(
            FamiliaCService familiaCSrv,
            FamiliaCJpaRepository repository) {
        this.familiaCSrv = familiaCSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of FamiliaC by ID
     *
     * @param contratoCContratoCID Identification field contratoCContratoCID
     *
     * @param familiaCID Identification field familiaCID
     *
     * @return Instance of FamiliaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaC getById(Long contratoCContratoCID, Long familiaCID) {
        return getByOID(new FamiliaCOid(contratoCContratoCID, familiaCID));
    }
    
    /*
     * Returns an instance of FamiliaC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaC getByOID(FamiliaCOid oid) {
        Optional<FamiliaC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of FamiliaC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public FamiliaC getByOIDWithHV(FamiliaCOid oid) {
        Optional<FamiliaC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<FamiliaC> getInstanceByOid(FamiliaCOid oid) {
        return oid != null && oid.getContratoCContratoCID() != null
               ? repository.findById(oid)
               : Optional.empty();
    }

    /*
     * Returns an instance of FamiliaC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of FamiliaC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaC getByJsonOid(String jsonOid) {
        FamiliaCOid oid = new FamiliaCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FamiliaCOid oid = new FamiliaCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FamiliaCConstants.ROLE_NAME_CONTRATOC + "." + ContratoCConstants.ATTR_FIELD_CONTRATOCID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getContratoCContratoCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
            SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
            comparison2.setOperator("=");
            comparison2.setFirstOperand(new SQLWhereOperandPathAttribute(FamiliaCConstants.ATTR_FIELD_FAMILIACID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison2.setSecondOperand(new SQLWhereOperandLiteral(oid.getFamiliaCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison2);
        } catch (Exception e) {
            LoggerFactory.getLogger(FamiliaCService.class).error(e.getMessage());
        }
    }

}
