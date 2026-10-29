package com.keralty.aeusuarios.viewmodel.productos.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.productos.ds.AutoDS;

public class PIUProductosObsResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUProductosObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUProductosObsResponse(List<AutoDS> results) {
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
