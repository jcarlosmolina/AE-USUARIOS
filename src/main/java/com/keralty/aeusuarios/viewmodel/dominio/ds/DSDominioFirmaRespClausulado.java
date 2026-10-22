package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioFirmaRespClausulado {

    @JsonProperty("respclaunombre")
    private String dSDominioFirmaRespClausuladoRespClauNombre;

    @JsonProperty("respclaucelula")
    private String dSDominioFirmaRespClausuladoRespClauCelula;

    @JsonProperty("respclauexpcelula")
    private String dSDominioFirmaRespClausuladoRespClauExpCelula;

    @JsonProperty("respclaucargo")
    private String dSDominioFirmaRespClausuladoRespClauCargo;

    @JsonProperty("respclaufirma")
    private byte[] dSDominioFirmaRespClausuladoRespClauFirma;

    public DSDominioFirmaRespClausulado() {
    
    }

    public DSDominioFirmaRespClausulado(Dominio instance) {
        if (instance != null) {
            this.dSDominioFirmaRespClausuladoRespClauNombre = instance.getDominioRespClauNombre();
            this.dSDominioFirmaRespClausuladoRespClauCelula = instance.getDominioRespClauCelula();
            this.dSDominioFirmaRespClausuladoRespClauExpCelula = instance.getDominioRespClauExpCelula();
            this.dSDominioFirmaRespClausuladoRespClauCargo = instance.getDominioRespClauCargo();
            this.dSDominioFirmaRespClausuladoRespClauFirma = instance.getDominioRespClauFirma();
        }
    }

    @JsonIgnore
    public String getDSDominioFirmaRespClausuladoRespClauNombre() {
        return this.dSDominioFirmaRespClausuladoRespClauNombre;
    }
    
    public void setDSDominioFirmaRespClausuladoRespClauNombre(String dSDominioFirmaRespClausuladoRespClauNombre) {
        this.dSDominioFirmaRespClausuladoRespClauNombre = dSDominioFirmaRespClausuladoRespClauNombre;
    }

    @JsonIgnore
    public String getDSDominioFirmaRespClausuladoRespClauCelula() {
        return this.dSDominioFirmaRespClausuladoRespClauCelula;
    }
    
    public void setDSDominioFirmaRespClausuladoRespClauCelula(String dSDominioFirmaRespClausuladoRespClauCelula) {
        this.dSDominioFirmaRespClausuladoRespClauCelula = dSDominioFirmaRespClausuladoRespClauCelula;
    }

    @JsonIgnore
    public String getDSDominioFirmaRespClausuladoRespClauExpCelula() {
        return this.dSDominioFirmaRespClausuladoRespClauExpCelula;
    }
    
    public void setDSDominioFirmaRespClausuladoRespClauExpCelula(String dSDominioFirmaRespClausuladoRespClauExpCelula) {
        this.dSDominioFirmaRespClausuladoRespClauExpCelula = dSDominioFirmaRespClausuladoRespClauExpCelula;
    }

    @JsonIgnore
    public String getDSDominioFirmaRespClausuladoRespClauCargo() {
        return this.dSDominioFirmaRespClausuladoRespClauCargo;
    }
    
    public void setDSDominioFirmaRespClausuladoRespClauCargo(String dSDominioFirmaRespClausuladoRespClauCargo) {
        this.dSDominioFirmaRespClausuladoRespClauCargo = dSDominioFirmaRespClausuladoRespClauCargo;
    }

    @JsonIgnore
    public byte[] getDSDominioFirmaRespClausuladoRespClauFirma() {
        return this.dSDominioFirmaRespClausuladoRespClauFirma;
    }
    
    public void setDSDominioFirmaRespClausuladoRespClauFirma(byte[] dSDominioFirmaRespClausuladoRespClauFirma) {
        this.dSDominioFirmaRespClausuladoRespClauFirma = dSDominioFirmaRespClausuladoRespClauFirma;
    }
}
