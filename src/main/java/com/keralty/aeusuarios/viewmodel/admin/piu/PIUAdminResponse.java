package com.keralty.aeusuarios.viewmodel.admin.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.admin.ds.AutoDS;

public class PIUAdminResponse extends QueryResponse {

    private List<AutoDS> results;

    public PIUAdminResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAdminResponse(List<AutoDS> results) {
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
