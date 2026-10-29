package com.keralty.aeusuarios.viewmodel.frecuenciaact.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.FrecuenciaAct;
public class ICFrecuenciaAct {

    @JsonProperty("drvnombreparametrica")
    private String iCFrecuenciaActDrvNombreParametrica;

    public ICFrecuenciaAct() {
    
    }

    public ICFrecuenciaAct(FrecuenciaAct instance) {
        if (instance != null) {
            try {
                this.iCFrecuenciaActDrvNombreParametrica = instance.getFrecuenciaActdrvNombreParametrica();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICFrecuenciaActDrvNombreParametrica() {
        return this.iCFrecuenciaActDrvNombreParametrica;
    }
    
    public void setICFrecuenciaActDrvNombreParametrica(String iCFrecuenciaActDrvNombreParametrica) {
        this.iCFrecuenciaActDrvNombreParametrica = iCFrecuenciaActDrvNombreParametrica;
    }
}
