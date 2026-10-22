package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Productos;
import java.sql.Timestamp;

public class TCREARRequest {

    @JsonProperty("pt_p_agrproductot_oid")
    private ProductosOid agentexProductoTCREARptpagrProductoT;
    
    @JsonIgnore
    private Productos agentexProductoTCREARptpagrProductoTInstance;

    @JsonProperty("pt_p_agrasesor_oid")
    private AsesorOid agentexProductoTCREARptpagrAsesor;
    
    @JsonIgnore
    private Asesor agentexProductoTCREARptpagrAsesorInstance;

    @JsonProperty("pt_p_atrfechainicio")
    private Timestamp agentexProductoTCREARptpatrFechaInicio;

    @JsonProperty("pt_p_atrfechafin")
    private Timestamp agentexProductoTCREARptpatrFechaFin;

    @JsonProperty("pt_p_atrcodigo")
    private Long agentexProductoTCREARptpatrCodigo;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoTCREARptpagrProductoT();
        checkAgentexProductoTCREARptpagrAsesor();
        checkAgentexProductoTCREARptpatrCodigo();
    }

    @JsonIgnore
    public ProductosOid getAgentexProductoTCREARptpagrProductoT() {
        return this.agentexProductoTCREARptpagrProductoT;
    }
    
    public void setAgentexProductoTCREARptpagrProductoT(ProductosOid agentexProductoTCREARptpagrProductoT) {
        this.agentexProductoTCREARptpagrProductoT = agentexProductoTCREARptpagrProductoT;
    }

    @JsonIgnore
    public Productos getAgentexProductoTCREARptpagrProductoTInstance() {
        return this.agentexProductoTCREARptpagrProductoTInstance;
    }
    
    public void setAgentexProductoTCREARptpagrProductoTInstance(Productos agentexProductoTCREARptpagrProductoT) {
        this.agentexProductoTCREARptpagrProductoTInstance = agentexProductoTCREARptpagrProductoT;
        this.agentexProductoTCREARptpagrProductoT = agentexProductoTCREARptpagrProductoT != null ? agentexProductoTCREARptpagrProductoT.getOid() : null;
    }

    private void checkAgentexProductoTCREARptpagrProductoT() throws NotNullArgumentException {
        if(this.getAgentexProductoTCREARptpagrProductoTInstance() == null || this.getAgentexProductoTCREARptpagrProductoTInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TCREAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TCREAR_AGENTEXPRODUCTOTCREARPTPAGRPRODUCTOT, AgentexProductoConstants.SERV_ALIAS_TCREAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TCREAR_AGENTEXPRODUCTOTCREARPTPAGRPRODUCTOT);
        }
    }

    @JsonIgnore
    public AsesorOid getAgentexProductoTCREARptpagrAsesor() {
        return this.agentexProductoTCREARptpagrAsesor;
    }
    
    public void setAgentexProductoTCREARptpagrAsesor(AsesorOid agentexProductoTCREARptpagrAsesor) {
        this.agentexProductoTCREARptpagrAsesor = agentexProductoTCREARptpagrAsesor;
    }

    @JsonIgnore
    public Asesor getAgentexProductoTCREARptpagrAsesorInstance() {
        return this.agentexProductoTCREARptpagrAsesorInstance;
    }
    
    public void setAgentexProductoTCREARptpagrAsesorInstance(Asesor agentexProductoTCREARptpagrAsesor) {
        this.agentexProductoTCREARptpagrAsesorInstance = agentexProductoTCREARptpagrAsesor;
        this.agentexProductoTCREARptpagrAsesor = agentexProductoTCREARptpagrAsesor != null ? agentexProductoTCREARptpagrAsesor.getOid() : null;
    }

    private void checkAgentexProductoTCREARptpagrAsesor() throws NotNullArgumentException {
        if(this.getAgentexProductoTCREARptpagrAsesorInstance() == null || this.getAgentexProductoTCREARptpagrAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TCREAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TCREAR_AGENTEXPRODUCTOTCREARPTPAGRASESOR, AgentexProductoConstants.SERV_ALIAS_TCREAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TCREAR_AGENTEXPRODUCTOTCREARPTPAGRASESOR);
        }
    }

    @JsonIgnore
    public Timestamp getAgentexProductoTCREARptpatrFechaInicio() {
        return this.agentexProductoTCREARptpatrFechaInicio;
    }
    
    public void setAgentexProductoTCREARptpatrFechaInicio(Timestamp agentexProductoTCREARptpatrFechaInicio) {
        this.agentexProductoTCREARptpatrFechaInicio = agentexProductoTCREARptpatrFechaInicio;
    }

    @JsonIgnore
    public Timestamp getAgentexProductoTCREARptpatrFechaFin() {
        return this.agentexProductoTCREARptpatrFechaFin;
    }
    
    public void setAgentexProductoTCREARptpatrFechaFin(Timestamp agentexProductoTCREARptpatrFechaFin) {
        this.agentexProductoTCREARptpatrFechaFin = agentexProductoTCREARptpatrFechaFin;
    }

    @JsonIgnore
    public Long getAgentexProductoTCREARptpatrCodigo() {
        return this.agentexProductoTCREARptpatrCodigo;
    }
    
    public void setAgentexProductoTCREARptpatrCodigo(Long agentexProductoTCREARptpatrCodigo) {
        this.agentexProductoTCREARptpatrCodigo = agentexProductoTCREARptpatrCodigo;
    }

    private void checkAgentexProductoTCREARptpatrCodigo() throws NotNullArgumentException {
        if(this.getAgentexProductoTCREARptpatrCodigo() == null) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TCREAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TCREAR_AGENTEXPRODUCTOTCREARPTPATRCODIGO, AgentexProductoConstants.SERV_ALIAS_TCREAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TCREAR_AGENTEXPRODUCTOTCREARPTPATRCODIGO);
        }
    }
}
