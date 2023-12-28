package com.crud_alquiler.domain.espacio_fisico.validation;


import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoUpdateDTO;

/**
 * Interfaz que define métodos para validar la inserción y actualización de entidades EspacioFisico.
 * Las clases que implementen esta interfaz deben proporcionar lógica de validación para la inserción y actualización de
 * EspacioFisico.
 */
public interface EspacioFisicoValidationInterface{

    /**
     * Método para validar la inserción de un EspacioFisico.
     * @param espacioFisicoInsertDTO Objeto DTO que contiene información del EspacioFisico a insertar.
     */
    void validationInsert(EspacioFisicoInsertDTO espacioFisicoInsertDTO);

    /**
     * Método para validar la actualización de un EspacioFisico.
     * @param espacioFisicoUpdateDTO Objeto DTO que contiene información del EspacioFisico a actualizar.
     */
    void validationUpdate(EspacioFisicoUpdateDTO espacioFisicoUpdateDTO);
}
