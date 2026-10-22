package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;

public class TDELDOMINIORequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoTDELDOMINIOpthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoTDELDOMINIOpthisAgentexProductoInstance;

    @JsonProperty("pt_p_evcdominio_oid")
    private DominioOid agentexProductoTDELDOMINIOptpevcDominio;
    
    @JsonIgnore
    private Dominio agentexProductoTDELDOMINIOptpevcDominioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoTDELDOMINIOpthisAgentexProducto();
        checkAgentexProductoTDELDOMINIOptpevcDominio();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoTDELDOMINIOpthisAgentexProducto() {
        return this.agentexProductoTDELDOMINIOpthisAgentexProducto;
    }
    
    public void setAgentexProductoTDELDOMINIOpthisAgentexProducto(AgentexProductoOid agentexProductoTDELDOMINIOpthisAgentexProducto) {
        this.agentexProductoTDELDOMINIOpthisAgentexProducto = agentexProductoTDELDOMINIOpthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoTDELDOMINIOpthisAgentexProductoInstance() {
        return this.agentexProductoTDELDOMINIOpthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoTDELDOMINIOpthisAgentexProductoInstance(AgentexProducto agentexProductoTDELDOMINIOpthisAgentexProducto) {
        this.agentexProductoTDELDOMINIOpthisAgentexProductoInstance = agentexProductoTDELDOMINIOpthisAgentexProducto;
        this.agentexProductoTDELDOMINIOpthisAgentexProducto = agentexProductoTDELDOMINIOpthisAgentexProducto != null ? agentexProductoTDELDOMINIOpthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoTDELDOMINIOpthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoTDELDOMINIOpthisAgentexProductoInstance() == null || this.getAgentexProductoTDELDOMINIOpthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TDELDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TDELDOMINIO_AGENTEXPRODUCTOTDELDOMINIOPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_TDELDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TDELDOMINIO_AGENTEXPRODUCTOTDELDOMINIOPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public DominioOid getAgentexProductoTDELDOMINIOptpevcDominio() {
        return this.agentexProductoTDELDOMINIOptpevcDominio;
    }
    
    public void setAgentexProductoTDELDOMINIOptpevcDominio(DominioOid agentexProductoTDELDOMINIOptpevcDominio) {
        this.agentexProductoTDELDOMINIOptpevcDominio = agentexProductoTDELDOMINIOptpevcDominio;
    }

    @JsonIgnore
    public Dominio getAgentexProductoTDELDOMINIOptpevcDominioInstance() {
        return this.agentexProductoTDELDOMINIOptpevcDominioInstance;
    }
    
    public void setAgentexProductoTDELDOMINIOptpevcDominioInstance(Dominio agentexProductoTDELDOMINIOptpevcDominio) {
        this.agentexProductoTDELDOMINIOptpevcDominioInstance = agentexProductoTDELDOMINIOptpevcDominio;
        this.agentexProductoTDELDOMINIOptpevcDominio = agentexProductoTDELDOMINIOptpevcDominio != null ? agentexProductoTDELDOMINIOptpevcDominio.getOid() : null;
    }

    private void checkAgentexProductoTDELDOMINIOptpevcDominio() throws NotNullArgumentException {
        if(this.getAgentexProductoTDELDOMINIOptpevcDominioInstance() == null || this.getAgentexProductoTDELDOMINIOptpevcDominioInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TDELDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TDELDOMINIO_AGENTEXPRODUCTOTDELDOMINIOPTPEVCDOMINIO, AgentexProductoConstants.SERV_ALIAS_TDELDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TDELDOMINIO_AGENTEXPRODUCTOTDELDOMINIOPTPEVCDOMINIO);
        }
    }
}
