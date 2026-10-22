package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;

public class DelFuncionarioGrupoRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioDelFuncionarioGrupopthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioDelFuncionarioGrupopthisFuncionarioInstance;

    @JsonProperty("p_evcgrupoasignacion_oid")
    private GrupoAsignacionOid funcionarioDelFuncionarioGrupopevcGrupoAsignacion;
    
    @JsonIgnore
    private GrupoAsignacion funcionarioDelFuncionarioGrupopevcGrupoAsignacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioDelFuncionarioGrupopthisFuncionario();
        checkFuncionarioDelFuncionarioGrupopevcGrupoAsignacion();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioDelFuncionarioGrupopthisFuncionario() {
        return this.funcionarioDelFuncionarioGrupopthisFuncionario;
    }
    
    public void setFuncionarioDelFuncionarioGrupopthisFuncionario(FuncionarioOid funcionarioDelFuncionarioGrupopthisFuncionario) {
        this.funcionarioDelFuncionarioGrupopthisFuncionario = funcionarioDelFuncionarioGrupopthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioDelFuncionarioGrupopthisFuncionarioInstance() {
        return this.funcionarioDelFuncionarioGrupopthisFuncionarioInstance;
    }
    
    public void setFuncionarioDelFuncionarioGrupopthisFuncionarioInstance(Funcionario funcionarioDelFuncionarioGrupopthisFuncionario) {
        this.funcionarioDelFuncionarioGrupopthisFuncionarioInstance = funcionarioDelFuncionarioGrupopthisFuncionario;
        this.funcionarioDelFuncionarioGrupopthisFuncionario = funcionarioDelFuncionarioGrupopthisFuncionario != null ? funcionarioDelFuncionarioGrupopthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioDelFuncionarioGrupopthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioDelFuncionarioGrupopthisFuncionarioInstance() == null || this.getFuncionarioDelFuncionarioGrupopthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELFUNCIONARIOGRUPO_FUNCIONARIODELFUNCIONARIOGRUPOPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_DELFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELFUNCIONARIOGRUPO_FUNCIONARIODELFUNCIONARIOGRUPOPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public GrupoAsignacionOid getFuncionarioDelFuncionarioGrupopevcGrupoAsignacion() {
        return this.funcionarioDelFuncionarioGrupopevcGrupoAsignacion;
    }
    
    public void setFuncionarioDelFuncionarioGrupopevcGrupoAsignacion(GrupoAsignacionOid funcionarioDelFuncionarioGrupopevcGrupoAsignacion) {
        this.funcionarioDelFuncionarioGrupopevcGrupoAsignacion = funcionarioDelFuncionarioGrupopevcGrupoAsignacion;
    }

    @JsonIgnore
    public GrupoAsignacion getFuncionarioDelFuncionarioGrupopevcGrupoAsignacionInstance() {
        return this.funcionarioDelFuncionarioGrupopevcGrupoAsignacionInstance;
    }
    
    public void setFuncionarioDelFuncionarioGrupopevcGrupoAsignacionInstance(GrupoAsignacion funcionarioDelFuncionarioGrupopevcGrupoAsignacion) {
        this.funcionarioDelFuncionarioGrupopevcGrupoAsignacionInstance = funcionarioDelFuncionarioGrupopevcGrupoAsignacion;
        this.funcionarioDelFuncionarioGrupopevcGrupoAsignacion = funcionarioDelFuncionarioGrupopevcGrupoAsignacion != null ? funcionarioDelFuncionarioGrupopevcGrupoAsignacion.getOid() : null;
    }

    private void checkFuncionarioDelFuncionarioGrupopevcGrupoAsignacion() throws NotNullArgumentException {
        if(this.getFuncionarioDelFuncionarioGrupopevcGrupoAsignacionInstance() == null || this.getFuncionarioDelFuncionarioGrupopevcGrupoAsignacionInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELFUNCIONARIOGRUPO_FUNCIONARIODELFUNCIONARIOGRUPOPEVCGRUPOASIGNACION, FuncionarioConstants.SERV_ALIAS_DELFUNCIONARIOGRUPO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELFUNCIONARIOGRUPO_FUNCIONARIODELFUNCIONARIOGRUPOPEVCGRUPOASIGNACION);
        }
    }
}
