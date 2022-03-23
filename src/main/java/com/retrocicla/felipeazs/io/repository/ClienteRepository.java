package com.retrocicla.felipeazs.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
	
	ClienteEntity findByEmail(String email);

	ClienteEntity findByClienteId(String clienteid);

}
