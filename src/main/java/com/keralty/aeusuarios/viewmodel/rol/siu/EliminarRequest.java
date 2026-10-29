package com.keralty.aeusuarios.viewmodel.rol.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RolConstants;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;

public class EliminarRequest {

    @JsonProperty("p_thisrol_oid")
    private RolOid roleliminarpthisRol;
    
    @JsonIgnore
    private Rol roleliminarpthisRolInstance;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkRoleliminarpthisRol();
    }

    @JsonIgnore
    public RolOid getRoleliminarpthisRol() {
        return this.roleliminarpthisRol;
    }
    
    public void setRoleliminarpthisRol(RolOid roleliminarpthisRol) {
        this.roleliminarpthisRol = roleliminarpthisRol;
    }

    @JsonIgnore
    public Rol getRoleliminarpthisRolInstance() {
        return this.roleliminarpthisRolInstance;
    }
    
    public void setRoleliminarpthisRolInstance(Rol roleliminarpthisRol) {
        this.roleliminarpthisRolInstance = roleliminarpthisRol;
        this.roleliminarpthisRol = roleliminarpthisRol != null ? roleliminarpthisRol.getOid() : null;
    }

    private void checkRoleliminarpthisRol() throws NotNullArgumentException {
        if(this.getRoleliminarpthisRolInstance() == null || this.getRoleliminarpthisRolInstance().isNull()) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_ELIMINAR, RolConstants.CLASS_ID, RolConstants.ARG_ID_ELIMINAR_ROLELIMINARPTHISROL, RolConstants.SERV_ALIAS_ELIMINAR, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_ELIMINAR_ROLELIMINARPTHISROL);
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
