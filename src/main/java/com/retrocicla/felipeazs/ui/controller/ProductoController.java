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

import com.retrocicla.felipeazs.exceptions.ProductoServiceException;
import com.retrocicla.felipeazs.model.dto.ProductoDto;
import com.retrocicla.felipeazs.service.ProductoService;
import com.retrocicla.felipeazs.ui.model.request.ProductoRequestModel;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;
import com.retrocicla.felipeazs.ui.model.response.ProductoRest;

@RestController
@RequestMapping("productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productService;
	
	@PostMapping(
			consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, //La data entregada puede ir en XML o JSON
			produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
	public ProductoRest AgregarProductoAlCarrito(@RequestBody ProductoRequestModel productDetails) {
		
		System.out.println(productDetails.getEstacion());
		
		if (productDetails.getDescripcion().isEmpty() ||
			productDetails.getPrenda().isEmpty() ||
			productDetails.getTamano().isEmpty() ||
			productDetails.getEstilo().isEmpty() ||
			productDetails.getColor().isEmpty() ||
			productDetails.getGenero().isEmpty() ||
			productDetails.getPrecio() == 0 ||
			productDetails.getImageUrl().isEmpty() ||
			productDetails.getMaterial().isEmpty() ||
			productDetails.getEstacion().isEmpty() ||
			productDetails.getTipo().isEmpty() ||
			productDetails.getStock() == 0) 
		throw new ProductoServiceException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());		
		
		ProductoDto productDto = new ProductoDto(); 
		BeanUtils.copyProperties(productDetails, productDto);
				
		ProductoDto savedProduct = productService.crearProducto(productDto);
		
		ProductoRest returnValue = new ProductoRest();
		BeanUtils.copyProperties(savedProduct, returnValue);		
		
		return returnValue;
		
	}
	
	@GetMapping(
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<ProductoRest> obtenerProductosDeUnCliene(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "limit", defaultValue = "25") int limit){
		
		List<ProductoRest> returnValue = new ArrayList<>();
		
		List<ProductoDto> productosDto = productService.listarProducts(page, limit);
		
		ModelMapper modelMapper = new ModelMapper();

		for (ProductoDto producto : productosDto) {
			returnValue.add(modelMapper.map(producto, ProductoRest.class));			
		}
				
		return returnValue; 
		
	}

}











