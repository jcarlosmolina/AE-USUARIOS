package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class EliminarRequest {

    @JsonProperty("p_thisadmin_oid")
    private FuncionarioOid funcionarioeliminarpthisAdmin;
    
    @JsonIgnore
    private Funcionario funcionarioeliminarpthisAdminInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioeliminarpthisAdmin();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioeliminarpthisAdmin() {
        return this.funcionarioeliminarpthisAdmin;
    }
    
    public void setFuncionarioeliminarpthisAdmin(FuncionarioOid funcionarioeliminarpthisAdmin) {
        this.funcionarioeliminarpthisAdmin = funcionarioeliminarpthisAdmin;
    }

    @JsonIgnore
    public Funcionario getFuncionarioeliminarpthisAdminInstance() {
        return this.funcionarioeliminarpthisAdminInstance;
    }
    
    public void setFuncionarioeliminarpthisAdminInstance(Funcionario funcionarioeliminarpthisAdmin) {
        this.funcionarioeliminarpthisAdminInstance = funcionarioeliminarpthisAdmin;
        this.funcionarioeliminarpthisAdmin = funcionarioeliminarpthisAdmin != null ? funcionarioeliminarpthisAdmin.getOid() : null;
    }

    private void checkFuncionarioeliminarpthisAdmin() throws NotNullArgumentException {
        if(this.getFuncionarioeliminarpthisAdminInstance() == null || this.getFuncionarioeliminarpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_ELIMINAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_ELIMINAR_FUNCIONARIOELIMINARPTHISADMIN, FuncionarioConstants.SERV_ALIAS_ELIMINAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_ELIMINAR_FUNCIONARIOELIMINARPTHISADMIN);
        }
    }
}
