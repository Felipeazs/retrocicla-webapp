package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.model.Product;

public interface CartService {
	
	List<Cart> list();
	void addProduct(Product product, Cliente cliente);
	void updateProduct(int productId, String email);
	void removeProduct(Integer productId, String email);
	void deleteProduct(Integer productId, String email);
	List<Cart> getProductsByClienteId(String cliente);
	List<Cart> listByEmail(String name);
	Cart getProductByIdAndEmail(int id, String email);
	List<Cart> listByClienteEmail(String email);

	
}
