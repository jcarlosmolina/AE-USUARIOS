package com.keralty.aeusuarios.viewmodel.mesadeapoyo.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.MesaDeApoyoConstants;
import com.keralty.aeusuarios.persistence.MesaDeApoyo;
import com.keralty.aeusuarios.persistence.oid.MesaDeApoyoOid;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private MesaDeApoyoOid mesaDeApoyochangePasswordpthisAdmin;
    
    @JsonIgnore
    private MesaDeApoyo mesaDeApoyochangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String mesaDeApoyochangePasswordpOldPassword;

    @JsonProperty("new")
    private String mesaDeApoyochangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkMesaDeApoyochangePasswordpthisAdmin();
        checkMesaDeApoyochangePasswordpOldPassword();
        checkMesaDeApoyochangePasswordpNewPassword();
    }

    @JsonIgnore
    public MesaDeApoyoOid getMesaDeApoyochangePasswordpthisAdmin() {
        return this.mesaDeApoyochangePasswordpthisAdmin;
    }
    
    public void setMesaDeApoyochangePasswordpthisAdmin(MesaDeApoyoOid mesaDeApoyochangePasswordpthisAdmin) {
        this.mesaDeApoyochangePasswordpthisAdmin = mesaDeApoyochangePasswordpthisAdmin;
    }

    @JsonIgnore
    public MesaDeApoyo getMesaDeApoyochangePasswordpthisAdminInstance() {
        return this.mesaDeApoyochangePasswordpthisAdminInstance;
    }
    
    public void setMesaDeApoyochangePasswordpthisAdminInstance(MesaDeApoyo mesaDeApoyochangePasswordpthisAdmin) {
        this.mesaDeApoyochangePasswordpthisAdminInstance = mesaDeApoyochangePasswordpthisAdmin;
        this.mesaDeApoyochangePasswordpthisAdmin = mesaDeApoyochangePasswordpthisAdmin != null ? mesaDeApoyochangePasswordpthisAdmin.getOid() : null;
    }

    private void checkMesaDeApoyochangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getMesaDeApoyochangePasswordpthisAdminInstance() == null || this.getMesaDeApoyochangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(MesaDeApoyoConstants.SERV_ID_CHANGEP4SSW0RD, MesaDeApoyoConstants.CLASS_ID, MesaDeApoyoConstants.ARG_ID_CHANGEP4SSW0RD_MESADEAPOYOCHANGEP4SSW0RDPTHISADMIN, MesaDeApoyoConstants.SERV_ALIAS_CHANGEP4SSW0RD, MesaDeApoyoConstants.CLASS_ALIAS, MesaDeApoyoConstants.ARG_ALIAS_CHANGEP4SSW0RD_MESADEAPOYOCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getMesaDeApoyochangePasswordpOldPassword() {
        return this.mesaDeApoyochangePasswordpOldPassword;
    }
    
    public void setMesaDeApoyochangePasswordpOldPassword(String mesaDeApoyochangePasswordpOldPassword) {
        this.mesaDeApoyochangePasswordpOldPassword = mesaDeApoyochangePasswordpOldPassword;
    }

    private void checkMesaDeApoyochangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getMesaDeApoyochangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(MesaDeApoyoConstants.SERV_ID_CHANGEP4SSW0RD, MesaDeApoyoConstants.CLASS_ID, MesaDeApoyoConstants.ARG_ID_CHANGEP4SSW0RD_MESADEAPOYOCHANGEP4SSW0RDPOLDP4SSW0RD, MesaDeApoyoConstants.SERV_ALIAS_CHANGEP4SSW0RD, MesaDeApoyoConstants.CLASS_ALIAS, MesaDeApoyoConstants.ARG_ALIAS_CHANGEP4SSW0RD_MESADEAPOYOCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getMesaDeApoyochangePasswordpNewPassword() {
        return this.mesaDeApoyochangePasswordpNewPassword;
    }
    
    public void setMesaDeApoyochangePasswordpNewPassword(String mesaDeApoyochangePasswordpNewPassword) {
        this.mesaDeApoyochangePasswordpNewPassword = mesaDeApoyochangePasswordpNewPassword;
    }

    private void checkMesaDeApoyochangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getMesaDeApoyochangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(MesaDeApoyoConstants.SERV_ID_CHANGEP4SSW0RD, MesaDeApoyoConstants.CLASS_ID, MesaDeApoyoConstants.ARG_ID_CHANGEP4SSW0RD_MESADEAPOYOCHANGEP4SSW0RDPNEWP4SSW0RD, MesaDeApoyoConstants.SERV_ALIAS_CHANGEP4SSW0RD, MesaDeApoyoConstants.CLASS_ALIAS, MesaDeApoyoConstants.ARG_ALIAS_CHANGEP4SSW0RD_MESADEAPOYOCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
