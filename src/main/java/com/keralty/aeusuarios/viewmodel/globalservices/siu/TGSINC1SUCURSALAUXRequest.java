package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.Regional;

public class TGSINC1SUCURSALAUXRequest {

    @JsonProperty("pt_p_agrregional_oid")
    private RegionalOid tGSINC1SUCURSALAUXptpagrRegional;
    
    @JsonIgnore
    private Regional tGSINC1SUCURSALAUXptpagrRegionalInstance;

    @JsonProperty("pt_p_atrcodigo")
    private Long tGSINC1SUCURSALAUXptpatrCodigo;

    @JsonProperty("pt_p_atrdescripcion")
    private String tGSINC1SUCURSALAUXptpatrDescripcion;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1SUCURSALAUXptpagrRegional();
        checkTGSINC1SUCURSALAUXptpatrCodigo();
        checkTGSINC1SUCURSALAUXptpatrDescripcion();
    }

    @JsonIgnore
    public RegionalOid getTGSINC1SUCURSALAUXptpagrRegional() {
        return this.tGSINC1SUCURSALAUXptpagrRegional;
    }
    
    public void setTGSINC1SUCURSALAUXptpagrRegional(RegionalOid tGSINC1SUCURSALAUXptpagrRegional) {
        this.tGSINC1SUCURSALAUXptpagrRegional = tGSINC1SUCURSALAUXptpagrRegional;
    }

    @JsonIgnore
    public Regional getTGSINC1SUCURSALAUXptpagrRegionalInstance() {
        return this.tGSINC1SUCURSALAUXptpagrRegionalInstance;
    }
    
    public void setTGSINC1SUCURSALAUXptpagrRegionalInstance(Regional tGSINC1SUCURSALAUXptpagrRegional) {
        this.tGSINC1SUCURSALAUXptpagrRegionalInstance = tGSINC1SUCURSALAUXptpagrRegional;
        this.tGSINC1SUCURSALAUXptpagrRegional = tGSINC1SUCURSALAUXptpagrRegional != null ? tGSINC1SUCURSALAUXptpagrRegional.getOid() : null;
    }

    private void checkTGSINC1SUCURSALAUXptpagrRegional() throws NotNullArgumentException {
        if(this.getTGSINC1SUCURSALAUXptpagrRegionalInstance() == null || this.getTGSINC1SUCURSALAUXptpagrRegionalInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1SUCURSALAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1SUCURSALAUX_TGSINC1SUCURSALAUXPTPAGRREGIONAL, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1SUCURSALAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1SUCURSALAUX_TGSINC1SUCURSALAUXPTPAGRREGIONAL);
        }
    }

    @JsonIgnore
    public Long getTGSINC1SUCURSALAUXptpatrCodigo() {
        return this.tGSINC1SUCURSALAUXptpatrCodigo;
    }
    
    public void setTGSINC1SUCURSALAUXptpatrCodigo(Long tGSINC1SUCURSALAUXptpatrCodigo) {
        this.tGSINC1SUCURSALAUXptpatrCodigo = tGSINC1SUCURSALAUXptpatrCodigo;
    }

    private void checkTGSINC1SUCURSALAUXptpatrCodigo() throws NotNullArgumentException {
        if(this.getTGSINC1SUCURSALAUXptpatrCodigo() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1SUCURSALAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1SUCURSALAUX_TGSINC1SUCURSALAUXPTPATRCODIGO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1SUCURSALAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1SUCURSALAUX_TGSINC1SUCURSALAUXPTPATRCODIGO);
        }
    }

    @JsonIgnore
    public String getTGSINC1SUCURSALAUXptpatrDescripcion() {
        return this.tGSINC1SUCURSALAUXptpatrDescripcion;
    }
    
    public void setTGSINC1SUCURSALAUXptpatrDescripcion(String tGSINC1SUCURSALAUXptpatrDescripcion) {
        this.tGSINC1SUCURSALAUXptpatrDescripcion = tGSINC1SUCURSALAUXptpatrDescripcion;
    }

    private void checkTGSINC1SUCURSALAUXptpatrDescripcion() throws NotNullArgumentException {
        if(this.getTGSINC1SUCURSALAUXptpatrDescripcion() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1SUCURSALAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1SUCURSALAUX_TGSINC1SUCURSALAUXPTPATRDESCRIPCION, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1SUCURSALAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1SUCURSALAUX_TGSINC1SUCURSALAUXPTPATRDESCRIPCION);
        }
    }
}
