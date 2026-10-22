package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class TBORRARRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioTBORRARpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioTBORRARpthisFuncionarioInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioTBORRARpthisFuncionario();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioTBORRARpthisFuncionario() {
        return this.funcionarioTBORRARpthisFuncionario;
    }
    
    public void setFuncionarioTBORRARpthisFuncionario(FuncionarioOid funcionarioTBORRARpthisFuncionario) {
        this.funcionarioTBORRARpthisFuncionario = funcionarioTBORRARpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioTBORRARpthisFuncionarioInstance() {
        return this.funcionarioTBORRARpthisFuncionarioInstance;
    }
    
    public void setFuncionarioTBORRARpthisFuncionarioInstance(Funcionario funcionarioTBORRARpthisFuncionario) {
        this.funcionarioTBORRARpthisFuncionarioInstance = funcionarioTBORRARpthisFuncionario;
        this.funcionarioTBORRARpthisFuncionario = funcionarioTBORRARpthisFuncionario != null ? funcionarioTBORRARpthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioTBORRARpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioTBORRARpthisFuncionarioInstance() == null || this.getFuncionarioTBORRARpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TBORRAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TBORRAR_FUNCIONARIOTBORRARPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_TBORRAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TBORRAR_FUNCIONARIOTBORRARPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
