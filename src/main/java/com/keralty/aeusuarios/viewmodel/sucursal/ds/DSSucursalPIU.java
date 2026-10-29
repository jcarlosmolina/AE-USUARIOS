package com.keralty.aeusuarios.viewmodel.sucursal.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Sucursal;
public class DSSucursalPIU {

    @JsonProperty("regional_descripcion")
    private String dSSucursalPIURegionalDotDescripcion;

    @JsonProperty("codigo")
    private Long dSSucursalPIUCodigo;

    @JsonProperty("descripcion")
    private String dSSucursalPIUDescripcion;

    public DSSucursalPIU() {
    
    }

    public DSSucursalPIU(Sucursal instance) {
        if (instance != null) {
            try {
                this.dSSucursalPIURegionalDotDescripcion = instance.getRegional().getRegionalDescripcion();
                this.dSSucursalPIUCodigo = instance.getSucursalCodigo();
                this.dSSucursalPIUDescripcion = instance.getSucursalDescripcion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSucursalPIURegionalDotDescripcion() {
        return this.dSSucursalPIURegionalDotDescripcion;
    }
    
    public void setDSSucursalPIURegionalDotDescripcion(String dSSucursalPIURegionalDotDescripcion) {
        this.dSSucursalPIURegionalDotDescripcion = dSSucursalPIURegionalDotDescripcion;
    }

    @JsonIgnore
    public Long getDSSucursalPIUCodigo() {
        return this.dSSucursalPIUCodigo;
    }
    
    public void setDSSucursalPIUCodigo(Long dSSucursalPIUCodigo) {
        this.dSSucursalPIUCodigo = dSSucursalPIUCodigo;
    }

    @JsonIgnore
    public String getDSSucursalPIUDescripcion() {
        return this.dSSucursalPIUDescripcion;
    }
    
    public void setDSSucursalPIUDescripcion(String dSSucursalPIUDescripcion) {
        this.dSSucursalPIUDescripcion = dSSucursalPIUDescripcion;
    }
}
