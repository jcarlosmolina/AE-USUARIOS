package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class DeshacerAsesorRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariodeshacerAsesorpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerAsesorpthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerAsesorpthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerAsesorpthisAgente() {
        return this.funcionariodeshacerAsesorpthisAgente;
    }
    
    public void setFuncionariodeshacerAsesorpthisAgente(FuncionarioOid funcionariodeshacerAsesorpthisAgente) {
        this.funcionariodeshacerAsesorpthisAgente = funcionariodeshacerAsesorpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerAsesorpthisAgenteInstance() {
        return this.funcionariodeshacerAsesorpthisAgenteInstance;
    }
    
    public void setFuncionariodeshacerAsesorpthisAgenteInstance(Funcionario funcionariodeshacerAsesorpthisAgente) {
        this.funcionariodeshacerAsesorpthisAgenteInstance = funcionariodeshacerAsesorpthisAgente;
        this.funcionariodeshacerAsesorpthisAgente = funcionariodeshacerAsesorpthisAgente != null ? funcionariodeshacerAsesorpthisAgente.getOid() : null;
    }

    private void checkFuncionariodeshacerAsesorpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerAsesorpthisAgenteInstance() == null || this.getFuncionariodeshacerAsesorpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERASESOR_FUNCIONARIODESHACERASESORPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_DESHACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERASESOR_FUNCIONARIODESHACERASESORPTHISAGENTE);
        }
    }
}
