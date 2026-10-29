package com.keralty.aeusuarios.viewmodel.solicitudnovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAfiliacion;

public class PIUEstatusSolNovAfiliacionResponse extends QueryResponse {

    private List<DSSolNovEstatusAfiliacion> results;

    public PIUEstatusSolNovAfiliacionResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEstatusSolNovAfiliacionResponse(List<DSSolNovEstatusAfiliacion> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolNovEstatusAfiliacion> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolNovEstatusAfiliacion> results) {
        this.results = results;
    }
}
