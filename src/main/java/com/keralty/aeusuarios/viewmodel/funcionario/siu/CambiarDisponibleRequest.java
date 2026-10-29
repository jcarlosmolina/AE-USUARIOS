package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class CambiarDisponibleRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionariocambiarDisponiblepthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionariocambiarDisponiblepthisFuncionarioInstance;

    @JsonProperty("pedisponible")
    private Boolean funcionariocambiarDisponiblepeDisponible;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariocambiarDisponiblepthisFuncionario();
        checkFuncionariocambiarDisponiblepeDisponible();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariocambiarDisponiblepthisFuncionario() {
        return this.funcionariocambiarDisponiblepthisFuncionario;
    }
    
    public void setFuncionariocambiarDisponiblepthisFuncionario(FuncionarioOid funcionariocambiarDisponiblepthisFuncionario) {
        this.funcionariocambiarDisponiblepthisFuncionario = funcionariocambiarDisponiblepthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionariocambiarDisponiblepthisFuncionarioInstance() {
        return this.funcionariocambiarDisponiblepthisFuncionarioInstance;
    }
    
    public void setFuncionariocambiarDisponiblepthisFuncionarioInstance(Funcionario funcionariocambiarDisponiblepthisFuncionario) {
        this.funcionariocambiarDisponiblepthisFuncionarioInstance = funcionariocambiarDisponiblepthisFuncionario;
        this.funcionariocambiarDisponiblepthisFuncionario = funcionariocambiarDisponiblepthisFuncionario != null ? funcionariocambiarDisponiblepthisFuncionario.getOid() : null;
    }

    private void checkFuncionariocambiarDisponiblepthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionariocambiarDisponiblepthisFuncionarioInstance() == null || this.getFuncionariocambiarDisponiblepthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CAMBIARDISPONIBLE_FUNCIONARIOCAMBIARDISPONIBLEPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_CAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CAMBIARDISPONIBLE_FUNCIONARIOCAMBIARDISPONIBLEPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public Boolean getFuncionariocambiarDisponiblepeDisponible() {
        return this.funcionariocambiarDisponiblepeDisponible;
    }
    
    public void setFuncionariocambiarDisponiblepeDisponible(Boolean funcionariocambiarDisponiblepeDisponible) {
        this.funcionariocambiarDisponiblepeDisponible = funcionariocambiarDisponiblepeDisponible;
    }

    private void checkFuncionariocambiarDisponiblepeDisponible() throws NotNullArgumentException {
        if(this.getFuncionariocambiarDisponiblepeDisponible() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CAMBIARDISPONIBLE_FUNCIONARIOCAMBIARDISPONIBLEPEDISPONIBLE, FuncionarioConstants.SERV_ALIAS_CAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CAMBIARDISPONIBLE_FUNCIONARIOCAMBIARDISPONIBLEPEDISPONIBLE);
        }
    }
}
