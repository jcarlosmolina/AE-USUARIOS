package com.keralty.aeusuarios.viewmodel.productos.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.ProductosConstants;

public class CrearRequest {

    @JsonProperty("p_atrproducto")
    private Long productoscrearpatrProducto;

    @JsonProperty("p_atrdescripcion")
    private String productoscrearpatrDescripcion;

    @JsonProperty("p_atrcodanexomat")
    private Long productoscrearpatrCodAnexoMat;

    @JsonProperty("p_atrcodanexoneo")
    private Long productoscrearpatrCodAnexoNeo;

    @JsonProperty("p_atrnit")
    private String productoscrearpatrNIT;

    @JsonProperty("p_atrcodigolegal")
    private String productoscrearpatrCodigoLegal;

    public void checkArguments() throws NotNullArgumentException {
        checkProductoscrearpatrProducto();
        checkProductoscrearpatrDescripcion();
        checkProductoscrearpatrCodigoLegal();
    }

    @JsonIgnore
    public Long getProductoscrearpatrProducto() {
        return this.productoscrearpatrProducto;
    }
    
    public void setProductoscrearpatrProducto(Long productoscrearpatrProducto) {
        this.productoscrearpatrProducto = productoscrearpatrProducto;
    }

    private void checkProductoscrearpatrProducto() throws NotNullArgumentException {
        if(this.getProductoscrearpatrProducto() == null) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_CREAR, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_CREAR_PRODUCTOSCREARPATRPRODUCTO, ProductosConstants.SERV_ALIAS_CREAR, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_CREAR_PRODUCTOSCREARPATRPRODUCTO);
        }
    }

    @JsonIgnore
    public String getProductoscrearpatrDescripcion() {
        return this.productoscrearpatrDescripcion;
    }
    
    public void setProductoscrearpatrDescripcion(String productoscrearpatrDescripcion) {
        this.productoscrearpatrDescripcion = productoscrearpatrDescripcion;
    }

    private void checkProductoscrearpatrDescripcion() throws NotNullArgumentException {
        if(this.getProductoscrearpatrDescripcion() == null) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_CREAR, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_CREAR_PRODUCTOSCREARPATRDESCRIPCION, ProductosConstants.SERV_ALIAS_CREAR, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_CREAR_PRODUCTOSCREARPATRDESCRIPCION);
        }
    }

    @JsonIgnore
    public Long getProductoscrearpatrCodAnexoMat() {
        return this.productoscrearpatrCodAnexoMat;
    }
    
    public void setProductoscrearpatrCodAnexoMat(Long productoscrearpatrCodAnexoMat) {
        this.productoscrearpatrCodAnexoMat = productoscrearpatrCodAnexoMat;
    }

    @JsonIgnore
    public Long getProductoscrearpatrCodAnexoNeo() {
        return this.productoscrearpatrCodAnexoNeo;
    }
    
    public void setProductoscrearpatrCodAnexoNeo(Long productoscrearpatrCodAnexoNeo) {
        this.productoscrearpatrCodAnexoNeo = productoscrearpatrCodAnexoNeo;
    }

    @JsonIgnore
    public String getProductoscrearpatrNIT() {
        return this.productoscrearpatrNIT;
    }
    
    public void setProductoscrearpatrNIT(String productoscrearpatrNIT) {
        this.productoscrearpatrNIT = productoscrearpatrNIT;
    }

    @JsonIgnore
    public String getProductoscrearpatrCodigoLegal() {
        return this.productoscrearpatrCodigoLegal;
    }
    
    public void setProductoscrearpatrCodigoLegal(String productoscrearpatrCodigoLegal) {
        this.productoscrearpatrCodigoLegal = productoscrearpatrCodigoLegal;
    }

    private void checkProductoscrearpatrCodigoLegal() throws NotNullArgumentException {
        if(this.getProductoscrearpatrCodigoLegal() == null) {
            throw new NotNullArgumentException(ProductosConstants.SERV_ID_CREAR, ProductosConstants.CLASS_ID, ProductosConstants.ARG_ID_CREAR_PRODUCTOSCREARPATRCODIGOLEGAL, ProductosConstants.SERV_ALIAS_CREAR, ProductosConstants.CLASS_ALIAS, ProductosConstants.ARG_ALIAS_CREAR_PRODUCTOSCREARPATRCODIGOLEGAL);
        }
    }
}
