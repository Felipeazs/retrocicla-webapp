package com.retrocicla.felipeazs.service;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public List<Product> list() {

		return repo.findAll();
	}

	@Override
	public void add(Product product) {
		
		if (product.getType().equals("tela")) {
			
			product.setGenre("indefinido");
			product.setStyle("indefinido");
			product.setSeason("indefinido");
			product.setWear("indefinido");
			
		} else {
			
			String genre = product.getGenre().toLowerCase();
			product.setGenre(genre);			
			
		}
		

		String size = product.getSize().toUpperCase();
		product.setSize(size);
			
		String madeIn = product.getMade_in().substring(0, 1).toUpperCase() + product.getMade_in().substring(1);
		product.setMade_in(madeIn);

		String color = product.getColor().toLowerCase();
		product.setColor(color);

		String description = product.getDescription().substring(0, 1).toUpperCase()
				+ product.getDescription().substring(1);
		product.setDescription(description);

		Locale clp = new Locale("es", "CL");
		NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
		String price = nf.format(product.getPrice());
		product.setFormatted_price(price);

		repo.save(product);
			
		
	}

	@Override
	public List<Product> searchBy(String productType) {
		
		return repo.findAllByTypeOrderByWearAsc(productType);
	}
}
