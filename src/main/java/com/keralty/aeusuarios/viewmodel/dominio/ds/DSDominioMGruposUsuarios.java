package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioMGruposUsuarios {

    @JsonProperty("productot_descripcion")
    private String dSDominioMGruposUsuariosProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSDominioMGruposUsuariosPlanTDotNombre;

    public DSDominioMGruposUsuarios() {
    
    }

    public DSDominioMGruposUsuarios(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominioMGruposUsuariosProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSDominioMGruposUsuariosPlanTDotNombre = instance.getPlanT().getPlanesNombre();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSDominioMGruposUsuariosProductoTDotDescripcion() {
        return this.dSDominioMGruposUsuariosProductoTDotDescripcion;
    }
    
    public void setDSDominioMGruposUsuariosProductoTDotDescripcion(String dSDominioMGruposUsuariosProductoTDotDescripcion) {
        this.dSDominioMGruposUsuariosProductoTDotDescripcion = dSDominioMGruposUsuariosProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSDominioMGruposUsuariosPlanTDotNombre() {
        return this.dSDominioMGruposUsuariosPlanTDotNombre;
    }
    
    public void setDSDominioMGruposUsuariosPlanTDotNombre(String dSDominioMGruposUsuariosPlanTDotNombre) {
        this.dSDominioMGruposUsuariosPlanTDotNombre = dSDominioMGruposUsuariosPlanTDotNombre;
    }
}
