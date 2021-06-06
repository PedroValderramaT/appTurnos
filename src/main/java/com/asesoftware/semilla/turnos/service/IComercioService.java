package com.asesoftware.semilla.turnos.service;

import java.util.List;

import com.asesoftware.semilla.turnos.entity.ComercioEntity;

public interface IComercioService {
	
	public List<ComercioEntity> getAll();
	
	public ComercioEntity getComercioById(Integer id);
	
	public ComercioEntity createComercio(ComercioEntity comercioEntity);
	
	public ComercioEntity updateComercio(ComercioEntity comercioEntity);
	
	public void deleteComercio(Integer id);

}
