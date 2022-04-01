package com.retrocicla.felipeazs.service;

import com.retrocicla.felipeazs.io.entity.CartEntity;
import com.retrocicla.felipeazs.model.dto.CartDto;
import com.retrocicla.felipeazs.ui.model.request.CartRequestModel;

public interface CartService {

	CartDto createCart(CartRequestModel cartDetails);

	void addProduct(String productId);

	void updateProductInCart(CartEntity product);
	
//	List<Cart> list();
//	void addProduct(Product product, Cliente cliente);
//	void updateProduct(int productId, String email);
//	void removeProduct(Integer productId, String email);
//	void deleteProduct(Integer productId, String email);
//	List<Cart> getProductsByClienteId(String cliente);
//	List<Cart> listByEmail(String name);
//	Cart getProductByIdAndEmail(int id, String email);
//	List<Cart> listByClienteEmail(String email);

	
}
