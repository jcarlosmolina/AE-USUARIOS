package com.keralty.aeusuarios.viewmodel.planes.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Planes;
public class ICPlan {

    @JsonProperty("nombre")
    private String iCPlanNombre;

    public ICPlan() {
    
    }

    public ICPlan(Planes instance) {
        if (instance != null) {
            this.iCPlanNombre = instance.getPlanesNombre();
        }
    }

    @JsonIgnore
    public String getICPlanNombre() {
        return this.iCPlanNombre;
    }
    
    public void setICPlanNombre(String iCPlanNombre) {
        this.iCPlanNombre = iCPlanNombre;
    }
}
