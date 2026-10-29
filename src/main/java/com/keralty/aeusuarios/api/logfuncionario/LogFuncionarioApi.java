package com.keralty.aeusuarios.api.logfuncionario;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.LogFuncionario;
import com.keralty.aeusuarios.persistence.oid.LogFuncionarioOid;
import com.keralty.aeusuarios.service.LogFuncionarioService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.logfuncionario.piu.PIULogFuncionarioResponse;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/LogFuncionarioApi")
@RequestScoped
public class LogFuncionarioApi {

    LogFuncionarioService service;

    public LogFuncionarioApi(LogFuncionarioService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{logFuncionarioId}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin"})
    public LogFuncionario getInstance(Long logFuncionarioId) {
    	return service.getById(logFuncionarioId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin"})
    public List<LogFuncionario> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin"})
    public LogFuncionario getByOid(LogFuncionarioOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin"})
    public LogFuncionario getByOIDWithHV(LogFuncionarioOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetLogFuncionarioDynamic")
    @RolesAllowed({"Admin","SuperAdmin"})
    public InstanceResponseViewModel getLogFuncionarioDynamic(QueryRequest request) {
        LogFuncionarioOid oid = new LogFuncionarioOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getLogFuncionarioDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin"})
    public PopulationResponseViewModel getLogFuncionarioPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }



    @POST
    @Path(value = "/PIU_LogFuncionario")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin"})
    public PIULogFuncionarioResponse piuPIULogFuncionario(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIULogFuncionarioResponse response;
        try
        {
            response = new PIULogFuncionarioResponse(service.piuPIULogFuncionario(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIULogFuncionario(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIULogFuncionarioResponse();
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
