package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovContratante {

    @JsonProperty("contradrvidentificacion")
    private String dSSolNovContratanteContraDrvIdentificacion;

    @JsonProperty("contradrvnombrecompleto")
    private String dSSolNovContratanteContraDrvNombreCompleto;

    @JsonProperty("contranuevarazonsocial")
    private String dSSolNovContratanteContraNuevaRazonSocial;

    public DSSolNovContratante() {
    
    }

    public DSSolNovContratante(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovContratanteContraDrvIdentificacion = instance.getSolicitudNovedadContraDrvIdentificacion();
                this.dSSolNovContratanteContraDrvNombreCompleto = instance.getSolicitudNovedadContraDrvNombreCompleto();
                this.dSSolNovContratanteContraNuevaRazonSocial = instance.getSolicitudNovedadContraNuevaRazonSocial();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovContratanteContraDrvIdentificacion() {
        return this.dSSolNovContratanteContraDrvIdentificacion;
    }
    
    public void setDSSolNovContratanteContraDrvIdentificacion(String dSSolNovContratanteContraDrvIdentificacion) {
        this.dSSolNovContratanteContraDrvIdentificacion = dSSolNovContratanteContraDrvIdentificacion;
    }

    @JsonIgnore
    public String getDSSolNovContratanteContraDrvNombreCompleto() {
        return this.dSSolNovContratanteContraDrvNombreCompleto;
    }
    
    public void setDSSolNovContratanteContraDrvNombreCompleto(String dSSolNovContratanteContraDrvNombreCompleto) {
        this.dSSolNovContratanteContraDrvNombreCompleto = dSSolNovContratanteContraDrvNombreCompleto;
    }

    @JsonIgnore
    public String getDSSolNovContratanteContraNuevaRazonSocial() {
        return this.dSSolNovContratanteContraNuevaRazonSocial;
    }
    
    public void setDSSolNovContratanteContraNuevaRazonSocial(String dSSolNovContratanteContraNuevaRazonSocial) {
        this.dSSolNovContratanteContraNuevaRazonSocial = dSSolNovContratanteContraNuevaRazonSocial;
    }
}
