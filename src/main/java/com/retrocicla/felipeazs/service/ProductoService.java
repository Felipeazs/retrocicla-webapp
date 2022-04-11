package com.retrocicla.felipeazs.service;

import java.util.ArrayList;
import java.util.List;

import com.retrocicla.felipeazs.io.entity.ProductoEntity;
import com.retrocicla.felipeazs.model.dto.ProductoDto;

public interface ProductoService {
	
	public List<ProductoDto> listarProducts(int page, int limit);

	public ProductoDto crearProducto(ProductoDto productDto);

	public List<ArrayList<String>> getMultipleSelection();

	public List<ProductoDto> searchBy(String productType);

	public ProductoDto obtenerProductoPorId(String productoId);

}
