package com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.UsuarioSistemaExternoConstants;
import com.keralty.aeusuarios.persistence.oid.UsuarioSistemaExternoOid;
import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;

public class ChangePasswordRequest {

    @JsonProperty("oid")
    private UsuarioSistemaExternoOid usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno;
    
    @JsonIgnore
    private UsuarioSistemaExterno usuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance;

    @JsonProperty("old")
    private String usuarioSistemaExternochangePasswordpOldPassword;

    @JsonProperty("new")
    private String usuarioSistemaExternochangePasswordpNewPassword;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno();
        checkUsuarioSistemaExternochangePasswordpOldPassword();
        checkUsuarioSistemaExternochangePasswordpNewPassword();
    }

    @JsonIgnore
    public UsuarioSistemaExternoOid getUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno() {
        return this.usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno;
    }
    
    public void setUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno(UsuarioSistemaExternoOid usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno = usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno;
    }

    @JsonIgnore
    public UsuarioSistemaExterno getUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance() {
        return this.usuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance;
    }
    
    public void setUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance(UsuarioSistemaExterno usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno) {
        this.usuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance = usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno;
        this.usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno = usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno != null ? usuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno.getOid() : null;
    }

    private void checkUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExterno() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance() == null || this.getUsuarioSistemaExternochangePasswordpthisUsuarioSistemaExternoInstance().isNull()) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_CHANGEP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_CHANGEP4SSW0RD_USUARIOSISTEMAEXTERNOCHANGEP4SSW0RDPTHISUSUARIOSISTEMAEXTERNO, UsuarioSistemaExternoConstants.SERV_ALIAS_CHANGEP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_CHANGEP4SSW0RD_USUARIOSISTEMAEXTERNOCHANGEP4SSW0RDPTHISUSUARIOSISTEMAEXTERNO);
        }
    }

    @JsonIgnore
    public String getUsuarioSistemaExternochangePasswordpOldPassword() {
        return this.usuarioSistemaExternochangePasswordpOldPassword;
    }
    
    public void setUsuarioSistemaExternochangePasswordpOldPassword(String usuarioSistemaExternochangePasswordpOldPassword) {
        this.usuarioSistemaExternochangePasswordpOldPassword = usuarioSistemaExternochangePasswordpOldPassword;
    }

    private void checkUsuarioSistemaExternochangePasswordpOldPassword() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternochangePasswordpOldPassword() == null) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_CHANGEP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_CHANGEP4SSW0RD_USUARIOSISTEMAEXTERNOCHANGEP4SSW0RDPOLDP4SSW0RD, UsuarioSistemaExternoConstants.SERV_ALIAS_CHANGEP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_CHANGEP4SSW0RD_USUARIOSISTEMAEXTERNOCHANGEP4SSW0RDPOLDP4SSW0RD);
        }
    }

    @JsonIgnore
    public String getUsuarioSistemaExternochangePasswordpNewPassword() {
        return this.usuarioSistemaExternochangePasswordpNewPassword;
    }
    
    public void setUsuarioSistemaExternochangePasswordpNewPassword(String usuarioSistemaExternochangePasswordpNewPassword) {
        this.usuarioSistemaExternochangePasswordpNewPassword = usuarioSistemaExternochangePasswordpNewPassword;
    }

    private void checkUsuarioSistemaExternochangePasswordpNewPassword() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternochangePasswordpNewPassword() == null) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_CHANGEP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_CHANGEP4SSW0RD_USUARIOSISTEMAEXTERNOCHANGEP4SSW0RDPNEWP4SSW0RD, UsuarioSistemaExternoConstants.SERV_ALIAS_CHANGEP4SSW0RD, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_CHANGEP4SSW0RD_USUARIOSISTEMAEXTERNOCHANGEP4SSW0RDPNEWP4SSW0RD);
        }
    }
}
