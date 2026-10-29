package com.keralty.integraciones.token;


import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TokenUtils {

	@RestClient
	TokenProxy parametricasToken;
	
	@ConfigProperty(name="com.keralty.integraciones.token.usr")
	String username;
	
	@ConfigProperty(name="com.keralty.integraciones.token.pwd")
	String password;
	
	public TokenUtils() {
		
	}

	public String getTokenValue() throws Exception {
		try {
			
			TokenResponse tokenResponse = parametricasToken.token("password", username, password);
			return tokenResponse.getTokenType() + " " + tokenResponse.getAccessToken();
		} catch (Exception e) {
			org.slf4j.LoggerFactory.getLogger(this.getClass().getName()).error("TKN-0010. Error obteniendo token. " + e.getMessage());
			throw new Exception("TKN-0010");
		}			
	}
}
