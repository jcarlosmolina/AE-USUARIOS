package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TCARGARDOMINIOPLANRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTCARGARDOMINIOPLANpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTCARGARDOMINIOPLANpthisAsesorInstance;

    @JsonProperty("ptcodlegalproducto")
    private String asesorTCARGARDOMINIOPLANptCodLegalProducto;

    @JsonProperty("ptcodlegalplan")
    private String asesorTCARGARDOMINIOPLANptCodLegalPlan;

    @JsonProperty("ptaccion")
    private String asesorTCARGARDOMINIOPLANptAccion;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTCARGARDOMINIOPLANpthisAsesor();
        checkAsesorTCARGARDOMINIOPLANptCodLegalProducto();
        checkAsesorTCARGARDOMINIOPLANptCodLegalPlan();
        checkAsesorTCARGARDOMINIOPLANptAccion();
    }

    @JsonIgnore
    public AsesorOid getAsesorTCARGARDOMINIOPLANpthisAsesor() {
        return this.asesorTCARGARDOMINIOPLANpthisAsesor;
    }
    
    public void setAsesorTCARGARDOMINIOPLANpthisAsesor(AsesorOid asesorTCARGARDOMINIOPLANpthisAsesor) {
        this.asesorTCARGARDOMINIOPLANpthisAsesor = asesorTCARGARDOMINIOPLANpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTCARGARDOMINIOPLANpthisAsesorInstance() {
        return this.asesorTCARGARDOMINIOPLANpthisAsesorInstance;
    }
    
    public void setAsesorTCARGARDOMINIOPLANpthisAsesorInstance(Asesor asesorTCARGARDOMINIOPLANpthisAsesor) {
        this.asesorTCARGARDOMINIOPLANpthisAsesorInstance = asesorTCARGARDOMINIOPLANpthisAsesor;
        this.asesorTCARGARDOMINIOPLANpthisAsesor = asesorTCARGARDOMINIOPLANpthisAsesor != null ? asesorTCARGARDOMINIOPLANpthisAsesor.getOid() : null;
    }

    private void checkAsesorTCARGARDOMINIOPLANpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTCARGARDOMINIOPLANpthisAsesorInstance() == null || this.getAsesorTCARGARDOMINIOPLANpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTHISASESOR, AsesorConstants.SERV_ALIAS_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTHISASESOR);
        }
    }

    @JsonIgnore
    public String getAsesorTCARGARDOMINIOPLANptCodLegalProducto() {
        return this.asesorTCARGARDOMINIOPLANptCodLegalProducto;
    }
    
    public void setAsesorTCARGARDOMINIOPLANptCodLegalProducto(String asesorTCARGARDOMINIOPLANptCodLegalProducto) {
        this.asesorTCARGARDOMINIOPLANptCodLegalProducto = asesorTCARGARDOMINIOPLANptCodLegalProducto;
    }

    private void checkAsesorTCARGARDOMINIOPLANptCodLegalProducto() throws NotNullArgumentException {
        if(this.getAsesorTCARGARDOMINIOPLANptCodLegalProducto() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTCODLEGALPRODUCTO, AsesorConstants.SERV_ALIAS_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTCODLEGALPRODUCTO);
        }
    }

    @JsonIgnore
    public String getAsesorTCARGARDOMINIOPLANptCodLegalPlan() {
        return this.asesorTCARGARDOMINIOPLANptCodLegalPlan;
    }
    
    public void setAsesorTCARGARDOMINIOPLANptCodLegalPlan(String asesorTCARGARDOMINIOPLANptCodLegalPlan) {
        this.asesorTCARGARDOMINIOPLANptCodLegalPlan = asesorTCARGARDOMINIOPLANptCodLegalPlan;
    }

    private void checkAsesorTCARGARDOMINIOPLANptCodLegalPlan() throws NotNullArgumentException {
        if(this.getAsesorTCARGARDOMINIOPLANptCodLegalPlan() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTCODLEGALPLAN, AsesorConstants.SERV_ALIAS_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTCODLEGALPLAN);
        }
    }

    @JsonIgnore
    public String getAsesorTCARGARDOMINIOPLANptAccion() {
        return this.asesorTCARGARDOMINIOPLANptAccion;
    }
    
    public void setAsesorTCARGARDOMINIOPLANptAccion(String asesorTCARGARDOMINIOPLANptAccion) {
        this.asesorTCARGARDOMINIOPLANptAccion = asesorTCARGARDOMINIOPLANptAccion;
    }

    private void checkAsesorTCARGARDOMINIOPLANptAccion() throws NotNullArgumentException {
        if(this.getAsesorTCARGARDOMINIOPLANptAccion() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTACCION, AsesorConstants.SERV_ALIAS_TCARGARDOMINIOPLAN, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TCARGARDOMINIOPLAN_ASESORTCARGARDOMINIOPLANPTACCION);
        }
    }
}
