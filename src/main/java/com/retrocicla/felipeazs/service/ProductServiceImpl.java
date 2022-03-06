package com.retrocicla.felipeazs.service;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.Exceptions.ErrorMessages;
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> list() {

        return repo.findAll();
    }

	@Override
	public void add(Product product) {
		
		try {
			if (!product.getImage_url().equals("null") || !product.getImage_url().isEmpty()) {
				
				String size = product.getSize().toUpperCase();
				product.setSize(size);
								
				String genre = product.getGenre().substring(0, 1).toUpperCase();
				product.setGenre(genre);
				
				String madeIn = product.getMade_in().substring(0, 1).toUpperCase();
				product.setMade_in(madeIn);
				
				String color = product.getColor().substring(0, 1).toUpperCase();
				product.setColor(color);
				
				String description = product.getDescription().substring(0, 1).toUpperCase();
				product.setDescription(description);
				
				repo.save(product);			
			}
		} catch (NullPointerException e) {
			System.out.println(ErrorMessages.MISSING_WEAR_REQUIRED_FIELD.getErrorMessage());			
		}			
	}
}
