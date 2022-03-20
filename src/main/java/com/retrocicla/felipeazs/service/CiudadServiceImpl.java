package com.retrocicla.felipeazs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Ciudad;
import com.retrocicla.felipeazs.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService{
	
	@Autowired
	private CiudadRepository repo;

	@Override
	public List<Ciudad> list() {
		
		return repo.findAllByNameOrderByNameAsc();
	}

	@Override
	public List<Ciudad> findAllByRegion(Integer regionid) {
		
		return repo.findAllByRegionIdOrderByNameAsc(regionid);
	}

}
