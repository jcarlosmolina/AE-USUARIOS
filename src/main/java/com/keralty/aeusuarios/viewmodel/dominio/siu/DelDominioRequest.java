package com.keralty.aeusuarios.viewmodel.dominio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.persistence.oid.DominioOid;

public class DelDominioRequest {

    @JsonProperty("p_thisdominio_oid")
    private DominioOid dominioDelDominiopthisDominio;
    
    @JsonIgnore
    private Dominio dominioDelDominiopthisDominioInstance;

    @JsonProperty("p_evcagentexproducto_oid")
    private AgentexProductoOid dominioDelDominiopevcAgentexProducto;
    
    @JsonIgnore
    private AgentexProducto dominioDelDominiopevcAgentexProductoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDominioDelDominiopthisDominio();
        checkDominioDelDominiopevcAgentexProducto();
    }

    @JsonIgnore
    public DominioOid getDominioDelDominiopthisDominio() {
        return this.dominioDelDominiopthisDominio;
    }
    
    public void setDominioDelDominiopthisDominio(DominioOid dominioDelDominiopthisDominio) {
        this.dominioDelDominiopthisDominio = dominioDelDominiopthisDominio;
    }

    @JsonIgnore
    public Dominio getDominioDelDominiopthisDominioInstance() {
        return this.dominioDelDominiopthisDominioInstance;
    }
    
    public void setDominioDelDominiopthisDominioInstance(Dominio dominioDelDominiopthisDominio) {
        this.dominioDelDominiopthisDominioInstance = dominioDelDominiopthisDominio;
        this.dominioDelDominiopthisDominio = dominioDelDominiopthisDominio != null ? dominioDelDominiopthisDominio.getOid() : null;
    }

    private void checkDominioDelDominiopthisDominio() throws NotNullArgumentException {
        if(this.getDominioDelDominiopthisDominioInstance() == null || this.getDominioDelDominiopthisDominioInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_DELDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_DELDOMINIO_DOMINIODELDOMINIOPTHISDOMINIO, DominioConstants.SERV_ALIAS_DELDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_DELDOMINIO_DOMINIODELDOMINIOPTHISDOMINIO);
        }
    }

    @JsonIgnore
    public AgentexProductoOid getDominioDelDominiopevcAgentexProducto() {
        return this.dominioDelDominiopevcAgentexProducto;
    }
    
    public void setDominioDelDominiopevcAgentexProducto(AgentexProductoOid dominioDelDominiopevcAgentexProducto) {
        this.dominioDelDominiopevcAgentexProducto = dominioDelDominiopevcAgentexProducto;
    }

    @JsonIgnore
    public AgentexProducto getDominioDelDominiopevcAgentexProductoInstance() {
        return this.dominioDelDominiopevcAgentexProductoInstance;
    }
    
    public void setDominioDelDominiopevcAgentexProductoInstance(AgentexProducto dominioDelDominiopevcAgentexProducto) {
        this.dominioDelDominiopevcAgentexProductoInstance = dominioDelDominiopevcAgentexProducto;
        this.dominioDelDominiopevcAgentexProducto = dominioDelDominiopevcAgentexProducto != null ? dominioDelDominiopevcAgentexProducto.getOid() : null;
    }

    private void checkDominioDelDominiopevcAgentexProducto() throws NotNullArgumentException {
        if(this.getDominioDelDominiopevcAgentexProductoInstance() == null || this.getDominioDelDominiopevcAgentexProductoInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_DELDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_DELDOMINIO_DOMINIODELDOMINIOPEVCAGENTEXPRODUCTO, DominioConstants.SERV_ALIAS_DELDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_DELDOMINIO_DOMINIODELDOMINIOPEVCAGENTEXPRODUCTO);
        }
    }
}
