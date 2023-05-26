package service.test;


import dao.impl.OdontologoDao;
import entity.Odontologo;
import org.junit.jupiter.api.Test;
import service.OdontologoService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {


    private OdontologoService odontologoService = new OdontologoService(new OdontologoDao());



    @Test
    void probarSiPuedelistarOdontologos() {

        Odontologo odontologo1 = new Odontologo("153dea", "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo("123ERT", "Jose", "Martinez");

        odontologoService.registrarOdontologo(odontologo1);
        odontologoService.registrarOdontologo(odontologo2);

        List<Odontologo> odontologoTest = odontologoService.listarOdontologos();

        assertFalse(odontologoTest.isEmpty());


    }
}