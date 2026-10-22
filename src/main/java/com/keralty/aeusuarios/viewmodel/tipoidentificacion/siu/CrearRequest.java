package com.keralty.aeusuarios.viewmodel.tipoidentificacion.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;

public class CrearRequest {

    @JsonProperty("p_atrcodigo")
    private Long tipoIdentificacioncrearpatrCodigo;

    @JsonProperty("p_atrdescripcion")
    private String tipoIdentificacioncrearpatrDescripcion;

    @JsonProperty("p_atrnombrecorto")
    private String tipoIdentificacioncrearpatrNombreCorto;

    @JsonProperty("p_atrvalidocontratante")
    private Boolean tipoIdentificacioncrearpatrValidoContratante;

    @JsonProperty("p_atrvalidotitular")
    private Boolean tipoIdentificacioncrearpatrValidoTitular;

    @JsonProperty("p_atrdiplomatico")
    private Boolean tipoIdentificacioncrearpatrDiplomatico;

    @JsonProperty("p_atrnit")
    private Boolean tipoIdentificacioncrearpatrNIT;

    @JsonProperty("p_atrhijode")
    private Boolean tipoIdentificacioncrearpatrHijoDe;

    @JsonProperty("p_atrrequiereeps")
    private Boolean tipoIdentificacioncrearpatrRequiereEPS;

    @JsonProperty("p_atrmenorsinidentificar")
    private Boolean tipoIdentificacioncrearpatrMenorSinIdentificar;

    @JsonProperty("p_atrespasaporte")
    private Boolean tipoIdentificacioncrearpatrEsPasaporte;

    @JsonProperty("p_atrvisiblevalidadorusu")
    private Boolean tipoIdentificacioncrearpatrVisibleValidadorUsu;

    public void checkArguments() throws NotNullArgumentException {
        checkTipoIdentificacioncrearpatrCodigo();
        checkTipoIdentificacioncrearpatrDescripcion();
        checkTipoIdentificacioncrearpatrNombreCorto();
        checkTipoIdentificacioncrearpatrValidoContratante();
        checkTipoIdentificacioncrearpatrValidoTitular();
        checkTipoIdentificacioncrearpatrDiplomatico();
        checkTipoIdentificacioncrearpatrNIT();
        checkTipoIdentificacioncrearpatrHijoDe();
        checkTipoIdentificacioncrearpatrRequiereEPS();
        checkTipoIdentificacioncrearpatrMenorSinIdentificar();
        checkTipoIdentificacioncrearpatrEsPasaporte();
        checkTipoIdentificacioncrearpatrVisibleValidadorUsu();
    }

    @JsonIgnore
    public Long getTipoIdentificacioncrearpatrCodigo() {
        return this.tipoIdentificacioncrearpatrCodigo;
    }
    
    public void setTipoIdentificacioncrearpatrCodigo(Long tipoIdentificacioncrearpatrCodigo) {
        this.tipoIdentificacioncrearpatrCodigo = tipoIdentificacioncrearpatrCodigo;
    }

    private void checkTipoIdentificacioncrearpatrCodigo() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrCodigo() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRCODIGO, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRCODIGO);
        }
    }

    @JsonIgnore
    public String getTipoIdentificacioncrearpatrDescripcion() {
        return this.tipoIdentificacioncrearpatrDescripcion;
    }
    
    public void setTipoIdentificacioncrearpatrDescripcion(String tipoIdentificacioncrearpatrDescripcion) {
        this.tipoIdentificacioncrearpatrDescripcion = tipoIdentificacioncrearpatrDescripcion;
    }

    private void checkTipoIdentificacioncrearpatrDescripcion() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrDescripcion() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRDESCRIPCION, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRDESCRIPCION);
        }
    }

    @JsonIgnore
    public String getTipoIdentificacioncrearpatrNombreCorto() {
        return this.tipoIdentificacioncrearpatrNombreCorto;
    }
    
    public void setTipoIdentificacioncrearpatrNombreCorto(String tipoIdentificacioncrearpatrNombreCorto) {
        this.tipoIdentificacioncrearpatrNombreCorto = tipoIdentificacioncrearpatrNombreCorto;
    }

    private void checkTipoIdentificacioncrearpatrNombreCorto() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrNombreCorto() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRNOMBRECORTO, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRNOMBRECORTO);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrValidoContratante() {
        return this.tipoIdentificacioncrearpatrValidoContratante;
    }
    
    public void setTipoIdentificacioncrearpatrValidoContratante(Boolean tipoIdentificacioncrearpatrValidoContratante) {
        this.tipoIdentificacioncrearpatrValidoContratante = tipoIdentificacioncrearpatrValidoContratante;
    }

    private void checkTipoIdentificacioncrearpatrValidoContratante() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrValidoContratante() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRVALIDOCONTRATANTE, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRVALIDOCONTRATANTE);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrValidoTitular() {
        return this.tipoIdentificacioncrearpatrValidoTitular;
    }
    
    public void setTipoIdentificacioncrearpatrValidoTitular(Boolean tipoIdentificacioncrearpatrValidoTitular) {
        this.tipoIdentificacioncrearpatrValidoTitular = tipoIdentificacioncrearpatrValidoTitular;
    }

    private void checkTipoIdentificacioncrearpatrValidoTitular() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrValidoTitular() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRVALIDOTITULAR, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRVALIDOTITULAR);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrDiplomatico() {
        return this.tipoIdentificacioncrearpatrDiplomatico;
    }
    
    public void setTipoIdentificacioncrearpatrDiplomatico(Boolean tipoIdentificacioncrearpatrDiplomatico) {
        this.tipoIdentificacioncrearpatrDiplomatico = tipoIdentificacioncrearpatrDiplomatico;
    }

    private void checkTipoIdentificacioncrearpatrDiplomatico() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrDiplomatico() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRDIPLOMATICO, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRDIPLOMATICO);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrNIT() {
        return this.tipoIdentificacioncrearpatrNIT;
    }
    
    public void setTipoIdentificacioncrearpatrNIT(Boolean tipoIdentificacioncrearpatrNIT) {
        this.tipoIdentificacioncrearpatrNIT = tipoIdentificacioncrearpatrNIT;
    }

    private void checkTipoIdentificacioncrearpatrNIT() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrNIT() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRNIT, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRNIT);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrHijoDe() {
        return this.tipoIdentificacioncrearpatrHijoDe;
    }
    
    public void setTipoIdentificacioncrearpatrHijoDe(Boolean tipoIdentificacioncrearpatrHijoDe) {
        this.tipoIdentificacioncrearpatrHijoDe = tipoIdentificacioncrearpatrHijoDe;
    }

    private void checkTipoIdentificacioncrearpatrHijoDe() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrHijoDe() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRHIJODE, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRHIJODE);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrRequiereEPS() {
        return this.tipoIdentificacioncrearpatrRequiereEPS;
    }
    
    public void setTipoIdentificacioncrearpatrRequiereEPS(Boolean tipoIdentificacioncrearpatrRequiereEPS) {
        this.tipoIdentificacioncrearpatrRequiereEPS = tipoIdentificacioncrearpatrRequiereEPS;
    }

    private void checkTipoIdentificacioncrearpatrRequiereEPS() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrRequiereEPS() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRREQUIEREEPS, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRREQUIEREEPS);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrMenorSinIdentificar() {
        return this.tipoIdentificacioncrearpatrMenorSinIdentificar;
    }
    
    public void setTipoIdentificacioncrearpatrMenorSinIdentificar(Boolean tipoIdentificacioncrearpatrMenorSinIdentificar) {
        this.tipoIdentificacioncrearpatrMenorSinIdentificar = tipoIdentificacioncrearpatrMenorSinIdentificar;
    }

    private void checkTipoIdentificacioncrearpatrMenorSinIdentificar() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrMenorSinIdentificar() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRMENORSINIDENTIFICAR, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRMENORSINIDENTIFICAR);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrEsPasaporte() {
        return this.tipoIdentificacioncrearpatrEsPasaporte;
    }
    
    public void setTipoIdentificacioncrearpatrEsPasaporte(Boolean tipoIdentificacioncrearpatrEsPasaporte) {
        this.tipoIdentificacioncrearpatrEsPasaporte = tipoIdentificacioncrearpatrEsPasaporte;
    }

    private void checkTipoIdentificacioncrearpatrEsPasaporte() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrEsPasaporte() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRESPASAPORTE, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRESPASAPORTE);
        }
    }

    @JsonIgnore
    public Boolean getTipoIdentificacioncrearpatrVisibleValidadorUsu() {
        return this.tipoIdentificacioncrearpatrVisibleValidadorUsu;
    }
    
    public void setTipoIdentificacioncrearpatrVisibleValidadorUsu(Boolean tipoIdentificacioncrearpatrVisibleValidadorUsu) {
        this.tipoIdentificacioncrearpatrVisibleValidadorUsu = tipoIdentificacioncrearpatrVisibleValidadorUsu;
    }

    private void checkTipoIdentificacioncrearpatrVisibleValidadorUsu() throws NotNullArgumentException {
        if(this.getTipoIdentificacioncrearpatrVisibleValidadorUsu() == null) {
            throw new NotNullArgumentException(TipoIdentificacionConstants.SERV_ID_CREAR, TipoIdentificacionConstants.CLASS_ID, TipoIdentificacionConstants.ARG_ID_CREAR_TIPOIDENTIFICACIONCREARPATRVISIBLEVALIDADORUSU, TipoIdentificacionConstants.SERV_ALIAS_CREAR, TipoIdentificacionConstants.CLASS_ALIAS, TipoIdentificacionConstants.ARG_ALIAS_CREAR_TIPOIDENTIFICACIONCREARPATRVISIBLEVALIDADORUSU);
        }
    }
}
