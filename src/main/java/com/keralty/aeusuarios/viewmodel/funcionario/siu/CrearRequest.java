package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.persistence.Sucursal;

public class CrearRequest {

    @JsonProperty("p_agrrol_oid")
    private RolOid funcionariocrearpagrRol;
    
    @JsonIgnore
    private Rol funcionariocrearpagrRolInstance;

    @JsonProperty("p_agrsucursal_oid")
    private SucursalOid funcionariocrearpagrSucursal;
    
    @JsonIgnore
    private Sucursal funcionariocrearpagrSucursalInstance;

    @JsonProperty("p_atrusuario")
    private String funcionariocrearpatrUsuario;

    @JsonProperty("p_atrprimernombre")
    private String funcionariocrearpatrPrimerNombre;

    @JsonProperty("p_atrsegundonombre")
    private String funcionariocrearpatrSegundoNombre;

    @JsonProperty("p_atrprimerapellido")
    private String funcionariocrearpatrPrimerApellido;

    @JsonProperty("p_atrsegundoapellido")
    private String funcionariocrearpatrSegundoApellido;

    @JsonProperty("p_atrusuarioldap")
    private String funcionariocrearpatrUsuarioLDAP;

    @JsonProperty("p_atremail")
    private String funcionariocrearpatrEmail;

    @JsonProperty("p_atrmanual")
    private Boolean funcionariocrearpatrManual;

    @JsonProperty("p_password")
    private String funcionariocrearppassword;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariocrearpagrRol();
        checkFuncionariocrearpagrSucursal();
        checkFuncionariocrearpatrUsuario();
        checkFuncionariocrearpatrPrimerNombre();
        checkFuncionariocrearpatrManual();
        checkFuncionariocrearppassword();
    }

    @JsonIgnore
    public RolOid getFuncionariocrearpagrRol() {
        return this.funcionariocrearpagrRol;
    }
    
    public void setFuncionariocrearpagrRol(RolOid funcionariocrearpagrRol) {
        this.funcionariocrearpagrRol = funcionariocrearpagrRol;
    }

    @JsonIgnore
    public Rol getFuncionariocrearpagrRolInstance() {
        return this.funcionariocrearpagrRolInstance;
    }
    
    public void setFuncionariocrearpagrRolInstance(Rol funcionariocrearpagrRol) {
        this.funcionariocrearpagrRolInstance = funcionariocrearpagrRol;
        this.funcionariocrearpagrRol = funcionariocrearpagrRol != null ? funcionariocrearpagrRol.getOid() : null;
    }

    private void checkFuncionariocrearpagrRol() throws NotNullArgumentException {
        if(this.getFuncionariocrearpagrRolInstance() == null || this.getFuncionariocrearpagrRolInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CREAR_FUNCIONARIOCREARPAGRROL, FuncionarioConstants.SERV_ALIAS_CREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CREAR_FUNCIONARIOCREARPAGRROL);
        }
    }

    @JsonIgnore
    public SucursalOid getFuncionariocrearpagrSucursal() {
        return this.funcionariocrearpagrSucursal;
    }
    
    public void setFuncionariocrearpagrSucursal(SucursalOid funcionariocrearpagrSucursal) {
        this.funcionariocrearpagrSucursal = funcionariocrearpagrSucursal;
    }

    @JsonIgnore
    public Sucursal getFuncionariocrearpagrSucursalInstance() {
        return this.funcionariocrearpagrSucursalInstance;
    }
    
    public void setFuncionariocrearpagrSucursalInstance(Sucursal funcionariocrearpagrSucursal) {
        this.funcionariocrearpagrSucursalInstance = funcionariocrearpagrSucursal;
        this.funcionariocrearpagrSucursal = funcionariocrearpagrSucursal != null ? funcionariocrearpagrSucursal.getOid() : null;
    }

    private void checkFuncionariocrearpagrSucursal() throws NotNullArgumentException {
        if(this.getFuncionariocrearpagrSucursalInstance() == null || this.getFuncionariocrearpagrSucursalInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CREAR_FUNCIONARIOCREARPAGRSUCURSAL, FuncionarioConstants.SERV_ALIAS_CREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CREAR_FUNCIONARIOCREARPAGRSUCURSAL);
        }
    }

    @JsonIgnore
    public String getFuncionariocrearpatrUsuario() {
        return this.funcionariocrearpatrUsuario;
    }
    
    public void setFuncionariocrearpatrUsuario(String funcionariocrearpatrUsuario) {
        this.funcionariocrearpatrUsuario = funcionariocrearpatrUsuario;
    }

    private void checkFuncionariocrearpatrUsuario() throws NotNullArgumentException {
        if(this.getFuncionariocrearpatrUsuario() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CREAR_FUNCIONARIOCREARPATRUSUARIO, FuncionarioConstants.SERV_ALIAS_CREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CREAR_FUNCIONARIOCREARPATRUSUARIO);
        }
    }

    @JsonIgnore
    public String getFuncionariocrearpatrPrimerNombre() {
        return this.funcionariocrearpatrPrimerNombre;
    }
    
    public void setFuncionariocrearpatrPrimerNombre(String funcionariocrearpatrPrimerNombre) {
        this.funcionariocrearpatrPrimerNombre = funcionariocrearpatrPrimerNombre;
    }

    private void checkFuncionariocrearpatrPrimerNombre() throws NotNullArgumentException {
        if(this.getFuncionariocrearpatrPrimerNombre() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CREAR_FUNCIONARIOCREARPATRPRIMERNOMBRE, FuncionarioConstants.SERV_ALIAS_CREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CREAR_FUNCIONARIOCREARPATRPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getFuncionariocrearpatrSegundoNombre() {
        return this.funcionariocrearpatrSegundoNombre;
    }
    
    public void setFuncionariocrearpatrSegundoNombre(String funcionariocrearpatrSegundoNombre) {
        this.funcionariocrearpatrSegundoNombre = funcionariocrearpatrSegundoNombre;
    }

    @JsonIgnore
    public String getFuncionariocrearpatrPrimerApellido() {
        return this.funcionariocrearpatrPrimerApellido;
    }
    
    public void setFuncionariocrearpatrPrimerApellido(String funcionariocrearpatrPrimerApellido) {
        this.funcionariocrearpatrPrimerApellido = funcionariocrearpatrPrimerApellido;
    }

    @JsonIgnore
    public String getFuncionariocrearpatrSegundoApellido() {
        return this.funcionariocrearpatrSegundoApellido;
    }
    
    public void setFuncionariocrearpatrSegundoApellido(String funcionariocrearpatrSegundoApellido) {
        this.funcionariocrearpatrSegundoApellido = funcionariocrearpatrSegundoApellido;
    }

    @JsonIgnore
    public String getFuncionariocrearpatrUsuarioLDAP() {
        return this.funcionariocrearpatrUsuarioLDAP;
    }
    
    public void setFuncionariocrearpatrUsuarioLDAP(String funcionariocrearpatrUsuarioLDAP) {
        this.funcionariocrearpatrUsuarioLDAP = funcionariocrearpatrUsuarioLDAP;
    }

    @JsonIgnore
    public String getFuncionariocrearpatrEmail() {
        return this.funcionariocrearpatrEmail;
    }
    
    public void setFuncionariocrearpatrEmail(String funcionariocrearpatrEmail) {
        this.funcionariocrearpatrEmail = funcionariocrearpatrEmail;
    }

    @JsonIgnore
    public Boolean getFuncionariocrearpatrManual() {
        return this.funcionariocrearpatrManual;
    }
    
    public void setFuncionariocrearpatrManual(Boolean funcionariocrearpatrManual) {
        this.funcionariocrearpatrManual = funcionariocrearpatrManual;
    }

    private void checkFuncionariocrearpatrManual() throws NotNullArgumentException {
        if(this.getFuncionariocrearpatrManual() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CREAR_FUNCIONARIOCREARPATRMANUAL, FuncionarioConstants.SERV_ALIAS_CREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CREAR_FUNCIONARIOCREARPATRMANUAL);
        }
    }

    @JsonIgnore
    public String getFuncionariocrearppassword() {
        return this.funcionariocrearppassword;
    }
    
    public void setFuncionariocrearppassword(String funcionariocrearppassword) {
        this.funcionariocrearppassword = funcionariocrearppassword;
    }

    private void checkFuncionariocrearppassword() throws NotNullArgumentException {
        if(this.getFuncionariocrearppassword() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CREAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CREAR_FUNCIONARIOCREARPP4SSW0RD, FuncionarioConstants.SERV_ALIAS_CREAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CREAR_FUNCIONARIOCREARPP4SSW0RD);
        }
    }
}
