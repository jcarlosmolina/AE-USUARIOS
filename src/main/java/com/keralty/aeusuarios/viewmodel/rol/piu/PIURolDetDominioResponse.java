package com.keralty.aeusuarios.viewmodel.rol.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.rol.ds.AutoDS;

public class PIURolDetDominioResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIURolDetDominioResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIURolDetDominioResponse(List<AutoDS> results) {
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
