package com.keralty.aeusuarios.viewmodel.globalservices.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.exception.NotNullArgumentException;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.persistence.oid.ProductosOid;
import com.keralty.aeusuarios.persistence.Productos;
import java.sql.Timestamp;

public class TGSINC1AGENTEXPRODAUXRequest {

    @JsonProperty("pt_p_agrproducto_oid")
    private ProductosOid tGSINC1AGENTEXPRODAUXptpagrProducto;
    
    @JsonIgnore
    private Productos tGSINC1AGENTEXPRODAUXptpagrProductoInstance;

    @JsonProperty("pt_p_agrasesor_oid")
    private AsesorOid tGSINC1AGENTEXPRODAUXptpagrAsesor;
    
    @JsonIgnore
    private Asesor tGSINC1AGENTEXPRODAUXptpagrAsesorInstance;

    @JsonProperty("pt_p_atrcodigo")
    private Long tGSINC1AGENTEXPRODAUXptpatrCodigo;

    @JsonProperty("pt_p_atrfechainicio")
    private Timestamp tGSINC1AGENTEXPRODAUXptpatrFechaInicio;

    @JsonProperty("pt_p_atrfechafin")
    private Timestamp tGSINC1AGENTEXPRODAUXptpatrFechaFin;

    public void checkArguments() throws NotNullArgumentException {
        checkTGSINC1AGENTEXPRODAUXptpagrProducto();
        checkTGSINC1AGENTEXPRODAUXptpagrAsesor();
        checkTGSINC1AGENTEXPRODAUXptpatrCodigo();
    }

    @JsonIgnore
    public ProductosOid getTGSINC1AGENTEXPRODAUXptpagrProducto() {
        return this.tGSINC1AGENTEXPRODAUXptpagrProducto;
    }
    
    public void setTGSINC1AGENTEXPRODAUXptpagrProducto(ProductosOid tGSINC1AGENTEXPRODAUXptpagrProducto) {
        this.tGSINC1AGENTEXPRODAUXptpagrProducto = tGSINC1AGENTEXPRODAUXptpagrProducto;
    }

    @JsonIgnore
    public Productos getTGSINC1AGENTEXPRODAUXptpagrProductoInstance() {
        return this.tGSINC1AGENTEXPRODAUXptpagrProductoInstance;
    }
    
    public void setTGSINC1AGENTEXPRODAUXptpagrProductoInstance(Productos tGSINC1AGENTEXPRODAUXptpagrProducto) {
        this.tGSINC1AGENTEXPRODAUXptpagrProductoInstance = tGSINC1AGENTEXPRODAUXptpagrProducto;
        this.tGSINC1AGENTEXPRODAUXptpagrProducto = tGSINC1AGENTEXPRODAUXptpagrProducto != null ? tGSINC1AGENTEXPRODAUXptpagrProducto.getOid() : null;
    }

    private void checkTGSINC1AGENTEXPRODAUXptpagrProducto() throws NotNullArgumentException {
        if(this.getTGSINC1AGENTEXPRODAUXptpagrProductoInstance() == null || this.getTGSINC1AGENTEXPRODAUXptpagrProductoInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1AGENTEXPRODAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRPRODUCTO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1AGENTEXPRODAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRPRODUCTO);
        }
    }

    @JsonIgnore
    public AsesorOid getTGSINC1AGENTEXPRODAUXptpagrAsesor() {
        return this.tGSINC1AGENTEXPRODAUXptpagrAsesor;
    }
    
    public void setTGSINC1AGENTEXPRODAUXptpagrAsesor(AsesorOid tGSINC1AGENTEXPRODAUXptpagrAsesor) {
        this.tGSINC1AGENTEXPRODAUXptpagrAsesor = tGSINC1AGENTEXPRODAUXptpagrAsesor;
    }

    @JsonIgnore
    public Asesor getTGSINC1AGENTEXPRODAUXptpagrAsesorInstance() {
        return this.tGSINC1AGENTEXPRODAUXptpagrAsesorInstance;
    }
    
    public void setTGSINC1AGENTEXPRODAUXptpagrAsesorInstance(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor) {
        this.tGSINC1AGENTEXPRODAUXptpagrAsesorInstance = tGSINC1AGENTEXPRODAUXptpagrAsesor;
        this.tGSINC1AGENTEXPRODAUXptpagrAsesor = tGSINC1AGENTEXPRODAUXptpagrAsesor != null ? tGSINC1AGENTEXPRODAUXptpagrAsesor.getOid() : null;
    }

    private void checkTGSINC1AGENTEXPRODAUXptpagrAsesor() throws NotNullArgumentException {
        if(this.getTGSINC1AGENTEXPRODAUXptpagrAsesorInstance() == null || this.getTGSINC1AGENTEXPRODAUXptpagrAsesorInstance().isNull()) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1AGENTEXPRODAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1AGENTEXPRODAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR);
        }
    }

    @JsonIgnore
    public Long getTGSINC1AGENTEXPRODAUXptpatrCodigo() {
        return this.tGSINC1AGENTEXPRODAUXptpatrCodigo;
    }
    
    public void setTGSINC1AGENTEXPRODAUXptpatrCodigo(Long tGSINC1AGENTEXPRODAUXptpatrCodigo) {
        this.tGSINC1AGENTEXPRODAUXptpatrCodigo = tGSINC1AGENTEXPRODAUXptpatrCodigo;
    }

    private void checkTGSINC1AGENTEXPRODAUXptpatrCodigo() throws NotNullArgumentException {
        if(this.getTGSINC1AGENTEXPRODAUXptpatrCodigo() == null) {
            throw new NotNullArgumentException(GlobalServiceConstants.G_SERV_ID_TGSINC1AGENTEXPRODAUX, GlobalServiceConstants.GS_ARG_ID_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPATRCODIGO, GlobalServiceConstants.G_SERV_ALIAS_TGSINC1AGENTEXPRODAUX, GlobalServiceConstants.GS_ARG_ALIAS_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPATRCODIGO);
        }
    }

    @JsonIgnore
    public Timestamp getTGSINC1AGENTEXPRODAUXptpatrFechaInicio() {
        return this.tGSINC1AGENTEXPRODAUXptpatrFechaInicio;
    }
    
    public void setTGSINC1AGENTEXPRODAUXptpatrFechaInicio(Timestamp tGSINC1AGENTEXPRODAUXptpatrFechaInicio) {
        this.tGSINC1AGENTEXPRODAUXptpatrFechaInicio = tGSINC1AGENTEXPRODAUXptpatrFechaInicio;
    }

    @JsonIgnore
    public Timestamp getTGSINC1AGENTEXPRODAUXptpatrFechaFin() {
        return this.tGSINC1AGENTEXPRODAUXptpatrFechaFin;
    }
    
    public void setTGSINC1AGENTEXPRODAUXptpatrFechaFin(Timestamp tGSINC1AGENTEXPRODAUXptpatrFechaFin) {
        this.tGSINC1AGENTEXPRODAUXptpatrFechaFin = tGSINC1AGENTEXPRODAUXptpatrFechaFin;
    }
}
