package com.backend.proyectoIntegrador.repository;

import java.util.List;

public interface IDao<T> {
    //alta, buscarlos, eliminarlos y listarlos
    T guardar(T t);

    List<T> listarTodos();

    void eliminar(int id);

    T buscarPorId(int id);

    T buscarPorCriterio(String criterio);

    T actualizar(T t);

}
