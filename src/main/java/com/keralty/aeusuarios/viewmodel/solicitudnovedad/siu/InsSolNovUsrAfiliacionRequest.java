package com.keralty.aeusuarios.viewmodel.solicitudnovedad.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.SolicitudNovedadConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;

public class InsSolNovUsrAfiliacionRequest {

    @JsonProperty("p_thissolicitudnovedad_oid")
    private SolicitudNovedadOid solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario;
    
    @JsonIgnore
    private Funcionario solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad();
        checkSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario();
    }

    @JsonIgnore
    public SolicitudNovedadOid getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad() {
        return this.solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad;
    }
    
    public void setSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad(SolicitudNovedadOid solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad) {
        this.solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad = solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance() {
        return this.solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance;
    }
    
    public void setSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance(SolicitudNovedad solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad) {
        this.solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance = solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad;
        this.solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad = solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad != null ? solicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad.getOid() : null;
    }

    private void checkSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedad() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance() == null || this.getSolicitudNovedadInsSolNovUsrAfiliacionpthisSolicitudNovedadInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSSOLNOVUSRAFILIACION_SOLICITUDNOVEDADINSSOLNOVUSRAFILIACIONPTHISSOLICITUDNOVEDAD, SolicitudNovedadConstants.SERV_ALIAS_INSSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSSOLNOVUSRAFILIACION_SOLICITUDNOVEDADINSSOLNOVUSRAFILIACIONPTHISSOLICITUDNOVEDAD);
        }
    }

    @JsonIgnore
    public FuncionarioOid getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario() {
        return this.solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario;
    }
    
    public void setSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario(FuncionarioOid solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario) {
        this.solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario = solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance() {
        return this.solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance;
    }
    
    public void setSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance(Funcionario solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario) {
        this.solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance = solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario;
        this.solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario = solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario != null ? solicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario.getOid() : null;
    }

    private void checkSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionario() throws NotNullArgumentException {
        if(this.getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance() == null || this.getSolicitudNovedadInsSolNovUsrAfiliacionpevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(SolicitudNovedadConstants.SERV_ID_INSSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ID, SolicitudNovedadConstants.ARG_ID_INSSOLNOVUSRAFILIACION_SOLICITUDNOVEDADINSSOLNOVUSRAFILIACIONPEVCFUNCIONARIO, SolicitudNovedadConstants.SERV_ALIAS_INSSOLNOVUSRAFILIACION, SolicitudNovedadConstants.CLASS_ALIAS, SolicitudNovedadConstants.ARG_ALIAS_INSSOLNOVUSRAFILIACION_SOLICITUDNOVEDADINSSOLNOVUSRAFILIACIONPEVCFUNCIONARIO);
        }
    }
}
