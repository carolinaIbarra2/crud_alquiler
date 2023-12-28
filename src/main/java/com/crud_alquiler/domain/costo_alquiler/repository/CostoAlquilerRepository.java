package com.crud_alquiler.domain.costo_alquiler.repository;

import com.crud_alquiler.domain.costo_alquiler.entidades.CostoAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de CostoAlquiler
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
public interface CostoAlquilerRepository extends JpaRepository<CostoAlquiler, Long> {


    }

