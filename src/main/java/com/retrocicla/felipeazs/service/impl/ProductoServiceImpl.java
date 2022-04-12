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

import com.retrocicla.felipeazs.exceptions.ProductoServiceException;
import com.retrocicla.felipeazs.io.entity.ProductoEntity;
import com.retrocicla.felipeazs.io.repository.ProductoRepository;
import com.retrocicla.felipeazs.model.dto.ProductoDto;
import com.retrocicla.felipeazs.service.ProductoService;
import com.retrocicla.felipeazs.shared.Utils;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepo;

	@Autowired
	private Utils utils;

	@Override
	public ProductoDto crearProducto(ProductoDto productDto) {

		ProductoEntity dbProduct = productoRepo.findByImageUrl(productDto.getImageUrl());
		if (dbProduct != null)
			throw new ProductoServiceException(ErrorMessages.RECORDS_ALREADY_EXIST.getErrorMessage());

		ProductoEntity newProduct = new ProductoEntity();
				
		BeanUtils.copyProperties(productDto, newProduct);
		
		String productoId = utils.generateProductId(10);
		newProduct.setProductoId(productoId);
		newProduct.setFormatted_price(formatPrice(productDto.getPrice()));
		
		ProductoEntity savedProduct = productoRepo.save(newProduct);
		
		ProductoDto returnValue = new ProductoDto();
		
		BeanUtils.copyProperties(savedProduct, returnValue);

		return returnValue;
	}

	@Override
	public List<ProductoDto> listarProducts(int page, int limit) {

		if (page > 0)
			page = page - 1;

		List<ProductoDto> returnValue = new ArrayList<>();

		Pageable pageableReq = PageRequest.of(page, limit);

		Page<ProductoEntity> pageProducts = productoRepo.findAll(pageableReq);

		if (pageProducts == null)
			throw new ProductoServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());

		List<ProductoEntity> products = pageProducts.getContent();
		
		ModelMapper modelMapper = new ModelMapper();

		for (ProductoEntity product : products) {
			returnValue.add(modelMapper.map(product, ProductoDto.class));			
		}

		return returnValue;
	}
	
	@Override
	public ProductoDto obtenerProductoPorId(String productoId) {
		
		ProductoDto returnValue = new ProductoDto();
		
		ProductoEntity productoEntity = productoRepo.findByProductoId(productoId);
		BeanUtils.copyProperties(productoEntity, returnValue);
		
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
		
		ArrayList<String> type = productoRepo.getDistinctByType();
		ArrayList<String> material = productoRepo.getDistinctByMaterial();
		ArrayList<String> wear = productoRepo.getDistinctByWear();
		ArrayList<String> color = productoRepo.getDistinctByColor();
		ArrayList<String> telasize = productoRepo.getDistinctByTelaSize();
		ArrayList<String> ropasize = productoRepo.getDistinctByRopaSize();
		ArrayList<String> style = productoRepo.getDistinctByStyle();
		ArrayList<String> genre = productoRepo.getDistinctByGenre();
		ArrayList<String> made = productoRepo.getDistinctByMadeIn();
		
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
	public List<ProductoDto> buscarPorPrenda(String productType) {
		
		List<String> items = new ArrayList<>();
		String[] texto = productType.split("_");
		
		for (String txt : texto) {
			System.out.println(txt);
			items.add(txt);
		}
		
		System.out.println("nombre: "+ productType + " tamaño: " + texto.length);
		
		List<ProductoDto> returnValue = new ArrayList<>();
		List<ProductoEntity> productos =new ArrayList<>();
		
		if (productType.equals("prenda") || productType.equals("material")) {
			productos = productoRepo.findAllByTypeOrderByWearAsc(productType);
		} else if (productType.equals("outdoor") || productType.equals("casual")) {
			productos = productoRepo.findAllByStyleOrderByWearAsc(productType);
		} else if (productType.equals("sintética") || productType.equals("natural") || productType.equals("artificial") || productType.equals("origen animal")) {
			productos = productoRepo.findAllByFibra(productType);
		} else if (productType.equals("algodón") || productType.equals("spandex") || productType.equals("poliester")) {
			productos = productoRepo.findAllByMaterial(productType);
		} else if (texto.length > 1) {
			productos = productoRepo.findAllByWearAndGenreOrderByWearAsc(items.get(0), items.get(1));
		} 
				
		ModelMapper modelMap = new ModelMapper();
		for (ProductoEntity producto : productos) {
			returnValue.add(modelMap.map(producto, ProductoDto.class));			
		}
		
		
		return returnValue;
	}
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
