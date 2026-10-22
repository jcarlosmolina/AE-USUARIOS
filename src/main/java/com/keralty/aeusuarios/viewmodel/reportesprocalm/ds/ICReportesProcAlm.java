package com.keralty.aeusuarios.viewmodel.reportesprocalm.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;
public class ICReportesProcAlm {

    @JsonProperty("descripcion")
    private String iCReportesProcAlmDescripcion;

    public ICReportesProcAlm() {
    
    }

    public ICReportesProcAlm(ReportesProcAlm instance) {
        if (instance != null) {
            this.iCReportesProcAlmDescripcion = instance.getReportesProcAlmDescripcion();
        }
    }

    @JsonIgnore
    public String getICReportesProcAlmDescripcion() {
        return this.iCReportesProcAlmDescripcion;
    }
    
    public void setICReportesProcAlmDescripcion(String iCReportesProcAlmDescripcion) {
        this.iCReportesProcAlmDescripcion = iCReportesProcAlmDescripcion;
    }
}
