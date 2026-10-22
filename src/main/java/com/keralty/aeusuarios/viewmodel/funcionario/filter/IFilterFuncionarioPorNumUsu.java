package com.keralty.aeusuarios.viewmodel.funcionario.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFilterFuncionarioPorNumUsu {

    @JsonProperty("vfnumusu")
    private String vfNumUsu;

    public IFilterFuncionarioPorNumUsu() {
        // Default constructor
    }

    @JsonIgnore
    public String getVfNumUsu() {
        return this.vfNumUsu;
    }
    
    public void setVfNumUsu(String vfNumUsu) {
        this.vfNumUsu = vfNumUsu;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(FuncionarioConstants.FILTER_NAME_IFILTERFUNCIONARIOPORNUMUSU);
        filterRequest.addFilterVariable(FuncionarioConstants.VAR_NAME_IFILTERFUNCIONARIOPORNUMUSU_VFNUMUSU, vfNumUsu);
        return filterRequest;
    }
}
