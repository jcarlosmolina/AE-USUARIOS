package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;

public class InsReporteFuncionarioRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioInsReporteFuncionariopthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioInsReporteFuncionariopthisFuncionarioInstance;

    @JsonProperty("p_evcreportesprocalm_json")
    private String funcionarioInsReporteFuncionariopevcReportesProcAlm;
    
    @JsonIgnore
    private ReportesProcAlm funcionarioInsReporteFuncionariopevcReportesProcAlmInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioInsReporteFuncionariopthisFuncionario();
        checkFuncionarioInsReporteFuncionariopevcReportesProcAlm();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioInsReporteFuncionariopthisFuncionario() {
        return this.funcionarioInsReporteFuncionariopthisFuncionario;
    }
    
    public void setFuncionarioInsReporteFuncionariopthisFuncionario(FuncionarioOid funcionarioInsReporteFuncionariopthisFuncionario) {
        this.funcionarioInsReporteFuncionariopthisFuncionario = funcionarioInsReporteFuncionariopthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioInsReporteFuncionariopthisFuncionarioInstance() {
        return this.funcionarioInsReporteFuncionariopthisFuncionarioInstance;
    }
    
    public void setFuncionarioInsReporteFuncionariopthisFuncionarioInstance(Funcionario funcionarioInsReporteFuncionariopthisFuncionario) {
        this.funcionarioInsReporteFuncionariopthisFuncionarioInstance = funcionarioInsReporteFuncionariopthisFuncionario;
        this.funcionarioInsReporteFuncionariopthisFuncionario = funcionarioInsReporteFuncionariopthisFuncionario != null ? funcionarioInsReporteFuncionariopthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioInsReporteFuncionariopthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioInsReporteFuncionariopthisFuncionarioInstance() == null || this.getFuncionarioInsReporteFuncionariopthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_INSREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_INSREPORTEFUNCIONARIO_FUNCIONARIOINSREPORTEFUNCIONARIOPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_INSREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_INSREPORTEFUNCIONARIO_FUNCIONARIOINSREPORTEFUNCIONARIOPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public String getFuncionarioInsReporteFuncionariopevcReportesProcAlm() {
        return this.funcionarioInsReporteFuncionariopevcReportesProcAlm;
    }
    
    public void setFuncionarioInsReporteFuncionariopevcReportesProcAlm(String funcionarioInsReporteFuncionariopevcReportesProcAlm) {
        this.funcionarioInsReporteFuncionariopevcReportesProcAlm = funcionarioInsReporteFuncionariopevcReportesProcAlm;
    }

    @JsonIgnore
    public ReportesProcAlm getFuncionarioInsReporteFuncionariopevcReportesProcAlmInstance() {
        return this.funcionarioInsReporteFuncionariopevcReportesProcAlmInstance;
    }
    
    public void setFuncionarioInsReporteFuncionariopevcReportesProcAlmInstance(ReportesProcAlm funcionarioInsReporteFuncionariopevcReportesProcAlm) {
        this.funcionarioInsReporteFuncionariopevcReportesProcAlmInstance = funcionarioInsReporteFuncionariopevcReportesProcAlm;
        this.funcionarioInsReporteFuncionariopevcReportesProcAlm = funcionarioInsReporteFuncionariopevcReportesProcAlm != null ? funcionarioInsReporteFuncionariopevcReportesProcAlm.getOid().toJson() : "";
    }

    private void checkFuncionarioInsReporteFuncionariopevcReportesProcAlm() throws NotNullArgumentException {
        if(this.getFuncionarioInsReporteFuncionariopevcReportesProcAlmInstance() == null || this.getFuncionarioInsReporteFuncionariopevcReportesProcAlmInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_INSREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_INSREPORTEFUNCIONARIO_FUNCIONARIOINSREPORTEFUNCIONARIOPEVCREPORTESPROCALM, FuncionarioConstants.SERV_ALIAS_INSREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_INSREPORTEFUNCIONARIO_FUNCIONARIOINSREPORTEFUNCIONARIOPEVCREPORTESPROCALM);
        }
    }
}
