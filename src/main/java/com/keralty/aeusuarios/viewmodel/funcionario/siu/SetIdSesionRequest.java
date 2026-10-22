package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class SetIdSesionRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionariosetIdSesionpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionariosetIdSesionpthisFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariosetIdSesionpthisFuncionario();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariosetIdSesionpthisFuncionario() {
        return this.funcionariosetIdSesionpthisFuncionario;
    }
    
    public void setFuncionariosetIdSesionpthisFuncionario(FuncionarioOid funcionariosetIdSesionpthisFuncionario) {
        this.funcionariosetIdSesionpthisFuncionario = funcionariosetIdSesionpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionariosetIdSesionpthisFuncionarioInstance() {
        return this.funcionariosetIdSesionpthisFuncionarioInstance;
    }
    
    public void setFuncionariosetIdSesionpthisFuncionarioInstance(Funcionario funcionariosetIdSesionpthisFuncionario) {
        this.funcionariosetIdSesionpthisFuncionarioInstance = funcionariosetIdSesionpthisFuncionario;
        this.funcionariosetIdSesionpthisFuncionario = funcionariosetIdSesionpthisFuncionario != null ? funcionariosetIdSesionpthisFuncionario.getOid() : null;
    }

    private void checkFuncionariosetIdSesionpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionariosetIdSesionpthisFuncionarioInstance() == null || this.getFuncionariosetIdSesionpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_SETIDSESION, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_SETIDSESION_FUNCIONARIOSETIDSESIONPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_SETIDSESION, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_SETIDSESION_FUNCIONARIOSETIDSESIONPTHISFUNCIONARIO);
        }
    }
}
