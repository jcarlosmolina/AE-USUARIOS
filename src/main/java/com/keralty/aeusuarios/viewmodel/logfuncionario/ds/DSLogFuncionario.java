package com.keralty.aeusuarios.viewmodel.logfuncionario.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.LogFuncionario;
public class DSLogFuncionario {

    @JsonProperty("fecha")
    private Timestamp dSLogFuncionarioFecha;

    @JsonProperty("loginfuncionario")
    private String dSLogFuncionarioLoginFuncionario;

    @JsonProperty("disponible")
    private Boolean dSLogFuncionarioDisponible;

    public DSLogFuncionario() {
    
    }

    public DSLogFuncionario(LogFuncionario instance) {
        if (instance != null) {
            this.dSLogFuncionarioFecha = instance.getLogFuncionarioFecha();
            this.dSLogFuncionarioLoginFuncionario = instance.getLogFuncionarioLoginFuncionario();
            this.dSLogFuncionarioDisponible = instance.getLogFuncionarioDisponible();
        }
    }

    @JsonIgnore
    public Timestamp getDSLogFuncionarioFecha() {
        return this.dSLogFuncionarioFecha;
    }
    
    public void setDSLogFuncionarioFecha(Timestamp dSLogFuncionarioFecha) {
        this.dSLogFuncionarioFecha = dSLogFuncionarioFecha;
    }

    @JsonIgnore
    public String getDSLogFuncionarioLoginFuncionario() {
        return this.dSLogFuncionarioLoginFuncionario;
    }
    
    public void setDSLogFuncionarioLoginFuncionario(String dSLogFuncionarioLoginFuncionario) {
        this.dSLogFuncionarioLoginFuncionario = dSLogFuncionarioLoginFuncionario;
    }

    @JsonIgnore
    public Boolean getDSLogFuncionarioDisponible() {
        return this.dSLogFuncionarioDisponible;
    }
    
    public void setDSLogFuncionarioDisponible(Boolean dSLogFuncionarioDisponible) {
        this.dSLogFuncionarioDisponible = dSLogFuncionarioDisponible;
    }
}
