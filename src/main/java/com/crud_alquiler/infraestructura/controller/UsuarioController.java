package com.crud_alquiler.infraestructura.controller;

import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioRespuestaDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioUpdateDTO;
import com.crud_alquiler.servicio.usuario.UsuarioServiceInterface;
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
 * Controlador REST para gestionar las operaciones relacionadas con usuarios.
 */
@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioServiceInterface usuarioServiceInterface;

    /**
     * Constructor para inicializar el controlador con una implementación de UsuarioServiceRepository.
     * @param usuarioServiceInterface Implementación de la interfaz de servicio de usuario.
     */
    public UsuarioController(UsuarioServiceInterface usuarioServiceInterface) {
        this.usuarioServiceInterface = usuarioServiceInterface;
    }

    /**
     * Obtiene un usuario por su identificador.
     * @param id
     * @return ResponseEntity con el DTO de respuesta correspondiente al usuario encontrado, si existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRespuestaDTO> getUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioServiceInterface.getUsuario(id));
    }

    /**
     *Obtiene todos los usuario de manera paginada.
     * @param pageable
     * @return ResponseEntity con una página de DTOs de respuesta de usuario.
     */
    @GetMapping
    public ResponseEntity<Page<UsuarioRespuestaDTO>> getAllUsuario(
            @PageableDefault(size=5, sort = "id")Pageable pageable){
        return ResponseEntity.ok(usuarioServiceInterface.findByUsuario(pageable));
    }

    /**
     * Inserta un nuevo usuario en el sistema.
     * @param usuarioInsertDTO Los datos de usuario a insertar.
     * @param uriComponentsBuilder Utilidad para construir URIs para la respuesta.
     * @return ResponseEntity con el DTO de respuesta del nuevo usuario insertado.
     */
    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioRespuestaDTO> insertUsuario(
        @Valid @RequestBody UsuarioInsertDTO usuarioInsertDTO, UriComponentsBuilder uriComponentsBuilder){
        UsuarioRespuestaDTO usuarioRespuestaDTO = usuarioServiceInterface.insertUsuario(usuarioInsertDTO);
        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuarioRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(usuarioRespuestaDTO);
    }

    /**
     * Actualiza un usuario existente en el sistema.
     * @param usuarioUpdateDTO Los datos actualizados de un usuario.
     * @return ResponseEntity con el DTO de respuesta del usuario actualizado.
     */
    @PutMapping
    @Transactional
    public ResponseEntity<UsuarioRespuestaDTO> updateUsuario(
            @Valid @RequestBody UsuarioUpdateDTO usuarioUpdateDTO
            ){
        UsuarioRespuestaDTO usuarioRespuestaDTO = usuarioServiceInterface.updateUsuario(usuarioUpdateDTO);
        return ResponseEntity.ok(usuarioRespuestaDTO);
    }

    /**
     * Elimina un usuario por su identificador.
     * @param id
     * @return ResponseEntity con una respuesta sin contenido.
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delectUsuario(@PathVariable Long id){
        usuarioServiceInterface.delectUsuario(id);
        return ResponseEntity.noContent().build();
    }


}
