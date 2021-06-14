package com.asesoftware.semilla.turnos.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.dto.ServiciosDTO;
import com.asesoftware.semilla.turnos.entity.ServiciosEntity;
import com.asesoftware.semilla.turnos.mapper.IServicioMapper;
import com.asesoftware.semilla.turnos.repository.IServicioRepository;

@Service
public class ServicioService implements IServicioService{
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private IServicioMapper mapperServicio;

	@Override
	public ResponseDTO getAll() {

		return new ResponseDTO(mapperServicio.listEntityToDto(servicioRepository.findAll()), true, "ok", HttpStatus.OK); 
	
	}

	@Override
	public ResponseDTO getServicioById(Integer id) {
		Optional<ServiciosEntity> optional = servicioRepository.findById(id);
		if(optional.isPresent()) {
			return new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "servicio no encontrado", HttpStatus.OK);
		}
	}
	
	@Override
	public ResponseDTO createServicio(ServiciosDTO serviciosDTO) {
		try {
		ServiciosEntity serviciosEntity = mapperServicio.dtoToEntity(serviciosDTO); 
		
		servicioRepository.save(serviciosEntity);
	
		return new ResponseDTO(mapperServicio.entityToDTO(serviciosEntity), true, "servicio creado correctamente", HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseDTO(null, false, "servicio no puede ser creado", HttpStatus.OK);
		}
	}
	
	
	@Override
	public ResponseDTO updateServicio(ServiciosDTO serviciosDTO) {
		
		ServiciosEntity serviciosEntity = mapperServicio.dtoToEntity(serviciosDTO);
		
		servicioRepository.save(serviciosEntity);
		
		return new ResponseDTO(mapperServicio.entityToDTO(serviciosEntity), true, "servicio actualizado", HttpStatus.OK);
	}

	@Override
	public ResponseDTO deleteServicio(Integer id) {
		try {
		servicioRepository.deleteById(id);
		return new ResponseDTO(null, true, "servicio eliminado", HttpStatus.OK);
		}catch (Exception e) {
		return new ResponseDTO(null, false, "servicio no existe", HttpStatus.OK);
		}
	}

	
}
