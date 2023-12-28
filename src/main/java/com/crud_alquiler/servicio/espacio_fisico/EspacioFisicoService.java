package com.crud_alquiler.servicio.espacio_fisico;

import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoUpdateDTO;
import com.crud_alquiler.domain.espacio_fisico.repository.EspacioFisicoRepository;
import com.crud_alquiler.domain.espacio_fisico.validation.EspacioFisicoValidationInterface;
import com.crud_alquiler.domain.tipo_espacio.entity.TipoEspacio;
import com.crud_alquiler.domain.tipo_espacio.repository.TipoEspacioRepository;
import com.crud_alquiler.infraestructura.errors.IntegrityValidation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *Implementación de EspacioFisicoServiceInterface que gestiona la lógica de negocio relacionada con los
 *espacios fisicos.
 */
@Service
public class EspacioFisicoService implements EspacioFisicoServiceInterface{

    private final EspacioFisicoRepository espacioFisicoRepository;
    private final TipoEspacioRepository tipoEspacioRepository;
    private final List<EspacioFisicoValidationInterface> espacioFisicoValidationInterface;


    /**
     * Constructor para inicializar las dependencias
     *
     * @param espacioFisicoRepository          Repositorio para operaciones relacionadas con EspacioFisico
     * @param tipoEspacioRepository            Repositorio para operaciones relacionadas con TipoEspacio
     * @param espacioFisicoValidationInterface lógica de validación para la inserción y actualización de EspacioFisico.
     */
    public EspacioFisicoService(EspacioFisicoRepository espacioFisicoRepository, TipoEspacioRepository tipoEspacioRepository, List<EspacioFisicoValidationInterface> espacioFisicoValidationInterface) {
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.tipoEspacioRepository = tipoEspacioRepository;
        this.espacioFisicoValidationInterface = espacioFisicoValidationInterface;
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
        // Verificar si el id del tipo de espacio existe
        TipoEspacio tipoEspacio = tipoEspacioRepository.findById(espacioFisicoInsertDTO.tipoEspacioId())
                        .orElseThrow(() -> new IntegrityValidation("El tipo de espacio físico con el ID proporcionado" +
                                " no existe"));
        // Si el tipo de espacio físico existe, se procede con la creación del espacio fisico
        espacioFisicoValidationInterface.forEach(v->v.validationInsert(espacioFisicoInsertDTO));
        EspacioFisico espacioFisico = espacioFisicoRepository.save(new EspacioFisico(espacioFisicoInsertDTO, tipoEspacio));
        return new EspacioFisicoRespuestaDTO(espacioFisico);
    }

    @Override
    public EspacioFisicoRespuestaDTO updateEspacioFisico(EspacioFisicoUpdateDTO espacioFisicoUpdateDTO){
        espacioFisicoValidationInterface.forEach(v->v.validationUpdate(espacioFisicoUpdateDTO));
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
