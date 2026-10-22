package com.keralty.aeusuarios.viewmodel.grupoasignacion.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.GrupoAsignacion;
public class ICGrupoAsignacion {

    @JsonProperty("nombre")
    private String iCGrupoAsignacionNombre;

    public ICGrupoAsignacion() {
    
    }

    public ICGrupoAsignacion(GrupoAsignacion instance) {
        if (instance != null) {
            this.iCGrupoAsignacionNombre = instance.getGrupoAsignacionNombre();
        }
    }

    @JsonIgnore
    public String getICGrupoAsignacionNombre() {
        return this.iCGrupoAsignacionNombre;
    }
    
    public void setICGrupoAsignacionNombre(String iCGrupoAsignacionNombre) {
        this.iCGrupoAsignacionNombre = iCGrupoAsignacionNombre;
    }
}
