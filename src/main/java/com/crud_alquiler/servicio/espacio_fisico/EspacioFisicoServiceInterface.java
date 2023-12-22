package com.crud_alquiler.servicio.espacio_fisico;

import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *Interfaz que define operaciones para manipular espacios fisicos
 */
public interface EspacioFisicoServiceInterface {

    /**
     * Obtiene un espacio fisico por su identificador
     * @param id El identificador único del espacio físico a obtener.
     * @return Un objeto EspacioFisicoRespuestaDTO que representa la información del espacio físico.
     */
    EspacioFisicoRespuestaDTO getEspacioFisico(Long id);

    /**
     * Obtiene una página de espacios físicos de acuerdo a la paginación especificada.
     * @param pageable La información de paginación para la consulta.
     * @return Una página paginada de objetos EspacioFisicoRespuestaDTO que representa la información de los
     * espacios físicos.
     */
    Page<EspacioFisicoRespuestaDTO> getAllEspacioFisico(Pageable pageable);

    /**
     * Inserta un nuevo espacio físico en el sistema.
     * @param espacioFisicoInsertDTO El DTO que contiene la información para la creación del espacio físico.
     * @return Un objeto EspacioFisicoRespuestaDTO que representa la información del nuevo espacio físico insertado.     *
     */
    EspacioFisicoRespuestaDTO insertEspacioFisico(EspacioFisicoInsertDTO espacioFisicoInsertDTO);

    /**
     *Actualiza la información de un espacio físico existente.
     * @param espacioFisicoUpdateDTO El DTO con la información actualizada para el espacio físico.
     * @return Un objeto EspacioFisicoRespuestaDTO que representa la información actualizada del espacio físico.
     */
    EspacioFisicoRespuestaDTO updateEspacioFisico(EspacioFisicoUpdateDTO espacioFisicoUpdateDTO);

    /**
     *Elimina un espacio físico del sistema dado su ID.
     * @param id El identificador único del espacio físico a eliminar.
     */
    void deleteEspacioFisico(Long id);
}
