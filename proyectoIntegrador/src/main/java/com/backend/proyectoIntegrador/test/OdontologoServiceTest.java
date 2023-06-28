package com.backend.proyectoIntegrador.test;

import com.backend.proyectoIntegrador.entity.Odontologo;
import com.backend.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.backend.proyectoIntegrador.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class OdontologoServiceTest {
    private final OdontologoService odontologoService;
    private static Odontologo odontologo;

    @Autowired
    OdontologoServiceTest(OdontologoService odontologoService) {

        this.odontologoService = odontologoService;
    }

    @BeforeAll
    public static void crearOdontologo() {
        odontologo = new Odontologo("156166", "Juan", "Perez");
    }


    @Test
    @Order(1)
    void deberiaValidarElGuardadoDeUnOdontologo()  {
        assertEquals("Juan", odontologoService.buscarOdontologoPorId(1L).getNombre());
        assertEquals(1L, (long) odontologoService.buscarOdontologoPorId(1L).getId());
    }

    @Test
    @Order(2)
    void deberiaEncontrarUnOdontologoPorId(){
        Assertions.assertEquals("Juan", odontologoService.buscarOdontologoPorId(1L).getNombre());
    }

    @Test
    @Order(3)
    void deberiaEliminarUnOdontologo() throws ResourceNotFoundException {
        odontologoService.eliminarOdontologo(1l);
        Assertions.assertTrue(odontologoService.listarOdontologos().isEmpty());
        Assertions.assertEquals(0,odontologoService.listarOdontologos().size());
    }
}