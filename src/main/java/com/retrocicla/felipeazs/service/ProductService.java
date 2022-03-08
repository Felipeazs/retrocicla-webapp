package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Product;

public interface ProductService {
	
	public List<Product> list();

	public Product add(Product product);

	public List<Product> searchBy(String productType);

	public List<String> getDistinctByWear();

	public List<String> getDistinctByStyle();

	public List<String> getDistinctByGenre();

	public List<String> getDistinctByType();

	public List<String> getDistinctByMaterial();

	public List<String> getDistinctByColor();

	public List<String> getDistinctByRopaSize();

	public List<String> getDistinctByTelaSize();

	public List<String> getDistinctByMadeIn();

	public List<Product> findProducts(Product product);
	
	

}
