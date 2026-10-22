package com.keralty.aeusuarios.viewmodel.afiliaciones.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private AfiliacionesOid afiliacioneschangePasswordpthisAdmin;
    
    @JsonIgnore
    private Afiliaciones afiliacioneschangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String afiliacioneschangePasswordpOldPassword;

    @JsonProperty("new")
    private String afiliacioneschangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkAfiliacioneschangePasswordpthisAdmin();
        checkAfiliacioneschangePasswordpOldPassword();
        checkAfiliacioneschangePasswordpNewPassword();
    }

    @JsonIgnore
    public AfiliacionesOid getAfiliacioneschangePasswordpthisAdmin() {
        return this.afiliacioneschangePasswordpthisAdmin;
    }
    
    public void setAfiliacioneschangePasswordpthisAdmin(AfiliacionesOid afiliacioneschangePasswordpthisAdmin) {
        this.afiliacioneschangePasswordpthisAdmin = afiliacioneschangePasswordpthisAdmin;
    }

    @JsonIgnore
    public Afiliaciones getAfiliacioneschangePasswordpthisAdminInstance() {
        return this.afiliacioneschangePasswordpthisAdminInstance;
    }
    
    public void setAfiliacioneschangePasswordpthisAdminInstance(Afiliaciones afiliacioneschangePasswordpthisAdmin) {
        this.afiliacioneschangePasswordpthisAdminInstance = afiliacioneschangePasswordpthisAdmin;
        this.afiliacioneschangePasswordpthisAdmin = afiliacioneschangePasswordpthisAdmin != null ? afiliacioneschangePasswordpthisAdmin.getOid() : null;
    }

    private void checkAfiliacioneschangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getAfiliacioneschangePasswordpthisAdminInstance() == null || this.getAfiliacioneschangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(AfiliacionesConstants.SERV_ID_CHANGEP4SSW0RD, AfiliacionesConstants.CLASS_ID, AfiliacionesConstants.ARG_ID_CHANGEP4SSW0RD_AFILIACIONESCHANGEP4SSW0RDPTHISADMIN, AfiliacionesConstants.SERV_ALIAS_CHANGEP4SSW0RD, AfiliacionesConstants.CLASS_ALIAS, AfiliacionesConstants.ARG_ALIAS_CHANGEP4SSW0RD_AFILIACIONESCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getAfiliacioneschangePasswordpOldPassword() {
        return this.afiliacioneschangePasswordpOldPassword;
    }
    
    public void setAfiliacioneschangePasswordpOldPassword(String afiliacioneschangePasswordpOldPassword) {
        this.afiliacioneschangePasswordpOldPassword = afiliacioneschangePasswordpOldPassword;
    }

    private void checkAfiliacioneschangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getAfiliacioneschangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(AfiliacionesConstants.SERV_ID_CHANGEP4SSW0RD, AfiliacionesConstants.CLASS_ID, AfiliacionesConstants.ARG_ID_CHANGEP4SSW0RD_AFILIACIONESCHANGEP4SSW0RDPOLDP4SSW0RD, AfiliacionesConstants.SERV_ALIAS_CHANGEP4SSW0RD, AfiliacionesConstants.CLASS_ALIAS, AfiliacionesConstants.ARG_ALIAS_CHANGEP4SSW0RD_AFILIACIONESCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getAfiliacioneschangePasswordpNewPassword() {
        return this.afiliacioneschangePasswordpNewPassword;
    }
    
    public void setAfiliacioneschangePasswordpNewPassword(String afiliacioneschangePasswordpNewPassword) {
        this.afiliacioneschangePasswordpNewPassword = afiliacioneschangePasswordpNewPassword;
    }

    private void checkAfiliacioneschangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getAfiliacioneschangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(AfiliacionesConstants.SERV_ID_CHANGEP4SSW0RD, AfiliacionesConstants.CLASS_ID, AfiliacionesConstants.ARG_ID_CHANGEP4SSW0RD_AFILIACIONESCHANGEP4SSW0RDPNEWP4SSW0RD, AfiliacionesConstants.SERV_ALIAS_CHANGEP4SSW0RD, AfiliacionesConstants.CLASS_ALIAS, AfiliacionesConstants.ARG_ALIAS_CHANGEP4SSW0RD_AFILIACIONESCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
