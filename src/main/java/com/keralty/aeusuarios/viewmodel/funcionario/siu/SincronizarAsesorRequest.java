package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class SincronizarAsesorRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariosincronizarAsesorpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariosincronizarAsesorpthisAgenteInstance;

    @JsonProperty("p_primernombre")
    private String funcionariosincronizarAsesorpPrimerNombre;

    @JsonProperty("p_segundonombre")
    private String funcionariosincronizarAsesorpSegundoNombre;

    @JsonProperty("p_primerapellido")
    private String funcionariosincronizarAsesorpPrimerApellido;

    @JsonProperty("p_segundoapellido")
    private String funcionariosincronizarAsesorpSegundoApellido;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariosincronizarAsesorpthisAgente();
        checkFuncionariosincronizarAsesorpPrimerNombre();
        checkFuncionariosincronizarAsesorpPrimerApellido();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariosincronizarAsesorpthisAgente() {
        return this.funcionariosincronizarAsesorpthisAgente;
    }
    
    public void setFuncionariosincronizarAsesorpthisAgente(FuncionarioOid funcionariosincronizarAsesorpthisAgente) {
        this.funcionariosincronizarAsesorpthisAgente = funcionariosincronizarAsesorpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariosincronizarAsesorpthisAgenteInstance() {
        return this.funcionariosincronizarAsesorpthisAgenteInstance;
    }
    
    public void setFuncionariosincronizarAsesorpthisAgenteInstance(Funcionario funcionariosincronizarAsesorpthisAgente) {
        this.funcionariosincronizarAsesorpthisAgenteInstance = funcionariosincronizarAsesorpthisAgente;
        this.funcionariosincronizarAsesorpthisAgente = funcionariosincronizarAsesorpthisAgente != null ? funcionariosincronizarAsesorpthisAgente.getOid() : null;
    }

    private void checkFuncionariosincronizarAsesorpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariosincronizarAsesorpthisAgenteInstance() == null || this.getFuncionariosincronizarAsesorpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_SINCRONIZARASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_SINCRONIZARASESOR_FUNCIONARIOSINCRONIZARASESORPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_SINCRONIZARASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_SINCRONIZARASESOR_FUNCIONARIOSINCRONIZARASESORPTHISAGENTE);
        }
    }

    @JsonIgnore
    public String getFuncionariosincronizarAsesorpPrimerNombre() {
        return this.funcionariosincronizarAsesorpPrimerNombre;
    }
    
    public void setFuncionariosincronizarAsesorpPrimerNombre(String funcionariosincronizarAsesorpPrimerNombre) {
        this.funcionariosincronizarAsesorpPrimerNombre = funcionariosincronizarAsesorpPrimerNombre;
    }

    private void checkFuncionariosincronizarAsesorpPrimerNombre() throws NotNullArgumentException {
        if(this.getFuncionariosincronizarAsesorpPrimerNombre() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_SINCRONIZARASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_SINCRONIZARASESOR_FUNCIONARIOSINCRONIZARASESORPPRIMERNOMBRE, FuncionarioConstants.SERV_ALIAS_SINCRONIZARASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_SINCRONIZARASESOR_FUNCIONARIOSINCRONIZARASESORPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getFuncionariosincronizarAsesorpSegundoNombre() {
        return this.funcionariosincronizarAsesorpSegundoNombre;
    }
    
    public void setFuncionariosincronizarAsesorpSegundoNombre(String funcionariosincronizarAsesorpSegundoNombre) {
        this.funcionariosincronizarAsesorpSegundoNombre = funcionariosincronizarAsesorpSegundoNombre;
    }

    @JsonIgnore
    public String getFuncionariosincronizarAsesorpPrimerApellido() {
        return this.funcionariosincronizarAsesorpPrimerApellido;
    }
    
    public void setFuncionariosincronizarAsesorpPrimerApellido(String funcionariosincronizarAsesorpPrimerApellido) {
        this.funcionariosincronizarAsesorpPrimerApellido = funcionariosincronizarAsesorpPrimerApellido;
    }

    private void checkFuncionariosincronizarAsesorpPrimerApellido() throws NotNullArgumentException {
        if(this.getFuncionariosincronizarAsesorpPrimerApellido() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_SINCRONIZARASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_SINCRONIZARASESOR_FUNCIONARIOSINCRONIZARASESORPPRIMERAPELLIDO, FuncionarioConstants.SERV_ALIAS_SINCRONIZARASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_SINCRONIZARASESOR_FUNCIONARIOSINCRONIZARASESORPPRIMERAPELLIDO);
        }
    }

    @JsonIgnore
    public String getFuncionariosincronizarAsesorpSegundoApellido() {
        return this.funcionariosincronizarAsesorpSegundoApellido;
    }
    
    public void setFuncionariosincronizarAsesorpSegundoApellido(String funcionariosincronizarAsesorpSegundoApellido) {
        this.funcionariosincronizarAsesorpSegundoApellido = funcionariosincronizarAsesorpSegundoApellido;
    }
}
