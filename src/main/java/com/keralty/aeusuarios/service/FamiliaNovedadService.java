package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FamiliaNovedadConstants;
import com.keralty.aeusuarios.persistence.FamiliaNovedad;
import com.keralty.aeusuarios.persistence.oid.FamiliaNovedadOid;
import com.keralty.aeusuarios.repository.FamiliaNovedadJpaRepository;
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
public class FamiliaNovedadService extends AbstractService {

    FamiliaNovedadJpaRepository repository;

    FamiliaNovedadService familiaNovedadSrv;

    @Inject
    public FamiliaNovedadService(
            FamiliaNovedadService familiaNovedadSrv,
            FamiliaNovedadJpaRepository repository) {
        this.familiaNovedadSrv = familiaNovedadSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of FamiliaNovedad by ID
     *
     * @param familiaNovedadidFamiliaNovedad Identification field familiaNovedadidFamiliaNovedad
     *
     * @return Instance of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaNovedad getById(Long familiaNovedadidFamiliaNovedad) {
        return getByOID(new FamiliaNovedadOid(familiaNovedadidFamiliaNovedad));
    }
    
    /*
     * Returns an instance of FamiliaNovedad by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaNovedad getByOID(FamiliaNovedadOid oid) {
        Optional<FamiliaNovedad> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of FamiliaNovedad by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of FamiliaNovedad
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public FamiliaNovedad getByOIDWithHV(FamiliaNovedadOid oid) {
        Optional<FamiliaNovedad> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<FamiliaNovedad> getInstanceByOid(FamiliaNovedadOid oid) {
        return oid != null && oid.getFamiliaNovedadidFamiliaNovedad() != null
               ? repository.findById(oid.getFamiliaNovedadidFamiliaNovedad())
               : Optional.empty();
    }

    /*
     * Returns an instance of FamiliaNovedad by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of FamiliaNovedad
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public FamiliaNovedad getByJsonOid(String jsonOid) {
        FamiliaNovedadOid oid = new FamiliaNovedadOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            FamiliaNovedadOid oid = new FamiliaNovedadOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(FamiliaNovedadConstants.ATTR_FIELD_FAMILIANOVEDADIDFAMILIANOVEDAD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getFamiliaNovedadidFamiliaNovedad(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(FamiliaNovedadService.class).error(e.getMessage());
        }
    }

}
