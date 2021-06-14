package com.asesoftware.semilla.turnos.service;

import com.asesoftware.semilla.turnos.dto.ComerciosDTO;
import com.asesoftware.semilla.turnos.dto.ResponseDTO;

public interface IComercioService {
	
	public ResponseDTO getAll();
	
	public ResponseDTO getComercioById(Integer id);
	
	public ResponseDTO createComercio(ComerciosDTO comerciosDTO);
	
	public ResponseDTO updateComercio(ComerciosDTO comerciosDTO);
	
	public ResponseDTO deleteComercio(Integer id);


}
