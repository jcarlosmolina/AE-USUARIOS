package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class DeshacerAreaMedicaRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariodeshacerAreaMedicapthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerAreaMedicapthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerAreaMedicapthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerAreaMedicapthisAgente() {
        return this.funcionariodeshacerAreaMedicapthisAgente;
    }
    
    public void setFuncionariodeshacerAreaMedicapthisAgente(FuncionarioOid funcionariodeshacerAreaMedicapthisAgente) {
        this.funcionariodeshacerAreaMedicapthisAgente = funcionariodeshacerAreaMedicapthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerAreaMedicapthisAgenteInstance() {
        return this.funcionariodeshacerAreaMedicapthisAgenteInstance;
    }
    
    public void setFuncionariodeshacerAreaMedicapthisAgenteInstance(Funcionario funcionariodeshacerAreaMedicapthisAgente) {
        this.funcionariodeshacerAreaMedicapthisAgenteInstance = funcionariodeshacerAreaMedicapthisAgente;
        this.funcionariodeshacerAreaMedicapthisAgente = funcionariodeshacerAreaMedicapthisAgente != null ? funcionariodeshacerAreaMedicapthisAgente.getOid() : null;
    }

    private void checkFuncionariodeshacerAreaMedicapthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerAreaMedicapthisAgenteInstance() == null || this.getFuncionariodeshacerAreaMedicapthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERAREAMEDICA, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERAREAMEDICA_FUNCIONARIODESHACERAREAMEDICAPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_DESHACERAREAMEDICA, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERAREAMEDICA_FUNCIONARIODESHACERAREAMEDICAPTHISAGENTE);
        }
    }
}
