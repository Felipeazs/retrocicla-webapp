package com.retrocicla.felipeazs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.io.entity.OrdenesEntity;
import com.retrocicla.felipeazs.io.repository.OrdenesRepository;
import com.retrocicla.felipeazs.model.dto.ClienteDto;
import com.retrocicla.felipeazs.service.OrdenesService;

@Service
public class OrdenesServiceImpl implements OrdenesService {
	
	@Autowired
	private OrdenesRepository ordenesRepo;

	@Override
	public void agregarOrden(List<OrdenesEntity> ordenes, ClienteDto cliente) {
		
		for (OrdenesEntity orden : ordenes) {
			orden.setClienteId(cliente.getClienteId());
			ordenes.set(0, orden);
		}
		
		ordenesRepo.saveAll(ordenes);
		
	}

}
