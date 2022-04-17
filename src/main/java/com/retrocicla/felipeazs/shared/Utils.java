package com.retrocicla.felipeazs.shared;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.dto.ProductoDto;
import com.retrocicla.felipeazs.security.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
	private final String NUMBER = "123456789";

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
			Claims claims = Jwts.parser().setSigningKey(SecurityConstants.getTokenSecret()).parseClaimsJws(token)
					.getBody();

			Date tokenExpirationDate = claims.getExpiration();
			Date today = new Date();

			returnValue = tokenExpirationDate.before(today);

		} catch (ExpiredJwtException ex) {
			returnValue = true;
		}

		return returnValue;

	}

	public String generateEmailVerificationToken(String publicId) {

		String token = Jwts.builder().setSubject(publicId)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();

		return token;
	}

	public String generatePasswordResetToken(String clienteId) {

		String token = Jwts.builder().setSubject(clienteId)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.PASSWORD_RESET_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret()).compact();

		return token;
	}

	public String generateProductId(int length) {

		StringBuilder rv = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			rv.append(NUMBER.charAt(RANDOM.nextInt(NUMBER.length())));
		}
		return new String(rv);

	}

	public String generateProductoCodigo(ProductoDto producto) {

		String codigo = "";

		String tipo = producto.getTipo();
		String prenda = producto.getPrenda();
		String genero = producto.getGenero();
		String material = producto.getMaterial();
		String talla = producto.getTalla();
		String color = producto.getColor();
		String patron = producto.getPatron();
		String origen = producto.getOrigen();
		
		switch (tipo) {
		case "vacio":
			codigo = "%";
			break;
		case "prenda":
			codigo = "PR";
			break;
		case "material":
			codigo = "MA";
			break;
		}
		
		switch (prenda) {
		case "vacio":
			codigo = codigo.concat("%");
			break;
		case "pantalón":
			codigo = codigo.concat("PT");
			break;
		case "polera":
			codigo = codigo.concat("PL");
			break;
		}
		
		switch (genero) {
		case "vacio":
			codigo = codigo.concat("%");
			break;
		case "femenino":
			codigo = codigo.concat("FM");
			break;
		case "masculino":
			codigo = codigo.concat("MC");
			break;
		}
		
		switch (material) {
		case "vacio":
			codigo = codigo.concat("%");
			break;
		case "algodón":
			codigo = codigo.concat("AL");
			break;
		case "poliester":
			codigo = codigo.concat("PO");
			break;
		case "spandex":
			codigo = codigo.concat("SP");
			break;
		}
		
		switch (talla) {
		case "vacio":
			codigo = codigo.concat("%");
			break;
		case "s":
			codigo = codigo.concat("S");
			break;
		case "m":
			codigo = codigo.concat("M");
			break;
		case "36":
			codigo = codigo.concat("36");
			break;
		}
		
		switch (color) {
		case "vacio":
			codigo = codigo.concat("%");
			break;
		case "azul":
			codigo = codigo.concat("AZ");
			break;
		case "blanco":
			codigo = codigo.concat("BL");
			break;
		case "café":
			codigo = codigo.concat("CF");
			break;
		}
		
		switch (patron) {
		case "vacio":
			codigo = codigo.concat("%");
			break;
		case "true":
			codigo = codigo.concat("P");
			break;
		case "false":
			codigo = codigo.concat("L");
			break;
		}
		
		switch (origen) {
		case "vacio":
			codigo = codigo.concat("%");
			break;
		case "china":
			codigo = codigo.concat("CN");
			break;
		case "chile":
			codigo = codigo.concat("CL");
			break;
		}
		
		System.out.println(codigo);
		
		return codigo;

	}
}
