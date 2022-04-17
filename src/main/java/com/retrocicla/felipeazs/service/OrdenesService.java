package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.io.entity.OrdenesEntity;
import com.retrocicla.felipeazs.model.dto.ClienteDto;

public interface OrdenesService {

	void agregarOrden(List<OrdenesEntity> ordenes, ClienteDto cliente);

}
