package com.keralty.aeusuarios.viewmodel.afiliaciones.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AfiliacionesConstants;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.oid.AfiliacionesOid;
import com.keralty.aeusuarios.persistence.oid.PlanesOid;
import com.keralty.aeusuarios.persistence.Planes;

public class DelPlanRequest {

    @JsonProperty("p_thisafiliaciones_oid")
    private AfiliacionesOid afiliacionesDelPlanpthisAfiliaciones;
    
    @JsonIgnore
    private Afiliaciones afiliacionesDelPlanpthisAfiliacionesInstance;

    @JsonProperty("p_evcplanes_oid")
    private PlanesOid afiliacionesDelPlanpevcPlanes;
    
    @JsonIgnore
    private Planes afiliacionesDelPlanpevcPlanesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAfiliacionesDelPlanpthisAfiliaciones();
        checkAfiliacionesDelPlanpevcPlanes();
    }

    @JsonIgnore
    public AfiliacionesOid getAfiliacionesDelPlanpthisAfiliaciones() {
        return this.afiliacionesDelPlanpthisAfiliaciones;
    }
    
    public void setAfiliacionesDelPlanpthisAfiliaciones(AfiliacionesOid afiliacionesDelPlanpthisAfiliaciones) {
        this.afiliacionesDelPlanpthisAfiliaciones = afiliacionesDelPlanpthisAfiliaciones;
    }

    @JsonIgnore
    public Afiliaciones getAfiliacionesDelPlanpthisAfiliacionesInstance() {
        return this.afiliacionesDelPlanpthisAfiliacionesInstance;
    }
    
    public void setAfiliacionesDelPlanpthisAfiliacionesInstance(Afiliaciones afiliacionesDelPlanpthisAfiliaciones) {
        this.afiliacionesDelPlanpthisAfiliacionesInstance = afiliacionesDelPlanpthisAfiliaciones;
        this.afiliacionesDelPlanpthisAfiliaciones = afiliacionesDelPlanpthisAfiliaciones != null ? afiliacionesDelPlanpthisAfiliaciones.getOid() : null;
    }

    private void checkAfiliacionesDelPlanpthisAfiliaciones() throws NotNullArgumentException {
        if(this.getAfiliacionesDelPlanpthisAfiliacionesInstance() == null || this.getAfiliacionesDelPlanpthisAfiliacionesInstance().isNull()) {
            throw new NotNullArgumentException(AfiliacionesConstants.SERV_ID_DELPLAN, AfiliacionesConstants.CLASS_ID, AfiliacionesConstants.ARG_ID_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES, AfiliacionesConstants.SERV_ALIAS_DELPLAN, AfiliacionesConstants.CLASS_ALIAS, AfiliacionesConstants.ARG_ALIAS_DELPLAN_AFILIACIONESDELPLANPTHISAFILIACIONES);
        }
    }

    @JsonIgnore
    public PlanesOid getAfiliacionesDelPlanpevcPlanes() {
        return this.afiliacionesDelPlanpevcPlanes;
    }
    
    public void setAfiliacionesDelPlanpevcPlanes(PlanesOid afiliacionesDelPlanpevcPlanes) {
        this.afiliacionesDelPlanpevcPlanes = afiliacionesDelPlanpevcPlanes;
    }

    @JsonIgnore
    public Planes getAfiliacionesDelPlanpevcPlanesInstance() {
        return this.afiliacionesDelPlanpevcPlanesInstance;
    }
    
    public void setAfiliacionesDelPlanpevcPlanesInstance(Planes afiliacionesDelPlanpevcPlanes) {
        this.afiliacionesDelPlanpevcPlanesInstance = afiliacionesDelPlanpevcPlanes;
        this.afiliacionesDelPlanpevcPlanes = afiliacionesDelPlanpevcPlanes != null ? afiliacionesDelPlanpevcPlanes.getOid() : null;
    }

    private void checkAfiliacionesDelPlanpevcPlanes() throws NotNullArgumentException {
        if(this.getAfiliacionesDelPlanpevcPlanesInstance() == null || this.getAfiliacionesDelPlanpevcPlanesInstance().isNull()) {
            throw new NotNullArgumentException(AfiliacionesConstants.SERV_ID_DELPLAN, AfiliacionesConstants.CLASS_ID, AfiliacionesConstants.ARG_ID_DELPLAN_AFILIACIONESDELPLANPEVCPLANES, AfiliacionesConstants.SERV_ALIAS_DELPLAN, AfiliacionesConstants.CLASS_ALIAS, AfiliacionesConstants.ARG_ALIAS_DELPLAN_AFILIACIONESDELPLANPEVCPLANES);
        }
    }
}
