package com.retrocicla.felipeazs.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.DireccionEntity;

public interface DireccionRepository extends JpaRepository<DireccionEntity, Long> {

	List<DireccionEntity> findAllByClienteDetailsClienteId(String clienteid);

	DireccionEntity findByDireccionId(String direccionid);

}
