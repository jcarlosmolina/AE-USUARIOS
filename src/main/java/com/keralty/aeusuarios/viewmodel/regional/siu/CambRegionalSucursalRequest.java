package com.keralty.aeusuarios.viewmodel.regional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;

public class CambRegionalSucursalRequest {

    @JsonProperty("p_thisregional_oid")
    private RegionalOid regionalCambRegionalSucursalpthisRegional;
    
    @JsonIgnore
    private Regional regionalCambRegionalSucursalpthisRegionalInstance;

    @JsonProperty("p_evcsucursal_oid")
    private SucursalOid regionalCambRegionalSucursalpevcSucursal;
    
    @JsonIgnore
    private Sucursal regionalCambRegionalSucursalpevcSucursalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRegionalCambRegionalSucursalpthisRegional();
        checkRegionalCambRegionalSucursalpevcSucursal();
    }

    @JsonIgnore
    public RegionalOid getRegionalCambRegionalSucursalpthisRegional() {
        return this.regionalCambRegionalSucursalpthisRegional;
    }
    
    public void setRegionalCambRegionalSucursalpthisRegional(RegionalOid regionalCambRegionalSucursalpthisRegional) {
        this.regionalCambRegionalSucursalpthisRegional = regionalCambRegionalSucursalpthisRegional;
    }

    @JsonIgnore
    public Regional getRegionalCambRegionalSucursalpthisRegionalInstance() {
        return this.regionalCambRegionalSucursalpthisRegionalInstance;
    }
    
    public void setRegionalCambRegionalSucursalpthisRegionalInstance(Regional regionalCambRegionalSucursalpthisRegional) {
        this.regionalCambRegionalSucursalpthisRegionalInstance = regionalCambRegionalSucursalpthisRegional;
        this.regionalCambRegionalSucursalpthisRegional = regionalCambRegionalSucursalpthisRegional != null ? regionalCambRegionalSucursalpthisRegional.getOid() : null;
    }

    private void checkRegionalCambRegionalSucursalpthisRegional() throws NotNullArgumentException {
        if(this.getRegionalCambRegionalSucursalpthisRegionalInstance() == null || this.getRegionalCambRegionalSucursalpthisRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_CAMBREGIONALSUCURSAL, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_CAMBREGIONALSUCURSAL_REGIONALCAMBREGIONALSUCURSALPTHISREGIONAL, RegionalConstants.SERV_ALIAS_CAMBREGIONALSUCURSAL, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_CAMBREGIONALSUCURSAL_REGIONALCAMBREGIONALSUCURSALPTHISREGIONAL);
        }
    }

    @JsonIgnore
    public SucursalOid getRegionalCambRegionalSucursalpevcSucursal() {
        return this.regionalCambRegionalSucursalpevcSucursal;
    }
    
    public void setRegionalCambRegionalSucursalpevcSucursal(SucursalOid regionalCambRegionalSucursalpevcSucursal) {
        this.regionalCambRegionalSucursalpevcSucursal = regionalCambRegionalSucursalpevcSucursal;
    }

    @JsonIgnore
    public Sucursal getRegionalCambRegionalSucursalpevcSucursalInstance() {
        return this.regionalCambRegionalSucursalpevcSucursalInstance;
    }
    
    public void setRegionalCambRegionalSucursalpevcSucursalInstance(Sucursal regionalCambRegionalSucursalpevcSucursal) {
        this.regionalCambRegionalSucursalpevcSucursalInstance = regionalCambRegionalSucursalpevcSucursal;
        this.regionalCambRegionalSucursalpevcSucursal = regionalCambRegionalSucursalpevcSucursal != null ? regionalCambRegionalSucursalpevcSucursal.getOid() : null;
    }

    private void checkRegionalCambRegionalSucursalpevcSucursal() throws NotNullArgumentException {
        if(this.getRegionalCambRegionalSucursalpevcSucursalInstance() == null || this.getRegionalCambRegionalSucursalpevcSucursalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_CAMBREGIONALSUCURSAL, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_CAMBREGIONALSUCURSAL_REGIONALCAMBREGIONALSUCURSALPEVCSUCURSAL, RegionalConstants.SERV_ALIAS_CAMBREGIONALSUCURSAL, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_CAMBREGIONALSUCURSAL_REGIONALCAMBREGIONALSUCURSALPEVCSUCURSAL);
        }
    }
}
