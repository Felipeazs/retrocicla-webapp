package com.retrocicla.felipeazs.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.retrocicla.felipeazs.exceptions.ClienteServiceException;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.DireccionEntity;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.io.repository.PasswordResetTokenRepository;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.model.dto.DireccionDto;
import com.retrocicla.felipeazs.shared.AmazonSES;
import com.retrocicla.felipeazs.shared.Utils;

class ClienteServiceImplTest {
	
	@InjectMocks
	ClienteServiceImpl clienteService;
	
	@Mock
	private ClienteRepository clienteRepo;
	
    @Mock 
    private Utils utils;
    
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Mock
    private PasswordResetTokenRepository passwordResetTokenRepo;
    
    @Mock
    AmazonSES amazonSes;
    
    String clienteId = "rgsdfgsdf65s5s6";
    String encryptedPassword = "kajsdfhgjyserbjyvbjsyfdiunoearsuirae";
    
    ClienteEntity cliente;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		
		//Se ejecutan antes de cada test
	
		cliente = new ClienteEntity();
		cliente.setId(1L);
		cliente.setNombre("Felipe");
		cliente.setApellido("Zapata");
		cliente.setEmail("felipeazs@gmail.com");
		cliente.setClienteId(clienteId);
		cliente.setEcryptedPassword(encryptedPassword);	
		cliente.setEmailVerificationToken("hjfdhjuhuiuiehfde77823");
		cliente.setDirecciones(getDireccionesEntity());
	}

	@Test
	final void testObtenerClienteByEmail() {		
		
		when(clienteRepo.findByEmail(anyString())).thenReturn(cliente);
		
		ClienteDto clienteDto = clienteService.obtenerClienteByEmail("felipeazs@gmail.com");
		
		assertNotNull(clienteDto);
		assertEquals("Felipe", clienteDto.getNombre());
		
	}
	
	@Test
	final void testObtenerClienteByEmail_Exception() {		
		
		when(clienteRepo.findByEmail(anyString())).thenReturn(null);
		
		assertThrows(ClienteServiceException.class, () -> {
			clienteService.obtenerClienteByEmail("felipeazs@gmail.com");
		});
	}
	
	@Test
	final void testCrearCliente() {
		//Crear cliente
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNombre("Felipe");
		clienteDto.setApellido("Zapata");
		clienteDto.setPassword("aasdfwef");
		clienteDto.setEmail("felipeazs@gmail.com");
		
		List<DireccionDto> direcciones = getDireccionesDto();
		clienteDto.setDirecciones(direcciones);		
		
		//Buscar cliente
		when(clienteRepo.findByEmail(anyString())).thenReturn(null);
		
		//Generar Id de direccion
		when(utils.generateDireccionId(anyInt())).thenReturn("kjdfshdf78sf8");
		
		//Generar clienteId
		when(utils.generateClienteId(anyInt())).thenReturn(clienteId);
		
		//Encriptar el password
		when(bCryptPasswordEncoder.encode(anyString())).thenReturn(encryptedPassword);
		
		//Guardar cliente en DB
		when(clienteRepo.save(any(ClienteEntity.class))).thenReturn(cliente);
		
		//Ignorar la respuesta de amazon
		Mockito.doNothing().when(amazonSes).verifyEmail(any(ClienteDto.class));	
		
		ClienteDto storedCliente = clienteService.crearCliente(clienteDto);		
		
		assertNotNull(storedCliente);
		assertEquals(cliente.getNombre(), storedCliente.getNombre());
		assertEquals(cliente.getApellido(), storedCliente.getApellido());
		assertNotNull(storedCliente.getClienteId());
		assertEquals(cliente.getDirecciones().size(), storedCliente.getDirecciones().size());
		verify(utils, times(cliente.getDirecciones().size())).generateDireccionId(30);
		verify(bCryptPasswordEncoder, times(1)).encode("aasdfwef");
		verify(utils, times(1)).generateClienteId(30);
		verify(clienteRepo, times(1)).save(any(ClienteEntity.class));
		
	}
	
	@Test
	final void testCreateCliente_Exception() {		
		
		when(clienteRepo.findByEmail(anyString())).thenReturn(cliente);
		
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setNombre("Felipe");
		clienteDto.setApellido("Zapata");
		clienteDto.setPassword("aasdfwef");
		clienteDto.setEmail("felipeazs@gmail.com");
		
		assertThrows(ClienteServiceException.class, () -> {
			clienteService.crearCliente(clienteDto);
		});
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
	
	private List<DireccionEntity> getDireccionesEntity(){
		
		List<DireccionDto> direccionesDto = getDireccionesDto();
		
		Type listType = new TypeToken<List<DireccionEntity>>() {}.getType();
		
		ModelMapper modelMapper = new ModelMapper();
		List<DireccionEntity> direccionesEntity = modelMapper.map(direccionesDto, listType);
		
		return direccionesEntity;		
	
	}
	

}








