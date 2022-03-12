package com.retrocicla.felipeazs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.service.CartService;
import com.retrocicla.felipeazs.service.ProductService;

@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;
		
	@GetMapping(path = "/products/add/{productid}")
	public List<Cart> addProductToCart(@PathVariable String productid, Model model) {
		
		int id = Integer.parseInt(productid);				
		Product pro = productService.findProductById(id);
		
		cartService.addProduct(pro);
			
		List<Cart> carrito = cartService.list();		
				
		return carrito;		
	}
	
	@GetMapping(path = "/product/add/{productid}")
	public Cart addCartProduct(@PathVariable String productid, Model model) {
			
		int id = Integer.parseInt(productid);		
		Product pro = productService.findProductById(id);
		
		cartService.addProduct(pro);
		
		Cart cart = cartService.findByProductId(id);
		
		return cart;
	}
	
	@GetMapping(path = "/products/remove/{productid}")
	public List<Cart> removeProductToCart(@PathVariable String productid, Model model) {
		
		int id = Integer.parseInt(productid);
		cartService.removeProduct(id);
			
		List<Cart> carrito = cartService.list();		
				
		return carrito;		
	}
	
	@GetMapping(path = "/product/remove/{productid}")
	public Cart removeCartProduct(@PathVariable String productid, Model model) {
			
		int id = Integer.parseInt(productid);		
		cartService.removeProduct(id);		
		
		Cart cart = cartService.findByProductId(id);
		
		return cart;
	}
	
	@GetMapping(path = "/product/delete/{productid}")
	public void deleteCartProduct(@PathVariable String productid, Model model) {
			
		int id = Integer.parseInt(productid);		
		cartService.deleteProduct(id);		
		
	}

}
