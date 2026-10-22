package com.keralty.aeusuarios.viewmodel.areamedica.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.areamedica.ds.DSAreaMedicaNull;

public class PIUAreaMedicaNullResponse extends QueryResponse {

    private List<DSAreaMedicaNull> results;

    public PIUAreaMedicaNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAreaMedicaNullResponse(List<DSAreaMedicaNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAreaMedicaNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAreaMedicaNull> results) {
        this.results = results;
    }
}
