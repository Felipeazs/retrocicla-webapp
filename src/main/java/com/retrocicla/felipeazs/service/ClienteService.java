package com.retrocicla.felipeazs.service;

import com.retrocicla.felipeazs.model.dto.ClienteDto;

public interface ClienteService {
	
	public ClienteDto crearCliente(ClienteDto cliente);
	
	public ClienteDto obtenerClienteByEmail(String email);

	public ClienteDto obtenerClienteById(String id);

}
