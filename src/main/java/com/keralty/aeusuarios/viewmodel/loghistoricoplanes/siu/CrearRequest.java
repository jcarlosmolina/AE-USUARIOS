package com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogHistoricoPlanesConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class CrearRequest {

    @JsonProperty("p_agrasesor_oid")
    private AsesorOid logHistoricoPlanescrearpagrAsesor;
    
    @JsonIgnore
    private Asesor logHistoricoPlanescrearpagrAsesorInstance;

    @JsonProperty("p_atrloginfuncionario")
    private String logHistoricoPlanescrearpatrLoginFuncionario;

    @JsonProperty("p_atrproducto")
    private String logHistoricoPlanescrearpatrProducto;

    @JsonProperty("p_atrplan")
    private String logHistoricoPlanescrearpatrPlan;

    @JsonProperty("p_atraccion")
    private String logHistoricoPlanescrearpatrAccion;

    public void checkArguments() throws NotNullArgumentException {
        checkLogHistoricoPlanescrearpagrAsesor();
        checkLogHistoricoPlanescrearpatrLoginFuncionario();
        checkLogHistoricoPlanescrearpatrProducto();
        checkLogHistoricoPlanescrearpatrPlan();
        checkLogHistoricoPlanescrearpatrAccion();
    }

    @JsonIgnore
    public AsesorOid getLogHistoricoPlanescrearpagrAsesor() {
        return this.logHistoricoPlanescrearpagrAsesor;
    }
    
    public void setLogHistoricoPlanescrearpagrAsesor(AsesorOid logHistoricoPlanescrearpagrAsesor) {
        this.logHistoricoPlanescrearpagrAsesor = logHistoricoPlanescrearpagrAsesor;
    }

    @JsonIgnore
    public Asesor getLogHistoricoPlanescrearpagrAsesorInstance() {
        return this.logHistoricoPlanescrearpagrAsesorInstance;
    }
    
    public void setLogHistoricoPlanescrearpagrAsesorInstance(Asesor logHistoricoPlanescrearpagrAsesor) {
        this.logHistoricoPlanescrearpagrAsesorInstance = logHistoricoPlanescrearpagrAsesor;
        this.logHistoricoPlanescrearpagrAsesor = logHistoricoPlanescrearpagrAsesor != null ? logHistoricoPlanescrearpagrAsesor.getOid() : null;
    }

    private void checkLogHistoricoPlanescrearpagrAsesor() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanescrearpagrAsesorInstance() == null || this.getLogHistoricoPlanescrearpagrAsesorInstance().isNull()) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_CREAR, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_CREAR_LOGHISTORICOPLANESCREARPAGRASESOR, LogHistoricoPlanesConstants.SERV_ALIAS_CREAR, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_CREAR_LOGHISTORICOPLANESCREARPAGRASESOR);
        }
    }

    @JsonIgnore
    public String getLogHistoricoPlanescrearpatrLoginFuncionario() {
        return this.logHistoricoPlanescrearpatrLoginFuncionario;
    }
    
    public void setLogHistoricoPlanescrearpatrLoginFuncionario(String logHistoricoPlanescrearpatrLoginFuncionario) {
        this.logHistoricoPlanescrearpatrLoginFuncionario = logHistoricoPlanescrearpatrLoginFuncionario;
    }

    private void checkLogHistoricoPlanescrearpatrLoginFuncionario() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanescrearpatrLoginFuncionario() == null) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_CREAR, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_CREAR_LOGHISTORICOPLANESCREARPATRLOGINFUNCIONARIO, LogHistoricoPlanesConstants.SERV_ALIAS_CREAR, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_CREAR_LOGHISTORICOPLANESCREARPATRLOGINFUNCIONARIO);
        }
    }

    @JsonIgnore
    public String getLogHistoricoPlanescrearpatrProducto() {
        return this.logHistoricoPlanescrearpatrProducto;
    }
    
    public void setLogHistoricoPlanescrearpatrProducto(String logHistoricoPlanescrearpatrProducto) {
        this.logHistoricoPlanescrearpatrProducto = logHistoricoPlanescrearpatrProducto;
    }

    private void checkLogHistoricoPlanescrearpatrProducto() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanescrearpatrProducto() == null) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_CREAR, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_CREAR_LOGHISTORICOPLANESCREARPATRPRODUCTO, LogHistoricoPlanesConstants.SERV_ALIAS_CREAR, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_CREAR_LOGHISTORICOPLANESCREARPATRPRODUCTO);
        }
    }

    @JsonIgnore
    public String getLogHistoricoPlanescrearpatrPlan() {
        return this.logHistoricoPlanescrearpatrPlan;
    }
    
    public void setLogHistoricoPlanescrearpatrPlan(String logHistoricoPlanescrearpatrPlan) {
        this.logHistoricoPlanescrearpatrPlan = logHistoricoPlanescrearpatrPlan;
    }

    private void checkLogHistoricoPlanescrearpatrPlan() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanescrearpatrPlan() == null) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_CREAR, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_CREAR_LOGHISTORICOPLANESCREARPATRPLAN, LogHistoricoPlanesConstants.SERV_ALIAS_CREAR, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_CREAR_LOGHISTORICOPLANESCREARPATRPLAN);
        }
    }

    @JsonIgnore
    public String getLogHistoricoPlanescrearpatrAccion() {
        return this.logHistoricoPlanescrearpatrAccion;
    }
    
    public void setLogHistoricoPlanescrearpatrAccion(String logHistoricoPlanescrearpatrAccion) {
        this.logHistoricoPlanescrearpatrAccion = logHistoricoPlanescrearpatrAccion;
    }

    private void checkLogHistoricoPlanescrearpatrAccion() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanescrearpatrAccion() == null) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_CREAR, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_CREAR_LOGHISTORICOPLANESCREARPATRACCION, LogHistoricoPlanesConstants.SERV_ALIAS_CREAR, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_CREAR_LOGHISTORICOPLANESCREARPATRACCION);
        }
    }
}
