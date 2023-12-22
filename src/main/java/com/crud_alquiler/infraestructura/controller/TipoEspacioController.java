package com.crud_alquiler.infraestructura.controller;

import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioInsertDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioRespuestaDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioUpdateDTO;
import com.crud_alquiler.servicio.tipo_espacio.TipoEspacioServiceInterface;
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
 * Controlador REST para gestionar las operaciones relacionadas con tipo de espacio.
 */
@RestController
@RequestMapping("/tipo_espacio")
public class TipoEspacioController {

    private final TipoEspacioServiceInterface tipoEspacioServiceInterface;

    /**
     * Constructor para inicializar el controlador con una implementación de TipoEspacioServiceRepository.
     * @param tipoEspacioServiceInterface Implementación de la interfaz de servicio de tipoEspacio.
     */
    public TipoEspacioController(TipoEspacioServiceInterface tipoEspacioServiceInterface) {
        this.tipoEspacioServiceInterface = tipoEspacioServiceInterface;
    }

    /**
     * Obtiene un tipo de espacio por su identificador.
     * @param id
     * @return ResponseEntity con el DTO de respuesta correspondiente al tipo de espacio encontrado, si existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<TipoEspacioRespuestaDTO> getTipoEspacio(@PathVariable Long id){
        return ResponseEntity.ok(tipoEspacioServiceInterface.getTipoEspacio(id));
    }

    /**
     *Obtiene todos los tipos de espacio de manera paginada.
     * @param pageable
     * @return ResponseEntity con una página de DTOs de respuesta de tipo de espacio.
     */
    @GetMapping
    public ResponseEntity<Page<TipoEspacioRespuestaDTO>> getAllTipoEspacio(
            @PageableDefault(size = 5, sort = "tipoEspacio") Pageable pageable){
        return ResponseEntity.ok(tipoEspacioServiceInterface.getAllTipoEspacio(pageable));
    }

    /**
     * Inserta un nuevo tipo de espacio en el sistema.
     * @param tipoEspacioInsertDTO Los datos de tipo de espacio a insertar.
     * @param uriComponentsBuilder Utilidad para construir URIs para la respuesta.
     * @return ResponseEntity con el DTO de respuesta del nuevo tipo de espacio insertado.
     */
    @PostMapping
    @Transactional
    public ResponseEntity<TipoEspacioRespuestaDTO> insertTipoEspacio(
            @Valid @RequestBody TipoEspacioInsertDTO tipoEspacioInsertDTO,
            UriComponentsBuilder uriComponentsBuilder){

        TipoEspacioRespuestaDTO tipoEspacioRespuestaDTO = tipoEspacioServiceInterface.insertTipoEspacio(tipoEspacioInsertDTO);
        URI url = uriComponentsBuilder.path("/tipo_espacio/{id}").buildAndExpand(tipoEspacioRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(tipoEspacioRespuestaDTO);
    }

    /**
     * Actualiza un tipo de espacio existente en el sistema.
     * @param tipoEspacioUpdateDTO Los datos actualizados de un tipo de espacio.
     * @return ResponseEntity con el DTO de respuesta del tipo de espacio actualizado.
     */
    @PutMapping
    @Transactional
    public ResponseEntity<TipoEspacioRespuestaDTO> updateTipoEspacio(
            @Valid @RequestBody TipoEspacioUpdateDTO tipoEspacioUpdateDTO
            ){

        TipoEspacioRespuestaDTO respuestaDTO = tipoEspacioServiceInterface.updateTipoEspacio(tipoEspacioUpdateDTO);
        return ResponseEntity.ok(respuestaDTO);
    }

    /**
     * Elimina un tipo de espacio por su identificador.
     * @param id
     * @return ResponseEntity con una respuesta sin contenido.
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteTipoEspacio(@PathVariable Long id){
        tipoEspacioServiceInterface.deleteTipoEspacio(id);
        return ResponseEntity.noContent().build();
    }

}
