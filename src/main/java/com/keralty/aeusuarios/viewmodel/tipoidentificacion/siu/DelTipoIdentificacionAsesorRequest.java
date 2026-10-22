package com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class DelTipoIdentificacionAsesorRequest {

    @JsonProperty("p_thistipoidentificacion_oid")
    private TipoIdentificacionOid tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance;

    @JsonProperty("p_evcasesor_oid")
    private AsesorOid tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor;
    
    @JsonIgnore
    private Asesor tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion();
        checkTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor();
    }

    @JsonIgnore
    public TipoIdentificacionOid getTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion() {
        return this.tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion(TipoIdentificacionOid tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion) {
        this.tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance = tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion;
        this.tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion = tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion != null ? tipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionDelTipoIdentificacionAsesorpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONASESORPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONASESORPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public AsesorOid getTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor() {
        return this.tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor(AsesorOid tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor) {
        this.tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor = tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor;
    }

    @JsonIgnore
    public Asesor getTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance() {
        return this.tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance;
    }
    
    public void setTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance(Asesor tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor) {
        this.tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance = tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor;
        this.tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor = tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor != null ? tipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor.getOid() : null;
    }

    private void checkTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesor() throws NotNullArgumentException {
        if(this.getTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance() == null || this.getTipoIdentificacionDelTipoIdentificacionAsesorpevcAsesorInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_DELTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_DELTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONASESORPEVCASESOR, TipoIdentificacionConstants.SERV_ALIAS_DELTIPOIDENTIFICACIONASESOR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_DELTIPOIDENTIFICACIONASESOR_TIPOIDENTIFICACIONDELTIPOIDENTIFICACIONASESORPEVCASESOR);
        }
    }
}
