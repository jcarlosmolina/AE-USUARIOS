package com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.UsuarioSistemaExternoConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioSistemaExternoOid;
import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;

public class SetPasswordRequest {

    @JsonProperty("p_thisusuariosistemaexterno_oid")
    private UsuarioSistemaExternoOid usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno;
    
    @JsonIgnore
    private UsuarioSistemaExterno usuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance;

    @JsonProperty("p_newpassword")
    private String usuarioSistemaExternosetPasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno();
        checkUsuarioSistemaExternosetPasswordpNewPassword();
    }

    @JsonIgnore
    public UsuarioSistemaExternoOid getUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno() {
        return this.usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno;
    }
    
    public void setUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno(UsuarioSistemaExternoOid usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno = usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno;
    }

    @JsonIgnore
    public UsuarioSistemaExterno getUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance() {
        return this.usuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance;
    }
    
    public void setUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance(UsuarioSistemaExterno usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance = usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno;
        this.usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno = usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno != null ? usuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno.getOid() : null;
    }

    private void checkUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExterno() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance() == null || this.getUsuarioSistemaExternosetPasswordpthisUsuarioSistemaExternoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_SETP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_SETP4SSW0RD_USUARIOSISTEMAEXTERNOSETP4SSW0RDPTHISUSUARIOSISTEMAEXTERNO, UsuarioSistemaExternoConstants.SERV_ALIAS_SETP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_SETP4SSW0RD_USUARIOSISTEMAEXTERNOSETP4SSW0RDPTHISUSUARIOSISTEMAEXTERNO);
        }
    }

    @JsonIgnore
    public String getUsuarioSistemaExternosetPasswordpNewPassword() {
        return this.usuarioSistemaExternosetPasswordpNewPassword;
    }
    
    public void setUsuarioSistemaExternosetPasswordpNewPassword(String usuarioSistemaExternosetPasswordpNewPassword) {
        this.usuarioSistemaExternosetPasswordpNewPassword = usuarioSistemaExternosetPasswordpNewPassword;
    }

    private void checkUsuarioSistemaExternosetPasswordpNewPassword() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternosetPasswordpNewPassword() == null) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_SETP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_SETP4SSW0RD_USUARIOSISTEMAEXTERNOSETP4SSW0RDPNEWP4SSW0RD, UsuarioSistemaExternoConstants.SERV_ALIAS_SETP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_SETP4SSW0RD_USUARIOSISTEMAEXTERNOSETP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
