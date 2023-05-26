package dao.impl;

import dao.IDao;
import entity.Odontologo;

import java.util.List;

public class OdontologoDaoMemoria implements IDao<Odontologo> {

    private List<Odontologo> listaOdontologos;

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
