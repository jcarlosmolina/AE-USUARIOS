package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class HacerAdminRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariohacerAdminpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariohacerAdminpthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerAdminpthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerAdminpthisAgente() {
        return this.funcionariohacerAdminpthisAgente;
    }
    
    public void setFuncionariohacerAdminpthisAgente(FuncionarioOid funcionariohacerAdminpthisAgente) {
        this.funcionariohacerAdminpthisAgente = funcionariohacerAdminpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerAdminpthisAgenteInstance() {
        return this.funcionariohacerAdminpthisAgenteInstance;
    }
    
    public void setFuncionariohacerAdminpthisAgenteInstance(Funcionario funcionariohacerAdminpthisAgente) {
        this.funcionariohacerAdminpthisAgenteInstance = funcionariohacerAdminpthisAgente;
        this.funcionariohacerAdminpthisAgente = funcionariohacerAdminpthisAgente != null ? funcionariohacerAdminpthisAgente.getOid() : null;
    }

    private void checkFuncionariohacerAdminpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariohacerAdminpthisAgenteInstance() == null || this.getFuncionariohacerAdminpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERADMIN, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERADMIN_FUNCIONARIOHACERADMINPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_HACERADMIN, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERADMIN_FUNCIONARIOHACERADMINPTHISAGENTE);
        }
    }
}
