package com.retrocicla.felipeazs.service;

import java.text.NumberFormat;
import java.util.ArrayList;
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
	public Product add(Product product) {
		
		if (product.getType().equals("tela")) {			
			product.setGenre("indefinido");
			product.setStyle("indefinido");
			product.setSeason("indefinido");
			product.setWear("indefinido");			
		} else {			
			String genre = product.getGenre().toLowerCase();
			product.setGenre(genre);			
		}
		
		if (product.getCotton() >= product.getSpandex()) {
			product.setMaterial("algodón");
		} else {
			product.setMaterial("spandex");
		}
		
		String size = product.getSize().toUpperCase();
		product.setSize(size);
			
		String madeIn = product.getMade().substring(0, 1).toUpperCase() + product.getMade().substring(1);
		product.setMade(madeIn);

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
			
		return product;
		
	}

	@Override
	public List<Product> searchBy(String productType) {
		
		return repo.findAllByTypeOrderByWearAsc(productType);
	}

	@Override
	public List<String> getDistinctByWear() {
		
		return repo.getDistinctByWear();
	}

	@Override
	public List<String> getDistinctByStyle() {
		
		return repo.getDistinctByStyle();
	}

	@Override
	public List<String> getDistinctByGenre() {
		
		return repo.getDistinctByGenre();
	}

	@Override
	public List<String> getDistinctByType() {
		
		return repo.getDistinctByType();
	}

	@Override
	public List<String> getDistinctByMaterial() {
		
		return repo.getDistinctByMaterial();
	}

	@Override
	public List<String> getDistinctByColor() {
		
		return repo.getDistinctByColor();
	}

	@Override
	public List<String> getDistinctByRopaSize() {
		
		return repo.getDistinctByRopaSize();
	}

	@Override
	public List<String> getDistinctByTelaSize() {
		
		return repo.getDistinctByTelaSize();
	}

	@Override
	public List<String> getDistinctByMadeIn() {
		
		return repo.getDistinctByMadeIn();
	}

	@Override
	public List<Product> searchProducts(Product product) {		
				
		int sizeIndex = product.getSize().indexOf(',');		
				
		if (product.getType().equals("tela")) {					
			product.setGenre("indefinido");
			product.setStyle("indefinido");
		    product.setSeason("indefinido");
			product.setWear("indefinido");
			product.setSize(product.getSize().substring(sizeIndex + 1));
		} else {
			product.setSize(product.getSize().substring(0, sizeIndex));
		}
						
		String type = product.getType();
		String material = product.getMaterial();		
		String wear = product.getWear();
		String color = product.getColor();
		String size = product.getSize();
		String style = product.getStyle();
		String genre = product.getGenre();
		String season = product.getSeason();
		String madeIn = product.getMade();
				
		return repo.findByTypeAndMaterialAndWearAndColorAndSizeAndStyleAndGenreAndSeasonAndMade(type, material, wear, color, size, style, genre, season, madeIn);
	}

	@Override
	public Product getProductById(int id) {
		
		return repo.findById(id);
	}

	@Override
	public List<Product> listById(ArrayList<Integer> pps) {
		
		List<Product> products = repo.findAllById(pps);
		
		
		
		return products;
	}

	
}
