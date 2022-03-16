package com.retrocicla.felipeazs.controller;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	private ClienteService clienetService;

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

	@ModelAttribute("client")
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
	public String getLogin() {
		return "login";
	}

	@GetMapping("logout")
	public String getLogout() {
		return "logout";
	}

	@GetMapping("/")
	public String getIndex(Product product, Model model) {

		modelMultipleSelection(model);
		setTotalAmountAndQuantityProducts(model, cartService.list());

		return "index";
	}
	
	@PostMapping("/registrarcliente")
	public String getRegistroCliente(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult br, Model model) {
		
		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}
		
		return null;
	}

	@GetMapping("/addproductpage")
	public String getAddProductPage() {

		return "addproduct";
	}

	@GetMapping("/addproductdb")
	public String getAddProductdv(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model) {

		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}

		Product add_product = productService.add(product);
		model.addAttribute("addProduct", add_product);

		setTotalAmountAndQuantityProducts(model, cartService.list());

		return getIndex(product, model);
	}

	@GetMapping("/ropaspage")
	public String getRopasPage(Model model) {

		model.addAttribute("products", productService.searchBy("prenda"));

		setTotalAmountAndQuantityProducts(model, cartService.list());

		return "productslist";
	}

	@GetMapping("/telaspage")
	public String getTelasPage(Model model) {

		model.addAttribute("products", productService.searchBy("tela"));

		setTotalAmountAndQuantityProducts(model, cartService.list());

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

		Product pro = productService.findProductById(product.getId());
		model.addAttribute("product", pro);

		return "productdetails";
	}

	@GetMapping("/cartdetails")
	public String getProductDetails(Model model) {

		model.addAttribute("cartitems", cartService.list());

		setTotalAmountAndQuantityProducts(model, cartService.list());

		return "cartdetails";
	}

	@GetMapping("/checkout")
	public String getCheckout(Model model, Authentication auth) {
		
		String email = auth.getName();
		System.out.println(email);

		setTotalAmountAndQuantityProducts(model, cartService.list());
		model.addAttribute("regiones", regionService.list());
		model.addAttribute("ciudades", ciudadService.list());

		return "checkout";
	}

	@PostMapping("/addOrder")
	public String getAddOrder(@Valid @ModelAttribute("order") Order order, BindingResult br,
			Model model) {

		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "error-404";
		}
		
		List<Cart> items = cartService.list();
		
		orderService.save(order, items);
		
		List<Order> nueva_orden = orderService.listByClienteId(31);
		
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

	private void setTotalAmountAndQuantityProducts(Model model, List<Cart> cartitems) {

		int totalAmount = 0;
		int totalQuantity = 0;
		for (Cart cartitem : cartitems) {
			totalQuantity = totalQuantity + cartitem.getQuantity();
			totalAmount = totalAmount + (cartitem.getPrice() * cartitem.getQuantity());
		}

		Locale clp = new Locale("es", "CL");
		NumberFormat nf = NumberFormat.getCurrencyInstance(clp);
		String totalprice = nf.format(totalAmount);

		model.addAttribute("totalquantity", totalQuantity);
		model.addAttribute("totalamount", totalprice);
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
