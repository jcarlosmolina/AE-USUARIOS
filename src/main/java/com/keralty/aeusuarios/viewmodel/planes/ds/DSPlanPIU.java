package com.keralty.aeusuarios.viewmodel.planes.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Planes;
public class DSPlanPIU {

    @JsonProperty("productot_descripcion")
    private String dSPlanPIUProductoTDotDescripcion;

    @JsonProperty("plan")
    private Long dSPlanPIUPlan;

    @JsonProperty("nombre")
    private String dSPlanPIUNombre;

    @JsonProperty("esbancorep")
    private Boolean dSPlanPIUEsBancoRep;

    @JsonProperty("aceptapreexistencias")
    private Boolean dSPlanPIUAceptaPreexistencias;

    @JsonProperty("esvoluntario")
    private Boolean dSPlanPIUEsVoluntario;

    @JsonProperty("iniciocontdiauno")
    private Boolean dSPlanPIUInicioContDiaUno;

    public DSPlanPIU() {
    
    }

    public DSPlanPIU(Planes instance) {
        if (instance != null) {
            try {
                this.dSPlanPIUProductoTDotDescripcion = instance.getProductoT().getProductosDescripcion();
                this.dSPlanPIUPlan = instance.getPlanesPlan();
                this.dSPlanPIUNombre = instance.getPlanesNombre();
                this.dSPlanPIUEsBancoRep = instance.getPlanesEsBancoRep();
                this.dSPlanPIUAceptaPreexistencias = instance.getPlanesAceptaPreexistencias();
                this.dSPlanPIUEsVoluntario = instance.getPlanesEsVoluntario();
                this.dSPlanPIUInicioContDiaUno = instance.getPlanesInicioContDiaUno();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSPlanPIUProductoTDotDescripcion() {
        return this.dSPlanPIUProductoTDotDescripcion;
    }
    
    public void setDSPlanPIUProductoTDotDescripcion(String dSPlanPIUProductoTDotDescripcion) {
        this.dSPlanPIUProductoTDotDescripcion = dSPlanPIUProductoTDotDescripcion;
    }

    @JsonIgnore
    public Long getDSPlanPIUPlan() {
        return this.dSPlanPIUPlan;
    }
    
    public void setDSPlanPIUPlan(Long dSPlanPIUPlan) {
        this.dSPlanPIUPlan = dSPlanPIUPlan;
    }

    @JsonIgnore
    public String getDSPlanPIUNombre() {
        return this.dSPlanPIUNombre;
    }
    
    public void setDSPlanPIUNombre(String dSPlanPIUNombre) {
        this.dSPlanPIUNombre = dSPlanPIUNombre;
    }

    @JsonIgnore
    public Boolean getDSPlanPIUEsBancoRep() {
        return this.dSPlanPIUEsBancoRep;
    }
    
    public void setDSPlanPIUEsBancoRep(Boolean dSPlanPIUEsBancoRep) {
        this.dSPlanPIUEsBancoRep = dSPlanPIUEsBancoRep;
    }

    @JsonIgnore
    public Boolean getDSPlanPIUAceptaPreexistencias() {
        return this.dSPlanPIUAceptaPreexistencias;
    }
    
    public void setDSPlanPIUAceptaPreexistencias(Boolean dSPlanPIUAceptaPreexistencias) {
        this.dSPlanPIUAceptaPreexistencias = dSPlanPIUAceptaPreexistencias;
    }

    @JsonIgnore
    public Boolean getDSPlanPIUEsVoluntario() {
        return this.dSPlanPIUEsVoluntario;
    }
    
    public void setDSPlanPIUEsVoluntario(Boolean dSPlanPIUEsVoluntario) {
        this.dSPlanPIUEsVoluntario = dSPlanPIUEsVoluntario;
    }

    @JsonIgnore
    public Boolean getDSPlanPIUInicioContDiaUno() {
        return this.dSPlanPIUInicioContDiaUno;
    }
    
    public void setDSPlanPIUInicioContDiaUno(Boolean dSPlanPIUInicioContDiaUno) {
        this.dSPlanPIUInicioContDiaUno = dSPlanPIUInicioContDiaUno;
    }
}
