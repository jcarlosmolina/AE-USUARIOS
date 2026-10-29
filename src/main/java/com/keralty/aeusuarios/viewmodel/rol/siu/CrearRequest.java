package com.keralty.aeusuarios.viewmodel.rol.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RolConstants;

public class CrearRequest {

    @JsonProperty("p_atrnombre")
    private String rolcrearpatrNombre;

    public void checkArguments() throws NotNullArgumentException {
        checkRolcrearpatrNombre();
    }

    @JsonIgnore
    public String getRolcrearpatrNombre() {
        return this.rolcrearpatrNombre;
    }
    
    public void setRolcrearpatrNombre(String rolcrearpatrNombre) {
        this.rolcrearpatrNombre = rolcrearpatrNombre;
    }

    private void checkRolcrearpatrNombre() throws NotNullArgumentException {
        if(this.getRolcrearpatrNombre() == null) {
            throw new NotNullArgumentException(RolConstants.SERV_ID_CREAR, RolConstants.CLASS_ID, RolConstants.ARG_ID_CREAR_ROLCREARPATRNOMBRE, RolConstants.SERV_ALIAS_CREAR, RolConstants.CLASS_ALIAS, RolConstants.ARG_ALIAS_CREAR_ROLCREARPATRNOMBRE);
        }
    }
}
