package com.backend.proyectoIntegrador.service;

import com.backend.proyectoIntegrador.entity.Paciente;

import java.util.List;

public interface IPacienteService {
    List<Paciente> listarPacientes();

    Paciente buscarPacientePorDni(String dni);

    Paciente buscarPacientePorId(int id);

    Paciente guardarPaciente(Paciente paciente);

    Paciente actualizarPaciente(Paciente paciente);

    void eliminarPaciente(int id);

}
