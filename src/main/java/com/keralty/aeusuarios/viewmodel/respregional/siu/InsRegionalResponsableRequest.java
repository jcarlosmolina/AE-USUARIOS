package com.keralty.aeusuarios.viewmodel.respregional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.RespRegional;

public class InsRegionalResponsableRequest {

    @JsonProperty("p_thisrespregional_oid")
    private RespRegionalOid respRegionalInsRegionalResponsablepthisRespRegional;
    
    @JsonIgnore
    private RespRegional respRegionalInsRegionalResponsablepthisRespRegionalInstance;

    @JsonProperty("p_evcregional_oid")
    private RegionalOid respRegionalInsRegionalResponsablepevcRegional;
    
    @JsonIgnore
    private Regional respRegionalInsRegionalResponsablepevcRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRespRegionalInsRegionalResponsablepthisRespRegional();
        checkRespRegionalInsRegionalResponsablepevcRegional();
    }

    @JsonIgnore
    public RespRegionalOid getRespRegionalInsRegionalResponsablepthisRespRegional() {
        return this.respRegionalInsRegionalResponsablepthisRespRegional;
    }
    
    public void setRespRegionalInsRegionalResponsablepthisRespRegional(RespRegionalOid respRegionalInsRegionalResponsablepthisRespRegional) {
        this.respRegionalInsRegionalResponsablepthisRespRegional = respRegionalInsRegionalResponsablepthisRespRegional;
    }

    @JsonIgnore
    public RespRegional getRespRegionalInsRegionalResponsablepthisRespRegionalInstance() {
        return this.respRegionalInsRegionalResponsablepthisRespRegionalInstance;
    }
    
    public void setRespRegionalInsRegionalResponsablepthisRespRegionalInstance(RespRegional respRegionalInsRegionalResponsablepthisRespRegional) {
        this.respRegionalInsRegionalResponsablepthisRespRegionalInstance = respRegionalInsRegionalResponsablepthisRespRegional;
        this.respRegionalInsRegionalResponsablepthisRespRegional = respRegionalInsRegionalResponsablepthisRespRegional != null ? respRegionalInsRegionalResponsablepthisRespRegional.getOid() : null;
    }

    private void checkRespRegionalInsRegionalResponsablepthisRespRegional() throws NotNullArgumentException {
        if(this.getRespRegionalInsRegionalResponsablepthisRespRegionalInstance() == null || this.getRespRegionalInsRegionalResponsablepthisRespRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_INSREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_INSREGIONALRESPONSABLE_RESPREGIONALINSREGIONALRESPONSABLEPTHISRESPREGIONAL, RespRegionalConstants.SERV_ALIAS_INSREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_INSREGIONALRESPONSABLE_RESPREGIONALINSREGIONALRESPONSABLEPTHISRESPREGIONAL);
        }
    }

    @JsonIgnore
    public RegionalOid getRespRegionalInsRegionalResponsablepevcRegional() {
        return this.respRegionalInsRegionalResponsablepevcRegional;
    }
    
    public void setRespRegionalInsRegionalResponsablepevcRegional(RegionalOid respRegionalInsRegionalResponsablepevcRegional) {
        this.respRegionalInsRegionalResponsablepevcRegional = respRegionalInsRegionalResponsablepevcRegional;
    }

    @JsonIgnore
    public Regional getRespRegionalInsRegionalResponsablepevcRegionalInstance() {
        return this.respRegionalInsRegionalResponsablepevcRegionalInstance;
    }
    
    public void setRespRegionalInsRegionalResponsablepevcRegionalInstance(Regional respRegionalInsRegionalResponsablepevcRegional) {
        this.respRegionalInsRegionalResponsablepevcRegionalInstance = respRegionalInsRegionalResponsablepevcRegional;
        this.respRegionalInsRegionalResponsablepevcRegional = respRegionalInsRegionalResponsablepevcRegional != null ? respRegionalInsRegionalResponsablepevcRegional.getOid() : null;
    }

    private void checkRespRegionalInsRegionalResponsablepevcRegional() throws NotNullArgumentException {
        if(this.getRespRegionalInsRegionalResponsablepevcRegionalInstance() == null || this.getRespRegionalInsRegionalResponsablepevcRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_INSREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_INSREGIONALRESPONSABLE_RESPREGIONALINSREGIONALRESPONSABLEPEVCREGIONAL, RespRegionalConstants.SERV_ALIAS_INSREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_INSREGIONALRESPONSABLE_RESPREGIONALINSREGIONALRESPONSABLEPEVCREGIONAL);
        }
    }
}
