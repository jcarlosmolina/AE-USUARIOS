package com.keralty.aeusuarios.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Solicitud;

public class DummyDevolverErroresWSRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicituddummyDevolverErroresWSpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicituddummyDevolverErroresWSpthisSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicituddummyDevolverErroresWSpthisSolicitud();
    }

    @JsonIgnore
    public SolicitudOid getSolicituddummyDevolverErroresWSpthisSolicitud() {
        return this.solicituddummyDevolverErroresWSpthisSolicitud;
    }
    
    public void setSolicituddummyDevolverErroresWSpthisSolicitud(SolicitudOid solicituddummyDevolverErroresWSpthisSolicitud) {
        this.solicituddummyDevolverErroresWSpthisSolicitud = solicituddummyDevolverErroresWSpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicituddummyDevolverErroresWSpthisSolicitudInstance() {
        return this.solicituddummyDevolverErroresWSpthisSolicitudInstance;
    }
    
    public void setSolicituddummyDevolverErroresWSpthisSolicitudInstance(Solicitud solicituddummyDevolverErroresWSpthisSolicitud) {
        this.solicituddummyDevolverErroresWSpthisSolicitudInstance = solicituddummyDevolverErroresWSpthisSolicitud;
        this.solicituddummyDevolverErroresWSpthisSolicitud = solicituddummyDevolverErroresWSpthisSolicitud != null ? solicituddummyDevolverErroresWSpthisSolicitud.getOid() : null;
    }

    private void checkSolicituddummyDevolverErroresWSpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicituddummyDevolverErroresWSpthisSolicitudInstance() == null || this.getSolicituddummyDevolverErroresWSpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DUMMYDEVOLVERERRORESWS, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DUMMYDEVOLVERERRORESWS_SOLICITUDDUMMYDEVOLVERERRORESWSPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DUMMYDEVOLVERERRORESWS, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DUMMYDEVOLVERERRORESWS_SOLICITUDDUMMYDEVOLVERERRORESWSPTHISSOLICITUD);
        }
    }
}
