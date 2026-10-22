package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.PersonaCConstants;
import com.keralty.aeusuarios.persistence.oid.PersonaCOid;
import com.keralty.aeusuarios.persistence.PersonaC;
import com.keralty.aeusuarios.repository.PersonaCJpaRepository;
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
public class PersonaCService extends AbstractService {

    PersonaCJpaRepository repository;

    PersonaCService personaCSrv;

    @Inject
    public PersonaCService(
            PersonaCService personaCSrv,
            PersonaCJpaRepository repository) {
        this.personaCSrv = personaCSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of PersonaC by ID
     *
     * @param personaCID Identification field personaCID
     *
     * @return Instance of PersonaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public PersonaC getById(Long personaCID) {
        return getByOID(new PersonaCOid(personaCID));
    }
    
    /*
     * Returns an instance of PersonaC by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PersonaC
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public PersonaC getByOID(PersonaCOid oid) {
        Optional<PersonaC> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of PersonaC by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of PersonaC
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public PersonaC getByOIDWithHV(PersonaCOid oid) {
        Optional<PersonaC> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<PersonaC> getInstanceByOid(PersonaCOid oid) {
        return oid != null && oid.getPersonaCID() != null
               ? repository.findById(oid.getPersonaCID())
               : Optional.empty();
    }

    /*
     * Returns an instance of PersonaC by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of PersonaC
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public PersonaC getByJsonOid(String jsonOid) {
        PersonaCOid oid = new PersonaCOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PersonaCOid oid = new PersonaCOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PersonaCConstants.ATTR_FIELD_PERSONACID, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPersonaCID(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PersonaCService.class).error(e.getMessage());
        }
    }

}
