package com.keralty.aeusuarios.viewmodel.logfuncionario.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.logfuncionario.ds.DSLogFuncionario;

public class PIULogFuncionarioResponse extends QueryResponse {

    private List<DSLogFuncionario> results;

    public PIULogFuncionarioResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIULogFuncionarioResponse(List<DSLogFuncionario> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSLogFuncionario> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSLogFuncionario> results) {
        this.results = results;
    }
}
