package com.backend.proyectoIntegrador.entity;

import java.time.LocalDateTime;

public class Turno {
    private int id;
    private Odontologo odontologo;
    private Paciente paciente;
    private LocalDateTime fechayhora;

    public Turno(int id, Odontologo odontologo, Paciente paciente, LocalDateTime fechayhora) {
        this.id = id;
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechayhora = fechayhora;
    }

    public Turno(Odontologo odontologo, Paciente paciente, LocalDateTime fechayhora) {
        this.odontologo = odontologo;
        this.paciente = paciente;
        this.fechayhora = fechayhora;
    }

    public Turno() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechayhora() {
        return fechayhora;
    }

    public void setFechayhora(LocalDateTime fechayhora) {
        this.fechayhora = fechayhora;
    }

    @Override
    public String toString() {
        return "Turno{" +
                "id=" + id +
                ", odontologo=" + odontologo +
                ", paciente=" + paciente +
                ", fechayhora=" + fechayhora +
                '}';
    }
}
