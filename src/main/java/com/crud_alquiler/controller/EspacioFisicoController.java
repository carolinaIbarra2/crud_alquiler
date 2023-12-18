package com.crud_alquiler.controller;

import com.crud_alquiler.domain.espacio_fisico.EspacioFisicoService;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoUpdateDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/espacio_fisico")
public class EspacioFisicoController {

    private final EspacioFisicoService espacioFisicoService;

    public EspacioFisicoController(EspacioFisicoService espacioFisicoService) {
        this.espacioFisicoService = espacioFisicoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EspacioFisicoRespuestaDTO> getEspacioFisico(@PathVariable Long id){
        return ResponseEntity.ok(espacioFisicoService.getEspacioFisico(id));
    }

    @GetMapping
    public ResponseEntity<Page<EspacioFisicoRespuestaDTO>> getAllEspacioFisico(
            @PageableDefault(size = 5, sort = "nombre") Pageable pageable){
        return ResponseEntity.ok(espacioFisicoService.findByEspacioFisico(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EspacioFisicoRespuestaDTO> insertEspacioFisico(
            @Valid @RequestBody EspacioFisicoInsertDTO espacioFisicoInsertDTO,
            UriComponentsBuilder uriComponentsBuilder){

        EspacioFisicoRespuestaDTO espacioFisicoRespuestaDTO = espacioFisicoService.insertEspacioFisico(espacioFisicoInsertDTO);
        URI url = uriComponentsBuilder.path("/espacio_fisico/{id}").buildAndExpand(espacioFisicoRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(espacioFisicoRespuestaDTO);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<EspacioFisicoRespuestaDTO> updateEspacioFisico(
            @Valid @RequestBody EspacioFisicoUpdateDTO espacioUpdateDTO
    ){

        EspacioFisicoRespuestaDTO espacioFisicoRespuestaDTO = espacioFisicoService.updateEspacioFisico(espacioUpdateDTO);
        return ResponseEntity.ok(espacioFisicoRespuestaDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteEspacioFisico(@PathVariable Long id){
        espacioFisicoService.deleteEspacioFisico(id);
        return ResponseEntity.noContent().build();
    }
}
