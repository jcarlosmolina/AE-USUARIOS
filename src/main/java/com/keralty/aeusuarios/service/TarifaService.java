package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.TarifaConstants;
import com.keralty.aeusuarios.persistence.oid.TarifaOid;
import com.keralty.aeusuarios.persistence.Tarifa;
import com.keralty.aeusuarios.repository.TarifaJpaRepository;
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
public class TarifaService extends AbstractService {

    TarifaJpaRepository repository;

    TarifaService tarifaSrv;

    @Inject
    public TarifaService(
            TarifaService tarifaSrv,
            TarifaJpaRepository repository) {
        this.tarifaSrv = tarifaSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Tarifa by ID
     *
     * @param tarifaId Identification field tarifaId
     *
     * @return Instance of Tarifa
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Tarifa getById(Long tarifaId) {
        return getByOID(new TarifaOid(tarifaId));
    }
    
    /*
     * Returns an instance of Tarifa by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Tarifa
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Tarifa getByOID(TarifaOid oid) {
        Optional<Tarifa> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Tarifa by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Tarifa
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Tarifa getByOIDWithHV(TarifaOid oid) {
        Optional<Tarifa> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Tarifa> getInstanceByOid(TarifaOid oid) {
        return oid != null && oid.getTarifaId() != null
               ? repository.findById(oid.getTarifaId())
               : Optional.empty();
    }

    /*
     * Returns an instance of Tarifa by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Tarifa
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Tarifa getByJsonOid(String jsonOid) {
        TarifaOid oid = new TarifaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            TarifaOid oid = new TarifaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TarifaConstants.ATTR_FIELD_TARIFAID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getTarifaId(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(TarifaService.class).error(e.getMessage());
        }
    }

}
