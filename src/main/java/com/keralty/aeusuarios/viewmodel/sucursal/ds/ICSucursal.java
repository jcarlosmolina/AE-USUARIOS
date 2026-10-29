package com.keralty.aeusuarios.viewmodel.sucursal.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Sucursal;
public class ICSucursal {

    @JsonProperty("descripcion")
    private String iCSucursalDescripcion;

    public ICSucursal() {
    
    }

    public ICSucursal(Sucursal instance) {
        if (instance != null) {
            this.iCSucursalDescripcion = instance.getSucursalDescripcion();
        }
    }

    @JsonIgnore
    public String getICSucursalDescripcion() {
        return this.iCSucursalDescripcion;
    }
    
    public void setICSucursalDescripcion(String iCSucursalDescripcion) {
        this.iCSucursalDescripcion = iCSucursalDescripcion;
    }
}
