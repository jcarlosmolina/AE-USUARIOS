package com.keralty.aeusuarios.viewmodel.agentexproducto.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.AgentexProducto;
public class DSAgentexProductoPIU {

    @JsonProperty("productot_codigolegal")
    private String dSAgentexProductoPIUProductoTDotCodigoLegal;

    @JsonProperty("productot_descripcion")
    private String dSAgentexProductoPIUProductoTDotDescripcion;

    @JsonProperty("fechainicio")
    private Timestamp dSAgentexProductoPIUFechaInicio;

    @JsonProperty("fechafin")
    private Timestamp dSAgentexProductoPIUFechaFin;

    @JsonProperty("todosdominios")
    private Boolean dSAgentexProductoPIUTodosDominios;

    public DSAgentexProductoPIU() {
    
    }

    public DSAgentexProductoPIU(AgentexProducto instance) {
        if (instance != null) {
            try {
                this.dSAgentexProductoPIUProductoTDotCodigoLegal = instance.getProductoT().getProductosCodigoLegal();
                this.dSAgentexProductoPIUProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSAgentexProductoPIUFechaInicio = instance.getAgentexProductoFechaInicio();
                this.dSAgentexProductoPIUFechaFin = instance.getAgentexProductoFechaFin();
                this.dSAgentexProductoPIUTodosDominios = instance.getAgentexProductoTodosDominios();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSAgentexProductoPIUProductoTDotCodigoLegal() {
        return this.dSAgentexProductoPIUProductoTDotCodigoLegal;
    }
    
    public void setDSAgentexProductoPIUProductoTDotCodigoLegal(String dSAgentexProductoPIUProductoTDotCodigoLegal) {
        this.dSAgentexProductoPIUProductoTDotCodigoLegal = dSAgentexProductoPIUProductoTDotCodigoLegal;
    }

    @JsonIgnore
    public String getDSAgentexProductoPIUProductoTDotDescripcion() {
        return this.dSAgentexProductoPIUProductoTDotDescripcion;
    }
    
    public void setDSAgentexProductoPIUProductoTDotDescripcion(String dSAgentexProductoPIUProductoTDotDescripcion) {
        this.dSAgentexProductoPIUProductoTDotDescripcion = dSAgentexProductoPIUProductoTDotDescripcion;
    }

    @JsonIgnore
    public Timestamp getDSAgentexProductoPIUFechaInicio() {
        return this.dSAgentexProductoPIUFechaInicio;
    }
    
    public void setDSAgentexProductoPIUFechaInicio(Timestamp dSAgentexProductoPIUFechaInicio) {
        this.dSAgentexProductoPIUFechaInicio = dSAgentexProductoPIUFechaInicio;
    }

    @JsonIgnore
    public Timestamp getDSAgentexProductoPIUFechaFin() {
        return this.dSAgentexProductoPIUFechaFin;
    }
    
    public void setDSAgentexProductoPIUFechaFin(Timestamp dSAgentexProductoPIUFechaFin) {
        this.dSAgentexProductoPIUFechaFin = dSAgentexProductoPIUFechaFin;
    }

    @JsonIgnore
    public Boolean getDSAgentexProductoPIUTodosDominios() {
        return this.dSAgentexProductoPIUTodosDominios;
    }
    
    public void setDSAgentexProductoPIUTodosDominios(Boolean dSAgentexProductoPIUTodosDominios) {
        this.dSAgentexProductoPIUTodosDominios = dSAgentexProductoPIUTodosDominios;
    }
}
