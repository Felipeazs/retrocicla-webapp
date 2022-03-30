package com.retrocicla.felipeazs.ui.controller;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.model.dto.CartDto;
import com.retrocicla.felipeazs.service.CartService;
import com.retrocicla.felipeazs.ui.model.request.CartRequestModel;
import com.retrocicla.felipeazs.ui.model.response.CartRest;

@RestController
@RequestMapping("carritos")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, //La data entregada puede ir en XML o JSON
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public CartRest createCart(@RequestBody CartRequestModel cartDetails) {
				
		CartDto cartDto = cartService.createCart(cartDetails);
		
		CartRest returnValue = new CartRest();
		
		ModelMapper modelMapper = new ModelMapper();
		returnValue = modelMapper.map(cartDto, CartRest.class);
		
		return returnValue;
		
	}

}
