package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class DelTipoIdentificacionAsesorRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorDelTipoIdentificacionAsesorpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorDelTipoIdentificacionAsesorpthisAsesorInstance;

    @JsonProperty("p_evctipoidentificacion_oid")
    private TipoIdentificacionOid asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion asesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorDelTipoIdentificacionAsesorpthisAsesor();
        checkAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacion();
    }

    @JsonIgnore
    public AsesorOid getAsesorDelTipoIdentificacionAsesorpthisAsesor() {
        return this.asesorDelTipoIdentificacionAsesorpthisAsesor;
    }
    
    public void setAsesorDelTipoIdentificacionAsesorpthisAsesor(AsesorOid asesorDelTipoIdentificacionAsesorpthisAsesor) {
        this.asesorDelTipoIdentificacionAsesorpthisAsesor = asesorDelTipoIdentificacionAsesorpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorDelTipoIdentificacionAsesorpthisAsesorInstance() {
        return this.asesorDelTipoIdentificacionAsesorpthisAsesorInstance;
    }
    
    public void setAsesorDelTipoIdentificacionAsesorpthisAsesorInstance(Asesor asesorDelTipoIdentificacionAsesorpthisAsesor) {
        this.asesorDelTipoIdentificacionAsesorpthisAsesorInstance = asesorDelTipoIdentificacionAsesorpthisAsesor;
        this.asesorDelTipoIdentificacionAsesorpthisAsesor = asesorDelTipoIdentificacionAsesorpthisAsesor != null ? asesorDelTipoIdentificacionAsesorpthisAsesor.getOid() : null;
    }

    private void checkAsesorDelTipoIdentificacionAsesorpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorDelTipoIdentificacionAsesorpthisAsesorInstance() == null || this.getAsesorDelTipoIdentificacionAsesorpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_DELTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_DELTIPOIDENTIFICACIONASESOR_ASESORDELTIPOIDENTIFICACIONASESORPTHISASESOR, AsesorConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONASESOR_ASESORDELTIPOIDENTIFICACIONASESORPTHISASESOR);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacion() {
        return this.asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion;
    }
    
    public void setAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacion(TipoIdentificacionOid asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion) {
        this.asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion = asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance() {
        return this.asesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance;
    }
    
    public void setAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance(TipoIdentificacion asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion) {
        this.asesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance = asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion;
        this.asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion = asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion != null ? asesorDelTipoIdentificacionAsesorpevcTipoIdentificacion.getOid() : null;
    }

    private void checkAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacion() throws NotNullArgumentException {
        if(this.getAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance() == null || this.getAsesorDelTipoIdentificacionAsesorpevcTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_DELTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_DELTIPOIDENTIFICACIONASESOR_ASESORDELTIPOIDENTIFICACIONASESORPEVCTIPOIDENTIFICACION, AsesorConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONASESOR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONASESOR_ASESORDELTIPOIDENTIFICACIONASESORPEVCTIPOIDENTIFICACION);
        }
    }
}
