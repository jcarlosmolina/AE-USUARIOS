package com.keralty.aeusuarios.viewmodel.respregional.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.RespRegionalConstants;
import com.keralty.aeusuarios.persistence.oid.RegionalOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.RespRegional;

public class DelRegionalResponsableRequest {

    @JsonProperty("p_thisrespregional_oid")
    private RespRegionalOid respRegionalDelRegionalResponsablepthisRespRegional;
    
    @JsonIgnore
    private RespRegional respRegionalDelRegionalResponsablepthisRespRegionalInstance;

    @JsonProperty("p_evcregional_oid")
    private RegionalOid respRegionalDelRegionalResponsablepevcRegional;
    
    @JsonIgnore
    private Regional respRegionalDelRegionalResponsablepevcRegionalInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkRespRegionalDelRegionalResponsablepthisRespRegional();
        checkRespRegionalDelRegionalResponsablepevcRegional();
    }

    @JsonIgnore
    public RespRegionalOid getRespRegionalDelRegionalResponsablepthisRespRegional() {
        return this.respRegionalDelRegionalResponsablepthisRespRegional;
    }
    
    public void setRespRegionalDelRegionalResponsablepthisRespRegional(RespRegionalOid respRegionalDelRegionalResponsablepthisRespRegional) {
        this.respRegionalDelRegionalResponsablepthisRespRegional = respRegionalDelRegionalResponsablepthisRespRegional;
    }

    @JsonIgnore
    public RespRegional getRespRegionalDelRegionalResponsablepthisRespRegionalInstance() {
        return this.respRegionalDelRegionalResponsablepthisRespRegionalInstance;
    }
    
    public void setRespRegionalDelRegionalResponsablepthisRespRegionalInstance(RespRegional respRegionalDelRegionalResponsablepthisRespRegional) {
        this.respRegionalDelRegionalResponsablepthisRespRegionalInstance = respRegionalDelRegionalResponsablepthisRespRegional;
        this.respRegionalDelRegionalResponsablepthisRespRegional = respRegionalDelRegionalResponsablepthisRespRegional != null ? respRegionalDelRegionalResponsablepthisRespRegional.getOid() : null;
    }

    private void checkRespRegionalDelRegionalResponsablepthisRespRegional() throws NotNullArgumentException {
        if(this.getRespRegionalDelRegionalResponsablepthisRespRegionalInstance() == null || this.getRespRegionalDelRegionalResponsablepthisRespRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_DELREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_DELREGIONALRESPONSABLE_RESPREGIONALDELREGIONALRESPONSABLEPTHISRESPREGIONAL, RespRegionalConstants.SERV_ALIAS_DELREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_DELREGIONALRESPONSABLE_RESPREGIONALDELREGIONALRESPONSABLEPTHISRESPREGIONAL);
        }
    }

    @JsonIgnore
    public RegionalOid getRespRegionalDelRegionalResponsablepevcRegional() {
        return this.respRegionalDelRegionalResponsablepevcRegional;
    }
    
    public void setRespRegionalDelRegionalResponsablepevcRegional(RegionalOid respRegionalDelRegionalResponsablepevcRegional) {
        this.respRegionalDelRegionalResponsablepevcRegional = respRegionalDelRegionalResponsablepevcRegional;
    }

    @JsonIgnore
    public Regional getRespRegionalDelRegionalResponsablepevcRegionalInstance() {
        return this.respRegionalDelRegionalResponsablepevcRegionalInstance;
    }
    
    public void setRespRegionalDelRegionalResponsablepevcRegionalInstance(Regional respRegionalDelRegionalResponsablepevcRegional) {
        this.respRegionalDelRegionalResponsablepevcRegionalInstance = respRegionalDelRegionalResponsablepevcRegional;
        this.respRegionalDelRegionalResponsablepevcRegional = respRegionalDelRegionalResponsablepevcRegional != null ? respRegionalDelRegionalResponsablepevcRegional.getOid() : null;
    }

    private void checkRespRegionalDelRegionalResponsablepevcRegional() throws NotNullArgumentException {
        if(this.getRespRegionalDelRegionalResponsablepevcRegionalInstance() == null || this.getRespRegionalDelRegionalResponsablepevcRegionalInstance().isNull()) {
            throw new NotNullArgumentException(RespRegionalConstants.SERV_ID_DELREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ID, RespRegionalConstants.ARG_ID_DELREGIONALRESPONSABLE_RESPREGIONALDELREGIONALRESPONSABLEPEVCREGIONAL, RespRegionalConstants.SERV_ALIAS_DELREGIONALRESPONSABLE, RespRegionalConstants.CLASS_ALIAS, RespRegionalConstants.ARG_ALIAS_DELREGIONALRESPONSABLE_RESPREGIONALDELREGIONALRESPONSABLEPEVCREGIONAL);
        }
    }
}
