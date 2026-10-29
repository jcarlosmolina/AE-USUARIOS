package com.keralty.aeusuarios.viewmodel.userfunctions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.oid.PersonaOid;
import com.keralty.aeusuarios.persistence.oid.ProteccionDatosOid;
import com.keralty.aeusuarios.persistence.Persona;
import com.keralty.aeusuarios.persistence.ProteccionDatos;
public class FuActualizarPersonaCORERequest {

    @JsonProperty("pfpersona")
    private PersonaOid pfPersona;

    @JsonIgnore
    private Persona pfPersonaInstance;

    @JsonProperty("pfprotdatos")
    private ProteccionDatosOid pfProtDatos;

    @JsonIgnore
    private ProteccionDatos pfProtDatosInstance;

    @JsonProperty("pfnumsolicitud")
    private String pfNumSolicitud;

    public FuActualizarPersonaCORERequest() {
        // Default constructor
    }
    
    @JsonIgnore
    public PersonaOid getPfPersona() {
        return this.pfPersona;
    }
    
    public void setPfPersona(PersonaOid pfPersona) {
        this.pfPersona = pfPersona;
    }

    @JsonIgnore
    public Persona getPfPersonaInstance() {
        if (this.pfPersonaInstance == null)
            this.pfPersonaInstance = new Persona();
        return this.pfPersonaInstance;
    }
    
    public void setPfPersonaInstance(Persona pfPersona) {
        this.pfPersonaInstance = pfPersona;
        this.pfPersona = pfPersona != null ? pfPersona.getOid() : null;
    }
    @JsonIgnore
    public ProteccionDatosOid getPfProtDatos() {
        return this.pfProtDatos;
    }
    
    public void setPfProtDatos(ProteccionDatosOid pfProtDatos) {
        this.pfProtDatos = pfProtDatos;
    }

    @JsonIgnore
    public ProteccionDatos getPfProtDatosInstance() {
        if (this.pfProtDatosInstance == null)
            this.pfProtDatosInstance = new ProteccionDatos();
        return this.pfProtDatosInstance;
    }
    
    public void setPfProtDatosInstance(ProteccionDatos pfProtDatos) {
        this.pfProtDatosInstance = pfProtDatos;
        this.pfProtDatos = pfProtDatos != null ? pfProtDatos.getOid() : null;
    }
    @JsonIgnore
    public String getPfNumSolicitud() {
        return this.pfNumSolicitud;
    }
    
    public void setPfNumSolicitud(String pfNumSolicitud) {
        this.pfNumSolicitud = pfNumSolicitud;
    }
}
