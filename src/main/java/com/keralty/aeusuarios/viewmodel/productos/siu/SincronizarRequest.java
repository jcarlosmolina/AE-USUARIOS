package com.keralty.aeusuarios.viewmodel.productos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Productos;

public class SincronizarRequest {

    @JsonProperty("p_thisproducto_oid")
    private ProductosOid productossincronizarpthisProducto;
    
    @JsonIgnore
    private Productos productossincronizarpthisProductoInstance;

    @JsonProperty("p_descripcion")
    private String productossincronizarpDescripcion;

    @JsonProperty("p_codigolegal")
    private String productossincronizarpCodigoLegal;

    public void checkArguments() throws NotNullArgumentException {
        checkProductossincronizarpthisProducto();
        checkProductossincronizarpDescripcion();
        checkProductossincronizarpCodigoLegal();
    }

    @JsonIgnore
    public ProductosOid getProductossincronizarpthisProducto() {
        return this.productossincronizarpthisProducto;
    }
    
    public void setProductossincronizarpthisProducto(ProductosOid productossincronizarpthisProducto) {
        this.productossincronizarpthisProducto = productossincronizarpthisProducto;
    }

    @JsonIgnore
    public Productos getProductossincronizarpthisProductoInstance() {
        return this.productossincronizarpthisProductoInstance;
    }
    
    public void setProductossincronizarpthisProductoInstance(Productos productossincronizarpthisProducto) {
        this.productossincronizarpthisProductoInstance = productossincronizarpthisProducto;
        this.productossincronizarpthisProducto = productossincronizarpthisProducto != null ? productossincronizarpthisProducto.getOid() : null;
    }

    private void checkProductossincronizarpthisProducto() throws NotNullArgumentException {
        if(this.getProductossincronizarpthisProductoInstance() == null || this.getProductossincronizarpthisProductoInstance().isNull()) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_SINCRONIZAR, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_SINCRONIZAR_PRODUCTOSSINCRONIZARPTHISPRODUCTO, ProductosConstants.SERV_ALIAS_SINCRONIZAR, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_SINCRONIZAR_PRODUCTOSSINCRONIZARPTHISPRODUCTO);
        }
    }

    @JsonIgnore
    public String getProductossincronizarpDescripcion() {
        return this.productossincronizarpDescripcion;
    }
    
    public void setProductossincronizarpDescripcion(String productossincronizarpDescripcion) {
        this.productossincronizarpDescripcion = productossincronizarpDescripcion;
    }

    private void checkProductossincronizarpDescripcion() throws NotNullArgumentException {
        if(this.getProductossincronizarpDescripcion() == null) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_SINCRONIZAR, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_SINCRONIZAR_PRODUCTOSSINCRONIZARPDESCRIPCION, ProductosConstants.SERV_ALIAS_SINCRONIZAR, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_SINCRONIZAR_PRODUCTOSSINCRONIZARPDESCRIPCION);
        }
    }

    @JsonIgnore
    public String getProductossincronizarpCodigoLegal() {
        return this.productossincronizarpCodigoLegal;
    }
    
    public void setProductossincronizarpCodigoLegal(String productossincronizarpCodigoLegal) {
        this.productossincronizarpCodigoLegal = productossincronizarpCodigoLegal;
    }

    private void checkProductossincronizarpCodigoLegal() throws NotNullArgumentException {
        if(this.getProductossincronizarpCodigoLegal() == null) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_SINCRONIZAR, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_SINCRONIZAR_PRODUCTOSSINCRONIZARPCODIGOLEGAL, ProductosConstants.SERV_ALIAS_SINCRONIZAR, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_SINCRONIZAR_PRODUCTOSSINCRONIZARPCODIGOLEGAL);
        }
    }
}
