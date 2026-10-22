package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class HacerSuperAdminRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariohacerSuperAdminpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariohacerSuperAdminpthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerSuperAdminpthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerSuperAdminpthisAgente() {
        return this.funcionariohacerSuperAdminpthisAgente;
    }
    
    public void setFuncionariohacerSuperAdminpthisAgente(FuncionarioOid funcionariohacerSuperAdminpthisAgente) {
        this.funcionariohacerSuperAdminpthisAgente = funcionariohacerSuperAdminpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerSuperAdminpthisAgenteInstance() {
        return this.funcionariohacerSuperAdminpthisAgenteInstance;
    }
    
    public void setFuncionariohacerSuperAdminpthisAgenteInstance(Funcionario funcionariohacerSuperAdminpthisAgente) {
        this.funcionariohacerSuperAdminpthisAgenteInstance = funcionariohacerSuperAdminpthisAgente;
        this.funcionariohacerSuperAdminpthisAgente = funcionariohacerSuperAdminpthisAgente != null ? funcionariohacerSuperAdminpthisAgente.getOid() : null;
    }

    private void checkFuncionariohacerSuperAdminpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariohacerSuperAdminpthisAgenteInstance() == null || this.getFuncionariohacerSuperAdminpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERSUPERADMIN, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERSUPERADMIN_FUNCIONARIOHACERSUPERADMINPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_HACERSUPERADMIN, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERSUPERADMIN_FUNCIONARIOHACERSUPERADMINPTHISAGENTE);
        }
    }
}
