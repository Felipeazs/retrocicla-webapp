package com.retrocicla.felipeazs.controller;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.retrocicla.felipeazs.model.Cart;
import com.retrocicla.felipeazs.model.Client;
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.service.CartService;
import com.retrocicla.felipeazs.service.ClientService;
import com.retrocicla.felipeazs.service.ProductService;

@Controller
public class WebController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CartService cartService;

	@ModelAttribute("client")
	private Client setClient() {
		return new Client();
	}

	@ModelAttribute("product")
	private Product setProduct() {
		return new Product();
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
	public String getProductDetailsPage(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model) {
		
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
	public String getCheckout(Model model) {		
		
		setTotalAmountAndQuantityProducts(model, cartService.list());		
		
		return "checkout";
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
