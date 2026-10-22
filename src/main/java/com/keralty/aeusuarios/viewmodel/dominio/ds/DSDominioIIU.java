package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioIIU {

    @JsonProperty("productot_descripcion")
    private String dSDominioIIUProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSDominioIIUPlanTDotNombre;

    @JsonProperty("nuevaafiliacion")
    private Boolean dSDominioIIUNuevaAfiliacion;

    @JsonProperty("inclusion")
    private Boolean dSDominioIIUInclusion;

    @JsonProperty("inclusionmodgrupoasoc")
    private Boolean dSDominioIIUInclusionModGrupoAsoc;

    @JsonProperty("reqcuesmed")
    private Boolean dSDominioIIUReqCuesMed;

    @JsonProperty("nocuesmedtras")
    private Boolean dSDominioIIUNoCuesMedTras;

    @JsonProperty("acepcuesmat")
    private Boolean dSDominioIIUAcepCuesMat;

    @JsonProperty("acepcuesneo")
    private Boolean dSDominioIIUAcepCuesNeo;

    @JsonProperty("acepbbgestante")
    private Boolean dSDominioIIUAcepBBGestante;

    @JsonProperty("ignorarpreexistencias")
    private Boolean dSDominioIIUIgnorarPreexistencias;

    @JsonProperty("prorrateousuexistente")
    private Boolean dSDominioIIUProrrateoUsuExistente;

    @JsonProperty("diainivigencia")
    private Long dSDominioIIUDiaIniVigencia;

    @JsonProperty("diafinvigencia")
    private Long dSDominioIIUDiaFinVigencia;

    @JsonProperty("diascaducidad")
    private Long dSDominioIIUDiasCaducidad;

    @JsonProperty("permiterechazadosafi")
    private Boolean dSDominioIIUPermiteRechazadosAfi;

    @JsonProperty("aceppolizainter")
    private Boolean dSDominioIIUAcepPolizaInter;

    @JsonProperty("mostrarpreexanexos")
    private Boolean dSDominioIIUMostrarPreexAnexos;

    @JsonProperty("mostrarpreexcontrato")
    private Boolean dSDominioIIUMostrarPreexContrato;

    @JsonProperty("tramiteenlinea")
    private Boolean dSDominioIIUTramiteEnLinea;

    @JsonProperty("vigenciaradicacion")
    private Boolean dSDominioIIUVigenciaRadicacion;

    public DSDominioIIU() {
    
    }

    public DSDominioIIU(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominioIIUProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSDominioIIUPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSDominioIIUNuevaAfiliacion = instance.getDominioNuevaAfiliacion();
                this.dSDominioIIUInclusion = instance.getDominioInclusion();
                this.dSDominioIIUInclusionModGrupoAsoc = instance.getDominioInclusionModGrupoAsoc();
                this.dSDominioIIUReqCuesMed = instance.getDominioReqCuesMed();
                this.dSDominioIIUNoCuesMedTras = instance.getDominioNoCuesMedTras();
                this.dSDominioIIUAcepCuesMat = instance.getDominioAcepCuesMat();
                this.dSDominioIIUAcepCuesNeo = instance.getDominioAcepCuesNeo();
                this.dSDominioIIUAcepBBGestante = instance.getDominioAcepBBGestante();
                this.dSDominioIIUIgnorarPreexistencias = instance.getDominioIgnorarPreexistencias();
                this.dSDominioIIUProrrateoUsuExistente = instance.getDominioProrrateoUsuExistente();
                this.dSDominioIIUDiaIniVigencia = instance.getDominioDiaIniVigencia();
                this.dSDominioIIUDiaFinVigencia = instance.getDominioDiaFinVigencia();
                this.dSDominioIIUDiasCaducidad = instance.getDominioDiasCaducidad();
                this.dSDominioIIUPermiteRechazadosAfi = instance.getDominioPermiteRechazadosAfi();
                this.dSDominioIIUAcepPolizaInter = instance.getDominioAcepPolizaInter();
                this.dSDominioIIUMostrarPreexAnexos = instance.getDominioMostrarPreexAnexos();
                this.dSDominioIIUMostrarPreexContrato = instance.getDominioMostrarPreexContrato();
                this.dSDominioIIUTramiteEnLinea = instance.getDominioTramiteEnLinea();
                this.dSDominioIIUVigenciaRadicacion = instance.getDominioVigenciaRadicacion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSDominioIIUProductoTDotDescripcion() {
        return this.dSDominioIIUProductoTDotDescripcion;
    }
    
    public void setDSDominioIIUProductoTDotDescripcion(String dSDominioIIUProductoTDotDescripcion) {
        this.dSDominioIIUProductoTDotDescripcion = dSDominioIIUProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSDominioIIUPlanTDotNombre() {
        return this.dSDominioIIUPlanTDotNombre;
    }
    
    public void setDSDominioIIUPlanTDotNombre(String dSDominioIIUPlanTDotNombre) {
        this.dSDominioIIUPlanTDotNombre = dSDominioIIUPlanTDotNombre;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUNuevaAfiliacion() {
        return this.dSDominioIIUNuevaAfiliacion;
    }
    
    public void setDSDominioIIUNuevaAfiliacion(Boolean dSDominioIIUNuevaAfiliacion) {
        this.dSDominioIIUNuevaAfiliacion = dSDominioIIUNuevaAfiliacion;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUInclusion() {
        return this.dSDominioIIUInclusion;
    }
    
    public void setDSDominioIIUInclusion(Boolean dSDominioIIUInclusion) {
        this.dSDominioIIUInclusion = dSDominioIIUInclusion;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUInclusionModGrupoAsoc() {
        return this.dSDominioIIUInclusionModGrupoAsoc;
    }
    
    public void setDSDominioIIUInclusionModGrupoAsoc(Boolean dSDominioIIUInclusionModGrupoAsoc) {
        this.dSDominioIIUInclusionModGrupoAsoc = dSDominioIIUInclusionModGrupoAsoc;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUReqCuesMed() {
        return this.dSDominioIIUReqCuesMed;
    }
    
    public void setDSDominioIIUReqCuesMed(Boolean dSDominioIIUReqCuesMed) {
        this.dSDominioIIUReqCuesMed = dSDominioIIUReqCuesMed;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUNoCuesMedTras() {
        return this.dSDominioIIUNoCuesMedTras;
    }
    
    public void setDSDominioIIUNoCuesMedTras(Boolean dSDominioIIUNoCuesMedTras) {
        this.dSDominioIIUNoCuesMedTras = dSDominioIIUNoCuesMedTras;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUAcepCuesMat() {
        return this.dSDominioIIUAcepCuesMat;
    }
    
    public void setDSDominioIIUAcepCuesMat(Boolean dSDominioIIUAcepCuesMat) {
        this.dSDominioIIUAcepCuesMat = dSDominioIIUAcepCuesMat;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUAcepCuesNeo() {
        return this.dSDominioIIUAcepCuesNeo;
    }
    
    public void setDSDominioIIUAcepCuesNeo(Boolean dSDominioIIUAcepCuesNeo) {
        this.dSDominioIIUAcepCuesNeo = dSDominioIIUAcepCuesNeo;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUAcepBBGestante() {
        return this.dSDominioIIUAcepBBGestante;
    }
    
    public void setDSDominioIIUAcepBBGestante(Boolean dSDominioIIUAcepBBGestante) {
        this.dSDominioIIUAcepBBGestante = dSDominioIIUAcepBBGestante;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUIgnorarPreexistencias() {
        return this.dSDominioIIUIgnorarPreexistencias;
    }
    
    public void setDSDominioIIUIgnorarPreexistencias(Boolean dSDominioIIUIgnorarPreexistencias) {
        this.dSDominioIIUIgnorarPreexistencias = dSDominioIIUIgnorarPreexistencias;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUProrrateoUsuExistente() {
        return this.dSDominioIIUProrrateoUsuExistente;
    }
    
    public void setDSDominioIIUProrrateoUsuExistente(Boolean dSDominioIIUProrrateoUsuExistente) {
        this.dSDominioIIUProrrateoUsuExistente = dSDominioIIUProrrateoUsuExistente;
    }

    @JsonIgnore
    public Long getDSDominioIIUDiaIniVigencia() {
        return this.dSDominioIIUDiaIniVigencia;
    }
    
    public void setDSDominioIIUDiaIniVigencia(Long dSDominioIIUDiaIniVigencia) {
        this.dSDominioIIUDiaIniVigencia = dSDominioIIUDiaIniVigencia;
    }

    @JsonIgnore
    public Long getDSDominioIIUDiaFinVigencia() {
        return this.dSDominioIIUDiaFinVigencia;
    }
    
    public void setDSDominioIIUDiaFinVigencia(Long dSDominioIIUDiaFinVigencia) {
        this.dSDominioIIUDiaFinVigencia = dSDominioIIUDiaFinVigencia;
    }

    @JsonIgnore
    public Long getDSDominioIIUDiasCaducidad() {
        return this.dSDominioIIUDiasCaducidad;
    }
    
    public void setDSDominioIIUDiasCaducidad(Long dSDominioIIUDiasCaducidad) {
        this.dSDominioIIUDiasCaducidad = dSDominioIIUDiasCaducidad;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUPermiteRechazadosAfi() {
        return this.dSDominioIIUPermiteRechazadosAfi;
    }
    
    public void setDSDominioIIUPermiteRechazadosAfi(Boolean dSDominioIIUPermiteRechazadosAfi) {
        this.dSDominioIIUPermiteRechazadosAfi = dSDominioIIUPermiteRechazadosAfi;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUAcepPolizaInter() {
        return this.dSDominioIIUAcepPolizaInter;
    }
    
    public void setDSDominioIIUAcepPolizaInter(Boolean dSDominioIIUAcepPolizaInter) {
        this.dSDominioIIUAcepPolizaInter = dSDominioIIUAcepPolizaInter;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUMostrarPreexAnexos() {
        return this.dSDominioIIUMostrarPreexAnexos;
    }
    
    public void setDSDominioIIUMostrarPreexAnexos(Boolean dSDominioIIUMostrarPreexAnexos) {
        this.dSDominioIIUMostrarPreexAnexos = dSDominioIIUMostrarPreexAnexos;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUMostrarPreexContrato() {
        return this.dSDominioIIUMostrarPreexContrato;
    }
    
    public void setDSDominioIIUMostrarPreexContrato(Boolean dSDominioIIUMostrarPreexContrato) {
        this.dSDominioIIUMostrarPreexContrato = dSDominioIIUMostrarPreexContrato;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUTramiteEnLinea() {
        return this.dSDominioIIUTramiteEnLinea;
    }
    
    public void setDSDominioIIUTramiteEnLinea(Boolean dSDominioIIUTramiteEnLinea) {
        this.dSDominioIIUTramiteEnLinea = dSDominioIIUTramiteEnLinea;
    }

    @JsonIgnore
    public Boolean getDSDominioIIUVigenciaRadicacion() {
        return this.dSDominioIIUVigenciaRadicacion;
    }
    
    public void setDSDominioIIUVigenciaRadicacion(Boolean dSDominioIIUVigenciaRadicacion) {
        this.dSDominioIIUVigenciaRadicacion = dSDominioIIUVigenciaRadicacion;
    }
}
