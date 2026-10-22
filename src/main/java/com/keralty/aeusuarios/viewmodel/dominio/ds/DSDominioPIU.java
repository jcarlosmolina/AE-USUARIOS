package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioPIU {

    @JsonProperty("productot_descripcion")
    private String dSDominioPIUProductoTDotDescripcion;

    @JsonProperty("plant_nombre")
    private String dSDominioPIUPlanTDotNombre;

    @JsonProperty("nuevaafiliacion")
    private Boolean dSDominioPIUNuevaAfiliacion;

    @JsonProperty("inclusion")
    private Boolean dSDominioPIUInclusion;

    @JsonProperty("reqcuesmed")
    private Boolean dSDominioPIUReqCuesMed;

    @JsonProperty("nocuesmedtras")
    private Boolean dSDominioPIUNoCuesMedTras;

    @JsonProperty("acepcuesmat")
    private Boolean dSDominioPIUAcepCuesMat;

    @JsonProperty("acepcuesneo")
    private Boolean dSDominioPIUAcepCuesNeo;

    @JsonProperty("acepbbgestante")
    private Boolean dSDominioPIUAcepBBGestante;

    public DSDominioPIU() {
    
    }

    public DSDominioPIU(Dominio instance) {
        if (instance != null) {
            try {
                this.dSDominioPIUProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSDominioPIUPlanTDotNombre = instance.getPlanT().getPlanesNombre();
                this.dSDominioPIUNuevaAfiliacion = instance.getDominioNuevaAfiliacion();
                this.dSDominioPIUInclusion = instance.getDominioInclusion();
                this.dSDominioPIUReqCuesMed = instance.getDominioReqCuesMed();
                this.dSDominioPIUNoCuesMedTras = instance.getDominioNoCuesMedTras();
                this.dSDominioPIUAcepCuesMat = instance.getDominioAcepCuesMat();
                this.dSDominioPIUAcepCuesNeo = instance.getDominioAcepCuesNeo();
                this.dSDominioPIUAcepBBGestante = instance.getDominioAcepBBGestante();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSDominioPIUProductoTDotDescripcion() {
        return this.dSDominioPIUProductoTDotDescripcion;
    }
    
    public void setDSDominioPIUProductoTDotDescripcion(String dSDominioPIUProductoTDotDescripcion) {
        this.dSDominioPIUProductoTDotDescripcion = dSDominioPIUProductoTDotDescripcion;
    }

    @JsonIgnore
    public String getDSDominioPIUPlanTDotNombre() {
        return this.dSDominioPIUPlanTDotNombre;
    }
    
    public void setDSDominioPIUPlanTDotNombre(String dSDominioPIUPlanTDotNombre) {
        this.dSDominioPIUPlanTDotNombre = dSDominioPIUPlanTDotNombre;
    }

    @JsonIgnore
    public Boolean getDSDominioPIUNuevaAfiliacion() {
        return this.dSDominioPIUNuevaAfiliacion;
    }
    
    public void setDSDominioPIUNuevaAfiliacion(Boolean dSDominioPIUNuevaAfiliacion) {
        this.dSDominioPIUNuevaAfiliacion = dSDominioPIUNuevaAfiliacion;
    }

    @JsonIgnore
    public Boolean getDSDominioPIUInclusion() {
        return this.dSDominioPIUInclusion;
    }
    
    public void setDSDominioPIUInclusion(Boolean dSDominioPIUInclusion) {
        this.dSDominioPIUInclusion = dSDominioPIUInclusion;
    }

    @JsonIgnore
    public Boolean getDSDominioPIUReqCuesMed() {
        return this.dSDominioPIUReqCuesMed;
    }
    
    public void setDSDominioPIUReqCuesMed(Boolean dSDominioPIUReqCuesMed) {
        this.dSDominioPIUReqCuesMed = dSDominioPIUReqCuesMed;
    }

    @JsonIgnore
    public Boolean getDSDominioPIUNoCuesMedTras() {
        return this.dSDominioPIUNoCuesMedTras;
    }
    
    public void setDSDominioPIUNoCuesMedTras(Boolean dSDominioPIUNoCuesMedTras) {
        this.dSDominioPIUNoCuesMedTras = dSDominioPIUNoCuesMedTras;
    }

    @JsonIgnore
    public Boolean getDSDominioPIUAcepCuesMat() {
        return this.dSDominioPIUAcepCuesMat;
    }
    
    public void setDSDominioPIUAcepCuesMat(Boolean dSDominioPIUAcepCuesMat) {
        this.dSDominioPIUAcepCuesMat = dSDominioPIUAcepCuesMat;
    }

    @JsonIgnore
    public Boolean getDSDominioPIUAcepCuesNeo() {
        return this.dSDominioPIUAcepCuesNeo;
    }
    
    public void setDSDominioPIUAcepCuesNeo(Boolean dSDominioPIUAcepCuesNeo) {
        this.dSDominioPIUAcepCuesNeo = dSDominioPIUAcepCuesNeo;
    }

    @JsonIgnore
    public Boolean getDSDominioPIUAcepBBGestante() {
        return this.dSDominioPIUAcepBBGestante;
    }
    
    public void setDSDominioPIUAcepBBGestante(Boolean dSDominioPIUAcepBBGestante) {
        this.dSDominioPIUAcepBBGestante = dSDominioPIUAcepBBGestante;
    }
}
