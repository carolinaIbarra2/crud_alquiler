package com.crud_alquiler.controller;

import com.crud_alquiler.domain.reserva.ReservaService;
import com.crud_alquiler.domain.reserva.dto.ReservaInsertDTO;
import com.crud_alquiler.domain.reserva.dto.ReservaRespuestaDTO;
import com.crud_alquiler.domain.reserva.dto.ReservaUpdateDTO;
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
@RequestMapping("/reserva")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaRespuestaDTO> getReserva(@PathVariable Long id){
        return ResponseEntity.ok(reservaService.getReserva(id));
    }

    @GetMapping
    public ResponseEntity<Page<ReservaRespuestaDTO>> getAllReserva(
            @PageableDefault(size = 5, sort = "id")Pageable pageable){
            return ResponseEntity.ok(reservaService.getAllReserva(pageable));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ReservaRespuestaDTO> insertReserva(
            @Valid @RequestBody ReservaInsertDTO reservaInsertDTO,
            UriComponentsBuilder uriComponentsBuilder
            ){
        ReservaRespuestaDTO reservaRespuestaDTO = reservaService.insertReserva(reservaInsertDTO);
        URI url = uriComponentsBuilder.path("/reserva/{id}").buildAndExpand(reservaRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(reservaRespuestaDTO);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<ReservaRespuestaDTO> updateReserva(
            @Valid @RequestBody ReservaUpdateDTO reservaUpdateDTO){
        ReservaRespuestaDTO reservaRespuestaDTO = reservaService.updateReserva(reservaUpdateDTO);
        return ResponseEntity.ok(reservaRespuestaDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteReserva(@PathVariable Long id){
        reservaService.deleteReserva(id);
        return ResponseEntity.noContent().build();
    }

}
