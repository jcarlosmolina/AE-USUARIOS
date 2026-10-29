package com.keralty.aeusuarios.viewmodel.grupoasignacion.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
public class DSGrupoAsignacion {

    @JsonProperty("id")
    private Long dSGrupoAsignacionId;

    @JsonProperty("tipo")
    private Long dSGrupoAsignacionTipo;

    @JsonProperty("nombre")
    private String dSGrupoAsignacionNombre;

    @JsonProperty("descripcion")
    private String dSGrupoAsignacionDescripcion;

    public DSGrupoAsignacion() {
    
    }

    public DSGrupoAsignacion(GrupoAsignacion instance) {
        if (instance != null) {
            this.dSGrupoAsignacionId = instance.getGrupoAsignacionId();
            this.dSGrupoAsignacionTipo = instance.getGrupoAsignacionTipo();
            this.dSGrupoAsignacionNombre = instance.getGrupoAsignacionNombre();
            this.dSGrupoAsignacionDescripcion = instance.getGrupoAsignacionDescripcion();
        }
    }

    @JsonIgnore
    public Long getDSGrupoAsignacionId() {
        return this.dSGrupoAsignacionId;
    }
    
    public void setDSGrupoAsignacionId(Long dSGrupoAsignacionId) {
        this.dSGrupoAsignacionId = dSGrupoAsignacionId;
    }

    @JsonIgnore
    public Long getDSGrupoAsignacionTipo() {
        return this.dSGrupoAsignacionTipo;
    }
    
    public void setDSGrupoAsignacionTipo(Long dSGrupoAsignacionTipo) {
        this.dSGrupoAsignacionTipo = dSGrupoAsignacionTipo;
    }

    @JsonIgnore
    public String getDSGrupoAsignacionNombre() {
        return this.dSGrupoAsignacionNombre;
    }
    
    public void setDSGrupoAsignacionNombre(String dSGrupoAsignacionNombre) {
        this.dSGrupoAsignacionNombre = dSGrupoAsignacionNombre;
    }

    @JsonIgnore
    public String getDSGrupoAsignacionDescripcion() {
        return this.dSGrupoAsignacionDescripcion;
    }
    
    public void setDSGrupoAsignacionDescripcion(String dSGrupoAsignacionDescripcion) {
        this.dSGrupoAsignacionDescripcion = dSGrupoAsignacionDescripcion;
    }
}
