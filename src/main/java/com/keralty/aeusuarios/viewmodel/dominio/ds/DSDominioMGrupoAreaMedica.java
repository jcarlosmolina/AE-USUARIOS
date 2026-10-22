package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioMGrupoAreaMedica {

    @JsonProperty("grupoareamedica_nombre")
    private String dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre;

    @JsonProperty("grupoareamedica_descripcion")
    private String dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion;

    public DSDominioMGrupoAreaMedica() {
    
    }

    public DSDominioMGrupoAreaMedica(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre = instance.getGrupoAreaMedica().getGrupoAsignacionNombre();
                this.dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion = instance.getGrupoAreaMedica().getGrupoAsignacionDescripcion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre() {
        return this.dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre;
    }
    
    public void setDSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre(String dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre) {
        this.dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre = dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotNombre;
    }

    @JsonIgnore
    public String getDSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion() {
        return this.dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion;
    }
    
    public void setDSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion(String dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion) {
        this.dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion = dSDominioMGrupoAreaMedicaGrupoAreaMedicaDotDescripcion;
    }
}
