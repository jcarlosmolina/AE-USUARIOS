package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AesolicitudesConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.ContratanteConstants;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.persistence.Contratante;
import com.keralty.aeusuarios.persistence.oid.ContratanteOid;
import com.keralty.aeusuarios.repository.ContratanteJpaRepository;
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
public class ContratanteService extends AbstractService {

    ContratanteJpaRepository repository;

    ContratanteService contratanteSrv;

    @Inject
    public ContratanteService(
            ContratanteService contratanteSrv,
            ContratanteJpaRepository repository) {
        this.contratanteSrv = contratanteSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Contratante by ID
     *
     * @param aesolicitudesidsolicitud Identification field aesolicitudesidsolicitud
     *
     * @return Instance of Contratante
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Contratante getById(Long aesolicitudesidsolicitud) {
        return getByOID(new ContratanteOid(aesolicitudesidsolicitud));
    }
    
    /*
     * Returns an instance of Contratante by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Contratante
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Contratante getByOID(ContratanteOid oid) {
        Optional<Contratante> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Contratante by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Contratante
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Contratante getByOIDWithHV(ContratanteOid oid) {
        Optional<Contratante> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Contratante> getInstanceByOid(ContratanteOid oid) {
        return oid != null && oid.getAesolicitudesidsolicitud() != null
               ? repository.findById(oid.getAesolicitudesidsolicitud())
               : Optional.empty();
    }

    /*
     * Returns an instance of Contratante by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Contratante
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Contratante getByJsonOid(String jsonOid) {
        ContratanteOid oid = new ContratanteOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            ContratanteOid oid = new ContratanteOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(ContratanteConstants.ROLE_NAME_SOLICITUD + "." + SolicitudConstants.ROLE_NAME_AESOLICITUDES + "." + AesolicitudesConstants.ATTR_FIELD_AESOLICITUDESIDSOLICITUD, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getAesolicitudesidsolicitud(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(ContratanteService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
