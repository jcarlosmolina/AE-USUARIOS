package com.keralty.aeusuarios.viewmodel.firma.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FirmaConstants;
import com.keralty.aeusuarios.persistence.Firma;
import com.keralty.aeusuarios.persistence.oid.FirmaOid;

public class ModificarRequest {

    @JsonProperty("p_thisfirma_oid")
    private FirmaOid firmamodificarpthisFirma;
    
    @JsonIgnore
    private Firma firmamodificarpthisFirmaInstance;

    @JsonProperty("p_imagenfirma")
    private byte[] firmamodificarpImagenFirma;

    @JsonProperty("p_latitud")
    private String firmamodificarpLatitud;

    @JsonProperty("p_longitud")
    private String firmamodificarpLongitud;

    public void checkArguments() throws NotNullArgumentException {
        checkFirmamodificarpthisFirma();
    }

    @JsonIgnore
    public FirmaOid getFirmamodificarpthisFirma() {
        return this.firmamodificarpthisFirma;
    }
    
    public void setFirmamodificarpthisFirma(FirmaOid firmamodificarpthisFirma) {
        this.firmamodificarpthisFirma = firmamodificarpthisFirma;
    }

    @JsonIgnore
    public Firma getFirmamodificarpthisFirmaInstance() {
        return this.firmamodificarpthisFirmaInstance;
    }
    
    public void setFirmamodificarpthisFirmaInstance(Firma firmamodificarpthisFirma) {
        this.firmamodificarpthisFirmaInstance = firmamodificarpthisFirma;
        this.firmamodificarpthisFirma = firmamodificarpthisFirma != null ? firmamodificarpthisFirma.getOid() : null;
    }

    private void checkFirmamodificarpthisFirma() throws NotNullArgumentException {
        if(this.getFirmamodificarpthisFirmaInstance() == null || this.getFirmamodificarpthisFirmaInstance().isNull()) {
            throw new NotNullArgumentException(FirmaConstants.SERV_ID_MODIFICAR, FirmaConstants.CLASS_ID, FirmaConstants.ARG_ID_MODIFICAR_FIRMAMODIFICARPTHISFIRMA, FirmaConstants.SERV_ALIAS_MODIFICAR, FirmaConstants.CLASS_ALIAS, FirmaConstants.ARG_ALIAS_MODIFICAR_FIRMAMODIFICARPTHISFIRMA);
        }
    }

    @JsonIgnore
    public byte[] getFirmamodificarpImagenFirma() {
        return this.firmamodificarpImagenFirma;
    }
    
    public void setFirmamodificarpImagenFirma(byte[] firmamodificarpImagenFirma) {
        this.firmamodificarpImagenFirma = firmamodificarpImagenFirma;
    }

    @JsonIgnore
    public String getFirmamodificarpLatitud() {
        return this.firmamodificarpLatitud;
    }
    
    public void setFirmamodificarpLatitud(String firmamodificarpLatitud) {
        this.firmamodificarpLatitud = firmamodificarpLatitud;
    }

    @JsonIgnore
    public String getFirmamodificarpLongitud() {
        return this.firmamodificarpLongitud;
    }
    
    public void setFirmamodificarpLongitud(String firmamodificarpLongitud) {
        this.firmamodificarpLongitud = firmamodificarpLongitud;
    }
}
