package com.crud_alquiler.servicio.usuario;

import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioRespuestaDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interfaz que define operaciones para manipular usuario
 */
public interface UsuarioServiceInterface {

    /**
     * Obtiene un usuario por su identificador
     * @param id El identificador único del usuario a obtener.
     * @return Un objeto UsuarioRespuestaDTO que representa la información del usuario.
     */
    UsuarioRespuestaDTO getUsuario(Long id);

    /**
     * Obtiene una página de usuario de acuerdo a la paginación especificada.
     * @param pageable La información de paginación para la consulta.
     * @return Una página paginada de objetos UsuarioRespuestaDTO que representa la información del usuario
     */
    Page<UsuarioRespuestaDTO> findByUsuario(Pageable pageable);

    /**
     * Inserta un nuevo usuario en el sistema.
     * @param usuarioInsertDTO El DTO que contiene la información para la creación de un usuario.
     * @return Un objeto UsuarioRespuestaDTO que representa la información del nuevo usuario.
     */
    UsuarioRespuestaDTO insertUsuario(UsuarioInsertDTO usuarioInsertDTO);

    /**
     *Actualiza la información de un usuario existente.
     * @param usuarioUpdateDTO El DTO con la información actualizada para el usuario.
     * @return Un objeto UsuarioRespuestaDTO que representa la información actualizada del usuario.
     */
    UsuarioRespuestaDTO updateUsuario(UsuarioUpdateDTO usuarioUpdateDTO);

    /**
     *Elimina un usuario del sistema dado su ID.
     * @param id El identificador único del usuario a eliminar.
     */
    void delectUsuario(Long id);
}
