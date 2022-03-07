package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Product;

public interface ProductService {
	
	public List<Product> list();

	public void add(Product product);

	public List<Product> searchBy(String productType);

}
