package com.keralty.aeusuarios.viewmodel.productos.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Productos;
public class ICProducto {

    @JsonProperty("descripcion")
    private String iCProductoDescripcion;

    public ICProducto() {
    
    }

    public ICProducto(Productos instance) {
        if (instance != null) {
            this.iCProductoDescripcion = instance.getProductosDescripcion();
        }
    }

    @JsonIgnore
    public String getICProductoDescripcion() {
        return this.iCProductoDescripcion;
    }
    
    public void setICProductoDescripcion(String iCProductoDescripcion) {
        this.iCProductoDescripcion = iCProductoDescripcion;
    }
}
