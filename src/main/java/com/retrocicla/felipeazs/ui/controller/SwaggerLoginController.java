package com.retrocicla.felipeazs.ui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.ui.model.request.SwagegrLoginRequestModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SwaggerLoginController {
	
	@Operation(
			summary = "Ingresar a retrocicla",
			description = "Ingresar email y password para ingresar a la página",
			tags = "cliente")
	@ApiResponses(
			value = {
					@ApiResponse(
							responseCode = "200",
							description = "Response headers",							
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
	@PostMapping("clientes/login")
	public void swaggerLogin(@RequestBody SwagegrLoginRequestModel swaggerLoginRequestModel) {
		throw new IllegalStateException("Este método no debiese ser llamado. Este método está implementado por Spring Security");
	}

}
