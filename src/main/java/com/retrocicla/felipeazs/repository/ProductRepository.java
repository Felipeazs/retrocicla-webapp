package com.retrocicla.felipeazs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	List<Product> findAllByTypeOrderByWearAsc(String productType);
}
