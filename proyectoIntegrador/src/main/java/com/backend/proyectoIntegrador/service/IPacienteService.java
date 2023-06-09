package com.backend.proyectoIntegrador.service;

import com.backend.proyectoIntegrador.dto.PacienteDto;
import com.backend.proyectoIntegrador.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<PacienteDto> listarPacientes();

    PacienteDto buscarPacientePorDni(String dni);

    PacienteDto buscarPacientePorId(int id);

    PacienteDto guardarPaciente(Paciente paciente);

    PacienteDto actualizarPaciente(Paciente paciente);

    void eliminarPaciente(int id);

}
