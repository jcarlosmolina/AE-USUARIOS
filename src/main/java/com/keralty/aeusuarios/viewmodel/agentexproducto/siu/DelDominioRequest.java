package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;

public class DelDominioRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoDelDominiopthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoDelDominiopthisAgentexProductoInstance;

    @JsonProperty("p_evcdominio_oid")
    private DominioOid agentexProductoDelDominiopevcDominio;
    
    @JsonIgnore
    private Dominio agentexProductoDelDominiopevcDominioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoDelDominiopthisAgentexProducto();
        checkAgentexProductoDelDominiopevcDominio();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoDelDominiopthisAgentexProducto() {
        return this.agentexProductoDelDominiopthisAgentexProducto;
    }
    
    public void setAgentexProductoDelDominiopthisAgentexProducto(AgentexProductoOid agentexProductoDelDominiopthisAgentexProducto) {
        this.agentexProductoDelDominiopthisAgentexProducto = agentexProductoDelDominiopthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoDelDominiopthisAgentexProductoInstance() {
        return this.agentexProductoDelDominiopthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoDelDominiopthisAgentexProductoInstance(AgentexProducto agentexProductoDelDominiopthisAgentexProducto) {
        this.agentexProductoDelDominiopthisAgentexProductoInstance = agentexProductoDelDominiopthisAgentexProducto;
        this.agentexProductoDelDominiopthisAgentexProducto = agentexProductoDelDominiopthisAgentexProducto != null ? agentexProductoDelDominiopthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoDelDominiopthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoDelDominiopthisAgentexProductoInstance() == null || this.getAgentexProductoDelDominiopthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_DELDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_DELDOMINIO_AGENTEXPRODUCTODELDOMINIOPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_DELDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_DELDOMINIO_AGENTEXPRODUCTODELDOMINIOPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public DominioOid getAgentexProductoDelDominiopevcDominio() {
        return this.agentexProductoDelDominiopevcDominio;
    }
    
    public void setAgentexProductoDelDominiopevcDominio(DominioOid agentexProductoDelDominiopevcDominio) {
        this.agentexProductoDelDominiopevcDominio = agentexProductoDelDominiopevcDominio;
    }

    @JsonIgnore
    public Dominio getAgentexProductoDelDominiopevcDominioInstance() {
        return this.agentexProductoDelDominiopevcDominioInstance;
    }
    
    public void setAgentexProductoDelDominiopevcDominioInstance(Dominio agentexProductoDelDominiopevcDominio) {
        this.agentexProductoDelDominiopevcDominioInstance = agentexProductoDelDominiopevcDominio;
        this.agentexProductoDelDominiopevcDominio = agentexProductoDelDominiopevcDominio != null ? agentexProductoDelDominiopevcDominio.getOid() : null;
    }

    private void checkAgentexProductoDelDominiopevcDominio() throws NotNullArgumentException {
        if(this.getAgentexProductoDelDominiopevcDominioInstance() == null || this.getAgentexProductoDelDominiopevcDominioInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_DELDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_DELDOMINIO_AGENTEXPRODUCTODELDOMINIOPEVCDOMINIO, AgentexProductoConstants.SERV_ALIAS_DELDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_DELDOMINIO_AGENTEXPRODUCTODELDOMINIOPEVCDOMINIO);
        }
    }
}
