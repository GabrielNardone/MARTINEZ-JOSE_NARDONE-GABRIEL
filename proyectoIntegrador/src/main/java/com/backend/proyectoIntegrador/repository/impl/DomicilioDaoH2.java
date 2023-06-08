package com.backend.proyectoIntegrador.repository.impl;


import com.backend.proyectoIntegrador.entity.Domicilio;
import com.backend.proyectoIntegrador.repository.H2Connection;
import com.backend.proyectoIntegrador.repository.IDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DomicilioDaoH2 implements IDao<Domicilio> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DomicilioDaoH2.class);


    @Override
    public Domicilio guardar(Domicilio domicilio) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, domicilio.getCalle());
            ps.setInt(2, domicilio.getNumero());
            ps.setString(3, domicilio.getLocalidad());
            ps.setString(4, domicilio.getProvincia());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                domicilio.setId(rs.getInt(1));
            }

            connection.commit();
            LOGGER.info("The home: " + domicilio + " was registered.");

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("We had a problem");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("An error occurred while closing DB " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return domicilio;
    }

    @Override
    public List<Domicilio> listarTodos() {
        Connection connection = null;
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM DOMICILIOS");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Domicilio domicilio = new Domicilio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
                domicilios.add(domicilio);
            }

            LOGGER.info("Complete homes list: \n" + domicilios);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("An error occurred while closing DB " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return domicilios;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("DELETE FROM DOMICILIOS WHERE ID = ?", id);
            //ps.setInt(1, id);
            ps.execute();
            connection.commit();
            LOGGER.info("The home with id: " + id + " was deleted.");

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("We had a problem");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("An error occurred while closing DB " + ex.getMessage());
                ex.printStackTrace();
            }
        }

    }

    @Override
    public Domicilio buscarPorId(int id) {
        Domicilio domicilio = null;
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                domicilio = new Domicilio(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            }

            LOGGER.info("We have found the home: " + domicilio);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("An error occurred while closing DB " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarPorCriterio(String criterio) {
        return null;
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        return null;
    }
}
