package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class SetPasswordRequest {

    @JsonProperty("p_thisadmin_oid")
    private FuncionarioOid funcionariosetPasswordpthisAdmin;
    
    @JsonIgnore
    private Funcionario funcionariosetPasswordpthisAdminInstance;

    @JsonProperty("p_newpassword")
    private String funcionariosetPasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariosetPasswordpthisAdmin();
        checkFuncionariosetPasswordpNewPassword();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariosetPasswordpthisAdmin() {
        return this.funcionariosetPasswordpthisAdmin;
    }
    
    public void setFuncionariosetPasswordpthisAdmin(FuncionarioOid funcionariosetPasswordpthisAdmin) {
        this.funcionariosetPasswordpthisAdmin = funcionariosetPasswordpthisAdmin;
    }

    @JsonIgnore
    public Funcionario getFuncionariosetPasswordpthisAdminInstance() {
        return this.funcionariosetPasswordpthisAdminInstance;
    }
    
    public void setFuncionariosetPasswordpthisAdminInstance(Funcionario funcionariosetPasswordpthisAdmin) {
        this.funcionariosetPasswordpthisAdminInstance = funcionariosetPasswordpthisAdmin;
        this.funcionariosetPasswordpthisAdmin = funcionariosetPasswordpthisAdmin != null ? funcionariosetPasswordpthisAdmin.getOid() : null;
    }

    private void checkFuncionariosetPasswordpthisAdmin() throws NotNullArgumentException {
        if(this.getFuncionariosetPasswordpthisAdminInstance() == null || this.getFuncionariosetPasswordpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_SETP4SSW0RD, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_SETP4SSW0RD_FUNCIONARIOSETP4SSW0RDPTHISADMIN, FuncionarioConstants.SERV_ALIAS_SETP4SSW0RD, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_SETP4SSW0RD_FUNCIONARIOSETP4SSW0RDPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getFuncionariosetPasswordpNewPassword() {
        return this.funcionariosetPasswordpNewPassword;
    }
    
    public void setFuncionariosetPasswordpNewPassword(String funcionariosetPasswordpNewPassword) {
        this.funcionariosetPasswordpNewPassword = funcionariosetPasswordpNewPassword;
    }

    private void checkFuncionariosetPasswordpNewPassword() throws NotNullArgumentException {
        if(this.getFuncionariosetPasswordpNewPassword() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_SETP4SSW0RD, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_SETP4SSW0RD_FUNCIONARIOSETP4SSW0RDPNEWP4SSW0RD, FuncionarioConstants.SERV_ALIAS_SETP4SSW0RD, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_SETP4SSW0RD_FUNCIONARIOSETP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
