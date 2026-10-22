package com.keralty.aeusuarios.viewmodel.solicitud.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import java.util.HashMap;
import java.util.Map;

public class DummyDevolverErroresWSResponse extends ServiceResponse {

    @JsonProperty("pserroresws")
    private String solicituddummyDevolverErroresWSpsErroresWS;

    public DummyDevolverErroresWSResponse() {
        super();
    }

    @JsonIgnore
    public String getSolicituddummyDevolverErroresWSpsErroresWS() {
        return this.solicituddummyDevolverErroresWSpsErroresWS;
    }
    
    public void setSolicituddummyDevolverErroresWSpsErroresWS(String solicituddummyDevolverErroresWSpsErroresWS) {
        this.solicituddummyDevolverErroresWSpsErroresWS = solicituddummyDevolverErroresWSpsErroresWS;
    }

    @Override
    public Map<String, Object> buildOutArgs() {
        Map<String, Object> outArgs = new HashMap<>();
        outArgs.put("solicituddummyDevolverErroresWSpsErroresWS", solicituddummyDevolverErroresWSpsErroresWS);
        return outArgs;
    }
}
