package com.keralty.aeusuarios.viewmodel.rol.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFRolPorNombre {

    @JsonProperty("v_nombre")
    private String vNombre;

    public IFRolPorNombre() {
        // Default constructor
    }

    @JsonIgnore
    public String getVNombre() {
        return this.vNombre;
    }
    
    public void setVNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(RolConstants.FILTER_NAME_IFROLPORNOMBRE);
        filterRequest.addFilterVariable(RolConstants.VAR_NAME_IFROLPORNOMBRE_VNOMBRE, vNombre);
        return filterRequest;
    }
}
