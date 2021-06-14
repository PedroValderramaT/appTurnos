package com.asesoftware.semilla.turnos.service;

import java.util.List;
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
	public ServiciosDTO createServicio(ServiciosDTO serviciosDTO) {
		
		ServiciosEntity serviciosEntity = mapperServicio.dtoToEntity(serviciosDTO); 
	
		return mapperServicio.entityToDTO(servicioRepository.save(serviciosEntity));
	}
	
	
	@Override
	public ServiciosEntity updateServicio(ServiciosEntity serviciosEntity) {
		return servicioRepository.save(serviciosEntity);
	}

	@Override
	public void deleteServicio(Integer id) {
		servicioRepository.deleteById(id);
		
	}

	@Override
	public ServiciosDTO buscarPorId(Integer id) {
		// TODO Auto-generated method stub
		Optional<ServiciosEntity> serviciosEntity = servicioRepository.findById(id); 
		return mapperServicio.entityToDTO(serviciosEntity.get());
	}

	
}
