package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TLOGCAMBIOSRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTLOGCAMBIOSpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTLOGCAMBIOSpthisAsesorInstance;

    @JsonProperty("pt_pverdatospersona")
    private Boolean asesorTLOGCAMBIOSptpVerDatosPersona;

    @JsonProperty("pt_pverdocspersona")
    private Boolean asesorTLOGCAMBIOSptpVerDocsPersona;

    @JsonProperty("pt_pvercontratonovedad")
    private Boolean asesorTLOGCAMBIOSptpVerContratoNovedad;

    @JsonProperty("ptaccesovalidador")
    private Boolean asesorTLOGCAMBIOSptAccesoValidador;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTLOGCAMBIOSpthisAsesor();
        checkAsesorTLOGCAMBIOSptpVerDatosPersona();
        checkAsesorTLOGCAMBIOSptpVerDocsPersona();
        checkAsesorTLOGCAMBIOSptpVerContratoNovedad();
        checkAsesorTLOGCAMBIOSptAccesoValidador();
    }

    @JsonIgnore
    public AsesorOid getAsesorTLOGCAMBIOSpthisAsesor() {
        return this.asesorTLOGCAMBIOSpthisAsesor;
    }
    
    public void setAsesorTLOGCAMBIOSpthisAsesor(AsesorOid asesorTLOGCAMBIOSpthisAsesor) {
        this.asesorTLOGCAMBIOSpthisAsesor = asesorTLOGCAMBIOSpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTLOGCAMBIOSpthisAsesorInstance() {
        return this.asesorTLOGCAMBIOSpthisAsesorInstance;
    }
    
    public void setAsesorTLOGCAMBIOSpthisAsesorInstance(Asesor asesorTLOGCAMBIOSpthisAsesor) {
        this.asesorTLOGCAMBIOSpthisAsesorInstance = asesorTLOGCAMBIOSpthisAsesor;
        this.asesorTLOGCAMBIOSpthisAsesor = asesorTLOGCAMBIOSpthisAsesor != null ? asesorTLOGCAMBIOSpthisAsesor.getOid() : null;
    }

    private void checkAsesorTLOGCAMBIOSpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTLOGCAMBIOSpthisAsesorInstance() == null || this.getAsesorTLOGCAMBIOSpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TLOGCAMBIOS, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTHISASESOR, AsesorConstants.SERV_ALIAS_TLOGCAMBIOS, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTLOGCAMBIOSptpVerDatosPersona() {
        return this.asesorTLOGCAMBIOSptpVerDatosPersona;
    }
    
    public void setAsesorTLOGCAMBIOSptpVerDatosPersona(Boolean asesorTLOGCAMBIOSptpVerDatosPersona) {
        this.asesorTLOGCAMBIOSptpVerDatosPersona = asesorTLOGCAMBIOSptpVerDatosPersona;
    }

    private void checkAsesorTLOGCAMBIOSptpVerDatosPersona() throws NotNullArgumentException {
        if(this.getAsesorTLOGCAMBIOSptpVerDatosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TLOGCAMBIOS, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTPVERDATOSPERSONA, AsesorConstants.SERV_ALIAS_TLOGCAMBIOS, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTPVERDATOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTLOGCAMBIOSptpVerDocsPersona() {
        return this.asesorTLOGCAMBIOSptpVerDocsPersona;
    }
    
    public void setAsesorTLOGCAMBIOSptpVerDocsPersona(Boolean asesorTLOGCAMBIOSptpVerDocsPersona) {
        this.asesorTLOGCAMBIOSptpVerDocsPersona = asesorTLOGCAMBIOSptpVerDocsPersona;
    }

    private void checkAsesorTLOGCAMBIOSptpVerDocsPersona() throws NotNullArgumentException {
        if(this.getAsesorTLOGCAMBIOSptpVerDocsPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TLOGCAMBIOS, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTPVERDOCSPERSONA, AsesorConstants.SERV_ALIAS_TLOGCAMBIOS, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTPVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTLOGCAMBIOSptpVerContratoNovedad() {
        return this.asesorTLOGCAMBIOSptpVerContratoNovedad;
    }
    
    public void setAsesorTLOGCAMBIOSptpVerContratoNovedad(Boolean asesorTLOGCAMBIOSptpVerContratoNovedad) {
        this.asesorTLOGCAMBIOSptpVerContratoNovedad = asesorTLOGCAMBIOSptpVerContratoNovedad;
    }

    private void checkAsesorTLOGCAMBIOSptpVerContratoNovedad() throws NotNullArgumentException {
        if(this.getAsesorTLOGCAMBIOSptpVerContratoNovedad() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TLOGCAMBIOS, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTPVERCONTRATONOVEDAD, AsesorConstants.SERV_ALIAS_TLOGCAMBIOS, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTPVERCONTRATONOVEDAD);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTLOGCAMBIOSptAccesoValidador() {
        return this.asesorTLOGCAMBIOSptAccesoValidador;
    }
    
    public void setAsesorTLOGCAMBIOSptAccesoValidador(Boolean asesorTLOGCAMBIOSptAccesoValidador) {
        this.asesorTLOGCAMBIOSptAccesoValidador = asesorTLOGCAMBIOSptAccesoValidador;
    }

    private void checkAsesorTLOGCAMBIOSptAccesoValidador() throws NotNullArgumentException {
        if(this.getAsesorTLOGCAMBIOSptAccesoValidador() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TLOGCAMBIOS, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTACCESOVALIDADOR, AsesorConstants.SERV_ALIAS_TLOGCAMBIOS, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TLOGCAMBIOS_ASESORTLOGCAMBIOSPTACCESOVALIDADOR);
        }
    }
}
