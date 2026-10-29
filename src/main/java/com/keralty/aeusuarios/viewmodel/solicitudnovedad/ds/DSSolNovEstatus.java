package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovEstatus {

    @JsonProperty("drvnumradicadostr")
    private String dSSolNovEstatusDrvNumRadicadoStr;

    @JsonProperty("fechacreacion")
    private Date dSSolNovEstatusFechaCreacion;

    @JsonProperty("estado")
    private Long dSSolNovEstatusEstado;

    @JsonProperty("plant_productot_descripcion")
    private String dSSolNovEstatusPlanTDotProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSSolNovEstatusPlanTDotNombre;

    @JsonProperty("numcontrato")
    private String dSSolNovEstatusNumContrato;

    @JsonProperty("excepcion")
    private Boolean dSSolNovEstatusExcepcion;

    @JsonProperty("novedad_tiponovedad_nombre")
    private String dSSolNovEstatusNovedadDotTipoNovedadDotNombre;

    @JsonProperty("novedad_nombre")
    private String dSSolNovEstatusNovedadDotNombre;

    @JsonProperty("causal_nombre")
    private String dSSolNovEstatusCausalDotNombre;

    @JsonProperty("fechacompletada")
    private Timestamp dSSolNovEstatusFechaCompletada;

    @JsonProperty("fechaultimodoc")
    private Timestamp dSSolNovEstatusFechaUltimoDoc;

    @JsonProperty("estadodocumentacion")
    private Long dSSolNovEstatusEstadoDocumentacion;

    @JsonProperty("prioridad")
    private Long dSSolNovEstatusPrioridad;

    @JsonProperty("drvsemaforograbase")
    private Double dSSolNovEstatusDrvSemaforoGrabAse;

    @JsonProperty("usrafiliacion_drvnombrecompleto")
    private String dSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto;

    public DSSolNovEstatus() {
    
    }

    public DSSolNovEstatus(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovEstatusDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
                this.dSSolNovEstatusFechaCreacion = instance.getSolicitudNovedadFechaCreacion();
                this.dSSolNovEstatusEstado = instance.getSolicitudNovedadEstado();
                this.dSSolNovEstatusPlanTDotProductoTDotDescripcion = instance.getPlanT().getProductoT().getProductosDescripcion();
                this.dSSolNovEstatusPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSSolNovEstatusNumContrato = instance.getSolicitudNovedadNumContrato();
                this.dSSolNovEstatusExcepcion = instance.getSolicitudNovedadExcepcion();
                this.dSSolNovEstatusNovedadDotTipoNovedadDotNombre = instance.getNovedad().getTipoNovedad().getTipoNovedadNombre();
                this.dSSolNovEstatusNovedadDotNombre = instance.getNovedad().getNovedadNombre();
                this.dSSolNovEstatusCausalDotNombre = instance.getCausal().getCausalNombre();
                this.dSSolNovEstatusFechaCompletada = instance.getSolicitudNovedadFechaCompletada();
                this.dSSolNovEstatusFechaUltimoDoc = instance.getSolicitudNovedadFechaUltimoDoc();
                this.dSSolNovEstatusEstadoDocumentacion = instance.getSolicitudNovedadEstadoDocumentacion();
                this.dSSolNovEstatusPrioridad = instance.getSolicitudNovedadPrioridad();
                this.dSSolNovEstatusDrvSemaforoGrabAse = instance.getSolicitudNovedaddrvSemaforoGrabAse();
                this.dSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto = instance.getUsrAfiliacion().getFuncionariodrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovEstatusDrvNumRadicadoStr() {
        return this.dSSolNovEstatusDrvNumRadicadoStr;
    }
    
    public void setDSSolNovEstatusDrvNumRadicadoStr(String dSSolNovEstatusDrvNumRadicadoStr) {
        this.dSSolNovEstatusDrvNumRadicadoStr = dSSolNovEstatusDrvNumRadicadoStr;
    }

    @JsonIgnore
    public Date getDSSolNovEstatusFechaCreacion() {
        return this.dSSolNovEstatusFechaCreacion;
    }
    
    public void setDSSolNovEstatusFechaCreacion(Date dSSolNovEstatusFechaCreacion) {
        this.dSSolNovEstatusFechaCreacion = dSSolNovEstatusFechaCreacion;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusEstado() {
        return this.dSSolNovEstatusEstado;
    }
    
    public void setDSSolNovEstatusEstado(Long dSSolNovEstatusEstado) {
        this.dSSolNovEstatusEstado = dSSolNovEstatusEstado;
    }

    @JsonIgnore
    public String getDSSolNovEstatusPlanTDotProductoTDotDescripcion() {
        return this.dSSolNovEstatusPlanTDotProductoTDotDescripcion;
    }
    
    public void setDSSolNovEstatusPlanTDotProductoTDotDescripcion(String dSSolNovEstatusPlanTDotProductoTDotDescripcion) {
        this.dSSolNovEstatusPlanTDotProductoTDotDescripcion = dSSolNovEstatusPlanTDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovEstatusPlanTDotNombre() {
        return this.dSSolNovEstatusPlanTDotNombre;
    }
    
    public void setDSSolNovEstatusPlanTDotNombre(String dSSolNovEstatusPlanTDotNombre) {
        this.dSSolNovEstatusPlanTDotNombre = dSSolNovEstatusPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusNumContrato() {
        return this.dSSolNovEstatusNumContrato;
    }
    
    public void setDSSolNovEstatusNumContrato(String dSSolNovEstatusNumContrato) {
        this.dSSolNovEstatusNumContrato = dSSolNovEstatusNumContrato;
    }

    @JsonIgnore
    public Boolean getDSSolNovEstatusExcepcion() {
        return this.dSSolNovEstatusExcepcion;
    }
    
    public void setDSSolNovEstatusExcepcion(Boolean dSSolNovEstatusExcepcion) {
        this.dSSolNovEstatusExcepcion = dSSolNovEstatusExcepcion;
    }

    @JsonIgnore
    public String getDSSolNovEstatusNovedadDotTipoNovedadDotNombre() {
        return this.dSSolNovEstatusNovedadDotTipoNovedadDotNombre;
    }
    
    public void setDSSolNovEstatusNovedadDotTipoNovedadDotNombre(String dSSolNovEstatusNovedadDotTipoNovedadDotNombre) {
        this.dSSolNovEstatusNovedadDotTipoNovedadDotNombre = dSSolNovEstatusNovedadDotTipoNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusNovedadDotNombre() {
        return this.dSSolNovEstatusNovedadDotNombre;
    }
    
    public void setDSSolNovEstatusNovedadDotNombre(String dSSolNovEstatusNovedadDotNombre) {
        this.dSSolNovEstatusNovedadDotNombre = dSSolNovEstatusNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusCausalDotNombre() {
        return this.dSSolNovEstatusCausalDotNombre;
    }
    
    public void setDSSolNovEstatusCausalDotNombre(String dSSolNovEstatusCausalDotNombre) {
        this.dSSolNovEstatusCausalDotNombre = dSSolNovEstatusCausalDotNombre;
    }

    @JsonIgnore
    public Timestamp getDSSolNovEstatusFechaCompletada() {
        return this.dSSolNovEstatusFechaCompletada;
    }
    
    public void setDSSolNovEstatusFechaCompletada(Timestamp dSSolNovEstatusFechaCompletada) {
        this.dSSolNovEstatusFechaCompletada = dSSolNovEstatusFechaCompletada;
    }

    @JsonIgnore
    public Timestamp getDSSolNovEstatusFechaUltimoDoc() {
        return this.dSSolNovEstatusFechaUltimoDoc;
    }
    
    public void setDSSolNovEstatusFechaUltimoDoc(Timestamp dSSolNovEstatusFechaUltimoDoc) {
        this.dSSolNovEstatusFechaUltimoDoc = dSSolNovEstatusFechaUltimoDoc;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusEstadoDocumentacion() {
        return this.dSSolNovEstatusEstadoDocumentacion;
    }
    
    public void setDSSolNovEstatusEstadoDocumentacion(Long dSSolNovEstatusEstadoDocumentacion) {
        this.dSSolNovEstatusEstadoDocumentacion = dSSolNovEstatusEstadoDocumentacion;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusPrioridad() {
        return this.dSSolNovEstatusPrioridad;
    }
    
    public void setDSSolNovEstatusPrioridad(Long dSSolNovEstatusPrioridad) {
        this.dSSolNovEstatusPrioridad = dSSolNovEstatusPrioridad;
    }

    @JsonIgnore
    public Double getDSSolNovEstatusDrvSemaforoGrabAse() {
        return this.dSSolNovEstatusDrvSemaforoGrabAse;
    }
    
    public void setDSSolNovEstatusDrvSemaforoGrabAse(Double dSSolNovEstatusDrvSemaforoGrabAse) {
        this.dSSolNovEstatusDrvSemaforoGrabAse = dSSolNovEstatusDrvSemaforoGrabAse;
    }

    @JsonIgnore
    public String getDSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto() {
        return this.dSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto;
    }
    
    public void setDSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto(String dSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto) {
        this.dSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto = dSSolNovEstatusUsrAfiliacionDotDrvNombreCompleto;
    }
}
