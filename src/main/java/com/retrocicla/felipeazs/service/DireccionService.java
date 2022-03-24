package com.retrocicla.felipeazs.service;

import java.util.List;

import com.retrocicla.felipeazs.model.dto.DireccionDto;

public interface DireccionService {

	List<DireccionDto> obtenerDireccionesCliente(String clienteid);

	DireccionDto obtenerDireccionCliente(String direccionid);
	
	
}
