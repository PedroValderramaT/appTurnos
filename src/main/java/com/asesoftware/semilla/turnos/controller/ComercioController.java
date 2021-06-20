package com.asesoftware.semilla.turnos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asesoftware.semilla.turnos.dto.ComerciosDTO;
import com.asesoftware.semilla.turnos.dto.ResponseDTO;
import com.asesoftware.semilla.turnos.service.IComercioService;

@RestController
@RequestMapping(path = "/api/v1/comercio")
public class ComercioController {
	
	private static final Logger logger = LoggerFactory.getLogger(ComercioController.class);
	
	@Autowired
	private IComercioService comercioService;
	
	//listar todos	
	@GetMapping(path = "/all")
	public ResponseDTO getAll(){
		
		logger.info("ingreso al metodo getAll ");
		
		return comercioService.getAll();
	}
	
	//listar comercio por id
	@GetMapping(path = "/comercio/{id}")
	public ResponseDTO getComercioById(@PathVariable Integer id) {
		
		logger.info("ingreso al metodo getComercioById ");

		logger.info("comercio a consultar con el id {}", id);
		
		
		return comercioService.getComercioById(id);
	}
	
	//mostrar por parametro id	
	@GetMapping(path = "/comercio")
	public ResponseDTO getComercioParametroById(@RequestParam Integer id) {
		
		logger.info("ingreso al metodo getComercioParametroById ");

		logger.info("comercio a consultar con el id {}", id);
		
		return comercioService.getComercioById(id);
	}
	
	
	//crear comercio
	@PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
	public ResponseDTO createComercio(@RequestBody ComerciosDTO entity) {
		
		logger.info("ingreso al metodo createComercio ");

		logger.info("comercio a crear con los datos {}", entity);
		
		return comercioService.createComercio(entity);
	}
	
	//editar comercio
	@PostMapping(path = "/editar", consumes = "application/json", produces = "application/json")
	public ResponseDTO updateComercio(@RequestBody ComerciosDTO entity) {
		
		logger.info("ingreso al metodo updateComercio ");

		logger.info("comercio a actualizar con los datos {}", entity);
		
		return comercioService.updateComercio(entity);
	} 
	
	//eliminar comercio
	@GetMapping(path = "/delete/{id}")
	public ResponseDTO deleteComercio(@PathVariable Integer id) {
		
		logger.info("ingreso al metodo deleteComercio ");

		logger.info("comercio a eliminar {}",id);
		
		return comercioService.deleteComercio(id);
	}
	
}
