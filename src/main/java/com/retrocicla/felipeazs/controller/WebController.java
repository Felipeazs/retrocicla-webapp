package com.retrocicla.felipeazs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

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
    private Client setClient(){
        return new Client();
    }

    @ModelAttribute("product")
    private Product setProduct(){
        return new Product();
    }

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("logout")
    public String getLogout(){
        return "logout";
    }

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }
}
