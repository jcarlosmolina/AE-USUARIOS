package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class DeshacerGestorRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionariodeshacerGestorpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerGestorpthisFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerGestorpthisFuncionario();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerGestorpthisFuncionario() {
        return this.funcionariodeshacerGestorpthisFuncionario;
    }
    
    public void setFuncionariodeshacerGestorpthisFuncionario(FuncionarioOid funcionariodeshacerGestorpthisFuncionario) {
        this.funcionariodeshacerGestorpthisFuncionario = funcionariodeshacerGestorpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerGestorpthisFuncionarioInstance() {
        return this.funcionariodeshacerGestorpthisFuncionarioInstance;
    }
    
    public void setFuncionariodeshacerGestorpthisFuncionarioInstance(Funcionario funcionariodeshacerGestorpthisFuncionario) {
        this.funcionariodeshacerGestorpthisFuncionarioInstance = funcionariodeshacerGestorpthisFuncionario;
        this.funcionariodeshacerGestorpthisFuncionario = funcionariodeshacerGestorpthisFuncionario != null ? funcionariodeshacerGestorpthisFuncionario.getOid() : null;
    }

    private void checkFuncionariodeshacerGestorpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerGestorpthisFuncionarioInstance() == null || this.getFuncionariodeshacerGestorpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERGESTOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERGESTOR_FUNCIONARIODESHACERGESTORPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_DESHACERGESTOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERGESTOR_FUNCIONARIODESHACERGESTORPTHISFUNCIONARIO);
        }
    }
}
