package com.retrocicla.felipeazs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.retrocicla.felipeazs.model.Client;
import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.service.ClientService;
import com.retrocicla.felipeazs.service.ProductService;

@Controller
public class WebController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private ProductService productService;

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
						
		modelMultipleSelect(product, model);

		return "index";
	}

	@GetMapping("/addproductpage")
	public String getAddProductPage(@ModelAttribute("product") Product product, Model model) {
		
		modelMultipleSelect(product, model);

		return "addproduct";
	}
	
	@GetMapping("/addproductdb")
	public String getAddProductdv(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model) {

		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}
		
		System.out.println("type: " + product.getType());
		
		productService.add(product);		
		
		return getIndex(product, model);
	}
	
	@GetMapping("/ropaspage")
	public String getRopasPage(Model model) {
		
		model.addAttribute("products", productService.searchBy("prenda"));
		
		return "listadoproductos";
	}
	
	@GetMapping("/telaspage")
	public String getTelasPage(Model model) {
		
		model.addAttribute("products", productService.searchBy("tela"));
		
		return "listadoproductos";
	}
	
	@GetMapping("/searchproduct")
	public String getSearchProduct(@Valid @ModelAttribute("product") Product product, BindingResult br, Model model) {
		
		if (br.hasErrors()) {
			System.out.println(br.toString());
			return "index";
		}
		
		return null;
	}
	
	// FUNCIONES Y MÉTODOS
	
	private void modelMultipleSelect(Product product, Model model) {
		model.addAttribute("wear", product.listingWears());
		model.addAttribute("styles", product.listingStyles());
		model.addAttribute("seasons", product.listingSeasons());
		model.addAttribute("materials", product.listingMaterials());
		model.addAttribute("types", product.listingTypes());
		model.addAttribute("colors", product.listingColors());
		model.addAttribute("genres", product.listingGenres());
	}
	
}
