package com.keralty.aeusuarios.viewmodel.planes.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.planes.ds.DSPlanesDAfiliacion;

public class PIUPlanesDAfiliacionResponse extends QueryResponse {

    private List<DSPlanesDAfiliacion> results;

    public PIUPlanesDAfiliacionResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUPlanesDAfiliacionResponse(List<DSPlanesDAfiliacion> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSPlanesDAfiliacion> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSPlanesDAfiliacion> results) {
        this.results = results;
    }
}
