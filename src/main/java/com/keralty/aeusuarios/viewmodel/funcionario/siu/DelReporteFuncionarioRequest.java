package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.persistence.ReportesProcAlm;

public class DelReporteFuncionarioRequest {

    @JsonProperty("p_thisfuncionario_oid")
    private FuncionarioOid funcionarioDelReporteFuncionariopthisFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioDelReporteFuncionariopthisFuncionarioInstance;

    @JsonProperty("p_evcreportesprocalm_json")
    private String funcionarioDelReporteFuncionariopevcReportesProcAlm;
    
    @JsonIgnore
    private ReportesProcAlm funcionarioDelReporteFuncionariopevcReportesProcAlmInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkFuncionarioDelReporteFuncionariopthisFuncionario();
        checkFuncionarioDelReporteFuncionariopevcReportesProcAlm();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioDelReporteFuncionariopthisFuncionario() {
        return this.funcionarioDelReporteFuncionariopthisFuncionario;
    }
    
    public void setFuncionarioDelReporteFuncionariopthisFuncionario(FuncionarioOid funcionarioDelReporteFuncionariopthisFuncionario) {
        this.funcionarioDelReporteFuncionariopthisFuncionario = funcionarioDelReporteFuncionariopthisFuncionario;
    }

    @JsonIgnore
    public Funcionario getFuncionarioDelReporteFuncionariopthisFuncionarioInstance() {
        return this.funcionarioDelReporteFuncionariopthisFuncionarioInstance;
    }
    
    public void setFuncionarioDelReporteFuncionariopthisFuncionarioInstance(Funcionario funcionarioDelReporteFuncionariopthisFuncionario) {
        this.funcionarioDelReporteFuncionariopthisFuncionarioInstance = funcionarioDelReporteFuncionariopthisFuncionario;
        this.funcionarioDelReporteFuncionariopthisFuncionario = funcionarioDelReporteFuncionariopthisFuncionario != null ? funcionarioDelReporteFuncionariopthisFuncionario.getOid() : null;
    }

    private void checkFuncionarioDelReporteFuncionariopthisFuncionario() throws NotNullArgumentException {
        if(this.getFuncionarioDelReporteFuncionariopthisFuncionarioInstance() == null || this.getFuncionarioDelReporteFuncionariopthisFuncionarioInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELREPORTEFUNCIONARIO_FUNCIONARIODELREPORTEFUNCIONARIOPTHISFUNCIONARIO, FuncionarioConstants.SERV_ALIAS_DELREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELREPORTEFUNCIONARIO_FUNCIONARIODELREPORTEFUNCIONARIOPTHISFUNCIONARIO);
        }
    }

    @JsonIgnore
    public String getFuncionarioDelReporteFuncionariopevcReportesProcAlm() {
        return this.funcionarioDelReporteFuncionariopevcReportesProcAlm;
    }
    
    public void setFuncionarioDelReporteFuncionariopevcReportesProcAlm(String funcionarioDelReporteFuncionariopevcReportesProcAlm) {
        this.funcionarioDelReporteFuncionariopevcReportesProcAlm = funcionarioDelReporteFuncionariopevcReportesProcAlm;
    }

    @JsonIgnore
    public ReportesProcAlm getFuncionarioDelReporteFuncionariopevcReportesProcAlmInstance() {
        return this.funcionarioDelReporteFuncionariopevcReportesProcAlmInstance;
    }
    
    public void setFuncionarioDelReporteFuncionariopevcReportesProcAlmInstance(ReportesProcAlm funcionarioDelReporteFuncionariopevcReportesProcAlm) {
        this.funcionarioDelReporteFuncionariopevcReportesProcAlmInstance = funcionarioDelReporteFuncionariopevcReportesProcAlm;
        this.funcionarioDelReporteFuncionariopevcReportesProcAlm = funcionarioDelReporteFuncionariopevcReportesProcAlm != null ? funcionarioDelReporteFuncionariopevcReportesProcAlm.getOid().toJson() : "";
    }

    private void checkFuncionarioDelReporteFuncionariopevcReportesProcAlm() throws NotNullArgumentException {
        if(this.getFuncionarioDelReporteFuncionariopevcReportesProcAlmInstance() == null || this.getFuncionarioDelReporteFuncionariopevcReportesProcAlmInstance().isNull()) {
            throw new NotNullArgumentException(FuncionarioConstants.SERV_ID_DELREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ID, FuncionarioConstants.ARG_ID_DELREPORTEFUNCIONARIO_FUNCIONARIODELREPORTEFUNCIONARIOPEVCREPORTESPROCALM, FuncionarioConstants.SERV_ALIAS_DELREPORTEFUNCIONARIO, FuncionarioConstants.CLASS_ALIAS, FuncionarioConstants.ARG_ALIAS_DELREPORTEFUNCIONARIO_FUNCIONARIODELREPORTEFUNCIONARIOPEVCREPORTESPROCALM);
        }
    }
}
