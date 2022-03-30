package com.retrocicla.felipeazs;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class OpenAPIConfig {
	
	@Bean
	public OpenAPI customConfig() {
		return new OpenAPI()
				.components(new Components())
				.info(new Info()
				.title("Retrocicla API")
				.description("RESTful API documentation")
				.version("v0.0.1")
				.contact(new Contact().email("felipeazs@gmail.com").name("Felipe Z. Soto")))
				.schemaRequirement("bearer-key", new SecurityScheme()
						.type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"));
	}

}
