package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominiosPorAsesor {

    @JsonProperty("plant_codigolegal")
    private String dSDominiosPorAsesorPlanTDotCodigoLegal;

    @JsonProperty("plant_nombre")
    private String dSDominiosPorAsesorPlanTDotNombre;

    public DSDominiosPorAsesor() {
    
    }

    public DSDominiosPorAsesor(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominiosPorAsesorPlanTDotCodigoLegal = instance.getPlanT().getPlanesCodigoLegal();
                this.dSDominiosPorAsesorPlanTDotNombre = instance.getPlanT().getPlanesNombre();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSDominiosPorAsesorPlanTDotCodigoLegal() {
        return this.dSDominiosPorAsesorPlanTDotCodigoLegal;
    }
    
    public void setDSDominiosPorAsesorPlanTDotCodigoLegal(String dSDominiosPorAsesorPlanTDotCodigoLegal) {
        this.dSDominiosPorAsesorPlanTDotCodigoLegal = dSDominiosPorAsesorPlanTDotCodigoLegal;
    }

    @JsonIgnore
    public String getDSDominiosPorAsesorPlanTDotNombre() {
        return this.dSDominiosPorAsesorPlanTDotNombre;
    }
    
    public void setDSDominiosPorAsesorPlanTDotNombre(String dSDominiosPorAsesorPlanTDotNombre) {
        this.dSDominiosPorAsesorPlanTDotNombre = dSDominiosPorAsesorPlanTDotNombre;
    }
}
