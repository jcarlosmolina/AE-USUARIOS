package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;

public class AddFuncionarioGrupoRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioAddFuncionarioGrupopthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioAddFuncionarioGrupopthisFuncionarioInstance;

    @JsonProperty("p_evcgrupoasignacion_oid")
    private GrupoAsignacionOid funcionarioAddFuncionarioGrupopevcGrupoAsignacion;
    
    @JsonIgnore
    private GrupoAsignacion funcionarioAddFuncionarioGrupopevcGrupoAsignacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioAddFuncionarioGrupopthisFuncionario();
        checkFuncionarioAddFuncionarioGrupopevcGrupoAsignacion();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioAddFuncionarioGrupopthisFuncionario() {
        return this.funcionarioAddFuncionarioGrupopthisFuncionario;
    }
    
    public void setFuncionarioAddFuncionarioGrupopthisFuncionario(FuncionarioOid funcionarioAddFuncionarioGrupopthisFuncionario) {
        this.funcionarioAddFuncionarioGrupopthisFuncionario = funcionarioAddFuncionarioGrupopthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioAddFuncionarioGrupopthisFuncionarioInstance() {
        return this.funcionarioAddFuncionarioGrupopthisFuncionarioInstance;
    }
    
    public void setFuncionarioAddFuncionarioGrupopthisFuncionarioInstance(Funcionario funcionarioAddFuncionarioGrupopthisFuncionario) {
        this.funcionarioAddFuncionarioGrupopthisFuncionarioInstance = funcionarioAddFuncionarioGrupopthisFuncionario;
        this.funcionarioAddFuncionarioGrupopthisFuncionario = funcionarioAddFuncionarioGrupopthisFuncionario != null ? funcionarioAddFuncionarioGrupopthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioAddFuncionarioGrupopthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioAddFuncionarioGrupopthisFuncionarioInstance() == null || this.getFuncionarioAddFuncionarioGrupopthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_ADDFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_ADDFUNCIONARIOGRUPO_FUNCIONARIOADDFUNCIONARIOGRUPOPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_ADDFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_ADDFUNCIONARIOGRUPO_FUNCIONARIOADDFUNCIONARIOGRUPOPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public GrupoAsignacionOid getFuncionarioAddFuncionarioGrupopevcGrupoAsignacion() {
        return this.funcionarioAddFuncionarioGrupopevcGrupoAsignacion;
    }
    
    public void setFuncionarioAddFuncionarioGrupopevcGrupoAsignacion(GrupoAsignacionOid funcionarioAddFuncionarioGrupopevcGrupoAsignacion) {
        this.funcionarioAddFuncionarioGrupopevcGrupoAsignacion = funcionarioAddFuncionarioGrupopevcGrupoAsignacion;
    }

    @JsonIgnore
    public GrupoAsignacion getFuncionarioAddFuncionarioGrupopevcGrupoAsignacionInstance() {
        return this.funcionarioAddFuncionarioGrupopevcGrupoAsignacionInstance;
    }
    
    public void setFuncionarioAddFuncionarioGrupopevcGrupoAsignacionInstance(GrupoAsignacion funcionarioAddFuncionarioGrupopevcGrupoAsignacion) {
        this.funcionarioAddFuncionarioGrupopevcGrupoAsignacionInstance = funcionarioAddFuncionarioGrupopevcGrupoAsignacion;
        this.funcionarioAddFuncionarioGrupopevcGrupoAsignacion = funcionarioAddFuncionarioGrupopevcGrupoAsignacion != null ? funcionarioAddFuncionarioGrupopevcGrupoAsignacion.getOid() : null;
    }

    private void checkFuncionarioAddFuncionarioGrupopevcGrupoAsignacion() throws NotNullArgumentException {
        if(this.getFuncionarioAddFuncionarioGrupopevcGrupoAsignacionInstance() == null || this.getFuncionarioAddFuncionarioGrupopevcGrupoAsignacionInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_ADDFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_ADDFUNCIONARIOGRUPO_FUNCIONARIOADDFUNCIONARIOGRUPOPEVCGRUPOASIGNACION, FuncionarioConstants.SERV_ALIAS_ADDFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_ADDFUNCIONARIOGRUPO_FUNCIONARIOADDFUNCIONARIOGRUPOPEVCGRUPOASIGNACION);
        }
    }
}
