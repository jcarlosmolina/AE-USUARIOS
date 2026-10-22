package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioMLog {

    @JsonProperty("productot_descripcion")
    private String dSDominioMLogProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSDominioMLogPlanTDotNombre;

    public DSDominioMLog() {
    
    }

    public DSDominioMLog(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominioMLogProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSDominioMLogPlanTDotNombre = instance.getPlanT().getPlanesNombre();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSDominioMLogProductoTDotDescripcion() {
        return this.dSDominioMLogProductoTDotDescripcion;
    }
    
    public void setDSDominioMLogProductoTDotDescripcion(String dSDominioMLogProductoTDotDescripcion) {
        this.dSDominioMLogProductoTDotDescripcion = dSDominioMLogProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSDominioMLogPlanTDotNombre() {
        return this.dSDominioMLogPlanTDotNombre;
    }
    
    public void setDSDominioMLogPlanTDotNombre(String dSDominioMLogPlanTDotNombre) {
        this.dSDominioMLogPlanTDotNombre = dSDominioMLogPlanTDotNombre;
    }
}
