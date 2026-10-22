package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;

public class InsDominioRequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoInsDominiopthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoInsDominiopthisAgentexProductoInstance;

    @JsonProperty("p_evcdominio_oid")
    private DominioOid agentexProductoInsDominiopevcDominio;
    
    @JsonIgnore
    private Dominio agentexProductoInsDominiopevcDominioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoInsDominiopthisAgentexProducto();
        checkAgentexProductoInsDominiopevcDominio();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoInsDominiopthisAgentexProducto() {
        return this.agentexProductoInsDominiopthisAgentexProducto;
    }
    
    public void setAgentexProductoInsDominiopthisAgentexProducto(AgentexProductoOid agentexProductoInsDominiopthisAgentexProducto) {
        this.agentexProductoInsDominiopthisAgentexProducto = agentexProductoInsDominiopthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoInsDominiopthisAgentexProductoInstance() {
        return this.agentexProductoInsDominiopthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoInsDominiopthisAgentexProductoInstance(AgentexProducto agentexProductoInsDominiopthisAgentexProducto) {
        this.agentexProductoInsDominiopthisAgentexProductoInstance = agentexProductoInsDominiopthisAgentexProducto;
        this.agentexProductoInsDominiopthisAgentexProducto = agentexProductoInsDominiopthisAgentexProducto != null ? agentexProductoInsDominiopthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoInsDominiopthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoInsDominiopthisAgentexProductoInstance() == null || this.getAgentexProductoInsDominiopthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_INSDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_INSDOMINIO_AGENTEXPRODUCTOINSDOMINIOPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_INSDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_INSDOMINIO_AGENTEXPRODUCTOINSDOMINIOPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public DominioOid getAgentexProductoInsDominiopevcDominio() {
        return this.agentexProductoInsDominiopevcDominio;
    }
    
    public void setAgentexProductoInsDominiopevcDominio(DominioOid agentexProductoInsDominiopevcDominio) {
        this.agentexProductoInsDominiopevcDominio = agentexProductoInsDominiopevcDominio;
    }

    @JsonIgnore
    public Dominio getAgentexProductoInsDominiopevcDominioInstance() {
        return this.agentexProductoInsDominiopevcDominioInstance;
    }
    
    public void setAgentexProductoInsDominiopevcDominioInstance(Dominio agentexProductoInsDominiopevcDominio) {
        this.agentexProductoInsDominiopevcDominioInstance = agentexProductoInsDominiopevcDominio;
        this.agentexProductoInsDominiopevcDominio = agentexProductoInsDominiopevcDominio != null ? agentexProductoInsDominiopevcDominio.getOid() : null;
    }

    private void checkAgentexProductoInsDominiopevcDominio() throws NotNullArgumentException {
        if(this.getAgentexProductoInsDominiopevcDominioInstance() == null || this.getAgentexProductoInsDominiopevcDominioInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_INSDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_INSDOMINIO_AGENTEXPRODUCTOINSDOMINIOPEVCDOMINIO, AgentexProductoConstants.SERV_ALIAS_INSDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_INSDOMINIO_AGENTEXPRODUCTOINSDOMINIOPEVCDOMINIO);
        }
    }
}
