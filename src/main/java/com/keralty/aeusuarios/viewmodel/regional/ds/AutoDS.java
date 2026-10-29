package com.keralty.aeusuarios.viewmodel.regional.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Regional;
public class AutoDS {

    @JsonProperty("codigo")
    private Long autoDSCodigo;

    @JsonProperty("descripcion")
    private String autoDSDescripcion;

    public AutoDS() {
    
    }

    public AutoDS(Regional instance) {
        if (instance != null) {
            this.autoDSCodigo = instance.getRegionalCodigo();
            this.autoDSDescripcion = instance.getRegionalDescripcion();
        }
    }

    @JsonIgnore
    public Long getAutoDSCodigo() {
        return this.autoDSCodigo;
    }
    
    public void setAutoDSCodigo(Long autoDSCodigo) {
        this.autoDSCodigo = autoDSCodigo;
    }

    @JsonIgnore
    public String getAutoDSDescripcion() {
        return this.autoDSDescripcion;
    }
    
    public void setAutoDSDescripcion(String autoDSDescripcion) {
        this.autoDSDescripcion = autoDSDescripcion;
    }
}
