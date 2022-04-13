//package com.retrocicla.felipeazs.ui.controller;
//
//import org.modelmapper.ModelMapper;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.retrocicla.felipeazs.io.entity.ProductoEntity;
//import com.retrocicla.felipeazs.model.CalculoTotalModel;
//import com.retrocicla.felipeazs.model.dto.CarritoDto;
//import com.retrocicla.felipeazs.model.dto.ClienteDto;
//import com.retrocicla.felipeazs.model.dto.ProductoDto;
//import com.retrocicla.felipeazs.service.CarritoService;
//import com.retrocicla.felipeazs.service.ClienteService;
//import com.retrocicla.felipeazs.service.ProductoService;
//import com.retrocicla.felipeazs.ui.model.response.CarritoRest;
//
//@RestController
//@RequestMapping("carrito")
//public class CarritoController {
//	
//	@Autowired
//	private CarritoService carritoService;
//	
//	@Autowired
//	private ClienteService clienteService;
//	
//	@Autowired
//	private ProductoService productoService;
//	
//	@PostMapping(
//			path = "/{productoId}",
//			produces = { MediaType.APPLICATION_JSON_VALUE })
//	public CarritoRest agregarProductoAlCarrito(@PathVariable String productoId, Authentication auth) {
//		
//		System.out.println(productoId);
//		
//		String clienteEmail = auth.getName();
//				
//		CarritoDto carritoDto = carritoService.agregarProductoAlCarrito(productoId, clienteEmail);
//		
//		CarritoRest returnValue = new CarritoRest();
//		
//		ModelMapper modelMapper = new ModelMapper();
//		returnValue = modelMapper.map(carritoDto, CarritoRest.class);
//		
//		return returnValue;
//		
//	}
//	
//	@GetMapping(
//			path = "/cliente/{clienteId}",
//			produces = { MediaType.APPLICATION_JSON_VALUE })
//	public CalculoTotalModel calcularElTotalDelCliente(@PathVariable String clienteId){
//				
//		ClienteDto clienteDto = clienteService.obtenerClienteById(clienteId);
//		
//		CalculoTotalModel returnValue = carritoService.calcularTotalCliente(clienteDto.getEmail());
//				
//		return returnValue;
//	}
//	
//	@PutMapping(
//			path = "/restar/{productoId}",
//			produces = { MediaType.APPLICATION_JSON_VALUE })
//	public void restarUnProductoDeUnCliente(@PathVariable String productoId, Authentication auth) {
//		
////		CarritoDto carrito = carritoService.obtenerPorProductoYCliente()
////		
////		carritoService.actualizarProductoEnCarrito(producto, auth.getName());
//		
//		
//		
//		
//	}
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
