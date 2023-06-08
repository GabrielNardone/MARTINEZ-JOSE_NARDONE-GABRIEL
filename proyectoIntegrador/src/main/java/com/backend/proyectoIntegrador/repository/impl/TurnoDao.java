package com.backend.proyectoIntegrador.repository.impl;

import com.backend.proyectoIntegrador.entity.Odontologo;
import com.backend.proyectoIntegrador.entity.Paciente;
import com.backend.proyectoIntegrador.entity.Turno;
import com.backend.proyectoIntegrador.repository.IDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TurnoDao implements IDao<Turno> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PacienteDaoH2.class);
    private PacienteDaoH2 pacienteDaoH2;
    private OdontologoDaoH2 odontologoDaoH2;
    private List<Turno> turnosRepository = new ArrayList<>();

    @Autowired
    public TurnoDao(PacienteDaoH2 pacienteDaoH2, OdontologoDaoH2 odontologoDaoH2) {
        this.pacienteDaoH2 = pacienteDaoH2;
        this.odontologoDaoH2 = odontologoDaoH2;
    }

    @Override
    public Turno guardar(Turno turno) {
        Turno guardado = null;
        Paciente paciente = pacienteDaoH2.buscarPorId(turno.getPaciente().getId());
        Odontologo odontologo = odontologoDaoH2.buscarPorId(turno.getOdontologo().getId());

        if (paciente != null && odontologo != null) {
            guardado = turno;
            turnosRepository.add(guardado);
            LOGGER.info("The date was saved: {}", guardado);
        } else LOGGER.error("Couldn´t save the date");

        return guardado;
    }

    @Override
    public List<Turno> listarTodos() {
        LOGGER.info("Complete dates list: {}", turnosRepository);
        return turnosRepository;
    }

    @Override
    public void eliminar(int id) {
        Turno turno = buscarPorId(id);
        turnosRepository.remove(turno);
        LOGGER.warn("The date with id " + id + " was deleted");
    }

    @Override
    public Turno buscarPorId(int id) {
        return (Turno) turnosRepository.stream().filter(t -> t.getId() == id);

        /* ANOTHER WAY TO FIND THE DATE
        Turno turnoBuscado = null;
        for (Turno turno : turnosRepository){
            if(turno.getId() == id) {
                turnoBuscado = turno;
                LOGGER.info("Turno encontrado {}", turnoBuscado);
            }
        }
        return turnoBuscado;
        */
    }

    @Override
    public Turno buscarPorCriterio(String criterio) {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) {
        turnosRepository.set(turnosRepository.indexOf(buscarPorId(turno.getId())), turno);
        return turno;
    }
}
