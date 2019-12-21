package com.sircon.dao;

import java.util.List;

public interface DAOBaseI <T, ID>{
    
    void insertar (T object);
    void modificar (T object);
    void eliminar (T id);
    List<T> obtenerTodos();
    T obtener(ID id);
}