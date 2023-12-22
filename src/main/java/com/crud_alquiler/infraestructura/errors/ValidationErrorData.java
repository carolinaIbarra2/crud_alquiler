package com.crud_alquiler.infraestructura.errors;

import org.springframework.validation.FieldError;

/**
 * Encapsula la informacion de errores de las validaciones
 * @param campo representando el campo asociado al error
 * @param error representando el mensaje de error
 */
record ValidationErrorData(String campo, String error) {

    /**
     * Constructor de la clase que toma un objeto FieldError y extrae la información relevante para inicializar el registro.
     * @param error El objeto FieldError que contiene información sobre el error de validación.
     */
    public ValidationErrorData(FieldError error) {
        // Inicializa el registro con el campo y el mensaje de error del objeto FieldError proporcionado.
        this(error.getField(), error.getDefaultMessage());
    }
}
