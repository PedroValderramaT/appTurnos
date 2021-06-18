package com.asesoftware.semilla.turnos.dto;

import java.util.List;

import lombok.Data;

@Data
public class ComerciosDTO {
		
	private Integer identificador;
		
	private String nombre;	
	
	private Integer aforoMaximo;
	
	private List<ServiciosDTO> servicios;

}
