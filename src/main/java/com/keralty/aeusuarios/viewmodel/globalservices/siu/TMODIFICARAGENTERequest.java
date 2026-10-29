package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Rol;

public class TMODIFICARAGENTERequest {

    @JsonProperty("pt_p_thisagente_oid")
    private FuncionarioOid tMODIFICARAGENTEptpthisAgente;
    
    @JsonIgnore
    private Funcionario tMODIFICARAGENTEptpthisAgenteInstance;

    @JsonProperty("pt_p_primernombre")
    private String tMODIFICARAGENTEptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String tMODIFICARAGENTEptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String tMODIFICARAGENTEptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String tMODIFICARAGENTEptpSegundoApellido;

    @JsonProperty("pt_nuevorol_json")
    private String tMODIFICARAGENTEptNuevoRol;
    
    @JsonIgnore
    private Rol tMODIFICARAGENTEptNuevoRolInstance;

    @JsonProperty("pt_p_atrusuarioldap")
    private String tMODIFICARAGENTEptpatrUsuarioLDAP;

    @JsonProperty("pt_p_atremail")
    private String tMODIFICARAGENTEptpatrEmail;

    @JsonProperty("pt_p_agrregional_oid")
    private RegionalOid tMODIFICARAGENTEptpagrRegional;
    
    @JsonIgnore
    private Regional tMODIFICARAGENTEptpagrRegionalInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkTMODIFICARAGENTEptpthisAgente();
        checkTMODIFICARAGENTEptpPrimerNombre();
        checkTMODIFICARAGENTEptNuevoRol();
    }

    @JsonIgnore
    public FuncionarioOid getTMODIFICARAGENTEptpthisAgente() {
        return this.tMODIFICARAGENTEptpthisAgente;
    }
    
    public void setTMODIFICARAGENTEptpthisAgente(FuncionarioOid tMODIFICARAGENTEptpthisAgente) {
        this.tMODIFICARAGENTEptpthisAgente = tMODIFICARAGENTEptpthisAgente;
    }

    @JsonIgnore
    public Funcionario getTMODIFICARAGENTEptpthisAgenteInstance() {
        return this.tMODIFICARAGENTEptpthisAgenteInstance;
    }
    
    public void setTMODIFICARAGENTEptpthisAgenteInstance(Funcionario tMODIFICARAGENTEptpthisAgente) {
        this.tMODIFICARAGENTEptpthisAgenteInstance = tMODIFICARAGENTEptpthisAgente;
        this.tMODIFICARAGENTEptpthisAgente = tMODIFICARAGENTEptpthisAgente != null ? tMODIFICARAGENTEptpthisAgente.getOid() : null;
    }

    private void checkTMODIFICARAGENTEptpthisAgente() throws NotNullArgumentException {
        if(this.getTMODIFICARAGENTEptpthisAgenteInstance() == null || this.getTMODIFICARAGENTEptpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TMODIFICARAGENTE, GlobalServiceConstants.GS_ARG_ID_TMODIFICARAGENTE_TMODIFICARAGENTEPTPTHISAGENTE, GlobalServiceConstants.G_SERV_ALIAS_TMODIFICARAGENTE, GlobalServiceConstants.GS_ARG_ALIAS_TMODIFICARAGENTE_TMODIFICARAGENTEPTPTHISAGENTE);
        }
    }

    @JsonIgnore
    public String getTMODIFICARAGENTEptpPrimerNombre() {
        return this.tMODIFICARAGENTEptpPrimerNombre;
    }
    
    public void setTMODIFICARAGENTEptpPrimerNombre(String tMODIFICARAGENTEptpPrimerNombre) {
        this.tMODIFICARAGENTEptpPrimerNombre = tMODIFICARAGENTEptpPrimerNombre;
    }

    private void checkTMODIFICARAGENTEptpPrimerNombre() throws NotNullArgumentException {
        if(this.getTMODIFICARAGENTEptpPrimerNombre() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TMODIFICARAGENTE, GlobalServiceConstants.GS_ARG_ID_TMODIFICARAGENTE_TMODIFICARAGENTEPTPPRIMERNOMBRE, GlobalServiceConstants.G_SERV_ALIAS_TMODIFICARAGENTE, GlobalServiceConstants.GS_ARG_ALIAS_TMODIFICARAGENTE_TMODIFICARAGENTEPTPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getTMODIFICARAGENTEptpSegundoNombre() {
        return this.tMODIFICARAGENTEptpSegundoNombre;
    }
    
    public void setTMODIFICARAGENTEptpSegundoNombre(String tMODIFICARAGENTEptpSegundoNombre) {
        this.tMODIFICARAGENTEptpSegundoNombre = tMODIFICARAGENTEptpSegundoNombre;
    }

    @JsonIgnore
    public String getTMODIFICARAGENTEptpPrimerApellido() {
        return this.tMODIFICARAGENTEptpPrimerApellido;
    }
    
    public void setTMODIFICARAGENTEptpPrimerApellido(String tMODIFICARAGENTEptpPrimerApellido) {
        this.tMODIFICARAGENTEptpPrimerApellido = tMODIFICARAGENTEptpPrimerApellido;
    }

    @JsonIgnore
    public String getTMODIFICARAGENTEptpSegundoApellido() {
        return this.tMODIFICARAGENTEptpSegundoApellido;
    }
    
    public void setTMODIFICARAGENTEptpSegundoApellido(String tMODIFICARAGENTEptpSegundoApellido) {
        this.tMODIFICARAGENTEptpSegundoApellido = tMODIFICARAGENTEptpSegundoApellido;
    }

    @JsonIgnore
    public String getTMODIFICARAGENTEptNuevoRol() {
        return this.tMODIFICARAGENTEptNuevoRol;
    }
    
    public void setTMODIFICARAGENTEptNuevoRol(String tMODIFICARAGENTEptNuevoRol) {
        this.tMODIFICARAGENTEptNuevoRol = tMODIFICARAGENTEptNuevoRol;
    }

    @JsonIgnore
    public Rol getTMODIFICARAGENTEptNuevoRolInstance() {
        return this.tMODIFICARAGENTEptNuevoRolInstance;
    }
    
    public void setTMODIFICARAGENTEptNuevoRolInstance(Rol tMODIFICARAGENTEptNuevoRol) {
        this.tMODIFICARAGENTEptNuevoRolInstance = tMODIFICARAGENTEptNuevoRol;
        this.tMODIFICARAGENTEptNuevoRol = tMODIFICARAGENTEptNuevoRol != null ? tMODIFICARAGENTEptNuevoRol.getOid().toJson() : "";
    }

    private void checkTMODIFICARAGENTEptNuevoRol() throws NotNullArgumentException {
        if(this.getTMODIFICARAGENTEptNuevoRolInstance() == null || this.getTMODIFICARAGENTEptNuevoRolInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TMODIFICARAGENTE, GlobalServiceConstants.GS_ARG_ID_TMODIFICARAGENTE_TMODIFICARAGENTEPTNUEVOROL, GlobalServiceConstants.G_SERV_ALIAS_TMODIFICARAGENTE, GlobalServiceConstants.GS_ARG_ALIAS_TMODIFICARAGENTE_TMODIFICARAGENTEPTNUEVOROL);
        }
    }

    @JsonIgnore
    public String getTMODIFICARAGENTEptpatrUsuarioLDAP() {
        return this.tMODIFICARAGENTEptpatrUsuarioLDAP;
    }
    
    public void setTMODIFICARAGENTEptpatrUsuarioLDAP(String tMODIFICARAGENTEptpatrUsuarioLDAP) {
        this.tMODIFICARAGENTEptpatrUsuarioLDAP = tMODIFICARAGENTEptpatrUsuarioLDAP;
    }

    @JsonIgnore
    public String getTMODIFICARAGENTEptpatrEmail() {
        return this.tMODIFICARAGENTEptpatrEmail;
    }
    
    public void setTMODIFICARAGENTEptpatrEmail(String tMODIFICARAGENTEptpatrEmail) {
        this.tMODIFICARAGENTEptpatrEmail = tMODIFICARAGENTEptpatrEmail;
    }

    @JsonIgnore
    public RegionalOid getTMODIFICARAGENTEptpagrRegional() {
        return this.tMODIFICARAGENTEptpagrRegional;
    }
    
    public void setTMODIFICARAGENTEptpagrRegional(RegionalOid tMODIFICARAGENTEptpagrRegional) {
        this.tMODIFICARAGENTEptpagrRegional = tMODIFICARAGENTEptpagrRegional;
    }

    @JsonIgnore
    public Regional getTMODIFICARAGENTEptpagrRegionalInstance() {
        return this.tMODIFICARAGENTEptpagrRegionalInstance;
    }
    
    public void setTMODIFICARAGENTEptpagrRegionalInstance(Regional tMODIFICARAGENTEptpagrRegional) {
        this.tMODIFICARAGENTEptpagrRegionalInstance = tMODIFICARAGENTEptpagrRegional;
        this.tMODIFICARAGENTEptpagrRegional = tMODIFICARAGENTEptpagrRegional != null ? tMODIFICARAGENTEptpagrRegional.getOid() : null;
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
