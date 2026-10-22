package com.keralty.aeusuarios.viewmodel.grupoasignacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GrupoAsignacionConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.GrupoAsignacionOid;

public class AddFuncionarioGrupoRequest {

    @JsonProperty("p_thisgrupoasignacion_oid")
    private GrupoAsignacionOid grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion;
    
    @JsonIgnore
    private GrupoAsignacion grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid grupoAsignacionAddFuncionarioGrupopevcFuncionario;
    
    @JsonIgnore
    private Funcionario grupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion();
        checkGrupoAsignacionAddFuncionarioGrupopevcFuncionario();
    }

    @JsonIgnore
    public GrupoAsignacionOid getGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion() {
        return this.grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion;
    }
    
    public void setGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion(GrupoAsignacionOid grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion) {
        this.grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion = grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion;
    }

    @JsonIgnore
    public GrupoAsignacion getGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance() {
        return this.grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance;
    }
    
    public void setGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance(GrupoAsignacion grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion) {
        this.grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance = grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion;
        this.grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion = grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion != null ? grupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion.getOid() : null;
    }

    private void checkGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacion() throws NotNullArgumentException {
        if(this.getGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance() == null || this.getGrupoAsignacionAddFuncionarioGrupopthisGrupoAsignacionInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsignacionConstants.SERV_ID_ADDFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ID, GrupoAsignacionConstants.ARG_ID_ADDFUNCIONARIOGRUPO_GRUPOASIGNACIONADDFUNCIONARIOGRUPOPTHISGRUPOASIGNACION, GrupoAsignacionConstants.SERV_ALIAS_ADDFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ALIAS, GrupoAsignacionConstants.ARG_ALIAS_ADDFUNCIONARIOGRUPO_GRUPOASIGNACIONADDFUNCIONARIOGRUPOPTHISGRUPOASIGNACION);
        }
    }

    @JsonIgnore
    public FuncionarioOid getGrupoAsignacionAddFuncionarioGrupopevcFuncionario() {
        return this.grupoAsignacionAddFuncionarioGrupopevcFuncionario;
    }
    
    public void setGrupoAsignacionAddFuncionarioGrupopevcFuncionario(FuncionarioOid grupoAsignacionAddFuncionarioGrupopevcFuncionario) {
        this.grupoAsignacionAddFuncionarioGrupopevcFuncionario = grupoAsignacionAddFuncionarioGrupopevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getGrupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance() {
        return this.grupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance;
    }
    
    public void setGrupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance(Funcionario grupoAsignacionAddFuncionarioGrupopevcFuncionario) {
        this.grupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance = grupoAsignacionAddFuncionarioGrupopevcFuncionario;
        this.grupoAsignacionAddFuncionarioGrupopevcFuncionario = grupoAsignacionAddFuncionarioGrupopevcFuncionario != null ? grupoAsignacionAddFuncionarioGrupopevcFuncionario.getOid() : null;
    }

    private void checkGrupoAsignacionAddFuncionarioGrupopevcFuncionario() throws NotNullArgumentException {
        if(this.getGrupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance() == null || this.getGrupoAsignacionAddFuncionarioGrupopevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(GrupoAsignacionConstants.SERV_ID_ADDFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ID, GrupoAsignacionConstants.ARG_ID_ADDFUNCIONARIOGRUPO_GRUPOASIGNACIONADDFUNCIONARIOGRUPOPEVCFUNCIONARIO, GrupoAsignacionConstants.SERV_ALIAS_ADDFUNCIONARIOGRUPO, GrupoAsignacionConstants.CLASS_ALIAS, GrupoAsignacionConstants.ARG_ALIAS_ADDFUNCIONARIOGRUPO_GRUPOASIGNACIONADDFUNCIONARIOGRUPOPEVCFUNCIONARIO);
        }
    }
}
