package com.keralty.aeusuarios.viewmodel.superadmin.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SuperAdminConstants;
import com.keralty.aeusuarios.persistence.oid.SuperAdminOid;
import com.keralty.aeusuarios.persistence.SuperAdmin;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private SuperAdminOid superAdminchangePasswordpthisAdmin;
    
    @JsonIgnore
    private SuperAdmin superAdminchangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String superAdminchangePasswordpOldPassword;

    @JsonProperty("new")
    private String superAdminchangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkSuperAdminchangePasswordpthisAdmin();
        checkSuperAdminchangePasswordpOldPassword();
        checkSuperAdminchangePasswordpNewPassword();
    }

    @JsonIgnore
    public SuperAdminOid getSuperAdminchangePasswordpthisAdmin() {
        return this.superAdminchangePasswordpthisAdmin;
    }
    
    public void setSuperAdminchangePasswordpthisAdmin(SuperAdminOid superAdminchangePasswordpthisAdmin) {
        this.superAdminchangePasswordpthisAdmin = superAdminchangePasswordpthisAdmin;
    }

    @JsonIgnore
    public SuperAdmin getSuperAdminchangePasswordpthisAdminInstance() {
        return this.superAdminchangePasswordpthisAdminInstance;
    }
    
    public void setSuperAdminchangePasswordpthisAdminInstance(SuperAdmin superAdminchangePasswordpthisAdmin) {
        this.superAdminchangePasswordpthisAdminInstance = superAdminchangePasswordpthisAdmin;
        this.superAdminchangePasswordpthisAdmin = superAdminchangePasswordpthisAdmin != null ? superAdminchangePasswordpthisAdmin.getOid() : null;
    }

    private void checkSuperAdminchangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getSuperAdminchangePasswordpthisAdminInstance() == null || this.getSuperAdminchangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(SuperAdminConstants.SERV_ID_CHANGEP4SSW0RD, SuperAdminConstants.CLASS_ID, SuperAdminConstants.ARG_ID_CHANGEP4SSW0RD_SUPERADMINCHANGEP4SSW0RDPTHISADMIN, SuperAdminConstants.SERV_ALIAS_CHANGEP4SSW0RD, SuperAdminConstants.CLASS_ALIAS, SuperAdminConstants.ARG_ALIAS_CHANGEP4SSW0RD_SUPERADMINCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getSuperAdminchangePasswordpOldPassword() {
        return this.superAdminchangePasswordpOldPassword;
    }
    
    public void setSuperAdminchangePasswordpOldPassword(String superAdminchangePasswordpOldPassword) {
        this.superAdminchangePasswordpOldPassword = superAdminchangePasswordpOldPassword;
    }

    private void checkSuperAdminchangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getSuperAdminchangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(SuperAdminConstants.SERV_ID_CHANGEP4SSW0RD, SuperAdminConstants.CLASS_ID, SuperAdminConstants.ARG_ID_CHANGEP4SSW0RD_SUPERADMINCHANGEP4SSW0RDPOLDP4SSW0RD, SuperAdminConstants.SERV_ALIAS_CHANGEP4SSW0RD, SuperAdminConstants.CLASS_ALIAS, SuperAdminConstants.ARG_ALIAS_CHANGEP4SSW0RD_SUPERADMINCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getSuperAdminchangePasswordpNewPassword() {
        return this.superAdminchangePasswordpNewPassword;
    }
    
    public void setSuperAdminchangePasswordpNewPassword(String superAdminchangePasswordpNewPassword) {
        this.superAdminchangePasswordpNewPassword = superAdminchangePasswordpNewPassword;
    }

    private void checkSuperAdminchangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getSuperAdminchangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(SuperAdminConstants.SERV_ID_CHANGEP4SSW0RD, SuperAdminConstants.CLASS_ID, SuperAdminConstants.ARG_ID_CHANGEP4SSW0RD_SUPERADMINCHANGEP4SSW0RDPNEWP4SSW0RD, SuperAdminConstants.SERV_ALIAS_CHANGEP4SSW0RD, SuperAdminConstants.CLASS_ALIAS, SuperAdminConstants.ARG_ALIAS_CHANGEP4SSW0RD_SUPERADMINCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
