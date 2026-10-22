package com.keralty.aeusuarios.viewmodel.solicitud.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Solicitud;
public class ICSolicitud {

    @JsonProperty("aesolicitudes_numerosolicitud")
    private String iCSolicitudAesolicitudesDotNumerosolicitud;

    public ICSolicitud() {
    
    }

    public ICSolicitud(Solicitud instance) {
        if (instance != null) {
            try {
                this.iCSolicitudAesolicitudesDotNumerosolicitud = instance.getAesolicitudes().getAesolicitudesNumerosolicitud();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICSolicitudAesolicitudesDotNumerosolicitud() {
        return this.iCSolicitudAesolicitudesDotNumerosolicitud;
    }
    
    public void setICSolicitudAesolicitudesDotNumerosolicitud(String iCSolicitudAesolicitudesDotNumerosolicitud) {
        this.iCSolicitudAesolicitudesDotNumerosolicitud = iCSolicitudAesolicitudesDotNumerosolicitud;
    }
}
