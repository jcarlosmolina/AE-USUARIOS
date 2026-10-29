package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovEstatusAsesor {

    @JsonProperty("drvnumradicadostr")
    private String dSSolNovEstatusAsesorDrvNumRadicadoStr;

    @JsonProperty("fechacreacion")
    private Date dSSolNovEstatusAsesorFechaCreacion;

    @JsonProperty("estado")
    private Long dSSolNovEstatusAsesorEstado;

    @JsonProperty("plant_productot_descripcion")
    private String dSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSSolNovEstatusAsesorPlanTDotNombre;

    @JsonProperty("numcontrato")
    private String dSSolNovEstatusAsesorNumContrato;

    @JsonProperty("excepcion")
    private Boolean dSSolNovEstatusAsesorExcepcion;

    @JsonProperty("novedad_tiponovedad_nombre")
    private String dSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre;

    @JsonProperty("novedad_nombre")
    private String dSSolNovEstatusAsesorNovedadDotNombre;

    @JsonProperty("causal_nombre")
    private String dSSolNovEstatusAsesorCausalDotNombre;

    @JsonProperty("fechacompletada")
    private Timestamp dSSolNovEstatusAsesorFechaCompletada;

    @JsonProperty("fechaultimodoc")
    private Timestamp dSSolNovEstatusAsesorFechaUltimoDoc;

    @JsonProperty("estadodocumentacion")
    private Long dSSolNovEstatusAsesorEstadoDocumentacion;

    @JsonProperty("prioridad")
    private Long dSSolNovEstatusAsesorPrioridad;

    public DSSolNovEstatusAsesor() {
    
    }

    public DSSolNovEstatusAsesor(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovEstatusAsesorDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
                this.dSSolNovEstatusAsesorFechaCreacion = instance.getSolicitudNovedadFechaCreacion();
                this.dSSolNovEstatusAsesorEstado = instance.getSolicitudNovedadEstado();
                this.dSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion = instance.getPlanT().getProductoT().getProductosDescripcion();
                this.dSSolNovEstatusAsesorPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSSolNovEstatusAsesorNumContrato = instance.getSolicitudNovedadNumContrato();
                this.dSSolNovEstatusAsesorExcepcion = instance.getSolicitudNovedadExcepcion();
                this.dSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre = instance.getNovedad().getTipoNovedad().getTipoNovedadNombre();
                this.dSSolNovEstatusAsesorNovedadDotNombre = instance.getNovedad().getNovedadNombre();
                this.dSSolNovEstatusAsesorCausalDotNombre = instance.getCausal().getCausalNombre();
                this.dSSolNovEstatusAsesorFechaCompletada = instance.getSolicitudNovedadFechaCompletada();
                this.dSSolNovEstatusAsesorFechaUltimoDoc = instance.getSolicitudNovedadFechaUltimoDoc();
                this.dSSolNovEstatusAsesorEstadoDocumentacion = instance.getSolicitudNovedadEstadoDocumentacion();
                this.dSSolNovEstatusAsesorPrioridad = instance.getSolicitudNovedadPrioridad();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovEstatusAsesorDrvNumRadicadoStr() {
        return this.dSSolNovEstatusAsesorDrvNumRadicadoStr;
    }
    
    public void setDSSolNovEstatusAsesorDrvNumRadicadoStr(String dSSolNovEstatusAsesorDrvNumRadicadoStr) {
        this.dSSolNovEstatusAsesorDrvNumRadicadoStr = dSSolNovEstatusAsesorDrvNumRadicadoStr;
    }

    @JsonIgnore
    public Date getDSSolNovEstatusAsesorFechaCreacion() {
        return this.dSSolNovEstatusAsesorFechaCreacion;
    }
    
    public void setDSSolNovEstatusAsesorFechaCreacion(Date dSSolNovEstatusAsesorFechaCreacion) {
        this.dSSolNovEstatusAsesorFechaCreacion = dSSolNovEstatusAsesorFechaCreacion;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusAsesorEstado() {
        return this.dSSolNovEstatusAsesorEstado;
    }
    
    public void setDSSolNovEstatusAsesorEstado(Long dSSolNovEstatusAsesorEstado) {
        this.dSSolNovEstatusAsesorEstado = dSSolNovEstatusAsesorEstado;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion() {
        return this.dSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion;
    }
    
    public void setDSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion(String dSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion) {
        this.dSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion = dSSolNovEstatusAsesorPlanTDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAsesorPlanTDotNombre() {
        return this.dSSolNovEstatusAsesorPlanTDotNombre;
    }
    
    public void setDSSolNovEstatusAsesorPlanTDotNombre(String dSSolNovEstatusAsesorPlanTDotNombre) {
        this.dSSolNovEstatusAsesorPlanTDotNombre = dSSolNovEstatusAsesorPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAsesorNumContrato() {
        return this.dSSolNovEstatusAsesorNumContrato;
    }
    
    public void setDSSolNovEstatusAsesorNumContrato(String dSSolNovEstatusAsesorNumContrato) {
        this.dSSolNovEstatusAsesorNumContrato = dSSolNovEstatusAsesorNumContrato;
    }

    @JsonIgnore
    public Boolean getDSSolNovEstatusAsesorExcepcion() {
        return this.dSSolNovEstatusAsesorExcepcion;
    }
    
    public void setDSSolNovEstatusAsesorExcepcion(Boolean dSSolNovEstatusAsesorExcepcion) {
        this.dSSolNovEstatusAsesorExcepcion = dSSolNovEstatusAsesorExcepcion;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre() {
        return this.dSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre;
    }
    
    public void setDSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre(String dSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre) {
        this.dSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre = dSSolNovEstatusAsesorNovedadDotTipoNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAsesorNovedadDotNombre() {
        return this.dSSolNovEstatusAsesorNovedadDotNombre;
    }
    
    public void setDSSolNovEstatusAsesorNovedadDotNombre(String dSSolNovEstatusAsesorNovedadDotNombre) {
        this.dSSolNovEstatusAsesorNovedadDotNombre = dSSolNovEstatusAsesorNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAsesorCausalDotNombre() {
        return this.dSSolNovEstatusAsesorCausalDotNombre;
    }
    
    public void setDSSolNovEstatusAsesorCausalDotNombre(String dSSolNovEstatusAsesorCausalDotNombre) {
        this.dSSolNovEstatusAsesorCausalDotNombre = dSSolNovEstatusAsesorCausalDotNombre;
    }

    @JsonIgnore
    public Timestamp getDSSolNovEstatusAsesorFechaCompletada() {
        return this.dSSolNovEstatusAsesorFechaCompletada;
    }
    
    public void setDSSolNovEstatusAsesorFechaCompletada(Timestamp dSSolNovEstatusAsesorFechaCompletada) {
        this.dSSolNovEstatusAsesorFechaCompletada = dSSolNovEstatusAsesorFechaCompletada;
    }

    @JsonIgnore
    public Timestamp getDSSolNovEstatusAsesorFechaUltimoDoc() {
        return this.dSSolNovEstatusAsesorFechaUltimoDoc;
    }
    
    public void setDSSolNovEstatusAsesorFechaUltimoDoc(Timestamp dSSolNovEstatusAsesorFechaUltimoDoc) {
        this.dSSolNovEstatusAsesorFechaUltimoDoc = dSSolNovEstatusAsesorFechaUltimoDoc;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusAsesorEstadoDocumentacion() {
        return this.dSSolNovEstatusAsesorEstadoDocumentacion;
    }
    
    public void setDSSolNovEstatusAsesorEstadoDocumentacion(Long dSSolNovEstatusAsesorEstadoDocumentacion) {
        this.dSSolNovEstatusAsesorEstadoDocumentacion = dSSolNovEstatusAsesorEstadoDocumentacion;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusAsesorPrioridad() {
        return this.dSSolNovEstatusAsesorPrioridad;
    }
    
    public void setDSSolNovEstatusAsesorPrioridad(Long dSSolNovEstatusAsesorPrioridad) {
        this.dSSolNovEstatusAsesorPrioridad = dSSolNovEstatusAsesorPrioridad;
    }
}
