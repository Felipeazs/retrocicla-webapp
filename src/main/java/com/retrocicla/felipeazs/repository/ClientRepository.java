package com.retrocicla.felipeazs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    Client findByEmail(String email);
}
