package com.keralty.aeusuarios.viewmodel.planes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.PlanesConstants;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.Planes;

public class DelPlanRequest {

    @JsonProperty("p_thisplanes_oid")
    private PlanesOid planesDelPlanpthisPlanes;
    
    @JsonIgnore
    private Planes planesDelPlanpthisPlanesInstance;

    @JsonProperty("p_evcafiliaciones_oid")
    private AfiliacionesOid planesDelPlanpevcAfiliaciones;
    
    @JsonIgnore
    private Afiliaciones planesDelPlanpevcAfiliacionesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkPlanesDelPlanpthisPlanes();
        checkPlanesDelPlanpevcAfiliaciones();
    }

    @JsonIgnore
    public PlanesOid getPlanesDelPlanpthisPlanes() {
        return this.planesDelPlanpthisPlanes;
    }
    
    public void setPlanesDelPlanpthisPlanes(PlanesOid planesDelPlanpthisPlanes) {
        this.planesDelPlanpthisPlanes = planesDelPlanpthisPlanes;
    }

    @JsonIgnore
    public Planes getPlanesDelPlanpthisPlanesInstance() {
        return this.planesDelPlanpthisPlanesInstance;
    }
    
    public void setPlanesDelPlanpthisPlanesInstance(Planes planesDelPlanpthisPlanes) {
        this.planesDelPlanpthisPlanesInstance = planesDelPlanpthisPlanes;
        this.planesDelPlanpthisPlanes = planesDelPlanpthisPlanes != null ? planesDelPlanpthisPlanes.getOid() : null;
    }

    private void checkPlanesDelPlanpthisPlanes() throws NotNullArgumentException {
        if(this.getPlanesDelPlanpthisPlanesInstance() == null || this.getPlanesDelPlanpthisPlanesInstance().isNull()) {
            throw new NotNullArgumentException(PlanesConstants.SERV_ID_DELPLAN, PlanesConstants.CLASS_ID, PlanesConstants.ARG_ID_DELPLAN_PLANESDELPLANPTHISPLANES, PlanesConstants.SERV_ALIAS_DELPLAN, PlanesConstants.CLASS_ALIAS, PlanesConstants.ARG_ALIAS_DELPLAN_PLANESDELPLANPTHISPLANES);
        }
    }

    @JsonIgnore
    public AfiliacionesOid getPlanesDelPlanpevcAfiliaciones() {
        return this.planesDelPlanpevcAfiliaciones;
    }
    
    public void setPlanesDelPlanpevcAfiliaciones(AfiliacionesOid planesDelPlanpevcAfiliaciones) {
        this.planesDelPlanpevcAfiliaciones = planesDelPlanpevcAfiliaciones;
    }

    @JsonIgnore
    public Afiliaciones getPlanesDelPlanpevcAfiliacionesInstance() {
        return this.planesDelPlanpevcAfiliacionesInstance;
    }
    
    public void setPlanesDelPlanpevcAfiliacionesInstance(Afiliaciones planesDelPlanpevcAfiliaciones) {
        this.planesDelPlanpevcAfiliacionesInstance = planesDelPlanpevcAfiliaciones;
        this.planesDelPlanpevcAfiliaciones = planesDelPlanpevcAfiliaciones != null ? planesDelPlanpevcAfiliaciones.getOid() : null;
    }

    private void checkPlanesDelPlanpevcAfiliaciones() throws NotNullArgumentException {
        if(this.getPlanesDelPlanpevcAfiliacionesInstance() == null || this.getPlanesDelPlanpevcAfiliacionesInstance().isNull()) {
            throw new NotNullArgumentException(PlanesConstants.SERV_ID_DELPLAN, PlanesConstants.CLASS_ID, PlanesConstants.ARG_ID_DELPLAN_PLANESDELPLANPEVCAFILIACIONES, PlanesConstants.SERV_ALIAS_DELPLAN, PlanesConstants.CLASS_ALIAS, PlanesConstants.ARG_ALIAS_DELPLAN_PLANESDELPLANPEVCAFILIACIONES);
        }
    }
}
