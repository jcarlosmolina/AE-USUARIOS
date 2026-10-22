package com.keralty.aeusuarios.viewmodel.regional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.RespRegional;

public class InsRegionalResponsableRequest {

    @JsonProperty("p_thisregional_oid")
    private RegionalOid regionalInsRegionalResponsablepthisRegional;
    
    @JsonIgnore
    private Regional regionalInsRegionalResponsablepthisRegionalInstance;

    @JsonProperty("p_evcrespregional_oid")
    private RespRegionalOid regionalInsRegionalResponsablepevcRespRegional;
    
    @JsonIgnore
    private RespRegional regionalInsRegionalResponsablepevcRespRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRegionalInsRegionalResponsablepthisRegional();
        checkRegionalInsRegionalResponsablepevcRespRegional();
    }

    @JsonIgnore
    public RegionalOid getRegionalInsRegionalResponsablepthisRegional() {
        return this.regionalInsRegionalResponsablepthisRegional;
    }
    
    public void setRegionalInsRegionalResponsablepthisRegional(RegionalOid regionalInsRegionalResponsablepthisRegional) {
        this.regionalInsRegionalResponsablepthisRegional = regionalInsRegionalResponsablepthisRegional;
    }

    @JsonIgnore
    public Regional getRegionalInsRegionalResponsablepthisRegionalInstance() {
        return this.regionalInsRegionalResponsablepthisRegionalInstance;
    }
    
    public void setRegionalInsRegionalResponsablepthisRegionalInstance(Regional regionalInsRegionalResponsablepthisRegional) {
        this.regionalInsRegionalResponsablepthisRegionalInstance = regionalInsRegionalResponsablepthisRegional;
        this.regionalInsRegionalResponsablepthisRegional = regionalInsRegionalResponsablepthisRegional != null ? regionalInsRegionalResponsablepthisRegional.getOid() : null;
    }

    private void checkRegionalInsRegionalResponsablepthisRegional() throws NotNullArgumentException {
        if(this.getRegionalInsRegionalResponsablepthisRegionalInstance() == null || this.getRegionalInsRegionalResponsablepthisRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_INSREGIONALRESPONSABLE, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_INSREGIONALRESPONSABLE_REGIONALINSREGIONALRESPONSABLEPTHISREGIONAL, RegionalConstants.SERV_ALIAS_INSREGIONALRESPONSABLE, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_INSREGIONALRESPONSABLE_REGIONALINSREGIONALRESPONSABLEPTHISREGIONAL);
        }
    }

    @JsonIgnore
    public RespRegionalOid getRegionalInsRegionalResponsablepevcRespRegional() {
        return this.regionalInsRegionalResponsablepevcRespRegional;
    }
    
    public void setRegionalInsRegionalResponsablepevcRespRegional(RespRegionalOid regionalInsRegionalResponsablepevcRespRegional) {
        this.regionalInsRegionalResponsablepevcRespRegional = regionalInsRegionalResponsablepevcRespRegional;
    }

    @JsonIgnore
    public RespRegional getRegionalInsRegionalResponsablepevcRespRegionalInstance() {
        return this.regionalInsRegionalResponsablepevcRespRegionalInstance;
    }
    
    public void setRegionalInsRegionalResponsablepevcRespRegionalInstance(RespRegional regionalInsRegionalResponsablepevcRespRegional) {
        this.regionalInsRegionalResponsablepevcRespRegionalInstance = regionalInsRegionalResponsablepevcRespRegional;
        this.regionalInsRegionalResponsablepevcRespRegional = regionalInsRegionalResponsablepevcRespRegional != null ? regionalInsRegionalResponsablepevcRespRegional.getOid() : null;
    }

    private void checkRegionalInsRegionalResponsablepevcRespRegional() throws NotNullArgumentException {
        if(this.getRegionalInsRegionalResponsablepevcRespRegionalInstance() == null || this.getRegionalInsRegionalResponsablepevcRespRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RegionalConstants.SERV_ID_INSREGIONALRESPONSABLE, RegionalConstants.CLASS_ID, RegionalConstants.ARG_ID_INSREGIONALRESPONSABLE_REGIONALINSREGIONALRESPONSABLEPEVCRESPREGIONAL, RegionalConstants.SERV_ALIAS_INSREGIONALRESPONSABLE, RegionalConstants.CLASS_ALIAS, RegionalConstants.ARG_ALIAS_INSREGIONALRESPONSABLE_REGIONALINSREGIONALRESPONSABLEPEVCRESPREGIONAL);
        }
    }
}
