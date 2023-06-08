package com.backend.proyectoIntegrador.service.impl;


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
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarTodos();
    }

    @Override
    public Paciente buscarPacientePorDni(String dni) {
        return pacienteIDao.buscarPorCriterio(dni);
    }

    @Override
    public Paciente buscarPacientePorId(int id) {
        return pacienteIDao.buscarPorId(id);
    }

    @Override
    public Paciente guardarPaciente(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteIDao.actualizar(paciente);
    }

    @Override
    public void eliminarPaciente(int id) {
        pacienteIDao.eliminar(id);
    }
}
