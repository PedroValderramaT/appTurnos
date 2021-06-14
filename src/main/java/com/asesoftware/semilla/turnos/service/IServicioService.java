package com.asesoftware.semilla.turnos.service;


import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.dto.ServiciosDTO;


public interface IServicioService {
	
	
	public ResponseDTO getAll();
	
	public ResponseDTO getServicioById(Integer id);
	
	public ResponseDTO createServicio(ServiciosDTO serviciosDTO);
	
	public ResponseDTO updateServicio(ServiciosDTO serviciosDTO);
	
	public ResponseDTO deleteServicio(Integer id);
	


}
