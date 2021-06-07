package com.asesoftware.semilla.turnos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "servicios")
public class ServiciosEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nom_servicio")
	private String nombreServicio;
	
	@Column(name = "hora_apertura")
	private String horaApertura;
	
	@Column(name = "hora_cierre")
	private String horaCierre;
	
	@Column(name = "id_comercio")
	private Integer idComercio;
	
	@Column(name = "duracion")
	private Integer duracionServicio;
}
