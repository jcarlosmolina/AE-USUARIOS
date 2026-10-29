package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class DeshacerAdminRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariodeshacerAdminpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerAdminpthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerAdminpthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerAdminpthisAgente() {
        return this.funcionariodeshacerAdminpthisAgente;
    }
    
    public void setFuncionariodeshacerAdminpthisAgente(FuncionarioOid funcionariodeshacerAdminpthisAgente) {
        this.funcionariodeshacerAdminpthisAgente = funcionariodeshacerAdminpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerAdminpthisAgenteInstance() {
        return this.funcionariodeshacerAdminpthisAgenteInstance;
    }
    
    public void setFuncionariodeshacerAdminpthisAgenteInstance(Funcionario funcionariodeshacerAdminpthisAgente) {
        this.funcionariodeshacerAdminpthisAgenteInstance = funcionariodeshacerAdminpthisAgente;
        this.funcionariodeshacerAdminpthisAgente = funcionariodeshacerAdminpthisAgente != null ? funcionariodeshacerAdminpthisAgente.getOid() : null;
    }

    private void checkFuncionariodeshacerAdminpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerAdminpthisAgenteInstance() == null || this.getFuncionariodeshacerAdminpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERADMIN, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERADMIN_FUNCIONARIODESHACERADMINPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_DESHACERADMIN, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERADMIN_FUNCIONARIODESHACERADMINPTHISAGENTE);
        }
    }
}
