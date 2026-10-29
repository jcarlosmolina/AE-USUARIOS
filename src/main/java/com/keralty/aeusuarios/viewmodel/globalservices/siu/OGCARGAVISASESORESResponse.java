package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class OGCARGAVISASESORESResponse extends ServiceResponse {

    @JsonProperty("oaprocesados")
    private Long oGCARGAVISASESORESoaProcesados;

    @JsonProperty("oaerrores")
    private Long oGCARGAVISASESORESoaErrores;

    @JsonProperty("oaresultado")
    private String oGCARGAVISASESORESoaResultado;

    public OGCARGAVISASESORESResponse() {
        super();
    }

    @JsonIgnore
    public Long getOGCARGAVISASESORESoaProcesados() {
        return this.oGCARGAVISASESORESoaProcesados;
    }

    public void setOGCARGAVISASESORESoaProcesados(Long oGCARGAVISASESORESoaProcesados) {
        this.oGCARGAVISASESORESoaProcesados = oGCARGAVISASESORESoaProcesados;
    }

    @JsonIgnore
    public Long getOGCARGAVISASESORESoaErrores() {
        return this.oGCARGAVISASESORESoaErrores;
    }

    public void setOGCARGAVISASESORESoaErrores(Long oGCARGAVISASESORESoaErrores) {
        this.oGCARGAVISASESORESoaErrores = oGCARGAVISASESORESoaErrores;
    }

    @JsonIgnore
    public String getOGCARGAVISASESORESoaResultado() {
        return this.oGCARGAVISASESORESoaResultado;
    }

    public void setOGCARGAVISASESORESoaResultado(String oGCARGAVISASESORESoaResultado) {
        this.oGCARGAVISASESORESoaResultado = oGCARGAVISASESORESoaResultado;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("oGCARGAVISASESORESoaProcesados", oGCARGAVISASESORESoaProcesados);
        outArgs.put("oGCARGAVISASESORESoaErrores", oGCARGAVISASESORESoaErrores);
        outArgs.put("oGCARGAVISASESORESoaResultado", oGCARGAVISASESORESoaResultado);
        return outArgs;
    }
}
