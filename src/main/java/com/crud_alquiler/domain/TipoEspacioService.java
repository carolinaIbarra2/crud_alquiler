package com.crud_alquiler.domain;

import com.crud_alquiler.domain.dto.TipoEspacioRespuestaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TipoEspacioService {

    private final TipoEspacioRepository tipoEspacioRepository;

    public TipoEspacioService(TipoEspacioRepository tipoEspacioRepository) {
        this.tipoEspacioRepository = tipoEspacioRepository;
    }

    public TipoEspacioRespuestaDTO getTipoEspacio(Long id){
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(id);
        return new TipoEspacioRespuestaDTO(tipoEspacio);
    }

    public Page<TipoEspacioRespuestaDTO> findByTipoEspacio(Pageable pageable){
        return tipoEspacioRepository.findAll(pageable).map(TipoEspacioRespuestaDTO::new);
    }
}
