package com.retrocicla.felipeazs.io.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.retrocicla.felipeazs.io.entity.CarritoEntity;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.ProductoEntity;

public interface CarritoRepository extends JpaRepository<CarritoEntity, Integer> {
	
	CarritoEntity findByClienteId(String cliente_id);

	List<CarritoEntity> findAllByClienteClienteId(String clienteId);

	CarritoEntity findByClienteAndProductoId(ClienteEntity clienteEntity, String productoId);

	List<CarritoEntity> findAllByClienteId(String clienteId);

	CarritoEntity findByClienteClienteIdAndProductoId(String clienteId, String productoId);

}
