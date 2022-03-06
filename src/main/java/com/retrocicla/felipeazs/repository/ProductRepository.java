package com.retrocicla.felipeazs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
