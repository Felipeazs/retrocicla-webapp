package com.retrocicla.felipeazs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.model.Region;
import com.retrocicla.felipeazs.service.CartService;
import com.retrocicla.felipeazs.service.CiudadService;
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
		
	@PostMapping(path = "/product/{productid}")
	public List<Cart> addProductToCart(@PathVariable String productid, Model model) {
		
		int id = Integer.parseInt(productid);				
		Product pro = productService.findProductById(id);
		
		cartService.addProduct(pro);
			
		List<Cart> carrito = cartService.list();		
				
		return carrito;		
	}
	
	@PutMapping(path = "/product/add/{productid}")
	public Cart addCartProduct(@PathVariable String productid, Model model) {
			
		int id = Integer.parseInt(productid);		
		Cart product = cartService.findByProductId(id);
		
		cartService.updateProduct(product);
				
		return product;
	}
	
	@PutMapping(path = "/product/remove/{productid}")
	public List<Cart> removeCartProductItem(@PathVariable String productid, Model model) {
		
		int id = Integer.parseInt(productid);
		cartService.removeProduct(id);
			
		List<Cart> carrito = cartService.list();		
				
		return carrito;		
	}	
		
	@DeleteMapping(path = "/product/{productid}")
	public void deleteCartProduct(@PathVariable String productid, Model model) {
			
		int id = Integer.parseInt(productid);		
		cartService.deleteProduct(id);		
		
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

}