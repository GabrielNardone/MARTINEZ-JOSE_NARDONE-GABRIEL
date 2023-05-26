package dao.impl;

import dao.IDao;
import entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoMemoria implements IDao<Odontologo> {

    private List<Odontologo> listaOdontologos;

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);

    private OdontologoDaoMemoria(List<Odontologo> listaOdontologos) {
        this.listaOdontologos = listaOdontologos;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {
        listaOdontologos.add(odontologo);



        return odontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {

        return listaOdontologos;
    }
}
