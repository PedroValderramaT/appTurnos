package com.asesoftware.semilla.turnos.dto;

import lombok.Data;

@Data
public class ServiciosDTO {
	
	private Integer id;
		
	private String nombreServicio;
		
	private String horaApertura;
		
	private String horaCierre;
		
	private Integer idComercio;
		
	private Integer duracionServicio;

}
