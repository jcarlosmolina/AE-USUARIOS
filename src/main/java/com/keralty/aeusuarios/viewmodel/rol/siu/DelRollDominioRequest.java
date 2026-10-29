package com.keralty.aeusuarios.viewmodel.rol.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.persistence.Dominio;
import com.keralty.aeusuarios.persistence.oid.DominioOid;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;

public class DelRollDominioRequest {

    @JsonProperty("p_thisrol_oid")
    private RolOid rolDelRollDominiopthisRol;
    
    @JsonIgnore
    private Rol rolDelRollDominiopthisRolInstance;

    @JsonProperty("p_evcdominio_oid")
    private DominioOid rolDelRollDominiopevcDominio;
    
    @JsonIgnore
    private Dominio rolDelRollDominiopevcDominioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRolDelRollDominiopthisRol();
        checkRolDelRollDominiopevcDominio();
    }

    @JsonIgnore
    public RolOid getRolDelRollDominiopthisRol() {
        return this.rolDelRollDominiopthisRol;
    }
    
    public void setRolDelRollDominiopthisRol(RolOid rolDelRollDominiopthisRol) {
        this.rolDelRollDominiopthisRol = rolDelRollDominiopthisRol;
    }

    @JsonIgnore
    public Rol getRolDelRollDominiopthisRolInstance() {
        return this.rolDelRollDominiopthisRolInstance;
    }
    
    public void setRolDelRollDominiopthisRolInstance(Rol rolDelRollDominiopthisRol) {
        this.rolDelRollDominiopthisRolInstance = rolDelRollDominiopthisRol;
        this.rolDelRollDominiopthisRol = rolDelRollDominiopthisRol != null ? rolDelRollDominiopthisRol.getOid() : null;
    }

    private void checkRolDelRollDominiopthisRol() throws NotNullArgumentException {
        if(this.getRolDelRollDominiopthisRolInstance() == null || this.getRolDelRollDominiopthisRolInstance().isNull()) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_DELROLLDOMINIO, RolConstants.CLASS_ID, RolConstants.ARG_ID_DELROLLDOMINIO_ROLDELROLLDOMINIOPTHISROL, RolConstants.SERV_ALIAS_DELROLLDOMINIO, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_DELROLLDOMINIO_ROLDELROLLDOMINIOPTHISROL);
        }
    }

    @JsonIgnore
    public DominioOid getRolDelRollDominiopevcDominio() {
        return this.rolDelRollDominiopevcDominio;
    }
    
    public void setRolDelRollDominiopevcDominio(DominioOid rolDelRollDominiopevcDominio) {
        this.rolDelRollDominiopevcDominio = rolDelRollDominiopevcDominio;
    }

    @JsonIgnore
    public Dominio getRolDelRollDominiopevcDominioInstance() {
        return this.rolDelRollDominiopevcDominioInstance;
    }
    
    public void setRolDelRollDominiopevcDominioInstance(Dominio rolDelRollDominiopevcDominio) {
        this.rolDelRollDominiopevcDominioInstance = rolDelRollDominiopevcDominio;
        this.rolDelRollDominiopevcDominio = rolDelRollDominiopevcDominio != null ? rolDelRollDominiopevcDominio.getOid() : null;
    }

    private void checkRolDelRollDominiopevcDominio() throws NotNullArgumentException {
        if(this.getRolDelRollDominiopevcDominioInstance() == null || this.getRolDelRollDominiopevcDominioInstance().isNull()) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_DELROLLDOMINIO, RolConstants.CLASS_ID, RolConstants.ARG_ID_DELROLLDOMINIO_ROLDELROLLDOMINIOPEVCDOMINIO, RolConstants.SERV_ALIAS_DELROLLDOMINIO, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_DELROLLDOMINIO_ROLDELROLLDOMINIOPEVCDOMINIO);
        }
    }
}
