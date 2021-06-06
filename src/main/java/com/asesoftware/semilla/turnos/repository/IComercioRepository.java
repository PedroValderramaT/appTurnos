package com.asesoftware.semilla.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asesoftware.semilla.turnos.entity.ComercioEntity;

public interface IComercioRepository extends JpaRepository<ComercioEntity, Integer>{

}
