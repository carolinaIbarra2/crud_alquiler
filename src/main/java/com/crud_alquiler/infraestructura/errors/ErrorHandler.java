package com.crud_alquiler.infraestructura.errors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase que actúa como un controlador global para manejar errores en toda la aplicación.
 * Anotada con @RestControllerAdvice para centralizar el manejo de excepciones en los controladores.
 */
@RestControllerAdvice
public class ErrorHandler {

    /**
     * Manejador de excepciones para cuando no se encuentra la entidad solicitada.
     * Captura la excepción EntityNotFoundException y devuelve una respuesta HTTP 404 Not Found.
     * @return ResponseEntity con una respuesta HTTP 404 Not Found.
     */
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity tryError404() {
        // Devuelve una respuesta HTTP 404 Not Found.
        return ResponseEntity.notFound().build();
    }

    /**
     * Manejador de excepciones para errores de validación de argumentos de método.
     * Captura la excepción MethodArgumentNotValidException y devuelve una respuesta HTTP 400 Bad Request
     * con detalles sobre los errores de validación.
     * @param e La excepción MethodArgumentNotValidException capturada.
     * @return ResponseEntity con una respuesta HTTP 400 Bad Request que contiene detalles de los errores de validación.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity tryError400(MethodArgumentNotValidException e) {
        // Obtiene los errores de validación de la excepción capturada y los convierte en objetos ValidationErrorData.
        var errors = e.getFieldErrors()
                .stream()
                .map(ValidationErrorData::new)
                .toList();

        // Devuelve una respuesta HTTP 400 Bad Request con los errores de validación.
        return ResponseEntity.badRequest().body(errors);
    }

    /**
     * Manejador de excepciones para capturar y manejar ValidationException, que representa errores de validación de negocio.
     * Devuelve una respuesta HTTP 400 Bad Request con el mensaje de error de la excepción.
     *
     * @param e Excepción ValidationException capturada.
     * @return ResponseEntity con una respuesta HTTP 400 Bad Request y el mensaje de error de la excepción.
     */
    @ExceptionHandler(BusinessValidation.class)
    public ResponseEntity errorHandlerValidacionesDeNegocio(Exception e) {
        // Captura la excepción ValidationException y devuelve una respuesta HTTP 400 Bad Request con el mensaje de error.
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    /**
     * Manejador de excepciones para capturar y manejar ValidacionIntegridad, que representa errores de validación de integridad.
     * Devuelve una respuesta HTTP 400 Bad Request con el mensaje de error de la excepción.
     *
     * @param e Excepción ValidacionIntegridad capturada.
     * @return ResponseEntity con una respuesta HTTP 400 Bad Request y el mensaje de error de la excepción.
     */
    @ExceptionHandler(IntegrityValidation.class)
    public ResponseEntity errorHandlerValidacionesIntegridad(Exception e) {
        // Captura la excepción ValidacionIntegridad y devuelve una respuesta HTTP 400 Bad Request con el mensaje de error.
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
