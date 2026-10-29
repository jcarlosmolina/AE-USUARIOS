package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class TNEWASESORMANUALRequest {

    @JsonProperty("pt_p_agrsucursal_oid")
    private SucursalOid funcionarioTNEWASESORMANUALptpagrSucursal;
    
    @JsonIgnore
    private Sucursal funcionarioTNEWASESORMANUALptpagrSucursalInstance;

    @JsonProperty("pt_p_atrusuario")
    private String funcionarioTNEWASESORMANUALptpatrUsuario;

    @JsonProperty("pt_p_atrprimernombre")
    private String funcionarioTNEWASESORMANUALptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String funcionarioTNEWASESORMANUALptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String funcionarioTNEWASESORMANUALptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String funcionarioTNEWASESORMANUALptpatrSegundoApellido;

    @JsonProperty("pt_p_atrusuarioldap")
    private String funcionarioTNEWASESORMANUALptpatrUsuarioLDAP;

    @JsonProperty("pt_p_atremail")
    private String funcionarioTNEWASESORMANUALptpatrEmail;

    @JsonProperty("pt_p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid funcionarioTNEWASESORMANUALptpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion funcionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance;

    @JsonProperty("pt_p_atrmodificadirector")
    private Boolean funcionarioTNEWASESORMANUALptpatrmodificaDirector;

    @JsonProperty("pt_p_atresdirector")
    private Boolean funcionarioTNEWASESORMANUALptpatresDirector;

    @JsonProperty("pt_p_atrnumidentificacion")
    private String funcionarioTNEWASESORMANUALptpatrNumIdentificacion;

    @JsonProperty("pt_p_codjefe")
    private String funcionarioTNEWASESORMANUALptpCodJefe;

    @JsonProperty("pt_p_atrmoddbasicospersona")
    private Boolean funcionarioTNEWASESORMANUALptpatrModDBasicosPersona;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioTNEWASESORMANUALptpagrSucursal();
        checkFuncionarioTNEWASESORMANUALptpatrUsuario();
        checkFuncionarioTNEWASESORMANUALptpatrPrimerNombre();
        checkFuncionarioTNEWASESORMANUALptpatrmodificaDirector();
        checkFuncionarioTNEWASESORMANUALptpatresDirector();
        checkFuncionarioTNEWASESORMANUALptpatrModDBasicosPersona();
    }

    @JsonIgnore
    public SucursalOid getFuncionarioTNEWASESORMANUALptpagrSucursal() {
        return this.funcionarioTNEWASESORMANUALptpagrSucursal;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpagrSucursal(SucursalOid funcionarioTNEWASESORMANUALptpagrSucursal) {
        this.funcionarioTNEWASESORMANUALptpagrSucursal = funcionarioTNEWASESORMANUALptpagrSucursal;
    }

    @JsonIgnore
    public Sucursal getFuncionarioTNEWASESORMANUALptpagrSucursalInstance() {
        return this.funcionarioTNEWASESORMANUALptpagrSucursalInstance;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpagrSucursalInstance(Sucursal funcionarioTNEWASESORMANUALptpagrSucursal) {
        this.funcionarioTNEWASESORMANUALptpagrSucursalInstance = funcionarioTNEWASESORMANUALptpagrSucursal;
        this.funcionarioTNEWASESORMANUALptpagrSucursal = funcionarioTNEWASESORMANUALptpagrSucursal != null ? funcionarioTNEWASESORMANUALptpagrSucursal.getOid() : null;
    }

    private void checkFuncionarioTNEWASESORMANUALptpagrSucursal() throws NotNullArgumentException {
        if(this.getFuncionarioTNEWASESORMANUALptpagrSucursalInstance() == null || this.getFuncionarioTNEWASESORMANUALptpagrSucursalInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPAGRSUCURSAL, FuncionarioConstants.SERV_ALIAS_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPAGRSUCURSAL);
        }
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrUsuario() {
        return this.funcionarioTNEWASESORMANUALptpatrUsuario;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrUsuario(String funcionarioTNEWASESORMANUALptpatrUsuario) {
        this.funcionarioTNEWASESORMANUALptpatrUsuario = funcionarioTNEWASESORMANUALptpatrUsuario;
    }

    private void checkFuncionarioTNEWASESORMANUALptpatrUsuario() throws NotNullArgumentException {
        if(this.getFuncionarioTNEWASESORMANUALptpatrUsuario() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRUSUARIO, FuncionarioConstants.SERV_ALIAS_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrPrimerNombre() {
        return this.funcionarioTNEWASESORMANUALptpatrPrimerNombre;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrPrimerNombre(String funcionarioTNEWASESORMANUALptpatrPrimerNombre) {
        this.funcionarioTNEWASESORMANUALptpatrPrimerNombre = funcionarioTNEWASESORMANUALptpatrPrimerNombre;
    }

    private void checkFuncionarioTNEWASESORMANUALptpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getFuncionarioTNEWASESORMANUALptpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRPRIMERNOMBRE, FuncionarioConstants.SERV_ALIAS_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrSegundoNombre() {
        return this.funcionarioTNEWASESORMANUALptpatrSegundoNombre;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrSegundoNombre(String funcionarioTNEWASESORMANUALptpatrSegundoNombre) {
        this.funcionarioTNEWASESORMANUALptpatrSegundoNombre = funcionarioTNEWASESORMANUALptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrPrimerApellido() {
        return this.funcionarioTNEWASESORMANUALptpatrPrimerApellido;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrPrimerApellido(String funcionarioTNEWASESORMANUALptpatrPrimerApellido) {
        this.funcionarioTNEWASESORMANUALptpatrPrimerApellido = funcionarioTNEWASESORMANUALptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrSegundoApellido() {
        return this.funcionarioTNEWASESORMANUALptpatrSegundoApellido;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrSegundoApellido(String funcionarioTNEWASESORMANUALptpatrSegundoApellido) {
        this.funcionarioTNEWASESORMANUALptpatrSegundoApellido = funcionarioTNEWASESORMANUALptpatrSegundoApellido;
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrUsuarioLDAP() {
        return this.funcionarioTNEWASESORMANUALptpatrUsuarioLDAP;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrUsuarioLDAP(String funcionarioTNEWASESORMANUALptpatrUsuarioLDAP) {
        this.funcionarioTNEWASESORMANUALptpatrUsuarioLDAP = funcionarioTNEWASESORMANUALptpatrUsuarioLDAP;
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrEmail() {
        return this.funcionarioTNEWASESORMANUALptpatrEmail;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrEmail(String funcionarioTNEWASESORMANUALptpatrEmail) {
        this.funcionarioTNEWASESORMANUALptpatrEmail = funcionarioTNEWASESORMANUALptpatrEmail;
    }

    @JsonIgnore
    public TipoIdentificacionOid getFuncionarioTNEWASESORMANUALptpagrTipoIdentificacion() {
        return this.funcionarioTNEWASESORMANUALptpagrTipoIdentificacion;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpagrTipoIdentificacion(TipoIdentificacionOid funcionarioTNEWASESORMANUALptpagrTipoIdentificacion) {
        this.funcionarioTNEWASESORMANUALptpagrTipoIdentificacion = funcionarioTNEWASESORMANUALptpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFuncionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance() {
        return this.funcionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance(TipoIdentificacion funcionarioTNEWASESORMANUALptpagrTipoIdentificacion) {
        this.funcionarioTNEWASESORMANUALptpagrTipoIdentificacionInstance = funcionarioTNEWASESORMANUALptpagrTipoIdentificacion;
        this.funcionarioTNEWASESORMANUALptpagrTipoIdentificacion = funcionarioTNEWASESORMANUALptpagrTipoIdentificacion != null ? funcionarioTNEWASESORMANUALptpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public Boolean getFuncionarioTNEWASESORMANUALptpatrmodificaDirector() {
        return this.funcionarioTNEWASESORMANUALptpatrmodificaDirector;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrmodificaDirector(Boolean funcionarioTNEWASESORMANUALptpatrmodificaDirector) {
        this.funcionarioTNEWASESORMANUALptpatrmodificaDirector = funcionarioTNEWASESORMANUALptpatrmodificaDirector;
    }

    private void checkFuncionarioTNEWASESORMANUALptpatrmodificaDirector() throws NotNullArgumentException {
        if(this.getFuncionarioTNEWASESORMANUALptpatrmodificaDirector() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRMODIFICADIRECTOR, FuncionarioConstants.SERV_ALIAS_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRMODIFICADIRECTOR);
        }
    }

    @JsonIgnore
    public Boolean getFuncionarioTNEWASESORMANUALptpatresDirector() {
        return this.funcionarioTNEWASESORMANUALptpatresDirector;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatresDirector(Boolean funcionarioTNEWASESORMANUALptpatresDirector) {
        this.funcionarioTNEWASESORMANUALptpatresDirector = funcionarioTNEWASESORMANUALptpatresDirector;
    }

    private void checkFuncionarioTNEWASESORMANUALptpatresDirector() throws NotNullArgumentException {
        if(this.getFuncionarioTNEWASESORMANUALptpatresDirector() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRESDIRECTOR, FuncionarioConstants.SERV_ALIAS_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRESDIRECTOR);
        }
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpatrNumIdentificacion() {
        return this.funcionarioTNEWASESORMANUALptpatrNumIdentificacion;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrNumIdentificacion(String funcionarioTNEWASESORMANUALptpatrNumIdentificacion) {
        this.funcionarioTNEWASESORMANUALptpatrNumIdentificacion = funcionarioTNEWASESORMANUALptpatrNumIdentificacion;
    }

    @JsonIgnore
    public String getFuncionarioTNEWASESORMANUALptpCodJefe() {
        return this.funcionarioTNEWASESORMANUALptpCodJefe;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpCodJefe(String funcionarioTNEWASESORMANUALptpCodJefe) {
        this.funcionarioTNEWASESORMANUALptpCodJefe = funcionarioTNEWASESORMANUALptpCodJefe;
    }

    @JsonIgnore
    public Boolean getFuncionarioTNEWASESORMANUALptpatrModDBasicosPersona() {
        return this.funcionarioTNEWASESORMANUALptpatrModDBasicosPersona;
    }
    
    public void setFuncionarioTNEWASESORMANUALptpatrModDBasicosPersona(Boolean funcionarioTNEWASESORMANUALptpatrModDBasicosPersona) {
        this.funcionarioTNEWASESORMANUALptpatrModDBasicosPersona = funcionarioTNEWASESORMANUALptpatrModDBasicosPersona;
    }

    private void checkFuncionarioTNEWASESORMANUALptpatrModDBasicosPersona() throws NotNullArgumentException {
        if(this.getFuncionarioTNEWASESORMANUALptpatrModDBasicosPersona() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRMODDBASICOSPERSONA, FuncionarioConstants.SERV_ALIAS_TNEWASESORMANUAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TNEWASESORMANUAL_FUNCIONARIOTNEWASESORMANUALPTPATRMODDBASICOSPERSONA);
        }
    }
}
