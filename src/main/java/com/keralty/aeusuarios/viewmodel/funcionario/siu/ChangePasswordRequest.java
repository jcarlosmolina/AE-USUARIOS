package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private FuncionarioOid funcionariochangePasswordpthisAdmin;
    
    @JsonIgnore
    private Funcionario funcionariochangePasswordpthisAdminInstance;

    @JsonProperty("old")
    private String funcionariochangePasswordpOldPassword;

    @JsonProperty("new")
    private String funcionariochangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariochangePasswordpthisAdmin();
        checkFuncionariochangePasswordpOldPassword();
        checkFuncionariochangePasswordpNewPassword();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariochangePasswordpthisAdmin() {
        return this.funcionariochangePasswordpthisAdmin;
    }
    
    public void setFuncionariochangePasswordpthisAdmin(FuncionarioOid funcionariochangePasswordpthisAdmin) {
        this.funcionariochangePasswordpthisAdmin = funcionariochangePasswordpthisAdmin;
    }

    @JsonIgnore
    public Funcionario getFuncionariochangePasswordpthisAdminInstance() {
        return this.funcionariochangePasswordpthisAdminInstance;
    }
    
    public void setFuncionariochangePasswordpthisAdminInstance(Funcionario funcionariochangePasswordpthisAdmin) {
        this.funcionariochangePasswordpthisAdminInstance = funcionariochangePasswordpthisAdmin;
        this.funcionariochangePasswordpthisAdmin = funcionariochangePasswordpthisAdmin != null ? funcionariochangePasswordpthisAdmin.getOid() : null;
    }

    private void checkFuncionariochangePasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getFuncionariochangePasswordpthisAdminInstance() == null || this.getFuncionariochangePasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CHANGEP4SSW0RD, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CHANGEP4SSW0RD_FUNCIONARIOCHANGEP4SSW0RDPTHISADMIN, FuncionarioConstants.SERV_ALIAS_CHANGEP4SSW0RD, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CHANGEP4SSW0RD_FUNCIONARIOCHANGEP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getFuncionariochangePasswordpOldPassword() {
        return this.funcionariochangePasswordpOldPassword;
    }
    
    public void setFuncionariochangePasswordpOldPassword(String funcionariochangePasswordpOldPassword) {
        this.funcionariochangePasswordpOldPassword = funcionariochangePasswordpOldPassword;
    }

    private void checkFuncionariochangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getFuncionariochangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CHANGEP4SSW0RD, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CHANGEP4SSW0RD_FUNCIONARIOCHANGEP4SSW0RDPOLDP4SSW0RD, FuncionarioConstants.SERV_ALIAS_CHANGEP4SSW0RD, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CHANGEP4SSW0RD_FUNCIONARIOCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getFuncionariochangePasswordpNewPassword() {
        return this.funcionariochangePasswordpNewPassword;
    }
    
    public void setFuncionariochangePasswordpNewPassword(String funcionariochangePasswordpNewPassword) {
        this.funcionariochangePasswordpNewPassword = funcionariochangePasswordpNewPassword;
    }

    private void checkFuncionariochangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getFuncionariochangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CHANGEP4SSW0RD, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CHANGEP4SSW0RD_FUNCIONARIOCHANGEP4SSW0RDPNEWP4SSW0RD, FuncionarioConstants.SERV_ALIAS_CHANGEP4SSW0RD, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CHANGEP4SSW0RD_FUNCIONARIOCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
