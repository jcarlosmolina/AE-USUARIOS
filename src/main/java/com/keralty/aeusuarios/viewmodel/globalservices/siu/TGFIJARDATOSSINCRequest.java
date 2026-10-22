package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;

public class TGFIJARDATOSSINCRequest {

    @JsonProperty("ptnumparametrica")
    private Long tGFIJARDATOSSINCptNumParametrica;

    @JsonProperty("ptresultado")
    private String tGFIJARDATOSSINCptResultado;

    public void checkArguments() throws NotNullArgumentException {
        checkTGFIJARDATOSSINCptNumParametrica();
    }

    @JsonIgnore
    public Long getTGFIJARDATOSSINCptNumParametrica() {
        return this.tGFIJARDATOSSINCptNumParametrica;
    }
    
    public void setTGFIJARDATOSSINCptNumParametrica(Long tGFIJARDATOSSINCptNumParametrica) {
        this.tGFIJARDATOSSINCptNumParametrica = tGFIJARDATOSSINCptNumParametrica;
    }

    private void checkTGFIJARDATOSSINCptNumParametrica() throws NotNullArgumentException {
        if(this.getTGFIJARDATOSSINCptNumParametrica() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGFIJARDATOSSINC, GlobalServiceConstants.GS_ARG_ID_TGFIJARDATOSSINC_TGFIJARDATOSSINCPTNUMPARAMETRICA, GlobalServiceConstants.G_SERV_ALIAS_TGFIJARDATOSSINC, GlobalServiceConstants.GS_ARG_ALIAS_TGFIJARDATOSSINC_TGFIJARDATOSSINCPTNUMPARAMETRICA);
        }
    }

    @JsonIgnore
    public String getTGFIJARDATOSSINCptResultado() {
        return this.tGFIJARDATOSSINCptResultado;
    }
    
    public void setTGFIJARDATOSSINCptResultado(String tGFIJARDATOSSINCptResultado) {
        this.tGFIJARDATOSSINCptResultado = tGFIJARDATOSSINCptResultado;
    }
}
