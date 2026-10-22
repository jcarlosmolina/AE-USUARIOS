package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Sucursal;

public class CambSucursalAgenteRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionarioCambSucursalAgentepthisAgente;
    
    @JsonIgnore
    private Funcionario funcionarioCambSucursalAgentepthisAgenteInstance;

    @JsonProperty("p_evcsucursal_oid")
    private SucursalOid funcionarioCambSucursalAgentepevcSucursal;
    
    @JsonIgnore
    private Sucursal funcionarioCambSucursalAgentepevcSucursalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioCambSucursalAgentepthisAgente();
        checkFuncionarioCambSucursalAgentepevcSucursal();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioCambSucursalAgentepthisAgente() {
        return this.funcionarioCambSucursalAgentepthisAgente;
    }
    
    public void setFuncionarioCambSucursalAgentepthisAgente(FuncionarioOid funcionarioCambSucursalAgentepthisAgente) {
        this.funcionarioCambSucursalAgentepthisAgente = funcionarioCambSucursalAgentepthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionarioCambSucursalAgentepthisAgenteInstance() {
        return this.funcionarioCambSucursalAgentepthisAgenteInstance;
    }
    
    public void setFuncionarioCambSucursalAgentepthisAgenteInstance(Funcionario funcionarioCambSucursalAgentepthisAgente) {
        this.funcionarioCambSucursalAgentepthisAgenteInstance = funcionarioCambSucursalAgentepthisAgente;
        this.funcionarioCambSucursalAgentepthisAgente = funcionarioCambSucursalAgentepthisAgente != null ? funcionarioCambSucursalAgentepthisAgente.getOid() : null;
    }

    private void checkFuncionarioCambSucursalAgentepthisAgente() throws NotNullArgumentException {
        if(this.getFuncionarioCambSucursalAgentepthisAgenteInstance() == null || this.getFuncionarioCambSucursalAgentepthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CAMBSUCURSALAGENTE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CAMBSUCURSALAGENTE_FUNCIONARIOCAMBSUCURSALAGENTEPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_CAMBSUCURSALAGENTE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CAMBSUCURSALAGENTE_FUNCIONARIOCAMBSUCURSALAGENTEPTHISAGENTE);
        }
    }

    @JsonIgnore
    public SucursalOid getFuncionarioCambSucursalAgentepevcSucursal() {
        return this.funcionarioCambSucursalAgentepevcSucursal;
    }
    
    public void setFuncionarioCambSucursalAgentepevcSucursal(SucursalOid funcionarioCambSucursalAgentepevcSucursal) {
        this.funcionarioCambSucursalAgentepevcSucursal = funcionarioCambSucursalAgentepevcSucursal;
    }

    @JsonIgnore
    public Sucursal getFuncionarioCambSucursalAgentepevcSucursalInstance() {
        return this.funcionarioCambSucursalAgentepevcSucursalInstance;
    }
    
    public void setFuncionarioCambSucursalAgentepevcSucursalInstance(Sucursal funcionarioCambSucursalAgentepevcSucursal) {
        this.funcionarioCambSucursalAgentepevcSucursalInstance = funcionarioCambSucursalAgentepevcSucursal;
        this.funcionarioCambSucursalAgentepevcSucursal = funcionarioCambSucursalAgentepevcSucursal != null ? funcionarioCambSucursalAgentepevcSucursal.getOid() : null;
    }

    private void checkFuncionarioCambSucursalAgentepevcSucursal() throws NotNullArgumentException {
        if(this.getFuncionarioCambSucursalAgentepevcSucursalInstance() == null || this.getFuncionarioCambSucursalAgentepevcSucursalInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_CAMBSUCURSALAGENTE, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_CAMBSUCURSALAGENTE_FUNCIONARIOCAMBSUCURSALAGENTEPEVCSUCURSAL, FuncionarioConstants.SERV_ALIAS_CAMBSUCURSALAGENTE, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_CAMBSUCURSALAGENTE_FUNCIONARIOCAMBSUCURSALAGENTEPEVCSUCURSAL);
        }
    }
}
