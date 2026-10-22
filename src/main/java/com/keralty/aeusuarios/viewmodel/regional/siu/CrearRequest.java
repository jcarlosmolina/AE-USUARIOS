package com.keralty.aeusuarios.viewmodel.regional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.RespRegional;

public class CrearRequest {

    @JsonProperty("p_agrrespregional_oid")
    private RespRegionalOid regionalcrearpagrRespRegional;
    
    @JsonIgnore
    private RespRegional regionalcrearpagrRespRegionalInstance;

    @JsonProperty("p_atrcodigo")
    private Long regionalcrearpatrCodigo;

    @JsonProperty("p_atrdescripcion")
    private String regionalcrearpatrDescripcion;

    public void checkArguments() throws NotNullArgumentException {
        checkRegionalcrearpatrCodigo();
        checkRegionalcrearpatrDescripcion();
    }

    @JsonIgnore
    public RespRegionalOid getRegionalcrearpagrRespRegional() {
        return this.regionalcrearpagrRespRegional;
    }
    
    public void setRegionalcrearpagrRespRegional(RespRegionalOid regionalcrearpagrRespRegional) {
        this.regionalcrearpagrRespRegional = regionalcrearpagrRespRegional;
    }

    @JsonIgnore
    public RespRegional getRegionalcrearpagrRespRegionalInstance() {
        return this.regionalcrearpagrRespRegionalInstance;
    }
    
    public void setRegionalcrearpagrRespRegionalInstance(RespRegional regionalcrearpagrRespRegional) {
        this.regionalcrearpagrRespRegionalInstance = regionalcrearpagrRespRegional;
        this.regionalcrearpagrRespRegional = regionalcrearpagrRespRegional != null ? regionalcrearpagrRespRegional.getOid() : null;
    }

    @JsonIgnore
    public Long getRegionalcrearpatrCodigo() {
        return this.regionalcrearpatrCodigo;
    }
    
    public void setRegionalcrearpatrCodigo(Long regionalcrearpatrCodigo) {
        this.regionalcrearpatrCodigo = regionalcrearpatrCodigo;
    }

    private void checkRegionalcrearpatrCodigo() throws NotNullArgumentException {
        if(this.getRegionalcrearpatrCodigo() == null) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_CREAR, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_CREAR_REGIONALCREARPATRCODIGO, RegionalConstants.SERV_ALIAS_CREAR, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_CREAR_REGIONALCREARPATRCODIGO);
        }
    }

    @JsonIgnore
    public String getRegionalcrearpatrDescripcion() {
        return this.regionalcrearpatrDescripcion;
    }
    
    public void setRegionalcrearpatrDescripcion(String regionalcrearpatrDescripcion) {
        this.regionalcrearpatrDescripcion = regionalcrearpatrDescripcion;
    }

    private void checkRegionalcrearpatrDescripcion() throws NotNullArgumentException {
        if(this.getRegionalcrearpatrDescripcion() == null) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_CREAR, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_CREAR_REGIONALCREARPATRDESCRIPCION, RegionalConstants.SERV_ALIAS_CREAR, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_CREAR_REGIONALCREARPATRDESCRIPCION);
        }
    }
}
