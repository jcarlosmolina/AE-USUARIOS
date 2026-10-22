package com.keralty.aeusuarios.viewmodel.planes.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Planes;
public class DSPlanesDAfiliacion {

    @JsonProperty("productot_codigolegal")
    private String dSPlanesDAfiliacionProductoTDotCodigoLegal;

    @JsonProperty("productot_descripcion")
    private String dSPlanesDAfiliacionProductoTDotDescripcion;

    @JsonProperty("codigolegal")
    private String dSPlanesDAfiliacionCodigoLegal;

    @JsonProperty("nombre")
    private String dSPlanesDAfiliacionNombre;

    @JsonProperty("esbancorep")
    private Boolean dSPlanesDAfiliacionEsBancoRep;

    @JsonProperty("esvoluntario")
    private Boolean dSPlanesDAfiliacionEsVoluntario;

    @JsonProperty("iniciocontdiauno")
    private Boolean dSPlanesDAfiliacionInicioContDiaUno;

    public DSPlanesDAfiliacion() {
    
    }

    public DSPlanesDAfiliacion(Planes instance) {
        if (instance != null) {
            try {
                this.dSPlanesDAfiliacionProductoTDotCodigoLegal = instance.getProductoT().getProductosCodigoLegal();
                this.dSPlanesDAfiliacionProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSPlanesDAfiliacionCodigoLegal = instance.getPlanesCodigoLegal();
                this.dSPlanesDAfiliacionNombre = instance.getPlanesNombre();
                this.dSPlanesDAfiliacionEsBancoRep = instance.getPlanesEsBancoRep();
                this.dSPlanesDAfiliacionEsVoluntario = instance.getPlanesEsVoluntario();
                this.dSPlanesDAfiliacionInicioContDiaUno = instance.getPlanesInicioContDiaUno();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSPlanesDAfiliacionProductoTDotCodigoLegal() {
        return this.dSPlanesDAfiliacionProductoTDotCodigoLegal;
    }
    
    public void setDSPlanesDAfiliacionProductoTDotCodigoLegal(String dSPlanesDAfiliacionProductoTDotCodigoLegal) {
        this.dSPlanesDAfiliacionProductoTDotCodigoLegal = dSPlanesDAfiliacionProductoTDotCodigoLegal;
    }

    @JsonIgnore
    public String getDSPlanesDAfiliacionProductoTDotDescripcion() {
        return this.dSPlanesDAfiliacionProductoTDotDescripcion;
    }
    
    public void setDSPlanesDAfiliacionProductoTDotDescripcion(String dSPlanesDAfiliacionProductoTDotDescripcion) {
        this.dSPlanesDAfiliacionProductoTDotDescripcion = dSPlanesDAfiliacionProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSPlanesDAfiliacionCodigoLegal() {
        return this.dSPlanesDAfiliacionCodigoLegal;
    }
    
    public void setDSPlanesDAfiliacionCodigoLegal(String dSPlanesDAfiliacionCodigoLegal) {
        this.dSPlanesDAfiliacionCodigoLegal = dSPlanesDAfiliacionCodigoLegal;
    }

    @JsonIgnore
    public String getDSPlanesDAfiliacionNombre() {
        return this.dSPlanesDAfiliacionNombre;
    }
    
    public void setDSPlanesDAfiliacionNombre(String dSPlanesDAfiliacionNombre) {
        this.dSPlanesDAfiliacionNombre = dSPlanesDAfiliacionNombre;
    }

    @JsonIgnore
    public Boolean getDSPlanesDAfiliacionEsBancoRep() {
        return this.dSPlanesDAfiliacionEsBancoRep;
    }
    
    public void setDSPlanesDAfiliacionEsBancoRep(Boolean dSPlanesDAfiliacionEsBancoRep) {
        this.dSPlanesDAfiliacionEsBancoRep = dSPlanesDAfiliacionEsBancoRep;
    }

    @JsonIgnore
    public Boolean getDSPlanesDAfiliacionEsVoluntario() {
        return this.dSPlanesDAfiliacionEsVoluntario;
    }
    
    public void setDSPlanesDAfiliacionEsVoluntario(Boolean dSPlanesDAfiliacionEsVoluntario) {
        this.dSPlanesDAfiliacionEsVoluntario = dSPlanesDAfiliacionEsVoluntario;
    }

    @JsonIgnore
    public Boolean getDSPlanesDAfiliacionInicioContDiaUno() {
        return this.dSPlanesDAfiliacionInicioContDiaUno;
    }
    
    public void setDSPlanesDAfiliacionInicioContDiaUno(Boolean dSPlanesDAfiliacionInicioContDiaUno) {
        this.dSPlanesDAfiliacionInicioContDiaUno = dSPlanesDAfiliacionInicioContDiaUno;
    }
}
