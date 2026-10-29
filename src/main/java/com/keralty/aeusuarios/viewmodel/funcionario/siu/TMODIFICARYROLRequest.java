package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Rol;

public class TMODIFICARYROLRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionarioTMODIFICARYROLpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionarioTMODIFICARYROLpthisAgenteInstance;

    @JsonProperty("pt_p_primernombre")
    private String funcionarioTMODIFICARYROLptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String funcionarioTMODIFICARYROLptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String funcionarioTMODIFICARYROLptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String funcionarioTMODIFICARYROLptpSegundoApellido;

    @JsonProperty("pt_nuevorol_oid")
    private RolOid funcionarioTMODIFICARYROLptNuevoRol;
    
    @JsonIgnore
    private Rol funcionarioTMODIFICARYROLptNuevoRolInstance;

    @JsonProperty("pt_p_atrusuarioldap")
    private String funcionarioTMODIFICARYROLptpatrUsuarioLDAP;

    @JsonProperty("pt_p_atremail")
    private String funcionarioTMODIFICARYROLptpatrEmail;

    @JsonProperty("pt_p_agrregional_oid")
    private RegionalOid funcionarioTMODIFICARYROLptpagrRegional;
    
    @JsonIgnore
    private Regional funcionarioTMODIFICARYROLptpagrRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioTMODIFICARYROLpthisAgente();
        checkFuncionarioTMODIFICARYROLptpPrimerNombre();
        checkFuncionarioTMODIFICARYROLptNuevoRol();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioTMODIFICARYROLpthisAgente() {
        return this.funcionarioTMODIFICARYROLpthisAgente;
    }
    
    public void setFuncionarioTMODIFICARYROLpthisAgente(FuncionarioOid funcionarioTMODIFICARYROLpthisAgente) {
        this.funcionarioTMODIFICARYROLpthisAgente = funcionarioTMODIFICARYROLpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionarioTMODIFICARYROLpthisAgenteInstance() {
        return this.funcionarioTMODIFICARYROLpthisAgenteInstance;
    }
    
    public void setFuncionarioTMODIFICARYROLpthisAgenteInstance(Funcionario funcionarioTMODIFICARYROLpthisAgente) {
        this.funcionarioTMODIFICARYROLpthisAgenteInstance = funcionarioTMODIFICARYROLpthisAgente;
        this.funcionarioTMODIFICARYROLpthisAgente = funcionarioTMODIFICARYROLpthisAgente != null ? funcionarioTMODIFICARYROLpthisAgente.getOid() : null;
    }

    private void checkFuncionarioTMODIFICARYROLpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionarioTMODIFICARYROLpthisAgenteInstance() == null || this.getFuncionarioTMODIFICARYROLpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TMODIFICARYROL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TMODIFICARYROL_FUNCIONARIOTMODIFICARYROLPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_TMODIFICARYROL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TMODIFICARYROL_FUNCIONARIOTMODIFICARYROLPTHISAGENTE);
        }
    }

    @JsonIgnore
    public String getFuncionarioTMODIFICARYROLptpPrimerNombre() {
        return this.funcionarioTMODIFICARYROLptpPrimerNombre;
    }
    
    public void setFuncionarioTMODIFICARYROLptpPrimerNombre(String funcionarioTMODIFICARYROLptpPrimerNombre) {
        this.funcionarioTMODIFICARYROLptpPrimerNombre = funcionarioTMODIFICARYROLptpPrimerNombre;
    }

    private void checkFuncionarioTMODIFICARYROLptpPrimerNombre() throws NotNullArgumentException {
        if(this.getFuncionarioTMODIFICARYROLptpPrimerNombre() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TMODIFICARYROL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TMODIFICARYROL_FUNCIONARIOTMODIFICARYROLPTPPRIMERNOMBRE, FuncionarioConstants.SERV_ALIAS_TMODIFICARYROL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TMODIFICARYROL_FUNCIONARIOTMODIFICARYROLPTPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getFuncionarioTMODIFICARYROLptpSegundoNombre() {
        return this.funcionarioTMODIFICARYROLptpSegundoNombre;
    }
    
    public void setFuncionarioTMODIFICARYROLptpSegundoNombre(String funcionarioTMODIFICARYROLptpSegundoNombre) {
        this.funcionarioTMODIFICARYROLptpSegundoNombre = funcionarioTMODIFICARYROLptpSegundoNombre;
    }

    @JsonIgnore
    public String getFuncionarioTMODIFICARYROLptpPrimerApellido() {
        return this.funcionarioTMODIFICARYROLptpPrimerApellido;
    }
    
    public void setFuncionarioTMODIFICARYROLptpPrimerApellido(String funcionarioTMODIFICARYROLptpPrimerApellido) {
        this.funcionarioTMODIFICARYROLptpPrimerApellido = funcionarioTMODIFICARYROLptpPrimerApellido;
    }

    @JsonIgnore
    public String getFuncionarioTMODIFICARYROLptpSegundoApellido() {
        return this.funcionarioTMODIFICARYROLptpSegundoApellido;
    }
    
    public void setFuncionarioTMODIFICARYROLptpSegundoApellido(String funcionarioTMODIFICARYROLptpSegundoApellido) {
        this.funcionarioTMODIFICARYROLptpSegundoApellido = funcionarioTMODIFICARYROLptpSegundoApellido;
    }

    @JsonIgnore
    public RolOid getFuncionarioTMODIFICARYROLptNuevoRol() {
        return this.funcionarioTMODIFICARYROLptNuevoRol;
    }
    
    public void setFuncionarioTMODIFICARYROLptNuevoRol(RolOid funcionarioTMODIFICARYROLptNuevoRol) {
        this.funcionarioTMODIFICARYROLptNuevoRol = funcionarioTMODIFICARYROLptNuevoRol;
    }

    @JsonIgnore
    public Rol getFuncionarioTMODIFICARYROLptNuevoRolInstance() {
        return this.funcionarioTMODIFICARYROLptNuevoRolInstance;
    }
    
    public void setFuncionarioTMODIFICARYROLptNuevoRolInstance(Rol funcionarioTMODIFICARYROLptNuevoRol) {
        this.funcionarioTMODIFICARYROLptNuevoRolInstance = funcionarioTMODIFICARYROLptNuevoRol;
        this.funcionarioTMODIFICARYROLptNuevoRol = funcionarioTMODIFICARYROLptNuevoRol != null ? funcionarioTMODIFICARYROLptNuevoRol.getOid() : null;
    }

    private void checkFuncionarioTMODIFICARYROLptNuevoRol() throws NotNullArgumentException {
        if(this.getFuncionarioTMODIFICARYROLptNuevoRolInstance() == null || this.getFuncionarioTMODIFICARYROLptNuevoRolInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TMODIFICARYROL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TMODIFICARYROL_FUNCIONARIOTMODIFICARYROLPTNUEVOROL, FuncionarioConstants.SERV_ALIAS_TMODIFICARYROL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TMODIFICARYROL_FUNCIONARIOTMODIFICARYROLPTNUEVOROL);
        }
    }

    @JsonIgnore
    public String getFuncionarioTMODIFICARYROLptpatrUsuarioLDAP() {
        return this.funcionarioTMODIFICARYROLptpatrUsuarioLDAP;
    }
    
    public void setFuncionarioTMODIFICARYROLptpatrUsuarioLDAP(String funcionarioTMODIFICARYROLptpatrUsuarioLDAP) {
        this.funcionarioTMODIFICARYROLptpatrUsuarioLDAP = funcionarioTMODIFICARYROLptpatrUsuarioLDAP;
    }

    @JsonIgnore
    public String getFuncionarioTMODIFICARYROLptpatrEmail() {
        return this.funcionarioTMODIFICARYROLptpatrEmail;
    }
    
    public void setFuncionarioTMODIFICARYROLptpatrEmail(String funcionarioTMODIFICARYROLptpatrEmail) {
        this.funcionarioTMODIFICARYROLptpatrEmail = funcionarioTMODIFICARYROLptpatrEmail;
    }

    @JsonIgnore
    public RegionalOid getFuncionarioTMODIFICARYROLptpagrRegional() {
        return this.funcionarioTMODIFICARYROLptpagrRegional;
    }
    
    public void setFuncionarioTMODIFICARYROLptpagrRegional(RegionalOid funcionarioTMODIFICARYROLptpagrRegional) {
        this.funcionarioTMODIFICARYROLptpagrRegional = funcionarioTMODIFICARYROLptpagrRegional;
    }

    @JsonIgnore
    public Regional getFuncionarioTMODIFICARYROLptpagrRegionalInstance() {
        return this.funcionarioTMODIFICARYROLptpagrRegionalInstance;
    }
    
    public void setFuncionarioTMODIFICARYROLptpagrRegionalInstance(Regional funcionarioTMODIFICARYROLptpagrRegional) {
        this.funcionarioTMODIFICARYROLptpagrRegionalInstance = funcionarioTMODIFICARYROLptpagrRegional;
        this.funcionarioTMODIFICARYROLptpagrRegional = funcionarioTMODIFICARYROLptpagrRegional != null ? funcionarioTMODIFICARYROLptpagrRegional.getOid() : null;
    }
}
