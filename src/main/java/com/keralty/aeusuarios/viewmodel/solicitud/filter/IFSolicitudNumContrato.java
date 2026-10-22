package com.keralty.aeusuarios.viewmodel.solicitud.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFSolicitudNumContrato {

    @JsonProperty("v_numcontrato")
    private String vNumContrato;

    public IFSolicitudNumContrato() {
        // Default constructor
    }

    @JsonIgnore
    public String getVNumContrato() {
        return this.vNumContrato;
    }
    
    public void setVNumContrato(String vNumContrato) {
        this.vNumContrato = vNumContrato;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudConstants.FILTER_NAME_IFSOLICITUDNUMCONTRATO);
        filterRequest.addFilterVariable(SolicitudConstants.VAR_NAME_IFSOLICITUDNUMCONTRATO_VNUMCONTRATO, vNumContrato);
        return filterRequest;
    }
}
