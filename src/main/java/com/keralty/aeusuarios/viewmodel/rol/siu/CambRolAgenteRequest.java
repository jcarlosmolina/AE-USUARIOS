package com.keralty.aeusuarios.viewmodel.rol.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;

public class CambRolAgenteRequest {

    @JsonProperty("p_thisrol_oid")
    private RolOid rolCambRolAgentepthisRol;
    
    @JsonIgnore
    private Rol rolCambRolAgentepthisRolInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid rolCambRolAgentepevcFuncionario;
    
    @JsonIgnore
    private Funcionario rolCambRolAgentepevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRolCambRolAgentepthisRol();
        checkRolCambRolAgentepevcFuncionario();
    }

    @JsonIgnore
    public RolOid getRolCambRolAgentepthisRol() {
        return this.rolCambRolAgentepthisRol;
    }
    
    public void setRolCambRolAgentepthisRol(RolOid rolCambRolAgentepthisRol) {
        this.rolCambRolAgentepthisRol = rolCambRolAgentepthisRol;
    }

    @JsonIgnore
    public Rol getRolCambRolAgentepthisRolInstance() {
        return this.rolCambRolAgentepthisRolInstance;
    }
    
    public void setRolCambRolAgentepthisRolInstance(Rol rolCambRolAgentepthisRol) {
        this.rolCambRolAgentepthisRolInstance = rolCambRolAgentepthisRol;
        this.rolCambRolAgentepthisRol = rolCambRolAgentepthisRol != null ? rolCambRolAgentepthisRol.getOid() : null;
    }

    private void checkRolCambRolAgentepthisRol() throws NotNullArgumentException {
        if(this.getRolCambRolAgentepthisRolInstance() == null || this.getRolCambRolAgentepthisRolInstance().isNull()) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_CAMBROLAGENTE, RolConstants.CLASS_ID, RolConstants.ARG_ID_CAMBROLAGENTE_ROLCAMBROLAGENTEPTHISROL, RolConstants.SERV_ALIAS_CAMBROLAGENTE, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_CAMBROLAGENTE_ROLCAMBROLAGENTEPTHISROL);
        }
    }

    @JsonIgnore
    public FuncionarioOid getRolCambRolAgentepevcFuncionario() {
        return this.rolCambRolAgentepevcFuncionario;
    }
    
    public void setRolCambRolAgentepevcFuncionario(FuncionarioOid rolCambRolAgentepevcFuncionario) {
        this.rolCambRolAgentepevcFuncionario = rolCambRolAgentepevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getRolCambRolAgentepevcFuncionarioInstance() {
        return this.rolCambRolAgentepevcFuncionarioInstance;
    }
    
    public void setRolCambRolAgentepevcFuncionarioInstance(Funcionario rolCambRolAgentepevcFuncionario) {
        this.rolCambRolAgentepevcFuncionarioInstance = rolCambRolAgentepevcFuncionario;
        this.rolCambRolAgentepevcFuncionario = rolCambRolAgentepevcFuncionario != null ? rolCambRolAgentepevcFuncionario.getOid() : null;
    }

    private void checkRolCambRolAgentepevcFuncionario() throws NotNullArgumentException {
        if(this.getRolCambRolAgentepevcFuncionarioInstance() == null || this.getRolCambRolAgentepevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_CAMBROLAGENTE, RolConstants.CLASS_ID, RolConstants.ARG_ID_CAMBROLAGENTE_ROLCAMBROLAGENTEPEVCFUNCIONARIO, RolConstants.SERV_ALIAS_CAMBROLAGENTE, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_CAMBROLAGENTE_ROLCAMBROLAGENTEPEVCFUNCIONARIO);
        }
    }
}
