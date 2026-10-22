package com.keralty.aeusuarios.viewmodel.firma.siu;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.FamiliaNovedad;
import com.keralty.aeusuarios.persistence.NovedadCT;
import com.keralty.aeusuarios.persistence.oid.FamiliaNovedadOid;
import com.keralty.aeusuarios.persistence.oid.NovedadCTOid;
import com.keralty.aeusuarios.persistence.oid.RespRegionalOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudNovedadOid;
import com.keralty.aeusuarios.persistence.oid.SolicitudOid;
import com.keralty.aeusuarios.persistence.RespRegional;
import com.keralty.aeusuarios.persistence.Solicitud;
import com.keralty.aeusuarios.persistence.SolicitudNovedad;

public class CrearRequest {

    @JsonProperty("p_agrsolicitudsegunda_oid")
    private SolicitudOid firmacrearpagrSolicitudSegunda;
    
    @JsonIgnore
    private Solicitud firmacrearpagrSolicitudSegundaInstance;

    @JsonProperty("p_agrrespregional_oid")
    private RespRegionalOid firmacrearpagrRespRegional;
    
    @JsonIgnore
    private RespRegional firmacrearpagrRespRegionalInstance;

    @JsonProperty("p_agrsolicitudcontratante_oid")
    private SolicitudOid firmacrearpagrSolicitudContratante;
    
    @JsonIgnore
    private Solicitud firmacrearpagrSolicitudContratanteInstance;

    @JsonProperty("p_agrfamilianovedad_oid")
    private FamiliaNovedadOid firmacrearpagrFamiliaNovedad;
    
    @JsonIgnore
    private FamiliaNovedad firmacrearpagrFamiliaNovedadInstance;

    @JsonProperty("p_agrnovedadesct_oid")
    private NovedadCTOid firmacrearpagrNovedadesCT;
    
    @JsonIgnore
    private NovedadCT firmacrearpagrNovedadesCTInstance;

    @JsonProperty("p_agrsolicitud_oid")
    private SolicitudOid firmacrearpagrSolicitud;
    
    @JsonIgnore
    private Solicitud firmacrearpagrSolicitudInstance;

    @JsonProperty("p_agrsolicitudnovedad_oid")
    private SolicitudNovedadOid firmacrearpagrSolicitudNovedad;
    
    @JsonIgnore
    private SolicitudNovedad firmacrearpagrSolicitudNovedadInstance;

    @JsonProperty("p_atrimagenfirma")
    private byte[] firmacrearpatrImagenFirma;

    @JsonProperty("p_atrlatitud")
    private String firmacrearpatrLatitud;

    @JsonProperty("p_atrlongitud")
    private String firmacrearpatrLongitud;

    @JsonIgnore
    public SolicitudOid getFirmacrearpagrSolicitudSegunda() {
        return this.firmacrearpagrSolicitudSegunda;
    }
    
    public void setFirmacrearpagrSolicitudSegunda(SolicitudOid firmacrearpagrSolicitudSegunda) {
        this.firmacrearpagrSolicitudSegunda = firmacrearpagrSolicitudSegunda;
    }

    @JsonIgnore
    public Solicitud getFirmacrearpagrSolicitudSegundaInstance() {
        return this.firmacrearpagrSolicitudSegundaInstance;
    }
    
    public void setFirmacrearpagrSolicitudSegundaInstance(Solicitud firmacrearpagrSolicitudSegunda) {
        this.firmacrearpagrSolicitudSegundaInstance = firmacrearpagrSolicitudSegunda;
        this.firmacrearpagrSolicitudSegunda = firmacrearpagrSolicitudSegunda != null ? firmacrearpagrSolicitudSegunda.getOid() : null;
    }

    @JsonIgnore
    public RespRegionalOid getFirmacrearpagrRespRegional() {
        return this.firmacrearpagrRespRegional;
    }
    
    public void setFirmacrearpagrRespRegional(RespRegionalOid firmacrearpagrRespRegional) {
        this.firmacrearpagrRespRegional = firmacrearpagrRespRegional;
    }

    @JsonIgnore
    public RespRegional getFirmacrearpagrRespRegionalInstance() {
        return this.firmacrearpagrRespRegionalInstance;
    }
    
    public void setFirmacrearpagrRespRegionalInstance(RespRegional firmacrearpagrRespRegional) {
        this.firmacrearpagrRespRegionalInstance = firmacrearpagrRespRegional;
        this.firmacrearpagrRespRegional = firmacrearpagrRespRegional != null ? firmacrearpagrRespRegional.getOid() : null;
    }

    @JsonIgnore
    public SolicitudOid getFirmacrearpagrSolicitudContratante() {
        return this.firmacrearpagrSolicitudContratante;
    }
    
    public void setFirmacrearpagrSolicitudContratante(SolicitudOid firmacrearpagrSolicitudContratante) {
        this.firmacrearpagrSolicitudContratante = firmacrearpagrSolicitudContratante;
    }

    @JsonIgnore
    public Solicitud getFirmacrearpagrSolicitudContratanteInstance() {
        return this.firmacrearpagrSolicitudContratanteInstance;
    }
    
    public void setFirmacrearpagrSolicitudContratanteInstance(Solicitud firmacrearpagrSolicitudContratante) {
        this.firmacrearpagrSolicitudContratanteInstance = firmacrearpagrSolicitudContratante;
        this.firmacrearpagrSolicitudContratante = firmacrearpagrSolicitudContratante != null ? firmacrearpagrSolicitudContratante.getOid() : null;
    }

    @JsonIgnore
    public FamiliaNovedadOid getFirmacrearpagrFamiliaNovedad() {
        return this.firmacrearpagrFamiliaNovedad;
    }
    
    public void setFirmacrearpagrFamiliaNovedad(FamiliaNovedadOid firmacrearpagrFamiliaNovedad) {
        this.firmacrearpagrFamiliaNovedad = firmacrearpagrFamiliaNovedad;
    }

    @JsonIgnore
    public FamiliaNovedad getFirmacrearpagrFamiliaNovedadInstance() {
        return this.firmacrearpagrFamiliaNovedadInstance;
    }
    
    public void setFirmacrearpagrFamiliaNovedadInstance(FamiliaNovedad firmacrearpagrFamiliaNovedad) {
        this.firmacrearpagrFamiliaNovedadInstance = firmacrearpagrFamiliaNovedad;
        this.firmacrearpagrFamiliaNovedad = firmacrearpagrFamiliaNovedad != null ? firmacrearpagrFamiliaNovedad.getOid() : null;
    }

    @JsonIgnore
    public NovedadCTOid getFirmacrearpagrNovedadesCT() {
        return this.firmacrearpagrNovedadesCT;
    }
    
    public void setFirmacrearpagrNovedadesCT(NovedadCTOid firmacrearpagrNovedadesCT) {
        this.firmacrearpagrNovedadesCT = firmacrearpagrNovedadesCT;
    }

    @JsonIgnore
    public NovedadCT getFirmacrearpagrNovedadesCTInstance() {
        return this.firmacrearpagrNovedadesCTInstance;
    }
    
    public void setFirmacrearpagrNovedadesCTInstance(NovedadCT firmacrearpagrNovedadesCT) {
        this.firmacrearpagrNovedadesCTInstance = firmacrearpagrNovedadesCT;
        this.firmacrearpagrNovedadesCT = firmacrearpagrNovedadesCT != null ? firmacrearpagrNovedadesCT.getOid() : null;
    }

    @JsonIgnore
    public SolicitudOid getFirmacrearpagrSolicitud() {
        return this.firmacrearpagrSolicitud;
    }
    
    public void setFirmacrearpagrSolicitud(SolicitudOid firmacrearpagrSolicitud) {
        this.firmacrearpagrSolicitud = firmacrearpagrSolicitud;
    }

    @JsonIgnore
    public Solicitud getFirmacrearpagrSolicitudInstance() {
        return this.firmacrearpagrSolicitudInstance;
    }
    
    public void setFirmacrearpagrSolicitudInstance(Solicitud firmacrearpagrSolicitud) {
        this.firmacrearpagrSolicitudInstance = firmacrearpagrSolicitud;
        this.firmacrearpagrSolicitud = firmacrearpagrSolicitud != null ? firmacrearpagrSolicitud.getOid() : null;
    }

    @JsonIgnore
    public SolicitudNovedadOid getFirmacrearpagrSolicitudNovedad() {
        return this.firmacrearpagrSolicitudNovedad;
    }
    
    public void setFirmacrearpagrSolicitudNovedad(SolicitudNovedadOid firmacrearpagrSolicitudNovedad) {
        this.firmacrearpagrSolicitudNovedad = firmacrearpagrSolicitudNovedad;
    }

    @JsonIgnore
    public SolicitudNovedad getFirmacrearpagrSolicitudNovedadInstance() {
        return this.firmacrearpagrSolicitudNovedadInstance;
    }
    
    public void setFirmacrearpagrSolicitudNovedadInstance(SolicitudNovedad firmacrearpagrSolicitudNovedad) {
        this.firmacrearpagrSolicitudNovedadInstance = firmacrearpagrSolicitudNovedad;
        this.firmacrearpagrSolicitudNovedad = firmacrearpagrSolicitudNovedad != null ? firmacrearpagrSolicitudNovedad.getOid() : null;
    }

    @JsonIgnore
    public byte[] getFirmacrearpatrImagenFirma() {
        return this.firmacrearpatrImagenFirma;
    }
    
    public void setFirmacrearpatrImagenFirma(byte[] firmacrearpatrImagenFirma) {
        this.firmacrearpatrImagenFirma = firmacrearpatrImagenFirma;
    }

    @JsonIgnore
    public String getFirmacrearpatrLatitud() {
        return this.firmacrearpatrLatitud;
    }
    
    public void setFirmacrearpatrLatitud(String firmacrearpatrLatitud) {
        this.firmacrearpatrLatitud = firmacrearpatrLatitud;
    }

    @JsonIgnore
    public String getFirmacrearpatrLongitud() {
        return this.firmacrearpatrLongitud;
    }
    
    public void setFirmacrearpatrLongitud(String firmacrearpatrLongitud) {
        this.firmacrearpatrLongitud = firmacrearpatrLongitud;
    }
}
