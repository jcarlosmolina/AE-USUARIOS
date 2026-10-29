package com.keralty.aeusuarios.viewmodel.planes.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FPlanesPorCodLegal {

    @JsonProperty("vfcodigolegal")
    private String vfCodigoLegal;

    public FPlanesPorCodLegal() {
        // Default constructor
    }

    @JsonIgnore
    public String getVfCodigoLegal() {
        return this.vfCodigoLegal;
    }
    
    public void setVfCodigoLegal(String vfCodigoLegal) {
        this.vfCodigoLegal = vfCodigoLegal;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(PlanesConstants.FILTER_NAME_FPLANESPORCODLEGAL);
        filterRequest.addFilterVariable(PlanesConstants.VAR_NAME_FPLANESPORCODLEGAL_VFCODIGOLEGAL, vfCodigoLegal);
        return filterRequest;
    }
}
