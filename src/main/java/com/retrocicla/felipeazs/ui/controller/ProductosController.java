package com.retrocicla.felipeazs.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.retrocicla.felipeazs.io.entity.ProductEntity;
import com.retrocicla.felipeazs.model.dto.ProductDto;
import com.retrocicla.felipeazs.service.ProductService;
import com.retrocicla.felipeazs.ui.model.response.ProductRest;

@Controller
@RequestMapping("productos")
public class ProductosController {
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("producto")
	private ProductEntity setProduct() {
		return new ProductEntity();
	}
	
	@GetMapping("/ropa")
	public String getRopasPage(Model model) {
		
		List<ProductRest> returnValue = new ArrayList<>();
				
		List<ProductDto> productos = productService.searchBy("prenda");
		
		ModelMapper modelMap = new ModelMapper();
		for (ProductDto producto : productos) {
			returnValue.add(modelMap.map(producto, ProductRest.class));
		}	
				
		model.addAttribute("products", returnValue);

//		amountAndQuantity(model, auth);

		return "listado-productos";
	}
	
	
	
	

}
