package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.io.entity.CarritoEntity;
import com.retrocicla.felipeazs.model.CalculoTotalModel;
import com.retrocicla.felipeazs.model.dto.CarritoDto;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.ui.model.request.ProductoRequestModel;

public interface CarritoService {



	List<CarritoDto> buscarTodosLosProductos(String clienteId);

	CalculoTotalModel calcularTotalCliente(String clienteEmail);

	List<CarritoDto> obtenerTodosPorCliente(String email);

	CarritoDto actualizarProductoEnCarrito(CarritoEntity producto, String email);

	CarritoDto agregarProductoAlCarrito(ProductoRequestModel detalle_producto, ClienteDto cliente);
	
//	List<Cart> list();
//	void addProduct(Product product, Cliente cliente);
//	void updateProduct(int productId, String email);
//	void removeProduct(Integer productId, String email);
//	void deleteProduct(Integer productId, String email);
//	List<Cart> getProductsByClienteId(String cliente);
//	List<Cart> listByEmail(String name);
//	Cart getProductByIdAndEmail(int id, String email);
//	List<Cart> listByClienteEmail(String email);

	
}