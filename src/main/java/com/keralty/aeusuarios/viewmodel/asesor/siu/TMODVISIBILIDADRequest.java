package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TMODVISIBILIDADRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTMODVISIBILIDADpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTMODVISIBILIDADpthisAsesorInstance;

    @JsonProperty("pt_pverdatospersona")
    private Boolean asesorTMODVISIBILIDADptpVerDatosPersona;

    @JsonProperty("pt_pverdocspersona")
    private Boolean asesorTMODVISIBILIDADptpVerDocsPersona;

    @JsonProperty("pt_pvercontratonovedad")
    private Boolean asesorTMODVISIBILIDADptpVerContratoNovedad;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTMODVISIBILIDADpthisAsesor();
        checkAsesorTMODVISIBILIDADptpVerDatosPersona();
        checkAsesorTMODVISIBILIDADptpVerDocsPersona();
        checkAsesorTMODVISIBILIDADptpVerContratoNovedad();
    }

    @JsonIgnore
    public AsesorOid getAsesorTMODVISIBILIDADpthisAsesor() {
        return this.asesorTMODVISIBILIDADpthisAsesor;
    }
    
    public void setAsesorTMODVISIBILIDADpthisAsesor(AsesorOid asesorTMODVISIBILIDADpthisAsesor) {
        this.asesorTMODVISIBILIDADpthisAsesor = asesorTMODVISIBILIDADpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTMODVISIBILIDADpthisAsesorInstance() {
        return this.asesorTMODVISIBILIDADpthisAsesorInstance;
    }
    
    public void setAsesorTMODVISIBILIDADpthisAsesorInstance(Asesor asesorTMODVISIBILIDADpthisAsesor) {
        this.asesorTMODVISIBILIDADpthisAsesorInstance = asesorTMODVISIBILIDADpthisAsesor;
        this.asesorTMODVISIBILIDADpthisAsesor = asesorTMODVISIBILIDADpthisAsesor != null ? asesorTMODVISIBILIDADpthisAsesor.getOid() : null;
    }

    private void checkAsesorTMODVISIBILIDADpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTMODVISIBILIDADpthisAsesorInstance() == null || this.getAsesorTMODVISIBILIDADpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTHISASESOR, AsesorConstants.SERV_ALIAS_TMODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODVISIBILIDADptpVerDatosPersona() {
        return this.asesorTMODVISIBILIDADptpVerDatosPersona;
    }
    
    public void setAsesorTMODVISIBILIDADptpVerDatosPersona(Boolean asesorTMODVISIBILIDADptpVerDatosPersona) {
        this.asesorTMODVISIBILIDADptpVerDatosPersona = asesorTMODVISIBILIDADptpVerDatosPersona;
    }

    private void checkAsesorTMODVISIBILIDADptpVerDatosPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODVISIBILIDADptpVerDatosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTPVERDATOSPERSONA, AsesorConstants.SERV_ALIAS_TMODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTPVERDATOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODVISIBILIDADptpVerDocsPersona() {
        return this.asesorTMODVISIBILIDADptpVerDocsPersona;
    }
    
    public void setAsesorTMODVISIBILIDADptpVerDocsPersona(Boolean asesorTMODVISIBILIDADptpVerDocsPersona) {
        this.asesorTMODVISIBILIDADptpVerDocsPersona = asesorTMODVISIBILIDADptpVerDocsPersona;
    }

    private void checkAsesorTMODVISIBILIDADptpVerDocsPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODVISIBILIDADptpVerDocsPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTPVERDOCSPERSONA, AsesorConstants.SERV_ALIAS_TMODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTPVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODVISIBILIDADptpVerContratoNovedad() {
        return this.asesorTMODVISIBILIDADptpVerContratoNovedad;
    }
    
    public void setAsesorTMODVISIBILIDADptpVerContratoNovedad(Boolean asesorTMODVISIBILIDADptpVerContratoNovedad) {
        this.asesorTMODVISIBILIDADptpVerContratoNovedad = asesorTMODVISIBILIDADptpVerContratoNovedad;
    }

    private void checkAsesorTMODVISIBILIDADptpVerContratoNovedad() throws NotNullArgumentException {
        if(this.getAsesorTMODVISIBILIDADptpVerContratoNovedad() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODVISIBILIDAD, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTPVERCONTRATONOVEDAD, AsesorConstants.SERV_ALIAS_TMODVISIBILIDAD, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODVISIBILIDAD_ASESORTMODVISIBILIDADPTPVERCONTRATONOVEDAD);
        }
    }
}
