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
public class Controlador_CLI extends Controlador {

    public Controlador_CLI(Interfaz vista) {
        super(vista);
    }

    public enum AccionMVC {

        //Panel Clientes

        AnyadirCli,
        ModificarCli,
        ElminarCli,
        VerCli,
        // Dialogo Añadir Cliente
        CliGuardar,
        CliCerrar,
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
        //Añadimos la accion de los botones correspondientes al panel Clientes
        this.vista.btnAniadeClientes.setActionCommand("AnyadirCli");
        this.vista.btnAniadeClientes.addActionListener(this);
        this.vista.btnModificaClientes.setActionCommand("ModificarCli");
        this.vista.btnModificaClientes.addActionListener(this);
        this.vista.btnEliminarClientes.setActionCommand("EliminarCli");
        this.vista.btnEliminarClientes.addActionListener(this);
        this.vista.btnVerClientes.setActionCommand("VerCli");
        this.vista.btnVerClientes.addActionListener(this);
        // Añadimos la accion de los botones correspondientes al dialogo añadirClientes
        this.vista.btnGuardarCliente.setActionCommand("CliGuardar");
        this.vista.btnGuardarCliente.addActionListener(this);
        this.vista.btnCancelarCliente.setActionCommand("CliCerrar");
        this.vista.btnCancelarCliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Controlador_CLI.AccionMVC.valueOf(e.getActionCommand())) {
            /**
             *
             */
            //Comienzo del control del panel del panel Clientes
            case AnyadirCli:
                this.vista.DiaAñadirCLi.setSize(900, 570);
                int xc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2 - this.vista.DiaAñadirCLi.getWidth() / 2);
                int yc = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2 - this.vista.DiaAñadirCLi.getHeight() / 2);
                this.vista.DiaAñadirCLi.setLocation(xc, yc);
                this.vista.DiaAñadirCLi.setVisible(true);
                break;
            case ModificarCli:
                this.mo_cl.Modificar();
                break;
            case ElminarCli:
                this.mo_cl.Eliminar();
                break;
            case VerCli:
                this.mo_cl.Buscar();
                break;
            //Cierre del control del panel Clientes
                //Comienzo del control del dialogo Añadir Cliente
            case CliGuardar:
                this.mo_cl.Insertar();
                break;
            case CliCerrar:
                this.vista.DiaAñadirCLi.dispose();
                break;
            //Cierre del control del dialogo Añadir Cliente

        }
    }

}
