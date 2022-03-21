package com.retrocicla.felipeazs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Ciudad;
import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.model.Direccion;
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.model.Region;
import com.retrocicla.felipeazs.service.CartService;
import com.retrocicla.felipeazs.service.CiudadService;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.service.DireccionService;
import com.retrocicla.felipeazs.service.ProductService;
import com.retrocicla.felipeazs.service.RegionService;

@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private RegionService regionService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private DireccionService direccionService;
		
	@PostMapping(path = "/product/{productid}")
	public List<Cart> addProductToCart(@PathVariable String productid,Authentication auth) {	
		
		System.out.println("entró al api");
		
		int id = Integer.parseInt(productid); 
		Product pro = productService.getProductById(id); 
		Cliente cliente = clienteService.getCliente(auth.getName());
		 
		cartService.addProduct(pro, cliente);
		List<Cart> carrito = cartService.listByEmail(auth.getName());
					
		return carrito;		
	}
	
	@PutMapping(path = "/product/add/{productid}")
	public Cart addCartProduct(@PathVariable String productid, Authentication auth) {
		
		System.out.println("entró al api");
			
		int id = Integer.parseInt(productid);				
		cartService.updateProduct(id, auth.getName());		
		Cart product = cartService.getProductByIdAndEmail(id, auth.getName());
				
		return product;
	}
	
	@PutMapping(path = "/product/remove/{productid}")
	public List<Cart> removeCartProductItem(@PathVariable String productid, Authentication auth) {
		
		int id = Integer.parseInt(productid);
		cartService.removeProduct(id, auth.getName());
			
		List<Cart> carrito = cartService.list();
		System.out.println(carrito.isEmpty());
				
		return carrito;		
	}	
		
	@DeleteMapping(path = "/product/{productid}")
	public void deleteCartProduct(@PathVariable String productid, Authentication auth) {
			
		System.out.println(productid);
		int id = Integer.parseInt(productid);		
		cartService.deleteProduct(id, auth.getName());		
		
	}
	
	@GetMapping(path = "/products")
	public List<Product> getProducts() {		
		
		List<Product> products = productService.list();
		return products;	
	}
	
	@GetMapping(path = "/regiones/{regionid}")
	public List<Ciudad> getCiudades(@PathVariable String regionid) {
		
		int id = Integer.parseInt(regionid);
		List<Ciudad> cities = ciudadService.findAllByRegion(id);
		return cities;	
	}
	
	@GetMapping(path = "/regiones")
	public List<Region> getCiudades() {
		
		List<Region> regiones = regionService.list();
		return regiones;	
	}
	
	@PostMapping(path = "/add/address/{region}/{ciudad}/{calle}/{nombre}")
	public void addAddress(@PathVariable("region") String region, String ciudad, String calle, String nombre, Authentication auth) {
		
		Cliente cliente = clienteService.getCliente(auth.getName());
		Region regionid = regionService.getRegion(region);
		Ciudad ciudadid = ciudadService.getCiudad(ciudad);
		
		Direccion direccion = new Direccion();
		direccion.setRegion(regionid);
		direccion.setCiudad(ciudadid);
		direccion.setCalle(calle);
		direccion.setNombre(nombre);
		direccion.setCliente(cliente);
		
		direccionService.addAddress(direccion);
		
	}
	
	@GetMapping(path = "/address/{direccionid}")
	public Direccion getAddress(@PathVariable String direccionid) {
		
		Direccion direccion = direccionService.getAddress(direccionid);
		System.out.println(direccion.getCiudad());
		
		return direccion;
		
		
	}
	

}
