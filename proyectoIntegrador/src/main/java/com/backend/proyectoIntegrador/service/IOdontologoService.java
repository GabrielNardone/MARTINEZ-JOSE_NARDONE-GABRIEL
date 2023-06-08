package com.backend.proyectoIntegrador.service;

import com.backend.proyectoIntegrador.entity.Odontologo;

import java.util.List;

public interface IOdontologoService {

    Odontologo buscarOdontologoPorId(int id);

    List<Odontologo> listarOdontologos();

    Odontologo registrarOdontologo(Odontologo odontologo);

    Odontologo actualizarOdontologo(Odontologo odontologo);

    void eliminarOdontologo(int id);
}
