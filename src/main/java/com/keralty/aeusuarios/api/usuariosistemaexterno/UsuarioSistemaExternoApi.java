package com.keralty.aeusuarios.api.usuariosistemaexterno;

import com.keralty.aeusuarios.persistence.AbstractAppEntity;
import com.keralty.aeusuarios.persistence.oid.UsuarioSistemaExternoOid;
import com.keralty.aeusuarios.persistence.UsuarioSistemaExterno;
import com.keralty.aeusuarios.service.UsuarioSistemaExternoService;
import com.keralty.aeusuarios.utils.TokenUtilities;
import com.keralty.aeusuarios.viewmodel.InstanceResponseViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationRequestViewModel;
import com.keralty.aeusuarios.viewmodel.PopulationResponseViewModel;
import com.keralty.aeusuarios.viewmodel.QueryRequest;
import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.piu.PIUUsuarioSistemaExternoResponse;
import com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ChangePasswordRequest;
import com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.CrearRequest;
import com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.EliminarRequest;
import com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.ModificarRequest;
import com.keralty.aeusuarios.viewmodel.usuariosistemaexterno.siu.SetPasswordRequest;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import java.util.List;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;

@Path("/api/UsuarioSistemaExternoApi")
@RequestScoped
public class UsuarioSistemaExternoApi {

    UsuarioSistemaExternoService service;

    public UsuarioSistemaExternoApi(UsuarioSistemaExternoService service, JsonWebToken jwt) {
        this.service = service;
        TokenUtilities.getInstance().setJsonWebToken(jwt);
    }

    @GET
    @Path(value="/{usuarioSistemaExternoLogin}")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public UsuarioSistemaExterno getInstance(String usuarioSistemaExternoLogin) {
    	return service.getById(usuarioSistemaExternoLogin);
    }

    @GET
    @Path(value="/")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public List<UsuarioSistemaExterno> getPopulation(QueryRequest queryRequest){
    	return service.get(queryRequest);
    }

    @GET
    @Path(value="/getByOid")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public UsuarioSistemaExterno getByOid(UsuarioSistemaExternoOid oid) {
    	return service.getByOID(oid);
    }

    @GET
    @Path(value="/getByOIDWithHV")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public UsuarioSistemaExterno getByOIDWithHV(UsuarioSistemaExternoOid oid) {
    	return service.getByOIDWithHV(oid);
    }
    
    @POST
    @Path(value = "/GetUsuarioSistemaExternoDynamic")
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public InstanceResponseViewModel getUsuarioSistemaExternoDynamic(QueryRequest request) {
        UsuarioSistemaExternoOid oid = new UsuarioSistemaExternoOid();
        oid.fromJsonString(request.getJsonOID());
        return service.getUsuarioSistemaExternoDynamic(oid, request.getDisplaySetItems());
    }
    
    @POST
    @Path(value = "/GetPopulationDynamic")
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public PopulationResponseViewModel getUsuarioSistemaExternoPopulationDynamic(QueryRequest request) {
        return (PopulationResponseViewModel) service.getDynamic(request);
    }

    @POST
    @Path(value = "/crear")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse usuarioSistemaExternoCrear(CrearRequest request) {
        return service.crear(request);
    }
    

    @POST
    @Path(value = "/eliminar")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse usuarioSistemaExternoEliminar(EliminarRequest request) {
        return service.eliminar(request);
    }
    

    @POST
    @Path(value = "/modificar")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse usuarioSistemaExternoModificar(ModificarRequest request) {
        return service.modificar(request);
    }
    

    @POST
    @Path(value = "/setPassword")
    @RolesAllowed({"Admin","SuperAdmin"})
    public ServiceResponse usuarioSistemaExternoSetPassword(SetPasswordRequest request) {
        return service.setPassword(request);
    }
    

    @POST
    @Path(value = "/changePassword")
    @RolesAllowed({"UsuarioSistemaExterno"})
    public ServiceResponse usuarioSistemaExternoChangePassword(ChangePasswordRequest request) {
        return service.changePassword(request);
    }
    


    @POST
    @Path(value = "/PIU_UsuarioSistemaExterno")
    @Operation(hidden = true)
    @RolesAllowed({"Admin","SuperAdmin","UsuarioSistemaExterno"})
    public PIUUsuarioSistemaExternoResponse piuPIUUsuarioSistemaExterno(PopulationRequestViewModel request) {
        QueryRequest queryRequest = request.buildQueryRequest();
        PIUUsuarioSistemaExternoResponse response;
        try
        {
            response = new PIUUsuarioSistemaExternoResponse(service.piuPIUUsuarioSistemaExterno(queryRequest));
            if (queryRequest.getPageSize() > 0) {
                queryRequest.setPageSize(0);
                response.setTotalItems(service.getCount4PIUUsuarioSistemaExterno(queryRequest));
            }
        } catch (Exception e) {
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(e.getMessage());
            response = new PIUUsuarioSistemaExternoResponse();
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
