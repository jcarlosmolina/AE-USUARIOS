package com.keralty.aeusuarios.api.globalservices;

import com.keralty.aeusuarios.service.GlobalServicesService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAPLANASESORResponse;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGCARGAVISASESORESResponse;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCAGENTESXPRODRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCASESORESRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCASESORESResponse;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCSUCURSALESRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TCREARAGENTERequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGFIJARDATOSSINCRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGMODASESORAGENCIARequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIARequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGNEWASESORAGENCIAResponse;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGPOSPROCESARASESORESRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODAUXRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1AGENTEXPRODRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINC1ASESORRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCPRODUCTOSRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCTIPOSIDENTIFICACIONRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGVERIFICARUSUARIORequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TMODIFICARAGENTERequest;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/GlobalServicesApi")
@RequestScoped
public class GlobalServicesApi {

    GlobalServicesService service;

    public GlobalServicesApi(GlobalServicesService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @POST
    @Path(value = "/TGSINCPRODUCTOS")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGSINCPRODUCTOS(TGSINCPRODUCTOSRequest request) {
        return service.tGSINCPRODUCTOS(request);
    }

    @POST
    @Path(value = "/OGSINCSUCURSALES")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse oGSINCSUCURSALES(OGSINCSUCURSALESRequest request) {
        return service.oGSINCSUCURSALES(request);
    }

    @POST
    @Path(value = "/TGSINC1ASESOR")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGSINC1ASESOR(TGSINC1ASESORRequest request) {
        return service.tGSINC1ASESOR(request);
    }

    @POST
    @Path(value = "/OGSINCASESORES")
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public OGSINCASESORESResponse oGSINCASESORES(OGSINCASESORESRequest request) {
        return service.oGSINCASESORES(request);
    }

    @POST
    @Path(value = "/TGSINCTIPOSIDENTIFICACION")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGSINCTIPOSIDENTIFICACION(TGSINCTIPOSIDENTIFICACIONRequest request) {
        return service.tGSINCTIPOSIDENTIFICACION(request);
    }

    @POST
    @Path(value = "/TGVERIFICARUSUARIO")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public ServiceResponse tGVERIFICARUSUARIO(TGVERIFICARUSUARIORequest request) {
        return service.tGVERIFICARUSUARIO(request);
    }

    @POST
    @Path(value = "/OGSINCAGENTESXPROD")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse oGSINCAGENTESXPROD(OGSINCAGENTESXPRODRequest request) {
        return service.oGSINCAGENTESXPROD(request);
    }

    @POST
    @Path(value = "/TGSINC1AGENTEXPROD")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGSINC1AGENTEXPROD(TGSINC1AGENTEXPRODRequest request) {
        return service.tGSINC1AGENTEXPROD(request);
    }

    @POST
    @Path(value = "/TGSINC1AGENTEXPRODAUX")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGSINC1AGENTEXPRODAUX(TGSINC1AGENTEXPRODAUXRequest request) {
        return service.tGSINC1AGENTEXPRODAUX(request);
    }

    @POST
    @Path(value = "/TGPOSPROCESARASESORES")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGPOSPROCESARASESORES(TGPOSPROCESARASESORESRequest request) {
        return service.tGPOSPROCESARASESORES(request);
    }

    @POST
    @Path(value = "/TCREARAGENTE")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tCREARAGENTE(TCREARAGENTERequest request) {
        return service.tCREARAGENTE(request);
    }

    @POST
    @Path(value = "/TCREARAGENTECheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tCREARAGENTECheckPreconditions(TCREARAGENTERequest request) {
        return service.tCREARAGENTECheckPreconditions(request);
    }

    @POST
    @Path(value = "/TMODIFICARAGENTE")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tMODIFICARAGENTE(TMODIFICARAGENTERequest request) {
        return service.tMODIFICARAGENTE(request);
    }

    @POST
    @Path(value = "/TMODIFICARAGENTECheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tMODIFICARAGENTECheckPreconditions(TMODIFICARAGENTERequest request) {
        return service.tMODIFICARAGENTECheckPreconditions(request);
    }

    @POST
    @Path(value = "/TGNEWASESORAGENCIA")
    @RolesAllowed({"Admin","SuperAdmin"})
    public TGNEWASESORAGENCIAResponse tGNEWASESORAGENCIA(TGNEWASESORAGENCIARequest request) {
        return service.tGNEWASESORAGENCIA(request);
    }

    @POST
    @Path(value = "/TGNEWASESORAGENCIACheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin"})
    public TGNEWASESORAGENCIAResponse tGNEWASESORAGENCIACheckPreconditions(TGNEWASESORAGENCIARequest request) {
        return service.tGNEWASESORAGENCIACheckPreconditions(request);
    }

    @POST
    @Path(value = "/TGMODASESORAGENCIA")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGMODASESORAGENCIA(TGMODASESORAGENCIARequest request) {
        return service.tGMODASESORAGENCIA(request);
    }

    @POST
    @Path(value = "/TGMODASESORAGENCIACheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse tGMODASESORAGENCIACheckPreconditions(TGMODASESORAGENCIARequest request) {
        return service.tGMODASESORAGENCIACheckPreconditions(request);
    }

    @POST
    @Path(value = "/OGCARGAVISASESORES")
    @RolesAllowed({"Admin","SuperAdmin"})
    public OGCARGAVISASESORESResponse oGCARGAVISASESORES(OGCARGAVISASESORESRequest request) {
        return service.oGCARGAVISASESORES(request);
    }

    @POST
    @Path(value = "/OGCARGAPLANASESOR")
    @RolesAllowed({"Admin","SuperAdmin"})
    public OGCARGAPLANASESORResponse oGCARGAPLANASESOR(OGCARGAPLANASESORRequest request) {
        return service.oGCARGAPLANASESOR(request);
    }

    @POST
    @Path(value = "/TGFIJARDATOSSINC")
    public ServiceResponse tGFIJARDATOSSINC(TGFIJARDATOSSINCRequest request) {
        return service.tGFIJARDATOSSINC(request);
    }
}
