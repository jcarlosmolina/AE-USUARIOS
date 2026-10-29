package com.keralty.aeusuarios.viewmodel.funcionario.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Admin;
import com.keralty.aeusuarios.persistence.SuperAdmin;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.AreaMedica;
import com.keralty.aeusuarios.persistence.Afiliaciones;
import com.keralty.aeusuarios.persistence.RespRegional;
import com.keralty.aeusuarios.persistence.Gestor;
import com.keralty.aeusuarios.persistence.MesaDeApoyo;
public class ICAgente {

    @JsonProperty("primernombre")
    private String iCAgentePrimerNombre;

    @JsonProperty("segundonombre")
    private String iCAgenteSegundoNombre;

    @JsonProperty("primerapellido")
    private String iCAgentePrimerApellido;

    @JsonProperty("segundoapellido")
    private String iCAgenteSegundoApellido;

    public ICAgente() {
    
    }

    public ICAgente(Funcionario instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(Admin instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(SuperAdmin instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(Asesor instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(AreaMedica instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(Afiliaciones instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(RespRegional instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(Gestor instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    public ICAgente(MesaDeApoyo instance) {
        if (instance != null) {
            this.iCAgentePrimerNombre = instance.getFuncionarioPrimerNombre();
            this.iCAgenteSegundoNombre = instance.getFuncionarioSegundoNombre();
            this.iCAgentePrimerApellido = instance.getFuncionarioPrimerApellido();
            this.iCAgenteSegundoApellido = instance.getFuncionarioSegundoApellido();
        }
    }

    @JsonIgnore
    public String getICAgentePrimerNombre() {
        return this.iCAgentePrimerNombre;
    }
    
    public void setICAgentePrimerNombre(String iCAgentePrimerNombre) {
        this.iCAgentePrimerNombre = iCAgentePrimerNombre;
    }

    @JsonIgnore
    public String getICAgenteSegundoNombre() {
        return this.iCAgenteSegundoNombre;
    }
    
    public void setICAgenteSegundoNombre(String iCAgenteSegundoNombre) {
        this.iCAgenteSegundoNombre = iCAgenteSegundoNombre;
    }

    @JsonIgnore
    public String getICAgentePrimerApellido() {
        return this.iCAgentePrimerApellido;
    }
    
    public void setICAgentePrimerApellido(String iCAgentePrimerApellido) {
        this.iCAgentePrimerApellido = iCAgentePrimerApellido;
    }

    @JsonIgnore
    public String getICAgenteSegundoApellido() {
        return this.iCAgenteSegundoApellido;
    }
    
    public void setICAgenteSegundoApellido(String iCAgenteSegundoApellido) {
        this.iCAgenteSegundoApellido = iCAgenteSegundoApellido;
    }
}
