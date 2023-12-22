package com.crud_alquiler.infraestructura.errors;

/**
 * Clase de excepción personalizada que extiende RuntimeException.
 * Se utiliza para representar errores de validación de integridad en la aplicación.
 */
public class IntegrityValidation extends RuntimeException {

    /**
     * Constructor que acepta un mensaje de error y lo pasa al constructor de la clase base (RuntimeException).
     * @param s Mensaje de error que describe la razón de la excepción de validación de integridad.
     */
    public IntegrityValidation(String s) {
        // Llama al constructor de la clase base (RuntimeException) con el mensaje proporcionado.
        super(s);
    }
}
