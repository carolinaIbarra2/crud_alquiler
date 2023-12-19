package com.crud_alquiler.domain.reserva;

import com.crud_alquiler.domain.espacio_fisico.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.EspacioFisicoRepository;
import com.crud_alquiler.domain.reserva.dto.ReservaInsertDTO;
import com.crud_alquiler.domain.reserva.dto.ReservaRespuestaDTO;
import com.crud_alquiler.domain.reserva.dto.ReservaUpdateDTO;
import com.crud_alquiler.domain.usuario.Usuario;
import com.crud_alquiler.domain.usuario.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    final private ReservaRepository reservaRepository;
    final private EspacioFisicoRepository espacioFisicoRepository;
    final private UsuarioRepository usuarioRepository;


    public ReservaService(ReservaRepository reservaRepository, EspacioFisicoRepository espacioFisicoRepository, UsuarioRepository usuarioRepository) {
        this.reservaRepository = reservaRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public ReservaRespuestaDTO getReserva(Long id){
        Reserva reserva = reservaRepository.getReferenceById(id);
        return new ReservaRespuestaDTO(reserva);
    }

    public Page<ReservaRespuestaDTO> getAllReserva(Pageable pageable){
        return reservaRepository.findAll(pageable).map(ReservaRespuestaDTO::new);
    }

    public ReservaRespuestaDTO insertReserva(ReservaInsertDTO reservaInsertDTO){
        EspacioFisico espacioFisico = espacioFisicoRepository.getReferenceById(reservaInsertDTO.espacioFisicoId());
        Usuario usuario = usuarioRepository.getReferenceById(reservaInsertDTO.usuarioId());
        Reserva reserva = reservaRepository.save(new Reserva(reservaInsertDTO,espacioFisico,usuario));
        return new ReservaRespuestaDTO(reserva);
    }

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

    public void deleteReserva(Long id){
        Reserva reserva = reservaRepository.getReferenceById(id);
        reservaRepository.deleteById(reserva.getId());
    }
}
