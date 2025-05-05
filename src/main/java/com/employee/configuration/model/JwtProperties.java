package com.employee.configuration.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {

	private String secretKey;
	private long jwtExpirationTIme;
	public String getSecretKey() {
		return secretKey;
	}
	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}
	public long getJwtExpirationTIme() {
		return jwtExpirationTIme;
	}
	public void setJwtExpirationTIme(long jwtExpirationTIme) {
		this.jwtExpirationTIme = jwtExpirationTIme;
	}
	
	
	
}
