package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class TCAMBIARDISPONIBLERequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioTCAMBIARDISPONIBLEpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance;

    @JsonProperty("pt_pedisponible")
    private Boolean funcionarioTCAMBIARDISPONIBLEptpeDisponible;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioTCAMBIARDISPONIBLEpthisFuncionario();
        checkFuncionarioTCAMBIARDISPONIBLEptpeDisponible();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioTCAMBIARDISPONIBLEpthisFuncionario() {
        return this.funcionarioTCAMBIARDISPONIBLEpthisFuncionario;
    }
    
    public void setFuncionarioTCAMBIARDISPONIBLEpthisFuncionario(FuncionarioOid funcionarioTCAMBIARDISPONIBLEpthisFuncionario) {
        this.funcionarioTCAMBIARDISPONIBLEpthisFuncionario = funcionarioTCAMBIARDISPONIBLEpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance() {
        return this.funcionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance;
    }
    
    public void setFuncionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance(Funcionario funcionarioTCAMBIARDISPONIBLEpthisFuncionario) {
        this.funcionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance = funcionarioTCAMBIARDISPONIBLEpthisFuncionario;
        this.funcionarioTCAMBIARDISPONIBLEpthisFuncionario = funcionarioTCAMBIARDISPONIBLEpthisFuncionario != null ? funcionarioTCAMBIARDISPONIBLEpthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioTCAMBIARDISPONIBLEpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance() == null || this.getFuncionarioTCAMBIARDISPONIBLEpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCAMBIARDISPONIBLE_FUNCIONARIOTCAMBIARDISPONIBLEPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_TCAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCAMBIARDISPONIBLE_FUNCIONARIOTCAMBIARDISPONIBLEPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public Boolean getFuncionarioTCAMBIARDISPONIBLEptpeDisponible() {
        return this.funcionarioTCAMBIARDISPONIBLEptpeDisponible;
    }
    
    public void setFuncionarioTCAMBIARDISPONIBLEptpeDisponible(Boolean funcionarioTCAMBIARDISPONIBLEptpeDisponible) {
        this.funcionarioTCAMBIARDISPONIBLEptpeDisponible = funcionarioTCAMBIARDISPONIBLEptpeDisponible;
    }

    private void checkFuncionarioTCAMBIARDISPONIBLEptpeDisponible() throws NotNullArgumentException {
        if(this.getFuncionarioTCAMBIARDISPONIBLEptpeDisponible() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_TCAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_TCAMBIARDISPONIBLE_FUNCIONARIOTCAMBIARDISPONIBLEPTPEDISPONIBLE, FuncionarioConstants.SERV_ALIAS_TCAMBIARDISPONIBLE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_TCAMBIARDISPONIBLE_FUNCIONARIOTCAMBIARDISPONIBLEPTPEDISPONIBLE);
        }
    }
}
