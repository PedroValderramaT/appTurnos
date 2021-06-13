package com.asesoftware.semilla.turnos.dto;

import lombok.Data;

@Data
public class ServiciosDTO {
	
	private Integer identificador;
		
	private String servicio;
		
	private String apertura;
		
	private String cierre;
		
	private Integer identificadorComercio;
		
	private Integer duracion;

}
