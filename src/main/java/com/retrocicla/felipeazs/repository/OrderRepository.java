package com.retrocicla.felipeazs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Cliente findClienteByEmail(String email);

}
