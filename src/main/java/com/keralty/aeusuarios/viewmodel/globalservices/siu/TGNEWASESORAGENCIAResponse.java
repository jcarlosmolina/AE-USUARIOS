package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class TGNEWASESORAGENCIAResponse extends ServiceResponse {

    @JsonProperty("oafuncionario")
    private FuncionarioOid tGNEWASESORAGENCIAoaFuncionario;
    
    @JsonIgnore
    private Funcionario tGNEWASESORAGENCIAoaFuncionarioInstance;

    public TGNEWASESORAGENCIAResponse() {
        super();
    }

    @JsonIgnore
    public FuncionarioOid getTGNEWASESORAGENCIAoaFuncionario() {
        return this.tGNEWASESORAGENCIAoaFuncionario;
    }

    public void setTGNEWASESORAGENCIAoaFuncionario(FuncionarioOid tGNEWASESORAGENCIAoaFuncionario) {
        this.tGNEWASESORAGENCIAoaFuncionario = tGNEWASESORAGENCIAoaFuncionario;
    }
    @JsonIgnore
    public Funcionario getTGNEWASESORAGENCIAoaFuncionarioInstance() {
        return this.tGNEWASESORAGENCIAoaFuncionarioInstance;
    }
    
    public void setTGNEWASESORAGENCIAoaFuncionarioInstance(Funcionario tGNEWASESORAGENCIAoaFuncionario) {
        if (tGNEWASESORAGENCIAoaFuncionario != null && !tGNEWASESORAGENCIAoaFuncionario.isNull()) {
            this.tGNEWASESORAGENCIAoaFuncionario = tGNEWASESORAGENCIAoaFuncionario.getOid();
            this.tGNEWASESORAGENCIAoaFuncionarioInstance = tGNEWASESORAGENCIAoaFuncionario;
        } else {
            this.tGNEWASESORAGENCIAoaFuncionario = null;
            this.tGNEWASESORAGENCIAoaFuncionarioInstance = null;
        }
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("tGNEWASESORAGENCIAoaFuncionario", tGNEWASESORAGENCIAoaFuncionario);
        return outArgs;
    }
}
