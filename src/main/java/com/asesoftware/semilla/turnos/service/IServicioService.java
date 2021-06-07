package com.asesoftware.semilla.turnos.service;

import java.util.List;

import com.asesoftware.semilla.turnos.entity.ServiciosEntity;

public interface IServicioService {
	
	public List<ServiciosEntity> getAll();
	

	public ServiciosEntity getServicioById(Integer id);
	
	public ServiciosEntity createServicio(ServiciosEntity serviciosEntity);
	
	public ServiciosEntity updateServicio(ServiciosEntity serviciosEntity);
	
	public void deleteServicio(Integer id);

}
