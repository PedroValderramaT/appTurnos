package com.asesoftware.semilla.turnos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.semilla.turnos.dto.ServiciosDTO;
import com.asesoftware.semilla.turnos.entity.ServiciosEntity;

@Mapper(componentModel = "spring")
public interface IServicioMapper {
	
	
	public ServiciosDTO entityToDTO(ServiciosEntity serviciosEntity);
	
	public ServiciosEntity dtoToEntity(ServiciosDTO serviciosDTO);
	
	public List<ServiciosDTO> listEntityToDto(List<ServiciosEntity> serviciosEntity);
	
	public List<ServiciosEntity> listDtoToEntity(List<ServiciosDTO> serviciosDTO);
	
}
