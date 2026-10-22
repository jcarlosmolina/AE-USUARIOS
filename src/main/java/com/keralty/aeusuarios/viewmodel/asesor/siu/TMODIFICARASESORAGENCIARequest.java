package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.SucursalOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class TMODIFICARASESORAGENCIARequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTMODIFICARASESORAGENCIApthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTMODIFICARASESORAGENCIApthisAsesorInstance;

    @JsonProperty("pt_p_moddbasicospersona")
    private Boolean asesorTMODIFICARASESORAGENCIAptpModDBasicosPersona;

    @JsonProperty("pmodificadirector")
    private Boolean asesorTMODIFICARASESORAGENCIApModificaDirector;

    @JsonProperty("ptusuarioldap")
    private String asesorTMODIFICARASESORAGENCIAptUsuarioLDAP;

    @JsonProperty("ptemail")
    private String asesorTMODIFICARASESORAGENCIAptEmail;

    @JsonProperty("pt_p_primernombre")
    private String asesorTMODIFICARASESORAGENCIAptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String asesorTMODIFICARASESORAGENCIAptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String asesorTMODIFICARASESORAGENCIAptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String asesorTMODIFICARASESORAGENCIAptpSegundoApellido;

    @JsonProperty("pt_penumusuario")
    private String asesorTMODIFICARASESORAGENCIAptpeNumUsuario;

    @JsonProperty("pt_p_esdirector")
    private Boolean asesorTMODIFICARASESORAGENCIAptpEsDirector;

    @JsonProperty("pt_pecodjefe")
    private String asesorTMODIFICARASESORAGENCIAptpeCodJefe;

    @JsonProperty("ptsucursal_oid")
    private SucursalOid asesorTMODIFICARASESORAGENCIAptSucursal;
    
    @JsonIgnore
    private Sucursal asesorTMODIFICARASESORAGENCIAptSucursalInstance;

    @JsonProperty("pttipoidentificacion_oid")
    private TipoIdentificacionOid asesorTMODIFICARASESORAGENCIAptTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion asesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance;

    @JsonProperty("ptnumidentificacion")
    private String asesorTMODIFICARASESORAGENCIAptNumIdentificacion;

    @JsonProperty("pt_pverdbasicospersona")
    private Boolean asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona;

    @JsonProperty("pt_pverdocspersona")
    private Boolean asesorTMODIFICARASESORAGENCIAptpVerDocsPersona;

    @JsonProperty("pt_pvercontratonovedad")
    private Boolean asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTMODIFICARASESORAGENCIApthisAsesor();
        checkAsesorTMODIFICARASESORAGENCIAptpModDBasicosPersona();
        checkAsesorTMODIFICARASESORAGENCIApModificaDirector();
        checkAsesorTMODIFICARASESORAGENCIAptpPrimerNombre();
        checkAsesorTMODIFICARASESORAGENCIAptpeNumUsuario();
        checkAsesorTMODIFICARASESORAGENCIAptpEsDirector();
        checkAsesorTMODIFICARASESORAGENCIAptSucursal();
        checkAsesorTMODIFICARASESORAGENCIAptTipoIdentificacion();
        checkAsesorTMODIFICARASESORAGENCIAptNumIdentificacion();
        checkAsesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona();
        checkAsesorTMODIFICARASESORAGENCIAptpVerDocsPersona();
        checkAsesorTMODIFICARASESORAGENCIAptpVerContratoNovedad();
    }

    @JsonIgnore
    public AsesorOid getAsesorTMODIFICARASESORAGENCIApthisAsesor() {
        return this.asesorTMODIFICARASESORAGENCIApthisAsesor;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIApthisAsesor(AsesorOid asesorTMODIFICARASESORAGENCIApthisAsesor) {
        this.asesorTMODIFICARASESORAGENCIApthisAsesor = asesorTMODIFICARASESORAGENCIApthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTMODIFICARASESORAGENCIApthisAsesorInstance() {
        return this.asesorTMODIFICARASESORAGENCIApthisAsesorInstance;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIApthisAsesorInstance(Asesor asesorTMODIFICARASESORAGENCIApthisAsesor) {
        this.asesorTMODIFICARASESORAGENCIApthisAsesorInstance = asesorTMODIFICARASESORAGENCIApthisAsesor;
        this.asesorTMODIFICARASESORAGENCIApthisAsesor = asesorTMODIFICARASESORAGENCIApthisAsesor != null ? asesorTMODIFICARASESORAGENCIApthisAsesor.getOid() : null;
    }

    private void checkAsesorTMODIFICARASESORAGENCIApthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIApthisAsesorInstance() == null || this.getAsesorTMODIFICARASESORAGENCIApthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTHISASESOR, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTHISASESOR);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORAGENCIAptpModDBasicosPersona() {
        return this.asesorTMODIFICARASESORAGENCIAptpModDBasicosPersona;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpModDBasicosPersona(Boolean asesorTMODIFICARASESORAGENCIAptpModDBasicosPersona) {
        this.asesorTMODIFICARASESORAGENCIAptpModDBasicosPersona = asesorTMODIFICARASESORAGENCIAptpModDBasicosPersona;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptpModDBasicosPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptpModDBasicosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPMODDBASICOSPERSONA, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPMODDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORAGENCIApModificaDirector() {
        return this.asesorTMODIFICARASESORAGENCIApModificaDirector;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIApModificaDirector(Boolean asesorTMODIFICARASESORAGENCIApModificaDirector) {
        this.asesorTMODIFICARASESORAGENCIApModificaDirector = asesorTMODIFICARASESORAGENCIApModificaDirector;
    }

    private void checkAsesorTMODIFICARASESORAGENCIApModificaDirector() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIApModificaDirector() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPMODIFICADIRECTOR, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPMODIFICADIRECTOR);
        }
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptUsuarioLDAP() {
        return this.asesorTMODIFICARASESORAGENCIAptUsuarioLDAP;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptUsuarioLDAP(String asesorTMODIFICARASESORAGENCIAptUsuarioLDAP) {
        this.asesorTMODIFICARASESORAGENCIAptUsuarioLDAP = asesorTMODIFICARASESORAGENCIAptUsuarioLDAP;
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptEmail() {
        return this.asesorTMODIFICARASESORAGENCIAptEmail;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptEmail(String asesorTMODIFICARASESORAGENCIAptEmail) {
        this.asesorTMODIFICARASESORAGENCIAptEmail = asesorTMODIFICARASESORAGENCIAptEmail;
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptpPrimerNombre() {
        return this.asesorTMODIFICARASESORAGENCIAptpPrimerNombre;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpPrimerNombre(String asesorTMODIFICARASESORAGENCIAptpPrimerNombre) {
        this.asesorTMODIFICARASESORAGENCIAptpPrimerNombre = asesorTMODIFICARASESORAGENCIAptpPrimerNombre;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptpPrimerNombre() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptpPrimerNombre() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPPRIMERNOMBRE, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptpSegundoNombre() {
        return this.asesorTMODIFICARASESORAGENCIAptpSegundoNombre;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpSegundoNombre(String asesorTMODIFICARASESORAGENCIAptpSegundoNombre) {
        this.asesorTMODIFICARASESORAGENCIAptpSegundoNombre = asesorTMODIFICARASESORAGENCIAptpSegundoNombre;
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptpPrimerApellido() {
        return this.asesorTMODIFICARASESORAGENCIAptpPrimerApellido;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpPrimerApellido(String asesorTMODIFICARASESORAGENCIAptpPrimerApellido) {
        this.asesorTMODIFICARASESORAGENCIAptpPrimerApellido = asesorTMODIFICARASESORAGENCIAptpPrimerApellido;
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptpSegundoApellido() {
        return this.asesorTMODIFICARASESORAGENCIAptpSegundoApellido;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpSegundoApellido(String asesorTMODIFICARASESORAGENCIAptpSegundoApellido) {
        this.asesorTMODIFICARASESORAGENCIAptpSegundoApellido = asesorTMODIFICARASESORAGENCIAptpSegundoApellido;
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptpeNumUsuario() {
        return this.asesorTMODIFICARASESORAGENCIAptpeNumUsuario;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpeNumUsuario(String asesorTMODIFICARASESORAGENCIAptpeNumUsuario) {
        this.asesorTMODIFICARASESORAGENCIAptpeNumUsuario = asesorTMODIFICARASESORAGENCIAptpeNumUsuario;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptpeNumUsuario() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptpeNumUsuario() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPENUMUSUARIO, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPENUMUSUARIO);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORAGENCIAptpEsDirector() {
        return this.asesorTMODIFICARASESORAGENCIAptpEsDirector;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpEsDirector(Boolean asesorTMODIFICARASESORAGENCIAptpEsDirector) {
        this.asesorTMODIFICARASESORAGENCIAptpEsDirector = asesorTMODIFICARASESORAGENCIAptpEsDirector;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptpEsDirector() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptpEsDirector() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPESDIRECTOR, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPESDIRECTOR);
        }
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptpeCodJefe() {
        return this.asesorTMODIFICARASESORAGENCIAptpeCodJefe;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpeCodJefe(String asesorTMODIFICARASESORAGENCIAptpeCodJefe) {
        this.asesorTMODIFICARASESORAGENCIAptpeCodJefe = asesorTMODIFICARASESORAGENCIAptpeCodJefe;
    }

    @JsonIgnore
    public SucursalOid getAsesorTMODIFICARASESORAGENCIAptSucursal() {
        return this.asesorTMODIFICARASESORAGENCIAptSucursal;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptSucursal(SucursalOid asesorTMODIFICARASESORAGENCIAptSucursal) {
        this.asesorTMODIFICARASESORAGENCIAptSucursal = asesorTMODIFICARASESORAGENCIAptSucursal;
    }

    @JsonIgnore
    public Sucursal getAsesorTMODIFICARASESORAGENCIAptSucursalInstance() {
        return this.asesorTMODIFICARASESORAGENCIAptSucursalInstance;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptSucursalInstance(Sucursal asesorTMODIFICARASESORAGENCIAptSucursal) {
        this.asesorTMODIFICARASESORAGENCIAptSucursalInstance = asesorTMODIFICARASESORAGENCIAptSucursal;
        this.asesorTMODIFICARASESORAGENCIAptSucursal = asesorTMODIFICARASESORAGENCIAptSucursal != null ? asesorTMODIFICARASESORAGENCIAptSucursal.getOid() : null;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptSucursal() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptSucursalInstance() == null || this.getAsesorTMODIFICARASESORAGENCIAptSucursalInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTSUCURSAL, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTSUCURSAL);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getAsesorTMODIFICARASESORAGENCIAptTipoIdentificacion() {
        return this.asesorTMODIFICARASESORAGENCIAptTipoIdentificacion;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptTipoIdentificacion(TipoIdentificacionOid asesorTMODIFICARASESORAGENCIAptTipoIdentificacion) {
        this.asesorTMODIFICARASESORAGENCIAptTipoIdentificacion = asesorTMODIFICARASESORAGENCIAptTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getAsesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance() {
        return this.asesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance(TipoIdentificacion asesorTMODIFICARASESORAGENCIAptTipoIdentificacion) {
        this.asesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance = asesorTMODIFICARASESORAGENCIAptTipoIdentificacion;
        this.asesorTMODIFICARASESORAGENCIAptTipoIdentificacion = asesorTMODIFICARASESORAGENCIAptTipoIdentificacion != null ? asesorTMODIFICARASESORAGENCIAptTipoIdentificacion.getOid() : null;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptTipoIdentificacion() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance() == null || this.getAsesorTMODIFICARASESORAGENCIAptTipoIdentificacionInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTTIPOIDENTIFICACION, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTTIPOIDENTIFICACION);
        }
    }

    @JsonIgnore
    public String getAsesorTMODIFICARASESORAGENCIAptNumIdentificacion() {
        return this.asesorTMODIFICARASESORAGENCIAptNumIdentificacion;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptNumIdentificacion(String asesorTMODIFICARASESORAGENCIAptNumIdentificacion) {
        this.asesorTMODIFICARASESORAGENCIAptNumIdentificacion = asesorTMODIFICARASESORAGENCIAptNumIdentificacion;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptNumIdentificacion() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptNumIdentificacion() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTNUMIDENTIFICACION, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTNUMIDENTIFICACION);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona() {
        return this.asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona(Boolean asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona) {
        this.asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona = asesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptpVerDBasicosPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPVERDBASICOSPERSONA, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPVERDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORAGENCIAptpVerDocsPersona() {
        return this.asesorTMODIFICARASESORAGENCIAptpVerDocsPersona;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpVerDocsPersona(Boolean asesorTMODIFICARASESORAGENCIAptpVerDocsPersona) {
        this.asesorTMODIFICARASESORAGENCIAptpVerDocsPersona = asesorTMODIFICARASESORAGENCIAptpVerDocsPersona;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptpVerDocsPersona() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptpVerDocsPersona() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPVERDOCSPERSONA, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPVERDOCSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getAsesorTMODIFICARASESORAGENCIAptpVerContratoNovedad() {
        return this.asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad;
    }
    
    public void setAsesorTMODIFICARASESORAGENCIAptpVerContratoNovedad(Boolean asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad) {
        this.asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad = asesorTMODIFICARASESORAGENCIAptpVerContratoNovedad;
    }

    private void checkAsesorTMODIFICARASESORAGENCIAptpVerContratoNovedad() throws NotNullArgumentException {
        if(this.getAsesorTMODIFICARASESORAGENCIAptpVerContratoNovedad() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPVERCONTRATONOVEDAD, AsesorConstants.SERV_ALIAS_TMODIFICARASESORAGENCIA, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TMODIFICARASESORAGENCIA_ASESORTMODIFICARASESORAGENCIAPTPVERCONTRATONOVEDAD);
        }
    }
}
