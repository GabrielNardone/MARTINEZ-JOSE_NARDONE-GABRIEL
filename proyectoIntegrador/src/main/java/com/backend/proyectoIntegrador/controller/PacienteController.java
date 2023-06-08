package com.backend.proyectoIntegrador.controller;

import com.backend.proyectoIntegrador.entity.Paciente;
import com.backend.proyectoIntegrador.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PacienteController {
    private IPacienteService pacienteService;

    @Autowired
    public PacienteController(IPacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping("/register")
    public Paciente registrarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping("/update")
    public Paciente actualizarPaciente(@RequestBody Paciente paciente) {
        return pacienteService.actualizarPaciente(paciente);
    }

    @GetMapping
    public List<Paciente> listarTodos() {
        return pacienteService.listarPacientes();
    }

    @GetMapping("/{id}")
    public Paciente buscarPacientePorId(@PathVariable int id) {
        return pacienteService.buscarPacientePorId(id);
    }

    @DeleteMapping("/delete/{id}")
    public void eliminarPaciente(@PathVariable int id) {
        pacienteService.eliminarPaciente(id);
    }
}
