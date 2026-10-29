package com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogHistoricoPlanesConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;

public class TNEWRequest {

    @JsonProperty("pt_p_agrasesor_oid")
    private AsesorOid logHistoricoPlanesTNEWptpagrAsesor;
    
    @JsonIgnore
    private Asesor logHistoricoPlanesTNEWptpagrAsesorInstance;

    @JsonProperty("pt_p_atrproducto")
    private String logHistoricoPlanesTNEWptpatrProducto;

    @JsonProperty("pt_p_atrplan")
    private String logHistoricoPlanesTNEWptpatrPlan;

    @JsonProperty("pt_p_atraccion")
    private String logHistoricoPlanesTNEWptpatrAccion;

    public void checkArguments() throws NotNullArgumentException {
        checkLogHistoricoPlanesTNEWptpagrAsesor();
        checkLogHistoricoPlanesTNEWptpatrProducto();
        checkLogHistoricoPlanesTNEWptpatrPlan();
        checkLogHistoricoPlanesTNEWptpatrAccion();
    }

    @JsonIgnore
    public AsesorOid getLogHistoricoPlanesTNEWptpagrAsesor() {
        return this.logHistoricoPlanesTNEWptpagrAsesor;
    }
    
    public void setLogHistoricoPlanesTNEWptpagrAsesor(AsesorOid logHistoricoPlanesTNEWptpagrAsesor) {
        this.logHistoricoPlanesTNEWptpagrAsesor = logHistoricoPlanesTNEWptpagrAsesor;
    }

    @JsonIgnore
    public Asesor getLogHistoricoPlanesTNEWptpagrAsesorInstance() {
        return this.logHistoricoPlanesTNEWptpagrAsesorInstance;
    }
    
    public void setLogHistoricoPlanesTNEWptpagrAsesorInstance(Asesor logHistoricoPlanesTNEWptpagrAsesor) {
        this.logHistoricoPlanesTNEWptpagrAsesorInstance = logHistoricoPlanesTNEWptpagrAsesor;
        this.logHistoricoPlanesTNEWptpagrAsesor = logHistoricoPlanesTNEWptpagrAsesor != null ? logHistoricoPlanesTNEWptpagrAsesor.getOid() : null;
    }

    private void checkLogHistoricoPlanesTNEWptpagrAsesor() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanesTNEWptpagrAsesorInstance() == null || this.getLogHistoricoPlanesTNEWptpagrAsesorInstance().isNull()) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_TNEW, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_TNEW_LOGHISTORICOPLANESTNEWPTPAGRASESOR, LogHistoricoPlanesConstants.SERV_ALIAS_TNEW, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_TNEW_LOGHISTORICOPLANESTNEWPTPAGRASESOR);
        }
    }

    @JsonIgnore
    public String getLogHistoricoPlanesTNEWptpatrProducto() {
        return this.logHistoricoPlanesTNEWptpatrProducto;
    }
    
    public void setLogHistoricoPlanesTNEWptpatrProducto(String logHistoricoPlanesTNEWptpatrProducto) {
        this.logHistoricoPlanesTNEWptpatrProducto = logHistoricoPlanesTNEWptpatrProducto;
    }

    private void checkLogHistoricoPlanesTNEWptpatrProducto() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanesTNEWptpatrProducto() == null) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_TNEW, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_TNEW_LOGHISTORICOPLANESTNEWPTPATRPRODUCTO, LogHistoricoPlanesConstants.SERV_ALIAS_TNEW, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_TNEW_LOGHISTORICOPLANESTNEWPTPATRPRODUCTO);
        }
    }

    @JsonIgnore
    public String getLogHistoricoPlanesTNEWptpatrPlan() {
        return this.logHistoricoPlanesTNEWptpatrPlan;
    }
    
    public void setLogHistoricoPlanesTNEWptpatrPlan(String logHistoricoPlanesTNEWptpatrPlan) {
        this.logHistoricoPlanesTNEWptpatrPlan = logHistoricoPlanesTNEWptpatrPlan;
    }

    private void checkLogHistoricoPlanesTNEWptpatrPlan() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanesTNEWptpatrPlan() == null) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_TNEW, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_TNEW_LOGHISTORICOPLANESTNEWPTPATRPLAN, LogHistoricoPlanesConstants.SERV_ALIAS_TNEW, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_TNEW_LOGHISTORICOPLANESTNEWPTPATRPLAN);
        }
    }

    @JsonIgnore
    public String getLogHistoricoPlanesTNEWptpatrAccion() {
        return this.logHistoricoPlanesTNEWptpatrAccion;
    }
    
    public void setLogHistoricoPlanesTNEWptpatrAccion(String logHistoricoPlanesTNEWptpatrAccion) {
        this.logHistoricoPlanesTNEWptpatrAccion = logHistoricoPlanesTNEWptpatrAccion;
    }

    private void checkLogHistoricoPlanesTNEWptpatrAccion() throws NotNullArgumentException {
        if(this.getLogHistoricoPlanesTNEWptpatrAccion() == null) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_TNEW, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_TNEW_LOGHISTORICOPLANESTNEWPTPATRACCION, LogHistoricoPlanesConstants.SERV_ALIAS_TNEW, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_TNEW_LOGHISTORICOPLANESTNEWPTPATRACCION);
        }
    }
}
