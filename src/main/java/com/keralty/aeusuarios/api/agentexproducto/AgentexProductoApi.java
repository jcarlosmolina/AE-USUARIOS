package com.keralty.aeusuarios.api.agentexproducto;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.oid.AgentexProductoOid;
import com.keralty.aeusuarios.service.AgentexProductoService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.agentexproducto.piu.PIUAgentexProductoResponse;
import com.keralty.aeusuarios.viewmodel.agentexproducto.siu.EliminarRequest;
import com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TADDDOMINIORequest;
import com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TCREARRequest;
import com.keralty.aeusuarios.viewmodel.agentexproducto.siu.TDELDOMINIORequest;
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

@Path("/api/AgentexProductoApi")
@RequestScoped
public class AgentexProductoApi {

    AgentexProductoService service;

    public AgentexProductoApi(AgentexProductoService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{funcionarioAsesorId}/{agentexProductoId}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public AgentexProducto getInstance(Long funcionarioAsesorId, Long agentexProductoId) {
    	return service.getById(funcionarioAsesorId, agentexProductoId);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public List<AgentexProducto> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public List<PreloadViewModel> getAgentexProductoPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public AgentexProducto getByOid(AgentexProductoOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public AgentexProducto getByOIDWithHV(AgentexProductoOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetAgentexProductoDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public InstanceResponseViewModel getAgentexProductoDynamic(QueryRequest request) {
        AgentexProductoOid oid = new AgentexProductoOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getAgentexProductoDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public PreloadResponseViewModel getAgentexProductoWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public PopulationResponseViewModel getAgentexProductoPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/eliminar")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse agentexProductoEliminar(EliminarRequest request) {
        return service.eliminar(request);
    }
    

    @POST
    @Path(value = "/TCREAR")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse agentexProductoTCREAR(TCREARRequest request) {
        return service.tCREAR(request);
    }
    

    @POST
    @Path(value = "/TADDDOMINIO")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse agentexProductoTADDDOMINIO(TADDDOMINIORequest request) {
        return service.tADDDOMINIO(request);
    }
    

    @POST
    @Path(value = "/TADDDOMINIOCheckPreconditions")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse agentexProductoTADDDOMINIOCheckPreconditions(TADDDOMINIORequest request) {

        return service.tADDDOMINIOCheckPreconditions(request);
    }

    @POST
    @Path(value = "/TDELDOMINIO")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse agentexProductoTDELDOMINIO(TDELDOMINIORequest request) {
        return service.tDELDOMINIO(request);
    }
    


    @POST
    @Path(value = "/PIU_AgentexProducto")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","Asesor","AreaMedica","Afiliaciones"})
    public PIUAgentexProductoResponse piuPIUAgentexProducto(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUAgentexProductoResponse response;
        try
        {
            response = new PIUAgentexProductoResponse(service.piuPIUAgentexProducto(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUAgentexProducto(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUAgentexProductoResponse();
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
