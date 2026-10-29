package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class TCREARASESORRequest {

    @JsonProperty("pt_p_agrsucursal_oid")
    private SucursalOid funcionarioTCREARASESORptpagrSucursal;
    
    @JsonIgnore
    private Sucursal funcionarioTCREARASESORptpagrSucursalInstance;

    @JsonProperty("pt_p_atrusuario")
    private String funcionarioTCREARASESORptpatrUsuario;

    @JsonProperty("pt_p_atrprimernombre")
    private String funcionarioTCREARASESORptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String funcionarioTCREARASESORptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String funcionarioTCREARASESORptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String funcionarioTCREARASESORptpatrSegundoApellido;

    @JsonProperty("pt_p_atremail")
    private String funcionarioTCREARASESORptpatrEmail;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid funcionarioTCREARASESORptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion funcionarioTCREARASESORptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String funcionarioTCREARASESORptpatrNumIdentificacion;

    @JsonProperty("pt_p_codjefe")
    private String funcionarioTCREARASESORptpCodJefe;

    @JsonProperty("ptcanal")
    private String funcionarioTCREARASESORptCanal;

    @JsonProperty("ptcargo")
    private String funcionarioTCREARASESORptCargo;

    @JsonProperty("ptestado")
    private String funcionarioTCREARASESORptEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioTCREARASESORptpagrSucursal();
        checkFuncionarioTCREARASESORptpatrUsuario();
        checkFuncionarioTCREARASESORptpatrPrimerNombre();
    }

    @JsonIgnore
    public SucursalOid getFuncionarioTCREARASESORptpagrSucursal() {
        return this.funcionarioTCREARASESORptpagrSucursal;
    }
    
    public void setFuncionarioTCREARASESORptpagrSucursal(SucursalOid funcionarioTCREARASESORptpagrSucursal) {
        this.funcionarioTCREARASESORptpagrSucursal = funcionarioTCREARASESORptpagrSucursal;
    }

    @JsonIgnore
    public Sucursal getFuncionarioTCREARASESORptpagrSucursalInstance() {
        return this.funcionarioTCREARASESORptpagrSucursalInstance;
    }
    
    public void setFuncionarioTCREARASESORptpagrSucursalInstance(Sucursal funcionarioTCREARASESORptpagrSucursal) {
        this.funcionarioTCREARASESORptpagrSucursalInstance = funcionarioTCREARASESORptpagrSucursal;
        this.funcionarioTCREARASESORptpagrSucursal = funcionarioTCREARASESORptpagrSucursal != null ? funcionarioTCREARASESORptpagrSucursal.getOid() : null;
    }

    private void checkFuncionarioTCREARASESORptpagrSucursal() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARASESORptpagrSucursalInstance() == null || this.getFuncionarioTCREARASESORptpagrSucursalInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREARASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREARASESOR_FUNCIONARIOTCREARASESORPTPAGRSUCURSAL, FuncionarioConstants.SERV_ALIAS_TCREARASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREARASESOR_FUNCIONARIOTCREARASESORPTPAGRSUCURSAL);
        }
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpatrUsuario() {
        return this.funcionarioTCREARASESORptpatrUsuario;
    }
    
    public void setFuncionarioTCREARASESORptpatrUsuario(String funcionarioTCREARASESORptpatrUsuario) {
        this.funcionarioTCREARASESORptpatrUsuario = funcionarioTCREARASESORptpatrUsuario;
    }

    private void checkFuncionarioTCREARASESORptpatrUsuario() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARASESORptpatrUsuario() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREARASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREARASESOR_FUNCIONARIOTCREARASESORPTPATRUSUARIO, FuncionarioConstants.SERV_ALIAS_TCREARASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREARASESOR_FUNCIONARIOTCREARASESORPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpatrPrimerNombre() {
        return this.funcionarioTCREARASESORptpatrPrimerNombre;
    }
    
    public void setFuncionarioTCREARASESORptpatrPrimerNombre(String funcionarioTCREARASESORptpatrPrimerNombre) {
        this.funcionarioTCREARASESORptpatrPrimerNombre = funcionarioTCREARASESORptpatrPrimerNombre;
    }

    private void checkFuncionarioTCREARASESORptpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARASESORptpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREARASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREARASESOR_FUNCIONARIOTCREARASESORPTPATRPRIMERNOMBRE, FuncionarioConstants.SERV_ALIAS_TCREARASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREARASESOR_FUNCIONARIOTCREARASESORPTPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpatrSegundoNombre() {
        return this.funcionarioTCREARASESORptpatrSegundoNombre;
    }
    
    public void setFuncionarioTCREARASESORptpatrSegundoNombre(String funcionarioTCREARASESORptpatrSegundoNombre) {
        this.funcionarioTCREARASESORptpatrSegundoNombre = funcionarioTCREARASESORptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpatrPrimerApellido() {
        return this.funcionarioTCREARASESORptpatrPrimerApellido;
    }
    
    public void setFuncionarioTCREARASESORptpatrPrimerApellido(String funcionarioTCREARASESORptpatrPrimerApellido) {
        this.funcionarioTCREARASESORptpatrPrimerApellido = funcionarioTCREARASESORptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpatrSegundoApellido() {
        return this.funcionarioTCREARASESORptpatrSegundoApellido;
    }
    
    public void setFuncionarioTCREARASESORptpatrSegundoApellido(String funcionarioTCREARASESORptpatrSegundoApellido) {
        this.funcionarioTCREARASESORptpatrSegundoApellido = funcionarioTCREARASESORptpatrSegundoApellido;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpatrEmail() {
        return this.funcionarioTCREARASESORptpatrEmail;
    }
    
    public void setFuncionarioTCREARASESORptpatrEmail(String funcionarioTCREARASESORptpatrEmail) {
        this.funcionarioTCREARASESORptpatrEmail = funcionarioTCREARASESORptpatrEmail;
    }

    @JsonIgnore
    public TipoIdentificacionOid getFuncionarioTCREARASESORptpagrTipoIdentificacion() {
        return this.funcionarioTCREARASESORptpagrTipoIdentificacion;
    }
    
    public void setFuncionarioTCREARASESORptpagrTipoIdentificacion(TipoIdentificacionOid funcionarioTCREARASESORptpagrTipoIdentificacion) {
        this.funcionarioTCREARASESORptpagrTipoIdentificacion = funcionarioTCREARASESORptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFuncionarioTCREARASESORptpagrTipoIdentificacionInstance() {
        return this.funcionarioTCREARASESORptpagrTipoIdentificacionInstance;
    }
    
    public void setFuncionarioTCREARASESORptpagrTipoIdentificacionInstance(TipoIdentificacion funcionarioTCREARASESORptpagrTipoIdentificacion) {
        this.funcionarioTCREARASESORptpagrTipoIdentificacionInstance = funcionarioTCREARASESORptpagrTipoIdentificacion;
        this.funcionarioTCREARASESORptpagrTipoIdentificacion = funcionarioTCREARASESORptpagrTipoIdentificacion != null ? funcionarioTCREARASESORptpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpatrNumIdentificacion() {
        return this.funcionarioTCREARASESORptpatrNumIdentificacion;
    }
    
    public void setFuncionarioTCREARASESORptpatrNumIdentificacion(String funcionarioTCREARASESORptpatrNumIdentificacion) {
        this.funcionarioTCREARASESORptpatrNumIdentificacion = funcionarioTCREARASESORptpatrNumIdentificacion;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptpCodJefe() {
        return this.funcionarioTCREARASESORptpCodJefe;
    }
    
    public void setFuncionarioTCREARASESORptpCodJefe(String funcionarioTCREARASESORptpCodJefe) {
        this.funcionarioTCREARASESORptpCodJefe = funcionarioTCREARASESORptpCodJefe;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptCanal() {
        return this.funcionarioTCREARASESORptCanal;
    }
    
    public void setFuncionarioTCREARASESORptCanal(String funcionarioTCREARASESORptCanal) {
        this.funcionarioTCREARASESORptCanal = funcionarioTCREARASESORptCanal;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptCargo() {
        return this.funcionarioTCREARASESORptCargo;
    }
    
    public void setFuncionarioTCREARASESORptCargo(String funcionarioTCREARASESORptCargo) {
        this.funcionarioTCREARASESORptCargo = funcionarioTCREARASESORptCargo;
    }

    @JsonIgnore
    public String getFuncionarioTCREARASESORptEstado() {
        return this.funcionarioTCREARASESORptEstado;
    }
    
    public void setFuncionarioTCREARASESORptEstado(String funcionarioTCREARASESORptEstado) {
        this.funcionarioTCREARASESORptEstado = funcionarioTCREARASESORptEstado;
    }
}
