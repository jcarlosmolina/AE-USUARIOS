package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;

public class TGSINC1PRODUCTORequest {

    @JsonProperty("pt_p_atrnumero")
    private Long tGSINC1PRODUCTOptpatrNumero;

    @JsonProperty("pt_p_atrdescripcion")
    private String tGSINC1PRODUCTOptpatrDescripcion;

    @JsonProperty("pt_p_atrcodigolegal")
    private String tGSINC1PRODUCTOptpatrCodigoLegal;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1PRODUCTOptpatrNumero();
        checkTGSINC1PRODUCTOptpatrDescripcion();
        checkTGSINC1PRODUCTOptpatrCodigoLegal();
    }

    @JsonIgnore
    public Long getTGSINC1PRODUCTOptpatrNumero() {
        return this.tGSINC1PRODUCTOptpatrNumero;
    }
    
    public void setTGSINC1PRODUCTOptpatrNumero(Long tGSINC1PRODUCTOptpatrNumero) {
        this.tGSINC1PRODUCTOptpatrNumero = tGSINC1PRODUCTOptpatrNumero;
    }

    private void checkTGSINC1PRODUCTOptpatrNumero() throws NotNullArgumentException {
        if(this.getTGSINC1PRODUCTOptpatrNumero() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1PRODUCTO, GlobalServiceConstants.GS_ARG_ID_TGSINC1PRODUCTO_TGSINC1PRODUCTOPTPATRNUMERO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1PRODUCTO, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1PRODUCTO_TGSINC1PRODUCTOPTPATRNUMERO);
        }
    }

    @JsonIgnore
    public String getTGSINC1PRODUCTOptpatrDescripcion() {
        return this.tGSINC1PRODUCTOptpatrDescripcion;
    }
    
    public void setTGSINC1PRODUCTOptpatrDescripcion(String tGSINC1PRODUCTOptpatrDescripcion) {
        this.tGSINC1PRODUCTOptpatrDescripcion = tGSINC1PRODUCTOptpatrDescripcion;
    }

    private void checkTGSINC1PRODUCTOptpatrDescripcion() throws NotNullArgumentException {
        if(this.getTGSINC1PRODUCTOptpatrDescripcion() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1PRODUCTO, GlobalServiceConstants.GS_ARG_ID_TGSINC1PRODUCTO_TGSINC1PRODUCTOPTPATRDESCRIPCION, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1PRODUCTO, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1PRODUCTO_TGSINC1PRODUCTOPTPATRDESCRIPCION);
        }
    }

    @JsonIgnore
    public String getTGSINC1PRODUCTOptpatrCodigoLegal() {
        return this.tGSINC1PRODUCTOptpatrCodigoLegal;
    }
    
    public void setTGSINC1PRODUCTOptpatrCodigoLegal(String tGSINC1PRODUCTOptpatrCodigoLegal) {
        this.tGSINC1PRODUCTOptpatrCodigoLegal = tGSINC1PRODUCTOptpatrCodigoLegal;
    }

    private void checkTGSINC1PRODUCTOptpatrCodigoLegal() throws NotNullArgumentException {
        if(this.getTGSINC1PRODUCTOptpatrCodigoLegal() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1PRODUCTO, GlobalServiceConstants.GS_ARG_ID_TGSINC1PRODUCTO_TGSINC1PRODUCTOPTPATRCODIGOLEGAL, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1PRODUCTO, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1PRODUCTO_TGSINC1PRODUCTOPTPATRCODIGOLEGAL);
        }
    }
}
