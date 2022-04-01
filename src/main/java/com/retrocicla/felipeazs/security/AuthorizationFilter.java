package com.retrocicla.felipeazs.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;

import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends BasicAuthenticationFilter {
	
	private final ClienteRepository clienteRepo;

	public AuthorizationFilter(AuthenticationManager authManager, ClienteRepository clienteRepo) {
		super(authManager);
		this.clienteRepo = clienteRepo;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		String header = request.getHeader(SecurityConstants.HEADER_STRING);
		
		if (header == null || !header.startsWith(SecurityConstants.TOKEN_PREFIX)) {
			chain.doFilter(request, response);
			return;
		}
		
		UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
	
		String token = request.getHeader(SecurityConstants.HEADER_STRING);
		
		if (token != null) {
			token = token.replace(SecurityConstants.TOKEN_PREFIX, "");
			
			String cliente = Jwts.parser().setSigningKey(SecurityConstants.getTokenSecret())
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
			
			if (cliente != null) {
				ClienteEntity clienteEntity = clienteRepo.findByEmail(cliente);
				if (clienteEntity == null) return null;
				
				ClientePrincipal clientePrincipal = new ClientePrincipal(clienteEntity); 
				return new UsernamePasswordAuthenticationToken(clientePrincipal, null, clientePrincipal.getAuthorities());
			}
			return null;
		}
		
		return null;
	}
	
	

}
