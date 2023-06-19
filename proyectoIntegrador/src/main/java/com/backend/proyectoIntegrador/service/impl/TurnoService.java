package com.backend.proyectoIntegrador.service.impl;

import com.backend.proyectoIntegrador.dto.OdontologoDto;
import com.backend.proyectoIntegrador.dto.PacienteDto;
import com.backend.proyectoIntegrador.dto.TurnoDto;
import com.backend.proyectoIntegrador.entity.Odontologo;
import com.backend.proyectoIntegrador.entity.Paciente;
import com.backend.proyectoIntegrador.entity.Turno;
import com.backend.proyectoIntegrador.repository.TurnoRepository;
import com.backend.proyectoIntegrador.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService implements ITurnoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private TurnoRepository turnoRepository;
    private ObjectMapper objectMapper;
    @Override
    public TurnoDto guardarTurno(Turno turno) {
        Turno turnoNuevo = turnoRepository.save(turno);
        PacienteDto pacienteDto = objectMapper.convertValue(turno.getPaciente(), PacienteDto.class);
        OdontologoDto odontologoDto = objectMapper.convertValue(turno.getOdontologo(), OdontologoDto.class);
        TurnoDto turnoNuevoDto = objectMapper.convertValue(turnoNuevo, TurnoDto.class);
        turnoNuevoDto.setPacienteDto(pacienteDto);
        turnoNuevoDto.setOdontologoDto(odontologoDto);

        LOGGER.info("Date saved {}:", turno);
        return turnoNuevoDto;
    }

    @Override
    public List<TurnoDto> listarTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        List<TurnoDto> turnoDtoList = turnos.stream()
                .map(turno -> {
                    Paciente paciente = turno.getPaciente();
                    Odontologo odontologo = turno.getOdontologo();
                    PacienteDto pacienteDto = objectMapper.convertValue(paciente, PacienteDto.class);
                    OdontologoDto odontologoDto = objectMapper.convertValue(odontologo, OdontologoDto.class);
                    return new TurnoDto(turno.getId(), turno.getFechaAsistencia().atStartOfDay(), pacienteDto, odontologoDto);
                })
                .toList();
        return turnoDtoList;
    }

    @Override
    public TurnoDto buscarTurnoPorId(Long id) {
        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);
        TurnoDto turnoDto = null;
        if (turnoBuscado != null) {
            PacienteDto pacienteDto = objectMapper.convertValue(turnoBuscado.getPaciente(), PacienteDto.class);
            OdontologoDto odontologoDto = objectMapper.convertValue(turnoBuscado.getOdontologo(), OdontologoDto.class);
            turnoDto = objectMapper.convertValue(turnoBuscado, TurnoDto.class);
            turnoDto.setOdontologoDto(odontologoDto);
            turnoDto.setPacienteDto(pacienteDto);
        } else LOGGER.info("The ID doesn´t exist");
        return turnoDto;
    }

    @Override
    public TurnoDto actualizarTurno(Turno turno) {
        Turno turnoAActualizar = turnoRepository.findById(turno.getId()).orElse(null);
        TurnoDto turnoActualizadoDto = null;

        if(turnoAActualizar != null) {
            turnoAActualizar = turno;
            turnoRepository.save(turnoAActualizar);

            PacienteDto pacienteDto = objectMapper.convertValue(turnoAActualizar.getPaciente(), PacienteDto.class);
            OdontologoDto odontologoDto = objectMapper.convertValue(turnoAActualizar.getOdontologo(), OdontologoDto.class);
            turnoActualizadoDto = objectMapper.convertValue(turnoAActualizar, TurnoDto.class);
            turnoActualizadoDto.setOdontologoDto(odontologoDto);
            turnoActualizadoDto.setPacienteDto(pacienteDto);
            LOGGER.info("Date updated {}:", turnoActualizadoDto);
        } else LOGGER.error("The date doesn´t exist");

        return turnoActualizadoDto;
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
        LOGGER.warn("The date with id {} was deleted", id);
    }
}
