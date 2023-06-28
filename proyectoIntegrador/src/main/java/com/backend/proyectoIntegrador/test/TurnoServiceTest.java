package com.backend.proyectoIntegrador.test;

import com.backend.proyectoIntegrador.entity.Turno;
import com.backend.proyectoIntegrador.service.impl.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TurnoServiceTest {

    private final TurnoService turnoService;

    private static Turno turno;

   @Autowired
    TurnoServiceTest(TurnoService turnoService){
       this.turnoService = turnoService;
   }

   @BeforeAll
    public static void crearTurno(){
       turno = new Turno();
   }
}