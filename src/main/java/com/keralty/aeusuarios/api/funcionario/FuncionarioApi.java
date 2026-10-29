package com.keralty.aeusuarios.api.funcionario;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.service.FuncionarioService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUAgenteResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUDFuncionariosReporteResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUFuncionarioDDominioResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUFuncionarioDGrupoResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUFuncionarioGrupoUsuariosRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUFuncionarioGrupoUsuariosResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUFuncionarioObsRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUFuncionarioObsResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUUsuariosRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.piu.PIUUsuariosResponse;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.CambRolAgenteRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.DelReporteFuncionarioRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.InsReporteFuncionarioRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.SetPasswordRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.TBORRARRequest;
import com.keralty.aeusuarios.viewmodel.funcionario.siu.TCAMBIARDISPONIBLERequest;
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
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/FuncionarioApi")
@RequestScoped
public class FuncionarioApi {

    FuncionarioService service;

    public FuncionarioApi(FuncionarioService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{funcionarioId}")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Funcionario getInstance(Long funcionarioId) {
    	return service.getById(funcionarioId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<Funcionario> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public List<PreloadViewModel> getFuncionarioPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Funcionario getByOid(FuncionarioOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public Funcionario getByOIDWithHV(FuncionarioOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetFuncionarioDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getFuncionarioDynamic(QueryRequest request) {
        FuncionarioOid oid = new FuncionarioOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getFuncionarioDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PreloadResponseViewModel getFuncionarioWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getFuncionarioPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/setPassword")
    @RolesAllowed({"SuperAdmin"})
    public ServiceResponse funcionarioSetPassword(SetPasswordRequest request) {
        return service.setPassword(request);
    }
    

    @POST
    @Path(value = "/CambRolAgente")
    @RolesAllowed({"SuperAdmin"})
    public ServiceResponse funcionarioCambRolAgente(CambRolAgenteRequest request) {
        return service.cambRolAgente(request);
    }
    

    @POST
    @Path(value = "/InsReporteFuncionario")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse funcionarioInsReporteFuncionario(InsReporteFuncionarioRequest request) {
        return service.insReporteFuncionario(request);
    }
    

    @POST
    @Path(value = "/DelReporteFuncionario")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse funcionarioDelReporteFuncionario(DelReporteFuncionarioRequest request) {
        return service.delReporteFuncionario(request);
    }
    

    @POST
    @Path(value = "/TCAMBIARDISPONIBLE")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse funcionarioTCAMBIARDISPONIBLE(TCAMBIARDISPONIBLERequest request) {
        return service.tCAMBIARDISPONIBLE(request);
    }
    

    @POST
    @Path(value = "/TBORRAR")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse funcionarioTBORRAR(TBORRARRequest request) {
        return service.tBORRAR(request);
    }
    

    @POST
    @Path(value = "/TBORRARCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse funcionarioTBORRARCheckPreconditions(TBORRARRequest request) {

        return service.tBORRARCheckPreconditions(request);
    }

    @POST
    @Path(value = "/changePassword")
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public ServiceResponse funcionarioChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    


    @POST
    @Path(value = "/PIU_Agente")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUAgenteResponse piuPIUAgente(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAgenteResponse response;
        try
        {
            response = new PIUAgenteResponse(service.piuPIUAgente(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAgente(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUAgenteResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_D_FuncionariosReporte")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUDFuncionariosReporteResponse piuPIUDFuncionariosReporte(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUDFuncionariosReporteResponse response;
        try
        {
            response = new PIUDFuncionariosReporteResponse(service.piuPIUDFuncionariosReporte(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUDFuncionariosReporte(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUDFuncionariosReporteResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Funcionario_D_Grupo")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUFuncionarioDGrupoResponse piuPIUFuncionarioDGrupo(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFuncionarioDGrupoResponse response;
        try
        {
            response = new PIUFuncionarioDGrupoResponse(service.piuPIUFuncionarioDGrupo(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFuncionarioDGrupo(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFuncionarioDGrupoResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Funcionario_D_Dominio")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUFuncionarioDDominioResponse piuPIUFuncionarioDDominio(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFuncionarioDDominioResponse response;
        try
        {
            response = new PIUFuncionarioDDominioResponse(service.piuPIUFuncionarioDDominio(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFuncionarioDDominio(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFuncionarioDDominioResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Funcionario_GrupoUsuarios")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUFuncionarioGrupoUsuariosResponse piuPIUFuncionarioGrupoUsuarios(PIUFuncionarioGrupoUsuariosRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFuncionarioGrupoUsuariosResponse response;
        try
        {
            response = new PIUFuncionarioGrupoUsuariosResponse(service.piuPIUFuncionarioGrupoUsuarios(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFuncionarioGrupoUsuarios(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFuncionarioGrupoUsuariosResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Usuarios")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUUsuariosResponse piuPIUUsuarios(PIUUsuariosRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuariosResponse response;
        try
        {
            response = new PIUUsuariosResponse(service.piuPIUUsuarios(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuarios(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUUsuariosResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_Funcionario_Obs")
    @Operation(hidden = true)
    @RolesAllowed({"Funcionario","Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones","RespRegional","Gestor","MesaDeApoyo"})
    public PIUFuncionarioObsResponse piuPIUFuncionarioObs(PIUFuncionarioObsRequest request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUFuncionarioObsResponse response;
        try
        {
            response = new PIUFuncionarioObsResponse(service.piuPIUFuncionarioObs(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUFuncionarioObs(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUFuncionarioObsResponse();
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
