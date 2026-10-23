package com.keralty.aeusuarios.service;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.keralty.aeusuarios.viewmodel.ServiceResponse;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.OGSINCSUCURSALESRequest;
import com.keralty.aeusuarios.viewmodel.globalservices.siu.TGSINCTIPOSIDENTIFICACIONRequest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/api/GlobalServicesApi")
@RegisterRestClient(configKey="ae-configuraciones")
@ClientHeaderParam(name = "Authorization", value = "Bearer {com.keralty.aeusuarios.utils.TokenUtilities.getToken4aeconfiguraciones}")
public interface GlobalServiceDeAEConfiguraciones {

    @POST
    @Path(value = "/OGSINCSUCURSALES")
    public ServiceResponse oGSINCSUCURSALES(OGSINCSUCURSALESRequest request);
    
    @POST
    @Path(value = "/TGSINCTIPOSIDENTIFICACION")
    public ServiceResponse tGSINCTIPOSIDENTIFICACION(TGSINCTIPOSIDENTIFICACIONRequest request);
    
}
