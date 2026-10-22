package com.keralty.aeusuarios.viewmodel.grupoasignacion.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.GrupoAsignacionConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FGrupoAsignacionPorTipo {

    @JsonProperty("vftipo")
    private Long vfTipo;

    public FGrupoAsignacionPorTipo() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVfTipo() {
        return this.vfTipo;
    }
    
    public void setVfTipo(Long vfTipo) {
        this.vfTipo = vfTipo;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(GrupoAsignacionConstants.FILTER_NAME_FGRUPOASIGNACIONPORTIPO);
        filterRequest.addFilterVariable(GrupoAsignacionConstants.VAR_NAME_FGRUPOASIGNACIONPORTIPO_VFTIPO, vfTipo);
        return filterRequest;
    }
}
