package com.retrocicla.felipeazs.io.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.AutoridadEntity;

public interface AutoridadRepository extends JpaRepository<AutoridadEntity, Long>{
	
	AutoridadEntity findByNombre(String nombre);

}
