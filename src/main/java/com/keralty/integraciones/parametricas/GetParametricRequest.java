package com.keralty.integraciones.parametricas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetParametricRequest {

	private String codTable;
	
	private String nomTable;

	@JsonProperty("codTable")
	public String getCodTable() {
		return codTable;
	}

	public void setCodTable(String codTable) {
		this.codTable = codTable;
	}

	@JsonProperty("nomTable")
	public String getNomTable() {
		return nomTable;
	}

	public void setNomTable(String nomTable) {
		this.nomTable = nomTable;
	}
	
}
