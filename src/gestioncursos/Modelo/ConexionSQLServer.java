/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncursos.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diurno
 */
public class ConexionSQLServer {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=GestionCursos";
    private static final String USUARIO = "C06PC27\\Diurno";
    private static final String CONTRASENA = "";
    Connection c;
    //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    public ConexionSQLServer() {
    }
    
    public Connection getConnection(){
        if(c==null){
            System.out.println("Conectado");
            try {
                c= DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            } catch (SQLException ex) {
                Logger.getLogger(ConexionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        return c;
    }
    
    public void desconectar(){
        try {
            c.close();
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionSQLServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
