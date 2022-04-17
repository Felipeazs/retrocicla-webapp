package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.io.entity.CarritoEntity;
import com.retrocicla.felipeazs.model.CalculoTotalModel;
import com.retrocicla.felipeazs.model.dto.CarritoDto;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.ui.model.request.CarritoRequestModel;
import com.retrocicla.felipeazs.ui.model.request.ClienteRequestModel;
import com.retrocicla.felipeazs.ui.model.request.ProductoRequestModel;

public interface CarritoService {



	List<CarritoDto> buscarTodosLosProductos(String clienteId);

	CalculoTotalModel calcularTotalCliente(String clienteEmail);

	List<CarritoDto> obtenerTodosPorCliente(String clienteId);

	CarritoDto agregarProductoAlCarrito(CarritoDto producto, ClienteDto cliente);

	void actualizarCarritoEnvio(String radio, ClienteDto cliente);

	void actualizarCarritoDetalleCliente(CarritoRequestModel carrito_detalle, ClienteDto cliente);

	void actualizarCarritoPago(String radio1, ClienteDto cliente);

	void eliminarProductos(String clienteId);

	void eliminarProductoDelCarrito(String productoId, String clienteId);

}
	

	
