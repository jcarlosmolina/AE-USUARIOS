package com.keralty.aeusuarios.viewmodel.frecuenciaact.filter;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.FrecuenciaActConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class FFrecuenciaActVarios {

    @JsonProperty("v_parametrica")
    private Long vParametrica;

    @JsonProperty("v_fini")
    private Date vFIni;

    @JsonProperty("v_ffin")
    private Date vFFin;

    public FFrecuenciaActVarios() {
        // Default constructor
    }

    @JsonIgnore
    public Long getVParametrica() {
        return this.vParametrica;
    }
    
    public void setVParametrica(Long vParametrica) {
        this.vParametrica = vParametrica;
    }

    @JsonIgnore
    public Date getVFIni() {
        return this.vFIni;
    }
    
    public void setVFIni(Date vFIni) {
        this.vFIni = vFIni;
    }

    @JsonIgnore
    public Date getVFFin() {
        return this.vFFin;
    }
    
    public void setVFFin(Date vFFin) {
        this.vFFin = vFFin;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(FrecuenciaActConstants.FILTER_NAME_FFRECUENCIAACTVARIOS);
        filterRequest.addFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VPARAMETRICA, vParametrica);
        filterRequest.addFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VFINI, vFIni);
        filterRequest.addFilterVariable(FrecuenciaActConstants.VAR_NAME_FFRECUENCIAACTVARIOS_VFFIN, vFFin);
        return filterRequest;
    }
}
