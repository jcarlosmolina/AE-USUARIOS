package com.keralty.aeusuarios.viewmodel.grupoasignacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GrupoAsignacionConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;

public class DelFuncionarioGrupoRequest {

    @JsonProperty("p_thisgrupoasignacion_oid")
    private GrupoAsignacionOid grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion;
    
    @JsonIgnore
    private GrupoAsignacion grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid grupoAsignacionDelFuncionarioGrupopevcFuncionario;
    
    @JsonIgnore
    private Funcionario grupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion();
        checkGrupoAsignacionDelFuncionarioGrupopevcFuncionario();
    }

    @JsonIgnore
    public GrupoAsignacionOid getGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion() {
        return this.grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion;
    }
    
    public void setGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion(GrupoAsignacionOid grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion) {
        this.grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion = grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion;
    }

    @JsonIgnore
    public GrupoAsignacion getGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance() {
        return this.grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance;
    }
    
    public void setGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance(GrupoAsignacion grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion) {
        this.grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance = grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion;
        this.grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion = grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion != null ? grupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion.getOid() : null;
    }

    private void checkGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacion() throws NotNullArgumentException {
        if(this.getGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance() == null || this.getGrupoAsignacionDelFuncionarioGrupopthisGrupoAsignacionInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsignacionConstants.SERV_ID_DELFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ID, GrupoAsignacionConstants.ARG_ID_DELFUNCIONARIOGRUPO_GRUPOASIGNACIONDELFUNCIONARIOGRUPOPTHISGRUPOASIGNACION, GrupoAsignacionConstants.SERV_ALIAS_DELFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ALIAS, GrupoAsignacionConstants.ARG_ALIAS_DELFUNCIONARIOGRUPO_GRUPOASIGNACIONDELFUNCIONARIOGRUPOPTHISGRUPOASIGNACION);
        }
    }

    @JsonIgnore
    public FuncionarioOid getGrupoAsignacionDelFuncionarioGrupopevcFuncionario() {
        return this.grupoAsignacionDelFuncionarioGrupopevcFuncionario;
    }
    
    public void setGrupoAsignacionDelFuncionarioGrupopevcFuncionario(FuncionarioOid grupoAsignacionDelFuncionarioGrupopevcFuncionario) {
        this.grupoAsignacionDelFuncionarioGrupopevcFuncionario = grupoAsignacionDelFuncionarioGrupopevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getGrupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance() {
        return this.grupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance;
    }
    
    public void setGrupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance(Funcionario grupoAsignacionDelFuncionarioGrupopevcFuncionario) {
        this.grupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance = grupoAsignacionDelFuncionarioGrupopevcFuncionario;
        this.grupoAsignacionDelFuncionarioGrupopevcFuncionario = grupoAsignacionDelFuncionarioGrupopevcFuncionario != null ? grupoAsignacionDelFuncionarioGrupopevcFuncionario.getOid() : null;
    }

    private void checkGrupoAsignacionDelFuncionarioGrupopevcFuncionario() throws NotNullArgumentException {
        if(this.getGrupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance() == null || this.getGrupoAsignacionDelFuncionarioGrupopevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsignacionConstants.SERV_ID_DELFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ID, GrupoAsignacionConstants.ARG_ID_DELFUNCIONARIOGRUPO_GRUPOASIGNACIONDELFUNCIONARIOGRUPOPEVCFUNCIONARIO, GrupoAsignacionConstants.SERV_ALIAS_DELFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ALIAS, GrupoAsignacionConstants.ARG_ALIAS_DELFUNCIONARIOGRUPO_GRUPOASIGNACIONDELFUNCIONARIOGRUPOPEVCFUNCIONARIO);
        }
    }
}
