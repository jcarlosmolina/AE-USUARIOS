package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class TGSINC1ASESORRequest {

    @JsonProperty("pt_p_atrusuario")
    private String tGSINC1ASESORptpatrUsuario;

    @JsonProperty("pt_p_atrprimernombre")
    private String tGSINC1ASESORptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String tGSINC1ASESORptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String tGSINC1ASESORptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String tGSINC1ASESORptpatrSegundoApellido;

    @JsonProperty("pt_p_atremail")
    private String tGSINC1ASESORptpatrEmail;

    @JsonProperty("pt_p_atrcodigosucursal")
    private Long tGSINC1ASESORptpatrCodigoSucursal;

    @JsonProperty("pcoddirector")
    private String tGSINC1ASESORpCodDirector;

    @JsonProperty("ptipoidentificacion_json")
    private String tGSINC1ASESORpTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tGSINC1ASESORpTipoIdentificacionInstance;

    @JsonProperty("pnumidentificacion")
    private String tGSINC1ASESORpNumIdentificacion;

    @JsonProperty("pt_pcanal")
    private String tGSINC1ASESORptpCanal;

    @JsonProperty("pt_pcargo")
    private String tGSINC1ASESORptpCargo;

    @JsonProperty("pt_pestado")
    private String tGSINC1ASESORptpEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1ASESORptpatrUsuario();
        checkTGSINC1ASESORptpatrPrimerNombre();
        checkTGSINC1ASESORptpatrPrimerApellido();
        checkTGSINC1ASESORptpatrCodigoSucursal();
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpatrUsuario() {
        return this.tGSINC1ASESORptpatrUsuario;
    }
    
    public void setTGSINC1ASESORptpatrUsuario(String tGSINC1ASESORptpatrUsuario) {
        this.tGSINC1ASESORptpatrUsuario = tGSINC1ASESORptpatrUsuario;
    }

    private void checkTGSINC1ASESORptpatrUsuario() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORptpatrUsuario() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESOR_TGSINC1ASESORPTPATRUSUARIO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESOR_TGSINC1ASESORPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpatrPrimerNombre() {
        return this.tGSINC1ASESORptpatrPrimerNombre;
    }
    
    public void setTGSINC1ASESORptpatrPrimerNombre(String tGSINC1ASESORptpatrPrimerNombre) {
        this.tGSINC1ASESORptpatrPrimerNombre = tGSINC1ASESORptpatrPrimerNombre;
    }

    private void checkTGSINC1ASESORptpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORptpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESOR_TGSINC1ASESORPTPATRPRIMERNOMBRE, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESOR_TGSINC1ASESORPTPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpatrSegundoNombre() {
        return this.tGSINC1ASESORptpatrSegundoNombre;
    }
    
    public void setTGSINC1ASESORptpatrSegundoNombre(String tGSINC1ASESORptpatrSegundoNombre) {
        this.tGSINC1ASESORptpatrSegundoNombre = tGSINC1ASESORptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpatrPrimerApellido() {
        return this.tGSINC1ASESORptpatrPrimerApellido;
    }
    
    public void setTGSINC1ASESORptpatrPrimerApellido(String tGSINC1ASESORptpatrPrimerApellido) {
        this.tGSINC1ASESORptpatrPrimerApellido = tGSINC1ASESORptpatrPrimerApellido;
    }

    private void checkTGSINC1ASESORptpatrPrimerApellido() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORptpatrPrimerApellido() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESOR_TGSINC1ASESORPTPATRPRIMERAPELLIDO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESOR_TGSINC1ASESORPTPATRPRIMERAPELLIDO);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpatrSegundoApellido() {
        return this.tGSINC1ASESORptpatrSegundoApellido;
    }
    
    public void setTGSINC1ASESORptpatrSegundoApellido(String tGSINC1ASESORptpatrSegundoApellido) {
        this.tGSINC1ASESORptpatrSegundoApellido = tGSINC1ASESORptpatrSegundoApellido;
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpatrEmail() {
        return this.tGSINC1ASESORptpatrEmail;
    }
    
    public void setTGSINC1ASESORptpatrEmail(String tGSINC1ASESORptpatrEmail) {
        this.tGSINC1ASESORptpatrEmail = tGSINC1ASESORptpatrEmail;
    }

    @JsonIgnore
    public Long getTGSINC1ASESORptpatrCodigoSucursal() {
        return this.tGSINC1ASESORptpatrCodigoSucursal;
    }
    
    public void setTGSINC1ASESORptpatrCodigoSucursal(Long tGSINC1ASESORptpatrCodigoSucursal) {
        this.tGSINC1ASESORptpatrCodigoSucursal = tGSINC1ASESORptpatrCodigoSucursal;
    }

    private void checkTGSINC1ASESORptpatrCodigoSucursal() throws NotNullArgumentException {
        if(this.getTGSINC1ASESORptpatrCodigoSucursal() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ID_TGSINC1ASESOR_TGSINC1ASESORPTPATRCODIGOSUCURSAL, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1ASESOR, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1ASESOR_TGSINC1ASESORPTPATRCODIGOSUCURSAL);
        }
    }

    @JsonIgnore
    public String getTGSINC1ASESORpCodDirector() {
        return this.tGSINC1ASESORpCodDirector;
    }
    
    public void setTGSINC1ASESORpCodDirector(String tGSINC1ASESORpCodDirector) {
        this.tGSINC1ASESORpCodDirector = tGSINC1ASESORpCodDirector;
    }

    @JsonIgnore
    public String getTGSINC1ASESORpTipoIdentificacion() {
        return this.tGSINC1ASESORpTipoIdentificacion;
    }
    
    public void setTGSINC1ASESORpTipoIdentificacion(String tGSINC1ASESORpTipoIdentificacion) {
        this.tGSINC1ASESORpTipoIdentificacion = tGSINC1ASESORpTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTGSINC1ASESORpTipoIdentificacionInstance() {
        return this.tGSINC1ASESORpTipoIdentificacionInstance;
    }
    
    public void setTGSINC1ASESORpTipoIdentificacionInstance(TipoIdentificacion tGSINC1ASESORpTipoIdentificacion) {
        this.tGSINC1ASESORpTipoIdentificacionInstance = tGSINC1ASESORpTipoIdentificacion;
        this.tGSINC1ASESORpTipoIdentificacion = tGSINC1ASESORpTipoIdentificacion != null ? tGSINC1ASESORpTipoIdentificacion.getOid().toJson() : "";
    }

    @JsonIgnore
    public String getTGSINC1ASESORpNumIdentificacion() {
        return this.tGSINC1ASESORpNumIdentificacion;
    }
    
    public void setTGSINC1ASESORpNumIdentificacion(String tGSINC1ASESORpNumIdentificacion) {
        this.tGSINC1ASESORpNumIdentificacion = tGSINC1ASESORpNumIdentificacion;
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpCanal() {
        return this.tGSINC1ASESORptpCanal;
    }
    
    public void setTGSINC1ASESORptpCanal(String tGSINC1ASESORptpCanal) {
        this.tGSINC1ASESORptpCanal = tGSINC1ASESORptpCanal;
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpCargo() {
        return this.tGSINC1ASESORptpCargo;
    }
    
    public void setTGSINC1ASESORptpCargo(String tGSINC1ASESORptpCargo) {
        this.tGSINC1ASESORptpCargo = tGSINC1ASESORptpCargo;
    }

    @JsonIgnore
    public String getTGSINC1ASESORptpEstado() {
        return this.tGSINC1ASESORptpEstado;
    }
    
    public void setTGSINC1ASESORptpEstado(String tGSINC1ASESORptpEstado) {
        this.tGSINC1ASESORptpEstado = tGSINC1ASESORptpEstado;
    }
}
