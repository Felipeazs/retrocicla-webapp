package com.retrocicla.felipeazs.service.impl;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.exceptions.CartServiceException;
import com.retrocicla.felipeazs.io.entity.CartEntity;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.ProductEntity;
import com.retrocicla.felipeazs.io.repository.CartRepository;
import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.io.repository.ProductRepository;
import com.retrocicla.felipeazs.model.dto.CartDto;
import com.retrocicla.felipeazs.service.CartService;
import com.retrocicla.felipeazs.ui.model.request.CartRequestModel;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;

//
//import java.text.NumberFormat;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//import org.hibernate.StaleStateException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.retrocicla.felipeazs.model.Cart;
//import com.retrocicla.felipeazs.model.Product;
//import com.retrocicla.felipeazs.model.dto.ClienteDto;
//import com.retrocicla.felipeazs.repository.CartRepository;
//
@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ClienteRepository clienteRepo;

	@Override
	public CartDto createCart(CartRequestModel cartDetails) {
				
		ClienteEntity dbCart = clienteRepo.findByClienteId(cartDetails.getCliente_id());
		if(dbCart != null) throw new CartServiceException(ErrorMessages.RECORDS_ALREADY_EXIST.getErrorMessage());
				
		CartEntity newCart = new CartEntity();
		BeanUtils.copyProperties(cartDetails, newCart);
		
		ProductEntity dbProduct = productRepo.findByProductid(cartDetails.getPoducto_id());		
		newCart.setProducto(dbProduct);
		
		ClienteEntity dbCliente = clienteRepo.findByClienteId(cartDetails.getCliente_id());
		newCart.setCliente(dbCliente);
		
		newCart.setCreatedAt(LocalDate.now());
		
		int totalPrice = cartDetails.getPrice() * cartDetails.getQuantity();		
				
		newCart.setTotalPrice(formatPrice(totalPrice));
		
		CartEntity savedCart = cartRepo.save(newCart);	
		
		System.out.println(savedCart.getProducto().getDescription());
				
		CartDto returnValue = new CartDto();
		BeanUtils.copyProperties(savedCart, returnValue);
		
		System.out.println(returnValue.getCliente());
		
		return returnValue;
	} 	
	
	private String formatPrice(int price) {

		Locale clp = new Locale("es", "CL");
		NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
		String formattedPrice = nf.format(price);

		return formattedPrice;
	}
}



////	@Override
////	public List<Cart> list() {		
////		return repo.findAll();
////	}
////	
////
////	@Override
////	public List<Cart> listByEmail(String email) {
////		
////		List<Cart> clientecart = repo.findAllByClienteEmail(email);
////			
////		
////		return clientecart;
////	}
////
////	@Override
////	public void addProduct(Product product, ClienteDto cliente) {
////		
////		try {
////			Cart findProduct = repo.findByProductIdAndClienteEmail(product.getId(), cliente.getEmail());			
////			updateProduct(findProduct.getProduct().getId(), cliente.getEmail());
////		} catch (NullPointerException ex) {
////			
////			Cart cart = new Cart();
////			
////			cart.setCreatedAt(LocalDate.now());
////			cart.setProduct(product);
////			cart.setQuantity(1);
////			cart.setPrice(product.getPrice());						
////			cart.setCliente(cliente);
////				
////			int totalPrice = cart.getQuantity() * cart.getPrice();
////			Locale clp = new Locale("es", "CL");
////			NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
////			String price = nf.format(totalPrice);		
////			cart.setTotalPrice(price);
////				
////			repo.save(cart);			
////		}				
////	}
////
////	@Override
////	public void updateProduct(int productId, String email) {
////		
////		Cart product = repo.findByProductIdAndClienteEmail(productId, email);
////		
////		if (product.getQuantity() < product.getProduct().getStock()) {
////			
////			product.setQuantity(product.getQuantity() + 1);		
////			
////			int totalPrice = product.getQuantity() * product.getPrice();
////			Locale clp = new Locale("es", "CL");
////			NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
////			String price = nf.format(totalPrice);		
////			product.setTotalPrice(price);
////			
////			repo.save(product);
////		}		
////						
////	}
////
////	@Override
////	public void removeProduct(Integer productId, String email) {
////		
////		try {
////			Cart findProd = repo.findByProductIdAndClienteEmail(productId, email);
////			
////			if (findProd.getQuantity() > 1) {
////				findProd.setQuantity(findProd.getQuantity() - 1);		
////				
////				int totalPrice = findProd.getQuantity() * findProd.getPrice();
////				Locale clp = new Locale("es", "CL");
////				NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
////				String price = nf.format(totalPrice);		
////				findProd.setTotalPrice(price);
////				
////				repo.save(findProd);
////			} else {
////				deleteProduct(productId, email);
////			}
////						
////		} catch (NullPointerException ex) {
////			System.out.println(ex.getMessage());
////		}		
////	}
////
////	@Override
////	public void deleteProduct(Integer productId, String email) {
////		
////		try {
////			Cart product = repo.findByProductIdAndClienteEmail(productId, email);
////			repo.delete(product);
////		} catch (StaleStateException ex) {
////			ex.getMessage();
////		}
////		
////		
////	}
////
////
////	@Override
////	public List<Cart> getProductsByClienteId(String cliente) {
////		
////		return repo.findAllByClienteEmail(cliente);
////	}
////
////
////	@Override
////	public Cart getProductByIdAndEmail(int id, String email) {
////		
////		return repo.findByProductIdAndClienteEmail(id, email);
////	}
////
////
////	@Override
////	public List<Cart> listByClienteEmail(String email) {
////		
////		return repo.findAllByClienteEmail(email);
////	}
//
//}
