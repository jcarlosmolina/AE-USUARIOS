package com.keralty.aeusuarios.viewmodel.agentexproducto.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.AgentexProducto;
public class ICAgentexProducto {

    @JsonProperty("asesor_drvnombrecompleto")
    private String iCAgentexProductoAsesorDotDrvNombreCompleto;

    @JsonProperty("productot_descripcion")
    private String iCAgentexProductoProductoTDotDescripcion;

    public ICAgentexProducto() {
    
    }

    public ICAgentexProducto(AgentexProducto instance) {
        if (instance != null) {
            try {
                this.iCAgentexProductoAsesorDotDrvNombreCompleto = instance.getAsesor().getFuncionariodrvNombreCompleto();
                this.iCAgentexProductoProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getICAgentexProductoAsesorDotDrvNombreCompleto() {
        return this.iCAgentexProductoAsesorDotDrvNombreCompleto;
    }
    
    public void setICAgentexProductoAsesorDotDrvNombreCompleto(String iCAgentexProductoAsesorDotDrvNombreCompleto) {
        this.iCAgentexProductoAsesorDotDrvNombreCompleto = iCAgentexProductoAsesorDotDrvNombreCompleto;
    }

    @JsonIgnore
    public String getICAgentexProductoProductoTDotDescripcion() {
        return this.iCAgentexProductoProductoTDotDescripcion;
    }
    
    public void setICAgentexProductoProductoTDotDescripcion(String iCAgentexProductoProductoTDotDescripcion) {
        this.iCAgentexProductoProductoTDotDescripcion = iCAgentexProductoProductoTDotDescripcion;
    }
}
