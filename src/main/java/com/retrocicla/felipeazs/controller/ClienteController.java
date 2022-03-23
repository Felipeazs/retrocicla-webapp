package com.retrocicla.felipeazs.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.exceptions.ClienteServiceException;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.ui.model.request.ClienteRequestModel;
import com.retrocicla.felipeazs.ui.model.response.ClienteRest;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;


// Basic CRUD
@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping(
			path = "/{clienteid}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) // Retorna el valor en XML o JSON
	public ClienteRest getCliente(@PathVariable String clienteid) {
		
		ClienteRest returnValue = new ClienteRest();
			
		ClienteDto cliente = clienteService.obtenerClienteById(clienteid);
		
		BeanUtils.copyProperties(cliente, returnValue);
		
		return returnValue;
	}
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, //La data entregada puede ir en XML o JSON
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ClienteRest createCliente(@RequestBody ClienteRequestModel clienteDetails) throws Exception {
		
		if (clienteDetails.getNombre().isEmpty() ||
			clienteDetails.getApellido().isEmpty() ||
			clienteDetails.getEmail().isEmpty() || 
			clienteDetails.getPassword().isEmpty()) 
		throw new ClienteServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		
		//Crear un nuevo objeto de respuesta al request.
		ClienteRest returnValue = new ClienteRest();
		
		//Crear un nuevo Data Transfer Object que tendrá toda la informacion del cliente.
		ClienteDto clienteDto = new ClienteDto();
		
		//Copia y pega las propiedades desde el RequestBody al DTO.
		BeanUtils.copyProperties(clienteDetails, clienteDto); 
		
		//Crea un nuevo cliente y lo almacena en la DB a travéz del Service, utilizando la informacion del DTO.
		ClienteDto createdCliente = clienteService.crearCliente(clienteDto);
		
		//Copia el nuevo cliente creado y almacenado en la base de datos en el objeto de retorno.
		BeanUtils.copyProperties(createdCliente, returnValue);
		
		return returnValue;
		
	}
	
	@PutMapping(path = "{/id}",
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ClienteRest updateCliente(@RequestBody ClienteRequestModel clienteDetails, @PathVariable String clienteid) {
				
			ClienteRest returnValue = new ClienteRest();
			
			ClienteDto clienteDto = new ClienteDto();
			
			BeanUtils.copyProperties(clienteDetails, clienteDto); 
		
			ClienteDto updatedCliente = clienteService.actualizarCliente(clienteid, clienteDto);
			
			BeanUtils.copyProperties(updatedCliente, returnValue);
			
			return returnValue;
	}
	
	@DeleteMapping
	public String deleteCliente() {
		
		return "Delete cliente was called";
	}

}
