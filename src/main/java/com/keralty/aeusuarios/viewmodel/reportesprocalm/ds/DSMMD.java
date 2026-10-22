package com.keralty.aeusuarios.viewmodel.reportesprocalm.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;
public class DSMMD {

    @JsonProperty("nombreproc")
    private String dSMMDNombreProc;

    @JsonProperty("nombrefichero")
    private String dSMMDNombreFichero;

    @JsonProperty("descripcion")
    private String dSMMDDescripcion;

    public DSMMD() {
    
    }

    public DSMMD(ReportesProcAlm instance) {
        if (instance != null) {
            this.dSMMDNombreProc = instance.getReportesProcAlmNombreProc();
            this.dSMMDNombreFichero = instance.getReportesProcAlmNombreFichero();
            this.dSMMDDescripcion = instance.getReportesProcAlmDescripcion();
        }
    }

    @JsonIgnore
    public String getDSMMDNombreProc() {
        return this.dSMMDNombreProc;
    }
    
    public void setDSMMDNombreProc(String dSMMDNombreProc) {
        this.dSMMDNombreProc = dSMMDNombreProc;
    }

    @JsonIgnore
    public String getDSMMDNombreFichero() {
        return this.dSMMDNombreFichero;
    }
    
    public void setDSMMDNombreFichero(String dSMMDNombreFichero) {
        this.dSMMDNombreFichero = dSMMDNombreFichero;
    }

    @JsonIgnore
    public String getDSMMDDescripcion() {
        return this.dSMMDDescripcion;
    }
    
    public void setDSMMDDescripcion(String dSMMDDescripcion) {
        this.dSMMDDescripcion = dSMMDDescripcion;
    }
}
