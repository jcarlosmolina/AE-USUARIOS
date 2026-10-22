package com.keralty.aeusuarios.viewmodel.reportesprocalm.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.ReportesProcAlmConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.oid.ReportesProcAlmOid;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;

public class InsReporteFuncionarioRequest {

    @JsonProperty("p_thisreportesprocalm_oid")
    private ReportesProcAlmOid reportesProcAlmInsReporteFuncionariopthisReportesProcAlm;
    
    @JsonIgnore
    private ReportesProcAlm reportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance;

    @JsonProperty("p_evcfuncionario_oid")
    private FuncionarioOid reportesProcAlmInsReporteFuncionariopevcFuncionario;
    
    @JsonIgnore
    private Funcionario reportesProcAlmInsReporteFuncionariopevcFuncionarioInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkReportesProcAlmInsReporteFuncionariopthisReportesProcAlm();
        checkReportesProcAlmInsReporteFuncionariopevcFuncionario();
    }

    @JsonIgnore
    public ReportesProcAlmOid getReportesProcAlmInsReporteFuncionariopthisReportesProcAlm() {
        return this.reportesProcAlmInsReporteFuncionariopthisReportesProcAlm;
    }
    
    public void setReportesProcAlmInsReporteFuncionariopthisReportesProcAlm(ReportesProcAlmOid reportesProcAlmInsReporteFuncionariopthisReportesProcAlm) {
        this.reportesProcAlmInsReporteFuncionariopthisReportesProcAlm = reportesProcAlmInsReporteFuncionariopthisReportesProcAlm;
    }

    @JsonIgnore
    public ReportesProcAlm getReportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance() {
        return this.reportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance;
    }
    
    public void setReportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance(ReportesProcAlm reportesProcAlmInsReporteFuncionariopthisReportesProcAlm) {
        this.reportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance = reportesProcAlmInsReporteFuncionariopthisReportesProcAlm;
        this.reportesProcAlmInsReporteFuncionariopthisReportesProcAlm = reportesProcAlmInsReporteFuncionariopthisReportesProcAlm != null ? reportesProcAlmInsReporteFuncionariopthisReportesProcAlm.getOid() : null;
    }

    private void checkReportesProcAlmInsReporteFuncionariopthisReportesProcAlm() throws NotNullArgumentException {
        if(this.getReportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance() == null || this.getReportesProcAlmInsReporteFuncionariopthisReportesProcAlmInstance().isNull()) {
            throw new NotNullArgumentException(ReportesProcAlmConstants.SERV_ID_INSREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ID, ReportesProcAlmConstants.ARG_ID_INSREPORTEFUNCIONARIO_REPORTESPROCALMINSREPORTEFUNCIONARIOPTHISREPORTESPROCALM, ReportesProcAlmConstants.SERV_ALIAS_INSREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ALIAS, ReportesProcAlmConstants.ARG_ALIAS_INSREPORTEFUNCIONARIO_REPORTESPROCALMINSREPORTEFUNCIONARIOPTHISREPORTESPROCALM);
        }
    }

    @JsonIgnore
    public FuncionarioOid getReportesProcAlmInsReporteFuncionariopevcFuncionario() {
        return this.reportesProcAlmInsReporteFuncionariopevcFuncionario;
    }
    
    public void setReportesProcAlmInsReporteFuncionariopevcFuncionario(FuncionarioOid reportesProcAlmInsReporteFuncionariopevcFuncionario) {
        this.reportesProcAlmInsReporteFuncionariopevcFuncionario = reportesProcAlmInsReporteFuncionariopevcFuncionario;
    }

    @JsonIgnore
    public Funcionario getReportesProcAlmInsReporteFuncionariopevcFuncionarioInstance() {
        return this.reportesProcAlmInsReporteFuncionariopevcFuncionarioInstance;
    }
    
    public void setReportesProcAlmInsReporteFuncionariopevcFuncionarioInstance(Funcionario reportesProcAlmInsReporteFuncionariopevcFuncionario) {
        this.reportesProcAlmInsReporteFuncionariopevcFuncionarioInstance = reportesProcAlmInsReporteFuncionariopevcFuncionario;
        this.reportesProcAlmInsReporteFuncionariopevcFuncionario = reportesProcAlmInsReporteFuncionariopevcFuncionario != null ? reportesProcAlmInsReporteFuncionariopevcFuncionario.getOid() : null;
    }

    private void checkReportesProcAlmInsReporteFuncionariopevcFuncionario() throws NotNullArgumentException {
        if(this.getReportesProcAlmInsReporteFuncionariopevcFuncionarioInstance() == null || this.getReportesProcAlmInsReporteFuncionariopevcFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(ReportesProcAlmConstants.SERV_ID_INSREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ID, ReportesProcAlmConstants.ARG_ID_INSREPORTEFUNCIONARIO_REPORTESPROCALMINSREPORTEFUNCIONARIOPEVCFUNCIONARIO, ReportesProcAlmConstants.SERV_ALIAS_INSREPORTEFUNCIONARIO, ReportesProcAlmConstants.CLASS_ALIAS, ReportesProcAlmConstants.ARG_ALIAS_INSREPORTEFUNCIONARIO_REPORTESPROCALMINSREPORTEFUNCIONARIOPEVCFUNCIONARIO);
        }
    }
}
