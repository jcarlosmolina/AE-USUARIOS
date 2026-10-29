package com.keralty.aeusuarios.viewmodel.grupoasignacion.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.AutoDS;

public class PIUGrupoAsignacion1Response extends QueryResponse {

    private List<AutoDS> results;

    public PIUGrupoAsignacion1Response() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUGrupoAsignacion1Response(List<AutoDS> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<AutoDS> getResults() {
        return this.results;
    }
    
    public void setResults(List<AutoDS> results) {
        this.results = results;
    }
}
