package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;

public class DelSolNovUsrAfiliacionRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioDelSolNovUsrAfiliacionpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance;

    @JsonProperty("p_evcsolicitudnovedad_oid")
    private SolicitudNovedadOid funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioDelSolNovUsrAfiliacionpthisFuncionario();
        checkFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioDelSolNovUsrAfiliacionpthisFuncionario() {
        return this.funcionarioDelSolNovUsrAfiliacionpthisFuncionario;
    }
    
    public void setFuncionarioDelSolNovUsrAfiliacionpthisFuncionario(FuncionarioOid funcionarioDelSolNovUsrAfiliacionpthisFuncionario) {
        this.funcionarioDelSolNovUsrAfiliacionpthisFuncionario = funcionarioDelSolNovUsrAfiliacionpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance() {
        return this.funcionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance;
    }
    
    public void setFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance(Funcionario funcionarioDelSolNovUsrAfiliacionpthisFuncionario) {
        this.funcionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance = funcionarioDelSolNovUsrAfiliacionpthisFuncionario;
        this.funcionarioDelSolNovUsrAfiliacionpthisFuncionario = funcionarioDelSolNovUsrAfiliacionpthisFuncionario != null ? funcionarioDelSolNovUsrAfiliacionpthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioDelSolNovUsrAfiliacionpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance() == null || this.getFuncionarioDelSolNovUsrAfiliacionpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELSOLNOVUSRAFILIACION_FUNCIONARIODELSOLNOVUSRAFILIACIONPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_DELSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELSOLNOVUSRAFILIACION_FUNCIONARIODELSOLNOVUSRAFILIACIONPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public SolicitudNovedadOid getFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad() {
        return this.funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad;
    }
    
    public void setFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad(SolicitudNovedadOid funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad) {
        this.funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad = funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance() {
        return this.funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance;
    }
    
    public void setFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance(SolicitudNovedad funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad) {
        this.funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance = funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad;
        this.funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad = funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad != null ? funcionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad.getOid() : null;
    }

    private void checkFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedad() throws NotNullArgumentException {
        if(this.getFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance() == null || this.getFuncionarioDelSolNovUsrAfiliacionpevcSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELSOLNOVUSRAFILIACION_FUNCIONARIODELSOLNOVUSRAFILIACIONPEVCSOLICITUDNOVEDAD, FuncionarioConstants.SERV_ALIAS_DELSOLNOVUSRAFILIACION, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELSOLNOVUSRAFILIACION_FUNCIONARIODELSOLNOVUSRAFILIACIONPEVCSOLICITUDNOVEDAD);
        }
    }
}
