package com.keralty.aeusuarios.viewmodel.productos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Productos;

public class CambProductoDeAsesorxProductoRequest {

    @JsonProperty("p_thisproducto_oid")
    private ProductosOid productosCambProductoDeAsesorxProductopthisProducto;
    
    @JsonIgnore
    private Productos productosCambProductoDeAsesorxProductopthisProductoInstance;

    @JsonProperty("p_evcagentexproducto_oid")
    private AgentexProductoOid productosCambProductoDeAsesorxProductopevcAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto productosCambProductoDeAsesorxProductopevcAgentexProductoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkProductosCambProductoDeAsesorxProductopthisProducto();
        checkProductosCambProductoDeAsesorxProductopevcAgentexProducto();
    }

    @JsonIgnore
    public ProductosOid getProductosCambProductoDeAsesorxProductopthisProducto() {
        return this.productosCambProductoDeAsesorxProductopthisProducto;
    }
    
    public void setProductosCambProductoDeAsesorxProductopthisProducto(ProductosOid productosCambProductoDeAsesorxProductopthisProducto) {
        this.productosCambProductoDeAsesorxProductopthisProducto = productosCambProductoDeAsesorxProductopthisProducto;
    }

    @JsonIgnore
    public Productos getProductosCambProductoDeAsesorxProductopthisProductoInstance() {
        return this.productosCambProductoDeAsesorxProductopthisProductoInstance;
    }
    
    public void setProductosCambProductoDeAsesorxProductopthisProductoInstance(Productos productosCambProductoDeAsesorxProductopthisProducto) {
        this.productosCambProductoDeAsesorxProductopthisProductoInstance = productosCambProductoDeAsesorxProductopthisProducto;
        this.productosCambProductoDeAsesorxProductopthisProducto = productosCambProductoDeAsesorxProductopthisProducto != null ? productosCambProductoDeAsesorxProductopthisProducto.getOid() : null;
    }

    private void checkProductosCambProductoDeAsesorxProductopthisProducto() throws NotNullArgumentException {
        if(this.getProductosCambProductoDeAsesorxProductopthisProductoInstance() == null || this.getProductosCambProductoDeAsesorxProductopthisProductoInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_CAMBPRODUCTODEASESORXPRODUCTO, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_CAMBPRODUCTODEASESORXPRODUCTO_PRODUCTOSCAMBPRODUCTODEASESORXPRODUCTOPTHISPRODUCTO, ProductosConstants.SERV_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO_PRODUCTOSCAMBPRODUCTODEASESORXPRODUCTOPTHISPRODUCTO);
        }
    }

    @JsonIgnore
    public AgentexProductoOid getProductosCambProductoDeAsesorxProductopevcAgentexProducto() {
        return this.productosCambProductoDeAsesorxProductopevcAgentexProducto;
    }
    
    public void setProductosCambProductoDeAsesorxProductopevcAgentexProducto(AgentexProductoOid productosCambProductoDeAsesorxProductopevcAgentexProducto) {
        this.productosCambProductoDeAsesorxProductopevcAgentexProducto = productosCambProductoDeAsesorxProductopevcAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getProductosCambProductoDeAsesorxProductopevcAgentexProductoInstance() {
        return this.productosCambProductoDeAsesorxProductopevcAgentexProductoInstance;
    }
    
    public void setProductosCambProductoDeAsesorxProductopevcAgentexProductoInstance(AgentexProducto productosCambProductoDeAsesorxProductopevcAgentexProducto) {
        this.productosCambProductoDeAsesorxProductopevcAgentexProductoInstance = productosCambProductoDeAsesorxProductopevcAgentexProducto;
        this.productosCambProductoDeAsesorxProductopevcAgentexProducto = productosCambProductoDeAsesorxProductopevcAgentexProducto != null ? productosCambProductoDeAsesorxProductopevcAgentexProducto.getOid() : null;
    }

    private void checkProductosCambProductoDeAsesorxProductopevcAgentexProducto() throws NotNullArgumentException {
        if(this.getProductosCambProductoDeAsesorxProductopevcAgentexProductoInstance() == null || this.getProductosCambProductoDeAsesorxProductopevcAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_CAMBPRODUCTODEASESORXPRODUCTO, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_CAMBPRODUCTODEASESORXPRODUCTO_PRODUCTOSCAMBPRODUCTODEASESORXPRODUCTOPEVCAGENTEXPRODUCTO, ProductosConstants.SERV_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_CAMBPRODUCTODEASESORXPRODUCTO_PRODUCTOSCAMBPRODUCTODEASESORXPRODUCTOPEVCAGENTEXPRODUCTO);
        }
    }
}
