package com.keralty.aeusuarios.viewmodel.loghistoricoplanes.ds;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
public class DSLogHistoricoPlanes {

    @JsonProperty("accion")
    private String dSLogHistoricoPlanesAccion;

    @JsonProperty("producto")
    private String dSLogHistoricoPlanesProducto;

    @JsonProperty("plan")
    private String dSLogHistoricoPlanesPlan;

    @JsonProperty("fechahora")
    private Timestamp dSLogHistoricoPlanesFechaHora;

    @JsonProperty("loginfuncionario")
    private String dSLogHistoricoPlanesLoginFuncionario;

    public DSLogHistoricoPlanes() {
    
    }

    public DSLogHistoricoPlanes(LogHistoricoPlanes instance) {
        if (instance != null) {
            this.dSLogHistoricoPlanesAccion = instance.getLogHistoricoPlanesAccion();
            this.dSLogHistoricoPlanesProducto = instance.getLogHistoricoPlanesProducto();
            this.dSLogHistoricoPlanesPlan = instance.getLogHistoricoPlanesPlan();
            this.dSLogHistoricoPlanesFechaHora = instance.getLogHistoricoPlanesFechaHora();
            this.dSLogHistoricoPlanesLoginFuncionario = instance.getLogHistoricoPlanesLoginFuncionario();
        }
    }

    @JsonIgnore
    public String getDSLogHistoricoPlanesAccion() {
        return this.dSLogHistoricoPlanesAccion;
    }
    
    public void setDSLogHistoricoPlanesAccion(String dSLogHistoricoPlanesAccion) {
        this.dSLogHistoricoPlanesAccion = dSLogHistoricoPlanesAccion;
    }

    @JsonIgnore
    public String getDSLogHistoricoPlanesProducto() {
        return this.dSLogHistoricoPlanesProducto;
    }
    
    public void setDSLogHistoricoPlanesProducto(String dSLogHistoricoPlanesProducto) {
        this.dSLogHistoricoPlanesProducto = dSLogHistoricoPlanesProducto;
    }

    @JsonIgnore
    public String getDSLogHistoricoPlanesPlan() {
        return this.dSLogHistoricoPlanesPlan;
    }
    
    public void setDSLogHistoricoPlanesPlan(String dSLogHistoricoPlanesPlan) {
        this.dSLogHistoricoPlanesPlan = dSLogHistoricoPlanesPlan;
    }

    @JsonIgnore
    public Timestamp getDSLogHistoricoPlanesFechaHora() {
        return this.dSLogHistoricoPlanesFechaHora;
    }
    
    public void setDSLogHistoricoPlanesFechaHora(Timestamp dSLogHistoricoPlanesFechaHora) {
        this.dSLogHistoricoPlanesFechaHora = dSLogHistoricoPlanesFechaHora;
    }

    @JsonIgnore
    public String getDSLogHistoricoPlanesLoginFuncionario() {
        return this.dSLogHistoricoPlanesLoginFuncionario;
    }
    
    public void setDSLogHistoricoPlanesLoginFuncionario(String dSLogHistoricoPlanesLoginFuncionario) {
        this.dSLogHistoricoPlanesLoginFuncionario = dSLogHistoricoPlanesLoginFuncionario;
    }
}
