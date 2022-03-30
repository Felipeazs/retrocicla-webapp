package com.retrocicla.felipeazs.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.RolEntity;

public interface RolRepository extends JpaRepository<RolEntity, Long>{
	
	RolEntity findByNombre(String nombre);

}
