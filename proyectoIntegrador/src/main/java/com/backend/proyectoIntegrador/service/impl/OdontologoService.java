package com.backend.proyectoIntegrador.service.impl;


import com.backend.proyectoIntegrador.entity.Odontologo;
import com.backend.proyectoIntegrador.repository.IDao;
import com.backend.proyectoIntegrador.service.IOdontologoService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OdontologoService implements IOdontologoService {
    private IDao<Odontologo> odontologoIDao;


    @Override
    public Odontologo buscarOdontologoPorId(int id) {
        return odontologoIDao.buscarPorId(id);
    }

    @Override
    public List<Odontologo> listarOdontologos() {
        return odontologoIDao.listarTodos();
    }

    @Override
    public Odontologo registrarOdontologo(Odontologo odontologo) {
        return odontologoIDao.guardar(odontologo);
    }

    @Override
    public Odontologo actualizarOdontologo(Odontologo odontologo) {
        return odontologoIDao.actualizar(odontologo);
    }

    @Override
    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }
}
