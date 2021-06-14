package com.asesoftware.semilla.turnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.entity.ComercioEntity;
import com.asesoftware.semilla.turnos.service.IComercioService;

@RestController
@RequestMapping(path = "/api/v1/comercio")
public class ComercioController {
	
	@Autowired
	private IComercioService comercioService;
	
	//listar todos
	
	@GetMapping(path = "/all")
	public List<ComercioEntity> getAll(){
		return comercioService.getAll();
	}
	
	//listar comercio por id
	//@GetMapping(path = "/comercio/{id}")
	//public ComercioEntity getComercioById(@PathVariable Integer id) {
	//	return comercioService.getComercioById(id);
	//}
	
	@GetMapping(path = "/comercio/{id}")
	public ResponseDTO getComercioById(@PathVariable Integer id) {
		return comercioService.getComercioById(id);
	}
	
	//mostrar por parametro id
	//@GetMapping(path = "/comercio")
	//public ComercioEntity getComercioParametroById(@RequestParam Integer id) {
	//	return comercioService.getComercioById(id);
	//}
	
	@GetMapping(path = "/comercio")
	public ResponseDTO getComercioParametroById(@RequestParam Integer id) {
		return comercioService.getComercioById(id);
	}
	
	
	//crear comercio
	//@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	//public ComercioEntity createComercio(@RequestBody ComercioEntity entity) {
	//	return comercioService.createComercio(entity);
	//} 
	
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO createComercio(@RequestBody ComercioEntity entity) {
		return comercioService.createComercio(entity);
	}
	
	//editar comercio
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ComercioEntity updateComercio(@RequestBody ComercioEntity entity) {
		return comercioService.updateComercio(entity);
	} 
	
	//eliminar comercio
	//@GetMapping(path = "/delete/{id}")
	//public void deleteComercio(@PathVariable Integer id) {
	//	comercioService.deleteComercio(id);
	//}
	
	@GetMapping(path = "/delete/{id}")
	public ResponseDTO deleteComercio(@PathVariable Integer id) {
		return comercioService.deleteComercio(id);
	}
	
}
