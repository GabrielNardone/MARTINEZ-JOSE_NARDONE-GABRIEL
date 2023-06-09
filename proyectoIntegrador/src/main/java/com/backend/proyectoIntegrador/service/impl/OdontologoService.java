package com.backend.proyectoIntegrador.service.impl;


import com.backend.proyectoIntegrador.dto.OdontologoDto;
import com.backend.proyectoIntegrador.entity.Odontologo;
import com.backend.proyectoIntegrador.repository.IDao;
import com.backend.proyectoIntegrador.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OdontologoService implements IOdontologoService {
    private IDao<Odontologo> odontologoIDao;
    private ObjectMapper objectMapper;

    @Autowired
    public OdontologoService(IDao<Odontologo> odontologoIDao, ObjectMapper objectMapper) {
        this.odontologoIDao = odontologoIDao;
        this.objectMapper = objectMapper;
    }

    @Override
    public OdontologoDto buscarOdontologoPorId(int id) {
        return objectMapper.convertValue(odontologoIDao.buscarPorId(id), OdontologoDto.class);
    }

    @Override
    public List<OdontologoDto> listarOdontologos() {
        return odontologoIDao.listarTodos().stream().map(o -> objectMapper.convertValue(o, OdontologoDto.class)).toList();
    }

    @Override
    public OdontologoDto registrarOdontologo(Odontologo odontologo) {
        return objectMapper.convertValue(odontologoIDao.guardar(odontologo), OdontologoDto.class);
    }

    @Override
    public OdontologoDto actualizarOdontologo(Odontologo odontologo) {
        return objectMapper.convertValue(odontologoIDao.actualizar(odontologo), OdontologoDto.class);
    }

    @Override
    public void eliminarOdontologo(int id) {
        odontologoIDao.eliminar(id);
    }
}
