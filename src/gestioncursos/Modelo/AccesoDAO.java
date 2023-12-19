/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncursos.Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diurno
 */
public class AccesoDAO {
    ConexionSQLServer con;
    Connection conexion;

    public AccesoDAO() {
         con= new ConexionSQLServer();
         conexion = con.getConnection();
                
         if (conexion!= null) {
             System.out.println("Conectado"); 
        }
         //con.desconectar();
    
}
    
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void instertarEmpleado(String nombre, String apellido, int id, int id_curso, int salario){
        try {
            String queryInsert = "INSERT INTO empleado(nombre, apellido, id, id_curo, salario) VALUES (?,?,?,?,?);";
            PreparedStatement sentencia= conexion.prepareStatement(queryInsert);
            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setInt(3, id);
            sentencia.setInt(4, id_curso);
            sentencia.setInt(5, salario);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void instertarCurso(String nombre, int id, int numEmpleados){
        try {
            String queryInsert = "INSERT INTO curso(nombre, id, numEmpleados) VALUES (?,?,?);";
            PreparedStatement sentencia= conexion.prepareStatement(queryInsert);
            sentencia.setString(1, nombre);
            sentencia.setInt(2, id);
            sentencia.setInt(2, numEmpleados);
            sentencia.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarEmpleado(){
        try {
            String query = "SELECT * FROM empleado";
            PreparedStatement sentencia= conexion.prepareStatement(query);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                String columna1 = resultSet.getString("nombre");
                String columna2 = resultSet.getString("apellido");
                int columna3 = resultSet.getInt("id");
                int columna4 = resultSet.getInt("id_curso");
                int columna5 = resultSet.getInt("salario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarCurso(){
        try {
            String query = "SELECT * FROM curso";
            PreparedStatement sentencia= conexion.prepareStatement(query);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                String columna1 = resultSet.getString("nombre");
                int columna2 = resultSet.getInt("id");
                int columna3 = resultSet.getInt("numEmpleado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void borrarEmpleado(int id){
       try {
            String consultaSQL = "DELETE FROM empleado WHERE id = ?";
            PreparedStatement sentencia= conexion.prepareStatement(consultaSQL);
            // Establecer el valor del parámetro
            sentencia.setInt(1, id);

            int filasAfectadas = sentencia.executeUpdate();

            // Verificar si se eliminó con éxito
            if (filasAfectadas > 0) {
                System.out.println("Empleado con id: " + id + " eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún empleado con id: " + id + ".");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void borrarCurso(int id){
       try {
            String consultaSQL = "DELETE FROM curso WHERE id = ?";
            PreparedStatement sentencia= conexion.prepareStatement(consultaSQL);
            // Establecer el valor del parámetro
            sentencia.setInt(1, id);

            int filasAfectadas = sentencia.executeUpdate();

            // Verificar si se eliminó con éxito
            if (filasAfectadas > 0) {
                System.out.println("Curso con id: " + id + " eliminado con éxito.");
            } else {
                System.out.println("No se encontró ningún curso con id: " + id + ".");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
     
}
