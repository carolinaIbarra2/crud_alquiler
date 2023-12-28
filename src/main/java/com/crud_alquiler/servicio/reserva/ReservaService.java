package com.crud_alquiler.servicio.reserva;

import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.repository.EspacioFisicoRepository;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaInsertDTO;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaRespuestaDTO;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaUpdateDTO;
import com.crud_alquiler.domain.reserva.entidades.Reserva;
import com.crud_alquiler.domain.reserva.repository.ReservaRepository;
import com.crud_alquiler.domain.usuario.entidades.Usuario;
import com.crud_alquiler.domain.usuario.repository.UsuarioRepository;
import com.crud_alquiler.infraestructura.errors.IntegrityValidation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *Implementación de ReservaServiceInterface que gestiona la lógica de negocio relacionada con las
 *reservas.
 */
@Service
public class ReservaService implements ReservaServiceInterface {

    final private ReservaRepository reservaRepository;
    final private EspacioFisicoRepository espacioFisicoRepository;
    final private UsuarioRepository usuarioRepository;


    /**
     * Constructor para inicializar las dependencias
     * @param reservaRepository Repositorio para operaciones relacionadas con Reserva
     * @param espacioFisicoRepository Repositorio para operaciones relacionadas con EspacioFisico
     * @param usuarioRepository Repositorio para operaciones relacionadas con Usuario
     */
    public ReservaService(ReservaRepository reservaRepository, EspacioFisicoRepository espacioFisicoRepository, UsuarioRepository usuarioRepository) {
        this.reservaRepository = reservaRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public ReservaRespuestaDTO getReserva(Long id){
        Reserva reserva = reservaRepository.getReferenceById(id);
        return new ReservaRespuestaDTO(reserva);
    }

    @Override
    public Page<ReservaRespuestaDTO> getAllReserva(Pageable pageable){
        return reservaRepository.findAll(pageable).map(ReservaRespuestaDTO::new);
    }

    @Override
    public ReservaRespuestaDTO insertReserva(ReservaInsertDTO reservaInsertDTO){
        // Verificar si existen los ID de las llaves foráneas
        EspacioFisico espacioFisico = espacioFisicoRepository.findById(reservaInsertDTO.espacioFisicoId())
                .orElseThrow(() -> new IntegrityValidation("El espacio físico con el ID proporcionado no existe"));

        Usuario usuario = usuarioRepository.findById(reservaInsertDTO.usuarioId())
                .orElseThrow(() -> new IntegrityValidation("El usuario con el ID proporcionado no existe"));

        // Si el espacio físico y el existe, se procede con la creación de la reserva
        Reserva reserva = reservaRepository.save(new Reserva(reservaInsertDTO,espacioFisico,usuario));
        return new ReservaRespuestaDTO(reserva);
    }

    @Override
    public ReservaRespuestaDTO updateReserva(ReservaUpdateDTO reservaUpdateDTO){
        Reserva reserva = reservaRepository.getReferenceById(reservaUpdateDTO.id());
        EspacioFisico espacioFisico = null;
        Usuario usuario = null;
        if (reservaUpdateDTO.espacioFisicoId() !=null){
            espacioFisico = espacioFisicoRepository.getReferenceById(reservaUpdateDTO.espacioFisicoId());
        }
        if (reservaUpdateDTO.usuarioId() != null){
            usuario = usuarioRepository.getReferenceById(reservaUpdateDTO.usuarioId());
        }
        reserva.updateReserva(reservaUpdateDTO,espacioFisico,usuario);
        return new ReservaRespuestaDTO(reserva);
    }

    @Override
    public void deleteReserva(Long id){
        Reserva reserva = reservaRepository.getReferenceById(id);
        reservaRepository.deleteById(reserva.getId());
    }
}
