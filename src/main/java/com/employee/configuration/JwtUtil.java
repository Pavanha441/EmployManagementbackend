package com.employee.configuration;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.employee.configuration.model.JwtProperties;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	// private final String secretKey = "superSecretKeyForJwtShouldBeLongEnough123";
	// private final Long jwtExpirationTIme = 60000L;

	private final JwtProperties jwtProperties;

	public JwtUtil(JwtProperties jwtProperties) {
		super();
		this.jwtProperties = jwtProperties;
	}

	public String generateToken(UserDetails userDetails) {

		return Jwts.builder().setSubject(userDetails.getUsername()).claim("roles", userDetails.getAuthorities())
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getJwtExpirationTIme()))
				.signWith(Keys.hmacShaKeyFor(jwtProperties.getSecretKey().getBytes()), SignatureAlgorithm.HS256)
				.compact();
		// return null;
	}

//	For extracting userName

	public String getUsernameFromTOken(String token) {
		return Jwts.parserBuilder().setSigningKey(jwtProperties.getSecretKey().getBytes()).build().parseClaimsJws(token)
				.getBody().getSubject();
	}

//	Validate token
	public boolean validateToken(String token, UserDetails userDetails) {
		String userName = getUsernameFromTOken(token);
		return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
	}

	private boolean isTokenExpired(String token) {

		return Jwts.parserBuilder().setSigningKey(jwtProperties.getSecretKey().getBytes()).build().parseClaimsJws(token)
				.getBody().getExpiration().before(new Date());
	}
}
