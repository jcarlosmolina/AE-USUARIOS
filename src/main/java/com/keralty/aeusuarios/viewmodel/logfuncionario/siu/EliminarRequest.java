package com.keralty.aeusuarios.viewmodel.logfuncionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogFuncionarioConstants;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.oid.LogFuncionarioOid;

public class EliminarRequest {

    @JsonProperty("p_thislogfuncoinario_oid")
    private LogFuncionarioOid logFuncionarioeliminarpthisLogFuncoinario;
    
    @JsonIgnore
    private LogFuncionario logFuncionarioeliminarpthisLogFuncoinarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkLogFuncionarioeliminarpthisLogFuncoinario();
    }

    @JsonIgnore
    public LogFuncionarioOid getLogFuncionarioeliminarpthisLogFuncoinario() {
        return this.logFuncionarioeliminarpthisLogFuncoinario;
    }
    
    public void setLogFuncionarioeliminarpthisLogFuncoinario(LogFuncionarioOid logFuncionarioeliminarpthisLogFuncoinario) {
        this.logFuncionarioeliminarpthisLogFuncoinario = logFuncionarioeliminarpthisLogFuncoinario;
    }

    @JsonIgnore
    public LogFuncionario getLogFuncionarioeliminarpthisLogFuncoinarioInstance() {
        return this.logFuncionarioeliminarpthisLogFuncoinarioInstance;
    }
    
    public void setLogFuncionarioeliminarpthisLogFuncoinarioInstance(LogFuncionario logFuncionarioeliminarpthisLogFuncoinario) {
        this.logFuncionarioeliminarpthisLogFuncoinarioInstance = logFuncionarioeliminarpthisLogFuncoinario;
        this.logFuncionarioeliminarpthisLogFuncoinario = logFuncionarioeliminarpthisLogFuncoinario != null ? logFuncionarioeliminarpthisLogFuncoinario.getOid() : null;
    }

    private void checkLogFuncionarioeliminarpthisLogFuncoinario() throws NotNullArgumentException {
        if(this.getLogFuncionarioeliminarpthisLogFuncoinarioInstance() == null || this.getLogFuncionarioeliminarpthisLogFuncoinarioInstance().isNull()) {
            throw new NotNullArgumentException(LogFuncionarioConstants.SERV_ID_ELIMINAR, LogFuncionarioConstants.CLASS_ID, LogFuncionarioConstants.ARG_ID_ELIMINAR_LOGFUNCIONARIOELIMINARPTHISLOGFUNCOINARIO, LogFuncionarioConstants.SERV_ALIAS_ELIMINAR, LogFuncionarioConstants.CLASS_ALIAS, LogFuncionarioConstants.ARG_ALIAS_ELIMINAR_LOGFUNCIONARIOELIMINARPTHISLOGFUNCOINARIO);
        }
    }
}
