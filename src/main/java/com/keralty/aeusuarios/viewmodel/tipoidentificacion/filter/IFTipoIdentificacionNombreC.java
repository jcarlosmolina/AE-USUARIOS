package com.keralty.aeusuarios.viewmodel.tipoidentificacion.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.viewmodel.FilterRequest;

public class IFTipoIdentificacionNombreC {

    @JsonProperty("v_nombrecorto")
    private String vNombreCorto;

    public IFTipoIdentificacionNombreC() {
        // Default constructor
    }

    @JsonIgnore
    public String getVNombreCorto() {
        return this.vNombreCorto;
    }
    
    public void setVNombreCorto(String vNombreCorto) {
        this.vNombreCorto = vNombreCorto;
    }

    public FilterRequest buildFilterRequest() {
        FilterRequest filterRequest = new FilterRequest();
        filterRequest.setName(TipoIdentificacionConstants.FILTER_NAME_IFTIPOIDENTIFICACIONNOMBREC);
        filterRequest.addFilterVariable(TipoIdentificacionConstants.VAR_NAME_IFTIPOIDENTIFICACIONNOMBREC_VNOMBRECORTO, vNombreCorto);
        return filterRequest;
    }
}
