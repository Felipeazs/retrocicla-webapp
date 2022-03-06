package com.retrocicla.felipeazs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Client;
import com.retrocicla.felipeazs.repository.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository repo;

    @Override
    public List<Client> list() {
        return null;
    }
}