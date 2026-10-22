package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.TipoIdentificacionOid;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;

public class HacerAsesorRequest {

    @JsonProperty("p_thisagente_oid")
    private FuncionarioOid funcionariohacerAsesorpthisAgente;
    
    @JsonIgnore
    private Funcionario funcionariohacerAsesorpthisAgenteInstance;

    @JsonProperty("p_agrtipoidentificacion_oid")
    private TipoIdentificacionOid funcionariohacerAsesorpagrTipoIdentificacion;
    
    @JsonIgnore
    private TipoIdentificacion funcionariohacerAsesorpagrTipoIdentificacionInstance;

    @JsonProperty("p_atrmodificadirector")
    private Boolean funcionariohacerAsesorpatrmodificaDirector;

    @JsonProperty("p_atresdirector")
    private Boolean funcionariohacerAsesorpatresDirector;

    @JsonProperty("p_atrnumidentificacion")
    private String funcionariohacerAsesorpatrNumIdentificacion;

    @JsonProperty("p_atrmoddbasicospersona")
    private Boolean funcionariohacerAsesorpatrModDBasicosPersona;

    @JsonProperty("p_atresintegral")
    private Boolean funcionariohacerAsesorpatrEsIntegral;

    @JsonProperty("p_atrverdbasicospersona")
    private Boolean funcionariohacerAsesorpatrVerDBasicosPersona;

    @JsonProperty("p_atrverdocidentificacionperso")
    private Boolean funcionariohacerAsesorpatrVerDocIdentificacionPerso;

    @JsonProperty("p_atrvercontratonovedad")
    private Boolean funcionariohacerAsesorpatrVerContratoNovedad;

    @JsonProperty("p_atrcanalcomercial")
    private String funcionariohacerAsesorpatrCanalComercial;

    @JsonProperty("p_atrcargo")
    private String funcionariohacerAsesorpatrCargo;

    @JsonProperty("p_atrestado")
    private String funcionariohacerAsesorpatrEstado;

    @JsonProperty("p_atraccesovalidadorusuarios")
    private Boolean funcionariohacerAsesorpatrAccesoValidadorUsuarios;

    @JsonProperty("p_codjefe")
    private String funcionariohacerAsesorpCodJefe;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionariohacerAsesorpthisAgente();
        checkFuncionariohacerAsesorpatrmodificaDirector();
        checkFuncionariohacerAsesorpatresDirector();
        checkFuncionariohacerAsesorpatrModDBasicosPersona();
        checkFuncionariohacerAsesorpatrEsIntegral();
        checkFuncionariohacerAsesorpatrVerDBasicosPersona();
        checkFuncionariohacerAsesorpatrVerDocIdentificacionPerso();
        checkFuncionariohacerAsesorpatrVerContratoNovedad();
        checkFuncionariohacerAsesorpatrAccesoValidadorUsuarios();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionariohacerAsesorpthisAgente() {
        return this.funcionariohacerAsesorpthisAgente;
    }
    
    public void setFuncionariohacerAsesorpthisAgente(FuncionarioOid funcionariohacerAsesorpthisAgente) {
        this.funcionariohacerAsesorpthisAgente = funcionariohacerAsesorpthisAgente;
    }

    @JsonIgnore
    public Funcionario getFuncionariohacerAsesorpthisAgenteInstance() {
        return this.funcionariohacerAsesorpthisAgenteInstance;
    }
    
    public void setFuncionariohacerAsesorpthisAgenteInstance(Funcionario funcionariohacerAsesorpthisAgente) {
        this.funcionariohacerAsesorpthisAgenteInstance = funcionariohacerAsesorpthisAgente;
        this.funcionariohacerAsesorpthisAgente = funcionariohacerAsesorpthisAgente != null ? funcionariohacerAsesorpthisAgente.getOid() : null;
    }

    private void checkFuncionariohacerAsesorpthisAgente() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpthisAgenteInstance() == null || this.getFuncionariohacerAsesorpthisAgenteInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPTHISAGENTE, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPTHISAGENTE);
        }
    }

    @JsonIgnore
    public TipoIdentificacionOid getFuncionariohacerAsesorpagrTipoIdentificacion() {
        return this.funcionariohacerAsesorpagrTipoIdentificacion;
    }
    
    public void setFuncionariohacerAsesorpagrTipoIdentificacion(TipoIdentificacionOid funcionariohacerAsesorpagrTipoIdentificacion) {
        this.funcionariohacerAsesorpagrTipoIdentificacion = funcionariohacerAsesorpagrTipoIdentificacion;
    }

    @JsonIgnore
    public TipoIdentificacion getFuncionariohacerAsesorpagrTipoIdentificacionInstance() {
        return this.funcionariohacerAsesorpagrTipoIdentificacionInstance;
    }
    
    public void setFuncionariohacerAsesorpagrTipoIdentificacionInstance(TipoIdentificacion funcionariohacerAsesorpagrTipoIdentificacion) {
        this.funcionariohacerAsesorpagrTipoIdentificacionInstance = funcionariohacerAsesorpagrTipoIdentificacion;
        this.funcionariohacerAsesorpagrTipoIdentificacion = funcionariohacerAsesorpagrTipoIdentificacion != null ? funcionariohacerAsesorpagrTipoIdentificacion.getOid() : null;
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatrmodificaDirector() {
        return this.funcionariohacerAsesorpatrmodificaDirector;
    }
    
    public void setFuncionariohacerAsesorpatrmodificaDirector(Boolean funcionariohacerAsesorpatrmodificaDirector) {
        this.funcionariohacerAsesorpatrmodificaDirector = funcionariohacerAsesorpatrmodificaDirector;
    }

    private void checkFuncionariohacerAsesorpatrmodificaDirector() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatrmodificaDirector() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRMODIFICADIRECTOR, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRMODIFICADIRECTOR);
        }
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatresDirector() {
        return this.funcionariohacerAsesorpatresDirector;
    }
    
    public void setFuncionariohacerAsesorpatresDirector(Boolean funcionariohacerAsesorpatresDirector) {
        this.funcionariohacerAsesorpatresDirector = funcionariohacerAsesorpatresDirector;
    }

    private void checkFuncionariohacerAsesorpatresDirector() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatresDirector() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRESDIRECTOR, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRESDIRECTOR);
        }
    }

    @JsonIgnore
    public String getFuncionariohacerAsesorpatrNumIdentificacion() {
        return this.funcionariohacerAsesorpatrNumIdentificacion;
    }
    
    public void setFuncionariohacerAsesorpatrNumIdentificacion(String funcionariohacerAsesorpatrNumIdentificacion) {
        this.funcionariohacerAsesorpatrNumIdentificacion = funcionariohacerAsesorpatrNumIdentificacion;
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatrModDBasicosPersona() {
        return this.funcionariohacerAsesorpatrModDBasicosPersona;
    }
    
    public void setFuncionariohacerAsesorpatrModDBasicosPersona(Boolean funcionariohacerAsesorpatrModDBasicosPersona) {
        this.funcionariohacerAsesorpatrModDBasicosPersona = funcionariohacerAsesorpatrModDBasicosPersona;
    }

    private void checkFuncionariohacerAsesorpatrModDBasicosPersona() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatrModDBasicosPersona() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRMODDBASICOSPERSONA, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRMODDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatrEsIntegral() {
        return this.funcionariohacerAsesorpatrEsIntegral;
    }
    
    public void setFuncionariohacerAsesorpatrEsIntegral(Boolean funcionariohacerAsesorpatrEsIntegral) {
        this.funcionariohacerAsesorpatrEsIntegral = funcionariohacerAsesorpatrEsIntegral;
    }

    private void checkFuncionariohacerAsesorpatrEsIntegral() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatrEsIntegral() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRESINTEGRAL, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRESINTEGRAL);
        }
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatrVerDBasicosPersona() {
        return this.funcionariohacerAsesorpatrVerDBasicosPersona;
    }
    
    public void setFuncionariohacerAsesorpatrVerDBasicosPersona(Boolean funcionariohacerAsesorpatrVerDBasicosPersona) {
        this.funcionariohacerAsesorpatrVerDBasicosPersona = funcionariohacerAsesorpatrVerDBasicosPersona;
    }

    private void checkFuncionariohacerAsesorpatrVerDBasicosPersona() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatrVerDBasicosPersona() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRVERDBASICOSPERSONA, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRVERDBASICOSPERSONA);
        }
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatrVerDocIdentificacionPerso() {
        return this.funcionariohacerAsesorpatrVerDocIdentificacionPerso;
    }
    
    public void setFuncionariohacerAsesorpatrVerDocIdentificacionPerso(Boolean funcionariohacerAsesorpatrVerDocIdentificacionPerso) {
        this.funcionariohacerAsesorpatrVerDocIdentificacionPerso = funcionariohacerAsesorpatrVerDocIdentificacionPerso;
    }

    private void checkFuncionariohacerAsesorpatrVerDocIdentificacionPerso() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatrVerDocIdentificacionPerso() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRVERDOCIDENTIFICACIONPERSO, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRVERDOCIDENTIFICACIONPERSO);
        }
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatrVerContratoNovedad() {
        return this.funcionariohacerAsesorpatrVerContratoNovedad;
    }
    
    public void setFuncionariohacerAsesorpatrVerContratoNovedad(Boolean funcionariohacerAsesorpatrVerContratoNovedad) {
        this.funcionariohacerAsesorpatrVerContratoNovedad = funcionariohacerAsesorpatrVerContratoNovedad;
    }

    private void checkFuncionariohacerAsesorpatrVerContratoNovedad() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatrVerContratoNovedad() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRVERCONTRATONOVEDAD, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRVERCONTRATONOVEDAD);
        }
    }

    @JsonIgnore
    public String getFuncionariohacerAsesorpatrCanalComercial() {
        return this.funcionariohacerAsesorpatrCanalComercial;
    }
    
    public void setFuncionariohacerAsesorpatrCanalComercial(String funcionariohacerAsesorpatrCanalComercial) {
        this.funcionariohacerAsesorpatrCanalComercial = funcionariohacerAsesorpatrCanalComercial;
    }

    @JsonIgnore
    public String getFuncionariohacerAsesorpatrCargo() {
        return this.funcionariohacerAsesorpatrCargo;
    }
    
    public void setFuncionariohacerAsesorpatrCargo(String funcionariohacerAsesorpatrCargo) {
        this.funcionariohacerAsesorpatrCargo = funcionariohacerAsesorpatrCargo;
    }

    @JsonIgnore
    public String getFuncionariohacerAsesorpatrEstado() {
        return this.funcionariohacerAsesorpatrEstado;
    }
    
    public void setFuncionariohacerAsesorpatrEstado(String funcionariohacerAsesorpatrEstado) {
        this.funcionariohacerAsesorpatrEstado = funcionariohacerAsesorpatrEstado;
    }

    @JsonIgnore
    public Boolean getFuncionariohacerAsesorpatrAccesoValidadorUsuarios() {
        return this.funcionariohacerAsesorpatrAccesoValidadorUsuarios;
    }
    
    public void setFuncionariohacerAsesorpatrAccesoValidadorUsuarios(Boolean funcionariohacerAsesorpatrAccesoValidadorUsuarios) {
        this.funcionariohacerAsesorpatrAccesoValidadorUsuarios = funcionariohacerAsesorpatrAccesoValidadorUsuarios;
    }

    private void checkFuncionariohacerAsesorpatrAccesoValidadorUsuarios() throws NotNullArgumentException {
        if(this.getFuncionariohacerAsesorpatrAccesoValidadorUsuarios() == null) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_HACERASESOR, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_HACERASESOR_FUNCIONARIOHACERASESORPATRACCESOVALIDADORUSUARIOS, FuncionarioConstants.SERV_ALIAS_HACERASESOR, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_HACERASESOR_FUNCIONARIOHACERASESORPATRACCESOVALIDADORUSUARIOS);
        }
    }

    @JsonIgnore
    public String getFuncionariohacerAsesorpCodJefe() {
        return this.funcionariohacerAsesorpCodJefe;
    }
    
    public void setFuncionariohacerAsesorpCodJefe(String funcionariohacerAsesorpCodJefe) {
        this.funcionariohacerAsesorpCodJefe = funcionariohacerAsesorpCodJefe;
    }
}
