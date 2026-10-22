package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class InsTipoIdentificacionAsesorRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorInsTipoIdentificacionAsesorpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorInsTipoIdentificacionAsesorpthisAsesorInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion asesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorInsTipoIdentificacionAsesorpthisAsesor();
        checkAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacion();
    }

    @JsonIgnore
    public AsesorOid getAsesorInsTipoIdentificacionAsesorpthisAsesor() {
        return this.asesorInsTipoIdentificacionAsesorpthisAsesor;
    }
    
    public void setAsesorInsTipoIdentificacionAsesorpthisAsesor(AsesorOid asesorInsTipoIdentificacionAsesorpthisAsesor) {
        this.asesorInsTipoIdentificacionAsesorpthisAsesor = asesorInsTipoIdentificacionAsesorpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorInsTipoIdentificacionAsesorpthisAsesorInstance() {
        return this.asesorInsTipoIdentificacionAsesorpthisAsesorInstance;
    }
    
    public void setAsesorInsTipoIdentificacionAsesorpthisAsesorInstance(Asesor asesorInsTipoIdentificacionAsesorpthisAsesor) {
        this.asesorInsTipoIdentificacionAsesorpthisAsesorInstance = asesorInsTipoIdentificacionAsesorpthisAsesor;
        this.asesorInsTipoIdentificacionAsesorpthisAsesor = asesorInsTipoIdentificacionAsesorpthisAsesor != null ? asesorInsTipoIdentificacionAsesorpthisAsesor.getOid() : null;
    }

    private void checkAsesorInsTipoIdentificacionAsesorpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorInsTipoIdentificacionAsesorpthisAsesorInstance() == null || this.getAsesorInsTipoIdentificacionAsesorpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_INSTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_INSTIPOIDENTIFICACIONASESOR_ASESORINSTIPOIDENTIFICACIONASESORPTHISASESOR, AsesorConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONASESOR_ASESORINSTIPOIDENTIFICACIONASESORPTHISASESOR);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacion() {
        return this.asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion;
    }
    
    public void setAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacion(TipoIdentificacionOid asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion) {
        this.asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion = asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance() {
        return this.asesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance;
    }
    
    public void setAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance(TipoIdentificacion asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion) {
        this.asesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance = asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion;
        this.asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion = asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion != null ? asesorInsTipoIdentificacionAsesorpevcTipoIdentificacion.getOid() : null;
    }

    private void checkAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance() == null || this.getAsesorInsTipoIdentificacionAsesorpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_INSTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_INSTIPOIDENTIFICACIONASESOR_ASESORINSTIPOIDENTIFICACIONASESORPEVCTIPOIDENTIFICACION, AsesorConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONASESOR_ASESORINSTIPOIDENTIFICACIONASESORPEVCTIPOIDENTIFICACION);
        }
    }
}
