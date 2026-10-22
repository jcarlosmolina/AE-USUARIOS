package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;

public class TGPOSPROCESS1ASESORRequest {

    @JsonProperty("p_usuario")
    private String tGPOSPROCESS1ASESORpUsuario;

    @JsonProperty("p_esdirector")
    private Boolean tGPOSPROCESS1ASESORpEsDirector;

    @JsonProperty("p_rol_oid")
    private RolOid tGPOSPROCESS1ASESORpRol;
    
    @JsonIgnore
    private Rol tGPOSPROCESS1ASESORpRolInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkTGPOSPROCESS1ASESORpUsuario();
        checkTGPOSPROCESS1ASESORpEsDirector();
        checkTGPOSPROCESS1ASESORpRol();
    }

    @JsonIgnore
    public String getTGPOSPROCESS1ASESORpUsuario() {
        return this.tGPOSPROCESS1ASESORpUsuario;
    }
    
    public void setTGPOSPROCESS1ASESORpUsuario(String tGPOSPROCESS1ASESORpUsuario) {
        this.tGPOSPROCESS1ASESORpUsuario = tGPOSPROCESS1ASESORpUsuario;
    }

    private void checkTGPOSPROCESS1ASESORpUsuario() throws NotNullArgumentException {
        if(this.getTGPOSPROCESS1ASESORpUsuario() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGPOSPROCESS1ASESOR, GlobalServiceConstants.GS_ARG_ID_TGPOSPROCESS1ASESOR_TGPOSPROCESS1ASESORPUSUARIO, GlobalServiceConstants.G_SERV_ALIAS_TGPOSPROCESS1ASESOR, GlobalServiceConstants.GS_ARG_ALIAS_TGPOSPROCESS1ASESOR_TGPOSPROCESS1ASESORPUSUARIO);
        }
    }

    @JsonIgnore
    public Boolean getTGPOSPROCESS1ASESORpEsDirector() {
        return this.tGPOSPROCESS1ASESORpEsDirector;
    }
    
    public void setTGPOSPROCESS1ASESORpEsDirector(Boolean tGPOSPROCESS1ASESORpEsDirector) {
        this.tGPOSPROCESS1ASESORpEsDirector = tGPOSPROCESS1ASESORpEsDirector;
    }

    private void checkTGPOSPROCESS1ASESORpEsDirector() throws NotNullArgumentException {
        if(this.getTGPOSPROCESS1ASESORpEsDirector() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGPOSPROCESS1ASESOR, GlobalServiceConstants.GS_ARG_ID_TGPOSPROCESS1ASESOR_TGPOSPROCESS1ASESORPESDIRECTOR, GlobalServiceConstants.G_SERV_ALIAS_TGPOSPROCESS1ASESOR, GlobalServiceConstants.GS_ARG_ALIAS_TGPOSPROCESS1ASESOR_TGPOSPROCESS1ASESORPESDIRECTOR);
        }
    }

    @JsonIgnore
    public RolOid getTGPOSPROCESS1ASESORpRol() {
        return this.tGPOSPROCESS1ASESORpRol;
    }
    
    public void setTGPOSPROCESS1ASESORpRol(RolOid tGPOSPROCESS1ASESORpRol) {
        this.tGPOSPROCESS1ASESORpRol = tGPOSPROCESS1ASESORpRol;
    }

    @JsonIgnore
    public Rol getTGPOSPROCESS1ASESORpRolInstance() {
        return this.tGPOSPROCESS1ASESORpRolInstance;
    }
    
    public void setTGPOSPROCESS1ASESORpRolInstance(Rol tGPOSPROCESS1ASESORpRol) {
        this.tGPOSPROCESS1ASESORpRolInstance = tGPOSPROCESS1ASESORpRol;
        this.tGPOSPROCESS1ASESORpRol = tGPOSPROCESS1ASESORpRol != null ? tGPOSPROCESS1ASESORpRol.getOid() : null;
    }

    private void checkTGPOSPROCESS1ASESORpRol() throws NotNullArgumentException {
        if(this.getTGPOSPROCESS1ASESORpRolInstance() == null || this.getTGPOSPROCESS1ASESORpRolInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGPOSPROCESS1ASESOR, GlobalServiceConstants.GS_ARG_ID_TGPOSPROCESS1ASESOR_TGPOSPROCESS1ASESORPROL, GlobalServiceConstants.G_SERV_ALIAS_TGPOSPROCESS1ASESOR, GlobalServiceConstants.GS_ARG_ALIAS_TGPOSPROCESS1ASESOR_TGPOSPROCESS1ASESORPROL);
        }
    }
}
