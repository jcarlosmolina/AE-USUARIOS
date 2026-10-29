// Utility para el MS aeusuarios
package com.keralty.integraciones.parametricas;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.keralty.aeusuarios.global.STDFunctions;
import com.keralty.integraciones.CallBHUtils;
import com.keralty.integraciones.IntegracionesUtils;
import com.keralty.integraciones.token.TokenUtils;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ParametricasUtils {

	TokenUtils tokenUtils;
	
	CallBHUtils callBHUtils;

	@RestClient
	ParametricasProxy parametricas;
	
	@ConfigProperty(name="com.keralty.integraciones.parametricas.asesor.nom_table")
	String nomTablaAsesores;
	
	@ConfigProperty(name="com.keralty.integraciones.parametricas.tipoagente.nom_table")
	String nomTablaTipoAgente;

	@ConfigProperty(name="com.keralty.integraciones.parametricas.agentexproducto.nom_table")
	String nomTablaAgentexProducto;
	
	public ParametricasUtils(CallBHUtils callBHUtils, TokenUtils tokenUtils) {
		this.callBHUtils = callBHUtils;
		this.tokenUtils = tokenUtils;
	}

	private List<DatoParametrica> consultarPorNombre(String nombre) {
		GetParametricRequest request = new GetParametricRequest();
		request.setNomTable(nombre);
		String textoError = null;
		long startTime = System.currentTimeMillis();
		long endTime = startTime;
		Double tiempoEjecucion = 0.0;
		Timestamp fechaHora = STDFunctions.systemDateTimeFun();	
		List<DatoParametrica> respuesta = new ArrayList<DatoParametrica>();
		try {
			respuesta = parametricas.getParametric(tokenUtils.getTokenValue(), "ID", IntegracionesUtils.getRequestDate(), request);
			endTime = System.currentTimeMillis();
		} catch (Exception e) {
			endTime = System.currentTimeMillis();
			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("INT-0030. " + e.getMessage());
			textoError = e.getMessage();
		}
		tiempoEjecucion = (double) ((endTime - startTime)/1000.0f);
		
		callBHUtils.guardarLlamadaBH(fechaHora, callBHUtils.getUsuario(), "getParametric", "Parametric", null, request, respuesta, tiempoEjecucion, textoError);
		
		return respuesta;
	}
	
	public List<DatoParametrica> getAsesores() {
		return consultarPorNombre(nomTablaAsesores);
	}
	
	public List<DatoParametrica> getTipoAgenteCORE() throws  Exception {
		return consultarPorNombre(nomTablaTipoAgente);
		
	}

	public List<DatoParametrica> getAgentesXProductoCORE() {
		return consultarPorNombre(nomTablaAgentexProducto);
	}
	
	public static java.sql.Date parseDate(String formattedDate, String datePattern) throws ParseException {
		java.sql.Date date = null;
		formattedDate = formattedDate.replace("a.m.", "AM");
		formattedDate = formattedDate.replace("a. m.", "AM");
		formattedDate = formattedDate.replace("A.M.", "AM");
		formattedDate = formattedDate.replace("A. M.", "AM");
		formattedDate = formattedDate.replace("p.m.", "PM");
		formattedDate = formattedDate.replace("p. m.", "PM");
		formattedDate = formattedDate.replace("P.M.", "PM");
		formattedDate = formattedDate.replace("P. M.", "PM");
		if (formattedDate != null && !formattedDate.isEmpty()) {
			SimpleDateFormat sdf = new SimpleDateFormat(datePattern);
			java.util.Date parsedDate = sdf.parse(formattedDate);
			date = new java.sql.Date(parsedDate.getTime());
		}
		return date;
	}
	public static String[] descomponerNombreCompleto(String nombreCompleto, boolean reverseOrder) {
		String nombre1 = "";
		String nombre2 = "";
		String apellido1 = "";
		String apellido2 = "";


		String[] partesNombre = nombreCompleto.split("\\s+", 4);

		if (reverseOrder) {
			nombre1 = partesNombre[0];
			if (partesNombre.length == 2) {
				nombre1 = partesNombre[1];
				apellido1 = partesNombre[0];
			}
			if (partesNombre.length == 3) {
				nombre1 = partesNombre[1];
				nombre2 = partesNombre[2];
				apellido1 = partesNombre[0];
			}
			if (partesNombre.length > 3) {
				nombre1 = partesNombre[2];
				nombre2 = partesNombre[3];
				apellido1 = partesNombre[0];
				apellido2 = partesNombre[1];
			}
		} else {
			nombre1 = partesNombre[0];
			if (partesNombre.length == 2) {
				apellido1 = partesNombre[1];
			}
			if (partesNombre.length > 2) {
				nombre2 = partesNombre[1];
				apellido1 = partesNombre[2];
			}
			if (partesNombre.length > 3) {
				apellido2 = partesNombre[3];
			}
		}

		String[] resultado = new String[4];
		resultado[0] = nombre1;
		resultado[1] = nombre2;
		resultado[2] = apellido1;
		resultado[3] = apellido2;
		return resultado;
	}

	public static String getDescripcionPorCodigo(List<DatoParametrica> parametricas, String codigo) {

		for(DatoParametrica dato  : parametricas) {
			if (dato.getCode().equalsIgnoreCase(codigo)) {
				return dato.getDescription();
			}
		}
		return null;
	}

}
