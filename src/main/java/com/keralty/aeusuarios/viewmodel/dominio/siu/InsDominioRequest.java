package com.keralty.aeusuarios.viewmodel.dominio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;

public class InsDominioRequest {

    @JsonProperty("p_thisdominio_oid")
    private DominioOid dominioInsDominiopthisDominio;
    
    @JsonIgnore
    private Dominio dominioInsDominiopthisDominioInstance;

    @JsonProperty("p_evcagentexproducto_oid")
    private AgentexProductoOid dominioInsDominiopevcAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto dominioInsDominiopevcAgentexProductoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDominioInsDominiopthisDominio();
        checkDominioInsDominiopevcAgentexProducto();
    }

    @JsonIgnore
    public DominioOid getDominioInsDominiopthisDominio() {
        return this.dominioInsDominiopthisDominio;
    }
    
    public void setDominioInsDominiopthisDominio(DominioOid dominioInsDominiopthisDominio) {
        this.dominioInsDominiopthisDominio = dominioInsDominiopthisDominio;
    }

    @JsonIgnore
    public Dominio getDominioInsDominiopthisDominioInstance() {
        return this.dominioInsDominiopthisDominioInstance;
    }
    
    public void setDominioInsDominiopthisDominioInstance(Dominio dominioInsDominiopthisDominio) {
        this.dominioInsDominiopthisDominioInstance = dominioInsDominiopthisDominio;
        this.dominioInsDominiopthisDominio = dominioInsDominiopthisDominio != null ? dominioInsDominiopthisDominio.getOid() : null;
    }

    private void checkDominioInsDominiopthisDominio() throws NotNullArgumentException {
        if(this.getDominioInsDominiopthisDominioInstance() == null || this.getDominioInsDominiopthisDominioInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_INSDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_INSDOMINIO_DOMINIOINSDOMINIOPTHISDOMINIO, DominioConstants.SERV_ALIAS_INSDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_INSDOMINIO_DOMINIOINSDOMINIOPTHISDOMINIO);
        }
    }

    @JsonIgnore
    public AgentexProductoOid getDominioInsDominiopevcAgentexProducto() {
        return this.dominioInsDominiopevcAgentexProducto;
    }
    
    public void setDominioInsDominiopevcAgentexProducto(AgentexProductoOid dominioInsDominiopevcAgentexProducto) {
        this.dominioInsDominiopevcAgentexProducto = dominioInsDominiopevcAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getDominioInsDominiopevcAgentexProductoInstance() {
        return this.dominioInsDominiopevcAgentexProductoInstance;
    }
    
    public void setDominioInsDominiopevcAgentexProductoInstance(AgentexProducto dominioInsDominiopevcAgentexProducto) {
        this.dominioInsDominiopevcAgentexProductoInstance = dominioInsDominiopevcAgentexProducto;
        this.dominioInsDominiopevcAgentexProducto = dominioInsDominiopevcAgentexProducto != null ? dominioInsDominiopevcAgentexProducto.getOid() : null;
    }

    private void checkDominioInsDominiopevcAgentexProducto() throws NotNullArgumentException {
        if(this.getDominioInsDominiopevcAgentexProductoInstance() == null || this.getDominioInsDominiopevcAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_INSDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_INSDOMINIO_DOMINIOINSDOMINIOPEVCAGENTEXPRODUCTO, DominioConstants.SERV_ALIAS_INSDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_INSDOMINIO_DOMINIOINSDOMINIOPEVCAGENTEXPRODUCTO);
        }
    }
}
