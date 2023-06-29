package com.backend.proyectoIntegrador.service.impl;


import com.backend.proyectoIntegrador.dto.TurnoDto;
import com.backend.proyectoIntegrador.entity.Odontologo;
import com.backend.proyectoIntegrador.entity.Paciente;
import com.backend.proyectoIntegrador.entity.Turno;
import com.backend.proyectoIntegrador.exceptions.BadRequestException;
import com.backend.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.backend.proyectoIntegrador.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.List;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class TurnoServiceTest {
    @Autowired
    private TurnoService turnoService;

    @Test
    @Order(1)
    void deberiaGuardarUnTurno() throws BadRequestException {
        Turno crearUnTurno = new Turno(1L, LocalDateTime.now(), new Paciente(), new Odontologo());
        TurnoDto turnoDto = turnoService.guardarTurno(crearUnTurno);

        Assertions.assertNotNull(turnoDto);
        Assertions.assertNotNull(turnoDto.getId());

    }

    @Test
    @Order(2)
    void deberiaEliminarElTurno() throws ResourceNotFoundException {
        turnoService.eliminarTurno(1L);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> turnoService.eliminarTurno(1L));
    }

    @Test
    @Order(3)
    void deberiaRetornarLaListaVacia(){
        List<TurnoDto> turnoDtos = turnoService.listarTodos();
        Assertions.assertTrue(turnoDtos.isEmpty());
    }

}