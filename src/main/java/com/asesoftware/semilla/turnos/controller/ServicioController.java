package com.asesoftware.semilla.turnos.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.dto.ServiciosDTO;

import com.asesoftware.semilla.turnos.service.IServicioService;

@RestController
@RequestMapping(path = "/api/v1/servicio")
public class ServicioController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServicioController.class);
	
	@Autowired
	private IServicioService servicioService;
	
	//listar servicios
	@GetMapping(path = "/todos")
	public ResponseDTO consultarTodosServicios(){
		
		logger.info("ingreso al metodo consultarTodosServicios");
		
		return servicioService.getAll();
	}
	
	//listar servicio por id
	@GetMapping(path = "/servicio/{id}")
	public ResponseDTO getServicioById(@PathVariable Integer id) {
		
		logger.info("ingreso al metodo getServicioById ");

		logger.info("servicio a consultar con el id {}", id);
		
		return servicioService.getServicioById(id);
	}
	
	//creacion servicio
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json" )
	public ResponseDTO createServicio(@RequestBody ServiciosDTO dto) {
		
		logger.info("ingreso al metodo createServicio ");

		logger.info("servicio a crear con los datos {}", dto);
		
		return servicioService.createServicio(dto);
	}
	
	//editar servicio
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json" )
	public ResponseDTO updateServicio(@RequestBody ServiciosDTO entity) {
		
		logger.info("ingreso al metodo updateServicio ");

		logger.info("servicio a actualizar con los datos {}", entity);
		
		return servicioService.updateServicio(entity);
	}
	
	//eliminar servicio
	@GetMapping(path = "/delete/{id}")
	public ResponseDTO deleteServicio(@PathVariable Integer id) {
		
		logger.info("ingreso al metodo deleteServicio ");

		logger.info("servicio a eliminar {}",id);
		
		return servicioService.deleteServicio(id);
	}
		
	
	
	
	
}
