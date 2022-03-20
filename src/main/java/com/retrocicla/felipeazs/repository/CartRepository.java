package com.retrocicla.felipeazs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Integer> {

	Cart findByProductId(int id);

	Cart findByProductIdAndClienteEmail(int id, String email);

	List<Cart> findAllByClienteEmail(String cliente);

	List<Cart> findByClienteEmail(String email);
}
