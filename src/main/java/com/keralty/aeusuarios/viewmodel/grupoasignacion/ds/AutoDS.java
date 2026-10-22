package com.keralty.aeusuarios.viewmodel.grupoasignacion.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
public class AutoDS {

    @JsonProperty("id")
    private Long autoDSId;

    @JsonProperty("tipo")
    private Long autoDSTipo;

    @JsonProperty("nombre")
    private String autoDSNombre;

    @JsonProperty("descripcion")
    private String autoDSDescripcion;

    public AutoDS() {
    
    }

    public AutoDS(GrupoAsignacion instance) {
        if (instance != null) {
            this.autoDSId = instance.getGrupoAsignacionId();
            this.autoDSTipo = instance.getGrupoAsignacionTipo();
            this.autoDSNombre = instance.getGrupoAsignacionNombre();
            this.autoDSDescripcion = instance.getGrupoAsignacionDescripcion();
        }
    }

    @JsonIgnore
    public Long getAutoDSId() {
        return this.autoDSId;
    }
    
    public void setAutoDSId(Long autoDSId) {
        this.autoDSId = autoDSId;
    }

    @JsonIgnore
    public Long getAutoDSTipo() {
        return this.autoDSTipo;
    }
    
    public void setAutoDSTipo(Long autoDSTipo) {
        this.autoDSTipo = autoDSTipo;
    }

    @JsonIgnore
    public String getAutoDSNombre() {
        return this.autoDSNombre;
    }
    
    public void setAutoDSNombre(String autoDSNombre) {
        this.autoDSNombre = autoDSNombre;
    }

    @JsonIgnore
    public String getAutoDSDescripcion() {
        return this.autoDSDescripcion;
    }
    
    public void setAutoDSDescripcion(String autoDSDescripcion) {
        this.autoDSDescripcion = autoDSDescripcion;
    }
}
