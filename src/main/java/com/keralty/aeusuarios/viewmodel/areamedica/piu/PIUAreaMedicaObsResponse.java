package com.keralty.aeusuarios.viewmodel.areamedica.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.areamedica.ds.DSAreaMedica;

public class PIUAreaMedicaObsResponse extends QueryResponse {

    private List<DSAreaMedica> results;

    public PIUAreaMedicaObsResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAreaMedicaObsResponse(List<DSAreaMedica> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAreaMedica> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAreaMedica> results) {
        this.results = results;
    }
}
