package com.asesoftware.semilla.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.semilla.turnos.entity.ServiciosEntity;

public interface IServicioRepository extends JpaRepository<ServiciosEntity, Integer>{

}
