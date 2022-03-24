package com.retrocicla.felipeazs.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.exceptions.ClienteServiceException;
import com.retrocicla.felipeazs.io.entity.DireccionEntity;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.model.dto.DireccionDto;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.service.DireccionService;
import com.retrocicla.felipeazs.ui.model.request.ClienteRequestModel;
import com.retrocicla.felipeazs.ui.model.request.RequestOperationName;
import com.retrocicla.felipeazs.ui.model.response.ClienteRest;
import com.retrocicla.felipeazs.ui.model.response.DireccionRest;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;
import com.retrocicla.felipeazs.ui.model.response.OperationStatusModel;
import com.retrocicla.felipeazs.ui.model.response.OperationStatusResponse;


// Basic CRUD
@RestController
@RequestMapping("clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private DireccionService direccionService;
	
	@GetMapping(
			path = "/{clienteid}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }) // Retorna el valor en XML o JSON
	public ClienteRest getCliente(@PathVariable String clienteid) {
					
		ClienteDto cliente = clienteService.obtenerClienteById(clienteid);
		
		ModelMapper modelMapper = new ModelMapper();
		ClienteRest returnValue = modelMapper.map(cliente, ClienteRest.class);
				
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
		//Copia y pega las propiedades desde el RequestBody al DTO.
		ModelMapper modelMapper = new ModelMapper();
		ClienteDto clienteDto = modelMapper.map(clienteDetails, ClienteDto.class);
		
		//Crea un nuevo cliente y lo almacena en la DB a travéz del Service, utilizando la informacion del DTO.
		ClienteDto createdCliente = clienteService.crearCliente(clienteDto);
		
		//Copia el nuevo cliente creado y almacenado en la base de datos en el objeto de retorno.
		returnValue = modelMapper.map(createdCliente, ClienteRest.class);
		
		return returnValue;
		
	}
	
	@PutMapping(
			path = "/{clienteid}",
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
	
	@DeleteMapping(
			path = "/{clienteid}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel deleteCliente(@PathVariable String clienteid) {
		
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		
		clienteService.eliminarCliente(clienteid);
		
		returnValue.setOperationResult(OperationStatusResponse.SUCCESS.name());
		
		return returnValue;
	}
	
	@GetMapping(
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ClienteRest> getClientes(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit){
		
		List<ClienteRest> returnValue = new ArrayList<>();
		
		List<ClienteDto> clientes = clienteService.obtenerClientes(page, limit);
		
		for (ClienteDto cliente : clientes) {
			ClienteRest clModel = new ClienteRest();
			BeanUtils.copyProperties(cliente, clModel);
			returnValue.add(clModel);			
		}		
		
		return returnValue;
	}
	
	@GetMapping(
			path="/{clienteid}/direcciones",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<DireccionRest> getDireccionesCliente(
			@PathVariable String clienteid){
		
		List<DireccionRest> returnValue = new ArrayList<>();
		
		List<DireccionDto> direcciones = direccionService.obtenerDireccionesCliente(clienteid);
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (DireccionDto direccion : direcciones) {
			returnValue.add(modelMapper.map(direccion, DireccionRest.class));
		}
						
		return returnValue;
	}
	
	@GetMapping(
			path="/{clienteid}/direcciones/{direccionid}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public DireccionRest getDireccionCliente(
			@PathVariable String direccionid){
		
		DireccionRest returnValue = new DireccionRest();
		
		DireccionDto direccion = direccionService.obtenerDireccionCliente(direccionid);
		
		BeanUtils.copyProperties(direccion, returnValue);
						
		return returnValue;
	}

}
