package com.keralty.aeusuarios.viewmodel.contratoc.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.ContratoCConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.ContratoC;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.ContratoCOid;

public class DelAsesorCRequest {

    @JsonProperty("p_thiscontratoc_oid")
    private ContratoCOid contratoCDelAsesorCpthisContratoC;
    
    @JsonIgnore
    private ContratoC contratoCDelAsesorCpthisContratoCInstance;

    @JsonProperty("p_evcasesor_oid")
    private AsesorOid contratoCDelAsesorCpevcAsesor;
    
    @JsonIgnore
    private Asesor contratoCDelAsesorCpevcAsesorInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkContratoCDelAsesorCpthisContratoC();
        checkContratoCDelAsesorCpevcAsesor();
    }

    @JsonIgnore
    public ContratoCOid getContratoCDelAsesorCpthisContratoC() {
        return this.contratoCDelAsesorCpthisContratoC;
    }
    
    public void setContratoCDelAsesorCpthisContratoC(ContratoCOid contratoCDelAsesorCpthisContratoC) {
        this.contratoCDelAsesorCpthisContratoC = contratoCDelAsesorCpthisContratoC;
    }

    @JsonIgnore
    public ContratoC getContratoCDelAsesorCpthisContratoCInstance() {
        return this.contratoCDelAsesorCpthisContratoCInstance;
    }
    
    public void setContratoCDelAsesorCpthisContratoCInstance(ContratoC contratoCDelAsesorCpthisContratoC) {
        this.contratoCDelAsesorCpthisContratoCInstance = contratoCDelAsesorCpthisContratoC;
        this.contratoCDelAsesorCpthisContratoC = contratoCDelAsesorCpthisContratoC != null ? contratoCDelAsesorCpthisContratoC.getOid() : null;
    }

    private void checkContratoCDelAsesorCpthisContratoC() throws NotNullArgumentException {
        if(this.getContratoCDelAsesorCpthisContratoCInstance() == null || this.getContratoCDelAsesorCpthisContratoCInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELASESORC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELASESORC_CONTRATOCDELASESORCPTHISCONTRATOC, ContratoCConstants.SERV_ALIAS_DELASESORC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELASESORC_CONTRATOCDELASESORCPTHISCONTRATOC);
        }
    }

    @JsonIgnore
    public AsesorOid getContratoCDelAsesorCpevcAsesor() {
        return this.contratoCDelAsesorCpevcAsesor;
    }
    
    public void setContratoCDelAsesorCpevcAsesor(AsesorOid contratoCDelAsesorCpevcAsesor) {
        this.contratoCDelAsesorCpevcAsesor = contratoCDelAsesorCpevcAsesor;
    }

    @JsonIgnore
    public Asesor getContratoCDelAsesorCpevcAsesorInstance() {
        return this.contratoCDelAsesorCpevcAsesorInstance;
    }
    
    public void setContratoCDelAsesorCpevcAsesorInstance(Asesor contratoCDelAsesorCpevcAsesor) {
        this.contratoCDelAsesorCpevcAsesorInstance = contratoCDelAsesorCpevcAsesor;
        this.contratoCDelAsesorCpevcAsesor = contratoCDelAsesorCpevcAsesor != null ? contratoCDelAsesorCpevcAsesor.getOid() : null;
    }

    private void checkContratoCDelAsesorCpevcAsesor() throws NotNullArgumentException {
        if(this.getContratoCDelAsesorCpevcAsesorInstance() == null || this.getContratoCDelAsesorCpevcAsesorInstance().isNull()) {
            throw new NotNullArgumentException(ContratoCConstants.SERV_ID_DELASESORC, ContratoCConstants.CLASS_ID, ContratoCConstants.ARG_ID_DELASESORC_CONTRATOCDELASESORCPEVCASESOR, ContratoCConstants.SERV_ALIAS_DELASESORC, ContratoCConstants.CLASS_ALIAS, ContratoCConstants.ARG_ALIAS_DELASESORC_CONTRATOCDELASESORCPEVCASESOR);
        }
    }
}
