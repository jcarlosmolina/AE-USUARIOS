package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovObservaciones {

    @JsonProperty("observacions")
    private String dSSolNovObservacionesObservacions;

    public DSSolNovObservaciones() {
    
    }

    public DSSolNovObservaciones(SolicitudNovedad instance) {
        if (instance != null) {
            this.dSSolNovObservacionesObservacions = instance.getSolicitudNovedadObservacions();
        }
    }

    @JsonIgnore
    public String getDSSolNovObservacionesObservacions() {
        return this.dSSolNovObservacionesObservacions;
    }
    
    public void setDSSolNovObservacionesObservacions(String dSSolNovObservacionesObservacions) {
        this.dSSolNovObservacionesObservacions = dSSolNovObservacionesObservacions;
    }
}
