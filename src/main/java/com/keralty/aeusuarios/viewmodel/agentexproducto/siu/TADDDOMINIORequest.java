package com.keralty.aeusuarios.viewmodel.agentexproducto.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;

public class TADDDOMINIORequest {

    @JsonProperty("p_thisagentexproducto_oid")
    private AgentexProductoOid agentexProductoTADDDOMINIOpthisAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto agentexProductoTADDDOMINIOpthisAgentexProductoInstance;

    @JsonProperty("pt_p_evcdominio_oid")
    private DominioOid agentexProductoTADDDOMINIOptpevcDominio;
    
    @JsonIgnore
    private Dominio agentexProductoTADDDOMINIOptpevcDominioInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkAgentexProductoTADDDOMINIOpthisAgentexProducto();
        checkAgentexProductoTADDDOMINIOptpevcDominio();
    }

    @JsonIgnore
    public AgentexProductoOid getAgentexProductoTADDDOMINIOpthisAgentexProducto() {
        return this.agentexProductoTADDDOMINIOpthisAgentexProducto;
    }
    
    public void setAgentexProductoTADDDOMINIOpthisAgentexProducto(AgentexProductoOid agentexProductoTADDDOMINIOpthisAgentexProducto) {
        this.agentexProductoTADDDOMINIOpthisAgentexProducto = agentexProductoTADDDOMINIOpthisAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getAgentexProductoTADDDOMINIOpthisAgentexProductoInstance() {
        return this.agentexProductoTADDDOMINIOpthisAgentexProductoInstance;
    }
    
    public void setAgentexProductoTADDDOMINIOpthisAgentexProductoInstance(AgentexProducto agentexProductoTADDDOMINIOpthisAgentexProducto) {
        this.agentexProductoTADDDOMINIOpthisAgentexProductoInstance = agentexProductoTADDDOMINIOpthisAgentexProducto;
        this.agentexProductoTADDDOMINIOpthisAgentexProducto = agentexProductoTADDDOMINIOpthisAgentexProducto != null ? agentexProductoTADDDOMINIOpthisAgentexProducto.getOid() : null;
    }

    private void checkAgentexProductoTADDDOMINIOpthisAgentexProducto() throws NotNullArgumentException {
        if(this.getAgentexProductoTADDDOMINIOpthisAgentexProductoInstance() == null || this.getAgentexProductoTADDDOMINIOpthisAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TADDDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TADDDOMINIO_AGENTEXPRODUCTOTADDDOMINIOPTHISAGENTEXPRODUCTO, AgentexProductoConstants.SERV_ALIAS_TADDDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TADDDOMINIO_AGENTEXPRODUCTOTADDDOMINIOPTHISAGENTEXPRODUCTO);
        }
    }

    @JsonIgnore
    public DominioOid getAgentexProductoTADDDOMINIOptpevcDominio() {
        return this.agentexProductoTADDDOMINIOptpevcDominio;
    }
    
    public void setAgentexProductoTADDDOMINIOptpevcDominio(DominioOid agentexProductoTADDDOMINIOptpevcDominio) {
        this.agentexProductoTADDDOMINIOptpevcDominio = agentexProductoTADDDOMINIOptpevcDominio;
    }

    @JsonIgnore
    public Dominio getAgentexProductoTADDDOMINIOptpevcDominioInstance() {
        return this.agentexProductoTADDDOMINIOptpevcDominioInstance;
    }
    
    public void setAgentexProductoTADDDOMINIOptpevcDominioInstance(Dominio agentexProductoTADDDOMINIOptpevcDominio) {
        this.agentexProductoTADDDOMINIOptpevcDominioInstance = agentexProductoTADDDOMINIOptpevcDominio;
        this.agentexProductoTADDDOMINIOptpevcDominio = agentexProductoTADDDOMINIOptpevcDominio != null ? agentexProductoTADDDOMINIOptpevcDominio.getOid() : null;
    }

    private void checkAgentexProductoTADDDOMINIOptpevcDominio() throws NotNullArgumentException {
        if(this.getAgentexProductoTADDDOMINIOptpevcDominioInstance() == null || this.getAgentexProductoTADDDOMINIOptpevcDominioInstance().isNull()) {
            throw new NotNullArgumentException(AgentexProductoConstants.SERV_ID_TADDDOMINIO, AgentexProductoConstants.CLASS_ID, AgentexProductoConstants.ARG_ID_TADDDOMINIO_AGENTEXPRODUCTOTADDDOMINIOPTPEVCDOMINIO, AgentexProductoConstants.SERV_ALIAS_TADDDOMINIO, AgentexProductoConstants.CLASS_ALIAS, AgentexProductoConstants.ARG_ALIAS_TADDDOMINIO_AGENTEXPRODUCTOTADDDOMINIOPTPEVCDOMINIO);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
