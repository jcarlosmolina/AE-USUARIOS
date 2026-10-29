package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;

public class InsAsesorCRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorInsAsesorCpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorInsAsesorCpthisAsesorInstance;

    @JsonProperty("p_evccontratoc_oid")
    private ContratoCOid asesorInsAsesorCpevcContratoC;
    
    @JsonIgnore
    private ContratoC asesorInsAsesorCpevcContratoCInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorInsAsesorCpthisAsesor();
        checkAsesorInsAsesorCpevcContratoC();
    }

    @JsonIgnore
    public AsesorOid getAsesorInsAsesorCpthisAsesor() {
        return this.asesorInsAsesorCpthisAsesor;
    }
    
    public void setAsesorInsAsesorCpthisAsesor(AsesorOid asesorInsAsesorCpthisAsesor) {
        this.asesorInsAsesorCpthisAsesor = asesorInsAsesorCpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorInsAsesorCpthisAsesorInstance() {
        return this.asesorInsAsesorCpthisAsesorInstance;
    }
    
    public void setAsesorInsAsesorCpthisAsesorInstance(Asesor asesorInsAsesorCpthisAsesor) {
        this.asesorInsAsesorCpthisAsesorInstance = asesorInsAsesorCpthisAsesor;
        this.asesorInsAsesorCpthisAsesor = asesorInsAsesorCpthisAsesor != null ? asesorInsAsesorCpthisAsesor.getOid() : null;
    }

    private void checkAsesorInsAsesorCpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorInsAsesorCpthisAsesorInstance() == null || this.getAsesorInsAsesorCpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_INSASESORC, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_INSASESORC_ASESORINSASESORCPTHISASESOR, AsesorConstants.SERV_ALIAS_INSASESORC, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_INSASESORC_ASESORINSASESORCPTHISASESOR);
        }
    }

    @JsonIgnore
    public ContratoCOid getAsesorInsAsesorCpevcContratoC() {
        return this.asesorInsAsesorCpevcContratoC;
    }
    
    public void setAsesorInsAsesorCpevcContratoC(ContratoCOid asesorInsAsesorCpevcContratoC) {
        this.asesorInsAsesorCpevcContratoC = asesorInsAsesorCpevcContratoC;
    }

    @JsonIgnore
    public ContratoC getAsesorInsAsesorCpevcContratoCInstance() {
        return this.asesorInsAsesorCpevcContratoCInstance;
    }
    
    public void setAsesorInsAsesorCpevcContratoCInstance(ContratoC asesorInsAsesorCpevcContratoC) {
        this.asesorInsAsesorCpevcContratoCInstance = asesorInsAsesorCpevcContratoC;
        this.asesorInsAsesorCpevcContratoC = asesorInsAsesorCpevcContratoC != null ? asesorInsAsesorCpevcContratoC.getOid() : null;
    }

    private void checkAsesorInsAsesorCpevcContratoC() throws NotNullArgumentException {
        if(this.getAsesorInsAsesorCpevcContratoCInstance() == null || this.getAsesorInsAsesorCpevcContratoCInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_INSASESORC, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_INSASESORC_ASESORINSASESORCPEVCCONTRATOC, AsesorConstants.SERV_ALIAS_INSASESORC, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_INSASESORC_ASESORINSASESORCPEVCCONTRATOC);
        }
    }
}
