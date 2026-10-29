package com.keralty.aeusuarios.viewmodel.dominio.ds;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Dominio;
public class DSDominioSolNovedad {

    @JsonProperty("novexcepcionreqdoc")
    private Boolean dSDominioSolNovedadNovExcepcionReqDoc;

    @JsonProperty("solnovcoloroscuro")
    private String dSDominioSolNovedadSolNovColorOscuro;

    @JsonProperty("solnovcolorclaro")
    private String dSDominioSolNovedadSolNovColorClaro;

    @JsonProperty("solnovlogo")
    private String dSDominioSolNovedadSolNovLogo;

    public DSDominioSolNovedad() {
    
    }

    public DSDominioSolNovedad(Dominio instance) {
        if (instance != null) {
            this.dSDominioSolNovedadNovExcepcionReqDoc = instance.getDominioNovExcepcionReqDoc();
            this.dSDominioSolNovedadSolNovColorOscuro = instance.getDominioSolNovColorOscuro();
            this.dSDominioSolNovedadSolNovColorClaro = instance.getDominioSolNovColorClaro();
            this.dSDominioSolNovedadSolNovLogo = instance.getDominioSolNovLogo();
        }
    }

    @JsonIgnore
    public Boolean getDSDominioSolNovedadNovExcepcionReqDoc() {
        return this.dSDominioSolNovedadNovExcepcionReqDoc;
    }
    
    public void setDSDominioSolNovedadNovExcepcionReqDoc(Boolean dSDominioSolNovedadNovExcepcionReqDoc) {
        this.dSDominioSolNovedadNovExcepcionReqDoc = dSDominioSolNovedadNovExcepcionReqDoc;
    }

    @JsonIgnore
    public String getDSDominioSolNovedadSolNovColorOscuro() {
        return this.dSDominioSolNovedadSolNovColorOscuro;
    }
    
    public void setDSDominioSolNovedadSolNovColorOscuro(String dSDominioSolNovedadSolNovColorOscuro) {
        this.dSDominioSolNovedadSolNovColorOscuro = dSDominioSolNovedadSolNovColorOscuro;
    }

    @JsonIgnore
    public String getDSDominioSolNovedadSolNovColorClaro() {
        return this.dSDominioSolNovedadSolNovColorClaro;
    }
    
    public void setDSDominioSolNovedadSolNovColorClaro(String dSDominioSolNovedadSolNovColorClaro) {
        this.dSDominioSolNovedadSolNovColorClaro = dSDominioSolNovedadSolNovColorClaro;
    }

    @JsonIgnore
    public String getDSDominioSolNovedadSolNovLogo() {
        return this.dSDominioSolNovedadSolNovLogo;
    }
    
    public void setDSDominioSolNovedadSolNovLogo(String dSDominioSolNovedadSolNovLogo) {
        this.dSDominioSolNovedadSolNovLogo = dSDominioSolNovedadSolNovLogo;
    }
}
