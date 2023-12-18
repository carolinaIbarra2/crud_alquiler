package com.crud_alquiler.domain.espacio_fisico;

import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoUpdateDTO;
import com.crud_alquiler.domain.tipo_espacio.TipoEspacio;
import com.crud_alquiler.domain.tipo_espacio.TipoEspacioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EspacioFisicoService {

    final private EspacioFisicoRepository espacioFisicoRepository;
    final private TipoEspacioRepository tipoEspacioRepository;

    public EspacioFisicoService(EspacioFisicoRepository espacioFisicoRepository, TipoEspacioRepository tipoEspacioRepository) {
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.tipoEspacioRepository = tipoEspacioRepository;
    }

    public EspacioFisicoRespuestaDTO getEspacioFisico(Long id){
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(id);
        return new EspacioFisicoRespuestaDTO(espacioFisico);
    }

    public Page<EspacioFisicoRespuestaDTO> findByEspacioFisico(Pageable pageable){
        return espacioFisicoRepository.findAll(pageable).map(EspacioFisicoRespuestaDTO::new);
    }

    public EspacioFisicoRespuestaDTO insertEspacioFisico(EspacioFisicoInsertDTO espacioFisicoInsertDTO){
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(espacioFisicoInsertDTO.tipoEspacioId());
        EspacioFisico espacioFisico = espacioFisicoRepository.save(new EspacioFisico(espacioFisicoInsertDTO,tipoEspacio));
        return new EspacioFisicoRespuestaDTO(espacioFisico);
    }

    public EspacioFisicoRespuestaDTO updateEspacioFisico(EspacioFisicoUpdateDTO espacioFisicoUpdateDTO){
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(espacioFisicoUpdateDTO.id());
        TipoEspacio tipoEspacio  = null;
        if (espacioFisicoUpdateDTO.tipoEspacioId() !=  null){
            tipoEspacio = tipoEspacioRepository.getReferenceById(espacioFisicoUpdateDTO.tipoEspacioId());
        }
        espacioFisico.updateEspacioFisico(espacioFisicoUpdateDTO,tipoEspacio);
        return new EspacioFisicoRespuestaDTO(espacioFisico);
    }

    public void deleteEspacioFisico(Long id) {
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(id);
        espacioFisicoRepository.deleteById(tipoEspacio.getId());
    }
}
