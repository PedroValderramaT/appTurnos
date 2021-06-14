package com.asesoftware.semilla.turnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.entity.ComercioEntity;
import com.asesoftware.semilla.turnos.repository.IComercioRepository;

@Service
public class ComercioService implements IComercioService{
	
	@Autowired
	private IComercioRepository comercioRepository;

	@Override
	public List<ComercioEntity> getAll() {
		return comercioRepository.findAll();
	}

	//@Override
	//public ComercioEntity getComercioById(Integer id) {
	//	Optional<ComercioEntity> optional = comercioRepository.findById(id);
	//	if(optional.isPresent()) {
	//		return optional.get();
	//	}else {
	//		return null;
	//	}
	//}
	
	@Override
	public ResponseDTO getComercioById(Integer id) {
		Optional<ComercioEntity> optional = comercioRepository.findById(id);
		
		if(optional.isPresent()) {
			return new ResponseDTO(optional.get(), true, "ok", HttpStatus.OK);
		}else {
			return new ResponseDTO(null, false, "comercio no encontrado", HttpStatus.OK);
		}
	}

	//@Override
	//public ComercioEntity createComercio(ComercioEntity comercioEntity) {
	//	try {
	//		return comercioRepository.save(comercioEntity);
	//	}catch(Exception e) {
	//		return null;
	//	}
	//	
	//}
	
	
	@Override
	public ResponseDTO createComercio(ComercioEntity comercioEntity) {
		try {
			comercioRepository.save(comercioEntity);
			return new ResponseDTO(comercioEntity, true, "comercio creado correctamente", HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseDTO(null, false, "el comercio no puede ser creado", HttpStatus.OK);
		}
		
	}

	@Override
	public ComercioEntity updateComercio(ComercioEntity comercioEntity) {
		
		return comercioRepository.save(comercioEntity);
	}

	//@Override
	//public void deleteComercio(Integer id) {
	//	
	//	comercioRepository.deleteById(id);
	//}
	
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
