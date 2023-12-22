package com.crud_alquiler.infraestructura.controller;

import com.crud_alquiler.domain.reserva.entidades.dto.ReservaInsertDTO;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaRespuestaDTO;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaUpdateDTO;
import com.crud_alquiler.servicio.reserva.ReservaServiceInterface;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Controlador REST para gestionar las operaciones relacionadas con las reservas.
 */
@RestController
@RequestMapping("/reserva")
public class ReservaController {

    private final ReservaServiceInterface reservaServiceInterface;

    /**
     * Constructor para inicializar el controlador con una implementación de ReservaServiceInterface.
     * @param reservaServiceInterface Implementación de la interfaz de servicio de reserva.
     */
    public ReservaController(ReservaServiceInterface reservaServiceInterface) {
        this.reservaServiceInterface = reservaServiceInterface;
    }

    /**
     * Obtiene una reserva por su identificador.
     * @param id
     * @return ResponseEntity con el DTO de respuesta correspondiente a la reserva encontrada, si existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservaRespuestaDTO> getReserva(@PathVariable Long id){
        return ResponseEntity.ok(reservaServiceInterface.getReserva(id));
    }

    /**
     *Obtiene todos las reservas de manera paginada.
     * @param pageable
     * @return ResponseEntity con una página de DTOs de respuesta de reservas.
     */
    @GetMapping
    public ResponseEntity<Page<ReservaRespuestaDTO>> getAllReserva(
            @PageableDefault(size = 5, sort = "id")Pageable pageable){
            return ResponseEntity.ok(reservaServiceInterface.getAllReserva(pageable));
    }

    /**
     * Inserta una nueva reserva en el sistema.
     * @param reservaInsertDTO Los datos de reserva a insertar.
     * @param uriComponentsBuilder Utilidad para construir URIs para la respuesta.
     * @return ResponseEntity con el DTO de respuesta de la nueva reserva insertada.
     */
    @PostMapping
    @Transactional
    public ResponseEntity<ReservaRespuestaDTO> insertReserva(
            @Valid @RequestBody ReservaInsertDTO reservaInsertDTO,
            UriComponentsBuilder uriComponentsBuilder
            ){
        ReservaRespuestaDTO reservaRespuestaDTO = reservaServiceInterface.insertReserva(reservaInsertDTO);
        URI url = uriComponentsBuilder.path("/reserva/{id}").buildAndExpand(reservaRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(reservaRespuestaDTO);
    }

    /**
     * Actualiza una reserva existente en el sistema.
     * @param reservaUpdateDTO Los datos actualizados de una reserva.
     * @return ResponseEntity con el DTO de respuesta de la reserva actualizada.
     */
    @PutMapping
    @Transactional
    public ResponseEntity<ReservaRespuestaDTO> updateReserva(
            @Valid @RequestBody ReservaUpdateDTO reservaUpdateDTO){
        ReservaRespuestaDTO reservaRespuestaDTO = reservaServiceInterface.updateReserva(reservaUpdateDTO);
        return ResponseEntity.ok(reservaRespuestaDTO);
    }

    /**
     * Elimina una reserva por su identificador.
     * @param id
     * @return ResponseEntity con una respuesta sin contenido.
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteReserva(@PathVariable Long id){
        reservaServiceInterface.deleteReserva(id);
        return ResponseEntity.noContent().build();
    }

}
