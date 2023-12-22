package com.crud_alquiler.servicio.tipo_espacio;

import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioRespuestaDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioInsertDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioUpdateDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.TipoEspacio;
import com.crud_alquiler.domain.tipo_espacio.repository.TipoEspacioRepository;
import com.crud_alquiler.domain.tipo_espacio.validation.TipoEspacioValidationInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *Implementación de TipoEspacioServiceRepository que gestiona la lógica de negocio relacionada con los
 *tipos de espacios.
 */
@Service
public class TipoEspacioService implements TipoEspacioServiceInterface {

    private final TipoEspacioRepository tipoEspacioRepository;
    private final List<TipoEspacioValidationInterface> tipoEspacioValidationInterface;

    /**
     * Constructor para inicializar las dependencias
     *
     * @param tipoEspacioRepository          Repositorio para operaciones relacionadas con TipoEspacio
     * @param tipoEspacioValidationInterface lógica de validación para la inserción y actualización de TipoEspacio.
     */
    public TipoEspacioService(TipoEspacioRepository tipoEspacioRepository, List<TipoEspacioValidationInterface> tipoEspacioValidationInterface) {
        this.tipoEspacioRepository = tipoEspacioRepository;
        this.tipoEspacioValidationInterface = tipoEspacioValidationInterface;
    }

    @Override
    public TipoEspacioRespuestaDTO getTipoEspacio(Long id){
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(id);
        return new TipoEspacioRespuestaDTO(tipoEspacio);
    }

    @Override
    public Page<TipoEspacioRespuestaDTO> getAllTipoEspacio(Pageable pageable){
        return tipoEspacioRepository.findAll(pageable).map(TipoEspacioRespuestaDTO::new);
    }

    @Override
    public TipoEspacioRespuestaDTO insertTipoEspacio(TipoEspacioInsertDTO tipoEspacioInsertDTO){
        tipoEspacioValidationInterface.forEach(v->v.validacionInsert(tipoEspacioInsertDTO));
        TipoEspacio tipoEspacio = tipoEspacioRepository.save(new TipoEspacio(tipoEspacioInsertDTO));
        return new TipoEspacioRespuestaDTO(tipoEspacio);
    }

    @Override
    public TipoEspacioRespuestaDTO updateTipoEspacio(TipoEspacioUpdateDTO tipoEspacioUpdateDTO){
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(tipoEspacioUpdateDTO.id());
        tipoEspacio.updateTipoEspacio(tipoEspacioUpdateDTO);
        return new TipoEspacioRespuestaDTO(tipoEspacio);
    }

    @Override
    public void deleteTipoEspacio(Long id){
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(id);
        tipoEspacioRepository.deleteById(tipoEspacio.getId());
    }
}
