package com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FSolicitudNovedadNumFechas {

    @JsonProperty("vfnumradicado")
    private Long vfNumRadicado;

    @JsonProperty("vfdesde")
    private Date vfDesde;

    @JsonProperty("vfhasta")
    private Date vfHasta;

    public FSolicitudNovedadNumFechas() {
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

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADNUMFECHAS);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFNUMRADICADO, vfNumRadicado);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFDESDE, vfDesde);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHAS_VFHASTA, vfHasta);
        return filterRequest;
    }
}
