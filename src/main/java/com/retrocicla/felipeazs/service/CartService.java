package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Product;

public interface CartService {
	
	List<Cart> list();
	void addProduct(Product product);
	Cart findByProductId(int id);
	void updateProductQuantityInCart(Cart product);
	void removeProduct(Integer productId);
	void deleteProduct(Integer productId);
	
}
