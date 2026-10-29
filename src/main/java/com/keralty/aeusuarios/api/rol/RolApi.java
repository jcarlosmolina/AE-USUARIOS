package com.keralty.aeusuarios.api.rol;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.RolOid;
import com.keralty.aeusuarios.persistence.Rol;
import com.keralty.aeusuarios.service.RolService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PreloadViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.rol.piu.PIURolDetDominioResponse;
import com.keralty.aeusuarios.viewmodel.rol.piu.PIURolResponse;
import com.keralty.aeusuarios.viewmodel.rol.siu.CrearRequest;
import com.keralty.aeusuarios.viewmodel.rol.siu.EliminarRequest;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/RolApi")
@RequestScoped
public class RolApi {

    RolService service;

    public RolApi(RolService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{rolIdentificador}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public Rol getInstance(Long rolIdentificador) {
    	return service.getById(rolIdentificador);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public List<Rol> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @POST
    @Path(value = "/GetPreload")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public List<PreloadViewModel> getRolPreload(QueryRequest queryRequest) {
        return service.getPreload(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public Rol getByOid(RolOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public Rol getByOIDWithHV(RolOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetRolDynamic")
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public InstanceResponseViewModel getRolDynamic(QueryRequest request) {
        RolOid oid = new RolOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getRolDynamic(oid, request.getDisplaySetItems());
    }

    @POST
    @Path(value = "/GetWithDisplaySetDynamic")
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public PreloadResponseViewModel getRolWithDisplaySetDynamic(QueryRequest request) {
        return (PreloadResponseViewModel) service.getDynamic(request);
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public PopulationResponseViewModel getRolPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/crear")
    @RolesAllowed({"SuperAdmin"})
    public ServiceResponse rolCrear(CrearRequest request) {
        return service.crear(request);
    }
    

    @POST
    @Path(value = "/eliminar")
    @RolesAllowed({"SuperAdmin"})
    public ServiceResponse rolEliminar(EliminarRequest request) {
        return service.eliminar(request);
    }
    

    @POST
    @Path(value = "/eliminarCheckPreconditions")
    @RolesAllowed({"SuperAdmin"})
    public ServiceResponse rolEliminarCheckPreconditions(EliminarRequest request) {

        return service.eliminarCheckPreconditions(request);
    }


    @POST
    @Path(value = "/PIU_Rol")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public PIURolResponse piuPIURol(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIURolResponse response;
        try
        {
            response = new PIURolResponse(service.piuPIURol(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIURol(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIURolResponse();
            response.setException(e);
        }
        return response;
    }

    @POST
    @Path(value = "/PIU_RolDetDominio")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","AreaMedica","Gestor","MesaDeApoyo"})
    public PIURolDetDominioResponse piuPIURolDetDominio(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIURolDetDominioResponse response;
        try
        {
            response = new PIURolDetDominioResponse(service.piuPIURolDetDominio(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIURolDetDominio(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIURolDetDominioResponse();
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
