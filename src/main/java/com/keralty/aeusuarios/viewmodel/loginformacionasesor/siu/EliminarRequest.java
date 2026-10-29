package com.keralty.aeusuarios.viewmodel.loginformacionasesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogInformacionAsesorConstants;
import com.keralty.aeusuarios.persistence.LogInformacionAsesor;
import com.keralty.aeusuarios.persistence.oid.LogInformacionAsesorOid;

public class EliminarRequest {

    @JsonProperty("p_thisloginformacionasesor_oid")
    private LogInformacionAsesorOid logInformacionAsesoreliminarpthisLogInformacionAsesor;
    
    @JsonIgnore
    private LogInformacionAsesor logInformacionAsesoreliminarpthisLogInformacionAsesorInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkLogInformacionAsesoreliminarpthisLogInformacionAsesor();
    }

    @JsonIgnore
    public LogInformacionAsesorOid getLogInformacionAsesoreliminarpthisLogInformacionAsesor() {
        return this.logInformacionAsesoreliminarpthisLogInformacionAsesor;
    }
    
    public void setLogInformacionAsesoreliminarpthisLogInformacionAsesor(LogInformacionAsesorOid logInformacionAsesoreliminarpthisLogInformacionAsesor) {
        this.logInformacionAsesoreliminarpthisLogInformacionAsesor = logInformacionAsesoreliminarpthisLogInformacionAsesor;
    }

    @JsonIgnore
    public LogInformacionAsesor getLogInformacionAsesoreliminarpthisLogInformacionAsesorInstance() {
        return this.logInformacionAsesoreliminarpthisLogInformacionAsesorInstance;
    }
    
    public void setLogInformacionAsesoreliminarpthisLogInformacionAsesorInstance(LogInformacionAsesor logInformacionAsesoreliminarpthisLogInformacionAsesor) {
        this.logInformacionAsesoreliminarpthisLogInformacionAsesorInstance = logInformacionAsesoreliminarpthisLogInformacionAsesor;
        this.logInformacionAsesoreliminarpthisLogInformacionAsesor = logInformacionAsesoreliminarpthisLogInformacionAsesor != null ? logInformacionAsesoreliminarpthisLogInformacionAsesor.getOid() : null;
    }

    private void checkLogInformacionAsesoreliminarpthisLogInformacionAsesor() throws NotNullArgumentException {
        if(this.getLogInformacionAsesoreliminarpthisLogInformacionAsesorInstance() == null || this.getLogInformacionAsesoreliminarpthisLogInformacionAsesorInstance().isNull()) {
            throw new NotNullArgumentException(LogInformacionAsesorConstants.SERV_ID_ELIMINAR, LogInformacionAsesorConstants.CLASS_ID, LogInformacionAsesorConstants.ARG_ID_ELIMINAR_LOGINFORMACIONASESORELIMINARPTHISLOGINFORMACIONASESOR, LogInformacionAsesorConstants.SERV_ALIAS_ELIMINAR, LogInformacionAsesorConstants.CLASS_ALIAS, LogInformacionAsesorConstants.ARG_ALIAS_ELIMINAR_LOGINFORMACIONASESORELIMINARPTHISLOGINFORMACIONASESOR);
        }
    }
}
