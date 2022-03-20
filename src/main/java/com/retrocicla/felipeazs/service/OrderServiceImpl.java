package com.retrocicla.felipeazs.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.model.Direccion;
import com.retrocicla.felipeazs.model.Facturacion;
import com.retrocicla.felipeazs.model.Order;
import com.retrocicla.felipeazs.repository.ClienteRepository;
import com.retrocicla.felipeazs.repository.DireccionRepository;
import com.retrocicla.felipeazs.repository.FacturacionRepository;
import com.retrocicla.felipeazs.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repo;
	
	@Autowired
	private ClienteRepository repo_cl;
	
	@Autowired
	private DireccionRepository repo_d;
	
	@Autowired
	private FacturacionRepository repo_f;

	@Override
	public void save(Order order, List<Cart> items, String cliente) {
		
		Order nueva_orden = new Order();
		
		Cliente findClienteEmail = repo_cl.findByEmail(cliente);
					
		Direccion direccion = new Direccion();
		String dcalle = order.getDireccion().getCalle();
		String dciudad = order.getDireccion().getCiudad();
		String dregion = order.getDireccion().getRegion();
			
		direccion.setCalle(dcalle);
		direccion.setCiudad(dciudad);
		direccion.setRegion(dregion);
		direccion.setCliente(findClienteEmail);			
		Direccion nueva_direccion = repo_d.save(direccion);	
		
		ArrayList<Direccion> direcciones = (ArrayList<Direccion>) findClienteEmail.getDireccion();
		
		direcciones.add(nueva_direccion);
					
		Facturacion facturacion = new Facturacion();
		String fcalle = order.getDireccion().getCalle();
		String fciudad = order.getDireccion().getCiudad();
		String fregion = order.getDireccion().getRegion();
			
		facturacion.setCalle(fcalle);
		facturacion.setCiudad(fciudad);
		facturacion.setRegion(fregion);
		facturacion.setCliente(findClienteEmail);			
		Facturacion nueva_facturacion = repo_f.save(facturacion);
			
		findClienteEmail.getFacturacion().add(nueva_facturacion);
				
		ArrayList<Integer> productos = new ArrayList<>();
		
		for (Cart item : items) {
			productos.add(item.getProduct().getId());
		}
		
		nueva_orden.setProduct(productos);			
		
		nueva_orden.setCretedAt(LocalDate.now());	
		
		repo.save(nueva_orden);
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

}




































