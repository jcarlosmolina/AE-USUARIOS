package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;

public class TCREARRequest {

    @JsonProperty("pt_p_agrrol_oid")
    private RolOid funcionarioTCREARptpagrRol;
    
    @JsonIgnore
    private Rol funcionarioTCREARptpagrRolInstance;

    @JsonProperty("pt_p_atrusuario")
    private String funcionarioTCREARptpatrUsuario;

    @JsonProperty("pt_p_atrprimernombre")
    private String funcionarioTCREARptpatrPrimerNombre;

    @JsonProperty("pt_p_atrsegundonombre")
    private String funcionarioTCREARptpatrSegundoNombre;

    @JsonProperty("pt_p_atrprimerapellido")
    private String funcionarioTCREARptpatrPrimerApellido;

    @JsonProperty("pt_p_atrsegundoapellido")
    private String funcionarioTCREARptpatrSegundoApellido;

    @JsonProperty("pt_p_password")
    private String funcionarioTCREARptppassword;

    @JsonProperty("pt_p_agrsucursal_oid")
    private SucursalOid funcionarioTCREARptpagrSucursal;
    
    @JsonIgnore
    private Sucursal funcionarioTCREARptpagrSucursalInstance;

    @JsonProperty("pt_p_atrusuarioldap")
    private String funcionarioTCREARptpatrUsuarioLDAP;

    @JsonProperty("pt_p_atremail")
    private String funcionarioTCREARptpatrEmail;

    @JsonProperty("pt_p_agrregional_oid")
    private RegionalOid funcionarioTCREARptpagrRegional;
    
    @JsonIgnore
    private Regional funcionarioTCREARptpagrRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioTCREARptpagrRol();
        checkFuncionarioTCREARptpatrUsuario();
        checkFuncionarioTCREARptpatrPrimerNombre();
        checkFuncionarioTCREARptppassword();
        checkFuncionarioTCREARptpagrSucursal();
    }

    @JsonIgnore
    public RolOid getFuncionarioTCREARptpagrRol() {
        return this.funcionarioTCREARptpagrRol;
    }
    
    public void setFuncionarioTCREARptpagrRol(RolOid funcionarioTCREARptpagrRol) {
        this.funcionarioTCREARptpagrRol = funcionarioTCREARptpagrRol;
    }

    @JsonIgnore
    public Rol getFuncionarioTCREARptpagrRolInstance() {
        return this.funcionarioTCREARptpagrRolInstance;
    }
    
    public void setFuncionarioTCREARptpagrRolInstance(Rol funcionarioTCREARptpagrRol) {
        this.funcionarioTCREARptpagrRolInstance = funcionarioTCREARptpagrRol;
        this.funcionarioTCREARptpagrRol = funcionarioTCREARptpagrRol != null ? funcionarioTCREARptpagrRol.getOid() : null;
    }

    private void checkFuncionarioTCREARptpagrRol() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARptpagrRolInstance() == null || this.getFuncionarioTCREARptpagrRolInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREAR_FUNCIONARIOTCREARPTPAGRROL, FuncionarioConstants.SERV_ALIAS_TCREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREAR_FUNCIONARIOTCREARPTPAGRROL);
        }
    }

    @JsonIgnore
    public String getFuncionarioTCREARptpatrUsuario() {
        return this.funcionarioTCREARptpatrUsuario;
    }
    
    public void setFuncionarioTCREARptpatrUsuario(String funcionarioTCREARptpatrUsuario) {
        this.funcionarioTCREARptpatrUsuario = funcionarioTCREARptpatrUsuario;
    }

    private void checkFuncionarioTCREARptpatrUsuario() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARptpatrUsuario() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREAR_FUNCIONARIOTCREARPTPATRUSUARIO, FuncionarioConstants.SERV_ALIAS_TCREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREAR_FUNCIONARIOTCREARPTPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getFuncionarioTCREARptpatrPrimerNombre() {
        return this.funcionarioTCREARptpatrPrimerNombre;
    }
    
    public void setFuncionarioTCREARptpatrPrimerNombre(String funcionarioTCREARptpatrPrimerNombre) {
        this.funcionarioTCREARptpatrPrimerNombre = funcionarioTCREARptpatrPrimerNombre;
    }

    private void checkFuncionarioTCREARptpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARptpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREAR_FUNCIONARIOTCREARPTPATRPRIMERNOMBRE, FuncionarioConstants.SERV_ALIAS_TCREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREAR_FUNCIONARIOTCREARPTPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getFuncionarioTCREARptpatrSegundoNombre() {
        return this.funcionarioTCREARptpatrSegundoNombre;
    }
    
    public void setFuncionarioTCREARptpatrSegundoNombre(String funcionarioTCREARptpatrSegundoNombre) {
        this.funcionarioTCREARptpatrSegundoNombre = funcionarioTCREARptpatrSegundoNombre;
    }

    @JsonIgnore
    public String getFuncionarioTCREARptpatrPrimerApellido() {
        return this.funcionarioTCREARptpatrPrimerApellido;
    }
    
    public void setFuncionarioTCREARptpatrPrimerApellido(String funcionarioTCREARptpatrPrimerApellido) {
        this.funcionarioTCREARptpatrPrimerApellido = funcionarioTCREARptpatrPrimerApellido;
    }

    @JsonIgnore
    public String getFuncionarioTCREARptpatrSegundoApellido() {
        return this.funcionarioTCREARptpatrSegundoApellido;
    }
    
    public void setFuncionarioTCREARptpatrSegundoApellido(String funcionarioTCREARptpatrSegundoApellido) {
        this.funcionarioTCREARptpatrSegundoApellido = funcionarioTCREARptpatrSegundoApellido;
    }

    @JsonIgnore
    public String getFuncionarioTCREARptppassword() {
        return this.funcionarioTCREARptppassword;
    }
    
    public void setFuncionarioTCREARptppassword(String funcionarioTCREARptppassword) {
        this.funcionarioTCREARptppassword = funcionarioTCREARptppassword;
    }

    private void checkFuncionarioTCREARptppassword() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARptppassword() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREAR_FUNCIONARIOTCREARPTPP4SSW0RD, FuncionarioConstants.SERV_ALIAS_TCREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREAR_FUNCIONARIOTCREARPTPP4SSW0RD);
        }
    }

    @JsonIgnore
    public SucursalOid getFuncionarioTCREARptpagrSucursal() {
        return this.funcionarioTCREARptpagrSucursal;
    }
    
    public void setFuncionarioTCREARptpagrSucursal(SucursalOid funcionarioTCREARptpagrSucursal) {
        this.funcionarioTCREARptpagrSucursal = funcionarioTCREARptpagrSucursal;
    }

    @JsonIgnore
    public Sucursal getFuncionarioTCREARptpagrSucursalInstance() {
        return this.funcionarioTCREARptpagrSucursalInstance;
    }
    
    public void setFuncionarioTCREARptpagrSucursalInstance(Sucursal funcionarioTCREARptpagrSucursal) {
        this.funcionarioTCREARptpagrSucursalInstance = funcionarioTCREARptpagrSucursal;
        this.funcionarioTCREARptpagrSucursal = funcionarioTCREARptpagrSucursal != null ? funcionarioTCREARptpagrSucursal.getOid() : null;
    }

    private void checkFuncionarioTCREARptpagrSucursal() throws NotNullArgumentException {
        if(this.getFuncionarioTCREARptpagrSucursalInstance() == null || this.getFuncionarioTCREARptpagrSucursalInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCREAR_FUNCIONARIOTCREARPTPAGRSUCURSAL, FuncionarioConstants.SERV_ALIAS_TCREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCREAR_FUNCIONARIOTCREARPTPAGRSUCURSAL);
        }
    }

    @JsonIgnore
    public String getFuncionarioTCREARptpatrUsuarioLDAP() {
        return this.funcionarioTCREARptpatrUsuarioLDAP;
    }
    
    public void setFuncionarioTCREARptpatrUsuarioLDAP(String funcionarioTCREARptpatrUsuarioLDAP) {
        this.funcionarioTCREARptpatrUsuarioLDAP = funcionarioTCREARptpatrUsuarioLDAP;
    }

    @JsonIgnore
    public String getFuncionarioTCREARptpatrEmail() {
        return this.funcionarioTCREARptpatrEmail;
    }
    
    public void setFuncionarioTCREARptpatrEmail(String funcionarioTCREARptpatrEmail) {
        this.funcionarioTCREARptpatrEmail = funcionarioTCREARptpatrEmail;
    }

    @JsonIgnore
    public RegionalOid getFuncionarioTCREARptpagrRegional() {
        return this.funcionarioTCREARptpagrRegional;
    }
    
    public void setFuncionarioTCREARptpagrRegional(RegionalOid funcionarioTCREARptpagrRegional) {
        this.funcionarioTCREARptpagrRegional = funcionarioTCREARptpagrRegional;
    }

    @JsonIgnore
    public Regional getFuncionarioTCREARptpagrRegionalInstance() {
        return this.funcionarioTCREARptpagrRegionalInstance;
    }
    
    public void setFuncionarioTCREARptpagrRegionalInstance(Regional funcionarioTCREARptpagrRegional) {
        this.funcionarioTCREARptpagrRegionalInstance = funcionarioTCREARptpagrRegional;
        this.funcionarioTCREARptpagrRegional = funcionarioTCREARptpagrRegional != null ? funcionarioTCREARptpagrRegional.getOid() : null;
    }
}
