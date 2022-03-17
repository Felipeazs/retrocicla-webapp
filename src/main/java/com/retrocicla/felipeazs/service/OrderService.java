package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Order;

public interface OrderService {
	
	void save(Order order, List<Cart> items, String clienteEmail);

	List<Order> list();

	List<Order> listByClienteEmail(String clienteEmail);

	
}
