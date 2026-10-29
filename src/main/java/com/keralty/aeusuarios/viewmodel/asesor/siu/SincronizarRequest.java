package com.keralty.aeusuarios.viewmodel.asesor.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class SincronizarRequest {

    @JsonProperty("p_thisasesor_oid")
    private AsesorOid asesorsincronizarpthisAsesor;
    
    @JsonIgnore
    private Asesor asesorsincronizarpthisAsesorInstance;

    @JsonProperty("pcoddirector")
    private String asesorsincronizarpCodDirector;

    @JsonProperty("pnumidentificacion")
    private String asesorsincronizarpNumIdentificacion;

    @JsonProperty("pcanal")
    private String asesorsincronizarpCanal;

    @JsonProperty("pcargo")
    private String asesorsincronizarpCargo;

    @JsonProperty("pestado")
    private String asesorsincronizarpEstado;

    public void checkArguments() throws NotNullArgumentException {
        checkAsesorsincronizarpthisAsesor();
    }

    @JsonIgnore
    public AsesorOid getAsesorsincronizarpthisAsesor() {
        return this.asesorsincronizarpthisAsesor;
    }
    
    public void setAsesorsincronizarpthisAsesor(AsesorOid asesorsincronizarpthisAsesor) {
        this.asesorsincronizarpthisAsesor = asesorsincronizarpthisAsesor;
    }

    @JsonIgnore
    public Asesor getAsesorsincronizarpthisAsesorInstance() {
        return this.asesorsincronizarpthisAsesorInstance;
    }
    
    public void setAsesorsincronizarpthisAsesorInstance(Asesor asesorsincronizarpthisAsesor) {
        this.asesorsincronizarpthisAsesorInstance = asesorsincronizarpthisAsesor;
        this.asesorsincronizarpthisAsesor = asesorsincronizarpthisAsesor != null ? asesorsincronizarpthisAsesor.getOid() : null;
    }

    private void checkAsesorsincronizarpthisAsesor() throws NotNullArgumentException {
        if(this.getAsesorsincronizarpthisAsesorInstance() == null || this.getAsesorsincronizarpthisAsesorInstance().isNull()) {
            throw new NotNullArgumentException(AsesorConstants.SERV_ID_SINCRONIZAR, AsesorConstants.CLASS_ID, AsesorConstants.ARG_ID_SINCRONIZAR_ASESORSINCRONIZARPTHISASESOR, AsesorConstants.SERV_ALIAS_SINCRONIZAR, AsesorConstants.CLASS_ALIAS, AsesorConstants.ARG_ALIAS_SINCRONIZAR_ASESORSINCRONIZARPTHISASESOR);
        }
    }

    @JsonIgnore
    public String getAsesorsincronizarpCodDirector() {
        return this.asesorsincronizarpCodDirector;
    }
    
    public void setAsesorsincronizarpCodDirector(String asesorsincronizarpCodDirector) {
        this.asesorsincronizarpCodDirector = asesorsincronizarpCodDirector;
    }

    @JsonIgnore
    public String getAsesorsincronizarpNumIdentificacion() {
        return this.asesorsincronizarpNumIdentificacion;
    }
    
    public void setAsesorsincronizarpNumIdentificacion(String asesorsincronizarpNumIdentificacion) {
        this.asesorsincronizarpNumIdentificacion = asesorsincronizarpNumIdentificacion;
    }

    @JsonIgnore
    public String getAsesorsincronizarpCanal() {
        return this.asesorsincronizarpCanal;
    }
    
    public void setAsesorsincronizarpCanal(String asesorsincronizarpCanal) {
        this.asesorsincronizarpCanal = asesorsincronizarpCanal;
    }

    @JsonIgnore
    public String getAsesorsincronizarpCargo() {
        return this.asesorsincronizarpCargo;
    }
    
    public void setAsesorsincronizarpCargo(String asesorsincronizarpCargo) {
        this.asesorsincronizarpCargo = asesorsincronizarpCargo;
    }

    @JsonIgnore
    public String getAsesorsincronizarpEstado() {
        return this.asesorsincronizarpEstado;
    }
    
    public void setAsesorsincronizarpEstado(String asesorsincronizarpEstado) {
        this.asesorsincronizarpEstado = asesorsincronizarpEstado;
    }
}
