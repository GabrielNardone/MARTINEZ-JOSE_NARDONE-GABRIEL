package dao.impl;

import dao.H2Connection;
import dao.IDao;
import entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdotologoDao implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdotologoDao.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;

        try {
            connection = H2Connection.getConnetion();

            connection.setAutoCommit(false);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)");
            ps.setString(1, odontologo.getNroMatricula());
            ps.setString(2, odontologo.getNombre());
            ps.setString(3, odontologo.getApellido());
            ps.execute();

            LOGGER.info("El odontólogo con matrícula " + odontologo.getNroMatricula() + " fué registrado");

            connection.commit();
            connection.setAutoCommit(true);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.error("ERROR! Se activó el rollback");
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + e.getMessage());
                e.printStackTrace();
            }
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {

        List<Odontologo> listaOdontologos = new ArrayList<>();

        Connection connection = null;

        try {
            connection = H2Connection.getConnetion();

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM ODONTOLOGOS");

            while (rs.next()) {
                String matricula = rs.getString("MATRICULA");
                String nombre = rs.getString("NOMBRE");
                String apellido = rs.getString("APELLIDO");
                Odontologo odontologo = new Odontologo(matricula, nombre, apellido);
                listaOdontologos.add(odontologo);
            }

            LOGGER.info("Lista de odontólgos: " + listaOdontologos);


        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }
        return listaOdontologos;
    }
}
