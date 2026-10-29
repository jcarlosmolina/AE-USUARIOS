package com.keralty.aeusuarios.viewmodel.respregional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.RespRegional;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private RespRegionalOid respRegionalchangePasswordpthisAdmin;
    
    @JsonIgnore
    private RespRegional respRegionalchangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String respRegionalchangePasswordpOldPassword;

    @JsonProperty("new")
    private String respRegionalchangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkRespRegionalchangePasswordpthisAdmin();
        checkRespRegionalchangePasswordpOldPassword();
        checkRespRegionalchangePasswordpNewPassword();
    }

    @JsonIgnore
    public RespRegionalOid getRespRegionalchangePasswordpthisAdmin() {
        return this.respRegionalchangePasswordpthisAdmin;
    }
    
    public void setRespRegionalchangePasswordpthisAdmin(RespRegionalOid respRegionalchangePasswordpthisAdmin) {
        this.respRegionalchangePasswordpthisAdmin = respRegionalchangePasswordpthisAdmin;
    }

    @JsonIgnore
    public RespRegional getRespRegionalchangePasswordpthisAdminInstance() {
        return this.respRegionalchangePasswordpthisAdminInstance;
    }
    
    public void setRespRegionalchangePasswordpthisAdminInstance(RespRegional respRegionalchangePasswordpthisAdmin) {
        this.respRegionalchangePasswordpthisAdminInstance = respRegionalchangePasswordpthisAdmin;
        this.respRegionalchangePasswordpthisAdmin = respRegionalchangePasswordpthisAdmin != null ? respRegionalchangePasswordpthisAdmin.getOid() : null;
    }

    private void checkRespRegionalchangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getRespRegionalchangePasswordpthisAdminInstance() == null || this.getRespRegionalchangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_CHANGEP4SSW0RD, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_CHANGEP4SSW0RD_RESPREGIONALCHANGEP4SSW0RDPTHISADMIN, RespRegionalConstants.SERV_ALIAS_CHANGEP4SSW0RD, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_CHANGEP4SSW0RD_RESPREGIONALCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getRespRegionalchangePasswordpOldPassword() {
        return this.respRegionalchangePasswordpOldPassword;
    }
    
    public void setRespRegionalchangePasswordpOldPassword(String respRegionalchangePasswordpOldPassword) {
        this.respRegionalchangePasswordpOldPassword = respRegionalchangePasswordpOldPassword;
    }

    private void checkRespRegionalchangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getRespRegionalchangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_CHANGEP4SSW0RD, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_CHANGEP4SSW0RD_RESPREGIONALCHANGEP4SSW0RDPOLDP4SSW0RD, RespRegionalConstants.SERV_ALIAS_CHANGEP4SSW0RD, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_CHANGEP4SSW0RD_RESPREGIONALCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getRespRegionalchangePasswordpNewPassword() {
        return this.respRegionalchangePasswordpNewPassword;
    }
    
    public void setRespRegionalchangePasswordpNewPassword(String respRegionalchangePasswordpNewPassword) {
        this.respRegionalchangePasswordpNewPassword = respRegionalchangePasswordpNewPassword;
    }

    private void checkRespRegionalchangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getRespRegionalchangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_CHANGEP4SSW0RD, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_CHANGEP4SSW0RD_RESPREGIONALCHANGEP4SSW0RDPNEWP4SSW0RD, RespRegionalConstants.SERV_ALIAS_CHANGEP4SSW0RD, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_CHANGEP4SSW0RD_RESPREGIONALCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
