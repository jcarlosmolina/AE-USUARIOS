package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import java.sql.Date;
import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovEstatusAfiliacion {

    @JsonProperty("plant_productot_descripcion")
    private String dSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSSolNovEstatusAfiliacionPlanTDotNombre;

    @JsonProperty("estadodocumentacion")
    private Long dSSolNovEstatusAfiliacionEstadoDocumentacion;

    @JsonProperty("estado")
    private Long dSSolNovEstatusAfiliacionEstado;

    @JsonProperty("fechafa")
    private Timestamp dSSolNovEstatusAfiliacionFechaFA;

    @JsonProperty("fechavigencia")
    private Date dSSolNovEstatusAfiliacionFechaVigencia;

    @JsonProperty("drvnumradicadostr")
    private String dSSolNovEstatusAfiliacionDrvNumRadicadoStr;

    @JsonProperty("novedad_tiponovedad_nombre")
    private String dSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre;

    @JsonProperty("novedad_nombre")
    private String dSSolNovEstatusAfiliacionNovedadDotNombre;

    @JsonProperty("causal_nombre")
    private String dSSolNovEstatusAfiliacionCausalDotNombre;

    @JsonProperty("prioridad")
    private Long dSSolNovEstatusAfiliacionPrioridad;

    @JsonProperty("drvsemaforograbase")
    private Double dSSolNovEstatusAfiliacionDrvSemaforoGrabAse;

    @JsonProperty("agente_drvnombrecompleto")
    private String dSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto;

    public DSSolNovEstatusAfiliacion() {
    
    }

    public DSSolNovEstatusAfiliacion(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion = instance.getPlanT().getProductoT().getProductosDescripcion();
                this.dSSolNovEstatusAfiliacionPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSSolNovEstatusAfiliacionEstadoDocumentacion = instance.getSolicitudNovedadEstadoDocumentacion();
                this.dSSolNovEstatusAfiliacionEstado = instance.getSolicitudNovedadEstado();
                this.dSSolNovEstatusAfiliacionFechaFA = instance.getSolicitudNovedadFechaFA();
                this.dSSolNovEstatusAfiliacionFechaVigencia = instance.getSolicitudNovedadFechaVigencia();
                this.dSSolNovEstatusAfiliacionDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
                this.dSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre = instance.getNovedad().getTipoNovedad().getTipoNovedadNombre();
                this.dSSolNovEstatusAfiliacionNovedadDotNombre = instance.getNovedad().getNovedadNombre();
                this.dSSolNovEstatusAfiliacionCausalDotNombre = instance.getCausal().getCausalNombre();
                this.dSSolNovEstatusAfiliacionPrioridad = instance.getSolicitudNovedadPrioridad();
                this.dSSolNovEstatusAfiliacionDrvSemaforoGrabAse = instance.getSolicitudNovedaddrvSemaforoGrabAse();
                this.dSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto = instance.getAgente().getFuncionariodrvNombreCompleto();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion() {
        return this.dSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion;
    }
    
    public void setDSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion(String dSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion) {
        this.dSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion = dSSolNovEstatusAfiliacionPlanTDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAfiliacionPlanTDotNombre() {
        return this.dSSolNovEstatusAfiliacionPlanTDotNombre;
    }
    
    public void setDSSolNovEstatusAfiliacionPlanTDotNombre(String dSSolNovEstatusAfiliacionPlanTDotNombre) {
        this.dSSolNovEstatusAfiliacionPlanTDotNombre = dSSolNovEstatusAfiliacionPlanTDotNombre;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusAfiliacionEstadoDocumentacion() {
        return this.dSSolNovEstatusAfiliacionEstadoDocumentacion;
    }
    
    public void setDSSolNovEstatusAfiliacionEstadoDocumentacion(Long dSSolNovEstatusAfiliacionEstadoDocumentacion) {
        this.dSSolNovEstatusAfiliacionEstadoDocumentacion = dSSolNovEstatusAfiliacionEstadoDocumentacion;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusAfiliacionEstado() {
        return this.dSSolNovEstatusAfiliacionEstado;
    }
    
    public void setDSSolNovEstatusAfiliacionEstado(Long dSSolNovEstatusAfiliacionEstado) {
        this.dSSolNovEstatusAfiliacionEstado = dSSolNovEstatusAfiliacionEstado;
    }

    @JsonIgnore
    public Timestamp getDSSolNovEstatusAfiliacionFechaFA() {
        return this.dSSolNovEstatusAfiliacionFechaFA;
    }
    
    public void setDSSolNovEstatusAfiliacionFechaFA(Timestamp dSSolNovEstatusAfiliacionFechaFA) {
        this.dSSolNovEstatusAfiliacionFechaFA = dSSolNovEstatusAfiliacionFechaFA;
    }

    @JsonIgnore
    public Date getDSSolNovEstatusAfiliacionFechaVigencia() {
        return this.dSSolNovEstatusAfiliacionFechaVigencia;
    }
    
    public void setDSSolNovEstatusAfiliacionFechaVigencia(Date dSSolNovEstatusAfiliacionFechaVigencia) {
        this.dSSolNovEstatusAfiliacionFechaVigencia = dSSolNovEstatusAfiliacionFechaVigencia;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAfiliacionDrvNumRadicadoStr() {
        return this.dSSolNovEstatusAfiliacionDrvNumRadicadoStr;
    }
    
    public void setDSSolNovEstatusAfiliacionDrvNumRadicadoStr(String dSSolNovEstatusAfiliacionDrvNumRadicadoStr) {
        this.dSSolNovEstatusAfiliacionDrvNumRadicadoStr = dSSolNovEstatusAfiliacionDrvNumRadicadoStr;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre() {
        return this.dSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre;
    }
    
    public void setDSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre(String dSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre) {
        this.dSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre = dSSolNovEstatusAfiliacionNovedadDotTipoNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAfiliacionNovedadDotNombre() {
        return this.dSSolNovEstatusAfiliacionNovedadDotNombre;
    }
    
    public void setDSSolNovEstatusAfiliacionNovedadDotNombre(String dSSolNovEstatusAfiliacionNovedadDotNombre) {
        this.dSSolNovEstatusAfiliacionNovedadDotNombre = dSSolNovEstatusAfiliacionNovedadDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAfiliacionCausalDotNombre() {
        return this.dSSolNovEstatusAfiliacionCausalDotNombre;
    }
    
    public void setDSSolNovEstatusAfiliacionCausalDotNombre(String dSSolNovEstatusAfiliacionCausalDotNombre) {
        this.dSSolNovEstatusAfiliacionCausalDotNombre = dSSolNovEstatusAfiliacionCausalDotNombre;
    }

    @JsonIgnore
    public Long getDSSolNovEstatusAfiliacionPrioridad() {
        return this.dSSolNovEstatusAfiliacionPrioridad;
    }
    
    public void setDSSolNovEstatusAfiliacionPrioridad(Long dSSolNovEstatusAfiliacionPrioridad) {
        this.dSSolNovEstatusAfiliacionPrioridad = dSSolNovEstatusAfiliacionPrioridad;
    }

    @JsonIgnore
    public Double getDSSolNovEstatusAfiliacionDrvSemaforoGrabAse() {
        return this.dSSolNovEstatusAfiliacionDrvSemaforoGrabAse;
    }
    
    public void setDSSolNovEstatusAfiliacionDrvSemaforoGrabAse(Double dSSolNovEstatusAfiliacionDrvSemaforoGrabAse) {
        this.dSSolNovEstatusAfiliacionDrvSemaforoGrabAse = dSSolNovEstatusAfiliacionDrvSemaforoGrabAse;
    }

    @JsonIgnore
    public String getDSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto() {
        return this.dSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto;
    }
    
    public void setDSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto(String dSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto) {
        this.dSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto = dSSolNovEstatusAfiliacionAgenteDotDrvNombreCompleto;
    }
}
