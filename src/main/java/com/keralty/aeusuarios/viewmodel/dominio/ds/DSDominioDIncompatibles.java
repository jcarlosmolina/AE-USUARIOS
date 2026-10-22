package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioDIncompatibles {

    @JsonProperty("productot_descripcion")
    private String dSDominioDIncompatiblesProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSDominioDIncompatiblesPlanTDotNombre;

    public DSDominioDIncompatibles() {
    
    }

    public DSDominioDIncompatibles(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominioDIncompatiblesProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSDominioDIncompatiblesPlanTDotNombre = instance.getPlanT().getPlanesNombre();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSDominioDIncompatiblesProductoTDotDescripcion() {
        return this.dSDominioDIncompatiblesProductoTDotDescripcion;
    }
    
    public void setDSDominioDIncompatiblesProductoTDotDescripcion(String dSDominioDIncompatiblesProductoTDotDescripcion) {
        this.dSDominioDIncompatiblesProductoTDotDescripcion = dSDominioDIncompatiblesProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSDominioDIncompatiblesPlanTDotNombre() {
        return this.dSDominioDIncompatiblesPlanTDotNombre;
    }
    
    public void setDSDominioDIncompatiblesPlanTDotNombre(String dSDominioDIncompatiblesPlanTDotNombre) {
        this.dSDominioDIncompatiblesPlanTDotNombre = dSDominioDIncompatiblesPlanTDotNombre;
    }
}
