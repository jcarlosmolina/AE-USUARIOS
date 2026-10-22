package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;

public class TGVERIFICARUSUARIORequest {

    @JsonProperty("pt_p_agrrol")
    private String tGVERIFICARUSUARIOptpagrRol;

    @JsonProperty("pt_p_atrusuario")
    private String tGVERIFICARUSUARIOptpatrUsuario;

    @JsonProperty("pprimernombre")
    private String tGVERIFICARUSUARIOpPrimerNombre;

    @JsonProperty("psegundonombre")
    private String tGVERIFICARUSUARIOpSegundoNombre;

    @JsonProperty("pprimerapellido")
    private String tGVERIFICARUSUARIOpPrimerApellido;

    @JsonProperty("psegundoapellido")
    private String tGVERIFICARUSUARIOpSegundoApellido;

    @JsonProperty("pemail")
    private String tGVERIFICARUSUARIOpEmail;

    public void checkArguments() throws NotNullArgumentException {
        checkTGVERIFICARUSUARIOptpagrRol();
        checkTGVERIFICARUSUARIOptpatrUsuario();
        checkTGVERIFICARUSUARIOpPrimerNombre();
        checkTGVERIFICARUSUARIOpPrimerApellido();
    }

    @JsonIgnore
    public String getTGVERIFICARUSUARIOptpagrRol() {
        return this.tGVERIFICARUSUARIOptpagrRol;
    }
    
    public void setTGVERIFICARUSUARIOptpagrRol(String tGVERIFICARUSUARIOptpagrRol) {
        this.tGVERIFICARUSUARIOptpagrRol = tGVERIFICARUSUARIOptpagrRol;
    }

    private void checkTGVERIFICARUSUARIOptpagrRol() throws NotNullArgumentException {
        if(this.getTGVERIFICARUSUARIOptpagrRol() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ID_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPTPAGRROL, GlobalServiceConstants.G_SERV_ALIAS_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ALIAS_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPTPAGRROL);
        }
    }

    @JsonIgnore
    public String getTGVERIFICARUSUARIOptpatrUsuario() {
        return this.tGVERIFICARUSUARIOptpatrUsuario;
    }
    
    public void setTGVERIFICARUSUARIOptpatrUsuario(String tGVERIFICARUSUARIOptpatrUsuario) {
        this.tGVERIFICARUSUARIOptpatrUsuario = tGVERIFICARUSUARIOptpatrUsuario;
    }

    private void checkTGVERIFICARUSUARIOptpatrUsuario() throws NotNullArgumentException {
        if(this.getTGVERIFICARUSUARIOptpatrUsuario() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ID_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPTPATRUSUARIO, GlobalServiceConstants.G_SERV_ALIAS_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ALIAS_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getTGVERIFICARUSUARIOpPrimerNombre() {
        return this.tGVERIFICARUSUARIOpPrimerNombre;
    }
    
    public void setTGVERIFICARUSUARIOpPrimerNombre(String tGVERIFICARUSUARIOpPrimerNombre) {
        this.tGVERIFICARUSUARIOpPrimerNombre = tGVERIFICARUSUARIOpPrimerNombre;
    }

    private void checkTGVERIFICARUSUARIOpPrimerNombre() throws NotNullArgumentException {
        if(this.getTGVERIFICARUSUARIOpPrimerNombre() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ID_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPPRIMERNOMBRE, GlobalServiceConstants.G_SERV_ALIAS_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ALIAS_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getTGVERIFICARUSUARIOpSegundoNombre() {
        return this.tGVERIFICARUSUARIOpSegundoNombre;
    }
    
    public void setTGVERIFICARUSUARIOpSegundoNombre(String tGVERIFICARUSUARIOpSegundoNombre) {
        this.tGVERIFICARUSUARIOpSegundoNombre = tGVERIFICARUSUARIOpSegundoNombre;
    }

    @JsonIgnore
    public String getTGVERIFICARUSUARIOpPrimerApellido() {
        return this.tGVERIFICARUSUARIOpPrimerApellido;
    }
    
    public void setTGVERIFICARUSUARIOpPrimerApellido(String tGVERIFICARUSUARIOpPrimerApellido) {
        this.tGVERIFICARUSUARIOpPrimerApellido = tGVERIFICARUSUARIOpPrimerApellido;
    }

    private void checkTGVERIFICARUSUARIOpPrimerApellido() throws NotNullArgumentException {
        if(this.getTGVERIFICARUSUARIOpPrimerApellido() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ID_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPPRIMERAPELLIDO, GlobalServiceConstants.G_SERV_ALIAS_TGVERIFICARUSUARIO, GlobalServiceConstants.GS_ARG_ALIAS_TGVERIFICARUSUARIO_TGVERIFICARUSUARIOPPRIMERAPELLIDO);
        }
    }

    @JsonIgnore
    public String getTGVERIFICARUSUARIOpSegundoApellido() {
        return this.tGVERIFICARUSUARIOpSegundoApellido;
    }
    
    public void setTGVERIFICARUSUARIOpSegundoApellido(String tGVERIFICARUSUARIOpSegundoApellido) {
        this.tGVERIFICARUSUARIOpSegundoApellido = tGVERIFICARUSUARIOpSegundoApellido;
    }

    @JsonIgnore
    public String getTGVERIFICARUSUARIOpEmail() {
        return this.tGVERIFICARUSUARIOpEmail;
    }
    
    public void setTGVERIFICARUSUARIOpEmail(String tGVERIFICARUSUARIOpEmail) {
        this.tGVERIFICARUSUARIOpEmail = tGVERIFICARUSUARIOpEmail;
    }
}
