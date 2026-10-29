package com.keralty.aeusuarios.viewmodel.frecuenciaact.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.frecuenciaact.ds.DSFrecuenciaActPIU;

public class PIUFrecuenciaActResponse extends QueryResponse {

    private List<DSFrecuenciaActPIU> results;

    public PIUFrecuenciaActResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUFrecuenciaActResponse(List<DSFrecuenciaActPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSFrecuenciaActPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSFrecuenciaActPIU> results) {
        this.results = results;
    }
}
