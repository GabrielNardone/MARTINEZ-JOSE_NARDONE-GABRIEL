package com.backend.proyectoIntegrador.controller;

import com.backend.proyectoIntegrador.entity.Odontologo;
import com.backend.proyectoIntegrador.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
public class OdontologoController {
    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping()
    public List<Odontologo> listarOdontologos() {
        return odontologoService.listarOdontologos();
    }

    @GetMapping("/{id}")
    public Odontologo buscarOdontologoPorId(@PathVariable int id) {
        return odontologoService.buscarOdontologoPorId(id);
    }

    @PostMapping("/register")
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.registrarOdontologo(odontologo);
    }

    @PutMapping("/update")
    public Odontologo actualizarOdontologo(@RequestBody Odontologo odontologo) {
        return odontologoService.actualizarOdontologo(odontologo);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarOdontologo(@PathVariable int id) {
        odontologoService.eliminarOdontologo(id);
    }

}
