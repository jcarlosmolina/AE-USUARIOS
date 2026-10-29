package com.keralty.aeusuarios.viewmodel.loghistoricoplanes.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.LogHistoricoPlanesConstants;
import com.keralty.aeusuarios.persistence.LogHistoricoPlanes;
import com.keralty.aeusuarios.persistence.oid.LogHistoricoPlanesOid;

public class EliminarRequest {

    @JsonProperty("p_thisloghistoricoplanes_oid")
    private LogHistoricoPlanesOid logHistoricoPlaneseliminarpthisLogHistoricoPlanes;
    
    @JsonIgnore
    private LogHistoricoPlanes logHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance;

    public void checkArguments() throws NotNullArgumentException {
        checkLogHistoricoPlaneseliminarpthisLogHistoricoPlanes();
    }

    @JsonIgnore
    public LogHistoricoPlanesOid getLogHistoricoPlaneseliminarpthisLogHistoricoPlanes() {
        return this.logHistoricoPlaneseliminarpthisLogHistoricoPlanes;
    }
    
    public void setLogHistoricoPlaneseliminarpthisLogHistoricoPlanes(LogHistoricoPlanesOid logHistoricoPlaneseliminarpthisLogHistoricoPlanes) {
        this.logHistoricoPlaneseliminarpthisLogHistoricoPlanes = logHistoricoPlaneseliminarpthisLogHistoricoPlanes;
    }

    @JsonIgnore
    public LogHistoricoPlanes getLogHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance() {
        return this.logHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance;
    }
    
    public void setLogHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance(LogHistoricoPlanes logHistoricoPlaneseliminarpthisLogHistoricoPlanes) {
        this.logHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance = logHistoricoPlaneseliminarpthisLogHistoricoPlanes;
        this.logHistoricoPlaneseliminarpthisLogHistoricoPlanes = logHistoricoPlaneseliminarpthisLogHistoricoPlanes != null ? logHistoricoPlaneseliminarpthisLogHistoricoPlanes.getOid() : null;
    }

    private void checkLogHistoricoPlaneseliminarpthisLogHistoricoPlanes() throws NotNullArgumentException {
        if(this.getLogHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance() == null || this.getLogHistoricoPlaneseliminarpthisLogHistoricoPlanesInstance().isNull()) {
            throw new NotNullArgumentException(LogHistoricoPlanesConstants.SERV_ID_ELIMINAR, LogHistoricoPlanesConstants.CLASS_ID, LogHistoricoPlanesConstants.ARG_ID_ELIMINAR_LOGHISTORICOPLANESELIMINARPTHISLOGHISTORICOPLANES, LogHistoricoPlanesConstants.SERV_ALIAS_ELIMINAR, LogHistoricoPlanesConstants.CLASS_ALIAS, LogHistoricoPlanesConstants.ARG_ALIAS_ELIMINAR_LOGHISTORICOPLANESELIMINARPTHISLOGHISTORICOPLANES);
        }
    }
}
