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
import com.retrocicla.felipeazs.model.Product;
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
	public void save(Order order, List<Cart> items) {
		
		Order nueva_orden = new Order();
		
		Order findEmail = repo.findByClienteEmail(order.getCliente().getEmail());
		if (findEmail == null) {
			Cliente cliente = new Cliente();
			
			String nombre = order.getCliente().getNombre();
			String apellido = order.getCliente().getApellido();
			String rut = "16741352-8";
			String email = order.getCliente().getEmail();
			int telefono = order.getCliente().getTelefono();
			
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setRun(rut);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			
			Cliente nuevo_cliente = repo_cl.save(cliente);
			nueva_orden.setCliente(nuevo_cliente);
			
			Direccion direccion = new Direccion();
			String dcalle = order.getDireccion().getCalle();
			String dciudad = order.getDireccion().getCiudad();
			String dregion = order.getDireccion().getRegion();
			
			direccion.setCalle(dcalle);
			direccion.setCiudad(dciudad);
			direccion.setRegion(dregion);
			direccion.setCliente(nuevo_cliente);			
			Direccion nueva_direccion = repo_d.save(direccion);
			
			nueva_orden.setDireccion(nueva_direccion);
			
			Facturacion facturacion = new Facturacion();
			String fcalle = order.getDireccion().getCalle();
			String fciudad = order.getDireccion().getCiudad();
			String fregion = order.getDireccion().getRegion();
			
			facturacion.setCalle(fcalle);
			facturacion.setCiudad(fciudad);
			facturacion.setRegion(fregion);
			facturacion.setCliente(nuevo_cliente);			
			Facturacion nueva_facturacion = repo_f.save(facturacion);
			
			nueva_orden.setFacturacion(nueva_facturacion);
			
		} else {			
			nueva_orden.setCliente(findEmail.getCliente());
			nueva_orden.setDireccion(findEmail.getDireccion());
			nueva_orden.setFacturacion(findEmail.getFacturacion());
		}
		
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
	public List<Order> listByClienteId(int id) {
		
		List<Order> orders = repo.findAllByClienteId(id);
		for (Order order : orders) {
			System.out.println("order id:" + order.getId());
		}
		
		
		return orders;
	}	

}




































