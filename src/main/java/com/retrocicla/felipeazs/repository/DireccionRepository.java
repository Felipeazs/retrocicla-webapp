package com.retrocicla.felipeazs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.model.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

	Direccion findByCalle(String calle);

	List<Direccion> findAllByClienteEmail(String email);

}
