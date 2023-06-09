package com.backend.proyectoIntegrador.dto;

import com.backend.proyectoIntegrador.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PacienteDto {
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fechaIngreso;
    private String domicilio;
    private String odontologo;

    public PacienteDto(String nombre, String apellido, String dni, LocalDate fechaIngreso, String domicilio, String odontologo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.odontologo = odontologo;
    }

    public PacienteDto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(String odontologo) {
        this.odontologo = odontologo;
    }

    public static PacienteDto fromPaciente(Paciente paciente) {
        String odontologo = paciente.getOdontologo().getNombre() + " " + paciente.getOdontologo().getApellido();
        String domicilio = paciente.getDomicilio().getCalle() + " " + paciente.getDomicilio().getLocalidad();
        return new PacienteDto(paciente.getNombre(), paciente.getApellido(), paciente.getDni(), paciente.getFechaIngreso(), domicilio, odontologo);
    }
}
