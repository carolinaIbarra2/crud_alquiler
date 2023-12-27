package com.crud_alquiler.domain.usuario.validation;

import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioUpdateDTO;
import com.crud_alquiler.domain.usuario.repository.UsuarioRepository;
import com.crud_alquiler.infraestructura.errors.BusinessValidation;
import jakarta.validation.ValidationException;
import org.springframework.stereotype.Component;

/**
 * Clase que implementa la interfaz UsuarioValidation para validar la inserción y actualización de Usuario
 * y verificar la existencia de login y cedula duplicados antes de realizar operaciones de inserción o actualización.
 */
@Component
public class UsuarioDuplicado implements UsuarioValidationInterface{

    private final UsuarioRepository usuarioRepository;

    /**
     *  Constructor de la clase UsuarioDuplicado.
     * @param usuarioRepository Repositorio que proporciona métodos para acceder a la base de datos de Usuario.
     */
    public UsuarioDuplicado(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Método para validar la inserción de un Usuario.
     * @param usuarioInsertDTO Objeto DTO que contiene información del Usuario a insertar.
     * @throws ValidationException Si ya existe un Usuario con la misma cedula y/o login registrado.
     */
    @Override
    public void validationInsert(UsuarioInsertDTO usuarioInsertDTO) {
        // Verifica si existe una cedula y login duplicado antes de la inserción.
        Boolean cedulayloginDuplicado = usuarioRepository.findDuplicateLoginCedulaToInsert(usuarioInsertDTO.login(),
                usuarioInsertDTO.cedula());
        if (cedulayloginDuplicado){
            throw new BusinessValidation("Ya existe un usuario con este login y contraseña registrado");
        }

        // Verifica si existe una cedula duplicada antes de la inserción.
        Boolean cedulaDuplicada = usuarioRepository.findDuplicateCedulaToInsert(usuarioInsertDTO.cedula());
        if (cedulaDuplicada){
            throw new BusinessValidation("Ya existe un usuario con esta cedula registrada");
        }

        // Verifica si existe un login duplicado antes de la inserción.
        Boolean loginDuplicado = usuarioRepository.finDuplicateLoginToInsert(usuarioInsertDTO.login());
        if (loginDuplicado){
            throw new BusinessValidation("Ya existe un usuario con este login registrado");
        }

    }

    /**
     *  Método para validar la actualización de un Usuario.
     * @param usuarioUpdateDTO Objeto DTO que contiene información del Usuario a actualizar.
     * @throws ValidationException Si ya existe un Usuario con la misma cedula y/o login registrado (excluyendo el
     * registro actual).
     */
    @Override
    public void validationUpdate(UsuarioUpdateDTO usuarioUpdateDTO) {
        //Verifica si existe un Usuario duplicado antes de la actualizacion
        Boolean cedulayloginDuplicado = usuarioRepository.findDuplicateLoginCedulaToInsert(usuarioUpdateDTO.login(),
                usuarioUpdateDTO.cedula(), usuarioUpdateDTO.id());
        if (cedulayloginDuplicado){
            throw new BusinessValidation("Ya existe un usuario con el mismo login y cedula registrado");
        }

        // Verifica si existe un Usuario duplicado antes de la actualización.
        Boolean cedulaDuplicada = usuarioRepository.findDuplicateCedulaToUpdate(usuarioUpdateDTO.cedula(), usuarioUpdateDTO.id());
        if (cedulaDuplicada){
            throw new BusinessValidation("Ya existe un usuario con la misma cedula registrado");
        }

        // Verifica si existe un Usuario duplicado antes de la actualización.
        Boolean loginDuplicado = usuarioRepository.findDuplicateLoginToUpdate(usuarioUpdateDTO.login(), usuarioUpdateDTO.id());
        if (loginDuplicado){
            throw new BusinessValidation("Ya existe un usuario con el mismo login registrado");
        }

    }
}
