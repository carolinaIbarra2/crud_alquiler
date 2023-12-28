package com.crud_alquiler.domain.reserva.repository;

import com.crud_alquiler.domain.reserva.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de Reserva
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

  }
