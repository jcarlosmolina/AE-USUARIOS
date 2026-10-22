package com.keralty.aeusuarios.viewmodel.solicitudnovedad.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.solicitudnovedad.ds.DSSolicitudNovedadNull;

public class PIUSolicitudNovedadNullResponse extends QueryResponse {

    private List<DSSolicitudNovedadNull> results;

    public PIUSolicitudNovedadNullResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUSolicitudNovedadNullResponse(List<DSSolicitudNovedadNull> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSSolicitudNovedadNull> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSSolicitudNovedadNull> results) {
        this.results = results;
    }
}
