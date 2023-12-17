package com.crud_alquiler.controller;

import com.crud_alquiler.domain.tipo_espacio.TipoEspacioService;
import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioInsertDTO;
import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioRespuestaDTO;
import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioUpdateDTO;
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

    @PostMapping
    @Transactional
    public ResponseEntity<TipoEspacioRespuestaDTO> insertTipoEspacio(
            @Valid @RequestBody TipoEspacioInsertDTO tipoEspacioInsertDTO,
            UriComponentsBuilder uriComponentsBuilder){

        TipoEspacioRespuestaDTO tipoEspacioRespuestaDTO = tipoEspacioService.insertTipoEspacio(tipoEspacioInsertDTO);
        URI url = uriComponentsBuilder.path("/tipo_espacio/{id}").buildAndExpand(tipoEspacioRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(tipoEspacioRespuestaDTO);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<TipoEspacioRespuestaDTO> updateTipoEspacio(
            @Valid @RequestBody TipoEspacioUpdateDTO tipoEspacioUpdateDTO
            ){

        TipoEspacioRespuestaDTO respuestaDTO = tipoEspacioService.updateTipoEspacio(tipoEspacioUpdateDTO);
        return ResponseEntity.ok(respuestaDTO);
    }

}
