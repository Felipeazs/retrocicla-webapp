package com.retrocicla.felipeazs.service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

import org.hibernate.StaleStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository repo;

	@Override
	public List<Cart> list() {
		
		return repo.findAll();
	}

	@Override
	public void addProduct(Product product) {
		
		try {
			Cart findProd = findByProductId(product.getId());
			updateProductQuantityInCart(findProd);
		} catch (NullPointerException ex) {
			
			Cart cart = new Cart();
			
			cart.setCreatedAt(LocalDate.now());
			cart.setProduct(product);
			cart.setQuantity(1);
			cart.setPrice(product.getPrice());
				
			int totalPrice = cart.getQuantity() * cart.getPrice();
			Locale clp = new Locale("es", "CL");
			NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
			String price = nf.format(totalPrice);		
			cart.setTotalPrice(price);
				
			repo.save(cart);			
		}				
	}

	@Override
	public Cart findByProductId(int id) {		
		
		Cart cart = repo.findByProductId(id);		
		
		return cart;		
	}

	@Override
	public void updateProductQuantityInCart(Cart cart) {
		
		if (cart.getQuantity() < cart.getProduct().getStock()) {
			
			cart.setQuantity(cart.getQuantity() + 1);		
			
			int totalPrice = cart.getQuantity() * cart.getPrice();
			Locale clp = new Locale("es", "CL");
			NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
			String price = nf.format(totalPrice);		
			cart.setTotalPrice(price);
			
			repo.save(cart);
		}		
						
	}

	@Override
	public void removeProduct(Integer productId) {
		
		try {
			Cart findProd = findByProductId(productId);
			
			if (findProd.getQuantity() > 1) {
				findProd.setQuantity(findProd.getQuantity() - 1);		
				
				int totalPrice = findProd.getQuantity() * findProd.getPrice();
				Locale clp = new Locale("es", "CL");
				NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
				String price = nf.format(totalPrice);		
				findProd.setTotalPrice(price);
				
				repo.save(findProd);
			} else {
				deleteProduct(productId);
			}
						
		} catch (NullPointerException ex) {
			System.out.println(ex.getMessage());
		}		
	}

	@Override
	public void deleteProduct(Integer productId) {
		
		try {
			Cart product = findByProductId(productId);
			System.out.println("eliminar: " + product.getId());
			repo.delete(product);
		} catch (StaleStateException ex) {
			ex.getMessage();
		}
		
		
	}
}
