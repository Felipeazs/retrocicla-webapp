package com.retrocicla.felipeazs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository repo;

    @Override
    public List<Cliente> list() {
        return null;
    }
}