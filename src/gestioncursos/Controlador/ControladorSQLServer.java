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
import java.util.ArrayList;

/**
 *
 * @author Diurno
 */
public class ControladorSQLServer implements ActionListener, KeyListener{
    
    Vista ventana;
    AccesoDAO modelo;

    public ControladorSQLServer(gestioncursos.Vista.Vista view, gestioncursos.Modelo.AccesoDAO modelo) {
        this.ventana = view;
        this.modelo = modelo;
        añadirAcionListener(this);
        cargaE();
        cargaC();
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
                modelo.instertarEmpleado(ventana.nombreE.getText(), ventana.apellidoE.getText(), 
                        Integer.valueOf(ventana.idE.getText()), Integer.valueOf(ventana.idCurso.getText()), Integer.valueOf(ventana.salarioE.getText()));
                break;
            case "Insertar Curso":
                modelo.instertarCurso(ventana.nombreE.getText(), Integer.valueOf(ventana.idC.getText()), 
                        Integer.valueOf(ventana.numC.getText()));
                break;
            case "Borrar Empleado":
                modelo.borrarEmpleado(Integer.valueOf(ventana.idBorrarE.getText()));
                break;
            case "Borrar Curso":
                modelo.borrarCurso(Integer.valueOf(ventana.idBorrarC.getText()));
                break;
            case "Mostrar datos Empleados":
                ventana.txtMostrar.setText(modelo.mostrarEmpleado(Integer.valueOf(ventana.cEmpleados.getSelectedItem().toString())));
                break;
            case "Mostrar datos Cursos":
                ventana.txtMostrar.setText(modelo.mostrarCurso(Integer.valueOf(ventana.cCurso.getSelectedItem().toString())));
                break;
            default:
                throw new AssertionError();
        }
    }
    
    public void cargaE() {
        ventana.cEmpleados.removeAllItems();
        ArrayList<String> empleados = modelo.recorrerClientes();
        for (String cliente : empleados) {
            ventana.cEmpleados.addItem(cliente);
        }
    }

    public void cargaC() {
        ventana.cCurso.removeAllItems();
        ArrayList<Integer> curso = modelo.idC();
        for (int id : curso) {
            ventana.cCurso.addItem(id + "");
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


