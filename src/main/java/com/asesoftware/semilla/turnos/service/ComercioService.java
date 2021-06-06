package com.asesoftware.semilla.turnos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public ComercioEntity getComercioById(Integer id) {

		return null;
	}

	@Override
	public ComercioEntity createComercio(ComercioEntity comercioEntity) {

		return null;
	}

	@Override
	public ComercioEntity updateComercio(ComercioEntity comercioEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComercio(Integer id) {
		
		
	}

}
