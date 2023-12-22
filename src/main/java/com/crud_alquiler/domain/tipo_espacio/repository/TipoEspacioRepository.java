package com.crud_alquiler.domain.tipo_espacio.repository;

import com.crud_alquiler.domain.tipo_espacio.entidades.TipoEspacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de Tipo de espacio
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
@Repository
public interface TipoEspacioRepository extends JpaRepository<TipoEspacio, Long> {
    /*
    @Query("SELECT TE FROM TipoEspacio TE")
    Page<TipoEspacio> findAllTipoEspacio(Pageable pageable);*/
}
