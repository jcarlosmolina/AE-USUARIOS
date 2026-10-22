package com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFSolNovValidadorUsuarios {

    @JsonProperty("vfnumcontrato")
    private String vfNumContrato;

    @JsonProperty("vfplan")
    private String vfPlan;

    @JsonProperty("vfproducto")
    private String vfProducto;

    @JsonProperty("vftipoident")
    private String vfTipoIdent;

    @JsonProperty("vfnumident")
    private String vfNumIdent;

    public IFSolNovValidadorUsuarios() {
        // Default constructor
    }

    @JsonIgnore
    public String getVfNumContrato() {
        return this.vfNumContrato;
    }
    
    public void setVfNumContrato(String vfNumContrato) {
        this.vfNumContrato = vfNumContrato;
    }

    @JsonIgnore
    public String getVfPlan() {
        return this.vfPlan;
    }
    
    public void setVfPlan(String vfPlan) {
        this.vfPlan = vfPlan;
    }

    @JsonIgnore
    public String getVfProducto() {
        return this.vfProducto;
    }
    
    public void setVfProducto(String vfProducto) {
        this.vfProducto = vfProducto;
    }

    @JsonIgnore
    public String getVfTipoIdent() {
        return this.vfTipoIdent;
    }
    
    public void setVfTipoIdent(String vfTipoIdent) {
        this.vfTipoIdent = vfTipoIdent;
    }

    @JsonIgnore
    public String getVfNumIdent() {
        return this.vfNumIdent;
    }
    
    public void setVfNumIdent(String vfNumIdent) {
        this.vfNumIdent = vfNumIdent;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudNovedadConstants.FILTER_NAME_IFSOLNOVVALIDADORUSUARIOS);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMCONTRATO, vfNumContrato);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPLAN, vfPlan);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFPRODUCTO, vfProducto);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFTIPOIDENT, vfTipoIdent);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_IFSOLNOVVALIDADORUSUARIOS_VFNUMIDENT, vfNumIdent);
        return filterRequest;
    }
}
