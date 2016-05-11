/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Interfaz;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Usuario
 */
public class Controlador_PROD extends Controlador{

    public Controlador_PROD(Interfaz vista) {
        super(vista);
    }
     public enum AccionMVC {
 //Panel Productos
        AnyadirProd,
        ModificarProd,
        ElminarProd,
        VerProd,
         //Diaolgo Productos
        ProdGuardar,
        ProdCerrar,
    }

    public void Iniciar() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vista);
            vista.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }
         //Añadimos la accion de los botones correspondientes al panel Productos
        this.vista.btnAniadeProductos.setActionCommand("AnyadirProd");
        this.vista.btnAniadeProductos.addActionListener(this);
        this.vista.btnModificarProductos.setActionCommand("ModificarProd");
        this.vista.btnModificarProductos.addActionListener(this);
        this.vista.btnEliminarProductos.setActionCommand("EliminarProd");
        this.vista.btnEliminarProductos.addActionListener(this);
        this.vista.btnVerProductos.setActionCommand("VerProd");
        this.vista.btnVerProductos.addActionListener(this);
         //Añadimos la accion de los botones correspondientes al dialogo AñadirProductos
        this.vista.btnGuardarProducto.setActionCommand("ProdGuardar");
        this.vista.btnGuardarProducto.addActionListener(this);
        this.vista.btnSalirProducto.setActionCommand("ProdCerrar");
        this.vista.btnSalirProducto.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_PROD.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
//Comienzo del control del panel Productos
            case AnyadirProd:
                this.vista.DiaAñadirPro.setSize(770, 650);
                int xpr = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirPro.getWidth() / 2);
                int ypr = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirPro.getHeight() / 2);
                this.vista.DiaAñadirPro.setLocation(xpr, ypr);
                this.vista.DiaAñadirPro.setVisible(true);
                break;
            case ModificarProd:
                this.mo_prod.Modificar();
                break;
            case ElminarProd:
                this.mo_prod.Eliminar();
                break;
            case VerProd:
                this.mo_prod.Buscar();
                break;
            //Cierre del control del panel Productos
                //Comienzo del control del dialogo Añadir Productos
            case ProdGuardar:
                this.mo_prod.Insertar();
                break;
            case ProdCerrar:
                this.vista.DiaAñadirPro.dispose();
                break;
            //Cierre del contrl del dialogo Añadir Productos
        }
    }
}
