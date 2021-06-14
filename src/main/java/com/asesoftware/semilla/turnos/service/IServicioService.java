package com.asesoftware.semilla.turnos.service;

import java.util.List;

import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.dto.ServiciosDTO;
import com.asesoftware.semilla.turnos.entity.ServiciosEntity;

public interface IServicioService {
	
	
	public ResponseDTO getAll();
	
	public ResponseDTO getServicioById(Integer id);
	
	
	public ServiciosEntity updateServicio(ServiciosEntity serviciosEntity);
	
	public void deleteServicio(Integer id);
		
	public ServiciosDTO buscarPorId(Integer id);
	
	public ServiciosDTO createServicio(ServiciosDTO serviciosDTO);

}
