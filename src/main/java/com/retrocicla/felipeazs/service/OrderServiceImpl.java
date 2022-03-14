package com.retrocicla.felipeazs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.model.Order;
import com.retrocicla.felipeazs.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;

	@Override
	public void save(Order order) {
		
		Cliente client = repo.findClienteByEmail(order.getCliente().getEmail());
		
		repo.save(order);
		
	}

}
