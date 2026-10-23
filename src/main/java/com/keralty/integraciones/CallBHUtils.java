// Utility para el MS aeusuarios
package com.keralty.integraciones;

import java.sql.Timestamp;
import java.util.Set;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.global.UsuarioSistemaExternoConstants;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.oid.FuncionarioOid;
import com.keralty.aeusuarios.service.ApiGatewayProxy;
import com.keralty.aeusuarios.service.FuncionarioService;
import com.keralty.aeusuarios.viewmodel.logllamadasbh.siu.CreateinstanceRequest;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CallBHUtils {

	UserFunctions userFunctions;

    @RestClient
    ApiGatewayProxy apiGatewayProxy;

    FuncionarioService serviceFuncionario;

    JsonWebToken jwt;

	@Inject
	public CallBHUtils(FuncionarioService serviceFuncionario, UserFunctions userFunctions, JsonWebToken jwt){
		this.serviceFuncionario = serviceFuncionario;
		this.userFunctions = userFunctions;
		this.jwt = jwt;
	}
	
	public String getUsuario() {
		
		if (jwt != null && jwt.getName() != null) {
			Set<String> grupos = jwt.getGroups();
			if (grupos.contains(UsuarioSistemaExternoConstants.CLASS_NAME)) {
				int i = jwt.getName().indexOf(":");
				if (i >= 0) {
					String nombre = jwt.getName().substring(i+1);
					nombre = nombre.replaceAll("\"", "").replaceAll(" ", "").replaceAll("}", "");
					return nombre;
				} else {
					org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("CallBHUtils getUsuario - GU020");
				}
			} else {
				try {
					Funcionario funcionario = serviceFuncionario.getByOID(new FuncionarioOid( Long.valueOf(jwt.getName())));
					return funcionario.getFuncionarioUsuario();
				} catch (Exception e) {
		    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("CallBHUtils getUsuario - " + e.getMessage());
				}
			}
		}
		
		return "";
	}
	
    
    public String fromJsonToString(Object objetoJson) {
    	String retorno = "";
		ObjectMapper mapper= new ObjectMapper();
		if (objetoJson != null) {
			try {
				retorno = mapper.writeValueAsString(objetoJson);
			} catch (JsonProcessingException e) {
	    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(e.getMessage());
			}
		}
		return retorno;
    }

    public byte[] fromJsonToByteArray(Object objetoJson) {
    	byte[] retorno = null;
		ObjectMapper mapper= new ObjectMapper();
		if (objetoJson != null) {
			try {
				retorno = mapper.writeValueAsBytes(objetoJson);
			} catch (JsonProcessingException e) {
	    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(e.getMessage());
			}
		}
		return retorno;
    }

	public void guardarLlamadaBH(Timestamp fechaHora, String usuario, 
			String capacidad, String servicio, String numSolicitud, Object peticion, Object respuesta,
			Double tiempoEjecucion, String textoError){
		if (servicio == null || servicio.isEmpty()) {
			servicio = capacidad;
		}
		
		boolean exito = textoError == null || textoError.isEmpty();
		
		String texto = "Llamada a: " + servicio + " - " + capacidad;
		if (exito) {
			texto += " - Exito";
		} else {
			texto += " - Error";
		}
		if (numSolicitud != null && !numSolicitud.isEmpty()) {
			texto += " - Numero solicitud:" + numSolicitud;
		}
		if (tiempoEjecucion != null) {
			texto += " - Tiempo (seg):" + String.valueOf( tiempoEjecucion);
		}
		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).info(texto);
		
		String peticionStr = fromJsonToString(peticion);
		String respuestaStr = fromJsonToString(respuesta);
		
		CreateinstanceRequest request = new CreateinstanceRequest();
		request.setLogLlamadasBHcreateinstancepatrCapacidad(capacidad != null ? capacidad.toUpperCase() : "");
		request.setLogLlamadasBHcreateinstancepatrFechaHora(fechaHora);
		request.setLogLlamadasBHcreateinstancepatrPeticion(peticionStr);
		request.setLogLlamadasBHcreateinstancepatrRespuesta(respuestaStr);
		request.setLogLlamadasBHcreateinstancepatrServicio(servicio);
		request.setLogLlamadasBHcreateinstancepatrSolicitud(numSolicitud);
		request.setLogLlamadasBHcreateinstancepatrTextoError(textoError);
		request.setLogLlamadasBHcreateinstancepatrTiempoEjecucion(tiempoEjecucion);
		request.setLogLlamadasBHcreateinstancepatrTipoServicio("REST Service");
		request.setLogLlamadasBHcreateinstancepatrUsuario(usuario);

		try {
			apiGatewayProxy.createinstanceAsync(request);
		} catch(Exception e) {
    		org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error(e.getMessage());
		}
	}
}
