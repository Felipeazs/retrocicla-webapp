package com.retrocicla.felipeazs.service;

import java.util.ArrayList;
import java.util.List;

import com.retrocicla.felipeazs.model.dto.ProductDto;

public interface ProductService {
	
	public List<ProductDto> listarProducts(int page, int limit);

	public ProductDto crearProducto(ProductDto productDto);

	public List<ArrayList<String>> getMultipleSelection();
	
//	public List<ProductEntity> list();
//
//	public ProductEntity add(ProductEntity product);
//
//	public List<ProductEntity> searchBy(String productType);
//
//	public List<ProductEntity> searchProducts(ProductEntity product);
//
//	public List<ProductEntity> listById(ArrayList<Integer> pps);
//
//	public ProductEntity getProductById(int id);

	
	
	

}
