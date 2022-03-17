package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Cliente;

public interface ClienteService {
	
	public List<Cliente> list();
	
	void add(Cliente cliente);

	public Cliente getCliente(String name);

}
