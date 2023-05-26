package service.test;


import dao.impl.OdotologoDao;
import entity.Odontologo;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class OdontologoServiceTest {


    private OdontologoService odontologoService = new OdontologoService(new OdotologoDao());


    @Test
    void probarSiPuedelistarOdontologos() {

        Odontologo odontologo1 = new Odontologo("153dea", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo("123ERT", "Jose", "Martinez");

        odontologoService.registrarOdontologo(odontologo1);
        odontologoService.registrarOdontologo(odontologo2);

        List<Odontologo> odontologoTest = odontologoService.listarOdontologos();

        assertTrue(odontologoTest.size() >= 5);


    }
}