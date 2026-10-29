package com.keralty.aeusuarios.service;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.PersonaConstants;
import com.keralty.aeusuarios.persistence.oid.PersonaOid;
import com.keralty.aeusuarios.persistence.Persona;
import com.keralty.aeusuarios.repository.PersonaJpaRepository;
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
public class PersonaService extends AbstractService {

    PersonaJpaRepository repository;

    PersonaService personaSrv;

    @Inject
    public PersonaService(
            PersonaService personaSrv,
            PersonaJpaRepository repository) {
        this.personaSrv = personaSrv;
        this.repository = repository;
    }


    /*
     * Returns an instance of Persona by ID
     *
     * @param personaIdentificador Identification field personaIdentificador
     *
     * @return Instance of Persona
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Persona getById(Long personaIdentificador) {
        return getByOID(new PersonaOid(personaIdentificador));
    }
    
    /*
     * Returns an instance of Persona by OID
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Persona
     */
    @Transactional(Transactional.TxType.REQUIRED)
    public Persona getByOID(PersonaOid oid) {
        Optional<Persona> instance = getInstanceByOid(oid);
        return instance.isPresent() ? instance.get() : null;
    }
    
    /*
     * Returns an instance of Persona by OID applying horizontal visibility constraints
     *
     * @param oid Object IDentifier
     *
     * @return Instance of Persona
     */
    @Transactional(Transactional.TxType.SUPPORTS)
    public Persona getByOIDWithHV(PersonaOid oid) {
        Optional<Persona> instance = getInstanceByOid(oid);
    	return instance.isPresent() && instance.get().checkHorizontalVisibility(getAgentInstance()) 
    		 ? instance.get() 
    		 : null;
    }
    
    private Optional<Persona> getInstanceByOid(PersonaOid oid) {
        return oid != null && oid.getPersonaIdentificador() != null
               ? repository.findById(oid.getPersonaIdentificador())
               : Optional.empty();
    }

    /*
     * Returns an instance of Persona by OID in JSON format
     *
     * @param jsonOid Object IDentifier in JSON format
     *
     * @return Instance of Persona
     */
    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public Persona getByJsonOid(String jsonOid) {
        PersonaOid oid = new PersonaOid();
        oid.fromJsonString(jsonOid);
        return getByOIDWithHV(oid);
    }


    @Override
    protected void applyFilterByOid(String jsonOid, SQLSelect sql) {
        try {
            PersonaOid oid = new PersonaOid().fromJsonString(jsonOid);
            SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
            comparison1.setOperator("=");
            comparison1.setFirstOperand(new SQLWhereOperandPathAttribute(PersonaConstants.ATTR_FIELD_PERSONAIDENTIFICADOR, Constants.Type.AUTONUMERIC.getTypeName()));
            comparison1.setSecondOperand(new SQLWhereOperandLiteral(oid.getPersonaIdentificador(), Constants.Type.AUTONUMERIC.getTypeName()));
            sql.addComparison(comparison1);
        } catch (Exception e) {
            LoggerFactory.getLogger(PersonaService.class).error(e.getMessage());
            throw new SystemException(e.getMessage());
        }
    }

}
