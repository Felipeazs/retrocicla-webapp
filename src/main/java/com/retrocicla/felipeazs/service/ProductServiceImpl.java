package com.retrocicla.felipeazs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Product;
import com.retrocicla.felipeazs.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> list() {

        return repo.findAll();
    }
}
