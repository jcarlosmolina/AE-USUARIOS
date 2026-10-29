package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class HacerAreaMedicaRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariohacerAreaMedicapthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariohacerAreaMedicapthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerAreaMedicapthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerAreaMedicapthisAgente() {
        return this.funcionariohacerAreaMedicapthisAgente;
    }
    
    public void setFuncionariohacerAreaMedicapthisAgente(FuncionarioOid funcionariohacerAreaMedicapthisAgente) {
        this.funcionariohacerAreaMedicapthisAgente = funcionariohacerAreaMedicapthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerAreaMedicapthisAgenteInstance() {
        return this.funcionariohacerAreaMedicapthisAgenteInstance;
    }
    
    public void setFuncionariohacerAreaMedicapthisAgenteInstance(Funcionario funcionariohacerAreaMedicapthisAgente) {
        this.funcionariohacerAreaMedicapthisAgenteInstance = funcionariohacerAreaMedicapthisAgente;
        this.funcionariohacerAreaMedicapthisAgente = funcionariohacerAreaMedicapthisAgente != null ? funcionariohacerAreaMedicapthisAgente.getOid() : null;
    }

    private void checkFuncionariohacerAreaMedicapthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariohacerAreaMedicapthisAgenteInstance() == null || this.getFuncionariohacerAreaMedicapthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERAREAMEDICA, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERAREAMEDICA_FUNCIONARIOHACERAREAMEDICAPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_HACERAREAMEDICA, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERAREAMEDICA_FUNCIONARIOHACERAREAMEDICAPTHISAGENTE);
        }
    }
}
