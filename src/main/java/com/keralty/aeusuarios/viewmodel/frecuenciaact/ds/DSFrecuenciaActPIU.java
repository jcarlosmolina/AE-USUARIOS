package com.keralty.aeusuarios.viewmodel.frecuenciaact.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.FrecuenciaAct;
public class DSFrecuenciaActPIU {

    @JsonProperty("parametrica")
    private Long dSFrecuenciaActPIUParametrica;

    @JsonProperty("frecuencia")
    private Long dSFrecuenciaActPIUFrecuencia;

    @JsonProperty("fechaultimasinc")
    private Date dSFrecuenciaActPIUFechaUltimaSinc;

    @JsonProperty("usuario")
    private String dSFrecuenciaActPIUUsuario;

    @JsonProperty("nombreusuario")
    private String dSFrecuenciaActPIUNombreUsuario;

    @JsonProperty("resultadosinc")
    private String dSFrecuenciaActPIUResultadoSinc;

    public DSFrecuenciaActPIU() {
    
    }

    public DSFrecuenciaActPIU(FrecuenciaAct instance) {
        if (instance != null) {
            this.dSFrecuenciaActPIUParametrica = instance.getFrecuenciaActParametrica();
            this.dSFrecuenciaActPIUFrecuencia = instance.getFrecuenciaActFrecuencia();
            this.dSFrecuenciaActPIUFechaUltimaSinc = instance.getFrecuenciaActFechaUltimaSinc();
            this.dSFrecuenciaActPIUUsuario = instance.getFrecuenciaActUsuario();
            this.dSFrecuenciaActPIUNombreUsuario = instance.getFrecuenciaActNombreUsuario();
            this.dSFrecuenciaActPIUResultadoSinc = instance.getFrecuenciaActResultadoSinc();
        }
    }

    @JsonIgnore
    public Long getDSFrecuenciaActPIUParametrica() {
        return this.dSFrecuenciaActPIUParametrica;
    }
    
    public void setDSFrecuenciaActPIUParametrica(Long dSFrecuenciaActPIUParametrica) {
        this.dSFrecuenciaActPIUParametrica = dSFrecuenciaActPIUParametrica;
    }

    @JsonIgnore
    public Long getDSFrecuenciaActPIUFrecuencia() {
        return this.dSFrecuenciaActPIUFrecuencia;
    }
    
    public void setDSFrecuenciaActPIUFrecuencia(Long dSFrecuenciaActPIUFrecuencia) {
        this.dSFrecuenciaActPIUFrecuencia = dSFrecuenciaActPIUFrecuencia;
    }

    @JsonIgnore
    public Date getDSFrecuenciaActPIUFechaUltimaSinc() {
        return this.dSFrecuenciaActPIUFechaUltimaSinc;
    }
    
    public void setDSFrecuenciaActPIUFechaUltimaSinc(Date dSFrecuenciaActPIUFechaUltimaSinc) {
        this.dSFrecuenciaActPIUFechaUltimaSinc = dSFrecuenciaActPIUFechaUltimaSinc;
    }

    @JsonIgnore
    public String getDSFrecuenciaActPIUUsuario() {
        return this.dSFrecuenciaActPIUUsuario;
    }
    
    public void setDSFrecuenciaActPIUUsuario(String dSFrecuenciaActPIUUsuario) {
        this.dSFrecuenciaActPIUUsuario = dSFrecuenciaActPIUUsuario;
    }

    @JsonIgnore
    public String getDSFrecuenciaActPIUNombreUsuario() {
        return this.dSFrecuenciaActPIUNombreUsuario;
    }
    
    public void setDSFrecuenciaActPIUNombreUsuario(String dSFrecuenciaActPIUNombreUsuario) {
        this.dSFrecuenciaActPIUNombreUsuario = dSFrecuenciaActPIUNombreUsuario;
    }

    @JsonIgnore
    public String getDSFrecuenciaActPIUResultadoSinc() {
        return this.dSFrecuenciaActPIUResultadoSinc;
    }
    
    public void setDSFrecuenciaActPIUResultadoSinc(String dSFrecuenciaActPIUResultadoSinc) {
        this.dSFrecuenciaActPIUResultadoSinc = dSFrecuenciaActPIUResultadoSinc;
    }
}
