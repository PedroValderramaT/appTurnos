package com.asesoftware.semilla.turnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.turnos.dto.ServiciosDTO;
import com.asesoftware.semilla.turnos.entity.ServiciosEntity;
import com.asesoftware.semilla.turnos.service.IServicioService;

@RestController
@RequestMapping(path = "/api/v1/servicio")
public class ServicioController {
	
	@Autowired
	private IServicioService servicioService;
	
	//listar servicios
	@GetMapping(path = "/todos")
	public List<ServiciosEntity> consultarTodosServicios(){
		return servicioService.getAll();
	}
	
	//listar servicio por id
	@GetMapping(path = "/servicio/{id}")
	public ServiciosEntity getServicioById(@PathVariable Integer id) {
		return servicioService.getServicioById(id);
	}
	
	//creacion servicio
	//@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json" )
	//public ServiciosEntity createServicio(@RequestBody ServiciosEntity entity) {
	//	return servicioService.createServicio(entity);
	//}
	
	//creacion servicio con dto
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json" )
	public ServiciosDTO createServicio(@RequestBody ServiciosDTO dto) {
		return servicioService.createServicio(dto);
	}
	
	//editar servicio
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json" )
	public ServiciosEntity updateServicio(@RequestBody ServiciosEntity entity) {
		return servicioService.updateServicio(entity);
	}
	
	//eliminar servicio
	@GetMapping(path = "/delete/{id}")
	public void deleteServicio(@PathVariable Integer id) {
		servicioService.deleteServicio(id);
	}
	
	//buscar servicio por id consultando el DTO
	@GetMapping(path = "/{id}")
	public ServiciosDTO buscarPorId(@PathVariable Integer id) {
		return servicioService.buscarPorId(id);
	}
	
	
	
	
	
}
