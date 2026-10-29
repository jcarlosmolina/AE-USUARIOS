package com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.UsuarioSistemaExternoConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioSistemaExternoOid;
import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;

public class ModificarRequest {

    @JsonProperty("p_thisusuariosistemaexterno_oid")
    private UsuarioSistemaExternoOid usuarioSistemaExternomodificarpthisUsuarioSistemaExterno;
    
    @JsonIgnore
    private UsuarioSistemaExterno usuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance;

    @JsonProperty("p_descripcion")
    private String usuarioSistemaExternomodificarpDescripcion;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioSistemaExternomodificarpthisUsuarioSistemaExterno();
    }

    @JsonIgnore
    public UsuarioSistemaExternoOid getUsuarioSistemaExternomodificarpthisUsuarioSistemaExterno() {
        return this.usuarioSistemaExternomodificarpthisUsuarioSistemaExterno;
    }
    
    public void setUsuarioSistemaExternomodificarpthisUsuarioSistemaExterno(UsuarioSistemaExternoOid usuarioSistemaExternomodificarpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternomodificarpthisUsuarioSistemaExterno = usuarioSistemaExternomodificarpthisUsuarioSistemaExterno;
    }

    @JsonIgnore
    public UsuarioSistemaExterno getUsuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance() {
        return this.usuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance;
    }
    
    public void setUsuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance(UsuarioSistemaExterno usuarioSistemaExternomodificarpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance = usuarioSistemaExternomodificarpthisUsuarioSistemaExterno;
        this.usuarioSistemaExternomodificarpthisUsuarioSistemaExterno = usuarioSistemaExternomodificarpthisUsuarioSistemaExterno != null ? usuarioSistemaExternomodificarpthisUsuarioSistemaExterno.getOid() : null;
    }

    private void checkUsuarioSistemaExternomodificarpthisUsuarioSistemaExterno() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance() == null || this.getUsuarioSistemaExternomodificarpthisUsuarioSistemaExternoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_MODIFICAR, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_MODIFICAR_USUARIOSISTEMAEXTERNOMODIFICARPTHISUSUARIOSISTEMAEXTERNO, UsuarioSistemaExternoConstants.SERV_ALIAS_MODIFICAR, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_MODIFICAR_USUARIOSISTEMAEXTERNOMODIFICARPTHISUSUARIOSISTEMAEXTERNO);
        }
    }

    @JsonIgnore
    public String getUsuarioSistemaExternomodificarpDescripcion() {
        return this.usuarioSistemaExternomodificarpDescripcion;
    }
    
    public void setUsuarioSistemaExternomodificarpDescripcion(String usuarioSistemaExternomodificarpDescripcion) {
        this.usuarioSistemaExternomodificarpDescripcion = usuarioSistemaExternomodificarpDescripcion;
    }
}
