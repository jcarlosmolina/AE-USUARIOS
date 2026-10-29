package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class ModificarAsesorRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesormodificarAsesorpthisAsesor;
    
    @JsonIgnore
    private Asesor asesormodificarAsesorpthisAsesorInstance;

    @JsonProperty("p_moddbasicospersona")
    private Boolean asesormodificarAsesorpModDBasicosPersona;

    @JsonProperty("pmodificadirector")
    private Boolean asesormodificarAsesorpModificaDirector;

    @JsonProperty("ptusuarioldap")
    private String asesormodificarAsesorptUsuarioLDAP;

    @JsonProperty("ptemail")
    private String asesormodificarAsesorptEmail;

    @JsonProperty("ptnumidentificacion")
    private String asesormodificarAsesorptNumIdentificacion;

    @JsonProperty("peintegral")
    private Boolean asesormodificarAsesorpeIntegral;

    @JsonProperty("pevalidadorusuarios")
    private Boolean asesormodificarAsesorpeValidadorUsuarios;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesormodificarAsesorpthisAsesor();
        checkAsesormodificarAsesorpModDBasicosPersona();
        checkAsesormodificarAsesorpModificaDirector();
        checkAsesormodificarAsesorpeIntegral();
        checkAsesormodificarAsesorpeValidadorUsuarios();
    }

    @JsonIgnore
    public AsesorOid getAsesormodificarAsesorpthisAsesor() {
        return this.asesormodificarAsesorpthisAsesor;
    }
    
    public void setAsesormodificarAsesorpthisAsesor(AsesorOid asesormodificarAsesorpthisAsesor) {
        this.asesormodificarAsesorpthisAsesor = asesormodificarAsesorpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesormodificarAsesorpthisAsesorInstance() {
        return this.asesormodificarAsesorpthisAsesorInstance;
    }
    
    public void setAsesormodificarAsesorpthisAsesorInstance(Asesor asesormodificarAsesorpthisAsesor) {
        this.asesormodificarAsesorpthisAsesorInstance = asesormodificarAsesorpthisAsesor;
        this.asesormodificarAsesorpthisAsesor = asesormodificarAsesorpthisAsesor != null ? asesormodificarAsesorpthisAsesor.getOid() : null;
    }

    private void checkAsesormodificarAsesorpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesormodificarAsesorpthisAsesorInstance() == null || this.getAsesormodificarAsesorpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODIFICARASESOR_ASESORMODIFICARASESORPTHISASESOR, AsesorConstants.SERV_ALIAS_MODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODIFICARASESOR_ASESORMODIFICARASESORPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesormodificarAsesorpModDBasicosPersona() {
        return this.asesormodificarAsesorpModDBasicosPersona;
    }
    
    public void setAsesormodificarAsesorpModDBasicosPersona(Boolean asesormodificarAsesorpModDBasicosPersona) {
        this.asesormodificarAsesorpModDBasicosPersona = asesormodificarAsesorpModDBasicosPersona;
    }

    private void checkAsesormodificarAsesorpModDBasicosPersona() throws NotNullArgumentException {
        if(this.getAsesormodificarAsesorpModDBasicosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODIFICARASESOR_ASESORMODIFICARASESORPMODDBASICOSPERSONA, AsesorConstants.SERV_ALIAS_MODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODIFICARASESOR_ASESORMODIFICARASESORPMODDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesormodificarAsesorpModificaDirector() {
        return this.asesormodificarAsesorpModificaDirector;
    }
    
    public void setAsesormodificarAsesorpModificaDirector(Boolean asesormodificarAsesorpModificaDirector) {
        this.asesormodificarAsesorpModificaDirector = asesormodificarAsesorpModificaDirector;
    }

    private void checkAsesormodificarAsesorpModificaDirector() throws NotNullArgumentException {
        if(this.getAsesormodificarAsesorpModificaDirector() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODIFICARASESOR_ASESORMODIFICARASESORPMODIFICADIRECTOR, AsesorConstants.SERV_ALIAS_MODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODIFICARASESOR_ASESORMODIFICARASESORPMODIFICADIRECTOR);
        }
    }

    @JsonIgnore
    public String getAsesormodificarAsesorptUsuarioLDAP() {
        return this.asesormodificarAsesorptUsuarioLDAP;
    }
    
    public void setAsesormodificarAsesorptUsuarioLDAP(String asesormodificarAsesorptUsuarioLDAP) {
        this.asesormodificarAsesorptUsuarioLDAP = asesormodificarAsesorptUsuarioLDAP;
    }

    @JsonIgnore
    public String getAsesormodificarAsesorptEmail() {
        return this.asesormodificarAsesorptEmail;
    }
    
    public void setAsesormodificarAsesorptEmail(String asesormodificarAsesorptEmail) {
        this.asesormodificarAsesorptEmail = asesormodificarAsesorptEmail;
    }

    @JsonIgnore
    public String getAsesormodificarAsesorptNumIdentificacion() {
        return this.asesormodificarAsesorptNumIdentificacion;
    }
    
    public void setAsesormodificarAsesorptNumIdentificacion(String asesormodificarAsesorptNumIdentificacion) {
        this.asesormodificarAsesorptNumIdentificacion = asesormodificarAsesorptNumIdentificacion;
    }

    @JsonIgnore
    public Boolean getAsesormodificarAsesorpeIntegral() {
        return this.asesormodificarAsesorpeIntegral;
    }
    
    public void setAsesormodificarAsesorpeIntegral(Boolean asesormodificarAsesorpeIntegral) {
        this.asesormodificarAsesorpeIntegral = asesormodificarAsesorpeIntegral;
    }

    private void checkAsesormodificarAsesorpeIntegral() throws NotNullArgumentException {
        if(this.getAsesormodificarAsesorpeIntegral() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODIFICARASESOR_ASESORMODIFICARASESORPEINTEGRAL, AsesorConstants.SERV_ALIAS_MODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODIFICARASESOR_ASESORMODIFICARASESORPEINTEGRAL);
        }
    }

    @JsonIgnore
    public Boolean getAsesormodificarAsesorpeValidadorUsuarios() {
        return this.asesormodificarAsesorpeValidadorUsuarios;
    }
    
    public void setAsesormodificarAsesorpeValidadorUsuarios(Boolean asesormodificarAsesorpeValidadorUsuarios) {
        this.asesormodificarAsesorpeValidadorUsuarios = asesormodificarAsesorpeValidadorUsuarios;
    }

    private void checkAsesormodificarAsesorpeValidadorUsuarios() throws NotNullArgumentException {
        if(this.getAsesormodificarAsesorpeValidadorUsuarios() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODIFICARASESOR_ASESORMODIFICARASESORPEVALIDADORUSUARIOS, AsesorConstants.SERV_ALIAS_MODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODIFICARASESOR_ASESORMODIFICARASESORPEVALIDADORUSUARIOS);
        }
    }
}
