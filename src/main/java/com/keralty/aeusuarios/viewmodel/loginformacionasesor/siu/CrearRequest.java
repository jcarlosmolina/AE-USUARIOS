package com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogInformacionAsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class CrearRequest {

    @JsonProperty("p_agrasesor_oid")
    private AsesorOid logInformacionAsesorcrearpagrAsesor;
    
    @JsonIgnore
    private Asesor logInformacionAsesorcrearpagrAsesorInstance;

    @JsonProperty("p_atrverdatospersona")
    private Boolean logInformacionAsesorcrearpatrVerDatosPersona;

    @JsonProperty("p_atrverdocspersona")
    private Boolean logInformacionAsesorcrearpatrVerDocsPersona;

    @JsonProperty("p_atrvercontratonovedad")
    private Boolean logInformacionAsesorcrearpatrVerContratoNovedad;

    @JsonProperty("p_atrloginfuncionario")
    private String logInformacionAsesorcrearpatrLoginFuncionario;

    @JsonProperty("p_atraccesovalidadorusuarios")
    private Boolean logInformacionAsesorcrearpatrAccesoValidadorUsuarios;

    public void checkArguments() throws NotNullArgumentException {
        checkLogInformacionAsesorcrearpagrAsesor();
        checkLogInformacionAsesorcrearpatrVerDatosPersona();
        checkLogInformacionAsesorcrearpatrVerDocsPersona();
        checkLogInformacionAsesorcrearpatrVerContratoNovedad();
        checkLogInformacionAsesorcrearpatrLoginFuncionario();
        checkLogInformacionAsesorcrearpatrAccesoValidadorUsuarios();
    }

    @JsonIgnore
    public AsesorOid getLogInformacionAsesorcrearpagrAsesor() {
        return this.logInformacionAsesorcrearpagrAsesor;
    }
    
    public void setLogInformacionAsesorcrearpagrAsesor(AsesorOid logInformacionAsesorcrearpagrAsesor) {
        this.logInformacionAsesorcrearpagrAsesor = logInformacionAsesorcrearpagrAsesor;
    }

    @JsonIgnore
    public Asesor getLogInformacionAsesorcrearpagrAsesorInstance() {
        return this.logInformacionAsesorcrearpagrAsesorInstance;
    }
    
    public void setLogInformacionAsesorcrearpagrAsesorInstance(Asesor logInformacionAsesorcrearpagrAsesor) {
        this.logInformacionAsesorcrearpagrAsesorInstance = logInformacionAsesorcrearpagrAsesor;
        this.logInformacionAsesorcrearpagrAsesor = logInformacionAsesorcrearpagrAsesor != null ? logInformacionAsesorcrearpagrAsesor.getOid() : null;
    }

    private void checkLogInformacionAsesorcrearpagrAsesor() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorcrearpagrAsesorInstance() == null || this.getLogInformacionAsesorcrearpagrAsesorInstance().isNull()) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_CREAR, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_CREAR_LOGINFORMACIONASESORCREARPAGRASESOR, LogInformacionAsesorConstants.SERV_ALIAS_CREAR, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_CREAR_LOGINFORMACIONASESORCREARPAGRASESOR);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorcrearpatrVerDatosPersona() {
        return this.logInformacionAsesorcrearpatrVerDatosPersona;
    }
    
    public void setLogInformacionAsesorcrearpatrVerDatosPersona(Boolean logInformacionAsesorcrearpatrVerDatosPersona) {
        this.logInformacionAsesorcrearpatrVerDatosPersona = logInformacionAsesorcrearpatrVerDatosPersona;
    }

    private void checkLogInformacionAsesorcrearpatrVerDatosPersona() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorcrearpatrVerDatosPersona() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_CREAR, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_CREAR_LOGINFORMACIONASESORCREARPATRVERDATOSPERSONA, LogInformacionAsesorConstants.SERV_ALIAS_CREAR, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_CREAR_LOGINFORMACIONASESORCREARPATRVERDATOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorcrearpatrVerDocsPersona() {
        return this.logInformacionAsesorcrearpatrVerDocsPersona;
    }
    
    public void setLogInformacionAsesorcrearpatrVerDocsPersona(Boolean logInformacionAsesorcrearpatrVerDocsPersona) {
        this.logInformacionAsesorcrearpatrVerDocsPersona = logInformacionAsesorcrearpatrVerDocsPersona;
    }

    private void checkLogInformacionAsesorcrearpatrVerDocsPersona() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorcrearpatrVerDocsPersona() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_CREAR, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_CREAR_LOGINFORMACIONASESORCREARPATRVERDOCSPERSONA, LogInformacionAsesorConstants.SERV_ALIAS_CREAR, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_CREAR_LOGINFORMACIONASESORCREARPATRVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorcrearpatrVerContratoNovedad() {
        return this.logInformacionAsesorcrearpatrVerContratoNovedad;
    }
    
    public void setLogInformacionAsesorcrearpatrVerContratoNovedad(Boolean logInformacionAsesorcrearpatrVerContratoNovedad) {
        this.logInformacionAsesorcrearpatrVerContratoNovedad = logInformacionAsesorcrearpatrVerContratoNovedad;
    }

    private void checkLogInformacionAsesorcrearpatrVerContratoNovedad() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorcrearpatrVerContratoNovedad() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_CREAR, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_CREAR_LOGINFORMACIONASESORCREARPATRVERCONTRATONOVEDAD, LogInformacionAsesorConstants.SERV_ALIAS_CREAR, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_CREAR_LOGINFORMACIONASESORCREARPATRVERCONTRATONOVEDAD);
        }
    }

    @JsonIgnore
    public String getLogInformacionAsesorcrearpatrLoginFuncionario() {
        return this.logInformacionAsesorcrearpatrLoginFuncionario;
    }
    
    public void setLogInformacionAsesorcrearpatrLoginFuncionario(String logInformacionAsesorcrearpatrLoginFuncionario) {
        this.logInformacionAsesorcrearpatrLoginFuncionario = logInformacionAsesorcrearpatrLoginFuncionario;
    }

    private void checkLogInformacionAsesorcrearpatrLoginFuncionario() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorcrearpatrLoginFuncionario() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_CREAR, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_CREAR_LOGINFORMACIONASESORCREARPATRLOGINFUNCIONARIO, LogInformacionAsesorConstants.SERV_ALIAS_CREAR, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_CREAR_LOGINFORMACIONASESORCREARPATRLOGINFUNCIONARIO);
        }
    }

    @JsonIgnore
    public Boolean getLogInformacionAsesorcrearpatrAccesoValidadorUsuarios() {
        return this.logInformacionAsesorcrearpatrAccesoValidadorUsuarios;
    }
    
    public void setLogInformacionAsesorcrearpatrAccesoValidadorUsuarios(Boolean logInformacionAsesorcrearpatrAccesoValidadorUsuarios) {
        this.logInformacionAsesorcrearpatrAccesoValidadorUsuarios = logInformacionAsesorcrearpatrAccesoValidadorUsuarios;
    }

    private void checkLogInformacionAsesorcrearpatrAccesoValidadorUsuarios() throws NotNullArgumentException {
        if(this.getLogInformacionAsesorcrearpatrAccesoValidadorUsuarios() == null) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_CREAR, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_CREAR_LOGINFORMACIONASESORCREARPATRACCESOVALIDADORUSUARIOS, LogInformacionAsesorConstants.SERV_ALIAS_CREAR, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_CREAR_LOGINFORMACIONASESORCREARPATRACCESOVALIDADORUSUARIOS);
        }
    }
}
