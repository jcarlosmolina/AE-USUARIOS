package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;

public class OGCARGAPLANASESORRequest {

    @JsonProperty("ptfichero")
    private byte[] oGCARGAPLANASESORptFichero;

    public void checkArguments() throws NotNullArgumentException {
        checkOGCARGAPLANASESORptFichero();
    }

    @JsonIgnore
    public byte[] getOGCARGAPLANASESORptFichero() {
        return this.oGCARGAPLANASESORptFichero;
    }
    
    public void setOGCARGAPLANASESORptFichero(byte[] oGCARGAPLANASESORptFichero) {
        this.oGCARGAPLANASESORptFichero = oGCARGAPLANASESORptFichero;
    }

    private void checkOGCARGAPLANASESORptFichero() throws NotNullArgumentException {
        if(this.getOGCARGAPLANASESORptFichero() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_OGCARGAPLANASESOR, GlobalServiceConstants.GS_ARG_ID_OGCARGAPLANASESOR_OGCARGAPLANASESORPTFICHERO, GlobalServiceConstants.G_SERV_ALIAS_OGCARGAPLANASESOR, GlobalServiceConstants.GS_ARG_ALIAS_OGCARGAPLANASESOR_OGCARGAPLANASESORPTFICHERO);
        }
    }
}
