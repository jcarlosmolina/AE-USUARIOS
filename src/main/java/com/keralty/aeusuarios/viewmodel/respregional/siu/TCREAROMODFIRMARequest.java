package com.keralty.aeusuarios.viewmodel.respregional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.RespRegional;

public class TCREAROMODFIRMARequest {

    @JsonProperty("p_thisrespregional_oid")
    private RespRegionalOid respRegionalTCREAROMODFIRMApthisRespRegional;
    
    @JsonIgnore
    private RespRegional respRegionalTCREAROMODFIRMApthisRespRegionalInstance;

    @JsonProperty("pt_p_atrimagenfirma")
    private byte[] respRegionalTCREAROMODFIRMAptpatrImagenFirma;

    @JsonProperty("pt_p_atrlatitud")
    private String respRegionalTCREAROMODFIRMAptpatrLatitud;

    @JsonProperty("pt_p_atrlongitud")
    private String respRegionalTCREAROMODFIRMAptpatrLongitud;

    public void checkArguments() throws NotNullArgumentException {
        checkRespRegionalTCREAROMODFIRMApthisRespRegional();
    }

    @JsonIgnore
    public RespRegionalOid getRespRegionalTCREAROMODFIRMApthisRespRegional() {
        return this.respRegionalTCREAROMODFIRMApthisRespRegional;
    }
    
    public void setRespRegionalTCREAROMODFIRMApthisRespRegional(RespRegionalOid respRegionalTCREAROMODFIRMApthisRespRegional) {
        this.respRegionalTCREAROMODFIRMApthisRespRegional = respRegionalTCREAROMODFIRMApthisRespRegional;
    }

    @JsonIgnore
    public RespRegional getRespRegionalTCREAROMODFIRMApthisRespRegionalInstance() {
        return this.respRegionalTCREAROMODFIRMApthisRespRegionalInstance;
    }
    
    public void setRespRegionalTCREAROMODFIRMApthisRespRegionalInstance(RespRegional respRegionalTCREAROMODFIRMApthisRespRegional) {
        this.respRegionalTCREAROMODFIRMApthisRespRegionalInstance = respRegionalTCREAROMODFIRMApthisRespRegional;
        this.respRegionalTCREAROMODFIRMApthisRespRegional = respRegionalTCREAROMODFIRMApthisRespRegional != null ? respRegionalTCREAROMODFIRMApthisRespRegional.getOid() : null;
    }

    private void checkRespRegionalTCREAROMODFIRMApthisRespRegional() throws NotNullArgumentException {
        if(this.getRespRegionalTCREAROMODFIRMApthisRespRegionalInstance() == null || this.getRespRegionalTCREAROMODFIRMApthisRespRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_TCREAROMODFIRMA, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_TCREAROMODFIRMA_RESPREGIONALTCREAROMODFIRMAPTHISRESPREGIONAL, RespRegionalConstants.SERV_ALIAS_TCREAROMODFIRMA, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_TCREAROMODFIRMA_RESPREGIONALTCREAROMODFIRMAPTHISRESPREGIONAL);
        }
    }

    @JsonIgnore
    public byte[] getRespRegionalTCREAROMODFIRMAptpatrImagenFirma() {
        return this.respRegionalTCREAROMODFIRMAptpatrImagenFirma;
    }
    
    public void setRespRegionalTCREAROMODFIRMAptpatrImagenFirma(byte[] respRegionalTCREAROMODFIRMAptpatrImagenFirma) {
        this.respRegionalTCREAROMODFIRMAptpatrImagenFirma = respRegionalTCREAROMODFIRMAptpatrImagenFirma;
    }

    @JsonIgnore
    public String getRespRegionalTCREAROMODFIRMAptpatrLatitud() {
        return this.respRegionalTCREAROMODFIRMAptpatrLatitud;
    }
    
    public void setRespRegionalTCREAROMODFIRMAptpatrLatitud(String respRegionalTCREAROMODFIRMAptpatrLatitud) {
        this.respRegionalTCREAROMODFIRMAptpatrLatitud = respRegionalTCREAROMODFIRMAptpatrLatitud;
    }

    @JsonIgnore
    public String getRespRegionalTCREAROMODFIRMAptpatrLongitud() {
        return this.respRegionalTCREAROMODFIRMAptpatrLongitud;
    }
    
    public void setRespRegionalTCREAROMODFIRMAptpatrLongitud(String respRegionalTCREAROMODFIRMAptpatrLongitud) {
        this.respRegionalTCREAROMODFIRMAptpatrLongitud = respRegionalTCREAROMODFIRMAptpatrLongitud;
    }
}
