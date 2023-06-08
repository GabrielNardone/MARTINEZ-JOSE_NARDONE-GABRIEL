package com.backend.proyectoIntegrador.controller;

import com.backend.proyectoIntegrador.dto.TurnoDto;
import com.backend.proyectoIntegrador.entity.Turno;
import com.backend.proyectoIntegrador.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    private final ITurnoService turnoService;

    @Autowired
    public TurnoController(ITurnoService turnoService) {
        this.turnoService = turnoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDto> buscarTurnoPorId(@PathVariable int id) {
        ResponseEntity<TurnoDto> respuesta;
        TurnoDto turnoDto = turnoService.buscarTurnoPorId(id);
        if (turnoDto != null) respuesta = new ResponseEntity<>(turnoDto, null, HttpStatus.OK);
        else respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return respuesta;
    }

    @PostMapping("/registrar")
    public ResponseEntity<TurnoDto> guardarTurno(@RequestBody Turno turno) {
        ResponseEntity<TurnoDto> respuesta;
        TurnoDto turnoDto = turnoService.guardarTurno(turno);
        if (turnoDto != null) respuesta = new ResponseEntity<>(turnoDto, null, HttpStatus.CREATED);
        else respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return respuesta;
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarTurno(@PathVariable int id) {
        turnoService.eliminarTurno(id);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<TurnoDto> actualizarTurno(@RequestBody Turno turno) {
        ResponseEntity<TurnoDto> respuesta;
        TurnoDto turnoDto = turnoService.actualizarTurno(turno);
        if (turnoDto != null) respuesta = new ResponseEntity<>(turnoDto, null, HttpStatus.OK);
        else respuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return respuesta;
    }

}
