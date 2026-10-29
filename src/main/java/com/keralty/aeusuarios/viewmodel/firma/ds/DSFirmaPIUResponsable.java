package com.keralty.aeusuarios.viewmodel.firma.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Firma;
public class DSFirmaPIUResponsable {

    @JsonProperty("respregional_usuario")
    private String dSFirmaPIUResponsableRespRegionalDotUsuario;

    @JsonProperty("respregional_primernombre")
    private String dSFirmaPIUResponsableRespRegionalDotPrimerNombre;

    @JsonProperty("respregional_segundonombre")
    private String dSFirmaPIUResponsableRespRegionalDotSegundoNombre;

    @JsonProperty("respregional_primerapellido")
    private String dSFirmaPIUResponsableRespRegionalDotPrimerApellido;

    @JsonProperty("respregional_segundoapellido")
    private String dSFirmaPIUResponsableRespRegionalDotSegundoApellido;

    @JsonProperty("respregional_sucursal_descripcion")
    private String dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion;

    @JsonProperty("respregional_sucursal_regional_descripcion")
    private String dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion;

    public DSFirmaPIUResponsable() {
    
    }

    public DSFirmaPIUResponsable(Firma instance) {
        if (instance != null) {
            try {
                this.dSFirmaPIUResponsableRespRegionalDotUsuario = instance.getRespRegional().getFuncionarioUsuario();
                this.dSFirmaPIUResponsableRespRegionalDotPrimerNombre = instance.getRespRegional().getFuncionarioPrimerNombre();
                this.dSFirmaPIUResponsableRespRegionalDotSegundoNombre = instance.getRespRegional().getFuncionarioSegundoNombre();
                this.dSFirmaPIUResponsableRespRegionalDotPrimerApellido = instance.getRespRegional().getFuncionarioPrimerApellido();
                this.dSFirmaPIUResponsableRespRegionalDotSegundoApellido = instance.getRespRegional().getFuncionarioSegundoApellido();
                this.dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion = instance.getRespRegional().getSucursal().getSucursalDescripcion();
                this.dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion = instance.getRespRegional().getSucursal().getRegional().getRegionalDescripcion();
            } catch (Exception e) {
                org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            }
        }
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotUsuario() {
        return this.dSFirmaPIUResponsableRespRegionalDotUsuario;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotUsuario(String dSFirmaPIUResponsableRespRegionalDotUsuario) {
        this.dSFirmaPIUResponsableRespRegionalDotUsuario = dSFirmaPIUResponsableRespRegionalDotUsuario;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotPrimerNombre() {
        return this.dSFirmaPIUResponsableRespRegionalDotPrimerNombre;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotPrimerNombre(String dSFirmaPIUResponsableRespRegionalDotPrimerNombre) {
        this.dSFirmaPIUResponsableRespRegionalDotPrimerNombre = dSFirmaPIUResponsableRespRegionalDotPrimerNombre;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotSegundoNombre() {
        return this.dSFirmaPIUResponsableRespRegionalDotSegundoNombre;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotSegundoNombre(String dSFirmaPIUResponsableRespRegionalDotSegundoNombre) {
        this.dSFirmaPIUResponsableRespRegionalDotSegundoNombre = dSFirmaPIUResponsableRespRegionalDotSegundoNombre;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotPrimerApellido() {
        return this.dSFirmaPIUResponsableRespRegionalDotPrimerApellido;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotPrimerApellido(String dSFirmaPIUResponsableRespRegionalDotPrimerApellido) {
        this.dSFirmaPIUResponsableRespRegionalDotPrimerApellido = dSFirmaPIUResponsableRespRegionalDotPrimerApellido;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotSegundoApellido() {
        return this.dSFirmaPIUResponsableRespRegionalDotSegundoApellido;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotSegundoApellido(String dSFirmaPIUResponsableRespRegionalDotSegundoApellido) {
        this.dSFirmaPIUResponsableRespRegionalDotSegundoApellido = dSFirmaPIUResponsableRespRegionalDotSegundoApellido;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion() {
        return this.dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion(String dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion) {
        this.dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion = dSFirmaPIUResponsableRespRegionalDotSucursalDotDescripcion;
    }

    @JsonIgnore
    public String getDSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion() {
        return this.dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion;
    }
    
    public void setDSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion(String dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion) {
        this.dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion = dSFirmaPIUResponsableRespRegionalDotSucursalDotRegionalDotDescripcion;
    }
}
