package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.NovedadCTConstants;
import com.keralty.aeusuarios.persistence.NovedadCT;
import com.keralty.aeusuarios.persistence.oid.NovedadCTOid;
import com.keralty.aeusuarios.repository.NovedadCTJpaRepository;
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
public class NovedadCTService extends AbstractService {

    NovedadCTJpaRepository repository;

    NovedadCTService novedadCTSrv;

    @Inject
    public NovedadCTService(
            NovedadCTService novedadCTSrv,
            NovedadCTJpaRepository repository) {
        this.novedadCTSrv = novedadCTSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of NovedadCT by ID
     *
     * @param novedadCTidNovedadCT Identification field novedadCTidNovedadCT
     *
     * @return Instance of NovedadCT
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadCT getById(Long novedadCTidNovedadCT) {
        return getByOID(new NovedadCTOid(novedadCTidNovedadCT));
    }
    
    /*
     * Returns an instance of NovedadCT by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadCT
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadCT getByOID(NovedadCTOid oid) {
        Optional<NovedadCT> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of NovedadCT by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of NovedadCT
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public NovedadCT getByOIDWithHV(NovedadCTOid oid) {
        Optional<NovedadCT> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<NovedadCT> getInstanceByOid(NovedadCTOid oid) {
        return oid != null && oid.getNovedadCTidNovedadCT() != null
               ? repository.findById(oid.getNovedadCTidNovedadCT())
               : Optional.empty();
    }

    /*
     * Returns an instance of NovedadCT by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of NovedadCT
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public NovedadCT getByJsonOid(String jsonOid) {
        NovedadCTOid oid = new NovedadCTOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            NovedadCTOid oid = new NovedadCTOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(NovedadCTConstants.ATTR_FIELD_NOVEDADCTIDNOVEDADCT, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getNovedadCTidNovedadCT(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(NovedadCTService.class).error(e.getMessage());
        }
    }

}
