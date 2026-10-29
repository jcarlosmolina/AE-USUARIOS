package com.keralty.aeusuarios.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.oid.AreaMedicaOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Solicitud;

public class DelUsrAreaMedicaRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudDelUsrAreaMedicapthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudDelUsrAreaMedicapthisSolicitudInstance;

    @JsonProperty("p_evcareamedica_oid")
    private AreaMedicaOid solicitudDelUsrAreaMedicapevcAreaMedica;
    
    @JsonIgnore
    private AreaMedica solicitudDelUsrAreaMedicapevcAreaMedicaInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudDelUsrAreaMedicapthisSolicitud();
        checkSolicitudDelUsrAreaMedicapevcAreaMedica();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudDelUsrAreaMedicapthisSolicitud() {
        return this.solicitudDelUsrAreaMedicapthisSolicitud;
    }
    
    public void setSolicitudDelUsrAreaMedicapthisSolicitud(SolicitudOid solicitudDelUsrAreaMedicapthisSolicitud) {
        this.solicitudDelUsrAreaMedicapthisSolicitud = solicitudDelUsrAreaMedicapthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudDelUsrAreaMedicapthisSolicitudInstance() {
        return this.solicitudDelUsrAreaMedicapthisSolicitudInstance;
    }
    
    public void setSolicitudDelUsrAreaMedicapthisSolicitudInstance(Solicitud solicitudDelUsrAreaMedicapthisSolicitud) {
        this.solicitudDelUsrAreaMedicapthisSolicitudInstance = solicitudDelUsrAreaMedicapthisSolicitud;
        this.solicitudDelUsrAreaMedicapthisSolicitud = solicitudDelUsrAreaMedicapthisSolicitud != null ? solicitudDelUsrAreaMedicapthisSolicitud.getOid() : null;
    }

    private void checkSolicitudDelUsrAreaMedicapthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudDelUsrAreaMedicapthisSolicitudInstance() == null || this.getSolicitudDelUsrAreaMedicapthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELUSRAREAMEDICA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELUSRAREAMEDICA_SOLICITUDDELUSRAREAMEDICAPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DELUSRAREAMEDICA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELUSRAREAMEDICA_SOLICITUDDELUSRAREAMEDICAPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public AreaMedicaOid getSolicitudDelUsrAreaMedicapevcAreaMedica() {
        return this.solicitudDelUsrAreaMedicapevcAreaMedica;
    }
    
    public void setSolicitudDelUsrAreaMedicapevcAreaMedica(AreaMedicaOid solicitudDelUsrAreaMedicapevcAreaMedica) {
        this.solicitudDelUsrAreaMedicapevcAreaMedica = solicitudDelUsrAreaMedicapevcAreaMedica;
    }

    @JsonIgnore
    public AreaMedica getSolicitudDelUsrAreaMedicapevcAreaMedicaInstance() {
        return this.solicitudDelUsrAreaMedicapevcAreaMedicaInstance;
    }
    
    public void setSolicitudDelUsrAreaMedicapevcAreaMedicaInstance(AreaMedica solicitudDelUsrAreaMedicapevcAreaMedica) {
        this.solicitudDelUsrAreaMedicapevcAreaMedicaInstance = solicitudDelUsrAreaMedicapevcAreaMedica;
        this.solicitudDelUsrAreaMedicapevcAreaMedica = solicitudDelUsrAreaMedicapevcAreaMedica != null ? solicitudDelUsrAreaMedicapevcAreaMedica.getOid() : null;
    }

    private void checkSolicitudDelUsrAreaMedicapevcAreaMedica() throws NotNullArgumentException {
        if(this.getSolicitudDelUsrAreaMedicapevcAreaMedicaInstance() == null || this.getSolicitudDelUsrAreaMedicapevcAreaMedicaInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELUSRAREAMEDICA, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELUSRAREAMEDICA_SOLICITUDDELUSRAREAMEDICAPEVCAREAMEDICA, SolicitudConstants.SERV_ALIAS_DELUSRAREAMEDICA, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELUSRAREAMEDICA_SOLICITUDDELUSRAREAMEDICAPEVCAREAMEDICA);
        }
    }
}
