package com.keralty.aeusuarios.api.asesor;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.oid.AsesorOid;
import com.keralty.aeusuarios.service.AsesorService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorIIU;
import com.keralty.aeusuarios.viewmodel.asesor.ds.DSAsesorPIUMaestroProductos;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesorDetalleResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesoresDeAgenciaRequest;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesoresDeAgenciaResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesorNullResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesorRequest;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUAsesorResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUDirectoresObsRequest;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUDirectoresObsResponse;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUDirectoresRequest;
import com.keralty.aeusuarios.viewmodel.asesor.piu.PIUDirectoresResponse;
import com.keralty.aeusuarios.viewmodel.asesor.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TCARGARDOMINIOPLANRequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TDELETERequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TMODIFICARASESORRequest;
import com.keralty.aeusuarios.viewmodel.asesor.siu.TMODVISIBILIDADRequest;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/AsesorApi")
@RequestScoped
public class AsesorApi {

    AsesorService service;

    public AsesorApi(AsesorService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{funcionarioId}")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Asesor getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<Asesor> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<PreloadViewModel> getAsesorPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Asesor getByOid(AsesorOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Asesor getByOIDWithHV(AsesorOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetAsesorDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getAsesorDynamic(QueryRequest request) {
        AsesorOid oid = new AsesorOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAsesorDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PreloadResponseViewModel getAsesorWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getAsesorPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/TMODIFICARASESOR")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse asesorTMODIFICARASESOR(TMODIFICARASESORRequest request) {
        return service.tMODIFICARASESOR(request);
    }
    

    @POST
    @Path(value = "/TDELETE")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse asesorTDELETE(TDELETERequest request) {
        return service.tDELETE(request);
    }
    

    @POST
    @Path(value = "/TDELETECheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse asesorTDELETECheckPreconditions(TDELETERequest request) {

        return service.tDELETECheckPreconditions(request);
    }

    @POST
    @Path(value = "/TMODVISIBILIDAD")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse asesorTMODVISIBILIDAD(TMODVISIBILIDADRequest request) {
        return service.tMODVISIBILIDAD(request);
    }
    

    @POST
    @Path(value = "/TCARGARDOMINIOPLAN")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse asesorTCARGARDOMINIOPLAN(TCARGARDOMINIOPLANRequest request) {
        return service.tCARGARDOMINIOPLAN(request);
    }
    

    @POST
    @Path(value = "/changePassword")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public ServiceResponse asesorChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    

    @POST
    @Path(value = "/IIU_Asesor")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSAsesorIIU iiuIIUAsesor(AsesorOid oid) {
        return service.iIUAsesor(oid);
    }

    @POST
    @Path(value = "/IIU_AsesorProductos")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public DSAsesorPIUMaestroProductos iiuIIUAsesorProductos(AsesorOid oid) {
        return service.iIUAsesorProductos(oid);
    }

    @POST
    @Path(value = "/PIU_Asesor")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUAsesorResponse piuPIUAsesor(PIUAsesorRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAsesorResponse response;
        try
        {
            response = new PIUAsesorResponse(service.piuPIUAsesor(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAsesor(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUAsesorResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_AsesorDetalle")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUAsesorDetalleResponse piuPIUAsesorDetalle(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAsesorDetalleResponse response;
        try
        {
            response = new PIUAsesorDetalleResponse(service.piuPIUAsesorDetalle(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAsesorDetalle(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUAsesorDetalleResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Directores")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUDirectoresResponse piuPIUDirectores(PIUDirectoresRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDirectoresResponse response;
        try
        {
            response = new PIUDirectoresResponse(service.piuPIUDirectores(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDirectores(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUDirectoresResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_AsesoresDeAgencia")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUAsesoresDeAgenciaResponse piuPIUAsesoresDeAgencia(PIUAsesoresDeAgenciaRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAsesoresDeAgenciaResponse response;
        try
        {
            response = new PIUAsesoresDeAgenciaResponse(service.piuPIUAsesoresDeAgencia(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAsesoresDeAgencia(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUAsesoresDeAgenciaResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Asesor_Null")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUAsesorNullResponse piuPIUAsesorNull(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAsesorNullResponse response;
        try
        {
            response = new PIUAsesorNullResponse(service.piuPIUAsesorNull(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAsesorNull(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUAsesorNullResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Directores_Obs")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUDirectoresObsResponse piuPIUDirectoresObs(PIUDirectoresObsRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDirectoresObsResponse response;
        try
        {
            response = new PIUDirectoresObsResponse(service.piuPIUDirectoresObs(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDirectoresObs(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUDirectoresObsResponse();
            response.setException(e);
        }
        return response;
    }


    @GET
    @Path("buildRelatedInstance/{relatedInstanceJsonOid}/{relatedInstancePath}")
    @Operation(hidden = true)
    public AbstractAppEntity buildRelatedInstance(String relatedInstanceJsonOid, String relatedInstancePath) {
        return service.buildRelatedInstance(relatedInstanceJsonOid, relatedInstancePath);
    }
}
