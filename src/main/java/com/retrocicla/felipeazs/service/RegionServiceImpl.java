package com.retrocicla.felipeazs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.model.Region;
import com.retrocicla.felipeazs.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {
	
	@Autowired
	private RegionRepository repo;

	@Override
	public List<Region> list() {
		
		return repo.findAll();
	}

	@Override
	public Region getRegion(String region) {
		
		int id = Integer.parseInt(region);
		return repo.findById(id).get();
	}

}
