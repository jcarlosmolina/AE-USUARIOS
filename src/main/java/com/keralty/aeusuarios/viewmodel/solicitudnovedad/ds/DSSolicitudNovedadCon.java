package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolicitudNovedadCon {

    @JsonProperty("drvnumradicadostr")
    private String dSSolicitudNovedadConDrvNumRadicadoStr;

    @JsonProperty("fechacreacion")
    private Date dSSolicitudNovedadConFechaCreacion;

    @JsonProperty("plant_productot_descripcion")
    private String dSSolicitudNovedadConPlanTDotProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSSolicitudNovedadConPlanTDotNombre;

    @JsonProperty("numcontrato")
    private String dSSolicitudNovedadConNumContrato;

    @JsonProperty("excepcion")
    private Boolean dSSolicitudNovedadConExcepcion;

    @JsonProperty("novedad_tiponovedad_nombre")
    private String dSSolicitudNovedadConNovedadDotTipoNovedadDotNombre;

    @JsonProperty("novedad_nombre")
    private String dSSolicitudNovedadConNovedadDotNombre;

    @JsonProperty("causal_nombre")
    private String dSSolicitudNovedadConCausalDotNombre;

    public DSSolicitudNovedadCon() {
    
    }

    public DSSolicitudNovedadCon(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolicitudNovedadConDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
                this.dSSolicitudNovedadConFechaCreacion = instance.getSolicitudNovedadFechaCreacion();
                this.dSSolicitudNovedadConPlanTDotProductoTDotDescripcion = instance.getPlanT().getProductoT().getProductosDescripcion();
                this.dSSolicitudNovedadConPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSSolicitudNovedadConNumContrato = instance.getSolicitudNovedadNumContrato();
                this.dSSolicitudNovedadConExcepcion = instance.getSolicitudNovedadExcepcion();
                this.dSSolicitudNovedadConNovedadDotTipoNovedadDotNombre = instance.getNovedad().getTipoNovedad().getTipoNovedadNombre();
                this.dSSolicitudNovedadConNovedadDotNombre = instance.getNovedad().getNovedadNombre();
                this.dSSolicitudNovedadConCausalDotNombre = instance.getCausal().getCausalNombre();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolicitudNovedadConDrvNumRadicadoStr() {
        return this.dSSolicitudNovedadConDrvNumRadicadoStr;
    }
    
    public void setDSSolicitudNovedadConDrvNumRadicadoStr(String dSSolicitudNovedadConDrvNumRadicadoStr) {
        this.dSSolicitudNovedadConDrvNumRadicadoStr = dSSolicitudNovedadConDrvNumRadicadoStr;
    }

    @JsonIgnore
    public Date getDSSolicitudNovedadConFechaCreacion() {
        return this.dSSolicitudNovedadConFechaCreacion;
    }
    
    public void setDSSolicitudNovedadConFechaCreacion(Date dSSolicitudNovedadConFechaCreacion) {
        this.dSSolicitudNovedadConFechaCreacion = dSSolicitudNovedadConFechaCreacion;
    }

    @JsonIgnore
    public String getDSSolicitudNovedadConPlanTDotProductoTDotDescripcion() {
        return this.dSSolicitudNovedadConPlanTDotProductoTDotDescripcion;
    }
    
    public void setDSSolicitudNovedadConPlanTDotProductoTDotDescripcion(String dSSolicitudNovedadConPlanTDotProductoTDotDescripcion) {
        this.dSSolicitudNovedadConPlanTDotProductoTDotDescripcion = dSSolicitudNovedadConPlanTDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolicitudNovedadConPlanTDotNombre() {
        return this.dSSolicitudNovedadConPlanTDotNombre;
    }
    
    public void setDSSolicitudNovedadConPlanTDotNombre(String dSSolicitudNovedadConPlanTDotNombre) {
        this.dSSolicitudNovedadConPlanTDotNombre = dSSolicitudNovedadConPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSSolicitudNovedadConNumContrato() {
        return this.dSSolicitudNovedadConNumContrato;
    }
    
    public void setDSSolicitudNovedadConNumContrato(String dSSolicitudNovedadConNumContrato) {
        this.dSSolicitudNovedadConNumContrato = dSSolicitudNovedadConNumContrato;
    }

    @JsonIgnore
    public Boolean getDSSolicitudNovedadConExcepcion() {
        return this.dSSolicitudNovedadConExcepcion;
    }
    
    public void setDSSolicitudNovedadConExcepcion(Boolean dSSolicitudNovedadConExcepcion) {
        this.dSSolicitudNovedadConExcepcion = dSSolicitudNovedadConExcepcion;
    }

    @JsonIgnore
    public String getDSSolicitudNovedadConNovedadDotTipoNovedadDotNombre() {
        return this.dSSolicitudNovedadConNovedadDotTipoNovedadDotNombre;
    }
    
    public void setDSSolicitudNovedadConNovedadDotTipoNovedadDotNombre(String dSSolicitudNovedadConNovedadDotTipoNovedadDotNombre) {
        this.dSSolicitudNovedadConNovedadDotTipoNovedadDotNombre = dSSolicitudNovedadConNovedadDotTipoNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolicitudNovedadConNovedadDotNombre() {
        return this.dSSolicitudNovedadConNovedadDotNombre;
    }
    
    public void setDSSolicitudNovedadConNovedadDotNombre(String dSSolicitudNovedadConNovedadDotNombre) {
        this.dSSolicitudNovedadConNovedadDotNombre = dSSolicitudNovedadConNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolicitudNovedadConCausalDotNombre() {
        return this.dSSolicitudNovedadConCausalDotNombre;
    }
    
    public void setDSSolicitudNovedadConCausalDotNombre(String dSSolicitudNovedadConCausalDotNombre) {
        this.dSSolicitudNovedadConCausalDotNombre = dSSolicitudNovedadConCausalDotNombre;
    }
}
