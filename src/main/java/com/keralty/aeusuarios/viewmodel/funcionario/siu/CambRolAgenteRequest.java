package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;

public class CambRolAgenteRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionarioCambRolAgentepthisAgente;
    
    @JsonIgnore
    private Funcionario funcionarioCambRolAgentepthisAgenteInstance;

    @JsonProperty("p_evcrol_oid")
    private RolOid funcionarioCambRolAgentepevcRol;
    
    @JsonIgnore
    private Rol funcionarioCambRolAgentepevcRolInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioCambRolAgentepthisAgente();
        checkFuncionarioCambRolAgentepevcRol();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioCambRolAgentepthisAgente() {
        return this.funcionarioCambRolAgentepthisAgente;
    }
    
    public void setFuncionarioCambRolAgentepthisAgente(FuncionarioOid funcionarioCambRolAgentepthisAgente) {
        this.funcionarioCambRolAgentepthisAgente = funcionarioCambRolAgentepthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionarioCambRolAgentepthisAgenteInstance() {
        return this.funcionarioCambRolAgentepthisAgenteInstance;
    }
    
    public void setFuncionarioCambRolAgentepthisAgenteInstance(Funcionario funcionarioCambRolAgentepthisAgente) {
        this.funcionarioCambRolAgentepthisAgenteInstance = funcionarioCambRolAgentepthisAgente;
        this.funcionarioCambRolAgentepthisAgente = funcionarioCambRolAgentepthisAgente != null ? funcionarioCambRolAgentepthisAgente.getOid() : null;
    }

    private void checkFuncionarioCambRolAgentepthisAgente() throws NotNullArgumentException {
        if(this.getFuncionarioCambRolAgentepthisAgenteInstance() == null || this.getFuncionarioCambRolAgentepthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CAMBROLAGENTE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CAMBROLAGENTE_FUNCIONARIOCAMBROLAGENTEPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_CAMBROLAGENTE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CAMBROLAGENTE_FUNCIONARIOCAMBROLAGENTEPTHISAGENTE);
        }
    }

    @JsonIgnore
    public RolOid getFuncionarioCambRolAgentepevcRol() {
        return this.funcionarioCambRolAgentepevcRol;
    }
    
    public void setFuncionarioCambRolAgentepevcRol(RolOid funcionarioCambRolAgentepevcRol) {
        this.funcionarioCambRolAgentepevcRol = funcionarioCambRolAgentepevcRol;
    }

    @JsonIgnore
    public Rol getFuncionarioCambRolAgentepevcRolInstance() {
        return this.funcionarioCambRolAgentepevcRolInstance;
    }
    
    public void setFuncionarioCambRolAgentepevcRolInstance(Rol funcionarioCambRolAgentepevcRol) {
        this.funcionarioCambRolAgentepevcRolInstance = funcionarioCambRolAgentepevcRol;
        this.funcionarioCambRolAgentepevcRol = funcionarioCambRolAgentepevcRol != null ? funcionarioCambRolAgentepevcRol.getOid() : null;
    }

    private void checkFuncionarioCambRolAgentepevcRol() throws NotNullArgumentException {
        if(this.getFuncionarioCambRolAgentepevcRolInstance() == null || this.getFuncionarioCambRolAgentepevcRolInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CAMBROLAGENTE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CAMBROLAGENTE_FUNCIONARIOCAMBROLAGENTEPEVCROL, FuncionarioConstants.SERV_ALIAS_CAMBROLAGENTE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CAMBROLAGENTE_FUNCIONARIOCAMBROLAGENTEPEVCROL);
        }
    }
}
