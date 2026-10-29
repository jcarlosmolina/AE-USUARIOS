package com.keralty.aeusuarios.viewmodel.gestor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GestorConstants;
import com.keralty.aeusuarios.persistence.Gestor;
import com.keralty.aeusuarios.persistence.oid.GestorOid;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private GestorOid gestorchangePasswordpthisAdmin;
    
    @JsonIgnore
    private Gestor gestorchangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String gestorchangePasswordpOldPassword;

    @JsonProperty("new")
    private String gestorchangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkGestorchangePasswordpthisAdmin();
        checkGestorchangePasswordpOldPassword();
        checkGestorchangePasswordpNewPassword();
    }

    @JsonIgnore
    public GestorOid getGestorchangePasswordpthisAdmin() {
        return this.gestorchangePasswordpthisAdmin;
    }
    
    public void setGestorchangePasswordpthisAdmin(GestorOid gestorchangePasswordpthisAdmin) {
        this.gestorchangePasswordpthisAdmin = gestorchangePasswordpthisAdmin;
    }

    @JsonIgnore
    public Gestor getGestorchangePasswordpthisAdminInstance() {
        return this.gestorchangePasswordpthisAdminInstance;
    }
    
    public void setGestorchangePasswordpthisAdminInstance(Gestor gestorchangePasswordpthisAdmin) {
        this.gestorchangePasswordpthisAdminInstance = gestorchangePasswordpthisAdmin;
        this.gestorchangePasswordpthisAdmin = gestorchangePasswordpthisAdmin != null ? gestorchangePasswordpthisAdmin.getOid() : null;
    }

    private void checkGestorchangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getGestorchangePasswordpthisAdminInstance() == null || this.getGestorchangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(GestorConstants.SERV_ID_CHANGEP4SSW0RD, GestorConstants.CLASS_ID, GestorConstants.ARG_ID_CHANGEP4SSW0RD_GESTORCHANGEP4SSW0RDPTHISADMIN, GestorConstants.SERV_ALIAS_CHANGEP4SSW0RD, GestorConstants.CLASS_ALIAS, GestorConstants.ARG_ALIAS_CHANGEP4SSW0RD_GESTORCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getGestorchangePasswordpOldPassword() {
        return this.gestorchangePasswordpOldPassword;
    }
    
    public void setGestorchangePasswordpOldPassword(String gestorchangePasswordpOldPassword) {
        this.gestorchangePasswordpOldPassword = gestorchangePasswordpOldPassword;
    }

    private void checkGestorchangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getGestorchangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(GestorConstants.SERV_ID_CHANGEP4SSW0RD, GestorConstants.CLASS_ID, GestorConstants.ARG_ID_CHANGEP4SSW0RD_GESTORCHANGEP4SSW0RDPOLDP4SSW0RD, GestorConstants.SERV_ALIAS_CHANGEP4SSW0RD, GestorConstants.CLASS_ALIAS, GestorConstants.ARG_ALIAS_CHANGEP4SSW0RD_GESTORCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getGestorchangePasswordpNewPassword() {
        return this.gestorchangePasswordpNewPassword;
    }
    
    public void setGestorchangePasswordpNewPassword(String gestorchangePasswordpNewPassword) {
        this.gestorchangePasswordpNewPassword = gestorchangePasswordpNewPassword;
    }

    private void checkGestorchangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getGestorchangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(GestorConstants.SERV_ID_CHANGEP4SSW0RD, GestorConstants.CLASS_ID, GestorConstants.ARG_ID_CHANGEP4SSW0RD_GESTORCHANGEP4SSW0RDPNEWP4SSW0RD, GestorConstants.SERV_ALIAS_CHANGEP4SSW0RD, GestorConstants.CLASS_ALIAS, GestorConstants.ARG_ALIAS_CHANGEP4SSW0RD_GESTORCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
