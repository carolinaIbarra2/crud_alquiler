package com.crud_alquiler.infraestructura.controller;


import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoUpdateDTO;
import com.crud_alquiler.servicio.espacio_fisico.EspacioFisicoServiceInterface;
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
 * Controlador REST para gestionar las operaciones relacionadas con los espacios fisicos.
 */
@RestController
@RequestMapping("/espacio_fisico")
public class EspacioFisicoController {

    private final EspacioFisicoServiceInterface espacioFisicoServiceInterface;

    /**
     * Constructor para inicializar el controlador con una implementación de EspacioFisicoServiceInterface.
     * @param espacioFisicoServiceInterface Implementación de la interfaz de servicio de espacios fisicos.
     */
    public EspacioFisicoController(EspacioFisicoServiceInterface espacioFisicoServiceInterface) {
        this.espacioFisicoServiceInterface = espacioFisicoServiceInterface;
    }

    /**
     * Obtiene un espacio fisico por su identificador.
     * @param id
     * @return ResponseEntity con el DTO de respuesta correspondiente al espacio fisico encontrado, si existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<EspacioFisicoRespuestaDTO> getEspacioFisico(@PathVariable Long id){
        return ResponseEntity.ok(espacioFisicoServiceInterface.getEspacioFisico(id));
    }

    /**
     *Obtiene todos los espacios fisicos de manera paginada.
     * @param pageable
     * @return ResponseEntity con una página de DTOs de respuesta de espacios fisicos.
     */
    @GetMapping
    public ResponseEntity<Page<EspacioFisicoRespuestaDTO>> getAllEspacioFisico(
            @PageableDefault(size = 10, sort = "nombre") Pageable pageable){
        return ResponseEntity.ok(espacioFisicoServiceInterface.getAllEspacioFisico(pageable));
    }

    /**
     * Inserta un nuevo espacio fisico en el sistema.
     * @param espacioFisicoInsertDTO Los datos de espacio fisico a insertar.
     * @param uriComponentsBuilder Utilidad para construir URIs para la respuesta.
     * @return ResponseEntity con el DTO de respuesta del nuevo espacio fisico insertado.
     */
    @PostMapping
    @Transactional
    public ResponseEntity<EspacioFisicoRespuestaDTO> insertEspacioFisico(
            @Valid @RequestBody EspacioFisicoInsertDTO espacioFisicoInsertDTO,
            UriComponentsBuilder uriComponentsBuilder){

        EspacioFisicoRespuestaDTO espacioFisicoRespuestaDTO = espacioFisicoServiceInterface.insertEspacioFisico(espacioFisicoInsertDTO);
        URI url = uriComponentsBuilder.path("/espacio_fisico/{id}").buildAndExpand(espacioFisicoRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(espacioFisicoRespuestaDTO);
    }

    /**
     * Actualiza un espacio fisico existente en el sistema.
     * @param espacioUpdateDTO Los datos actualizados de espacio fisico.
     * @return ResponseEntity con el DTO de respuesta del espacio fisico actualizado.
     */
    @PutMapping
    @Transactional
    public ResponseEntity<EspacioFisicoRespuestaDTO> updateEspacioFisico(
            @Valid @RequestBody EspacioFisicoUpdateDTO espacioUpdateDTO
    ){

        EspacioFisicoRespuestaDTO espacioFisicoRespuestaDTO = espacioFisicoServiceInterface.updateEspacioFisico(espacioUpdateDTO);
        return ResponseEntity.ok(espacioFisicoRespuestaDTO);
    }

    /**
     * Elimina un espacio fisico por su identificador.
     * @param id
     * @return ResponseEntity con una respuesta sin contenido.
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteEspacioFisico(@PathVariable Long id){
        espacioFisicoServiceInterface.deleteEspacioFisico(id);
        return ResponseEntity.noContent().build();
    }
}
