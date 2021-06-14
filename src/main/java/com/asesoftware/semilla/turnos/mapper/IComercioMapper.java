package com.asesoftware.semilla.turnos.mapper;

import org.mapstruct.Mapper;

import com.asesoftware.semilla.turnos.dto.ComerciosDTO;
import com.asesoftware.semilla.turnos.entity.ComercioEntity;

@Mapper(componentModel = "spring")
public interface IComercioMapper {

	public ComercioEntity dtoToEntity(ComerciosDTO dto);
	
	public ComerciosDTO entityToDto(ComercioEntity comercioEntity);
	
}
