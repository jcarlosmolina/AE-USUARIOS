package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class HacerAfiliacionesRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariohacerAfiliacionespthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariohacerAfiliacionespthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerAfiliacionespthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerAfiliacionespthisAgente() {
        return this.funcionariohacerAfiliacionespthisAgente;
    }
    
    public void setFuncionariohacerAfiliacionespthisAgente(FuncionarioOid funcionariohacerAfiliacionespthisAgente) {
        this.funcionariohacerAfiliacionespthisAgente = funcionariohacerAfiliacionespthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerAfiliacionespthisAgenteInstance() {
        return this.funcionariohacerAfiliacionespthisAgenteInstance;
    }
    
    public void setFuncionariohacerAfiliacionespthisAgenteInstance(Funcionario funcionariohacerAfiliacionespthisAgente) {
        this.funcionariohacerAfiliacionespthisAgenteInstance = funcionariohacerAfiliacionespthisAgente;
        this.funcionariohacerAfiliacionespthisAgente = funcionariohacerAfiliacionespthisAgente != null ? funcionariohacerAfiliacionespthisAgente.getOid() : null;
    }

    private void checkFuncionariohacerAfiliacionespthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariohacerAfiliacionespthisAgenteInstance() == null || this.getFuncionariohacerAfiliacionespthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERAFILIACIONES, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERAFILIACIONES_FUNCIONARIOHACERAFILIACIONESPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_HACERAFILIACIONES, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERAFILIACIONES_FUNCIONARIOHACERAFILIACIONESPTHISAGENTE);
        }
    }
}
