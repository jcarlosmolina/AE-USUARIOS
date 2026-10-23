package com.keralty.integraciones.parametricas;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("")
@RegisterRestClient(configKey="integraciones_parametricas")
public interface ParametricasProxy {

	@POST
	@Path("/getParametric")
	@ClientHeaderParam(name="aplicationCod", value="${com.keralty.integraciones.codaplicacion}")
	@ClientHeaderParam(name="user", value="${com.keralty.integraciones.parametricas.user}")
	@ClientHeaderParam(name="businessFunction", value="${com.keralty.integraciones.funcionnegocio}")
	List<DatoParametrica> getParametric(@HeaderParam("Authorization") String token, @HeaderParam("petitionId") String petitionId, @HeaderParam("dateRequest") String dateRequest, @RequestBody GetParametricRequest request);
}
