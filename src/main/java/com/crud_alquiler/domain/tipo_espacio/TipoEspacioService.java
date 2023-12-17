package com.crud_alquiler.domain.tipo_espacio;

import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioInsertDTO;
import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioRespuestaDTO;
import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioUpdateDTO;
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

    public TipoEspacioRespuestaDTO insertTipoEspacio(TipoEspacioInsertDTO tipoEspacioInsertDTO){
        TipoEspacio tipoEspacio = tipoEspacioRepository.save(new TipoEspacio(tipoEspacioInsertDTO));
        return new TipoEspacioRespuestaDTO(tipoEspacio);
    }

    public TipoEspacioRespuestaDTO updateTipoEspacio(TipoEspacioUpdateDTO tipoEspacioUpdateDTO){
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(tipoEspacioUpdateDTO.id());
        tipoEspacio.updateTipoEspacio(tipoEspacioUpdateDTO);
        return new TipoEspacioRespuestaDTO(tipoEspacio);
    }
}
