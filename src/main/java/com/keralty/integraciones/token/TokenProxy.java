package com.keralty.integraciones.token;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@Path("")
@RegisterRestClient(configKey="integraciones_token")
public interface TokenProxy {
	
	@POST
	@Path("/token")
	@ClientHeaderParam(name="Content-Type", value="application/x-www-form-urlencoded")
	@ClientHeaderParam(name="Authorization", value="Basic ${com.keralty.integraciones.token.hash}")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public TokenResponse token( @FormParam("grant_type") String grantType, @FormParam("username") String userName, @FormParam("password") String password);
}
