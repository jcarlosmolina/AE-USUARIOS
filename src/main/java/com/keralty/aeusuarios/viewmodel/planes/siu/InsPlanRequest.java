package com.keralty.aeusuarios.viewmodel.planes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.Planes;

public class InsPlanRequest {

    @JsonProperty("p_thisplanes_oid")
    private PlanesOid planesInsPlanpthisPlanes;
    
    @JsonIgnore
    private Planes planesInsPlanpthisPlanesInstance;

    @JsonProperty("p_evcafiliaciones_oid")
    private AfiliacionesOid planesInsPlanpevcAfiliaciones;
    
    @JsonIgnore
    private Afiliaciones planesInsPlanpevcAfiliacionesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPlanesInsPlanpthisPlanes();
        checkPlanesInsPlanpevcAfiliaciones();
    }

    @JsonIgnore
    public PlanesOid getPlanesInsPlanpthisPlanes() {
        return this.planesInsPlanpthisPlanes;
    }
    
    public void setPlanesInsPlanpthisPlanes(PlanesOid planesInsPlanpthisPlanes) {
        this.planesInsPlanpthisPlanes = planesInsPlanpthisPlanes;
    }

    @JsonIgnore
    public Planes getPlanesInsPlanpthisPlanesInstance() {
        return this.planesInsPlanpthisPlanesInstance;
    }
    
    public void setPlanesInsPlanpthisPlanesInstance(Planes planesInsPlanpthisPlanes) {
        this.planesInsPlanpthisPlanesInstance = planesInsPlanpthisPlanes;
        this.planesInsPlanpthisPlanes = planesInsPlanpthisPlanes != null ? planesInsPlanpthisPlanes.getOid() : null;
    }

    private void checkPlanesInsPlanpthisPlanes() throws NotNullArgumentException {
        if(this.getPlanesInsPlanpthisPlanesInstance() == null || this.getPlanesInsPlanpthisPlanesInstance().isNull()) {
            throw new NotNullArgumentException(PlanesConstants.SERV_ID_INSPLAN, PlanesConstants.CLASS_ID, PlanesConstants.ARG_ID_INSPLAN_PLANESINSPLANPTHISPLANES, PlanesConstants.SERV_ALIAS_INSPLAN, PlanesConstants.CLASS_ALIAS, PlanesConstants.ARG_ALIAS_INSPLAN_PLANESINSPLANPTHISPLANES);
        }
    }

    @JsonIgnore
    public AfiliacionesOid getPlanesInsPlanpevcAfiliaciones() {
        return this.planesInsPlanpevcAfiliaciones;
    }
    
    public void setPlanesInsPlanpevcAfiliaciones(AfiliacionesOid planesInsPlanpevcAfiliaciones) {
        this.planesInsPlanpevcAfiliaciones = planesInsPlanpevcAfiliaciones;
    }

    @JsonIgnore
    public Afiliaciones getPlanesInsPlanpevcAfiliacionesInstance() {
        return this.planesInsPlanpevcAfiliacionesInstance;
    }
    
    public void setPlanesInsPlanpevcAfiliacionesInstance(Afiliaciones planesInsPlanpevcAfiliaciones) {
        this.planesInsPlanpevcAfiliacionesInstance = planesInsPlanpevcAfiliaciones;
        this.planesInsPlanpevcAfiliaciones = planesInsPlanpevcAfiliaciones != null ? planesInsPlanpevcAfiliaciones.getOid() : null;
    }

    private void checkPlanesInsPlanpevcAfiliaciones() throws NotNullArgumentException {
        if(this.getPlanesInsPlanpevcAfiliacionesInstance() == null || this.getPlanesInsPlanpevcAfiliacionesInstance().isNull()) {
            throw new NotNullArgumentException(PlanesConstants.SERV_ID_INSPLAN, PlanesConstants.CLASS_ID, PlanesConstants.ARG_ID_INSPLAN_PLANESINSPLANPEVCAFILIACIONES, PlanesConstants.SERV_ALIAS_INSPLAN, PlanesConstants.CLASS_ALIAS, PlanesConstants.ARG_ALIAS_INSPLAN_PLANESINSPLANPEVCAFILIACIONES);
        }
    }
}
