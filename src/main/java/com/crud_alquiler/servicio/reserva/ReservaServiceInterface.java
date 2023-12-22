package com.crud_alquiler.servicio.reserva;

import com.crud_alquiler.domain.reserva.entidades.dto.ReservaInsertDTO;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaRespuestaDTO;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interfaz que define operaciones para manipular reservas
 */
public interface ReservaServiceInterface {

    /**
     * Obtiene una reserva por su identificador
     * @param id El identificador único de la reserva a obtener.
     * @return Un objeto ReservaRespuestaDTO que representa la información de la reserva.
     */
    ReservaRespuestaDTO getReserva(Long id);

    /**
     * Obtiene una página de reservas de acuerdo a la paginación especificada.
     * @param pageable La información de paginación para la consulta.
     * @return Una página paginada de objetos ReservaRespuestaDTO que representa la información de las
     * reservas.
     */
    Page<ReservaRespuestaDTO> getAllReserva(Pageable pageable);

    /**
     * Inserta una nueva reserva en el sistema.
     * @param reservaInsertDTO El DTO que contiene la información para la creación de una reserva.
     * @return Un objeto ReservaRespuestaDTO que representa la información de la nueva reserva.
     */
    ReservaRespuestaDTO insertReserva(ReservaInsertDTO reservaInsertDTO);

    /**
     *Actualiza la información de una reserva existente.
     * @param reservaUpdateDTO El DTO con la información actualizada para la reserva.
     * @return Un objeto ReservaRespuestaDTO que representa la información actualizada de la reserva.
     */
    ReservaRespuestaDTO updateReserva(ReservaUpdateDTO reservaUpdateDTO);

    /**
     *Elimina una reserva del sistema dado su ID.
     * @param id El identificador único de la reserva a eliminar.
     */
    void deleteReserva(Long id);
}
