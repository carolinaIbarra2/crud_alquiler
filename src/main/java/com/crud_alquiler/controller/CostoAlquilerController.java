package com.crud_alquiler.controller;

import com.crud_alquiler.domain.costo_alquiler.CostoAlquilerService;
import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerInsertDTO;
import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerRespuestaDTO;
import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerUpdateDTO;
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
@RequestMapping("/costo_alquiler")
public class CostoAlquilerController {

    private final CostoAlquilerService costoAlquilerService;

    public CostoAlquilerController(CostoAlquilerService costoAlquilerService) {
        this.costoAlquilerService = costoAlquilerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostoAlquilerRespuestaDTO> getCostoAlquiler(@PathVariable Long id){
        return ResponseEntity.ok(costoAlquilerService.getCostoAlquiler(id));
    }

    @GetMapping
    public ResponseEntity<Page<CostoAlquilerRespuestaDTO>> getAllCostoAlquiler(
            @PageableDefault(size=5, sort = "id")Pageable pageable){
        return ResponseEntity.ok(costoAlquilerService.findByCostoAlquiler(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CostoAlquilerRespuestaDTO> insertCostoAlquiler(
            @Valid @RequestBody CostoAlquilerInsertDTO costoAlquilerInsertDTO,
            UriComponentsBuilder uriComponentsBuilder){
            CostoAlquilerRespuestaDTO costoAlquilerRespuestaDTO = costoAlquilerService.insertCostoAlquiler(costoAlquilerInsertDTO);
            URI url = uriComponentsBuilder.path("/costo_alquiler/{id}").buildAndExpand(costoAlquilerRespuestaDTO.id()).toUri();
            return ResponseEntity.created(url).body(costoAlquilerRespuestaDTO);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<CostoAlquilerRespuestaDTO> updateCostoAlquiler(
            @Valid @RequestBody CostoAlquilerUpdateDTO costoAlquilerUpdateDTO){
        CostoAlquilerRespuestaDTO costoAlquilerRespuestaDTO = costoAlquilerService.updateCostoAlquiler(costoAlquilerUpdateDTO);
        return ResponseEntity.ok(costoAlquilerRespuestaDTO);
    }
}
