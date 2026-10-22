package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class HacerMesaApoyoRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionariohacerMesaApoyopthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionariohacerMesaApoyopthisFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerMesaApoyopthisFuncionario();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerMesaApoyopthisFuncionario() {
        return this.funcionariohacerMesaApoyopthisFuncionario;
    }
    
    public void setFuncionariohacerMesaApoyopthisFuncionario(FuncionarioOid funcionariohacerMesaApoyopthisFuncionario) {
        this.funcionariohacerMesaApoyopthisFuncionario = funcionariohacerMesaApoyopthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerMesaApoyopthisFuncionarioInstance() {
        return this.funcionariohacerMesaApoyopthisFuncionarioInstance;
    }
    
    public void setFuncionariohacerMesaApoyopthisFuncionarioInstance(Funcionario funcionariohacerMesaApoyopthisFuncionario) {
        this.funcionariohacerMesaApoyopthisFuncionarioInstance = funcionariohacerMesaApoyopthisFuncionario;
        this.funcionariohacerMesaApoyopthisFuncionario = funcionariohacerMesaApoyopthisFuncionario != null ? funcionariohacerMesaApoyopthisFuncionario.getOid() : null;
    }

    private void checkFuncionariohacerMesaApoyopthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionariohacerMesaApoyopthisFuncionarioInstance() == null || this.getFuncionariohacerMesaApoyopthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERMESAAPOYO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERMESAAPOYO_FUNCIONARIOHACERMESAAPOYOPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_HACERMESAAPOYO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERMESAAPOYO_FUNCIONARIOHACERMESAAPOYOPTHISFUNCIONARIO);
        }
    }
}
