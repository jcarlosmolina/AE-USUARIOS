package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;

public class InsSolNovUsrAfiliacionRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioInsSolNovUsrAfiliacionpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioInsSolNovUsrAfiliacionpthisFuncionario();
        checkFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioInsSolNovUsrAfiliacionpthisFuncionario() {
        return this.funcionarioInsSolNovUsrAfiliacionpthisFuncionario;
    }
    
    public void setFuncionarioInsSolNovUsrAfiliacionpthisFuncionario(FuncionarioOid funcionarioInsSolNovUsrAfiliacionpthisFuncionario) {
        this.funcionarioInsSolNovUsrAfiliacionpthisFuncionario = funcionarioInsSolNovUsrAfiliacionpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance() {
        return this.funcionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance;
    }
    
    public void setFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance(Funcionario funcionarioInsSolNovUsrAfiliacionpthisFuncionario) {
        this.funcionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance = funcionarioInsSolNovUsrAfiliacionpthisFuncionario;
        this.funcionarioInsSolNovUsrAfiliacionpthisFuncionario = funcionarioInsSolNovUsrAfiliacionpthisFuncionario != null ? funcionarioInsSolNovUsrAfiliacionpthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioInsSolNovUsrAfiliacionpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance() == null || this.getFuncionarioInsSolNovUsrAfiliacionpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_INSSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_INSSOLNOVUSRAFILIACION_FUNCIONARIOINSSOLNOVUSRAFILIACIONPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_INSSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_INSSOLNOVUSRAFILIACION_FUNCIONARIOINSSOLNOVUSRAFILIACIONPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad() {
        return this.funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad;
    }
    
    public void setFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad(SolicitudNovedadOid funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad) {
        this.funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad = funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance() {
        return this.funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance;
    }
    
    public void setFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance(SolicitudNovedad funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad) {
        this.funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance = funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad;
        this.funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad = funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad != null ? funcionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad.getOid() : null;
    }

    private void checkFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance() == null || this.getFuncionarioInsSolNovUsrAfiliacionpevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_INSSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_INSSOLNOVUSRAFILIACION_FUNCIONARIOINSSOLNOVUSRAFILIACIONPEVCSOLICITUDNOVEDAD, FuncionarioConstants.SERV_ALIAS_INSSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_INSSOLNOVUSRAFILIACION_FUNCIONARIOINSSOLNOVUSRAFILIACIONPEVCSOLICITUDNOVEDAD);
        }
    }
}
