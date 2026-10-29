package com.keralty.integraciones;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IntegracionesUtils {

	public static final String MSGERRORTECNICO = "Estamos presentando fallas tecnicas. Pruebe de nuevo pasados unos minutos.";

	public static String getTextoErrorUsuarioFinal(String codigo) {
		if (codigo != null) return MSGERRORTECNICO + " " + codigo;
		return MSGERRORTECNICO;
	}
	
	public static Timestamp systemDateTimeFun() {

		Date lDate = new Date();
		long lnMilisegundos = lDate.getTime();

		return new Timestamp(lnMilisegundos);
	}
	
	public static String getRequestDate() {
		java.util.Date currentDate = new java.util.Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		return dateFormat.format(currentDate); 
	}

}
