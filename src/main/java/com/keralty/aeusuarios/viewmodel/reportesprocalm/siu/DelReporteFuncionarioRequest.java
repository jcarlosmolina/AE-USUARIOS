package com.keralty.aeusuarios.viewmodel.reportesprocalm.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.ReportesProcAlmConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;

public class DelReporteFuncionarioRequest {

    @JsonProperty("p_thisreportesprocalm_oid")
    private ReportesProcAlmOid reportesProcAlmDelReporteFuncionariopthisReportesProcAlm;
    
    @JsonIgnore
    private ReportesProcAlm reportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid reportesProcAlmDelReporteFuncionariopevcFuncionario;
    
    @JsonIgnore
    private Funcionario reportesProcAlmDelReporteFuncionariopevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkReportesProcAlmDelReporteFuncionariopthisReportesProcAlm();
        checkReportesProcAlmDelReporteFuncionariopevcFuncionario();
    }

    @JsonIgnore
    public ReportesProcAlmOid getReportesProcAlmDelReporteFuncionariopthisReportesProcAlm() {
        return this.reportesProcAlmDelReporteFuncionariopthisReportesProcAlm;
    }
    
    public void setReportesProcAlmDelReporteFuncionariopthisReportesProcAlm(ReportesProcAlmOid reportesProcAlmDelReporteFuncionariopthisReportesProcAlm) {
        this.reportesProcAlmDelReporteFuncionariopthisReportesProcAlm = reportesProcAlmDelReporteFuncionariopthisReportesProcAlm;
    }

    @JsonIgnore
    public ReportesProcAlm getReportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance() {
        return this.reportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance;
    }
    
    public void setReportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance(ReportesProcAlm reportesProcAlmDelReporteFuncionariopthisReportesProcAlm) {
        this.reportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance = reportesProcAlmDelReporteFuncionariopthisReportesProcAlm;
        this.reportesProcAlmDelReporteFuncionariopthisReportesProcAlm = reportesProcAlmDelReporteFuncionariopthisReportesProcAlm != null ? reportesProcAlmDelReporteFuncionariopthisReportesProcAlm.getOid() : null;
    }

    private void checkReportesProcAlmDelReporteFuncionariopthisReportesProcAlm() throws NotNullArgumentException {
        if(this.getReportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance() == null || this.getReportesProcAlmDelReporteFuncionariopthisReportesProcAlmInstance().isNull()) {
            throw new NotNullArgumentException(ReportesProcAlmConstants.SERV_ID_DELREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ID, ReportesProcAlmConstants.ARG_ID_DELREPORTEFUNCIONARIO_REPORTESPROCALMDELREPORTEFUNCIONARIOPTHISREPORTESPROCALM, ReportesProcAlmConstants.SERV_ALIAS_DELREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ALIAS, ReportesProcAlmConstants.ARG_ALIAS_DELREPORTEFUNCIONARIO_REPORTESPROCALMDELREPORTEFUNCIONARIOPTHISREPORTESPROCALM);
        }
    }

    @JsonIgnore
    public FuncionarioOid getReportesProcAlmDelReporteFuncionariopevcFuncionario() {
        return this.reportesProcAlmDelReporteFuncionariopevcFuncionario;
    }
    
    public void setReportesProcAlmDelReporteFuncionariopevcFuncionario(FuncionarioOid reportesProcAlmDelReporteFuncionariopevcFuncionario) {
        this.reportesProcAlmDelReporteFuncionariopevcFuncionario = reportesProcAlmDelReporteFuncionariopevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getReportesProcAlmDelReporteFuncionariopevcFuncionarioInstance() {
        return this.reportesProcAlmDelReporteFuncionariopevcFuncionarioInstance;
    }
    
    public void setReportesProcAlmDelReporteFuncionariopevcFuncionarioInstance(Funcionario reportesProcAlmDelReporteFuncionariopevcFuncionario) {
        this.reportesProcAlmDelReporteFuncionariopevcFuncionarioInstance = reportesProcAlmDelReporteFuncionariopevcFuncionario;
        this.reportesProcAlmDelReporteFuncionariopevcFuncionario = reportesProcAlmDelReporteFuncionariopevcFuncionario != null ? reportesProcAlmDelReporteFuncionariopevcFuncionario.getOid() : null;
    }

    private void checkReportesProcAlmDelReporteFuncionariopevcFuncionario() throws NotNullArgumentException {
        if(this.getReportesProcAlmDelReporteFuncionariopevcFuncionarioInstance() == null || this.getReportesProcAlmDelReporteFuncionariopevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(ReportesProcAlmConstants.SERV_ID_DELREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ID, ReportesProcAlmConstants.ARG_ID_DELREPORTEFUNCIONARIO_REPORTESPROCALMDELREPORTEFUNCIONARIOPEVCFUNCIONARIO, ReportesProcAlmConstants.SERV_ALIAS_DELREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ALIAS, ReportesProcAlmConstants.ARG_ALIAS_DELREPORTEFUNCIONARIO_REPORTESPROCALMDELREPORTEFUNCIONARIOPEVCFUNCIONARIO);
        }
    }
}
