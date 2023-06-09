package com.backend.proyectoIntegrador.service.impl;


import com.backend.proyectoIntegrador.dto.PacienteDto;
import com.backend.proyectoIntegrador.entity.Paciente;
import com.backend.proyectoIntegrador.repository.IDao;
import com.backend.proyectoIntegrador.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PacienteService implements IPacienteService {
    private IDao<Paciente> pacienteIDao;

    @Autowired
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    @Override
    public List<PacienteDto> listarPacientes() {
        return pacienteIDao.listarTodos().stream().map(p -> PacienteDto.fromPaciente(p)).toList();
    }

    @Override
    public PacienteDto buscarPacientePorDni(String dni) {
        return PacienteDto.fromPaciente(pacienteIDao.buscarPorCriterio(dni));
    }

    @Override
    public PacienteDto buscarPacientePorId(int id) {
        return PacienteDto.fromPaciente(pacienteIDao.buscarPorId(id));
    }

    @Override
    public PacienteDto guardarPaciente(Paciente paciente) {
        return PacienteDto.fromPaciente(pacienteIDao.guardar(paciente));
    }

    @Override
    public PacienteDto actualizarPaciente(Paciente paciente) {
        return PacienteDto.fromPaciente(pacienteIDao.actualizar(paciente));
    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteIDao.eliminar(id);
    }
}
