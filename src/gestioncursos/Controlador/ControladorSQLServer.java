/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncursos.Controlador;

import gestioncursos.Modelo.AccesoDAO;
import gestioncursos.Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Diurno
 */
public class ControladorSQLServer implements ActionListener, KeyListener{
    
    Vista ventana;
    AccesoDAO empDAO;

    public ControladorSQLServer(gestioncursos.Vista.Vista view, gestioncursos.Modelo.AccesoDAO modelo) {
        this.ventana = view;
        this.empDAO = modelo;
        añadirAcionListener(this);
    }
    
    private void añadirAcionListener(ActionListener lis) {
        ventana.btnBorrarCurso.addActionListener(lis);
        ventana.btnBorrarEmpleado.addActionListener(lis);
        ventana.btnEnviarCurso.addActionListener(lis);
        ventana.btnEnviarEmpleado.addActionListener(lis);
        ventana.btnMostrarCursos.addActionListener(lis);
        ventana.btnMostrarEmpleados.addActionListener(lis);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         String action= e.getActionCommand();
          switch (action) {
            case "Insertar Empleado":
                break;
            case "Insertar Curso":
                break;
            case "Borrar Empleado":
                break;
            case "Borrar Curso":
                break;
            case "Mostrar datos Empleados":
                break;
            case "Mostrar datos Cursos":
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void añadirKeyListener(KeyListener kl) {
    
    }
    
}


