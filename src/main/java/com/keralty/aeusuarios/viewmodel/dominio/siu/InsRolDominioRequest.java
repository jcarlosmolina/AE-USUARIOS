package com.keralty.aeusuarios.viewmodel.dominio.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.DominioConstants;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;

public class InsRolDominioRequest {

    @JsonProperty("p_thisdominio_oid")
    private DominioOid dominioInsRolDominiopthisDominio;
    
    @JsonIgnore
    private Dominio dominioInsRolDominiopthisDominioInstance;

    @JsonProperty("p_evcrol_oid")
    private RolOid dominioInsRolDominiopevcRol;
    
    @JsonIgnore
    private Rol dominioInsRolDominiopevcRolInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkDominioInsRolDominiopthisDominio();
        checkDominioInsRolDominiopevcRol();
    }

    @JsonIgnore
    public DominioOid getDominioInsRolDominiopthisDominio() {
        return this.dominioInsRolDominiopthisDominio;
    }
    
    public void setDominioInsRolDominiopthisDominio(DominioOid dominioInsRolDominiopthisDominio) {
        this.dominioInsRolDominiopthisDominio = dominioInsRolDominiopthisDominio;
    }

    @JsonIgnore
    public Dominio getDominioInsRolDominiopthisDominioInstance() {
        return this.dominioInsRolDominiopthisDominioInstance;
    }
    
    public void setDominioInsRolDominiopthisDominioInstance(Dominio dominioInsRolDominiopthisDominio) {
        this.dominioInsRolDominiopthisDominioInstance = dominioInsRolDominiopthisDominio;
        this.dominioInsRolDominiopthisDominio = dominioInsRolDominiopthisDominio != null ? dominioInsRolDominiopthisDominio.getOid() : null;
    }

    private void checkDominioInsRolDominiopthisDominio() throws NotNullArgumentException {
        if(this.getDominioInsRolDominiopthisDominioInstance() == null || this.getDominioInsRolDominiopthisDominioInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_INSROLDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_INSROLDOMINIO_DOMINIOINSROLDOMINIOPTHISDOMINIO, DominioConstants.SERV_ALIAS_INSROLDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_INSROLDOMINIO_DOMINIOINSROLDOMINIOPTHISDOMINIO);
        }
    }

    @JsonIgnore
    public RolOid getDominioInsRolDominiopevcRol() {
        return this.dominioInsRolDominiopevcRol;
    }
    
    public void setDominioInsRolDominiopevcRol(RolOid dominioInsRolDominiopevcRol) {
        this.dominioInsRolDominiopevcRol = dominioInsRolDominiopevcRol;
    }

    @JsonIgnore
    public Rol getDominioInsRolDominiopevcRolInstance() {
        return this.dominioInsRolDominiopevcRolInstance;
    }
    
    public void setDominioInsRolDominiopevcRolInstance(Rol dominioInsRolDominiopevcRol) {
        this.dominioInsRolDominiopevcRolInstance = dominioInsRolDominiopevcRol;
        this.dominioInsRolDominiopevcRol = dominioInsRolDominiopevcRol != null ? dominioInsRolDominiopevcRol.getOid() : null;
    }

    private void checkDominioInsRolDominiopevcRol() throws NotNullArgumentException {
        if(this.getDominioInsRolDominiopevcRolInstance() == null || this.getDominioInsRolDominiopevcRolInstance().isNull()) {
            throw new NotNullArgumentException(DominioConstants.SERV_ID_INSROLDOMINIO, DominioConstants.CLASS_ID, DominioConstants.ARG_ID_INSROLDOMINIO_DOMINIOINSROLDOMINIOPEVCROL, DominioConstants.SERV_ALIAS_INSROLDOMINIO, DominioConstants.CLASS_ALIAS, DominioConstants.ARG_ALIAS_INSROLDOMINIO_DOMINIOINSROLDOMINIOPEVCROL);
        }
    }
}
