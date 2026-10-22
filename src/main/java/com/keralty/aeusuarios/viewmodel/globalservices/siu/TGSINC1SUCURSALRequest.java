package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;

public class TGSINC1SUCURSALRequest {

    @JsonProperty("pt_p_atrcodigo")
    private Long tGSINC1SUCURSALptpatrCodigo;

    @JsonProperty("pt_p_atrdescripcion")
    private String tGSINC1SUCURSALptpatrDescripcion;

    @JsonProperty("pt_p_atrcodigosucursal")
    private Long tGSINC1SUCURSALptpatrCodigoSucursal;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1SUCURSALptpatrCodigo();
        checkTGSINC1SUCURSALptpatrDescripcion();
        checkTGSINC1SUCURSALptpatrCodigoSucursal();
    }

    @JsonIgnore
    public Long getTGSINC1SUCURSALptpatrCodigo() {
        return this.tGSINC1SUCURSALptpatrCodigo;
    }
    
    public void setTGSINC1SUCURSALptpatrCodigo(Long tGSINC1SUCURSALptpatrCodigo) {
        this.tGSINC1SUCURSALptpatrCodigo = tGSINC1SUCURSALptpatrCodigo;
    }

    private void checkTGSINC1SUCURSALptpatrCodigo() throws NotNullArgumentException {
        if(this.getTGSINC1SUCURSALptpatrCodigo() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1SUCURSAL, GlobalServiceConstants.GS_ARG_ID_TGSINC1SUCURSAL_TGSINC1SUCURSALPTPATRCODIGO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1SUCURSAL, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1SUCURSAL_TGSINC1SUCURSALPTPATRCODIGO);
        }
    }

    @JsonIgnore
    public String getTGSINC1SUCURSALptpatrDescripcion() {
        return this.tGSINC1SUCURSALptpatrDescripcion;
    }
    
    public void setTGSINC1SUCURSALptpatrDescripcion(String tGSINC1SUCURSALptpatrDescripcion) {
        this.tGSINC1SUCURSALptpatrDescripcion = tGSINC1SUCURSALptpatrDescripcion;
    }

    private void checkTGSINC1SUCURSALptpatrDescripcion() throws NotNullArgumentException {
        if(this.getTGSINC1SUCURSALptpatrDescripcion() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1SUCURSAL, GlobalServiceConstants.GS_ARG_ID_TGSINC1SUCURSAL_TGSINC1SUCURSALPTPATRDESCRIPCION, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1SUCURSAL, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1SUCURSAL_TGSINC1SUCURSALPTPATRDESCRIPCION);
        }
    }

    @JsonIgnore
    public Long getTGSINC1SUCURSALptpatrCodigoSucursal() {
        return this.tGSINC1SUCURSALptpatrCodigoSucursal;
    }
    
    public void setTGSINC1SUCURSALptpatrCodigoSucursal(Long tGSINC1SUCURSALptpatrCodigoSucursal) {
        this.tGSINC1SUCURSALptpatrCodigoSucursal = tGSINC1SUCURSALptpatrCodigoSucursal;
    }

    private void checkTGSINC1SUCURSALptpatrCodigoSucursal() throws NotNullArgumentException {
        if(this.getTGSINC1SUCURSALptpatrCodigoSucursal() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1SUCURSAL, GlobalServiceConstants.GS_ARG_ID_TGSINC1SUCURSAL_TGSINC1SUCURSALPTPATRCODIGOSUCURSAL, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1SUCURSAL, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1SUCURSAL_TGSINC1SUCURSALPTPATRCODIGOSUCURSAL);
        }
    }
}
