package com.asesoftware.semilla.turnos.dto;

import lombok.Data;

@Data
public class ServiciosDTO {
	
	private Integer identificador;
		
	private String nombre;
		
	private String apertura;
		
	private String cierre;
		
	private Integer idComercio;
		
	private Integer duracion;

}
