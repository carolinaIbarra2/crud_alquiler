package com.crud_alquiler.servicio.espacio_fisico;

import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoUpdateDTO;
import com.crud_alquiler.domain.espacio_fisico.repository.EspacioFisicoRepository;
import com.crud_alquiler.domain.tipo_espacio.entidades.TipoEspacio;
import com.crud_alquiler.domain.tipo_espacio.repository.TipoEspacioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *Implementación de EspacioFisicoServiceInterface que gestiona la lógica de negocio relacionada con los
 *espacios fisicos.
 */
@Service
public class EspacioFisicoService implements EspacioFisicoServiceInterface{

    final private EspacioFisicoRepository espacioFisicoRepository;
    final private TipoEspacioRepository tipoEspacioRepository;

    /**
     * Constructor para inicializar las dependencias
     * @param espacioFisicoRepository Repositorio para operaciones relacionadas con EspacioFisico
     * @param tipoEspacioRepository Repositorio para operaciones relacionadas con TipoEspacio
     */
    public EspacioFisicoService(EspacioFisicoRepository espacioFisicoRepository, TipoEspacioRepository tipoEspacioRepository) {
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.tipoEspacioRepository = tipoEspacioRepository;
    }
    @Override
    public EspacioFisicoRespuestaDTO getEspacioFisico(Long id){
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(id);
        return new EspacioFisicoRespuestaDTO(espacioFisico);
    }

    @Override
    public Page<EspacioFisicoRespuestaDTO> getAllEspacioFisico(Pageable pageable){
        return espacioFisicoRepository.findAll(pageable).map(EspacioFisicoRespuestaDTO::new);
    }

    @Override
    public EspacioFisicoRespuestaDTO insertEspacioFisico(EspacioFisicoInsertDTO espacioFisicoInsertDTO){
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(espacioFisicoInsertDTO.tipoEspacioId());
        EspacioFisico espacioFisico = espacioFisicoRepository.save(new EspacioFisico(espacioFisicoInsertDTO,tipoEspacio));
        return new EspacioFisicoRespuestaDTO(espacioFisico);
    }

    @Override
    public EspacioFisicoRespuestaDTO updateEspacioFisico(EspacioFisicoUpdateDTO espacioFisicoUpdateDTO){
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(espacioFisicoUpdateDTO.id());
        TipoEspacio tipoEspacio  = null;
        if (espacioFisicoUpdateDTO.tipoEspacioId() !=  null){
            tipoEspacio = tipoEspacioRepository.getReferenceById(espacioFisicoUpdateDTO.tipoEspacioId());
        }
        espacioFisico.updateEspacioFisico(espacioFisicoUpdateDTO,tipoEspacio);
        return new EspacioFisicoRespuestaDTO(espacioFisico);
    }

    @Override
    public void deleteEspacioFisico(Long id) {
        TipoEspacio tipoEspacio = tipoEspacioRepository.getReferenceById(id);
        espacioFisicoRepository.deleteById(tipoEspacio.getId());
    }
}
