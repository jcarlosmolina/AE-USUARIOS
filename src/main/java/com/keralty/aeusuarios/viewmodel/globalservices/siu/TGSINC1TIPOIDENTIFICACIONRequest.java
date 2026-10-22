package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;

public class TGSINC1TIPOIDENTIFICACIONRequest {

    @JsonProperty("pt_p_atrcodigo")
    private Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo;

    @JsonProperty("pt_p_atrdescripcion")
    private String tGSINC1TIPOIDENTIFICACIONptpatrDescripcion;

    @JsonProperty("pt_p_atrnombrecorto")
    private String tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1TIPOIDENTIFICACIONptpatrCodigo();
        checkTGSINC1TIPOIDENTIFICACIONptpatrDescripcion();
        checkTGSINC1TIPOIDENTIFICACIONptpatrNombreCorto();
    }

    @JsonIgnore
    public Long getTGSINC1TIPOIDENTIFICACIONptpatrCodigo() {
        return this.tGSINC1TIPOIDENTIFICACIONptpatrCodigo;
    }
    
    public void setTGSINC1TIPOIDENTIFICACIONptpatrCodigo(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) {
        this.tGSINC1TIPOIDENTIFICACIONptpatrCodigo = tGSINC1TIPOIDENTIFICACIONptpatrCodigo;
    }

    private void checkTGSINC1TIPOIDENTIFICACIONptpatrCodigo() throws NotNullArgumentException {
        if(this.getTGSINC1TIPOIDENTIFICACIONptpatrCodigo() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1TIPOIDENTIFICACION, GlobalServiceConstants.GS_ARG_ID_TGSINC1TIPOIDENTIFICACION_TGSINC1TIPOIDENTIFICACIONPTPATRCODIGO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1TIPOIDENTIFICACION, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1TIPOIDENTIFICACION_TGSINC1TIPOIDENTIFICACIONPTPATRCODIGO);
        }
    }

    @JsonIgnore
    public String getTGSINC1TIPOIDENTIFICACIONptpatrDescripcion() {
        return this.tGSINC1TIPOIDENTIFICACIONptpatrDescripcion;
    }
    
    public void setTGSINC1TIPOIDENTIFICACIONptpatrDescripcion(String tGSINC1TIPOIDENTIFICACIONptpatrDescripcion) {
        this.tGSINC1TIPOIDENTIFICACIONptpatrDescripcion = tGSINC1TIPOIDENTIFICACIONptpatrDescripcion;
    }

    private void checkTGSINC1TIPOIDENTIFICACIONptpatrDescripcion() throws NotNullArgumentException {
        if(this.getTGSINC1TIPOIDENTIFICACIONptpatrDescripcion() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1TIPOIDENTIFICACION, GlobalServiceConstants.GS_ARG_ID_TGSINC1TIPOIDENTIFICACION_TGSINC1TIPOIDENTIFICACIONPTPATRDESCRIPCION, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1TIPOIDENTIFICACION, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1TIPOIDENTIFICACION_TGSINC1TIPOIDENTIFICACIONPTPATRDESCRIPCION);
        }
    }

    @JsonIgnore
    public String getTGSINC1TIPOIDENTIFICACIONptpatrNombreCorto() {
        return this.tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto;
    }
    
    public void setTGSINC1TIPOIDENTIFICACIONptpatrNombreCorto(String tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto) {
        this.tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto = tGSINC1TIPOIDENTIFICACIONptpatrNombreCorto;
    }

    private void checkTGSINC1TIPOIDENTIFICACIONptpatrNombreCorto() throws NotNullArgumentException {
        if(this.getTGSINC1TIPOIDENTIFICACIONptpatrNombreCorto() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1TIPOIDENTIFICACION, GlobalServiceConstants.GS_ARG_ID_TGSINC1TIPOIDENTIFICACION_TGSINC1TIPOIDENTIFICACIONPTPATRNOMBRECORTO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1TIPOIDENTIFICACION, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1TIPOIDENTIFICACION_TGSINC1TIPOIDENTIFICACIONPTPATRNOMBRECORTO);
        }
    }
}
