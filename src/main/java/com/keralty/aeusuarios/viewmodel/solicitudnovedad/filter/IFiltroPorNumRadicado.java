package com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFiltroPorNumRadicado {

    @JsonProperty("vfnumradicado")
    private Long vfNumRadicado;

    public IFiltroPorNumRadicado() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVfNumRadicado() {
        return this.vfNumRadicado;
    }
    
    public void setVfNumRadicado(Long vfNumRadicado) {
        this.vfNumRadicado = vfNumRadicado;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudNovedadConstants.FILTER_NAME_IFILTROPORNUMRADICADO);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFILTROPORNUMRADICADO_VFNUMRADICADO, vfNumRadicado);
        return filterRequest;
    }
}
