package com.retrocicla.felipeazs.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retrocicla.felipeazs.model.CalculoTotalModel;
import com.retrocicla.felipeazs.model.dto.CarritoDto;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.service.CarritoService;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.ui.model.request.ProductoRequestModel;
import com.retrocicla.felipeazs.ui.model.response.CarritoRest;

@RestController
public class CarritoController {
	
	@Autowired
	private CarritoService carritoService;
	
	@Autowired
	private ClienteService clienteService;
		
	@RequestMapping(value="/carritos", method=RequestMethod.POST)
	public List<CarritoRest> agregarProductoAlCarrito(@RequestBody ProductoRequestModel detalle_producto, Authentication auth) {
			
		ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());
		CarritoDto producto = new CarritoDto();		
		BeanUtils.copyProperties(detalle_producto, producto);		
		carritoService.agregarProductoAlCarrito(producto, cliente);
		
		List<CarritoRest> returnValue = new ArrayList<>();		
		ModelMapper modelMapper = new ModelMapper();
		
		List<CarritoDto> productos = carritoService.obtenerTodosPorCliente(cliente.getClienteId());
		for (CarritoDto prod : productos) {
			returnValue.add(modelMapper.map(prod, CarritoRest.class));			
		}
		
		return returnValue;
		
	}
	
	@RequestMapping(value="/carritos/{productoId}", method=RequestMethod.DELETE)
	public void eliminarProductoDelCarrito(@PathVariable String productoId, Authentication auth) {
		
		ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());
		carritoService.eliminarProductoDelCarrito(productoId, cliente.getClienteId());
	
	}
	
	@GetMapping(
			path = "/cliente/{clienteId}",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public CalculoTotalModel calcularElTotalDelCliente(@PathVariable String clienteId){
				
		ClienteDto clienteDto = clienteService.obtenerClienteById(clienteId);
		
		CalculoTotalModel returnValue = carritoService.calcularTotalCliente(clienteDto.getEmail());
				
		return returnValue;
	}
	
	@PutMapping(
			path = "/restar/{productoId}",
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public void restarUnProductoDeUnCliente(@PathVariable String productoId, Authentication auth) {
		
//		CarritoDto carrito = carritoService.obtenerPorProductoYCliente()
//		
//		carritoService.actualizarProductoEnCarrito(producto, auth.getName());
		
		
		
		
	}

}















