package com.crud_alquiler.servicio.costo_alquiler;

import com.crud_alquiler.domain.costo_alquiler.entidades.CostoAlquiler;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerInsertDTO;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerRespuestaDTO;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerUpdateDTO;
import com.crud_alquiler.domain.costo_alquiler.repository.CostoAlquilerRepository;
import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.repository.EspacioFisicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *Implementación de CostoAlquilerServiceInterface que gestiona la lógica de negocio relacionada con los
 *costos de alquiler.
 */
@Service
public class CostoAlquilerService implements CostoAlquilerServiceInterface{

    final private CostoAlquilerRepository costoAlquilerRepository;
    final private EspacioFisicoRepository espacioFisicoRepository;

    /**
     * Constructor para inicializar las dependencias
     * @param costoAlquilerRepository Repositorio para operaciones relacionadas con CostoAlquier
     * @param espacioFisicoRepository Repositorio para operaciones relacionadas con EspacioFisico
     */
    public CostoAlquilerService(CostoAlquilerRepository costoAlquilerRepository, EspacioFisicoRepository espacioFisicoRepository) {
        this.costoAlquilerRepository = costoAlquilerRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
    }


    @Override
    public CostoAlquilerRespuestaDTO getCostoAlquiler(Long id) {
        CostoAlquiler costoAlquiler = costoAlquilerRepository.getReferenceById(id);
        return new CostoAlquilerRespuestaDTO(costoAlquiler);
    }

    @Override
    public Page<CostoAlquilerRespuestaDTO> getAllCostoAlquiler(Pageable pageable){
        return costoAlquilerRepository.findAll(pageable).map(CostoAlquilerRespuestaDTO::new);
    }

    @Override
    public CostoAlquilerRespuestaDTO insertCostoAlquiler(CostoAlquilerInsertDTO costoAlquilerInsertDTO) {
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(costoAlquilerInsertDTO.espacioFisicoId());
        CostoAlquiler costoAlquiler = costoAlquilerRepository.save(new CostoAlquiler(costoAlquilerInsertDTO,espacioFisico));
        return new CostoAlquilerRespuestaDTO(costoAlquiler);
    }

    @Override
    public CostoAlquilerRespuestaDTO updateCostoAlquiler(CostoAlquilerUpdateDTO costoAlquilerUpdateDTO) {
        CostoAlquiler costoAlquiler = costoAlquilerRepository.getReferenceById(costoAlquilerUpdateDTO.id());
        EspacioFisico espacioFisico = null;
        if (costoAlquilerUpdateDTO.espacioFisicoId() != null){
            espacioFisico = espacioFisicoRepository.getReferenceById(costoAlquilerUpdateDTO.espacioFisicoId());
        }
        costoAlquiler.updateCostoAlquiler(costoAlquilerUpdateDTO,espacioFisico);
        return new CostoAlquilerRespuestaDTO(costoAlquiler);
    }

    @Override
    public void delectCostoAlquiler(Long id) {
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(id);
        costoAlquilerRepository.deleteById(espacioFisico.getId());
    }
}
