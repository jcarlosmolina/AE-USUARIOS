package com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class SincronizarRequest {

    @JsonProperty("p_thistipoidentificacion_oid")
    private TipoIdentificacionOid tipoIdentificacionsincronizarpthisTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tipoIdentificacionsincronizarpthisTipoIdentificacionInstance;

    @JsonProperty("p_descripcion")
    private String tipoIdentificacionsincronizarpDescripcion;

    @JsonProperty("p_nombrecorto")
    private String tipoIdentificacionsincronizarpNombreCorto;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacionsincronizarpthisTipoIdentificacion();
        checkTipoIdentificacionsincronizarpDescripcion();
        checkTipoIdentificacionsincronizarpNombreCorto();
    }

    @JsonIgnore
    public TipoIdentificacionOid getTipoIdentificacionsincronizarpthisTipoIdentificacion() {
        return this.tipoIdentificacionsincronizarpthisTipoIdentificacion;
    }
    
    public void setTipoIdentificacionsincronizarpthisTipoIdentificacion(TipoIdentificacionOid tipoIdentificacionsincronizarpthisTipoIdentificacion) {
        this.tipoIdentificacionsincronizarpthisTipoIdentificacion = tipoIdentificacionsincronizarpthisTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTipoIdentificacionsincronizarpthisTipoIdentificacionInstance() {
        return this.tipoIdentificacionsincronizarpthisTipoIdentificacionInstance;
    }
    
    public void setTipoIdentificacionsincronizarpthisTipoIdentificacionInstance(TipoIdentificacion tipoIdentificacionsincronizarpthisTipoIdentificacion) {
        this.tipoIdentificacionsincronizarpthisTipoIdentificacionInstance = tipoIdentificacionsincronizarpthisTipoIdentificacion;
        this.tipoIdentificacionsincronizarpthisTipoIdentificacion = tipoIdentificacionsincronizarpthisTipoIdentificacion != null ? tipoIdentificacionsincronizarpthisTipoIdentificacion.getOid() : null;
    }

    private void checkTipoIdentificacionsincronizarpthisTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionsincronizarpthisTipoIdentificacionInstance() == null || this.getTipoIdentificacionsincronizarpthisTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_SINCRONIZAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_SINCRONIZAR_TIPOIDENTIFICACIONSINCRONIZARPTHISTIPOIDENTIFICACION, TipoIdentificacionConstants.SERV_ALIAS_SINCRONIZAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_SINCRONIZAR_TIPOIDENTIFICACIONSINCRONIZARPTHISTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getTipoIdentificacionsincronizarpDescripcion() {
        return this.tipoIdentificacionsincronizarpDescripcion;
    }
    
    public void setTipoIdentificacionsincronizarpDescripcion(String tipoIdentificacionsincronizarpDescripcion) {
        this.tipoIdentificacionsincronizarpDescripcion = tipoIdentificacionsincronizarpDescripcion;
    }

    private void checkTipoIdentificacionsincronizarpDescripcion() throws NotNullArgumentException {
        if(this.getTipoIdentificacionsincronizarpDescripcion() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_SINCRONIZAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_SINCRONIZAR_TIPOIDENTIFICACIONSINCRONIZARPDESCRIPCION, TipoIdentificacionConstants.SERV_ALIAS_SINCRONIZAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_SINCRONIZAR_TIPOIDENTIFICACIONSINCRONIZARPDESCRIPCION);
        }
    }

    @JsonIgnore
    public String getTipoIdentificacionsincronizarpNombreCorto() {
        return this.tipoIdentificacionsincronizarpNombreCorto;
    }
    
    public void setTipoIdentificacionsincronizarpNombreCorto(String tipoIdentificacionsincronizarpNombreCorto) {
        this.tipoIdentificacionsincronizarpNombreCorto = tipoIdentificacionsincronizarpNombreCorto;
    }

    private void checkTipoIdentificacionsincronizarpNombreCorto() throws NotNullArgumentException {
        if(this.getTipoIdentificacionsincronizarpNombreCorto() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_SINCRONIZAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_SINCRONIZAR_TIPOIDENTIFICACIONSINCRONIZARPNOMBRECORTO, TipoIdentificacionConstants.SERV_ALIAS_SINCRONIZAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_SINCRONIZAR_TIPOIDENTIFICACIONSINCRONIZARPNOMBRECORTO);
        }
    }
}
