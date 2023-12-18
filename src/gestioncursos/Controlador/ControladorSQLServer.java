/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncursos.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Diurno
 */
public class ControladorSQLServer implements ActionListener, KeyListener{
    
    gestioncursos.Vista.Vista view;
    gestioncursos.Modelo.AccesoDAO modelo;

    public ControladorSQLServer(gestioncursos.Vista.Vista view, gestioncursos.Modelo.AccesoDAO modelo) {
        this.view = view;
        this.modelo = modelo;
        añadirKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         /* String action= e.getActionCommand();
          switch (action) {
            case "Consultar":
                String localidad= view.txtLocalidad.getText();
                model.queryTable("departamentos");
                break;
            default:
                throw new AssertionError();
        }*/
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

    private void añadirAcionListener(ActionListener lis) {

    }

    private void añadirKeyListener(KeyListener kl) {
    
    }
    
}


