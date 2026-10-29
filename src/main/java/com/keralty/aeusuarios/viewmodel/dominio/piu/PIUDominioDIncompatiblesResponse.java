package com.keralty.aeusuarios.viewmodel.dominio.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominioDIncompatibles;

public class PIUDominioDIncompatiblesResponse extends QueryResponse {

    private List<DSDominioDIncompatibles> results;

    public PIUDominioDIncompatiblesResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDominioDIncompatiblesResponse(List<DSDominioDIncompatibles> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSDominioDIncompatibles> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSDominioDIncompatibles> results) {
        this.results = results;
    }
}
