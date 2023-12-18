package com.crud_alquiler.domain.costo_alquiler;

import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerInsertDTO;
import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerRespuestaDTO;
import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerUpdateDTO;
import com.crud_alquiler.domain.espacio_fisico.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.EspacioFisicoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CostoAlquilerService {

    final private CostoAlquilerRepository costoAlquilerRepository;
    final private EspacioFisicoRepository espacioFisicoRepository;


    public CostoAlquilerService(CostoAlquilerRepository costoAlquilerRepository, EspacioFisicoRepository espacioFisicoRepository) {
        this.costoAlquilerRepository = costoAlquilerRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    public CostoAlquilerRespuestaDTO getCostoAlquiler(Long id){
          CostoAlquiler costoAlquiler = costoAlquilerRepository.getReferenceById(id);
          return new CostoAlquilerRespuestaDTO(costoAlquiler);
    }

    public Page<CostoAlquilerRespuestaDTO> findByCostoAlquiler(Pageable pageable){
        return costoAlquilerRepository.findAll(pageable).map(CostoAlquilerRespuestaDTO::new);
    }

    public CostoAlquilerRespuestaDTO insertCostoAlquiler(CostoAlquilerInsertDTO costoAlquilerInsertDTO){
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(costoAlquilerInsertDTO.espacioFisicoId());
        CostoAlquiler costoAlquiler = costoAlquilerRepository.save(new CostoAlquiler(costoAlquilerInsertDTO,espacioFisico));
        return new CostoAlquilerRespuestaDTO(costoAlquiler);

    }

    public CostoAlquilerRespuestaDTO updateCostoAlquiler(CostoAlquilerUpdateDTO costoAlquilerUpdateDTO){
        CostoAlquiler costoAlquiler = costoAlquilerRepository.getReferenceById(costoAlquilerUpdateDTO.id());
        EspacioFisico espacioFisico = null;
        if (costoAlquilerUpdateDTO.espacioFisicoId() != null){
            espacioFisico = espacioFisicoRepository.getReferenceById(costoAlquilerUpdateDTO.espacioFisicoId());
        }
        costoAlquiler.updateCostoAlquiler(costoAlquilerUpdateDTO,espacioFisico);
        return new CostoAlquilerRespuestaDTO(costoAlquiler);
    }

    public void delectCostoAlquiler(Long id){
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(id);
        costoAlquilerRepository.deleteById(espacioFisico.getId());
    }
}
