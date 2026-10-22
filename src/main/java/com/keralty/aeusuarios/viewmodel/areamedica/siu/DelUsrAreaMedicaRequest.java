package com.keralty.aeusuarios.viewmodel.areamedica.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AreaMedicaConstants;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.oid.AreaMedicaOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Solicitud;

public class DelUsrAreaMedicaRequest {

    @JsonProperty("p_thisareamedica_oid")
    private AreaMedicaOid areaMedicaDelUsrAreaMedicapthisAreaMedica;
    
    @JsonIgnore
    private AreaMedica areaMedicaDelUsrAreaMedicapthisAreaMedicaInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid areaMedicaDelUsrAreaMedicapevcSolicitud;
    
    @JsonIgnore
    private Solicitud areaMedicaDelUsrAreaMedicapevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAreaMedicaDelUsrAreaMedicapthisAreaMedica();
        checkAreaMedicaDelUsrAreaMedicapevcSolicitud();
    }

    @JsonIgnore
    public AreaMedicaOid getAreaMedicaDelUsrAreaMedicapthisAreaMedica() {
        return this.areaMedicaDelUsrAreaMedicapthisAreaMedica;
    }
    
    public void setAreaMedicaDelUsrAreaMedicapthisAreaMedica(AreaMedicaOid areaMedicaDelUsrAreaMedicapthisAreaMedica) {
        this.areaMedicaDelUsrAreaMedicapthisAreaMedica = areaMedicaDelUsrAreaMedicapthisAreaMedica;
    }

    @JsonIgnore
    public AreaMedica getAreaMedicaDelUsrAreaMedicapthisAreaMedicaInstance() {
        return this.areaMedicaDelUsrAreaMedicapthisAreaMedicaInstance;
    }
    
    public void setAreaMedicaDelUsrAreaMedicapthisAreaMedicaInstance(AreaMedica areaMedicaDelUsrAreaMedicapthisAreaMedica) {
        this.areaMedicaDelUsrAreaMedicapthisAreaMedicaInstance = areaMedicaDelUsrAreaMedicapthisAreaMedica;
        this.areaMedicaDelUsrAreaMedicapthisAreaMedica = areaMedicaDelUsrAreaMedicapthisAreaMedica != null ? areaMedicaDelUsrAreaMedicapthisAreaMedica.getOid() : null;
    }

    private void checkAreaMedicaDelUsrAreaMedicapthisAreaMedica() throws NotNullArgumentException {
        if(this.getAreaMedicaDelUsrAreaMedicapthisAreaMedicaInstance() == null || this.getAreaMedicaDelUsrAreaMedicapthisAreaMedicaInstance().isNull()) {
            throw new NotNullArgumentException(AreaMedicaConstants.SERV_ID_DELUSRAREAMEDICA, AreaMedicaConstants.CLASS_ID, AreaMedicaConstants.ARG_ID_DELUSRAREAMEDICA_AREAMEDICADELUSRAREAMEDICAPTHISAREAMEDICA, AreaMedicaConstants.SERV_ALIAS_DELUSRAREAMEDICA, AreaMedicaConstants.CLASS_ALIAS, AreaMedicaConstants.ARG_ALIAS_DELUSRAREAMEDICA_AREAMEDICADELUSRAREAMEDICAPTHISAREAMEDICA);
        }
    }

    @JsonIgnore
    public SolicitudOid getAreaMedicaDelUsrAreaMedicapevcSolicitud() {
        return this.areaMedicaDelUsrAreaMedicapevcSolicitud;
    }
    
    public void setAreaMedicaDelUsrAreaMedicapevcSolicitud(SolicitudOid areaMedicaDelUsrAreaMedicapevcSolicitud) {
        this.areaMedicaDelUsrAreaMedicapevcSolicitud = areaMedicaDelUsrAreaMedicapevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getAreaMedicaDelUsrAreaMedicapevcSolicitudInstance() {
        return this.areaMedicaDelUsrAreaMedicapevcSolicitudInstance;
    }
    
    public void setAreaMedicaDelUsrAreaMedicapevcSolicitudInstance(Solicitud areaMedicaDelUsrAreaMedicapevcSolicitud) {
        this.areaMedicaDelUsrAreaMedicapevcSolicitudInstance = areaMedicaDelUsrAreaMedicapevcSolicitud;
        this.areaMedicaDelUsrAreaMedicapevcSolicitud = areaMedicaDelUsrAreaMedicapevcSolicitud != null ? areaMedicaDelUsrAreaMedicapevcSolicitud.getOid() : null;
    }

    private void checkAreaMedicaDelUsrAreaMedicapevcSolicitud() throws NotNullArgumentException {
        if(this.getAreaMedicaDelUsrAreaMedicapevcSolicitudInstance() == null || this.getAreaMedicaDelUsrAreaMedicapevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(AreaMedicaConstants.SERV_ID_DELUSRAREAMEDICA, AreaMedicaConstants.CLASS_ID, AreaMedicaConstants.ARG_ID_DELUSRAREAMEDICA_AREAMEDICADELUSRAREAMEDICAPEVCSOLICITUD, AreaMedicaConstants.SERV_ALIAS_DELUSRAREAMEDICA, AreaMedicaConstants.CLASS_ALIAS, AreaMedicaConstants.ARG_ALIAS_DELUSRAREAMEDICA_AREAMEDICADELUSRAREAMEDICAPEVCSOLICITUD);
        }
    }
}
