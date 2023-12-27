package com.crud_alquiler.servicio.costo_alquiler;

import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerInsertDTO;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerRespuestaDTO;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerUpdateDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *Interfaz que define operaciones para manipular costos de alquiler
 */

public interface CostoAlquilerServiceInterface {

    /**
     * Obtiene un costo de alquiler por su identificador
     * @param id El identificador único del costo de alquiler a obtener.
     * @return Un objeto CostoAlquilerRespuestaDTO que representa la información del costo de alquiler.
     */
    CostoAlquilerRespuestaDTO getCostoAlquiler(Long id);

    /**
     * Obtiene una página de costos de alquiler de acuerdo a la paginación especificada.     *
     * @param pageable La información de paginación para la consulta.
     * @return Una página paginada de objetos CostoAlquilerRespuestaDTO que representa la información de los
     * costos de alquiler.
     */
    Page<CostoAlquilerRespuestaDTO> getAllCostoAlquiler(Pageable pageable);

    /**
     * Inserta un nuevo costo de alquiler en el sistema.
     * @param costoAlquilerInsertDTO El DTO que contiene la información para la creación del costo de alquiler.
     * @return Un objeto CostoAlquilerRespuestaDTO que representa la información del nuevo costo de alquiler insertado.     *
     */
    CostoAlquilerRespuestaDTO insertCostoAlquiler(CostoAlquilerInsertDTO costoAlquilerInsertDTO);

    /**
     *Actualiza la información de un costo de alquiler existente.
     * @param costoAlquilerUpdateDTO El DTO con la información actualizada para el costo de alquiler.
     * @return Un objeto CostoAlquilerRespuestaDTO que representa la información actualizada del costo de alquiler.
     */
    CostoAlquilerRespuestaDTO updateCostoAlquiler(CostoAlquilerUpdateDTO costoAlquilerUpdateDTO);

    /**
     *Elimina un costo de alquiler del sistema dado su ID.
     * @param id El identificador único del costo de alquiler a eliminar.
     */
    void delectCostoAlquiler(Long id);
}
