package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import java.sql.Timestamp;

public class SincronizarRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductosincronizarpthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductosincronizarpthisAgentexProductoInstance;

    @JsonProperty("p_fechainicio")
    private Timestamp agentexProductosincronizarpFechaInicio;

    @JsonProperty("p_fechafin")
    private Timestamp agentexProductosincronizarpFechaFin;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductosincronizarpthisAgentexProducto();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductosincronizarpthisAgentexProducto() {
        return this.agentexProductosincronizarpthisAgentexProducto;
    }
    
    public void setAgentexProductosincronizarpthisAgentexProducto(AgentexProductoOid agentexProductosincronizarpthisAgentexProducto) {
        this.agentexProductosincronizarpthisAgentexProducto = agentexProductosincronizarpthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductosincronizarpthisAgentexProductoInstance() {
        return this.agentexProductosincronizarpthisAgentexProductoInstance;
    }
    
    public void setAgentexProductosincronizarpthisAgentexProductoInstance(AgentexProducto agentexProductosincronizarpthisAgentexProducto) {
        this.agentexProductosincronizarpthisAgentexProductoInstance = agentexProductosincronizarpthisAgentexProducto;
        this.agentexProductosincronizarpthisAgentexProducto = agentexProductosincronizarpthisAgentexProducto != null ? agentexProductosincronizarpthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductosincronizarpthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductosincronizarpthisAgentexProductoInstance() == null || this.getAgentexProductosincronizarpthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_SINCRONIZAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_SINCRONIZAR_AGENTEXPRODUCTOSINCRONIZARPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_SINCRONIZAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_SINCRONIZAR_AGENTEXPRODUCTOSINCRONIZARPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public Timestamp getAgentexProductosincronizarpFechaInicio() {
        return this.agentexProductosincronizarpFechaInicio;
    }
    
    public void setAgentexProductosincronizarpFechaInicio(Timestamp agentexProductosincronizarpFechaInicio) {
        this.agentexProductosincronizarpFechaInicio = agentexProductosincronizarpFechaInicio;
    }

    @JsonIgnore
    public Timestamp getAgentexProductosincronizarpFechaFin() {
        return this.agentexProductosincronizarpFechaFin;
    }
    
    public void setAgentexProductosincronizarpFechaFin(Timestamp agentexProductosincronizarpFechaFin) {
        this.agentexProductosincronizarpFechaFin = agentexProductosincronizarpFechaFin;
    }
}
