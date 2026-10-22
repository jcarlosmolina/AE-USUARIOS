package com.keralty.aeusuarios.viewmodel.afiliaciones.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.Planes;

public class InsPlanRequest {

    @JsonProperty("p_thisafiliaciones_oid")
    private AfiliacionesOid afiliacionesInsPlanpthisAfiliaciones;
    
    @JsonIgnore
    private Afiliaciones afiliacionesInsPlanpthisAfiliacionesInstance;

    @JsonProperty("p_evcplanes_oid")
    private PlanesOid afiliacionesInsPlanpevcPlanes;
    
    @JsonIgnore
    private Planes afiliacionesInsPlanpevcPlanesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAfiliacionesInsPlanpthisAfiliaciones();
        checkAfiliacionesInsPlanpevcPlanes();
    }

    @JsonIgnore
    public AfiliacionesOid getAfiliacionesInsPlanpthisAfiliaciones() {
        return this.afiliacionesInsPlanpthisAfiliaciones;
    }
    
    public void setAfiliacionesInsPlanpthisAfiliaciones(AfiliacionesOid afiliacionesInsPlanpthisAfiliaciones) {
        this.afiliacionesInsPlanpthisAfiliaciones = afiliacionesInsPlanpthisAfiliaciones;
    }

    @JsonIgnore
    public Afiliaciones getAfiliacionesInsPlanpthisAfiliacionesInstance() {
        return this.afiliacionesInsPlanpthisAfiliacionesInstance;
    }
    
    public void setAfiliacionesInsPlanpthisAfiliacionesInstance(Afiliaciones afiliacionesInsPlanpthisAfiliaciones) {
        this.afiliacionesInsPlanpthisAfiliacionesInstance = afiliacionesInsPlanpthisAfiliaciones;
        this.afiliacionesInsPlanpthisAfiliaciones = afiliacionesInsPlanpthisAfiliaciones != null ? afiliacionesInsPlanpthisAfiliaciones.getOid() : null;
    }

    private void checkAfiliacionesInsPlanpthisAfiliaciones() throws NotNullArgumentException {
        if(this.getAfiliacionesInsPlanpthisAfiliacionesInstance() == null || this.getAfiliacionesInsPlanpthisAfiliacionesInstance().isNull()) {
            throw new NotNullArgumentException(AfiliacionesConstants.SERV_ID_INSPLAN, AfiliacionesConstants.CLASS_ID, AfiliacionesConstants.ARG_ID_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES, AfiliacionesConstants.SERV_ALIAS_INSPLAN, AfiliacionesConstants.CLASS_ALIAS, AfiliacionesConstants.ARG_ALIAS_INSPLAN_AFILIACIONESINSPLANPTHISAFILIACIONES);
        }
    }

    @JsonIgnore
    public PlanesOid getAfiliacionesInsPlanpevcPlanes() {
        return this.afiliacionesInsPlanpevcPlanes;
    }
    
    public void setAfiliacionesInsPlanpevcPlanes(PlanesOid afiliacionesInsPlanpevcPlanes) {
        this.afiliacionesInsPlanpevcPlanes = afiliacionesInsPlanpevcPlanes;
    }

    @JsonIgnore
    public Planes getAfiliacionesInsPlanpevcPlanesInstance() {
        return this.afiliacionesInsPlanpevcPlanesInstance;
    }
    
    public void setAfiliacionesInsPlanpevcPlanesInstance(Planes afiliacionesInsPlanpevcPlanes) {
        this.afiliacionesInsPlanpevcPlanesInstance = afiliacionesInsPlanpevcPlanes;
        this.afiliacionesInsPlanpevcPlanes = afiliacionesInsPlanpevcPlanes != null ? afiliacionesInsPlanpevcPlanes.getOid() : null;
    }

    private void checkAfiliacionesInsPlanpevcPlanes() throws NotNullArgumentException {
        if(this.getAfiliacionesInsPlanpevcPlanesInstance() == null || this.getAfiliacionesInsPlanpevcPlanesInstance().isNull()) {
            throw new NotNullArgumentException(AfiliacionesConstants.SERV_ID_INSPLAN, AfiliacionesConstants.CLASS_ID, AfiliacionesConstants.ARG_ID_INSPLAN_AFILIACIONESINSPLANPEVCPLANES, AfiliacionesConstants.SERV_ALIAS_INSPLAN, AfiliacionesConstants.CLASS_ALIAS, AfiliacionesConstants.ARG_ALIAS_INSPLAN_AFILIACIONESINSPLANPEVCPLANES);
        }
    }
}
