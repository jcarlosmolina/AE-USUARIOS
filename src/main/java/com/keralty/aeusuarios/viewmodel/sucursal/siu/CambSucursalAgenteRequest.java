package com.keralty.aeusuarios.viewmodel.sucursal.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Sucursal;

public class CambSucursalAgenteRequest {

    @JsonProperty("p_thissucursal_oid")
    private SucursalOid sucursalCambSucursalAgentepthisSucursal;
    
    @JsonIgnore
    private Sucursal sucursalCambSucursalAgentepthisSucursalInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid sucursalCambSucursalAgentepevcFuncionario;
    
    @JsonIgnore
    private Funcionario sucursalCambSucursalAgentepevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSucursalCambSucursalAgentepthisSucursal();
        checkSucursalCambSucursalAgentepevcFuncionario();
    }

    @JsonIgnore
    public SucursalOid getSucursalCambSucursalAgentepthisSucursal() {
        return this.sucursalCambSucursalAgentepthisSucursal;
    }
    
    public void setSucursalCambSucursalAgentepthisSucursal(SucursalOid sucursalCambSucursalAgentepthisSucursal) {
        this.sucursalCambSucursalAgentepthisSucursal = sucursalCambSucursalAgentepthisSucursal;
    }

    @JsonIgnore
    public Sucursal getSucursalCambSucursalAgentepthisSucursalInstance() {
        return this.sucursalCambSucursalAgentepthisSucursalInstance;
    }
    
    public void setSucursalCambSucursalAgentepthisSucursalInstance(Sucursal sucursalCambSucursalAgentepthisSucursal) {
        this.sucursalCambSucursalAgentepthisSucursalInstance = sucursalCambSucursalAgentepthisSucursal;
        this.sucursalCambSucursalAgentepthisSucursal = sucursalCambSucursalAgentepthisSucursal != null ? sucursalCambSucursalAgentepthisSucursal.getOid() : null;
    }

    private void checkSucursalCambSucursalAgentepthisSucursal() throws NotNullArgumentException {
        if(this.getSucursalCambSucursalAgentepthisSucursalInstance() == null || this.getSucursalCambSucursalAgentepthisSucursalInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_CAMBSUCURSALAGENTE, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_CAMBSUCURSALAGENTE_SUCURSALCAMBSUCURSALAGENTEPTHISSUCURSAL, SucursalConstants.SERV_ALIAS_CAMBSUCURSALAGENTE, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_CAMBSUCURSALAGENTE_SUCURSALCAMBSUCURSALAGENTEPTHISSUCURSAL);
        }
    }

    @JsonIgnore
    public FuncionarioOid getSucursalCambSucursalAgentepevcFuncionario() {
        return this.sucursalCambSucursalAgentepevcFuncionario;
    }
    
    public void setSucursalCambSucursalAgentepevcFuncionario(FuncionarioOid sucursalCambSucursalAgentepevcFuncionario) {
        this.sucursalCambSucursalAgentepevcFuncionario = sucursalCambSucursalAgentepevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getSucursalCambSucursalAgentepevcFuncionarioInstance() {
        return this.sucursalCambSucursalAgentepevcFuncionarioInstance;
    }
    
    public void setSucursalCambSucursalAgentepevcFuncionarioInstance(Funcionario sucursalCambSucursalAgentepevcFuncionario) {
        this.sucursalCambSucursalAgentepevcFuncionarioInstance = sucursalCambSucursalAgentepevcFuncionario;
        this.sucursalCambSucursalAgentepevcFuncionario = sucursalCambSucursalAgentepevcFuncionario != null ? sucursalCambSucursalAgentepevcFuncionario.getOid() : null;
    }

    private void checkSucursalCambSucursalAgentepevcFuncionario() throws NotNullArgumentException {
        if(this.getSucursalCambSucursalAgentepevcFuncionarioInstance() == null || this.getSucursalCambSucursalAgentepevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(SucursalConstants.SERV_ID_CAMBSUCURSALAGENTE, SucursalConstants.CLASS_ID, SucursalConstants.ARG_ID_CAMBSUCURSALAGENTE_SUCURSALCAMBSUCURSALAGENTEPEVCFUNCIONARIO, SucursalConstants.SERV_ALIAS_CAMBSUCURSALAGENTE, SucursalConstants.CLASS_ALIAS, SucursalConstants.ARG_ALIAS_CAMBSUCURSALAGENTE_SUCURSALCAMBSUCURSALAGENTEPEVCFUNCIONARIO);
        }
    }
}
