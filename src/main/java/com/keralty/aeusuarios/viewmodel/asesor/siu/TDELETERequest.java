package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TDELETERequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTDELETEpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTDELETEpthisAsesorInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTDELETEpthisAsesor();
    }

    @JsonIgnore
    public AsesorOid getAsesorTDELETEpthisAsesor() {
        return this.asesorTDELETEpthisAsesor;
    }
    
    public void setAsesorTDELETEpthisAsesor(AsesorOid asesorTDELETEpthisAsesor) {
        this.asesorTDELETEpthisAsesor = asesorTDELETEpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTDELETEpthisAsesorInstance() {
        return this.asesorTDELETEpthisAsesorInstance;
    }
    
    public void setAsesorTDELETEpthisAsesorInstance(Asesor asesorTDELETEpthisAsesor) {
        this.asesorTDELETEpthisAsesorInstance = asesorTDELETEpthisAsesor;
        this.asesorTDELETEpthisAsesor = asesorTDELETEpthisAsesor != null ? asesorTDELETEpthisAsesor.getOid() : null;
    }

    private void checkAsesorTDELETEpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTDELETEpthisAsesorInstance() == null || this.getAsesorTDELETEpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TDELETE, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TDELETE_ASESORTDELETEPTHISASESOR, AsesorConstants.SERV_ALIAS_TDELETE, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TDELETE_ASESORTDELETEPTHISASESOR);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
