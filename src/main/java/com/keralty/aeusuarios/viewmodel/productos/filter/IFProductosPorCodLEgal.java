package com.keralty.aeusuarios.viewmodel.productos.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFProductosPorCodLEgal {

    @JsonProperty("vcodlegal")
    private String vCodLegal;

    public IFProductosPorCodLEgal() {
        // Default constructor
    }

    @JsonIgnore
    public String getVCodLegal() {
        return this.vCodLegal;
    }
    
    public void setVCodLegal(String vCodLegal) {
        this.vCodLegal = vCodLegal;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ProductosConstants.FILTER_NAME_IFPRODUCTOSPORCODLEGAL);
        filterRequest.addFilterVariable(ProductosConstants.VAR_NAME_IFPRODUCTOSPORCODLEGAL_VCODLEGAL, vCodLegal);
        return filterRequest;
    }
}
