package com.sircon.mysql;

import com.mysql.cj.xdevapi.PreparableStatement;
import com.sircon.dao.AdministrativoDAO;
import com.sircon.modelo.Administrativo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MYSQLAdministrativoDAO implements AdministrativoDAO{
    
    final String INSERT ="INSERT INTO Administrativo (cargo, fechaIngreso, fechaSalida, sueldo, profesion) VALUES (?,?,?,?,?)";
    final String UPDATE ="UPDATE Administrativo SET cargo=?, fechaIngreso = ?, fechaSalida= ?, sueldo = ?, profesion = ? WHERE Usuario_usuario = ?";
    final String DELETE ="DELETE FROM Administrativo WHERE Usuario_usuario = ?";
    final String GETALL ="SELECT * FROM Administrativo";
    final String GETONE ="SELECT * FROM Administrativo WHERE Usuario_usuario = ?";
    
    private Connection conn;
    
    public MYSQLAdministrativoDAO (Connection conn){
        this.conn = conn;
    }

    @Override
    public void insertar(Administrativo a) {
        PreparableStatement ps = null;
        try {
            ps = conn.prepareStatement(INSERT);
            ps.setString(1, a.getCargo());
            ps.setDate(2, new Date(a.getFechaIngreso().getTime()));
            ps.setDate(3, new Date(a.getFechaSalida().getTime()));
            ps.setFloat(4, a.getSueldo());
            ps.setString(5, a.getProfesion());
        } catch(SQLException e){
            throws new DAOException("Error en SQL:", e);
        }finally {
            ps.close();
        }
    }

    @Override
    public void modificar(Administrativo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Administrativo a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Administrativo> obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Administrativo obtener(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
