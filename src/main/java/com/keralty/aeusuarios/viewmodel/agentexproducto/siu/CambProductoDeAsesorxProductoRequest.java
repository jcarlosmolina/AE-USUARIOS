package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Productos;

public class CambProductoDeAsesorxProductoRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance;

    @JsonProperty("p_evcproductos_oid")
    private ProductosOid agentexProductoCambProductoDeAsesorxProductopevcProductos;
    
    @JsonIgnore
    private Productos agentexProductoCambProductoDeAsesorxProductopevcProductosInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoCambProductoDeAsesorxProductopthisAgentexProducto();
        checkAgentexProductoCambProductoDeAsesorxProductopevcProductos();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoCambProductoDeAsesorxProductopthisAgentexProducto() {
        return this.agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto;
    }
    
    public void setAgentexProductoCambProductoDeAsesorxProductopthisAgentexProducto(AgentexProductoOid agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto) {
        this.agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto = agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance() {
        return this.agentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance(AgentexProducto agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto) {
        this.agentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance = agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto;
        this.agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto = agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto != null ? agentexProductoCambProductoDeAsesorxProductopthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoCambProductoDeAsesorxProductopthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance() == null || this.getAgentexProductoCambProductoDeAsesorxProductopthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_CAMBPRODUCTODEASESORXPRODUCTO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_CAMBPRODUCTODEASESORXPRODUCTO_AGENTEXPRODUCTOCAMBPRODUCTODEASESORXPRODUCTOPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO_AGENTEXPRODUCTOCAMBPRODUCTODEASESORXPRODUCTOPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public ProductosOid getAgentexProductoCambProductoDeAsesorxProductopevcProductos() {
        return this.agentexProductoCambProductoDeAsesorxProductopevcProductos;
    }
    
    public void setAgentexProductoCambProductoDeAsesorxProductopevcProductos(ProductosOid agentexProductoCambProductoDeAsesorxProductopevcProductos) {
        this.agentexProductoCambProductoDeAsesorxProductopevcProductos = agentexProductoCambProductoDeAsesorxProductopevcProductos;
    }

    @JsonIgnore
    public Productos getAgentexProductoCambProductoDeAsesorxProductopevcProductosInstance() {
        return this.agentexProductoCambProductoDeAsesorxProductopevcProductosInstance;
    }
    
    public void setAgentexProductoCambProductoDeAsesorxProductopevcProductosInstance(Productos agentexProductoCambProductoDeAsesorxProductopevcProductos) {
        this.agentexProductoCambProductoDeAsesorxProductopevcProductosInstance = agentexProductoCambProductoDeAsesorxProductopevcProductos;
        this.agentexProductoCambProductoDeAsesorxProductopevcProductos = agentexProductoCambProductoDeAsesorxProductopevcProductos != null ? agentexProductoCambProductoDeAsesorxProductopevcProductos.getOid() : null;
    }

    private void checkAgentexProductoCambProductoDeAsesorxProductopevcProductos() throws NotNullArgumentException {
        if(this.getAgentexProductoCambProductoDeAsesorxProductopevcProductosInstance() == null || this.getAgentexProductoCambProductoDeAsesorxProductopevcProductosInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_CAMBPRODUCTODEASESORXPRODUCTO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_CAMBPRODUCTODEASESORXPRODUCTO_AGENTEXPRODUCTOCAMBPRODUCTODEASESORXPRODUCTOPEVCPRODUCTOS, AgentexProductoConstants.SERV_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO_AGENTEXPRODUCTOCAMBPRODUCTODEASESORXPRODUCTOPEVCPRODUCTOS);
        }
    }
}
