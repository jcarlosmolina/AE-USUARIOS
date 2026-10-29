package com.keralty.aeusuarios.viewmodel.logfuncionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogFuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class CrearRequest {

    @JsonProperty("p_agrfuncionario_oid")
    private FuncionarioOid logFuncionariocrearpagrFuncionario;
    
    @JsonIgnore
    private Funcionario logFuncionariocrearpagrFuncionarioInstance;

    @JsonProperty("p_atrloginfuncionario")
    private String logFuncionariocrearpatrLoginFuncionario;

    @JsonProperty("p_atrdisponible")
    private Boolean logFuncionariocrearpatrDisponible;

    public void checkArguments() throws NotNullArgumentException {
        checkLogFuncionariocrearpagrFuncionario();
        checkLogFuncionariocrearpatrLoginFuncionario();
        checkLogFuncionariocrearpatrDisponible();
    }

    @JsonIgnore
    public FuncionarioOid getLogFuncionariocrearpagrFuncionario() {
        return this.logFuncionariocrearpagrFuncionario;
    }
    
    public void setLogFuncionariocrearpagrFuncionario(FuncionarioOid logFuncionariocrearpagrFuncionario) {
        this.logFuncionariocrearpagrFuncionario = logFuncionariocrearpagrFuncionario;
    }

    @JsonIgnore
    public Funcionario getLogFuncionariocrearpagrFuncionarioInstance() {
        return this.logFuncionariocrearpagrFuncionarioInstance;
    }
    
    public void setLogFuncionariocrearpagrFuncionarioInstance(Funcionario logFuncionariocrearpagrFuncionario) {
        this.logFuncionariocrearpagrFuncionarioInstance = logFuncionariocrearpagrFuncionario;
        this.logFuncionariocrearpagrFuncionario = logFuncionariocrearpagrFuncionario != null ? logFuncionariocrearpagrFuncionario.getOid() : null;
    }

    private void checkLogFuncionariocrearpagrFuncionario() throws NotNullArgumentException {
        if(this.getLogFuncionariocrearpagrFuncionarioInstance() == null || this.getLogFuncionariocrearpagrFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(LogFuncionarioConstants.SERV_ID_CREAR, LogFuncionarioConstants.CLASS_ID, LogFuncionarioConstants.ARG_ID_CREAR_LOGFUNCIONARIOCREARPAGRFUNCIONARIO, LogFuncionarioConstants.SERV_ALIAS_CREAR, LogFuncionarioConstants.CLASS_ALIAS, LogFuncionarioConstants.ARG_ALIAS_CREAR_LOGFUNCIONARIOCREARPAGRFUNCIONARIO);
        }
    }

    @JsonIgnore
    public String getLogFuncionariocrearpatrLoginFuncionario() {
        return this.logFuncionariocrearpatrLoginFuncionario;
    }
    
    public void setLogFuncionariocrearpatrLoginFuncionario(String logFuncionariocrearpatrLoginFuncionario) {
        this.logFuncionariocrearpatrLoginFuncionario = logFuncionariocrearpatrLoginFuncionario;
    }

    private void checkLogFuncionariocrearpatrLoginFuncionario() throws NotNullArgumentException {
        if(this.getLogFuncionariocrearpatrLoginFuncionario() == null) {
            throw new NotNullArgumentException(LogFuncionarioConstants.SERV_ID_CREAR, LogFuncionarioConstants.CLASS_ID, LogFuncionarioConstants.ARG_ID_CREAR_LOGFUNCIONARIOCREARPATRLOGINFUNCIONARIO, LogFuncionarioConstants.SERV_ALIAS_CREAR, LogFuncionarioConstants.CLASS_ALIAS, LogFuncionarioConstants.ARG_ALIAS_CREAR_LOGFUNCIONARIOCREARPATRLOGINFUNCIONARIO);
        }
    }

    @JsonIgnore
    public Boolean getLogFuncionariocrearpatrDisponible() {
        return this.logFuncionariocrearpatrDisponible;
    }
    
    public void setLogFuncionariocrearpatrDisponible(Boolean logFuncionariocrearpatrDisponible) {
        this.logFuncionariocrearpatrDisponible = logFuncionariocrearpatrDisponible;
    }

    private void checkLogFuncionariocrearpatrDisponible() throws NotNullArgumentException {
        if(this.getLogFuncionariocrearpatrDisponible() == null) {
            throw new NotNullArgumentException(LogFuncionarioConstants.SERV_ID_CREAR, LogFuncionarioConstants.CLASS_ID, LogFuncionarioConstants.ARG_ID_CREAR_LOGFUNCIONARIOCREARPATRDISPONIBLE, LogFuncionarioConstants.SERV_ALIAS_CREAR, LogFuncionarioConstants.CLASS_ALIAS, LogFuncionarioConstants.ARG_ALIAS_CREAR_LOGFUNCIONARIOCREARPATRDISPONIBLE);
        }
    }
}
