package com.keralty.aeusuarios.viewmodel.sucursal.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.Regional;

public class CrearRequest {

    @JsonProperty("p_agrregional_oid")
    private RegionalOid sucursalcrearpagrRegional;
    
    @JsonIgnore
    private Regional sucursalcrearpagrRegionalInstance;

    @JsonProperty("p_atrcodigo")
    private Long sucursalcrearpatrCodigo;

    @JsonProperty("p_atrdescripcion")
    private String sucursalcrearpatrDescripcion;

    public void checkArguments() throws NotNullArgumentException {
        checkSucursalcrearpagrRegional();
        checkSucursalcrearpatrCodigo();
        checkSucursalcrearpatrDescripcion();
    }

    @JsonIgnore
    public RegionalOid getSucursalcrearpagrRegional() {
        return this.sucursalcrearpagrRegional;
    }
    
    public void setSucursalcrearpagrRegional(RegionalOid sucursalcrearpagrRegional) {
        this.sucursalcrearpagrRegional = sucursalcrearpagrRegional;
    }

    @JsonIgnore
    public Regional getSucursalcrearpagrRegionalInstance() {
        return this.sucursalcrearpagrRegionalInstance;
    }
    
    public void setSucursalcrearpagrRegionalInstance(Regional sucursalcrearpagrRegional) {
        this.sucursalcrearpagrRegionalInstance = sucursalcrearpagrRegional;
        this.sucursalcrearpagrRegional = sucursalcrearpagrRegional != null ? sucursalcrearpagrRegional.getOid() : null;
    }

    private void checkSucursalcrearpagrRegional() throws NotNullArgumentException {
        if(this.getSucursalcrearpagrRegionalInstance() == null || this.getSucursalcrearpagrRegionalInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_CREAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_CREAR_SUCURSALCREARPAGRREGIONAL, SucursalConstants.SERV_ALIAS_CREAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_CREAR_SUCURSALCREARPAGRREGIONAL);
        }
    }

    @JsonIgnore
    public Long getSucursalcrearpatrCodigo() {
        return this.sucursalcrearpatrCodigo;
    }
    
    public void setSucursalcrearpatrCodigo(Long sucursalcrearpatrCodigo) {
        this.sucursalcrearpatrCodigo = sucursalcrearpatrCodigo;
    }

    private void checkSucursalcrearpatrCodigo() throws NotNullArgumentException {
        if(this.getSucursalcrearpatrCodigo() == null) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_CREAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_CREAR_SUCURSALCREARPATRCODIGO, SucursalConstants.SERV_ALIAS_CREAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_CREAR_SUCURSALCREARPATRCODIGO);
        }
    }

    @JsonIgnore
    public String getSucursalcrearpatrDescripcion() {
        return this.sucursalcrearpatrDescripcion;
    }
    
    public void setSucursalcrearpatrDescripcion(String sucursalcrearpatrDescripcion) {
        this.sucursalcrearpatrDescripcion = sucursalcrearpatrDescripcion;
    }

    private void checkSucursalcrearpatrDescripcion() throws NotNullArgumentException {
        if(this.getSucursalcrearpatrDescripcion() == null) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_CREAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_CREAR_SUCURSALCREARPATRDESCRIPCION, SucursalConstants.SERV_ALIAS_CREAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_CREAR_SUCURSALCREARPATRDESCRIPCION);
        }
    }
}
