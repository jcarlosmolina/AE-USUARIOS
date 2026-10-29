package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Productos;
import java.sql.Timestamp;

public class TSINCRONIZARRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoTSINCRONIZARpthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoTSINCRONIZARpthisAgentexProductoInstance;

    @JsonProperty("pt_p_fechainicio")
    private Timestamp agentexProductoTSINCRONIZARptpFechaInicio;

    @JsonProperty("pt_p_fechafin")
    private Timestamp agentexProductoTSINCRONIZARptpFechaFin;

    @JsonProperty("p_producto_oid")
    private ProductosOid agentexProductoTSINCRONIZARpProducto;
    
    @JsonIgnore
    private Productos agentexProductoTSINCRONIZARpProductoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoTSINCRONIZARpthisAgentexProducto();
        checkAgentexProductoTSINCRONIZARpProducto();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoTSINCRONIZARpthisAgentexProducto() {
        return this.agentexProductoTSINCRONIZARpthisAgentexProducto;
    }
    
    public void setAgentexProductoTSINCRONIZARpthisAgentexProducto(AgentexProductoOid agentexProductoTSINCRONIZARpthisAgentexProducto) {
        this.agentexProductoTSINCRONIZARpthisAgentexProducto = agentexProductoTSINCRONIZARpthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoTSINCRONIZARpthisAgentexProductoInstance() {
        return this.agentexProductoTSINCRONIZARpthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoTSINCRONIZARpthisAgentexProductoInstance(AgentexProducto agentexProductoTSINCRONIZARpthisAgentexProducto) {
        this.agentexProductoTSINCRONIZARpthisAgentexProductoInstance = agentexProductoTSINCRONIZARpthisAgentexProducto;
        this.agentexProductoTSINCRONIZARpthisAgentexProducto = agentexProductoTSINCRONIZARpthisAgentexProducto != null ? agentexProductoTSINCRONIZARpthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoTSINCRONIZARpthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoTSINCRONIZARpthisAgentexProductoInstance() == null || this.getAgentexProductoTSINCRONIZARpthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TSINCRONIZAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TSINCRONIZAR_AGENTEXPRODUCTOTSINCRONIZARPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_TSINCRONIZAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TSINCRONIZAR_AGENTEXPRODUCTOTSINCRONIZARPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public Timestamp getAgentexProductoTSINCRONIZARptpFechaInicio() {
        return this.agentexProductoTSINCRONIZARptpFechaInicio;
    }
    
    public void setAgentexProductoTSINCRONIZARptpFechaInicio(Timestamp agentexProductoTSINCRONIZARptpFechaInicio) {
        this.agentexProductoTSINCRONIZARptpFechaInicio = agentexProductoTSINCRONIZARptpFechaInicio;
    }

    @JsonIgnore
    public Timestamp getAgentexProductoTSINCRONIZARptpFechaFin() {
        return this.agentexProductoTSINCRONIZARptpFechaFin;
    }
    
    public void setAgentexProductoTSINCRONIZARptpFechaFin(Timestamp agentexProductoTSINCRONIZARptpFechaFin) {
        this.agentexProductoTSINCRONIZARptpFechaFin = agentexProductoTSINCRONIZARptpFechaFin;
    }

    @JsonIgnore
    public ProductosOid getAgentexProductoTSINCRONIZARpProducto() {
        return this.agentexProductoTSINCRONIZARpProducto;
    }
    
    public void setAgentexProductoTSINCRONIZARpProducto(ProductosOid agentexProductoTSINCRONIZARpProducto) {
        this.agentexProductoTSINCRONIZARpProducto = agentexProductoTSINCRONIZARpProducto;
    }

    @JsonIgnore
    public Productos getAgentexProductoTSINCRONIZARpProductoInstance() {
        return this.agentexProductoTSINCRONIZARpProductoInstance;
    }
    
    public void setAgentexProductoTSINCRONIZARpProductoInstance(Productos agentexProductoTSINCRONIZARpProducto) {
        this.agentexProductoTSINCRONIZARpProductoInstance = agentexProductoTSINCRONIZARpProducto;
        this.agentexProductoTSINCRONIZARpProducto = agentexProductoTSINCRONIZARpProducto != null ? agentexProductoTSINCRONIZARpProducto.getOid() : null;
    }

    private void checkAgentexProductoTSINCRONIZARpProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoTSINCRONIZARpProductoInstance() == null || this.getAgentexProductoTSINCRONIZARpProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TSINCRONIZAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TSINCRONIZAR_AGENTEXPRODUCTOTSINCRONIZARPPRODUCTO, AgentexProductoConstants.SERV_ALIAS_TSINCRONIZAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TSINCRONIZAR_AGENTEXPRODUCTOTSINCRONIZARPPRODUCTO);
        }
    }
}
