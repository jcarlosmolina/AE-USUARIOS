package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private AsesorOid asesorchangePasswordpthisAdmin;
    
    @JsonIgnore
    private Asesor asesorchangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String asesorchangePasswordpOldPassword;

    @JsonProperty("new")
    private String asesorchangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorchangePasswordpthisAdmin();
        checkAsesorchangePasswordpOldPassword();
        checkAsesorchangePasswordpNewPassword();
    }

    @JsonIgnore
    public AsesorOid getAsesorchangePasswordpthisAdmin() {
        return this.asesorchangePasswordpthisAdmin;
    }
    
    public void setAsesorchangePasswordpthisAdmin(AsesorOid asesorchangePasswordpthisAdmin) {
        this.asesorchangePasswordpthisAdmin = asesorchangePasswordpthisAdmin;
    }

    @JsonIgnore
    public Asesor getAsesorchangePasswordpthisAdminInstance() {
        return this.asesorchangePasswordpthisAdminInstance;
    }
    
    public void setAsesorchangePasswordpthisAdminInstance(Asesor asesorchangePasswordpthisAdmin) {
        this.asesorchangePasswordpthisAdminInstance = asesorchangePasswordpthisAdmin;
        this.asesorchangePasswordpthisAdmin = asesorchangePasswordpthisAdmin != null ? asesorchangePasswordpthisAdmin.getOid() : null;
    }

    private void checkAsesorchangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getAsesorchangePasswordpthisAdminInstance() == null || this.getAsesorchangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_CHANGEP4SSW0RD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_CHANGEP4SSW0RD_ASESORCHANGEP4SSW0RDPTHISADMIN, AsesorConstants.SERV_ALIAS_CHANGEP4SSW0RD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_CHANGEP4SSW0RD_ASESORCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getAsesorchangePasswordpOldPassword() {
        return this.asesorchangePasswordpOldPassword;
    }
    
    public void setAsesorchangePasswordpOldPassword(String asesorchangePasswordpOldPassword) {
        this.asesorchangePasswordpOldPassword = asesorchangePasswordpOldPassword;
    }

    private void checkAsesorchangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getAsesorchangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_CHANGEP4SSW0RD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_CHANGEP4SSW0RD_ASESORCHANGEP4SSW0RDPOLDP4SSW0RD, AsesorConstants.SERV_ALIAS_CHANGEP4SSW0RD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_CHANGEP4SSW0RD_ASESORCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getAsesorchangePasswordpNewPassword() {
        return this.asesorchangePasswordpNewPassword;
    }
    
    public void setAsesorchangePasswordpNewPassword(String asesorchangePasswordpNewPassword) {
        this.asesorchangePasswordpNewPassword = asesorchangePasswordpNewPassword;
    }

    private void checkAsesorchangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getAsesorchangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_CHANGEP4SSW0RD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_CHANGEP4SSW0RD_ASESORCHANGEP4SSW0RDPNEWP4SSW0RD, AsesorConstants.SERV_ALIAS_CHANGEP4SSW0RD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_CHANGEP4SSW0RD_ASESORCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
