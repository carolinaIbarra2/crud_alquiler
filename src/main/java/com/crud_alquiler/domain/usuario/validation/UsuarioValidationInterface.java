package com.crud_alquiler.domain.usuario.validation;

import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioUpdateDTO;

/**
 * Interfaz que define métodos para validar la inserción y actualización de entidades Usuario.
 * Las clases que implementen esta interfaz deben proporcionar lógica de validación para la inserción y actualización de Usuario.
 */
public interface UsuarioValidationInterface {

    /**
     * Método para validar la inserción de un Usuario.
     * @param usuarioInsertDTO Objeto DTO que contiene información del Usuario a insertar.
     */
    void validationInsert(UsuarioInsertDTO usuarioInsertDTO);

    /**
     * Método para validar la actualización de un Usuario.
     * @param usuarioUpdateDTO Objeto DTO que contiene información del Usuario a actualizar.
     */
    void validationUpdate(UsuarioUpdateDTO usuarioUpdateDTO);
}
