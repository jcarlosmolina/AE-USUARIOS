package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class DSSolicitudVacia {

    @JsonProperty("numfamilia")
    private String dSSolicitudVaciaNumFamilia;

    public DSSolicitudVacia() {
    
    }

    public DSSolicitudVacia(Solicitud instance) {
        if (instance != null) {
            this.dSSolicitudVaciaNumFamilia = instance.getSolicitudNumFamilia();
        }
    }

    @JsonIgnore
    public String getDSSolicitudVaciaNumFamilia() {
        return this.dSSolicitudVaciaNumFamilia;
    }
    
    public void setDSSolicitudVaciaNumFamilia(String dSSolicitudVaciaNumFamilia) {
        this.dSSolicitudVaciaNumFamilia = dSSolicitudVaciaNumFamilia;
    }
}
