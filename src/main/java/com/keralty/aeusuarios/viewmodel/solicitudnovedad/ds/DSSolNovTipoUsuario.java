package com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;
public class DSSolNovTipoUsuario {

    @JsonProperty("drvnumradicadostr")
    private String dSSolNovTipoUsuarioDrvNumRadicadoStr;

    @JsonProperty("plant_productot_descripcion")
    private String dSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSSolNovTipoUsuarioPlanTDotNombre;

    @JsonProperty("numcontrato")
    private String dSSolNovTipoUsuarioNumContrato;

    @JsonProperty("estadocontrato_descripcion")
    private String dSSolNovTipoUsuarioEstadoContratoDotDescripcion;

    @JsonProperty("ctrtagcausaexclusion")
    private String dSSolNovTipoUsuarioCtrTagCausaExclusion;

    @JsonProperty("drvtarifa")
    private String dSSolNovTipoUsuarioDrvTarifa;

    @JsonProperty("drvconvenio")
    private String dSSolNovTipoUsuarioDrvConvenio;

    @JsonProperty("drvgrupoasociado")
    private String dSSolNovTipoUsuarioDrvGrupoAsociado;

    @JsonProperty("drvperiodicidad")
    private String dSSolNovTipoUsuarioDrvPeriodicidad;

    @JsonProperty("novedad_drvtextomostrar")
    private String dSSolNovTipoUsuarioNovedadDotDrvTextoMostrar;

    @JsonProperty("causal_drvtextomostrar")
    private String dSSolNovTipoUsuarioCausalDotDrvTextoMostrar;

    @JsonProperty("firma_imagenfirma")
    private byte[] dSSolNovTipoUsuarioFirmaDotImagenFirma;

    @JsonProperty("completada")
    private Boolean dSSolNovTipoUsuarioCompletada;

    @JsonProperty("drvpermiteaddfam")
    private Boolean dSSolNovTipoUsuarioDrvPermiteAddFam;

    @JsonProperty("drvpermitedelfam")
    private Boolean dSSolNovTipoUsuarioDrvPermiteDelFam;

    @JsonProperty("novedad_aliasnovedad")
    private String dSSolNovTipoUsuarioNovedadDotAliasNovedad;

    public DSSolNovTipoUsuario() {
    
    }

    public DSSolNovTipoUsuario(SolicitudNovedad instance) {
        if (instance != null) {
            try {
                this.dSSolNovTipoUsuarioDrvNumRadicadoStr = instance.getSolicitudNovedadDrvNumRadicadoStr();
                this.dSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion = instance.getPlanT().getProductoT().getProductosDescripcion();
                this.dSSolNovTipoUsuarioPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSSolNovTipoUsuarioNumContrato = instance.getSolicitudNovedadNumContrato();
                this.dSSolNovTipoUsuarioEstadoContratoDotDescripcion = instance.getEstadoContrato().getEstadoContratoDescripcion();
                this.dSSolNovTipoUsuarioCtrTagCausaExclusion = instance.getSolicitudNovedadCtrTagCausaExclusion();
                this.dSSolNovTipoUsuarioDrvTarifa = instance.getSolicitudNovedadDrvTarifa();
                this.dSSolNovTipoUsuarioDrvConvenio = instance.getSolicitudNovedadDrvConvenio();
                this.dSSolNovTipoUsuarioDrvGrupoAsociado = instance.getSolicitudNovedadDrvGrupoAsociado();
                this.dSSolNovTipoUsuarioDrvPeriodicidad = instance.getSolicitudNovedadDrvPeriodicidad();
                this.dSSolNovTipoUsuarioNovedadDotDrvTextoMostrar = instance.getNovedad().getNovedadDrvTextoMostrar();
                this.dSSolNovTipoUsuarioCausalDotDrvTextoMostrar = instance.getCausal().getCausalDrvTextoMostrar();
                this.dSSolNovTipoUsuarioFirmaDotImagenFirma = instance.getFirma().getFirmaImagenFirma();
                this.dSSolNovTipoUsuarioCompletada = instance.getSolicitudNovedadCompletada();
                this.dSSolNovTipoUsuarioDrvPermiteAddFam = instance.getSolicitudNovedadDrvPermiteAddFam();
                this.dSSolNovTipoUsuarioDrvPermiteDelFam = instance.getSolicitudNovedadDrvPermiteDelFam();
                this.dSSolNovTipoUsuarioNovedadDotAliasNovedad = instance.getNovedad().getNovedadAliasNovedad();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioDrvNumRadicadoStr() {
        return this.dSSolNovTipoUsuarioDrvNumRadicadoStr;
    }
    
    public void setDSSolNovTipoUsuarioDrvNumRadicadoStr(String dSSolNovTipoUsuarioDrvNumRadicadoStr) {
        this.dSSolNovTipoUsuarioDrvNumRadicadoStr = dSSolNovTipoUsuarioDrvNumRadicadoStr;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion() {
        return this.dSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion;
    }
    
    public void setDSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion(String dSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion) {
        this.dSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion = dSSolNovTipoUsuarioPlanTDotProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioPlanTDotNombre() {
        return this.dSSolNovTipoUsuarioPlanTDotNombre;
    }
    
    public void setDSSolNovTipoUsuarioPlanTDotNombre(String dSSolNovTipoUsuarioPlanTDotNombre) {
        this.dSSolNovTipoUsuarioPlanTDotNombre = dSSolNovTipoUsuarioPlanTDotNombre;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioNumContrato() {
        return this.dSSolNovTipoUsuarioNumContrato;
    }
    
    public void setDSSolNovTipoUsuarioNumContrato(String dSSolNovTipoUsuarioNumContrato) {
        this.dSSolNovTipoUsuarioNumContrato = dSSolNovTipoUsuarioNumContrato;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioEstadoContratoDotDescripcion() {
        return this.dSSolNovTipoUsuarioEstadoContratoDotDescripcion;
    }
    
    public void setDSSolNovTipoUsuarioEstadoContratoDotDescripcion(String dSSolNovTipoUsuarioEstadoContratoDotDescripcion) {
        this.dSSolNovTipoUsuarioEstadoContratoDotDescripcion = dSSolNovTipoUsuarioEstadoContratoDotDescripcion;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioCtrTagCausaExclusion() {
        return this.dSSolNovTipoUsuarioCtrTagCausaExclusion;
    }
    
    public void setDSSolNovTipoUsuarioCtrTagCausaExclusion(String dSSolNovTipoUsuarioCtrTagCausaExclusion) {
        this.dSSolNovTipoUsuarioCtrTagCausaExclusion = dSSolNovTipoUsuarioCtrTagCausaExclusion;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioDrvTarifa() {
        return this.dSSolNovTipoUsuarioDrvTarifa;
    }
    
    public void setDSSolNovTipoUsuarioDrvTarifa(String dSSolNovTipoUsuarioDrvTarifa) {
        this.dSSolNovTipoUsuarioDrvTarifa = dSSolNovTipoUsuarioDrvTarifa;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioDrvConvenio() {
        return this.dSSolNovTipoUsuarioDrvConvenio;
    }
    
    public void setDSSolNovTipoUsuarioDrvConvenio(String dSSolNovTipoUsuarioDrvConvenio) {
        this.dSSolNovTipoUsuarioDrvConvenio = dSSolNovTipoUsuarioDrvConvenio;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioDrvGrupoAsociado() {
        return this.dSSolNovTipoUsuarioDrvGrupoAsociado;
    }
    
    public void setDSSolNovTipoUsuarioDrvGrupoAsociado(String dSSolNovTipoUsuarioDrvGrupoAsociado) {
        this.dSSolNovTipoUsuarioDrvGrupoAsociado = dSSolNovTipoUsuarioDrvGrupoAsociado;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioDrvPeriodicidad() {
        return this.dSSolNovTipoUsuarioDrvPeriodicidad;
    }
    
    public void setDSSolNovTipoUsuarioDrvPeriodicidad(String dSSolNovTipoUsuarioDrvPeriodicidad) {
        this.dSSolNovTipoUsuarioDrvPeriodicidad = dSSolNovTipoUsuarioDrvPeriodicidad;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioNovedadDotDrvTextoMostrar() {
        return this.dSSolNovTipoUsuarioNovedadDotDrvTextoMostrar;
    }
    
    public void setDSSolNovTipoUsuarioNovedadDotDrvTextoMostrar(String dSSolNovTipoUsuarioNovedadDotDrvTextoMostrar) {
        this.dSSolNovTipoUsuarioNovedadDotDrvTextoMostrar = dSSolNovTipoUsuarioNovedadDotDrvTextoMostrar;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioCausalDotDrvTextoMostrar() {
        return this.dSSolNovTipoUsuarioCausalDotDrvTextoMostrar;
    }
    
    public void setDSSolNovTipoUsuarioCausalDotDrvTextoMostrar(String dSSolNovTipoUsuarioCausalDotDrvTextoMostrar) {
        this.dSSolNovTipoUsuarioCausalDotDrvTextoMostrar = dSSolNovTipoUsuarioCausalDotDrvTextoMostrar;
    }

    @JsonIgnore
    public byte[] getDSSolNovTipoUsuarioFirmaDotImagenFirma() {
        return this.dSSolNovTipoUsuarioFirmaDotImagenFirma;
    }
    
    public void setDSSolNovTipoUsuarioFirmaDotImagenFirma(byte[] dSSolNovTipoUsuarioFirmaDotImagenFirma) {
        this.dSSolNovTipoUsuarioFirmaDotImagenFirma = dSSolNovTipoUsuarioFirmaDotImagenFirma;
    }

    @JsonIgnore
    public Boolean getDSSolNovTipoUsuarioCompletada() {
        return this.dSSolNovTipoUsuarioCompletada;
    }
    
    public void setDSSolNovTipoUsuarioCompletada(Boolean dSSolNovTipoUsuarioCompletada) {
        this.dSSolNovTipoUsuarioCompletada = dSSolNovTipoUsuarioCompletada;
    }

    @JsonIgnore
    public Boolean getDSSolNovTipoUsuarioDrvPermiteAddFam() {
        return this.dSSolNovTipoUsuarioDrvPermiteAddFam;
    }
    
    public void setDSSolNovTipoUsuarioDrvPermiteAddFam(Boolean dSSolNovTipoUsuarioDrvPermiteAddFam) {
        this.dSSolNovTipoUsuarioDrvPermiteAddFam = dSSolNovTipoUsuarioDrvPermiteAddFam;
    }

    @JsonIgnore
    public Boolean getDSSolNovTipoUsuarioDrvPermiteDelFam() {
        return this.dSSolNovTipoUsuarioDrvPermiteDelFam;
    }
    
    public void setDSSolNovTipoUsuarioDrvPermiteDelFam(Boolean dSSolNovTipoUsuarioDrvPermiteDelFam) {
        this.dSSolNovTipoUsuarioDrvPermiteDelFam = dSSolNovTipoUsuarioDrvPermiteDelFam;
    }

    @JsonIgnore
    public String getDSSolNovTipoUsuarioNovedadDotAliasNovedad() {
        return this.dSSolNovTipoUsuarioNovedadDotAliasNovedad;
    }
    
    public void setDSSolNovTipoUsuarioNovedadDotAliasNovedad(String dSSolNovTipoUsuarioNovedadDotAliasNovedad) {
        this.dSSolNovTipoUsuarioNovedadDotAliasNovedad = dSSolNovTipoUsuarioNovedadDotAliasNovedad;
    }
}
