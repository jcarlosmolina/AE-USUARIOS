package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class OGCARGAPLANASESORResponse extends ServiceResponse {

    @JsonProperty("oaprocesados")
    private Long oGCARGAPLANASESORoaProcesados;

    @JsonProperty("oaerrores")
    private Long oGCARGAPLANASESORoaErrores;

    @JsonProperty("oaresultado")
    private String oGCARGAPLANASESORoaResultado;

    public OGCARGAPLANASESORResponse() {
        super();
    }

    @JsonIgnore
    public Long getOGCARGAPLANASESORoaProcesados() {
        return this.oGCARGAPLANASESORoaProcesados;
    }

    public void setOGCARGAPLANASESORoaProcesados(Long oGCARGAPLANASESORoaProcesados) {
        this.oGCARGAPLANASESORoaProcesados = oGCARGAPLANASESORoaProcesados;
    }

    @JsonIgnore
    public Long getOGCARGAPLANASESORoaErrores() {
        return this.oGCARGAPLANASESORoaErrores;
    }

    public void setOGCARGAPLANASESORoaErrores(Long oGCARGAPLANASESORoaErrores) {
        this.oGCARGAPLANASESORoaErrores = oGCARGAPLANASESORoaErrores;
    }

    @JsonIgnore
    public String getOGCARGAPLANASESORoaResultado() {
        return this.oGCARGAPLANASESORoaResultado;
    }

    public void setOGCARGAPLANASESORoaResultado(String oGCARGAPLANASESORoaResultado) {
        this.oGCARGAPLANASESORoaResultado = oGCARGAPLANASESORoaResultado;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("oGCARGAPLANASESORoaProcesados", oGCARGAPLANASESORoaProcesados);
        outArgs.put("oGCARGAPLANASESORoaErrores", oGCARGAPLANASESORoaErrores);
        outArgs.put("oGCARGAPLANASESORoaResultado", oGCARGAPLANASESORoaResultado);
        return outArgs;
    }
}
