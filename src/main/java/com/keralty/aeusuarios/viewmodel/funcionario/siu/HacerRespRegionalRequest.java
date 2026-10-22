package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.Regional;

public class HacerRespRegionalRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariohacerRespRegionalpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariohacerRespRegionalpthisAgenteInstance;

    @JsonProperty("p_agrregional_oid")
    private RegionalOid funcionariohacerRespRegionalpagrRegional;
    
    @JsonIgnore
    private Regional funcionariohacerRespRegionalpagrRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerRespRegionalpthisAgente();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerRespRegionalpthisAgente() {
        return this.funcionariohacerRespRegionalpthisAgente;
    }
    
    public void setFuncionariohacerRespRegionalpthisAgente(FuncionarioOid funcionariohacerRespRegionalpthisAgente) {
        this.funcionariohacerRespRegionalpthisAgente = funcionariohacerRespRegionalpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerRespRegionalpthisAgenteInstance() {
        return this.funcionariohacerRespRegionalpthisAgenteInstance;
    }
    
    public void setFuncionariohacerRespRegionalpthisAgenteInstance(Funcionario funcionariohacerRespRegionalpthisAgente) {
        this.funcionariohacerRespRegionalpthisAgenteInstance = funcionariohacerRespRegionalpthisAgente;
        this.funcionariohacerRespRegionalpthisAgente = funcionariohacerRespRegionalpthisAgente != null ? funcionariohacerRespRegionalpthisAgente.getOid() : null;
    }

    private void checkFuncionariohacerRespRegionalpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariohacerRespRegionalpthisAgenteInstance() == null || this.getFuncionariohacerRespRegionalpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERRESPREGIONAL, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERRESPREGIONAL_FUNCIONARIOHACERRESPREGIONALPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_HACERRESPREGIONAL, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERRESPREGIONAL_FUNCIONARIOHACERRESPREGIONALPTHISAGENTE);
        }
    }

    @JsonIgnore
    public RegionalOid getFuncionariohacerRespRegionalpagrRegional() {
        return this.funcionariohacerRespRegionalpagrRegional;
    }
    
    public void setFuncionariohacerRespRegionalpagrRegional(RegionalOid funcionariohacerRespRegionalpagrRegional) {
        this.funcionariohacerRespRegionalpagrRegional = funcionariohacerRespRegionalpagrRegional;
    }

    @JsonIgnore
    public Regional getFuncionariohacerRespRegionalpagrRegionalInstance() {
        return this.funcionariohacerRespRegionalpagrRegionalInstance;
    }
    
    public void setFuncionariohacerRespRegionalpagrRegionalInstance(Regional funcionariohacerRespRegionalpagrRegional) {
        this.funcionariohacerRespRegionalpagrRegionalInstance = funcionariohacerRespRegionalpagrRegional;
        this.funcionariohacerRespRegionalpagrRegional = funcionariohacerRespRegionalpagrRegional != null ? funcionariohacerRespRegionalpagrRegional.getOid() : null;
    }
}
