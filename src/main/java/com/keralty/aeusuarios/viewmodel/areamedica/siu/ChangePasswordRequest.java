package com.keralty.aeusuarios.viewmodel.areamedica.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.oid.AreaMedicaOid;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private AreaMedicaOid areaMedicachangePasswordpthisAdmin;
    
    @JsonIgnore
    private AreaMedica areaMedicachangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String areaMedicachangePasswordpOldPassword;

    @JsonProperty("new")
    private String areaMedicachangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkAreaMedicachangePasswordpthisAdmin();
        checkAreaMedicachangePasswordpOldPassword();
        checkAreaMedicachangePasswordpNewPassword();
    }

    @JsonIgnore
    public AreaMedicaOid getAreaMedicachangePasswordpthisAdmin() {
        return this.areaMedicachangePasswordpthisAdmin;
    }
    
    public void setAreaMedicachangePasswordpthisAdmin(AreaMedicaOid areaMedicachangePasswordpthisAdmin) {
        this.areaMedicachangePasswordpthisAdmin = areaMedicachangePasswordpthisAdmin;
    }

    @JsonIgnore
    public AreaMedica getAreaMedicachangePasswordpthisAdminInstance() {
        return this.areaMedicachangePasswordpthisAdminInstance;
    }
    
    public void setAreaMedicachangePasswordpthisAdminInstance(AreaMedica areaMedicachangePasswordpthisAdmin) {
        this.areaMedicachangePasswordpthisAdminInstance = areaMedicachangePasswordpthisAdmin;
        this.areaMedicachangePasswordpthisAdmin = areaMedicachangePasswordpthisAdmin != null ? areaMedicachangePasswordpthisAdmin.getOid() : null;
    }

    private void checkAreaMedicachangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getAreaMedicachangePasswordpthisAdminInstance() == null || this.getAreaMedicachangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(AreaMedicaConstants.SERV_ID_CHANGEP4SSW0RD, AreaMedicaConstants.CLASS_ID, AreaMedicaConstants.ARG_ID_CHANGEP4SSW0RD_AREAMEDICACHANGEP4SSW0RDPTHISADMIN, AreaMedicaConstants.SERV_ALIAS_CHANGEP4SSW0RD, AreaMedicaConstants.CLASS_ALIAS, AreaMedicaConstants.ARG_ALIAS_CHANGEP4SSW0RD_AREAMEDICACHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getAreaMedicachangePasswordpOldPassword() {
        return this.areaMedicachangePasswordpOldPassword;
    }
    
    public void setAreaMedicachangePasswordpOldPassword(String areaMedicachangePasswordpOldPassword) {
        this.areaMedicachangePasswordpOldPassword = areaMedicachangePasswordpOldPassword;
    }

    private void checkAreaMedicachangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getAreaMedicachangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(AreaMedicaConstants.SERV_ID_CHANGEP4SSW0RD, AreaMedicaConstants.CLASS_ID, AreaMedicaConstants.ARG_ID_CHANGEP4SSW0RD_AREAMEDICACHANGEP4SSW0RDPOLDP4SSW0RD, AreaMedicaConstants.SERV_ALIAS_CHANGEP4SSW0RD, AreaMedicaConstants.CLASS_ALIAS, AreaMedicaConstants.ARG_ALIAS_CHANGEP4SSW0RD_AREAMEDICACHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getAreaMedicachangePasswordpNewPassword() {
        return this.areaMedicachangePasswordpNewPassword;
    }
    
    public void setAreaMedicachangePasswordpNewPassword(String areaMedicachangePasswordpNewPassword) {
        this.areaMedicachangePasswordpNewPassword = areaMedicachangePasswordpNewPassword;
    }

    private void checkAreaMedicachangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getAreaMedicachangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(AreaMedicaConstants.SERV_ID_CHANGEP4SSW0RD, AreaMedicaConstants.CLASS_ID, AreaMedicaConstants.ARG_ID_CHANGEP4SSW0RD_AREAMEDICACHANGEP4SSW0RDPNEWP4SSW0RD, AreaMedicaConstants.SERV_ALIAS_CHANGEP4SSW0RD, AreaMedicaConstants.CLASS_ALIAS, AreaMedicaConstants.ARG_ALIAS_CHANGEP4SSW0RD_AREAMEDICACHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
