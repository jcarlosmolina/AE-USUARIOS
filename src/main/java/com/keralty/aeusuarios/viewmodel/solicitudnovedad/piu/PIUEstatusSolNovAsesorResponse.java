package com.keralty.aeusuarios.viewmodel.solicitudnovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolNovEstatusAsesor;

public class PIUEstatusSolNovAsesorResponse extends QueryResponse {

    private List<DSSolNovEstatusAsesor> results;

    public PIUEstatusSolNovAsesorResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUEstatusSolNovAsesorResponse(List<DSSolNovEstatusAsesor> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolNovEstatusAsesor> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolNovEstatusAsesor> results) {
        this.results = results;
    }
}
