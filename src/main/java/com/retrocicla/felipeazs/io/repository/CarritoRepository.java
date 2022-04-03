package com.retrocicla.felipeazs.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.CarritoEntity;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.ProductoEntity;

public interface CarritoRepository extends JpaRepository<CarritoEntity, Integer> {
	
	CarritoEntity findByClienteId(String cliente_id);

	CarritoEntity findByClienteAndProducto(ClienteEntity clienteEntity, ProductoEntity productoEntity);

	List<CarritoEntity> findAllByClienteClienteId(String clienteId);

	List<CarritoEntity> findAllByClienteEmail(String email);

}
