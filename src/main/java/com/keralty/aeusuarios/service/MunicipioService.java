package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.MunicipioConstants;
import com.keralty.aeusuarios.persistence.Municipio;
import com.keralty.aeusuarios.persistence.oid.MunicipioOid;
import com.keralty.aeusuarios.repository.MunicipioJpaRepository;
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
public class MunicipioService extends AbstractService {

    MunicipioJpaRepository repository;

    MunicipioService municipioSrv;

    @Inject
    public MunicipioService(
            MunicipioService municipioSrv,
            MunicipioJpaRepository repository) {
        this.municipioSrv = municipioSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Municipio by ID
     *
     * @param municipioCodigo Identification field municipioCodigo
     *
     * @return Instance of Municipio
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Municipio getById(Long municipioCodigo) {
        return getByOID(new MunicipioOid(municipioCodigo));
    }
    
    /*
     * Returns an instance of Municipio by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Municipio
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Municipio getByOID(MunicipioOid oid) {
        Optional<Municipio> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Municipio by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Municipio
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Municipio getByOIDWithHV(MunicipioOid oid) {
        Optional<Municipio> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Municipio> getInstanceByOid(MunicipioOid oid) {
        return oid != null && oid.getMunicipioCodigo() != null
               ? repository.findById(oid.getMunicipioCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Municipio by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Municipio
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Municipio getByJsonOid(String jsonOid) {
        MunicipioOid oid = new MunicipioOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            MunicipioOid oid = new MunicipioOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(MunicipioConstants.ATTR_FIELD_MUNICIPIOCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getMunicipioCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(MunicipioService.class).error(e.getMessage());
        }
    }

}
