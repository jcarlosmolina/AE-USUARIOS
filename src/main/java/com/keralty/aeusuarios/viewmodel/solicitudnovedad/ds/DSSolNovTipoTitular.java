package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovTipoTitular {

    @JsonProperty("drvnumradicadostr")
    private String dSSolNovTipoTitularDrvNumRadicadoStr;

    @JsonProperty("plant_productot_descripcion")
    private String dSSolNovTipoTitularPlanTDotProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSSolNovTipoTitularPlanTDotNombre;

    @JsonProperty("numcontrato")
    private String dSSolNovTipoTitularNumContrato;

    @JsonProperty("estadocontrato_descripcion")
    private String dSSolNovTipoTitularEstadoContratoDotDescripcion;

    @JsonProperty("ctrtagcausaexclusion")
    private String dSSolNovTipoTitularCtrTagCausaExclusion;

    @JsonProperty("drvtarifa")
    private String dSSolNovTipoTitularDrvTarifa;

    @JsonProperty("drvconvenio")
    private String dSSolNovTipoTitularDrvConvenio;

    @JsonProperty("drvgrupoasociado")
    private String dSSolNovTipoTitularDrvGrupoAsociado;

    @JsonProperty("drvperiodicidad")
    private String dSSolNovTipoTitularDrvPeriodicidad;

    @JsonProperty("novedad_drvtextomostrar")
    private String dSSolNovTipoTitularNovedadDotDrvTextoMostrar;

    @JsonProperty("causal_drvtextomostrar")
    private String dSSolNovTipoTitularCausalDotDrvTextoMostrar;

    @JsonProperty("firma_imagenfirma")
    private byte[] dSSolNovTipoTitularFirmaDotImagenFirma;

    @JsonProperty("completada")
    private Boolean dSSolNovTipoTitularCompletada;

    @JsonProperty("drvpermiteaddfam")
    private Boolean dSSolNovTipoTitularDrvPermiteAddFam;

    @JsonProperty("drvpermitedelfam")
    private Boolean dSSolNovTipoTitularDrvPermiteDelFam;

    @JsonProperty("novedad_aliasnovedad")
    private String dSSolNovTipoTitularNovedadDotAliasNovedad;

    public DSSolNovTipoTitular() {
    
    }

    public DSSolNovTipoTitular(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovTipoTitularDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
                this.dSSolNovTipoTitularPlanTDotProductoTDotDescripcion = instance.getPlanT().getProductoT().getProductosDescripcion();
                this.dSSolNovTipoTitularPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSSolNovTipoTitularNumContrato = instance.getSolicitudNovedadNumContrato();
                this.dSSolNovTipoTitularEstadoContratoDotDescripcion = instance.getEstadoContrato().getEstadoContratoDescripcion();
                this.dSSolNovTipoTitularCtrTagCausaExclusion = instance.getSolicitudNovedadCtrTagCausaExclusion();
                this.dSSolNovTipoTitularDrvTarifa = instance.getSolicitudNovedadDrvTarifa();
                this.dSSolNovTipoTitularDrvConvenio = instance.getSolicitudNovedadDrvConvenio();
                this.dSSolNovTipoTitularDrvGrupoAsociado = instance.getSolicitudNovedadDrvGrupoAsociado();
                this.dSSolNovTipoTitularDrvPeriodicidad = instance.getSolicitudNovedadDrvPeriodicidad();
                this.dSSolNovTipoTitularNovedadDotDrvTextoMostrar = instance.getNovedad().getNovedadDrvTextoMostrar();
                this.dSSolNovTipoTitularCausalDotDrvTextoMostrar = instance.getCausal().getCausalDrvTextoMostrar();
                this.dSSolNovTipoTitularFirmaDotImagenFirma = instance.getFirma().getFirmaImagenFirma();
                this.dSSolNovTipoTitularCompletada = instance.getSolicitudNovedadCompletada();
                this.dSSolNovTipoTitularDrvPermiteAddFam = instance.getSolicitudNovedadDrvPermiteAddFam();
                this.dSSolNovTipoTitularDrvPermiteDelFam = instance.getSolicitudNovedadDrvPermiteDelFam();
                this.dSSolNovTipoTitularNovedadDotAliasNovedad = instance.getNovedad().getNovedadAliasNovedad();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularDrvNumRadicadoStr() {
        return this.dSSolNovTipoTitularDrvNumRadicadoStr;
    }
    
    public void setDSSolNovTipoTitularDrvNumRadicadoStr(String dSSolNovTipoTitularDrvNumRadicadoStr) {
        this.dSSolNovTipoTitularDrvNumRadicadoStr = dSSolNovTipoTitularDrvNumRadicadoStr;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularPlanTDotProductoTDotDescripcion() {
        return this.dSSolNovTipoTitularPlanTDotProductoTDotDescripcion;
    }
    
    public void setDSSolNovTipoTitularPlanTDotProductoTDotDescripcion(String dSSolNovTipoTitularPlanTDotProductoTDotDescripcion) {
        this.dSSolNovTipoTitularPlanTDotProductoTDotDescripcion = dSSolNovTipoTitularPlanTDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularPlanTDotNombre() {
        return this.dSSolNovTipoTitularPlanTDotNombre;
    }
    
    public void setDSSolNovTipoTitularPlanTDotNombre(String dSSolNovTipoTitularPlanTDotNombre) {
        this.dSSolNovTipoTitularPlanTDotNombre = dSSolNovTipoTitularPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularNumContrato() {
        return this.dSSolNovTipoTitularNumContrato;
    }
    
    public void setDSSolNovTipoTitularNumContrato(String dSSolNovTipoTitularNumContrato) {
        this.dSSolNovTipoTitularNumContrato = dSSolNovTipoTitularNumContrato;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularEstadoContratoDotDescripcion() {
        return this.dSSolNovTipoTitularEstadoContratoDotDescripcion;
    }
    
    public void setDSSolNovTipoTitularEstadoContratoDotDescripcion(String dSSolNovTipoTitularEstadoContratoDotDescripcion) {
        this.dSSolNovTipoTitularEstadoContratoDotDescripcion = dSSolNovTipoTitularEstadoContratoDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularCtrTagCausaExclusion() {
        return this.dSSolNovTipoTitularCtrTagCausaExclusion;
    }
    
    public void setDSSolNovTipoTitularCtrTagCausaExclusion(String dSSolNovTipoTitularCtrTagCausaExclusion) {
        this.dSSolNovTipoTitularCtrTagCausaExclusion = dSSolNovTipoTitularCtrTagCausaExclusion;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularDrvTarifa() {
        return this.dSSolNovTipoTitularDrvTarifa;
    }
    
    public void setDSSolNovTipoTitularDrvTarifa(String dSSolNovTipoTitularDrvTarifa) {
        this.dSSolNovTipoTitularDrvTarifa = dSSolNovTipoTitularDrvTarifa;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularDrvConvenio() {
        return this.dSSolNovTipoTitularDrvConvenio;
    }
    
    public void setDSSolNovTipoTitularDrvConvenio(String dSSolNovTipoTitularDrvConvenio) {
        this.dSSolNovTipoTitularDrvConvenio = dSSolNovTipoTitularDrvConvenio;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularDrvGrupoAsociado() {
        return this.dSSolNovTipoTitularDrvGrupoAsociado;
    }
    
    public void setDSSolNovTipoTitularDrvGrupoAsociado(String dSSolNovTipoTitularDrvGrupoAsociado) {
        this.dSSolNovTipoTitularDrvGrupoAsociado = dSSolNovTipoTitularDrvGrupoAsociado;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularDrvPeriodicidad() {
        return this.dSSolNovTipoTitularDrvPeriodicidad;
    }
    
    public void setDSSolNovTipoTitularDrvPeriodicidad(String dSSolNovTipoTitularDrvPeriodicidad) {
        this.dSSolNovTipoTitularDrvPeriodicidad = dSSolNovTipoTitularDrvPeriodicidad;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularNovedadDotDrvTextoMostrar() {
        return this.dSSolNovTipoTitularNovedadDotDrvTextoMostrar;
    }
    
    public void setDSSolNovTipoTitularNovedadDotDrvTextoMostrar(String dSSolNovTipoTitularNovedadDotDrvTextoMostrar) {
        this.dSSolNovTipoTitularNovedadDotDrvTextoMostrar = dSSolNovTipoTitularNovedadDotDrvTextoMostrar;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularCausalDotDrvTextoMostrar() {
        return this.dSSolNovTipoTitularCausalDotDrvTextoMostrar;
    }
    
    public void setDSSolNovTipoTitularCausalDotDrvTextoMostrar(String dSSolNovTipoTitularCausalDotDrvTextoMostrar) {
        this.dSSolNovTipoTitularCausalDotDrvTextoMostrar = dSSolNovTipoTitularCausalDotDrvTextoMostrar;
    }

    @JsonIgnore
    public byte[] getDSSolNovTipoTitularFirmaDotImagenFirma() {
        return this.dSSolNovTipoTitularFirmaDotImagenFirma;
    }
    
    public void setDSSolNovTipoTitularFirmaDotImagenFirma(byte[] dSSolNovTipoTitularFirmaDotImagenFirma) {
        this.dSSolNovTipoTitularFirmaDotImagenFirma = dSSolNovTipoTitularFirmaDotImagenFirma;
    }

    @JsonIgnore
    public Boolean getDSSolNovTipoTitularCompletada() {
        return this.dSSolNovTipoTitularCompletada;
    }
    
    public void setDSSolNovTipoTitularCompletada(Boolean dSSolNovTipoTitularCompletada) {
        this.dSSolNovTipoTitularCompletada = dSSolNovTipoTitularCompletada;
    }

    @JsonIgnore
    public Boolean getDSSolNovTipoTitularDrvPermiteAddFam() {
        return this.dSSolNovTipoTitularDrvPermiteAddFam;
    }
    
    public void setDSSolNovTipoTitularDrvPermiteAddFam(Boolean dSSolNovTipoTitularDrvPermiteAddFam) {
        this.dSSolNovTipoTitularDrvPermiteAddFam = dSSolNovTipoTitularDrvPermiteAddFam;
    }

    @JsonIgnore
    public Boolean getDSSolNovTipoTitularDrvPermiteDelFam() {
        return this.dSSolNovTipoTitularDrvPermiteDelFam;
    }
    
    public void setDSSolNovTipoTitularDrvPermiteDelFam(Boolean dSSolNovTipoTitularDrvPermiteDelFam) {
        this.dSSolNovTipoTitularDrvPermiteDelFam = dSSolNovTipoTitularDrvPermiteDelFam;
    }

    @JsonIgnore
    public String getDSSolNovTipoTitularNovedadDotAliasNovedad() {
        return this.dSSolNovTipoTitularNovedadDotAliasNovedad;
    }
    
    public void setDSSolNovTipoTitularNovedadDotAliasNovedad(String dSSolNovTipoTitularNovedadDotAliasNovedad) {
        this.dSSolNovTipoTitularNovedadDotAliasNovedad = dSSolNovTipoTitularNovedadDotAliasNovedad;
    }
}
