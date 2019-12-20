package com.sircon.dao;

import java.util.List;

public interface DAOBaseI <T, ID>{
    
    void insertar (T a) throws DAOException;
    void modificar (T a) throws DAOException;
    void eliminar (T a) throws DAOException;
    List<T> obtenerTodos() throws DAOException;
    T obtener(ID id) throws DAOException;
}