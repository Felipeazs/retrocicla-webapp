package com.retrocicla.felipeazs.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.exceptions.ProductServiceException;
import com.retrocicla.felipeazs.model.dto.ProductDto;
import com.retrocicla.felipeazs.service.ProductService;
import com.retrocicla.felipeazs.ui.model.request.ProductRequestModel;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;
import com.retrocicla.felipeazs.ui.model.response.ProductRest;

@RestController
@RequestMapping("productos")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, //La data entregada puede ir en XML o JSON
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ProductRest createProduct(@RequestBody ProductRequestModel productDetails) {
		
		if (productDetails.getDescription().isEmpty() ||
			productDetails.getWear().isEmpty() ||
			productDetails.getSize().isEmpty() ||
			productDetails.getStyle().isEmpty() ||
			productDetails.getColor().isEmpty() ||
			productDetails.getGenre().isEmpty() ||
			productDetails.getPrice() == 0 ||
			productDetails.getImageUrl().isEmpty() ||
			productDetails.getMaterial().isEmpty() ||
			productDetails.getSeason().isEmpty() ||
			productDetails.getType().isEmpty() ||
			productDetails.getStock() == 0) 
		throw new ProductServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());		
		
		ProductDto productDto = new ProductDto(); 
		BeanUtils.copyProperties(productDetails, productDto);
				
		ProductDto savedProduct = productService.crearProducto(productDto);
		
		ProductRest returnValue = new ProductRest();
		BeanUtils.copyProperties(savedProduct, returnValue);		
		
		return returnValue;
		
	}
	
	@GetMapping(
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ProductRest> getProductos(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit){
		
		List<ProductRest> returnValue = new ArrayList<>();
		
		List<ProductDto> productDto = productService.listarProducts(page, limit);
		
		ModelMapper modelMapper = new ModelMapper();

		for (ProductDto product : productDto) {
			returnValue.add(modelMapper.map(product, ProductRest.class));			
		}
				
		return returnValue; 
		
	}

}
