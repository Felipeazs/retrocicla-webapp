package com.retrocicla.felipeazs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.security.ClientePrincipal;

@Service
public class ClienteSecurityService implements UserDetailsService{
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		ClienteEntity clienteEntity = clienteRepository.findByEmail(email);				
		
		if (clienteEntity == null) throw new UsernameNotFoundException(email);
		
		System.out.println("cliente: " + clienteEntity.getEmail());
		System.out.println("autoridades: " + clienteEntity.getRoles());
		
		return new ClientePrincipal(clienteEntity);
		
		
//		return new User(
//				clienteEntity.getEmail(), 
//				clienteEntity.getEcryptedPassword(), 
//				clienteEntity.getEmailVerificationStatus(),
//				true, true, true, Arrays.asList(clienteEntity.getRoles()));		
	}

}
