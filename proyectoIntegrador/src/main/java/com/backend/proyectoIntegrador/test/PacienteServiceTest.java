package com.backend.proyectoIntegrador.test;



import com.backend.proyectoIntegrador.dto.PacienteDto;
import com.backend.proyectoIntegrador.entity.Domicilio;
import com.backend.proyectoIntegrador.entity.Paciente;
import com.backend.proyectoIntegrador.exceptions.ResourceNotFoundException;
import com.backend.proyectoIntegrador.service.impl.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.*;
import java.time.LocalDate;


@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceTest {
    private final PacienteService pacienteService;
    private static Paciente paciente;

@Autowired
    PacienteServiceTest(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
    @BeforeAll
    public static void crearPaciente(){
    paciente = new Paciente( "Francisco", "Lopez", "53123456", LocalDate.now() , new Domicilio());
    }


    @Test
    @Order(1)
    void deberiaValidarElGuardarUnPaciente() {
        PacienteDto pacienteDto = pacienteService.guardarPaciente(paciente);
        Assertions.assertEquals("Francisco", pacienteDto.getNombre());
        Assertions.assertEquals(1L, (long) pacienteDto.getId());
    }

    @Test
    @Order(2)
    void deberiaEncontrarPacientePorId() {
    Assertions.assertEquals("Francisco", pacienteService.buscarPacientePorId(1L).getNombre());

    }

    @Test
    @Order(3)
    void deberiaEliminarUnPaciente() throws ResourceNotFoundException{
        pacienteService.eliminarPaciente(1L);
        Assertions.assertTrue(pacienteService.listarPacientes().isEmpty());
        Assertions.assertEquals(0, pacienteService.listarPacientes().size());
    }
}