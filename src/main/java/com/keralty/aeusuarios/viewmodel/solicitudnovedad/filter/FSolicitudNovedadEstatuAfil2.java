package com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FSolicitudNovedadEstatuAfil2 {

    @JsonProperty("vfnumradicado")
    private Long vfNumRadicado;

    @JsonProperty("vfdesde")
    private Date vfDesde;

    @JsonProperty("vfhasta")
    private Date vfHasta;

    @JsonProperty("vfestado")
    private Long vfEstado;

    @JsonProperty("vftiponovedad")
    private Long vfTipoNovedad;

    public FSolicitudNovedadEstatuAfil2() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVfNumRadicado() {
        return this.vfNumRadicado;
    }
    
    public void setVfNumRadicado(Long vfNumRadicado) {
        this.vfNumRadicado = vfNumRadicado;
    }

    @JsonIgnore
    public Date getVfDesde() {
        return this.vfDesde;
    }
    
    public void setVfDesde(Date vfDesde) {
        this.vfDesde = vfDesde;
    }

    @JsonIgnore
    public Date getVfHasta() {
        return this.vfHasta;
    }
    
    public void setVfHasta(Date vfHasta) {
        this.vfHasta = vfHasta;
    }

    @JsonIgnore
    public Long getVfEstado() {
        return this.vfEstado;
    }
    
    public void setVfEstado(Long vfEstado) {
        this.vfEstado = vfEstado;
    }

    @JsonIgnore
    public Long getVfTipoNovedad() {
        return this.vfTipoNovedad;
    }
    
    public void setVfTipoNovedad(Long vfTipoNovedad) {
        this.vfTipoNovedad = vfTipoNovedad;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADESTATUAFIL2);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFNUMRADICADO, vfNumRadicado);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFDESDE, vfDesde);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFHASTA, vfHasta);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFESTADO, vfEstado);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADESTATUAFIL2_VFTIPONOVEDAD, vfTipoNovedad);
        return filterRequest;
    }
}
