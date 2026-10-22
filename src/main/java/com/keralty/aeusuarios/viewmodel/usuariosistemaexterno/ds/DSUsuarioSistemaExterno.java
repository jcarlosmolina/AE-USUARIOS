package com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;
public class DSUsuarioSistemaExterno {

    @JsonProperty("login")
    private String dSUsuarioSistemaExternoLogin;

    @JsonProperty("descripcion")
    private String dSUsuarioSistemaExternoDescripcion;

    public DSUsuarioSistemaExterno() {
    
    }

    public DSUsuarioSistemaExterno(UsuarioSistemaExterno instance) {
        if (instance != null) {
            this.dSUsuarioSistemaExternoLogin = instance.getUsuarioSistemaExternoLogin();
            this.dSUsuarioSistemaExternoDescripcion = instance.getUsuarioSistemaExternoDescripcion();
        }
    }

    @JsonIgnore
    public String getDSUsuarioSistemaExternoLogin() {
        return this.dSUsuarioSistemaExternoLogin;
    }
    
    public void setDSUsuarioSistemaExternoLogin(String dSUsuarioSistemaExternoLogin) {
        this.dSUsuarioSistemaExternoLogin = dSUsuarioSistemaExternoLogin;
    }

    @JsonIgnore
    public String getDSUsuarioSistemaExternoDescripcion() {
        return this.dSUsuarioSistemaExternoDescripcion;
    }
    
    public void setDSUsuarioSistemaExternoDescripcion(String dSUsuarioSistemaExternoDescripcion) {
        this.dSUsuarioSistemaExternoDescripcion = dSUsuarioSistemaExternoDescripcion;
    }
}
