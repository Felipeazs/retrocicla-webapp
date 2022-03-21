package com.retrocicla.felipeazs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Direccion;
import com.retrocicla.felipeazs.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	private DireccionRepository repo;

	@Override
	public List<Direccion> list() {
		
		return repo.findAll();
	}

	@Override
	public void addAddress(Direccion direccion) {
		
		repo.save(direccion);
		
	}

	@Override
	public Direccion getAddress(String direccionid) {
		
		int id = Integer.parseInt(direccionid);
		return repo.findById(id).get();
	}

}
