package com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class InsTipoIdentificacionAsesorRequest {

    @JsonProperty("p_thistipoidentificacion_oid")
    private TipoIdentificacionOid tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcasesor_oid")
    private AsesorOid tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor;
    
    @JsonIgnore
    private Asesor tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion();
        checkTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor();
    }

    @JsonIgnore
    public TipoIdentificacionOid getTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion() {
        return this.tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion(TipoIdentificacionOid tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion) {
        this.tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance = tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion;
        this.tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion = tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion != null ? tipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionInsTipoIdentificacionAsesorpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONASESORPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONASESORPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public AsesorOid getTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor() {
        return this.tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor(AsesorOid tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor) {
        this.tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor = tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor;
    }

    @JsonIgnore
    public Asesor getTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance() {
        return this.tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance;
    }
    
    public void setTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance(Asesor tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor) {
        this.tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance = tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor;
        this.tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor = tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor != null ? tipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor.getOid() : null;
    }

    private void checkTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesor() throws NotNullArgumentException {
        if(this.getTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance() == null || this.getTipoIdentificacionInsTipoIdentificacionAsesorpevcAsesorInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_INSTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_INSTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONASESORPEVCASESOR, TipoIdentificacionConstants.SERV_ALIAS_INSTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_INSTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONINSTIPOIDENTIFICACIONASESORPEVCASESOR);
        }
    }
}
