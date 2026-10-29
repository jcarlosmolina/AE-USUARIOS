package com.keralty.aeusuarios.viewmodel.logllamadasbh.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogLlamadasBHConstants;
import java.sql.Timestamp;

public class CreateinstanceRequest {

    @JsonProperty("p_atrfechahora")
    private Timestamp logLlamadasBHcreateinstancepatrFechaHora;

    @JsonProperty("p_atrusuario")
    private String logLlamadasBHcreateinstancepatrUsuario;

    @JsonProperty("p_atrcapacidad")
    private String logLlamadasBHcreateinstancepatrCapacidad;

    @JsonProperty("p_atrservicio")
    private String logLlamadasBHcreateinstancepatrServicio;

    @JsonProperty("p_atrsolicitud")
    private String logLlamadasBHcreateinstancepatrSolicitud;

    @JsonProperty("p_atrpeticion")
    private String logLlamadasBHcreateinstancepatrPeticion;

    @JsonProperty("p_atrrespuesta")
    private String logLlamadasBHcreateinstancepatrRespuesta;

    @JsonProperty("p_atrtiposervicio")
    private String logLlamadasBHcreateinstancepatrTipoServicio;

    @JsonProperty("p_atrtiempoejecucion")
    private Double logLlamadasBHcreateinstancepatrTiempoEjecucion;

    @JsonProperty("p_atrtextoerror")
    private String logLlamadasBHcreateinstancepatrTextoError;

    public void checkArguments() throws NotNullArgumentException {
        checkLogLlamadasBHcreateinstancepatrFechaHora();
        checkLogLlamadasBHcreateinstancepatrServicio();
        checkLogLlamadasBHcreateinstancepatrTipoServicio();
    }

    @JsonIgnore
    public Timestamp getLogLlamadasBHcreateinstancepatrFechaHora() {
        return this.logLlamadasBHcreateinstancepatrFechaHora;
    }
    
    public void setLogLlamadasBHcreateinstancepatrFechaHora(Timestamp logLlamadasBHcreateinstancepatrFechaHora) {
        this.logLlamadasBHcreateinstancepatrFechaHora = logLlamadasBHcreateinstancepatrFechaHora;
    }

    private void checkLogLlamadasBHcreateinstancepatrFechaHora() throws NotNullArgumentException {
        if(this.getLogLlamadasBHcreateinstancepatrFechaHora() == null) {
            throw new NotNullArgumentException(LogLlamadasBHConstants.SERV_ID_CREATEINSTANCE, LogLlamadasBHConstants.CLASS_ID, LogLlamadasBHConstants.ARG_ID_CREATEINSTANCE_LOGLLAMADASBHCREATEINSTANCEPATRFECHAHORA, LogLlamadasBHConstants.SERV_ALIAS_CREATEINSTANCE, LogLlamadasBHConstants.CLASS_ALIAS, LogLlamadasBHConstants.ARG_ALIAS_CREATEINSTANCE_LOGLLAMADASBHCREATEINSTANCEPATRFECHAHORA);
        }
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrUsuario() {
        return this.logLlamadasBHcreateinstancepatrUsuario;
    }
    
    public void setLogLlamadasBHcreateinstancepatrUsuario(String logLlamadasBHcreateinstancepatrUsuario) {
        this.logLlamadasBHcreateinstancepatrUsuario = logLlamadasBHcreateinstancepatrUsuario;
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrCapacidad() {
        return this.logLlamadasBHcreateinstancepatrCapacidad;
    }
    
    public void setLogLlamadasBHcreateinstancepatrCapacidad(String logLlamadasBHcreateinstancepatrCapacidad) {
        this.logLlamadasBHcreateinstancepatrCapacidad = logLlamadasBHcreateinstancepatrCapacidad;
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrServicio() {
        return this.logLlamadasBHcreateinstancepatrServicio;
    }
    
    public void setLogLlamadasBHcreateinstancepatrServicio(String logLlamadasBHcreateinstancepatrServicio) {
        this.logLlamadasBHcreateinstancepatrServicio = logLlamadasBHcreateinstancepatrServicio;
    }

    private void checkLogLlamadasBHcreateinstancepatrServicio() throws NotNullArgumentException {
        if(this.getLogLlamadasBHcreateinstancepatrServicio() == null) {
            throw new NotNullArgumentException(LogLlamadasBHConstants.SERV_ID_CREATEINSTANCE, LogLlamadasBHConstants.CLASS_ID, LogLlamadasBHConstants.ARG_ID_CREATEINSTANCE_LOGLLAMADASBHCREATEINSTANCEPATRSERVICIO, LogLlamadasBHConstants.SERV_ALIAS_CREATEINSTANCE, LogLlamadasBHConstants.CLASS_ALIAS, LogLlamadasBHConstants.ARG_ALIAS_CREATEINSTANCE_LOGLLAMADASBHCREATEINSTANCEPATRSERVICIO);
        }
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrSolicitud() {
        return this.logLlamadasBHcreateinstancepatrSolicitud;
    }
    
    public void setLogLlamadasBHcreateinstancepatrSolicitud(String logLlamadasBHcreateinstancepatrSolicitud) {
        this.logLlamadasBHcreateinstancepatrSolicitud = logLlamadasBHcreateinstancepatrSolicitud;
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrPeticion() {
        return this.logLlamadasBHcreateinstancepatrPeticion;
    }
    
    public void setLogLlamadasBHcreateinstancepatrPeticion(String logLlamadasBHcreateinstancepatrPeticion) {
        this.logLlamadasBHcreateinstancepatrPeticion = logLlamadasBHcreateinstancepatrPeticion;
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrRespuesta() {
        return this.logLlamadasBHcreateinstancepatrRespuesta;
    }
    
    public void setLogLlamadasBHcreateinstancepatrRespuesta(String logLlamadasBHcreateinstancepatrRespuesta) {
        this.logLlamadasBHcreateinstancepatrRespuesta = logLlamadasBHcreateinstancepatrRespuesta;
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrTipoServicio() {
        return this.logLlamadasBHcreateinstancepatrTipoServicio;
    }
    
    public void setLogLlamadasBHcreateinstancepatrTipoServicio(String logLlamadasBHcreateinstancepatrTipoServicio) {
        this.logLlamadasBHcreateinstancepatrTipoServicio = logLlamadasBHcreateinstancepatrTipoServicio;
    }

    private void checkLogLlamadasBHcreateinstancepatrTipoServicio() throws NotNullArgumentException {
        if(this.getLogLlamadasBHcreateinstancepatrTipoServicio() == null) {
            throw new NotNullArgumentException(LogLlamadasBHConstants.SERV_ID_CREATEINSTANCE, LogLlamadasBHConstants.CLASS_ID, LogLlamadasBHConstants.ARG_ID_CREATEINSTANCE_LOGLLAMADASBHCREATEINSTANCEPATRTIPOSERVICIO, LogLlamadasBHConstants.SERV_ALIAS_CREATEINSTANCE, LogLlamadasBHConstants.CLASS_ALIAS, LogLlamadasBHConstants.ARG_ALIAS_CREATEINSTANCE_LOGLLAMADASBHCREATEINSTANCEPATRTIPOSERVICIO);
        }
    }

    @JsonIgnore
    public Double getLogLlamadasBHcreateinstancepatrTiempoEjecucion() {
        return this.logLlamadasBHcreateinstancepatrTiempoEjecucion;
    }
    
    public void setLogLlamadasBHcreateinstancepatrTiempoEjecucion(Double logLlamadasBHcreateinstancepatrTiempoEjecucion) {
        this.logLlamadasBHcreateinstancepatrTiempoEjecucion = logLlamadasBHcreateinstancepatrTiempoEjecucion;
    }

    @JsonIgnore
    public String getLogLlamadasBHcreateinstancepatrTextoError() {
        return this.logLlamadasBHcreateinstancepatrTextoError;
    }
    
    public void setLogLlamadasBHcreateinstancepatrTextoError(String logLlamadasBHcreateinstancepatrTextoError) {
        this.logLlamadasBHcreateinstancepatrTextoError = logLlamadasBHcreateinstancepatrTextoError;
    }
}
