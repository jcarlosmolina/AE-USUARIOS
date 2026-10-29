package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioMGrupoAsesores {

    @JsonProperty("grupoasesores_id")
    private Long dSDominioMGrupoAsesoresGrupoAsesoresDotId;

    @JsonProperty("grupoasesores_nombre")
    private String dSDominioMGrupoAsesoresGrupoAsesoresDotNombre;

    @JsonProperty("grupoasesores_descripcion")
    private String dSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion;

    public DSDominioMGrupoAsesores() {
    
    }

    public DSDominioMGrupoAsesores(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominioMGrupoAsesoresGrupoAsesoresDotId = instance.getGrupoAsesores().getGrupoAsignacionId();
                this.dSDominioMGrupoAsesoresGrupoAsesoresDotNombre = instance.getGrupoAsesores().getGrupoAsignacionNombre();
                this.dSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion = instance.getGrupoAsesores().getGrupoAsignacionDescripcion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public Long getDSDominioMGrupoAsesoresGrupoAsesoresDotId() {
        return this.dSDominioMGrupoAsesoresGrupoAsesoresDotId;
    }
    
    public void setDSDominioMGrupoAsesoresGrupoAsesoresDotId(Long dSDominioMGrupoAsesoresGrupoAsesoresDotId) {
        this.dSDominioMGrupoAsesoresGrupoAsesoresDotId = dSDominioMGrupoAsesoresGrupoAsesoresDotId;
    }

    @JsonIgnore
    public String getDSDominioMGrupoAsesoresGrupoAsesoresDotNombre() {
        return this.dSDominioMGrupoAsesoresGrupoAsesoresDotNombre;
    }
    
    public void setDSDominioMGrupoAsesoresGrupoAsesoresDotNombre(String dSDominioMGrupoAsesoresGrupoAsesoresDotNombre) {
        this.dSDominioMGrupoAsesoresGrupoAsesoresDotNombre = dSDominioMGrupoAsesoresGrupoAsesoresDotNombre;
    }

    @JsonIgnore
    public String getDSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion() {
        return this.dSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion;
    }
    
    public void setDSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion(String dSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion) {
        this.dSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion = dSDominioMGrupoAsesoresGrupoAsesoresDotDescripcion;
    }
}
