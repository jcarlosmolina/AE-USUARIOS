package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class DeshacerSuperAdminRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariodeshacerSuperAdminpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerSuperAdminpthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerSuperAdminpthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerSuperAdminpthisAgente() {
        return this.funcionariodeshacerSuperAdminpthisAgente;
    }
    
    public void setFuncionariodeshacerSuperAdminpthisAgente(FuncionarioOid funcionariodeshacerSuperAdminpthisAgente) {
        this.funcionariodeshacerSuperAdminpthisAgente = funcionariodeshacerSuperAdminpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerSuperAdminpthisAgenteInstance() {
        return this.funcionariodeshacerSuperAdminpthisAgenteInstance;
    }
    
    public void setFuncionariodeshacerSuperAdminpthisAgenteInstance(Funcionario funcionariodeshacerSuperAdminpthisAgente) {
        this.funcionariodeshacerSuperAdminpthisAgenteInstance = funcionariodeshacerSuperAdminpthisAgente;
        this.funcionariodeshacerSuperAdminpthisAgente = funcionariodeshacerSuperAdminpthisAgente != null ? funcionariodeshacerSuperAdminpthisAgente.getOid() : null;
    }

    private void checkFuncionariodeshacerSuperAdminpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerSuperAdminpthisAgenteInstance() == null || this.getFuncionariodeshacerSuperAdminpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERSUPERADMIN, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERSUPERADMIN_FUNCIONARIODESHACERSUPERADMINPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_DESHACERSUPERADMIN, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERSUPERADMIN_FUNCIONARIODESHACERSUPERADMINPTHISAGENTE);
        }
    }
}
