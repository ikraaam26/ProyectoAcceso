/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestioncursos;

import gestioncursos.Modelo.ConexionSQLServer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 *
 * @author Diurno
 */
public class GestionCursos {

  /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionSQLServer con = new ConexionSQLServer();
        
        try (Connection c = con.getConnection()) {
            DatabaseMetaData informacion = c.getMetaData();
            String nombre = informacion.getDatabaseProductName();
            String driver = informacion.getDriverName();
            String url = informacion.getURL();
            String usuario = informacion.getUserName();
            
            System.out.println(nombre + " " + driver + " " + url + " " + usuario);
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }
}
