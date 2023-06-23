package com.backend.proyectoIntegrador.service.impl;



import com.backend.proyectoIntegrador.dto.OdontologoDto;
import com.backend.proyectoIntegrador.entity.Odontologo;

import com.backend.proyectoIntegrador.repository.OdontologoRepository;
import com.backend.proyectoIntegrador.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OdontologoService implements IOdontologoService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);
    private final OdontologoRepository odontologoRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository, ObjectMapper objectMapper) {
        this.odontologoRepository = odontologoRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public OdontologoDto buscarOdontologoPorId(Long id) {
        Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);
        OdontologoDto odontologoDto = null;
        if (odontologoBuscado != null){
            OdontologoDto odontologoDtoNuevo= objectMapper.convertValue(odontologoBuscado.getMatricula(), OdontologoDto.class);
            odontologoBuscado.setMatricula(odontologoBuscado.getMatricula());
            LOGGER.info("Odontologo encontrado: {}", odontologoDtoNuevo);
        }else LOGGER.info("La matricula no se encuentra registrada");

        return odontologoDto;
    }

    @Override
    public List<OdontologoDto> listarOdontologos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        List<OdontologoDto> odontologoDtos = odontologos.stream()
                .map(odontologo ->{
                    return new OdontologoDto(odontologo.getId(), odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());
                })
                .toList();
        return odontologoDtos;
    }

    @Override
    public OdontologoDto registrarOdontologo(Odontologo odontologo) {
        Odontologo odontologoNuevo = odontologoRepository.save(odontologo);
        OdontologoDto odontologoDtoNuevo = objectMapper.convertValue(odontologoNuevo.getMatricula(), OdontologoDto.class);
        odontologoDtoNuevo.setMatricula(odontologo.getMatricula());

        LOGGER.info("Nuevo odontologo registrado con exito: {}", odontologoDtoNuevo);

        return odontologoDtoNuevo;

    }

    @Override
    public OdontologoDto actualizarOdontologo(Odontologo odontologo) {
        Odontologo odontologoActualizar = odontologoRepository.findById(odontologo.getId()).orElse(null);
        OdontologoDto odontologoActualizadoDto = null;
        if (odontologoActualizar != null){
            odontologoActualizar = odontologo;
            odontologoRepository.save(odontologoActualizar);
            odontologoActualizadoDto = objectMapper.convertValue(odontologoActualizar, OdontologoDto.class);
            odontologoActualizadoDto.setMatricula(odontologo.getMatricula());
            LOGGER.info("Paciente actualizado con exito: {}", odontologoActualizadoDto);
        }else LOGGER.error("No fue posible actualizar los datos ya que el odontologo no se encuentra registrado");

        return odontologoActualizadoDto;
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
        LOGGER.warn("Se ha eliminado el odontologo con id {}", id);
    }



}
