package com.keralty.aeusuarios.viewmodel.regional.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Regional;
public class ICRegional {

    @JsonProperty("descripcion")
    private String iCRegionalDescripcion;

    public ICRegional() {
    
    }

    public ICRegional(Regional instance) {
        if (instance != null) {
            this.iCRegionalDescripcion = instance.getRegionalDescripcion();
        }
    }

    @JsonIgnore
    public String getICRegionalDescripcion() {
        return this.iCRegionalDescripcion;
    }
    
    public void setICRegionalDescripcion(String iCRegionalDescripcion) {
        this.iCRegionalDescripcion = iCRegionalDescripcion;
    }
}
