package com.crud_alquiler.infraestructura.errors;

/**
 * Clase de excepción personalizada que extiende RuntimeException.
 * Se utiliza para representar errores de validación de negocio en la aplicación.
 */
public class BusinessValidation extends RuntimeException {

    /**
     * Constructor que acepta un mensaje de error y lo pasa al constructor de la clase base (RuntimeException).
     *
     * @param s Mensaje de error que describe la razón de la excepción de validación de negocio.
     */
    public BusinessValidation(String s) {
        // Llama al constructor de la clase base (RuntimeException) con el mensaje proporcionado.
        super(s);
    }
}
