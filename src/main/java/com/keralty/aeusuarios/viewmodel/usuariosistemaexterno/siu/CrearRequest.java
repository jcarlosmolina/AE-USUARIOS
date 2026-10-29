package com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.UsuarioSistemaExternoConstants;

public class CrearRequest {

    @JsonProperty("p_atrlogin")
    private String usuarioSistemaExternocrearpatrLogin;

    @JsonProperty("p_atrdescripcion")
    private String usuarioSistemaExternocrearpatrDescripcion;

    @JsonProperty("p_password")
    private String usuarioSistemaExternocrearppassword;

    public void checkArguments() throws NotNullArgumentException {
        checkUsuarioSistemaExternocrearpatrLogin();
        checkUsuarioSistemaExternocrearppassword();
    }

    @JsonIgnore
    public String getUsuarioSistemaExternocrearpatrLogin() {
        return this.usuarioSistemaExternocrearpatrLogin;
    }
    
    public void setUsuarioSistemaExternocrearpatrLogin(String usuarioSistemaExternocrearpatrLogin) {
        this.usuarioSistemaExternocrearpatrLogin = usuarioSistemaExternocrearpatrLogin;
    }

    private void checkUsuarioSistemaExternocrearpatrLogin() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternocrearpatrLogin() == null) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_CREAR, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_CREAR_USUARIOSISTEMAEXTERNOCREARPATRLOGIN, UsuarioSistemaExternoConstants.SERV_ALIAS_CREAR, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_CREAR_USUARIOSISTEMAEXTERNOCREARPATRLOGIN);
        }
    }

    @JsonIgnore
    public String getUsuarioSistemaExternocrearpatrDescripcion() {
        return this.usuarioSistemaExternocrearpatrDescripcion;
    }
    
    public void setUsuarioSistemaExternocrearpatrDescripcion(String usuarioSistemaExternocrearpatrDescripcion) {
        this.usuarioSistemaExternocrearpatrDescripcion = usuarioSistemaExternocrearpatrDescripcion;
    }

    @JsonIgnore
    public String getUsuarioSistemaExternocrearppassword() {
        return this.usuarioSistemaExternocrearppassword;
    }
    
    public void setUsuarioSistemaExternocrearppassword(String usuarioSistemaExternocrearppassword) {
        this.usuarioSistemaExternocrearppassword = usuarioSistemaExternocrearppassword;
    }

    private void checkUsuarioSistemaExternocrearppassword() throws NotNullArgumentException {
        if(this.getUsuarioSistemaExternocrearppassword() == null) {
            throw new NotNullArgumentException(UsuarioSistemaExternoConstants.SERV_ID_CREAR, UsuarioSistemaExternoConstants.CLASS_ID, UsuarioSistemaExternoConstants.ARG_ID_CREAR_USUARIOSISTEMAEXTERNOCREARPP4SSW0RD, UsuarioSistemaExternoConstants.SERV_ALIAS_CREAR, UsuarioSistemaExternoConstants.CLASS_ALIAS, UsuarioSistemaExternoConstants.ARG_ALIAS_CREAR_USUARIOSISTEMAEXTERNOCREARPP4SSW0RD);
        }
    }
}
