package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.PeriodicidadConstants;
import com.keralty.aeusuarios.persistence.oid.PeriodicidadOid;
import com.keralty.aeusuarios.persistence.Periodicidad;
import com.keralty.aeusuarios.repository.PeriodicidadJpaRepository;
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
public class PeriodicidadService extends AbstractService {

    PeriodicidadJpaRepository repository;

    PeriodicidadService periodicidadSrv;

    @Inject
    public PeriodicidadService(
            PeriodicidadService periodicidadSrv,
            PeriodicidadJpaRepository repository) {
        this.periodicidadSrv = periodicidadSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Periodicidad by ID
     *
     * @param periodicidadCodigo Identification field periodicidadCodigo
     *
     * @return Instance of Periodicidad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Periodicidad getById(Long periodicidadCodigo) {
        return getByOID(new PeriodicidadOid(periodicidadCodigo));
    }
    
    /*
     * Returns an instance of Periodicidad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Periodicidad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Periodicidad getByOID(PeriodicidadOid oid) {
        Optional<Periodicidad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Periodicidad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Periodicidad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Periodicidad getByOIDWithHV(PeriodicidadOid oid) {
        Optional<Periodicidad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Periodicidad> getInstanceByOid(PeriodicidadOid oid) {
        return oid != null && oid.getPeriodicidadCodigo() != null
               ? repository.findById(oid.getPeriodicidadCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Periodicidad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Periodicidad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Periodicidad getByJsonOid(String jsonOid) {
        PeriodicidadOid oid = new PeriodicidadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PeriodicidadOid oid = new PeriodicidadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PeriodicidadConstants.ATTR_FIELD_PERIODICIDADCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPeriodicidadCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PeriodicidadService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
