package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class TGMODASESORAGENCIARequest {

    @JsonProperty("pt_p_thisasesor_oid")
    private AsesorOid tGMODASESORAGENCIAptpthisAsesor;
    
    @JsonIgnore
    private Asesor tGMODASESORAGENCIAptpthisAsesorInstance;

    @JsonProperty("pt_p_moddbasicospersona")
    private Boolean tGMODASESORAGENCIAptpModDBasicosPersona;

    @JsonProperty("pt_pmodificadirector")
    private Boolean tGMODASESORAGENCIAptpModificaDirector;

    @JsonProperty("pt_ptusuarioldap")
    private String tGMODASESORAGENCIAptptUsuarioLDAP;

    @JsonProperty("pt_ptemail")
    private String tGMODASESORAGENCIAptptEmail;

    @JsonProperty("pt_p_primernombre")
    private String tGMODASESORAGENCIAptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String tGMODASESORAGENCIAptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String tGMODASESORAGENCIAptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String tGMODASESORAGENCIAptpSegundoApellido;

    @JsonProperty("pt_penumusuario")
    private String tGMODASESORAGENCIAptpeNumUsuario;

    @JsonProperty("pt_ptsucursal_oid")
    private SucursalOid tGMODASESORAGENCIAptptSucursal;
    
    @JsonIgnore
    private Sucursal tGMODASESORAGENCIAptptSucursalInstance;

    @JsonProperty("pt_pttipoidentificacion_json")
    private String tGMODASESORAGENCIAptptTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion tGMODASESORAGENCIAptptTipoIdentificacionInstance;

    @JsonProperty("pt_ptnumidentificacion")
    private String tGMODASESORAGENCIAptptNumIdentificacion;

    @JsonProperty("pt_pverdbasicospersona")
    private Boolean tGMODASESORAGENCIAptpVerDBasicosPersona;

    @JsonProperty("pt_pverdocspersona")
    private Boolean tGMODASESORAGENCIAptpVerDocsPersona;

    @JsonProperty("pt_pvercontratonovedad")
    private Boolean tGMODASESORAGENCIAptpVerContratoNovedad;

    @JsonProperty("preconditionId")
    private String preconditionId;

    public void checkArguments() throws NotNullArgumentException {
        checkTGMODASESORAGENCIAptpthisAsesor();
        checkTGMODASESORAGENCIAptpModDBasicosPersona();
        checkTGMODASESORAGENCIAptpModificaDirector();
        checkTGMODASESORAGENCIAptpPrimerNombre();
        checkTGMODASESORAGENCIAptpeNumUsuario();
        checkTGMODASESORAGENCIAptptSucursal();
        checkTGMODASESORAGENCIAptptTipoIdentificacion();
        checkTGMODASESORAGENCIAptptNumIdentificacion();
        checkTGMODASESORAGENCIAptpVerDBasicosPersona();
        checkTGMODASESORAGENCIAptpVerDocsPersona();
        checkTGMODASESORAGENCIAptpVerContratoNovedad();
    }

    @JsonIgnore
    public AsesorOid getTGMODASESORAGENCIAptpthisAsesor() {
        return this.tGMODASESORAGENCIAptpthisAsesor;
    }
    
    public void setTGMODASESORAGENCIAptpthisAsesor(AsesorOid tGMODASESORAGENCIAptpthisAsesor) {
        this.tGMODASESORAGENCIAptpthisAsesor = tGMODASESORAGENCIAptpthisAsesor;
    }

    @JsonIgnore
    public Asesor getTGMODASESORAGENCIAptpthisAsesorInstance() {
        return this.tGMODASESORAGENCIAptpthisAsesorInstance;
    }
    
    public void setTGMODASESORAGENCIAptpthisAsesorInstance(Asesor tGMODASESORAGENCIAptpthisAsesor) {
        this.tGMODASESORAGENCIAptpthisAsesorInstance = tGMODASESORAGENCIAptpthisAsesor;
        this.tGMODASESORAGENCIAptpthisAsesor = tGMODASESORAGENCIAptpthisAsesor != null ? tGMODASESORAGENCIAptpthisAsesor.getOid() : null;
    }

    private void checkTGMODASESORAGENCIAptpthisAsesor() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpthisAsesorInstance() == null || this.getTGMODASESORAGENCIAptpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTHISASESOR, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getTGMODASESORAGENCIAptpModDBasicosPersona() {
        return this.tGMODASESORAGENCIAptpModDBasicosPersona;
    }
    
    public void setTGMODASESORAGENCIAptpModDBasicosPersona(Boolean tGMODASESORAGENCIAptpModDBasicosPersona) {
        this.tGMODASESORAGENCIAptpModDBasicosPersona = tGMODASESORAGENCIAptpModDBasicosPersona;
    }

    private void checkTGMODASESORAGENCIAptpModDBasicosPersona() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpModDBasicosPersona() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPMODDBASICOSPERSONA, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPMODDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getTGMODASESORAGENCIAptpModificaDirector() {
        return this.tGMODASESORAGENCIAptpModificaDirector;
    }
    
    public void setTGMODASESORAGENCIAptpModificaDirector(Boolean tGMODASESORAGENCIAptpModificaDirector) {
        this.tGMODASESORAGENCIAptpModificaDirector = tGMODASESORAGENCIAptpModificaDirector;
    }

    private void checkTGMODASESORAGENCIAptpModificaDirector() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpModificaDirector() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPMODIFICADIRECTOR, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPMODIFICADIRECTOR);
        }
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptptUsuarioLDAP() {
        return this.tGMODASESORAGENCIAptptUsuarioLDAP;
    }
    
    public void setTGMODASESORAGENCIAptptUsuarioLDAP(String tGMODASESORAGENCIAptptUsuarioLDAP) {
        this.tGMODASESORAGENCIAptptUsuarioLDAP = tGMODASESORAGENCIAptptUsuarioLDAP;
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptptEmail() {
        return this.tGMODASESORAGENCIAptptEmail;
    }
    
    public void setTGMODASESORAGENCIAptptEmail(String tGMODASESORAGENCIAptptEmail) {
        this.tGMODASESORAGENCIAptptEmail = tGMODASESORAGENCIAptptEmail;
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptpPrimerNombre() {
        return this.tGMODASESORAGENCIAptpPrimerNombre;
    }
    
    public void setTGMODASESORAGENCIAptpPrimerNombre(String tGMODASESORAGENCIAptpPrimerNombre) {
        this.tGMODASESORAGENCIAptpPrimerNombre = tGMODASESORAGENCIAptpPrimerNombre;
    }

    private void checkTGMODASESORAGENCIAptpPrimerNombre() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpPrimerNombre() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPPRIMERNOMBRE, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptpSegundoNombre() {
        return this.tGMODASESORAGENCIAptpSegundoNombre;
    }
    
    public void setTGMODASESORAGENCIAptpSegundoNombre(String tGMODASESORAGENCIAptpSegundoNombre) {
        this.tGMODASESORAGENCIAptpSegundoNombre = tGMODASESORAGENCIAptpSegundoNombre;
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptpPrimerApellido() {
        return this.tGMODASESORAGENCIAptpPrimerApellido;
    }
    
    public void setTGMODASESORAGENCIAptpPrimerApellido(String tGMODASESORAGENCIAptpPrimerApellido) {
        this.tGMODASESORAGENCIAptpPrimerApellido = tGMODASESORAGENCIAptpPrimerApellido;
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptpSegundoApellido() {
        return this.tGMODASESORAGENCIAptpSegundoApellido;
    }
    
    public void setTGMODASESORAGENCIAptpSegundoApellido(String tGMODASESORAGENCIAptpSegundoApellido) {
        this.tGMODASESORAGENCIAptpSegundoApellido = tGMODASESORAGENCIAptpSegundoApellido;
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptpeNumUsuario() {
        return this.tGMODASESORAGENCIAptpeNumUsuario;
    }
    
    public void setTGMODASESORAGENCIAptpeNumUsuario(String tGMODASESORAGENCIAptpeNumUsuario) {
        this.tGMODASESORAGENCIAptpeNumUsuario = tGMODASESORAGENCIAptpeNumUsuario;
    }

    private void checkTGMODASESORAGENCIAptpeNumUsuario() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpeNumUsuario() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPENUMUSUARIO, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPENUMUSUARIO);
        }
    }

    @JsonIgnore
    public SucursalOid getTGMODASESORAGENCIAptptSucursal() {
        return this.tGMODASESORAGENCIAptptSucursal;
    }
    
    public void setTGMODASESORAGENCIAptptSucursal(SucursalOid tGMODASESORAGENCIAptptSucursal) {
        this.tGMODASESORAGENCIAptptSucursal = tGMODASESORAGENCIAptptSucursal;
    }

    @JsonIgnore
    public Sucursal getTGMODASESORAGENCIAptptSucursalInstance() {
        return this.tGMODASESORAGENCIAptptSucursalInstance;
    }
    
    public void setTGMODASESORAGENCIAptptSucursalInstance(Sucursal tGMODASESORAGENCIAptptSucursal) {
        this.tGMODASESORAGENCIAptptSucursalInstance = tGMODASESORAGENCIAptptSucursal;
        this.tGMODASESORAGENCIAptptSucursal = tGMODASESORAGENCIAptptSucursal != null ? tGMODASESORAGENCIAptptSucursal.getOid() : null;
    }

    private void checkTGMODASESORAGENCIAptptSucursal() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptptSucursalInstance() == null || this.getTGMODASESORAGENCIAptptSucursalInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTSUCURSAL, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTSUCURSAL);
        }
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptptTipoIdentificacion() {
        return this.tGMODASESORAGENCIAptptTipoIdentificacion;
    }
    
    public void setTGMODASESORAGENCIAptptTipoIdentificacion(String tGMODASESORAGENCIAptptTipoIdentificacion) {
        this.tGMODASESORAGENCIAptptTipoIdentificacion = tGMODASESORAGENCIAptptTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getTGMODASESORAGENCIAptptTipoIdentificacionInstance() {
        return this.tGMODASESORAGENCIAptptTipoIdentificacionInstance;
    }
    
    public void setTGMODASESORAGENCIAptptTipoIdentificacionInstance(TipoIdentificacion tGMODASESORAGENCIAptptTipoIdentificacion) {
        this.tGMODASESORAGENCIAptptTipoIdentificacionInstance = tGMODASESORAGENCIAptptTipoIdentificacion;
        this.tGMODASESORAGENCIAptptTipoIdentificacion = tGMODASESORAGENCIAptptTipoIdentificacion != null ? tGMODASESORAGENCIAptptTipoIdentificacion.getOid().toJson() : "";
    }

    private void checkTGMODASESORAGENCIAptptTipoIdentificacion() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptptTipoIdentificacionInstance() == null || this.getTGMODASESORAGENCIAptptTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTTIPOIDENTIFICACION, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getTGMODASESORAGENCIAptptNumIdentificacion() {
        return this.tGMODASESORAGENCIAptptNumIdentificacion;
    }
    
    public void setTGMODASESORAGENCIAptptNumIdentificacion(String tGMODASESORAGENCIAptptNumIdentificacion) {
        this.tGMODASESORAGENCIAptptNumIdentificacion = tGMODASESORAGENCIAptptNumIdentificacion;
    }

    private void checkTGMODASESORAGENCIAptptNumIdentificacion() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptptNumIdentificacion() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTNUMIDENTIFICACION, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPTNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public Boolean getTGMODASESORAGENCIAptpVerDBasicosPersona() {
        return this.tGMODASESORAGENCIAptpVerDBasicosPersona;
    }
    
    public void setTGMODASESORAGENCIAptpVerDBasicosPersona(Boolean tGMODASESORAGENCIAptpVerDBasicosPersona) {
        this.tGMODASESORAGENCIAptpVerDBasicosPersona = tGMODASESORAGENCIAptpVerDBasicosPersona;
    }

    private void checkTGMODASESORAGENCIAptpVerDBasicosPersona() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpVerDBasicosPersona() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPVERDBASICOSPERSONA, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPVERDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getTGMODASESORAGENCIAptpVerDocsPersona() {
        return this.tGMODASESORAGENCIAptpVerDocsPersona;
    }
    
    public void setTGMODASESORAGENCIAptpVerDocsPersona(Boolean tGMODASESORAGENCIAptpVerDocsPersona) {
        this.tGMODASESORAGENCIAptpVerDocsPersona = tGMODASESORAGENCIAptpVerDocsPersona;
    }

    private void checkTGMODASESORAGENCIAptpVerDocsPersona() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpVerDocsPersona() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPVERDOCSPERSONA, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getTGMODASESORAGENCIAptpVerContratoNovedad() {
        return this.tGMODASESORAGENCIAptpVerContratoNovedad;
    }
    
    public void setTGMODASESORAGENCIAptpVerContratoNovedad(Boolean tGMODASESORAGENCIAptpVerContratoNovedad) {
        this.tGMODASESORAGENCIAptpVerContratoNovedad = tGMODASESORAGENCIAptpVerContratoNovedad;
    }

    private void checkTGMODASESORAGENCIAptpVerContratoNovedad() throws NotNullArgumentException {
        if(this.getTGMODASESORAGENCIAptpVerContratoNovedad() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ID_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPVERCONTRATONOVEDAD, GlobalServiceConstants.G_SERV_ALIAS_TGMODASESORAGENCIA, GlobalServiceConstants.GS_ARG_ALIAS_TGMODASESORAGENCIA_TGMODASESORAGENCIAPTPVERCONTRATONOVEDAD);
        }
    }

    @JsonIgnore
    public String getPreconditionId() {
        return this.preconditionId;
    }
    
    public void setPreconditionId(String preconditionId) {
        this.preconditionId = preconditionId;
    }
}
