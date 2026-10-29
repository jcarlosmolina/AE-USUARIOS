package com.keralty.aeusuarios.viewmodel.dominio.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.dominio.ds.DSDominiosPorAsesor;

public class PIUDominiosPorAsesorResponse extends QueryResponse {

    private List<DSDominiosPorAsesor> results;

    public PIUDominiosPorAsesorResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUDominiosPorAsesorResponse(List<DSDominiosPorAsesor> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSDominiosPorAsesor> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSDominiosPorAsesor> results) {
        this.results = results;
    }
}
