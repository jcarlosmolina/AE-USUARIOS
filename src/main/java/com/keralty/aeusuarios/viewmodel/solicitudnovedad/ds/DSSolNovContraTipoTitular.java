package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovContraTipoTitular {

    @JsonProperty("contradrvidentificacion")
    private String dSSolNovContraTipoTitularContraDrvIdentificacion;

    @JsonProperty("contradrvnombrecompleto")
    private String dSSolNovContraTipoTitularContraDrvNombreCompleto;

    public DSSolNovContraTipoTitular() {
    
    }

    public DSSolNovContraTipoTitular(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovContraTipoTitularContraDrvIdentificacion = instance.getSolicitudNovedadContraDrvIdentificacion();
                this.dSSolNovContraTipoTitularContraDrvNombreCompleto = instance.getSolicitudNovedadContraDrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovContraTipoTitularContraDrvIdentificacion() {
        return this.dSSolNovContraTipoTitularContraDrvIdentificacion;
    }
    
    public void setDSSolNovContraTipoTitularContraDrvIdentificacion(String dSSolNovContraTipoTitularContraDrvIdentificacion) {
        this.dSSolNovContraTipoTitularContraDrvIdentificacion = dSSolNovContraTipoTitularContraDrvIdentificacion;
    }

    @JsonIgnore
    public String getDSSolNovContraTipoTitularContraDrvNombreCompleto() {
        return this.dSSolNovContraTipoTitularContraDrvNombreCompleto;
    }
    
    public void setDSSolNovContraTipoTitularContraDrvNombreCompleto(String dSSolNovContraTipoTitularContraDrvNombreCompleto) {
        this.dSSolNovContraTipoTitularContraDrvNombreCompleto = dSSolNovContraTipoTitularContraDrvNombreCompleto;
    }
}
