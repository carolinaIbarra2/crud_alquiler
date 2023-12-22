package com.crud_alquiler.domain.tipo_espacio.validation;

import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioInsertDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioUpdateDTO;
import com.crud_alquiler.domain.tipo_espacio.repository.TipoEspacioRepository;
import com.crud_alquiler.infraestructura.errors.BusinessValidation;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa la interfaz TipoEspacioValidation para validar la inserción y actualización de TipoEspacio
 * y verificar la existencia de nombres duplicados antes de realizar operaciones de inserción o actualización.
 */
@Component
public class TipoEspacioDuplicado implements TipoEspacioValidationInterface {

    private final TipoEspacioRepository tipoEspacioRepository;

    /**
     * Constructor de la clase TipoEspacioDuplicado.
     *
     * @param tipoEspacioRepository Repositorio que proporciona métodos para acceder a la base de datos de TipoEspacio.
     */
    public TipoEspacioDuplicado(TipoEspacioRepository tipoEspacioRepository) {
        this.tipoEspacioRepository = tipoEspacioRepository;
    }

    /**
     * Método para validar la inserción de un TipoEspacio.
     *
     * @param tipoEspacioInsertDTO Objeto DTO que contiene información del TipoEspacio a insertar.
     * @throws ValidationException Si ya existe un TipoEspacio con el mismo nombre registrado.
     */
    @Override
    public void validacionInsert(TipoEspacioInsertDTO tipoEspacioInsertDTO) {
        // Verifica si existe un TipoEspacio duplicado antes de la inserción.
        Boolean tipoEspacioDuplicado = tipoEspacioRepository.findDuplicateNameToInsert(tipoEspacioInsertDTO.tipoEspacio());
        if (tipoEspacioDuplicado){
            throw new BusinessValidation("Ya existe un tipo de espacio con el nombre registrado");
        }
    }

    /**
     * Método para validar la actualización de un TipoEspacio.
     *
     * @param tipoEspacioUpdateDTO Objeto DTO que contiene información del TipoEspacio a actualizar.
     * @throws ValidationException Si ya existe un TipoEspacio con el mismo nombre registrado (excluyendo el registro actual).
     */
    @Override
    public void validacionUpdate(TipoEspacioUpdateDTO tipoEspacioUpdateDTO) {
        // Verifica si existe un TipoEspacio duplicado antes de la actualización.
        Boolean tipoEspacioDuplicado = tipoEspacioRepository.findDuplicateNameToUpdate(tipoEspacioUpdateDTO.tipoEspacio(), tipoEspacioUpdateDTO.id());
        if (tipoEspacioDuplicado){
            throw new BusinessValidation("Ya existe un tipo de espacio con el nombre registrado");
        }
    }
}
