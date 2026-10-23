package com.keralty.integraciones.parametricas;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DatoParametrica {

	private String code;
	
	private String legalCode;
	
	private String name;
	
	private String description;
	
	private List<DatoAdicionalParametrica> additionalAttributes;

	@JsonProperty("code")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@JsonProperty("legalCode")
	public String getLegalCode() {
		return legalCode;
	}

	public void setLegalCode(String legalCode) {
		this.legalCode = legalCode;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@JsonProperty("additionalAttributes")
	public List<DatoAdicionalParametrica> getAdditionalAttributes() {
		return additionalAttributes;
	}

	public void setAdditionalAttributes(List<DatoAdicionalParametrica> additionalAttributes) {
		this.additionalAttributes = additionalAttributes;
	}
	
	@JsonIgnore
	public String getValorDeAdicional(String name) {
		
		for (DatoAdicionalParametrica datoAdicionalParametrica : this.additionalAttributes) {
			if (datoAdicionalParametrica.getAttributeName().equalsIgnoreCase(name)) {
				return datoAdicionalParametrica.getAttributeValue();
			}
		}
		
		return "";
	}

}
