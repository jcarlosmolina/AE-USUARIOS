package com.keralty.aeusuarios.viewmodel.productos.ds;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keralty.aeusuarios.persistence.Productos;
public class AutoDS {

    @JsonProperty("producto")
    private Long autoDSProducto;

    @JsonProperty("descripcion")
    private String autoDSDescripcion;

    @JsonProperty("codanexomat")
    private Long autoDSCodAnexoMat;

    @JsonProperty("codanexoneo")
    private Long autoDSCodAnexoNeo;

    @JsonProperty("nit")
    private String autoDSNIT;

    @JsonProperty("codigolegal")
    private String autoDSCodigoLegal;

    @JsonProperty("fechadocsolicitud")
    private Date autoDSFechaDocSolicitud;

    public AutoDS() {
    
    }

    public AutoDS(Productos instance) {
        if (instance != null) {
            this.autoDSProducto = instance.getProductosProducto();
            this.autoDSDescripcion = instance.getProductosDescripcion();
            this.autoDSCodAnexoMat = instance.getProductosCodAnexoMat();
            this.autoDSCodAnexoNeo = instance.getProductosCodAnexoNeo();
            this.autoDSNIT = instance.getProductosNIT();
            this.autoDSCodigoLegal = instance.getProductosCodigoLegal();
            this.autoDSFechaDocSolicitud = instance.getProductosFechaDocSolicitud();
        }
    }

    @JsonIgnore
    public Long getAutoDSProducto() {
        return this.autoDSProducto;
    }
    
    public void setAutoDSProducto(Long autoDSProducto) {
        this.autoDSProducto = autoDSProducto;
    }

    @JsonIgnore
    public String getAutoDSDescripcion() {
        return this.autoDSDescripcion;
    }
    
    public void setAutoDSDescripcion(String autoDSDescripcion) {
        this.autoDSDescripcion = autoDSDescripcion;
    }

    @JsonIgnore
    public Long getAutoDSCodAnexoMat() {
        return this.autoDSCodAnexoMat;
    }
    
    public void setAutoDSCodAnexoMat(Long autoDSCodAnexoMat) {
        this.autoDSCodAnexoMat = autoDSCodAnexoMat;
    }

    @JsonIgnore
    public Long getAutoDSCodAnexoNeo() {
        return this.autoDSCodAnexoNeo;
    }
    
    public void setAutoDSCodAnexoNeo(Long autoDSCodAnexoNeo) {
        this.autoDSCodAnexoNeo = autoDSCodAnexoNeo;
    }

    @JsonIgnore
    public String getAutoDSNIT() {
        return this.autoDSNIT;
    }
    
    public void setAutoDSNIT(String autoDSNIT) {
        this.autoDSNIT = autoDSNIT;
    }

    @JsonIgnore
    public String getAutoDSCodigoLegal() {
        return this.autoDSCodigoLegal;
    }
    
    public void setAutoDSCodigoLegal(String autoDSCodigoLegal) {
        this.autoDSCodigoLegal = autoDSCodigoLegal;
    }

    @JsonIgnore
    public Date getAutoDSFechaDocSolicitud() {
        return this.autoDSFechaDocSolicitud;
    }
    
    public void setAutoDSFechaDocSolicitud(Date autoDSFechaDocSolicitud) {
        this.autoDSFechaDocSolicitud = autoDSFechaDocSolicitud;
    }
}
