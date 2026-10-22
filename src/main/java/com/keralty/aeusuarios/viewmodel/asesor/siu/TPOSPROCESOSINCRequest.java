package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TPOSPROCESOSINCRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTPOSPROCESOSINCpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTPOSPROCESOSINCpthisAsesorInstance;

    @JsonProperty("p_esdirector")
    private Boolean asesorTPOSPROCESOSINCpEsDirector;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTPOSPROCESOSINCpthisAsesor();
        checkAsesorTPOSPROCESOSINCpEsDirector();
    }

    @JsonIgnore
    public AsesorOid getAsesorTPOSPROCESOSINCpthisAsesor() {
        return this.asesorTPOSPROCESOSINCpthisAsesor;
    }
    
    public void setAsesorTPOSPROCESOSINCpthisAsesor(AsesorOid asesorTPOSPROCESOSINCpthisAsesor) {
        this.asesorTPOSPROCESOSINCpthisAsesor = asesorTPOSPROCESOSINCpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTPOSPROCESOSINCpthisAsesorInstance() {
        return this.asesorTPOSPROCESOSINCpthisAsesorInstance;
    }
    
    public void setAsesorTPOSPROCESOSINCpthisAsesorInstance(Asesor asesorTPOSPROCESOSINCpthisAsesor) {
        this.asesorTPOSPROCESOSINCpthisAsesorInstance = asesorTPOSPROCESOSINCpthisAsesor;
        this.asesorTPOSPROCESOSINCpthisAsesor = asesorTPOSPROCESOSINCpthisAsesor != null ? asesorTPOSPROCESOSINCpthisAsesor.getOid() : null;
    }

    private void checkAsesorTPOSPROCESOSINCpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTPOSPROCESOSINCpthisAsesorInstance() == null || this.getAsesorTPOSPROCESOSINCpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TPOSPROCESOSINC, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TPOSPROCESOSINC_ASESORTPOSPROCESOSINCPTHISASESOR, AsesorConstants.SERV_ALIAS_TPOSPROCESOSINC, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TPOSPROCESOSINC_ASESORTPOSPROCESOSINCPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTPOSPROCESOSINCpEsDirector() {
        return this.asesorTPOSPROCESOSINCpEsDirector;
    }
    
    public void setAsesorTPOSPROCESOSINCpEsDirector(Boolean asesorTPOSPROCESOSINCpEsDirector) {
        this.asesorTPOSPROCESOSINCpEsDirector = asesorTPOSPROCESOSINCpEsDirector;
    }

    private void checkAsesorTPOSPROCESOSINCpEsDirector() throws NotNullArgumentException {
        if(this.getAsesorTPOSPROCESOSINCpEsDirector() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TPOSPROCESOSINC, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TPOSPROCESOSINC_ASESORTPOSPROCESOSINCPESDIRECTOR, AsesorConstants.SERV_ALIAS_TPOSPROCESOSINC, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TPOSPROCESOSINC_ASESORTPOSPROCESOSINCPESDIRECTOR);
        }
    }
}
