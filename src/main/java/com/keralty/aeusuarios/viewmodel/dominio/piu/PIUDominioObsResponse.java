package com.keralty.aeusuarios.viewmodel.dominio.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioPIU;

public class PIUDominioObsResponse extends QueryResponse {

    private List<DSDominioPIU> results;

    public PIUDominioObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDominioObsResponse(List<DSDominioPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSDominioPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSDominioPIU> results) {
        this.results = results;
    }
}
