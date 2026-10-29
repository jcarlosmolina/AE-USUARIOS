package com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;

public class DelSolNovUsrAfiliacionRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario;
    
    @JsonIgnore
    private Funcionario solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad();
        checkSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad() {
        return this.solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad) {
        this.solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad = solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad) {
        this.solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance = solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad;
        this.solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad = solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad != null ? solicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadDelSolNovUsrAfiliacionpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELSOLNOVUSRAFILIACION_SOLICITUDNOVEDADDELSOLNOVUSRAFILIACIONPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_DELSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELSOLNOVUSRAFILIACION_SOLICITUDNOVEDADDELSOLNOVUSRAFILIACIONPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario() {
        return this.solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario;
    }
    
    public void setSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario(FuncionarioOid solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario) {
        this.solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario = solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance() {
        return this.solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance;
    }
    
    public void setSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance(Funcionario solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario) {
        this.solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance = solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario;
        this.solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario = solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario != null ? solicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario.getOid() : null;
    }

    private void checkSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionario() throws NotNullArgumentException {
        if(this.getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance() == null || this.getSolicitudNovedadDelSolNovUsrAfiliacionpevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_DELSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_DELSOLNOVUSRAFILIACION_SOLICITUDNOVEDADDELSOLNOVUSRAFILIACIONPEVCFUNCIONARIO, SolicitudNovedadConstants.SERV_ALIAS_DELSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_DELSOLNOVUSRAFILIACION_SOLICITUDNOVEDADDELSOLNOVUSRAFILIACIONPEVCFUNCIONARIO);
        }
    }
}
