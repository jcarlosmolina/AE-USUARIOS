package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.TipoNovedadConstants;
import com.keralty.aeusuarios.persistence.oid.TipoNovedadOid;
import com.keralty.aeusuarios.persistence.TipoNovedad;
import com.keralty.aeusuarios.repository.TipoNovedadJpaRepository;
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
public class TipoNovedadService extends AbstractService {

    TipoNovedadJpaRepository repository;

    TipoNovedadService tipoNovedadSrv;

    @Inject
    public TipoNovedadService(
            TipoNovedadService tipoNovedadSrv,
            TipoNovedadJpaRepository repository) {
        this.tipoNovedadSrv = tipoNovedadSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of TipoNovedad by ID
     *
     * @param tipoNovedadTipo Identification field tipoNovedadTipo
     *
     * @return Instance of TipoNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoNovedad getById(Long tipoNovedadTipo) {
        return getByOID(new TipoNovedadOid(tipoNovedadTipo));
    }
    
    /*
     * Returns an instance of TipoNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoNovedad getByOID(TipoNovedadOid oid) {
        Optional<TipoNovedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of TipoNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of TipoNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public TipoNovedad getByOIDWithHV(TipoNovedadOid oid) {
        Optional<TipoNovedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<TipoNovedad> getInstanceByOid(TipoNovedadOid oid) {
        return oid != null && oid.getTipoNovedadTipo() != null
               ? repository.findById(oid.getTipoNovedadTipo())
               : Optional.empty();
    }

    /*
     * Returns an instance of TipoNovedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of TipoNovedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public TipoNovedad getByJsonOid(String jsonOid) {
        TipoNovedadOid oid = new TipoNovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            TipoNovedadOid oid = new TipoNovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(TipoNovedadConstants.ATTR_FIELD_TIPONOVEDADTIPO, Constants.Type.NAT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getTipoNovedadTipo(), Constants.Type.NAT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(TipoNovedadService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
