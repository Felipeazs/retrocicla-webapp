package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.dto.ClienteDto;

public interface ClienteService {
	
	public ClienteDto crearCliente(ClienteDto cliente);
	
	public ClienteDto obtenerClienteByEmail(String email);

	public ClienteDto obtenerClienteById(String id);

	public ClienteDto actualizarCliente(String clienteid, ClienteDto cliente);
	
	void eliminarCliente(String clienteid);

	public List<ClienteDto> obtenerClientes(int page, int limit);

	public boolean verifyEmailToken(String token);

	public boolean requestPasswordReset(String email);

	public boolean verifyAndResetPassword(String token, String password);

}
