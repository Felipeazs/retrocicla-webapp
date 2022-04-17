package com.retrocicla.felipeazs.service;

import java.util.ArrayList;
import java.util.List;


import com.retrocicla.felipeazs.model.dto.ProductoDto;

public interface ProductoService {
	
	public List<ProductoDto> listarProducts(int page, int limit);

	public ProductoDto crearProducto(ProductoDto productDto);

	public List<ArrayList<String>> getMultipleSelection();

	public ProductoDto obtenerProductoPorId(String productoId);

	public List<ProductoDto> buscarPorPrenda(String tipo_de_producto);

	public List<ProductoDto> buscarProductos(ProductoDto productoDto, int page, int limit);

}
