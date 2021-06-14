package com.asesoftware.semilla.turnos.dto;

import java.util.List;

import lombok.Data;

@Data
public class ComerciosDTO {
		
	private Integer id;
		
	private String nombre_comercio;	
	
	private Integer aforo_max;
	
	private List<ServiciosDTO> servicios;

}
