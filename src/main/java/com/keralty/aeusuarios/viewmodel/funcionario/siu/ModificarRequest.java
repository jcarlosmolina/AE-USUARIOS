package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class ModificarRequest {

    @JsonProperty("p_thisadmin_oid")
    private FuncionarioOid funcionariomodificarpthisAdmin;
    
    @JsonIgnore
    private Funcionario funcionariomodificarpthisAdminInstance;

    @JsonProperty("p_primernombre")
    private String funcionariomodificarpPrimerNombre;

    @JsonProperty("p_segundonombre")
    private String funcionariomodificarpSegundoNombre;

    @JsonProperty("p_primerapellido")
    private String funcionariomodificarpPrimerApellido;

    @JsonProperty("p_segundoapellido")
    private String funcionariomodificarpSegundoApellido;

    @JsonProperty("p_usuarioldap")
    private String funcionariomodificarpUsuarioLDAP;

    @JsonProperty("p_email")
    private String funcionariomodificarpEmail;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariomodificarpthisAdmin();
        checkFuncionariomodificarpPrimerNombre();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariomodificarpthisAdmin() {
        return this.funcionariomodificarpthisAdmin;
    }
    
    public void setFuncionariomodificarpthisAdmin(FuncionarioOid funcionariomodificarpthisAdmin) {
        this.funcionariomodificarpthisAdmin = funcionariomodificarpthisAdmin;
    }

    @JsonIgnore
    public Funcionario getFuncionariomodificarpthisAdminInstance() {
        return this.funcionariomodificarpthisAdminInstance;
    }
    
    public void setFuncionariomodificarpthisAdminInstance(Funcionario funcionariomodificarpthisAdmin) {
        this.funcionariomodificarpthisAdminInstance = funcionariomodificarpthisAdmin;
        this.funcionariomodificarpthisAdmin = funcionariomodificarpthisAdmin != null ? funcionariomodificarpthisAdmin.getOid() : null;
    }

    private void checkFuncionariomodificarpthisAdmin() throws NotNullArgumentException {
        if(this.getFuncionariomodificarpthisAdminInstance() == null || this.getFuncionariomodificarpthisAdminInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_MODIFICAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_MODIFICAR_FUNCIONARIOMODIFICARPTHISADMIN, FuncionarioConstants.SERV_ALIAS_MODIFICAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_MODIFICAR_FUNCIONARIOMODIFICARPTHISADMIN);
        }
    }

    @JsonIgnore
    public String getFuncionariomodificarpPrimerNombre() {
        return this.funcionariomodificarpPrimerNombre;
    }
    
    public void setFuncionariomodificarpPrimerNombre(String funcionariomodificarpPrimerNombre) {
        this.funcionariomodificarpPrimerNombre = funcionariomodificarpPrimerNombre;
    }

    private void checkFuncionariomodificarpPrimerNombre() throws NotNullArgumentException {
        if(this.getFuncionariomodificarpPrimerNombre() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_MODIFICAR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_MODIFICAR_FUNCIONARIOMODIFICARPPRIMERNOMBRE, FuncionarioConstants.SERV_ALIAS_MODIFICAR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_MODIFICAR_FUNCIONARIOMODIFICARPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getFuncionariomodificarpSegundoNombre() {
        return this.funcionariomodificarpSegundoNombre;
    }
    
    public void setFuncionariomodificarpSegundoNombre(String funcionariomodificarpSegundoNombre) {
        this.funcionariomodificarpSegundoNombre = funcionariomodificarpSegundoNombre;
    }

    @JsonIgnore
    public String getFuncionariomodificarpPrimerApellido() {
        return this.funcionariomodificarpPrimerApellido;
    }
    
    public void setFuncionariomodificarpPrimerApellido(String funcionariomodificarpPrimerApellido) {
        this.funcionariomodificarpPrimerApellido = funcionariomodificarpPrimerApellido;
    }

    @JsonIgnore
    public String getFuncionariomodificarpSegundoApellido() {
        return this.funcionariomodificarpSegundoApellido;
    }
    
    public void setFuncionariomodificarpSegundoApellido(String funcionariomodificarpSegundoApellido) {
        this.funcionariomodificarpSegundoApellido = funcionariomodificarpSegundoApellido;
    }

    @JsonIgnore
    public String getFuncionariomodificarpUsuarioLDAP() {
        return this.funcionariomodificarpUsuarioLDAP;
    }
    
    public void setFuncionariomodificarpUsuarioLDAP(String funcionariomodificarpUsuarioLDAP) {
        this.funcionariomodificarpUsuarioLDAP = funcionariomodificarpUsuarioLDAP;
    }

    @JsonIgnore
    public String getFuncionariomodificarpEmail() {
        return this.funcionariomodificarpEmail;
    }
    
    public void setFuncionariomodificarpEmail(String funcionariomodificarpEmail) {
        this.funcionariomodificarpEmail = funcionariomodificarpEmail;
    }
}
