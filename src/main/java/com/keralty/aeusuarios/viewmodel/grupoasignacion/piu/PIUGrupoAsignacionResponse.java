package com.keralty.aeusuarios.viewmodel.grupoasignacion.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.grupoasignacion.ds.DSGrupoAsignacion;

public class PIUGrupoAsignacionResponse extends QueryResponse {

    private List<DSGrupoAsignacion> results;

    public PIUGrupoAsignacionResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUGrupoAsignacionResponse(List<DSGrupoAsignacion> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSGrupoAsignacion> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSGrupoAsignacion> results) {
        this.results = results;
    }
}
