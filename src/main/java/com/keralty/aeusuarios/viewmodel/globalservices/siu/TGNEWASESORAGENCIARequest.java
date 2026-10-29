package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class TGNEWASESORAGENCIARequest {

    @JsonProperty("pt_p_agrsucursal_oid")
    private SucursalOid tGNEWASESORAGENCIAptpagrSucursal;
    
    @JsonIgnore
    private Sucursal tGNEWASESORAGENCIAptpagrSucursalInstance;

    @JsonProperty("pt_p_atrusuario")
    private String tGNEWASESORAGENCIAptpatrUsuario;

    @JsonProperty("pt_p_atrprimernombre")
    private String tGNEWASESORAGENCIAptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String tGNEWASESORAGENCIAptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String tGNEWASESORAGENCIAptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String tGNEWASESORAGENCIAptpatrSegundoApellido;

    @JsonProperty("pt_p_atrusuarioldap")
    private String tGNEWASESORAGENCIAptpatrUsuarioLDAP;

    @JsonProperty("pt_p_atremail")
    private String tGNEWASESORAGENCIAptpatrEmail;

    @JsonProperty("pt_p_agrtipoidentificacion_json")
    private String tGNEWASESORAGENCIAptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tGNEWASESORAGENCIAptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrmodificadirector")
    private Boolean tGNEWASESORAGENCIAptpatrmodificaDirector;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String tGNEWASESORAGENCIAptpatrNumIdentificacion;

    @JsonProperty("pt_p_atrmoddbasicospersona")
    private Boolean tGNEWASESORAGENCIAptpatrModDBasicosPersona;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkTGNEWASESORAGENCIAptpagrSucursal();
        checkTGNEWASESORAGENCIAptpatrUsuario();
        checkTGNEWASESORAGENCIAptpatrPrimerNombre();
        checkTGNEWASESORAGENCIAptpatrmodificaDirector();
        checkTGNEWASESORAGENCIAptpatrModDBasicosPersona();
    }

    @JsonIgnore
    public SucursalOid getTGNEWASESORAGENCIAptpagrSucursal() {
        return this.tGNEWASESORAGENCIAptpagrSucursal;
    }
    
    public void setTGNEWASESORAGENCIAptpagrSucursal(SucursalOid tGNEWASESORAGENCIAptpagrSucursal) {
        this.tGNEWASESORAGENCIAptpagrSucursal = tGNEWASESORAGENCIAptpagrSucursal;
    }

    @JsonIgnore
    public Sucursal getTGNEWASESORAGENCIAptpagrSucursalInstance() {
        return this.tGNEWASESORAGENCIAptpagrSucursalInstance;
    }
    
    public void setTGNEWASESORAGENCIAptpagrSucursalInstance(Sucursal tGNEWASESORAGENCIAptpagrSucursal) {
        this.tGNEWASESORAGENCIAptpagrSucursalInstance = tGNEWASESORAGENCIAptpagrSucursal;
        this.tGNEWASESORAGENCIAptpagrSucursal = tGNEWASESORAGENCIAptpagrSucursal != null ? tGNEWASESORAGENCIAptpagrSucursal.getOid() : null;
    }

    private void checkTGNEWASESORAGENCIAptpagrSucursal() throws NotNullArgumentException {
        if(this.getTGNEWASESORAGENCIAptpagrSucursalInstance() == null || this.getTGNEWASESORAGENCIAptpagrSucursalInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPAGRSUCURSAL, GlobalServiceConstants.G_SERV_ALIAS_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPAGRSUCURSAL);
        }
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrUsuario() {
        return this.tGNEWASESORAGENCIAptpatrUsuario;
    }
    
    public void setTGNEWASESORAGENCIAptpatrUsuario(String tGNEWASESORAGENCIAptpatrUsuario) {
        this.tGNEWASESORAGENCIAptpatrUsuario = tGNEWASESORAGENCIAptpatrUsuario;
    }

    private void checkTGNEWASESORAGENCIAptpatrUsuario() throws NotNullArgumentException {
        if(this.getTGNEWASESORAGENCIAptpatrUsuario() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRUSUARIO, GlobalServiceConstants.G_SERV_ALIAS_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrPrimerNombre() {
        return this.tGNEWASESORAGENCIAptpatrPrimerNombre;
    }
    
    public void setTGNEWASESORAGENCIAptpatrPrimerNombre(String tGNEWASESORAGENCIAptpatrPrimerNombre) {
        this.tGNEWASESORAGENCIAptpatrPrimerNombre = tGNEWASESORAGENCIAptpatrPrimerNombre;
    }

    private void checkTGNEWASESORAGENCIAptpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getTGNEWASESORAGENCIAptpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRPRIMERNOMBRE, GlobalServiceConstants.G_SERV_ALIAS_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrSegundoNombre() {
        return this.tGNEWASESORAGENCIAptpatrSegundoNombre;
    }
    
    public void setTGNEWASESORAGENCIAptpatrSegundoNombre(String tGNEWASESORAGENCIAptpatrSegundoNombre) {
        this.tGNEWASESORAGENCIAptpatrSegundoNombre = tGNEWASESORAGENCIAptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrPrimerApellido() {
        return this.tGNEWASESORAGENCIAptpatrPrimerApellido;
    }
    
    public void setTGNEWASESORAGENCIAptpatrPrimerApellido(String tGNEWASESORAGENCIAptpatrPrimerApellido) {
        this.tGNEWASESORAGENCIAptpatrPrimerApellido = tGNEWASESORAGENCIAptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrSegundoApellido() {
        return this.tGNEWASESORAGENCIAptpatrSegundoApellido;
    }
    
    public void setTGNEWASESORAGENCIAptpatrSegundoApellido(String tGNEWASESORAGENCIAptpatrSegundoApellido) {
        this.tGNEWASESORAGENCIAptpatrSegundoApellido = tGNEWASESORAGENCIAptpatrSegundoApellido;
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrUsuarioLDAP() {
        return this.tGNEWASESORAGENCIAptpatrUsuarioLDAP;
    }
    
    public void setTGNEWASESORAGENCIAptpatrUsuarioLDAP(String tGNEWASESORAGENCIAptpatrUsuarioLDAP) {
        this.tGNEWASESORAGENCIAptpatrUsuarioLDAP = tGNEWASESORAGENCIAptpatrUsuarioLDAP;
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrEmail() {
        return this.tGNEWASESORAGENCIAptpatrEmail;
    }
    
    public void setTGNEWASESORAGENCIAptpatrEmail(String tGNEWASESORAGENCIAptpatrEmail) {
        this.tGNEWASESORAGENCIAptpatrEmail = tGNEWASESORAGENCIAptpatrEmail;
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpagrTipoIdentificacion() {
        return this.tGNEWASESORAGENCIAptpagrTipoIdentificacion;
    }
    
    public void setTGNEWASESORAGENCIAptpagrTipoIdentificacion(String tGNEWASESORAGENCIAptpagrTipoIdentificacion) {
        this.tGNEWASESORAGENCIAptpagrTipoIdentificacion = tGNEWASESORAGENCIAptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTGNEWASESORAGENCIAptpagrTipoIdentificacionInstance() {
        return this.tGNEWASESORAGENCIAptpagrTipoIdentificacionInstance;
    }
    
    public void setTGNEWASESORAGENCIAptpagrTipoIdentificacionInstance(TipoIdentificacion tGNEWASESORAGENCIAptpagrTipoIdentificacion) {
        this.tGNEWASESORAGENCIAptpagrTipoIdentificacionInstance = tGNEWASESORAGENCIAptpagrTipoIdentificacion;
        this.tGNEWASESORAGENCIAptpagrTipoIdentificacion = tGNEWASESORAGENCIAptpagrTipoIdentificacion != null ? tGNEWASESORAGENCIAptpagrTipoIdentificacion.getOid().toJson() : "";
    }

    @JsonIgnore
    public Boolean getTGNEWASESORAGENCIAptpatrmodificaDirector() {
        return this.tGNEWASESORAGENCIAptpatrmodificaDirector;
    }
    
    public void setTGNEWASESORAGENCIAptpatrmodificaDirector(Boolean tGNEWASESORAGENCIAptpatrmodificaDirector) {
        this.tGNEWASESORAGENCIAptpatrmodificaDirector = tGNEWASESORAGENCIAptpatrmodificaDirector;
    }

    private void checkTGNEWASESORAGENCIAptpatrmodificaDirector() throws NotNullArgumentException {
        if(this.getTGNEWASESORAGENCIAptpatrmodificaDirector() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRMODIFICADIRECTOR, GlobalServiceConstants.G_SERV_ALIAS_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRMODIFICADIRECTOR);
        }
    }

    @JsonIgnore
    public String getTGNEWASESORAGENCIAptpatrNumIdentificacion() {
        return this.tGNEWASESORAGENCIAptpatrNumIdentificacion;
    }
    
    public void setTGNEWASESORAGENCIAptpatrNumIdentificacion(String tGNEWASESORAGENCIAptpatrNumIdentificacion) {
        this.tGNEWASESORAGENCIAptpatrNumIdentificacion = tGNEWASESORAGENCIAptpatrNumIdentificacion;
    }

    @JsonIgnore
    public Boolean getTGNEWASESORAGENCIAptpatrModDBasicosPersona() {
        return this.tGNEWASESORAGENCIAptpatrModDBasicosPersona;
    }
    
    public void setTGNEWASESORAGENCIAptpatrModDBasicosPersona(Boolean tGNEWASESORAGENCIAptpatrModDBasicosPersona) {
        this.tGNEWASESORAGENCIAptpatrModDBasicosPersona = tGNEWASESORAGENCIAptpatrModDBasicosPersona;
    }

    private void checkTGNEWASESORAGENCIAptpatrModDBasicosPersona() throws NotNullArgumentException {
        if(this.getTGNEWASESORAGENCIAptpatrModDBasicosPersona() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRMODDBASICOSPERSONA, GlobalServiceConstants.G_SERV_ALIAS_TGNEWASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGNEWASESORAGENCIA_TGNEWASESORAGENCIAPTPATRMODDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
