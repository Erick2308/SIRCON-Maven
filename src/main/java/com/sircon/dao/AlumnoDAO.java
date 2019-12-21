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
    public void insertar(Alumno object) {
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
    public void modificar(Alumno object) {

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
        System.out.println("Usuario :" + object.getUsuario() + " actualizado correctamente");
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
        System.out.println("Usuario: " + id + "Elminado correctamente");
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
                objEncontrado.setNombres(rs.getString("nombre"));
                objEncontrado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                objEncontrado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                objEncontrado.setFechaInscripcion(rs.getDate("fecha inscripcion"));
                objEncontrado.setEstado(rs.getString("estado"));
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
    public Alumno obtener(String id) {

        String sql = "SELECT * FROM administrativo WHERE Usuario_usuario = ?";
        PreparedStatement ps = jdbc.getSentencia(sql);

        Alumno objEncontrado = null;
        try {
            ps.setString(1, id);
            ResultSet rs = jdbc.ejecutarConsulta(ps);
            rs.next();
            objEncontrado = new Alumno();
                objEncontrado.setUsuario(rs.getString("usuario"));
                objEncontrado.setNombres(rs.getString("nombre"));
                objEncontrado.setApellidoPaterno(rs.getString("apellidoPaterno"));
                objEncontrado.setApellidoMaterno(rs.getString("apellidoMaterno"));
                objEncontrado.setFechaInscripcion(rs.getDate("fecha inscripcion"));
                objEncontrado.setEstado(rs.getString("estado"));
        } catch (SQLException e) {
            Logger.getLogger(AlumnoDAO.class.getName()).log(Level.SEVERE, null, e);
        }

        System.out.println("Personal encontrado con id: " + id);
        System.out.println(objEncontrado);
        jdbc.cerrarObjetos();
        return objEncontrado;
    }

}
