package com.keralty.aeusuarios.viewmodel.sucursal.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;

public class CambRegionalSucursalRequest {

    @JsonProperty("p_thissucursal_oid")
    private SucursalOid sucursalCambRegionalSucursalpthisSucursal;
    
    @JsonIgnore
    private Sucursal sucursalCambRegionalSucursalpthisSucursalInstance;

    @JsonProperty("p_evcregional_oid")
    private RegionalOid sucursalCambRegionalSucursalpevcRegional;
    
    @JsonIgnore
    private Regional sucursalCambRegionalSucursalpevcRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSucursalCambRegionalSucursalpthisSucursal();
        checkSucursalCambRegionalSucursalpevcRegional();
    }

    @JsonIgnore
    public SucursalOid getSucursalCambRegionalSucursalpthisSucursal() {
        return this.sucursalCambRegionalSucursalpthisSucursal;
    }
    
    public void setSucursalCambRegionalSucursalpthisSucursal(SucursalOid sucursalCambRegionalSucursalpthisSucursal) {
        this.sucursalCambRegionalSucursalpthisSucursal = sucursalCambRegionalSucursalpthisSucursal;
    }

    @JsonIgnore
    public Sucursal getSucursalCambRegionalSucursalpthisSucursalInstance() {
        return this.sucursalCambRegionalSucursalpthisSucursalInstance;
    }
    
    public void setSucursalCambRegionalSucursalpthisSucursalInstance(Sucursal sucursalCambRegionalSucursalpthisSucursal) {
        this.sucursalCambRegionalSucursalpthisSucursalInstance = sucursalCambRegionalSucursalpthisSucursal;
        this.sucursalCambRegionalSucursalpthisSucursal = sucursalCambRegionalSucursalpthisSucursal != null ? sucursalCambRegionalSucursalpthisSucursal.getOid() : null;
    }

    private void checkSucursalCambRegionalSucursalpthisSucursal() throws NotNullArgumentException {
        if(this.getSucursalCambRegionalSucursalpthisSucursalInstance() == null || this.getSucursalCambRegionalSucursalpthisSucursalInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_CAMBREGIONALSUCURSAL, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_CAMBREGIONALSUCURSAL_SUCURSALCAMBREGIONALSUCURSALPTHISSUCURSAL, SucursalConstants.SERV_ALIAS_CAMBREGIONALSUCURSAL, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_CAMBREGIONALSUCURSAL_SUCURSALCAMBREGIONALSUCURSALPTHISSUCURSAL);
        }
    }

    @JsonIgnore
    public RegionalOid getSucursalCambRegionalSucursalpevcRegional() {
        return this.sucursalCambRegionalSucursalpevcRegional;
    }
    
    public void setSucursalCambRegionalSucursalpevcRegional(RegionalOid sucursalCambRegionalSucursalpevcRegional) {
        this.sucursalCambRegionalSucursalpevcRegional = sucursalCambRegionalSucursalpevcRegional;
    }

    @JsonIgnore
    public Regional getSucursalCambRegionalSucursalpevcRegionalInstance() {
        return this.sucursalCambRegionalSucursalpevcRegionalInstance;
    }
    
    public void setSucursalCambRegionalSucursalpevcRegionalInstance(Regional sucursalCambRegionalSucursalpevcRegional) {
        this.sucursalCambRegionalSucursalpevcRegionalInstance = sucursalCambRegionalSucursalpevcRegional;
        this.sucursalCambRegionalSucursalpevcRegional = sucursalCambRegionalSucursalpevcRegional != null ? sucursalCambRegionalSucursalpevcRegional.getOid() : null;
    }

    private void checkSucursalCambRegionalSucursalpevcRegional() throws NotNullArgumentException {
        if(this.getSucursalCambRegionalSucursalpevcRegionalInstance() == null || this.getSucursalCambRegionalSucursalpevcRegionalInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_CAMBREGIONALSUCURSAL, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_CAMBREGIONALSUCURSAL_SUCURSALCAMBREGIONALSUCURSALPEVCREGIONAL, SucursalConstants.SERV_ALIAS_CAMBREGIONALSUCURSAL, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_CAMBREGIONALSUCURSAL_SUCURSALCAMBREGIONALSUCURSALPEVCREGIONAL);
        }
    }
}
