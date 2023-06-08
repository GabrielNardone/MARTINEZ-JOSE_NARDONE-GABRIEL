package com.backend.proyectoIntegrador;

import com.backend.proyectoIntegrador.repository.H2Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class IntegradoraApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(IntegradoraApplication.class);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        H2Connection.crearBd();
        SpringApplication.run(IntegradoraApplication.class, args);
        LOGGER.info("Final project is now RUNNING ...");
    }

}
