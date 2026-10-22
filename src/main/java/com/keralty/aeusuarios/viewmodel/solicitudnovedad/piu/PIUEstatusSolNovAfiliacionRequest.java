package com.keralty.aeusuarios.viewmodel.solicitudnovedad.piu;

import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter.FSolicitudNovedadEstatuAfil1;
import com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter.FSolicitudNovedadEstatuAfil2;
import com.keralty.aeusuarios.viewmodel.solicitudnovedad.filter.FSolicitudNovedadEstatuAfil3;

public class PIUEstatusSolNovAfiliacionRequest extends PopulationRequestViewModel{

    private FSolicitudNovedadEstatuAfil1 fSolicitudNovedadEstatuAfil1;

    private FSolicitudNovedadEstatuAfil2 fSolicitudNovedadEstatuAfil2;

    private FSolicitudNovedadEstatuAfil3 fSolicitudNovedadEstatuAfil3;
    
    public void setFSolicitudNovedadEstatuAfil1(FSolicitudNovedadEstatuAfil1 fSolicitudNovedadEstatuAfil1) {
        this.fSolicitudNovedadEstatuAfil1 = fSolicitudNovedadEstatuAfil1;
    }
    
    public FSolicitudNovedadEstatuAfil1 getFSolicitudNovedadEstatuAfil1() {
        return fSolicitudNovedadEstatuAfil1;
    }
    
    public void setFSolicitudNovedadEstatuAfil2(FSolicitudNovedadEstatuAfil2 fSolicitudNovedadEstatuAfil2) {
        this.fSolicitudNovedadEstatuAfil2 = fSolicitudNovedadEstatuAfil2;
    }
    
    public FSolicitudNovedadEstatuAfil2 getFSolicitudNovedadEstatuAfil2() {
        return fSolicitudNovedadEstatuAfil2;
    }
    
    public void setFSolicitudNovedadEstatuAfil3(FSolicitudNovedadEstatuAfil3 fSolicitudNovedadEstatuAfil3) {
        this.fSolicitudNovedadEstatuAfil3 = fSolicitudNovedadEstatuAfil3;
    }
    
    public FSolicitudNovedadEstatuAfil3 getFSolicitudNovedadEstatuAfil3() {
        return fSolicitudNovedadEstatuAfil3;
    }

    @Override
    public QueryRequest buildQueryRequest() {
        QueryRequest queryRequest = super.buildQueryRequest();

        if (fSolicitudNovedadEstatuAfil1 != null)
            queryRequest.addFilterRequest(fSolicitudNovedadEstatuAfil1.buildFilterRequest());

        if (fSolicitudNovedadEstatuAfil2 != null)
            queryRequest.addFilterRequest(fSolicitudNovedadEstatuAfil2.buildFilterRequest());

        if (fSolicitudNovedadEstatuAfil3 != null)
            queryRequest.addFilterRequest(fSolicitudNovedadEstatuAfil3.buildFilterRequest());
        return queryRequest;
    }
}
