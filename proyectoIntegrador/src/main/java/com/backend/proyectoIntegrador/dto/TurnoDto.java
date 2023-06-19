package com.backend.proyectoIntegrador.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoDto {

    private Long id;
    private LocalDateTime fechaAsistencia;
    private PacienteDto pacienteDto;
    private OdontologoDto odontologoDto;


    public TurnoDto(Long id, LocalDateTime fechaAsistencia, PacienteDto pacienteDto, OdontologoDto odontologoDto) {
        this.id = id;
        this.fechaAsistencia = fechaAsistencia;
        this.pacienteDto = pacienteDto;
        this.odontologoDto = odontologoDto;
    }

    public TurnoDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PacienteDto getPacienteDto() {
        return pacienteDto;
    }

    public void setPacienteDto(PacienteDto pacienteDto) {
        this.pacienteDto = pacienteDto;
    }

    public OdontologoDto getOdontologoDto() {
        return odontologoDto;
    }

    public void setOdontologoDto(OdontologoDto odontologoDto) {
        this.odontologoDto = odontologoDto;
    }

    public LocalDateTime getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(LocalDateTime fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }
}
