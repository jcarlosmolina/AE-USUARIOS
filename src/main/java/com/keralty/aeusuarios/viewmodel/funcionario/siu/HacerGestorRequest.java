package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class HacerGestorRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionariohacerGestorpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionariohacerGestorpthisFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerGestorpthisFuncionario();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerGestorpthisFuncionario() {
        return this.funcionariohacerGestorpthisFuncionario;
    }
    
    public void setFuncionariohacerGestorpthisFuncionario(FuncionarioOid funcionariohacerGestorpthisFuncionario) {
        this.funcionariohacerGestorpthisFuncionario = funcionariohacerGestorpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerGestorpthisFuncionarioInstance() {
        return this.funcionariohacerGestorpthisFuncionarioInstance;
    }
    
    public void setFuncionariohacerGestorpthisFuncionarioInstance(Funcionario funcionariohacerGestorpthisFuncionario) {
        this.funcionariohacerGestorpthisFuncionarioInstance = funcionariohacerGestorpthisFuncionario;
        this.funcionariohacerGestorpthisFuncionario = funcionariohacerGestorpthisFuncionario != null ? funcionariohacerGestorpthisFuncionario.getOid() : null;
    }

    private void checkFuncionariohacerGestorpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionariohacerGestorpthisFuncionarioInstance() == null || this.getFuncionariohacerGestorpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERGESTOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERGESTOR_FUNCIONARIOHACERGESTORPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_HACERGESTOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERGESTOR_FUNCIONARIOHACERGESTORPTHISFUNCIONARIO);
        }
    }
}
