package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.NovedadConstants;
import com.keralty.aeusuarios.persistence.Novedad;
import com.keralty.aeusuarios.persistence.oid.NovedadOid;
import com.keralty.aeusuarios.repository.NovedadJpaRepository;
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
public class NovedadService extends AbstractService {

    NovedadJpaRepository repository;

    NovedadService novedadSrv;

    @Inject
    public NovedadService(
            NovedadService novedadSrv,
            NovedadJpaRepository repository) {
        this.novedadSrv = novedadSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Novedad by ID
     *
     * @param novedadidNovedad Identification field novedadidNovedad
     *
     * @return Instance of Novedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Novedad getById(Long novedadidNovedad) {
        return getByOID(new NovedadOid(novedadidNovedad));
    }
    
    /*
     * Returns an instance of Novedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Novedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Novedad getByOID(NovedadOid oid) {
        Optional<Novedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Novedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Novedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Novedad getByOIDWithHV(NovedadOid oid) {
        Optional<Novedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Novedad> getInstanceByOid(NovedadOid oid) {
        return oid != null && oid.getNovedadidNovedad() != null
               ? repository.findById(oid.getNovedadidNovedad())
               : Optional.empty();
    }

    /*
     * Returns an instance of Novedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Novedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Novedad getByJsonOid(String jsonOid) {
        NovedadOid oid = new NovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            NovedadOid oid = new NovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(NovedadConstants.ATTR_FIELD_NOVEDADIDNOVEDAD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getNovedadidNovedad(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(NovedadService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
