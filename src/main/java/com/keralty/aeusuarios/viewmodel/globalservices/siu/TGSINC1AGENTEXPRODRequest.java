package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import java.sql.Timestamp;

public class TGSINC1AGENTEXPRODRequest {

    @JsonProperty("pproducto")
    private String tGSINC1AGENTEXPRODpProducto;

    @JsonProperty("pt_p_atrfechainicio")
    private Timestamp tGSINC1AGENTEXPRODptpatrFechaInicio;

    @JsonProperty("pt_p_atrfechafin")
    private Timestamp tGSINC1AGENTEXPRODptpatrFechaFin;

    @JsonProperty("pt_p_asesor")
    private String tGSINC1AGENTEXPRODptpAsesor;

    @JsonProperty("pcodigo")
    private Long tGSINC1AGENTEXPRODpCodigo;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1AGENTEXPRODpProducto();
        checkTGSINC1AGENTEXPRODptpAsesor();
        checkTGSINC1AGENTEXPRODpCodigo();
    }

    @JsonIgnore
    public String getTGSINC1AGENTEXPRODpProducto() {
        return this.tGSINC1AGENTEXPRODpProducto;
    }
    
    public void setTGSINC1AGENTEXPRODpProducto(String tGSINC1AGENTEXPRODpProducto) {
        this.tGSINC1AGENTEXPRODpProducto = tGSINC1AGENTEXPRODpProducto;
    }

    private void checkTGSINC1AGENTEXPRODpProducto() throws NotNullArgumentException {
        if(this.getTGSINC1AGENTEXPRODpProducto() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1AGENTEXPROD, GlobalServiceConstants.GS_ARG_ID_TGSINC1AGENTEXPROD_TGSINC1AGENTEXPRODPPRODUCTO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1AGENTEXPROD, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1AGENTEXPROD_TGSINC1AGENTEXPRODPPRODUCTO);
        }
    }

    @JsonIgnore
    public Timestamp getTGSINC1AGENTEXPRODptpatrFechaInicio() {
        return this.tGSINC1AGENTEXPRODptpatrFechaInicio;
    }
    
    public void setTGSINC1AGENTEXPRODptpatrFechaInicio(Timestamp tGSINC1AGENTEXPRODptpatrFechaInicio) {
        this.tGSINC1AGENTEXPRODptpatrFechaInicio = tGSINC1AGENTEXPRODptpatrFechaInicio;
    }

    @JsonIgnore
    public Timestamp getTGSINC1AGENTEXPRODptpatrFechaFin() {
        return this.tGSINC1AGENTEXPRODptpatrFechaFin;
    }
    
    public void setTGSINC1AGENTEXPRODptpatrFechaFin(Timestamp tGSINC1AGENTEXPRODptpatrFechaFin) {
        this.tGSINC1AGENTEXPRODptpatrFechaFin = tGSINC1AGENTEXPRODptpatrFechaFin;
    }

    @JsonIgnore
    public String getTGSINC1AGENTEXPRODptpAsesor() {
        return this.tGSINC1AGENTEXPRODptpAsesor;
    }
    
    public void setTGSINC1AGENTEXPRODptpAsesor(String tGSINC1AGENTEXPRODptpAsesor) {
        this.tGSINC1AGENTEXPRODptpAsesor = tGSINC1AGENTEXPRODptpAsesor;
    }

    private void checkTGSINC1AGENTEXPRODptpAsesor() throws NotNullArgumentException {
        if(this.getTGSINC1AGENTEXPRODptpAsesor() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1AGENTEXPROD, GlobalServiceConstants.GS_ARG_ID_TGSINC1AGENTEXPROD_TGSINC1AGENTEXPRODPTPASESOR, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1AGENTEXPROD, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1AGENTEXPROD_TGSINC1AGENTEXPRODPTPASESOR);
        }
    }

    @JsonIgnore
    public Long getTGSINC1AGENTEXPRODpCodigo() {
        return this.tGSINC1AGENTEXPRODpCodigo;
    }
    
    public void setTGSINC1AGENTEXPRODpCodigo(Long tGSINC1AGENTEXPRODpCodigo) {
        this.tGSINC1AGENTEXPRODpCodigo = tGSINC1AGENTEXPRODpCodigo;
    }

    private void checkTGSINC1AGENTEXPRODpCodigo() throws NotNullArgumentException {
        if(this.getTGSINC1AGENTEXPRODpCodigo() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1AGENTEXPROD, GlobalServiceConstants.GS_ARG_ID_TGSINC1AGENTEXPROD_TGSINC1AGENTEXPRODPCODIGO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1AGENTEXPROD, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1AGENTEXPROD_TGSINC1AGENTEXPRODPCODIGO);
        }
    }
}
