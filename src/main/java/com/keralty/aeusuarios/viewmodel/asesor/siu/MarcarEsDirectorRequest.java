package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class MarcarEsDirectorRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesormarcarEsDirectorpthisAsesor;
    
    @JsonIgnore
    private Asesor asesormarcarEsDirectorpthisAsesorInstance;

    @JsonProperty("p_esdirector")
    private Boolean asesormarcarEsDirectorpEsDirector;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesormarcarEsDirectorpthisAsesor();
        checkAsesormarcarEsDirectorpEsDirector();
    }

    @JsonIgnore
    public AsesorOid getAsesormarcarEsDirectorpthisAsesor() {
        return this.asesormarcarEsDirectorpthisAsesor;
    }
    
    public void setAsesormarcarEsDirectorpthisAsesor(AsesorOid asesormarcarEsDirectorpthisAsesor) {
        this.asesormarcarEsDirectorpthisAsesor = asesormarcarEsDirectorpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesormarcarEsDirectorpthisAsesorInstance() {
        return this.asesormarcarEsDirectorpthisAsesorInstance;
    }
    
    public void setAsesormarcarEsDirectorpthisAsesorInstance(Asesor asesormarcarEsDirectorpthisAsesor) {
        this.asesormarcarEsDirectorpthisAsesorInstance = asesormarcarEsDirectorpthisAsesor;
        this.asesormarcarEsDirectorpthisAsesor = asesormarcarEsDirectorpthisAsesor != null ? asesormarcarEsDirectorpthisAsesor.getOid() : null;
    }

    private void checkAsesormarcarEsDirectorpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesormarcarEsDirectorpthisAsesorInstance() == null || this.getAsesormarcarEsDirectorpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MARCARESDIRECTOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MARCARESDIRECTOR_ASESORMARCARESDIRECTORPTHISASESOR, AsesorConstants.SERV_ALIAS_MARCARESDIRECTOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MARCARESDIRECTOR_ASESORMARCARESDIRECTORPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesormarcarEsDirectorpEsDirector() {
        return this.asesormarcarEsDirectorpEsDirector;
    }
    
    public void setAsesormarcarEsDirectorpEsDirector(Boolean asesormarcarEsDirectorpEsDirector) {
        this.asesormarcarEsDirectorpEsDirector = asesormarcarEsDirectorpEsDirector;
    }

    private void checkAsesormarcarEsDirectorpEsDirector() throws NotNullArgumentException {
        if(this.getAsesormarcarEsDirectorpEsDirector() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MARCARESDIRECTOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MARCARESDIRECTOR_ASESORMARCARESDIRECTORPESDIRECTOR, AsesorConstants.SERV_ALIAS_MARCARESDIRECTOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MARCARESDIRECTOR_ASESORMARCARESDIRECTORPESDIRECTOR);
        }
    }
}
