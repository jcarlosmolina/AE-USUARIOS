package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;

public class SetTodosDominiosRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductosetTodosDominiospthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductosetTodosDominiospthisAgentexProductoInstance;

    @JsonProperty("pttodos")
    private Boolean agentexProductosetTodosDominiosptTodos;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductosetTodosDominiospthisAgentexProducto();
        checkAgentexProductosetTodosDominiosptTodos();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductosetTodosDominiospthisAgentexProducto() {
        return this.agentexProductosetTodosDominiospthisAgentexProducto;
    }
    
    public void setAgentexProductosetTodosDominiospthisAgentexProducto(AgentexProductoOid agentexProductosetTodosDominiospthisAgentexProducto) {
        this.agentexProductosetTodosDominiospthisAgentexProducto = agentexProductosetTodosDominiospthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductosetTodosDominiospthisAgentexProductoInstance() {
        return this.agentexProductosetTodosDominiospthisAgentexProductoInstance;
    }
    
    public void setAgentexProductosetTodosDominiospthisAgentexProductoInstance(AgentexProducto agentexProductosetTodosDominiospthisAgentexProducto) {
        this.agentexProductosetTodosDominiospthisAgentexProductoInstance = agentexProductosetTodosDominiospthisAgentexProducto;
        this.agentexProductosetTodosDominiospthisAgentexProducto = agentexProductosetTodosDominiospthisAgentexProducto != null ? agentexProductosetTodosDominiospthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductosetTodosDominiospthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductosetTodosDominiospthisAgentexProductoInstance() == null || this.getAgentexProductosetTodosDominiospthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_SETTODOSDOMINIOS, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_SETTODOSDOMINIOS_AGENTEXPRODUCTOSETTODOSDOMINIOSPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_SETTODOSDOMINIOS, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_SETTODOSDOMINIOS_AGENTEXPRODUCTOSETTODOSDOMINIOSPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public Boolean getAgentexProductosetTodosDominiosptTodos() {
        return this.agentexProductosetTodosDominiosptTodos;
    }
    
    public void setAgentexProductosetTodosDominiosptTodos(Boolean agentexProductosetTodosDominiosptTodos) {
        this.agentexProductosetTodosDominiosptTodos = agentexProductosetTodosDominiosptTodos;
    }

    private void checkAgentexProductosetTodosDominiosptTodos() throws NotNullArgumentException {
        if(this.getAgentexProductosetTodosDominiosptTodos() == null) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_SETTODOSDOMINIOS, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_SETTODOSDOMINIOS_AGENTEXPRODUCTOSETTODOSDOMINIOSPTTODOS, AgentexProductoConstants.SERV_ALIAS_SETTODOSDOMINIOS, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_SETTODOSDOMINIOS_AGENTEXPRODUCTOSETTODOSDOMINIOSPTTODOS);
        }
    }
}
