package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TMODIFICARASESORRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTMODIFICARASESORpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTMODIFICARASESORpthisAsesorInstance;

    @JsonProperty("pt_p_moddbasicospersona")
    private Boolean asesorTMODIFICARASESORptpModDBasicosPersona;

    @JsonProperty("pmodificadirector")
    private Boolean asesorTMODIFICARASESORpModificaDirector;

    @JsonProperty("ptusuarioldap")
    private String asesorTMODIFICARASESORptUsuarioLDAP;

    @JsonProperty("ptemail")
    private String asesorTMODIFICARASESORptEmail;

    @JsonProperty("peintegral")
    private Boolean asesorTMODIFICARASESORpeIntegral;

    @JsonProperty("pt_pverdbasicospersona")
    private Boolean asesorTMODIFICARASESORptpVerDBasicosPersona;

    @JsonProperty("pt_pverdocspersona")
    private Boolean asesorTMODIFICARASESORptpVerDocsPersona;

    @JsonProperty("pt_pvercontratonovedad")
    private Boolean asesorTMODIFICARASESORptpVerContratoNovedad;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTMODIFICARASESORpthisAsesor();
        checkAsesorTMODIFICARASESORptpModDBasicosPersona();
        checkAsesorTMODIFICARASESORpModificaDirector();
        checkAsesorTMODIFICARASESORpeIntegral();
        checkAsesorTMODIFICARASESORptpVerDBasicosPersona();
        checkAsesorTMODIFICARASESORptpVerDocsPersona();
        checkAsesorTMODIFICARASESORptpVerContratoNovedad();
    }

    @JsonIgnore
    public AsesorOid getAsesorTMODIFICARASESORpthisAsesor() {
        return this.asesorTMODIFICARASESORpthisAsesor;
    }
    
    public void setAsesorTMODIFICARASESORpthisAsesor(AsesorOid asesorTMODIFICARASESORpthisAsesor) {
        this.asesorTMODIFICARASESORpthisAsesor = asesorTMODIFICARASESORpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTMODIFICARASESORpthisAsesorInstance() {
        return this.asesorTMODIFICARASESORpthisAsesorInstance;
    }
    
    public void setAsesorTMODIFICARASESORpthisAsesorInstance(Asesor asesorTMODIFICARASESORpthisAsesor) {
        this.asesorTMODIFICARASESORpthisAsesorInstance = asesorTMODIFICARASESORpthisAsesor;
        this.asesorTMODIFICARASESORpthisAsesor = asesorTMODIFICARASESORpthisAsesor != null ? asesorTMODIFICARASESORpthisAsesor.getOid() : null;
    }

    private void checkAsesorTMODIFICARASESORpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORpthisAsesorInstance() == null || this.getAsesorTMODIFICARASESORpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESOR_ASESORTMODIFICARASESORPTHISASESOR, AsesorConstants.SERV_ALIAS_TMODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESOR_ASESORTMODIFICARASESORPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORptpModDBasicosPersona() {
        return this.asesorTMODIFICARASESORptpModDBasicosPersona;
    }
    
    public void setAsesorTMODIFICARASESORptpModDBasicosPersona(Boolean asesorTMODIFICARASESORptpModDBasicosPersona) {
        this.asesorTMODIFICARASESORptpModDBasicosPersona = asesorTMODIFICARASESORptpModDBasicosPersona;
    }

    private void checkAsesorTMODIFICARASESORptpModDBasicosPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORptpModDBasicosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPMODDBASICOSPERSONA, AsesorConstants.SERV_ALIAS_TMODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPMODDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORpModificaDirector() {
        return this.asesorTMODIFICARASESORpModificaDirector;
    }
    
    public void setAsesorTMODIFICARASESORpModificaDirector(Boolean asesorTMODIFICARASESORpModificaDirector) {
        this.asesorTMODIFICARASESORpModificaDirector = asesorTMODIFICARASESORpModificaDirector;
    }

    private void checkAsesorTMODIFICARASESORpModificaDirector() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORpModificaDirector() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESOR_ASESORTMODIFICARASESORPMODIFICADIRECTOR, AsesorConstants.SERV_ALIAS_TMODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESOR_ASESORTMODIFICARASESORPMODIFICADIRECTOR);
        }
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORptUsuarioLDAP() {
        return this.asesorTMODIFICARASESORptUsuarioLDAP;
    }
    
    public void setAsesorTMODIFICARASESORptUsuarioLDAP(String asesorTMODIFICARASESORptUsuarioLDAP) {
        this.asesorTMODIFICARASESORptUsuarioLDAP = asesorTMODIFICARASESORptUsuarioLDAP;
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORptEmail() {
        return this.asesorTMODIFICARASESORptEmail;
    }
    
    public void setAsesorTMODIFICARASESORptEmail(String asesorTMODIFICARASESORptEmail) {
        this.asesorTMODIFICARASESORptEmail = asesorTMODIFICARASESORptEmail;
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORpeIntegral() {
        return this.asesorTMODIFICARASESORpeIntegral;
    }
    
    public void setAsesorTMODIFICARASESORpeIntegral(Boolean asesorTMODIFICARASESORpeIntegral) {
        this.asesorTMODIFICARASESORpeIntegral = asesorTMODIFICARASESORpeIntegral;
    }

    private void checkAsesorTMODIFICARASESORpeIntegral() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORpeIntegral() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESOR_ASESORTMODIFICARASESORPEINTEGRAL, AsesorConstants.SERV_ALIAS_TMODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESOR_ASESORTMODIFICARASESORPEINTEGRAL);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORptpVerDBasicosPersona() {
        return this.asesorTMODIFICARASESORptpVerDBasicosPersona;
    }
    
    public void setAsesorTMODIFICARASESORptpVerDBasicosPersona(Boolean asesorTMODIFICARASESORptpVerDBasicosPersona) {
        this.asesorTMODIFICARASESORptpVerDBasicosPersona = asesorTMODIFICARASESORptpVerDBasicosPersona;
    }

    private void checkAsesorTMODIFICARASESORptpVerDBasicosPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORptpVerDBasicosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPVERDBASICOSPERSONA, AsesorConstants.SERV_ALIAS_TMODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPVERDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORptpVerDocsPersona() {
        return this.asesorTMODIFICARASESORptpVerDocsPersona;
    }
    
    public void setAsesorTMODIFICARASESORptpVerDocsPersona(Boolean asesorTMODIFICARASESORptpVerDocsPersona) {
        this.asesorTMODIFICARASESORptpVerDocsPersona = asesorTMODIFICARASESORptpVerDocsPersona;
    }

    private void checkAsesorTMODIFICARASESORptpVerDocsPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORptpVerDocsPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPVERDOCSPERSONA, AsesorConstants.SERV_ALIAS_TMODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORptpVerContratoNovedad() {
        return this.asesorTMODIFICARASESORptpVerContratoNovedad;
    }
    
    public void setAsesorTMODIFICARASESORptpVerContratoNovedad(Boolean asesorTMODIFICARASESORptpVerContratoNovedad) {
        this.asesorTMODIFICARASESORptpVerContratoNovedad = asesorTMODIFICARASESORptpVerContratoNovedad;
    }

    private void checkAsesorTMODIFICARASESORptpVerContratoNovedad() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORptpVerContratoNovedad() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPVERCONTRATONOVEDAD, AsesorConstants.SERV_ALIAS_TMODIFICARASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESOR_ASESORTMODIFICARASESORPTPVERCONTRATONOVEDAD);
        }
    }
}
