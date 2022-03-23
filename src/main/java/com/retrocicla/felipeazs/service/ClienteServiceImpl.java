package com.retrocicla.felipeazs.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.retrocicla.felipeazs.config.Security;
import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repo;
    
//    @Autowired
//    private Security security;

    @Override
    public List<Cliente> list() {
    	
        return repo.findAll();
    }

	@Override
	public void add(Cliente cliente) {
		
		Cliente cli = repo.findByEmail(cliente.getEmail());
		if (cli == null){
			cliente.setCreatedAt(LocalDate.now());
			cliente.setRol("cliente");
//			cliente.setEncpass(security.passwordEncoder().encode(cliente.getPassword()));	
					
			repo.save(cliente);
		} else {
			System.out.println("Cliente ya registrado");
		}
		
		
		
	}

	@Override
	public Cliente getCliente(String name) {
		
		return repo.findByEmail(name);
	}
}