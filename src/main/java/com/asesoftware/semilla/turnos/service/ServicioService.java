package com.asesoftware.semilla.turnos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<ServiciosEntity> getAll() {

		return servicioRepository.findAll();
	}

	@Override
	public ServiciosEntity getServicioById(Integer id) {
		Optional<ServiciosEntity> optional = servicioRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	@Override
	public ServiciosEntity createServicio(ServiciosEntity serviciosEntity) {
			try {
			return servicioRepository.save(serviciosEntity);
		} catch (Exception e) {
			return null;
		}
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
