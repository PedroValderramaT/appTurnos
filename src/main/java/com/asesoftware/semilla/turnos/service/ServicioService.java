package com.asesoftware.semilla.turnos.service;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(ServicioService.class);
	
	@Autowired
	private IServicioRepository servicioRepository;
	
	@Autowired
	private IServicioMapper mapperServicio;

	@Override
	public ResponseDTO getAll() {
		
		logger.info("ingreso al metodo getAll ");
		
		logger.info("reresa todos los servicios");
		
		return new ResponseDTO(mapperServicio.listEntityToDto(servicioRepository.findAll()), true, "ok", HttpStatus.OK); 
	
	}

	@Override
	public ResponseDTO getServicioById(Integer id) {
		
		logger.info("ingreso al metodo getServicioById");
		
		Optional<ServiciosEntity> optional = servicioRepository.findById(id);
		if(optional.isPresent()) {
			
			logger.info("servicio encontrado");
			
			return new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK);
		}else {
			
			logger.info("no se encontro el servicio");
			
			return new ResponseDTO(null, false, "servicio no encontrado", HttpStatus.OK);
		}
	}
	
	@Override
	public ResponseDTO createServicio(ServiciosDTO serviciosDTO) {
		
		logger.info("ingreso al metodo createServicio");
		
		try {
		ServiciosEntity serviciosEntity = mapperServicio.dtoToEntity(serviciosDTO); 
		
		servicioRepository.save(serviciosEntity);
		
		logger.info("se creo el servicio");
	
		return new ResponseDTO(mapperServicio.entityToDTO(serviciosEntity), true, "servicio creado correctamente", HttpStatus.OK);
		} catch(Exception e) {
			
			logger.error("Error {}",e.getMessage());
			
			return new ResponseDTO(null, false, "servicio no puede ser creado", HttpStatus.OK);
		}
	}
	
	
	@Override
	public ResponseDTO updateServicio(ServiciosDTO serviciosDTO) {
		
		logger.info("ingreso al metodo updateServicio");
		
		ServiciosEntity serviciosEntity = mapperServicio.dtoToEntity(serviciosDTO);
		
		servicioRepository.save(serviciosEntity);
		
		logger.info("servicio actualizado");
		
		return new ResponseDTO(mapperServicio.entityToDTO(serviciosEntity), true, "servicio actualizado", HttpStatus.OK);
	}

	@Override
	public ResponseDTO deleteServicio(Integer id) {
		
		logger.info("ingreso al metodo deleteServicio");
		
		try {
			servicioRepository.deleteById(id);
		
			logger.info("el servicio {} se elimino",id);
		
			return new ResponseDTO(null, true, "servicio eliminado", HttpStatus.OK);
		}catch (Exception e) {
			
			logger.error("Error {}",e.getMessage());
			return new ResponseDTO(null, false, "servicio no existe", HttpStatus.OK);
		}
	}

	
}
