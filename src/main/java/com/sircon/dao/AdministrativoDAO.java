package com.sircon.dao;

import com.sircon.modelo.Administrativo;
import com.sircon.util.JDBCSircon;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdministrativoDAO implements DAOBaseI<Administrativo, Long>{
    
    private JDBCSircon jdbc;
    
    public AdministrativoDAO (JDBCSircon instanciaJDBC){
        
        this.jdbc = instanciaJDBC;
    }

    @Override
    public void insertar(Administrativo object) {
        String sql = "INSERT INTO administrativo (cargo, fechaIngreso, fechaSalida, sueldo, profesion) values (?, ?, ?, ?, ?)";
        PreparedStatement ps = jdbc.getSentencia(sql);
        try {
            ps.setString(1, object.getCargo());
            ps.setDate(2, (Date) object.getFechaIngreso());
            ps.setDate(3, (Date) object.getFechaSalida());
            ps.setFloat(4, object.getSueldo());
            ps.setString(5, object.getProfesion());
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("Personal Actualizado");
        jdbc.cerrarObjetos();
    }

    @Override
    public void modificar(Administrativo object) {  
        
        String sql = "UPDATE administrativo SET cargo = ?, fechaIngreso = ?, fechaSalida = ?, sueldo = ?, profesion= ? WHERE Usuario_usuario = ?";
        PreparedStatement ps = jdbc.getSentencia(sql);
        try {
            ps.setString(1, object.getCargo());
            ps.setDate(2, (Date) object.getFechaIngreso());
            ps.setDate(3, (Date) object.getFechaSalida());
            ps.setFloat(4, object.getSueldo());
            ps.setString(5, object.getProfesion());
            ps.setString(6, object.getUsuario());
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("Usuario :"+object.getUsuario()+" actualizado correctamente");
        jdbc.cerrarObjetos();
    }

    @Override
    public void eliminar(String id) {        
        String sql = "DELETE FROM administrativo WHERE Usuario_usuario = ? ";
        PreparedStatement ps = jdbc.getSentencia(sql);
        try {
            ps.setString(1, id);
            jdbc.ejecutarActualizacion(ps);
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("Usuario: "+id+"Elminado correctamente");
        jdbc.cerrarObjetos();
    }

    @Override
    public List<Administrativo> obtenerTodos() {
        String sql = "SELECT * FROM administrativo";
        PreparedStatement ps = jdbc.getSentencia(sql);
        ResultSet rs = jdbc.ejecutarConsulta(ps);
        List<Administrativo> resultado = new ArrayList<Administrativo>();
        Administrativo objEncontrado = null;
        try {
            while (rs.next()){
                objEncontrado = new Administrativo();
                objEncontrado.setFechaIngreso(rs.getDate("Fecha Ingreso"));
                objEncontrado.setUsuario(rs.getString("usuario"));
                objEncontrado.setNombres(rs.getString("nombre"));
                objEncontrado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                objEncontrado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                objEncontrado.setProfesion(rs.getString("profesion"));
                objEncontrado.setSueldo(rs.getFloat("sueldo"));
                resultado.add(objEncontrado);
            }
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        System.out.println("Personal Administrativo Encontrados: ");
        System.out.println(resultado);
        jdbc.cerrarObjetos();
        return resultado;
    
    }

  
    @Override
    public Administrativo obtener(String id) {
        
        String sql = "SELECT * FROM administrativo WHERE Usuario_usuario = ?";
        PreparedStatement ps = jdbc.getSentencia(sql);
        
        Administrativo objEncontrado = null;
        try {
            ps.setString(1, id);
            ResultSet rs = jdbc.ejecutarConsulta(ps);
            rs.next();
                objEncontrado = new Administrativo();
                objEncontrado.setFechaIngreso(rs.getDate("Fecha Ingreso"));
                objEncontrado.setUsuario(rs.getString("usuario"));
                objEncontrado.setNombres(rs.getString("nombre"));
                objEncontrado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                objEncontrado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                objEncontrado.setProfesion(rs.getString("profesion"));
                objEncontrado.setSueldo(rs.getFloat("sueldo"));            
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        
        System.out.println("Personal encontrado con id: "+id);
        System.out.println(objEncontrado);
        jdbc.cerrarObjetos();
        return objEncontrado;
    }
}
