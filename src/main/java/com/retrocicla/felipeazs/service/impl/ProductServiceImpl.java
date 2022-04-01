package com.retrocicla.felipeazs.service.impl;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.exceptions.ProductServiceException;
import com.retrocicla.felipeazs.io.entity.ProductEntity;
import com.retrocicla.felipeazs.io.repository.ProductRepository;
import com.retrocicla.felipeazs.model.dto.ProductDto;
import com.retrocicla.felipeazs.service.ProductService;
import com.retrocicla.felipeazs.shared.Utils;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;
import com.retrocicla.felipeazs.ui.model.response.ProductRest;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private Utils utils;

	@Override
	public ProductDto crearProducto(ProductDto productDto) {

		ProductEntity dbProduct = productRepo.findByImageUrl(productDto.getImageUrl());
		if (dbProduct != null)
			throw new ProductServiceException(ErrorMessages.RECORDS_ALREADY_EXIST.getErrorMessage());

		ProductEntity newProduct = new ProductEntity();
				
		BeanUtils.copyProperties(productDto, newProduct);
		
		String productId = utils.generateProductId(10);
		newProduct.setProductid(productId);
		newProduct.setFormatted_price(formatPrice(productDto.getPrice()));
		
		ProductEntity savedProduct = productRepo.save(newProduct);
		
		ProductDto returnValue = new ProductDto();
		
		BeanUtils.copyProperties(savedProduct, returnValue);

		return returnValue;
	}

	@Override
	public List<ProductDto> listarProducts(int page, int limit) {

		if (page > 0)
			page = page - 1;

		List<ProductDto> returnValue = new ArrayList<>();

		Pageable pageableReq = PageRequest.of(page, limit);

		Page<ProductEntity> pageProducts = productRepo.findAll(pageableReq);

		if (pageProducts == null)
			throw new ProductServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		List<ProductEntity> products = pageProducts.getContent();
		
		ModelMapper modelMapper = new ModelMapper();

		for (ProductEntity product : products) {
			returnValue.add(modelMapper.map(product, ProductDto.class));			
		}

		return returnValue;
	}

	private String formatPrice(int price) {

		Locale clp = new Locale("es", "CL");
		NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
		String formattedPrice = nf.format(price);

		return formattedPrice;
	}

	@Override
	public List<ArrayList<String>> getMultipleSelection() {
			
		List<ArrayList<String>> selections = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> type = productRepo.getDistinctByType();
		ArrayList<String> material = productRepo.getDistinctByMaterial();
		ArrayList<String> wear = productRepo.getDistinctByWear();
		ArrayList<String> color = productRepo.getDistinctByColor();
		ArrayList<String> telasize = productRepo.getDistinctByTelaSize();
		ArrayList<String> ropasize = productRepo.getDistinctByRopaSize();
		ArrayList<String> style = productRepo.getDistinctByStyle();
		ArrayList<String> genre = productRepo.getDistinctByGenre();
		ArrayList<String> made = productRepo.getDistinctByMadeIn();
		
		selections.add(type);
		selections.add(material);
		selections.add(wear);
		selections.add(color);
		selections.add(telasize);
		selections.add(ropasize);
		selections.add(style);
		selections.add(genre);
		selections.add(made);
		
		System.out.println(selections);
					
		return selections;
	}

//	@Override
//	public List<ProductEntity> list() {
//
//		return repo.findAll();
//	}
//
//	@Override
//	public ProductEntity add(ProductEntity product) {
//		
//		if (product.getType().equals("tela")) {			
//			product.setGenre("indefinido");
//			product.setStyle("indefinido");
//			product.setSeason("indefinido");
//			product.setWear("indefinido");			
//		} else {			
//			String genre = product.getGenre().toLowerCase();
//			product.setGenre(genre);			
//		}
//		
//		if (product.getCotton() >= product.getSpandex()) {
//			product.setMaterial("algodón");
//		} else {
//			product.setMaterial("spandex");
//		}
//		
//		String size = product.getSize().toUpperCase();
//		product.setSize(size);
//			
//		String madeIn = product.getMade().substring(0, 1).toUpperCase() + product.getMade().substring(1);
//		product.setMade(madeIn);
//
//		String color = product.getColor().toLowerCase();
//		product.setColor(color);
//
//		String description = product.getDescription().substring(0, 1).toUpperCase()
//				+ product.getDescription().substring(1);
//		product.setDescription(description);
//
//		Locale clp = new Locale("es", "CL");
//		NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
//		String price = nf.format(product.getPrice());
//		product.setFormatted_price(price);
//
//		repo.save(product);
//			
//		return product;
//		
//	}
//
	@Override
	public List<ProductDto> searchBy(String productType) {
		
		List<ProductEntity> productos = productRepo.findAllByTypeOrderByWearAsc(productType);
		
		List<ProductDto> returnValue = new ArrayList<>();
		
		ModelMapper modelMap = new ModelMapper();
		for (ProductEntity producto : productos) {
			returnValue.add(modelMap.map(producto, ProductDto.class));			
		}
		
		
		return returnValue;
	}
//
//	
//
//	@Override
//	public List<ProductEntity> searchProducts(ProductEntity product) {		
//				
//		int sizeIndex = product.getSize().indexOf(',');		
//				
//		if (product.getType().equals("tela")) {					
//			product.setGenre("indefinido");
//			product.setStyle("indefinido");
//		    product.setSeason("indefinido");
//			product.setWear("indefinido");
//			product.setSize(product.getSize().substring(sizeIndex + 1));
//		} else if (product.getType().equals("prenda") && sizeIndex > 0) {			
//			product.setSize(product.getSize().substring(0, sizeIndex));
//		} else {
//			product.setSize(product.getSize());
//		}
//						
//		String type = product.getType();
//		String material = product.getMaterial();		
//		String wear = product.getWear();
//		String color = product.getColor();
//		String size = product.getSize();
//		String style = product.getStyle();
//		String genre = product.getGenre();
//		String season = product.getSeason();
//		String madeIn = product.getMade();
//				
//		return repo.findByTypeAndMaterialAndWearAndColorAndSizeAndStyleAndGenreAndSeasonAndMade(type, material, wear, color, size, style, genre, season, madeIn);
//	}
//
//	@Override
//	public ProductEntity getProductById(int id) {
//		
//		return repo.findById(id);
//	}
//
//	@Override
//	public List<ProductEntity> listById(ArrayList<Integer> pps) {
//		
//		List<ProductEntity> products = repo.findAllById(pps);
//		
//		
//		
//		return products;
//	}

}
