package com.crud_alquiler.domain.reserva.repository;

import com.crud_alquiler.domain.reserva.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de Reserva
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
public interface ReservaRepository extends JpaRepository<Reserva, Long> {


}
