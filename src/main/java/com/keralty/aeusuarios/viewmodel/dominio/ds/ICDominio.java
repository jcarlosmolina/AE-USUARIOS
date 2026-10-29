package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class ICDominio {

    @JsonProperty("productot_descripcion")
    private String iCDominioProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String iCDominioPlanTDotNombre;

    public ICDominio() {
    
    }

    public ICDominio(Dominio instance) {
        if (instance != null) {
            try {
                this.iCDominioProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.iCDominioPlanTDotNombre = instance.getPlanT().getPlanesNombre();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICDominioProductoTDotDescripcion() {
        return this.iCDominioProductoTDotDescripcion;
    }
    
    public void setICDominioProductoTDotDescripcion(String iCDominioProductoTDotDescripcion) {
        this.iCDominioProductoTDotDescripcion = iCDominioProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getICDominioPlanTDotNombre() {
        return this.iCDominioPlanTDotNombre;
    }
    
    public void setICDominioPlanTDotNombre(String iCDominioPlanTDotNombre) {
        this.iCDominioPlanTDotNombre = iCDominioPlanTDotNombre;
    }
}
