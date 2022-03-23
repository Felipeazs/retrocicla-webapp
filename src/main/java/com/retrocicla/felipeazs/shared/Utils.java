package com.retrocicla.felipeazs.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {
	
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
	private final String NUMBER = "0123456789";
	
	
	public String generarRandomId(int length) {
		return generateRandomString(length);
	}

	private String generateRandomString(int length) {
		StringBuilder rv = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			rv.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
			
		}
		return new String(rv);
	}

}
