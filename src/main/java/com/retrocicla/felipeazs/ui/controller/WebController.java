package com.retrocicla.felipeazs.ui.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.retrocicla.felipeazs.io.entity.CarritoEntity;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.OrdenesEntity;
import com.retrocicla.felipeazs.io.entity.ProductoEntity;
import com.retrocicla.felipeazs.model.CalculoTotalModel;
import com.retrocicla.felipeazs.model.dto.CarritoDto;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.model.dto.DireccionDto;
import com.retrocicla.felipeazs.model.dto.ProductoDto;
import com.retrocicla.felipeazs.service.CarritoService;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.service.OrdenesService;
import com.retrocicla.felipeazs.service.ProductoService;
import com.retrocicla.felipeazs.ui.model.request.CarritoRequestModel;
import com.retrocicla.felipeazs.ui.model.request.ClienteRequestModel;
import com.retrocicla.felipeazs.ui.model.request.ProductoRequestModel;
import com.retrocicla.felipeazs.ui.model.response.CarritoRest;
import com.retrocicla.felipeazs.ui.model.response.ClienteRest;
import com.retrocicla.felipeazs.ui.model.response.DireccionRest;
import com.retrocicla.felipeazs.ui.model.response.ProductoRest;

@Controller
public class WebController {
	
	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private OrdenesService ordenesService;
	
	@ModelAttribute("producto")
	private ProductoEntity setProduct() {
		return new ProductoEntity();
	}
	
	@Autowired
	private CarritoService carritoService;
	
	@ModelAttribute("carrito")
	private CarritoEntity setCartEntity() {
		return new CarritoEntity();
	}
	
	@ModelAttribute("carrito_model")
	private CarritoRequestModel setCarritoRequestModel() {
		return new CarritoRequestModel();
	}
	
	@ModelAttribute("cliente")
	private ClienteEntity setClienteEntity() {
		return new ClienteEntity();
	}
	
	@ModelAttribute("cliente_model")
	private ClienteRequestModel setClienteRequestModel() {
		return new ClienteRequestModel();
	}
	

	/**
	 *  
	 * @param model
	 * @param auth
	 * @return
	 */
	@GetMapping("/")
	public String getIndex(Model model, Authentication auth) {
		
		autenticacion(model, auth);
				
		return "index";
	}
	
	@GetMapping("/tienda")
	public String getTienda(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "tienda";
	}
	
	@GetMapping("/catalogo/{tipo_de_producto}")
	public String getCatalogo(@PathVariable String tipo_de_producto, Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		List<ProductoRest> returnValue = new ArrayList<>();
		
		List<ProductoDto> productos = new ArrayList<>();
		
		if (tipo_de_producto.equals("mostrar_todo")) {
			productos = productoService.listarProducts(1, 25);
			model.addAttribute("titulo", "Catálogo");
		} else {
			productos = productoService.buscarPorPrenda(tipo_de_producto);			
			model.addAttribute("titulo", tipo_de_producto);			
		}
		
		ModelMapper modelMapper = new ModelMapper();
		for (ProductoDto producto : productos) {
			returnValue.add(modelMapper.map(producto, ProductoRest.class));
		}
		
		model.addAttribute("productos", returnValue);
		
		return "catalogo";
	}
	
	@GetMapping("/item/{productoId}")
	public String getDetalleItem(@PathVariable String productoId, Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		ProductoRest returnValue = new ProductoRest();
		
		ProductoDto producto = productoService.obtenerProductoPorId(productoId);
		
		BeanUtils.copyProperties(producto, returnValue);	
		
		model.addAttribute("item", returnValue);		
		
		return "detalle-item";
	}
	
	@GetMapping("/informacion-usuario")
	public String getInformacionUsuario(Model model, Authentication auth) {
				
		autenticacion(model, auth);
		
		ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());
			
		ModelMapper modelMapper = new ModelMapper();
		ClienteRest returnCliente = modelMapper.map(cliente, ClienteRest.class);
					
		List<CarritoRest> returnProductos = new ArrayList<>();
		List<CarritoDto> productos = carritoService.obtenerTodosPorCliente(cliente.getClienteId());
		for (CarritoDto prod : productos) {
			returnProductos.add(modelMapper.map(prod, CarritoRest.class));
		}				
		
		model.addAttribute("cliente", returnCliente);
		model.addAttribute("productos", returnProductos);
		
		return "informacion-usuario";
	}
	
	@GetMapping("/informacion-envio")
	public String getInformacionEnvio(@ModelAttribute CarritoRequestModel carrito_detalle, Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());
		carritoService.actualizarCarritoDetalleCliente(carrito_detalle, cliente);
		
		ModelMapper modelMapper = new ModelMapper();
		List<CarritoRest> returnProductos = new ArrayList<>();
		List<CarritoDto> productos = carritoService.obtenerTodosPorCliente(cliente.getClienteId());
		for (CarritoDto prod : productos) {
			returnProductos.add(modelMapper.map(prod, CarritoRest.class));
		}
		
		model.addAttribute("productos", returnProductos);
		
		return "informacion-envio";
	}
	
	@GetMapping("/informacion-pago")
	public String getInformacionPago(@RequestParam String radio, Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());		
		carritoService.actualizarCarritoEnvio(radio, cliente);	
		
		ModelMapper modelMapper = new ModelMapper();
		List<CarritoRest> returnProductos = new ArrayList<>();
		
		try {
			List<CarritoDto> productos = carritoService.obtenerTodosPorCliente(cliente.getClienteId());
			
			for (CarritoDto prod : productos) {
				returnProductos.add(modelMapper.map(prod, CarritoRest.class));
			}
			
			model.addAttribute("cliente", returnProductos.get(0));
			model.addAttribute("productos", returnProductos);
		} catch (IndexOutOfBoundsException ex) {
			return "informacion-pago";
		}
		
		
		return "informacion-pago";
	}
	
	@GetMapping("/redirigiendo")
	public String getRedireccion(@RequestParam String radio1, String radio2, ClienteEntity detalle_cliente,  Model model, Authentication auth) {
			
		ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());		
		carritoService.actualizarCarritoPago(radio1, cliente);
		
		List<CarritoDto> carrito_cliente = carritoService.obtenerTodosPorCliente(cliente.getClienteId());
		List<OrdenesEntity> ordenes = new ArrayList<>();
		ModelMapper modelMapper = new ModelMapper();
		for (CarritoDto producto : carrito_cliente) {
			ordenes.add(modelMapper.map(producto, OrdenesEntity.class));			
		}
				
		ordenesService.agregarOrden(ordenes, cliente);	
			
		carritoService.eliminarProductos(cliente.getClienteId());
		
		return "/redirigiendo";
	}
	
	@GetMapping("/busqueda-avanzada")
	public String getBusquedaAvanzada() {
		
		return "busqueda-avanzada";
	}
	
	@GetMapping("/somos")
	public String getSomos(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "somos";
	}
		
	@GetMapping("/donaciones")
	public String getDonaciones(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "donaciones";
	}
	
	@GetMapping("/blog")
	public String getBlog(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "blog";
	}
	
	@GetMapping("/noticias")
	public String getNoticias(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "noticias";
	}
	
	@GetMapping("/carrito")
	public String getCarrito(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());
		
		ModelMapper modelMapper = new ModelMapper();
		List<CarritoRest> returnProductos = new ArrayList<>();
		List<CarritoDto> productos = carritoService.obtenerTodosPorCliente(cliente.getClienteId());
		
		for (CarritoDto prod : productos) {
			returnProductos.add(modelMapper.map(prod, CarritoRest.class));
		}
		
		model.addAttribute("productos", returnProductos);
			
		return "carrito";
	}
	
	
	@GetMapping("/politicas-privacidad")
	public String getPoliticasPrivacidad(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "politicas-privacidad";
	}
	
	@GetMapping("/politicas-contacto")
	public String getPoliticasContacto(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "politicas-contacto";
	}
	
	@GetMapping("/politicas-pago")
	public String getPoliticasPago(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "politicas-pago";
	}
	
	@GetMapping("/politicas-despacho")
	public String getPoliticasDespacho(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "politicas-despacho";
	}	

	@GetMapping("/login")
	public String postLogin(Model model, Authentication auth) {	
		
		autenticacion(model, auth);
				
		return "login";
	}
	
	@GetMapping("/email-verification")
	public String getEmailVerification() {
		return "email-verification";
	}
	
	@GetMapping("/password-reset-request")
	public String getPasswordResetRequest() {
		return "/password-reset";
	}
	
	@GetMapping("/registrar-productos")
	public String getRegistrarProductos(Model model, Authentication auth) {
		
		autenticacion(model, auth);
		
		return "/registrar-producto";
	}
	
//	FUNCIONES
		
	private void autenticacion(Model model, Authentication auth) {
		
		try {
			ClienteDto cliente = clienteService.obtenerClienteByEmail(auth.getName());
			ModelMapper modelMapper = new ModelMapper();
			ClienteRest returnCliente = modelMapper.map(cliente, ClienteRest.class);
			
			List<CarritoDto> carrito = carritoService.obtenerTodosPorCliente(cliente.getClienteId());
			
			model.addAttribute("tamano_carrito", carrito.size());
			model.addAttribute("cliente", returnCliente);
		} catch (NullPointerException ex){
			model.addAttribute("cliente", "");
			model.addAttribute("tamano_carrito", "0");
		}
	}
	
}
//	
//	@PostMapping("/registrarcliente")
//	public String getRegistroCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult br, Model model) {
//		
//		if (br.hasErrors()) {
//			System.out.println(br.toString());
//			return "index";
//		}
//		
//		clienteService.add(cliente);
//		
//		return "login";
//	}
//
//	@GetMapping("/addproductpage")
//	public String getAddProductPage() {
//
//		return "addproduct";
//	}
//
//	@GetMapping("/addproductdb")
//	public String getAddProductdv(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model
//			) {
//
//		if (br.hasErrors()) {
//			System.out.println(br.toString());
//			return "index";
//		}
//
//		Product add_product = productService.add(product);
//		model.addAttribute("addProduct", add_product);
//
////		amountAndQuantity(model, auth);
////
////		return getIndex(product, model, auth);
//		
//		return "index";
//	}
//

	
	
//
//	@GetMapping("/telaspage")
//	public String getTelasPage(Model model) {
//
//		model.addAttribute("products", productService.searchBy("tela"));
//
////		amountAndQuantity(model, auth);
//
//		return "productslist";
//	}
//
//	@GetMapping("/searchproduct")
//	public String getSearchProduct(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model) {
//
//		if (br.hasErrors()) {
//			System.out.println(br.toString());
//			return "index";
//		}
//
//		List<Product> products = productService.searchProducts(product);
//		model.addAttribute("products", products);
//		model.addAttribute("productssize", products.size());
//
//		return "productslist";
//	}
//

//

//
//	@GetMapping("/checkout")
//	public String getCheckout(Model model) {
//		
////		amountAndQuantity(model, auth);
////		
////		Cliente cliente = clienteService.getCliente(auth.getName());
////		
////		model.addAttribute("cliente", cliente);
////		model.addAttribute("regiones", regionService.list());
////		model.addAttribute("ciudades", ciudadService.list());
//		
//		return "checkout";
//	}
//
//	@PostMapping("/addOrder")
//	public String getAddOrder(@Valid @ModelAttribute("order") Order order, BindingResult br,
//			Model model) {
//
//		if (br.hasErrors()) {
//			System.out.println(br.toString());
//			return "error-404";
//		}
//		
////		String email = auth.getName();	
////		List<Cart> items = cartService.listByClienteEmail(email);
////		
////		orderService.save(order, items, email);
////		
////		Order nueva_orden = orderService.listByClienteEmailAndObservaciones(email, "abierta");
////		
////		ArrayList<Integer> prods = new ArrayList<>();
////				
////		for (Integer prod : nueva_orden.getProduct()) {
////			prods.add(prod);
////		}		
////						
////		model.addAttribute("order", nueva_orden);
////		
////		Locale clp = new Locale("es", "CL");
////		NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
////		String totalprice = nf.format(nueva_orden.getTotal());	
////		model.addAttribute("total", totalprice);
//		
//
//		return "detallecompra";
//	}
//
//	// FUNCIONES Y MÉTODOS
//	
//	private void amountAndQuantity(Model model, Authentication auth) {
//		
//		int totalAmount = 0;
//		int totalQuantity = 0;
//		int envio = 6990;
//		
//		try {
//			List<Cart> cartitems = cartService.listByEmail(auth.getName());	
//			
//			for (Cart cartitem : cartitems) {
//				totalQuantity = totalQuantity + cartitem.getQuantity();
//				totalAmount = totalAmount + (cartitem.getPrice() * cartitem.getQuantity());
//			}			
//				
//			Locale clp = new Locale("es", "CL");
//			NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
//			String totalprice = nf.format(totalAmount);	
//			String despacho = nf.format(envio);
//			String total_envio = nf.format(totalAmount + envio);	
//				
//			model.addAttribute("totalquantity", totalQuantity);
//			model.addAttribute("totalamount", totalprice);
//			model.addAttribute("envio", despacho);
//			model.addAttribute("total", total_envio);
//			
//		} catch (NullPointerException ex) {
//			model.addAttribute("totalquantity", 0);
//			model.addAttribute("totalamount", 0);
//		}
//	}

