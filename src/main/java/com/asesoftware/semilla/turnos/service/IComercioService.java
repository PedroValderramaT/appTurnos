package com.asesoftware.semilla.turnos.service;

import java.util.List;

import com.asesoftware.semilla.turnos.dto.ComerciosDTO;
import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.entity.ComercioEntity;

public interface IComercioService {
	
	public List<ComercioEntity> getAll();
	
	//public ComercioEntity getComercioById(Integer id);
	
	public ResponseDTO getComercioById(Integer id);
	
	//public ComercioEntity createComercio(ComercioEntity comercioEntity);
	
	//public ResponseDTO createComercio(ComercioEntity comercioEntity);
	
	public ResponseDTO createComercio(ComerciosDTO comerciosDTO);
	
	public ComercioEntity updateComercio(ComercioEntity comercioEntity);
	
	//public void deleteComercio(Integer id);
	
	public ResponseDTO deleteComercio(Integer id);


}
