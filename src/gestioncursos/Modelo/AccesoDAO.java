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
import java.util.ArrayList;
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
    
    public String mostrarEmpleado(int id){
            String cadena="";
        try {
            String query = "SELECT * FROM empleado WHERE id=?";
            PreparedStatement sentencia= conexion.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                String columna1 = resultSet.getString("nombre");
                String columna2 = resultSet.getString("apellido");
                int columna3 = resultSet.getInt("id");
                int columna4 = resultSet.getInt("id_curso");
                int columna5 = resultSet.getInt("salario");
                cadena+="Empleado{" + "nombre= " + columna1 + ", apellido= " + columna2 + ", id= " + columna3 + ", id_curso= " 
                        + columna4 + ", salario= " + columna5 + '}';
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
    }
    
    public String mostrarCurso(int id){
        String cadena="";
        try {
            String query = "SELECT * FROM curso WHERE id=?";
            PreparedStatement sentencia= conexion.prepareStatement(query);
            sentencia.setInt(1, id);
            ResultSet resultSet = sentencia.executeQuery();
            while (resultSet.next()) {
                String columna1 = resultSet.getString("nombre");
                int columna2 = resultSet.getInt("id");
                int columna3 = resultSet.getInt("numEmpleado");
                cadena+= "Curso{" + "nombre= " + columna1 + ", id= " + columna2 + ", numEmpleados= " + columna3 + '}';
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cadena;
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
     
    public ArrayList<String> recorrerClientes() {
        ArrayList<String> empleados = new ArrayList<>();
        try {
            String consulta = "SELECT nombre FROM empleado";
            Statement sentencia = conexion.createStatement();
            ResultSet rs = sentencia.executeQuery(consulta);
            while (rs.next()) {
                empleados.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }
    
    public ArrayList idC() {
        String consulta = "SELECT id FROM curso";
        ArrayList<Integer> lista = new ArrayList<>();
        try {
            PreparedStatement sentencia = conexion.prepareStatement(consulta);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                lista.add(resultado.getInt(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}
