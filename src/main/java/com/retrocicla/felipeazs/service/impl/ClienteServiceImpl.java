package com.retrocicla.felipeazs.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.exceptions.ClienteServiceException;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.shared.Utils;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepo;
    
    @Autowired
    private Utils utils;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ClienteDto crearCliente(ClienteDto clienteDto) {
		
		//Asegurar que el cliente no existe en la base de datos
		ClienteEntity dbCliente = clienteRepo.findByEmail(clienteDto.getEmail());		
		if (dbCliente != null) throw new RuntimeException("El cliente ya existe en la Base de datos");
		
		ClienteEntity clienteEntity = new ClienteEntity();
		
		//Las propiedades del ClienteEntity tienen que ser iguales al de ClienteDto
		BeanUtils.copyProperties(clienteDto, clienteEntity);
		
		//Generacion de un id random para el cliente
		clienteEntity.setClienteId(utils.generarRandomId(16));		
		
		//Encriptacion del password
		clienteEntity.setEcryptedPassword(bCryptPasswordEncoder.encode(clienteDto.getPassword()));
		
		//Almacenar el cliente en la base de datos
		ClienteEntity saveCliente = clienteRepo.save(clienteEntity);
		
		ClienteDto returnValue = new ClienteDto();
		
		//Guardar las  propiedades del cliente en DB al ClienteDto para retornarlo como JSON
		BeanUtils.copyProperties(saveCliente, returnValue);
		
		return returnValue;
		
		
	}

	@Override
	public ClienteDto obtenerClienteByEmail(String email) {
		
		ClienteEntity dbCliente = clienteRepo.findByEmail(email);
		
		if (dbCliente == null) throw new UsernameNotFoundException(email);
		
		ClienteDto returnValue = new ClienteDto();
		BeanUtils.copyProperties(dbCliente, returnValue);
		
		return returnValue;
	}

	@Override
	public ClienteDto obtenerClienteById(String clienteid) {
		
		ClienteEntity dbCliente = clienteRepo.findByClienteId(clienteid);
		
		if (dbCliente == null) throw new UsernameNotFoundException(clienteid);
		
		ClienteDto returnValue = new ClienteDto();
		BeanUtils.copyProperties(dbCliente, returnValue);
		
		return returnValue;
	}

	@Override
	public ClienteDto actualizarCliente(String clienteid, ClienteDto cliente) {
		
		
		
		ClienteEntity dbCliente = clienteRepo.findByClienteId(clienteid);
		
		if (dbCliente == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		
		return null;
	}

	
    
    
}