package com.keralty.aeusuarios.viewmodel.asesor.piu;

import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.asesor.filter.FDirectores;

public class PIUDirectoresRequest extends PopulationRequestViewModel{

    private FDirectores fDirectores;
    
    public void setFDirectores(FDirectores fDirectores) {
        this.fDirectores = fDirectores;
    }
    
    public FDirectores getFDirectores() {
        return fDirectores;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fDirectores != null)
            queryRequest.addFilterRequest(fDirectores.buildFilterRequest());
        return queryRequest;
    }
}
