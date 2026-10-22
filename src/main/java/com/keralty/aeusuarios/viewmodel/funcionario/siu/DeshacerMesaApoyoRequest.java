package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class DeshacerMesaApoyoRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionariodeshacerMesaApoyopthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerMesaApoyopthisFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerMesaApoyopthisFuncionario();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerMesaApoyopthisFuncionario() {
        return this.funcionariodeshacerMesaApoyopthisFuncionario;
    }
    
    public void setFuncionariodeshacerMesaApoyopthisFuncionario(FuncionarioOid funcionariodeshacerMesaApoyopthisFuncionario) {
        this.funcionariodeshacerMesaApoyopthisFuncionario = funcionariodeshacerMesaApoyopthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerMesaApoyopthisFuncionarioInstance() {
        return this.funcionariodeshacerMesaApoyopthisFuncionarioInstance;
    }
    
    public void setFuncionariodeshacerMesaApoyopthisFuncionarioInstance(Funcionario funcionariodeshacerMesaApoyopthisFuncionario) {
        this.funcionariodeshacerMesaApoyopthisFuncionarioInstance = funcionariodeshacerMesaApoyopthisFuncionario;
        this.funcionariodeshacerMesaApoyopthisFuncionario = funcionariodeshacerMesaApoyopthisFuncionario != null ? funcionariodeshacerMesaApoyopthisFuncionario.getOid() : null;
    }

    private void checkFuncionariodeshacerMesaApoyopthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerMesaApoyopthisFuncionarioInstance() == null || this.getFuncionariodeshacerMesaApoyopthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERMESAAPOYO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERMESAAPOYO_FUNCIONARIODESHACERMESAAPOYOPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_DESHACERMESAAPOYO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERMESAAPOYO_FUNCIONARIODESHACERMESAAPOYOPTHISFUNCIONARIO);
        }
    }
}
