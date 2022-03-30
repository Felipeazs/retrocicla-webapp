package com.retrocicla.felipeazs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.retrocicla.felipeazs.io.entity.AutoridadEntity;
import com.retrocicla.felipeazs.io.repository.AutoridadRepository;

@Component
public class InitialClienteSetup {
	
	@Autowired
	private AutoridadRepository autoridadRepo;
	
	@EventListener //Permite realizar código cuando la applicación comienza
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		System.out.println("ready event...");
		
	}
	
	private AutoridadEntity crearAutoridad(String nombre) {
		
		AutoridadEntity autoridad = autoridadRepo.findByNombre(nombre);
		if (autoridad == null) {
			autoridad = new AutoridadEntity(nombre);
			autoridadRepo.save(autoridad);
		}
		
		return autoridad;
	}

}
