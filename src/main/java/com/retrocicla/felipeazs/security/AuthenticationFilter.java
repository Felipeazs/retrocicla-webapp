package com.retrocicla.felipeazs.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.retrocicla.felipeazs.SpringApplicationContext;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.ui.model.request.ClienteLoginRequestModel;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
		 
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			ClienteLoginRequestModel creds = new ObjectMapper().readValue(request.getInputStream(), ClienteLoginRequestModel.class);
			
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							creds.getEmail(),
							creds.getPassword(),
							new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException(e);			
		} 		
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		
		String username = ((ClientePrincipal) auth.getPrincipal()).getUsername();
		
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SecurityConstants.getTokenSecret())
				.compact();
		
		ClienteService clienteService = (ClienteService) SpringApplicationContext.getBean("clienteServiceImpl");
		ClienteDto cliente = clienteService.obtenerClienteByEmail(username);
		
		response.getWriter().append("LOGIN SUCCESSFUL, welcome " + cliente.getNombre());
		
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
		response.addHeader("UserId", cliente.getClienteId());				
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		
		response.getWriter().append("UNSUCCESSFUL LOGIN: el cliente no se encuentra registrado ");	
	}
}
