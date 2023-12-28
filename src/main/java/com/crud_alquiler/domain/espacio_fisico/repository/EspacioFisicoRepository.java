package com.crud_alquiler.domain.espacio_fisico.repository;

import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de EspacioFisico
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */@Repository
public interface EspacioFisicoRepository extends JpaRepository<EspacioFisico, Long> {

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un nombre duplicado en la tabla
     * EspacioFisico. Se utiliza para comprobar si ya existe un registro con este mismo nombre antes de realizar una
     * inserción.
     *
     * @param nombre El valor del nombre que se va a comprobar si está duplicado.
     * @return Booleano que indica si existe un nombre duplicado (true) o no (false).
     */
    @Query("""
        SELECT EXISTS(
            SELECT ef FROM EspacioFisico ef
            WHERE ef.nombre=:nombre
        ) AS duplicate_nombre
    """)
    Boolean findDuplicateNombreToInsert(String nombre);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de una descripcion duplicada en la tabla
     * EspacioFisico. Se utiliza para comprobar si ya existe un registro con esta misma descripcion antes de realizar una
     * inserción.
     *
     * @param descripcion El valor de la descripcion que se va a comprobar si está duplicado.
     * @return Booleano que indica si existe una descripcion duplicada (true) o no (false).
     */
    @Query("""
        SELECT EXISTS(
            SELECT ef FROM EspacioFisico ef
            WHERE ef.descripcion=:descripcion
        ) AS duplicate_descripcion
    """)
    Boolean findDuplicateDescripcionToInsert(String descripcion);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un nombre y unaa descripcion duplicada
     * en la tabla EspacioFisico. Se utiliza para comprobar si ya existe un registro con este mismo nombre y esta misma
     * descripcion antes de realizar una inserción.     *
     * @param nombre El valor del nombre que se va a comprobar si está duplicado.
     * @param descripcion El valor de la descripcion que se va a comprobar si está duplicado.
     * @return Booleano que indica si existe un nombre y descripcion duplicada (true) o no (false).
     */
    @Query("""
        SELECT EXISTS(
            SELECT ef FROM EspacioFisico ef
            WHERE ef.nombre=:nombre AND ef.descripcion=:descripcion
        ) AS duplicate_nombre_descripcion
    """)
    Boolean findDuplicateNombreDescripcionToInsert(String nombre, String descripcion);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un nombre duplicado en la tabla
     * EspacioFisico al actualizar un registro. Se utiliza para comprobar si existe otro registro con el mismo EspacioFisico
     * (excluyendo el registro actual) antes de realizar una actualización.
     *
     * @param nombre    El valor del nombre que se va a comprobar si está duplicado.
     * @param espacioFisicoID El ID del espacioFisico que se está actualizando. Se excluye de la comprobación.
     * @return Booleano que indica si existe un nombre duplicado (true) o no (false) excluyendo el registro actual.
     */
    @Query("""
        SELECT EXISTS(
            SELECT ef FROM EspacioFisico ef
            WHERE ef.nombre=:nombre AND 
            ef.id=:espacioFisicoID
        ) AS duplicate_nombre
    """)
    Boolean findDuplicateNombreToUpdate(String nombre, Long espacioFisicoID);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de una descripcion duplicada en la tabla
     * EspacioFisico al actualizar un registro. Se utiliza para comprobar si existe otro registro con el mismo EspacioFisico
     * (excluyendo el registro actual) antes de realizar una actualización.
     *
     * @param descripcion    El valor de la descripcion que se va a comprobar si está duplicado.
     * @param espacioFisicoID El ID del espacioFisico que se está actualizando. Se excluye de la comprobación.
     * @return Booleano que indica si existe una descripcion duplicada (true) o no (false) excluyendo el registro actual.
     */
    @Query("""
        SELECT EXISTS(
            SELECT ef FROM EspacioFisico ef
            WHERE ef.descripcion=:descripcion AND 
            ef.id=:espacioFisicoID
        ) AS duplicate_descripcion
    """)
    Boolean findDuplicateDescripcionToUpdate(String descripcion, Long espacioFisicoID);


    @Query("""
        SELECT EXISTS(
            SELECT ef FROM EspacioFisico ef
            WHERE ef.nombre=:nombre AND
            ef.descripcion=:descripcion AND 
            ef.id=:espacioFisicoID
        ) AS duplicate_descripcion
    """)
    Boolean findDuplicateNombreDescripcionToUpdate(String nombre, String descripcion, Long espacioFisicoID);
}