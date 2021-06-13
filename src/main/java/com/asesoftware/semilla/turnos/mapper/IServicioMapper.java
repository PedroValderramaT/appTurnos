package com.asesoftware.semilla.turnos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.semilla.turnos.dto.ServiciosDTO;
import com.asesoftware.semilla.turnos.entity.ServiciosEntity;

@Mapper(componentModel = "spring")
public interface IServicioMapper {
	
	@Mappings({
		@Mapping(source  = "id", target = "identificador"),
		@Mapping(source  = "nombreServicio", target = "servicio"),
		@Mapping(source  = "horaApertura", target = "apertura"),
		@Mapping(source  = "horaCierre", target = "cierre"),
		@Mapping(source  = "idComercio", target = "identificadorComercio"),
		@Mapping(source  = "duracionServicio", target = "duracion")
		})
	public ServiciosDTO entityToDTO(ServiciosEntity serviciosEntity);
	
	@Mappings({
		@Mapping(source  = "identificador", target = "id"),
		@Mapping(source  = "servicio", target = "nombreServicio"),	
		@Mapping(source  = "apertura", target = "horaApertura"),
		@Mapping(source  = "cierre", target = "horaCierre"),
		@Mapping(source  = "identificadorComercio", target = "idComercio"),
		@Mapping(source  = "duracion", target = "duracionServicio")		
		})
	public ServiciosEntity dtoToEntity(ServiciosDTO serviciosDTO);
	
	public List<ServiciosDTO> listEntityToDto(List<ServiciosEntity> serviciosEntity);
	
	public List<ServiciosEntity> listDtoToEntity(List<ServiciosDTO> serviciosDTO);
	
}
