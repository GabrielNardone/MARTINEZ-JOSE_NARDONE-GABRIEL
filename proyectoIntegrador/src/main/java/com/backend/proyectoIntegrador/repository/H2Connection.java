/*package com.backend.proyectoIntegrador.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class H2Connection {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/final-project;", "sa", "sa");
    }

    public static Connection crearBd() throws SQLException, ClassNotFoundException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/final-project;INIT=RUNSCRIPT FROM 'create.sql'", "sa", "sa");
    }
}
*/