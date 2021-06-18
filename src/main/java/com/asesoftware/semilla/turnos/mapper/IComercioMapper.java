package com.asesoftware.semilla.turnos.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.asesoftware.semilla.turnos.dto.ComerciosDTO;
import com.asesoftware.semilla.turnos.entity.ComercioEntity;
 

@Mapper(componentModel = "spring", uses = {IServicioMapper.class})
public interface IComercioMapper {
	
	@Mappings({
		@Mapping(source = "id",target = "identificador" ),
		@Mapping(source = "nombreComercio",target = "nombre" ),
		@Mapping(source = "aforoMax",target = "aforoMaximo" )
	})
	public ComerciosDTO entityToDto(ComercioEntity comercioEntity);
	
	@Mappings({
		@Mapping(source = "identificador",target = "id" ),
		@Mapping(source = "nombre",target = "nombreComercio" ),
		@Mapping(source = "aforoMaximo",target = "aforoMax" )
	})
	public ComercioEntity dtoToEntity(ComerciosDTO dto);
	
	public List<ComerciosDTO> listEntityToDto(List<ComercioEntity> comercioEntity);
	
	public List<ComercioEntity>	listDtoToEntity(List<ComerciosDTO> comerciosDTO);
	
}
