package com.retrocicla.felipeazs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retrocicla.felipeazs.exceptions.ClienteServiceException;
import com.retrocicla.felipeazs.io.entity.DireccionEntity;
import com.retrocicla.felipeazs.io.repository.DireccionRepository;
import com.retrocicla.felipeazs.model.dto.DireccionDto;
import com.retrocicla.felipeazs.service.DireccionService;
import com.retrocicla.felipeazs.ui.model.response.ErrorMessages;

@Service
public class DireccionServiceImpl implements DireccionService{
	
	@Autowired
	private DireccionRepository direccionRepo;
	
	@Override
	public List<DireccionDto> obtenerDireccionesCliente(String clienteid) {
				
		List<DireccionEntity> direcciones = direccionRepo.findAllByClienteDetailsClienteId(clienteid);
		
		if (direcciones == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		List<DireccionDto> returnValue = new ArrayList<>();
		
		ModelMapper modelMapper = new ModelMapper();
		
		for (DireccionEntity direccion : direcciones) {
			returnValue.add(modelMapper.map(direccion, DireccionDto.class));
		}
			
		return returnValue;
	}

	@Override
	public DireccionDto obtenerDireccionCliente(String direccionid) {
		
		DireccionEntity direccion = direccionRepo.findByDireccionId(direccionid);
		
		if (direccion == null) throw new ClienteServiceException(ErrorMessages.NO_RECORD_FOUND.getErrorMessage());
		
		DireccionDto returnValue = new DireccionDto();
		
		BeanUtils.copyProperties(direccion, returnValue);
		
		return returnValue;
	}

}
