package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovTipoContrato {

    @JsonProperty("drvnumradicadostr")
    private String dSSolNovTipoContratoDrvNumRadicadoStr;

    @JsonProperty("plant_productot_descripcion")
    private String dSSolNovTipoContratoPlanTDotProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSSolNovTipoContratoPlanTDotNombre;

    @JsonProperty("numcontrato")
    private String dSSolNovTipoContratoNumContrato;

    @JsonProperty("estadocontrato_descripcion")
    private String dSSolNovTipoContratoEstadoContratoDotDescripcion;

    @JsonProperty("ctrtagcausaexclusion")
    private String dSSolNovTipoContratoCtrTagCausaExclusion;

    @JsonProperty("drvtarifa")
    private String dSSolNovTipoContratoDrvTarifa;

    @JsonProperty("drvconvenio")
    private String dSSolNovTipoContratoDrvConvenio;

    @JsonProperty("drvgrupoasociado")
    private String dSSolNovTipoContratoDrvGrupoAsociado;

    @JsonProperty("drvperiodicidad")
    private String dSSolNovTipoContratoDrvPeriodicidad;

    @JsonProperty("novedad_drvtextomostrar")
    private String dSSolNovTipoContratoNovedadDotDrvTextoMostrar;

    @JsonProperty("causal_drvtextomostrar")
    private String dSSolNovTipoContratoCausalDotDrvTextoMostrar;

    @JsonProperty("drvnuevaperiodicidad")
    private String dSSolNovTipoContratoDrvNuevaPeriodicidad;

    @JsonProperty("scnummeses")
    private Long dSSolNovTipoContratoSCNumMeses;

    @JsonProperty("firma_imagenfirma")
    private byte[] dSSolNovTipoContratoFirmaDotImagenFirma;

    @JsonProperty("completada")
    private Boolean dSSolNovTipoContratoCompletada;

    @JsonProperty("novedad_aliasnovedad")
    private String dSSolNovTipoContratoNovedadDotAliasNovedad;

    public DSSolNovTipoContrato() {
    
    }

    public DSSolNovTipoContrato(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovTipoContratoDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
                this.dSSolNovTipoContratoPlanTDotProductoTDotDescripcion = instance.getPlanT().getProductoT().getProductosDescripcion();
                this.dSSolNovTipoContratoPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSSolNovTipoContratoNumContrato = instance.getSolicitudNovedadNumContrato();
                this.dSSolNovTipoContratoEstadoContratoDotDescripcion = instance.getEstadoContrato().getEstadoContratoDescripcion();
                this.dSSolNovTipoContratoCtrTagCausaExclusion = instance.getSolicitudNovedadCtrTagCausaExclusion();
                this.dSSolNovTipoContratoDrvTarifa = instance.getSolicitudNovedadDrvTarifa();
                this.dSSolNovTipoContratoDrvConvenio = instance.getSolicitudNovedadDrvConvenio();
                this.dSSolNovTipoContratoDrvGrupoAsociado = instance.getSolicitudNovedadDrvGrupoAsociado();
                this.dSSolNovTipoContratoDrvPeriodicidad = instance.getSolicitudNovedadDrvPeriodicidad();
                this.dSSolNovTipoContratoNovedadDotDrvTextoMostrar = instance.getNovedad().getNovedadDrvTextoMostrar();
                this.dSSolNovTipoContratoCausalDotDrvTextoMostrar = instance.getCausal().getCausalDrvTextoMostrar();
                this.dSSolNovTipoContratoDrvNuevaPeriodicidad = instance.getSolicitudNovedadDrvNuevaPeriodicidad();
                this.dSSolNovTipoContratoSCNumMeses = instance.getSolicitudNovedadSCNumMeses();
                this.dSSolNovTipoContratoFirmaDotImagenFirma = instance.getFirma().getFirmaImagenFirma();
                this.dSSolNovTipoContratoCompletada = instance.getSolicitudNovedadCompletada();
                this.dSSolNovTipoContratoNovedadDotAliasNovedad = instance.getNovedad().getNovedadAliasNovedad();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoDrvNumRadicadoStr() {
        return this.dSSolNovTipoContratoDrvNumRadicadoStr;
    }
    
    public void setDSSolNovTipoContratoDrvNumRadicadoStr(String dSSolNovTipoContratoDrvNumRadicadoStr) {
        this.dSSolNovTipoContratoDrvNumRadicadoStr = dSSolNovTipoContratoDrvNumRadicadoStr;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoPlanTDotProductoTDotDescripcion() {
        return this.dSSolNovTipoContratoPlanTDotProductoTDotDescripcion;
    }
    
    public void setDSSolNovTipoContratoPlanTDotProductoTDotDescripcion(String dSSolNovTipoContratoPlanTDotProductoTDotDescripcion) {
        this.dSSolNovTipoContratoPlanTDotProductoTDotDescripcion = dSSolNovTipoContratoPlanTDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoPlanTDotNombre() {
        return this.dSSolNovTipoContratoPlanTDotNombre;
    }
    
    public void setDSSolNovTipoContratoPlanTDotNombre(String dSSolNovTipoContratoPlanTDotNombre) {
        this.dSSolNovTipoContratoPlanTDotNombre = dSSolNovTipoContratoPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoNumContrato() {
        return this.dSSolNovTipoContratoNumContrato;
    }
    
    public void setDSSolNovTipoContratoNumContrato(String dSSolNovTipoContratoNumContrato) {
        this.dSSolNovTipoContratoNumContrato = dSSolNovTipoContratoNumContrato;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoEstadoContratoDotDescripcion() {
        return this.dSSolNovTipoContratoEstadoContratoDotDescripcion;
    }
    
    public void setDSSolNovTipoContratoEstadoContratoDotDescripcion(String dSSolNovTipoContratoEstadoContratoDotDescripcion) {
        this.dSSolNovTipoContratoEstadoContratoDotDescripcion = dSSolNovTipoContratoEstadoContratoDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoCtrTagCausaExclusion() {
        return this.dSSolNovTipoContratoCtrTagCausaExclusion;
    }
    
    public void setDSSolNovTipoContratoCtrTagCausaExclusion(String dSSolNovTipoContratoCtrTagCausaExclusion) {
        this.dSSolNovTipoContratoCtrTagCausaExclusion = dSSolNovTipoContratoCtrTagCausaExclusion;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoDrvTarifa() {
        return this.dSSolNovTipoContratoDrvTarifa;
    }
    
    public void setDSSolNovTipoContratoDrvTarifa(String dSSolNovTipoContratoDrvTarifa) {
        this.dSSolNovTipoContratoDrvTarifa = dSSolNovTipoContratoDrvTarifa;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoDrvConvenio() {
        return this.dSSolNovTipoContratoDrvConvenio;
    }
    
    public void setDSSolNovTipoContratoDrvConvenio(String dSSolNovTipoContratoDrvConvenio) {
        this.dSSolNovTipoContratoDrvConvenio = dSSolNovTipoContratoDrvConvenio;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoDrvGrupoAsociado() {
        return this.dSSolNovTipoContratoDrvGrupoAsociado;
    }
    
    public void setDSSolNovTipoContratoDrvGrupoAsociado(String dSSolNovTipoContratoDrvGrupoAsociado) {
        this.dSSolNovTipoContratoDrvGrupoAsociado = dSSolNovTipoContratoDrvGrupoAsociado;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoDrvPeriodicidad() {
        return this.dSSolNovTipoContratoDrvPeriodicidad;
    }
    
    public void setDSSolNovTipoContratoDrvPeriodicidad(String dSSolNovTipoContratoDrvPeriodicidad) {
        this.dSSolNovTipoContratoDrvPeriodicidad = dSSolNovTipoContratoDrvPeriodicidad;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoNovedadDotDrvTextoMostrar() {
        return this.dSSolNovTipoContratoNovedadDotDrvTextoMostrar;
    }
    
    public void setDSSolNovTipoContratoNovedadDotDrvTextoMostrar(String dSSolNovTipoContratoNovedadDotDrvTextoMostrar) {
        this.dSSolNovTipoContratoNovedadDotDrvTextoMostrar = dSSolNovTipoContratoNovedadDotDrvTextoMostrar;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoCausalDotDrvTextoMostrar() {
        return this.dSSolNovTipoContratoCausalDotDrvTextoMostrar;
    }
    
    public void setDSSolNovTipoContratoCausalDotDrvTextoMostrar(String dSSolNovTipoContratoCausalDotDrvTextoMostrar) {
        this.dSSolNovTipoContratoCausalDotDrvTextoMostrar = dSSolNovTipoContratoCausalDotDrvTextoMostrar;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoDrvNuevaPeriodicidad() {
        return this.dSSolNovTipoContratoDrvNuevaPeriodicidad;
    }
    
    public void setDSSolNovTipoContratoDrvNuevaPeriodicidad(String dSSolNovTipoContratoDrvNuevaPeriodicidad) {
        this.dSSolNovTipoContratoDrvNuevaPeriodicidad = dSSolNovTipoContratoDrvNuevaPeriodicidad;
    }

    @JsonIgnore
    public Long getDSSolNovTipoContratoSCNumMeses() {
        return this.dSSolNovTipoContratoSCNumMeses;
    }
    
    public void setDSSolNovTipoContratoSCNumMeses(Long dSSolNovTipoContratoSCNumMeses) {
        this.dSSolNovTipoContratoSCNumMeses = dSSolNovTipoContratoSCNumMeses;
    }

    @JsonIgnore
    public byte[] getDSSolNovTipoContratoFirmaDotImagenFirma() {
        return this.dSSolNovTipoContratoFirmaDotImagenFirma;
    }
    
    public void setDSSolNovTipoContratoFirmaDotImagenFirma(byte[] dSSolNovTipoContratoFirmaDotImagenFirma) {
        this.dSSolNovTipoContratoFirmaDotImagenFirma = dSSolNovTipoContratoFirmaDotImagenFirma;
    }

    @JsonIgnore
    public Boolean getDSSolNovTipoContratoCompletada() {
        return this.dSSolNovTipoContratoCompletada;
    }
    
    public void setDSSolNovTipoContratoCompletada(Boolean dSSolNovTipoContratoCompletada) {
        this.dSSolNovTipoContratoCompletada = dSSolNovTipoContratoCompletada;
    }

    @JsonIgnore
    public String getDSSolNovTipoContratoNovedadDotAliasNovedad() {
        return this.dSSolNovTipoContratoNovedadDotAliasNovedad;
    }
    
    public void setDSSolNovTipoContratoNovedadDotAliasNovedad(String dSSolNovTipoContratoNovedadDotAliasNovedad) {
        this.dSSolNovTipoContratoNovedadDotAliasNovedad = dSSolNovTipoContratoNovedadDotAliasNovedad;
    }
}
