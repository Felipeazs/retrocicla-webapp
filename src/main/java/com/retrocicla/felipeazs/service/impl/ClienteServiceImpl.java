package com.retrocicla.felipeazs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.exceptions.ClienteServiceException;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.PasswordResetTokenEntity;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.io.repository.PasswordResetTokenRepository;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.model.dto.DireccionDto;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.shared.AmazonSES;
import com.retrocicla.felipeazs.shared.Utils;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepo;
    
    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepo;
        
    @Autowired
    private Utils utils;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public ClienteDto crearCliente(ClienteDto clienteDto) {
		
		//Asegurar que el cliente no existe en la base de datos
		ClienteEntity dbCliente = clienteRepo.findByEmail(clienteDto.getEmail());		
		if (dbCliente != null) throw new RuntimeException("El cliente ya existe en la Base de datos");
						
		//Setear los propiedades de direccion y devolverlos al clienteDto
		int i = 0;
		for (DireccionDto direccion : clienteDto.getDirecciones()) {			
			direccion.setClienteDetails(clienteDto);
			direccion.setDireccionId(utils.generateRandomId(30));
			clienteDto.getDirecciones().set(i, direccion);
			i++;
		}
		
		//Las propiedades del ClienteEntity tienen que ser iguales al de ClienteDto
		ModelMapper modelMapper = new ModelMapper();
		ClienteEntity clienteEntity = modelMapper.map(clienteDto, ClienteEntity.class);
		
		//Generacion de un id random para el cliente
		String publicClienteId = utils.generateRandomId(30);
		clienteEntity.setClienteId(publicClienteId);		
				
		//Encriptacion del password
		clienteEntity.setEcryptedPassword(bCryptPasswordEncoder.encode(clienteDto.getPassword()));
		
		//Generacion del email verification Token
		clienteEntity.setEmailVerificationToken(utils.generateEmailVerificationToken(publicClienteId));
		clienteEntity.setEmailVerificationStatus(false);
		
		//Almacenar el cliente en la base de datos
		ClienteEntity saveCliente = clienteRepo.save(clienteEntity);
			
		//Guardar las  propiedades del cliente en DB al ClienteDto para retornarlo como JSON
		ClienteDto returnValue = modelMapper.map(saveCliente, ClienteDto.class);
				
		return returnValue;
		
		
	}

	@Override
	public ClienteDto obtenerClienteByEmail(String email) {
		
		ClienteEntity dbCliente = clienteRepo.findByEmail(email);
		
		if (dbCliente == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
	
		ClienteDto returnValue = new ClienteDto();		
		BeanUtils.copyProperties(dbCliente, returnValue);
				
		return returnValue;
	}

	@Override
	public ClienteDto obtenerClienteById(String clienteid) {
		
		ClienteEntity dbCliente = clienteRepo.findByClienteId(clienteid);
		
		if (dbCliente == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		ModelMapper modelMapper = new ModelMapper();
		ClienteDto returnValue = modelMapper.map(dbCliente, ClienteDto.class);
		
		return returnValue;
	}

	@Override
	public ClienteDto actualizarCliente(String clienteid, ClienteDto cliente) {		
		
		ClienteEntity dbCliente = clienteRepo.findByClienteId(clienteid);
		
		if (dbCliente == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		dbCliente.setNombre(cliente.getNombre());
		dbCliente.setApellido(cliente.getApellido());
		
		ClienteEntity clienteEntity =  clienteRepo.save(dbCliente);
		
		ClienteDto returnValue = new ClienteDto();
		
		BeanUtils.copyProperties(clienteEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public void eliminarCliente(String clienteid) {

		ClienteEntity dbCliente = clienteRepo.findByClienteId(clienteid);
		
		if (dbCliente == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		clienteRepo.delete(dbCliente);
		
	}

	@Override
	public List<ClienteDto> obtenerClientes(int page, int limit) {
		
		if (page > 0) page = page - 1;
		
		List<ClienteDto> returnValue = new ArrayList<>();
		
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<ClienteEntity> pageClientes =  clienteRepo.findAll(pageableRequest);
		
		if (pageClientes == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
	
		List<ClienteEntity> clientes = pageClientes.getContent();
				
		ModelMapper modelMapper = new ModelMapper();
		
		for (ClienteEntity cliente : clientes) {
			returnValue.add(modelMapper.map(cliente, ClienteDto.class));			
		}
		
		return returnValue;
	}

	@Override
	public boolean verifyEmailToken(String token) {
		
		boolean returnValue = false;
		
		//Find user by token
		ClienteEntity clienteEntity = clienteRepo.findByEmailVerificationToken(token);
		
		if (clienteEntity != null) {
			boolean hasTokenExpired = Utils.hasTokenExpired(token);
			if (!hasTokenExpired) {
				clienteEntity.setEmailVerificationToken(null);
				clienteEntity.setEmailVerificationStatus(Boolean.TRUE);
				clienteRepo.save(clienteEntity);
				returnValue = true;
			}
		}
		
		return returnValue;
	}

	@Override
	public boolean requestPasswordReset(String email) {
		
		boolean returnValue = false;
		
		ClienteEntity cliente = clienteRepo.findByEmail(email);
		
		if (cliente == null) {
			return returnValue;
		}
		
		String token = utils.generatePasswordResetToken(cliente.getClienteId());
		
		PasswordResetTokenEntity passwordResetToken = new PasswordResetTokenEntity();
		passwordResetToken.setToken(token);
		passwordResetToken.setClienteDetails(cliente);
		passwordResetTokenRepo.save(passwordResetToken);
		
		returnValue = new AmazonSES().sendPasswordResetRequest(
				cliente.getNombre(),
				cliente.getEmail(),
				token);
		
		return returnValue;
	}

	@Override
	public boolean verifyPasswordResetToken(String token, String password) {
		
		boolean returnValue = false;

		PasswordResetTokenEntity passwordToken = passwordResetTokenRepo.findByToken(token);
		
		if (passwordToken == null) {
			return returnValue;
		}
		
		passwordToken.setToken(null);		
		passwordToken.getClienteDetails().setEcryptedPassword(bCryptPasswordEncoder.encode(password));
		
		passwordResetTokenRepo.save(passwordToken);
		
		returnValue = true;
		
		return returnValue;
	}

	
    
    
}