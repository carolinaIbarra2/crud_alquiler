package com.crud_alquiler.servicio.tipo_espacio;

import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioInsertDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioRespuestaDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interfaz que define operaciones para manipular tipo de espacio
 */
public interface TipoEspacioServiceInterface {
    /**
     * Obtiene un tipo de espacio por su identificador
     * @param id El identificador único del tipo de espacio a obtener.
     * @return Un objeto TipoEspacioRespuestaDTO que representa la información del tipo de espacio.
     */
    TipoEspacioRespuestaDTO getTipoEspacio(Long id);

    /**
     * Obtiene una página del tipo de espacio de acuerdo a la paginación especificada.
     * @param pageable La información de paginación para la consulta.
     * @return Una página paginada de objetos TipoEspacioRespuestaDTO que representa la información del tipo
     * de espacio
     */
    Page<TipoEspacioRespuestaDTO> getAllTipoEspacio(Pageable pageable);

    /**
     * Inserta un nuevo tipo de espacio en el sistema.
     * @param tipoEspacioInsertDTO El DTO que contiene la información para la creación de un tipo de espacio.
     * @return Un objeto TipoEspacioRespuestaDTO que representa la información del nuevo tipo de espacio.
     */
    TipoEspacioRespuestaDTO insertTipoEspacio(TipoEspacioInsertDTO tipoEspacioInsertDTO);

    /**
     *Actualiza la información de un tipo de espacio existente.
     * @param tipoEspacioUpdateDTO El DTO con la información actualizada para el tipo de espacio.
     * @return Un objeto TipoEspacioRespuestaDTO que representa la información actualizada del tipo de espacio.
     */
    TipoEspacioRespuestaDTO updateTipoEspacio(TipoEspacioUpdateDTO tipoEspacioUpdateDTO);

    /**
     *Elimina un tipo de espacio del sistema dado su ID.
     * @param id El identificador único del tipo de espacio a eliminar.
     */
    void deleteTipoEspacio(Long id);
}
