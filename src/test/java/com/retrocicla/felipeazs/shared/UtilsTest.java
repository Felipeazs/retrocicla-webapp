package com.retrocicla.felipeazs.shared;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)//Sirve para acceder a las variables de application.properties
@SpringBootTest
class UtilsTest {
	
	@Autowired
	Utils utils;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	final void testGenerateClienteId() {
		
		String clienteId = utils.generateClienteId(30);
		String clienteId2 = utils.generateClienteId(30);
		
		assertNotNull(clienteId);
		assertTrue(clienteId.length() == 30);
		assertTrue(!clienteId.equalsIgnoreCase(clienteId2));
		
	}

	@Test
	final void testHasTokenExpired() {
		
		String token = utils.generateEmailVerificationToken("dsdusdbhyeew6565ewfx56");		
		boolean hasTokenExpired = Utils.hasTokenExpired(token);
		
		assertNotNull(token);
		assertFalse(hasTokenExpired);		
	}
	
}














