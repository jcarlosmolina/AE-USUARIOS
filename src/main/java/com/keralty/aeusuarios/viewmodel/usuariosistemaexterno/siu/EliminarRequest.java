package com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.UsuarioSistemaExternoConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioSistemaExternoOid;
import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;

public class EliminarRequest {

    @JsonProperty("p_thisusuariosistemaexterno_oid")
    private UsuarioSistemaExternoOid usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno;
    
    @JsonIgnore
    private UsuarioSistemaExterno usuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioSistemaExternoeliminarpthisUsuarioSistemaExterno();
    }

    @JsonIgnore
    public UsuarioSistemaExternoOid getUsuarioSistemaExternoeliminarpthisUsuarioSistemaExterno() {
        return this.usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno;
    }
    
    public void setUsuarioSistemaExternoeliminarpthisUsuarioSistemaExterno(UsuarioSistemaExternoOid usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno = usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno;
    }

    @JsonIgnore
    public UsuarioSistemaExterno getUsuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance() {
        return this.usuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance;
    }
    
    public void setUsuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance(UsuarioSistemaExterno usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance = usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno;
        this.usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno = usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno != null ? usuarioSistemaExternoeliminarpthisUsuarioSistemaExterno.getOid() : null;
    }

    private void checkUsuarioSistemaExternoeliminarpthisUsuarioSistemaExterno() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance() == null || this.getUsuarioSistemaExternoeliminarpthisUsuarioSistemaExternoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_ELIMINAR, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_ELIMINAR_USUARIOSISTEMAEXTERNOELIMINARPTHISUSUARIOSISTEMAEXTERNO, UsuarioSistemaExternoConstants.SERV_ALIAS_ELIMINAR, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_ELIMINAR_USUARIOSISTEMAEXTERNOELIMINARPTHISUSUARIOSISTEMAEXTERNO);
        }
    }
}
