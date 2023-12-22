package com.crud_alquiler.domain.tipo_espacio.repository;

import com.crud_alquiler.domain.tipo_espacio.entity.TipoEspacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de Tipo de espacio
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
@Repository
public interface TipoEspacioRepository extends JpaRepository<TipoEspacio, Long> {

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un nombre duplicado en la tabla TipoEspacio.
     * Se utiliza para comprobar si ya existe un registro con el mismo tipoEspacio antes de realizar una inserción.
     * @param tipoEspacio El valor del tipoEspacio que se va a comprobar si está duplicado.
     * @return Booleano que indica si existe un nombre duplicado (true) o no (false).
     */
    @Query("""
            SELECT EXISTS(
                SELECT te FROM TipoEspacio te
                WHERE te.tipoEspacio =:tipoEspacio
            ) AS duplicate_name
            """)
    Boolean findDuplicateNameToInsert(String tipoEspacio);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un
     * nombre duplicado en la tabla TipoEspacio al actualizar un registro.
     * Se utiliza para comprobar si existe otro registro con el mismo tipoEspacio
     * (excluyendo el registro actual) antes de realizar una actualización.
     * @param tipoEspacio    El valor del tipoEspacio que se va a comprobar si está duplicado.
     * @param tipoEspacioID  El ID del registro que se está actualizando. Se excluye de la comprobación.
     * @return Booleano que indica si existe un nombre duplicado (true) o no (false) excluyendo el registro actual.
     */
    @Query("""
            SELECT EXISTS(
                SELECT te FROM TipoEspacio te
                WHERE te.tipoEspacio =:tipoEspacio
                AND te.id != :tipoEspacioID
            ) AS duplicate_name
            """)
    Boolean findDuplicateNameToUpdate(String tipoEspacio, Long tipoEspacioID);
}
