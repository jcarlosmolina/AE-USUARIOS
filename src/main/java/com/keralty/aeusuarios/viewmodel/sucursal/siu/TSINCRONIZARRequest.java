package com.keralty.aeusuarios.viewmodel.sucursal.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;

public class TSINCRONIZARRequest {

    @JsonProperty("p_thissucursal_oid")
    private SucursalOid sucursalTSINCRONIZARpthisSucursal;
    
    @JsonIgnore
    private Sucursal sucursalTSINCRONIZARpthisSucursalInstance;

    @JsonProperty("pt_p_descripcion")
    private String sucursalTSINCRONIZARptpDescripcion;

    @JsonProperty("pt_p_evcregional_oid")
    private RegionalOid sucursalTSINCRONIZARptpevcRegional;
    
    @JsonIgnore
    private Regional sucursalTSINCRONIZARptpevcRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSucursalTSINCRONIZARpthisSucursal();
        checkSucursalTSINCRONIZARptpDescripcion();
        checkSucursalTSINCRONIZARptpevcRegional();
    }

    @JsonIgnore
    public SucursalOid getSucursalTSINCRONIZARpthisSucursal() {
        return this.sucursalTSINCRONIZARpthisSucursal;
    }
    
    public void setSucursalTSINCRONIZARpthisSucursal(SucursalOid sucursalTSINCRONIZARpthisSucursal) {
        this.sucursalTSINCRONIZARpthisSucursal = sucursalTSINCRONIZARpthisSucursal;
    }

    @JsonIgnore
    public Sucursal getSucursalTSINCRONIZARpthisSucursalInstance() {
        return this.sucursalTSINCRONIZARpthisSucursalInstance;
    }
    
    public void setSucursalTSINCRONIZARpthisSucursalInstance(Sucursal sucursalTSINCRONIZARpthisSucursal) {
        this.sucursalTSINCRONIZARpthisSucursalInstance = sucursalTSINCRONIZARpthisSucursal;
        this.sucursalTSINCRONIZARpthisSucursal = sucursalTSINCRONIZARpthisSucursal != null ? sucursalTSINCRONIZARpthisSucursal.getOid() : null;
    }

    private void checkSucursalTSINCRONIZARpthisSucursal() throws NotNullArgumentException {
        if(this.getSucursalTSINCRONIZARpthisSucursalInstance() == null || this.getSucursalTSINCRONIZARpthisSucursalInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_TSINCRONIZAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_TSINCRONIZAR_SUCURSALTSINCRONIZARPTHISSUCURSAL, SucursalConstants.SERV_ALIAS_TSINCRONIZAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_TSINCRONIZAR_SUCURSALTSINCRONIZARPTHISSUCURSAL);
        }
    }

    @JsonIgnore
    public String getSucursalTSINCRONIZARptpDescripcion() {
        return this.sucursalTSINCRONIZARptpDescripcion;
    }
    
    public void setSucursalTSINCRONIZARptpDescripcion(String sucursalTSINCRONIZARptpDescripcion) {
        this.sucursalTSINCRONIZARptpDescripcion = sucursalTSINCRONIZARptpDescripcion;
    }

    private void checkSucursalTSINCRONIZARptpDescripcion() throws NotNullArgumentException {
        if(this.getSucursalTSINCRONIZARptpDescripcion() == null) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_TSINCRONIZAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_TSINCRONIZAR_SUCURSALTSINCRONIZARPTPDESCRIPCION, SucursalConstants.SERV_ALIAS_TSINCRONIZAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_TSINCRONIZAR_SUCURSALTSINCRONIZARPTPDESCRIPCION);
        }
    }

    @JsonIgnore
    public RegionalOid getSucursalTSINCRONIZARptpevcRegional() {
        return this.sucursalTSINCRONIZARptpevcRegional;
    }
    
    public void setSucursalTSINCRONIZARptpevcRegional(RegionalOid sucursalTSINCRONIZARptpevcRegional) {
        this.sucursalTSINCRONIZARptpevcRegional = sucursalTSINCRONIZARptpevcRegional;
    }

    @JsonIgnore
    public Regional getSucursalTSINCRONIZARptpevcRegionalInstance() {
        return this.sucursalTSINCRONIZARptpevcRegionalInstance;
    }
    
    public void setSucursalTSINCRONIZARptpevcRegionalInstance(Regional sucursalTSINCRONIZARptpevcRegional) {
        this.sucursalTSINCRONIZARptpevcRegionalInstance = sucursalTSINCRONIZARptpevcRegional;
        this.sucursalTSINCRONIZARptpevcRegional = sucursalTSINCRONIZARptpevcRegional != null ? sucursalTSINCRONIZARptpevcRegional.getOid() : null;
    }

    private void checkSucursalTSINCRONIZARptpevcRegional() throws NotNullArgumentException {
        if(this.getSucursalTSINCRONIZARptpevcRegionalInstance() == null || this.getSucursalTSINCRONIZARptpevcRegionalInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_TSINCRONIZAR, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_TSINCRONIZAR_SUCURSALTSINCRONIZARPTPEVCREGIONAL, SucursalConstants.SERV_ALIAS_TSINCRONIZAR, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_TSINCRONIZAR_SUCURSALTSINCRONIZARPTPEVCREGIONAL);
        }
    }
}
