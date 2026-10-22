package com.keralty.aeusuarios.viewmodel.firma.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.firma.ds.DSFirmaNull;

public class PIUFirmaNullResponse extends QueryResponse {

    private List<DSFirmaNull> results;

    public PIUFirmaNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUFirmaNullResponse(List<DSFirmaNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSFirmaNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSFirmaNull> results) {
        this.results = results;
    }
}
