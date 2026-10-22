package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class ModVisibilidadRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesormodVisibilidadpthisAsesor;
    
    @JsonIgnore
    private Asesor asesormodVisibilidadpthisAsesorInstance;

    @JsonProperty("pverdatospersona")
    private Boolean asesormodVisibilidadpVerDatosPersona;

    @JsonProperty("pverdocspersona")
    private Boolean asesormodVisibilidadpVerDocsPersona;

    @JsonProperty("pvercontratonovedad")
    private Boolean asesormodVisibilidadpVerContratoNovedad;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesormodVisibilidadpthisAsesor();
        checkAsesormodVisibilidadpVerDatosPersona();
        checkAsesormodVisibilidadpVerDocsPersona();
        checkAsesormodVisibilidadpVerContratoNovedad();
    }

    @JsonIgnore
    public AsesorOid getAsesormodVisibilidadpthisAsesor() {
        return this.asesormodVisibilidadpthisAsesor;
    }
    
    public void setAsesormodVisibilidadpthisAsesor(AsesorOid asesormodVisibilidadpthisAsesor) {
        this.asesormodVisibilidadpthisAsesor = asesormodVisibilidadpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesormodVisibilidadpthisAsesorInstance() {
        return this.asesormodVisibilidadpthisAsesorInstance;
    }
    
    public void setAsesormodVisibilidadpthisAsesorInstance(Asesor asesormodVisibilidadpthisAsesor) {
        this.asesormodVisibilidadpthisAsesorInstance = asesormodVisibilidadpthisAsesor;
        this.asesormodVisibilidadpthisAsesor = asesormodVisibilidadpthisAsesor != null ? asesormodVisibilidadpthisAsesor.getOid() : null;
    }

    private void checkAsesormodVisibilidadpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesormodVisibilidadpthisAsesorInstance() == null || this.getAsesormodVisibilidadpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODVISIBILIDAD_ASESORMODVISIBILIDADPTHISASESOR, AsesorConstants.SERV_ALIAS_MODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODVISIBILIDAD_ASESORMODVISIBILIDADPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesormodVisibilidadpVerDatosPersona() {
        return this.asesormodVisibilidadpVerDatosPersona;
    }
    
    public void setAsesormodVisibilidadpVerDatosPersona(Boolean asesormodVisibilidadpVerDatosPersona) {
        this.asesormodVisibilidadpVerDatosPersona = asesormodVisibilidadpVerDatosPersona;
    }

    private void checkAsesormodVisibilidadpVerDatosPersona() throws NotNullArgumentException {
        if(this.getAsesormodVisibilidadpVerDatosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODVISIBILIDAD_ASESORMODVISIBILIDADPVERDATOSPERSONA, AsesorConstants.SERV_ALIAS_MODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODVISIBILIDAD_ASESORMODVISIBILIDADPVERDATOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesormodVisibilidadpVerDocsPersona() {
        return this.asesormodVisibilidadpVerDocsPersona;
    }
    
    public void setAsesormodVisibilidadpVerDocsPersona(Boolean asesormodVisibilidadpVerDocsPersona) {
        this.asesormodVisibilidadpVerDocsPersona = asesormodVisibilidadpVerDocsPersona;
    }

    private void checkAsesormodVisibilidadpVerDocsPersona() throws NotNullArgumentException {
        if(this.getAsesormodVisibilidadpVerDocsPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODVISIBILIDAD_ASESORMODVISIBILIDADPVERDOCSPERSONA, AsesorConstants.SERV_ALIAS_MODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODVISIBILIDAD_ASESORMODVISIBILIDADPVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesormodVisibilidadpVerContratoNovedad() {
        return this.asesormodVisibilidadpVerContratoNovedad;
    }
    
    public void setAsesormodVisibilidadpVerContratoNovedad(Boolean asesormodVisibilidadpVerContratoNovedad) {
        this.asesormodVisibilidadpVerContratoNovedad = asesormodVisibilidadpVerContratoNovedad;
    }

    private void checkAsesormodVisibilidadpVerContratoNovedad() throws NotNullArgumentException {
        if(this.getAsesormodVisibilidadpVerContratoNovedad() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_MODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_MODVISIBILIDAD_ASESORMODVISIBILIDADPVERCONTRATONOVEDAD, AsesorConstants.SERV_ALIAS_MODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_MODVISIBILIDAD_ASESORMODVISIBILIDADPVERCONTRATONOVEDAD);
        }
    }
}
