package com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.ds.DSUsuarioSistemaExterno;

public class PIUUsuarioSistemaExternoResponse extends QueryResponse {

    private List<DSUsuarioSistemaExterno> results;

    public PIUUsuarioSistemaExternoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUUsuarioSistemaExternoResponse(List<DSUsuarioSistemaExterno> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSUsuarioSistemaExterno> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSUsuarioSistemaExterno> results) {
        this.results = results;
    }
}
