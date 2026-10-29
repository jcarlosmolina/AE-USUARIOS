package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AnexoMatConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.persistence.AnexoMat;
import com.keralty.aeusuarios.persistence.oid.AnexoMatOid;
import com.keralty.aeusuarios.repository.AnexoMatJpaRepository;
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
public class AnexoMatService extends AbstractService {

    AnexoMatJpaRepository repository;

    AnexoMatService anexoMatSrv;

    @Inject
    public AnexoMatService(
            AnexoMatService anexoMatSrv,
            AnexoMatJpaRepository repository) {
        this.anexoMatSrv = anexoMatSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of AnexoMat by ID
     *
     * @param anexoMatIdentificador Identification field anexoMatIdentificador
     *
     * @return Instance of AnexoMat
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AnexoMat getById(Long anexoMatIdentificador) {
        return getByOID(new AnexoMatOid(anexoMatIdentificador));
    }
    
    /*
     * Returns an instance of AnexoMat by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoMat
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public AnexoMat getByOID(AnexoMatOid oid) {
        Optional<AnexoMat> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of AnexoMat by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of AnexoMat
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public AnexoMat getByOIDWithHV(AnexoMatOid oid) {
        Optional<AnexoMat> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<AnexoMat> getInstanceByOid(AnexoMatOid oid) {
        return oid != null && oid.getAnexoMatIdentificador() != null
               ? repository.findById(oid.getAnexoMatIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of AnexoMat by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of AnexoMat
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public AnexoMat getByJsonOid(String jsonOid) {
        AnexoMatOid oid = new AnexoMatOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            AnexoMatOid oid = new AnexoMatOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(AnexoMatConstants.ATTR_FIELD_ANEXOMATIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAnexoMatIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(AnexoMatService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
