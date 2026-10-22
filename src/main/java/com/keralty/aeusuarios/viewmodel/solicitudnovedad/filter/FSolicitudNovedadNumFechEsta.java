package com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FSolicitudNovedadNumFechEsta {

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

    @JsonProperty("vfestadodoc")
    private Long vfEstadoDoc;

    public FSolicitudNovedadNumFechEsta() {
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

    @JsonIgnore
    public Long getVfEstadoDoc() {
        return this.vfEstadoDoc;
    }
    
    public void setVfEstadoDoc(Long vfEstadoDoc) {
        this.vfEstadoDoc = vfEstadoDoc;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(SolicitudNovedadConstants.FILTER_NAME_FSOLICITUDNOVEDADNUMFECHESTA);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFNUMRADICADO, vfNumRadicado);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFDESDE, vfDesde);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFHASTA, vfHasta);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADO, vfEstado);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFTIPONOVEDAD, vfTipoNovedad);
        filterRequest.addFilterVariable(SolicitudNovedadConstants.VAR_NAME_FSOLICITUDNOVEDADNUMFECHESTA_VFESTADODOC, vfEstadoDoc);
        return filterRequest;
    }
}
