package com.asesoftware.semilla.turnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.turnos.dto.ComerciosDTO;
import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.entity.ComercioEntity;
import com.asesoftware.semilla.turnos.mapper.IComercioMapper;
import com.asesoftware.semilla.turnos.repository.IComercioRepository;

@Service
public class ComercioService implements IComercioService{
	
	@Autowired
	private IComercioRepository comercioRepository;
	
	@Autowired
	private IComercioMapper mapperComercio;
	
	@Override
	public ResponseDTO getAll() {
		return new ResponseDTO(mapperComercio.listEntityToDto(comercioRepository.findAll()), true, "ok", HttpStatus.OK); 
	}
	
	@Override
	public ResponseDTO getComercioById(Integer id) {
		Optional<ComercioEntity> optional = comercioRepository.findById(id);
		
		if(optional.isPresent()) {
			return new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "comercio no encontrado", HttpStatus.OK);
		}
	}


	
	@Override
	public ResponseDTO createComercio(ComerciosDTO comerciosDTO) {
		try {			
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comerciosDTO);
			comercioRepository.save(comercioEntity);
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "comercio creado correctamente", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseDTO(null, false, "el comercio no puede ser creado", HttpStatus.OK);
		}
		
	}
	
	@Override
	public ResponseDTO updateComercio(ComerciosDTO comerciosDTO) {
		
		ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comerciosDTO);
		
		comercioRepository.save(comercioEntity);
		
		return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "comercio actualizado correctamente", HttpStatus.OK);
	}

	
	@Override
	public ResponseDTO deleteComercio(Integer id) {
		
		try {
			comercioRepository.deleteById(id);
			return new ResponseDTO(null, true, "comercio eliminado", HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseDTO(null, false, "comercio no existe", HttpStatus.OK);
		}
		
	}

}
