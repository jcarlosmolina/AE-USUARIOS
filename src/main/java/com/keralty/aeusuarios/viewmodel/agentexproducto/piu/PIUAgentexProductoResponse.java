package com.keralty.aeusuarios.viewmodel.agentexproducto.piu;

import java.util.ArrayList;
import java.util.List;

import com.keralty.aeusuarios.viewmodel.QueryResponse;
import com.keralty.aeusuarios.viewmodel.agentexproducto.ds.DSAgentexProductoPIU;

public class PIUAgentexProductoResponse extends QueryResponse {

    private List<DSAgentexProductoPIU> results;

    public PIUAgentexProductoResponse() {
        super();
        results = new ArrayList<>();
    }
    
    public PIUAgentexProductoResponse(List<DSAgentexProductoPIU> results) {
        super();
        this.results = results;
        this.setTotalItems(results.size());
    }
    
    public List<DSAgentexProductoPIU> getResults() {
        return this.results;
    }
    
    public void setResults(List<DSAgentexProductoPIU> results) {
        this.results = results;
    }
}
