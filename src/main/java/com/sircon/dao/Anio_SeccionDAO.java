package com.sircon.dao;

import com.sircon.modelo.Anio_Seccion;
import com.sircon.util.JDBCSircon;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Anio_SeccionDAO implements DAOBaseI<Anio_Seccion, Long>{
    
    private JDBCSircon jdbc;
    
    public Anio_SeccionDAO (JDBCSircon instanciaJDBC){
        
        this.jdbc = instanciaJDBC;
    }

    @Override
    public void insertar(Anio_Seccion object) {
    }

    @Override
    public void modificar(Anio_Seccion object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Anio_Seccion> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Anio_Seccion obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
