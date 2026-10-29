package com.keralty.aeusuarios.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SolicitudConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.Solicitud;

public class DelUsrAfiliacionRequest {

    @JsonProperty("p_thissolicitud_oid")
    private SolicitudOid solicitudDelUsrAfiliacionpthisSolicitud;
    
    @JsonIgnore
    private Solicitud solicitudDelUsrAfiliacionpthisSolicitudInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid solicitudDelUsrAfiliacionpevcFuncionario;
    
    @JsonIgnore
    private Funcionario solicitudDelUsrAfiliacionpevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudDelUsrAfiliacionpthisSolicitud();
        checkSolicitudDelUsrAfiliacionpevcFuncionario();
    }

    @JsonIgnore
    public SolicitudOid getSolicitudDelUsrAfiliacionpthisSolicitud() {
        return this.solicitudDelUsrAfiliacionpthisSolicitud;
    }
    
    public void setSolicitudDelUsrAfiliacionpthisSolicitud(SolicitudOid solicitudDelUsrAfiliacionpthisSolicitud) {
        this.solicitudDelUsrAfiliacionpthisSolicitud = solicitudDelUsrAfiliacionpthisSolicitud;
    }

    @JsonIgnore
    public Solicitud getSolicitudDelUsrAfiliacionpthisSolicitudInstance() {
        return this.solicitudDelUsrAfiliacionpthisSolicitudInstance;
    }
    
    public void setSolicitudDelUsrAfiliacionpthisSolicitudInstance(Solicitud solicitudDelUsrAfiliacionpthisSolicitud) {
        this.solicitudDelUsrAfiliacionpthisSolicitudInstance = solicitudDelUsrAfiliacionpthisSolicitud;
        this.solicitudDelUsrAfiliacionpthisSolicitud = solicitudDelUsrAfiliacionpthisSolicitud != null ? solicitudDelUsrAfiliacionpthisSolicitud.getOid() : null;
    }

    private void checkSolicitudDelUsrAfiliacionpthisSolicitud() throws NotNullArgumentException {
        if(this.getSolicitudDelUsrAfiliacionpthisSolicitudInstance() == null || this.getSolicitudDelUsrAfiliacionpthisSolicitudInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELUSRAFILIACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELUSRAFILIACION_SOLICITUDDELUSRAFILIACIONPTHISSOLICITUD, SolicitudConstants.SERV_ALIAS_DELUSRAFILIACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELUSRAFILIACION_SOLICITUDDELUSRAFILIACIONPTHISSOLICITUD);
        }
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudDelUsrAfiliacionpevcFuncionario() {
        return this.solicitudDelUsrAfiliacionpevcFuncionario;
    }
    
    public void setSolicitudDelUsrAfiliacionpevcFuncionario(FuncionarioOid solicitudDelUsrAfiliacionpevcFuncionario) {
        this.solicitudDelUsrAfiliacionpevcFuncionario = solicitudDelUsrAfiliacionpevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getSolicitudDelUsrAfiliacionpevcFuncionarioInstance() {
        return this.solicitudDelUsrAfiliacionpevcFuncionarioInstance;
    }
    
    public void setSolicitudDelUsrAfiliacionpevcFuncionarioInstance(Funcionario solicitudDelUsrAfiliacionpevcFuncionario) {
        this.solicitudDelUsrAfiliacionpevcFuncionarioInstance = solicitudDelUsrAfiliacionpevcFuncionario;
        this.solicitudDelUsrAfiliacionpevcFuncionario = solicitudDelUsrAfiliacionpevcFuncionario != null ? solicitudDelUsrAfiliacionpevcFuncionario.getOid() : null;
    }

    private void checkSolicitudDelUsrAfiliacionpevcFuncionario() throws NotNullArgumentException {
        if(this.getSolicitudDelUsrAfiliacionpevcFuncionarioInstance() == null || this.getSolicitudDelUsrAfiliacionpevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudConstants.SERV_ID_DELUSRAFILIACION, SolicitudConstants.CLASS_ID, SolicitudConstants.ARG_ID_DELUSRAFILIACION_SOLICITUDDELUSRAFILIACIONPEVCFUNCIONARIO, SolicitudConstants.SERV_ALIAS_DELUSRAFILIACION, SolicitudConstants.CLASS_ALIAS, SolicitudConstants.ARG_ALIAS_DELUSRAFILIACION_SOLICITUDDELUSRAFILIACIONPEVCFUNCIONARIO);
        }
    }
}
