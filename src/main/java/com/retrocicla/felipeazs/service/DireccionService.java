package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.Direccion;

public interface DireccionService {
	
	List<Direccion> list();
	void addAddress(Direccion direccion);
	Direccion getAddress(String direccionid);
	List<Direccion> listAddress(String email);

}
