package com.retrocicla.felipeazs.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.retrocicla.felipeazs.service.CartService;

@Controller
@RequestMapping("carrito")
public class CarritoController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/agregar/{productId}")
	public ModelAndView agregarAlCarrito(@PathVariable("productId") String productId) {
		
		System.out.println(productId);
		
		cartService.addProduct(productId);
		
		ModelAndView modelAndView = new ModelAndView("ropaspage");
		
		return modelAndView;
	}

}
