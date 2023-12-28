package com.crud_alquiler.domain.usuario.repository;

import com.crud_alquiler.domain.usuario.entidades.Rol;
import com.crud_alquiler.domain.usuario.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de Usuario
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de una cedula duplicada en la tabla
     * Usuario. Se utiliza para comprobar si ya existe un registro con este misma cedula antes de realizar una
     * inserción.
     *
     * @param cedula El valor de la cedula que se va a comprobar si está duplicado.
     * @return Booleano que indica si existe una cedula duplicada (true) o no (false).
     */
    @Query("""
        SElECT EXISTS(
            SELECT u FROM Usuario u
            WHERE u.cedula =:cedula
        ) AS duplicate_cedula
    """)
    Boolean findDuplicateCedulaToInsert(String cedula);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un login duplicado en la tabla
     * Usuario. Se utiliza para comprobar si ya existe un registro con este login antes de realizar una inserción.     *
     *
     * @param login El valor del login que se va a comprobar si está duplicado.
     * @return Booleano que indica si existe un login duplicado (true) o no (false).
     */
    @Query("""
        SELECT EXISTS(
            SELECT u FROM Usuario u
            WHERE u.login =:login      
        ) AS duplicate_login
    """)
    Boolean finDuplicateLoginToInsert(String login);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un login  y cedula duplicada en la tabla
     * Usuario. Se utiliza para comprobar si ya existe un registro con este login y cedula antes de realizar una inserción.
     * @param login El valor del login que se va a comprobar si está duplicado.
     * @param cedula El valor de la cedula que se va a comprobar si está duplicado.
     * @return Booleano que indica si existe un login y cedula duplicada (true) o no (false).
     */
    @Query("""
        SELECT EXISTS(
            SELECT u FROM Usuario u
            WHERE u.login =:login AND u.cedula =:cedula
        ) AS duplicate_login_cedula
    """)
    Boolean findDuplicateLoginCedulaToInsert(String login, String cedula);


    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de una cedula duplicada en la tabla
     * Usuario al actualizar un registro. Se utiliza para comprobar si existe otro registro con el mismo Usuario
     * (excluyendo el registro actual) antes de realizar una actualización.
     *
     * @param cedula    El valor del usuario que se va a comprobar si está duplicado.
     * @param usuarioID El ID del registro que se está actualizando. Se excluye de la comprobación.
     * @return Booleano que indica si existe una cedula duplicada (true) o no (false) excluyendo el registro actual.
     */
    @Query("""

            SELECT EXISTS(
        SELECT u FROM Usuario u
        WHERE u.cedula =:cedula
        AND u.id != :usuarioID
        )  AS duplicate_name  
    """)
    Boolean findDuplicateCedulaToUpdate(String cedula, Long usuarioID);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un login duplicado en la tabla
     * Usuario al actualizar un registro. Se utiliza para comprobar si existe otro registro con el mismo Usuario
     * (excluyendo el registro actual) antes de realizar una actualización.
     *
     * @param login     El valor del usuario que se va a comprobar si está duplicado.
     * @param usuarioID El ID del registro que se está actualizando. Se excluye de la comprobación.
     * @return Booleano que indica si existe un login duplicado (true) o no (false) excluyendo el registro actual.
     */
    @Query("""
        SELECT EXISTS(
            SELECT u FROM Usuario u
            WHERE u.login =:login
            AND u.id != :usuarioID
        ) AS duplicate_login
    """)
    Boolean findDuplicateLoginToUpdate(String login, Long usuarioID);

    /**
     * Método que utiliza una consulta personalizada para verificar la existencia de un login y cedula duplicada en la tabla
     * Usuario al actualizar un registro. Se utiliza para comprobar si existe otro registro con el mismo Usuario
     * (excluyendo el registro actual) antes de realizar una actualización.
     *
     * @param login El valor del login de usuario que se va a comprobar si está duplicado.
     * @param cedula El valor de la cedula del usuario que se va a comprobar si está duplicado.
     * @param usuarioID El ID del registro que se está actualizando. Se excluye de la comprobación.
     * @return Booleano que indica si existe un login duplicado y cedula duplicada(true) o no (false) excluyendo el
     * registro actual.
     */
    @Query("""
        SELECT EXISTS(
            SELECT u FROM Usuario u
            WHERE u.login =:login AND u.cedula =:cedula
            AND u.id != :usuarioID
        ) AS duplicate_login_cedula
    """)
    Boolean findDuplicateLoginCedulaToInsert(String login, String cedula, Long usuarioID);



}



