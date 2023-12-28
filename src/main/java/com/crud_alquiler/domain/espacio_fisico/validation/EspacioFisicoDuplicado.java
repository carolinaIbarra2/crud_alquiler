package com.crud_alquiler.domain.espacio_fisico.validation;

import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoUpdateDTO;
import com.crud_alquiler.domain.espacio_fisico.repository.EspacioFisicoRepository;
import com.crud_alquiler.infraestructura.errors.BusinessValidation;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa la interfaz EspacioFisicoValidation para validar la inserción y actualización de EspacioFisico
 * y verificar la existencia de nombre, descripcion duplicados antes de realizar operaciones de inserción o actualización.
 */
@Component
public class EspacioFisicoDuplicado implements EspacioFisicoValidationInterface{

    private final EspacioFisicoRepository espacioFisicoRepository;

    /**
     * Constructor de la clase EspacioFisicoDuplicado.
     * @param espacioFisicoRepository Repositorio que proporciona métodos para acceder a la base de datos de EspacioFisico.
     */
    public EspacioFisicoDuplicado(EspacioFisicoRepository espacioFisicoRepository) {
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    @Override
    public void validationInsert(EspacioFisicoInsertDTO espacioFisicoInsertDTO) {
        // Verifica si existe un nombre y descripcion duplicado antes de la inserción.
        Boolean nombreDescripcionDuplicado = espacioFisicoRepository.findDuplicateNombreDescripcionToInsert(espacioFisicoInsertDTO.nombre(),
                espacioFisicoInsertDTO.descripcion());
        if (nombreDescripcionDuplicado){
            throw new BusinessValidation("Ya existe un espacio fisico con este nombre y descripcion");
        }
        // Verifica si existe un nombre duplicado antes de la inserción.
        Boolean nombreDuplicado = espacioFisicoRepository.findDuplicateNombreToInsert(espacioFisicoInsertDTO.nombre());
        if (nombreDuplicado){
            throw new BusinessValidation("Ya existe un espacio fisico con este nombre");
        }
        // Verifica si existe una descripcion duplicada antes de la inserción.
        Boolean descripcionDuplicada = espacioFisicoRepository.findDuplicateDescripcionToInsert(espacioFisicoInsertDTO.descripcion());
        if (descripcionDuplicada){
            throw new BusinessValidation("Ya existe un espacio fisico con esta descripcion");
        }
    }

    @Override
    public void validationUpdate(EspacioFisicoUpdateDTO espacioFisicoUpdateDTO) {

        // Verifica si existe un nombre y descripcion duplicado antes de la inserción.
        Boolean nombreDescripcionDuplicado = espacioFisicoRepository.findDuplicateNombreDescripcionToUpdate(espacioFisicoUpdateDTO.nombre(),
                espacioFisicoUpdateDTO.descripcion(), espacioFisicoUpdateDTO.id());
        if (nombreDescripcionDuplicado){
            throw new BusinessValidation("Ya existe un espacio fisico con este nombre y descripcion");
        }
        // Verifica si existe un nombre duplicado antes de la inserción.
        Boolean nombreDuplicado = espacioFisicoRepository.findDuplicateNombreToUpdate(espacioFisicoUpdateDTO.nombre(),
                espacioFisicoUpdateDTO.id());
        if (nombreDuplicado){
            throw new BusinessValidation("Ya existe un nombre con el mismo nombre registrado");
        }
        // Verifica si existe una descripcion duplicada antes de la inserción.
        Boolean descripcionDuplicada = espacioFisicoRepository.findDuplicateDescripcionToUpdate(espacioFisicoUpdateDTO.descripcion(),
                espacioFisicoUpdateDTO.id());
        if (descripcionDuplicada){
            throw new BusinessValidation("Ya existe una descripcion con el mismo nombre registrado");
        }
    }
}
