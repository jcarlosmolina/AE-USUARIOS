package com.keralty.aeusuarios.service;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCASESORESRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCASESORESResponse;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/api/GlobalServicesApi")
@RegisterRestClient(configKey="ae-usuarios")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeusuarios}")
public interface GlobalServicesItSelf {

	
	// Definimos el mismo interfaz pero asíncrono
    @POST
    @Path(value = "/OGSINCASESORES_Async")
    public CompletionStage<OGSINCASESORESResponse> oGSINCASESORES_Async(OGSINCASESORESRequest request);

}
