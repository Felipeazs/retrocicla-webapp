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
			Cart findProduct = findByProductId(product.getId());
			updateProduct(findProduct);
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
	public void updateProduct(Cart product) {
		
		if (product.getQuantity() < product.getProduct().getStock()) {
			
			product.setQuantity(product.getQuantity() + 1);		
			
			int totalPrice = product.getQuantity() * product.getPrice();
			Locale clp = new Locale("es", "CL");
			NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
			String price = nf.format(totalPrice);		
			product.setTotalPrice(price);
			
			repo.save(product);
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
			repo.delete(product);
		} catch (StaleStateException ex) {
			ex.getMessage();
		}
		
		
	}
}
