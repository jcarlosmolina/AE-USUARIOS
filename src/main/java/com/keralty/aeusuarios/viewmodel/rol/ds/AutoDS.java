package com.keralty.aeusuarios.viewmodel.rol.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Rol;
public class AutoDS {

    @JsonProperty("identificador")
    private Long autoDSIdentificador;

    @JsonProperty("nombre")
    private String autoDSNombre;

    public AutoDS() {
    
    }

    public AutoDS(Rol instance) {
        if (instance != null) {
            this.autoDSIdentificador = instance.getRolIdentificador();
            this.autoDSNombre = instance.getRolNombre();
        }
    }

    @JsonIgnore
    public Long getAutoDSIdentificador() {
        return this.autoDSIdentificador;
    }
    
    public void setAutoDSIdentificador(Long autoDSIdentificador) {
        this.autoDSIdentificador = autoDSIdentificador;
    }

    @JsonIgnore
    public String getAutoDSNombre() {
        return this.autoDSNombre;
    }
    
    public void setAutoDSNombre(String autoDSNombre) {
        this.autoDSNombre = autoDSNombre;
    }
}
