package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;

public class EliminarRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoeliminarpthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoeliminarpthisAgentexProductoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoeliminarpthisAgentexProducto();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoeliminarpthisAgentexProducto() {
        return this.agentexProductoeliminarpthisAgentexProducto;
    }
    
    public void setAgentexProductoeliminarpthisAgentexProducto(AgentexProductoOid agentexProductoeliminarpthisAgentexProducto) {
        this.agentexProductoeliminarpthisAgentexProducto = agentexProductoeliminarpthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoeliminarpthisAgentexProductoInstance() {
        return this.agentexProductoeliminarpthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoeliminarpthisAgentexProductoInstance(AgentexProducto agentexProductoeliminarpthisAgentexProducto) {
        this.agentexProductoeliminarpthisAgentexProductoInstance = agentexProductoeliminarpthisAgentexProducto;
        this.agentexProductoeliminarpthisAgentexProducto = agentexProductoeliminarpthisAgentexProducto != null ? agentexProductoeliminarpthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoeliminarpthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoeliminarpthisAgentexProductoInstance() == null || this.getAgentexProductoeliminarpthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_ELIMINAR, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_ELIMINAR_AGENTEXPRODUCTOELIMINARPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_ELIMINAR, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_ELIMINAR_AGENTEXPRODUCTOELIMINARPTHISAGENTEXPRODUCTO);
        }
    }
}
