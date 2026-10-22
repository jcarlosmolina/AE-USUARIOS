package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class ICSolicitudNovedad {

    @JsonProperty("drvnumradicadostr")
    private String iCSolicitudNovedadDrvNumRadicadoStr;

    public ICSolicitudNovedad() {
    
    }

    public ICSolicitudNovedad(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.iCSolicitudNovedadDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICSolicitudNovedadDrvNumRadicadoStr() {
        return this.iCSolicitudNovedadDrvNumRadicadoStr;
    }
    
    public void setICSolicitudNovedadDrvNumRadicadoStr(String iCSolicitudNovedadDrvNumRadicadoStr) {
        this.iCSolicitudNovedadDrvNumRadicadoStr = iCSolicitudNovedadDrvNumRadicadoStr;
    }
}
