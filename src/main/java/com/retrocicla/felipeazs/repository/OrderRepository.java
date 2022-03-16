package com.retrocicla.felipeazs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

	Order findByClienteEmail(String email);

	List<Order> findAllByClienteId(int id);

}
