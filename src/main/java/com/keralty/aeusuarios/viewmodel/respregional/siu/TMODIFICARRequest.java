package com.keralty.aeusuarios.viewmodel.respregional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.RespRegional;

public class TMODIFICARRequest {

    @JsonProperty("p_thisrespregional_oid")
    private RespRegionalOid respRegionalTMODIFICARpthisRespRegional;
    
    @JsonIgnore
    private RespRegional respRegionalTMODIFICARpthisRespRegionalInstance;

    @JsonProperty("pt_p_usuarioldap")
    private String respRegionalTMODIFICARptpUsuarioLDAP;

    @JsonProperty("pt_p_primernombre")
    private String respRegionalTMODIFICARptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String respRegionalTMODIFICARptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String respRegionalTMODIFICARptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String respRegionalTMODIFICARptpSegundoApellido;

    @JsonProperty("pt_p_email")
    private String respRegionalTMODIFICARptpEmail;

    @JsonProperty("pt_p_evcregional_json")
    private String respRegionalTMODIFICARptpevcRegional;
    
    @JsonIgnore
    private Regional respRegionalTMODIFICARptpevcRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRespRegionalTMODIFICARpthisRespRegional();
        checkRespRegionalTMODIFICARptpPrimerNombre();
        checkRespRegionalTMODIFICARptpPrimerApellido();
    }

    @JsonIgnore
    public RespRegionalOid getRespRegionalTMODIFICARpthisRespRegional() {
        return this.respRegionalTMODIFICARpthisRespRegional;
    }
    
    public void setRespRegionalTMODIFICARpthisRespRegional(RespRegionalOid respRegionalTMODIFICARpthisRespRegional) {
        this.respRegionalTMODIFICARpthisRespRegional = respRegionalTMODIFICARpthisRespRegional;
    }

    @JsonIgnore
    public RespRegional getRespRegionalTMODIFICARpthisRespRegionalInstance() {
        return this.respRegionalTMODIFICARpthisRespRegionalInstance;
    }
    
    public void setRespRegionalTMODIFICARpthisRespRegionalInstance(RespRegional respRegionalTMODIFICARpthisRespRegional) {
        this.respRegionalTMODIFICARpthisRespRegionalInstance = respRegionalTMODIFICARpthisRespRegional;
        this.respRegionalTMODIFICARpthisRespRegional = respRegionalTMODIFICARpthisRespRegional != null ? respRegionalTMODIFICARpthisRespRegional.getOid() : null;
    }

    private void checkRespRegionalTMODIFICARpthisRespRegional() throws NotNullArgumentException {
        if(this.getRespRegionalTMODIFICARpthisRespRegionalInstance() == null || this.getRespRegionalTMODIFICARpthisRespRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_TMODIFICAR, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_TMODIFICAR_RESPREGIONALTMODIFICARPTHISRESPREGIONAL, RespRegionalConstants.SERV_ALIAS_TMODIFICAR, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_TMODIFICAR_RESPREGIONALTMODIFICARPTHISRESPREGIONAL);
        }
    }

    @JsonIgnore
    public String getRespRegionalTMODIFICARptpUsuarioLDAP() {
        return this.respRegionalTMODIFICARptpUsuarioLDAP;
    }
    
    public void setRespRegionalTMODIFICARptpUsuarioLDAP(String respRegionalTMODIFICARptpUsuarioLDAP) {
        this.respRegionalTMODIFICARptpUsuarioLDAP = respRegionalTMODIFICARptpUsuarioLDAP;
    }

    @JsonIgnore
    public String getRespRegionalTMODIFICARptpPrimerNombre() {
        return this.respRegionalTMODIFICARptpPrimerNombre;
    }
    
    public void setRespRegionalTMODIFICARptpPrimerNombre(String respRegionalTMODIFICARptpPrimerNombre) {
        this.respRegionalTMODIFICARptpPrimerNombre = respRegionalTMODIFICARptpPrimerNombre;
    }

    private void checkRespRegionalTMODIFICARptpPrimerNombre() throws NotNullArgumentException {
        if(this.getRespRegionalTMODIFICARptpPrimerNombre() == null) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_TMODIFICAR, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_TMODIFICAR_RESPREGIONALTMODIFICARPTPPRIMERNOMBRE, RespRegionalConstants.SERV_ALIAS_TMODIFICAR, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_TMODIFICAR_RESPREGIONALTMODIFICARPTPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getRespRegionalTMODIFICARptpSegundoNombre() {
        return this.respRegionalTMODIFICARptpSegundoNombre;
    }
    
    public void setRespRegionalTMODIFICARptpSegundoNombre(String respRegionalTMODIFICARptpSegundoNombre) {
        this.respRegionalTMODIFICARptpSegundoNombre = respRegionalTMODIFICARptpSegundoNombre;
    }

    @JsonIgnore
    public String getRespRegionalTMODIFICARptpPrimerApellido() {
        return this.respRegionalTMODIFICARptpPrimerApellido;
    }
    
    public void setRespRegionalTMODIFICARptpPrimerApellido(String respRegionalTMODIFICARptpPrimerApellido) {
        this.respRegionalTMODIFICARptpPrimerApellido = respRegionalTMODIFICARptpPrimerApellido;
    }

    private void checkRespRegionalTMODIFICARptpPrimerApellido() throws NotNullArgumentException {
        if(this.getRespRegionalTMODIFICARptpPrimerApellido() == null) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_TMODIFICAR, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_TMODIFICAR_RESPREGIONALTMODIFICARPTPPRIMERAPELLIDO, RespRegionalConstants.SERV_ALIAS_TMODIFICAR, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_TMODIFICAR_RESPREGIONALTMODIFICARPTPPRIMERAPELLIDO);
        }
    }

    @JsonIgnore
    public String getRespRegionalTMODIFICARptpSegundoApellido() {
        return this.respRegionalTMODIFICARptpSegundoApellido;
    }
    
    public void setRespRegionalTMODIFICARptpSegundoApellido(String respRegionalTMODIFICARptpSegundoApellido) {
        this.respRegionalTMODIFICARptpSegundoApellido = respRegionalTMODIFICARptpSegundoApellido;
    }

    @JsonIgnore
    public String getRespRegionalTMODIFICARptpEmail() {
        return this.respRegionalTMODIFICARptpEmail;
    }
    
    public void setRespRegionalTMODIFICARptpEmail(String respRegionalTMODIFICARptpEmail) {
        this.respRegionalTMODIFICARptpEmail = respRegionalTMODIFICARptpEmail;
    }

    @JsonIgnore
    public String getRespRegionalTMODIFICARptpevcRegional() {
        return this.respRegionalTMODIFICARptpevcRegional;
    }
    
    public void setRespRegionalTMODIFICARptpevcRegional(String respRegionalTMODIFICARptpevcRegional) {
        this.respRegionalTMODIFICARptpevcRegional = respRegionalTMODIFICARptpevcRegional;
    }

    @JsonIgnore
    public Regional getRespRegionalTMODIFICARptpevcRegionalInstance() {
        return this.respRegionalTMODIFICARptpevcRegionalInstance;
    }
    
    public void setRespRegionalTMODIFICARptpevcRegionalInstance(Regional respRegionalTMODIFICARptpevcRegional) {
        this.respRegionalTMODIFICARptpevcRegionalInstance = respRegionalTMODIFICARptpevcRegional;
        this.respRegionalTMODIFICARptpevcRegional = respRegionalTMODIFICARptpevcRegional != null ? respRegionalTMODIFICARptpevcRegional.getOid().toJson() : "";
    }
}
