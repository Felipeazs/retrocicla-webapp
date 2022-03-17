package com.retrocicla.felipeazs.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.model.Order;
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.service.CartService;
import com.retrocicla.felipeazs.service.CiudadService;
import com.retrocicla.felipeazs.service.ClienteService;
import com.retrocicla.felipeazs.service.OrderService;
import com.retrocicla.felipeazs.service.ProductService;
import com.retrocicla.felipeazs.service.RegionService;

@Controller
public class WebController {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;

	@Autowired
	private RegionService regionService;

	@Autowired
	private CiudadService ciudadService;
	
	@Autowired
	private OrderService orderService;

	@ModelAttribute("cliente")
	private Cliente setCliente() {
		return new Cliente();
	}

	@ModelAttribute("product")
	private Product setProduct() {
		return new Product();
	}
	
	@ModelAttribute("order")
	private Order setOrder() {
		return new Order();
	}
	
	@GetMapping("/registro")
	public String postRegistro() {		
		return "registro";
	}

	@GetMapping("/login")
	public String postLogin() {				
		return "login";
	}

	@GetMapping("logout")
	public String getLogout() {
		return "logout";
	}

	@GetMapping("/")
	public String getIndex(Product product, Model model, Authentication auth) {

		modelMultipleSelection(model);		
		amountAndQuantity(model, auth);

		return "index";
	}
	
	@PostMapping("/registrarcliente")
	public String getRegistroCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult br, Model model) {
		
		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}
		
		clienteService.add(cliente);
		
		return "index";
	}

	@GetMapping("/addproductpage")
	public String getAddProductPage() {

		return "addproduct";
	}

	@GetMapping("/addproductdb")
	public String getAddProductdv(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model,
			Authentication auth) {

		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}

		Product add_product = productService.add(product);
		model.addAttribute("addProduct", add_product);

		amountAndQuantity(model, auth);

		return getIndex(product, model, auth);
	}

	@GetMapping("/ropaspage")
	public String getRopasPage(Model model, Authentication auth) {

		model.addAttribute("products", productService.searchBy("prenda"));

		amountAndQuantity(model, auth);

		return "productslist";
	}

	@GetMapping("/telaspage")
	public String getTelasPage(Model model, Authentication auth) {

		model.addAttribute("products", productService.searchBy("tela"));

		amountAndQuantity(model, auth);

		return "productslist";
	}

	@GetMapping("/searchproduct")
	public String getSearchProduct(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model) {

		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}

		List<Product> products = productService.searchProducts(product);
		model.addAttribute("products", products);
		model.addAttribute("productssize", products.size());

		return "productslist";
	}

	@GetMapping("/productdetails")
	public String getProductDetailsPage(@Valid @ModelAttribute("product") Product product, BindingResult br,
			Model model) {

		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}

		Product pro = productService.getProductById(product.getId());
		model.addAttribute("product", pro);

		return "productdetails";
	}

	@GetMapping("/cartdetails")
	public String getProductDetails(Model model, Authentication auth) {
		
		String cliente = auth.getName();
		List<Cart> products = cartService.getProductsByClienteId(cliente);

		model.addAttribute("cartitems", products);

		amountAndQuantity(model, auth);

		return "cartdetails";
	}

	@GetMapping("/checkout")
	public String getCheckout(Model model, Authentication auth) {
		
		amountAndQuantity(model, auth);
		
		model.addAttribute("regiones", regionService.list());
		model.addAttribute("ciudades", ciudadService.list());

		return "checkout";
	}

	@PostMapping("/addOrder")
	public String getAddOrder(@Valid @ModelAttribute("order") Order order, BindingResult br,
			Model model, Authentication auth) {

		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "error-404";
		}
		
		List<Cart> items = cartService.list();
		String clienteEmail = auth.getName();		
		
		orderService.save(order, items, clienteEmail);
		
		List<Order> nueva_orden = orderService.listByClienteEmail(clienteEmail);
		
		ArrayList<Integer> prods = new ArrayList<>();
		for (Order nn : nueva_orden) {
			for (Integer prod : nn.getProduct()) {
				prods.add(prod);
			}
		}
						
		model.addAttribute("order", nueva_orden);
		model.addAttribute("products", productService.listById(prods));

		return "detallecompra";
	}

	// FUNCIONES Y MÉTODOS
	
	private void amountAndQuantity(Model model, Authentication auth) {
		
		int totalAmount = 0;
		int totalQuantity = 0;
		
		try {
			List<Cart> cartitems = cartService.listByEmail(auth.getName());	
			
			for (Cart cartitem : cartitems) {
				totalQuantity = totalQuantity + cartitem.getQuantity();
				totalAmount = totalAmount + (cartitem.getPrice() * cartitem.getQuantity());
			}			
				
			Locale clp = new Locale("es", "CL");
			NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
			String totalprice = nf.format(totalAmount);	
				
			model.addAttribute("totalquantity", totalQuantity);
			model.addAttribute("totalamount", totalprice);	
			
		} catch (NullPointerException ex) {
			model.addAttribute("totalquantity", 0);
			model.addAttribute("totalamount", 0);
		}
	}

	private void modelMultipleSelection(Model model) {
		model.addAttribute("types", productService.getDistinctByType());
		model.addAttribute("materials", productService.getDistinctByMaterial());
		model.addAttribute("colors", productService.getDistinctByColor());
		model.addAttribute("ropasizes", productService.getDistinctByRopaSize());
		model.addAttribute("telasizes", productService.getDistinctByTelaSize());
		model.addAttribute("wear", productService.getDistinctByWear());
		model.addAttribute("styles", productService.getDistinctByStyle());
		model.addAttribute("genres", productService.getDistinctByGenre());
		model.addAttribute("madeIn", productService.getDistinctByMadeIn());

	}

}
