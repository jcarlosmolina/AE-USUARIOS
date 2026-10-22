package com.keralty.aeusuarios.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.ContratoCConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;

public class InsAsesorCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCInsAsesorCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCInsAsesorCpthisContratoCInstance;

    @JsonProperty("p_evcasesor_oid")
    private AsesorOid contratoCInsAsesorCpevcAsesor;
    
    @JsonIgnore
    private Asesor contratoCInsAsesorCpevcAsesorInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCInsAsesorCpthisContratoC();
        checkContratoCInsAsesorCpevcAsesor();
    }

    @JsonIgnore
    public ContratoCOid getContratoCInsAsesorCpthisContratoC() {
        return this.contratoCInsAsesorCpthisContratoC;
    }
    
    public void setContratoCInsAsesorCpthisContratoC(ContratoCOid contratoCInsAsesorCpthisContratoC) {
        this.contratoCInsAsesorCpthisContratoC = contratoCInsAsesorCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCInsAsesorCpthisContratoCInstance() {
        return this.contratoCInsAsesorCpthisContratoCInstance;
    }
    
    public void setContratoCInsAsesorCpthisContratoCInstance(ContratoC contratoCInsAsesorCpthisContratoC) {
        this.contratoCInsAsesorCpthisContratoCInstance = contratoCInsAsesorCpthisContratoC;
        this.contratoCInsAsesorCpthisContratoC = contratoCInsAsesorCpthisContratoC != null ? contratoCInsAsesorCpthisContratoC.getOid() : null;
    }

    private void checkContratoCInsAsesorCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCInsAsesorCpthisContratoCInstance() == null || this.getContratoCInsAsesorCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSASESORC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSASESORC_CONTRATOCINSASESORCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_INSASESORC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSASESORC_CONTRATOCINSASESORCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public AsesorOid getContratoCInsAsesorCpevcAsesor() {
        return this.contratoCInsAsesorCpevcAsesor;
    }
    
    public void setContratoCInsAsesorCpevcAsesor(AsesorOid contratoCInsAsesorCpevcAsesor) {
        this.contratoCInsAsesorCpevcAsesor = contratoCInsAsesorCpevcAsesor;
    }

    @JsonIgnore
    public Asesor getContratoCInsAsesorCpevcAsesorInstance() {
        return this.contratoCInsAsesorCpevcAsesorInstance;
    }
    
    public void setContratoCInsAsesorCpevcAsesorInstance(Asesor contratoCInsAsesorCpevcAsesor) {
        this.contratoCInsAsesorCpevcAsesorInstance = contratoCInsAsesorCpevcAsesor;
        this.contratoCInsAsesorCpevcAsesor = contratoCInsAsesorCpevcAsesor != null ? contratoCInsAsesorCpevcAsesor.getOid() : null;
    }

    private void checkContratoCInsAsesorCpevcAsesor() throws NotNullArgumentException {
        if(this.getContratoCInsAsesorCpevcAsesorInstance() == null || this.getContratoCInsAsesorCpevcAsesorInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_INSASESORC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_INSASESORC_CONTRATOCINSASESORCPEVCASESOR, ContratoCConstants.SERV_ALIAS_INSASESORC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_INSASESORC_CONTRATOCINSASESORCPEVCASESOR);
        }
    }
}
