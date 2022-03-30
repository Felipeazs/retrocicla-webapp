package com.retrocicla.felipeazs.shared;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.security.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
	private final String NUMBER = "0123456789";
	
	
	public String generateClienteId(int length) {
		
		StringBuilder rv = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			rv.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));			
		}
		return new String(rv);
	}
	
	public String generateDireccionId(int length) {
		
		StringBuilder rv = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			rv.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));			
		}
		return new String(rv);
	}

	public static boolean hasTokenExpired(String token) {
		
		boolean returnValue = false;
		
		try {
			Claims claims = Jwts.parser().setSigningKey(SecurityConstants.getTokenSecret()).parseClaimsJws(token).getBody();
			
			Date tokenExpirationDate = claims.getExpiration();
			Date today = new Date();
					
			returnValue = tokenExpirationDate.before(today);
			
		} catch (ExpiredJwtException ex) {
			returnValue = true;
		}
		
		return returnValue;
		
	}

	public String generateEmailVerificationToken(String publicId) {
		
		String token = Jwts.builder()
				.setSubject(publicId)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
				.compact();
				
		return token;
	}

	public String generatePasswordResetToken(String clienteId) {
		
		String token = Jwts.builder()
				.setSubject(clienteId)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.PASSWORD_RESET_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
				.compact();
				
		return token;
	}

	public String generateProductId(int length) {
		
		StringBuilder rv = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			rv.append(NUMBER.charAt(RANDOM.nextInt(NUMBER.length())));			
		}
		return new String(rv);

	}
}











