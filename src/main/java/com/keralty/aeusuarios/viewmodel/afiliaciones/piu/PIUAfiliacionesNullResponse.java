package com.keralty.aeusuarios.viewmodel.afiliaciones.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.afiliaciones.ds.DSAfiliacionesNull;

public class PIUAfiliacionesNullResponse extends QueryResponse {

    private List<DSAfiliacionesNull> results;

    public PIUAfiliacionesNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAfiliacionesNullResponse(List<DSAfiliacionesNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAfiliacionesNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAfiliacionesNull> results) {
        this.results = results;
    }
}
