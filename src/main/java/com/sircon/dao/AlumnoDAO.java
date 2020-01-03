package com.sircon.dao;

import com.sircon.modelo.Alumno;
import com.sircon.util.JDBCSircon;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnoDAO implements DAOBaseI<Alumno, Long> {

    private JDBCSircon jdbc;

    public AlumnoDAO(JDBCSircon instanciaJDBC) {
        
        this.jdbc = instanciaJDBC;
    }

        @Override
        public void insertar(Alumno object ) {
        String sql = "INSERT INTO alumno (estado, fechaInscripcion, fechaSalida, Usuario_usuario) values (?, ?, ?, ?)";
            PreparedStatement ps = jdbc.getSentencia(sql);
            try {
                ps.setString(1, object.getEstado());
                ps.setDate(2, (Date) object.getFechaInscripcion());
                ps.setDate(3, (Date) object.getFechaSalida());
                ps.setString(4, object.getUsuario());
            } catch (SQLException e) {
                Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
            }
            System.out.println("Alumno Creado");
            jdbc.cerrarObjetos();
        }

        @Override
        public void modificar(Alumno object) {            
        String sql = "UPDATE alumno SET estado = ?, fechaInscripcion = ?, fechaSalida= ? WHERE Usuario_usuario = ?";
        PreparedStatement ps = jdbc.getSentencia(sql);
        try {
            ps.setString(1, object.getEstado());
            ps.setDate(2, (Date) object.getFechaInscripcion());
            ps.setDate(3, (Date) object.getFechaSalida());
            ps.setString(4, object.getUsuario());
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("Alumno :"+object.getUsuario()+" actualizado correctamente");
        jdbc.cerrarObjetos();
        
        }

        @Override
        public void eliminar(Long id) {            
        String sql = "DELETE FROM alumno WHERE Usuario_usuario = ? ";
        PreparedStatement ps = jdbc.getSentencia(sql);
        try {
            ps.setLong(1, id);
            jdbc.ejecutarActualizacion(ps);
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        System.out.println("alumno: " + id + "Elminado correctamente");
        jdbc.cerrarObjetos();
    }

        @Override
        public List<Alumno> obtenerTodos() {
        String sql = "SELECT * FROM alumno";
        PreparedStatement ps = jdbc.getSentencia(sql);
        ResultSet rs = jdbc.ejecutarConsulta(ps);
        List<Alumno> resultado = new ArrayList<Alumno>();
        Alumno objEncontrado = null;
        try {
            while (rs.next()) {
                objEncontrado = new Alumno();
                objEncontrado.setUsuario(rs.getString("usuario"));
                objEncontrado.setFechaInscripcion(rs.getDate("fechaInscripcion"));
                objEncontrado.setFechaSalida(rs.getDate("fechaSalida"));
                objEncontrado.setEstado(rs.getString("estado"));
                resultado.add(objEncontrado);
            }
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        System.out.println(" Estudiantes encontrados: ");
        System.out.println(resultado);
        jdbc.cerrarObjetos();
        return resultado;
    }

        @Override
        public Alumno obtener(Long id) {
        String sql = "SELECT * FROM alumno WHERE Usuario_usuario = ?";
        PreparedStatement ps = jdbc.getSentencia(sql);

        Alumno objEncontrado = null;
        try {
            ps.setLong(1, id);
            ResultSet rs = jdbc.ejecutarConsulta(ps);
            objEncontrado.setUsuario(rs.getString("usuario"));
            objEncontrado.setFechaInscripcion(rs.getDate("fechaInscripcion"));
            objEncontrado.setFechaSalida(rs.getDate("fechaSalida"));
            objEncontrado.setEstado(rs.getString("estado"));
            rs.next();
            objEncontrado = new Alumno();
            
        } catch (SQLException e) {
            Logger.getLogger(AdministrativoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        System.out.println("Alumno encontrado con dni: " + id);
        System.out.println(objEncontrado);
        jdbc.cerrarObjetos();
        return objEncontrado;
    }

    }

