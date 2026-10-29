package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DireccionConstants;
import com.keralty.aeusuarios.persistence.Direccion;
import com.keralty.aeusuarios.persistence.oid.DireccionOid;
import com.keralty.aeusuarios.repository.DireccionJpaRepository;
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
public class DireccionService extends AbstractService {

    DireccionJpaRepository repository;

    DireccionService direccionSrv;

    @Inject
    public DireccionService(
            DireccionService direccionSrv,
            DireccionJpaRepository repository) {
        this.direccionSrv = direccionSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Direccion by ID
     *
     * @param direccionIdentificador Identification field direccionIdentificador
     *
     * @return Instance of Direccion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Direccion getById(Long direccionIdentificador) {
        return getByOID(new DireccionOid(direccionIdentificador));
    }
    
    /*
     * Returns an instance of Direccion by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Direccion
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Direccion getByOID(DireccionOid oid) {
        Optional<Direccion> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Direccion by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Direccion
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Direccion getByOIDWithHV(DireccionOid oid) {
        Optional<Direccion> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Direccion> getInstanceByOid(DireccionOid oid) {
        return oid != null && oid.getDireccionIdentificador() != null
               ? repository.findById(oid.getDireccionIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of Direccion by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Direccion
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Direccion getByJsonOid(String jsonOid) {
        DireccionOid oid = new DireccionOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            DireccionOid oid = new DireccionOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DireccionConstants.ATTR_FIELD_DIRECCIONIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDireccionIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(DireccionService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
