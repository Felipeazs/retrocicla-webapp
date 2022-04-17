package com.retrocicla.felipeazs.ui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class OtroController {
	
	@PostMapping
	public void test() {
		System.out.println("Funciona!!");
	}

}
