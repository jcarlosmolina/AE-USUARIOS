package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class ModAsesorAgenciaRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionariomodAsesorAgenciapthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionariomodAsesorAgenciapthisFuncionarioInstance;

    @JsonProperty("penumusuario")
    private String funcionariomodAsesorAgenciapeNumUsuario;

    @JsonProperty("pecodjefe")
    private String funcionariomodAsesorAgenciapeCodJefe;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariomodAsesorAgenciapthisFuncionario();
        checkFuncionariomodAsesorAgenciapeNumUsuario();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariomodAsesorAgenciapthisFuncionario() {
        return this.funcionariomodAsesorAgenciapthisFuncionario;
    }
    
    public void setFuncionariomodAsesorAgenciapthisFuncionario(FuncionarioOid funcionariomodAsesorAgenciapthisFuncionario) {
        this.funcionariomodAsesorAgenciapthisFuncionario = funcionariomodAsesorAgenciapthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionariomodAsesorAgenciapthisFuncionarioInstance() {
        return this.funcionariomodAsesorAgenciapthisFuncionarioInstance;
    }
    
    public void setFuncionariomodAsesorAgenciapthisFuncionarioInstance(Funcionario funcionariomodAsesorAgenciapthisFuncionario) {
        this.funcionariomodAsesorAgenciapthisFuncionarioInstance = funcionariomodAsesorAgenciapthisFuncionario;
        this.funcionariomodAsesorAgenciapthisFuncionario = funcionariomodAsesorAgenciapthisFuncionario != null ? funcionariomodAsesorAgenciapthisFuncionario.getOid() : null;
    }

    private void checkFuncionariomodAsesorAgenciapthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionariomodAsesorAgenciapthisFuncionarioInstance() == null || this.getFuncionariomodAsesorAgenciapthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_MODASESORAGENCIA, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_MODASESORAGENCIA_FUNCIONARIOMODASESORAGENCIAPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_MODASESORAGENCIA, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_MODASESORAGENCIA_FUNCIONARIOMODASESORAGENCIAPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public String getFuncionariomodAsesorAgenciapeNumUsuario() {
        return this.funcionariomodAsesorAgenciapeNumUsuario;
    }
    
    public void setFuncionariomodAsesorAgenciapeNumUsuario(String funcionariomodAsesorAgenciapeNumUsuario) {
        this.funcionariomodAsesorAgenciapeNumUsuario = funcionariomodAsesorAgenciapeNumUsuario;
    }

    private void checkFuncionariomodAsesorAgenciapeNumUsuario() throws NotNullArgumentException {
        if(this.getFuncionariomodAsesorAgenciapeNumUsuario() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_MODASESORAGENCIA, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_MODASESORAGENCIA_FUNCIONARIOMODASESORAGENCIAPENUMUSUARIO, FuncionarioConstants.SERV_ALIAS_MODASESORAGENCIA, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_MODASESORAGENCIA_FUNCIONARIOMODASESORAGENCIAPENUMUSUARIO);
        }
    }

    @JsonIgnore
    public String getFuncionariomodAsesorAgenciapeCodJefe() {
        return this.funcionariomodAsesorAgenciapeCodJefe;
    }
    
    public void setFuncionariomodAsesorAgenciapeCodJefe(String funcionariomodAsesorAgenciapeCodJefe) {
        this.funcionariomodAsesorAgenciapeCodJefe = funcionariomodAsesorAgenciapeCodJefe;
    }
}
