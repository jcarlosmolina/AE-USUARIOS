package com.keralty.aeusuarios.viewmodel.rol.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;

public class InsRolDominioRequest {

    @JsonProperty("p_thisrol_oid")
    private RolOid rolInsRolDominiopthisRol;
    
    @JsonIgnore
    private Rol rolInsRolDominiopthisRolInstance;

    @JsonProperty("p_evcdominio_oid")
    private DominioOid rolInsRolDominiopevcDominio;
    
    @JsonIgnore
    private Dominio rolInsRolDominiopevcDominioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRolInsRolDominiopthisRol();
        checkRolInsRolDominiopevcDominio();
    }

    @JsonIgnore
    public RolOid getRolInsRolDominiopthisRol() {
        return this.rolInsRolDominiopthisRol;
    }
    
    public void setRolInsRolDominiopthisRol(RolOid rolInsRolDominiopthisRol) {
        this.rolInsRolDominiopthisRol = rolInsRolDominiopthisRol;
    }

    @JsonIgnore
    public Rol getRolInsRolDominiopthisRolInstance() {
        return this.rolInsRolDominiopthisRolInstance;
    }
    
    public void setRolInsRolDominiopthisRolInstance(Rol rolInsRolDominiopthisRol) {
        this.rolInsRolDominiopthisRolInstance = rolInsRolDominiopthisRol;
        this.rolInsRolDominiopthisRol = rolInsRolDominiopthisRol != null ? rolInsRolDominiopthisRol.getOid() : null;
    }

    private void checkRolInsRolDominiopthisRol() throws NotNullArgumentException {
        if(this.getRolInsRolDominiopthisRolInstance() == null || this.getRolInsRolDominiopthisRolInstance().isNull()) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_INSROLDOMINIO, RolConstants.CLASS_ID, RolConstants.ARG_ID_INSROLDOMINIO_ROLINSROLDOMINIOPTHISROL, RolConstants.SERV_ALIAS_INSROLDOMINIO, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_INSROLDOMINIO_ROLINSROLDOMINIOPTHISROL);
        }
    }

    @JsonIgnore
    public DominioOid getRolInsRolDominiopevcDominio() {
        return this.rolInsRolDominiopevcDominio;
    }
    
    public void setRolInsRolDominiopevcDominio(DominioOid rolInsRolDominiopevcDominio) {
        this.rolInsRolDominiopevcDominio = rolInsRolDominiopevcDominio;
    }

    @JsonIgnore
    public Dominio getRolInsRolDominiopevcDominioInstance() {
        return this.rolInsRolDominiopevcDominioInstance;
    }
    
    public void setRolInsRolDominiopevcDominioInstance(Dominio rolInsRolDominiopevcDominio) {
        this.rolInsRolDominiopevcDominioInstance = rolInsRolDominiopevcDominio;
        this.rolInsRolDominiopevcDominio = rolInsRolDominiopevcDominio != null ? rolInsRolDominiopevcDominio.getOid() : null;
    }

    private void checkRolInsRolDominiopevcDominio() throws NotNullArgumentException {
        if(this.getRolInsRolDominiopevcDominioInstance() == null || this.getRolInsRolDominiopevcDominioInstance().isNull()) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_INSROLDOMINIO, RolConstants.CLASS_ID, RolConstants.ARG_ID_INSROLDOMINIO_ROLINSROLDOMINIOPEVCDOMINIO, RolConstants.SERV_ALIAS_INSROLDOMINIO, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_INSROLDOMINIO_ROLINSROLDOMINIOPEVCDOMINIO);
        }
    }
}
