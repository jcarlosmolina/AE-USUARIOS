package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.DepartamentoConstants;
import com.keralty.aeusuarios.persistence.Departamento;
import com.keralty.aeusuarios.persistence.oid.DepartamentoOid;
import com.keralty.aeusuarios.repository.DepartamentoJpaRepository;
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
public class DepartamentoService extends AbstractService {

    DepartamentoJpaRepository repository;

    DepartamentoService departamentoSrv;

    @Inject
    public DepartamentoService(
            DepartamentoService departamentoSrv,
            DepartamentoJpaRepository repository) {
        this.departamentoSrv = departamentoSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Departamento by ID
     *
     * @param departamentoCodigo Identification field departamentoCodigo
     *
     * @return Instance of Departamento
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Departamento getById(Long departamentoCodigo) {
        return getByOID(new DepartamentoOid(departamentoCodigo));
    }
    
    /*
     * Returns an instance of Departamento by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Departamento
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Departamento getByOID(DepartamentoOid oid) {
        Optional<Departamento> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Departamento by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Departamento
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Departamento getByOIDWithHV(DepartamentoOid oid) {
        Optional<Departamento> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Departamento> getInstanceByOid(DepartamentoOid oid) {
        return oid != null && oid.getDepartamentoCodigo() != null
               ? repository.findById(oid.getDepartamentoCodigo())
               : Optional.empty();
    }

    /*
     * Returns an instance of Departamento by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Departamento
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Departamento getByJsonOid(String jsonOid) {
        DepartamentoOid oid = new DepartamentoOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            DepartamentoOid oid = new DepartamentoOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(DepartamentoConstants.ATTR_FIELD_DEPARTAMENTOCODIGO, Constants.Type.INT.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getDepartamentoCodigo(), Constants.Type.INT.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(DepartamentoService.class).error(e.getMessage());
        }
    }

}
