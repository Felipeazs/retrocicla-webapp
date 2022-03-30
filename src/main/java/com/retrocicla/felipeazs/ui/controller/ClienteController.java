package com.retrocicla.felipeazs.ui.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.model.dto.DireccionDto;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.service.DireccionService;
import com.retrocicla.felipeazs.ui.model.request.ClienteRequestModel;
import com.retrocicla.felipeazs.ui.model.request.PasswordResetModel;
import com.retrocicla.felipeazs.ui.model.request.PasswordResetRequestModel;
import com.retrocicla.felipeazs.ui.model.request.RequestOperationName;
import com.retrocicla.felipeazs.ui.model.response.ClienteRest;
import com.retrocicla.felipeazs.ui.model.response.DireccionRest;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;
import com.retrocicla.felipeazs.ui.model.response.OperationStatusModel;
import com.retrocicla.felipeazs.ui.model.response.OperationStatusResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

// Basic CRUD
@RestController
@RequestMapping("clientes")
@Tag(name = "clientes-controller", description = "clientes API")//Swagger
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private DireccionService direccionService;
	
	//OpenAPI/Swagger
	@Operation(
			summary = "Buscar un cliente",
			description = "Buscar un cliente en particular por su ID",
			tags = "cliente",
			security = {
					@SecurityRequirement(name = "bearer-key")
			})
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "Successful operation",
							content = @Content(
									mediaType = "application/json"),
							headers = { 
									@Header(
									name = "Authorization",
									description = "Bearer JWT value here"),
									@Header(
									name = "Cliente ID",
									description = "Cliente ID value here")
							}
					)	
			}
	)
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
	
	//OpenAPI/Swagger
		@Operation(
				summary = "Buscar a todos los cliente",
				description = "Buscar a todos los clientes",
				tags = "cliente",
				security = {
						@SecurityRequirement(name = "bearer-key")
				})		
		@ApiResponses(
				value = {
						@ApiResponse(
								responseCode = "200",
								description = "Successful operation",
								content = @Content(
										mediaType = "application/json")									
						)						
				}
		)
	@GetMapping(
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public List<ClienteRest> getClientes(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit){
		
		List<ClienteRest> returnValue = new ArrayList<>();
		
		List<ClienteDto> clientes = clienteService.obtenerClientes(page, limit);
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (ClienteDto cliente : clientes) {
			returnValue.add(modelMapper.map(cliente, ClienteRest.class));			
		}		
		
		return returnValue;
	}
	
	@GetMapping(
			path="/{clienteid}/direcciones",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CollectionModel<DireccionRest> getDireccionesCliente(
			@PathVariable String clienteid){
		
		List<DireccionRest> returnValue = new ArrayList<>();
		
		List<DireccionDto> direccionesDto = direccionService.obtenerDireccionesCliente(clienteid);
		
		if (direccionesDto!= null && !direccionesDto.isEmpty()) {
			Type listType = new TypeToken<List<DireccionRest>>() {}.getType();
			returnValue = new ModelMapper().map(direccionesDto, listType);
			
			for (DireccionRest direccion : returnValue) {
				Link selfLink = WebMvcLinkBuilder
						.linkTo(WebMvcLinkBuilder
						.methodOn(ClienteController.class).getDireccionCliente(clienteid, direccion.getDireccionId()))			
						.withSelfRel();	
				direccion.add(selfLink);
			}
		}
				
		//HATEOAS
		Link clienteLink = WebMvcLinkBuilder.linkTo(ClienteController.class)
				.slash(clienteid)
				.withRel("cliente");
		
		Link selfLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ClienteController.class).getDireccionesCliente(clienteid))			
				.withSelfRel();
						
		return CollectionModel.of(returnValue, clienteLink, selfLink);
	}
	
	@GetMapping(
			path="/{clienteid}/direcciones/{direccionid}",
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public EntityModel<DireccionRest> getDireccionCliente(
			@PathVariable String clienteid,
			@PathVariable String direccionid){
		
		DireccionRest returnValue = new DireccionRest();
		
		DireccionDto direccion = direccionService.obtenerDireccionCliente(direccionid);
		
		BeanUtils.copyProperties(direccion, returnValue);
		
		//HATEOAS
		Link clienteLink = WebMvcLinkBuilder.linkTo(ClienteController.class)
				.slash(clienteid)
				.withRel("cliente");
		
		Link direccionesLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ClienteController.class).getDireccionesCliente(clienteid))				
				.withRel("direcciones");
		
		Link selfLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(ClienteController.class).getDireccionCliente(clienteid, direccionid))			
				.withSelfRel();
				
		return EntityModel.of(returnValue, Arrays.asList(clienteLink, direccionesLink, selfLink));
	}
	
	@GetMapping(
			path="/email-verification",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel verifyEmailToken(@RequestParam(value = "token") String token) {
		
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.VERIFY_EMAIL.name());
		
		boolean isVerified = clienteService.verifyEmailToken(token);
		
		if (isVerified) {
			returnValue.setOperationResult(OperationStatusResponse.SUCCESS.name());
		} else {
			returnValue.setOperationResult(OperationStatusResponse.ERROR.name());
		}	
		
		return returnValue;
	}
	
	@PostMapping(path = "/password-reset-request",
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, //La data entregada puede ir en XML o JSON
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel requestResetPassword(@RequestBody PasswordResetRequestModel passwordResetRequest) throws Exception {
		
		boolean operationResult = clienteService.requestPasswordReset(passwordResetRequest.getEmail());
		
		OperationStatusModel returnValue = new OperationStatusModel();
		
		returnValue.setOperationName(RequestOperationName.REQUEST_PASSWORD_RESET.name());
		returnValue.setOperationResult(OperationStatusResponse.ERROR.name());
		
		if (operationResult) {
			returnValue.setOperationResult(OperationStatusResponse.SUCCESS.name());
		}	
		
		return returnValue;
	}
	
	@PostMapping(path = "/password-reset",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public OperationStatusModel passwordReset(@RequestBody PasswordResetModel passwordRequest){		
		
		OperationStatusModel returnValue = new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.RESET_PASSWORD.name());
		
		boolean isVerified = clienteService.verifyAndResetPassword(passwordRequest.getToken(), passwordRequest.getPassword());
				
		if (isVerified) {
			returnValue.setOperationResult(OperationStatusResponse.SUCCESS.name());
		} else {
			returnValue.setOperationResult(OperationStatusResponse.ERROR.name());
		}	
		
		return returnValue;
		
	}


}







