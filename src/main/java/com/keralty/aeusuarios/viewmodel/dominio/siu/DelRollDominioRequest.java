package com.keralty.aeusuarios.viewmodel.dominio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.Rol;

public class DelRollDominioRequest {

    @JsonProperty("p_thisdominio_oid")
    private DominioOid dominioDelRollDominiopthisDominio;
    
    @JsonIgnore
    private Dominio dominioDelRollDominiopthisDominioInstance;

    @JsonProperty("p_evcrol_json")
    private String dominioDelRollDominiopevcRol;
    
    @JsonIgnore
    private Rol dominioDelRollDominiopevcRolInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDominioDelRollDominiopthisDominio();
        checkDominioDelRollDominiopevcRol();
    }

    @JsonIgnore
    public DominioOid getDominioDelRollDominiopthisDominio() {
        return this.dominioDelRollDominiopthisDominio;
    }
    
    public void setDominioDelRollDominiopthisDominio(DominioOid dominioDelRollDominiopthisDominio) {
        this.dominioDelRollDominiopthisDominio = dominioDelRollDominiopthisDominio;
    }

    @JsonIgnore
    public Dominio getDominioDelRollDominiopthisDominioInstance() {
        return this.dominioDelRollDominiopthisDominioInstance;
    }
    
    public void setDominioDelRollDominiopthisDominioInstance(Dominio dominioDelRollDominiopthisDominio) {
        this.dominioDelRollDominiopthisDominioInstance = dominioDelRollDominiopthisDominio;
        this.dominioDelRollDominiopthisDominio = dominioDelRollDominiopthisDominio != null ? dominioDelRollDominiopthisDominio.getOid() : null;
    }

    private void checkDominioDelRollDominiopthisDominio() throws NotNullArgumentException {
        if(this.getDominioDelRollDominiopthisDominioInstance() == null || this.getDominioDelRollDominiopthisDominioInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_DELROLLDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPTHISDOMINIO, DominioConstants.SERV_ALIAS_DELROLLDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPTHISDOMINIO);
        }
    }

    @JsonIgnore
    public String getDominioDelRollDominiopevcRol() {
        return this.dominioDelRollDominiopevcRol;
    }
    
    public void setDominioDelRollDominiopevcRol(String dominioDelRollDominiopevcRol) {
        this.dominioDelRollDominiopevcRol = dominioDelRollDominiopevcRol;
    }

    @JsonIgnore
    public Rol getDominioDelRollDominiopevcRolInstance() {
        return this.dominioDelRollDominiopevcRolInstance;
    }
    
    public void setDominioDelRollDominiopevcRolInstance(Rol dominioDelRollDominiopevcRol) {
        this.dominioDelRollDominiopevcRolInstance = dominioDelRollDominiopevcRol;
        this.dominioDelRollDominiopevcRol = dominioDelRollDominiopevcRol != null ? dominioDelRollDominiopevcRol.getOid().toJson() : "";
    }

    private void checkDominioDelRollDominiopevcRol() throws NotNullArgumentException {
        if(this.getDominioDelRollDominiopevcRolInstance() == null || this.getDominioDelRollDominiopevcRolInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_DELROLLDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPEVCROL, DominioConstants.SERV_ALIAS_DELROLLDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_DELROLLDOMINIO_DOMINIODELROLLDOMINIOPEVCROL);
        }
    }
}
