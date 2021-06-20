package com.asesoftware.semilla.turnos.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger  = LoggerFactory.getLogger(ComercioService.class);
	
	@Autowired
	private IComercioRepository comercioRepository;
	
	@Autowired
	private IComercioMapper mapperComercio;
	
	@Override
	public ResponseDTO getAll() {
		
		logger.info("ingreso al metodo getAll ");
		
		logger.info("reresa todos los comercios ");
		
		return new ResponseDTO(mapperComercio.listEntityToDto(comercioRepository.findAll()), true, "ok", HttpStatus.OK); 
	}
	
	@Override
	public ResponseDTO getComercioById(Integer id) {
		
		logger.info("ingreso al metodo getComercioById");
		
		Optional<ComercioEntity> optional = comercioRepository.findById(id);
		
		if(optional.isPresent()) {
			logger.info("comercio encontrado");
			return new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK);
		}else {
			
			logger.info("no se encontro el comercio");			
			return new ResponseDTO(null, false, "comercio no encontrado", HttpStatus.OK);
		}
	}


	
	@Override
	public ResponseDTO createComercio(ComerciosDTO comerciosDTO) {
		
		logger.info("ingreso al metodo createComercio");
		
		try {			
			ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comerciosDTO);
			
			comercioRepository.save(comercioEntity);
			
			logger.info("se creo el comercio");
			
			return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "comercio creado correctamente", HttpStatus.OK);
		}catch(Exception e) {
			
			logger.error("Error {}",e.getMessage());
			
			return new ResponseDTO(null, false, "el comercio no puede ser creado", HttpStatus.OK);
		}
		
	}
	
	@Override
	public ResponseDTO updateComercio(ComerciosDTO comerciosDTO) {
		
		logger.info("ingreso al metodo updateComercio");
		
		ComercioEntity comercioEntity = mapperComercio.dtoToEntity(comerciosDTO);
		
		comercioRepository.save(comercioEntity);
		
		logger.info("comercio actualizado");
		
		return new ResponseDTO(mapperComercio.entityToDto(comercioEntity), true, "comercio actualizado correctamente", HttpStatus.OK);
	}

	
	@Override
	public ResponseDTO deleteComercio(Integer id) {
		
		logger.info("ingreso al metodo deleteComercio");
		
		try {
			comercioRepository.deleteById(id);
			
			logger.info("el comercio {} se elimino",id);
			
			return new ResponseDTO(null, true, "comercio eliminado", HttpStatus.OK);
		}catch (Exception e) {
			logger.error("Error {}",e.getMessage());
			
			return new ResponseDTO(null, false, "comercio no existe", HttpStatus.OK);
		}
		
	}

}
