package com.retrocicla.felipeazs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.model.Direccion;
import com.retrocicla.felipeazs.model.Order;
import com.retrocicla.felipeazs.repository.CartRepository;
import com.retrocicla.felipeazs.repository.ClienteRepository;
import com.retrocicla.felipeazs.repository.DireccionRepository;
import com.retrocicla.felipeazs.repository.OrderRepository;
import com.retrocicla.felipeazs.shared.Utils;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private ClienteRepository repo_cl;

	@Autowired
	private DireccionRepository repo_d;
	
	@Autowired
	private CartRepository repo_cr;
	
	@Autowired
	private Utils utils;

	@Override
	public void save(Order order, List<Cart> items, String cliente) {

		ArrayList<Integer> productos = new ArrayList<>();

		int total = 0;
		for (Cart item : items) {
			productos.add(item.getProduct().getId());
			total = total + (item.getPrice() * item.getQuantity());
		}
		
		if (total > 0 ) {
			
			Order nueva_orden = new Order();

			Cliente findClienteEmail = repo_cl.findByEmail(cliente);
			nueva_orden.setCliente(findClienteEmail); 
			
			Direccion d = repo_d.findByCalleAndClienteId(order.getDireccion().getCalle(), findClienteEmail.getId());
			nueva_orden.setDireccion(d);		
			
			nueva_orden.setTotal(total);

			nueva_orden.setProduct(productos);

			nueva_orden.setCretedAt(LocalDate.now());		
			
			nueva_orden.setObservaciones("abierta");
			
			nueva_orden.setTracking_number(utils.generarRandomId(18));
			
			repo.save(nueva_orden);
			
			repo_cr.deleteAllByClienteId(findClienteEmail.getId());
			
			updateLastOrder(findClienteEmail.getId());
			
		} 
		
		
	}

	private void updateLastOrder(int clienteid) {
		
		List<Order> orders = repo.findAllByClienteId(clienteid);
		int length = orders.size();
				
		if (length > 1 ) {
			Order lastOrder = orders.get(length - 2);
			lastOrder.setObservaciones("finalizada");
			
			repo.save(lastOrder);
		}		
		
	}

	@Override
	public List<Order> list() {

		return repo.findAll();
	}

	@Override
	public List<Order> listByClienteEmail(String email) {

		Cliente cliente = repo_cl.findByEmail(email);

		return repo.findAllByClienteId(cliente.getId());
	}

	@Override
	public Order listByClienteEmailAndObservaciones(String email, String obs) {
		
		return repo.findByClienteEmailAndObservaciones(email, obs);
	}

}
