package com.keralty.aeusuarios.viewmodel.planes.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FPlanVarios {

    @JsonProperty("vo_producto")
    private ProductosOid voProducto;

    @JsonProperty("v_nombre")
    private String vNombre;

    @JsonProperty("v_esbancorep")
    private Boolean vEsBancoRep;

    @JsonProperty("vesvoluntario")
    private Boolean vEsVoluntario;

    public FPlanVarios() {
        // Default constructor
    }

    @JsonIgnore
    public ProductosOid getVoProducto() {
        return this.voProducto;
    }
    
    public void setVoProducto(ProductosOid voProducto) {
        this.voProducto = voProducto;
    }

    @JsonIgnore
    public String getVNombre() {
        return this.vNombre;
    }
    
    public void setVNombre(String vNombre) {
        this.vNombre = vNombre;
    }

    @JsonIgnore
    public Boolean getVEsBancoRep() {
        return this.vEsBancoRep;
    }
    
    public void setVEsBancoRep(Boolean vEsBancoRep) {
        this.vEsBancoRep = vEsBancoRep;
    }

    @JsonIgnore
    public Boolean getVEsVoluntario() {
        return this.vEsVoluntario;
    }
    
    public void setVEsVoluntario(Boolean vEsVoluntario) {
        this.vEsVoluntario = vEsVoluntario;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(PlanesConstants.FILTER_NAME_FPLANVARIOS);
        filterRequest.addFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VOPRODUCTO, voProducto);
        filterRequest.addFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VNOMBRE, vNombre);
        filterRequest.addFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VESBANCOREP, vEsBancoRep);
        filterRequest.addFilterVariable(PlanesConstants.VAR_NAME_FPLANVARIOS_VESVOLUNTARIO, vEsVoluntario);
        return filterRequest;
    }
}
