package com.keralty.aeusuarios.viewmodel.funcionario.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TNEWASESORMANUALResponse extends ServiceResponse {


    @JsonProperty("oafuncionario")
    private FuncionarioOid funcionarioTNEWASESORMANUALoaFuncionario;
    
    @JsonIgnore
    private Funcionario funcionarioTNEWASESORMANUALoaFuncionarioInstance;

    public TNEWASESORMANUALResponse() {
        super();
    }

    @JsonIgnore
    public FuncionarioOid getFuncionarioTNEWASESORMANUALoaFuncionario() {
        return this.funcionarioTNEWASESORMANUALoaFuncionario;
    }
    
    public void setFuncionarioTNEWASESORMANUALoaFuncionario(FuncionarioOid funcionarioTNEWASESORMANUALoaFuncionario) {
        this.funcionarioTNEWASESORMANUALoaFuncionario = funcionarioTNEWASESORMANUALoaFuncionario;
    }
    @JsonIgnore
    public Funcionario getFuncionarioTNEWASESORMANUALoaFuncionarioInstance() {
        return this.funcionarioTNEWASESORMANUALoaFuncionarioInstance;
    }
    
    public void setFuncionarioTNEWASESORMANUALoaFuncionarioInstance(Funcionario funcionarioTNEWASESORMANUALoaFuncionario) {
        if (funcionarioTNEWASESORMANUALoaFuncionario != null && !funcionarioTNEWASESORMANUALoaFuncionario.isNull()) {
            this.funcionarioTNEWASESORMANUALoaFuncionario = funcionarioTNEWASESORMANUALoaFuncionario.getOid();
            this.funcionarioTNEWASESORMANUALoaFuncionarioInstance = funcionarioTNEWASESORMANUALoaFuncionario;
        } else {
            this.funcionarioTNEWASESORMANUALoaFuncionario = null;
            this.funcionarioTNEWASESORMANUALoaFuncionarioInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("funcionarioTNEWASESORMANUALoaFuncionario", funcionarioTNEWASESORMANUALoaFuncionario);
        return outArgs;
    }
}
