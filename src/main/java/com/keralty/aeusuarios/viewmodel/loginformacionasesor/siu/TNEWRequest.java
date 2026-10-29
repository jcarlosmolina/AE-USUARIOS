package com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogInformacionAsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TNEWRequest {

    @JsonProperty("pt_p_agrasesor_oid")
    private AsesorOid logInformacionAsesorTNEWptpagrAsesor;
    
    @JsonIgnore
    private Asesor logInformacionAsesorTNEWptpagrAsesorInstance;

    @JsonProperty("pt_p_atrverdatospersona")
    private Boolean logInformacionAsesorTNEWptpatrVerDatosPersona;

    @JsonProperty("pt_p_atrverdocspersona")
    private Boolean logInformacionAsesorTNEWptpatrVerDocsPersona;

    @JsonProperty("pt_p_atrvercontratonovedad")
    private Boolean logInformacionAsesorTNEWptpatrVerContratoNovedad;

    @JsonProperty("p_atraccesovalidadorusuarios")
    private Boolean logInformacionAsesorTNEWpatrAccesoValidadorUsuarios;

    public void checkArguments() throws NotNullArgumentException {
        checkLogInformacionAsesorTNEWptpagrAsesor();
        checkLogInformacionAsesorTNEWptpatrVerDatosPersona();
        checkLogInformacionAsesorTNEWptpatrVerDocsPersona();
        checkLogInformacionAsesorTNEWptpatrVerContratoNovedad();
        checkLogInformacionAsesorTNEWpatrAccesoValidadorUsuarios();
    }

    @JsonIgnore
    public AsesorOid getLogInformacionAsesorTNEWptpagrAsesor() {
        return this.logInformacionAsesorTNEWptpagrAsesor;
    }
    
    public void setLogInformacionAsesorTNEWptpagrAsesor(AsesorOid logInformacionAsesorTNEWptpagrAsesor) {
        this.logInformacionAsesorTNEWptpagrAsesor = logInformacionAsesorTNEWptpagrAsesor;
    }

    @JsonIgnore
    public Asesor getLogInformacionAsesorTNEWptpagrAsesorInstance() {
        return this.logInformacionAsesorTNEWptpagrAsesorInstance;
    }
    
    public void setLogInformacionAsesorTNEWptpagrAsesorInstance(Asesor logInformacionAsesorTNEWptpagrAsesor) {
        this.logInformacionAsesorTNEWptpagrAsesorInstance = logInformacionAsesorTNEWptpagrAsesor;
        this.logInformacionAsesorTNEWptpagrAsesor = logInformacionAsesorTNEWptpagrAsesor != null ? logInformacionAsesorTNEWptpagrAsesor.getOid() : null;
    }

    private void checkLogInformacionAsesorTNEWptpagrAsesor() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorTNEWptpagrAsesorInstance() == null || this.getLogInformacionAsesorTNEWptpagrAsesorInstance().isNull()) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_TNEW, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_TNEW_LOGINFORMACIONASESORTNEWPTPAGRASESOR, LogInformacionAsesorConstants.SERV_ALIAS_TNEW, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_TNEW_LOGINFORMACIONASESORTNEWPTPAGRASESOR);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorTNEWptpatrVerDatosPersona() {
        return this.logInformacionAsesorTNEWptpatrVerDatosPersona;
    }
    
    public void setLogInformacionAsesorTNEWptpatrVerDatosPersona(Boolean logInformacionAsesorTNEWptpatrVerDatosPersona) {
        this.logInformacionAsesorTNEWptpatrVerDatosPersona = logInformacionAsesorTNEWptpatrVerDatosPersona;
    }

    private void checkLogInformacionAsesorTNEWptpatrVerDatosPersona() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorTNEWptpatrVerDatosPersona() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_TNEW, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_TNEW_LOGINFORMACIONASESORTNEWPTPATRVERDATOSPERSONA, LogInformacionAsesorConstants.SERV_ALIAS_TNEW, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_TNEW_LOGINFORMACIONASESORTNEWPTPATRVERDATOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorTNEWptpatrVerDocsPersona() {
        return this.logInformacionAsesorTNEWptpatrVerDocsPersona;
    }
    
    public void setLogInformacionAsesorTNEWptpatrVerDocsPersona(Boolean logInformacionAsesorTNEWptpatrVerDocsPersona) {
        this.logInformacionAsesorTNEWptpatrVerDocsPersona = logInformacionAsesorTNEWptpatrVerDocsPersona;
    }

    private void checkLogInformacionAsesorTNEWptpatrVerDocsPersona() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorTNEWptpatrVerDocsPersona() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_TNEW, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_TNEW_LOGINFORMACIONASESORTNEWPTPATRVERDOCSPERSONA, LogInformacionAsesorConstants.SERV_ALIAS_TNEW, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_TNEW_LOGINFORMACIONASESORTNEWPTPATRVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorTNEWptpatrVerContratoNovedad() {
        return this.logInformacionAsesorTNEWptpatrVerContratoNovedad;
    }
    
    public void setLogInformacionAsesorTNEWptpatrVerContratoNovedad(Boolean logInformacionAsesorTNEWptpatrVerContratoNovedad) {
        this.logInformacionAsesorTNEWptpatrVerContratoNovedad = logInformacionAsesorTNEWptpatrVerContratoNovedad;
    }

    private void checkLogInformacionAsesorTNEWptpatrVerContratoNovedad() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorTNEWptpatrVerContratoNovedad() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_TNEW, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_TNEW_LOGINFORMACIONASESORTNEWPTPATRVERCONTRATONOVEDAD, LogInformacionAsesorConstants.SERV_ALIAS_TNEW, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_TNEW_LOGINFORMACIONASESORTNEWPTPATRVERCONTRATONOVEDAD);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorTNEWpatrAccesoValidadorUsuarios() {
        return this.logInformacionAsesorTNEWpatrAccesoValidadorUsuarios;
    }
    
    public void setLogInformacionAsesorTNEWpatrAccesoValidadorUsuarios(Boolean logInformacionAsesorTNEWpatrAccesoValidadorUsuarios) {
        this.logInformacionAsesorTNEWpatrAccesoValidadorUsuarios = logInformacionAsesorTNEWpatrAccesoValidadorUsuarios;
    }

    private void checkLogInformacionAsesorTNEWpatrAccesoValidadorUsuarios() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorTNEWpatrAccesoValidadorUsuarios() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_TNEW, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_TNEW_LOGINFORMACIONASESORTNEWPATRACCESOVALIDADORUSUARIOS, LogInformacionAsesorConstants.SERV_ALIAS_TNEW, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_TNEW_LOGINFORMACIONASESORTNEWPATRACCESOVALIDADORUSUARIOS);
        }
    }
}
