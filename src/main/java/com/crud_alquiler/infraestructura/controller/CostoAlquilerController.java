package com.crud_alquiler.infraestructura.controller;

import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerInsertDTO;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerRespuestaDTO;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerUpdateDTO;
import com.crud_alquiler.servicio.costo_alquiler.CostoAlquilerServiceInterface;
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
 * Controlador REST para gestionar las operaciones relacionadas con los costos de alquiler.
 */
@RestController
@RequestMapping("/costo_alquiler")
public class CostoAlquilerController {

    private final CostoAlquilerServiceInterface costoAlquilerServiceInterface;

    /**
     * Constructor para inicializar el controlador con una implementación de CostoAlquilerServiceInterface.
     * @param costoAlquilerServiceInterface Implementación de la interfaz de servicio de costos de alquiler
     */
    public CostoAlquilerController(CostoAlquilerServiceInterface costoAlquilerServiceInterface) {
        this.costoAlquilerServiceInterface = costoAlquilerServiceInterface;
    }

    /**
     * Obtiene un costo de alquiler por su identificador.
     * @param id
     * @return ResponseEntity con el DTO de respuesta correspondiente al costo de alquiler encontrado, si existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<CostoAlquilerRespuestaDTO> getCostoAlquiler(@PathVariable Long id){
        return ResponseEntity.ok(costoAlquilerServiceInterface.getCostoAlquiler(id));
    }

    /**
     *Obtiene todos los costos de alquiler de manera paginada.
     * @param pageable
     * @return ResponseEntity con una página de DTOs de respuesta de costos de alquiler.
     */
    @GetMapping
    public ResponseEntity<Page<CostoAlquilerRespuestaDTO>> getAllCostoAlquiler(
            @PageableDefault(size=5, sort = "id")Pageable pageable){
        return ResponseEntity.ok(costoAlquilerServiceInterface.getAllCostoAlquiler(pageable));
    }

    /**
     * Inserta un nuevo costo de alquiler en el sistema.
     * @param costoAlquilerInsertDTO Los datos del costo de alquiler a insertar.
     * @param uriComponentsBuilder Utilidad para construir URIs para la respuesta.
     * @return ResponseEntity con el DTO de respuesta del nuevo costo de alquiler insertado.
     */
    @PostMapping
    @Transactional
    public ResponseEntity<CostoAlquilerRespuestaDTO> insertCostoAlquiler(
            @Valid @RequestBody CostoAlquilerInsertDTO costoAlquilerInsertDTO,
            UriComponentsBuilder uriComponentsBuilder){
        CostoAlquilerRespuestaDTO costoAlquilerRespuestaDTO = costoAlquilerServiceInterface.insertCostoAlquiler(costoAlquilerInsertDTO);
        URI url = uriComponentsBuilder.path("/costo_alquiler/{id}").buildAndExpand(costoAlquilerRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(costoAlquilerRespuestaDTO);
    }

    /**
     * Actualiza un costo de alquiler existente en el sistema.
     * @param costoAlquilerUpdateDTO Los datos actualizados del costo de alquiler.
     * @return ResponseEntity con el DTO de respuesta del costo de alquiler actualizado.
     */
    @PutMapping
    @Transactional
    public ResponseEntity<CostoAlquilerRespuestaDTO> updateCostoAlquiler(
            @Valid @RequestBody CostoAlquilerUpdateDTO costoAlquilerUpdateDTO){
        CostoAlquilerRespuestaDTO costoAlquilerRespuestaDTO = costoAlquilerServiceInterface.updateCostoAlquiler(costoAlquilerUpdateDTO);
        return ResponseEntity.ok(costoAlquilerRespuestaDTO);
    }

    /**
     * Elimina un costo de alquiler por su identificador.
     * @param id
     * @return ResponseEntity con una respuesta sin contenido.
     */
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteCostoAlquiler(@PathVariable Long id){
        costoAlquilerServiceInterface.delectCostoAlquiler(id);
        return ResponseEntity.noContent().build();
    }
}
