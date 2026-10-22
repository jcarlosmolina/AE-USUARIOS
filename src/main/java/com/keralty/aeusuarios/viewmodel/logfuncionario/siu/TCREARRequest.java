package com.keralty.aeusuarios.viewmodel.logfuncionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogFuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class TCREARRequest {

    @JsonProperty("pt_p_agrfuncionario_oid")
    private FuncionarioOid logFuncionarioTCREARptpagrFuncionario;
    
    @JsonIgnore
    private Funcionario logFuncionarioTCREARptpagrFuncionarioInstance;

    @JsonProperty("pt_p_atrdisponible")
    private Boolean logFuncionarioTCREARptpatrDisponible;

    public void checkArguments() throws NotNullArgumentException {
        checkLogFuncionarioTCREARptpagrFuncionario();
        checkLogFuncionarioTCREARptpatrDisponible();
    }

    @JsonIgnore
    public FuncionarioOid getLogFuncionarioTCREARptpagrFuncionario() {
        return this.logFuncionarioTCREARptpagrFuncionario;
    }
    
    public void setLogFuncionarioTCREARptpagrFuncionario(FuncionarioOid logFuncionarioTCREARptpagrFuncionario) {
        this.logFuncionarioTCREARptpagrFuncionario = logFuncionarioTCREARptpagrFuncionario;
    }

    @JsonIgnore
    public Funcionario getLogFuncionarioTCREARptpagrFuncionarioInstance() {
        return this.logFuncionarioTCREARptpagrFuncionarioInstance;
    }
    
    public void setLogFuncionarioTCREARptpagrFuncionarioInstance(Funcionario logFuncionarioTCREARptpagrFuncionario) {
        this.logFuncionarioTCREARptpagrFuncionarioInstance = logFuncionarioTCREARptpagrFuncionario;
        this.logFuncionarioTCREARptpagrFuncionario = logFuncionarioTCREARptpagrFuncionario != null ? logFuncionarioTCREARptpagrFuncionario.getOid() : null;
    }

    private void checkLogFuncionarioTCREARptpagrFuncionario() throws NotNullArgumentException {
        if(this.getLogFuncionarioTCREARptpagrFuncionarioInstance() == null || this.getLogFuncionarioTCREARptpagrFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(LogFuncionarioConstants.SERV_ID_TCREAR, LogFuncionarioConstants.CLASS_ID, LogFuncionarioConstants.ARG_ID_TCREAR_LOGFUNCIONARIOTCREARPTPAGRFUNCIONARIO, LogFuncionarioConstants.SERV_ALIAS_TCREAR, LogFuncionarioConstants.CLASS_ALIAS, LogFuncionarioConstants.ARG_ALIAS_TCREAR_LOGFUNCIONARIOTCREARPTPAGRFUNCIONARIO);
        }
    }

    @JsonIgnore
    public Boolean getLogFuncionarioTCREARptpatrDisponible() {
        return this.logFuncionarioTCREARptpatrDisponible;
    }
    
    public void setLogFuncionarioTCREARptpatrDisponible(Boolean logFuncionarioTCREARptpatrDisponible) {
        this.logFuncionarioTCREARptpatrDisponible = logFuncionarioTCREARptpatrDisponible;
    }

    private void checkLogFuncionarioTCREARptpatrDisponible() throws NotNullArgumentException {
        if(this.getLogFuncionarioTCREARptpatrDisponible() == null) {
            throw new NotNullArgumentException(LogFuncionarioConstants.SERV_ID_TCREAR, LogFuncionarioConstants.CLASS_ID, LogFuncionarioConstants.ARG_ID_TCREAR_LOGFUNCIONARIOTCREARPTPATRDISPONIBLE, LogFuncionarioConstants.SERV_ALIAS_TCREAR, LogFuncionarioConstants.CLASS_ALIAS, LogFuncionarioConstants.ARG_ALIAS_TCREAR_LOGFUNCIONARIOTCREARPTPATRDISPONIBLE);
        }
    }
}
