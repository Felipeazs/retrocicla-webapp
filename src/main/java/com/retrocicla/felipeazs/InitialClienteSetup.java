package com.retrocicla.felipeazs;

import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.retrocicla.felipeazs.io.entity.AutoridadEntity;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.RolEntity;
import com.retrocicla.felipeazs.io.repository.AutoridadRepository;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.io.repository.RolRepository;
import com.retrocicla.felipeazs.shared.Utils;

@Component
public class InitialClienteSetup {
	
	@Autowired
	private AutoridadRepository autoridadRepo;
	
	@Autowired
	private RolRepository rolRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;
	
	@Autowired
	private Utils utils;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@EventListener //Permite realizar código cuando la applicación comienza
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		System.out.println("ready event...");
		
		AutoridadEntity readAutoridad = crearAutoridad("READ_AUTORIDAD");
		AutoridadEntity writeAutoridad = crearAutoridad("WRITE_AUTORIDAD");
		AutoridadEntity deleteAutoridad = crearAutoridad("DELETE_AUTORIDAD");
		
		RolEntity rolCliente = crearRol("ROL_CLIENTE", Arrays.asList(readAutoridad, writeAutoridad));
		RolEntity rolAdmin = crearRol("ROL_ADMIN", Arrays.asList(readAutoridad, writeAutoridad, deleteAutoridad));
		
		if (rolAdmin == null) return;
		
		ClienteEntity admin = new ClienteEntity();
		admin.setNombre("Felipe");
		admin.setApellido("Zapata");
		admin.setEmail("felipeazs@gmail.com");
		admin.setEmailVerificationStatus(true);
		admin.setClienteId(utils.generateClienteId(30));
		admin.setEcryptedPassword(bcryptPasswordEncoder.encode("1234"));
		admin.setRoles(Arrays.asList(rolAdmin));
		
		if (clienteRepo.findByEmail(admin.getEmail()) != null) {
			return;
		} else {
			clienteRepo.save(admin);
		}	
		
	}
	
	@Transactional
	private AutoridadEntity crearAutoridad(String nombre) {
		
		System.out.println(nombre);
		
		AutoridadEntity autoridad = autoridadRepo.findByNombre(nombre);
		
		if (autoridad == null) {
			autoridad = new AutoridadEntity(nombre);
			autoridadRepo.save(autoridad);
		}
		
		return autoridad;
	}
	
	@Transactional
	private RolEntity crearRol(String nombre, Collection<AutoridadEntity> autoridades) {
		
		RolEntity rol = rolRepo.findByNombre(nombre);
		if (rol == null) {
			rol = new RolEntity(nombre);
			rol.setAutoridades(autoridades);
			rolRepo.save(rol);
		}
		return rol;
	}

}
