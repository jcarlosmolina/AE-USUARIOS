package com.keralty.aeusuarios.viewmodel.productos.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFProductoNumero {

    @JsonProperty("v_numero")
    private Long vNumero;

    public IFProductoNumero() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVNumero() {
        return this.vNumero;
    }
    
    public void setVNumero(Long vNumero) {
        this.vNumero = vNumero;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(ProductosConstants.FILTER_NAME_IFPRODUCTONUMERO);
        filterRequest.addFilterVariable(ProductosConstants.VAR_NAME_IFPRODUCTONUMERO_VNUMERO, vNumero);
        return filterRequest;
    }
}
