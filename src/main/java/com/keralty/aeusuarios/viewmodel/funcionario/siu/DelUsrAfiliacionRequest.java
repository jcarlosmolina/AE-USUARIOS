package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Solicitud;

public class DelUsrAfiliacionRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioDelUsrAfiliacionpthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioDelUsrAfiliacionpthisFuncionarioInstance;

    @JsonProperty("p_evcsolicitud_oid")
    private SolicitudOid funcionarioDelUsrAfiliacionpevcSolicitud;
    
    @JsonIgnore
    private Solicitud funcionarioDelUsrAfiliacionpevcSolicitudInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioDelUsrAfiliacionpthisFuncionario();
        checkFuncionarioDelUsrAfiliacionpevcSolicitud();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioDelUsrAfiliacionpthisFuncionario() {
        return this.funcionarioDelUsrAfiliacionpthisFuncionario;
    }
    
    public void setFuncionarioDelUsrAfiliacionpthisFuncionario(FuncionarioOid funcionarioDelUsrAfiliacionpthisFuncionario) {
        this.funcionarioDelUsrAfiliacionpthisFuncionario = funcionarioDelUsrAfiliacionpthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioDelUsrAfiliacionpthisFuncionarioInstance() {
        return this.funcionarioDelUsrAfiliacionpthisFuncionarioInstance;
    }
    
    public void setFuncionarioDelUsrAfiliacionpthisFuncionarioInstance(Funcionario funcionarioDelUsrAfiliacionpthisFuncionario) {
        this.funcionarioDelUsrAfiliacionpthisFuncionarioInstance = funcionarioDelUsrAfiliacionpthisFuncionario;
        this.funcionarioDelUsrAfiliacionpthisFuncionario = funcionarioDelUsrAfiliacionpthisFuncionario != null ? funcionarioDelUsrAfiliacionpthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioDelUsrAfiliacionpthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioDelUsrAfiliacionpthisFuncionarioInstance() == null || this.getFuncionarioDelUsrAfiliacionpthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELUSRAFILIACION, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELUSRAFILIACION_FUNCIONARIODELUSRAFILIACIONPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_DELUSRAFILIACION, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELUSRAFILIACION_FUNCIONARIODELUSRAFILIACIONPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public SolicitudOid getFuncionarioDelUsrAfiliacionpevcSolicitud() {
        return this.funcionarioDelUsrAfiliacionpevcSolicitud;
    }
    
    public void setFuncionarioDelUsrAfiliacionpevcSolicitud(SolicitudOid funcionarioDelUsrAfiliacionpevcSolicitud) {
        this.funcionarioDelUsrAfiliacionpevcSolicitud = funcionarioDelUsrAfiliacionpevcSolicitud;
    }

    @JsonIgnore
    public Solicitud getFuncionarioDelUsrAfiliacionpevcSolicitudInstance() {
        return this.funcionarioDelUsrAfiliacionpevcSolicitudInstance;
    }
    
    public void setFuncionarioDelUsrAfiliacionpevcSolicitudInstance(Solicitud funcionarioDelUsrAfiliacionpevcSolicitud) {
        this.funcionarioDelUsrAfiliacionpevcSolicitudInstance = funcionarioDelUsrAfiliacionpevcSolicitud;
        this.funcionarioDelUsrAfiliacionpevcSolicitud = funcionarioDelUsrAfiliacionpevcSolicitud != null ? funcionarioDelUsrAfiliacionpevcSolicitud.getOid() : null;
    }

    private void checkFuncionarioDelUsrAfiliacionpevcSolicitud() throws NotNullArgumentException {
        if(this.getFuncionarioDelUsrAfiliacionpevcSolicitudInstance() == null || this.getFuncionarioDelUsrAfiliacionpevcSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELUSRAFILIACION, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELUSRAFILIACION_FUNCIONARIODELUSRAFILIACIONPEVCSOLICITUD, FuncionarioConstants.SERV_ALIAS_DELUSRAFILIACION, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELUSRAFILIACION_FUNCIONARIODELUSRAFILIACIONPEVCSOLICITUD);
        }
    }
}
