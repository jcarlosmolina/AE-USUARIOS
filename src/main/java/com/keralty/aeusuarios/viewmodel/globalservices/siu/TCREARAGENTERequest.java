package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;

public class TCREARAGENTERequest {

    @JsonProperty("pt_p_agrrol_json")
    private String tCREARAGENTEptpagrRol;
    
    @JsonIgnore
    private Rol tCREARAGENTEptpagrRolInstance;

    @JsonProperty("pt_p_atrusuario")
    private String tCREARAGENTEptpatrUsuario;

    @JsonProperty("pt_p_atrprimernombre")
    private String tCREARAGENTEptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String tCREARAGENTEptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String tCREARAGENTEptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String tCREARAGENTEptpatrSegundoApellido;

    @JsonProperty("pt_p_agrsucursal_oid")
    private SucursalOid tCREARAGENTEptpagrSucursal;
    
    @JsonIgnore
    private Sucursal tCREARAGENTEptpagrSucursalInstance;

    @JsonProperty("pt_p_atrusuarioldap")
    private String tCREARAGENTEptpatrUsuarioLDAP;

    @JsonProperty("pt_p_atremail")
    private String tCREARAGENTEptpatrEmail;

    @JsonProperty("pt_p_agrregional_oid")
    private RegionalOid tCREARAGENTEptpagrRegional;
    
    @JsonIgnore
    private Regional tCREARAGENTEptpagrRegionalInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkTCREARAGENTEptpagrRol();
        checkTCREARAGENTEptpatrUsuario();
        checkTCREARAGENTEptpatrPrimerNombre();
        checkTCREARAGENTEptpagrSucursal();
    }

    @JsonIgnore
    public String getTCREARAGENTEptpagrRol() {
        return this.tCREARAGENTEptpagrRol;
    }
    
    public void setTCREARAGENTEptpagrRol(String tCREARAGENTEptpagrRol) {
        this.tCREARAGENTEptpagrRol = tCREARAGENTEptpagrRol;
    }

    @JsonIgnore
    public Rol getTCREARAGENTEptpagrRolInstance() {
        return this.tCREARAGENTEptpagrRolInstance;
    }
    
    public void setTCREARAGENTEptpagrRolInstance(Rol tCREARAGENTEptpagrRol) {
        this.tCREARAGENTEptpagrRolInstance = tCREARAGENTEptpagrRol;
        this.tCREARAGENTEptpagrRol = tCREARAGENTEptpagrRol != null ? tCREARAGENTEptpagrRol.getOid().toJson() : "";
    }

    private void checkTCREARAGENTEptpagrRol() throws NotNullArgumentException {
        if(this.getTCREARAGENTEptpagrRolInstance() == null || this.getTCREARAGENTEptpagrRolInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ID_TCREARAGENTE_TCREARAGENTEPTPAGRROL, GlobalServiceConstants.G_SERV_ALIAS_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ALIAS_TCREARAGENTE_TCREARAGENTEPTPAGRROL);
        }
    }

    @JsonIgnore
    public String getTCREARAGENTEptpatrUsuario() {
        return this.tCREARAGENTEptpatrUsuario;
    }
    
    public void setTCREARAGENTEptpatrUsuario(String tCREARAGENTEptpatrUsuario) {
        this.tCREARAGENTEptpatrUsuario = tCREARAGENTEptpatrUsuario;
    }

    private void checkTCREARAGENTEptpatrUsuario() throws NotNullArgumentException {
        if(this.getTCREARAGENTEptpatrUsuario() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ID_TCREARAGENTE_TCREARAGENTEPTPATRUSUARIO, GlobalServiceConstants.G_SERV_ALIAS_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ALIAS_TCREARAGENTE_TCREARAGENTEPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getTCREARAGENTEptpatrPrimerNombre() {
        return this.tCREARAGENTEptpatrPrimerNombre;
    }
    
    public void setTCREARAGENTEptpatrPrimerNombre(String tCREARAGENTEptpatrPrimerNombre) {
        this.tCREARAGENTEptpatrPrimerNombre = tCREARAGENTEptpatrPrimerNombre;
    }

    private void checkTCREARAGENTEptpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getTCREARAGENTEptpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ID_TCREARAGENTE_TCREARAGENTEPTPATRPRIMERNOMBRE, GlobalServiceConstants.G_SERV_ALIAS_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ALIAS_TCREARAGENTE_TCREARAGENTEPTPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getTCREARAGENTEptpatrSegundoNombre() {
        return this.tCREARAGENTEptpatrSegundoNombre;
    }
    
    public void setTCREARAGENTEptpatrSegundoNombre(String tCREARAGENTEptpatrSegundoNombre) {
        this.tCREARAGENTEptpatrSegundoNombre = tCREARAGENTEptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getTCREARAGENTEptpatrPrimerApellido() {
        return this.tCREARAGENTEptpatrPrimerApellido;
    }
    
    public void setTCREARAGENTEptpatrPrimerApellido(String tCREARAGENTEptpatrPrimerApellido) {
        this.tCREARAGENTEptpatrPrimerApellido = tCREARAGENTEptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getTCREARAGENTEptpatrSegundoApellido() {
        return this.tCREARAGENTEptpatrSegundoApellido;
    }
    
    public void setTCREARAGENTEptpatrSegundoApellido(String tCREARAGENTEptpatrSegundoApellido) {
        this.tCREARAGENTEptpatrSegundoApellido = tCREARAGENTEptpatrSegundoApellido;
    }

    @JsonIgnore
    public SucursalOid getTCREARAGENTEptpagrSucursal() {
        return this.tCREARAGENTEptpagrSucursal;
    }
    
    public void setTCREARAGENTEptpagrSucursal(SucursalOid tCREARAGENTEptpagrSucursal) {
        this.tCREARAGENTEptpagrSucursal = tCREARAGENTEptpagrSucursal;
    }

    @JsonIgnore
    public Sucursal getTCREARAGENTEptpagrSucursalInstance() {
        return this.tCREARAGENTEptpagrSucursalInstance;
    }
    
    public void setTCREARAGENTEptpagrSucursalInstance(Sucursal tCREARAGENTEptpagrSucursal) {
        this.tCREARAGENTEptpagrSucursalInstance = tCREARAGENTEptpagrSucursal;
        this.tCREARAGENTEptpagrSucursal = tCREARAGENTEptpagrSucursal != null ? tCREARAGENTEptpagrSucursal.getOid() : null;
    }

    private void checkTCREARAGENTEptpagrSucursal() throws NotNullArgumentException {
        if(this.getTCREARAGENTEptpagrSucursalInstance() == null || this.getTCREARAGENTEptpagrSucursalInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ID_TCREARAGENTE_TCREARAGENTEPTPAGRSUCURSAL, GlobalServiceConstants.G_SERV_ALIAS_TCREARAGENTE, GlobalServiceConstants.GS_ARG_ALIAS_TCREARAGENTE_TCREARAGENTEPTPAGRSUCURSAL);
        }
    }

    @JsonIgnore
    public String getTCREARAGENTEptpatrUsuarioLDAP() {
        return this.tCREARAGENTEptpatrUsuarioLDAP;
    }
    
    public void setTCREARAGENTEptpatrUsuarioLDAP(String tCREARAGENTEptpatrUsuarioLDAP) {
        this.tCREARAGENTEptpatrUsuarioLDAP = tCREARAGENTEptpatrUsuarioLDAP;
    }

    @JsonIgnore
    public String getTCREARAGENTEptpatrEmail() {
        return this.tCREARAGENTEptpatrEmail;
    }
    
    public void setTCREARAGENTEptpatrEmail(String tCREARAGENTEptpatrEmail) {
        this.tCREARAGENTEptpatrEmail = tCREARAGENTEptpatrEmail;
    }

    @JsonIgnore
    public RegionalOid getTCREARAGENTEptpagrRegional() {
        return this.tCREARAGENTEptpagrRegional;
    }
    
    public void setTCREARAGENTEptpagrRegional(RegionalOid tCREARAGENTEptpagrRegional) {
        this.tCREARAGENTEptpagrRegional = tCREARAGENTEptpagrRegional;
    }

    @JsonIgnore
    public Regional getTCREARAGENTEptpagrRegionalInstance() {
        return this.tCREARAGENTEptpagrRegionalInstance;
    }
    
    public void setTCREARAGENTEptpagrRegionalInstance(Regional tCREARAGENTEptpagrRegional) {
        this.tCREARAGENTEptpagrRegionalInstance = tCREARAGENTEptpagrRegional;
        this.tCREARAGENTEptpagrRegional = tCREARAGENTEptpagrRegional != null ? tCREARAGENTEptpagrRegional.getOid() : null;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
