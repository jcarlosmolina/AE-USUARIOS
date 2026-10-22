package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolicitudNovedadNull {

    @JsonProperty("id")
    private Long dSSolicitudNovedadNullId;

    public DSSolicitudNovedadNull() {
    
    }

    public DSSolicitudNovedadNull(SolicitudNovedad instance) {
        if (instance != null) {
            this.dSSolicitudNovedadNullId = instance.getSolicitudNovedadId();
        }
    }

    @JsonIgnore
    public Long getDSSolicitudNovedadNullId() {
        return this.dSSolicitudNovedadNullId;
    }
    
    public void setDSSolicitudNovedadNullId(Long dSSolicitudNovedadNullId) {
        this.dSSolicitudNovedadNullId = dSSolicitudNovedadNullId;
    }
}
