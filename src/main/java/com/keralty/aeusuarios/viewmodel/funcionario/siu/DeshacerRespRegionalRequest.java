package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;

public class DeshacerRespRegionalRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariodeshacerRespRegionalpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariodeshacerRespRegionalpthisAgenteInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariodeshacerRespRegionalpthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariodeshacerRespRegionalpthisAgente() {
        return this.funcionariodeshacerRespRegionalpthisAgente;
    }
    
    public void setFuncionariodeshacerRespRegionalpthisAgente(FuncionarioOid funcionariodeshacerRespRegionalpthisAgente) {
        this.funcionariodeshacerRespRegionalpthisAgente = funcionariodeshacerRespRegionalpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariodeshacerRespRegionalpthisAgenteInstance() {
        return this.funcionariodeshacerRespRegionalpthisAgenteInstance;
    }
    
    public void setFuncionariodeshacerRespRegionalpthisAgenteInstance(Funcionario funcionariodeshacerRespRegionalpthisAgente) {
        this.funcionariodeshacerRespRegionalpthisAgenteInstance = funcionariodeshacerRespRegionalpthisAgente;
        this.funcionariodeshacerRespRegionalpthisAgente = funcionariodeshacerRespRegionalpthisAgente != null ? funcionariodeshacerRespRegionalpthisAgente.getOid() : null;
    }

    private void checkFuncionariodeshacerRespRegionalpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariodeshacerRespRegionalpthisAgenteInstance() == null || this.getFuncionariodeshacerRespRegionalpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DESHACERRESPREGIONAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DESHACERRESPREGIONAL_FUNCIONARIODESHACERRESPREGIONALPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_DESHACERRESPREGIONAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DESHACERRESPREGIONAL_FUNCIONARIODESHACERRESPREGIONALPTHISAGENTE);
        }
    }
}
