package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;

public class TCARGARDOMINIOPLANRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance;

    @JsonProperty("ptcodlegalplan")
    private String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan;

    @JsonProperty("ptaccion")
    private String agentexProductoTCARGARDOMINIOPLANptAccion;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoTCARGARDOMINIOPLANpthisAgentexProducto();
        checkAgentexProductoTCARGARDOMINIOPLANptCodLegalPlan();
        checkAgentexProductoTCARGARDOMINIOPLANptAccion();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoTCARGARDOMINIOPLANpthisAgentexProducto() {
        return this.agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto;
    }
    
    public void setAgentexProductoTCARGARDOMINIOPLANpthisAgentexProducto(AgentexProductoOid agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto) {
        this.agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto = agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance() {
        return this.agentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance(AgentexProducto agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto) {
        this.agentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance = agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto;
        this.agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto = agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto != null ? agentexProductoTCARGARDOMINIOPLANpthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoTCARGARDOMINIOPLANpthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance() == null || this.getAgentexProductoTCARGARDOMINIOPLANpthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TCARGARDOMINIOPLAN, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TCARGARDOMINIOPLAN_AGENTEXPRODUCTOTCARGARDOMINIOPLANPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_TCARGARDOMINIOPLAN, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TCARGARDOMINIOPLAN_AGENTEXPRODUCTOTCARGARDOMINIOPLANPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public String getAgentexProductoTCARGARDOMINIOPLANptCodLegalPlan() {
        return this.agentexProductoTCARGARDOMINIOPLANptCodLegalPlan;
    }
    
    public void setAgentexProductoTCARGARDOMINIOPLANptCodLegalPlan(String agentexProductoTCARGARDOMINIOPLANptCodLegalPlan) {
        this.agentexProductoTCARGARDOMINIOPLANptCodLegalPlan = agentexProductoTCARGARDOMINIOPLANptCodLegalPlan;
    }

    private void checkAgentexProductoTCARGARDOMINIOPLANptCodLegalPlan() throws NotNullArgumentException {
        if(this.getAgentexProductoTCARGARDOMINIOPLANptCodLegalPlan() == null) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TCARGARDOMINIOPLAN, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TCARGARDOMINIOPLAN_AGENTEXPRODUCTOTCARGARDOMINIOPLANPTCODLEGALPLAN, AgentexProductoConstants.SERV_ALIAS_TCARGARDOMINIOPLAN, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TCARGARDOMINIOPLAN_AGENTEXPRODUCTOTCARGARDOMINIOPLANPTCODLEGALPLAN);
        }
    }

    @JsonIgnore
    public String getAgentexProductoTCARGARDOMINIOPLANptAccion() {
        return this.agentexProductoTCARGARDOMINIOPLANptAccion;
    }
    
    public void setAgentexProductoTCARGARDOMINIOPLANptAccion(String agentexProductoTCARGARDOMINIOPLANptAccion) {
        this.agentexProductoTCARGARDOMINIOPLANptAccion = agentexProductoTCARGARDOMINIOPLANptAccion;
    }

    private void checkAgentexProductoTCARGARDOMINIOPLANptAccion() throws NotNullArgumentException {
        if(this.getAgentexProductoTCARGARDOMINIOPLANptAccion() == null) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TCARGARDOMINIOPLAN, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TCARGARDOMINIOPLAN_AGENTEXPRODUCTOTCARGARDOMINIOPLANPTACCION, AgentexProductoConstants.SERV_ALIAS_TCARGARDOMINIOPLAN, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TCARGARDOMINIOPLAN_AGENTEXPRODUCTOTCARGARDOMINIOPLANPTACCION);
        }
    }
}
