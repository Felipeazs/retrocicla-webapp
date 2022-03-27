package com.retrocicla.felipeazs.ui.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.model.dto.DireccionDto;
import com.retrocicla.felipeazs.service.impl.ClienteServiceImpl;
import com.retrocicla.felipeazs.ui.model.response.ClienteRest;

class ClienteControllerTest {
	
	@InjectMocks
	private ClienteController clienteController;
	
	@Mock
	private ClienteServiceImpl clienteService;
	
	private ClienteDto clienteDto;
	
	final String USER_ID = "ksdjhfisfa7sdf87ad82";

	@BeforeEach
	void setUp() throws Exception {
		
		MockitoAnnotations.openMocks(this);
		
		clienteDto = new ClienteDto();
		clienteDto.setNombre("Felipe");
		clienteDto.setApellido("Zapata");
		clienteDto.setEmail("felipeazs@gmail.com");
		clienteDto.setEmailVerificationStatus(Boolean.FALSE);
		clienteDto.setEmailVerificationToken(null);
		clienteDto.setClienteId(USER_ID);
		clienteDto.setDirecciones(getDireccionesDto());
		clienteDto.setEcryptedPassword("djhsid7afysdf879");
	}

	@Test
	final void testGetCliente() {
		
		when(clienteService.obtenerClienteById(anyString())).thenReturn(clienteDto);
		
		ClienteRest clienteRest = clienteController.getCliente(USER_ID);
		
		assertNotNull(clienteRest);
		assertEquals(USER_ID, clienteRest.getClienteId());
		assertEquals(clienteDto.getNombre(), clienteRest.getNombre());
		assertEquals(clienteDto.getApellido(), clienteRest.getApellido());
		assertEquals(clienteDto.getDirecciones().size(), clienteRest.getDirecciones().size());
		
	}
	
	private List<DireccionDto> getDireccionesDto() {
		DireccionDto direccion1 = new DireccionDto();
		direccion1.setCalle("Marte 2183");
		direccion1.setCiudad("Quilpué");
		direccion1.setRegion("Valapraiso");
		direccion1.setTipo("domicilio");
		
		DireccionDto direccion2 = new DireccionDto();
		direccion2.setCalle("Marte 2183");
		direccion2.setCiudad("Quilpué");
		direccion2.setRegion("Valapraiso");
		direccion2.setTipo("trabajo");
		
		List<DireccionDto> direcciones = new ArrayList<>();
		direcciones.add(direccion1);
		direcciones.add(direccion2);
		return direcciones;
	}

}
