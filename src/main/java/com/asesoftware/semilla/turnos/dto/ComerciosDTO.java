package com.asesoftware.semilla.turnos.dto;

import java.util.List;

import lombok.Data;

@Data
public class ComerciosDTO {
		
	private Integer id;
		
	private String nombreComercio;	
	
	private Integer aforoMax;
	
	private List<ServiciosDTO> servicios;

}
