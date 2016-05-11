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
public class Controlador_PROV extends Controlador{

    public Controlador_PROV(Interfaz vista) {
        super(vista);
    }
     public enum AccionMVC {
 //Panel Proveedores
        AnyadirProv,
        ModificarProv,
        ElminarProv,
        VerProv,
         //Dialogo Proveedores
        ProvGuardar,
        ProvCerrar,
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
        //Añadimos la accion de los botones correspondientes al panel Proveedores
        this.vista.btnAniadeProveedores.setActionCommand("AnyadirProv");
        this.vista.btnAniadeProveedores.addActionListener(this);
        this.vista.btnModificaProveedores.setActionCommand("ModificarProv");
        this.vista.btnModificaProveedores.addActionListener(this);
        this.vista.btnEliminarProveedores.setActionCommand("EliminarProv");
        this.vista.btnEliminarProveedores.addActionListener(this);
        this.vista.btnVerProveedores.setActionCommand("VerProv");
        this.vista.btnVerProveedores.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo AñadirProveedores
        this.vista.btnGuardarProveedor.setActionCommand("ProvGuardar");
        this.vista.btnGuardarProveedor.addActionListener(this);
        this.vista.btnCancelarProveedor.setActionCommand("ProvCerrar");
        this.vista.btnCancelarProveedor.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_PROV.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
 //Comienzo del contol del panel Proveedores
            case AnyadirProv:
                this.vista.DiaAñadirProve.setSize(1177, 380);
                int xpro = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirProve.getWidth() / 2);
                int ypro = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirProve.getHeight() / 2);
                this.vista.DiaAñadirProve.setLocation(xpro, ypro);
                this.vista.DiaAñadirProve.setVisible(true);
                break;
            case ModificarProv:
                this.mo_prov.Modificar();
                break;
            case ElminarProv:
                this.mo_prov.Eliminar();
                break;
            case VerProv:
                this.mo_prov.Buscar();
                break;
            //Cierre del control del panel Proveedores
                 //Comienzo del control del dialogo Añadir Proveedores
            case ProvGuardar:
                this.mo_prov.Insertar();
                break;
            case ProvCerrar:
                this.vista.DiaAñadirProve.dispose();
                break;
            //Cierre del control del dialogo Añadir Proveedores
        }
    }
}
