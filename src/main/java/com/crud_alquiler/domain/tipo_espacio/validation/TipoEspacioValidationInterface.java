package com.crud_alquiler.domain.tipo_espacio.validation;

import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioInsertDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioUpdateDTO;

/**
 * Interfaz que define métodos para validar la inserción y actualización de entidades TipoEspacio.
 * Las clases que implementen esta interfaz deben proporcionar lógica de validación para la inserción y actualización de TipoEspacio.
 */
public interface TipoEspacioValidationInterface {

    /**
     * Método para validar la inserción de un TipoEspacio.
     *
     * @param tipoEspacioInsertDTO Objeto DTO que contiene información del TipoEspacio a insertar.
     */
    void validacionInsert(TipoEspacioInsertDTO tipoEspacioInsertDTO);


    /**
     * Método para validar la actualización de un TipoEspacio.
     *
     * @param tipoEspacioUpdateDTO Objeto DTO que contiene información del TipoEspacio a actualizar.
     */
    void validacionUpdate(TipoEspacioUpdateDTO tipoEspacioUpdateDTO);
}
