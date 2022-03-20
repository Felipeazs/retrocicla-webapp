package com.retrocicla.felipeazs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Cliente findByEmail(String email);
}
