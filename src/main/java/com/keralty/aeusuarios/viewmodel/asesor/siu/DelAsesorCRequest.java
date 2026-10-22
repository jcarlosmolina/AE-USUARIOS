package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;

public class DelAsesorCRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorDelAsesorCpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorDelAsesorCpthisAsesorInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid asesorDelAsesorCpevcContratoC;
    
    @JsonIgnore
    private ContratoC asesorDelAsesorCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorDelAsesorCpthisAsesor();
        checkAsesorDelAsesorCpevcContratoC();
    }

    @JsonIgnore
    public AsesorOid getAsesorDelAsesorCpthisAsesor() {
        return this.asesorDelAsesorCpthisAsesor;
    }
    
    public void setAsesorDelAsesorCpthisAsesor(AsesorOid asesorDelAsesorCpthisAsesor) {
        this.asesorDelAsesorCpthisAsesor = asesorDelAsesorCpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorDelAsesorCpthisAsesorInstance() {
        return this.asesorDelAsesorCpthisAsesorInstance;
    }
    
    public void setAsesorDelAsesorCpthisAsesorInstance(Asesor asesorDelAsesorCpthisAsesor) {
        this.asesorDelAsesorCpthisAsesorInstance = asesorDelAsesorCpthisAsesor;
        this.asesorDelAsesorCpthisAsesor = asesorDelAsesorCpthisAsesor != null ? asesorDelAsesorCpthisAsesor.getOid() : null;
    }

    private void checkAsesorDelAsesorCpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorDelAsesorCpthisAsesorInstance() == null || this.getAsesorDelAsesorCpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_DELASESORC, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_DELASESORC_ASESORDELASESORCPTHISASESOR, AsesorConstants.SERV_ALIAS_DELASESORC, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_DELASESORC_ASESORDELASESORCPTHISASESOR);
        }
    }

    @JsonIgnore
    public ContratoCOid getAsesorDelAsesorCpevcContratoC() {
        return this.asesorDelAsesorCpevcContratoC;
    }
    
    public void setAsesorDelAsesorCpevcContratoC(ContratoCOid asesorDelAsesorCpevcContratoC) {
        this.asesorDelAsesorCpevcContratoC = asesorDelAsesorCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getAsesorDelAsesorCpevcContratoCInstance() {
        return this.asesorDelAsesorCpevcContratoCInstance;
    }
    
    public void setAsesorDelAsesorCpevcContratoCInstance(ContratoC asesorDelAsesorCpevcContratoC) {
        this.asesorDelAsesorCpevcContratoCInstance = asesorDelAsesorCpevcContratoC;
        this.asesorDelAsesorCpevcContratoC = asesorDelAsesorCpevcContratoC != null ? asesorDelAsesorCpevcContratoC.getOid() : null;
    }

    private void checkAsesorDelAsesorCpevcContratoC() throws NotNullArgumentException {
        if(this.getAsesorDelAsesorCpevcContratoCInstance() == null || this.getAsesorDelAsesorCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_DELASESORC, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_DELASESORC_ASESORDELASESORCPEVCCONTRATOC, AsesorConstants.SERV_ALIAS_DELASESORC, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_DELASESORC_ASESORDELASESORCPEVCCONTRATOC);
        }
    }
}
