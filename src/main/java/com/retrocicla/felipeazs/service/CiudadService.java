package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Ciudad;

public interface CiudadService {
	
	List<Ciudad> list();

	List<Ciudad> findAllByRegion(Integer regionid);

}
