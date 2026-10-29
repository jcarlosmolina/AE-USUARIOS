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

public class CrearRequest {

    @JsonProperty("p_agrproductot_oid")
    private ProductosOid agentexProductocrearpagrProductoT;
    
    @JsonIgnore
    private Productos agentexProductocrearpagrProductoTInstance;

    @JsonProperty("p_agrasesor_oid")
    private AsesorOid agentexProductocrearpagrAsesor;
    
    @JsonIgnore
    private Asesor agentexProductocrearpagrAsesorInstance;

    @JsonProperty("p_atrfechainicio")
    private Timestamp agentexProductocrearpatrFechaInicio;

    @JsonProperty("p_atrfechafin")
    private Timestamp agentexProductocrearpatrFechaFin;

    @JsonProperty("p_atrcodigo")
    private Long agentexProductocrearpatrCodigo;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductocrearpagrProductoT();
        checkAgentexProductocrearpagrAsesor();
        checkAgentexProductocrearpatrCodigo();
    }

    @JsonIgnore
    public ProductosOid getAgentexProductocrearpagrProductoT() {
        return this.agentexProductocrearpagrProductoT;
    }
    
    public void setAgentexProductocrearpagrProductoT(ProductosOid agentexProductocrearpagrProductoT) {
        this.agentexProductocrearpagrProductoT = agentexProductocrearpagrProductoT;
    }

    @JsonIgnore
    public Productos getAgentexProductocrearpagrProductoTInstance() {
        return this.agentexProductocrearpagrProductoTInstance;
    }
    
    public void setAgentexProductocrearpagrProductoTInstance(Productos agentexProductocrearpagrProductoT) {
        this.agentexProductocrearpagrProductoTInstance = agentexProductocrearpagrProductoT;
        this.agentexProductocrearpagrProductoT = agentexProductocrearpagrProductoT != null ? agentexProductocrearpagrProductoT.getOid() : null;
    }

    private void checkAgentexProductocrearpagrProductoT() throws NotNullArgumentException {
        if(this.getAgentexProductocrearpagrProductoTInstance() == null || this.getAgentexProductocrearpagrProductoTInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_CREAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_CREAR_AGENTEXPRODUCTOCREARPAGRPRODUCTOT, AgentexProductoConstants.SERV_ALIAS_CREAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_CREAR_AGENTEXPRODUCTOCREARPAGRPRODUCTOT);
        }
    }

    @JsonIgnore
    public AsesorOid getAgentexProductocrearpagrAsesor() {
        return this.agentexProductocrearpagrAsesor;
    }
    
    public void setAgentexProductocrearpagrAsesor(AsesorOid agentexProductocrearpagrAsesor) {
        this.agentexProductocrearpagrAsesor = agentexProductocrearpagrAsesor;
    }

    @JsonIgnore
    public Asesor getAgentexProductocrearpagrAsesorInstance() {
        return this.agentexProductocrearpagrAsesorInstance;
    }
    
    public void setAgentexProductocrearpagrAsesorInstance(Asesor agentexProductocrearpagrAsesor) {
        this.agentexProductocrearpagrAsesorInstance = agentexProductocrearpagrAsesor;
        this.agentexProductocrearpagrAsesor = agentexProductocrearpagrAsesor != null ? agentexProductocrearpagrAsesor.getOid() : null;
    }

    private void checkAgentexProductocrearpagrAsesor() throws NotNullArgumentException {
        if(this.getAgentexProductocrearpagrAsesorInstance() == null || this.getAgentexProductocrearpagrAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_CREAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_CREAR_AGENTEXPRODUCTOCREARPAGRASESOR, AgentexProductoConstants.SERV_ALIAS_CREAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_CREAR_AGENTEXPRODUCTOCREARPAGRASESOR);
        }
    }

    @JsonIgnore
    public Timestamp getAgentexProductocrearpatrFechaInicio() {
        return this.agentexProductocrearpatrFechaInicio;
    }
    
    public void setAgentexProductocrearpatrFechaInicio(Timestamp agentexProductocrearpatrFechaInicio) {
        this.agentexProductocrearpatrFechaInicio = agentexProductocrearpatrFechaInicio;
    }

    @JsonIgnore
    public Timestamp getAgentexProductocrearpatrFechaFin() {
        return this.agentexProductocrearpatrFechaFin;
    }
    
    public void setAgentexProductocrearpatrFechaFin(Timestamp agentexProductocrearpatrFechaFin) {
        this.agentexProductocrearpatrFechaFin = agentexProductocrearpatrFechaFin;
    }

    @JsonIgnore
    public Long getAgentexProductocrearpatrCodigo() {
        return this.agentexProductocrearpatrCodigo;
    }
    
    public void setAgentexProductocrearpatrCodigo(Long agentexProductocrearpatrCodigo) {
        this.agentexProductocrearpatrCodigo = agentexProductocrearpatrCodigo;
    }

    private void checkAgentexProductocrearpatrCodigo() throws NotNullArgumentException {
        if(this.getAgentexProductocrearpatrCodigo() == null) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_CREAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_CREAR_AGENTEXPRODUCTOCREARPATRCODIGO, AgentexProductoConstants.SERV_ALIAS_CREAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_CREAR_AGENTEXPRODUCTOCREARPATRCODIGO);
        }
    }
}
