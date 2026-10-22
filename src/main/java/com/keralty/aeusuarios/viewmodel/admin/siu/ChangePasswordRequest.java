package com.keralty.aeusuarios.viewmodel.admin.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AdminConstants;
import com.keralty.aeusuarios.persistence.Admin;
import com.keralty.aeusuarios.persistence.oid.AdminOid;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private AdminOid adminchangePasswordpthisAdmin;
    
    @JsonIgnore
    private Admin adminchangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String adminchangePasswordpOldPassword;

    @JsonProperty("new")
    private String adminchangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkAdminchangePasswordpthisAdmin();
        checkAdminchangePasswordpOldPassword();
        checkAdminchangePasswordpNewPassword();
    }

    @JsonIgnore
    public AdminOid getAdminchangePasswordpthisAdmin() {
        return this.adminchangePasswordpthisAdmin;
    }
    
    public void setAdminchangePasswordpthisAdmin(AdminOid adminchangePasswordpthisAdmin) {
        this.adminchangePasswordpthisAdmin = adminchangePasswordpthisAdmin;
    }

    @JsonIgnore
    public Admin getAdminchangePasswordpthisAdminInstance() {
        return this.adminchangePasswordpthisAdminInstance;
    }
    
    public void setAdminchangePasswordpthisAdminInstance(Admin adminchangePasswordpthisAdmin) {
        this.adminchangePasswordpthisAdminInstance = adminchangePasswordpthisAdmin;
        this.adminchangePasswordpthisAdmin = adminchangePasswordpthisAdmin != null ? adminchangePasswordpthisAdmin.getOid() : null;
    }

    private void checkAdminchangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getAdminchangePasswordpthisAdminInstance() == null || this.getAdminchangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(AdminConstants.SERV_ID_CHANGEP4SSW0RD, AdminConstants.CLASS_ID, AdminConstants.ARG_ID_CHANGEP4SSW0RD_ADMINCHANGEP4SSW0RDPTHISADMIN, AdminConstants.SERV_ALIAS_CHANGEP4SSW0RD, AdminConstants.CLASS_ALIAS, AdminConstants.ARG_ALIAS_CHANGEP4SSW0RD_ADMINCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getAdminchangePasswordpOldPassword() {
        return this.adminchangePasswordpOldPassword;
    }
    
    public void setAdminchangePasswordpOldPassword(String adminchangePasswordpOldPassword) {
        this.adminchangePasswordpOldPassword = adminchangePasswordpOldPassword;
    }

    private void checkAdminchangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getAdminchangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(AdminConstants.SERV_ID_CHANGEP4SSW0RD, AdminConstants.CLASS_ID, AdminConstants.ARG_ID_CHANGEP4SSW0RD_ADMINCHANGEP4SSW0RDPOLDP4SSW0RD, AdminConstants.SERV_ALIAS_CHANGEP4SSW0RD, AdminConstants.CLASS_ALIAS, AdminConstants.ARG_ALIAS_CHANGEP4SSW0RD_ADMINCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getAdminchangePasswordpNewPassword() {
        return this.adminchangePasswordpNewPassword;
    }
    
    public void setAdminchangePasswordpNewPassword(String adminchangePasswordpNewPassword) {
        this.adminchangePasswordpNewPassword = adminchangePasswordpNewPassword;
    }

    private void checkAdminchangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getAdminchangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(AdminConstants.SERV_ID_CHANGEP4SSW0RD, AdminConstants.CLASS_ID, AdminConstants.ARG_ID_CHANGEP4SSW0RD_ADMINCHANGEP4SSW0RDPNEWP4SSW0RD, AdminConstants.SERV_ALIAS_CHANGEP4SSW0RD, AdminConstants.CLASS_ALIAS, AdminConstants.ARG_ALIAS_CHANGEP4SSW0RD_ADMINCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
