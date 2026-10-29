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

public class TSINCRONIZARRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorTSINCRONIZARpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorTSINCRONIZARpthisAsesorInstance;

    @JsonProperty("pt_p_primernombre")
    private String asesorTSINCRONIZARptpPrimerNombre;

    @JsonProperty("pt_p_segundonombre")
    private String asesorTSINCRONIZARptpSegundoNombre;

    @JsonProperty("pt_p_primerapellido")
    private String asesorTSINCRONIZARptpPrimerApellido;

    @JsonProperty("pt_p_segundoapellido")
    private String asesorTSINCRONIZARptpSegundoApellido;

    @JsonProperty("pt_p_evcsucursal_oid")
    private SucursalOid asesorTSINCRONIZARptpevcSucursal;
    
    @JsonIgnore
    private Sucursal asesorTSINCRONIZARptpevcSucursalInstance;

    @JsonProperty("pcoddirector")
    private String asesorTSINCRONIZARpCodDirector;

    @JsonProperty("pnumidentificacion")
    private String asesorTSINCRONIZARpNumIdentificacion;

    @JsonProperty("ptipoidentificacion_oid")
    private TipoIdentificacionOid asesorTSINCRONIZARpTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion asesorTSINCRONIZARpTipoIdentificacionInstance;

    @JsonProperty("pt_pcanal")
    private String asesorTSINCRONIZARptpCanal;

    @JsonProperty("pt_pcargo")
    private String asesorTSINCRONIZARptpCargo;

    @JsonProperty("pt_pestado")
    private String asesorTSINCRONIZARptpEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorTSINCRONIZARpthisAsesor();
        checkAsesorTSINCRONIZARptpPrimerNombre();
        checkAsesorTSINCRONIZARptpPrimerApellido();
        checkAsesorTSINCRONIZARptpevcSucursal();
    }

    @JsonIgnore
    public AsesorOid getAsesorTSINCRONIZARpthisAsesor() {
        return this.asesorTSINCRONIZARpthisAsesor;
    }
    
    public void setAsesorTSINCRONIZARpthisAsesor(AsesorOid asesorTSINCRONIZARpthisAsesor) {
        this.asesorTSINCRONIZARpthisAsesor = asesorTSINCRONIZARpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorTSINCRONIZARpthisAsesorInstance() {
        return this.asesorTSINCRONIZARpthisAsesorInstance;
    }
    
    public void setAsesorTSINCRONIZARpthisAsesorInstance(Asesor asesorTSINCRONIZARpthisAsesor) {
        this.asesorTSINCRONIZARpthisAsesorInstance = asesorTSINCRONIZARpthisAsesor;
        this.asesorTSINCRONIZARpthisAsesor = asesorTSINCRONIZARpthisAsesor != null ? asesorTSINCRONIZARpthisAsesor.getOid() : null;
    }

    private void checkAsesorTSINCRONIZARpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorTSINCRONIZARpthisAsesorInstance() == null || this.getAsesorTSINCRONIZARpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TSINCRONIZAR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TSINCRONIZAR_ASESORTSINCRONIZARPTHISASESOR, AsesorConstants.SERV_ALIAS_TSINCRONIZAR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TSINCRONIZAR_ASESORTSINCRONIZARPTHISASESOR);
        }
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARptpPrimerNombre() {
        return this.asesorTSINCRONIZARptpPrimerNombre;
    }
    
    public void setAsesorTSINCRONIZARptpPrimerNombre(String asesorTSINCRONIZARptpPrimerNombre) {
        this.asesorTSINCRONIZARptpPrimerNombre = asesorTSINCRONIZARptpPrimerNombre;
    }

    private void checkAsesorTSINCRONIZARptpPrimerNombre() throws NotNullArgumentException {
        if(this.getAsesorTSINCRONIZARptpPrimerNombre() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TSINCRONIZAR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TSINCRONIZAR_ASESORTSINCRONIZARPTPPRIMERNOMBRE, AsesorConstants.SERV_ALIAS_TSINCRONIZAR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TSINCRONIZAR_ASESORTSINCRONIZARPTPPRIMERNOMBRE);
        }
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARptpSegundoNombre() {
        return this.asesorTSINCRONIZARptpSegundoNombre;
    }
    
    public void setAsesorTSINCRONIZARptpSegundoNombre(String asesorTSINCRONIZARptpSegundoNombre) {
        this.asesorTSINCRONIZARptpSegundoNombre = asesorTSINCRONIZARptpSegundoNombre;
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARptpPrimerApellido() {
        return this.asesorTSINCRONIZARptpPrimerApellido;
    }
    
    public void setAsesorTSINCRONIZARptpPrimerApellido(String asesorTSINCRONIZARptpPrimerApellido) {
        this.asesorTSINCRONIZARptpPrimerApellido = asesorTSINCRONIZARptpPrimerApellido;
    }

    private void checkAsesorTSINCRONIZARptpPrimerApellido() throws NotNullArgumentException {
        if(this.getAsesorTSINCRONIZARptpPrimerApellido() == null) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TSINCRONIZAR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TSINCRONIZAR_ASESORTSINCRONIZARPTPPRIMERAPELLIDO, AsesorConstants.SERV_ALIAS_TSINCRONIZAR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TSINCRONIZAR_ASESORTSINCRONIZARPTPPRIMERAPELLIDO);
        }
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARptpSegundoApellido() {
        return this.asesorTSINCRONIZARptpSegundoApellido;
    }
    
    public void setAsesorTSINCRONIZARptpSegundoApellido(String asesorTSINCRONIZARptpSegundoApellido) {
        this.asesorTSINCRONIZARptpSegundoApellido = asesorTSINCRONIZARptpSegundoApellido;
    }

    @JsonIgnore
    public SucursalOid getAsesorTSINCRONIZARptpevcSucursal() {
        return this.asesorTSINCRONIZARptpevcSucursal;
    }
    
    public void setAsesorTSINCRONIZARptpevcSucursal(SucursalOid asesorTSINCRONIZARptpevcSucursal) {
        this.asesorTSINCRONIZARptpevcSucursal = asesorTSINCRONIZARptpevcSucursal;
    }

    @JsonIgnore
    public Sucursal getAsesorTSINCRONIZARptpevcSucursalInstance() {
        return this.asesorTSINCRONIZARptpevcSucursalInstance;
    }
    
    public void setAsesorTSINCRONIZARptpevcSucursalInstance(Sucursal asesorTSINCRONIZARptpevcSucursal) {
        this.asesorTSINCRONIZARptpevcSucursalInstance = asesorTSINCRONIZARptpevcSucursal;
        this.asesorTSINCRONIZARptpevcSucursal = asesorTSINCRONIZARptpevcSucursal != null ? asesorTSINCRONIZARptpevcSucursal.getOid() : null;
    }

    private void checkAsesorTSINCRONIZARptpevcSucursal() throws NotNullArgumentException {
        if(this.getAsesorTSINCRONIZARptpevcSucursalInstance() == null || this.getAsesorTSINCRONIZARptpevcSucursalInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_TSINCRONIZAR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_TSINCRONIZAR_ASESORTSINCRONIZARPTPEVCSUCURSAL, AsesorConstants.SERV_ALIAS_TSINCRONIZAR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_TSINCRONIZAR_ASESORTSINCRONIZARPTPEVCSUCURSAL);
        }
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARpCodDirector() {
        return this.asesorTSINCRONIZARpCodDirector;
    }
    
    public void setAsesorTSINCRONIZARpCodDirector(String asesorTSINCRONIZARpCodDirector) {
        this.asesorTSINCRONIZARpCodDirector = asesorTSINCRONIZARpCodDirector;
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARpNumIdentificacion() {
        return this.asesorTSINCRONIZARpNumIdentificacion;
    }
    
    public void setAsesorTSINCRONIZARpNumIdentificacion(String asesorTSINCRONIZARpNumIdentificacion) {
        this.asesorTSINCRONIZARpNumIdentificacion = asesorTSINCRONIZARpNumIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacionOid getAsesorTSINCRONIZARpTipoIdentificacion() {
        return this.asesorTSINCRONIZARpTipoIdentificacion;
    }
    
    public void setAsesorTSINCRONIZARpTipoIdentificacion(TipoIdentificacionOid asesorTSINCRONIZARpTipoIdentificacion) {
        this.asesorTSINCRONIZARpTipoIdentificacion = asesorTSINCRONIZARpTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getAsesorTSINCRONIZARpTipoIdentificacionInstance() {
        return this.asesorTSINCRONIZARpTipoIdentificacionInstance;
    }
    
    public void setAsesorTSINCRONIZARpTipoIdentificacionInstance(TipoIdentificacion asesorTSINCRONIZARpTipoIdentificacion) {
        this.asesorTSINCRONIZARpTipoIdentificacionInstance = asesorTSINCRONIZARpTipoIdentificacion;
        this.asesorTSINCRONIZARpTipoIdentificacion = asesorTSINCRONIZARpTipoIdentificacion != null ? asesorTSINCRONIZARpTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARptpCanal() {
        return this.asesorTSINCRONIZARptpCanal;
    }
    
    public void setAsesorTSINCRONIZARptpCanal(String asesorTSINCRONIZARptpCanal) {
        this.asesorTSINCRONIZARptpCanal = asesorTSINCRONIZARptpCanal;
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARptpCargo() {
        return this.asesorTSINCRONIZARptpCargo;
    }
    
    public void setAsesorTSINCRONIZARptpCargo(String asesorTSINCRONIZARptpCargo) {
        this.asesorTSINCRONIZARptpCargo = asesorTSINCRONIZARptpCargo;
    }

    @JsonIgnore
    public String getAsesorTSINCRONIZARptpEstado() {
        return this.asesorTSINCRONIZARptpEstado;
    }
    
    public void setAsesorTSINCRONIZARptpEstado(String asesorTSINCRONIZARptpEstado) {
        this.asesorTSINCRONIZARptpEstado = asesorTSINCRONIZARptpEstado;
    }
}
