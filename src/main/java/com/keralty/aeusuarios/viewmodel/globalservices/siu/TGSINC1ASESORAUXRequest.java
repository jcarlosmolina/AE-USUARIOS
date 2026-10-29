package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class TGSINC1ASESORAUXRequest {

    @JsonProperty("pt_p_agrsucursal_oid")
    private SucursalOid tGSINC1ASESORAUXptpagrSucursal;
    
    @JsonIgnore
    private Sucursal tGSINC1ASESORAUXptpagrSucursalInstance;

    @JsonProperty("pt_p_atrusuario")
    private String tGSINC1ASESORAUXptpatrUsuario;

    @JsonProperty("pt_p_atrprimernombre")
    private String tGSINC1ASESORAUXptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String tGSINC1ASESORAUXptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String tGSINC1ASESORAUXptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String tGSINC1ASESORAUXptpatrSegundoApellido;

    @JsonProperty("pt_p_atremail")
    private String tGSINC1ASESORAUXptpatrEmail;

    @JsonProperty("pcoddirector")
    private String tGSINC1ASESORAUXpCodDirector;

    @JsonProperty("p_tipoidentificacion_oid")
    private TipoIdentificacionOid tGSINC1ASESORAUXpTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tGSINC1ASESORAUXpTipoIdentificacionInstance;

    @JsonProperty("p_numidentificacion")
    private String tGSINC1ASESORAUXpNumIdentificacion;

    @JsonProperty("pt_pcanal")
    private String tGSINC1ASESORAUXptpCanal;

    @JsonProperty("pt_pcargo")
    private String tGSINC1ASESORAUXptpCargo;

    @JsonProperty("pt_pestado")
    private String tGSINC1ASESORAUXptpEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1ASESORAUXptpagrSucursal();
        checkTGSINC1ASESORAUXptpatrUsuario();
        checkTGSINC1ASESORAUXptpatrPrimerNombre();
        checkTGSINC1ASESORAUXptpatrPrimerApellido();
    }

    @JsonIgnore
    public SucursalOid getTGSINC1ASESORAUXptpagrSucursal() {
        return this.tGSINC1ASESORAUXptpagrSucursal;
    }
    
    public void setTGSINC1ASESORAUXptpagrSucursal(SucursalOid tGSINC1ASESORAUXptpagrSucursal) {
        this.tGSINC1ASESORAUXptpagrSucursal = tGSINC1ASESORAUXptpagrSucursal;
    }

    @JsonIgnore
    public Sucursal getTGSINC1ASESORAUXptpagrSucursalInstance() {
        return this.tGSINC1ASESORAUXptpagrSucursalInstance;
    }
    
    public void setTGSINC1ASESORAUXptpagrSucursalInstance(Sucursal tGSINC1ASESORAUXptpagrSucursal) {
        this.tGSINC1ASESORAUXptpagrSucursalInstance = tGSINC1ASESORAUXptpagrSucursal;
        this.tGSINC1ASESORAUXptpagrSucursal = tGSINC1ASESORAUXptpagrSucursal != null ? tGSINC1ASESORAUXptpagrSucursal.getOid() : null;
    }

    private void checkTGSINC1ASESORAUXptpagrSucursal() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORAUXptpagrSucursalInstance() == null || this.getTGSINC1ASESORAUXptpagrSucursalInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPAGRSUCURSAL, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPAGRSUCURSAL);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpatrUsuario() {
        return this.tGSINC1ASESORAUXptpatrUsuario;
    }
    
    public void setTGSINC1ASESORAUXptpatrUsuario(String tGSINC1ASESORAUXptpatrUsuario) {
        this.tGSINC1ASESORAUXptpatrUsuario = tGSINC1ASESORAUXptpatrUsuario;
    }

    private void checkTGSINC1ASESORAUXptpatrUsuario() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORAUXptpatrUsuario() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPATRUSUARIO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpatrPrimerNombre() {
        return this.tGSINC1ASESORAUXptpatrPrimerNombre;
    }
    
    public void setTGSINC1ASESORAUXptpatrPrimerNombre(String tGSINC1ASESORAUXptpatrPrimerNombre) {
        this.tGSINC1ASESORAUXptpatrPrimerNombre = tGSINC1ASESORAUXptpatrPrimerNombre;
    }

    private void checkTGSINC1ASESORAUXptpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORAUXptpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPATRPRIMERNOMBRE, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpatrSegundoNombre() {
        return this.tGSINC1ASESORAUXptpatrSegundoNombre;
    }
    
    public void setTGSINC1ASESORAUXptpatrSegundoNombre(String tGSINC1ASESORAUXptpatrSegundoNombre) {
        this.tGSINC1ASESORAUXptpatrSegundoNombre = tGSINC1ASESORAUXptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpatrPrimerApellido() {
        return this.tGSINC1ASESORAUXptpatrPrimerApellido;
    }
    
    public void setTGSINC1ASESORAUXptpatrPrimerApellido(String tGSINC1ASESORAUXptpatrPrimerApellido) {
        this.tGSINC1ASESORAUXptpatrPrimerApellido = tGSINC1ASESORAUXptpatrPrimerApellido;
    }

    private void checkTGSINC1ASESORAUXptpatrPrimerApellido() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORAUXptpatrPrimerApellido() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPATRPRIMERAPELLIDO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESORAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESORAUX_TGSINC1ASESORAUXPTPATRPRIMERAPELLIDO);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpatrSegundoApellido() {
        return this.tGSINC1ASESORAUXptpatrSegundoApellido;
    }
    
    public void setTGSINC1ASESORAUXptpatrSegundoApellido(String tGSINC1ASESORAUXptpatrSegundoApellido) {
        this.tGSINC1ASESORAUXptpatrSegundoApellido = tGSINC1ASESORAUXptpatrSegundoApellido;
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpatrEmail() {
        return this.tGSINC1ASESORAUXptpatrEmail;
    }
    
    public void setTGSINC1ASESORAUXptpatrEmail(String tGSINC1ASESORAUXptpatrEmail) {
        this.tGSINC1ASESORAUXptpatrEmail = tGSINC1ASESORAUXptpatrEmail;
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXpCodDirector() {
        return this.tGSINC1ASESORAUXpCodDirector;
    }
    
    public void setTGSINC1ASESORAUXpCodDirector(String tGSINC1ASESORAUXpCodDirector) {
        this.tGSINC1ASESORAUXpCodDirector = tGSINC1ASESORAUXpCodDirector;
    }

    @JsonIgnore
    public TipoIdentificacionOid getTGSINC1ASESORAUXpTipoIdentificacion() {
        return this.tGSINC1ASESORAUXpTipoIdentificacion;
    }
    
    public void setTGSINC1ASESORAUXpTipoIdentificacion(TipoIdentificacionOid tGSINC1ASESORAUXpTipoIdentificacion) {
        this.tGSINC1ASESORAUXpTipoIdentificacion = tGSINC1ASESORAUXpTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTGSINC1ASESORAUXpTipoIdentificacionInstance() {
        return this.tGSINC1ASESORAUXpTipoIdentificacionInstance;
    }
    
    public void setTGSINC1ASESORAUXpTipoIdentificacionInstance(TipoIdentificacion tGSINC1ASESORAUXpTipoIdentificacion) {
        this.tGSINC1ASESORAUXpTipoIdentificacionInstance = tGSINC1ASESORAUXpTipoIdentificacion;
        this.tGSINC1ASESORAUXpTipoIdentificacion = tGSINC1ASESORAUXpTipoIdentificacion != null ? tGSINC1ASESORAUXpTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXpNumIdentificacion() {
        return this.tGSINC1ASESORAUXpNumIdentificacion;
    }
    
    public void setTGSINC1ASESORAUXpNumIdentificacion(String tGSINC1ASESORAUXpNumIdentificacion) {
        this.tGSINC1ASESORAUXpNumIdentificacion = tGSINC1ASESORAUXpNumIdentificacion;
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpCanal() {
        return this.tGSINC1ASESORAUXptpCanal;
    }
    
    public void setTGSINC1ASESORAUXptpCanal(String tGSINC1ASESORAUXptpCanal) {
        this.tGSINC1ASESORAUXptpCanal = tGSINC1ASESORAUXptpCanal;
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpCargo() {
        return this.tGSINC1ASESORAUXptpCargo;
    }
    
    public void setTGSINC1ASESORAUXptpCargo(String tGSINC1ASESORAUXptpCargo) {
        this.tGSINC1ASESORAUXptpCargo = tGSINC1ASESORAUXptpCargo;
    }

    @JsonIgnore
    public String getTGSINC1ASESORAUXptpEstado() {
        return this.tGSINC1ASESORAUXptpEstado;
    }
    
    public void setTGSINC1ASESORAUXptpEstado(String tGSINC1ASESORAUXptpEstado) {
        this.tGSINC1ASESORAUXptpEstado = tGSINC1ASESORAUXptpEstado;
    }
}
