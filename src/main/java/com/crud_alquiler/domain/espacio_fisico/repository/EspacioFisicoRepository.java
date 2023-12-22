package com.crud_alquiler.domain.espacio_fisico.repository;

import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de EspacioFisico
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
@Repository
public interface EspacioFisicoRepository extends JpaRepository<EspacioFisico, Long> {
}
