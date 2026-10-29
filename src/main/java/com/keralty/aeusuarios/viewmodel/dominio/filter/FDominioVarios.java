package com.keralty.aeusuarios.viewmodel.dominio.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FDominioVarios {

    @JsonProperty("vo_producto")
    private ProductosOid voProducto;

    @JsonProperty("vo_plan")
    private PlanesOid voPlan;

    @JsonProperty("v_nuevaafiliacion")
    private Boolean vNuevaAfiliacion;

    @JsonProperty("v_inclusion")
    private Boolean vInclusion;

    @JsonProperty("vo_rol")
    private RolOid voRol;

    public FDominioVarios() {
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
    public PlanesOid getVoPlan() {
        return this.voPlan;
    }
    
    public void setVoPlan(PlanesOid voPlan) {
        this.voPlan = voPlan;
    }

    @JsonIgnore
    public Boolean getVNuevaAfiliacion() {
        return this.vNuevaAfiliacion;
    }
    
    public void setVNuevaAfiliacion(Boolean vNuevaAfiliacion) {
        this.vNuevaAfiliacion = vNuevaAfiliacion;
    }

    @JsonIgnore
    public Boolean getVInclusion() {
        return this.vInclusion;
    }
    
    public void setVInclusion(Boolean vInclusion) {
        this.vInclusion = vInclusion;
    }

    @JsonIgnore
    public RolOid getVoRol() {
        return this.voRol;
    }
    
    public void setVoRol(RolOid voRol) {
        this.voRol = voRol;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(DominioConstants.FILTER_NAME_FDOMINIOVARIOS);
        filterRequest.addFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPRODUCTO, voProducto);
        filterRequest.addFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOPLAN, voPlan);
        filterRequest.addFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VNUEVAAFILIACION, vNuevaAfiliacion);
        filterRequest.addFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VINCLUSION, vInclusion);
        filterRequest.addFilterVariable(DominioConstants.VAR_NAME_FDOMINIOVARIOS_VOROL, voRol);
        return filterRequest;
    }
}
