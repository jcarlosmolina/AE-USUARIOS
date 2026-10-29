package com.keralty.aeusuarios.viewmodel.solicitudnovedad.piu;

import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter.FSolicitudNovedadNumFechas;

public class PIUConsultaSolicitudNovedadRequest extends PopulationRequestViewModel{

    private FSolicitudNovedadNumFechas fSolicitudNovedadNumFechas;
    
    public void setFSolicitudNovedadNumFechas(FSolicitudNovedadNumFechas fSolicitudNovedadNumFechas) {
        this.fSolicitudNovedadNumFechas = fSolicitudNovedadNumFechas;
    }
    
    public FSolicitudNovedadNumFechas getFSolicitudNovedadNumFechas() {
        return fSolicitudNovedadNumFechas;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fSolicitudNovedadNumFechas != null)
            queryRequest.addFilterRequest(fSolicitudNovedadNumFechas.buildFilterRequest());
        return queryRequest;
    }
}
