package com.crud_alquiler.controller;

import com.crud_alquiler.domain.TipoEspacioService;
import com.crud_alquiler.domain.dto.TipoEspacioRespuestaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo_espacio")
public class TipoEspacioController {

    private final TipoEspacioService tipoEspacioService;

    public TipoEspacioController(TipoEspacioService tipoEspacioService) {
        this.tipoEspacioService = tipoEspacioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoEspacioRespuestaDTO> getTipoEspacio(@PathVariable Long id){
        return ResponseEntity.ok(tipoEspacioService.getTipoEspacio(id));
    }

    @GetMapping
    public ResponseEntity<Page<TipoEspacioRespuestaDTO>> getAllTipoEspacio(
            @PageableDefault(size = 5, sort = "tipoEspacio") Pageable pageable){
        return ResponseEntity.ok(tipoEspacioService.findByTipoEspacio(pageable));
    }



}
