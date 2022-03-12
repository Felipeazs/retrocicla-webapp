package com.retrocicla.felipeazs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart findByProductId(int id);
}
